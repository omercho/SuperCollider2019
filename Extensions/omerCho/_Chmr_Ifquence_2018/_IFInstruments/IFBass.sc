/*
PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;

IFBass.times(2);
IFBass.p1_SC(1);
~octBass=4;

IFBass.lng(0,1,127,1);
IFMopho.lng(0,0.1,118,0.7);
*/
IFBass {
	var <>keyTime = 1;
	classvar <>counter3 = 0;
	/**initClass {
	StartUp add: {
	/*Server.default.doWhenBooted({
	this.load;
	});*/
	}
	}*/
	*load {
		this.globals;
		this.proxy;
		this.osc;
		this.makeOSCResponders;
	}
	*globals{
		~chVBass=0;
		~chBass=3;
		~bassLate=0.0;
		~timesBass=1;
		~octMulBass=0;
		~harmBass=0;
		~rootBass=0;
		~susMulBass=1;
		~trBass=0;
		~lfoMulBass1=0.2;
		~lfoMulBass2=0.2;
	}

	*proxy {
		~rootBass = PatternProxy( Pseq([0], inf));
		~rootBassP = Pseq([~rootBass], inf).asStream;
		~nt1Bass = PatternProxy( Pseq([0], inf));
		~nt1BassP = Pseq([~nt1Bass], inf).asStream;
		~dur1Bass = PatternProxy( Pseq([1], inf));
		~dur1BassP = Pseq([~dur1Bass], inf).asStream;
		~amp1Bass = PatternProxy( Pseq([0.9], inf));
		~amp1BassP = Pseq([~amp1Bass], inf).asStream;
		~sus1Bass = PatternProxy( Pseq([1], inf));
		~sus1BassP = Pseq([~sus1Bass], inf).asStream;

		~transBass = PatternProxy( Pseq([0], inf));
		~transBassP = Pseq([~transBass], inf).asStream;
		~transShufBass = PatternProxy( Pseq([0], inf));
		~transShufBassP = Pseq([~transShufBass], inf).asStream;
		~transCntBass = PatternProxy( Pseq([0], inf));
		~transCntBassP = Pseq([~transCntBass], inf).asStream;


		~octBass = PatternProxy( Pseq([4], inf));
		~octBassP = Pseq([~octBass], inf).asStream;
		~legBass = PatternProxy( Pseq([0.0], inf));
		~legBassP = Pseq([~legBass], inf).asStream;
		~hrmBass = PatternProxy( Pseq([1.0], inf));
		~hrmBassP = Pseq([~hrmBass], inf).asStream;

		~delta1Bass = PatternProxy( Pseq([1/1], inf));
		~delta1BassP = Pseq([~delta1Bass], inf).asStream;
		~delta2Bass = PatternProxy( Pseq([1/1], inf));
		~delta2BassP = Pseq([~delta2Bass], inf).asStream;

		~lfo1Bass = PatternProxy( Pseq([10], inf));
		~lfo1BassP = Pseq([~lfo1Bass], inf).asStream;
		~lfo2Bass = PatternProxy( Pseq([10], inf));
		~lfo2BassP = Pseq([~lfo2Bass], inf).asStream;

		~actBass = PatternProxy( Pseq([1], inf));
		~actBassP= Pseq([~actBass], inf).asStream;

		~volBass = PatternProxy( Pseq([0.9], inf));
		~volBassP = Pseq([~volBass], inf).asStream;

		//lng
		~rootLngBass = PatternProxy( Pseq([0], inf));
		~rootLngBassP = Pseq([~rootLngBass], inf).asStream;
		~nt1LngBass = PatternProxy( Pseq([0], inf));
		~nt1LngBassP = Pseq([~nt1LngBass], inf).asStream;
		~dur1LngBass = PatternProxy( Pseq([0.25], inf));
		~dur1LngBassP = Pseq([~dur1LngBass], inf).asStream;
		~amp1LngBass = PatternProxy( Pseq([0.9], inf));
		~amp1LngBassP = Pseq([~amp1LngBass], inf).asStream;
		~sus1LngBass = PatternProxy( Pseq([1], inf));
		~sus1LngBassP = Pseq([~sus1LngBass], inf).asStream;

		~transLngBass = PatternProxy( Pseq([0], inf));
		~transLngBassP = Pseq([~transLngBass], inf).asStream;
		~transShufLngBass = PatternProxy( Pseq([0], inf));
		~transShufLngBassP = Pseq([~transShufLngBass], inf).asStream;
	}
	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{
				~bassLate.wait;
				//this.p1_SC(val);
				this.p1(val);
				//this.p1(val);
				((~dur1BassP.next)*(~durMul3P.next)/val).wait;
			}}.fork;
		}
	}
	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\chan, ~chBass,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur1BassP.next],~actBassP.next),
			\degree, Pseq([~nt1BassP.next], inf),
			\amp, Pseq([~volBassP.next*~amp1BassP.next], inf),
			\sustain, Pseq([~sus1BassP.next],inf)*~susMulBass,
			\mtranspose, Pseq([~transBassP.next], inf)+~transShufBassP.next+~transCntBassP.next+~trBass,
			\ctranspose, Pseq([~rootBassP.next],inf),
			\octave, Pseq([~octBassP.next], inf)+~octMulBass,
			\harmonic, Pseq([~hrmBassP.next], inf)+~harmBass
		).play(~clkBass, quant: 0);

		Pbind(//LFO CUT BASS INT
			\midicmd, \control, \type, \midi,
			\midiout,~vBass, \chan, ~chVBass, \ctlNum, ~envDecVB,
			\delta, Pseq([~delta1BassP.next], 1),
			\control, Pseq([~lfo1BassP.value], 1)*~lfoMulBass1,
		).play(~clkBass, quant: 0);
		Pbind(//LFO CUT BASS RATE
			\midicmd, \control, \type, \midi,
			\midiout,~vBass, \chan, ~chVBass, \ctlNum, ~slideTm,
			\delta, Pseq([~delta2BassP.next], 1),
			\control, Pseq([~lfo2BassP.value], 1)*~lfoMulBass2,
		).play(~clkBass, quant: 0);

	}//p1

	*lng{|deg=0,amp=1,sus=4|
		Pbind(
			\chan, ~chVBass,
			\type, \midi, \midiout,~vBass, \scale, Pfunc({~scl2},inf),
			\dur, Pseq([~dur1LngBassP.next],1)+sus,
			\ctranspose, Pseq([~rootLngBassP.next],inf),
			\degree, Pseq([~nt1LngBassP.next],inf)+deg,
			\amp, Pseq([~volBassP.next*~amp1LngBassP.next],inf)+amp,
			\sustain, Pseq([~sus1LngBassP.next],inf)+sus,
			\mtranspose, Pseq([~transLngBassP.next],inf)+~transShufLngBassP.next+~transCntBassP.next,
			\octave, Pseq([~octBassP.next],inf)+~octMulBass,
			\harmonic, Pseq([~hrmBassP.next],inf)+~harmBass
		).play(~clkBass, quant: 0);
	}//lng

	*osc{
		~actBassBut.free;
		~actBassBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~actBass.source=1;
				~apcMn.noteOn(~apcMnCh, ~actButA4, 127); //Trk4_But 1
			},{
				~actBass.source=0;
				~apcMn.noteOff(~apcMnCh, ~actButA4, 127); //Trk4_But 1
			});
		},'/activBass');

		~time2BassBut.free;
		~countTime2Bass=0;
		~time2BassBut= OSCFunc({
			arg msg;
			~countTime2Bass = ~countTime2Bass + 1;
			~countTime2Bass.switch(
				1, {
					~apcMn.noteOn(~apcMnCh, ~actButB4, 1); //Trk4_But 2
					~tmMulBass.source = Pseq([2], inf);
				},
				2,{
					~tmMulBass.source = Pseq([1], inf);
					~apcMn.noteOn(~apcMnCh, ~actButB4, 0); //Trk4_But 2
					~countTime2Bass=0;
				}
			);
		},'/time2Bass');

	}
	/*
	*octave{|val|
		~octBass.source = Pseq([val], inf);
	}
	*octMul{|val|
		~octMulBass = val;
		~tOSCAdrr.sendMsg('octBassLabel', val);
	}
	IFBass.octMul(1);
	IFBass.set1(\octM,2);
	IFBass.set1(\vol,0.2);
	IFBass.set1(\att,0.5);
	IFBass.lbl1(\IFattBass,0.2);
	VBass.cc(\envAttVB,0.5);
	~mdOut.control(5, 5, 0.8*127);
	~vBass.control(0, ~envAttVB, 0.1);
	~local.sendMsg('IFattBass',0.1);
	IFBass.set(\decBass,0.2);
	~local.sendMsg('IFdecBass',0.1);
	IFBass.set1(\sus,0.2);
	IFBass.set1(\rls,0.2);

	IFBass.oscResp(respName:\attBassResp, oscName:\IFattBass, playTag:'attBass_T');
	*/
	//      NEW OSC
	*set{|key,val|
		var vel, valNew;
		vel=val*127;
		key.switch(
			/*\timeM,{
				if ( val==1, {
					~apcMn.noteOn(~apcMnCh, ~actButA4, 1);
					~tmMulBass.source = Pseq([2], inf);
				});
			},*/
			\octMDcr,{
				if ( val==1, {
					~crntBass_octM=~crntBass_octM-1;
					IFBass.set1(\octM,~crntBass_octM);
				});
			},
			\octMIcr,{
				if ( val==1, {
					~crntBass_octM=~crntBass_octM+1;
					IFBass.set1(\octM,~crntBass_octM);
				});
			},
			\octMZero,{
				if ( val==1, {
					IFBass.set1(\octM,0);
				});
			},
		);
	}
	*lbl1{|key,val1=0|
		~tOSCAdrr.sendMsg(key,val1);
	}
	*set1{|key,val1=0|
		var vel1;
		vel1=val1*127;
		key.switch(
			\vol, {
				~crntBass_vol=val1;
				this.lbl1(\volBass,val1);
				~volBass.source = val1;
				VBass.cc(\expresVB,vel1);
				~mdOut.control(5, 1, vel1);
			},
			\att, {
				~crntBass_att=val1;
				this.lbl1(\IFattBass,val1);
				VBass.cc(\envAttVB,vel1);
				~mdOut.control(5, 5, vel1);
			},
			\dec, {
				~crntBass_dec=val1;
				this.lbl1(\IFdecBass,val1);
				VBass.cc(\envDecVB,vel1);
				~mdOut.control(5, 127, vel1);
			},
			\sus, {
				~crntBass_sus=val1;
				this.lbl1(\IFsusBass,val1);
				VBass.cc(\slideTmVB,vel1);
				~mdOut.control(5, 6, vel1);
			},
			\rls, {
				~crntBass_rls=val1;
				this.lbl1(\IFrlsBass,val1);
				VBass.cc(\gateTmVB,vel1);
				~mdOut.control(5, 8, vel1);
			},
			\pan, {
				~crntBass_pan=val1;
				this.lbl1(\IFpanBass,val1);
				//~mdOut.control(5, 8, vel1);
			},
			\octM, {
				~crntBass_octM=val1;
				this.lbl1(\IFoctMBassLbl,val1);
				~octMulBass = val1;
			},
			\susM, {
				~crntBass_susM=val1;
				this.lbl1(\IFsusMBass,val1);
				~susMulBass=val1;
			},
			\lfoM1, {
				~crntBass_lfoM1=val1;
				this.lbl1(\IFlfoM1Bass,val1);
				~lfoMulBass1=val1;
			},
			\lfoM2, {
				~crntBass_lfoM2=val1;
				this.lbl1(\IFlfoM2Bass,val1);
				~lfoMulBass2=val1;
			},
		);
	}
	*lbl2{|key, val1=0, val2=0|
		var chan;
		~tOSCAdrr.sendMsg(key,val1,val2);
	}
	*set2{|key, val1=0, val2=0|
		var vel1,vel2;
		vel1=val1*127;
		vel2=val2*127;
		key.switch(
			\send, {
				this.lbl2(\sendBass,val1,val2);
				~mdOut.control(5, 4, vel1); // IFBass
				~mdOut.control(5, 3, vel2); // IFBass
				~crntBass_sndY=val1;
				~crntBass_sndX=val2;
			},
			\xy1, {
				this.lbl2(\xy1Bass,val1,val2);
				VBass.cc(\lfoRateVB,vel2);
				VBass.cc(\lfoIntVB,vel1);
				~crntBass_xy1X=val2;
				~crntBass_xy1Y=val1;
			},
			\xy2, {
				this.lbl2(\xy2Bass,val1,val2);
				VBass.cc(\vco2VB,vel2);
				VBass.cc(\vco3VB,vel1);
				~crntBass_xy2X=val2;
				~crntBass_xy2Y=val1;
			},

		);
	}
	*oscResp{|respName,oscName,playTag|
		OSCdef(respName, {|msg|
			var val, val1,val2;
			val= msg[1];
			val1= msg[1];
			val2= msg[2];
			playTag.switch(
				'octMDcrBass_T', { this.set(\octMDcr,val);},
				'octMIcrBass_T', { this.set(\octMIcr,val);},
				'octMZeroBass_T', { this.set(\octMZero,val);},
				//-GlobalSettings
				'volBass_T' , { this.set1(\vol,val1);},
				'attBass_T' , { this.set1(\att,val1);},
				'decBass_T' , { this.set1(\dec,val1);},
				'susBass_T' , { this.set1(\sus,val1);},
				'rlsBass_T' , { this.set1(\rls,val1);},
				'panBass_T' , { this.set1(\pan,val1);},
				'sendBass_T', { this.set2(\send,val1,val2);},
				'susMBass_T', { this.set1(\susM,val1);},
				'octMBass_T', { this.set1(\octM,val1);},
				'xy1Bass_T' , { this.set2(\xy1,val1,val2);},
				'xy2Bass_T' , { this.set2(\xy2,val1,val2);},
				'lfoM1Bass_T',{ this.set1(\lfoM1,val1);},
				'lfoM2Bass_T',{ this.set1(\lfoM2,val1);},
			);
		},path:oscName);
	}
	*makeOSCResponders{
		this.oscResp(respName:\octMDcrBassResp, oscName:\IFoctMDcrBass, playTag:'octMDcrBass_T');
		this.oscResp(respName:\octMIcrBassResp, oscName:\IFoctMIcrBass, playTag:'octMIcrBass_T');
		this.oscResp(respName:\octMZeroBassResp, oscName:\IFoctMZeroBass, playTag:'octMZeroBass_T');
		//-GlobalSettings
		this.oscResp(respName:\volBassResp, oscName:\IFvolBass, playTag:'volBass_T');
		this.oscResp(respName:\attBassResp, oscName:\IFattBass, playTag:'attBass_T');
		this.oscResp(respName:\decBassResp, oscName:\IFdecBass, playTag:'decBass_T');
		this.oscResp(respName:\susBassResp, oscName:\IFsusBass, playTag:'susBass_T');
		this.oscResp(respName:\rlsBassResp, oscName:\IFrlsBass, playTag:'rlsBass_T');
		this.oscResp(respName:\panBassResp, oscName:\IFpanBass, playTag:'panBass_T');
		this.oscResp(respName:\sendBassResp, oscName:\IFsendBass, playTag:'sendBass_T');
		this.oscResp(respName:\susMBassResp, oscName:\IFsusMBass, playTag:'susMBass_T');
		this.oscResp(respName:\octMBassResp, oscName:\IFoctMBass, playTag:'octMBass_T');
		this.oscResp(respName:\xy1BassResp,  oscName:\IFxy1Bass, playTag:'xy1Bass_T');
		this.oscResp(respName:\xy2BassResp, oscName:\IFxy2Bass, playTag:'xy2Bass_T');
		this.oscResp(respName:\lfoM1BassResp, oscName:\IFlfoM1Bass, playTag:'lfoM1Bass_T');
		this.oscResp(respName:\lfoM2BassResp, oscName:\IFlfoM2Bass, playTag:'lfoM2Bass_T');
	}

}