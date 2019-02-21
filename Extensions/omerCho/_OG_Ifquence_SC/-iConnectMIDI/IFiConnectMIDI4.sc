/*

PostAllMIDI.on;
PostAllMIDI.off;


IFiConnectMIDI4.load;
IFiConnectMIDI4.playPatterns;
IFiConnectMIDI4.stopPatterns;

*/

IFiConnectMIDI4{
	*load{

		~hstPort1=(1045905020);~hstPort2=(914608399);
		~hstPort3=(-694708014);~hstPort4=(563831859);
		~hstPort5=(1843132735);~hstPort6=(1105562645);
		~hstPort7=(-1298760971);~hstPort8=(763699131);
		~hstPort9=(1351388686);~hstPort10=(1820442188);
		~hstPort11=(-421217710);~hstPort12=(-1481845706);
		//~hstPort13=();~hstPort14=();
		//~hstPort15=();~hstPort16=();

		~iC_iPhone = MIDIOut.newByName("iConnectMIDI4+", "USB3 USB1 iPh");
		~iC_iPhoneOutID=(-426163114);
		~iC_iPhoneInID=~hstPort1;
		~iC_iPhoneClockOut = MIDIClockOut("iConnectMIDI4+", "USB3 USB1 iPh", TempoClock.default);

		~iC_ESI1 = MIDIOut.newByName("iConnectMIDI4+", "USB3 HST4 ESI1");
		~iC_ESI1OutID=(-1638161785);
		~iC_ESI2 = MIDIOut.newByName("iConnectMIDI4+", "USB3 HST5 ESI2");
		~iC_ESI2OutID=(-1638161785);




	}//loadAtStart

	*playPatterns{
		~iC_iPhoneClockOut.play;
		~iCElstc1=Pbind(
			\chan, Pseq([0], inf),
			\type, \midi, \midiout,~iC_iPhone,
			\octave,0,
			\dur, Pseq([0.5],inf),
			\note, Pseq([1], inf),
			\amp, Pseq([1], inf)
		).play;
		~iCElstc2=Pbind(
			\chan, Pseq([0], inf),
			\type, \midi, \midiout,~iC_iPhone,
			\octave,0,
			\dur, Pseq([0.25],inf),
			\note, Pseq([2], inf),
			\amp, Pseq([1], inf)
		).play;
		~iCElstc3=Pbind(
			\type, \midi, \midiout,~iC_iPhone,
			\chan, Pseq([0], inf),\octave,0,
			\dur, Pseq([0.5,0.25,0.25,0.5,1],inf),
			\note, Pseq([3], inf),
			\amp, Pseq([1,0.7,0.9,0.5], inf)
		).play;
		~iCElstc4=Pbind(
			\type, \midi, \midiout,~iC_iPhone,
			\chan, Pseq([0], inf),\octave,0,
			\dur, Pseq([0.5,0.25,0.25,0.5,1]*0.5,inf),
			\note, Pseq([4,5,4,6,5,4], inf),
			\amp, Pseq([1,0.7,0.9,0.5], inf)
		).play;
	}

	*stopPatterns{
		~iC_iPhoneClockOut.stop;
		~iCElstc1.stop;
		~iCElstc2.stop;
		~iCElstc3.stop;
		~iCElstc4.stop;
		~iCElstc5.stop;
		~iCElstc6.stop;
	}
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