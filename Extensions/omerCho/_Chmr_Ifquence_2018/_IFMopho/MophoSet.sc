/*
/*
Mopho.masterTranspose(12);
Mopho.masterTune(1);
Mopho.midiClock(0);
Mopho.parameterSend(1);
Mopho.parameterReceive(0);
Mopho.controllerSendReceive(1);
Mopho.sysexSendReceive(1);
Mopho.audioOut(0);
Mopho.midiOut(1);
*/
MophoSet(\default);
MophoSet.makeOSCResps;

Mopho.cc(\extIn, 127);

*/
MophoSet{
	*new{|key,val|
		key.switch(
			\default,{
				("MophoSet"+key).postln;
				Mopho.cc(\extIn, 0);
				Mopho.cc(\noise, 0);
				Mopho.cc(\voiVol, 124);

				Mopho.cc(\osc1Freq, 36);
				Mopho.cc(\osc1Tune,50);
				Mopho.cc(\osc1Shape,1);
				Mopho.cc(\osc1Glide,0);
				Mopho.cc(\osc1Kybrd,2);
				Mopho.cc(\osc1Sub, 0);

				Mopho.cc(\osc2Freq, 36);
				Mopho.cc(\osc2Tune,53);
				Mopho.cc(\osc2Shape,3);
				Mopho.cc(\osc2Glide,0);
				Mopho.cc(\osc2Kybrd,2);
				Mopho.cc(\osc2Sub, 0);

				Mopho.cc(\oscMix, 63);
				Mopho.cc(\oscSync, 1);
				Mopho.cc(\oscSlop, 1);
				Mopho.cc(\keyMode, 1);
				Mopho.cc(\glideMode, 1);

				Mopho.cc(\lpfFreq, 10);
				Mopho.cc(\lpfRes, 0);
				Mopho.cc(\lpfAmnt, 80);
				Mopho.cc(\lpfVel, 120);
				Mopho.cc(\lpfKeyAmnt, 100);
				Mopho.cc(\lpfAudMod, 40);
				Mopho.cc(\lpfPole, 0);
				Mopho.cc(\lpfEnvAtt, 0);
				Mopho.cc(\lpfEnvDec, 68);
				Mopho.cc(\lpfEnvSus, 40);
				Mopho.cc(\lpfEnvRls, 40);

				Mopho.cc(\vcaLvl, 120);
				Mopho.cc(\vcaAmnt, 120);
				Mopho.cc(\vcaVel, 127);
				Mopho.cc(\vcaEnvAtt, 0);
				Mopho.cc(\vcaEnvDec, 50);
				Mopho.cc(\vcaEnvSus, 100);
				Mopho.cc(\vcaEnvRls, 20);

				Mopho.cc('lfo1Dest', 0);
				Mopho.cc('lfo2Dest', 0);
				Mopho.cc('lfo3Dest', 0);
				Mopho.cc('lfo4Dest', 0);
				Mopho.cc('lfo1Amnt', 0);
				Mopho.cc('lfo2Amnt', 0);
				Mopho.cc('lfo3Amnt', 0);
				Mopho.cc('lfo4Amnt', 0);
				Mopho.cc('lfo1Freq', 0);
				Mopho.cc('lfo2Freq', 0);
				Mopho.cc('lfo3Freq', 0);
				Mopho.cc('lfo4Freq', 0);
				Mopho.cc('lfo1Shape', 0);
				Mopho.cc('lfo2Shape', 0);
				Mopho.cc('lfo3Shape', 0);
				Mopho.cc('lfo4Shape', 0);
				Mopho.cc('lfo1KeySync', 0);
				Mopho.cc('lfo2KeySync', 0);
				Mopho.cc('lfo3KeySync', 0);
				Mopho.cc('lfo4KeySync', 0);

				Mopho.cc('env3Dest', 0);
				Mopho.cc(\env3Amnt, 127);
				Mopho.cc(\env3Vel, 0);
				Mopho.cc(\env3Att, 0);
				Mopho.cc(\env3Dec, 0);
				Mopho.cc(\env3Sus, 0);
				Mopho.cc(\env3Rls, 0);
				Mopho.cc('mod1Dest', 0);
				Mopho.cc('mod2Dest', 0);
				Mopho.cc('mod3Dest', 0);
				Mopho.cc('mod4Dest', 0);
				Mopho.cc('mod1Src', 0);
				Mopho.cc('mod2Src', 0);
				Mopho.cc('mod3Src', 0);
				Mopho.cc('mod4Src', 0);
				Mopho.cc(\mod1Amnt, 127);
				Mopho.cc(\mod2Amnt, 127);
				Mopho.cc(\mod3Amnt, 127);
				Mopho.cc(\mod4Amnt, 127);
			},
			\oc01,{
				("MophoSet"+key).postln;
				Mopho.cc(\extIn, 64);
				Mopho.cc(\noise, 0);
				Mopho.cc(\voiVol, 126);

				Mopho.cc(\osc1Freq, 36);
				Mopho.cc(\osc1Tune,50);
				Mopho.cc(\osc1Shape,1);
				Mopho.cc(\osc1Glide,0);
				Mopho.cc(\osc1Kybrd,2);
				Mopho.cc(\osc1Sub, 0);

				Mopho.cc(\osc2Freq, 36);
				Mopho.cc(\osc2Tune,53);
				Mopho.cc(\osc2Shape,3);
				Mopho.cc(\osc2Glide,0);
				Mopho.cc(\osc2Kybrd,2);
				Mopho.cc(\osc2Sub, 0);

				Mopho.cc(\oscMix, 63);
				Mopho.cc(\oscSync, 1);
				Mopho.cc(\oscSlop, 1);
				Mopho.cc(\keyMode, 1);
				Mopho.cc(\glideMode, 1);

				Mopho.cc(\lpfFreq, 10);
				Mopho.cc(\lpfRes, 0);
				Mopho.cc(\lpfAmnt, 60);
				Mopho.cc(\lpfVel, 100);
				Mopho.cc(\lpfKeyAmnt, 100);
				Mopho.cc(\lpfAudMod, 80);
				Mopho.cc(\lpfPole, 1);
				Mopho.cc(\lpfEnvAtt, 0);
				Mopho.cc(\lpfEnvDec, 68);
				Mopho.cc(\lpfEnvSus, 60);
				Mopho.cc(\lpfEnvRls, 20);

				Mopho.cc(\vcaLvl, 10);
				Mopho.cc(\vcaAmnt, 90);
				Mopho.cc(\vcaVel, 127);
				Mopho.cc(\vcaEnvAtt, 0);
				Mopho.cc(\vcaEnvDec, 90);
				Mopho.cc(\vcaEnvSus, 100);
				Mopho.cc(\vcaEnvRls, 60);

				Mopho.cc('lfo1Dest', 0);
				Mopho.cc('lfo2Dest', 0);
				Mopho.cc('lfo3Dest', 0);
				Mopho.cc('lfo4Dest', 0);
				Mopho.cc('lfo1Amnt', 0);
				Mopho.cc('lfo2Amnt', 0);
				Mopho.cc('lfo3Amnt', 0);
				Mopho.cc('lfo4Amnt', 0);
				Mopho.cc('lfo1Freq', 0);
				Mopho.cc('lfo2Freq', 0);
				Mopho.cc('lfo3Freq', 0);
				Mopho.cc('lfo4Freq', 0);
				Mopho.cc('lfo1Shape', 0);
				Mopho.cc('lfo2Shape', 0);
				Mopho.cc('lfo3Shape', 0);
				Mopho.cc('lfo4Shape', 0);
				Mopho.cc('lfo1KeySync', 0);
				Mopho.cc('lfo2KeySync', 0);
				Mopho.cc('lfo3KeySync', 0);
				Mopho.cc('lfo4KeySync', 0);

				Mopho.cc(\env3Amnt, 127);
				Mopho.cc('env3Dest', 0);
				Mopho.cc(\env3Vel, 0);
				Mopho.cc(\env3Att, 0);
				Mopho.cc(\env3Dec, 0);
				Mopho.cc(\env3Sus, 0);
				Mopho.cc(\env3Rls, 0);
				Mopho.cc('mod1Dest', 0);
				Mopho.cc('mod2Dest', 0);
				Mopho.cc('mod3Dest', 0);
				Mopho.cc('mod4Dest', 0);
				Mopho.cc('mod1Src', 0);
				Mopho.cc('mod2Src', 0);
				Mopho.cc('mod3Src', 0);
				Mopho.cc('mod4Src', 0);
				Mopho.cc(\mod1Amnt, 127);
				Mopho.cc(\mod2Amnt, 127);
				Mopho.cc(\mod3Amnt, 127);
				Mopho.cc(\mod4Amnt, 127);
			},
			\oc02,{
				("MophoSet"+key).postln;
				Mopho.cc(\extIn, 64);
				Mopho.cc(\noise, 0);
				Mopho.cc(\voiVol, 126);

				Mopho.cc(\osc1Freq, 36);
				Mopho.cc(\osc1Tune,50);
				Mopho.cc(\osc1Shape,1);
				Mopho.cc(\osc1Glide,0);
				Mopho.cc(\osc1Kybrd,2);
				Mopho.cc(\osc1Sub, 0);

				Mopho.cc(\osc2Freq, 36);
				Mopho.cc(\osc2Tune,53);
				Mopho.cc(\osc2Shape,3);
				Mopho.cc(\osc2Glide,10);
				Mopho.cc(\osc2Kybrd,2);
				Mopho.cc(\osc2Sub, 0);

				Mopho.cc(\oscMix, 68);
				Mopho.cc(\oscSync, 1);
				Mopho.cc(\oscSlop, 1);
				Mopho.cc(\keyMode, 1);
				Mopho.cc(\glideMode, 1);

				Mopho.cc(\lpfFreq, 10);
				Mopho.cc(\lpfRes, 20);
				Mopho.cc(\lpfAmnt, 60);
				Mopho.cc(\lpfVel, 100);
				Mopho.cc(\lpfKeyAmnt, 100);
				Mopho.cc(\lpfAudMod, 80);
				Mopho.cc(\lpfPole, 2);
				Mopho.cc(\lpfEnvAtt, 0);
				Mopho.cc(\lpfEnvDec, 68);
				Mopho.cc(\lpfEnvSus, 90);
				Mopho.cc(\lpfEnvRls, 20);

				Mopho.cc(\vcaLvl, 0);
				Mopho.cc(\vcaAmnt, 90);
				Mopho.cc(\vcaVel, 127);
				Mopho.cc(\vcaEnvAtt, 0);
				Mopho.cc(\vcaEnvDec, 90);
				Mopho.cc(\vcaEnvSus, 100);
				Mopho.cc(\vcaEnvRls, 60);

				Mopho.cc('lfo1Dest', 4);
				Mopho.cc('lfo2Dest', 6);
				Mopho.cc('lfo3Dest', 8);
				Mopho.cc('lfo4Dest', 10);
				Mopho.cc('lfo1Amnt', 22);
				Mopho.cc('lfo2Amnt', 12);
				Mopho.cc('lfo3Amnt', 33);
				Mopho.cc('lfo4Amnt', 42);
				Mopho.cc('lfo1Freq', 1);
				Mopho.cc('lfo2Freq', 3);
				Mopho.cc('lfo3Freq', 4);
				Mopho.cc('lfo4Freq', 2);
				Mopho.cc('lfo1Shape', 1);
				Mopho.cc('lfo2Shape', 6);
				Mopho.cc('lfo3Shape', 4);
				Mopho.cc('lfo4Shape', 2);
				Mopho.cc('lfo1KeySync', 1);
				Mopho.cc('lfo2KeySync', 1);
				Mopho.cc('lfo3KeySync', 1);
				Mopho.cc('lfo4KeySync', 1);

				Mopho.cc(\env3Amnt, 127);
				Mopho.cc('env3Dest', 3);
				Mopho.cc(\env3Vel, 27);
				Mopho.cc(\env3Att, 0);
				Mopho.cc(\env3Dec, 0);
				Mopho.cc(\env3Sus, 0);
				Mopho.cc(\env3Rls, 0);
				Mopho.cc('mod1Dest', 0);
				Mopho.cc('mod2Dest', 0);
				Mopho.cc('mod3Dest', 0);
				Mopho.cc('mod4Dest', 0);
				Mopho.cc('mod1Src', 0);
				Mopho.cc('mod2Src', 0);
				Mopho.cc('mod3Src', 0);
				Mopho.cc('mod4Src', 0);
				Mopho.cc(\mod1Amnt, 127);
				Mopho.cc(\mod2Amnt, 127);
				Mopho.cc(\mod3Amnt, 127);
				Mopho.cc(\mod4Amnt, 127);
			},
		)
		/*
		MophoSet.(\voiVol_lcl,20);
		MophoSet.rand(\oscs);
		Mopho.cc(\osc1Freq, 36);
		Mopho.cc(\osc1Shape, (0..3).choose);
		Mopho.cc(\osc2Freq, 6*8);
		Mopho.cc(\osc2Shape, (0..3).choose);
		MophoSet.randSmooth(\oscs);
		MophoSet.randSmooth(\filt);
		MophoSet.randSmooth(\vca);
		MophoSet.rand(\lfo);
		MophoSet.rand(\mod);
		~local.sendMsg('MPHosc1Freq', 1.0.rrand(0.0));
		~local.sendMsg('MPHvoiVol', 1);
		*/
	}
	*rand{|key,min=0,max=1|
		key.switch(
			'oscs',{
				Mopho.cc(\osc1Freq, (0..127).choose);
				Mopho.cc(\osc1Tune, (0..103).choose);
				Mopho.cc(\osc1Shape, (0..127).choose);
				Mopho.cc(\osc1Glide, (0..127).choose);
				Mopho.cc(\osc1Sub, (0..127).choose);
				Mopho.cc(\osc1Kybrd, [0,1].choose);
				Mopho.cc(\osc2Freq, (0..127).choose);
				Mopho.cc(\osc2Tune, (0..103).choose);
				Mopho.cc(\osc2Shape, (0..127).choose);
				Mopho.cc(\osc2Glide, (0..127).choose);
				Mopho.cc(\osc2Sub, (0..127).choose);
				Mopho.cc(\osc2Kybrd, [0,1].choose);

				Mopho.cc(\oscMix, (0..127).choose);
				Mopho.cc(\extIn, (0..127).choose);
				Mopho.cc(\noise, (0..127).choose);
				Mopho.cc(\oscSync, [0,1].choose);
				Mopho.cc(\oscSlop, (0..5).choose);
				Mopho.cc(\keyMode, (0..5).choose);
				Mopho.cc(\glideMode, (0..3).choose);
			},
			'filt',{
				Mopho.cc(\lpfFreq, (0..127).choose);
				Mopho.cc(\lpfRes, (0..127).choose);
				Mopho.cc(\lpfAmnt, (0..127).choose);
				Mopho.cc(\lpfVel, (0..127).choose);
				Mopho.cc(\lpfKeyAmnt, (0..127).choose);
				Mopho.cc(\lpfAudMod, (0..127).choose);
				Mopho.cc(\lpfPole, [0,1].choose);
				Mopho.cc(\lpfEnvAtt, (0..127).choose);
				Mopho.cc(\lpfEnvDec, (0..127).choose);
				Mopho.cc(\lpfEnvSus, (0..127).choose);
				Mopho.cc(\lpfEnvRls, (0..127).choose);

			},
			'vca',{
				Mopho.cc(\vcaLvl, (0..127).choose);
				Mopho.cc(\vcaAmnt, (0..127).choose);
				Mopho.cc(\vcaVel, (0..127).choose);
				Mopho.cc(\vcaEnvAtt, (0..127).choose);
				Mopho.cc(\vcaEnvDec, (0..127).choose);
				Mopho.cc(\vcaEnvSus, (0..127).choose);
				Mopho.cc(\vcaEnvRls, (0..127).choose);

			},
			'lfo', {

				Mopho.cc('lfo1Dest', (0..46).choose);
				Mopho.cc('lfo2Dest', (0..46).choose);
				Mopho.cc('lfo3Dest', (0..46).choose);
				Mopho.cc('lfo4Dest', (0..46).choose);
				Mopho.cc('lfo1Amnt', (0..127).choose);
				Mopho.cc('lfo2Amnt', (0..127).choose);
				Mopho.cc('lfo3Amnt', (0..127).choose);
				Mopho.cc('lfo4Amnt', (0..127).choose);
				Mopho.cc('lfo1Freq', (0..127).choose);
				Mopho.cc('lfo2Freq', (0..127).choose);
				Mopho.cc('lfo3Freq', (0..127).choose);
				Mopho.cc('lfo4Freq', (0..127).choose);
				Mopho.cc('lfo1Shape', (0..4).choose);
				Mopho.cc('lfo2Shape', (0..4).choose);
				Mopho.cc('lfo3Shape', (0..4).choose);
				Mopho.cc('lfo4Shape', (0..4).choose);
				Mopho.cc('lfo1KeySync', [0,1].choose);
				Mopho.cc('lfo2KeySync', [0,1].choose);
				Mopho.cc('lfo3KeySync', [0,1].choose);
				Mopho.cc('lfo4KeySync', [0,1].choose);
			},
			'mod', {
				Mopho.cc('env3Dest', (0..46).choose);
				Mopho.cc(\env3Amnt, (0..254).choose);
				Mopho.cc(\env3Vel, (0..127).choose);
				Mopho.cc(\env3Att, (0..127).choose);
				Mopho.cc(\env3Dec, (0..127).choose);
				Mopho.cc(\env3Sus, (0..127).choose);
				Mopho.cc(\env3Rls, (0..127).choose);
				Mopho.cc('mod1Dest', (0..46).choose);
				Mopho.cc('mod2Dest', (0..46).choose);
				Mopho.cc('mod3Dest', (0..46).choose);
				Mopho.cc('mod4Dest', (0..46).choose);
				Mopho.cc('mod1Src', (0..22).choose);
				Mopho.cc('mod2Src', (0..22).choose);
				Mopho.cc('mod3Src', (0..22).choose);
				Mopho.cc('mod4Src', (0..22).choose);
				Mopho.cc(\mod1Amnt, (0..254).choose);
				Mopho.cc(\mod2Amnt, (0..254).choose);
				Mopho.cc(\mod3Amnt, (0..254).choose);
				Mopho.cc(\mod4Amnt, (0..254).choose);
			}
		);
	}//rand
	*randSmooth{|key,min=0,max=1|
		key.switch(
			'oscs',{
				Mopho.cc(\osc1Freq, (40..80).choose);
				Mopho.cc(\osc1Tune, (0..103).choose);
				Mopho.cc(\osc1Shape, (0..100).choose);
				Mopho.cc(\osc1Glide, (0..100).choose);
				Mopho.cc(\osc1Sub, (0..90).choose);
				Mopho.cc(\osc1Kybrd, [0,1].choose);
				Mopho.cc(\osc2Freq, (50..70).choose);
				Mopho.cc(\osc2Tune, (0..103).choose);
				Mopho.cc(\osc2Shape, (0..107).choose);
				Mopho.cc(\osc2Glide, (0..127).choose);
				Mopho.cc(\osc2Sub, (0..70).choose);
				Mopho.cc(\osc2Kybrd, [0,1].choose);

				Mopho.cc(\oscMix, (40..100).choose);
				Mopho.cc(\extIn, (0..107).choose);
				//Mopho.cc(\noise, (0..127).choose);
				Mopho.cc(\oscSync, [0,1].choose);
				Mopho.cc(\oscSlop, (0..5).choose);
				Mopho.cc(\keyMode, (0..5).choose);
				Mopho.cc(\glideMode, (0..3).choose);
			},
			'filt',{
				Mopho.cc(\lpfFreq, (30..97).choose);
				Mopho.cc(\lpfRes, (0..77).choose);
				Mopho.cc(\lpfAmnt, (0..107).choose);
				Mopho.cc(\lpfVel, (0..127).choose);
				Mopho.cc(\lpfKeyAmnt, (0..127).choose);
				Mopho.cc(\lpfAudMod, (0..127).choose);
				Mopho.cc(\lpfPole, [0,1].choose);
				Mopho.cc(\lpfEnvAtt, (0..67).choose);
				Mopho.cc(\lpfEnvDec, (10..107).choose);
				Mopho.cc(\lpfEnvSus, (0..117).choose);
				Mopho.cc(\lpfEnvRls, (10..127).choose);

			},
			'vca',{
				Mopho.cc(\vcaLvl, (0..127).choose);
				Mopho.cc(\vcaAmnt, (0..127).choose);
				Mopho.cc(\vcaVel, (40..127).choose);
				Mopho.cc(\vcaEnvAtt, (0..27).choose);
				Mopho.cc(\vcaEnvDec, (10..127).choose);
				Mopho.cc(\vcaEnvSus, (20..97).choose);
				Mopho.cc(\vcaEnvRls, (0..77).choose);

			},
			'lfo', {

				Mopho.cc('lfo1Dest', (0..46).choose);
				Mopho.cc('lfo2Dest', (0..46).choose);
				Mopho.cc('lfo3Dest', (0..46).choose);
				Mopho.cc('lfo4Dest', (0..46).choose);
				Mopho.cc('lfo1Amnt', (0..127).choose);
				Mopho.cc('lfo2Amnt', (0..127).choose);
				Mopho.cc('lfo3Amnt', (0..127).choose);
				Mopho.cc('lfo4Amnt', (0..127).choose);
				Mopho.cc('lfo1Freq', (0..127).choose);
				Mopho.cc('lfo2Freq', (0..127).choose);
				Mopho.cc('lfo3Freq', (0..127).choose);
				Mopho.cc('lfo4Freq', (0..127).choose);
				Mopho.cc('lfo1Shape', (0..4).choose);
				Mopho.cc('lfo2Shape', (0..4).choose);
				Mopho.cc('lfo3Shape', (0..4).choose);
				Mopho.cc('lfo4Shape', (0..4).choose);
				Mopho.cc('lfo1KeySync', [0,1].choose);
				Mopho.cc('lfo2KeySync', [0,1].choose);
				Mopho.cc('lfo3KeySync', [0,1].choose);
				Mopho.cc('lfo4KeySync', [0,1].choose);
			},
			'mod', {
				Mopho.cc('env3Dest', (0..46).choose);
				Mopho.cc(\env3Amnt, (0..254).choose);
				Mopho.cc(\env3Vel, (0..127).choose);
				Mopho.cc(\env3Att, (0..127).choose);
				Mopho.cc(\env3Dec, (0..127).choose);
				Mopho.cc(\env3Sus, (0..127).choose);
				Mopho.cc(\env3Rls, (0..127).choose);
				Mopho.cc('mod1Dest', (0..46).choose);
				Mopho.cc('mod2Dest', (0..46).choose);
				Mopho.cc('mod3Dest', (0..46).choose);
				Mopho.cc('mod4Dest', (0..46).choose);
				Mopho.cc('mod1Src', (0..22).choose);
				Mopho.cc('mod2Src', (0..22).choose);
				Mopho.cc('mod3Src', (0..22).choose);
				Mopho.cc('mod4Src', (0..22).choose);
				Mopho.cc(\mod1Amnt, (0..254).choose);
				Mopho.cc(\mod2Amnt, (0..254).choose);
				Mopho.cc(\mod3Amnt, (0..254).choose);
				Mopho.cc(\mod4Amnt, (0..254).choose);
			}
		);
	}//randSmooth
	*oscResp{|respName,oscName,playDir|
		var currentBpm=1;
		OSCdef(respName, {|msg|
			var val,vel;
			val=msg[1];
			vel=val*127;
			playDir.switch(
				'MPHsetRandT',{
					if ( val==1, {
						MophoSet.rand(\oscs);
						MophoSet.rand(\filt);
						MophoSet.rand(\vca);
						MophoSet.rand(\lfo);
						MophoSet.rand(\mod);
					})
				},
				'MPHsetDfltT',{
					if ( val==1, {MophoSet(\default);})
				},
			)
		},path:oscName);
	}
	*makeOSCResps{
		this.oscResp(respName:'MPHsetRandResp', oscName:'MPHsetRand', playDir:'MPHsetRandT');
		this.oscResp(respName:'MPHsetDfltResp', oscName:'MPHsetDflt', playDir:'MPHsetDfltT');

	}

}