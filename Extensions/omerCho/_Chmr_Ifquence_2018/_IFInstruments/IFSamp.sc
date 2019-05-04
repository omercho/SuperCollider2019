
/*
IFSamp.loadSC;
IFSamp.synthDef(1);
IFSamp.synthDef(2);
IFSamp.synthDef(3);
IFSamp.synthDef(4);
IFSamp.synthDef(5);


IFSamp.times(2);
IFSamp.pat_1;

~octSamp=4;
~octSamp.source = 5;

~secs=Clock.seconds;
*/


IFSamp {
	var <>keyTime = 1;
	classvar <>counter3 = 0;

	/**initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({ this.globals; this.preSet; this.default; this.osc; });*/
		}
	}*/
	*load{
		this.globals;
		this.proxy;
		this.osc;
		this.apc40;
	}
	*globals{

		~chSamp=5;
		~sampLate=0.00;
		~timesSamp=1;
		~octMulSamp=2;
		~rootFreqSamp=~c5; // 261=C4|523=C5
		~harmSamp=0;
		~susMulSamp=1;
		~lfoMulSamp1=0;
		~lfoMulSamp2=0;
		~trSamp=0;
		~cntSamp=0;


	}
	*octave{|val|
		~octSamp.source = Pseq([val], inf);
	}
	*octMul{|val|
		~octMulSamp = val;
		~tOSCAdrr.sendMsg('octSampLabel', val);
	}
	*proxy{
		~rootSamp = PatternProxy( Pseq([0], inf));
		~rootSampP = Pseq([~rootSamp], inf).asStream;
		~nt1Samp = PatternProxy( Pseq([0], inf));
		~nt1SampP = Pseq([~nt1Samp], inf).asStream;
		~dur1Samp = PatternProxy( Pseq([1], inf));
		~dur1SampP = Pseq([~dur1Samp], inf).asStream;
		~amp1Samp = PatternProxy( Pseq([0.9], inf));
		~amp1SampP = Pseq([~amp1Samp], inf).asStream;
		~sus1Samp = PatternProxy( Pseq([1], inf));
		~sus1SampP = Pseq([~sus1Samp], inf).asStream;

		~tmMulSamp = PatternProxy( Pseq([1], inf));
		~tmMulSampP= Pseq([~tmMulSamp], inf).asStream;
		~tmSamp = PatternProxy( Pseq([1], inf));
		~tmSampP= Pseq([~tmSamp], inf).asStream;

		~transSamp = PatternProxy( Pseq([0], inf));
		~transSampP = Pseq([~transSamp], inf).asStream;
		~transShufSamp = PatternProxy( Pseq([0], inf));
		~transShufSampP = Pseq([~transShufSamp], inf).asStream;
		~transCntSamp = PatternProxy( Pseq([0], inf));
		~transCntSampP = Pseq([~transCntSamp], inf).asStream;

		~octSamp = PatternProxy( Pseq([4], inf));
		~octSampP = Pseq([~octSamp], inf).asStream;

		~legSamp= PatternProxy( Pseq([0.0], inf));
		~legSampP = Pseq([~legSamp], inf).asStream;
		~hrmSamp = PatternProxy( Pseq([1.0], inf));
		~hrmSampP = Pseq([~hrmSamp], inf).asStream;

		~delta1Samp = PatternProxy( Pseq([1/4], inf));
		~delta1SampP = Pseq([~delta1Samp], inf).asStream;
		~delta2Samp = PatternProxy( Pseq([1/2], inf));
		~delta2SampP = Pseq([~delta2Samp], inf).asStream;

		~lfo1Samp = PatternProxy( Pseq([1], inf));
		~lfo1SampP = Pseq([~lfo1Samp], inf).asStream;
		~lfo2Samp = PatternProxy( Pseq([1], inf));
		~lfo2SampP = Pseq([~lfo2Samp], inf).asStream;

		~actSamp = PatternProxy( Pseq([1], inf));
		~actSampP= Pseq([~actSamp], inf).asStream;

		~volSamp = PatternProxy( Pseq([0.9], inf));
		~volSampP = Pseq([~volSamp], inf).asStream;

		//lng
		~rootLngSamp = PatternProxy( Pseq([0], inf));
		~rootLngSampP = Pseq([~rootLngSamp], inf).asStream;
		~nt1LngSamp = PatternProxy( Pseq([0], inf));
		~nt1LngSampP = Pseq([~nt1LngSamp], inf).asStream;
		~dur1LngSamp = PatternProxy( Pseq([1], inf));
		~dur1LngSampP = Pseq([~dur1LngSamp], inf).asStream;
		~amp1LngSamp = PatternProxy( Pseq([0.9], inf));
		~amp1LngSampP = Pseq([~amp1LngSamp], inf).asStream;
		~sus1LngSamp = PatternProxy( Pseq([1], inf));
		~sus1LngSampP = Pseq([~sus1LngSamp], inf).asStream;

		~transLngSamp = PatternProxy( Pseq([0], inf));
		~transLngSampP = Pseq([~transLngSamp], inf).asStream;
		~transShufLngSamp = PatternProxy( Pseq([0], inf));
		~transShufLngSampP = Pseq([~transShufLngSamp], inf).asStream;

	}

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{
				~sampLate.wait;
				~cntSamp=~cntSamp+1;
				//~cntSamp.postln;
				~cntSamp.switch(
					0,{},
					1,{this.p1(val);},
					4,{~cntSamp=0;}
				);
				((~dur1SampP.next)*(~durMulP.next)/val).wait;
			}}.fork;
		}
	}
	*p1 {|i=1|
		var val;
		val=i;

		Pbind(
			\chan, ~chSamp,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur1SampP.next],~actSampP),
			\degree, Pseq([~nt1SampP.next], inf),
			\amp, Pseq([~volSampP.next*~amp1SampP.next], inf),
			\sustain, Pseq([~sus1SampP.next],inf)*~susMulSamp,
			\mtranspose, Pseq([~transSampP.next], inf)+~transCntSampP.next+~trSamp+~transShufSampP.next,
			\ctranspose, Pseq([~rootSampP.next],inf),
			\octave, Pseq([~octSampP.next], inf)+~octMulSamp,
			\harmonic, Pseq([~hrmSampP.next], inf)+~harmSamp
		).play(~clkSamp, quant: 0);

		/*Pbind(//LFO 1
			\type, \midi, \midicmd, \control,
			\midiout,~mdOut, \chan, 7, \ctlNum, 40,
			\delta, Pseq([~delta1SampP.next], 1),
			\control, Pseq([~lfo1SampP.next], 1)*~lfoMulSamp1,
		).play(~clkSamp, quant: 0);

		Pbind(//LFO 2
			\type, \midi, \midicmd, \control,
			\midiout,~mdOut,\chan, 7,  \ctlNum, 41,
			\delta, Pseq([~delta2SampP.next], 1),
			\control, Pseq([~lfo2SampP.next], 1)*~lfoMulSamp2,
		).play(~clkSamp, quant: 0);*/

	}//p1

	*lng{|deg=0,amp=1,sus=4|
		Pbind(
			\chan, ~chSamp,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur1LngSampP.next],1),
			\degree, Pseq([~nt1LngSampP.next], inf)+deg,
			\amp, Pseq([~volSampP.next*~amp1LngSampP.next], inf)*amp,
			\sustain, Pseq([~sus1LngSampP.next],inf)*sus,
			\mtranspose, Pseq([~transLngSampP.next], inf)+~transCntSampP.next+~transShufLngSampP.next,
			\ctranspose, Pseq([~rootLngSampP.next],inf),
			\octave, Pseq([~octSampP.next], inf)+~octMulSamp,
			\harmonic, Pseq([~hrmSampP.next], inf)+~harmSamp
		).play(~clkSamp, quant: 0);
	}

	*apc40{

		/*~volSamp_APC.free;
		~volSamp_APC=MIDIFunc.cc( {
		arg vel;
		~tOSCAdrr.sendMsg('volSamp', vel/127);
		~volSamp.source = vel/127;

		},srcID:~apcMnInID, chan:~apcMnCh, ccNum:~apcFd6);*/

		//Act ButA6
		//Samp Activate
		/*~cntActLine6ButA6=0;
		~mdActLine6ButA6.free;
		~mdActLine6ButA6=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine6ButA6 = ~cntActLine6ButA6 + 1;
				~cntActLine6ButA6.switch(
					0,{},
					1, {
						IFAPCMn.actLine6ButA6(1);
					},
					2,{
						IFAPCMn.actLine6ButA6(0);
					}
			)}
			);
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButA6);

		//Act ButB6
		//Samp Time Div2
		~cntActLine6ButB6=0;
		~mdActLine6ButB6.free;
		~mdActLine6ButB6=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine6ButB6 = ~cntActLine6ButB6 + 1;
				~cntActLine6ButB6.switch(
					0,{},
					1, {
						IFAPCMn.actLine6ButB6(1);
					},
					2,{
						IFAPCMn.actLine6ButB6(0);
					}
			)}
			);
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButB6);

		//Act ButC6
		//Static Samp Activate
		~cntActLine6ButC6=0;
		~mdActLine6ButC6.free;
		~mdActLine6ButC6=MIDIFunc.noteOn({
			arg vel;
			if ( vel==127, {
				~cntActLine6ButC6 = ~cntActLine6ButC6 + 1;
				~cntActLine6ButC6.switch(
					0,{},
					1, {
						IFAPCMn.actLine6ButC6(1);
					},
					2,{
						IFAPCMn.actLine6ButC6(0);
					}
			)}
			);
		},srcID:~apcMnInID, chan:~apcMnCh, noteNum:~actButC6);*/

	}//*apc40


	*osc{

		~actSampBut.free;
		~actSampBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~actSamp.source=1;
				~apcMn.noteOn(~apcMnCh, ~actButA6, 127);
				//~behOut.control(7, 2, 127);
			},{
				~actSamp.source=0;
				~apcMn.noteOff(~apcMnCh, ~actButA6, 127);
				//~behOut.control(7, 2, 0);
			});
		},
		'/activSamp'
		);

		~time2SampBut.free;
		~countTime2Samp=0;
		~time2SampBut= OSCFunc({
			arg msg;
			~countTime2Samp = ~countTime2Samp + 1;
			~countTime2Samp.switch(
				0,{},
				1, {
					~apcMn.noteOn(~apcMnCh, ~actButB6, 1);
					//~tOSCAdrr.sendMsg('time2Samp', 1);
					//~tOSCAdrr.sendMsg('tmSampLabel', 2);
					~tmMulSamp.source = Pseq([2], inf);
				},
				2,{
					~apcMn.noteOn(~apcMnCh, ~actButB6, 0);
					//~tOSCAdrr.sendMsg('time2Samp', 0);
					//~tOSCAdrr.sendMsg('tmSampLabel', 1);
					~tmMulSamp.source = Pseq([1], inf);
					~countTime2Samp=0;
				}
			);
		},
		'/time2Samp'
		);


		~volSampFader.free;
		~volSampFader= OSCFunc({
			arg msg,vel;
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('volSamp', msg[1]);
			~mdOut.control(7, 1, vel);
		},
		'/volSamp'
		);

		~attSampFader.free;
		~attSampFader= OSCFunc({
			arg msg,vel;
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('attSamp', msg[1]);
			~mdOut.control(7, 5, vel);
		},
		'attSamp'
		);

		~susLevSampFader.free;
		~susLevSampFader= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('susSamp', msg[1]);
			~susLevSamp=msg[1];
			~mdOut.control(7, 6, msg[1]*127);

		},
		'/susSamp'
		);

		~decSampFader.free;
		~decSampFader= OSCFunc({
			arg msg,val,vel;
			val=msg[1];
			vel=msg[1]*127;
			~tOSCAdrr.sendMsg('decSamp', val);
			~decSamp=val;
			~mdOut.control(7, 127, vel);
			~nobD7_m1Val= vel;
		},
		'/decSamp'
		);

		~chainSampFader.free;
		~chainSampFader= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('chainSamp', msg[1]);
			~mdOut.control(7, 8, msg[1]*127);
		},
		'/chainSamp'
		);

		~sendSampXY.free;
		~sendSampXY= OSCFunc({
			arg msg,vel1,vel2;

			vel1=msg[1]*127;
			vel2=msg[2]*127;
			~mdOut.control(7, 4, vel1); // IFSamp
			~mdOut.control(7, 3, vel2); // IFSamp
			~mdOut.control(7, 10, vel2); // IFSamp
			~tOSCAdrr.sendMsg('sendSamp', msg[1], msg[2]);

		},
		'sendSamp'
		);
		~xy1Samp.free;
		~xy1Samp= OSCFunc({
			arg msg,vel1,vel2;

			vel1=msg[1]*127;
			vel2=msg[2]*127;
			~mdOut.control(7, 11, vel1); // IFSamp
			~mdOut.control(7, 12, vel2); // IFSamp
			~tOSCAdrr.sendMsg('xy1Samp', msg[1], msg[2]);

		},
		'xy1Samp'
		);

		~lfoMulSampFad1.free;
		~lfoMulSampFad1= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('lfoMulSamp1', msg[1]);
			~lfoMulSamp1=msg[1];
		},
		'/lfoMulSamp1'
		);

		~lfoMulSampFad2.free;
		~lfoMulSampFad2= OSCFunc({
			arg msg;
			~tOSCAdrr.sendMsg('lfoMulSamp2', msg[1]);
			~lfoMulSamp2=msg[1];
		},
		'/lfoMulSamp2'
		);
		//TIME

		~tmMulSampBut1.free;
		~tmMulSampBut1= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~tmMulSamp.source = Pseq([1], inf);
				~tOSCAdrr.sendMsg('tmSampLabel', 1);
			});
		},
		'/tmMulSamp1'
		);
		~tmMulSampBut2.free;
		~tmMulSampBut2= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~tmMulSamp.source = Pseq([2], inf);
				~tOSCAdrr.sendMsg('tmSampLabel', 2);
			});
		},
		'/tmMulSamp2'
		);
		~tmMulSampBut3.free;
		~tmMulSampBut3= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~tmMulSamp.source = Pseq([3], inf);
				~tOSCAdrr.sendMsg('tmSampLabel', 3);
			});
		},
		'/tmMulSamp3'
		);
		~tmSampFader.free;
		~tmSampFader= OSCFunc({
			arg msg;
			~tmSamp.source = msg[1];
		},
		'/timesSamp'
		);

		~padSamp.free;
		~padSamp = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSamp(~tmSampP.next);
			});
		},
		'/padSamp'
		);

		//----Samp-------
		~octSampMulBut.free;
		~octSampMulBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				//~octMulSamp = ~octMulSamp+1;
				//~tOSCAdrr.sendMsg('octSampLabel', ~octMulSamp);
				IFSamp.octMul(~octMulSamp+1)
			});
		},
		'/octSampMul'
		);

		~octSampZeroBut.free;
		~octSampZeroBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFSamp.octMul(0)
			});
		},
		'/octSampZero'
		);

		~octSampDivBut.free;
		~octSampDivBut= OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~octMulSamp = ~octMulSamp-1;
				~tOSCAdrr.sendMsg('octSampLabel', ~octMulSamp);
			});
		},
		'/octSampDiv'
		);

	}



}

/*
Pbind(
	\chan, ~chSamp,
	\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl2}, inf),
	\dur, Pseq([1],1),
	\degree, Pxrand([
		[0,2,4],
		[0,6,4],
		[0,3,9]
	], inf),
	\amp, Pseq([1], inf),
	\sustain, Pseq([12],inf),
	//\mtranspose, Pseq([~transSampP.next], inf)+~trSamp+~transShufSampP.next,
	//\octave, Pseq([~octSampP.next], inf)+~octMulSamp,
	//\harmonic, Pseq([~hrmSampP.next], inf)+~harmSamp
).play;

*/