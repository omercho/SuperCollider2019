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
	*octave{|val|
		~octBass.source = Pseq([val], inf);
	}
	*octMul{|val|
		~octMulBass = val;
		~tOSCAdrr.sendMsg('octBassLabel', val);
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
				((~dur1BassP.next)*(~durMulP.next)/val).wait;
			}}.fork;
		}
	}
	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\chan, ~chVBass,
			\type, \midi, \midiout,~vBass, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur1BassP.next],~actBassP.next),
			\degree, Pseq([~nt1BassP.next], inf),
			\amp, Pseq([~volBassP.next*~amp1BassP.next], inf),
			\sustain, Pseq([~sus1BassP.next],inf)*~susMulBass,
			\mtranspose, Pseq([~transBassP.next], inf)+~transCntBassP.next+~trBass+~transShufBassP.next,
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
				0,{},
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
		~xy1Bass.free;
		~xy1Bass= OSCFunc({
			arg msg,val1,val2,vel,vel1,vel2;
			val1=msg[1];
			val2=msg[2];
			vel=msg[1]*127;
			vel1=msg[1]*127;
			vel2=msg[2]*127;
			VBass.cc(\vco2VB,vel2);
			VBass.cc(\vco3VB,vel1);
			//~mdOut.control(5, 11, vel2);
			//~mdOut.control(5, 12, vel1);
			~tOSCAdrr.sendMsg('xy1Bass', msg[1], msg[2]);
		},'/xy1Bass');
		~susMulBassFader.free;
		~susMulBassFader= OSCFunc({
			arg msg, val,vel;
			val=msg[1];
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('susMulBass', val);
			~susMulBass=val;
		},'/susMulBass');
		~sendBassFader.free;
		~sendBassFader= OSCFunc({
			arg msg,vel1,vel2;
			vel1=msg[1]*127;
			vel2=msg[2]*127;
			~tOSCAdrr.sendMsg('sendBass', msg[1], msg[2]);
			VBass.cc(\lfoRateVB,vel2);
			VBass.cc(\lfoIntVB,vel1);
			//~mdOut.control(5, 4, vel1); // IFBass
			//~mdOut.control(5, 3, vel2); // IFBass
		},'/sendBass');
		~lfoMulBassFad1.free;
		~lfoMulBassFad1= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('lfoMulBass1', msg[1]);
			~lfoMulBass1=msg[1];
		},'/lfoMulBass1');
		~lfoMulBassFad2.free;
		~lfoMulBassFad2= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('lfoMulBass2', msg[1]);
			~lfoMulBass2=msg[1];
		},'/lfoMulBass2');

		/*~volBassFader.free;
		~volBassFader= OSCFunc({
		arg msg,vel,val;
		val=msg[1];
		vel=msg[1]*127;
		~tOSCAdrr.sendMsg('volBass', val);
		VBass.cc(\expresVB,vel);
		~mdOut.control(5, 1, vel);
		~volBass.source = val;
		},
		'/volBass'
		);

		~attBassFader.free;
		~attBassFader= OSCFunc({
		arg msg,vel,val;
		vel=msg[1]*127;
		val=msg[1];
		VBass.cc(\envAttVB,vel+0.01);
		~tOSCAdrr.sendMsg('attBass', val);
		//~mdOut.control(5, 5, vel);
		},
		'/attBass'
		);

		~susBassFader.free;
		~susBassFader= OSCFunc({
		arg msg,val,vel;
		val=msg[1];
		vel=msg[1]*127;
		~tOSCAdrr.sendMsg('susBass', msg[1]);
		VBass.cc(\slideTmVB,vel);
		//~mdOut.control(5, 6, vel);
		},
		'/susBass'
		);

		~decBassFader.free;
		~decBassFader= OSCFunc({
		arg msg,val,vel;
		val=msg[1];
		vel=msg[1]*127;
		~tOSCAdrr.sendMsg('decBass', val);
		VBass.cc(\envDecVB,vel);
		//~mdOut.control(5, 127, vel);
		},
		'/decBass'
		);
		~rlsBassFader.free;
		~rlsBassFader= OSCFunc({
		arg msg,val,vel;
		val=msg[1];
		vel=msg[1]*127;
		~tOSCAdrr.sendMsg('decBass', val);
		VBass.cc(\gateTmVB,vel);
		//~mdOut.control(5, 127, vel);
		},
		'/rlsBass'
		);*/

		//TIME
		~tmMulBassBut1.free;
		~tmMulBassBut1= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~tmMulBass.source = Pseq([1], inf);
				~tOSCAdrr.sendMsg('tmBassLabel', 1);
			});
		},
		'/tmMulBass1'
		);
		~tmMulBassBut2.free;
		~tmMulBassBut2= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~tmMulBass.source = Pseq([2], inf);
				~tOSCAdrr.sendMsg('tmBassLabel', 2);
			});
		},
		'/tmMulBass2'
		);
		~tmMulBassBut3.free;
		~tmMulBassBut3= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~tmMulBass.source = Pseq([3], inf);
				~tOSCAdrr.sendMsg('tmBassLabel', 3);
			});
		},
		'/tmMulBass3'
		);
		~tmBassFader.free;
		~tmBassFader= OSCFunc({
			arg msg;
			~tmBass.source = msg[1];
		},
		'/timesBass'
		);
		~padBass.free;
		~padBass = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFBass(~tmBassP.next);
			});
		},
		'/padBass'
		);
		//----Bass-------
		~octBassMulBut.free;
		~octBassMulBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~octMulBass = ~octMulBass+1;
				~tOSCAdrr.sendMsg('octBassLabel', ~octMulBass);
			});
		},
		'/octBassMul'
		);
		~octBassZeroBut.free;
		~octBassZeroBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~octMulBass = 0;
				~tOSCAdrr.sendMsg('octBassLabel', ~octMulBass);
			});
		},
		'/octBassZero'
		);
		~octBassDivBut.free;
		~octBassDivBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~octMulBass = ~octMulBass-1;
				~tOSCAdrr.sendMsg('octBassLabel', ~octMulBass);
			});
		},
		'/octBassDiv'
		);
	}
	//      NEW OSC
	*lbl{|key,val|
		var chan;
		~tOSCAdrr.sendMsg(key, val);
	}
	/*
	IFBass.set(\volBass,0.2);
	IFBass.set(\attBass,0.5);
	IFBass.lbl(\attBass,0.5);
	VBass.cc(\envAttVB,0.5);
	~vBass.control(0, ~envAttVB, 0.1);
	~local.sendMsg('IFattBass',0.1);
	IFBass.set(\decBass,0.2);
	~local.sendMsg('decBass',0.1);
	IFBass.set(\susBass,0.2);
	IFBass.set(\rlsBass,0.2);
	*/
	*set{|key,val|
		var vel;
		vel=val*127;
		key.switch(
			\vol, {
				this.lbl(\volBass,val);
				VBass.cc(\expresVB,vel);
				~mdOut.control(5, 1, vel);
				~volBass.source = val;
			},
			\att, {
				this.lbl(\IFattBass,val);
				VBass.cc(\envAttVB,vel);
				~mdOut.control(5, 5, vel);
			},
			\dec, {
				this.lbl(\decBass,val);
				VBass.cc(\envDecVB,vel);
				~mdOut.control(5, 127, vel);
			},
			\sus, {
				this.lbl(\susBass,val);
				VBass.cc(\slideTmVB,vel);
				~mdOut.control(5, 6, vel);
			},
			\rls, {
				this.lbl(\rlsBass,val);
				VBass.cc(\gateTmVB,vel);
				//~mdOut.control(5, 127, vel);
			},

		);
	}
	*oscResp{|respName,oscName,playTag|
		var currentBpm=1;
		OSCdef(respName, {|msg|
			var val,vel;
			val=msg[1];
			vel=val*127;
			playTag.switch(
				'volBass_T',{ this.set(\vol,val);},
				'attBass_T',{ this.set(\att,val);},
				'decBass_T',{ this.set(\dec,val);},
				'susBass_T',{ this.set(\sus,val);},
				'rlsBass_T',{ this.set(\rls,val);}
			)
		},path:oscName);
	}
	*makeOSCResponders{
		this.oscResp(respName:\volBassResp, oscName:\volBass, playTag:'volBass_T');
		this.oscResp(respName:\attBassResp, oscName:\IFattBass, playTag:'attBass_T');
		this.oscResp(respName:\decBassResp, oscName:\decBass, playTag:'decBass_T');
		this.oscResp(respName:\susBassResp, oscName:\susBass, playTag:'susBass_T');
		this.oscResp(respName:\rlsBassResp, oscName:\rlsBass, playTag:'rlsBass_T');

	}

}