//IF Globals
//Omer Chatziserif
//Sunday, 19 Jan 2014, 20:38
//Corfu, Greece
/*
PostAllMIDI.on;
PostAllMIDI.off;

IFLoad.load;
IFLoad.loadVolca;

IFProjectGlobals.setTempo(20);
*/
	IFProjectGlobals {
	classvar <>tempo= 120;
	*initClass {
		StartUp add: {
			/*Server.default.doWhenBooted({
				0.5.wait;
			~mdClock.play
				IFSC.loadGroups;
				0.25.wait;
				IFSC.loadBuses;
				0.25.wait;
				IFSC.loadEffects;
				0.25.wait;
				IFSC.playEffects;
				0.5.wait;
				this.globals;
				this.preSetAll;
				this.setTempo(120);
				//Server.default.latency=0.0;
			});*/
		}
	}
	*load {
		this.setAddr;
		this.shiftButtons;
		//this.setTempo(122);
		IFSixteen.defaults;
		IFMIDIMix.load;
		IFAPCMn.load;
		IFApcMnNotes.load;
		//IFAPCMn_Launch.load;
		//IFLaunchSteps.load;
		IFLpMn.load;
		//IFLpMnNotes.load;
		//IFLpMnShufs.load;
		IFLpMnSteps.load;
	}
	*setAddr{
		~tOSCAdrr = NetAddr.new("192.168.1.3", 5001); // router OTE
		~local = NetAddr("localhost", 57120);

		~mdOut = MIDIOut.newByName("IAC Driver", "SC-Abl");
		~mdOutID= (539419584);
		~mdClock = MIDIClockOut("IAC Driver", "SC-Abl", TempoClock.default);
		~mdTouch = MIDIOut.newByName("TouchOSC Bridge", "TouchOSC Bridge");
		~mdTouchOutID= (-1632639753);
		~midiVel=127;
	}

	*setTempo {arg tmp;
		//Tempo.bpm=tempo;
		//~clkMaster.tempo_(1.23*tmp/60);
		~clkMaster.tempo_(tmp/60);
		~clkSq01.tempo_(tmp/60);
		~clkSq02.tempo_(tmp/60);
		~clkSq03.tempo_(tmp/60);
		~clkSq04.tempo_(tmp/60);
		~clkDrum.tempo_(tmp/60);
		~clkTom.tempo_(tmp/60);
		~clkSnr.tempo_(tmp/60);
		~clkHat.tempo_(tmp/60);
		~clkBass.tempo_(tmp/60);
		~clkKeys.tempo_(tmp/60);
		~clkMopho.tempo_(tmp/60);
		~clkSamp.tempo_(tmp/60);

		~tmp1=tmp;
		~tOSCAdrr.sendMsg('tempoLabel', tmp);
		//~vMopho.control(~chMopho, 14, tmp-30); //BPM
		Mopho.cc(\tempo,tmp);
		//~mdOut.control(15, 3, 10); //ableton global tempo
		//Tempo.bpm = tempo;
		Ableton.tap4;
	}

	*shiftButtons {
		~shiftTracksBut.free;
		~shiftTracksBut = OSCFunc({
			arg msg;
			if( msg[1]==1,{IFSixteen.tracks;},{IFSixteen.defaults;});
		},'/shiftTracks');
		~shiftPartsBut.free;
		~shiftPartsBut = OSCFunc({
			arg msg;
			if( msg[1]==1,{IFSixteen.partsTrack01;},{IFSixteen.defaults;});
		},'/shiftParts');
		~shiftPresetsBut.free;
		~shiftPresetsBut = OSCFunc({
			arg msg;
			if( msg[1]==1,{IFSixteen.presets;},{IFSixteen.defaults;});
		},'/shiftPresets');
		~shiftDurationsBut.free;
		~shiftDurationsBut = OSCFunc({
			arg msg;
			if( msg[1]==1,{IFSixteen.durations;},{IFSixteen.defaults;});
		},'/shiftDurations');
		~shiftScalesBut.free;
		~shiftScalesBut = OSCFunc({
			arg msg;
			if( msg[1]==1,{IFSixteen.scales;},{IFSixteen.defaults;});
		},'/shiftScales');
		~shiftDirectionsBut.free;
		~shiftDirectionsBut = OSCFunc({
			arg msg;
			if( msg[1]==1,{IFSixteen.directions;},{IFSixteen.defaults;});
		},'/shiftDirect');
	}
}

