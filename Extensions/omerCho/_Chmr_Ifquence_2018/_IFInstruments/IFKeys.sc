/*
PostAllMIDI.on;
PostAllMIDI.off;

IFKeys.makeOSCResponders;
IFKeys(3);
*/
IFKeys {
	var <>keyTime = 1;
	classvar <>counter3 = 0;
	/**initClass{
	StartUp add: {
	/*Server.default.doWhenBooted({ this.globals; this.preSet; this.default;this.osc; });*/
	}
	}*/
	*load{
		this.globals;
		this.proxy;
		this.osc;
		this.makeOSCResponders;
	}
	*globals{
		~chVKeys=0;
		~chKeys=4;
		~lateKeys= 0.0;
		~timesKeys=1;
		~octMulKeys=0;
		~rootKeys=0;
		~harmKeys=0;
		~susMulKeys=1;
		~trKeys=0;
		~lfoMulKeys1=0.2;
		~lfoMulKeys2=0.2;
	}
	*proxy{
		~rootKeys = PatternProxy( Pseq([0], inf));
		~rootKeysP = Pseq([~rootKeys], inf).asStream;
		~nt1Keys = PatternProxy( Pseq([0], inf));
		~nt1KeysP = Pseq([~nt1Keys], inf).asStream;
		~nt2Keys = PatternProxy( Pseq([0], inf));
		~nt2KeysP = Pseq([~nt2Keys], inf).asStream;
		~nt3Keys = PatternProxy( Pseq([0], inf));
		~nt3KeysP = Pseq([~nt3Keys], inf).asStream;
		~dur1Keys = PatternProxy( Pseq([1], inf));
		~dur1KeysP = Pseq([~dur1Keys], inf).asStream;
		~durMulKeys = PatternProxy( Pseq([1], inf));
		~durMulKeysP = Pseq([~durMulKeys], inf).asStream;
		~amp1Keys = PatternProxy( Pseq([0.9], inf));
		~amp1KeysP = Pseq([~amp1Keys], inf).asStream;
		~sus1Keys = PatternProxy( Pseq([0.2], inf));
		~sus1KeysP = Pseq([~sus1Keys], inf).asStream;

		~transKeys = PatternProxy( Pseq([1], inf));
		~transKeysP = Pseq([~transKeys], inf).asStream;
		~transShufKeys = PatternProxy( Pseq([1], inf));
		~transShufKeysP = Pseq([~transShufKeys], inf).asStream;
		~transCntKeys = PatternProxy( Pseq([0], inf));
		~transCntKeysP = Pseq([~transCntKeys], inf).asStream;

		~octKeys = PatternProxy( Pseq([3], inf));
		~octKeysP = Pseq([~octKeys], inf).asStream;
		~legKeys = PatternProxy( Pseq([0.0], inf));
		~legKeysP = Pseq([~legKeys], inf).asStream;
		~hrmKeys = PatternProxy( Pseq([1.0], inf));
		~hrmKeysP = Pseq([~hrmKeys], inf).asStream;

		~delta1Keys = PatternProxy( Pseq([1/1], inf));
		~delta1KeysP = Pseq([~delta1Keys], inf).asStream;
		~lfoRtKeys = PatternProxy( Pseq([20], inf));
		~lfoRtKeysP = Pseq([~lfoRtKeys], inf).asStream;

		~delta2Keys = PatternProxy( Pseq([1/1], inf));
		~delta2KeysP = Pseq([~delta2Keys], inf).asStream;
		~lfoCtKeys = PatternProxy( Pseq([40], inf));
		~lfoCtKeysP = Pseq([~lfoCtKeys], inf).asStream;

		~delta3Keys = PatternProxy( Pseq([1/2], inf));
		~delta3KeysP = Pseq([~delta3Keys], inf).asStream;
		~vcfCtKeys = PatternProxy( Pseq([40], inf));
		~vcfCtKeysP = Pseq([~vcfCtKeys], inf).asStream;

		~lfo1Keys = PatternProxy( Pseq([10], inf));
		~lfo1KeysP = Pseq([~lfo1Keys], inf).asStream;
		~lfo2Keys = PatternProxy( Pseq([10], inf));
		~lfo2KeysP = Pseq([~lfo2Keys], inf).asStream;

		~actKeys = PatternProxy( Pseq([1], inf));
		~actKeysP= Pseq([~actKeys], inf).asStream;

		~volKeys = PatternProxy( Pseq([0.9], inf));
		~volKeysP = Pseq([~volKeys], inf).asStream;

		//lng
		~rootLngKeys = PatternProxy( Pseq([0], inf));
		~rootLngKeysP = Pseq([~rootLngKeys], inf).asStream;
		~nt1LngKeys = PatternProxy( Pseq([0], inf));
		~nt1LngKeysP = Pseq([~nt1LngKeys], inf).asStream;
		~dur1LngKeys = PatternProxy( Pseq([1], inf));
		~dur1LngKeysP = Pseq([~dur1LngKeys], inf).asStream;
		~amp1LngKeys = PatternProxy( Pseq([0.9], inf));
		~amp1LngKeysP = Pseq([~amp1LngKeys], inf).asStream;
		~sus1LngKeys = PatternProxy( Pseq([1], inf));
		~sus1LngKeysP = Pseq([~sus1LngKeys], inf).asStream;

		~transLngKeys = PatternProxy( Pseq([0], inf));
		~transLngKeysP = Pseq([~transLngKeys], inf).asStream;
		~transShufLngKeys = PatternProxy( Pseq([0], inf));
		~transShufLngKeysP = Pseq([~transShufLngKeys], inf).asStream;

		~cntKeysLfo=0;
		~cntKeys=0;
	}

	/**new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{
				~lateKeys.wait;
				~cntKeys=~cntKeys+1;
				//~cntKeys.postln;
				~cntKeys.switch(
					0,{},
					1,{this.p1(val);},
					4,{~cntKeys=0;}
				);
				((~dur1KeysP.next)*(~durMulP.next)/val).wait;
			}}.fork;
		}
	}
	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\chan, ~chVKeys,
			\type, \midi, \midiout,~vKeys, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur1KeysP.next],~actKeysP.next),
			\degree, Pseq([~nt1KeysP.next], inf),
			\amp, Pseq([~volKeysP.next*~amp1KeysP.next], inf),
			\sustain, Pseq([3.0*~sus1KeysP.next],inf)*~susMulKeys,
			\mtranspose, Pseq([~transKeysP.next], inf)+~transCntKeysP.next+~trKeys+~transShufKeysP.next,
			\ctranspose, Pseq([~rootKeysP.next],inf),
			\octave, Pseq([~octKeysP.next], inf)+~octMulKeys,
			\harmonic, Pseq([~hrmKeysP.next], inf)+~harmKeys
		).play(~clkKeys, quant: 0);

		~cntKeysLfo=~cntKeysLfo+1;
		~cntKeysLfo.switch(
			0,{},
			1,{this.pLfo;},
			2,{~cntKeysLfo=0;}
		);
	}//p1
	*pLfo{
		Pbind(//LFO CUT KEYS INT
			\midicmd, \control, \type, \midi,
			\midiout,~vKeys, \chan, ~chVKeys, \ctlNum, Pseq([~vcfEg],inf),
			\delta, Pseq([~delta1KeysP.next], ~actKeysP.next),
			\control, ~lfoMulKeys1*Pexprand(0.5*~lfo1KeysP.next,1*~lfo1KeysP.next, inf).round,
		).play(~clkKeys, quant: 0);

		Pbind(//LFO RATE KEYS
			\midicmd, \control, \type, \midi,
			\midiout,~vKeys, \chan, ~chVKeys, \ctlNum, Pseq([~vcoPort],inf),
			\delta, Pseq([~delta2KeysP.next], ~actKeysP.next),
			\control, ~lfoMulKeys2*Pexprand(0.8*~lfo2KeysP.next,0.5*~lfo2KeysP.next, inf).round,
		).play(~clkKeys, quant: 0);
	}//pLfo*/

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{
				this.p1(val);
				((~dur1KeysP.next)*(~durMulKeysP.next)/val).wait;
			}}.fork;
		}
	}
	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\chan, ~chVKeys,
			\type, \midi, \midiout,~vKeys, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur1KeysP.next],~actKeysP.next),
			\degree, Pseq([~nt1KeysP.next], inf),
			\amp, Pseq([~volKeysP.next*~amp1KeysP.next], inf),
			\sustain, Pseq([3.0*~sus1KeysP.next],inf)*~susMulKeys,
			\mtranspose, Pseq([~transKeysP.next], inf)+~transCntKeysP.next+~trKeys+~transShufKeysP.next,
			\ctranspose, Pseq([~rootKeysP.next],inf),
			\octave, Pseq([~octKeysP.next], inf)+~octMulKeys,
			\harmonic, Pseq([~hrmKeysP.next], inf)+~harmKeys
		).play(~clkKeys, quant: 0);

		~cntKeysLfo=~cntKeysLfo+1;
		~cntKeysLfo.switch(
			0,{},
			1,{this.pLfo;},
			2,{~cntKeysLfo=0;}
		);
	}//p1
	*pLfo{
		Pbind(//LFO CUT KEYS INT
			\midicmd, \control, \type, \midi,
			\midiout,~vKeys, \chan, ~chVKeys, \ctlNum, Pseq([~vcoDtn],inf),
			\delta, Pseq([~delta1KeysP.next], ~actKeysP.next),
			\control, ~lfoMulKeys1*Pexprand(0.5*~lfo1KeysP.next,1*~lfo1KeysP.next, inf).round,
		).play(~clkKeys, quant: 0);

		Pbind(//LFO RATE KEYS
			\midicmd, \control, \type, \midi,
			\midiout,~vKeys, \chan, ~chVKeys, \ctlNum, Pseq([~vcoPort],inf),
			\delta, Pseq([~delta2KeysP.next], ~actKeysP.next),
			\control, ~lfoMulKeys2*Pexprand(0.8*~lfo2KeysP.next,0.5*~lfo2KeysP.next, inf).round,
		).play(~clkKeys, quant: 0);
	}//pLfo
	*lng{|deg=0,amp=1,sus=4|
		Pbind(
			\chan, ~chVKeys,
			\type, \midi, \midiout,~vKeys, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur1LngKeysP.next],1),
			\degree, Pseq([~nt1LngKeysP.next], inf)+deg,
			\amp, Pseq([~volKeysP.next*~amp1LngKeysP.next], inf)*amp,
			\sustain, Pseq([~sus1LngKeysP.next],inf)*sus,
			\mtranspose, Pseq([~transLngKeysP.next], inf)+~transCntKeysP.next+~transShufLngKeysP.next,
			\ctranspose, Pseq([~rootLngKeysP.next],inf),
			\octave, Pseq([~octKeysP.next], inf)+~octMulKeys,
			\harmonic, Pseq([~hrmKeysP.next], inf)+~harmKeys
		).play(~clkKeys, quant: 0);
	}
	*osc{
		~actKeysBut.free;
		~actKeysBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~actKeys.source=1;
				~apcMn.noteOn(~apcMnCh, ~actButA6, 127); //Trk5_But 1
			},{
				~actKeys.source=0;
				~apcMn.noteOff(~apcMnCh, ~actButA6, 127); //Trk5_But
			});
		},'/activKeys');
		~time2KeysBut.free;
		~countTime2Keys=0;
		~time2KeysBut= OSCFunc({
			arg msg;

			~countTime2Keys = ~countTime2Keys + 1;
			~countTime2Keys.switch(
				0,{},
				1, {
					~apcMn.noteOn(~apcMnCh, ~actButB5, 1); //Trk5_But 2
					//~tOSCAdrr.sendMsg('time2Keys', 1);
					//~tOSCAdrr.sendMsg('tmKeysLabel', 2);
					~tmMulKeys.source = Pseq([2], inf);
				},
				2,{
					~apcMn.noteOn(~apcMnCh, ~actButB5, 0); //Trk5_But 2
					//~tOSCAdrr.sendMsg('time2Keys', 0);
					//~tOSCAdrr.sendMsg('tmKeysLabel', 1);
					~tmMulKeys.source = Pseq([1], inf);
					~countTime2Keys=0;
				}
			);
		},
		'/time2Keys'
		);

		/*~volKeysFader.free;
		~volKeysFader= OSCFunc({
			arg msg,vel,val;
			val=msg[1];
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('volKeys', msg[1]);
			//~vKeys.control(5, 1, vel);
			~mdOut.control(6, 1, vel);
			~volKeys.source = val;
		},
		'/volKeys');

		~attKeysFader.free;
		~attKeysFader= OSCFunc({
			arg msg,vel,val;
			vel=msg[1]*127;
			val=msg[1];
			~tOSCAdrr.sendMsg('attKeys', msg[1]);
			VKeys.cc(\envAttVK,vel);
			~mdOut.control(6, 5, vel);
		},
		'/attKeys'
		);
		~susKeysFader.free;
		~susKeysFader= OSCFunc({
			arg msg,val,vel;
			val=msg[1];
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('susKeys', msg[1]);
			VKeys.cc(\envSusVK,vel+0.01);
			~mdOut.control(6, 6, vel);
		},
		'/susKeys'
		);
		~decKeysFader.free;
		~decKeysFader= OSCFunc({
			arg msg,val,vel;
			val=msg[1];
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('decKeys', val);
			VKeys.cc(\envDecVK,vel+0.01);
			~mdOut.control(6, 127, vel);
		},
		'/decKeys'
		);

		~xy1Keys.free;
		~xy1Keys= OSCFunc({
			arg msg,val1,val2,vel;
			val1=msg[1];
			val2=msg[2];
			vel=msg[1]*127;
			~mdOut.control(6, 12, vel);
			~mdOut.control(6, 11, vel);
			VKeys.cc(\dlyTimeVK,msg[2]*127);
			VKeys.cc(\dlyFeedVK,msg[1]*127);
			~tOSCAdrr.sendMsg('xy1Keys', msg[1], msg[2]);
		},
		'/xy1Keys'
		);

		~sendsKeys.free;
		~sendsKeys= OSCFunc({
			arg msg,vel1,vel2;

			vel1=msg[1]*127;
			vel2=msg[2]*127;
			~tOSCAdrr.sendMsg('sendKeys', msg[1], msg[2]);
			~mdOut.control(6, 4, vel1); // IFKeys
			~mdOut.control(6, 3, vel2); // IFKeys
		},
		'/sendKeys'
		);
		~lfoMulKeysFad1.free;
		~lfoMulKeysFad1= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('lfoMulKeys1', msg[1]);
			~lfoMulKeys1=msg[1]*1.2;
		},
		'/lfoMulKeys1'
		);
		~lfoMulKeysFad2.free;
		~lfoMulKeysFad2= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('lfoMulKeys2', msg[1]);
			~lfoMulKeys2=msg[1]*1.2;
		},
		'/lfoMulKeys2'
		);
		//TIME
		~tmMulKeysBut1.free;
		~tmMulKeysBut1= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~tmMulKeys.source = Pseq([1], inf);
				~tOSCAdrr.sendMsg('tmKeysLabel', 1);
			});
		},
		'/tmMulKeys1'
		);
		~tmMulKeysBut2.free;
		~tmMulKeysBut2= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~tmMulKeys.source = Pseq([2], inf);
				~tOSCAdrr.sendMsg('tmKeysLabel', 2);
			});
		},
		'/tmMulKeys2'
		);
		~tmMulKeysBut3.free;
		~tmMulKeysBut3= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~tmMulKeys.source = Pseq([3], inf);
				~tOSCAdrr.sendMsg('tmKeysLabel', 3);
			});
		},
		'/tmMulKeys3'
		);
		~tmKeysFader.free;
		~tmKeysFader= OSCFunc({
			arg msg;
			~tmKeys.source = msg[1];

		},
		'/timesKeys'
		);
		~padKeys.free;
		~padKeys = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				IFKeys(~tmKeysP.next);

			});
		},
		'/padKeys'
		);

		~octKeysMulBut.free;
		~octKeysMulBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~octMulKeys = ~octMulKeys+1;
				~tOSCAdrr.sendMsg('octKeysLabel', ~octMulKeys);
			});
		},
		'/octKeysMul'
		);
		~octKeysZeroBut.free;
		~octKeysZeroBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~octMulKeys = 0;
				~tOSCAdrr.sendMsg('octKeysLabel', ~octMulKeys);
			});
		},
		'/octKeysZero'
		);
		~octKeysDivBut.free;
		~octKeysDivBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~octMulKeys = ~octMulKeys-1;
				~tOSCAdrr.sendMsg('octKeysLabel', ~octMulKeys);
			});
		},
		'/octKeysDiv'
		);*/

	}
	//      NEW OSC
	*set{|key,val|
		var vel, valNew;
		vel=val*127;
		key.switch(
			/*\timeM,{
				if ( val==1, {
					~apcMn.noteOn(~apcMnCh, ~actButA4, 1);
					~tmMulKeys.source = Pseq([2], inf);
				});
			},*/
			\octMDcr,{
				if ( val==1, {
					~crntKeys_octM=~crntKeys_octM-1;
					IFKeys.set1(\octM,~crntKeys_octM);
				});
			},
			\octMIcr,{
				if ( val==1, {
					~crntKeys_octM=~crntKeys_octM+1;
					IFKeys.set1(\octM,~crntKeys_octM);
				});
			},
			\octMZero,{
				if ( val==1, {
					IFKeys.set1(\octM,0);
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
				~crntKeys_vol=val1;
				this.lbl1(\IFvolKeys,val1);
				~volKeys.source = val1;
				VKeys.cc(\expresVK,vel1);
				~mdOut.control(6, 1, vel1);
			},
			\att, {
				~crntKeys_att=val1;
				this.lbl1(\IFattKeys,val1);
				VKeys.cc(\envAttVK,vel1);
				~mdOut.control(6, 5, vel1);
			},
			\dec, {
				~crntKeys_dec=val1;
				this.lbl1(\IFdecKeys,val1);
				VKeys.cc(\envDecVK,vel1);
				~mdOut.control(6, 127, vel1);
			},
			\sus, {
				~crntKeys_sus=val1;
				this.lbl1(\IFsusKeys,val1);
				VKeys.cc(\envSusVK,vel1);
				~mdOut.control(6, 6, vel1);
			},
			\rls, {
				~crntKeys_rls=val1;
				this.lbl1(\IFrlsKeys,val1);
				~mdOut.control(6, 8, vel1);
			},
			\pan, {
				~crntKeys_pan=val1;
				this.lbl1(\IFpanKeys,val1);
				VKeys.cc(\vcfEgVK,vel1);
				~mdOut.control(6, 16, vel1);
			},
			\octM, {
				~crntKeys_octM=val1;
				this.lbl1(\IFoctMKeysLbl,val1);
				~octMulKeys = val1;
			},
			\susM, {
				~crntKeys_susM=val1;
				this.lbl1(\IFsusMKeys,val1);
				~susMulKeys=val1;
			},
			\lfoM1, {
				~crntKeys_lfoM1=val1;
				this.lbl1(\IFlfoM1Keys,val1);
				~lfoMulKeys1=val1;
			},
			\lfoM2, {
				~crntKeys_lfoM2=val1;
				this.lbl1(\IFlfoM2Keys,val1);
				~lfoMulKeys2=val1;
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
				this.lbl2(\sendKeys,val1,val2);
				~mdOut.control(6, 4, vel1); // IFKeys
				~mdOut.control(6, 3, vel2); // IFKeys
				~crntKeys_sndY=val1;
				~crntKeys_sndX=val2;
			},
			\xy1, {
				this.lbl2(\xy1Keys,val1,val2);
				VKeys.cc(\lfoRateVK,val2);
				VKeys.cc(\lfoPitchVK,val1);
				~crntKeys_xy1X=val2;
				~crntKeys_xy1Y=val1;
			},
			\xy2, {
				this.lbl2(\xy2Keys,val1,val2);
				VKeys.cc(\dlyTimeVK,vel2);
				VKeys.cc(\dlyFeedVK,vel1);
				~crntKeys_xy2X=val2;
				~crntKeys_xy2Y=val1;
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
				'octMDcrKeys_T', { this.set(\octMDcr,val);},
				'octMIcrKeys_T', { this.set(\octMIcr,val);},
				'octMZeroKeys_T', { this.set(\octMZero,val);},
				//-GlobalSettings
				'volKeys_T' , { this.set1(\vol,val1);},
				'attKeys_T' , { this.set1(\att,val1);},
				'decKeys_T' , { this.set1(\dec,val1);},
				'susKeys_T' , { this.set1(\sus,val1);},
				'rlsKeys_T' , { this.set1(\rls,val1);},
				'panKeys_T' , { this.set1(\pan,val1);},
				'sendKeys_T', { this.set2(\send,val1,val2);},
				'susMKeys_T', { this.set1(\susM,val1);},
				'octMKeys_T', { this.set1(\octM,val1);},
				'xy1Keys_T' , { this.set2(\xy1,val1,val2);},
				'xy2Keys_T' , { this.set2(\xy2,val1,val2);},
				'lfoM1Keys_T',{ this.set1(\lfoM1,val1);},
				'lfoM2Keys_T',{ this.set1(\lfoM2,val1);},
			);
		},path:oscName);
	}
	*makeOSCResponders{
		this.oscResp(respName:\octMDcrKeysResp, oscName:\IFoctMDcrKeys, playTag:'octMDcrKeys_T');
		this.oscResp(respName:\octMIcrKeysResp, oscName:\IFoctMIcrKeys, playTag:'octMIcrKeys_T');
		this.oscResp(respName:\octMZeroKeysResp, oscName:\IFoctMZeroKeys, playTag:'octMZeroKeys_T');
		//-GlobalSettings
		this.oscResp(respName:\volKeysResp, oscName:\IFvolKeys, playTag:'volKeys_T');
		this.oscResp(respName:\attKeysResp, oscName:\IFattKeys, playTag:'attKeys_T');
		this.oscResp(respName:\decKeysResp, oscName:\IFdecKeys, playTag:'decKeys_T');
		this.oscResp(respName:\susKeysResp, oscName:\IFsusKeys, playTag:'susKeys_T');
		this.oscResp(respName:\rlsKeysResp, oscName:\IFrlsKeys, playTag:'rlsKeys_T');
		this.oscResp(respName:\panKeysResp, oscName:\IFpanKeys, playTag:'panKeys_T');
		this.oscResp(respName:\sendKeysResp, oscName:\IFsendKeys, playTag:'sendKeys_T');
		this.oscResp(respName:\susMKeysResp, oscName:\IFsusMKeys, playTag:'susMKeys_T');
		this.oscResp(respName:\octMKeysResp, oscName:\IFoctMKeys, playTag:'octMKeys_T');
		this.oscResp(respName:\xy1KeysResp,  oscName:\IFxy1Keys, playTag:'xy1Keys_T');
		this.oscResp(respName:\xy2KeysResp, oscName:\IFxy2Keys, playTag:'xy2Keys_T');
		this.oscResp(respName:\lfoM1KeysResp, oscName:\IFlfoM1Keys, playTag:'lfoM1Keys_T');
		this.oscResp(respName:\lfoM2KeysResp, oscName:\IFlfoM2Keys, playTag:'lfoM2Keys_T');
	}

}

/*
Pbind(
\chan, ~chKeys,
\type, \midi, \midiout,~vKeys, \scale, Pfunc({~scl2}, inf),
\dur, Pseq([4],1),
\degree, Pseq([
], inf),
\amp, Pseq([~volKeysP.next*~amp1KeysP.next], inf),
\sustain, Pseq([~sus1KeysP.next],inf)*~susMulKeys,
\mtranspose, Pseq([~transKeysP.next], inf)+~trKeys+~transShufKeysP.next,
\octave, Pseq([~octKeysP.next], inf)+~octMulKeys,
\harmonic, Pseq([~hrmKeysP.next], inf)+~harmKeys
).play;

*/