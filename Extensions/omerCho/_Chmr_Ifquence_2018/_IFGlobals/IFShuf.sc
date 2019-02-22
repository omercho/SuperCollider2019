
IFShuf{
	*load{
		this.loadVarResps;
	}
	*transKickOn{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8|
		~transShufKick.source  = Pshuf([
			(stp1),(stp2),(stp3),(stp4),
			(stp5),(stp6),(stp7),(stp8)
		], inf);
	}
	*transKickOff{
		~transShufKick.source  = Pshuf([0], inf);
	}
	*transSnrOn{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8|
		~transShufSnr.source  = Pshuf([
			(stp1),(stp2),(stp3),(stp4),
			(stp5),(stp6),(stp7),(stp8)
		], inf);
	}
	*transSnrOff{
		~transShufSnr.source  = Pshuf([0], inf);
	}
	*transHatOn{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8|
		~transShufHat.source  = Pshuf([
			(stp1),(stp2),(stp3),(stp4),
			(stp5),(stp6),(stp7),(stp8)
		], inf);
	}
	*transHatOff{
		~transShufHat.source  = Pshuf([0], inf);
	}
	*transBassOn{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8|
		~transShufBass.source  = Pseq([
			(stp1),(stp2),(stp3),(stp4),
			(stp5),(stp6),(stp7),(stp8)
		], inf);
	}
	*transBassOff{
		~transShufBass.source  = Pseq([0], inf);
	}
	*transKeysOn{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8|
		~transShufKeys.source  = Pseq([
			(stp1),(stp2),(stp3),(stp4),
			(stp5),(stp6),(stp7),(stp8)
		], inf);
	}
	*transKeysOff{
		~transShufKeys.source  = Pseq([0], inf);
	}
	*transSampOn{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8|
		~transShufSamp.source  = Pseq([
			(stp1),(stp2),(stp3),(stp4),
			(stp5),(stp6),(stp7),(stp8)
		], inf);
	}
	*transSampOff{
		~transShufSamp.source  = Pseq([0], inf);
	}
	*transMophoOn{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8|
		~transShufMopho.source  = Pseq([
			(stp1),(stp2),(stp3),(stp4),
			(stp5),(stp6),(stp7),(stp8)
		], inf);
	}
	*transMophoOff{
		~transShufMopho.source  = Pseq([0], inf);
	}

	*loadKick{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8|
		~shufKickBut.free;
		~countShufKick=0;
		~shufKickBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//"Transpose Shuffle".postln;
				~countShufKick = ~countShufKick + 1;

				~countShufKick.switch(
					0,{},
					1, {
						this.transKickOn(stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8);
						//~apcMn.noteOn(~apcMnCh, ~actButC1, 6); //But 1
					},
					2,{
						this.transKickOff;
						//~apcMn.noteOn(~apcMnCh, ~actButC1, 5); //But 1
						//~countShufKick=0;
					}
				)
			}
			);
		},
		'/shufKick'
		);
	}
	/**loadSnr{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8|
		~shufSnrBut.free;
		~countShufSnr=0;
		~shufSnrBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//"Transpose Shuffle".postln;
				~countShufSnr = ~countShufSnr + 1;

				~countShufSnr.switch(
					0,{},
					1, {
						this.transSnrOn(stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8);
						//~apcMn.noteOn(~apcMnCh, ~actButC2, 6); //But 1
					},
					2,{
						this.transSnrOff;
						//~apcMn.noteOn(~apcMnCh, ~actButC2, 5); //But 1
						//~countShufSnr=0;
					}
				)
			}
			);
		},
		'/shufSnr'
		);
	}*/
	*loadSnr{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8|
		~shufSnrBut.free;
		~countShufSnr=0;
		~shufSnrBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//"Transpose Shuffle".postln;
				//~countShufBass = ~countShufBass + 1;

				IFShuf.transSnrOn(stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8);
			},{
				IFShuf.transSnrOff;
			}
			);
		},
		'/shufSnr'
		);
	}
	*loadHat{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8|
		~shufHatBut.free;
		~countShufHat=0;
		~shufHatBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//"Transpose Shuffle".postln;
				//~countShufBass = ~countShufBass + 1;

				IFShuf.transHatOn(stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8);
			},{
				IFShuf.transHatOff;
			}
			);
		},
		'/shufHat'
		);
	}
	*loadBass{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8|
		~shufBassBut.free;
		~countShufBass=0;
		~shufBassBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//"Transpose Shuffle".postln;
				//~countShufBass = ~countShufBass + 1;

				IFShuf.transBassOn(stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8);
			},{
				IFShuf.transBassOff;
			}
			);
		},
		'/shufBass'
		);
	}
	*loadKeys{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8|
		~shufKeysBut.free;
		~countShufKeys=0;
		~shufKeysBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//"Transpose Shuffle".postln;
				//~countShufKeys = ~countShufKeys + 1;

				IFShuf.transKeysOn(stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8);
			},{
				IFShuf.transKeysOff;
			}
			);
		},
		'/shufKeys'
		);
	}
	*loadSamp{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8|
		~shufSampBut.free;
		~countShufSamp=0;
		~shufSampBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//"Transpose Shuffle".postln;
				//~countShufSamp = ~countShufSamp + 1;

				IFShuf.transSampOn(stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8);
			},{
				IFShuf.transSampOff;
			}
			);
		},
		'/shufSamp'
		);
	}
	*loadMopho{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8|
		~shufMophoBut.free;
		~countShufMopho=0;
		~shufMophoBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//"Transpose Shuffle".postln;
				//~countShufMopho = ~countShufMopho + 1;

				IFShuf.transMophoOn(stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8);
			},{
				IFShuf.transMophoOff;
			}
			);
		},
		'/shufMopho'
		);
	}
	*harmDrumOn{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8|

		"Harmonics Shuffle".postln;
		~hrmKick.source=Pshuf([stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8], inf);
		~hrmSnr.source=Pshuf([stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8], inf);
		~hrmHat.source=Pshuf([stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8], inf);
	}
	*harmDrumOff{
		~hrmKick.source=Pshuf([1], inf);
		~hrmSnr.source=Pshuf([1], inf);
		~hrmHat.source=Pshuf([1], inf);
	}
	*harmDrum{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8|
		~shufHarmDrumBut.free;
		~countShufHarmDrum=0;
		~shufHarmDrumBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//"Transpose Shuffle".postln;
				~countShufHarmDrum = ~countShufHarmDrum + 1;

				~countShufHarmDrum.switch(
					0,{},
					1, {
						this.harmDrumOn(stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8);
						~apcMn.noteOn(~apcMnCh, ~lnchBut28, 6); //But 1
					},
					2,{
						this.harmDrumOff;
						~apcMn.noteOn(~apcMnCh, ~lnchBut28, 0); //But 1
						~local.sendMsg('harm0', 1);
						~countShufHarmDrum=0;
					}
		)});},'/shufDrumHarm');
		~harmDrum_0.free;
		~harmDrum_0 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Harmonic 0".postln;
				~harmKick=0;
				~harmSnr=0;~harmHat=0;
				//~harmBass=0;~harmKeys=0;~harmSamp=0; ~hrmMulExt=0;

				~tOSCAdrr.sendMsg('harm0', 0);
				~tOSCAdrr.sendMsg('shufDrumHarm', 0);
			});
		},'/harmDrum0');
	}
	*harmMelOn{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8|

		~hrmBass.source=Pshuf([stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8], inf);
		~hrmKeys.source=Pshuf([stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8], inf);
		~hrmSamp.source=Pshuf([stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8], inf);
		~hrmMopho.source=Pshuf([stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8], inf);
	}
	*harmMelOff{
		~hrmBass.source=Pshuf([1], inf);
		~hrmKeys.source=Pshuf([1], inf);
		~hrmSamp.source=Pshuf([1], inf);
		~hrmMopho.source=Pshuf([1], inf);
	}
	*harmMel{|stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8|
		~shufHarmMelBut.free;
		~countShufHarmMel=0;
		~shufHarmMelBut = OSCFunc({
			arg msg;
			if ( msg[1]==1, {

				//"Transpose Shuffle".postln;
				~countShufHarmMel = ~countShufHarmMel + 1;

				~countShufHarmMel.switch(
					0,{},
					1, {
						this.harmMelOn(stp1,stp2,stp3,stp4,stp5,stp6,stp7,stp8);
						~apcMn.noteOn(~apcMnCh, ~lnchBut36, 1); //But 1
					},
					2,{
						this.harmMelOff;
						~apcMn.noteOn(~apcMnCh, ~lnchBut36, 0); //But 1
						~local.sendMsg('harmMel0', 1);
						~countShufHarmMel=0;
					}
				)
			}
			);
		},
		'/shufMelHarm'
		);
		~harmMel_0.free;
		~harmMel_0 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Harmonic 0".postln;
				//~harmKick=0;
				//~harmSnr=0;~harmHat=0;
				~harmBass=0;~harmKeys=0;~harmSamp=0;
				~harmMopho=0;~hrmMulExt=0;

				~tOSCAdrr.sendMsg('harm0', 0);
				~tOSCAdrr.sendMsg('shufMelHarm', 0);
			});
		},
		'/harmMel0'
		);
	}
	*loadVarResps{
		~harmXY.free;
		~harmXY= OSCFunc({
			arg msg;

			~harmKick=msg[1];~harmSnr=msg[1];~harmHat=msg[1]+1*1.5;
			//~harmBass=msg[2];~harmKeys=msg[2];~harmSamp=msg[2]; ~hrmMulExt=msg[1];

			~tOSCAdrr.sendMsg('harm0', 1);
		},
		'/harmXY/1'
		);

		~harm_0.free;
		~harm_0 = OSCFunc({
			arg msg;
			if ( msg[1]==1, {
				"Harmonic 0".postln;
				~harmKick=0;
				~harmSnr=0;~harmHat=0;
				~harmBass=0;~harmKeys=0;~harmSamp=0;
				~harmMopho=0;~hrmMulExt=0;

				//~hrmKick.source     =  Pshuf([1], inf);
				//~hrmSnr.source     =  Pshuf([1], inf);
				//~hrmHat.source     =  Pshuf([1], inf);
				//~hrmBass.source    =  Pshuf([1], inf);
				//~hrmKeys.source    =  Pshuf([1], inf);
				//~hrmSamp.source    =  Pshuf([1], inf);
				~tOSCAdrr.sendMsg('harm0', 0);
				~tOSCAdrr.sendMsg('shufDrumHarm', 0);
				~tOSCAdrr.sendMsg('shufMelHarm', 0);
			});
		},
		'/harm0'
		);
	}

}
/*

//------------shufKick
~shufKickBut.free;
~countShufKick=0;
~shufKickBut = OSCFunc({
arg msg;
if ( msg[1]==1, {

//"Transpose Shuffle".postln;
~countShufKick = ~countShufKick + 1;

~countShufKick.switch(
0,{},
1, {
~transShufKick.source  = Pshuf([0,2,4,(7), (-2),1,12,(-1)], inf);
~transShufSnr.source  = Pshuf([(-1),3,2,(-7), (-2),4,6,(-1)], inf);
~transShufHat.source  = Pshuf([(-1),2,7,(-6), (-2),3,6,(-4)], inf);
~apcMn.noteOn(~apcMnCh, ~lnchBut5, 6); //But 1
},
2,{
~transShufKick.source  = Pshuf([0], inf);
~transShufSnr.source  = Pshuf([0], inf);
~transShufHat.source  = Pshuf([0], inf);
~apcMn.noteOn(~apcMnCh, ~lnchBut5, 5); //But 1
~countShufKick=0;
}
)
},{


}
);
},
'/shufKick'
);

~shufTransBut.free;
~countShuf=0;
~tOSCAdrr.sendMsg('shufTransLabel', 'OFF');
~tOSCAdrr.sendMsg('shufTrans', 0);
~shufTransBut = OSCFunc({
arg msg;
if ( msg[1]==1, {

//"Transpose Shuffle".postln;
~countShuf = ~countShuf + 1;

~countShuf.switch(
0,{~tOSCAdrr.sendMsg('shufTransLabel', 'OFF');
~tOSCAdrr.sendMsg('shufTrans', 0);
},
1, {

"Modal Transpose Shuffle".postln;
~tOSCAdrr.sendMsg('shufTransLabel', 'ON');
~tOSCAdrr.sendMsg('shufTrans', 1);
~transShufBass.source  = Pshuf([0,2,4,(7), 0,1,12,(-1)], inf);
~transShufKeys.source  = Pshuf([0,2,2,4, 0,4,6,1], inf);
~transShufSamp.source  = Pshuf([0,2,7,(-3), 0,(-2),3,6], inf);
~apcMn.noteOn(~apcMnCh, ~lnchBut4, 6); //But 1
},
2,{
~tOSCAdrr.sendMsg('shufTransLabel', 'OFF');
~tOSCAdrr.sendMsg('shufTrans', 0);
~transShufBass.source  = Pshuf([0], inf);
~transShufKeys.source  = Pshuf([0], inf);
~transShufSamp.source  = Pshuf([0], inf);
~apcMn.noteOn(~apcMnCh, ~lnchBut4, 5); //But 1
~countShuf=0;
}
)
},{


}
);
},
'/shufTrans'
);

//------------shufDrum
~shufDrumBut.free;
~countShufDrum=0;
~shufDrumBut = OSCFunc({
arg msg;
if ( msg[1]==1, {

//"Transpose Shuffle".postln;
~countShufDrum = ~countShufDrum + 1;

~countShufDrum.switch(
0,{},
1, {
//~transShufKick.source  = Pshuf([0,2,4,(7), (-2),1,12,(-1)], inf);
~transShufSnr.source  = Pshuf([(-1),3,2,(-7), (-2),4,6,(-1)], inf);
~transShufHat.source  = Pshuf([(-1),2,7,(-6), (-2),3,6,(-4)], inf);
~apcMn.noteOn(~apcMnCh, ~lnchBut5, 6); //But 1
},
2,{
//~transShufKick.source  = Pshuf([0], inf);
~transShufSnr.source  = Pshuf([0], inf);
~transShufHat.source  = Pshuf([0], inf);
~apcMn.noteOn(~apcMnCh, ~lnchBut5, 5); //But 1
~countShufDrum=0;
}
)
},{


}
);
},
'/shufDrum'
);

*/	