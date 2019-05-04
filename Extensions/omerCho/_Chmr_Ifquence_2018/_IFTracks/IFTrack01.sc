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
		//~scl1= Scale.chromatic;
		//~scl2= Scale.humayun;
		//~scl2= Scale.minor;
		IFPitch.setScl(scl1:0,scl2:17, root:4);
		//~tOSCAdrr.sendMsg('scaleLabel', 'humayun');
		IFPitch.pat(4,0,2,3, 4,0,2,1);
		//~ifPitchPat.source=Pseq([0,-1,14,-3], inf);

		IFProjectGlobals.setTempo(122);
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
		~octVKick=4;~susVKick.source=0.1;
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
		IFGlobal.envBass(vol:0.89,att:0.01,dec:0.2,sus:0.1,rls:0.3,pan:0.1,sndX:0,sndY:0.1);
		IFGlobal.mulBass(octMul:1,susMul:0.3,xy1X:0.2,xy1Y:0.3,xy2X:0.2,xy2Y:0.3,lfo1:0.0,lfo2:0);

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
		IFGlobal.envKeys(vol:0.99,att:0.1,dec:0.9,sus:0.9,rls:0.3,pan:0.1,sndX:0.2,sndY:0.6);
		IFGlobal.mulKeys(octMul:1,susMul:0.99,xy1X:0.2,xy1Y:0.3,xy2X:0.2,xy2Y:0.3,lfo1:0.9,lfo2:0.4);

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
		IFGlobal.envMopho(vol:0.89,att:0.01,dec:0.2,sus:0.5,rls:0.3,pan:0.1,sndX:0,sndY:0.1);
		IFGlobal.mulMopho(octMul:2,susMul:0.5,xy1X:0.2,xy1Y:0.3,xy2X:0.2,xy2Y:0.3,lfo1:0.0,lfo2:0);

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
		IFGlobal.envSamp(vol:0.89,att:0.1,dec:0.2,sus:0.1,rls:0.3,pan:0.1,sndX:0,sndY:0.1);
		IFGlobal.mulSamp(octMul:1,susMul:0.2,xy1X:0.2,xy1Y:0.3,xy2X:0.2,xy2Y:0.3,lfo1:0.0,lfo2:0);
		//CH- -8- [Ext]
		~local.sendMsg('volExt',0.8);
		~local.sendMsg('susExt',0.2);
		~local.sendMsg('rlsExt',0.2);
		~local.sendMsg('extSends',0.2,0.3);

	}//////                                             - 1 -

	*part02{//////                                      - 2 -
		//IFTrack01.setActs;
		"part02".postln;
		~tOSCAdrr.sendMsg('partLabel', 'T1prt01');

		IFSeqSteps.long01;
		IFSeqVKick.stGrpSet  (1,0,1,0, 1,0,1,0,  1,0,0,1, 1,0,1,0);
		~octVKick=0;~ntVKick.source = Pseq([7], inf);
		IFSeqVSnr.stGrpSet  (0,0,1,0, 0,0,1,0,  0,0,1,0, 0,0,1,0);
		~octVSnr=0;~ntVSnr.source = Pseq([20], inf);
		IFSeqVHat.stGrpSet  (0,1,0,1, 0,1,0,1,  0,1,0,1, 0,1,0,1);
		~octVHat=0;~ntVHat.source = Pseq([124], inf);
		IFSeqVClap.stGrpSet  (0,0,0,0, 0,1,0,0,  0,0,0,0, 1,0,0,0);
		~octVClap=0;~ntVClap.source = Pseq([36], inf);
		//~durVClap.source  =  Pseq([1/2], inf);

		IFSeqVTomL.stGrpSet  (1,0,0,1, 1,0,0,0,  1,0,0,0, 0,0,0,0);
		//~ntVTomL.source = Pseq([43,43,43,50], inf);
		IFSeqVTomH.stGrpSet  (1,0,0,1, 1,0,0,0,  1,0,0,0, 0,0,0,0);
		//~ntVTomH.source = Pseq([43,43,43,50], inf);
		IFSeqVCrsh.stGrpSet  (0,0,0,0, 0,0,0,1,  0,0,0,0, 0,1,0,1);
		//~ntVCrsh.source = Pseq([67,75,75,75], inf);
		IFSeqVPcm.stGrpSet  (1,0,1,0, 1,0,1,1,  0,0,1,1, 0,1,0,1);
		~ntVPcm.source = Pseq([~vCalv,~vCalv,~vCalv,~vCalv,~vAgog], inf);

		//CH -1- [ Kick ]
		~local.sendMsg('sendKick', 0.0, 0.0);
		~local.sendMsg('attKick', 0.0);
		~local.sendMsg('susKick', 0.9);
		~local.sendMsg('decKick', 0.9);
		~local.sendMsg('chainKick', 0.0);
		IFSeqOctKick.stGrp (1);
		IFSeqKick.stGrpSet    (1,0,0,1, 0,1,0,1, 0,1,1,0, 0,1,0,1);
		IFSeqNtKick.stGrpSet  (0,1,0,4, 0,6,0,7,  0,1,0,0, 0,1,2,0);
		IFSeqVelKick.stGrpSet (3,1,1,3, 2,2,1,3,  0,3,1,3, 0,3,1,3);
		IFSeqSusKick.stGrpSet (1,2,1,2, 0,2,0,2,  0,2,0,2, 0,2,0,2);
		IFSeqTmKick.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKick.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);

		IFSeqKick2.stGrpSet    (0,1,0,0, 0,1,1,0,  1,0,1,0, 1,1,0,0);
		IFSeqNtKick2.stGrpSet  (0,0,2,3, 0,1,4,3,  0,1,2,3, 0,6,7,3);
		IFSeqVelKick2.stGrpSet (1,2,1,3, 1,2,1,2,  1,2,1,3, 1,2,1,2);
		IFSeqSusKick2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,5,2);

		//CH -1- [ Snare ]
		IFSeqSnr.stGrpSet     (0,1,0,0, 0,1,0,0,  0,0,1,0, 0,1,1,0);
		IFSeqNtSnr.stGrpSet   (4,0,2,3, 4,0,2,3,  0,1,4,3, 0,4,2,3);
		IFSeqVelSnr.stGrpSet  (1,2,3,3, 1,2,3,3,  1,2,3,3, 1,2,1,3);
		IFSeqSusSnr.stGrpSet  (1,2,1,3, 1,2,3,3,  1,2,2,3, 1,2,1,3);
		IFSeqTmSnr.stGrpSet   (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,2,1);
		IFSeqDurSnr.stGrp     (4);
		IFSeqSnr2.stGrpSet    (0,1,2,1, 0,0,0,1,  0,1,0,0, 0,0,0,1);
		IFSeqNtSnr2.stGrpSet  (0,1,2,3, 0,1,5,3,  0,1,2,3, 0,6,7,3);
		IFSeqVelSnr2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,1,2);
		IFSeqSusSnr2.stGrpSet (1,2,1,3, 1,2,1,2,  1,3,1,2, 1,2,3,2);

		//CH -2- [ HAT ]
		IFSeqHat.stGrpSet    (1,0,0,1, 0,1,1,0,  1,1,1,0, 1,1,1,0);
		IFSeqOctHat.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,4,3,3);
		IFSeqNtHat.stGrpSet  (0,1,1,2, 1,3,0,0,  1,2,1,0, 1,2,0,1);
		IFSeqVelHat.stGrpSet (1,3,3,1, 1,3,3,1,  1,3,3,2, 3,2,3,0);
		IFSeqSusHat.stGrpSet (3,1,2,1, 3,1,2,1,  3,1,2,1, 3,2,3,1);
		IFSeqTmHat.stGrp  (2);
		IFSeqDurHat.stGrp  (4);
		IFSeqHat2.stGrpSet    (1,1,1,0, 1,1,1,1,  1,1,0,1, 0,1,1,1);
		IFSeqNtHat2.stGrpSet  (0,0,8,3, 0,0,0,3,  0,1,2,3, 0,6,7,3);
		IFSeqVelHat2.stGrpSet (3,2,1,2, 1,2,3,2,  1,2,1,2, 1,2,1,2);
		IFSeqSusHat2.stGrpSet (1,2,1,3, 1,2,1,2,  1,3,1,2, 1,2,3,2);
		IFSeqTm2Hat.stGrp  (2);
		IFSeqDur2Hat.stGrp  (4);

		//CH -4- [Bass]
		IFSeqBass.stGrpSet    (1,1,1,1, 1,1,0,1,  1,0,1,1, 1,0,1,1);
		IFSeqOctBass.stGrpSet (2,3,3,3, 2,3,3,3,  2,3,3,3, 2,4,3,3);
		IFSeqNtBass.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 2,0,3,2);
		IFSeqVelBass.stGrpSet (3,2,1,2, 3,2,1,3,  3,1,3,2, 3,2,3,0);
		IFSeqSusBass.stGrpSet (3,2,1,2, 2,1,1,3,  2,2,1,2, 3,3,2,2);
		IFSeqTmBass.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurBass.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.setBass(0,2,0,4,1,3,0,5,2);
		~lfo1Bass.source  =  Pseq([10,90,70,18, 10,40,60,20], inf);
		~lfo2Bass.source  =  Pseq([10,20,30,50, 80,20,90,70], inf);
		~local.sendMsg('lfoMulBass1',0.30);
		~local.sendMsg('lfoMulBass2',0.10);
		//CH -5- [Keys]
		IFSeqKeys.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqOctKeys.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtKeys.stGrpSet  (0,2,0,4, 0,2,0,4,  0,2,0,4, 0,2,0,4);
		IFSeqVelKeys.stGrpSet (1,2,1,2, 1,2,1,3,  3,1,3,2, 3,2,3,0);
		IFSeqSusKeys.stGrpSet (3,2,1,2, 2,1,1,3,  2,2,1,2, 3,3,2,2);
		IFSeqTmKeys.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKeys.stGrpSet (4,4,4,4, 4,4,4,4,  4,2,4,4, 4,2,4,4);
		IFShuf.setKeys(0,2,0,4,1,3,0,5,2);
		~local.sendMsg('lfoMulKeys1',0.0);
		~local.sendMsg('lfoMulKeys2',0.01);
		~lfoRtKeys.source =  Pseq([20,40,40,10,20,10,90,10], inf);
		~lfoCtKeys.source =  Pseq([10,20,90,50,30,40,90,20], inf);
		//CH -6- [SAMP]a
		IFSeqSamp.stGrpSet    (0,1,0,1, 0,1,0,0,  1,1,0,1, 0,0,1,0);
		IFSeqOctSamp.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtSamp.stGrpSet  (6,1,2,1, 4,3,5,0,  1,0,1,2, 0,3,0,0);
		IFSeqVelSamp.stGrpSet (0,3,0,3, 0,3,0,3,  0,3,0,3, 0,3,0,3);
		IFSeqSusSamp.stGrpSet (5,5,5,0, 3,5,4,5,  5,0,0,0, 4,0,4,0);
		IFSeqTmSamp.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSamp.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.setSamp(0,2,0,4,1,3,0,5,2);
		~local.sendMsg('lfoMulSamp1',0.5);
		~local.sendMsg('lfoMulSamp2',0.4);
		~lfo1Samp.source  =  Pseq([90,1,70,9, 80,10,7,1], inf);
		~lfo2Samp.source  =  Pseq([120,10,80,99,6,10,80,99], inf);
		//CH -7- [Mopho]
		IFSeqMopho.stGrpSet    (1,0,1,1, 0,1,1,1,  0,1,1,1, 1,0,1,0);
		IFSeqOctMopho.stGrpSet (3,3,4,3, 3,4,3,4,  4,3,4,3, 3,4,3,3);
		IFSeqNtMopho.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,2,1, 0,0,0,0);
		IFSeqVelMopho.stGrpSet (4,3,0,3, 3,3,0,3,  0,3,0,3, 4,3,0,3);
		IFSeqSusMopho.stGrpSet (0,0,1,0, 4,0,1,0,  4,0,1,0, 0,3,0,5);
		IFSeqTmMopho.stGrpSet  (1,1,1,2, 1,1,1,2,  1,1,2,1, 2,1,1,1);
		IFSeqDurMopho.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.setMopho(0,2,0,-3,8,1,0,6,2);
		~local.sendMsg('lfoMulMopho1',0.2);
		~local.sendMsg('lfoMulMopho2',0.3);
		~local.sendMsg('lfo1AmntMopho',0.0);
		//CH- -8- [Ext]
		~local.sendMsg('volExt',0.8);
		~local.sendMsg('susExt',0.2);
		~local.sendMsg('rlsExt',0.2);
		~local.sendMsg('extSends',0.2,0.3);


	}//////                                      - 2 -

	*part03{//////                                      - 3 -
		//IFTrack01.setActs;
		"Part 03".postln;
		~tOSCAdrr.sendMsg('partLabel', 'T1prt01');

		IFSeqSteps.first8;


		IFSeqVSnr.stGrpSet  (0,0,1,0, 0,0,1,0,  0,0,1,0, 0,0,1,0);
		~octVSnr=0;~ntVSnr.source = Pseq([20], inf);
		IFSeqVHat.stGrpSet  (0,1,0,1, 0,1,0,1,  0,1,0,1, 0,1,0,1);
		~octVHat=0;~ntVHat.source = Pseq([124], inf);

		IFSeqVClap.stGrpSet  (0,0,0,0, 0,1,0,0,  0,0,0,0, 1,0,0,0);
		~octVClap=0;~ntVClap.source = Pseq([36], inf);
		//~durVClap.source  =  Pseq([1/2], inf);

		IFSeqVTomL.stGrpSet  (1,0,0,1, 1,0,0,0,  1,0,0,0, 0,0,0,0);
		//~ntVTomL.source = Pseq([43,43,43,50], inf);
		IFSeqVTomH.stGrpSet  (1,0,0,1, 1,0,0,0,  1,0,0,0, 0,0,0,0);
		//~ntVTomH.source = Pseq([43,43,43,50], inf);
		IFSeqVCrsh.stGrpSet  (0,0,0,0, 0,0,0,1,  0,0,0,0, 0,1,0,1);
		//~ntVCrsh.source = Pseq([67,75,75,75], inf);
		IFSeqVPcm.stGrpSet  (1,0,1,0, 1,0,1,1,  0,0,1,1, 0,1,0,1);
		~ntVPcm.source = Pseq([~vCalv,~vCalv,~vCalv,~vCalv,~vAgog], inf);

		//CH -1- [ Kick ]
		IFSeqVKick.stGrpSet  (1,0,1,0, 1,0,1,0,  1,0,0,1, 1,0,1,0);
		~octVKick=0;~ntVKick.source = Pseq([7], inf);
		~local.sendMsg('sendKick', 0.0, 0.0);
		~local.sendMsg('attKick', 0.0);
		~local.sendMsg('susKick', 0.9);
		~local.sendMsg('decKick', 0.9);
		~local.sendMsg('chainKick', 0.0);
		IFSeqOctKick.stGrp (1);
		IFSeqKick.stGrpSet    (1,0,0,1, 0,1,0,1, 0,1,1,0, 0,1,0,1);
		IFSeqNtKick.stGrpSet  (0,1,0,4, 0,6,0,7,  0,1,0,0, 0,1,2,0);
		IFSeqVelKick.stGrpSet (3,1,1,3, 2,2,1,3,  0,3,1,3, 0,3,1,3);
		IFSeqSusKick.stGrpSet (1,2,1,2, 0,2,0,2,  0,2,0,2, 0,2,0,2);
		IFSeqTmKick.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKick.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);

		IFSeqKick2.stGrpSet    (0,1,0,0, 0,1,1,0,  1,0,1,0, 1,1,0,0);
		IFSeqNtKick2.stGrpSet  (0,0,2,3, 0,1,4,3,  0,1,2,3, 0,6,7,3);
		IFSeqVelKick2.stGrpSet (1,2,1,3, 1,2,1,2,  1,2,1,3, 1,2,1,2);
		IFSeqSusKick2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,5,2);

		//CH -1- [ Snare ]
		IFSeqSnr.stGrpSet     (0,1,0,0, 0,1,0,0,  0,0,1,0, 0,1,1,0);
		IFSeqNtSnr.stGrpSet   (4,0,2,3, 4,0,2,3,  0,1,4,3, 0,4,2,3);
		IFSeqVelSnr.stGrpSet  (1,2,3,3, 1,2,3,3,  1,2,3,3, 1,2,1,3);
		IFSeqSusSnr.stGrpSet  (1,2,1,3, 1,2,3,3,  1,2,2,3, 1,2,1,3);
		IFSeqTmSnr.stGrpSet   (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,2,1);
		IFSeqDurSnr.stGrp     (4);
		IFSeqSnr2.stGrpSet    (0,1,2,1, 0,0,0,1,  0,1,0,0, 0,0,0,1);
		IFSeqNtSnr2.stGrpSet  (0,1,2,3, 0,1,5,3,  0,1,2,3, 0,6,7,3);
		IFSeqVelSnr2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,1,2);
		IFSeqSusSnr2.stGrpSet (1,2,1,3, 1,2,1,2,  1,3,1,2, 1,2,3,2);

		//CH -2- [ HAT ]
		IFSeqHat.stGrpSet    (1,0,0,1, 0,1,1,0,  1,1,1,0, 1,1,1,0);
		IFSeqOctHat.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,4,3,3);
		IFSeqNtHat.stGrpSet  (0,1,1,2, 1,3,0,0,  1,2,1,0, 1,2,0,1);
		IFSeqVelHat.stGrpSet (1,3,3,1, 1,3,3,1,  1,3,3,2, 3,2,3,0);
		IFSeqSusHat.stGrpSet (3,1,2,1, 3,1,2,1,  3,1,2,1, 3,2,3,1);
		IFSeqTmHat.stGrp  (2);
		IFSeqDurHat.stGrp  (4);
		IFSeqHat2.stGrpSet    (1,1,1,0, 1,1,1,1,  1,1,0,1, 0,1,1,1);
		IFSeqNtHat2.stGrpSet  (0,0,8,3, 0,0,0,3,  0,1,2,3, 0,6,7,3);
		IFSeqVelHat2.stGrpSet (3,2,1,2, 1,2,3,2,  1,2,1,2, 1,2,1,2);
		IFSeqSusHat2.stGrpSet (1,2,1,3, 1,2,1,2,  1,3,1,2, 1,2,3,2);
		IFSeqTm2Hat.stGrp  (2);
		IFSeqDur2Hat.stGrp  (4);

		//CH -4- [Bass]
		IFSeqBass.stGrpSet    (1,1,1,1, 1,1,0,1,  1,0,1,1, 1,0,1,1);
		IFSeqOctBass.stGrpSet (2,3,3,3, 2,3,3,3,  2,3,3,3, 2,4,3,3);
		IFSeqNtBass.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 2,0,3,2);
		IFSeqVelBass.stGrpSet (3,2,1,2, 3,2,1,3,  3,1,3,2, 3,2,3,0);
		IFSeqSusBass.stGrpSet (3,0,1,0, 0,0,1,3,  2,0,1,0, 3,3,0,0);
		IFSeqTmBass.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurBass.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.setBass(0,2,0,4,1,3,0,5,2);
		~lfo1Bass.source  =  Pseq([10,90,70,18, 10,40,60,20], inf);
		~lfo2Bass.source  =  Pseq([10,20,30,50, 80,20,90,70], inf);
		~local.sendMsg('lfoMulBass1',0.30);
		~local.sendMsg('lfoMulBass2',0.10);
		//CH -5- [Keys]
		IFSeqKeys.stGrpSet    (0,0,1,1, 0,1,0,1,  1,0,1,1, 1,1,1,1);
		IFSeqOctKeys.stGrpSet (3,3,3,3, 3,3,3,3,  2,3,3,3, 2,4,3,3);
		IFSeqNtKeys.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 2,0,3,2);
		IFSeqVelKeys.stGrpSet (1,2,1,2, 1,2,1,3,  3,1,3,2, 3,2,3,0);
		IFSeqSusKeys.stGrpSet (2,3,2,0, 2,3,4,5,  2,3,2,0, 2,2,3,0);
		IFSeqTmKeys.stGrpSet  (1,1,1,1, 1,1,1,1,  1,2,1,1, 1,1,1,1);
		IFSeqDurKeys.stGrpSet (4,4,4,4, 4,4,4,4,  4,2,4,4, 4,2,4,4);
		IFShuf.setKeys(0,2,0,4,1,3,0,5,2);
		~local.sendMsg('lfoMulKeys1',0.0);
		~local.sendMsg('lfoMulKeys2',0.01);
		~lfoRtKeys.source =  Pseq([20,40,40,10,20,10,90,10], inf);
		~lfoCtKeys.source =  Pseq([10,20,90,50,30,40,90,20], inf);
		//CH -6- [SAMP]a
		IFSeqSamp.stGrpSet    (0,1,0,1, 0,1,0,0,  1,1,0,1, 0,0,1,0);
		IFSeqOctSamp.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtSamp.stGrpSet  (6,1,2,1, 4,3,5,0,  1,0,1,2, 0,3,0,0);
		IFSeqVelSamp.stGrpSet (0,3,0,3, 0,3,0,3,  0,3,0,3, 0,3,0,3);
		IFSeqSusSamp.stGrpSet (5,5,5,0, 3,5,4,5,  5,0,0,0, 4,0,4,0);
		IFSeqTmSamp.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSamp.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.setSamp(0,2,0,4,1,3,0,5,2);
		~local.sendMsg('lfoMulSamp1',0.5);
		~local.sendMsg('lfoMulSamp2',0.4);
		~lfo1Samp.source  =  Pseq([90,1,70,9, 80,10,7,1], inf);
		~lfo2Samp.source  =  Pseq([120,10,80,99,6,10,80,99], inf);
		//CH -7- [Mopho]
		IFSeqMopho.stGrpSet    (1,0,1,1, 0,1,1,1,  0,1,1,1, 1,0,1,0);
		IFSeqOctMopho.stGrpSet (3,3,4,3, 3,4,3,4,  4,3,4,3, 3,4,3,3);
		IFSeqNtMopho.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,2,1, 0,0,0,0);
		IFSeqVelMopho.stGrpSet (4,3,0,3, 3,3,0,3,  0,3,0,3, 4,3,0,3);
		IFSeqSusMopho.stGrpSet (0,0,1,0, 4,0,1,0,  4,0,1,0, 0,3,0,5);
		IFSeqTmMopho.stGrpSet  (1,1,1,2, 1,1,1,2,  1,1,2,1, 2,1,1,1);
		IFSeqDurMopho.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.setMopho(0,2,0,-3,8,1,0,6,2);
		~local.sendMsg('lfoMulMopho1',0.2);
		~local.sendMsg('lfoMulMopho2',0.3);
		~local.sendMsg('lfo1AmntMopho',0.0);
		//CH- -8- [Ext]
		~local.sendMsg('volExt',0.8);
		~local.sendMsg('susExt',0.2);
		~local.sendMsg('rlsExt',0.2);
		~local.sendMsg('extSends',0.2,0.3);


	}//////                                      - 3 -

	*part04{//////                                      - 1 -
		//IFTrack01.setActs;
		"Part 04".postln;
		~tOSCAdrr.sendMsg('partLabel', 'T1prt01');

		IFSeqSteps.long02;


		IFSeqVSnr.stGrpSet  (0,0,1,0, 0,0,1,0,  0,0,1,0, 0,0,1,0);
		~octVSnr=0;~ntVSnr.source = Pseq([20], inf);
		IFSeqVHat.stGrpSet  (0,1,0,1, 0,1,0,1,  0,1,0,1, 0,1,0,1);
		~octVHat=0;~ntVHat.source = Pseq([124], inf);

		IFSeqVClap.stGrpSet  (0,0,0,0, 0,1,0,0,  0,0,0,0, 1,0,0,0);
		~octVClap=0;~ntVClap.source = Pseq([36], inf);
		//~durVClap.source  =  Pseq([1/2], inf);

		IFSeqVTomL.stGrpSet  (1,0,0,1, 1,0,0,0,  1,0,0,0, 0,0,0,0);
		//~ntVTomL.source = Pseq([43,43,43,50], inf);
		IFSeqVTomH.stGrpSet  (1,0,0,1, 1,0,0,0,  1,0,0,0, 0,0,0,0);
		//~ntVTomH.source = Pseq([43,43,43,50], inf);
		IFSeqVCrsh.stGrpSet  (0,0,0,0, 0,0,0,1,  0,0,0,0, 0,1,0,1);
		//~ntVCrsh.source = Pseq([67,75,75,75], inf);
		IFSeqVPcm.stGrpSet  (1,0,1,0, 1,0,1,1,  0,0,1,1, 0,1,0,1);
		~ntVPcm.source = Pseq([~vCalv,~vCalv,~vCalv,~vCalv,~vAgog], inf);

		//CH -1- [ Kick ]
		IFSeqVKick.stGrpSet  (1,0,1,0, 1,0,1,0,  1,0,0,1, 1,0,1,0);
		~octVKick=0;~ntVKick.source = Pseq([7], inf);
		~local.sendMsg('sendKick', 0.0, 0.0);
		~local.sendMsg('attKick', 0.0);
		~local.sendMsg('susKick', 0.9);
		~local.sendMsg('decKick', 0.9);
		~local.sendMsg('chainKick', 0.0);
		IFSeqOctKick.stGrp (1);
		IFSeqKick.stGrpSet    (1,0,0,1, 0,1,0,1, 0,1,1,0, 0,1,0,1);
		IFSeqNtKick.stGrpSet  (0,1,0,4, 0,6,0,7,  0,1,0,0, 0,1,2,0);
		IFSeqVelKick.stGrpSet (3,1,1,3, 2,2,1,3,  0,3,1,3, 0,3,1,3);
		IFSeqSusKick.stGrpSet (1,2,1,2, 0,2,0,2,  0,2,0,2, 0,2,0,2);
		IFSeqTmKick.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKick.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);

		IFSeqKick2.stGrpSet    (0,1,0,0, 0,1,1,0,  1,0,1,0, 1,1,0,0);
		IFSeqNtKick2.stGrpSet  (0,0,2,3, 0,1,4,3,  0,1,2,3, 0,6,7,3);
		IFSeqVelKick2.stGrpSet (1,2,1,3, 1,2,1,2,  1,2,1,3, 1,2,1,2);
		IFSeqSusKick2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,5,2);

		//CH -1- [ Snare ]
		IFSeqSnr.stGrpSet     (0,1,0,0, 0,1,0,0,  0,0,1,0, 0,1,1,0);
		IFSeqNtSnr.stGrpSet   (4,0,2,3, 4,0,2,3,  0,1,4,3, 0,4,2,3);
		IFSeqVelSnr.stGrpSet  (1,2,3,3, 1,2,3,3,  1,2,3,3, 1,2,1,3);
		IFSeqSusSnr.stGrpSet  (1,2,1,3, 1,2,3,3,  1,2,2,3, 1,2,1,3);
		IFSeqTmSnr.stGrpSet   (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,2,1);
		IFSeqDurSnr.stGrp     (4);
		IFSeqSnr2.stGrpSet    (0,1,2,1, 0,0,0,1,  0,1,0,0, 0,0,0,1);
		IFSeqNtSnr2.stGrpSet  (0,1,2,3, 0,1,5,3,  0,1,2,3, 0,6,7,3);
		IFSeqVelSnr2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,1,2);
		IFSeqSusSnr2.stGrpSet (1,2,1,3, 1,2,1,2,  1,3,1,2, 1,2,3,2);

		//CH -2- [ HAT ]
		IFSeqHat.stGrpSet    (1,0,0,1, 0,1,1,0,  1,1,1,0, 1,1,1,0);
		IFSeqOctHat.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,4,3,3);
		IFSeqNtHat.stGrpSet  (0,1,1,2, 1,3,0,0,  1,2,1,0, 1,2,0,1);
		IFSeqVelHat.stGrpSet (1,3,3,1, 1,3,3,1,  1,3,3,2, 3,2,3,0);
		IFSeqSusHat.stGrpSet (3,1,2,1, 3,1,2,1,  3,1,2,1, 3,2,3,1);
		IFSeqTmHat.stGrp  (2);
		IFSeqDurHat.stGrp  (4);
		IFSeqHat2.stGrpSet    (1,1,1,0, 1,1,1,1,  1,1,0,1, 0,1,1,1);
		IFSeqNtHat2.stGrpSet  (0,0,8,3, 0,0,0,3,  0,1,2,3, 0,6,7,3);
		IFSeqVelHat2.stGrpSet (3,2,1,2, 1,2,3,2,  1,2,1,2, 1,2,1,2);
		IFSeqSusHat2.stGrpSet (1,2,1,3, 1,2,1,2,  1,3,1,2, 1,2,3,2);
		IFSeqTm2Hat.stGrp  (2);
		IFSeqDur2Hat.stGrp  (4);

		//CH -4- [Bass]
		IFSeqBass.stGrpSet    (1,1,1,1, 1,1,0,1,  1,0,1,1, 1,0,1,1);
		IFSeqOctBass.stGrpSet (2,3,3,3, 2,3,3,3,  2,3,3,3, 2,4,3,3);
		IFSeqNtBass.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 2,0,3,2);
		IFSeqVelBass.stGrpSet (3,2,1,2, 3,2,1,3,  3,1,3,2, 3,2,3,0);
		IFSeqSusBass.stGrpSet (3,0,1,0, 0,0,1,3,  2,0,1,0, 3,3,0,0);
		IFSeqTmBass.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurBass.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.setBass(0,2,0,4,1,3,0,5,2);
		~lfo1Bass.source  =  Pseq([10,90,70,18, 10,40,60,20], inf);
		~lfo2Bass.source  =  Pseq([10,20,30,50, 80,20,90,70], inf);
		~local.sendMsg('lfoMulBass1',0.30);
		~local.sendMsg('lfoMulBass2',0.10);
		//CH -5- [Keys]
		IFSeqKeys.stGrpSet    (0,0,1,1, 0,1,0,1,  1,0,1,1, 1,1,1,1);
		IFSeqOctKeys.stGrpSet (3,3,3,3, 3,3,3,3,  2,3,3,3, 2,4,3,3);
		IFSeqNtKeys.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 2,0,3,2);
		IFSeqVelKeys.stGrpSet (1,2,1,2, 1,2,1,3,  3,1,3,2, 3,2,3,0);
		IFSeqSusKeys.stGrpSet (2,3,2,0, 2,3,4,5,  2,3,2,0, 2,2,3,0);
		IFSeqTmKeys.stGrpSet  (1,1,1,1, 1,1,1,1,  1,2,1,1, 1,1,1,1);
		IFSeqDurKeys.stGrpSet (4,4,4,4, 4,4,4,4,  4,2,4,4, 4,2,4,4);
		IFShuf.setKeys(0,2,0,4,1,3,0,5,2);
		~local.sendMsg('lfoMulKeys1',0.0);
		~local.sendMsg('lfoMulKeys2',0.01);
		~lfoRtKeys.source =  Pseq([20,40,40,10,20,10,90,10], inf);
		~lfoCtKeys.source =  Pseq([10,20,90,50,30,40,90,20], inf);
		//CH -6- [SAMP]a
		IFSeqSamp.stGrpSet    (0,1,0,1, 0,1,0,0,  1,1,0,1, 0,0,1,0);
		IFSeqOctSamp.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtSamp.stGrpSet  (6,1,2,1, 4,3,5,0,  1,0,1,2, 0,3,0,0);
		IFSeqVelSamp.stGrpSet (0,3,0,3, 0,3,0,3,  0,3,0,3, 0,3,0,3);
		IFSeqSusSamp.stGrpSet (5,5,5,0, 3,5,4,5,  5,0,0,0, 4,0,4,0);
		IFSeqTmSamp.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSamp.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.setSamp(0,2,0,4,1,3,0,5,2);
		~local.sendMsg('lfoMulSamp1',0.5);
		~local.sendMsg('lfoMulSamp2',0.4);
		~lfo1Samp.source  =  Pseq([90,1,70,9, 80,10,7,1], inf);
		~lfo2Samp.source  =  Pseq([120,10,80,99,6,10,80,99], inf);
		//CH -7- [Mopho]
		IFSeqMopho.stGrpSet    (1,0,1,1, 0,1,1,1,  0,1,1,1, 1,0,1,0);
		IFSeqOctMopho.stGrpSet (3,3,4,3, 3,4,3,4,  4,3,4,3, 3,4,3,3);
		IFSeqNtMopho.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,2,1, 0,0,0,0);
		IFSeqVelMopho.stGrpSet (4,3,0,3, 3,3,0,3,  0,3,0,3, 4,3,0,3);
		IFSeqSusMopho.stGrpSet (0,0,1,0, 4,0,1,0,  4,0,1,0, 0,3,0,5);
		IFSeqTmMopho.stGrpSet  (1,1,1,2, 1,1,1,2,  1,1,2,1, 2,1,1,1);
		IFSeqDurMopho.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.setMopho(0,2,0,-3,8,1,0,6,2);
		~local.sendMsg('lfoMulMopho1',0.2);
		~local.sendMsg('lfoMulMopho2',0.3);
		~local.sendMsg('lfo1AmntMopho',0.0);
		//CH- -8- [Ext]
		~local.sendMsg('volExt',0.8);
		~local.sendMsg('susExt',0.2);
		~local.sendMsg('rlsExt',0.2);
		~local.sendMsg('extSends',0.2,0.3);


	}//////                                      - 4 -

	*part05{//////                                      - 1 -
		//IFTrack01.setActs;
		"Part 05".postln;
		~tOSCAdrr.sendMsg('partLabel', 'T1prt01');

		IFSeqSteps.long02;


		IFSeqVSnr.stGrpSet  (0,0,1,0, 0,0,1,0,  0,0,1,0, 0,0,1,0);
		~octVSnr=0;~ntVSnr.source = Pseq([20], inf);
		IFSeqVHat.stGrpSet  (0,1,0,1, 0,1,0,1,  0,1,0,1, 0,1,0,1);
		~octVHat=0;~ntVHat.source = Pseq([124], inf);

		IFSeqVClap.stGrpSet  (0,0,0,0, 0,1,0,0,  0,0,0,0, 1,0,0,0);
		~octVClap=0;~ntVClap.source = Pseq([36], inf);
		//~durVClap.source  =  Pseq([1/2], inf);

		IFSeqVTomL.stGrpSet  (1,0,0,1, 1,0,0,0,  1,0,0,0, 0,0,0,0);
		//~ntVTomL.source = Pseq([43,43,43,50], inf);
		IFSeqVTomH.stGrpSet  (1,0,0,1, 1,0,0,0,  1,0,0,0, 0,0,0,0);
		//~ntVTomH.source = Pseq([43,43,43,50], inf);
		IFSeqVCrsh.stGrpSet  (0,0,0,0, 0,0,0,1,  0,0,0,0, 0,1,0,1);
		//~ntVCrsh.source = Pseq([67,75,75,75], inf);
		IFSeqVPcm.stGrpSet  (1,0,1,0, 1,0,1,1,  0,0,1,1, 0,1,0,1);
		~ntVPcm.source = Pseq([~vCalv,~vCalv,~vCalv,~vCalv,~vAgog], inf);

		//CH -1- [ Kick ]
		IFSeqVKick.stGrpSet  (1,0,1,0, 1,0,1,0,  1,0,0,1, 1,0,1,0);
		~octVKick=0;~ntVKick.source = Pseq([7], inf);
		~local.sendMsg('sendKick', 0.0, 0.0);
		~local.sendMsg('attKick', 0.0);
		~local.sendMsg('susKick', 0.9);
		~local.sendMsg('decKick', 0.9);
		~local.sendMsg('chainKick', 0.0);
		IFSeqOctKick.stGrp (1);
		IFSeqKick.stGrpSet    (1,0,0,1, 0,1,0,1, 0,1,1,0, 0,1,0,1);
		IFSeqNtKick.stGrpSet  (0,1,0,4, 0,6,0,7,  0,1,0,0, 0,1,2,0);
		IFSeqVelKick.stGrpSet (3,1,1,3, 2,2,1,3,  0,3,1,3, 0,3,1,3);
		IFSeqSusKick.stGrpSet (1,2,1,2, 0,2,0,2,  0,2,0,2, 0,2,0,2);
		IFSeqTmKick.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKick.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);

		IFSeqKick2.stGrpSet    (0,1,0,0, 0,1,1,0,  1,0,1,0, 1,1,0,0);
		IFSeqNtKick2.stGrpSet  (0,0,2,3, 0,1,4,3,  0,1,2,3, 0,6,7,3);
		IFSeqVelKick2.stGrpSet (1,2,1,3, 1,2,1,2,  1,2,1,3, 1,2,1,2);
		IFSeqSusKick2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,5,2);

		//CH -1- [ Snare ]
		IFSeqSnr.stGrpSet     (0,1,0,0, 0,1,0,0,  0,0,1,0, 0,1,1,0);
		IFSeqNtSnr.stGrpSet   (4,0,2,3, 4,0,2,3,  0,1,4,3, 0,4,2,3);
		IFSeqVelSnr.stGrpSet  (1,2,3,3, 1,2,3,3,  1,2,3,3, 1,2,1,3);
		IFSeqSusSnr.stGrpSet  (1,2,1,3, 1,2,3,3,  1,2,2,3, 1,2,1,3);
		IFSeqTmSnr.stGrpSet   (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,2,1);
		IFSeqDurSnr.stGrp     (4);
		IFSeqSnr2.stGrpSet    (0,1,2,1, 0,0,0,1,  0,1,0,0, 0,0,0,1);
		IFSeqNtSnr2.stGrpSet  (0,1,2,3, 0,1,5,3,  0,1,2,3, 0,6,7,3);
		IFSeqVelSnr2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,1,2);
		IFSeqSusSnr2.stGrpSet (1,2,1,3, 1,2,1,2,  1,3,1,2, 1,2,3,2);

		//CH -2- [ HAT ]
		IFSeqHat.stGrpSet    (1,0,0,1, 0,1,1,0,  1,1,1,0, 1,1,1,0);
		IFSeqOctHat.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,4,3,3);
		IFSeqNtHat.stGrpSet  (0,1,1,2, 1,3,0,0,  1,2,1,0, 1,2,0,1);
		IFSeqVelHat.stGrpSet (1,3,3,1, 1,3,3,1,  1,3,3,2, 3,2,3,0);
		IFSeqSusHat.stGrpSet (3,1,2,1, 3,1,2,1,  3,1,2,1, 3,2,3,1);
		IFSeqTmHat.stGrp  (2);
		IFSeqDurHat.stGrp  (4);
		IFSeqHat2.stGrpSet    (1,1,1,0, 1,1,1,1,  1,1,0,1, 0,1,1,1);
		IFSeqNtHat2.stGrpSet  (0,0,8,3, 0,0,0,3,  0,1,2,3, 0,6,7,3);
		IFSeqVelHat2.stGrpSet (3,2,1,2, 1,2,3,2,  1,2,1,2, 1,2,1,2);
		IFSeqSusHat2.stGrpSet (1,2,1,3, 1,2,1,2,  1,3,1,2, 1,2,3,2);
		IFSeqTm2Hat.stGrp  (2);
		IFSeqDur2Hat.stGrp  (4);

		//CH -4- [Bass]
		IFSeqBass.stGrpSet    (1,1,1,1, 1,1,0,1,  1,0,1,1, 1,0,1,1);
		IFSeqOctBass.stGrpSet (2,3,3,3, 2,3,3,3,  2,3,3,3, 2,4,3,3);
		IFSeqNtBass.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 2,0,3,2);
		IFSeqVelBass.stGrpSet (3,2,1,2, 3,2,1,3,  3,1,3,2, 3,2,3,0);
		IFSeqSusBass.stGrpSet (3,0,1,0, 0,0,1,3,  2,0,1,0, 3,3,0,0);
		IFSeqTmBass.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurBass.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.setBass(0,2,0,4,1,3,0,5,2);
		~lfo1Bass.source  =  Pseq([10,90,70,18, 10,40,60,20], inf);
		~lfo2Bass.source  =  Pseq([10,20,30,50, 80,20,90,70], inf);
		~local.sendMsg('lfoMulBass1',0.30);
		~local.sendMsg('lfoMulBass2',0.10);
		//CH -5- [Keys]
		IFSeqKeys.stGrpSet    (0,0,1,1, 0,1,0,1,  1,0,1,1, 1,1,1,1);
		IFSeqOctKeys.stGrpSet (3,3,3,3, 3,3,3,3,  2,3,3,3, 2,4,3,3);
		IFSeqNtKeys.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 2,0,3,2);
		IFSeqVelKeys.stGrpSet (1,2,1,2, 1,2,1,3,  3,1,3,2, 3,2,3,0);
		IFSeqSusKeys.stGrpSet (2,3,2,0, 2,3,4,5,  2,3,2,0, 2,2,3,0);
		IFSeqTmKeys.stGrpSet  (1,1,1,1, 1,1,1,1,  1,2,1,1, 1,1,1,1);
		IFSeqDurKeys.stGrpSet (4,4,4,4, 4,4,4,4,  4,2,4,4, 4,2,4,4);
		IFShuf.setKeys(0,2,0,4,1,3,0,5,2);
		~local.sendMsg('lfoMulKeys1',0.0);
		~local.sendMsg('lfoMulKeys2',0.01);
		~lfoRtKeys.source =  Pseq([20,40,40,10,20,10,90,10], inf);
		~lfoCtKeys.source =  Pseq([10,20,90,50,30,40,90,20], inf);
		//CH -6- [SAMP]a
		IFSeqSamp.stGrpSet    (0,1,0,1, 0,1,0,0,  1,1,0,1, 0,0,1,0);
		IFSeqOctSamp.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtSamp.stGrpSet  (6,1,2,1, 4,3,5,0,  1,0,1,2, 0,3,0,0);
		IFSeqVelSamp.stGrpSet (0,3,0,3, 0,3,0,3,  0,3,0,3, 0,3,0,3);
		IFSeqSusSamp.stGrpSet (5,5,5,0, 3,5,4,5,  5,0,0,0, 4,0,4,0);
		IFSeqTmSamp.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSamp.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.setSamp(0,2,0,4,1,3,0,5,2);
		~local.sendMsg('lfoMulSamp1',0.5);
		~local.sendMsg('lfoMulSamp2',0.4);
		~lfo1Samp.source  =  Pseq([90,1,70,9, 80,10,7,1], inf);
		~lfo2Samp.source  =  Pseq([120,10,80,99,6,10,80,99], inf);
		//CH -7- [Mopho]
		IFSeqMopho.stGrpSet    (1,0,1,1, 0,1,1,1,  0,1,1,1, 1,0,1,0);
		IFSeqOctMopho.stGrpSet (3,3,4,3, 3,4,3,4,  4,3,4,3, 3,4,3,3);
		IFSeqNtMopho.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,2,1, 0,0,0,0);
		IFSeqVelMopho.stGrpSet (4,3,0,3, 3,3,0,3,  0,3,0,3, 4,3,0,3);
		IFSeqSusMopho.stGrpSet (0,0,1,0, 4,0,1,0,  4,0,1,0, 0,3,0,5);
		IFSeqTmMopho.stGrpSet  (1,1,1,2, 1,1,1,2,  1,1,2,1, 2,1,1,1);
		IFSeqDurMopho.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.setMopho(0,2,0,-3,8,1,0,6,2);
		~local.sendMsg('lfoMulMopho1',0.2);
		~local.sendMsg('lfoMulMopho2',0.3);
		~local.sendMsg('lfo1AmntMopho',0.0);
		//CH- -8- [Ext]
		~local.sendMsg('volExt',0.8);
		~local.sendMsg('susExt',0.2);
		~local.sendMsg('rlsExt',0.2);
		~local.sendMsg('extSends',0.2,0.3);


	}//////                                      - 5 -

	*part06{//////                                      - 6 -
		//IFTrack01.setActs;
		"Part 06".postln;
		~tOSCAdrr.sendMsg('partLabel', 'T1prt01');

		IFSeqSteps.long03;


		IFSeqVSnr.stGrpSet  (0,0,1,0, 0,0,1,0,  0,0,1,0, 0,0,1,0);
		~octVSnr=0;~ntVSnr.source = Pseq([20], inf);
		IFSeqVHat.stGrpSet  (0,1,0,1, 0,1,0,1,  0,1,0,1, 0,1,0,1);
		~octVHat=0;~ntVHat.source = Pseq([124], inf);

		IFSeqVClap.stGrpSet  (0,0,0,0, 0,1,0,0,  0,0,0,0, 1,0,0,0);
		~octVClap=0;~ntVClap.source = Pseq([36], inf);
		//~durVClap.source  =  Pseq([1/2], inf);

		IFSeqVTomL.stGrpSet  (1,0,0,1, 1,0,0,0,  1,0,0,0, 0,0,0,0);
		//~ntVTomL.source = Pseq([43,43,43,50], inf);
		IFSeqVTomH.stGrpSet  (1,0,0,1, 1,0,0,0,  1,0,0,0, 0,0,0,0);
		//~ntVTomH.source = Pseq([43,43,43,50], inf);
		IFSeqVCrsh.stGrpSet  (0,0,0,0, 0,0,0,1,  0,0,0,0, 0,1,0,1);
		//~ntVCrsh.source = Pseq([67,75,75,75], inf);
		IFSeqVPcm.stGrpSet  (1,0,1,0, 1,0,1,1,  0,0,1,1, 0,1,0,1);
		~ntVPcm.source = Pseq([~vCalv,~vCalv,~vCalv,~vCalv,~vAgog], inf);

		//CH -1- [ Kick ]
		IFSeqVKick.stGrpSet  (1,0,1,0, 1,0,1,0,  1,0,1,1, 1,0,1,0);
		~octVKick=0;~ntVKick.source = Pseq([7], inf);
		~local.sendMsg('sendKick', 0.0, 0.0);
		~local.sendMsg('attKick', 0.0);
		~local.sendMsg('susKick', 0.9);
		~local.sendMsg('decKick', 0.9);
		~local.sendMsg('chainKick', 0.0);
		IFSeqOctKick.stGrp (1);
		IFSeqKick.stGrpSet    (1,0,0,1, 0,1,0,1, 0,1,1,0, 0,1,0,1);
		IFSeqNtKick.stGrpSet  (0,1,0,4, 0,6,0,7,  0,1,0,0, 0,1,2,0);
		IFSeqVelKick.stGrpSet (3,1,1,3, 2,2,1,3,  0,3,1,3, 0,3,1,3);
		IFSeqSusKick.stGrpSet (1,2,1,2, 0,2,0,2,  0,2,0,2, 0,2,0,2);
		IFSeqTmKick.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKick.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);

		IFSeqKick2.stGrpSet    (0,1,0,0, 0,1,1,0,  1,0,1,0, 1,1,0,0);
		IFSeqNtKick2.stGrpSet  (0,0,2,3, 0,1,4,3,  0,1,2,3, 0,6,7,3);
		IFSeqVelKick2.stGrpSet (1,2,1,3, 1,2,1,2,  1,2,1,3, 1,2,1,2);
		IFSeqSusKick2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,5,2);

		//CH -1- [ Snare ]
		IFSeqSnr.stGrpSet     (0,1,0,0, 0,1,0,0,  0,0,1,0, 0,1,1,0);
		IFSeqNtSnr.stGrpSet   (4,0,2,3, 4,0,2,3,  0,1,4,3, 0,4,2,3);
		IFSeqVelSnr.stGrpSet  (1,2,3,3, 1,2,3,3,  1,2,3,3, 1,2,1,3);
		IFSeqSusSnr.stGrpSet  (1,2,1,3, 1,2,3,3,  1,2,2,3, 1,2,1,3);
		IFSeqTmSnr.stGrpSet   (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,2,1);
		IFSeqDurSnr.stGrp     (4);
		IFSeqSnr2.stGrpSet    (0,1,2,1, 0,0,0,1,  0,1,0,0, 0,0,0,1);
		IFSeqNtSnr2.stGrpSet  (0,1,2,3, 0,1,5,3,  0,1,2,3, 0,6,7,3);
		IFSeqVelSnr2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,1,2);
		IFSeqSusSnr2.stGrpSet (1,2,1,3, 1,2,1,2,  1,3,1,2, 1,2,3,2);

		//CH -2- [ HAT ]
		IFSeqHat.stGrpSet    (1,0,0,1, 0,1,1,0,  1,1,1,0, 1,1,1,0);
		IFSeqOctHat.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,4,3,3);
		IFSeqNtHat.stGrpSet  (0,1,1,2, 1,3,0,0,  1,2,1,0, 1,2,0,1);
		IFSeqVelHat.stGrpSet (1,3,3,1, 1,3,3,1,  1,3,3,2, 3,2,3,0);
		IFSeqSusHat.stGrpSet (3,1,2,1, 3,1,2,1,  3,1,2,1, 3,2,3,1);
		IFSeqTmHat.stGrp  (2);
		IFSeqDurHat.stGrp  (4);
		IFSeqHat2.stGrpSet    (1,1,1,0, 1,1,1,1,  1,1,0,1, 0,1,1,1);
		IFSeqNtHat2.stGrpSet  (0,0,8,3, 0,0,0,3,  0,1,2,3, 0,6,7,3);
		IFSeqVelHat2.stGrpSet (3,2,1,2, 1,2,3,2,  1,2,1,2, 1,2,1,2);
		IFSeqSusHat2.stGrpSet (1,2,1,3, 1,2,1,2,  1,3,1,2, 1,2,3,2);
		IFSeqTm2Hat.stGrp  (2);
		IFSeqDur2Hat.stGrp  (4);

		//CH -4- [Bass]
		IFSeqBass.stGrpSet    (1,1,1,1, 1,1,1,1,  1,0,1,1, 1,1,1,1);
		IFSeqOctBass.stGrpSet (2,3,3,3, 3,3,3,3,  3,3,3,3, 3,4,3,3);
		IFSeqNtBass.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,6,0, 2,0,3,2);
		IFSeqVelBass.stGrpSet (3,2,1,2, 3,2,1,3,  3,1,3,2, 3,2,3,0);
		IFSeqSusBass.stGrpSet (3,0,1,0, 0,0,1,3,  2,0,1,0, 3,3,0,0);
		IFSeqTmBass.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurBass.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.setBass(0,2,0,4,1,3,0,6,2);
		~lfo1Bass.source  =  Pseq([100,90,70,18, 100,40,60,20], inf);
		~lfo2Bass.source  =  Pseq([10,70,30,50, 80,20,90,70], inf);
		~local.sendMsg('lfoMulBass1',0.50);
		~local.sendMsg('lfoMulBass2',0.40);
		//CH -5- [Keys]
		IFSeqKeys.stGrpSet    (1,0,1,1, 0,1,0,1,  1,0,1,1, 1,1,1,1);
		IFSeqOctKeys.stGrpSet (3,3,3,3, 3,3,3,3,  2,3,3,3, 2,4,3,3);
		IFSeqNtKeys.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 2,0,3,2);
		IFSeqVelKeys.stGrpSet (1,2,1,2, 1,2,1,3,  3,1,3,2, 3,2,3,0);
		IFSeqSusKeys.stGrpSet (2,3,2,0, 2,3,4,5,  2,3,2,0, 2,2,3,0);
		IFSeqTmKeys.stGrpSet  (1,1,1,1, 1,1,1,1,  1,2,1,1, 1,1,1,1);
		IFSeqDurKeys.stGrpSet (4,4,4,4, 4,4,4,4,  4,2,4,4, 4,2,4,4);
		IFShuf.setKeys(0,2,0,4,1,3,0,6,2);
		~local.sendMsg('lfoMulKeys1',0.50);
		~local.sendMsg('lfoMulKeys2',0.6);
		~lfoRtKeys.source =  Pseq([120,40,40,100,20,100,90,110], inf);
		~lfoCtKeys.source =  Pseq([40,20,90,50,90,40,90,120], inf);
		//CH -6- [SAMP]a
		IFSeqSamp.stGrpSet    (0,1,0,1, 0,1,1,0,  1,1,0,1, 0,1,1,0);
		IFSeqOctSamp.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtSamp.stGrpSet  (6,1,2,1, 4,3,5,0,  1,0,1,2, 0,3,0,0);
		IFSeqVelSamp.stGrpSet (0,3,0,3, 0,3,0,3,  0,3,0,3, 0,3,0,3);
		IFSeqSusSamp.stGrpSet (5,5,5,0, 3,5,4,5,  5,0,0,0, 4,0,4,0);
		IFSeqTmSamp.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSamp.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.setSamp(0,6,3,4,10,3,8,5,2);
		~local.sendMsg('lfoMulSamp1',0.9);
		~local.sendMsg('lfoMulSamp2',0.8);
		~lfo1Samp.source  =  Pseq([90,10,70,90, 80,10,70,110], inf);
		~lfo2Samp.source  =  Pseq([120,10,80,99,6,10,80,99], inf);
		//CH -7- [Mopho]
		IFSeqMopho.stGrpSet    (1,0,1,1, 0,1,1,1,  0,1,1,1, 1,0,1,0);
		IFSeqOctMopho.stGrpSet (3,3,4,3, 3,4,3,4,  4,3,4,3, 3,4,3,3);
		IFSeqNtMopho.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,2,1, 0,0,0,0);
		IFSeqVelMopho.stGrpSet (4,3,0,3, 3,3,0,3,  0,3,0,3, 4,3,0,3);
		IFSeqSusMopho.stGrpSet (0,0,1,0, 4,0,1,0,  4,0,1,0, 0,3,0,5);
		IFSeqTmMopho.stGrpSet  (1,1,1,2, 1,1,1,2,  1,1,2,1, 2,1,1,1);
		IFSeqDurMopho.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.setMopho(0,2,4,13,8,1,0,6,2);
		~local.sendMsg('lfoMulMopho1',0.2);
		~local.sendMsg('lfoMulMopho2',0.9);
		~local.sendMsg('lfo1AmntMopho',0.0);
		//CH- -8- [Ext]
		~local.sendMsg('volExt',0.8);
		~local.sendMsg('susExt',0.2);
		~local.sendMsg('rlsExt',0.2);
		~local.sendMsg('extSends',0.2,0.3);


	}//////                                      - 6 -

	*part07{//////                                      - 7 -
		//IFTrack01.setActs;
		"Part 07".postln;
		~tOSCAdrr.sendMsg('partLabel', 'T1prt07');

		IFSeqSteps.long04;


		IFSeqVSnr.stGrpSet  (0,0,1,0, 0,0,1,0,  0,0,1,0, 0,0,1,0);
		~octVSnr=0;~ntVSnr.source = Pseq([20], inf);
		IFSeqVHat.stGrpSet  (0,1,0,1, 0,1,0,1,  0,1,0,1, 0,1,0,1);
		~octVHat=0;~ntVHat.source = Pseq([124], inf);

		IFSeqVClap.stGrpSet  (0,0,0,0, 0,1,0,0,  0,0,0,0, 1,0,0,0);
		~octVClap=0;~ntVClap.source = Pseq([36], inf);
		//~durVClap.source  =  Pseq([1/2], inf);

		IFSeqVTomL.stGrpSet  (1,0,0,1, 1,0,0,0,  1,0,0,0, 0,0,0,0);
		//~ntVTomL.source = Pseq([43,43,43,50], inf);
		IFSeqVTomH.stGrpSet  (1,0,0,1, 1,0,0,0,  1,0,0,0, 0,0,0,0);
		//~ntVTomH.source = Pseq([43,43,43,50], inf);
		IFSeqVCrsh.stGrpSet  (0,0,0,0, 0,0,0,1,  0,0,0,0, 0,1,0,1);
		//~ntVCrsh.source = Pseq([67,75,75,75], inf);
		IFSeqVPcm.stGrpSet  (1,0,1,0, 1,0,1,1,  0,0,1,1, 0,1,0,1);
		~ntVPcm.source = Pseq([~vCalv,~vCalv,~vCalv,~vCalv,~vAgog], inf);

		//CH -1- [ Kick ]
		IFSeqVKick.stGrpSet  (1,0,1,0, 1,0,1,0,  1,0,1,0, 1,0,1,0);
		~octVKick=0;~ntVKick.source = Pseq([7], inf);
		~local.sendMsg('sendKick', 0.0, 0.0);
		~local.sendMsg('attKick', 0.0);
		~local.sendMsg('susKick', 0.9);
		~local.sendMsg('decKick', 0.9);
		~local.sendMsg('chainKick', 0.0);
		IFSeqOctKick.stGrp (1);
		IFSeqKick.stGrpSet    (1,0,0,1, 0,1,0,1, 0,1,1,0, 0,1,0,1);
		IFSeqNtKick.stGrpSet  (0,1,0,4, 0,6,0,7,  0,1,0,0, 0,1,2,0);
		IFSeqVelKick.stGrpSet (3,1,1,3, 2,2,1,3,  0,3,1,3, 0,3,1,3);
		IFSeqSusKick.stGrpSet (1,2,1,2, 0,2,0,2,  0,2,0,2, 0,2,0,2);
		IFSeqTmKick.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurKick.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);

		IFSeqKick2.stGrpSet    (0,1,0,0, 0,1,1,0,  1,0,1,0, 1,1,0,0);
		IFSeqNtKick2.stGrpSet  (0,0,2,3, 0,1,4,3,  0,1,2,3, 0,6,7,3);
		IFSeqVelKick2.stGrpSet (1,2,1,3, 1,2,1,2,  1,2,1,3, 1,2,1,2);
		IFSeqSusKick2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,5,2);

		//CH -1- [ Snare ]
		IFSeqSnr.stGrpSet     (0,1,0,0, 0,1,0,0,  0,0,1,0, 0,1,1,0);
		IFSeqNtSnr.stGrpSet   (4,0,2,3, 4,0,2,3,  0,1,4,3, 0,4,2,3);
		IFSeqVelSnr.stGrpSet  (1,2,3,3, 1,2,3,3,  1,2,3,3, 1,2,1,3);
		IFSeqSusSnr.stGrpSet  (1,2,1,3, 1,2,3,3,  1,2,2,3, 1,2,1,3);
		IFSeqTmSnr.stGrpSet   (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,2,1);
		IFSeqDurSnr.stGrp     (4);
		IFSeqSnr2.stGrpSet    (0,1,2,1, 0,0,0,1,  0,1,0,0, 0,0,0,1);
		IFSeqNtSnr2.stGrpSet  (0,1,2,3, 0,1,5,3,  0,1,2,3, 0,6,7,3);
		IFSeqVelSnr2.stGrpSet (1,2,1,2, 1,2,1,2,  1,2,1,2, 1,2,1,2);
		IFSeqSusSnr2.stGrpSet (1,2,1,3, 1,2,1,2,  1,3,1,2, 1,2,3,2);

		//CH -2- [ HAT ]
		IFSeqHat.stGrpSet    (1,0,0,1, 0,1,1,0,  1,1,1,0, 1,1,1,0);
		IFSeqOctHat.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,4,3,3);
		IFSeqNtHat.stGrpSet  (0,1,1,2, 1,3,0,0,  1,2,1,0, 1,2,0,1);
		IFSeqVelHat.stGrpSet (1,3,3,1, 1,3,3,1,  1,3,3,2, 3,2,3,0);
		IFSeqSusHat.stGrpSet (3,1,2,1, 3,1,2,1,  3,1,2,1, 3,2,3,1);
		IFSeqTmHat.stGrp  (2);
		IFSeqDurHat.stGrp  (4);
		IFSeqHat2.stGrpSet    (1,1,1,0, 1,1,1,1,  1,1,0,1, 0,1,1,1);
		IFSeqNtHat2.stGrpSet  (0,0,8,3, 0,0,0,3,  0,1,2,3, 0,6,7,3);
		IFSeqVelHat2.stGrpSet (3,2,1,2, 1,2,3,2,  1,2,1,2, 1,2,1,2);
		IFSeqSusHat2.stGrpSet (1,2,1,3, 1,2,1,2,  1,3,1,2, 1,2,3,2);
		IFSeqTm2Hat.stGrp  (2);
		IFSeqDur2Hat.stGrp  (4);

		//CH -4- [Bass]
		IFSeqBass.stGrpSet    (1,1,1,1, 1,1,1,1,  1,0,1,1, 1,1,1,1);
		IFSeqOctBass.stGrpSet (2,3,3,3, 3,3,3,3,  3,3,3,3, 3,4,3,3);
		IFSeqNtBass.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,6,0, 2,0,3,2);
		IFSeqVelBass.stGrpSet (3,2,1,2, 3,2,1,3,  3,1,3,2, 3,2,3,0);
		IFSeqSusBass.stGrpSet (3,0,1,0, 0,0,1,3,  2,0,1,0, 3,3,0,0);
		IFSeqTmBass.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurBass.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.setBass(0,2,0,4,1,3,0,6,2);
		~lfo1Bass.source  =  Pseq([100,90,70,18, 100,40,60,20], inf);
		~lfo2Bass.source  =  Pseq([10,70,30,50, 80,20,90,70], inf);
		~local.sendMsg('lfoMulBass1',0.50);
		~local.sendMsg('lfoMulBass2',0.40);
		//CH -5- [Keys]
		IFSeqKeys.stGrpSet    (1,0,1,1, 0,1,0,1,  1,0,1,1, 1,1,1,1);
		IFSeqOctKeys.stGrpSet (3,3,3,3, 3,3,3,3,  2,3,3,3, 2,4,3,3);
		IFSeqNtKeys.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 2,0,3,2);
		IFSeqVelKeys.stGrpSet (1,2,1,2, 1,2,1,3,  3,1,3,2, 3,2,3,0);
		IFSeqSusKeys.stGrpSet (2,3,2,0, 2,3,4,5,  2,3,2,0, 2,2,3,0);
		IFSeqTmKeys.stGrpSet  (1,1,1,1, 1,1,1,1,  1,2,1,1, 1,1,1,1);
		IFSeqDurKeys.stGrpSet (4,4,4,4, 4,4,4,4,  4,2,4,4, 4,2,4,4);
		IFShuf.setKeys(0,2,0,4,1,3,0,6,2);
		~local.sendMsg('lfoMulKeys1',0.50);
		~local.sendMsg('lfoMulKeys2',0.6);
		~lfoRtKeys.source =  Pseq([120,40,40,100,20,100,90,110], inf);
		~lfoCtKeys.source =  Pseq([40,20,90,50,90,40,90,120], inf);
		//CH -6- [SAMP]a
		IFSeqSamp.stGrpSet    (0,1,0,1, 0,1,1,0,  1,1,0,1, 0,1,1,0);
		IFSeqOctSamp.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFSeqNtSamp.stGrpSet  (6,1,2,1, 4,3,5,0,  1,0,1,2, 0,3,0,0);
		IFSeqVelSamp.stGrpSet (0,3,0,3, 0,3,0,3,  0,3,0,3, 0,3,0,3);
		IFSeqSusSamp.stGrpSet (5,5,5,0, 3,5,4,5,  5,0,0,0, 4,0,4,0);
		IFSeqTmSamp.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
		IFSeqDurSamp.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.setSamp(0,6,3,4,10,3,8,5,2);
		~local.sendMsg('lfoMulSamp1',0.9);
		~local.sendMsg('lfoMulSamp2',0.8);
		~lfo1Samp.source  =  Pseq([90,10,70,90, 80,10,70,110], inf);
		~lfo2Samp.source  =  Pseq([120,10,80,99,6,10,80,99], inf);
		//CH -7- [Mopho]
		IFSeqMopho.stGrpSet    (1,0,1,1, 0,1,1,1,  0,1,1,1, 1,0,1,0);
		IFSeqOctMopho.stGrpSet (3,3,4,3, 3,4,3,4,  4,3,4,3, 3,4,3,3);
		IFSeqNtMopho.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,2,1, 0,0,0,0);
		IFSeqVelMopho.stGrpSet (4,3,0,3, 3,3,0,3,  0,3,0,3, 4,3,0,3);
		IFSeqSusMopho.stGrpSet (0,0,1,0, 4,0,1,0,  4,0,1,0, 0,3,0,5);
		IFSeqTmMopho.stGrpSet  (1,1,1,2, 1,1,1,2,  1,1,2,1, 2,1,1,1);
		IFSeqDurMopho.stGrpSet (4,4,4,4, 4,4,4,4,  4,4,4,4, 4,4,4,4);
		IFShuf.setMopho(0,2,4,13,8,1,0,6,2);
		~local.sendMsg('lfoMulMopho1',0.2);
		~local.sendMsg('lfoMulMopho2',0.9);
		~local.sendMsg('lfo1AmntMopho',0.0);
		//CH- -8- [Ext]
		~local.sendMsg('volExt',0.8);
		~local.sendMsg('susExt',0.2);
		~local.sendMsg('rlsExt',0.2);
		~local.sendMsg('extSends',0.2,0.3);


	}//////                                      - 7 -

	*part08{//////                                      - 8 -
		//IFTrack01.setActs;
		"partTxtRandom".postln;
		~tOSCAdrr.sendMsg('partLabel', 'T1prt01');
		IFSeqSteps.long01;
		IFSeqVKick.stGrpSet  (1,0,1,0, 1,0,1,0,  1,0,1,0, 1,0,1,0);
		~octVKick=4;~ntVKick.source = Pseq([0], inf);
		IFSeqVSnr.stGrpSet  (0,0,1,0, 0,0,1,0,  0,0,1,0, 0,0,1,0);
		~octVSnr=0;~ntVSnr.source = Pseq([20], inf);
		IFSeqVHat.stGrpSet  (0,1,0,1, 0,1,0,1,  0,1,0,1, 0,1,0,1);
		~octVHat=0;~ntVHat.source = Pseq([125], inf);
		IFSeqVClap.stGrpSet  (0,0,0,0, 0,1,0,0,  0,0,0,0, 0,1,0,0);
		~octVClap=0;~ntVClap.source = Pseq([36], inf);
		//CH -1- [ Kick ]
		IFSeqKick.stGrpSet    (
			~tKcAmp[0],~tKcAmp[1],~tKcAmp[2],~tKcAmp[3],
			~tKcAmp[4],~tKcAmp[5],~tKcAmp[6],~tKcAmp[7],
			~tKcAmp[8],~tKcAmp[9],~tKcAmp[10],~tKcAmp[11],
			~tKcAmp[12],~tKcAmp[13],~tKcAmp[14],~tKcAmp[15],
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
		IFSeqKick2.stGrpSet   (
			~tKc2Amp[0],~tKc2Amp[1],~tKc2Amp[2],~tKc2Amp[3],
			~tKc2Amp[4],~tKc2Amp[5],~tKc2Amp[6],~tKc2Amp[7],
			~tKc2Amp[8],~tKc2Amp[9],~tKc2Amp[10],~tKc2Amp[11],
			~tKc2Amp[12],~tKc2Amp[13],~tKc2Amp[14],~tKc2Amp[15],
		);
		IFSeqNtKick2.stGrpSet  (
			~tKc2Nt[0],~tKc2Nt[1],~tKc2Nt[2],~tKc2Nt[3],
			~tKc2Nt[4],~tKc2Nt[5],~tKc2Nt[6],~tKc2Nt[7],
			~tKc2Nt[8],~tKc2Nt[9],~tKc2Nt[10],~tKc2Nt[11],
			~tKc2Nt[12],~tKc2Nt[13],~tKc2Nt[14],~tKc2Nt[15],
		);
		IFSeqVelKick2.stGrpSet (
			~tKc2Vel[0],~tKc2Vel[1],~tKc2Vel[2],~tKc2Vel[3],
			~tKc2Vel[4],~tKc2Vel[5],~tKc2Vel[6],~tKc2Vel[7],
			~tKc2Vel[8],~tKc2Vel[9],~tKc2Vel[10],~tKc2Vel[11],
			~tKc2Vel[12],~tKc2Vel[13],~tKc2Vel[14],~tKc2Vel[15],
		);
		IFSeqSusKick2.stGrpSet (
			~tKc2Sus[0],~tKc2Sus[1],~tKc2Sus[2],~tKc2Sus[3],
			~tKc2Sus[4],~tKc2Sus[5],~tKc2Sus[6],~tKc2Sus[7],
			~tKc2Sus[8],~tKc2Sus[9],~tKc2Sus[10],~tKc2Sus[11],
			~tKc2Sus[12],~tKc2Sus[13],~tKc2Sus[14],~tKc2Sus[15],
		);
		IFSeqOctKick.stGrpSet  (
			~tKcOct[0],~tKcOct[1],~tKcOct[2],~tKcOct[3],
			~tKcOct[4],~tKcOct[5],~tKcOct[6],~tKcOct[7],
			~tKcOct[8],~tKcOct[9],~tKcOct[10],~tKcOct[11],
			~tKcOct[12],~tKcOct[13],~tKcOct[14],~tKcOct[15],
		);
		//CH -1- [ Snare ]
		IFSeqSnr.stGrpSet    (
			~tSrAmp[0],~tSrAmp[1],~tSrAmp[2],~tSrAmp[3],
			~tSrAmp[4],~tSrAmp[5],~tSrAmp[6],~tSrAmp[7],
			~tSrAmp[8],~tSrAmp[9],~tSrAmp[10],~tSrAmp[11],
			~tSrAmp[12],~tSrAmp[13],~tSrAmp[14],~tSrAmp[15],
		);
		IFSeqNtSnr.stGrpSet  (
			~tSrNt[0],~tSrNt[1],~tSrNt[2],~tSrNt[3],
			~tSrNt[4],~tSrNt[5],~tSrNt[6],~tSrNt[7],
			~tSrNt[8],~tSrNt[9],~tSrNt[10],~tSrNt[11],
			~tSrNt[12],~tSrNt[13],~tSrNt[14],~tSrNt[15],
		);
		IFSeqVelSnr.stGrpSet (
			~tSrVel[0],~tSrVel[1],~tSrVel[2],~tSrVel[3],
			~tSrVel[4],~tSrVel[5],~tSrVel[6],~tSrVel[7],
			~tSrVel[8],~tSrVel[9],~tSrVel[10],~tSrVel[11],
			~tSrVel[12],~tSrVel[13],~tSrVel[14],~tSrVel[15],
		);
		IFSeqSusSnr.stGrpSet (
			~tSrSus[0],~tSrSus[1],~tSrSus[2],~tSrSus[3],
			~tSrSus[4],~tSrSus[5],~tSrSus[6],~tSrSus[7],
			~tSrSus[8],~tSrSus[9],~tSrSus[10],~tSrSus[11],
			~tSrSus[12],~tSrSus[13],~tSrSus[14],~tSrSus[15],
		);
		IFSeqTmSnr.stGrpSet  (
			~tSrTm[0],~tSrTm[1],~tSrTm[2],~tSrTm[3],
			~tSrTm[4],~tSrTm[5],~tSrTm[6],~tSrTm[7],
			~tSrTm[8],~tSrTm[9],~tSrTm[10],~tSrTm[11],
			~tSrTm[12],~tSrTm[13],~tSrTm[14],~tSrTm[15],
		);
		IFSeqDurSnr.stGrpSet (
			~tSrDur[0],~tSrDur[1],~tSrDur[2],~tSrDur[3],
			~tSrDur[4],~tSrDur[5],~tSrDur[6],~tSrDur[7],
			~tSrDur[8],~tSrDur[9],~tSrDur[10],~tSrDur[11],
			~tSrDur[12],~tSrDur[13],~tSrDur[14],~tSrDur[15],
		);
		IFSeqSnr2.stGrpSet   (
			~tSr2Amp[0],~tSr2Amp[1],~tSr2Amp[2],~tSr2Amp[3],
			~tSr2Amp[4],~tSr2Amp[5],~tSr2Amp[6],~tSr2Amp[7],
			~tSr2Amp[8],~tSr2Amp[9],~tSr2Amp[10],~tSr2Amp[11],
			~tSr2Amp[12],~tSr2Amp[13],~tSr2Amp[14],~tSr2Amp[15],
		);
		IFSeqNtSnr2.stGrpSet  (
			~tSr2Nt[0],~tSr2Nt[1],~tSr2Nt[2],~tSr2Nt[3],
			~tSr2Nt[4],~tSr2Nt[5],~tSr2Nt[6],~tSr2Nt[7],
			~tSr2Nt[8],~tSr2Nt[9],~tSr2Nt[10],~tSr2Nt[11],
			~tSr2Nt[12],~tSr2Nt[13],~tSr2Nt[14],~tSr2Nt[15],
		);
		IFSeqVelSnr2.stGrpSet (
			~tSr2Vel[0],~tSr2Vel[1],~tSr2Vel[2],~tSr2Vel[3],
			~tSr2Vel[4],~tSr2Vel[5],~tSr2Vel[6],~tSr2Vel[7],
			~tSr2Vel[8],~tSr2Vel[9],~tSr2Vel[10],~tSr2Vel[11],
			~tSr2Vel[12],~tSr2Vel[13],~tSr2Vel[14],~tSr2Vel[15],
		);
		IFSeqSusSnr2.stGrpSet (
			~tSr2Sus[0],~tSr2Sus[1],~tSr2Sus[2],~tSr2Sus[3],
			~tSr2Sus[4],~tSr2Sus[5],~tSr2Sus[6],~tSr2Sus[7],
			~tSr2Sus[8],~tSr2Sus[9],~tSr2Sus[10],~tSr2Sus[11],
			~tSr2Sus[12],~tSr2Sus[13],~tSr2Sus[14],~tSr2Sus[15],
		);
		IFSeqOctSnr.stGrpSet  (
			~tSrOct[0],~tSrOct[1],~tSrOct[2],~tSrOct[3],
			~tSrOct[4],~tSrOct[5],~tSrOct[6],~tSrOct[7],
			~tSrOct[8],~tSrOct[9],~tSrOct[10],~tSrOct[11],
			~tSrOct[12],~tSrOct[13],~tSrOct[14],~tSrOct[15],
		);

		//CH -2- [ HAT ]
		IFSeqHat.stGrpSet    (
			~tHtAmp[0],~tHtAmp[1],~tHtAmp[2],~tHtAmp[3],
			~tHtAmp[4],~tHtAmp[5],~tHtAmp[6],~tHtAmp[7],
			~tHtAmp[8],~tHtAmp[9],~tHtAmp[10],~tHtAmp[11],
			~tHtAmp[12],~tHtAmp[13],~tHtAmp[14],~tHtAmp[15],
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
		IFSeqHat2.stGrpSet   (
			~tHt2Amp[0],~tHt2Amp[1],~tHt2Amp[2],~tHt2Amp[3],
			~tHt2Amp[4],~tHt2Amp[5],~tHt2Amp[6],~tHt2Amp[7],
			~tHt2Amp[8],~tHt2Amp[9],~tHt2Amp[10],~tHt2Amp[11],
			~tHt2Amp[12],~tHt2Amp[13],~tHt2Amp[14],~tHt2Amp[15],
		);
		IFSeqNtHat2.stGrpSet  (
			~tHt2Nt[0],~tHt2Nt[1],~tHt2Nt[2],~tHt2Nt[3],
			~tHt2Nt[4],~tHt2Nt[5],~tHt2Nt[6],~tHt2Nt[7],
			~tHt2Nt[8],~tHt2Nt[9],~tHt2Nt[10],~tHt2Nt[11],
			~tHt2Nt[12],~tHt2Nt[13],~tHt2Nt[14],~tHt2Nt[15],
		);
		IFSeqVelHat2.stGrpSet (
			~tHt2Vel[0],~tHt2Vel[1],~tHt2Vel[2],~tHt2Vel[3],
			~tHt2Vel[4],~tHt2Vel[5],~tHt2Vel[6],~tHt2Vel[7],
			~tHt2Vel[8],~tHt2Vel[9],~tHt2Vel[10],~tHt2Vel[11],
			~tHt2Vel[12],~tHt2Vel[13],~tHt2Vel[14],~tHt2Vel[15],
		);
		IFSeqSusHat2.stGrpSet (
			~tHt2Sus[0],~tHt2Sus[1],~tHt2Sus[2],~tHt2Sus[3],
			~tHt2Sus[4],~tHt2Sus[5],~tHt2Sus[6],~tHt2Sus[7],
			~tHt2Sus[8],~tHt2Sus[9],~tHt2Sus[10],~tHt2Sus[11],
			~tHt2Sus[12],~tHt2Sus[13],~tHt2Sus[14],~tHt2Sus[15],
		);
		IFSeqOctHat.stGrpSet  (
			~tHtOct[0],~tHtOct[1],~tHtOct[2],~tHtOct[3],
			~tHtOct[4],~tHtOct[5],~tHtOct[6],~tHtOct[7],
			~tHtOct[8],~tHtOct[9],~tHtOct[10],~tHtOct[11],
			~tHtOct[12],~tHtOct[13],~tHtOct[14],~tHtOct[15],
		);

		//CH -4- [Bass]
		IFSeqBass.stGrpSet    (
			~tBsAmp[0],~tBsAmp[1],~tBsAmp[2],~tBsAmp[3],
			~tBsAmp[4],~tBsAmp[5],~tBsAmp[6],~tBsAmp[7],
			~tBsAmp[8],~tBsAmp[9],~tBsAmp[10],~tBsAmp[11],
			~tBsAmp[12],~tBsAmp[13],~tBsAmp[14],~tBsAmp[15],
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
		IFSeqOctBass.stGrpSet (2,3,3,3, 2,3,3,3,  2,3,3,3, 2,4,3,3);
		IFShuf.setBass(0,1,2,-2,4,5,6,0,7);
		~lfo1Bass.source  =  Pseq([10,90,70,18, 10,40,60,20], inf);
		~lfo2Bass.source  =  Pseq([10,20,30,50, 80,20,90,70], inf);
		~local.sendMsg('lfoMulBass1',0.30);
		~local.sendMsg('lfoMulBass2',0.10);
		//CH -5- [Keys]
		IFSeqKeys.stGrpSet    (
			~tKyAmp[0],~tKyAmp[1],~tKyAmp[2],~tKyAmp[3],
			~tKyAmp[4],~tKyAmp[5],~tKyAmp[6],~tKyAmp[7],
			~tKyAmp[8],~tKyAmp[9],~tKyAmp[10],~tKyAmp[11],
			~tKyAmp[12],~tKyAmp[13],~tKyAmp[14],~tKyAmp[15],
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
		IFSeqOctKeys.stGrpSet (3,3,3,3, 3,3,3,3,  2,3,3,3, 2,4,3,3);
		IFShuf.setKeys(0,1,2,-2,4,5,6,0,7);
		~local.sendMsg('lfoMulKeys1',0.0);
		~local.sendMsg('lfoMulKeys2',0.01);
		~lfoRtKeys.source =  Pseq([20,40,40,10,20,10,90,10], inf);
		~lfoCtKeys.source =  Pseq([10,20,90,50,30,40,90,20], inf);
		//CH -6- [SAMP]a
		IFSeqSamp.stGrpSet    (
			~tSmAmp[0],~tSmAmp[1],~tSmAmp[2],~tSmAmp[3],
			~tSmAmp[4],~tSmAmp[5],~tSmAmp[6],~tSmAmp[7],
			~tSmAmp[8],~tSmAmp[9],~tSmAmp[10],~tSmAmp[11],
			~tSmAmp[12],~tSmAmp[13],~tSmAmp[14],~tSmAmp[15],
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
		IFSeqOctSamp.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
		IFShuf.setSamp(0,1,2,-2,4,5,6,0,7);
		~local.sendMsg('lfoMulSamp1',0.5);
		~local.sendMsg('lfoMulSamp2',0.4);
		~lfo1Samp.source  =  Pseq([90,1,70,9, 80,10,7,1], inf);
		~lfo2Samp.source  =  Pseq([120,10,80,99,6,10,80,99], inf);
		//CH -7- [Mopho]
		IFSeqMopho.stGrpSet    (
			~tMpAmp[0],~tMpAmp[1],~tMpAmp[2],~tMpAmp[3],
			~tMpAmp[4],~tMpAmp[5],~tMpAmp[6],~tMpAmp[7],
			~tMpAmp[8],~tMpAmp[9],~tMpAmp[10],~tMpAmp[11],
			~tMpAmp[12],~tMpAmp[13],~tMpAmp[14],~tMpAmp[15],
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
		IFSeqOctMopho.stGrpSet (3,3,4,3, 3,4,3,4,  4,3,4,3, 3,4,3,3);
		IFShuf.setMopho(0,1,2,-2,4,5,6,0,7);
		~local.sendMsg('lfoMulMopho1',0.2);
		~local.sendMsg('lfoMulMopho2',0.3);
		~local.sendMsg('lfo1AmntMopho',0.5);
		//CH- -8- [Ext]
		~local.sendMsg('volExt',0.8);
		~local.sendMsg('susExt',0.2);
		~local.sendMsg('rlsExt',0.2);
		~local.sendMsg('extSends',0.2,0.3);
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