
IFMainTrack2 {
*load {

//////                                      - 1 -
~mainSet_01 = {
			IFSeqKick.stGrpSet    (1,0,1,0, 1,0,1,0,  1,0,1,0, 1,0,1,0);
			IFSeqOctKick.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
			IFSeqNtKick.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
			IFSeqVelKick.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
			IFSeqSusKick.stGrpSet (3,0,0,0, 1,0,0,0,  1,0,0,0, 1,0,0,0);
			IFSeqTmKick.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
			IFSeqDurKick.stGrpSet (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
//CH -1- [ Snare ]
			IFSeqSnr.stGrpSet    (0,0,1,0, 0,0,1,0,  0,0,1,0, 0,1,1,0);
			IFSeqOctSnr.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
			IFSeqNtSnr.stGrpSet  (1,2,0,3, 4,5,0,6,  7,8,0,9, 0,0,0,0);
			IFSeqVelSnr.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
			IFSeqSusSnr.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
			IFSeqTmSnr.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
			IFSeqDurSnr.stGrpSet (1,1,1,1, 1,1,1,1,  1,1,3,1, 1,1,1,1);
//CH -2- [ HAT ]
			IFSeqHat.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
			IFSeqOctHat.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
			IFSeqNtHat.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
			IFSeqVelHat.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
			IFSeqSusHat.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
			IFSeqTmHat.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
			IFSeqDurHat.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
			//IFSeqDurKick.stGrp (2);
//CH -4- [Bass]
			IFSeqBass.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
			IFSeqOctBass.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
			IFSeqNtBass.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
			IFSeqVelBass.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
			IFSeqSusBass.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
			IFSeqTmBass.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
			IFSeqDurBass.stGrpSet (4,1,1,1, 4,1,1,1,  1,1,1,1, 1,1,1,1);
	~lfo1Bass.source  =  Pseq([30,90,70,18, 0,10,60,20], inf);
	~lfo2Bass.source  =  Pseq([10,20,110,50], inf);
//CH -5- [Keys]
			IFSeqKeys.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
			IFSeqOctKeys.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
			IFSeqNtKeys.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
			IFSeqVelKeys.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
			IFSeqSusKeys.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
			IFSeqTmKeys.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
			IFSeqDurKeys.stGrpSet (4,1,1,1, 4,1,1,1,  1,1,1,1, 1,1,1,1);
	~lfoRtKeys.source =  Pseq([20,40,40,10], inf);
	~lfoCtKeys.source =  Pseq([10,20,50,50], inf);
//CH -6- [SAMP]
			IFSeqSamp.stGrpSet    (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
			IFSeqOctSamp.stGrpSet (3,3,3,3, 3,3,3,3,  3,3,3,3, 3,3,3,3);
			IFSeqNtSamp.stGrpSet  (0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0);
			IFSeqVelSamp.stGrpSet (3,2,3,0, 3,0,3,0,  3,0,3,0, 3,0,3,0);
			IFSeqSusSamp.stGrpSet (5,2,3,0, 3,0,0,0,  5,0,0,0, 4,0,0,0);
			IFSeqTmSamp.stGrpSet  (1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1);
			IFSeqDurSamp.stGrpSet (4,1,1,1, 4,1,1,1,  1,1,1,1, 1,1,1,1);
	~lfo1Samp.source  =  Pseq([90,1,7,9, 80,10,7,1], inf);
	~lfo2Samp.source  =  Pseq([6,10,80,0.1], inf);
//Res1
	~nt1Res1.source   =  Pseq([~nt+0,~nt+1,~nt+3,~nt+0,~nt+1,~nt+0], inf);
	~dur1Res1.source  =  Pseq([1]*1, inf);
	~tmRes1.source    =  Pseq([1], inf);
};
//////                                      - 1 -


}//*load END



//Class END
}