/*

PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;

Mopho.cc(\tempo,tmp);

*/

IFTrack01 {
	*loadAtStart{
		~trackCase=1;
		IFLpMn.tsLeds(1,0,0,0,0,0,0,0);
		IFRoot.set00;
		this.setGlb01;
		this.setActs;
		//this.lpMnParts;
		~shiftPartsBut.free;
		~shiftPartsBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				IFTrack01.sixteen;
			},{
				IFSixteen.defaults;
			});
		},
		'/shiftParts'
		);
	}

	*setActs{
		IFAPCMn.actLine1(0,0,0,0,0);
		IFAPCMn.actLine2(0,0,0,0,0);
		IFAPCMn.actLine3(1,0,0,0,0);
		IFAPCMn.actLine4(0,0,0,0,0);
		IFAPCMn.actLine5(1,0,0,0,0);
		IFAPCMn.actLine6(1,0,0,0,0);
		IFAPCMn.actLine7(0,0,0,0,0);
		IFAPCMn.actLine8(0,0,0,0,0);

		IFMIDIMix.act1(0,0,0);
		IFMIDIMix.act2(0,0,0);
		IFMIDIMix.act3(0,0,0);
		IFMIDIMix.act4(0,0,0);
		IFMIDIMix.act5(0,0,0);
		IFMIDIMix.act6(0,0,0);
		IFMIDIMix.act7(0,0,0);
		IFMIDIMix.act8(0,0,0);

	}//setActs
	*setGlb01{
		"Preset: Trk01".postln;
		~tOSCAdrr.sendMsg('presetLabel','Prst Trk01');
		"TRACK 1".postln;
		~tOSCAdrr.sendMsg('trackLabel','TRACK 1');
		IFPitch.setScl(scl1:0,scl2:17, root:4);
		//~tOSCAdrr.sendMsg('scaleLabel', 'humayun');
		IFPitch.pat(4,0,2,3, 4,0,2,1);
		//~ifPitchPat.source=Pseq([0,-1,14,-3], inf);

		IFProjectGlobals.setTempo(108);
		~tOSCAdrr.sendMsg('tempoLabel', ~tmp1);
		~tOSCAdrr.sendMsg('tempoFader', ~tmp1);
		~nt=(0);

		"Duration Pattern: Straight".postln;
		IFSeqDurPat.stGrp(3);
		~local.sendMsg('durResponder',1);
		~tOSCAdrr.sendMsg('durLabel', 'Straight');

		"Duration Mul: 1/2".postln;
		~tOSCAdrr.sendMsg('durMulLabel', '1/2');
		~durMul.source = Pseq([1/2], inf);

		"STORED GLOBAL SETTINGS:".postln;
		~local.sendMsg('harm0',1);
		~local.sendMsg('cutMel1',0.5, 0.4);
		~local.sendMsg('melFader1',0.2);
		~local.sendMsg('cutMel2',0.2, 0.25);
		~local.sendMsg('melFader2',0.2);
		~local.sendMsg('cutMel3',0.4, 0.1);
		~local.sendMsg('melFader3',0.2);
		~local.sendMsg('susMel',0.3);


		~local.sendMsg('cutDrum',0.2, 0.3);
		~local.sendMsg('susDrum',0.3);
		~local.sendMsg('snrXPose',0.3);//SnrXpose
		~local.sendMsg('fxFader',0.3);
		~local.sendMsg('fxComp',0.6);
		~local.sendMsg('fxDecay',0.3);
		~local.sendMsg('AllMasterFXxy1',0.6,0.1);


		"Ext Set".postln;
		~local.sendMsg('volExt',0.8);
		~local.sendMsg('susExt',0.2);
		~local.sendMsg('rlsExt',0.2);
		~local.sendMsg('extSends',0.2,0.3);

		//this.part1;
	}//track 01 End

	*part01{//////                                      - 1 -
		//IFTrack01.setActs;
		"Track:01 - Part:01".postln;
		~tOSCAdrr.sendMsg('partLabel', 'T1prt01');
		//CH -1- [ Static Drums ]
		IFSeqSteps.long01;
		IFSeqVKick.stGrpSet  (1,0,1,0, 1,0,1,0,  1,0,1,0, 1,0,1,0);
		~ntVKick.source=Pseq([0,0,0,0, 0,0,0,0, 0,0,0,0, 0,0,0,0], inf);
		~susVKick.source=0.1;
		IFSeqVSnr.stGrpSet  (0,0,1,0, 0,0,1,0,  0,0,1,0, 0,0,1,0);
		~octVSnr=0;~ntVSnr.source = Pseq([20], inf);
		IFSeqVHat.stGrpSet  (0,1,0,1, 0,1,0,1,  0,1,0,1, 0,1,0,1);
		~octVHat=0;~ntVHat.source = Pseq([124], inf);
		IFSeqVClap.stGrpSet  (0,0,0,0, 0,1,0,0,  0,0,0,0, 0,1,0,0);
		~octVClap=0;~ntVClap.source = Pseq([39], inf);
		IFSeqVTomL.stGrpSet  (0,0,0,1, 1,0,0,0,  1,0,0,0, 0,0,0,0);
		~octVTomL=0;~ntVTomL.source =  Pseq([29], inf);
		IFSeqVTomH.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,1,1, 0,0,0,0);
		~octVTomH=0;~ntVTomH.source = Pseq([37], inf);

		~local.sendMsg('susMel',0.2);

		//CH -1- [ Kick ]
		IFSeqKick.stGrpSet    (0,0,0,1, 0,0,0,1,  0,0,0,1, 0,1,0,1);
		IFSeqOctKick.stGrpSet  (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtKick.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelKick.stGrpSet (3,1,3,3, 3,2,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqSusKick.stGrpSet (2,2,3,2, 0,2,0,2,  0,2,0,2, 0,2,0,2);
		IFSeqTmKick.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKick.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.setKick        (0,2,0,3, 0,2,0,1,  1,2,3,4, 6,7,8,9);
		IFGlobal.setKick(vol:0.89,octMul:1,susMul:0.5,dec:0.2,dly:0.1,pan:0.1,sndX:0,sndY:0.0);

		//CH -1- [ Snare ]
		IFSeqSnr.stGrpSet     (0,1,0,0, 0,1,0,0,  0,1,0,0, 0,1,0,0);
		IFSeqOctSnr.stGrpSet  (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtSnr.stGrpSet   (4,0,2,3, 4,0,2,3,  0,1,4,3, 0,4,2,3);
		IFSeqVelSnr.stGrpSet  (1,2,3,3, 1,2,3,3,  1,2,3,3, 1,2,1,3);
		IFSeqSusSnr.stGrpSet  (1,2,1,3, 1,2,3,3,  1,2,2,3, 1,2,1,3);
		IFSeqTmSnr.stGrpSet   (1,1,1,1, 1,2,1,1,  1,1,1,1, 1,1,2,1);
		IFShuf.setSnr         (0,2,0,3, 0,2,0,1,  1,2,3,4, 6,7,8,9);
		IFGlobal.setSnr(vol:0.89,octMul:1,susMul:0.5,dec:0.2,dly:0.1,pan:0.1,sndX:0.2,sndY:0.1);

		//CH -2- [ HAT ]
		IFSeqHat.stGrpSet     (1,0,1,1, 1,0,1,1,  1,0,1,1, 0,1,1,0);
		IFSeqOctHat.stGrpSet  (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtHat.stGrp      (4,0,2,3, 4,0,2,3,  0,1,4,3, 0,4,2,3);
		IFSeqVelHat.stGrpSet  (1,3,3,1, 1,3,3,1,  1,3,3,2, 3,2,3,0);
		IFSeqSusHat.stGrpSet  (3,1,2,1, 3,1,2,1,  3,1,2,1, 3,2,3,1);
		IFSeqTmHat.stGrp      (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurHat.stGrp     (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.setHat         (0,1,0,3, 0,2,0,1,  1,2,3,4, 6,7,8,9);
		IFGlobal.setHat(vol:0.89,octMul:1,susMul:0.5,dec:0.2,dly:0.1,pan:0.1,sndX:0.1,sndY:0.1);

		//CH -4- [Bass]
		IFSeqBass.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctBass.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtBass.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelBass.stGrpSet (3,2,3,1, 3,2,3,1,  3,2,3,1, 3,2,3,1);
		IFSeqSusBass.stGrpSet (3,1,2,1, 3,1,2,1,  3,1,2,1, 3,2,2,3);
		IFSeqTmBass.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurBass.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.setBass        (0,-1,0,3, 0,-2,0,1,  -1,0,1,0, 0,-2,1,0);
		IFLfo.setBass(10,10,20,30,40,50,80,120,  110,90,80,60,50,20,10);
		IFGlobal.setBass(
			vol:0.89,att:0.01,dec:0.2,sus:0.1,rls:0.3,pan:0.1,sndX:0,sndY:0.1,
			octMul:1,susMul:0.3,xy1X:0.2,xy1Y:0.3,xy2X:0.2,xy2Y:0.3,lfo1:0.0,lfo2:0
		);
		//CH -5- [Keys]
		IFSeqKeys.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctKeys.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtKeys.stGrpSet  ([0,4],[2,6],0,0, [0,2],0,0,0,  [0,4],0,0,0, [2,0],0,0,0);
		IFSeqVelKeys.stGrpSet (3,2,3,2, 3,2,3,3,  3,1,3,2, 3,2,3,2);
		IFSeqSusKeys.stGrpSet (4,2,3,2, 4,2,3,2,  4,2,3,2, 4,2,3,2);
		IFSeqTmKeys.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKeys.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.setKeys        (0,-1,0,3, 0,-2,0,1,  -1,0,1,0, 0,-2,1,0);
		IFLfo.setKeys(110,120,120,30,120,50,80,120,  110,90,80,100,120,127,100);
		IFGlobal.setKeys(
			vol:0.99,att:0.1,dec:0.9,sus:0.9,rls:0.3,pan:0.1,sndX:0.2,sndY:0.6,
			octMul:1,susMul:0.99,xy1X:0.2,xy1Y:0.3,xy2X:0.2,xy2Y:0.3,lfo1:0.9,lfo2:0.4
		);

		//CH -6- [Mopho]
		IFSeqMopho.stGrpSet    (1,0,1,1, 1,0,1,1,  1,0,1,0, 0,1,1,0);
		IFSeqOctMopho.stGrpSet (4,3,4,3, 3,4,3,4,  4,3,4,3, 4,4,3,3);
		IFSeqNtMopho.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
		IFSeqVelMopho.stGrpSet (3,3,1,3, 3,2,1,3,  3,3,1,3, 3,2,1,1);
		IFSeqSusMopho.stGrpSet (1,0,1,2, 4,0,2,1,  3,2,1,1, 1,3,3,4);
		IFSeqTmMopho.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,2,1, 1,1,1,1);
		IFSeqDurMopho.stGrpSet (4,4,4,3, 4,4,4,4,  4,4,3,4, 4,4,4,4);
		IFShuf.setMopho        (0,-1,0,3, 0,-2,0,1,  -1,0,1,0, 0,-2,1,0);
		IFLfo.setMopho (10,10,20,30,40,50,80,120,  110,90,80,60,50,20,10);
		IFGlobal.setMopho(
			vol:0.89,att:0.01,dec:0.2,sus:0.5,rls:0.3,pan:0.1,sndX:0,sndY:0.1,
			octMul:2,susMul:0.5,xy1X:0.2,xy1Y:0.3,xy2X:0.2,xy2Y:0.3,lfo1:0.0,lfo2:0
		);

		//CH -7- [SAMP]
		IFSeqSamp.stGrpSet    (1,1,0,1, 0,1,1,0,  1,1,0,1, 1,0,1,0);
		IFSeqOctSamp.stGrpSet (3,3,3,4, 3,3,4,3,  3,3,3,4, 3,3,4,3);
		IFSeqNtSamp.stGrpSet  (0,1,2,3, 4,5,6,7,  8,7,6,5, 4,3,2,1);
		IFSeqVelSamp.stGrpSet (1,3,1,3, 2,2,2,3,  2,3,1,3, 2,3,2,3);
		IFSeqSusSamp.stGrpSet (5,2,5,0, 3,2,4,5,  3,1,1,2, 4,1,4,1);
		IFSeqTmSamp.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSamp.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.setSamp        (0,2,0,3, 0,2,0,1,  1,2,3,4, 6,7,8,9);
		IFLfo.setSamp (10,10,20,30,40,50,80,120,  110,90,80,60,50,20,10);
		IFGlobal.setSamp(
			vol:0.89,att:0.1,dec:0.2,sus:0.1,rls:0.3,pan:0.1,sndX:0,sndY:0.1,
			octMul:1,susMul:0.2,xy1X:0.2,xy1Y:0.3,xy2X:0.2,xy2Y:0.3,lfo1:0.0,lfo2:0
		);
		//CH- -8- [Ext]
		~local.sendMsg('volExt',0.8);
		~local.sendMsg('susExt',0.2);
		~local.sendMsg('rlsExt',0.2);
		~local.sendMsg('extSends',0.2,0.3);

	}//////                                             - 1 -

	*part02{//////                                      - 2 -
		IFPitch.pat(0,0,0,-1);
	}//////                                             - 2 -
	*part03{//////                                      - 3 -

	}//////                                             - 3 -
	*part04{//////                                      - 5 -

	}//////                                             - 4 -
	*part05{//////                                      - 5 -

	}//////                                             - 5 -
	*part06{//////                                      - 6 -

	}//////                                             - 6 -
	*part07{//////                                      - 7 -
		"Trck1_Prt7_RNDM".postln;
		~tOSCAdrr.sendMsg('partLabel', 'Trck1_Prt7_RNDM');

		IFGlobal.set(
			nt1:~tGlbPPat[0],nt2:~tGlbPPat[1],nt3:~tGlbPPat[2],nt4:~tGlbPPat[3],
			nt5:~tGlbPPat[4],nt6:~tGlbPPat[5],nt7:~tGlbPPat[6],nt8:~tGlbPPat[7],
			tmp:~tGlb[0],scl1:~tGlb[1],scl2:~tGlb[2],root:~tGlb[3],step:~tGlb[4]
		);
		//Static Drum
		IFSeqVKick.stGrpSet  (
			~tStKc[0],~tStKc[1],~tStKc[2],~tStKc[3],
			~tStKc[4],~tStKc[5],~tStKc[6],~tStKc[7],
			~tStKc[8],~tStKc[9],~tStKc[10],~tStKc[11],
			~tStKc[12],~tStKc[13],~tStKc[14],~tStKc[15],
		);
		~ntVKick.source = Pseq([
			~tStKcN[0],~tStKcN[1],~tStKcN[2],~tStKcN[3],
			~tStKcN[4],~tStKcN[5],~tStKcN[6],~tStKcN[7],
			~tStKcN[8],~tStKcN[9],~tStKcN[10],~tStKcN[11],
			~tStKcN[12],~tStKcN[13],~tStKcN[14],~tStKcN[15],
		], inf);
		IFSeqVSnr.stGrpSet  (
			~tStSn[0],~tStSn[1],~tStSn[2],~tStSn[3],
			~tStSn[4],~tStSn[5],~tStSn[6],~tStSn[7],
			~tStSn[8],~tStSn[9],~tStSn[10],~tStSn[11],
			~tStSn[12],~tStSn[13],~tStSn[14],~tStSn[15],
		);
		~ntVSnr.source = Pseq([
			~tStSnN[0],~tStSnN[1],~tStSnN[2],~tStSnN[3],
			~tStSnN[4],~tStSnN[5],~tStSnN[6],~tStSnN[7],
			~tStSnN[8],~tStSnN[9],~tStSnN[10],~tStSnN[11],
			~tStSnN[12],~tStSnN[13],~tStSnN[14],~tStSnN[15],
		], inf);
		IFSeqVHat.stGrpSet  (
			~tStHt[0],~tStHt[1],~tStHt[2],~tStHt[3],
			~tStHt[4],~tStHt[5],~tStHt[6],~tStHt[7],
			~tStHt[8],~tStHt[9],~tStHt[10],~tStHt[11],
			~tStHt[12],~tStHt[13],~tStHt[14],~tStHt[15],
		);
		~ntVHat.source = Pseq([
			~tStHtN[0],~tStHtN[1],~tStHtN[2],~tStHtN[3],
			~tStHtN[4],~tStHtN[5],~tStHtN[6],~tStHtN[7],
			~tStHtN[8],~tStHtN[9],~tStHtN[10],~tStHtN[11],
			~tStHtN[12],~tStHtN[13],~tStHtN[14],~tStHtN[15],
		], inf);
		IFSeqVClap.stGrpSet  (
			~tStClp[0],~tStClp[1],~tStClp[2],~tStClp[3],
			~tStClp[4],~tStClp[5],~tStClp[6],~tStClp[7],
			~tStClp[8],~tStClp[9],~tStClp[10],~tStClp[11],
			~tStClp[12],~tStClp[13],~tStClp[14],~tStClp[15],
		);
		~ntVClap.source = Pseq([
			~tStClpN[0],~tStClpN[1],~tStClpN[2],~tStClpN[3],
			~tStClpN[4],~tStClpN[5],~tStClpN[6],~tStClpN[7],
			~tStClpN[8],~tStClpN[9],~tStClpN[10],~tStClpN[11],
			~tStClpN[12],~tStClpN[13],~tStClpN[14],~tStClpN[15],
		], inf);
		IFSeqVTomL.stGrpSet  (
			~tStTom1[0],~tStTom1[1],~tStTom1[2],~tStTom1[3],
			~tStTom1[4],~tStTom1[5],~tStTom1[6],~tStTom1[7],
			~tStTom1[8],~tStTom1[9],~tStTom1[10],~tStTom1[11],
			~tStTom1[12],~tStTom1[13],~tStTom1[14],~tStTom1[15],
		);
		~ntVTomL.source = Pseq([
			~tStTom1N[0],~tStTom1N[1],~tStTom1N[2],~tStTom1N[3],
			~tStTom1N[4],~tStTom1N[5],~tStTom1N[6],~tStTom1N[7],
			~tStTom1N[8],~tStTom1N[9],~tStTom1N[10],~tStTom1N[11],
			~tStTom1N[12],~tStTom1N[13],~tStTom1N[14],~tStTom1N[15],
		], inf);
		IFSeqVTomH.stGrpSet  (
			~tStTom2[0],~tStTom2[1],~tStTom2[2],~tStTom2[3],
			~tStTom2[4],~tStTom2[5],~tStTom2[6],~tStTom2[7],
			~tStTom2[8],~tStTom2[9],~tStTom2[10],~tStTom2[11],
			~tStTom2[12],~tStTom2[13],~tStTom2[14],~tStTom2[15],
		);
		~ntVTomH.source = Pseq([
			~tStTom2N[0],~tStTom2N[1],~tStTom2N[2],~tStTom2N[3],
			~tStTom2N[4],~tStTom2N[5],~tStTom2N[6],~tStTom2N[7],
			~tStTom2N[8],~tStTom2N[9],~tStTom2N[10],~tStTom2N[11],
			~tStTom2N[12],~tStTom2N[13],~tStTom2N[14],~tStTom2N[15],
		], inf);
		//CH -1- [ Kick ]
		IFSeqKick.stGrpSet    (
			~tKcAmp[0],~tKcAmp[1],~tKcAmp[2],~tKcAmp[3],
			~tKcAmp[4],~tKcAmp[5],~tKcAmp[6],~tKcAmp[7],
			~tKcAmp[8],~tKcAmp[9],~tKcAmp[10],~tKcAmp[11],
			~tKcAmp[12],~tKcAmp[13],~tKcAmp[14],~tKcAmp[15],
		);
		IFSeqOctKick.stGrpSet  (
			~tKcOct[0],~tKcOct[1],~tKcOct[2],~tKcOct[3],
			~tKcOct[4],~tKcOct[5],~tKcOct[6],~tKcOct[7],
			~tKcOct[8],~tKcOct[9],~tKcOct[10],~tKcOct[11],
			~tKcOct[12],~tKcOct[13],~tKcOct[14],~tKcOct[15],
		);
		IFSeqNtKick.stGrpSet  (
			~tKcNt[0],~tKcNt[1],~tKcNt[2],~tKcNt[3],
			~tKcNt[4],~tKcNt[5],~tKcNt[6],~tKcNt[7],
			~tKcNt[8],~tKcNt[9],~tKcNt[10],~tKcNt[11],
			~tKcNt[12],~tKcNt[13],~tKcNt[14],~tKcNt[15],
		);
		IFSeqVelKick.stGrpSet (
			~tKcVel[0],~tKcVel[1],~tKcVel[2],~tKcVel[3],
			~tKcVel[4],~tKcVel[5],~tKcVel[6],~tKcVel[7],
			~tKcVel[8],~tKcVel[9],~tKcVel[10],~tKcVel[11],
			~tKcVel[12],~tKcVel[13],~tKcVel[14],~tKcVel[15],
		);
		IFSeqSusKick.stGrpSet (
			~tKcSus[0],~tKcSus[1],~tKcSus[2],~tKcSus[3],
			~tKcSus[4],~tKcSus[5],~tKcSus[6],~tKcSus[7],
			~tKcSus[8],~tKcSus[9],~tKcSus[10],~tKcSus[11],
			~tKcSus[12],~tKcSus[13],~tKcSus[14],~tKcSus[15],
		);
		IFSeqTmKick.stGrpSet  (
			~tKcTm[0],~tKcTm[1],~tKcTm[2],~tKcTm[3],
			~tKcTm[4],~tKcTm[5],~tKcTm[6],~tKcTm[7],
			~tKcTm[8],~tKcTm[9],~tKcTm[10],~tKcTm[11],
			~tKcTm[12],~tKcTm[13],~tKcTm[14],~tKcTm[15],
		);
		IFSeqDurKick.stGrpSet (
			~tKcDur[0],~tKcDur[1],~tKcDur[2],~tKcDur[3],
			~tKcDur[4],~tKcDur[5],~tKcDur[6],~tKcDur[7],
			~tKcDur[8],~tKcDur[9],~tKcDur[10],~tKcDur[11],
			~tKcDur[12],~tKcDur[13],~tKcDur[14],~tKcDur[15],
		);
		IFShuf.setKick    (
			~tKcShuf[0],~tKcShuf[1],~tKcShuf[2],~tKcShuf[3],
			~tKcShuf[4],~tKcShuf[5],~tKcShuf[6],~tKcShuf[7],
			~tKcShuf[8],~tKcShuf[9],~tKcShuf[10],~tKcShuf[11],
			~tKcShuf[12],~tKcShuf[13],~tKcShuf[14],~tKcShuf[15],
		);
		IFGlobal.setKick  (
			~tKcGlob[0],~tKcGlob[1],~tKcGlob[2],~tKcGlob[3],
			~tKcGlob[4],~tKcGlob[5],~tKcGlob[6],~tKcGlob[7],
			~tKcGlob[8],~tKcGlob[9],~tKcGlob[10],~tKcGlob[11],
			~tKcGlob[12],~tKcGlob[13],~tKcGlob[14],~tKcGlob[15],
		);
		//CH - [ Snr ]
		IFSeqSnr.stGrpSet    (
			~tSnAmp[0],~tSnAmp[1],~tSnAmp[2],~tSnAmp[3],
			~tSnAmp[4],~tSnAmp[5],~tSnAmp[6],~tSnAmp[7],
			~tSnAmp[8],~tSnAmp[9],~tSnAmp[10],~tSnAmp[11],
			~tSnAmp[12],~tSnAmp[13],~tSnAmp[14],~tSnAmp[15],
		);
		IFSeqOctSnr.stGrpSet  (
			~tSnOct[0],~tSnOct[1],~tSnOct[2],~tSnOct[3],
			~tSnOct[4],~tSnOct[5],~tSnOct[6],~tSnOct[7],
			~tSnOct[8],~tSnOct[9],~tSnOct[10],~tSnOct[11],
			~tSnOct[12],~tSnOct[13],~tSnOct[14],~tSnOct[15],
		);
		IFSeqNtSnr.stGrpSet  (
			~tSnNt[0],~tSnNt[1],~tSnNt[2],~tSnNt[3],
			~tSnNt[4],~tSnNt[5],~tSnNt[6],~tSnNt[7],
			~tSnNt[8],~tSnNt[9],~tSnNt[10],~tSnNt[11],
			~tSnNt[12],~tSnNt[13],~tSnNt[14],~tSnNt[15],
		);
		IFSeqVelSnr.stGrpSet (
			~tSnVel[0],~tSnVel[1],~tSnVel[2],~tSnVel[3],
			~tSnVel[4],~tSnVel[5],~tSnVel[6],~tSnVel[7],
			~tSnVel[8],~tSnVel[9],~tSnVel[10],~tSnVel[11],
			~tSnVel[12],~tSnVel[13],~tSnVel[14],~tSnVel[15],
		);
		IFSeqSusSnr.stGrpSet (
			~tSnSus[0],~tSnSus[1],~tSnSus[2],~tSnSus[3],
			~tSnSus[4],~tSnSus[5],~tSnSus[6],~tSnSus[7],
			~tSnSus[8],~tSnSus[9],~tSnSus[10],~tSnSus[11],
			~tSnSus[12],~tSnSus[13],~tSnSus[14],~tSnSus[15],
		);
		IFSeqTmSnr.stGrpSet  (
			~tSnTm[0],~tSnTm[1],~tSnTm[2],~tSnTm[3],
			~tSnTm[4],~tSnTm[5],~tSnTm[6],~tSnTm[7],
			~tSnTm[8],~tSnTm[9],~tSnTm[10],~tSnTm[11],
			~tSnTm[12],~tSnTm[13],~tSnTm[14],~tSnTm[15],
		);
		IFSeqDurSnr.stGrpSet (
			~tSnDur[0],~tSnDur[1],~tSnDur[2],~tSnDur[3],
			~tSnDur[4],~tSnDur[5],~tSnDur[6],~tSnDur[7],
			~tSnDur[8],~tSnDur[9],~tSnDur[10],~tSnDur[11],
			~tSnDur[12],~tSnDur[13],~tSnDur[14],~tSnDur[15],
		);
		IFShuf.setSnr    (
			~tSnShuf[0],~tSnShuf[1],~tSnShuf[2],~tSnShuf[3],
			~tSnShuf[4],~tSnShuf[5],~tSnShuf[6],~tSnShuf[7],
			~tSnShuf[8],~tSnShuf[9],~tSnShuf[10],~tSnShuf[11],
			~tSnShuf[12],~tSnShuf[13],~tSnShuf[14],~tSnShuf[15],
		);
		IFGlobal.setSnr  (
			~tSnGlob[0],~tSnGlob[1],~tSnGlob[2],~tSnGlob[3],
			~tSnGlob[4],~tSnGlob[5],~tSnGlob[6],~tSnGlob[7],
			~tSnGlob[8],~tSnGlob[9],~tSnGlob[10],~tSnGlob[11],
			~tSnGlob[12],~tSnGlob[13],~tSnGlob[14],~tSnGlob[15],
		);
		//CH  [ Hat ]
		IFSeqHat.stGrpSet    (
			~tHtAmp[0],~tHtAmp[1],~tHtAmp[2],~tHtAmp[3],
			~tHtAmp[4],~tHtAmp[5],~tHtAmp[6],~tHtAmp[7],
			~tHtAmp[8],~tHtAmp[9],~tHtAmp[10],~tHtAmp[11],
			~tHtAmp[12],~tHtAmp[13],~tHtAmp[14],~tHtAmp[15],
		);
		IFSeqOctHat.stGrpSet  (
			~tHtOct[0],~tHtOct[1],~tHtOct[2],~tHtOct[3],
			~tHtOct[4],~tHtOct[5],~tHtOct[6],~tHtOct[7],
			~tHtOct[8],~tHtOct[9],~tHtOct[10],~tHtOct[11],
			~tHtOct[12],~tHtOct[13],~tHtOct[14],~tHtOct[15],
		);
		IFSeqNtHat.stGrpSet  (
			~tHtNt[0],~tHtNt[1],~tHtNt[2],~tHtNt[3],
			~tHtNt[4],~tHtNt[5],~tHtNt[6],~tHtNt[7],
			~tHtNt[8],~tHtNt[9],~tHtNt[10],~tHtNt[11],
			~tHtNt[12],~tHtNt[13],~tHtNt[14],~tHtNt[15],
		);
		IFSeqVelHat.stGrpSet (
			~tHtVel[0],~tHtVel[1],~tHtVel[2],~tHtVel[3],
			~tHtVel[4],~tHtVel[5],~tHtVel[6],~tHtVel[7],
			~tHtVel[8],~tHtVel[9],~tHtVel[10],~tHtVel[11],
			~tHtVel[12],~tHtVel[13],~tHtVel[14],~tHtVel[15],
		);
		IFSeqSusHat.stGrpSet (
			~tHtSus[0],~tHtSus[1],~tHtSus[2],~tHtSus[3],
			~tHtSus[4],~tHtSus[5],~tHtSus[6],~tHtSus[7],
			~tHtSus[8],~tHtSus[9],~tHtSus[10],~tHtSus[11],
			~tHtSus[12],~tHtSus[13],~tHtSus[14],~tHtSus[15],
		);
		IFSeqTmHat.stGrpSet  (
			~tHtTm[0],~tHtTm[1],~tHtTm[2],~tHtTm[3],
			~tHtTm[4],~tHtTm[5],~tHtTm[6],~tHtTm[7],
			~tHtTm[8],~tHtTm[9],~tHtTm[10],~tHtTm[11],
			~tHtTm[12],~tHtTm[13],~tHtTm[14],~tHtTm[15],
		);
		IFSeqDurHat.stGrpSet (
			~tHtDur[0],~tHtDur[1],~tHtDur[2],~tHtDur[3],
			~tHtDur[4],~tHtDur[5],~tHtDur[6],~tHtDur[7],
			~tHtDur[8],~tHtDur[9],~tHtDur[10],~tHtDur[11],
			~tHtDur[12],~tHtDur[13],~tHtDur[14],~tHtDur[15],
		);
		IFShuf.setHat    (
			~tHtShuf[0],~tHtShuf[1],~tHtShuf[2],~tHtShuf[3],
			~tHtShuf[4],~tHtShuf[5],~tHtShuf[6],~tHtShuf[7],
			~tHtShuf[8],~tHtShuf[9],~tHtShuf[10],~tHtShuf[11],
			~tHtShuf[12],~tHtShuf[13],~tHtShuf[14],~tHtShuf[15],
		);
		IFGlobal.setHat  (
			~tHtGlob[0],~tHtGlob[1],~tHtGlob[2],~tHtGlob[3],
			~tHtGlob[4],~tHtGlob[5],~tHtGlob[6],~tHtGlob[7],
			~tHtGlob[8],~tHtGlob[9],~tHtGlob[10],~tHtGlob[11],
			~tHtGlob[12],~tHtGlob[13],~tHtGlob[14],~tHtGlob[15],
		);
		//CH - [ Bass ]
		IFSeqBass.stGrpSet    (
			~tBsAmp[0],~tBsAmp[1],~tBsAmp[2],~tBsAmp[3],
			~tBsAmp[4],~tBsAmp[5],~tBsAmp[6],~tBsAmp[7],
			~tBsAmp[8],~tBsAmp[9],~tBsAmp[10],~tBsAmp[11],
			~tBsAmp[12],~tBsAmp[13],~tBsAmp[14],~tBsAmp[15],
		);
		IFSeqOctBass.stGrpSet  (
			~tBsOct[0],~tBsOct[1],~tBsOct[2],~tBsOct[3],
			~tBsOct[4],~tBsOct[5],~tBsOct[6],~tBsOct[7],
			~tBsOct[8],~tBsOct[9],~tBsOct[10],~tBsOct[11],
			~tBsOct[12],~tBsOct[13],~tBsOct[14],~tBsOct[15],
		);
		IFSeqNtBass.stGrpSet  (
			~tBsNt[0],~tBsNt[1],~tBsNt[2],~tBsNt[3],
			~tBsNt[4],~tBsNt[5],~tBsNt[6],~tBsNt[7],
			~tBsNt[8],~tBsNt[9],~tBsNt[10],~tBsNt[11],
			~tBsNt[12],~tBsNt[13],~tBsNt[14],~tBsNt[15],
		);
		IFSeqVelBass.stGrpSet (
			~tBsVel[0],~tBsVel[1],~tBsVel[2],~tBsVel[3],
			~tBsVel[4],~tBsVel[5],~tBsVel[6],~tBsVel[7],
			~tBsVel[8],~tBsVel[9],~tBsVel[10],~tBsVel[11],
			~tBsVel[12],~tBsVel[13],~tBsVel[14],~tBsVel[15],
		);
		IFSeqSusBass.stGrpSet (
			~tBsSus[0],~tBsSus[1],~tBsSus[2],~tBsSus[3],
			~tBsSus[4],~tBsSus[5],~tBsSus[6],~tBsSus[7],
			~tBsSus[8],~tBsSus[9],~tBsSus[10],~tBsSus[11],
			~tBsSus[12],~tBsSus[13],~tBsSus[14],~tBsSus[15],
		);
		IFSeqTmBass.stGrpSet  (
			~tBsTm[0],~tBsTm[1],~tBsTm[2],~tBsTm[3],
			~tBsTm[4],~tBsTm[5],~tBsTm[6],~tBsTm[7],
			~tBsTm[8],~tBsTm[9],~tBsTm[10],~tBsTm[11],
			~tBsTm[12],~tBsTm[13],~tBsTm[14],~tBsTm[15],
		);
		IFSeqDurBass.stGrpSet (
			~tBsDur[0],~tBsDur[1],~tBsDur[2],~tBsDur[3],
			~tBsDur[4],~tBsDur[5],~tBsDur[6],~tBsDur[7],
			~tBsDur[8],~tBsDur[9],~tBsDur[10],~tBsDur[11],
			~tBsDur[12],~tBsDur[13],~tBsDur[14],~tBsDur[15],
		);
		IFShuf.setBass    (
			~tBsShuf[0],~tBsShuf[1],~tBsShuf[2],~tBsShuf[3],
			~tBsShuf[4],~tBsShuf[5],~tBsShuf[6],~tBsShuf[7],
			~tBsShuf[8],~tBsShuf[9],~tBsShuf[10],~tBsShuf[11],
			~tBsShuf[12],~tBsShuf[13],~tBsShuf[14],~tBsShuf[15],
		);
		IFLfo.setBass    (
			~tBsLfo[0],~tBsLfo[1],~tBsLfo[2],~tBsLfo[3],
			~tBsLfo[4],~tBsLfo[5],~tBsLfo[6],~tBsLfo[7],
			~tBsLfo[8],~tBsLfo[9],~tBsLfo[10],~tBsLfo[11],
			~tBsLfo[12],~tBsLfo[13],~tBsLfo[14],~tBsLfo[15],
		);
		IFGlobal.setBass  (
			~tBsEnv[0],~tBsEnv[1],~tBsEnv[2],~tBsEnv[3],
			~tBsEnv[4],~tBsEnv[5],~tBsEnv[6],~tBsEnv[7],
			~tBsEnv[8],~tBsEnv[9],~tBsEnv[10],~tBsEnv[11],
			~tBsEnv[12],~tBsEnv[13],~tBsEnv[14],~tBsEnv[15],
		);

		//CH - [ Keys ]
		IFSeqKeys.stGrpSet    (
			~tKyAmp[0],~tKyAmp[1],~tKyAmp[2],~tKyAmp[3],
			~tKyAmp[4],~tKyAmp[5],~tKyAmp[6],~tKyAmp[7],
			~tKyAmp[8],~tKyAmp[9],~tKyAmp[10],~tKyAmp[11],
			~tKyAmp[12],~tKyAmp[13],~tKyAmp[14],~tKyAmp[15],
		);
		IFSeqOctKeys.stGrpSet  (
			~tKyOct[0],~tKyOct[1],~tKyOct[2],~tKyOct[3],
			~tKyOct[4],~tKyOct[5],~tKyOct[6],~tKyOct[7],
			~tKyOct[8],~tKyOct[9],~tKyOct[10],~tKyOct[11],
			~tKyOct[12],~tKyOct[13],~tKyOct[14],~tKyOct[15],
		);
		IFSeqNtKeys.stGrpSet  (
			~tKyNt[0],~tKyNt[1],~tKyNt[2],~tKyNt[3],
			~tKyNt[4],~tKyNt[5],~tKyNt[6],~tKyNt[7],
			~tKyNt[8],~tKyNt[9],~tKyNt[10],~tKyNt[11],
			~tKyNt[12],~tKyNt[13],~tKyNt[14],~tKyNt[15],
		);
		IFSeqVelKeys.stGrpSet (
			~tKyVel[0],~tKyVel[1],~tKyVel[2],~tKyVel[3],
			~tKyVel[4],~tKyVel[5],~tKyVel[6],~tKyVel[7],
			~tKyVel[8],~tKyVel[9],~tKyVel[10],~tKyVel[11],
			~tKyVel[12],~tKyVel[13],~tKyVel[14],~tKyVel[15],
		);
		IFSeqSusKeys.stGrpSet (
			~tKySus[0],~tKySus[1],~tKySus[2],~tKySus[3],
			~tKySus[4],~tKySus[5],~tKySus[6],~tKySus[7],
			~tKySus[8],~tKySus[9],~tKySus[10],~tKySus[11],
			~tKySus[12],~tKySus[13],~tKySus[14],~tKySus[15],
		);
		IFSeqTmKeys.stGrpSet  (
			~tKyTm[0],~tKyTm[1],~tKyTm[2],~tKyTm[3],
			~tKyTm[4],~tKyTm[5],~tKyTm[6],~tKyTm[7],
			~tKyTm[8],~tKyTm[9],~tKyTm[10],~tKyTm[11],
			~tKyTm[12],~tKyTm[13],~tKyTm[14],~tKyTm[15],
		);
		IFSeqDurKeys.stGrpSet (
			~tKyDur[0],~tKyDur[1],~tKyDur[2],~tKyDur[3],
			~tKyDur[4],~tKyDur[5],~tKyDur[6],~tKyDur[7],
			~tKyDur[8],~tKyDur[9],~tKyDur[10],~tKyDur[11],
			~tKyDur[12],~tKyDur[13],~tKyDur[14],~tKyDur[15],
		);
		IFShuf.setKeys    (
			~tKyShuf[0],~tKyShuf[1],~tKyShuf[2],~tKyShuf[3],
			~tKyShuf[4],~tKyShuf[5],~tKyShuf[6],~tKyShuf[7],
			~tKyShuf[8],~tKyShuf[9],~tKyShuf[10],~tKyShuf[11],
			~tKyShuf[12],~tKyShuf[13],~tKyShuf[14],~tKyShuf[15],
		);
		IFLfo.setKeys    (
			~tKyLfo[0],~tKyLfo[1],~tKyLfo[2],~tKyLfo[3],
			~tKyLfo[4],~tKyLfo[5],~tKyLfo[6],~tKyLfo[7],
			~tKyLfo[8],~tKyLfo[9],~tKyLfo[10],~tKyLfo[11],
			~tKyLfo[12],~tKyLfo[13],~tKyLfo[14],~tKyLfo[15],
		);
		IFGlobal.setKeys  (
			~tKyEnv[0],~tKyEnv[1],~tKyEnv[2],~tKyEnv[3],
			~tKyEnv[4],~tKyEnv[5],~tKyEnv[6],~tKyEnv[7],
			~tKyEnv[8],~tKyEnv[9],~tKyEnv[10],~tKyEnv[11],
			~tKyEnv[12],~tKyEnv[13],~tKyEnv[14],~tKyEnv[15],
		);
		//CH - [ Mopho ]
		IFSeqMopho.stGrpSet    (
			~tMpAmp[0],~tMpAmp[1],~tMpAmp[2],~tMpAmp[3],
			~tMpAmp[4],~tMpAmp[5],~tMpAmp[6],~tMpAmp[7],
			~tMpAmp[8],~tMpAmp[9],~tMpAmp[10],~tMpAmp[11],
			~tMpAmp[12],~tMpAmp[13],~tMpAmp[14],~tMpAmp[15],
		);
		IFSeqOctMopho.stGrpSet  (
			~tMpOct[0],~tMpOct[1],~tMpOct[2],~tMpOct[3],
			~tMpOct[4],~tMpOct[5],~tMpOct[6],~tMpOct[7],
			~tMpOct[8],~tMpOct[9],~tMpOct[10],~tMpOct[11],
			~tMpOct[12],~tMpOct[13],~tMpOct[14],~tMpOct[15],
		);
		IFSeqNtMopho.stGrpSet  (
			~tMpNt[0],~tMpNt[1],~tMpNt[2],~tMpNt[3],
			~tMpNt[4],~tMpNt[5],~tMpNt[6],~tMpNt[7],
			~tMpNt[8],~tMpNt[9],~tMpNt[10],~tMpNt[11],
			~tMpNt[12],~tMpNt[13],~tMpNt[14],~tMpNt[15],
		);
		IFSeqVelMopho.stGrpSet (
			~tMpVel[0],~tMpVel[1],~tMpVel[2],~tMpVel[3],
			~tMpVel[4],~tMpVel[5],~tMpVel[6],~tMpVel[7],
			~tMpVel[8],~tMpVel[9],~tMpVel[10],~tMpVel[11],
			~tMpVel[12],~tMpVel[13],~tMpVel[14],~tMpVel[15],
		);
		IFSeqSusMopho.stGrpSet (
			~tMpSus[0],~tMpSus[1],~tMpSus[2],~tMpSus[3],
			~tMpSus[4],~tMpSus[5],~tMpSus[6],~tMpSus[7],
			~tMpSus[8],~tMpSus[9],~tMpSus[10],~tMpSus[11],
			~tMpSus[12],~tMpSus[13],~tMpSus[14],~tMpSus[15],
		);
		IFSeqTmMopho.stGrpSet  (
			~tMpTm[0],~tMpTm[1],~tMpTm[2],~tMpTm[3],
			~tMpTm[4],~tMpTm[5],~tMpTm[6],~tMpTm[7],
			~tMpTm[8],~tMpTm[9],~tMpTm[10],~tMpTm[11],
			~tMpTm[12],~tMpTm[13],~tMpTm[14],~tMpTm[15],
		);
		IFSeqDurMopho.stGrpSet (
			~tMpDur[0],~tMpDur[1],~tMpDur[2],~tMpDur[3],
			~tMpDur[4],~tMpDur[5],~tMpDur[6],~tMpDur[7],
			~tMpDur[8],~tMpDur[9],~tMpDur[10],~tMpDur[11],
			~tMpDur[12],~tMpDur[13],~tMpDur[14],~tMpDur[15],
		);
		IFShuf.setMopho    (
			~tMpShuf[0],~tMpShuf[1],~tMpShuf[2],~tMpShuf[3],
			~tMpShuf[4],~tMpShuf[5],~tMpShuf[6],~tMpShuf[7],
			~tMpShuf[8],~tMpShuf[9],~tMpShuf[10],~tMpShuf[11],
			~tMpShuf[12],~tMpShuf[13],~tMpShuf[14],~tMpShuf[15],
		);
		IFLfo.setMopho    (
			~tMpLfo[0],~tMpLfo[1],~tMpLfo[2],~tMpLfo[3],
			~tMpLfo[4],~tMpLfo[5],~tMpLfo[6],~tMpLfo[7],
			~tMpLfo[8],~tMpLfo[9],~tMpLfo[10],~tMpLfo[11],
			~tMpLfo[12],~tMpLfo[13],~tMpLfo[14],~tMpLfo[15],
		);
		IFGlobal.setMopho  (
			~tMpEnv[0],~tMpEnv[1],~tMpEnv[2],~tMpEnv[3],
			~tMpEnv[4],~tMpEnv[5],~tMpEnv[6],~tMpEnv[7],
			~tMpEnv[8],~tMpEnv[9],~tMpEnv[10],~tMpEnv[11],
			~tMpEnv[12],~tMpEnv[13],~tMpEnv[14],~tMpEnv[15],
		);
		//CH - [ Samp ]
		IFSeqSamp.stGrpSet    (
			~tSmAmp[0],~tSmAmp[1],~tSmAmp[2],~tSmAmp[3],
			~tSmAmp[4],~tSmAmp[5],~tSmAmp[6],~tSmAmp[7],
			~tSmAmp[8],~tSmAmp[9],~tSmAmp[10],~tSmAmp[11],
			~tSmAmp[12],~tSmAmp[13],~tSmAmp[14],~tSmAmp[15],
		);
		IFSeqOctSamp.stGrpSet  (
			~tSmOct[0],~tSmOct[1],~tSmOct[2],~tSmOct[3],
			~tSmOct[4],~tSmOct[5],~tSmOct[6],~tSmOct[7],
			~tSmOct[8],~tSmOct[9],~tSmOct[10],~tSmOct[11],
			~tSmOct[12],~tSmOct[13],~tSmOct[14],~tSmOct[15],
		);
		IFSeqNtSamp.stGrpSet  (
			~tSmNt[0],~tSmNt[1],~tSmNt[2],~tSmNt[3],
			~tSmNt[4],~tSmNt[5],~tSmNt[6],~tSmNt[7],
			~tSmNt[8],~tSmNt[9],~tSmNt[10],~tSmNt[11],
			~tSmNt[12],~tSmNt[13],~tSmNt[14],~tSmNt[15],
		);
		IFSeqVelSamp.stGrpSet (
			~tSmVel[0],~tSmVel[1],~tSmVel[2],~tSmVel[3],
			~tSmVel[4],~tSmVel[5],~tSmVel[6],~tSmVel[7],
			~tSmVel[8],~tSmVel[9],~tSmVel[10],~tSmVel[11],
			~tSmVel[12],~tSmVel[13],~tSmVel[14],~tSmVel[15],
		);
		IFSeqSusSamp.stGrpSet (
			~tSmSus[0],~tSmSus[1],~tSmSus[2],~tSmSus[3],
			~tSmSus[4],~tSmSus[5],~tSmSus[6],~tSmSus[7],
			~tSmSus[8],~tSmSus[9],~tSmSus[10],~tSmSus[11],
			~tSmSus[12],~tSmSus[13],~tSmSus[14],~tSmSus[15],
		);
		IFSeqTmSamp.stGrpSet  (
			~tSmTm[0],~tSmTm[1],~tSmTm[2],~tSmTm[3],
			~tSmTm[4],~tSmTm[5],~tSmTm[6],~tSmTm[7],
			~tSmTm[8],~tSmTm[9],~tSmTm[10],~tSmTm[11],
			~tSmTm[12],~tSmTm[13],~tSmTm[14],~tSmTm[15],
		);
		IFSeqDurSamp.stGrpSet (
			~tSmDur[0],~tSmDur[1],~tSmDur[2],~tSmDur[3],
			~tSmDur[4],~tSmDur[5],~tSmDur[6],~tSmDur[7],
			~tSmDur[8],~tSmDur[9],~tSmDur[10],~tSmDur[11],
			~tSmDur[12],~tSmDur[13],~tSmDur[14],~tSmDur[15],
		);
		IFShuf.setSamp    (
			~tSmShuf[0],~tSmShuf[1],~tSmShuf[2],~tSmShuf[3],
			~tSmShuf[4],~tSmShuf[5],~tSmShuf[6],~tSmShuf[7],
			~tSmShuf[8],~tSmShuf[9],~tSmShuf[10],~tSmShuf[11],
			~tSmShuf[12],~tSmShuf[13],~tSmShuf[14],~tSmShuf[15],
		);
		IFLfo.setSamp    (
			~tSmLfo[0],~tSmLfo[1],~tSmLfo[2],~tSmLfo[3],
			~tSmLfo[4],~tSmLfo[5],~tSmLfo[6],~tSmLfo[7],
			~tSmLfo[8],~tSmLfo[9],~tSmLfo[10],~tSmLfo[11],
			~tSmLfo[12],~tSmLfo[13],~tSmLfo[14],~tSmLfo[15],
		);
		IFGlobal.setSamp  (
			~tSmEnv[0],~tSmEnv[1],~tSmEnv[2],~tSmEnv[3],
			~tSmEnv[4],~tSmEnv[5],~tSmEnv[6],~tSmEnv[7],
			~tSmEnv[8],~tSmEnv[9],~tSmEnv[10],~tSmEnv[11],
			~tSmEnv[12],~tSmEnv[13],~tSmEnv[14],~tSmEnv[15],
		);

		//CH- -8- [Ext]
		~local.sendMsg('volExt',0.8);
		~local.sendMsg('susExt',0.2);
		~local.sendMsg('rlsExt',0.2);
		~local.sendMsg('extSends',0.2,0.3);

	}//////                                      - 7 -

	*part08{//////                               - 8 -
		//IFTrack01.setActs;
		"part8".postln;
		~tOSCAdrr.sendMsg('partLabel', 'T1prt08');

	}//////                                      - 8 -


}

/*
*apcParts {//Parts 1-8 //Presets 9-16

*sixteen {//Parts 1-8 //Presets 9-16
"TEMPORARY TEST: IFTrack01.sixteen".postln;
~seqStepBut01.free;
~seqStepBut01 = OSCFunc({
arg msg;
if ( msg[1]==1, {
IFTrack01.part01;
});
},
'/seqStep01'
);
~seqStepBut02.free;
~seqStepBut02 = OSCFunc({
arg msg;
if ( msg[1]==1, {
IFTrack01.part02;
});
},
'/seqStep02'
);

~seqStepBut03.free;
~seqStepBut03 = OSCFunc({
arg msg;
if ( msg[1]==1, {
IFTrack01.part03;
});
},
'/seqStep03'
);

~seqStepBut04.free;
~seqStepBut04 = OSCFunc({
arg msg;
if ( msg[1]==1, {
IFTrack01.part04;
});
},
'/seqStep04'
);
~seqStepBut05.free;
~seqStepBut05 = OSCFunc({
arg msg;
if ( msg[1]==1, {
IFTrack01.part05;
});
},
'/seqStep05'
);
~seqStepBut06.free;
~seqStepBut06 = OSCFunc({
arg msg;
if ( msg[1]==1, {
IFTrack01.part06;
});
},
'/seqStep06'
);
~seqStepBut07.free;
~seqStepBut07 = OSCFunc({
arg msg;
if ( msg[1]==1, {
IFTrack01.part07;
});
},
'/seqStep07'
);
~seqStepBut08.free;
~seqStepBut08 = OSCFunc({
arg msg;
if ( msg[1]==1, {
IFTrack01.part08;
});
},
'/seqStep08'
);
//----------------------------------------------Presets
~seqStepBut09.free;
~seqStepBut09 = OSCFunc({
arg msg;
if ( msg[1]==1, {
"prst00".postln;
IFPresets.prst00;
});
},
'/seqStep09'
);
~seqStepBut10.free;
~seqStepBut10 = OSCFunc({
arg msg;
if ( msg[1]==1, {
"prst02".postln;
IFPresets.prst01;
});
},
'/seqStep10'
);
~seqStepBut11.free;
~seqStepBut11 = OSCFunc({
arg msg;
if ( msg[1]==1, {
"prst03".postln;
IFPresets.prst02;
});
},
'/seqStep11'
);
~seqStepBut12.free;
~seqStepBut12 = OSCFunc({
arg msg;
if ( msg[1]==1, {
"prst04".postln;
IFPresets.prst03;
});
},
'/seqStep12'
);
~seqStepBut13.free;
~seqStepBut13 = OSCFunc({
arg msg;
if ( msg[1]==1, {
"prst01".postln;
IFPresets.prst04;
});
},
'/seqStep13'
);
~seqStepBut14.free;
~seqStepBut14 = OSCFunc({
arg msg;
if ( msg[1]==1, {
"prst05".postln;
IFPresets.prst05;
});
},
'/seqStep14'
);
~seqStepBut15.free;
~seqStepBut15 = OSCFunc({
arg msg;
if ( msg[1]==1, {
"prst06".postln;
IFPresets.prst06;
});
},
'/seqStep15'
);

~seqStepBut16.free;
~seqStepBut16 = OSCFunc({
arg msg;
if ( msg[1]==1, {
"prst07".postln;
IFPresets.prst07;
});
},
'/seqStep16'
);

}//sixteen

~apc_TS01.free;
~apc_TS01=MIDIFunc.noteOn( {
arg vel;
if ( vel==127, {
~partCase=1;
IFTrack01.part01;
IFAPCMn.tsLeds(1,0,0,0,0,0,0,0);
});
},srcID:~apcMnInID, chan:0, noteNum:~tsBut1);
~apc_TS02.free;
~apc_TS02=MIDIFunc.noteOn( {
arg vel;
if ( vel==127, {
~partCase=2;
IFTrack01.part02;
IFAPCMn.tsLeds(0,1,0,0,0,0,0,0);
});
},srcID:~apcMnInID, chan:0, noteNum:~tsBut2);
~apc_TS03.free;
~apc_TS03=MIDIFunc.noteOn( {
arg vel;
if ( vel==127, {
~partCase=3;
IFTrack01.part03;
IFAPCMn.tsLeds(0,0,1,0,0,0,0,0);
});
},srcID:~apcMnInID, chan:0, noteNum:~tsBut3);
~apc_TS04.free;
~apc_TS04=MIDIFunc.noteOn( {
arg vel;
if ( vel==127, {
~partCase=4;
IFTrack01.part04;
IFAPCMn.tsLeds(0,0,0,1,0,0,0,0);
});
},srcID:~apcMnInID, chan:0, noteNum:~tsBut4);
~apc_TS05.free;
~apc_TS05=MIDIFunc.noteOn( {
arg vel;
if ( vel==127, {
~partCase=5;
IFTrack01.part05;
IFAPCMn.tsLeds(0,0,0,0,1,0,0,0);
});
},srcID:~apcMnInID, chan:0, noteNum:~tsBut5);
~apc_TS06.free;
~apc_TS06=MIDIFunc.noteOn( {
arg vel;
if ( vel==127, {
~partCase=6;
IFTrack01.part06;
IFAPCMn.tsLeds(0,0,0,0,0,1,0,0);
});
},srcID:~apcMnInID, chan:0, noteNum:~tsBut6);
~apc_TS07.free;
~apc_TS07=MIDIFunc.noteOn( {
arg vel;
if ( vel==127, {
~partCase=7;
IFTrack01.part07;
IFAPCMn.tsLeds(0,0,0,0,0,0,1,0);
});
},srcID:~apcMnInID, chan:0, noteNum:~tsBut7);
~apc_TS08.free;
~apc_TS08=MIDIFunc.noteOn( {
arg vel;
if ( vel==127, {
~partCase=8;
IFTrack01.part08;
IFAPCMn.tsLeds(0,0,0,0,0,0,0,1);
});
},srcID:~apcMnInID, chan:0, noteNum:~tsBut8);

}//apcParts

*apcActs{

}//apcActs
*lpMnParts {//Parts 1-8 //Presets 9-16


~lpMn_TS01.free;
~lpMn_TS01=MIDIFunc.cc( {
arg vel;
if ( vel==127, {
~partCase=1;
IFTrack01.part01;
IFLpMn.tsLeds(1,0,0,0,0,0,0,0);
});
},srcID:~lpMnInID, chan:~lpMnCh, ccNum:~lpMnButH1);
~lpMn_TS02.free;
~lpMn_TS02=MIDIFunc.cc( {
arg vel;
if ( vel==127, {
~partCase=2;
IFTrack01.part02;
IFLpMn.tsLeds(0,1,0,0,0,0,0,0);
});
},srcID:~lpMnInID, chan:~lpMnCh, ccNum:~lpMnButH2);
~lpMn_TS03.free;
~lpMn_TS03=MIDIFunc.cc( {
arg vel;
if ( vel==127, {
~partCase=3;
IFTrack01.part03;
IFLpMn.tsLeds(0,0,1,0,0,0,0,0);
});
},srcID:~lpMnInID, chan:~lpMnCh, ccNum:~lpMnButH3);
~lpMn_TS04.free;
~lpMn_TS04=MIDIFunc.cc( {
arg vel;
if ( vel==127, {
~partCase=4;
IFTrack01.part04;
IFLpMn.tsLeds(0,0,0,1,0,0,0,0);
});
},srcID:~lpMnInID, chan:~lpMnCh, ccNum:~lpMnButH4);
~lpMn_TS05.free;
~lpMn_TS05=MIDIFunc.cc( {
arg vel;
if ( vel==127, {
~partCase=5;
IFTrack01.part05;
IFLpMn.tsLeds(0,0,0,0,1,0,0,0);
});
},srcID:~lpMnInID, chan:~lpMnCh, ccNum:~lpMnButH5);
~lpMn_TS06.free;
~lpMn_TS06=MIDIFunc.cc( {
arg vel;
if ( vel==127, {
~partCase=6;
IFTrack01.part06;
IFLpMn.tsLeds(0,0,0,0,0,1,0,0);
});
},srcID:~lpMnInID, chan:~lpMnCh, ccNum:~lpMnButH6);
~lpMn_TS07.free;
~lpMn_TS07=MIDIFunc.cc( {
arg vel;
if ( vel==127, {
~partCase=7;
IFTrack01.part07;
IFLpMn.tsLeds(0,0,0,0,0,0,1,0);
});
},srcID:~lpMnInID, chan:~lpMnCh, ccNum:~lpMnButH7);
~lpMn_TS08.free;
~lpMn_TS08=MIDIFunc.cc( {
arg vel;
if ( vel==127, {
~partCase=8;
IFTrack01.part08;
IFLpMn.tsLeds(0,0,0,0,0,0,0,1);
});
},srcID:~lpMnInID, chan:~lpMnCh, ccNum:~lpMnButH8);

}//lpMnParts

*/