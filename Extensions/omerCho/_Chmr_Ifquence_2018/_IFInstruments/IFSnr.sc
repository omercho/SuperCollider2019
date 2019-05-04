/*
IFSnr.times(4);


PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;

IFSequence.step(~stepNumP.next);
IFSnr(~tmMulSnrP.next*~tmSnrP.next);

~vSamp.noteOn(~smp06, ~smpLvl, 120);


*/

IFSnr {
	classvar <>counter2=0, <>counter3=0, timeCnt=0;
	var <>sTime=1;
	/**initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({ this.globals; this.preSet; this.default; this.cntrl; });*/
		}
	}*/
	*load {
		this.globals;
		this.proxy;
		this.osc;
	}
	*globals{
		~chSnr=1;
		~snrLate=0.00;
		~snrTimes=1;
		~rootSnr=0;
		~harmSnr=0;
		~susMulSnr=1;
		~trSnr=0;
		~octMulSnr=0;

		~lfoMulSnr=1;

		~quantSnr1=0.0;
		~quantSnr2=0.0;

	}

	*proxy {
		~actSnr = PatternProxy( Pseq([1], inf));
		~actSnrP= Pseq([~actSnr], inf).asStream;
		~nt1Snr = PatternProxy( Pseq([0], inf));
		~nt1SnrP = Pseq([~nt1Snr], inf).asStream;
		~amp1Snr = PatternProxy( Pseq([1], inf));
		~amp1SnrP = Pseq([~amp1Snr], inf).asStream;
		~dur1Snr = PatternProxy( Pseq([1], inf));
		~dur1SnrP = Pseq([~dur1Snr], inf).asStream;
		~sus1Snr = PatternProxy( Pseq([1], inf));
		~sus1SnrP = Pseq([~sus1Snr], inf).asStream;

		~act2Snr = PatternProxy( Pseq([1], inf));
		~act2SnrP= Pseq([~act2Snr], inf).asStream;
		~nt2Snr = PatternProxy( Pseq([0], inf));
		~nt2SnrP = Pseq([~nt2Snr], inf).asStream;
		~amp2Snr = PatternProxy( Pseq([1], inf));
		~amp2SnrP = Pseq([~amp2Snr], inf).asStream;
		~dur2Snr = PatternProxy( Pseq([1], inf));
		~dur2SnrP = Pseq([~dur2Snr], inf).asStream;
		~sus2Snr = PatternProxy( Pseq([1], inf));
		~sus2SnrP = Pseq([~sus2Snr], inf).asStream;
		~volSnr2 = PatternProxy( Pseq([0.9], inf));
		~volSnr2P = Pseq([~volSnr2], inf).asStream;
		~delta1Snr2 = PatternProxy( Pseq([1], inf));
		~delta1Snr2P = Pseq([~delta1Snr2], inf).asStream;

		~transSnr = PatternProxy( Pseq([0], inf));
		~transSnrP = Pseq([~transSnr], inf).asStream;
		~transShufSnr = PatternProxy( Pseq([0], inf));
		~transShufSnrP = Pseq([~transShufSnr], inf).asStream;
		~extraShufSnr = PatternProxy( Pshuf([0], inf));
		~extraShufSnrP = Pseq([~extraShufSnr], inf).asStream;

		~octSnr = PatternProxy( Pseq([3], inf));
		~octSnrP = Pseq([~octSnr], inf).asStream;

		~hrmSnr = PatternProxy( Pseq([1.0], inf));
		~hrmSnrP = Pseq([~hrmSnr], inf).asStream;

		~actSnrLfo1 = PatternProxy( Pseq([0], inf));
		~actSnrLfo1P= Pseq([~actSnrLfo1], inf).asStream;

		~volSnr = PatternProxy( Pseq([0.9], inf));
		~volSnrP = Pseq([~volSnr], inf).asStream;

		~delta1VSamp06 = PatternProxy( Pseq([1/1], inf));
		~delta1VSamp06P = Pseq([~delta1VSamp06], inf).asStream;

		~delta2VSamp06 = PatternProxy( Pseq([1/1], inf));
		~delta2VSamp06P = Pseq([~delta2VSamp06], inf).asStream;

		~lfoMulSnr=1;
		~lfo1Snr = PatternProxy( Pseq([1], inf));
		~lfo1SnrP = Pseq([~lfo1Snr], inf).asStream;
		~lfo2Snr = PatternProxy( Pseq([1], inf));
		~lfo2SnrP = Pseq([~lfo2Snr], inf).asStream;


	}//*proxy

	*octMul{|val|
		~octMulSnr = val;
		~tOSCAdrr.sendMsg('octSnrLabel', val);
	}

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{
				~snrLate.wait;
				//this.p1_SC(val);
				this.p1(val);
				((~dur1SnrP.next)*(~durMulP.next)/val).wait;
			}}.fork;
		}
	}
	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\chan, ~chSnr,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur1SnrP.next], ~actSnrP),
			\degree, Pseq([~nt1SnrP.next], inf),
			\amp, Pseq([~volSnrP.next*~amp1SnrP.next], inf),
			\sustain, Pseq([~sus1SnrP.next],inf)*~susMulSnr,
			\mtranspose, Pseq([~transSnrP.next
			], inf)+~trSnr+~transShufSnrP.next+~extraShufSnrP.next,
			\octave, Pseq([~octSnrP.next], inf)+~octMulSnr,
			\harmonic, Pseq([~hrmSnrP.next], inf)+~harmSnr
		).play(~clkSnr,quant:~quantSnr1);
		//snr2

	}
	*p2{
		Pbind(
			\chan, ~chSnr,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur2SnrP.next], ~act2SnrP),
			\degree, Pseq([~nt2SnrP.next], inf),
			\amp, Pseq([~volSnr2P.next*~amp2SnrP.next], inf),
			\sustain, Pseq([~sus2SnrP.next],inf)*~susMulSnr,
			\harmonic, Pseq([~hrmSnrP.next], inf)+~harmSnr
		).play(~clkSnr,quant:~quantSnr2);

	}


	*osc{

		/*~actSnrBut.free;
		~actSnrBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~actSnr.source=1;
				~apcMn.noteOn(~apcMnCh, ~actButA2, 127); //Trk1_But 1
			},{
				~actSnr.source=0;
				~apcMn.noteOff(~apcMnCh, ~actButA2, 127); //Trk1_But 1
			});
		},
		'/activSnr'
		);

		~time2SnrBut.free;
		~countTime2Snr=0;
		~time2SnrBut= OSCFunc({
			arg msg;
			~countTime2Snr = ~countTime2Snr + 1;
			~countTime2Snr.switch(
				1,{
					//~apcMn.noteOn(~apcMnCh, ~actButB2, 1);
					//~tOSCAdrr.sendMsg('time2Snr', 1);
					//~tOSCAdrr.sendMsg('tmSnrLabel', 2);
					//~tmMulSnr.source = Pseq([2], inf);
					//~extraShufSnr.source = Pshuf([10,11,12,13,14], inf);
				},
				2,{
					//~apcMn.noteOn(~apcMnCh, ~actButB2, 0);
					//~tOSCAdrr.sendMsg('time2Snr', 0);
					//~tOSCAdrr.sendMsg('tmSnrLabel', 1);
					//~tmMulSnr.source = Pseq([1], inf);
					//~extraShufSnr.source = Pshuf([0], inf);
					~countTime2Snr=0;
			});
		},
		'/time2Snr'
		);*/

		~volSnrFader.free;
		~volSnrFader= OSCFunc({
			arg msg,vel;
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('volSnr', msg[1]);
			~mdOut.control(3, 1, vel);
		},
		'/volSnr'
		);

		~xy1Snr.free;
		~xy1Snr= OSCFunc({
			arg msg,val1,val2,vel;
			val1=msg[1];
			val2=msg[2];
			vel=msg[1]*127;
			if ( ~volcaBoolean==1, {
				~mdOut.control(3, 11, msg[2]*127); //Snr / Act Delay1
				~mdOut.control(3, 12, msg[1]*127); //Snr / Act Delay2
				~tOSCAdrr.sendMsg('xy1Snr', msg[1], msg[2]);
			},{
				~tOSCAdrr.sendMsg('xy1Snr', msg[1], msg[2]);
			});

		},
		'/xy1Snr'
		);
		~attSnrFader.free;
		~attSnrFader= OSCFunc({
			arg msg,vel;
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('attSnr', msg[1]);
			~mdOut.control(3, 5, vel);
			//~nobD2_m2Val= msg[1]*127;
		},
		'attSnr'
		);

		~susLevSnrFader.free;
		~susLevSnrFader= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('susSnr', msg[1]);
			~susLevSnr=msg[1];
			~mdOut.control(3, 6, msg[1]*127);
		},
		'/susSnr'
		);

		~decSnrFader.free;
		~decSnrFader= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('decSnr', msg[1]);
			~decSnr=msg[1];
			~mdOut.control(3, 127, msg[1]*127);
			//~nobD2_m1Val= msg[1]*127;
		},
		'/decSnr'
		);

		~chainSnrFader.free;
		~chainSnrFader= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('chainSnr', msg[1]);
			~mdOut.control(3, 8, msg[1]*127);
		},
		'/chainSnr'
		);

		~sendSnrXY.free;
		~sendSnrXY= OSCFunc({
			arg msg,vel1,vel2;

			vel1=msg[1]*127;
			vel2=msg[2]*127;
			~mdOut.control(3, 4, vel1); // IFSnr
			~mdOut.control(3, 3, vel2); // IFSnr
			~tOSCAdrr.sendMsg('sendSnr', msg[1], msg[2]);

		},
		'sendSnr'
		);

		//TIME

		~tmMulSnrBut1.free;
		~tmMulSnrBut1= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulSnr.source = Pseq([1], inf);
				~tOSCAdrr.sendMsg('tmSnrLabel', 1);

			});

		},
		'/tmMulSnr1'
		);
		~tmMulSnrBut2.free;
		~tmMulSnrBut2= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulSnr.source = Pseq([2], inf);
				~tOSCAdrr.sendMsg('tmSnrLabel', 2);

			});

		},
		'/tmMulSnr2'
		);
		~tmMulSnrBut3.free;
		~tmMulSnrBut3= OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				~tmMulSnr.source = Pseq([3], inf);
				~tOSCAdrr.sendMsg('tmSnrLabel', 3);

			});

		},
		'/tmMulSnr3'
		);

		~octSnrMulBut.free;
		~octSnrMulBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulSnr = ~octMulSnr+1;
				~tOSCAdrr.sendMsg('octSnrLabel', ~octMulSnr);

			});

		},
		'/octSnrMul'
		);

		~octSnrZeroBut.free;
		~octSnrZeroBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulSnr = 0;
				~tOSCAdrr.sendMsg('octSnrLabel', ~octMulSnr);

			});

		},
		'/octSnrZero'
		);

		~octSnrDivBut.free;
		~octSnrDivBut= OSCFunc({
			arg msg;


			if ( msg[1]==1, {

				~octMulSnr = ~octMulSnr-1;
				~tOSCAdrr.sendMsg('octSnrLabel', ~octMulSnr);

			});

		},
		'/octSnrDiv'
		);

	}

	//Snr Beat Counter
	*timesCount {
		timeCnt = timeCnt + 1;
		timeCnt.switch(

			1, {  },
			4, {  },
			6, {  },
			8, {  },
			9, {  },
			10, {  },
			15, {  },
			17, {  },
			18, {
				("        -----------SnareTimesCnt"+timeCnt).postln;

				timeCnt=0;
			},

		);

	}

	*count2 {
		1.do{
			counter2 = counter2 + 1;
			counter2.switch(
				3, {
					("            SnareCnt"+counter2).postln;
					this.ctl_2;
					counter2 = 0;

				}

			)
		}

	}


}