IFGlobal{
	*set{|nt1,nt2,nt3,nt4,nt5,nt6,nt7,nt8,
		tmp,scl1,scl2,root,step|
		IFProjectGlobals.setTempo(tmp);
		IFPitch.setScl(scl1:scl1,scl2:scl2, root:root);
		IFPitch.pat(nt1,nt2,nt3,nt4,nt5,nt6,nt7,nt8);
		IFSeqSteps(direct:step);
	}
	*setKick{|vol=0.95,octMul=1,susMul=0.05,dec=0.4,dly=0.2,pan=0.1,sndX=0,sndY=0|
		IFKick.set1(\vol,vol);
		IFKick.set1(\octM,octMul);
		IFKick.set1(\susM,susMul);
		IFKick.set1(\dec,dec);
		IFKick.set1(\dly,dly);
		IFKick.set1(\pan,pan);
		IFKick.set2(\send,sndY,sndX);
	}
	*setSnr{|vol=0.95,octMul=1,susMul=0.05,dec=0.4,dly=0.2,pan=0.1,sndX=0,sndY=0|
		IFSnr.set1(\vol,vol);
		IFSnr.set1(\octM,octMul);
		IFSnr.set1(\susM,susMul);
		IFSnr.set1(\dec,dec);
		IFSnr.set1(\dly,dly);
		IFSnr.set1(\pan,pan);
		IFSnr.set2(\send,sndY,sndX);
	}
	*setHat{|vol=0.95,octMul=1,susMul=0.05,dec=0.4,dly=0.2,pan=0.1,sndX=0,sndY=0|
		IFKick.set1(\vol,vol);
		IFKick.set1(\octM,octMul);
		IFKick.set1(\susM,susMul);
		IFKick.set1(\dec,dec);
		IFKick.set1(\dly,dly);
		IFKick.set1(\pan,pan);
		IFKick.set2(\send,sndY,sndX);
	}
	*setBass{|vol=0.95,att=0,dec=0.4,sus=0.2,rls=0.1,pan=0.1,sndX=0,sndY=0,
		octMul=1,susMul=0.05,xy1X=0,xy1Y=0.1,xy2X=0,xy2Y=0.1,lfo1=0,lfo2=0|
		IFBass.set1(\vol,vol);
		IFBass.set1(\att,att);
		IFBass.set1(\dec,dec);
		IFBass.set1(\sus,sus);
		IFBass.set1(\rls,rls);
		IFBass.set1(\pan,pan);
		IFBass.set2(\send,sndY,sndX);
		//----
		IFBass.set1(\octM,octMul);
		IFBass.set1(\susM,susMul);
		IFBass.set2(\xy1,xy1Y,xy1X);
		IFBass.set2(\xy2,xy2Y,xy2X);
		IFBass.set1(\lfoM1,lfo1);
		IFBass.set1(\lfoM2,lfo2);
	}
	*setKeys{|vol=0.95,att=0.01,dec=0.4,sus=0.2,rls=0.1,pan=0.1,sndX=0,sndY=0,
		octMul=1,susMul=0.1,xy1X=0,xy1Y=0.1,xy2X=0,xy2Y=0.1,lfo1=0,lfo2=0|
		IFKeys.set1(\vol,vol);
		IFKeys.set1(\att,att);
		IFKeys.set1(\dec,dec);
		IFKeys.set1(\sus,sus);
		IFKeys.set1(\rls,rls);
		IFKeys.set1(\pan,pan);
		IFKeys.set2(\send,sndY,sndX);
		//----
		IFKeys.set1(\octM,octMul);
		IFKeys.set1(\susM,susMul);
		IFKeys.set2(\xy1,xy1Y,xy1X);
		IFKeys.set2(\xy2,xy2Y,xy2X);
		IFKeys.set1(\lfoM1,lfo1);
		IFKeys.set1(\lfoM2,lfo2);
	}
	*setMopho{|vol=0.95,att=0.001,dec=0.4,sus=0.2,rls=0.1,pan=0.1,sndX=0,sndY=0,
		octMul=1,susMul=0.05,xy1X=0,xy1Y=0.1,xy2X=0,xy2Y=0.1,lfo1=0,lfo2=0|
		IFMopho.set1(\vol,vol);
		IFMopho.set1(\att,att);
		IFMopho.set1(\dec,dec);
		IFMopho.set1(\sus,sus);
		IFMopho.set1(\rls,rls);
		IFMopho.set1(\pan,pan);
		IFMopho.set2(\send,sndY,sndX);
		//----
		IFMopho.set1(\octM,octMul);
		IFMopho.set1(\susM,susMul);
		IFMopho.set2(\xy1,xy1Y,xy1X);
		IFMopho.set2(\xy2,xy2Y,xy2X);
		IFMopho.set1(\lfoM1,lfo1);
		IFMopho.set1(\lfoM2,lfo2);
	}
	*setSamp{|vol=0.95,att=0.001,dec=0.4,sus=0.2,rls=0.1,pan=0.1,sndX=0,sndY=0,
		octMul=1,susMul=0.05,xy1X=0,xy1Y=0.1,xy2X=0,xy2Y=0.1,lfo1=0,lfo2=0|
		~local.sendMsg('volSamp', vol);
		~local.sendMsg('attSamp', att);
		~local.sendMsg('decSamp', dec);
		~local.sendMsg('susSamp', sus);
		~local.sendMsg('rlsSamp', rls);
		~local.sendMsg('panSamp', pan);
		~local.sendMsg('sendSamp', sndX*127, sndY*127);
		//--
		IFSamp.octMul(octMul);
		~local.sendMsg('susMulSamp', susMul);
		~local.sendMsg('xy1Samp', xy1X, xy1Y);
		~local.sendMsg('xy2Samp', xy2X, xy2Y);
		~local.sendMsg('lfoMulSamp1',lfo1);
		~local.sendMsg('lfoMulSamp2',lfo2);
	}
}
/*

IFProjectGlobals.times(kickT:1, snrT:1, hatT:1, bassT:1, sampT:1, ortaT:1, flatT:1, res1T:1);

~mdClock.tempo=140;

*/

