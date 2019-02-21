
/*
IFKeys.times(2);
IFKeys(3);

*/


IFKeys {
	var <>keyTime = 1;
	classvar <>counter3 = 0;


	*initClass{
		StartUp add: {
			/*Server.default.doWhenBooted({ this.globals; this.preSet; this.default;this.osc; });*/
		}
	}
	*load{
		this.globals;
		this.proxy;
		this.osc;
		this.apc40;
		//this.beh;
	}
	*globals{

		~chKeys=0;
		~keysLate= 0.0;
		~timesKeys=1;
		~octMulKeys=0;
		~rootKeys=0;
		~harmKeys=0;
		~susMulKeys=1;
		~lfoMulKeys1=0;
		~lfoMulKeys2=0;
		~trKeys=0;

	}
	*octave{|val|
		~octKeys.source = Pseq([val], inf);
	}
	*octMul{|val|
		~octMulKeys = val;
		~tOSCAdrr.sendMsg('octKeysLabel', val);
	}
	*proxy{
		~nt1Keys = PatternProxy( Pseq([0], inf));
		~nt1KeysP = Pseq([~nt1Keys], inf).asStream;
		~dur1Keys = PatternProxy( Pseq([1], inf));
		~dur1KeysP = Pseq([~dur1Keys], inf).asStream;
		~amp1Keys = PatternProxy( Pseq([0.9], inf));
		~amp1KeysP = Pseq([~amp1Keys], inf).asStream;
		~sus1Keys = PatternProxy( Pseq([0.2], inf));
		~sus1KeysP = Pseq([~sus1Keys], inf).asStream;

		~tmMulKeys = PatternProxy( Pseq([1], inf));
		~tmMulKeysP= Pseq([~tmMulKeys], inf).asStream;
		~tmKeys = PatternProxy( Pseq([1], inf));
		~tmKeysP = Pseq([~tmKeys], inf).asStream;

		~transKeys = PatternProxy( Pseq([1], inf));
		~transKeysP = Pseq([~transKeys], inf).asStream;

		~transShufKeys = PatternProxy( Pseq([1], inf));
		~transShufKeysP = Pseq([~transShufKeys], inf).asStream;

		~octKeys = PatternProxy( Pseq([3], inf));
		~octKeysP = Pseq([~octKeys], inf).asStream;
		~legKeys = PatternProxy( Pseq([0.0], inf));
		~legKeysP = Pseq([~legKeys], inf).asStream;
		~hrmKeys = PatternProxy( Pseq([1.0], inf));
		~hrmKeysP = Pseq([~hrmKeys], inf).asStream;
		//~delta1Keys.source=0.5;
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

		~actKeys = PatternProxy( Pseq([1], inf));
		~actKeysP= Pseq([~actKeys], inf).asStream;

		~volKeys = PatternProxy( Pseq([0.0], inf));
		~volKeysP = Pseq([~volKeys], inf).asStream;

		/*//StaticKeys
		~actStKeys = PatternProxy( Pseq([0], inf));
		~actStKeysP= Pseq([~actStKeys], inf).asStream;
		~durStKeys = PatternProxy( Pseq([1], inf));
		~durStKeysP = Pseq([~durStKeys], inf).asStream;
		~ampStKeys = PatternProxy( Pseq([0,0,0,0,1], inf));
		~ampStKeysP = Pseq([~ampStKeys], inf).asStream;
		~ntStKeys = PatternProxy( Pseq([67], inf));
		~ntStKeysP = Pseq([~ntStKeys], inf).asStream;*/


	}

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{
				~keysLate.wait;
				this.p1(val);
				((~dur1KeysP.next)*(~durMulP.next)/val).wait;
			}}.fork;
		}

	}

	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\chan, ~chKeys,
			\type, \midi, \midiout,~vKeys, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur1KeysP.next],~actKeysP),
			\degree, Pseq([~nt1KeysP.next], inf),
			\amp, Pseq([~volKeysP.next*~amp1KeysP.next], inf),
			\sustain, Pseq([~sus1KeysP.next],inf)*~susMulKeys,
			\mtranspose, Pseq([~transKeysP.next], inf)+~trKeys+~transShufKeysP.next,
			\octave, Pseq([~octKeysP.next], inf)+~octMulKeys,
			\harmonic, Pseq([~hrmKeysP.next], inf)+~harmKeys
		).play;

		//VKeys
		Pbind(//LFO CUT KEYS INT
			\midicmd, \control, \type, \midi,
			\midiout,~vKeys, \chan, 0, \ctlNum, ~lfoCut,
			\delta, Pseq([~delta1KeysP.value], ~actKeysP),
			\control, Pseq([~lfoCtKeysP.value], inf)*~lfoMulKeys1,
		).play;

		Pbind(//LFO RATE KEYS
			\midicmd, \control, \type, \midi,
			\midiout,~vKeys, \chan, 0, \ctlNum, ~lfoRate,
			\delta, Pseq([~delta2KeysP.value], ~actKeysP),
			\control, Pseq([~lfoRtKeysP.value], inf)*~lfoMulKeys2,
		).play;

	}//p1
	*apc40{

		~volKeys_APC.free;
		~volKeys_APC=MIDIFunc.cc( {
			arg vel;
			~tOSCAdrr.sendMsg('volKeys', vel/127);
			//~mdOut.control(6, 1, vel);
			~volKeys.source = vel/127;
		},srcID:~apc40InID, chan:~apcMnCh, ccNum:~apcFd5);

		//Act ButA5
		//Keys Activate
		~cntActLine5ButA5=0;
		~mdActLine5ButA5.free;
		~mdActLine5ButA5=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine5ButA5 = ~cntActLine5ButA5 + 1;
				~cntActLine5ButA5.switch(
					0,{},
					1, {
						IFAPC40.actLine5ButA5(1);
					},
					2,{
						IFAPC40.actLine5ButA5(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcMnCh, noteNum:~actButA5);

		//Act ButB5
		//Keys Time Div2
		~cntActLine5ButB5=0;
		~mdActLine5ButB5.free;
		~mdActLine5ButB5=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine5ButB5 = ~cntActLine5ButB5 + 1;
				~cntActLine5ButB5.switch(
					0,{},
					1, {
						IFAPC40.actLine5ButB5(1);
					},
					2,{
						IFAPC40.actLine5ButB5(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcMnCh, noteNum:~actButB5);

		//Act ButC5
		//Static Keys Activate
		~cntActLine5ButC5=0;
		~mdActLine5ButC5.free;
		~mdActLine5ButC5=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine5ButC5 = ~cntActLine5ButC5 + 1;
				~cntActLine5ButC5.switch(
					0,{},
					1, {
						IFAPC40.actLine5ButC5(1);
					},
					2,{
						IFAPC40.actLine5ButC5(0);
					}
				)}
			);
		},srcID:~apc40InID, chan:~apcMnCh, noteNum:~actButC5);

	}//*apc40
	*osc{

		~actKeysBut.free;
		~actKeysBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~actKeys.source=1;
				~apc40.noteOn(~apcMnCh, ~actButA5, 127); //Trk5_But 1
				},{
					~actKeys.source=0;
					~apc40.noteOff(~apcMnCh, ~actButA5, 127); //Trk5_But
			});
			},
			'/activKeys'
		);

		~time2KeysBut.free;
		~countTime2Keys=0;
		~time2KeysBut= OSCFunc({
			arg msg;

				~countTime2Keys = ~countTime2Keys + 1;
				~countTime2Keys.switch(
					0,{},
					1, {
						~apc40.noteOn(~apcMnCh, ~actButB5, 1); //Trk5_But 2
						~tOSCAdrr.sendMsg('time2Keys', 1);
						~tOSCAdrr.sendMsg('tmKeysLabel', 2);
						~tmMulKeys.source = Pseq([2], inf);
					},
					2,{
						~apc40.noteOn(~apcMnCh, ~actButB5, 0); //Trk5_But 2
						~tOSCAdrr.sendMsg('time2Keys', 0);
						~tOSCAdrr.sendMsg('tmKeysLabel', 1);
						~tmMulKeys.source = Pseq([1], inf);
						~countTime2Keys=0;
					}
				);
			},
			'/time2Keys'
		);

		~volKeysFader.free;
		~volKeysFader= OSCFunc({
			arg msg,vel;
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('volKeys', msg[1]);
			~vKeys.control(5, 1, vel);
			},
			'/volKeys'
		);

		~attKeysFader.free;
		~attKeysFader= OSCFunc({
			arg msg,val;
			val=msg[1]*127;
			if ( ~volcaBoolean==1, {
				~tOSCAdrr.sendMsg('attKeys', msg[1]);
				~vKeys.control(0, ~envAtt, val);
				//~mdOut.control(6, 5, val);
				},{
					~tOSCAdrr.sendMsg('attKeys', msg[1]);
					~mdOut.control(6, 5, val);
			});
			},
			'/attKeys'
		);


		~susKeysFader.free;
		~susKeysFader= OSCFunc({
			arg msg,val;
			val=msg[1]*127;
			if ( ~volcaBoolean==1, {
				~tOSCAdrr.sendMsg('susKeys', msg[1]);
				~vKeys.control(0, ~envSus, val+0.01);
				~mdOut.control(6, 6, val);
				},{
					~tOSCAdrr.sendMsg('susKeys', msg[1]);
					~mdOut.control(6, 6, val);
			});
			},
			'/susKeys'
		);


		~decKeysFader.free;
		~decKeysFader= OSCFunc({
			arg msg,val,vel;
			val=msg[1];
			vel=msg[1]*127;
			if ( ~volcaBoolean==1, {
				~tOSCAdrr.sendMsg('decKeys', val);
				~vKeys.control(0, ~envDec, vel+0.01);
				~mdOut.control(6, 127, vel);
				~nobD6_m1Val= vel;
				},{
					~tOSCAdrr.sendMsg('decKeys', val);
					~mdOut.control(6, 127, vel);
					~nobD6_m1Val= vel;
			});
			},
			'/decKeys'
		);

		~chainKeysFader.free;
		~chainKeysFader= OSCFunc({
			arg msg, val;
			val=msg[1]*127;
			~tOSCAdrr.sendMsg('chainKeys', msg[1]);
			~mdOut.control(6, 8, msg[1]*127);
			},
			'/chainKeys'
		);

		~sendsKeys.free;
		~sendsKeys= OSCFunc({
			arg msg,vel1,vel2;

			vel1=msg[1]*127;
			vel2=msg[2]*127;
			~tOSCAdrr.sendMsg('sendKeys', msg[1], msg[2]);
			~mdOut.control(6, 4, vel1); // IFKeys
			~mdOut.control(6, 3, vel2); // IFKeys
			~mdOut.control(6, 10, vel2); // IFKeys sendC

			},
			'/sendKeys'
		);

		~xy1Keys.free;
		~xy1Keys= OSCFunc({
			arg msg;
			if ( ~volcaBoolean==1, {
				~vKeys.control(0, ~dlyTime, msg[2]*127); //Delay Time
				~vKeys.control(0, ~dlyFeed, msg[1]*127); //Delay FeedBack
				~mdOut.control(6, 11, msg[2]*127);
				~mdOut.control(6, 12, msg[1]*127);
				~tOSCAdrr.sendMsg('xy1Keys', msg[1], msg[2]);
				},{

					~mdOut.control(6, 11, msg[2]*127);
					~mdOut.control(6, 12, msg[1]*127);
					~tOSCAdrr.sendMsg('xy1Keys', msg[1], msg[2]);
			});
			},
			'/xy1Keys'
		);


		/**/

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

		//----Keys-------
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
		);

	}


}