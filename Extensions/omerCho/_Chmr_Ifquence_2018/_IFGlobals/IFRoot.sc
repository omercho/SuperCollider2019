/*

PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;

*/
IFRoot {
	*load{this.globals;this.loadProxy}
	*globals{

		~ifRootPlayer=TaskProxy.new;
		~ifPlayer_Mel2=TaskProxy.new;
		~ifPlayer_Mel3=TaskProxy.new;
		~ifPlayer_Mel4=TaskProxy.new;
		~ifCountPlayer1=TaskProxy.new;
		this.responders;

	}
	*loadProxy {
		~dur = PatternProxy( Pseq([2],inf) );
		~durP= Pseq([~dur], inf).asStream;
		~durMul = PatternProxy( Pseq([2], inf));
		~durMulP= Pseq([~durMul], inf).asStream;

		~dur2 = PatternProxy( Pseq([2],inf) );
		~dur2P= Pseq([~dur2], inf).asStream;
		~durMul2 = PatternProxy( Pseq([1/4], inf));
		~durMul2P= Pseq([~durMul2], inf).asStream;

		~dur3 = PatternProxy( Pseq([2],inf) );
		~dur3P= Pseq([~dur3], inf).asStream;
		~durMul3 = PatternProxy( Pseq([1/2], inf));
		~durMul3P= Pseq([~durMul3], inf).asStream;

		~dur4 = PatternProxy( Pseq([2],inf) );
		~dur4P= Pseq([~dur4], inf).asStream;
		~durMul4 = PatternProxy( Pseq([1/4], inf));
		~durMul4P= Pseq([~durMul4], inf).asStream;

		~durCnt1 = PatternProxy( Pseq([2],inf) );
		~durCnt1P= Pseq([~durCnt1], inf).asStream;
		~durCntMul1 = PatternProxy( Pseq([1/4], inf));
		~durCntMul1P= Pseq([~durCntMul1], inf).asStream;
	}

	*play{
		IFCounter.getClockNow;
		IFCounter.getClockStart;
		~ifRootPlayer.play(TempoClock.default, quant: 0);
		~ifPlayer_Mel2.play(TempoClock.default, quant: 0);
		~ifPlayer_Mel3.play(TempoClock.default, quant: 0);
		~ifPlayer_Mel4.play(TempoClock.default, quant: 0);
		~ifCountPlayer1.play(TempoClock.default, quant: 0);

	}
	/*
	*play{~ifRootPlayer.play(MIDISyncClock, quant: 0);}
	*/
	*stop{
		IFCounter.reset;
		~ifRootPlayer.stop;
		~ifPlayer_Mel2.stop;
		~ifPlayer_Mel3.stop;
		~ifPlayer_Mel4.stop;
		~ifCountPlayer1.stop;
	}


	*set00{
		"IFRoot set00".postln;
		IFRoot.butLeds(0);
		~ifRootPlayer.source={
			//~cntApcUpdate=0;
			inf.do{
				1.do {
					IFSequence.step(~stepNumP.next);
					IFStat.ln01;IFStat.ln02;IFStat.ln03;IFStat.ln04;
					IFStat.ln05;IFStat.ln06;//IFStat.ln07;IFStat.ln08;
					/*~cntApcUpdate = ~cntApcUpdate + 1;
					~cntApcUpdate.switch(
					0,{},
					16,{
					IFAPCMn.update;
					~cntApcUpdate=0;
					}
					);*/
					((~durP.next)*(~durMulP.next)).wait;
				};
			};

		};
		~ifPlayer_Mel2.source={
			//~cntPlayerMel2=0;
			inf.do{
				1.do {
					IFSequence.step2(~stepNum2P.next);
					IFKick(~tmMulKickP.next*~tmKickP.next);
					IFSnr(~tmMulSnrP.next*~tmSnrP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFHat.hat2(~tmMul2HatP.next*~tm2HatP.next);
					/*~cntPlayerMel2 = ~cntPlayerMel2 + 1;
					~cntPlayerMel2.switch(
					0,{},
					16,{
					IFAPCMn.update;
					~cntPlayerMel2=0;
					}
					);*/
					((~dur2P.next)*(~durMul2P.next)).wait;
				};
			};
		};
		~ifPlayer_Mel3.source={
			//~cntPlayerMel3=0;
			inf.do{
				1.do {


					IFSequence.step3(~stepNum3P.next);
					IFBass(~tmMulBassP.next*~tmBassP.next);
					IFKeys(~tmMulKeysP.next*~tmKeysP.next);
					/*~cntPlayerMel3 = ~cntPlayerMel3 + 1;
					~cntPlayerMel3.switch(
					0,{},
					16,{
					IFAPCMn.update;
					~cntPlayerMel3=0;
					}
					);*/
					((~dur3P.next)*(~durMul3P.next)).wait;
				};
			};
		};
		~ifPlayer_Mel4.source={
			//~cntPlayerMel4=0;
			inf.do{
				1.do {
					IFSequence.step4(~stepNum4P.next);
					IFSamp(~tmMulSampP.next*~tmSampP.next);
					IFMopho(~tmMulMophoP.next*~tmMophoP.next);
					/*~cntPlayerMel4 = ~cntPlayerMel4 + 1;
					~cntPlayerMel4.switch(
					0,{},
					16,{
					IFAPCMn.update;
					~cntPlayerMel4=0;
					}
					);*/
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
		~ifRootPlayer.source={

			inf.do{
				1.do {


					IFSequence.step(~stepNumP.next);
					IFStat.ln01;IFStat.ln02;IFStat.ln03;
					IFKick(~tmMulKickP.next*~tmKickP.next);
					IFSnr(~tmMulSnrP.next*~tmSnrP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);

					IFBass(~tmMulBassP.next*~tmBassP.next);
					IFKeys(~tmMulKeysP.next*~tmKeysP.next);
					IFSamp(~tmMulSampP.next*~tmSampP.next);

					IFMopho(~tmMulMophoP.next*~tmMophoP.next);
					//IFMast(~tmMulMastP.next*~tmMastP.next);

					//IFRes(~tmResP.next);

					((~durP.next)*(~durMulP.next)).wait;

				};
			};

		};

	}

	*set02{
		"IFRoot set02".postln;
		IFRoot.butLeds(2);
		~ifRootPlayer.source={

			inf.do{
				1.do {


					IFSequence.step(~stepNumP.next);
					IFStat.ln01;IFStat.ln02;IFStat.ln03;
					IFMopho(~tmMulMophoP.next*~tmMophoP.next);
					IFKick(~tmMulKickP.next*~tmKickP.next);
					IFSnr(~tmMulSnrP.next*~tmSnrP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFSamp(~tmMulSampP.next*~tmSampP.next);
					((~durP.next)*(~durMulP.next)).wait;
					IFSequence.step(~stepNumP.next);
					IFStat.ln01;IFStat.ln02;IFStat.ln03;
					IFBass(~tmMulBassP.next*~tmBassP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFSnr(~tmMulSnrP.next*~tmSnrP.next);
					IFKeys(~tmMulKeysP.next*~tmKeysP.next);
					IFSamp(~tmMulSampP.next*~tmSampP.next);
					((~durP.next)*(~durMulP.next)).wait;
					IFStat.ln01;IFStat.ln02;IFStat.ln03;
					IFSequence.step(~stepNumP.next);
					IFKick(~tmMulKickP.next*~tmKickP.next);
					IFKeys(~tmMulKeysP.next*~tmKeysP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFSamp(~tmMulSampP.next*~tmSampP.next);
					IFMopho(~tmMulMophoP.next*~tmMophoP.next);
					((~durP.next)*(~durMulP.next)).wait;
				};
			};

		};

	}

	*set03{
		"IFRoot set03".postln;
		IFRoot.butLeds(3);
		~ifRootPlayer.source={

			inf.do{
				1.do {


					IFSequence.step(~stepNumP.next);
					IFStat.ln01;IFStat.ln02;IFStat.ln03;
					IFKick(~tmMulKickP.next*~tmKickP.next);
					IFSnr(~tmMulSnrP.next*~tmSnrP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFSamp(~tmMulSampP.next*~tmSampP.next);
					IFMopho(~tmMulMophoP.next*~tmMophoP.next);
					((~durP.next)*(~durMulP.next)).wait;
					IFStat.ln01;IFStat.ln02;IFStat.ln03;
					IFSequence.step(~stepNumP.next);
					IFBass(~tmMulBassP.next*~tmBassP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFSnr(~tmMulSnrP.next*~tmSnrP.next);
					((~durP.next)*(~durMulP.next)).wait;
					IFStat.ln01;IFStat.ln02;IFStat.ln03;
					IFSequence.step(~stepNumP.next);
					IFKick(~tmMulKickP.next*~tmKickP.next);
					IFKeys(~tmMulKeysP.next*~tmKeysP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFSamp(~tmMulSampP.next*~tmSampP.next);
					IFMopho(~tmMulMophoP.next*~tmMophoP.next);
					((~durP.next)*(~durMulP.next)).wait;
					IFStat.ln01;IFStat.ln02;IFStat.ln03;
					IFSequence.step(~stepNumP.next);
					IFKeys(~tmMulKeysP.next*~tmKeysP.next);
					IFSnr(~tmMulSnrP.next*~tmSnrP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					((~durP.next)*(~durMulP.next)).wait;
				};
			};

		};

	}


	*set04{
		"IFRoot set04".postln;
		IFRoot.butLeds(4);
		~ifRootPlayer.source={

			inf.do{
				1.do {


					IFSequence.step(~stepNumP.next);
					IFStat.ln01;IFStat.ln02;IFStat.ln03;
					//IFMast(~tmMulMastP.next*~tmMastP.next);
					//IFRes(~tmResP.next);
					//IFVKick(~tmMulVKickP.next*~tmVKickP.next);
					IFKick(~tmMulKickP.next*~tmKickP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFSamp(~tmMulSampP.next*~tmSampP.next);
					((~durP.next)*(~durMulP.next)).wait;
					IFSequence.step(~stepNumP.next);
					IFStat.ln01;IFStat.ln02;IFStat.ln03;
					IFBass(~tmMulBassP.next*~tmBassP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFSnr(~tmMulSnrP.next*~tmSnrP.next);
					IFMopho(~tmMulMophoP.next*~tmMophoP.next);
					((~durP.next)*(~durMulP.next)).wait;
					IFSequence.step(~stepNumP.next);
					IFStat.ln01;IFStat.ln02;IFStat.ln03;
					IFKick(~tmMulKickP.next*~tmKickP.next);
					IFKeys(~tmMulKeysP.next*~tmKeysP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFSamp(~tmMulSampP.next*~tmSampP.next);
					((~durP.next)*(~durMulP.next)).wait;
					IFSequence.step(~stepNumP.next);
					IFStat.ln01;IFStat.ln02;IFStat.ln03;
					IFBass(~tmMulBassP.next*~tmBassP.next);
					IFKeys(~tmMulKeysP.next*~tmKeysP.next);
					IFSnr(~tmMulSnrP.next*~tmSnrP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					((~durP.next)*(~durMulP.next)).wait;
				};
			};

		};

	}
	*set05{
		"IFRoot set05".postln;
		IFRoot.butLeds(5);
		~ifRootPlayer.source={

			inf.do{
				1.do {


					IFSequence.step(~stepNumP.next);
					IFStat.ln01;IFStat.ln02;IFStat.ln03;
					//IFMast(~tmMulMastP.next*~tmMastP.next);
					//IFRes(~tmResP.next);
					//IFVKick(~tmMulVKickP.next*~tmVKickP.next);
					IFKick(~tmMulKickP.next*~tmKickP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFBass(~tmMulBassP.next*~tmBassP.next);
					IFMopho(~tmMulMophoP.next*~tmMophoP.next);
					((~durP.next)*(~durMulP.next)).wait;
					IFSequence.step(~stepNumP.next);
					IFStat.ln01;IFStat.ln02;IFStat.ln03;
					IFBass(~tmMulBassP.next*~tmBassP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFSnr(~tmMulSnrP.next*~tmSnrP.next);
					IFMopho(~tmMulMophoP.next*~tmMophoP.next);
					((~durP.next)*(~durMulP.next)).wait;
					IFSequence.step(~stepNumP.next);
					IFStat.ln01;IFStat.ln02;IFStat.ln03;
					IFKick(~tmMulKickP.next*~tmKickP.next);
					IFKeys(~tmMulKeysP.next*~tmKeysP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					IFBass(~tmMulBassP.next*~tmBassP.next);
					IFSamp(~tmMulSampP.next*~tmSampP.next);
					((~durP.next)*(~durMulP.next)).wait;
					IFSequence.step(~stepNumP.next);
					IFStat.ln01;IFStat.ln02;IFStat.ln03;
					IFKick(~tmMulKickP.next*~tmKickP.next);
					IFKeys(~tmMulKeysP.next*~tmKeysP.next);
					IFSamp(~tmMulSampP.next*~tmSampP.next);
					IFHat(~tmMulHatP.next*~tmHatP.next);
					((~durP.next)*(~durMulP.next)).wait;
				};
			};

		};

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

}

/*
*set00{
"IFRoot Player 00".postln;
~ifRootPlayer.source={

inf.do{
1.do {


IFSequence.step(~stepNumP.next);
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