/*
VBass.killAll; VKeys.killAll;

//TWELVE TONES
// 5 note scales
~scl2= Scale.minorPentatonic;   //yu
~scl2= Scale.majorPentatonic;
~scl2= Scale.ritusen;           //zhi
~scl2= Scale.egyptian;

~scl2= Scale.kumoi;
~scl2= Scale.hirajoshi;
~scl2= Scale.iwato;
~scl2= Scale.chinese;
~scl2= Scale.indian;
~scl2= Scale.pelog;

~scl2= Scale.prometheus;
~scl2= Scale.scriabin;

~scl2= Scale.gong; //MajorPentatonic
~scl2= Scale.shang; //egyptian
~scl2= Scale.jiao;
~scl2= Scale.zhi;
~scl2= Scale.yu;

// 6 note scales
~scl2= Scale.whole;
~scl2= Scale.augmented;
~scl2= Scale.augmented2;

//Partch's Otonalitiew and Utonalities
~scl2= Scale.partch_o1;
~scl2= Scale.partch_o2;
~scl2= Scale.partch_o3;
~scl2= Scale.partch_o4;
~scl2= Scale.partch_o5;
~scl2= Scale.partch_o6;
~scl2= Scale.partch_u1;
~scl2= Scale.partch_u2;
~scl2= Scale.partch_u3;
~scl2= Scale.partch_u4;
~scl2= Scale.partch_u5;
~scl2= Scale.partch_u6;

// Hexatonic modes with no tritone
~scl2= Scale.hexMajor7;
~scl2= Scale.hexDorian;
~scl2= Scale.hexPhrygian;
~scl2= Scale.hexSus;
~scl2= Scale.hexMajor6;
~scl2= Scale.hexAeolian;

// 7 Note Scales
~scl2= Scale.major; //ionian
~scl2= Scale.ionian;
~scl2= Scale.dorian;
~scl2= Scale.phrygian;
~scl2= Scale.lydian;
~scl2= Scale.mixolydian;
~scl2= Scale.aeolian;    //melodicMinorDesc
~scl2= Scale.minor;      //melodicMinorDesc
~scl2= Scale.locrian;

~scl2= Scale.harmonicMinor;
~scl2= Scale.harmonicMajor;

~scl2= Scale.melodicMinor;
~scl2= Scale.melodicMinorDesc;
~scl2= Scale.melodicMajor;

~scl2= Scale.bartok;     //MelodicMajor
~scl2= Scale.hindu;      // MelodicMajor

//Raga Modes
~scl2= Scale.todi;
~scl2= Scale.purvi;
~scl2= Scale.marva;
~scl2= Scale.bhairav;
~scl2= Scale.ahirbhairav;

~scl2= Scale.superLocrian;
~scl2= Scale.romanianMinor;
~scl2= Scale.hungarianMinor;
~scl2= Scale.neapolitanMinor;
~scl2= Scale.enigmatic;
~scl2= Scale.spanish;


//Makam Scales OC
~scl2= Scale.cargah;
~scl2= Scale.buselik;
~scl2= Scale.kurdi;
~scl2= Scale.rast;
~scl2= Scale.ussak; //beyati
~scl2= Scale.beyati;
~scl2= Scale.humayun;
~scl2= Scale.hicaz; //uzzal
~scl2= Scale.uzzal;
~scl2= Scale.zirguleliHicaz;
~scl2= Scale.huseyni;
~scl2= Scale.muhayyer; //tahir
~scl2= Scale.neva; //huseyni
~scl2= Scale.tahir;
~scl2= Scale.karcigar;
~scl2= Scale.basitSuznak;
~scl2= Scale.sipihrEski; //tahir


*/