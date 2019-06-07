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
		this.makeOSCResponders;
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
		~nt2Snr = PatternProxy( Pseq([0], inf));
		~nt2SnrP = Pseq([~nt2Snr], inf).asStream;
		~nt3Snr = PatternProxy( Pseq([0], inf));
		~nt3SnrP = Pseq([~nt3Snr], inf).asStream;

		~amp1Snr = PatternProxy( Pseq([1], inf));
		~amp1SnrP = Pseq([~amp1Snr], inf).asStream;

		~dur1Snr = PatternProxy( Pseq([1], inf));
		~dur1SnrP = Pseq([~dur1Snr], inf).asStream;
		~durMulSnr = PatternProxy( Pseq([1], inf));
		~durMulSnrP = Pseq([~durMulSnr], inf).asStream;

		~sus1Snr = PatternProxy( Pseq([1], inf));
		~sus1SnrP = Pseq([~sus1Snr], inf).asStream;

		~act2Snr = PatternProxy( Pseq([1], inf));
		~act2SnrP= Pseq([~act2Snr], inf).asStream;

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

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{
				~snrLate.wait;
				this.p1(val);
				((~dur1SnrP.next)*(~durMulSnrP.next)/val).wait;
			}}.fork;
		}
	}
	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\chan, ~chSnr,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur1SnrP.next], ~actSnrP.next),
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



	}

	//      NEW OSC
	*set{|key,val|
		var vel, valNew;
		vel=val*127;
		key.switch(
			/*\timeM,{
				if ( val==1, {
					~apcMn.noteOn(~apcMnCh, ~actButA4, 1);
					~tmMulSnr.source = Pseq([2], inf);
				});
			},*/
			\octMDcr,{
				if ( val==1, {
					~crntSnr_octM=~crntSnr_octM-1;
					IFSnr.set1(\octM,~crntSnr_octM);
				});
			},
			\octMIcr,{
				if ( val==1, {
					~crntSnr_octM=~crntSnr_octM+1;
					IFSnr.set1(\octM,~crntSnr_octM);
				});
			},
			\octMZero,{
				if ( val==1, {
					IFSnr.set1(\octM,0);
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
				~crntSnr_vol=val1;
				this.lbl1(\volSnr,val1);
				~volSnr.source = val1;
				~mdOut.control(3, 1, vel1);
			},
			\octM, {
				~crntSnr_octM=val1;
				this.lbl1(\IFoctMSnrLbl,val1);
				~octMulSnr = val1;
			},
			\susM, {
				~crntSnr_susM=val1;
				this.lbl1(\IFsusMSnr,val1);
				~susMulSnr=val1;
			},
			\dec, {
				~crntSnr_dec=val1;
				this.lbl1(\IFdecSnr,val1);
				~mdOut.control(3, 127, vel1);
			},
			\dly, {
				~crntSnr_sus=val1;
				this.lbl1(\IFdlySnr,val1);
				//~mdOut.control(5, 6, vel1);
			},
			\pan, {
				~crntSnr_pan=val1;
				this.lbl1(\IFpanSnr,val1);
				//~mdOut.control(5, 8, vel1);
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
				this.lbl2(\sendSnr,val1,val2);
				~mdOut.control(3, 4, vel1); // IFSnr
				~mdOut.control(3, 3, vel2); // IFSnr
				~crntSnr_sndY=val1;
				~crntSnr_sndX=val2;
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
				'octMDcrSnr_T', { this.set(\octMDcr,val);},
				'octMIcrSnr_T', { this.set(\octMIcr,val);},
				'octMZeroSnr_T', { this.set(\octMZero,val);},
				//-GlobalSettings
				'volSnr_T' , { this.set1(\vol,val1);},
				'octMSnr_T', { this.set1(\octM,val1);},
				'susMSnr_T', { this.set1(\susM,val1);},
				'decSnr_T' , { this.set1(\dec,val1);},
				'susSnr_T' , { this.set1(\dly,val1);},
				'panSnr_T' , { this.set1(\pan,val1);},
				'sendSnr_T', { this.set2(\send,val1,val2);},

			);
		},path:oscName);
	}
	*makeOSCResponders{
		this.oscResp(respName:\octMDcrSnrResp, oscName:\IFoctMDcrSnr, playTag:'octMDcrSnr_T');
		this.oscResp(respName:\octMIcrSnrResp, oscName:\IFoctMIcrSnr, playTag:'octMIcrSnr_T');
		this.oscResp(respName:\octMZeroSnrResp, oscName:\IFoctMZeroSnr, playTag:'octMZeroSnr_T');
		//-GlobalSettings
		this.oscResp(respName:\volSnrResp, oscName:\IFvolSnr, playTag:'volSnr_T');
		this.oscResp(respName:\octMSnrResp, oscName:\IFoctMSnr, playTag:'octMSnr_T');
		this.oscResp(respName:\susMSnrResp, oscName:\IFsusMSnr, playTag:'susMSnr_T');
		this.oscResp(respName:\decSnrResp, oscName:\IFdecSnr, playTag:'decSnr_T');
		this.oscResp(respName:\dlySnrResp, oscName:\IFdlySnr, playTag:'dlySnr_T');
		this.oscResp(respName:\panSnrResp, oscName:\IFpanSnr, playTag:'panSnr_T');
		this.oscResp(respName:\sendSnrResp, oscName:\IFsendSnr, playTag:'sendSnr_T');
	}


}

