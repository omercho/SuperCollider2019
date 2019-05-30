
/*

IFHat.p1(1);

~actHat.source=1;
*/

IFHat {
	classvar <>counter3=0, timeCnt=0;
	var<>hTime=1;
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
		~chHat=2;
		~lateHat=0.00;
		~hatTimes=1;
		~susMulHat=1;
		~trHat=0;
		~octMulHat=0;
		~volCHat=1;

		~lfoMulHat=1;

		~quantHat1=0.0;
		~quantHat2=0.0;

	}

	*proxy {
		~actHat = PatternProxy( Pseq([1], inf));
		~actHatP= Pseq([~actHat], inf).asStream;
		~nt1Hat = PatternProxy( Pseq([0], inf));
		~nt1HatP = Pseq([~nt1Hat], inf).asStream;
		~amp1Hat = PatternProxy( Pseq([1], inf));
		~amp1HatP = Pseq([~amp1Hat], inf).asStream;
		~dur1Hat = PatternProxy( Pseq([1], inf));
		~dur1HatP = Pseq([~dur1Hat], inf).asStream;
		~sus1Hat = PatternProxy( Pseq([1], inf));
		~sus1HatP = Pseq([~sus1Hat], inf).asStream;
		~volHat = PatternProxy( Pseq([1.0], inf));
		~volHatP = Pseq([~volHat], inf).asStream;

		~act2Hat = PatternProxy( Pseq([1], inf));
		~act2HatP= Pseq([~act2Hat], inf).asStream;
		~nt2Hat = PatternProxy( Pseq([0], inf));
		~nt2HatP = Pseq([~nt2Hat], inf).asStream;
		~amp2Hat = PatternProxy( Pseq([1], inf));
		~amp2HatP = Pseq([~amp2Hat], inf).asStream;
		~dur2Hat = PatternProxy( Pseq([1], inf));
		~dur2HatP = Pseq([~dur2Hat], inf).asStream;
		~sus2Hat = PatternProxy( Pseq([1], inf));
		~sus2HatP = Pseq([~sus2Hat], inf).asStream;
		~volHat2 = PatternProxy( Pseq([0.9], inf));
		~volHat2P = Pseq([~volHat2], inf).asStream;

		~delta1Hat2 = PatternProxy( Pseq([1], inf));
		~delta1Hat2P = Pseq([~delta1Hat2], inf).asStream;

		~transHat = PatternProxy( Pseq([0], inf));
		~transHatP = Pseq([~transHat], inf).asStream;
		~transShufHat = PatternProxy( Pseq([0], inf));
		~transShufHatP = Pseq([~transShufHat], inf).asStream;
		~extraShufHat = PatternProxy( Pshuf([0], inf));
		~extraShufHatP = Pseq([~extraShufHat], inf).asStream;

		~octHat = PatternProxy( Pseq([3], inf));
		~octHatP = Pseq([~octHat], inf).asStream;

		~hrmHat = PatternProxy( Pseq([1.0], inf));
		~hrmHatP = Pseq([~hrmHat], inf).asStream;

		~actHatLfo1 = PatternProxy( Pseq([0], inf));
		~actHatLfo1P= Pseq([~actHatLfo1], inf).asStream;

		~delta1VSamp07 = PatternProxy( Pseq([1/1], inf));
		~delta1VSamp07P = Pseq([~delta1VSamp07], inf).asStream;

		~delta2VSamp07 = PatternProxy( Pseq([1/1], inf));
		~delta2VSamp07P = Pseq([~delta2VSamp07], inf).asStream;

		~lfo1Hat = PatternProxy( Pseq([1], inf));
		~lfo1HatP = Pseq([~lfo1Hat], inf).asStream;
		~lfo2Hat = PatternProxy( Pseq([1], inf));
		~lfo2HatP = Pseq([~lfo2Hat], inf).asStream;

	}//proxy

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{
				~lateHat.wait;
				this.p1(val);
				((~dur1HatP.next)*(~durMul2P.next)/val).wait;
			}}.fork;
		}
	}

	*hat2{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{

				this.p2(val);
				((~dur2HatP.next)*(~durMulP.next)/val).wait;
			}}.fork;
		}

	}
	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\chan, ~chHat,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur1HatP.next],~actHatP),
			\degree, Pseq([~nt1HatP.next], inf),
			\amp, Pseq([~volHatP.next*~amp1HatP.next], inf),
			\sustain, Pseq([~sus1HatP.next],inf)*~susMulHat,
			\mtranspose, Pseq([~transHatP.next], inf)+~trHat+~transShufHatP.next,
			\octave, Pseq([~octHatP.next], inf)+~octMulHat,
			\harmonic, Pseq([~hrmHatP.next], inf)+~harmHat
		).play(~clkHat,quant: ~quantHat1);
	}
	*p2{|i=1|
		var val;
		val=i;
		Pbind(
			\chan, ~chHat,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur2HatP.next], ~act2HatP),
			\degree, Pseq([~nt2HatP.next], inf),
			\amp, Pseq([~volHat2P.next*~amp2HatP.next], inf),
			\sustain, Pseq([~sus2HatP.next],inf)*~susMulHat,
			\harmonic, Pseq([~hrmHatP.next], inf)+~harmHat
		).play(~clkHat,quant:~quantHat2);
	}

	*osc {

		~actHatBut.free;
		~actHatBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~actHat.source=1;
				~apcMn.noteOn(~apcMnCh, ~actButA3, 127); //Trk1_But 1

			},{
				~actHat.source=0;
				~apcMn.noteOff(~apcMnCh, ~actButA3, 127); //Trk1_But 1

			});
		},
		'/activHat'
		);

		~time2HatBut.free;
		~countTime2Hat=0;
		~time2HatBut= OSCFunc({
			arg msg;

			~countTime2Hat = ~countTime2Hat + 1;
			~countTime2Hat.switch(
				0,{},
				1, {

					//~apcMn.noteOn(~apcMnCh, ~actButB3, 1);
					//~tOSCAdrr.sendMsg('time2Hat', 1);
					//~tOSCAdrr.sendMsg('tmHatLabel', 2);
					//~tmMulHat.source = Pseq([2], inf);
				},
				2,{

					//~apcMn.noteOn(~apcMnCh, ~actButB3, 0);
					//~tOSCAdrr.sendMsg('time2Hat', 0);
					//~tOSCAdrr.sendMsg('tmHatLabel', 1);
					//~tmMulHat.source = Pseq([1], inf);
					~countTime2Hat=0;
			});
		},
		'/time2Hat'
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
					~tmMulHat.source = Pseq([2], inf);
				});
			},*/
			\octMDcr,{
				if ( val==1, {
					~crntHat_octM=~crntHat_octM-1;
					IFHat.set1(\octM,~crntHat_octM);
				});
			},
			\octMIcr,{
				if ( val==1, {
					~crntHat_octM=~crntHat_octM+1;
					IFHat.set1(\octM,~crntHat_octM);
				});
			},
			\octMZero,{
				if ( val==1, {
					IFHat.set1(\octM,0);
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
				~crntHat_vol=val1;
				this.lbl1(\volHat,val1);
				~volHat.source = val1;
				~mdOut.control(4, 1, vel1);
			},
			\octM, {
				~crntHat_octM=val1;
				this.lbl1(\IFoctMHatLbl,val1);
				~octMulHat = val1;
			},
			\susM, {
				~crntHat_susM=val1;
				this.lbl1(\IFsusMHat,val1);
				~susMulHat=val1;
			},
			\dec, {
				~crntHat_dec=val1;
				this.lbl1(\IFdecHat,val1);
				~mdOut.control(4, 127, vel1);
			},
			\dly, {
				~crntHat_sus=val1;
				this.lbl1(\IFdlyHat,val1);
				//~mdOut.control(5, 6, vel1);
			},
			\pan, {
				~crntHat_pan=val1;
				this.lbl1(\IFpanHat,val1);
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
				this.lbl2(\sendHat,val1,val2);
				~mdOut.control(4, 4, vel1); // IFHat
				~mdOut.control(4, 3, vel2); // IFHat
				~crntHat_sndY=val1;
				~crntHat_sndX=val2;
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
				'octMDcrHat_T', { this.set(\octMDcr,val);},
				'octMIcrHat_T', { this.set(\octMIcr,val);},
				'octMZeroHat_T', { this.set(\octMZero,val);},
				//-GlobalSettings
				'volHat_T' , { this.set1(\vol,val1);},
				'octMHat_T', { this.set1(\octM,val1);},
				'susMHat_T', { this.set1(\susM,val1);},
				'decHat_T' , { this.set1(\dec,val1);},
				'susHat_T' , { this.set1(\dly,val1);},
				'panHat_T' , { this.set1(\pan,val1);},
				'sendHat_T', { this.set2(\send,val1,val2);},

			);
		},path:oscName);
	}
	*makeOSCResponders{
		this.oscResp(respName:\octMDcrHatResp, oscName:\IFoctMDcrHat, playTag:'octMDcrHat_T');
		this.oscResp(respName:\octMIcrHatResp, oscName:\IFoctMIcrHat, playTag:'octMIcrHat_T');
		this.oscResp(respName:\octMZeroHatResp, oscName:\IFoctMZeroHat, playTag:'octMZeroHat_T');
		//-GlobalSettings
		this.oscResp(respName:\volHatResp, oscName:\IFvolHat, playTag:'volHat_T');
		this.oscResp(respName:\octMHatResp, oscName:\IFoctMHat, playTag:'octMHat_T');
		this.oscResp(respName:\susMHatResp, oscName:\IFsusMHat, playTag:'susMHat_T');
		this.oscResp(respName:\decHatResp, oscName:\IFdecHat, playTag:'decHat_T');
		this.oscResp(respName:\dlyHatResp, oscName:\IFdlyHat, playTag:'dlyHat_T');
		this.oscResp(respName:\panHatResp, oscName:\IFpanHat, playTag:'panHat_T');
		this.oscResp(respName:\sendHatResp, oscName:\IFsendHat, playTag:'sendHat_T');
	}

}

