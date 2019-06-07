
/*

IFKick(4);

IFKick.synthDef(1);
~mdOut.noteOn(0, 0, 125);

*/

IFKick {

	/**initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({ this.globals; this.preSet; this.default; this.osc; });*/
		}
	}*/
	*load {
		this.globals;
		this.proxy;
		this.osc;
		this.makeOSCResponders;
	}

	*globals{

		~chKick=0;
		~actKick=1;
		~kickLate= 0.00;
		~kickTimes=1;
		~octMulKick=0;
		~trKick=0;
		~rootKick=0;
		~harmKick=0;
		~susMulKick=1;
		~drumVolC=0; ~kickVolC=1;
		~tuneKick=26;


		~attKick =0.001;
		~decKick =0.8;
		~relKick =0.3;
		~susLevKick = 0.01;

		~quantKick2=0.0;
	}

	*proxy {
		~actKick = PatternProxy( Pseq([1], inf));
		~actKickP= Pseq([~actKick], inf).asStream;
		~nt1Kick = PatternProxy( Pseq([~vKick], inf));
		~nt1KickP = Pseq([~nt1Kick], inf).asStream;
		~dur1Kick = PatternProxy( Pseq([1], inf));
		~dur1KickP = Pseq([~dur1Kick], inf).asStream;
		~durMulKick = PatternProxy( Pseq([1], inf));
		~durMulKickP = Pseq([~durMulKick], inf).asStream;
		~amp1Kick = PatternProxy( Pseq([1], inf));
		~amp1KickP = Pseq([~amp1Kick], inf).asStream;
		~sus1Kick = PatternProxy( Pseq([0.05], inf));
		~sus1KickP = Pseq([~sus1Kick], inf).asStream;


		~actKick2 = PatternProxy( Pseq([1], inf));
		~actKick2P= Pseq([~actKick2], inf).asStream;
		~ntKick2 = PatternProxy( Pseq([0], inf));
		~ntKick2P = Pseq([~ntKick2], inf).asStream;
		~ampKick2 = PatternProxy( Pseq([1], inf));
		~ampKick2P = Pseq([~ampKick2], inf).asStream;
		~durKick2 = PatternProxy( Pseq([1/2], inf));
		~durKick2P = Pseq([~durKick2], inf).asStream;
		~susKick2 = PatternProxy( Pseq([1], inf));
		~susKick2P = Pseq([~susKick2], inf).asStream;
		~volKick2 = PatternProxy( Pseq([0.9], inf));
		~volKick2P = Pseq([~volKick2], inf).asStream;
		~delta1Kick2 = PatternProxy( Pseq([1], inf));
		~delta1Kick2P = Pseq([~delta1Kick2], inf).asStream;

		~transKick = PatternProxy( Pseq([0], inf));
		~transKickP = Pseq([~transKick], inf).asStream;
		~transShufKick = PatternProxy( Pseq([0], inf));
		~transShufKickP = Pseq([~transShufKick], inf).asStream;
		~extraShufKick = PatternProxy( Pshuf([0], inf));
		~extraShufKickP = Pseq([~extraShufKick], inf).asStream;

		~octKick = PatternProxy( Pseq([0], inf));
		~octKickP = Pseq([~octKick], inf).asStream;

		~hrmKick = PatternProxy( Pseq([1.0], inf));
		~hrmKickP = Pseq([~hrmKick], inf).asStream;

		~actKickLfo1 = PatternProxy( Pseq([0], inf));
		~actKickLfo1P= Pseq([~actKickLfo1], inf).asStream;

		~volKick = PatternProxy( Pseq([1.0], inf));
		~volKickP = Pseq([~volKick], inf).asStream;

		~delta1VSamp05 = PatternProxy( Pseq([1/1], inf));
		~delta1VSamp05P = Pseq([~delta1VSamp05], inf).asStream;

		~delta2VSamp05 = PatternProxy( Pseq([1/1], inf));
		~delta2VSamp05P = Pseq([~delta2VSamp05], inf).asStream;
	}//*proxy

	*new{|i=1|
		var val;
		val=i;
		case
		{ i == val }  {
			{val.do{
				~kickLate.wait;
				this.p1(val);
				((~dur1KickP.next)*(~durMulKickP.next)/val).wait;
			}}.fork;
		}
	}

	*p1 {|i=1|
		var val;
		val=i;
		Pbind(
			\chan, ~chKick,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~dur1KickP.next],~actKickP),
			\degree,  Pseq([~nt1KickP.next], inf),
			\amp, Pseq([~volKickP.next*~amp1KickP.next], inf),
			\sustain, Pseq([~sus1KickP.next],inf)*~susMulKick,
			\mtranspose, Pseq([~transKickP.next], inf)+~trKick+~transShufKickP.next,
			\octave, Pseq([~octKickP], inf)+~octMulKick,
			\harmonic, Pseq([~hrmKickP.next], inf)+~harmKick,
		).play(~clkTom,quant:0);
		//this.count2;
		//this.timesCount;
	}
	*p2{
		//Kick2
		Pbind(
			\chan, ~chKick,
			\type, \midi, \midiout,~mdOut, \scale, Pfunc({~scl2}, inf),
			\dur, Pseq([~durKick2P.next], ~actKick2P),
			\degree, Pseq([~ntKick2P.next], inf),
			\octave, Pseq([~octKickP.next], inf)+~octMulKick,
			\amp, Pseq([~volKick2P.next*~ampKick2P.next], inf),
			\sustain, Pseq([~susKick2P.next],inf)*~susMulKick,
			\harmonic, Pseq([~hrmKickP.next], inf)+~harmKick,
		).play(~clkTom,quant:~quantKick2);
	}


	*osc{

		~actKickBut.free;
		~actKickBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				~actKick.source=1;
				~apcMn.noteOn(~apcMnCh, ~actButA1, 127); //Trk1_But 1
			},{
				~actKick.source=0;
				~apcMn.noteOff(~apcMnCh, ~actButA1, 127); //Trk1_But 1
			});
		},
		'/activKick'
		);
		~time2KickBut.free;
		~countTime2Kick=0;
		~time2KickBut= OSCFunc({
			arg msg;

			~countTime2Kick = ~countTime2Kick + 1;
			~countTime2Kick.switch(
				1,{
					//~apcMn.noteOn(0, ~actButB1, 1);
					//~tOSCAdrr.sendMsg('time2Kick', 1);
					//~tOSCAdrr.sendMsg('tmKickLabel', 2);
					//~tmMulKick.source = Pseq([2], inf);
					//~extraShufKick.source = Pshuf([2,0,2,3,0], inf);
				},
				2,{
					//~apcMn.noteOn(0, ~actButB1, 0);
					//~tOSCAdrr.sendMsg('time2Kick', 0);
					//~tOSCAdrr.sendMsg('tmKickLabel', 1);
					//~tmMulKick.source = Pseq([1], inf);
					//~extraShufKick.source = Pshuf([0], inf);
					~countTime2Kick=0;
			})

		},
		'/time2Kick'
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
					~tmMulKick.source = Pseq([2], inf);
				});
			},*/
			\octMDcr,{
				if ( val==1, {
					~crntKick_octM=~crntKick_octM-1;
					IFKick.set1(\octM,~crntKick_octM);
				});
			},
			\octMIcr,{
				if ( val==1, {
					~crntKick_octM=~crntKick_octM+1;
					IFKick.set1(\octM,~crntKick_octM);
				});
			},
			\octMZero,{
				if ( val==1, {
					IFKick.set1(\octM,0);
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
				~crntKick_vol=val1;
				this.lbl1(\volKick,val1);
				~volKick.source = val1;
				~mdOut.control(2, 1, vel1);
			},
			\octM, {
				~crntKick_octM=val1;
				this.lbl1(\IFoctMKickLbl,val1);
				~octMulKick = val1;
			},
			\susM, {
				~crntKick_susM=val1;
				this.lbl1(\IFsusMKick,val1);
				~susMulKick=val1;
			},
			\dec, {
				~crntKick_dec=val1;
				this.lbl1(\IFdecKick,val1);
				~mdOut.control(2, 127, vel1);
			},
			\dly, {
				~crntKick_sus=val1;
				this.lbl1(\IFdlyKick,val1);
				//~mdOut.control(5, 6, vel1);
			},
			\pan, {
				~crntKick_pan=val1;
				this.lbl1(\IFpanKick,val1);
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
				this.lbl2(\sendKick,val1,val2);
				~mdOut.control(2, 4, vel1); // IFKick
				~mdOut.control(2, 3, vel2); // IFKick
				~crntKick_sndY=val1;
				~crntKick_sndX=val2;
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
				'octMDcrKick_T', { this.set(\octMDcr,val);},
				'octMIcrKick_T', { this.set(\octMIcr,val);},
				'octMZeroKick_T', { this.set(\octMZero,val);},
				//-GlobalSettings
				'volKick_T' , { this.set1(\vol,val1);},
				'octMKick_T', { this.set1(\octM,val1);},
				'susMKick_T', { this.set1(\susM,val1);},
				'decKick_T' , { this.set1(\dec,val1);},
				'susKick_T' , { this.set1(\dly,val1);},
				'panKick_T' , { this.set1(\pan,val1);},
				'sendKick_T', { this.set2(\send,val1,val2);},

			);
		},path:oscName);
	}
	*makeOSCResponders{
		this.oscResp(respName:\octMDcrKickResp, oscName:\IFoctMDcrKick, playTag:'octMDcrKick_T');
		this.oscResp(respName:\octMIcrKickResp, oscName:\IFoctMIcrKick, playTag:'octMIcrKick_T');
		this.oscResp(respName:\octMZeroKickResp, oscName:\IFoctMZeroKick, playTag:'octMZeroKick_T');
		//-GlobalSettings
		this.oscResp(respName:\volKickResp, oscName:\IFvolKick, playTag:'volKick_T');
		this.oscResp(respName:\octMKickResp, oscName:\IFoctMKick, playTag:'octMKick_T');
		this.oscResp(respName:\susMKickResp, oscName:\IFsusMKick, playTag:'susMKick_T');
		this.oscResp(respName:\decKickResp, oscName:\IFdecKick, playTag:'decKick_T');
		this.oscResp(respName:\dlyKickResp, oscName:\IFdlyKick, playTag:'dlyKick_T');
		this.oscResp(respName:\panKickResp, oscName:\IFpanKick, playTag:'panKick_T');
		this.oscResp(respName:\sendKickResp, oscName:\IFsendKick, playTag:'sendKick_T');
	}

}

