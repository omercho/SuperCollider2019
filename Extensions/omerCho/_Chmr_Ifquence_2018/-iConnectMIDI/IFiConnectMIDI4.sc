/*

PostAllMIDI.on;
PostAllMIDI.off;


IFiConnectMIDI4.load;
IFiConnectMIDI4.playPatterns;
IFiConnectMIDI4.stopPatterns;

//to find MIDIIn src
(
c = NoteOnResponder({ |src,chan,note,vel|
        [src,chan,note,vel].postln;
    });
    c.learn; // wait for the first note
)

//to find MIDIOut src
~vBass.uid;
~vSampler.uid;
~vMopho.uid;
~vKeys.uid;
~elstc.uid;
~iC_Mac.uid;
~lpMn.uid;
~mdMix.uid;
~apcMn.uid;
~djMix.uid;
~djMn.uid;


*/

IFiConnectMIDI4{
	*initClass {
		StartUp add: {
			Server.default.doWhenBooted({this.load; });
		}
	}
	*load{

		~hstPort1=(1045905020);~hstPort2=(914608399);
		~hstPort3=(-694708014);~hstPort4=(563831859);
		~hstPort5=(1843132735);~hstPort6=(1105562645);
		~hstPort7=(-1298760971);~hstPort8=(763699131);
		~hstPort9=(1351388686);~hstPort10=(1820442188);
		~hstPort11=(-421217710);~hstPort12=(-1481845706);
		~hstPort13=();~hstPort14=();
		~hstPort15=();~hstPort16=();

		~iC_iPhone = MIDIOut.newByName("iConnectMIDI4+", "USB3 usb1");
		~iC_iPhoneOutID=(-426163114);
		~iC_iPhoneInID=~hstPort1;
		//~iC_iPhoneClockOut = MIDIClockOut("iConnectMIDI4+", "USB3 usb1", TempoClock.default);

		~elstc = MIDIOut.newByName("iConnectMIDI4+", "USB3 usb1");
		~elstcOutID=(-1012629108);
		~elstcInID=~hstPort1;
		//~elstcClockOut = MIDIClockOut("iConnectMIDI4+", "USB3 Usb1", TempoClock.default);

		~iC_Mac = MIDIOut.newByName("iConnectMIDI4+", "USB3 usb3");
		~iC_MacOutID=(-1628274097);
		~iC_iPhoneInID=(1980474828);

		~vBass = MIDIOut.newByName("iConnectMIDI4+", "USB3 DIN1");
		~vBassOutID=(967907784);

		~vKeys = MIDIOut.newByName("iConnectMIDI4+", "USB3 DIN2");
		~vKeysOutID=(177010293);
		//~vSamplerInID=~hstPort1;

		~vMopho = MIDIOut.newByName("iConnectMIDI4+", "USB3 DIN3");
		~vMophoOutID=(-1799991722);
		//~vMophoInID=~hstPort1;

		~lpMn = MIDIOut.newByName("iConnectMIDI4+", "USB3 HST1 LPMn");
		~lpMnOutID=(-1057850943);
		~lpMnInID=(1761293288);

		~mdMix = MIDIOut.newByName("iConnectMIDI4+", "USB3 HST2 MDMx");
		~mdMixOutID=(-1882635398);
		~mdMixInID=(1697062282);

		~apcMn = MIDIOut.newByName("iConnectMIDI4+", "USB3 HST3 APCMn");
		~apcMnOutID=(2078144719);
		~apcMnInID=(-877687627);

		~djMix = MIDIOut.newByName("iConnectMIDI4+", "USB3 HST4 DJMx");
		~djMixOutID=(-2126449294);
		~djMixInID=(919558582);

		~djMn = MIDIOut.newByName("iConnectMIDI4+", "USB3 HST5 DJMn");
		~djMnOutID=(432114873);
		~djMnInID=(1292133807);


	}//loadAtStart

}

/*
~iC_iPhone.uid;

~iC_iPhone.noteOn(0, 1, 127); //But 1
~iC_ESI1.noteOn(0, 37, 127); //But 1
~iC_iPhone.noteOn(15, 38, 127); //But 1
~iC_iPhone.noteOn(15, 39, 127); //But 1
~iC_iPhone.noteOn(15, 40, 127); //But 1
~iC_iPhone.noteOn(15, 41, 127); //But 1


~iCElstc1=Pbind(
			\chan, Pseq([0], inf),
			\type, \midi, \midiout,~iCUSB1,
			\dur, Pseq([0.25],inf),
			\octave,0,
			\note, Pseq([[36,37],37,[36,37],37,[38,37,39],40], inf),
			\amp, Pseq([1], inf)
		).play;

~iCUSB1.noteOff(15, 36, 0); //But 1

~iCUSB1.control(0, 1, 20); // slideTime


*/