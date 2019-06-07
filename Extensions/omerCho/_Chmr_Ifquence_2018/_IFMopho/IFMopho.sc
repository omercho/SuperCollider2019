/*
PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;

IFMopho.times(2);
IFMopho.p1_SC(1);
~octMopho=4;
IFMopho.makeOSCResponders;

~vMopho.noteOn(~chMopho, 26, 111); //But 1
~vMopho.noteOff(~chMopho, 26, 1); //But 1
IFMopho.lng(0,0.1,118,1);

*/
IFMopho {
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
		//~chMopho=1;
		~lateMopho=0.0;
		~timesMopho=1;
		~octMulMopho=0;
		~harmMopho=0;
		~rootMopho=0;
		~susMulMopho=1;
		~trMopho=0;
		~lfoMulMopho1=0.2;
		~lfoMulMopho2=0.2;
	}




	*proxy {
		~rootMopho = PatternProxy( Pseq([0], inf));
		~rootMophoP = Pseq([~rootMopho], inf).asStream;
		~nt1Mopho = PatternProxy( Pseq([0], inf));
		~nt1MophoP = Pseq([~nt1Mopho], inf).asStream;
		~dur1Mopho = PatternProxy( Pseq([1], inf));
		~dur1MophoP = Pseq([~dur1Mopho], inf).asStream;
		~durMulMopho = PatternProxy( Pseq([1], inf));
		~durMulMophoP = Pseq([~durMulMopho], inf).asStream;
		~amp1Mopho = PatternProxy( Pseq([0.9], inf));
		~amp1MophoP = Pseq([~amp1Mopho], inf).asStream;
		~sus1Mopho = PatternProxy( Pseq([1], inf));
		~sus1MophoP = Pseq([~sus1Mopho], inf).asStream;

		~transMopho = PatternProxy( Pseq([0], inf));
		~transMophoP = Pseq([~transMopho], inf).asStream;
		~transShufMopho = PatternProxy( Pseq([0], inf));
		~transShufMophoP = Pseq([~transShufMopho], inf).asStream;
		~transCntMopho = PatternProxy( Pseq([0], inf));
		~transCntMophoP = Pseq([~transCntMopho], inf).asStream;

		~octMopho = PatternProxy( Pseq([4], inf));
		~octMophoP = Pseq([~octMopho], inf).asStream;
		~legMopho = PatternProxy( Pseq([0.0], inf));
		~legMophoP = Pseq([~legMopho], inf).asStream;
		~hrmMopho = PatternProxy( Pseq([1.0], inf));
		~hrmMophoP = Pseq([~hrmMopho], inf).asStream;

		~delta1Mopho = PatternProxy( Pseq([1/1], inf));
		~delta1MophoP = Pseq([~delta1Mopho], inf).asStream;
		~delta2Mopho = PatternProxy( Pseq([1/1], inf));
		~delta2MophoP = Pseq([~delta2Mopho], inf).asStream;

		~lfo1Mopho = PatternProxy( Pseq([10], inf));
		~lfo1MophoP = Pseq([~lfo1Mopho], inf).asStream;
		~lfo2Mopho = PatternProxy( Pseq([58], inf));
		~lfo2MophoP = Pseq([~lfo2Mopho], inf).asStream;

		~actMopho = PatternProxy( Pseq([1], inf));
		~actMophoP= Pseq([~actMopho], inf).asStream;

		~volMopho = PatternProxy( Pseq([0.9], inf));
		~volMophoP = Pseq([~volMopho], inf).asStream;

		//lng
		~rootLngMopho = PatternProxy( Pseq([0], inf));
		~rootLngMophoP = Pseq([~rootLngMopho], inf).asStream;
		~nt1LngMopho = PatternProxy( Pseq([0], inf));
		~nt1LngMophoP = Pseq([~nt1LngMopho], inf).asStream;
		~dur1LngMopho = PatternProxy( Pseq([1], inf));
		~dur1LngMophoP = Pseq([~dur1LngMopho], inf).asStream;
		~amp1LngMopho = PatternProxy( Pseq([0.9], inf));
		~amp1LngMophoP = Pseq([~amp1LngMopho], inf).asStream;
		~sus1LngMopho = PatternProxy( Pseq([1], inf));
		~sus1LngMophoP = Pseq([~sus1LngMopho], inf).asStream;

		~transLngMopho = PatternProxy( Pseq([0], inf));
		~transLngMophoP = Pseq([~transLngMopho], inf).asStream;
		~transShufLngMopho = PatternProxy( Pseq([0], inf));
		~transShufLngMophoP = Pseq([~transShufLngMopho], inf).asStream;

	}

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{
				~lateMopho.wait;
				this.p1(val);
				((~dur1MophoP.next)*(~durMulMophoP.next)/val).wait;
			}}.fork;
		}
	}

	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\chan, ~chMopho,
			\type, \midi, \midiout,~vMopho, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur1MophoP.next],~actMophoP.next),
			\degree, Pseq([~nt1MophoP.next], inf),
			\amp, Pseq([~volMophoP.next*~amp1MophoP.next], inf),
			\sustain, Pseq([~sus1MophoP.next],inf)*~susMulMopho,
			\mtranspose, Pseq([~transMophoP.next], inf)+~transCntMophoP.next+~trMopho+~transShufMophoP.next,
			\ctranspose, Pseq([~rootMophoP.next],inf),
			\octave, Pseq([~octMophoP.next], inf)+~octMulMopho,
			\harmonic, Pseq([~hrmMophoP.next], inf)+~harmMopho
		).play(~clkMopho, quant: 0);

		//VMopho
		/*Pbind(//LFO CUT Mopho INT
			\midicmd, \control, \type, \midi,
			\midiout,~vMopho, \chan, ~chMopho, \ctlNum, 22,//Osc_1 Shape
			\delta, Pseq([~delta1MophoP.next], 1),
			\control, Pseq([~lfo1MophoP.value], 1)*~lfoMulMopho1,
		).play;
		Pbind(//LFO CUT Mopho RATE
			\midicmd, \control, \type, \midi,
			\midiout,~vMopho, \chan, ~chMopho, \ctlNum, 26,//Osc_1 Shape
			\delta, Pseq([~delta2MophoP.next], 1),
			\control, Pseq([~lfo2MophoP.value], 1)*~lfoMulMopho2,
		).play;*/

	}//p1
	*lng{|deg=0,amp=1,sus=4|
		Pbind(
			\chan, ~chMopho,
			\type, \midi, \midiout,~vMopho, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur1LngMophoP.next],1),
			\degree, Pseq([~nt1LngMophoP.next], inf)+deg,
			\amp, Pseq([~volMophoP.next*~amp1LngMophoP.next], inf)*amp,
			\sustain, Pseq([~sus1LngMophoP.next],inf)*sus,
			\mtranspose, Pseq([~transLngMophoP.next], inf)+~transCntMophoP.next+~transShufLngMophoP.next,
			\ctranspose, Pseq([~rootLngMophoP.next],inf),
			\octave, Pseq([~octMophoP.next], inf)+~octMulMopho,
			\harmonic, Pseq([~hrmMophoP.next], inf)+~harmMopho
		).play(~clkMopho, quant: 0);
	}

	*osc{

		~actMophoBut.free;
		~actMophoBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~actMopho.source=1;
				~apcMn.noteOn(~apcMnCh, ~actButA7, 127); //Trk4_But 1
			},{
				~actMopho.source=0;
				~apcMn.noteOff(~apcMnCh, ~actButA7, 127); //Trk4_But 1
			});
		},
		'/activMopho'
		);

		~time2MophoBut.free;
		~countTime2Mopho=0;
		~time2MophoBut= OSCFunc({
			arg msg;

			~countTime2Mopho = ~countTime2Mopho + 1;
			~countTime2Mopho.switch(
				0,{},
				1, {
					~apcMn.noteOn(~apcMnCh, ~actButB7, 1); //Trk4_But 2
					//~tOSCAdrr.sendMsg('time2Mopho', 1);
					//~tOSCAdrr.sendMsg('tmMophoLabel', 2);
					~tmMulMopho.source = Pseq([2], inf);
				},
				2,{

					//~tOSCAdrr.sendMsg('time2Mopho', 0);
					//~tOSCAdrr.sendMsg('tmMophoLabel', 1);
					~tmMulMopho.source = Pseq([1], inf);
					~apcMn.noteOn(~apcMnCh, ~actButB7, 0); //Trk4_But 2
					~countTime2Mopho=0;
				}
			);
		},
		'/time2Mopho'
		);

	}

	//      NEW OSC
	*set{|key,val|
		var vel, valNew;
		vel=val*127;
		key.switch(
			/*\timeM,{
				if ( val==1, {
					~apcMn.noteOn(~apcMnCh, ~actButA4, 1);
					~tmMulMopho.source = Pseq([2], inf);
				});
			},*/
			\octMDcr,{
				if ( val==1, {
					~crntMopho_octM=~crntMopho_octM-1;
					IFMopho.set1(\octM,~crntMopho_octM);
				});
			},
			\octMIcr,{
				if ( val==1, {
					~crntMopho_octM=~crntMopho_octM+1;
					IFMopho.set1(\octM,~crntMopho_octM);
				});
			},
			\octMZero,{
				if ( val==1, {
					IFMopho.set1(\octM,0);
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
				~crntMopho_vol=val1;
				this.lbl1(\volMopho,val1);
				~volMopho.source = val1;
				Mopho.cc(\voiVol, vel1);
				//~mdOut.control(5, 1, vel1);
			},
			\att, {
				~crntMopho_att=val1;
				this.lbl1(\IFattMopho,val1);
				Mopho.cc(\vcaEnvAtt,vel1);
				//~mdOut.control(5, 5, vel1);
			},
			\dec, {
				~crntMopho_dec=val1;
				this.lbl1(\IFdecMopho,val1);
				Mopho.cc(\vcaEnvDec,vel1);
				//~mdOut.control(5, 127, vel1);
			},
			\sus, {
				~crntMopho_sus=val1;
				this.lbl1(\IFsusMopho,val1);
				Mopho.cc(\vcaEnvSus,vel1);
				//~mdOut.control(5, 6, vel1);
			},
			\rls, {
				~crntMopho_rls=val1;
				this.lbl1(\IFrlsMopho,val1);
				Mopho.cc(\vcaEnvRls,vel1);
				//~mdOut.control(5, 8, vel1);
			},
			\pan, {
				~crntMopho_pan=val1;
				this.lbl1(\IFpanMopho,val1);
				Mopho.cc(\oscMix, vel1);
			},
			\octM, {
				~crntMopho_octM=val1;
				this.lbl1(\IFoctMMophoLbl,val1);
				~octMulMopho = val1;
			},
			\susM, {
				~crntMopho_susM=val1;
				this.lbl1(\IFsusMMopho,val1);
				~susMulMopho=val1;
			},
			\lfoM1, {
				~crntMopho_lfoM1=val1;
				this.lbl1(\IFlfoM1Mopho,val1);
				//~lfoMulMopho1=val1;
				Mopho.cc(\osc1Sub, vel1);
			},
			\lfoM2, {
				~crntMopho_lfoM2=val1;
				this.lbl1(\IFlfoM2Mopho,val1);
				//~lfoMulMopho2=val1;
				Mopho.cc(\osc2Sub, vel1);
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
				this.lbl2(\sendMopho,val1,val2);
				~mdOut.control(8, 4, vel1); // IFMopho
				~mdOut.control(8, 3, vel2); // IFMopho
				~crntMopho_sndY=val1;
				~crntMopho_sndX=val2;
			},
			\xy1, {
				this.lbl2(\xy1Mopho,val1,val2);
				//Mopho.cc(\osc1Glide,vel2);
				//Mopho.cc(\osc2Glide,vel1);
				Mopho.cc(\lpfFreq, vel2);
				Mopho.cc(\lpfRes, vel1);
				~crntMopho_xy1X=val2;
				~crntMopho_xy1Y=val1;
			},
			\xy2, {
				this.lbl2(\xy2Mopho,val1,val2);
				Mopho.cc(\lpfEnvAtt, vel2);
				Mopho.cc(\lpfEnvDec, vel1);
				~crntMopho_xy2X=val2;
				~crntMopho_xy2Y=val1;
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
				'octMDcrMopho_T', { this.set(\octMDcr,val);},
				'octMIcrMopho_T', { this.set(\octMIcr,val);},
				'octMZeroMopho_T', { this.set(\octMZero,val);},
				//-GlobalSettings
				'volMopho_T' , { this.set1(\vol,val1);},
				'attMopho_T' , { this.set1(\att,val1);},
				'decMopho_T' , { this.set1(\dec,val1);},
				'susMopho_T' , { this.set1(\sus,val1);},
				'rlsMopho_T' , { this.set1(\rls,val1);},
				'panMopho_T' , { this.set1(\pan,val1);},
				'sendMopho_T', { this.set2(\send,val1,val2);},
				'susMMopho_T', { this.set1(\susM,val1);},
				'octMMopho_T', { this.set1(\octM,val1);},
				'xy1Mopho_T' , { this.set2(\xy1,val1,val2);},
				'xy2Mopho_T' , { this.set2(\xy2,val1,val2);},
				'lfoM1Mopho_T',{ this.set1(\lfoM1,val1);},
				'lfoM2Mopho_T',{ this.set1(\lfoM2,val1);},
			);
		},path:oscName);
	}
	*makeOSCResponders{
		this.oscResp(respName:\octMDcrMophoResp, oscName:\IFoctMDcrMopho, playTag:'octMDcrMopho_T');
		this.oscResp(respName:\octMIcrMophoResp, oscName:\IFoctMIcrMopho, playTag:'octMIcrMopho_T');
		this.oscResp(respName:\octMZeroMophoResp, oscName:\IFoctMZeroMopho, playTag:'octMZeroMopho_T');
		//-GlobalSettings
		this.oscResp(respName:\volMophoResp, oscName:\IFvolMopho, playTag:'volMopho_T');
		this.oscResp(respName:\attMophoResp, oscName:\IFattMopho, playTag:'attMopho_T');
		this.oscResp(respName:\decMophoResp, oscName:\IFdecMopho, playTag:'decMopho_T');
		this.oscResp(respName:\susMophoResp, oscName:\IFsusMopho, playTag:'susMopho_T');
		this.oscResp(respName:\rlsMophoResp, oscName:\IFrlsMopho, playTag:'rlsMopho_T');
		this.oscResp(respName:\panMophoResp, oscName:\IFpanMopho, playTag:'panMopho_T');
		this.oscResp(respName:\sendMophoResp, oscName:\IFsendMopho, playTag:'sendMopho_T');
		this.oscResp(respName:\susMMophoResp, oscName:\IFsusMMopho, playTag:'susMMopho_T');
		this.oscResp(respName:\octMMophoResp, oscName:\IFoctMMopho, playTag:'octMMopho_T');
		this.oscResp(respName:\xy1MophoResp,  oscName:\IFxy1Mopho, playTag:'xy1Mopho_T');
		this.oscResp(respName:\xy2MophoResp, oscName:\IFxy2Mopho, playTag:'xy2Mopho_T');
		this.oscResp(respName:\lfoM1MophoResp, oscName:\IFlfoM1Mopho, playTag:'lfoM1Mopho_T');
		this.oscResp(respName:\lfoM2MophoResp, oscName:\IFlfoM2Mopho, playTag:'lfoM2Mopho_T');
	}


}
/*

*octave{|val|
		~octMopho.source = Pseq([val], inf);
	}
	*octMul{|val|
		~octMulMopho = val;
		~tOSCAdrr.sendMsg('octMophoLabel', val);
	}


IFMopho.set2(\send,0,0);

~vMopho.noteOn(~chMopho, 26, 111); //But 1
~vMopho.noteOff(~chMopho, 26, 1); //But 1

~vMopho.control(~chMopho, 20, 48); //Osc_1 Freq
~vMopho.control(~chMopho, 21, 50); //Osc_1 Fine Tune
~vMopho.control(~chMopho, 22, 3); //Osc_1 Shape
~vMopho.control(~chMopho, 23, 13); //Osc_1 Glide

~vMopho.control(~chMopho, 24, 60); //Osc_2 Freq
~vMopho.control(~chMopho, 25, 57); //Osc_2 Fine Tune
~vMopho.control(~chMopho, 26, 58); //Osc_2 Shape
~vMopho.control(~chMopho, 27, 113); //Osc_2 Glide

~vMopho.control(~chMopho, 28, 64); //Osc Mix

~vMopho.control(~chMopho, 30, 0); //Sub Osc_1
~vMopho.control(~chMopho, 31, 120); //Sub Osc_2

~vMopho.control(~chMopho, 102, 110); //Filter Freq CutOff
~vMopho.control(~chMopho, 103, 17); //Filter Resonans
~vMopho.control(~chMopho, 104, 17); //Filter Key Amnt
~vMopho.control(~chMopho, 105, 7); //Filter Audio Mod
~vMopho.control(~chMopho, 106, 0); //Filter Env Amnt
~vMopho.control(~chMopho, 107, 127); //Filter Env Vel Amnt
~vMopho.control(~chMopho, 108, 0); //Filter Dly
~vMopho.control(~chMopho, 109, 1); //Filter Att
~vMopho.control(~chMopho, 110, 10); //Filter Dec
~vMopho.control(~chMopho, 111, 20); //Filter Sus
~vMopho.control(~chMopho, 112, 17); //Filter Rel

~vMopho.control(~chMopho, 113, 0); //VCA Lvl
~vMopho.control(~chMopho, 115, 127); //Amp Env Amnt
~vMopho.control(~chMopho, 116, 127); //Amp Env Vel Amnt
~vMopho.control(~chMopho, 117, 0); //Amp Dly
~vMopho.control(~chMopho, 118, 1); //Amp Att
~vMopho.control(~chMopho, 119, 37); //Amp Dec
~vMopho.control(~chMopho, 75, 45); //Amp Sus
~vMopho.control(~chMopho, 76, 10); //Amp Rel

~vMopho.control(~chMopho, 85, 7); //Env3 Dest
~vMopho.control(~chMopho, 86, 7); //Env3 Amnt
~vMopho.control(~chMopho, 87, 7); //Env3 Vel Amnt
~vMopho.control(~chMopho, 88, 7); //Env3 Dly
~vMopho.control(~chMopho, 89, 7); //Env3 Att
~vMopho.control(~chMopho, 90, 7); //Env3 Dec
~vMopho.control(~chMopho, 77, 7); //Env3 Sus
~vMopho.control(~chMopho, 78, 7); //Env3 Rel

~vMopho.control(~chMopho, 29, 0); //Noise Lev
~vMopho.control(~chMopho, 14, 123); //BPM
~vMopho.control(~chMopho, 15, 0); //Clock Divide

//MOPHO SEND NRPN
//NRPN control of filter pole on DSI Tetra:
//   first, set parameter number (24 in this case)
//   set most significant byte for parameter number (0 in this case)
~vMopho.control(~chMopho, 99, 0);
//   then least significant byte for parameter number (24 in this case)
~vMopho.control(~chMopho, 98, 24);
// then set value (1 for 4 pole)
//   first set most significant byte for this value (0 in this case)
~vMopho.control(~chMopho, 6, 0);
//   then least significant byte for parameter number (1 in this case)
~vMopho.control(~chMopho,38, 1);

*/