/*

PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;

*/
IFRoot {
	*load{this.globals;this.loadProxy}
	*globals{
		~ifPlayerSeq01=TaskProxy.new;
		~ifPlayerSeq02=TaskProxy.new;
		~ifPlayerSeq03=TaskProxy.new;
		~ifPlayerSeq04=TaskProxy.new;
		~ifCountPlayer1=TaskProxy.new;
		this.responders;
		this.loadClocks;
		this.makeOSCResponders;
	}
	*loadProxy {
		~dur = PatternProxy( Pseq([2],inf) );
		~durP= Pseq([~dur], inf).asStream;
		~durMul = PatternProxy( Pseq([1/2], inf));
		~durMulP= Pseq([~durMul], inf).asStream;

		~dur2 = PatternProxy( Pseq([2],inf) );
		~dur2P= Pseq([~dur2], inf).asStream;
		~durMul2 = PatternProxy( Pseq([1/8], inf));
		~durMul2P= Pseq([~durMul2], inf).asStream;

		~dur3 = PatternProxy( Pseq([2],inf) );
		~dur3P= Pseq([~dur3], inf).asStream;
		~durMul3 = PatternProxy( Pseq([1/4], inf));
		~durMul3P= Pseq([~durMul3], inf).asStream;

		~dur4 = PatternProxy( Pseq([2],inf) );
		~dur4P= Pseq([~dur4], inf).asStream;
		~durMul4 = PatternProxy( Pseq([1/8], inf));
		~durMul4P= Pseq([~durMul4], inf).asStream;

		~durCnt1 = PatternProxy( Pseq([2],inf) );
		~durCnt1P= Pseq([~durCnt1], inf).asStream;
		~durCntMul1 = PatternProxy( Pseq([1/2], inf));
		~durCntMul1P= Pseq([~durCntMul1], inf).asStream;
	}
	*loadClocks{
		~clkMaster=TempoClock(1, 0, Main.elapsedTime.ceil);
		~clkSq01=TempoClock(1, 0, Main.elapsedTime.ceil);
		~clkSq02=TempoClock(1, 0, Main.elapsedTime.ceil);
		~clkSq03=TempoClock(1, 0, Main.elapsedTime.ceil);
		~clkSq04=TempoClock(1, 0, Main.elapsedTime.ceil);
		~clkDrum=TempoClock(1, 0, Main.elapsedTime.ceil);
		~clkTom=TempoClock(1, 0, Main.elapsedTime.ceil);
		~clkSnr=TempoClock(1, 0, Main.elapsedTime.ceil);
		~clkHat=TempoClock(1, 0, Main.elapsedTime.ceil);
		~clkBass=TempoClock(1, 0, Main.elapsedTime.ceil);
		~clkKeys=TempoClock(1, 0, Main.elapsedTime.ceil);
		~clkMopho=TempoClock(1, 0, Main.elapsedTime.ceil);
		~clkSamp=TempoClock(1, 0, Main.elapsedTime.ceil);
	}

	*play{
		IFCounter.getClockNow;
		IFCounter.getClockStart;
		~ifPlayerSeq01.play(~clkSq01, quant: 0);
		~ifPlayerSeq02.play(~clkSq02, quant: 0);
		~ifPlayerSeq03.play(~clkSq03, quant: 0);
		~ifPlayerSeq04.play(~clkSq04, quant: 0);
		~ifCountPlayer1.play(~clkMaster, quant: 0);

	}
	/*
	*play{~ifPlayerSeq01.play(MIDISyncClock, quant: 0);}
	*/
	*stop{
		IFCounter.reset;
		~ifPlayerSeq01.stop;
		~ifPlayerSeq02.stop;
		~ifPlayerSeq03.stop;
		~ifPlayerSeq04.stop;
		~ifCountPlayer1.stop;
	}


	*set00{
		"IFRoot set00".postln;
		IFRoot.butLeds(0);
		~ifPlayerSeq01.source={
			//~cntApcUpdate=0;
			inf.do{
				1.do {
					IFSequence.step(~stepNum1P.next);
					IFStat.ln01;IFStat.ln02;IFStat.ln03;
					IFStat.ln04;IFStat.ln05;IFStat.ln06;
					//IFStat.ln07;IFStat.ln08;
					((~durP.next)*(~durMulP.next)).wait;
				};
			};
		};
		~ifPlayerSeq02.source={
			//~cntPlayerMel2=0;
			inf.do{
				1.do {
					IFSequence.step2(~stepNum2P.next);
					IFKick(~tmMulKickP.next*~tmKickP.next);
					IFSnr(~tmMulSnrP.next*~tmSnrP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					//IFHat.hat2(~tmMul2HatP.next*~tm2HatP.next);
					((~dur2P.next)*(~durMul2P.next)).wait;
				};
			};
		};
		~ifPlayerSeq03.source={
			//~cntPlayerMel3=0;
			inf.do{
				1.do {
					IFSequence.step3(~stepNum3P.next);
					IFBass(~tmMulBassP.next*~tmBassP.next);
					IFKeys(~tmMulKeysP.next*~tmKeysP.next);
					((~dur3P.next)*(~durMul3P.next)).wait;
				};
			};
		};
		~ifPlayerSeq04.source={
			//~cntPlayerMel4=0;
			inf.do{
				1.do {
					IFSequence.step4(~stepNum4P.next);
					IFSamp(~tmMulSampP.next*~tmSampP.next);
					IFMopho(~tmMulMophoP.next*~tmMophoP.next);
					((~dur4P.next)*(~durMul4P.next)).wait;
				};
			};
		};
		~ifCountPlayer1.source={
			//~cntPlayerMel4=0;
			inf.do{
				1.do {
					IFCounter.cnt8;
					IFCounter.count;
					/*~cntPlayerMel4 = ~cntPlayerMel4 + 1;
					~cntPlayerMel4.switch(
					0,{},
					16,{
					IFAPCMn.update;
					~cntPlayerMel4=0;
					}
					);*/
					((~durCnt1P.next)*(~durCntMul1P.next)).wait;
				};
			};
		};
	}
	*set01{
		"IFRoot set01".postln;
		IFRoot.butLeds(1);
		~ifPlayerSeq01.source={

			inf.do{
				1.do {
					IFSequence.step(~stepNum1P.next);

					((~durP.next)*(~durMulP.next)).wait;
				};
			};
		};

	}
	*set02{
		"IFRoot set02".postln;
		IFRoot.butLeds(2);
		~ifPlayerSeq01.source={
			inf.do{
				1.do {
					IFSequence.step(~stepNum1P.next);
					((~durP.next)*(~durMulP.next)).wait;
				};
			};
		};
	}
	*set03{
		"IFRoot set03".postln;
		IFRoot.butLeds(3);
		~ifPlayerSeq01.source={
			inf.do{
				1.do {
					IFSequence.step(~stepNum1P.next);

					((~durP.next)*(~durMulP.next)).wait;
				};
			};
		};
	}
	*set04{
		"IFRoot set04".postln;
		IFRoot.butLeds(4);
		~ifPlayerSeq01.source={
			inf.do{
				1.do {
					IFSequence.step(~stepNum1P.next);
					((~durP.next)*(~durMulP.next)).wait;
				};
			};
		};
	}
	*set05{
		"IFRoot set05".postln;
		IFRoot.butLeds(5);
		~ifPlayerSeq01.source={
			inf.do{
				1.do {
					IFSequence.step(~stepNum1P.next);
					((~durP.next)*(~durMulP.next)).wait;
				};
			};
		};
	}
	*lbl{|key,val|
		var chan;
		~tOSCAdrr.sendMsg(key, val);
	}
	*mdCC{|key,val|
		var chan;
		chan=0;
		~lpMn.control(chan, key, val); //Track Selection But 1 cc=104
	}
	*mdNtOn{|key,val|
		var chan;
		chan=0;
		~lpMn.noteOn(chan,key,val);
	}
	/*
	IFRoot.makeOSCResponders;
	IFRoot.cc(\durMulSeq1,0);
	*/
	*cc{|key,vel|
		var val;val=vel/127;
		key.switch(
			\durPatSeq1, {
				case
				{val>=1} {~stepNum1.source=Pshuf([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);}
				{val==0} {
					~stepNum1.source  =  Pseq([
						1,2,3,4,5,6,7,8,
						1,2,3,4,5,6,7,8,
						1,2,3,4,5,6,7,8,
						9,10,11,12,13,14,15,16
					], inf);
				};
				this.mdNtOn(~lpMnButV1,val);
				this.lbl(\TOdurPatSeq1,val);
			},
			\durMulSeq1, {
				case
				{val>=1} {~durMul.source=Pseq([1/4], inf);}
				{val==0} {~durMul.source=Pseq([1/2], inf);};
				this.mdNtOn(~lpMnButV2,val);
				this.lbl(\TOdurMulSeq1,val);
			},
			\durPatSeq2, {
				case
				{val>=1} {~stepNum2.source=Pshuf([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);}
				{val==0} {
					~stepNum2.source  =  Pseq([
						1,2,3,4,5,6,7,8,
						1,2,3,4,5,6,7,8,
						1,2,3,4,5,6,7,8,
						9,10,11,12,13,14,15,16
					], inf);
				};
				this.mdNtOn(~lpMnButV3,val);
				this.lbl(\TOdurPatSeq2,val);
			},
			\durMulSeq2, {
				case
				{val>=1} {~durMul2.source=Pseq([1/8], inf);}
				{val==0} {~durMul2.source=Pseq([1/4], inf);};
				this.mdNtOn(~lpMnButV4,val);
				this.lbl(\TOdurMulSeq2,val);
			},
			\durPatSeq3, {
				case
				{val>=1} {~stepNum3.source=Pshuf([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);}
				{val==0} {
					~stepNum3.source  =  Pseq([
						1,2,3,4,5,6,7,8,
						1,2,3,4,5,6,7,8,
						1,2,3,4,5,6,7,8,
						9,10,11,12,13,14,15,16
					], inf);
				};
				this.mdNtOn(~lpMnButV5,val);
				this.lbl(\TOdurPatSeq3,val);
			},
			\durMulSeq3, {
				case
				{val>=1} {~durMul3.source=Pseq([1/8], inf);}
				{val==0} {~durMul3.source=Pseq([1/4], inf);};
				this.mdNtOn(~lpMnButV6,val);
				this.lbl(\TOdurMulSeq3,val);
			},
			\durPatSeq4, {
				case
				{val>=1} {~stepNum4.source  =  Pshuf([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16], inf);}
				{val==0} {
					~stepNum4.source  =  Pseq([
						1,2,3,4,5,6,7,8,
						1,2,3,4,5,6,7,8,
						1,2,3,4,5,6,7,8,
						9,10,11,12,13,14,15,16

					], inf);
				};
				this.mdNtOn(~lpMnButV7,val);
				this.lbl(\TOdurPatSeq4,val);
			},
			\durMulSeq4, {
				case
				{val>=1} {~durMul4.source=Pseq([1/8], inf);}
				{val==0} {~durMul4.source=Pseq([1/4], inf);};
				this.mdNtOn(~lpMnButV8,val);
				this.lbl(\TOdurMulSeq4,val);
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
				'durPatSeq1_T',{ this.cc(\durPatSeq1,vel);},
				'durPatSeq2_T',{ this.cc(\durPatSeq2,vel);},
				'durPatSeq3_T',{ this.cc(\durPatSeq3,vel);},
				'durPatSeq4_T',{ this.cc(\durPatSeq4,vel);},
				'durMulSeq1_T',{ this.cc(\durMulSeq1,vel);},
				'durMulSeq2_T',{ this.cc(\durMulSeq2,vel);},
				'durMulSeq3_T',{ this.cc(\durMulSeq3,vel);},
				'durMulSeq4_T',{ this.cc(\durMulSeq4,vel);},
			)
		},path:oscName);
	}
	*makeOSCResponders{
		this.oscResp(respName:\durPatSeq1Resp, oscName:\TOdurPatSeq1, playTag:'durPatSeq1_T');
		this.oscResp(respName:\durPatSeq2Resp, oscName:\TOdurPatSeq2, playTag:'durPatSeq2_T');
		this.oscResp(respName:\durPatSeq3Resp, oscName:\TOdurPatSeq3, playTag:'durPatSeq3_T');
		this.oscResp(respName:\durPatSeq4Resp, oscName:\TOdurPatSeq4, playTag:'durPatSeq4_T');
		this.oscResp(respName:\durMulSeq1Resp, oscName:\TOdurMulSeq1, playTag:'durMulSeq1_T');
		this.oscResp(respName:\durMulSeq2Resp, oscName:\TOdurMulSeq2, playTag:'durMulSeq2_T');
		this.oscResp(respName:\durMulSeq3Resp, oscName:\TOdurMulSeq3, playTag:'durMulSeq3_T');
		this.oscResp(respName:\durMulSeq4Resp, oscName:\TOdurMulSeq4, playTag:'durMulSeq4_T');

	}
	*responders{
		~rootBut00.free;
		~rootBut00= OSCFunc({
			arg msg,val;
			val=msg[1];
			if ( msg[1]==1, {IFRoot.set00;});
		},'/rootSet00');
		~rootBut01.free;
		~rootBut01= OSCFunc({
			arg msg,val;
			val=msg[1];
			if ( msg[1]==1, {IFRoot.set01;});
		},'/rootSet01');
		~rootBut02.free;
		~rootBut02= OSCFunc({
			arg msg,val;
			val=msg[1];
			if ( msg[1]==1, {IFRoot.set02;});
		},'/rootSet02');
		~rootBut03.free;
		~rootBut03= OSCFunc({
			arg msg,val;
			val=msg[1];
			if ( msg[1]==1, {IFRoot.set03;});
		},'/rootSet03');
		~rootBut04.free;
		~rootBut04= OSCFunc({
			arg msg,val;
			val=msg[1];
			if ( msg[1]==1, {IFRoot.set04;});
		},'/rootSet04');
		~rootBut05.free;
		~rootBut05= OSCFunc({
			arg msg,val;
			val=msg[1];
			if ( msg[1]==1, {IFRoot.set05;});
		},'/rootSet05');
	}
	*butLeds{|index|
		index.switch(
			0,{
				~tOSCAdrr.sendMsg('rootSet00', 1);
				~tOSCAdrr.sendMsg('rootSet01', 0);
				~tOSCAdrr.sendMsg('rootSet02', 0);
				~tOSCAdrr.sendMsg('rootSet03', 0);
				~tOSCAdrr.sendMsg('rootSet04', 0);
				~tOSCAdrr.sendMsg('rootSet05', 0);
			},
			1,{
				~tOSCAdrr.sendMsg('rootSet00', 0);
				~tOSCAdrr.sendMsg('rootSet01', 1);
				~tOSCAdrr.sendMsg('rootSet02', 0);
				~tOSCAdrr.sendMsg('rootSet03', 0);
				~tOSCAdrr.sendMsg('rootSet04', 0);
				~tOSCAdrr.sendMsg('rootSet05', 0);
			},
			2,{
				~tOSCAdrr.sendMsg('rootSet00', 0);
				~tOSCAdrr.sendMsg('rootSet01', 0);
				~tOSCAdrr.sendMsg('rootSet02', 1);
				~tOSCAdrr.sendMsg('rootSet03', 0);
				~tOSCAdrr.sendMsg('rootSet04', 0);
				~tOSCAdrr.sendMsg('rootSet05', 0);
			},
			3,{
				~tOSCAdrr.sendMsg('rootSet00', 0);
				~tOSCAdrr.sendMsg('rootSet01', 0);
				~tOSCAdrr.sendMsg('rootSet02', 0);
				~tOSCAdrr.sendMsg('rootSet03', 1);
				~tOSCAdrr.sendMsg('rootSet04', 0);
				~tOSCAdrr.sendMsg('rootSet05', 0);
			},
			4,{
				~tOSCAdrr.sendMsg('rootSet00', 0);
				~tOSCAdrr.sendMsg('rootSet01', 0);
				~tOSCAdrr.sendMsg('rootSet02', 0);
				~tOSCAdrr.sendMsg('rootSet03', 0);
				~tOSCAdrr.sendMsg('rootSet04', 1);
				~tOSCAdrr.sendMsg('rootSet05', 0);
			},
			5,{
				~tOSCAdrr.sendMsg('rootSet00', 0);
				~tOSCAdrr.sendMsg('rootSet01', 0);
				~tOSCAdrr.sendMsg('rootSet02', 0);
				~tOSCAdrr.sendMsg('rootSet03', 0);
				~tOSCAdrr.sendMsg('rootSet04', 0);
				~tOSCAdrr.sendMsg('rootSet05', 1);
			},
		)

	}
}

/*
*set00{
"IFRoot Player 00".postln;
~ifPlayerSeq01.source={

inf.do{
1.do {


IFSequence.step(~stepNum1P.next);
//IFCounter.step(~stepNumCntP.next);
//~local.sendMsg('seqRec', 1);
//IFVKick(~tmMulVKickP.next*~tmVKickP.next);
IFKick(~tmMulKickP.next*~tmKickP.next);
IFSnr(~tmMulSnrP.next*~tmSnrP.next);
IFHat(~tmMulHatP.next*~tmHatP.next);

IFBass(~tmMulBassP.next*~tmBassP.next);
IFKeys(~tmMulKeysP.next*~tmKeysP.next);
IFSamp(~tmMulSampP.next*~tmSampP.next);

IFMast(~tmMulMastP.next*~tmMastP.next);

IFRes(~tmResP.next);

//~vBeatsLate=Tempo.bpm*(1/267.91897);
//Ableton.tap4;


((~durP.next)*(~durMulP.next)).wait;
};
};

};

}

*/