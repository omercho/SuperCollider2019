


KafesLayerA {
	
	
	*load {
		
		~zencirLayerA = Preceive(


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////-------------------------------------- CiFTE DUYEK --------2 Levels-- 8 parts -- 1.6s -------------------------------------------------/////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
			\layer_A_1 -> {//------------------------------------------------------------------------------- A_1
//audio
fork{
	"-------A1forkLev----  1  -----".postln;
	~tol08.brt_(~kRC1 *1.07500).playBuf(0.001, 0.3, 0.1, mul:1.1, out: ~strHep);
	0.265.wait;
	
	"-------A1forkLev----  2  -----".postln;
	~tol06.brt_(~kRB1 *1.23700).playGverb(0.001, 1.1, 16.1, mul:0.8, room:165, rev:23.5, damp:0.71, out: [0,1,2,3]);
	5.6.wait;
	
	"-------A1forkLev----  3  -----".postln;
	~tol06.brt_(~kRB1 *1.23700).playGverbR(0.001, 1.1, 10.1, mul:0.5, room:55, rev:13.5, damp:0.71, out: ~strTek.choose);
	2.9.wait;
	
	"-------A1forkLev----  4  -----".postln;
	~tol06.brt_(~kRB4 *1.23700).playBufR(0.01, 3.5, 0.1, mul:0.5, out: ~strTek.choose);
	0.01.wait;
	
	"-------A1forkLev----  5  -----".postln;
	~tol06.brt_(~kRB1 *1.23700).playBufR(0.01, 4.5, 0.1, mul:0.5, out: ~strTek.choose);
	2.5.wait;
	
	"-------A1forkLev----  6  -----".postln;
	fork{
		
		~botbs.brt_(~kRC1 *1.36619).playBuf(0.001, 1.1, 3, mul:0.7, out: ~strTek.choose);
		OF.img(~imageLib.at('box', 0), 255, 255, 0, 0);
		0.5.wait;
		~botbs.brt_(~kRC4 *1.36619).playBuf(0.001, 1.1, 3, mul:0.5, out: ~strTek.choose);
		OF.img(~imageLib.at('box', 1), 255, 255, 0, 0);
		
	};
	0.25.wait;
	
	"-------A1forkLev----  7  -----".postln;
	~tol03.brt_(~kRD1 *1.07600).playBufR(0.001, 0.8, 1,4, mul:0.5, out: ~strTek.choose);
	1.5.wait;
	

};

//---vis---vis---vis---vis---vis---vis---vis---vis---vis---vis---//
OF.rect(0,0,1280, 1024);
OF.feedback("activate", 1);
OF.feedback("speedXY", (-0.15).asFloat, (-0.1).asFloat);
fork{
	~dur1 = Pseq([0.1]/4, inf).asStream;
	26.do{|i|
		
		OF.img(~imageLib.at('box', 0), (4.0+20.001*(i%100)).asInteger, (4.0+30.001*(i%100)).asInteger , 0, 0 );
		~dur1.next.wait;
		
		
	};
	
	0.65.wait;
	OF.img(~imageLib.at('box', 0), 255, 255, 0, 0);
	
	0.3.wait;
	
	~fadeOut = Pseq((255..0), 24).asStream;
	~fadeIn = Pseq((0..255), 24).asStream;
	~dur2 = Pseq([0.1]/4, inf).asStream;
	255.do{
		
		OF.img(~imageLib.at('box', 0), ~fadeOut.next, 255, 0, 0);
		~dur2.next.wait;
		
	};
	
	OF.feedback("speedXY", (-0.1).asFloat, (-0.1).asFloat);
	0.3.wait;
	124.do{
		
		OF.img(~imageLib.at('box', 1), ~fadeIn.next, 255, 0, 0);
		~dur2.next.wait;
		
	};
	OF.img(~imageLib.at('box', 2), 200, 200, 0, 0);
	0.5.wait;
	OF.img(~imageLib.at('box', 3), 200, 200, 0, 0);
	
};
				
			
				
				}, 
			\layer_A_2 -> {//------------------------------------------------------------------------------- A_2
fork{

	"-------A2forkLev----  1  -----".postln;
	~gou02.brt_(~kRC1 *0.89000).playFverb(0.001, 1.1, 10.1, mul:0.5, froom:0.8, fmix:0.5, fdamp:0.81, out: ~strHep.choose);
	OF.img(~imageLib.at('box', 3), 200, 100, 0, 0);
	0.31.wait;
	
	"-------A2forkLev----  2  -----".postln;
	OF.img(~imageLib.at('box', 4), 200, 100, 0, 0);
	~gou02.brt_(~kRB4 *0.89000).playFverb(0.001, 1.1, 10.1, mul:0.8, froom:0.8, fmix:0.5, fdamp:0.81, out: ~strHep.choose);
	0.25.wait;
	
	
	//aud
	"-------A2forkLev----  3  -----".postln;
	fork{
		~kPseq01 = Pseq([~kRC1, ~kRC3, ~kRC5, ~kRD1, ~kRC4, ~kRD1, ~kRC1, ~kRD1]/2, inf).asStream;
		29.do {|i|
		~tht02.brt_(~kPseq01.next *1.47500).playPV2(0.001, 10.3, 0.3, mul:0.09+(0.04*(i%9)), out: ~spira);
		0.1- (0.04*(i%15)).wait;	
			
		};
	};
	//---vis---vis---vis---vis---vis---vis---vis---vis---vis---vis---//
	fork{
		~cek01 = Pseq((0..4), inf).asStream;
		29.do {|i|
		OF.imgP(~imageLib.at('box', ~cek01.next), 215, rrand(25, 225), 0, 0);
		0.1- (0.04*(i%15)).wait;	
			
		};
	};	
	0.8.wait;
	
	
	
	//aud
	"-------A2forkLev----  4  -----".postln;
	~gir01.brt_(2.8).playGverbR(0.001, 1.1, 10.1, mul:0.5, room:55, rev:13.5, damp:0.71, out: ~strTek.choose);
	fork{
		12.do {
			~bth06.brt_(~kRA1 *1.00011).playPV2(0.001, 5.3, 0.3, mul:0.2, out: ~circ);
			0.4.wait;	
			
		};
	};
//---vis---vis---vis---vis---vis---vis---vis---vis---vis---vis---//
	fork{
		~cek01 = Pseq((0..4), inf).asStream;
		
		15.do {
			OF.img(~imageLib.at('box', ~cek01.next), 255, rrand(0, 155), 0, 0);
			0.4.wait	;
			
		};
	};	
	
	8.0.wait;
	"-------A2forkLev----  5  -----".postln;
	fork{
		18.do {
			~bth07.brt_(~kRA4 *1.00011).playPV2(0.001, 10.3, 0.3, mul:0.09, out: ~circ);
			0.4.wait;	
			
		};
	};
	
	0.001.wait;
	~ff = ~kC1;
	KafGendy.ar(0.001, 0.01, 4.03, 29.8,
		freq: [~ff*2, ~ff*3, ~ff*4, ~ff*5], 
		freqrlp1: ~kA1/2, 
		freqrlp2: ~ff*2,
		mul: 0.4,
		out: 0
	).play;	
	
	1.5.wait;
	"-------A2forkLev----  6  -----".postln;
	fork{
		~fadeOut = Pseq((255..0), 24).asStream;
		~fadeIn = Pseq((0..255), 24).asStream;
		~dur2 = Pseq([0.1]/2, inf).asStream;	
		255.do{
			
			OF.black(~fadeIn.next);
			~dur2.next.wait;
			
		};	
/*		25.do {
			~bth06.brt_(~kRB1 *1.00011).playPV2(0.001, 10.3, 0.3, mul:0.09, out: ~circ);
			0.4.wait;	
			
		};*/
	};
	8.00.wait;

	"-------A2forkLev----  7  -----".postln;
	fork {
		
		"-------A2forkLev----  7  -----01---".postln;
		~gir01.brt_(~kRC1 *1.19000).playBuf(2.1, 0.1, 4, loop:0, out: ~strCok.choose);
		~kik01.brt_(3.5).playPV2(0.001, 1.1, 1, mul:0.4, out: ~strTek.choose); // tek
		fork{
			4.do{
			var dur = Pseq([0.25]/5, inf).asStream;
			~gou02.brt_(~kRD3 *0.89000).playPV2(0.001, 1.1, 10.1, mul:0.2, out: ~strTek.choose);
			OF.imgP(~imageLib.at('deli', rrand(0,5)), [255, 155, 100, 55].choose, 255, 0, 0);
			dur.next.wait;
		
			};
			0.09.wait;
			~gou02.brt_(~kRD4 *0.89000).playFverb(0.001, 1.1, 10.1, mul:0.5, froom:0.5, fmix:0.5, fdamp:0.91, out: ~strTek.choose);
			OF.imgM(~imageLib.at('deli', rrand(0,5)), [255, 155, 100, 55].choose, 255, 180, 0);
			
		};
		0.25.wait;
		
		"-------A2forkLev----  7  -----02---".postln;
		fork {
			
			~gou02.brt_(~kRD5 *0.89000).playFverb(0.001, 1.1, 10.1, mul:0.2, froom:0.5, fmix:0.5, fdamp:0.91, out: ~strTek.choose);
			OF.imgY(~imageLib.at('deli', rrand(0,5)), [255, 155, 100, 55].choose, 255, 180, 0);
			
			
			0.5.wait;
			~kik01.brt_(9.5).playPV2(0.001, 1.1, 1, mul:0.1, out: ~strTek.choose); // tek
			OF.imgX(~imageLib.at('deli', rrand(0,5)), [255, 155, 100, 55].choose, 255, 180, 0);
			0.5.wait;
		};
		2.5.wait;			
		
		"-------A2forkLev----  7  -----03---".postln;
		fork{
			~kPseq01 = Pseq([~kRC1, ~kRC3, ~kRC5, ~kRD1, ~kRC4, ~kRD1, ~kRC1, ~kRD1], inf).asStream;
			11.do {|i, fr|
				var  ja;
				~bth02.brt_(~kPseq01.next *1.00011).playPV2(0.001, 10.3, 0.3, mul:0.03+(0.04*(i%9)), out: ~strTek.choose);
				OF.imgM(~imageLib.at('deli', rrand(0,5)), [255, 155, 100, 55].choose, 255, 180, 0);
				(0.4 - (0.04*(i%15))).wait;	
				
			};
			
			
		};
	
		"-------A2forkLev----  7  -----04---".postln;
		2.5.wait;
		fork{
			~kPseq01 = Pseq([~kRC1, ~kRC3, ~kRC5, ~kRD1, ~kRC4, ~kRD1, ~kRC1, ~kRD1], inf).asStream;
			12.do {|i, fr|
				var  ja;
				~gou02.brt_(~kRD5 *0.89000).playPV2(0.001, 10.3, 0.3, mul:0.01+(0.04*(i%9)), out: ~strTek.choose);
				OF.imgM(~imageLib.at('deli', rrand(0,5)), [255, 155, 100, 55].choose, 255, 180, 0);
				(0.1 + (0.04*(i%15))).wait;	
				~kik01.brt_(9.5).playPV1(0.001, 1.1, 1, mul:0.05+(0.04*(i%9)), out: ~strTek.choose); // tek
				(0.1 + (0.04*(i%15))).wait;
			};
			
			
		};
	
	
	};
	


};
			

				}, 
			\layer_A_3 -> {//------------------------------------------------------------------------------- A_3
fork {

	0.0.wait;
	"-------A3forkLev----  1  -----".postln;	

	
	
	
	0.25.wait;
	
	"-------A3forkLev----  2  -----".postln;
	fork{
		
		~kPseq01 = Pseq([~kRC1, ~kRC3, ~kRC5, ~kRD1, ~kRC4, ~kRD1, ~kRC1, ~kRD1]/2, inf).asStream;
		23.do {|i|
		~bth07.brt_(~kPseq01.next *1.00011).playPV2(0.001, 10.3, 0.3, mul:0.09+(0.04*(i%9)), out: ~spirOut);
		0.1- (0.04*(i%15)).wait;	
			
		};		
	};
	
	2.0.wait;
	~gir01.brt_(~kRC3).playFverb(2.1, 2.1, 5.3, loop:0, out: ~strTek.choose);
	//vis
/*	fork{
		~cek01 = Pseq((0..5), inf).asStream;
		
		27.do {|i|
			OF.img(~imageLib.at('deli', ~cek01.next), 20+(10.04*(i%29)), 20+(10.04*(i%19)), 0, 0);
			0.1- (0.04*(i%15)).wait;	
			
		};
	
		1.8.wait;
		//:--blackFade
		~blackFade={
			~fade = Pseq((0..255), 124).asStream;
			124.do{
				OF.black( ~fade.next); 
				0.1.wait;
			};
		}.fork;
	};*/
	
	5.7.wait;
	"-------A3forkLev----  3  -----".postln;
	~gou02.brt_(~kRC3 *0.89000).playPV2(0.001, 1.1, 10.1, mul:0.6, out: ~strTek.choose);
	OF.img(~imageLib.at('kostum', rrand(0,3)), 100, 250, 0, 0);
	
	0.5.wait;
	"-------A3forkLev----  4  -----".postln;
	fork{
		
		"-------A3forkLev----  4  --------01-----".postln;
		~sis08.brt_(~kRA1 *1.20900).playBufR(0.01, 8.1, 1.1, mul:0.5, out: ~strTek.choose);
		
		"-------A3forkLev----  4  --------02-----".postln;
		0.4.wait;
		fork{
			~volUp = Pseq([0.9, 0.65, 0.4, 0.3, 0.2, 0.1, 0.07, 0.04].reverse*0.5, inf).asStream;
			5.do{
				~ats03.brt_(~kRA1 *1.82101).playPV2(0.01, 2.0, 0.1, mul:~volUp.next, pv2a:6.0, start:[0.3, 0.1, 0.18, 0.17, 0.19].choose, out: ~strTek.choose);
				1.0.wait;
			};
		};
		
		"-------A3forkLev----  4  --------03-----".postln;
		2.2.wait;
		fork{
			~dur = Pseq([0.25, 0.36, 0.47, 0.58, 0.69, 0.80, 0.91, 0.94]/5, inf).asStream;
			3.do{
			//var dur = Pseq([0.25, 0.36, 0.47, 0.58, 0.69, 0.80, 0.91, 0.94]/5, inf).asStream;
			~gou02.brt_(~kRC5 *0.89000).playPV2(0.001, 1.1, 10.1, mul:0.2, out: ~strTek.choose);
			OF.img(~imageLib.at('el1', rrand(0,8)), [55, 155, 100, 55].choose, 255, 0, 0);
			~dur.next.wait;
		
			};
			0.09.wait;
			~gou02.brt_(~kRD5 *0.89000).playGverb(0.001, 1.1, 10.1, mul:0.5, room:55, rev:3.5, damp:0.91, out: ~strTek.choose);
			OF.img(~imageLib.at('el1', rrand(0,8)), [68, 155, 100, 55].choose, 255, 0, 0);
			
		};
	};

	
};
				},
		
		//-------------------------------------------lev2-8/4--48s-----------------------------------------------
			\layer_A_4 -> {//	+dum2

fork{

	"-----_A_4_----  1  --------00-----".postln;
	~ff = ~kA1;
	KafGendy.ar(1.1, 0.1, 4.3, 26.8,
		freq: [~ff*2, ~ff*3, ~ff*4, ~ff*5], 
		freqrlp1: ~kA1/2, 
		freqrlp2: ~ff,
		mul: 0.4,
		out: 0
	).play;	
	~ats01.brt_(~kRD1 *1.00000).playGverbR(0.01, 0.2, 6.0, mul:0.5, out: ~strTek.choose);
	
	2.5.wait;
	"-----_A_4_----  2  --------00-----".postln;
	fork{
		3.do{
		var dur = Pseq([0.25, 0.36, 2.47, 0.58, 0.69, 0.80, 0.91, 0.94], inf).asStream;
		var amp = Pseq([0.25, 0.36, 0.47, 0.58, 0.69, 0.80, 0.91, 0.94]/2, inf).asStream;
		~gou02.brt_(~kRD3 *0.89000).playPV2(0.001, 1.1, 10.1, mul:amp, out: ~strTek.choose);
		OF.img(~imageLib.at(['el1', 'el2'].choose, rrand(0,4)), [55, 155, 100, 55].choose, 255, 0, 0);
		OF.int("mirrorMode", [5, 4, 3].at(3));
		dur.next.wait;
	
		};

	};
	
	4.5.wait;
	"-----_A_4_----  3  --------00-----".postln;
	fork{
	
		~gou03.brt_(~kRD4 *0.89000).playPV1R(0.1, 3.1, 5.1, mul:0.3, out: ~strTek.choose);
		OF.black(255);
		0.0001.wait;
		~gou02.brt_(~kRD4 *0.89000).playGverb(0.001, 1.1, 10.1, mul:0.5, room:55, rev:3.5, damp:0.91, out: ~strTek.choose);
		//vis
		~blackFade={
			~fade = Pseq((0..255), 124).asStream;
			124.do{
				OF.img(~imageLib.at('box', 2), ~fade.next, 240, 0, 0);
				OF.int("mirrorMode", 0);
				0.04.wait;
			};
		}.fork;
		0.05.wait;			
		~gou03
			.brt1_(~kRA1 *1.02006).brt1Dur_(3.7)
			.btrDur_(1.9)
			.brt2_(~kRB4 *1.02006).brt2Dur_(7)
		.transGverb(10.0, 1.9, 8.0, mul:0.04, start:0.0, out: ~strTek.choose);
		0.05.wait;
		
		~gou02.brt_(~kRD1 *0.89000).playPV1R(0.1, 3.1, 5.1, mul:0.6, out: ~strTek.choose);
		
		~gou03
			.brt1_(~kRA3 *1.02006).brt1Dur_(3.4)
			.btrDur_(2.3)
			.brt2_(~kRA4 *1.02006).brt2Dur_(7)
		.transGverb(10.0, 1.9, 8.0, mul:0.06, start:0.0, out: ~strTek.choose);
		2.8.wait;
		~gou02.brt_(~kRB1 *0.89000).playPV2(0.1, 3.1, 5.1, mul:0.1, out: ~strCok.choose);
		0.2.wait;
		~gou02.brt_(~kRC1 *0.89000).playPV1(0.1, 3.1, 5.1, mul:0.2, out: ~strCok.choose);
		0.4.wait;
		~gou02.brt_(~kRB4 *0.89000).playPV2(0.1, 3.1, 5.1, mul:0.1, out: ~strCok.choose);
	
	};


};
				
				}, 
			\layer_A_5 -> {//	|dum2
~ff = ~kA4;
KafGendy.ar(1.1, 0.1, 4.3, 26.8,
	freq: [~ff*2, ~ff*3, ~ff*4, ~ff*5], 
	freqrlp1: ~kA1/2, 
	freqrlp2: ~ff*2,
	mul: 0.4,
	out: 0
).play;				

~bth05.brt_(~kRA4 *1.00011).playPV1(0.001, 12.3, 0.3, mul:0.6, out: ~strTek.choose);			
				}, 
			\layer_A_6 -> {//	|tek2
~ff = ~kA5;
KafGendy.ar(3.2, 0.2, 4.3, 4.8,
	freq: [~ff*2, ~ff*3, ~ff*4, ~ff*5], 
	freqrlp1: ~kA1/2, 
	freqrlp2: ~ff*2,
	mul: 0.6,
	out: 0
).play;					
~fsitRout.stop;
~fsitRout = {
	~amp = Pseq((0.2..0.4).mirror2/2, 8).asStream;
	8.do {
		~ats05.brt_(0.5).playPV2(1.01, 0.2, 2.1, mul:~amp.next, start:rrand(0.001,0.205), out: ~strTek.choose);
		0.4.wait;	
		
	};
}.fork;

fork{
	~bth05.brt_(~kRD1 *1.00011).playPV1R(0.001, 2.3, 0.3, mul:0.4, out: ~strTek.choose);
	2.8.wait;
	~tht02.brt_(~kRC1).playPV1R(0.01, 5, 1, loop:0, out: ~strTek.choose);
	0.5.wait;
	~bth05.brt_(~kRD1 *1.00011).playPV1(0.001, 2.3, 4.3, mul:0.4, out: ~strTek.choose);
	~ats05.brt_(3.5).playPV1(0.01, 0.2, 2.1, mul:0.27, start:rrand(0.001,0.305), out: ~strTek.choose); // tek
	4.2.wait;
	~tht02.brt_(~kRC1).playPV2(0.01, 5, 4, mul:0.9, loop:0, out: ~strTek.choose);
	~ats05.brt_(2.5).playPV2(0.01, 0.2, 2.1, mul:0.27, start:rrand(0.001,0.505), out: ~strTek.choose); // tek
	1.0.wait;
	~tol07.brt_(~kRC4.next *1.07500).playPV5(4.001, 0.2, 1.4, mul:~amp.next, out: 0);
	~ats05.brt_(0.5).playPV1(0.01, 0.2, 2.1, mul:0.27, start:rrand(0.001,0.205), out: ~strTek.choose);
	

};
	
				}, 
			\layer_A_7 -> {//	|te

~ff = ~kA4;
KafGendy.ar(1.1, 0.1, 0.3, 8.0,
	freq: [~ff*2, ~ff*3, ~ff*4, ~ff*5], 
	freqrlp1: ~kA4, 
	freqrlp2: ~ff*2,
	mul: 0.4,
	out: 0
).play;	

~gou02.brt_(~kRA4 *0.89000).playPV2(0.1, 3.1, 5.1, mul:0.1, out: ~strCok.choose);
//~bth05.brt_(~kRB1 *1.00011).playPV1(0.001, 12.3, 0.3, mul:0.6, out: ~strTek.choose);
~ats05.brt_(~kRA4 *1.01000).playPV5(4.001, 8.1, 4, mul:0.09, out: ~strCok.choose);
			
				}, 
			\layer_A_8 -> {//	ke

	fork{
		~seq01 = Pseq([~kRA4, ~kRC1, ~kRB3, ~kRA7, ~kRB5, ~kRB7, ~kRC4, ~kRD4]*4, inf).asStream;
		~amp = Pseq([0.15, 0.25, 0.35].mirror2/2, inf).asStream;
		~dur = 0.27;
		~does = 4;
		~seqCokus = Pseq((0..12).reverse, inf).asStream;
		0.02.wait;
		~does.do{|i|
			
			~tol07.brt_(~seq01.next *1.07500).playPV5(0.001, 0.9, 1.4, mul:~amp.next, out: 0);
			~ats05.brt_(~seq01 *1.01000).playPV5(3.001, 4.1, 4, mul:0.09, out: ~strCok.choose);
			OF.int("mirrorMode", [5,6].choose); 
			OF.img(~imageLib.at('cokus', ~seqCokus.next), 200, 100, 0, 0);
			( ~dur - (0.004*(i%~does)) ).wait;
			
			//~gou02.brt_(~seq01 *0.89000).playPV5(0.001, 1.1, 3.1, mul:0.09, out: ~strTek.choose);
			~ats06.brt_(~seq01.next *1.01000).playPV5(0.001, 1.1, 4, mul:0.9, out: ~strTek.choose);
			OF.img(~imageLib.at('cokus', ~seqCokus.next), 200, 100, 0, 0);
			( ~dur - (0.004*(i%~does)) ).wait;
		};
		~tol07.brt_(~seq01.next *1.07500).playPV5(0.001, 0.9, 1.4, mul:~amp.next, out: 0);
		OF.img(~imageLib.at('cokus', ~seqCokus.next), 200, 100, 0, 0);
	};

fork { |i, dur = 0.1|

	~ats01.brt_(~kRD1 *1.82101).playPV1(0.01, 6.0, 4.1, mul:0.5,  out:[0,1]);
	OF.img(~imageLib.at('cokus', ~seqCokus.next), 200, 100, 0, 0);

	0.25.wait;
	//~ats05.brt_(~kRD4 *1.00011).playFverb(0.001, 12.3, 0.3, mul:0.6, out: ~strTek.choose);
	//~ats01.brt_(~kRD1 *1.82101).playPV3(0.01, 6.0, 4.1, mul:0.5, pv3a:6.0,  out:[0,1]);
	//~tht02.brt_(1).playPV1R(0.01, 5, 1, loop:0, out: ~strTek.choose);

	0.001.wait;

	0.5.wait;
	OF.img(~imageLib.at('cokus', ~seqCokus.next), 200, 100, 0, 0);
	dur.wait;

	dur+0.2.wait;				

	dur+0.4.wait;

	dur.wait;
	~tol07.brt_(~kRD6.next *1.07500).playPV5(0.001, 0.9, 1.4, mul:0.1, out: ~strTek.choose);
	OF.img(~imageLib.at('cokus', ~seqCokus.next), 200, 100, 0, 0);
	1.2.wait;				
	~ats02.brt_(~kRB4 *1.82101).playPV3(0.01, 1.0, 0.1, mul:0.5, pv3a:6.0,  out:~strTek.choose);
	~tol07.brt_(~kRD7.next *1.07500).playPV5(0.001, 0.9, 1.4, mul:0.1, out: 0);
	OF.img(~imageLib.at('cokus', ~seqCokus.next), 200, 100, 0, 0);
	
	0.25.wait;
	~ats05.brt_(~kRB1 *1.01000).playPV5(1.001, 6.1, 4, mul:0.09, out: ~strCok.choose);
	
	0.25/2.wait;
	//~gou03.brt_(~kRB7 *1.23700).playFverb(3.001, 10.1, 10.1, mul:0.2, out: ~strTek.choose);
		
				
};
			

				}, 			
			
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////------------------------------------------- FAHTE --------4 Levels-- 13 parts -- 2.0s -------------------------------------------------/////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//-------------------------------------------lev1-4/4--24s-----------------------------------------------
			\layer_A_9 -> {//	+dum2
"LayerA FAHTE".postln;

~fot01.stop;
~kPseq01 = Pseq([~kRB4, ~kRC1, ~kRC3, ~kRC5, ~kRC7, ~kRD1, ~kRD4, ~kRD7, ~kRE1, ~kRD4]*4, inf).asStream;

fork{
	
	"--- FAHTE --- A_9 ----  1  --- 00 ----".postln;
	~ats05.brt_(~kRA1 *1.01000).playPV5(1.001, 6.1, 4, mul:0.09, out: ~strTek.choose);	
	fork{
		~ats05.brt_(~kRD4 *1.00011).playFverb(0.001, 12.3, 0.3, mul:0.2, out: ~strTek.choose);
		fork{
			~seq01 = Pseq([~kRC4], inf).asStream;
			~amp = Pseq([0.15, 0.25, 0.35].mirror2, inf).asStream;
			~does = 8;
			~dur = 0.08;
			~does.do{|i|
				
				"--- FAHTE --- A_9 ----  1  --- do ----".postln;
				~gou02.brt_(~kPseq01 *0.89000/2).playFverb(0.001, 0.1, 3.1, mul:~amp.next, froom:0.5, fmix:0.5, fdamp:0.1, out: ~strTek.choose);
				OF.img(~imageLib.at('eller', (0..11).choose), 200, 100, 0, 0);
				( ~dur + (0.004*(i%~does)) ).wait;
			};
		};
		
		
		OF.img(~imageLib.at('elayak', (0..12).choose), 200, 100, 0, 0);
		OF.int("mirrorMode", 6); 
		0.1.wait;
		//:--rectFade
		~blackFade={
			~fade = Pseq((0..255), inf).asStream;
			148.do{
				OF.rectOp(-100, -100, 1380, 1124, ~fade.next); 
				0.07.wait;
			};
		}.fork;
	
	};
	1.0.wait;
	"--- FAHTE --- A_9 ----  2  --- 00 ----".postln;
	~tol07.brt_(~kPseq01.next *1.07500).playGverb(0.001, 4.9, 5.4, mul:~amp.next, room:55, rev:33.5, damp:0.91, out: 0);
	KafSinVib.ar(0.1, 0.1, 8.0, mul:0.2, freq1: ~kA7, freq2: ~kB7, vib1: 1.1, vib2: 2, out: ~strCok.choose).play;
	~kik03.brt_(1.5).playPV2(0.001, 1.1, 1, mul:0.2, out: ~strCok.choose);
	
	~frit.stop;
	~frit = {
		~durfMul = 0.6;
		~ampfMul = 0.8;
		~durf = Pseq([1, 1/2,1/2, 1, 2, 1, 1/2, 2]*~durfMul, inf).asStream;
		
		~ampf = Pseq((0.2..0.4)*~ampfMul, inf).asStream;
		~ampf1 = 0.5*~ampfMul;
		1.do {
			"_______________________frit__01______________________".postln;
			~ats05.brt_( rrand(5.6,4.205) ).playPV2(0.01, 0.02, 1.1, mul:0.2*~ampf.next, start:rrand(0.1,0.2), out: ~strTek.choose);
			
			~durf.next.wait;	
			"_______________________frit__02______________________".postln;
			~ats05.brt_(1.5).playBufR(1.01, 0.2, 0.1, mul:~ampf.next, start:rrand(0.05,0.055), out: ~strTek.choose);
			
			~durf.next.wait;
			"_______________________frit__03______________________".postln;
			~ats05.brt_(3.5).playPV2(1.1, 0.02, 0.3, mul:~ampf.next, start:rrand(0.0,0.01), out: ~strTek.choose);
			
			~durf.next.wait;
			"_______________________frit__04______________________".postln;
			~ats05.brt_(1.5).playPV1(0.01, 0.2, 0.1, mul:~ampf.next, start:rrand(0.1,0.205), out: ~strTek.choose);
			
			~durf.next.wait;
			"_______________________frit__05______________________".postln;
			~ats05.brt_( rrand(13.5,14.5) ).playPV2(1.01, 0.2, 0.1, mul:~ampf.next, start:rrand(0.1,0.7), out: ~strTek.choose);
			
			~durf.next.wait;
			"_______________________frit__06______________________".postln;
			~ats05.brt_( rrand(33.5,34.5) ).playPV2(0.01, 0.2, 0.1, mul:~ampf.next, start:rrand(0.1,0.7), out: ~strTek.choose);
			
			~durf.next.wait;
			"_______________________frit__07______________________".postln;
			~ats05.brt_(0.6).playPV2(0.51, 0.2, rrand(0.2,0.3) , mul:~ampf1, start:0.22, out: ~strTek.choose);
			
			~durf.next.wait;
			"_______________________frit__08______________________".postln;
			~ats05.brt_( rrand(5.6,4.205) ).playPV2(0.01, 0.2, 1.1, mul:0.2*~ampf.next, start:rrand(0.1,0.2), out: ~strTek.choose);
			
			~durf.next.wait;
	
		};
	}.fork;
	
	
	0.25.wait;
	"--- FAHTE --- A_9 ----  3  --- 00 ----".postln;
	~fsitRout.stop;
	~fsitRout = {
		
		~amp = Pseq((0.2..0.4).mirror2/3, 8).asStream;
		17.do {
			~ats05.brt_(1.5).playPV2(1.01, 0.2, 2.1, mul:~amp.next, start:rrand(0.001,0.205), out: ~strTek.choose);
			0.5.wait;	
			
		};
	}.fork;
	
	
	
	
	1.0.wait;
	fork{
		~mul01 = Pseq([0.5, 0.4, 0.3, 0.2, 0.1, 0.09, 0.07, 0.04].reverse*0.2, inf).asStream;
		~dur01 = Pseq([0.25, 0.36, 0.47, 0.58, 0.69, 0.80, 0.91, 0.94].reverse/2, inf).asStream;
		16.do {|i|
			
			//~gou02.brt_(~kRC4 *1.23700).playGverb(0.001, 1.1, 1, mul: ~mul01.next, room:8.4, rev:1, damp:0.91, out: ~str);
			~gou02.brt_(~kRC4 *0.89000).playFverb(0.001, 1.1, 5.1, mul: ~mul01.next, froom:0.5, fmix:0.7, fdamp:0.71, out: ~strTek.choose);
			~dur01.next.wait;
		
		};
	};
	
	1.6.wait;
	
	2.9.wait;
	"--- FAHTE --- A_9 ----  4  --- do ----".postln;
	
	fork{
		~mul01 = Pseq([0.5, 0.4, 0.3, 0.2, 0.1, 0.09, 0.07, 0.04].reverse*0.2, inf).asStream;
		~dur01 = Pseq([0.25, 0.36, 0.47, 0.58, 0.69, 0.80, 0.91, 0.94].reverse/2, inf).asStream;
		16.do {|i|
			
			//~gou02.brt_(~kRB4 *1.23700).playGverb(0.001, 1.1, 1, mul: ~mul01.next, room:8.4, rev:1, damp:0.91, out: ~str);
			~gou02.brt_(~kRB4 *0.89000).playFverb(0.001, 1.1, 5.1, mul: ~mul01.next, froom:0.5, fmix:0.7, fdamp:0.71, out: ~strTek.choose);
			~dur01.next.wait;
		
		};
	};
	
	0.001.wait;
	"--- FAHTE --- A_9 ----  5  --- do ----".postln;
	//~tol06.brt_(~kRA3 *1.23700).playPV4(0.01, 4.5, 4.1, mul:0.5, out: ~strTek.choose);
	
	
	2.9.wait;
	fork{
		~mul01 = Pseq([0.5, 0.4, 0.3, 0.2, 0.1, 0.09, 0.07, 0.04].reverse*0.2, inf).asStream;
		~dur01 = Pseq([0.25, 0.36, 0.47, 0.58, 0.69, 0.80, 0.91, 0.94].reverse/2, inf).asStream;
		8.do {|i|

			~gou02.brt_(~kRB5 *0.89000).playFverb(0.001, 1.1, 5.1, mul: ~mul01.next, froom:0.5, fmix:0.7, fdamp:0.71, out: ~strTek.choose);
			~dur01.next.wait;
		
		};
	};
	
	1.5.wait;
	~gir01.brt_(10.5).playGverbR(0.01, 3, 5, loop:0, out: ~strTek.choose);
	
	0.003.wait;
	~gou02.brt_(~kRA4 *0.89000).playFverb(0.001, 1.1, 5.1, mul:0.5, froom:0.3, fmix:0.8, fdamp:0.1, out: ~strTek.choose);
	
	0.003.wait;
	OF.img(~imageLib.at('elayak', (0..11).choose), 200, 100, 0, 0);
	
	0.265.wait;
	fork{

		
		~gou02.brt_(~kRD7 *0.89000).playFverb(0.001, 4.1, 5.1, mul:0.5, froom:0.5, fmix:0.5, fdamp:0.71, out: ~strTek.choose);
		~tol07.brt_(~kRD7 *1.07500).playPV2(0.001, 0.9, 6.4, mul:0.2, out: 0);
		OF.img(~imageLib.at('elayak', (0..11).choose), 200, 100, 0, 0);
		0.4.wait;
		
		~gou02.brt_(~kRC7 *0.89000).playFverb(0.001, 1.1, 5.1, mul:0.5, froom:0.9, fmix:0.4, fdamp:0.71, out: ~strTek.choose);
		OF.img(~imageLib.at('elayak', (0..11).choose), 200, 100, 0, 0);
		0.3.wait;
		
		~gou02.brt_(~kRB7 *0.89000).playFverb(0.001, 1.1, 5.1, mul:0.5, froom:0.5, fmix:0.5, fdamp:0.71, out: ~strTek.choose);
		OF.img(~imageLib.at('eller', (0..11).choose), 200, 100, 0, 0);
		0.2.wait;
		
		~gou02.brt_(~kRD5 *0.89000).playFverb(0.001, 1.1, 5.1, mul:0.5, froom:0.3, fmix:0.8, fdamp:0.1, out: ~strTek.choose);
		OF.img(~imageLib.at('elayak', (0..11).choose), 200, 100, 0, 0);
		0.2.wait;
		~gou02.brt_(~kRA4 *0.89000).playFverb(0.001, 1.1, 5.1, mul:0.5, froom:0.3, fmix:0.8, fdamp:0.1, out: ~strTek.choose);
		OF.img(~imageLib.at('eller', (0..11).choose), 200, 100, 0, 0);
		OF.int("mirrorMode", 5); 

	};
	0.5.wait;
	
};
	
				
				
				}, 
			\layer_A_10 -> {//	|dum
fork{
	"--- FAHTE --- A_10 ----  1  --- do ----".postln;
	fork{
		~kPseq01 = Pseq([~kRE7, ~kRC1, ~kRE7, ~kRC7, ~kRC5, ~kRD7, ~kRC4], inf).asStream;
		~amp = Pseq([0.15, 0.25, 0.35].rotate/1.9, inf).asStream;
		29.do{|i, frq = 2240, dur = 0.25|
			var freqs = frq + (12 *( i % 26)); 
			
			~tol07.brt_(~kPseq01.next *1.07500).playPV2(0.001, 0.9, 2.4, mul:~amp.next, out: ~strTek.choose);
			OF.int("mirrorMode", [5,6].choose); 
			( dur - (0.01*(i%29)) ).yield;
			~gou02.brt_(~kPseq01 *0.89000).playPV5(0.001, 1.1, 4.1, mul:0.1, out: ~strTek.choose);
			OF.img(~imageLib.at('eller', (0..11).choose), 200, 100, 0, 0);
			( dur - (0.01*(i%29)) ).yield;
		};
	};
	1.0.wait;
	
	
	0.8.wait;
	
	1.0.wait;
	
	0.25.wait;
	
	0.25.wait;
	
	0.35.wait;
	
	2.8.wait;
	~kik03.brt_(1.5).playPV2(0.001, 1.1, 1, mul:0.2, out: ~strCok.choose);
		
	



};


				
				}, 
			\layer_A_11 -> {//	dum

fork{
	
	1.25.wait;	
	"--- FAHTE --- A_11 ----  1  --- do ----".postln;
	fork{
		~kPseq01 = Pseq([~kRC4, ~kRE6, ~kRD1, ~kRD1, ~kRC4, ~kRC7, ~kRB7, ~kRC1].reverse, inf).asStream;
		~amp = Pseq([0.15, 0.25, 0.35].rotate/1.9, inf).asStream;
		~dur = Pseq([0.25, 0.36, 0.47, 0.58, 0.69, 0.80, 0.91, 0.94]/2, inf).asStream;
		4.do{
			
			~gou02.brt_(~kPseq01 *0.89000).playPV5(0.001, 1.1, 10.1, mul:0.09, out: ~strTek.choose);
			~dur.next.wait;
			
			~tol07.brt_(~kPseq01 *1.07500).playPV2(0.001, 0.9, 0.4, mul:~amp, out: [0,1]);
			OF.img(~imageLib.at('elayak', (0..11).choose), 200, 100, 0, 0);
			
			~dur.next.wait;
	
		};
		
		0.001.wait;
		
		KafSinVib.ar(0.1, 0.1, 8.0, mul:0.2, freq1: ~kA6, freq2: ~kB6, vib1: 1.1, vib2: 2, out: ~strCok.choose).play;
		~kik03.brt_(1.5).playPV2(0.001, 1.1, 1, mul:0.2, out: ~strCok.choose);
		~tol07.brt_(~kRF6 *1.07500).playGverb(0.1, 1.1, 6.1, mul:0.1, room:67, rev:22.4, damp:0.61, out: ~strHep);
		//~kik03.brt_(1.5).playPV2(0.001, 1.1, 1, mul:0.2, out: ~strCok.choose); // tek
		OF.img(~imageLib.at('elayak', (0..11).choose), 200, 100, 0, 0);
	
		
	};
	
	4.7.wait;	
		

};
				
				}, 
			
		//-------------------------------------------lev2-6/4--36s-----------------------------------------------
			\layer_A_12 -> {//	+tek2
fork{
	~kPseq01 = Pseq([~kRC4, ~kRD3, ~kRD5, ~kRC5, ~kRC4, ~kRB7, ~kRD1, ~kRC1], inf).asStream;
	~dur = Pseq([0.25, 0.36, 0.47, 0.58, 0.69, 0.80, 0.91, 0.94]/3, inf).asStream;
	3.do{
		
		~gou02.brt_(~kPseq01 *0.89000).playPV5(0.001, 1.1, 10.1, mul:0.09, out: ~strTek.choose);
		~dur.next.wait;
		
		~tol07.brt_(~kPseq01 *1.23700).playPV2(0.001, 1.1, 16.1, mul:0.1, out: [0,1]);
		
		~dur.next.wait;

	};
	
	0.001.wait;
	~tol07.brt_(~kPseq01 *1.07500).playGverb(0.001, 1.1, 3.1, mul:0.3, room:125, rev:9.5, damp:0.81, out: ~strHep);
	
	3.5.wait;
	KafSinVib.ar(0.1, 0.1, 8.0, mul:0.2, freq1: ~kA5, freq2: ~kB4, vib1: 1.1, vib2: 2, out: ~strCok.choose).play;
	~kik03.brt_(1.5).playPV2(0.001, 1.1, 1, mul:0.2, out: ~strCok.choose);
	~tol07.brt_(~kRE4 *1.07500).playGverb(2.001, 3.1, 6.1, mul:0.2, room:125, rev:9.5, damp:0.51, out: ~strHep);
	OF.int("mirrorMode", 6);
	

	
~frit.stop;
~frit = {
	~durfMul = 0.6;
	~ampfMul = 0.8;
	~durf = Pseq([1, 1/2,1/2, 1, 2, 1, 1/2, 2]*~durfMul, inf).asStream;
	
	~ampf = Pseq((0.2..0.4)*~ampfMul, inf).asStream;
	~ampf1 = 0.5*~ampfMul;
	inf.do {
		"_______________________frit__01______________________".postln;
		~ats05.brt_( rrand(5.6,4.205) ).playPV2(0.01, 0.02, 1.1, mul:0.2*~ampf.next, start:rrand(0.1,0.2), out: ~strTek.choose);
		
		~durf.next.wait;	
		"_______________________frit__02______________________".postln;
		~ats05.brt_(1.5).playBufR(1.01, 0.2, 0.1, mul:~ampf.next, start:rrand(0.05,0.055), out: ~strTek.choose);
		
		~durf.next.wait;
		"_______________________frit__03______________________".postln;
		~ats05.brt_(3.5).playPV2(1.1, 0.02, 0.3, mul:~ampf.next, start:rrand(0.0,0.01), out: ~strTek.choose);
		
		~durf.next.wait;
		"_______________________frit__04______________________".postln;
		~ats05.brt_(1.5).playPV1(0.01, 0.2, 0.1, mul:~ampf.next, start:rrand(0.1,0.205), out: ~strTek.choose);
		
		~durf.next.wait;
		"_______________________frit__05______________________".postln;
		~ats05.brt_( rrand(13.5,14.5) ).playPV2(1.01, 0.2, 0.1, mul:~ampf.next, start:rrand(0.1,0.7), out: ~strTek.choose);
		
		~durf.next.wait;
		"_______________________frit__06______________________".postln;
		~ats05.brt_( rrand(33.5,34.5) ).playPV2(0.01, 0.2, 0.1, mul:~ampf.next, start:rrand(0.1,0.7), out: ~strTek.choose);
		
		~durf.next.wait;
		"_______________________frit__07______________________".postln;
		~ats05.brt_(0.6).playPV2(0.51, 0.2, rrand(0.2,0.3) , mul:~ampf1, start:0.22, out: ~strTek.choose);
		
		~durf.next.wait;
		"_______________________frit__08______________________".postln;
		~ats05.brt_( rrand(5.6,4.205) ).playPV2(0.01, 0.2, 1.1, mul:0.2*~ampf.next, start:rrand(0.1,0.2), out: ~strTek.choose);
		
		~durf.next.wait;

	};
}.fork;

	1.5.wait;
	//~tol04.brt_(~kRC4 *1.23700).playGverbR(0.001, 1.1, 9.1, mul:0.6, room:55, rev:13.5, damp:0.71, out: ~strTek.choose);
	1.25.wait;

	
};



fork{
	~fadeIn = Pseq((0..255), 24).asStream;
	~dur2 = Pseq([0.1]/2, inf).asStream;
	104.do{
		
		OF.img(~imageLib.at('box', 1), 255, ~fadeIn.next, 0, 0);
		~dur2.next.wait;
		
	};

};	
				
				}, 
			\layer_A_13 -> {//	|tek2

~frit.stop;
~frit = {
	~durfMul = 0.7;
	~ampfMul = 0.5;
	~durf = Pseq([1, 1/2,1/2, 1, 2, 1, 1/2, 2]*~durfMul, inf).asStream;
	
	~ampf = Pseq((0.2..0.4)*~ampfMul, inf).asStream;
	~ampf1 = 0.5*~ampfMul;
	inf.do {
		"_______________________frit__01______________________".postln;
		~ats05.brt_( rrand(5.6,4.205) ).playPV2(0.01, 0.02, 1.1, mul:0.2*~ampf.next, start:rrand(0.1,0.2), out: ~strTek.choose);
		
		~durf.next.wait;	
		"_______________________frit__02______________________".postln;
		~ats05.brt_(1.5).playBufR(1.01, 0.2, 1.1, mul:~ampf.next, start:rrand(0.05,0.055), out: ~strTek.choose);
		
		~durf.next.wait;
		"_______________________frit__03______________________".postln;
		~ats05.brt_(3.5).playPV2(1.1, 0.02, 0.3, mul:~ampf.next, start:rrand(0.0,0.01), out: ~strTek.choose);
		
		~durf.next.wait;
		"_______________________frit__04______________________".postln;
		~ats05.brt_(1.5).playPV1(0.01, 0.2, 0.1, mul:~ampf.next, start:rrand(0.1,0.205), out: ~strTek.choose);
		
		~durf.next.wait;
		"_______________________frit__05______________________".postln;
		~ats05.brt_( rrand(13.5,14.5) ).playPV2(1.01, 0.2, 0.1, mul:~ampf.next, start:rrand(0.1,0.7), out: ~strTek.choose);
		
		~durf.next.wait;
		"_______________________frit__06______________________".postln;
		~ats05.brt_( rrand(33.5,34.5) ).playPV2(0.01, 0.2, 0.1, mul:~ampf.next, start:rrand(0.1,0.7), out: ~strTek.choose);
		
		~durf.next.wait;
		"_______________________frit__07______________________".postln;
		~ats05.brt_(0.6).playPV2(0.51, 0.2, rrand(0.2,0.3) , mul:~ampf1, start:0.22, out: ~strTek.choose);
		
		~durf.next.wait;
		"_______________________frit__08______________________".postln;
		~ats05.brt_( rrand(5.6,4.205) ).playPV2(0.01, 0.2, 1.1, mul:0.2*~ampf.next, start:rrand(0.1,0.2), out: ~strTek.choose);
		
		~durf.next.wait;

	};
}.fork;

~ff = ~kB7;
KafGendy.ar(1.1, 0.1, 4.3, 26.8,
	freq: [~ff*2, ~ff*3, ~ff*4, ~ff*5], 
	freqrlp1: ~kA1/2, 
	freqrlp2: ~ff,
	mul: 0.4,
	out: 0
).play;

fork{
	~met03.brt_(~kRA2 *0.99900).playGverb(2.1, 1.1, 16.1, mul:0.5, room:55, rev:3.5, damp:0.71, out:~strTek.choose);
	0.5.wait;
	//~met03.brt_(~kRB4 *1.01000).playFverb(0.1, 5.1, 16.1, mul:0.3, froom:0.5, fmix:0.5, fdamp:0.71, out:~strTek.choose);
	0.25.wait;
	~met02.brt_(~kRA1 *1.01000).playGverbR(0.001, 1.1, 16.1, mul:0.5, room:55, rev:3.5, damp:0.71, out:~strTek.choose);
	0.5.wait;
	//~met02.brt_(~kRA7 *1.01000).playGverb(1, 1.1, 16.1, mul:0.5, room:55, rev:3.5, damp:0.71, out:~strTek.choose);
	0.25.wait;
};
				
				}, 
			\layer_A_14 -> {//	_tek2
~frit.stop;
~frit = {
	~durfMul = 0.7;
	~ampfMul = 0.2;
	~durf = Pseq([1, 1/2,1/2, 1, 2, 1, 1/2, 2]*~durfMul, inf).asStream;
	
	~ampf = Pseq((0.2..0.4)*~ampfMul, inf).asStream;
	~ampf1 = 0.5*~ampfMul;
	inf.do {
		"_______________________frit__01______________________".postln;
		~ats05.brt_( rrand(5.6,4.205) ).playPV2(0.01, 0.02, 1.1, mul:0.2*~ampf.next, start:rrand(0.1,0.2), out: ~strTek.choose);
		
		~durf.next.wait;	
		"_______________________frit__02______________________".postln;
		~ats05.brt_(1.5).playBufR(1.01, 0.2, 1.3, mul:~ampf.next, start:rrand(0.05,0.055), out: ~strTek.choose);
		
		~durf.next.wait;
		"_______________________frit__03______________________".postln;
		~ats05.brt_(3.5).playPV2(1.1, 0.02, 0.3, mul:~ampf.next, start:rrand(0.0,0.01), out: ~strTek.choose);
		
		~durf.next.wait;
		"_______________________frit__04______________________".postln;
		~ats05.brt_(1.5).playPV1(0.01, 0.2, 0.1, mul:~ampf.next, start:rrand(0.1,0.205), out: ~strTek.choose);
		
		~durf.next.wait;
		"_______________________frit__05______________________".postln;
		~ats05.brt_( rrand(13.5,14.5) ).playPV2(1.01, 0.2, 0.1, mul:~ampf.next, start:rrand(0.1,0.7), out: ~strTek.choose);
		
		~durf.next.wait;
		"_______________________frit__06______________________".postln;
		~ats05.brt_( rrand(33.5,34.5) ).playPV2(0.01, 0.2, 0.1, mul:~ampf.next, start:rrand(0.1,0.7), out: ~strTek.choose);
		
		~durf.next.wait;
		"_______________________frit__07______________________".postln;
		~ats05.brt_(0.6).playPV2(0.51, 0.2, rrand(0.2,0.3) , mul:~ampf1, start:0.22, out: ~strTek.choose);
		
		~durf.next.wait;
		"_______________________frit__08______________________".postln;
		~ats05.brt_( rrand(5.6,4.205) ).playPV2(0.01, 0.2, 1.1, mul:0.2*~ampf.next, start:rrand(0.1,0.2), out: ~strTek.choose);
		
		~durf.next.wait;

	};
}.fork;

	~ff = ~kB4;
	KafGendy.ar(1.1, 0.1, 4.3, 26.8,
		freq: [~ff*2, ~ff*3, ~ff*4, ~ff*5], 
		freqrlp1: ~kA1, 
		freqrlp2: ~ff/2,
		mul: 0.4,
		out: 0
	).play;

fork{

	
	~met03.brt_(~kRA4 *0.99900).playGverb(2.1, 1.1, 6.1, mul:0.5, room:55, rev:3.5, damp:0.71, out:~strTek.choose);
	1.5.wait;
	~met03.brt_(~kRB4 *1.01000).playFverb(0.1, 5.1, 6.1, mul:0.3, froom:0.5, fmix:0.5, fdamp:0.71, out:~strTek.choose);
	0.45.wait;
	//~met02.brt_(~kRB2 *1.01000).playGverbR(1.4, 1.1, 16.1, mul:0.5, room:55, rev:3.5, damp:0.71, out:~strTek.choose);
	0.5.wait;
	//~met03.brt_(~kRA7 *1.01000).playFverb(0.1, 5.1, 6.1, mul:0.3, froom:0.5, fmix:0.5, fdamp:0.71, out:~strTek.choose);
	1.5.wait;


};

				}, 
			
		//-------------------------------------------lev3-6/4--36s-----------------------------------------------
			\layer_A_15 -> {//	+dum2


~frit.stop;
~frit = {
	~durfMul = 0.7;
	~ampfMul = 0.2;
	~durf = Pseq([1, 1/2,1/2, 1, 2, 1, 1/2, 2]*~durfMul, inf).asStream;
	
	~ampf = Pseq((0.2..0.4)*~ampfMul, inf).asStream;
	~ampf1 = 0.5*~ampfMul;
	1.do {
		"_______________________frit__01______________________".postln;
		~ats05.brt_( rrand(5.6,4.205) ).playPV2(0.01, 0.02, 1.1, mul:0.2*~ampf.next, start:rrand(0.1,0.2), out: ~strTek.choose);
		
		~durf.next.wait;	
		"_______________________frit__02______________________".postln;
		~ats05.brt_(1.5).playBufR(1.01, 0.2, 0.1, mul:~ampf.next, start:rrand(0.05,0.055), out: ~strTek.choose);
		
		~durf.next.wait;
		"_______________________frit__03______________________".postln;
		~ats05.brt_(3.5).playPV2(1.1, 0.02, 0.3, mul:~ampf.next, start:rrand(0.0,0.01), out: ~strTek.choose);
		
		~durf.next.wait;
		"_______________________frit__04______________________".postln;
		~ats05.brt_(1.5).playPV1(0.01, 0.2, 0.1, mul:~ampf.next, start:rrand(0.1,0.205), out: ~strTek.choose);
		
		~durf.next.wait;
		"_______________________frit__05______________________".postln;
		~ats05.brt_( rrand(13.5,14.5) ).playPV2(1.01, 0.2, 0.1, mul:~ampf.next, start:rrand(0.1,0.7), out: ~strTek.choose);
		
		~durf.next.wait;
		"_______________________frit__06______________________".postln;
		~ats05.brt_( rrand(33.5,34.5) ).playPV2(0.01, 0.2, 0.1, mul:~ampf.next, start:rrand(0.1,0.7), out: ~strTek.choose);
		
		~durf.next.wait;
		"_______________________frit__07______________________".postln;
		~ats05.brt_(0.6).playPV2(0.51, 0.2, rrand(0.2,0.3) , mul:~ampf1, start:0.22, out: ~strTek.choose);
		
		~durf.next.wait;
		"_______________________frit__08______________________".postln;
		~ats05.brt_( rrand(5.6,4.205) ).playPV2(0.01, 0.2, 1.1, mul:0.2*~ampf.next, start:rrand(0.1,0.2), out: ~strTek.choose);
		
		~durf.next.wait;

	};
}.fork;

~ff = ~kB4;
KafGendy.ar(1.1, 0.1, 4.3, 26.8,
	freq: [~ff*2, ~ff*3, ~ff*4, ~ff*5], 
	freqrlp1: ~kA1, 
	freqrlp2: ~ff,
	mul: 0.4,
	out: 0
).play;

				
fork{

	
	~met03.brt_(~kRA1 *0.99900).playGverb(2.1, 1.1, 8.1, mul:0.5, room:55, rev:3.5, damp:0.71, out:~strTek.choose);
	0.5.wait;
	fork {
	
		~met03.brt_(~kRC5 *1.01000).playGverb(0.1, 5.1, 6.1, mul:0.3, room:55, rev:23.5, damp:0.71, out:~strTek.choose);
		2.9.wait;
		~met03.brt_(~kRC4 *1.01000).playGverb(0.1, 5.1, 6.1, mul:0.3, room:55, rev:23.5, damp:0.71, out:~strTek.choose);
	
	};
	
	0.25.wait;
	~met02.brt_(~kRB2 *1.01000).playGverbR(1, 1.1, 6.1, mul:0.5, room:55, rev:3.5, damp:0.71, out:~strTek.choose);
	0.5.wait;
	~met03.brt_(~kRA7 *1.01000).playFverb(0.1, 5.1, 8.1, mul:0.3, froom:0.5, fmix:0.5, fdamp:0.71, out:~strTek.choose);
	0.5.wait;


};
				
				}, 
			\layer_A_16 -> {//	|ta2

//~kik01.brt_(1.5).playPV1(0.001, 1.1, 1, mul:0.2, out: ~strTek.choose); // tek

	~ff = ~kB4;
	KafGendy.ar(1.1, 0.1, 4.3, 26.8,
		freq: [~ff*2, ~ff*3, ~ff*4, ~ff*5], 
		freqrlp1: ~kA1+10, 
		freqrlp2: ~ff/2.1,
		mul: 0.4,
		out: 0
	).play;

fork{

	
	~met03.brt_(~kRA7 *1.01000).playFverb(0.1, 5.1, 6.1, mul:0.3, froom:0.5, fmix:0.5, fdamp:0.71, out:~strTek.choose);
	2.5.wait;
	~met03.brt_(~kRB4 *1.01000).playGverb(3.1, 5.1, 6.1, mul:0.2, room:55, rev:23.5, damp:0.81, out:~strTek.choose);
	0.45.wait;
	~met02.brt_(~kRB3 *1.01000).playGverbR(1, 1.1, 10.1, mul:0.4, room:55, rev:3.5, damp:0.71, out:~strTek.choose);
	2.5.wait;
	~met02.brt_(~kRB1 *1.01000).playGverb(2.001, 1.1, 6.1, mul:0.2, room:55, rev:3.5, damp:0.71, out:~strTek.choose);
	1.5.wait;


};

				
				}, 
			\layer_A_17 -> {//	hek2
//~kik01.brt_(1.5).playPV1(0.001, 1.1, 1, mul:0.1, out: ~strTek.choose); // tek

fork{

	
	~met03.brt_(~kRA1 *0.99900).playGverb(2, 1.1, 6.1, mul:0.5, room:55, rev:3.5, damp:0.71, out:~strTek.choose);
	0.5.wait;
	~met03.brt_(~kRC3 *1.01000).playGverb(5.1, 5.1, 6.1, mul:0.3, room:55, rev:23.5, damp:0.71, out:~strTek.choose);
	0.25.wait;
	~met02.brt_(~kRB1 *1.01000).playGverbR(0.001, 1.1, 6.1, mul:0.5, room:55, rev:3.5, damp:0.71, out:~strTek.choose);
	0.5.wait;
	~met02.brt_(~kRA5 *1.01000).playGverb(0.001, 1.1, 6.1, mul:0.5, room:55, rev:3.5, damp:0.71, out:~strTek.choose);
	0.25.wait;
	~met02.brt_(~kRB5 *1.01000).playGverbR(0.001, 1.1, 6.1, mul:0.5, room:55, rev:3.5, damp:0.71, out:~strTek.choose);
	1.25.wait;

};				
				
				}, 
			
		//-------------------------------------------lev4-4/4--24s-----------------------------------------------
			\layer_A_18 -> {//	|te
~kik01.brt_(2.5).playPV1(0.001, 1.1, 1, mul:0.3, out: ~strTek.choose); // tek
fork{
	~ats01.brt_(~kRA1 *1.00000).playPV1(0.01, 6.0, 4.0, mul:0.3, out: ~strCok.choose);
	8.5.wait;
	~ats01.brt_(~kRB1 *1.00000).playPV1(0.01, 6.0, 4.0, mul:0.3, out: ~strCok.choose);
	5.0.wait;
	~ats02.brt_(1.5).playPV1(0.01, 0.4, 0.9, mul:0.4, start:[0.73, 0.2, 0.28, 0.37].choose, out: ~strTek.choose); // dum
	
};
//vis
~destMini01.stop;
~destMini01 = {
	inf.do{
		OF.destructMini(rrand(150,255)); 
		OF.mini(~imageLib.at('box', 0),255,255);
		0.04.wait;
	};
}.fork;

				
				}, 
			\layer_A_19 -> {//	ke

~kik02.brt_(9.5).playPV2(0.001, 1.1, 1, mul:0.8, out: ~strTek.choose); // tek	
~ats02.brt_(1.5).playPV4(0.01, 0.4, 0.9, mul:0.4, start:[0.59].choose, out:  ~strCok.choose); // dum			
				}, 
			\layer_A_20 -> {//	|te

~kik03.brt_(9.5).playPV2(0.001, 1.1, 1, mul:0.3, out: ~strCok.choose); // tek	
~ats02.brt_(1.5).playPV4(0.01, 0.4, 0.9, mul:0.3, start:[0.27].choose, out:  ~strCok.choose); // dum			
				}, 
			\layer_A_21 -> {//	ke
~kik03.brt_(9.5).playPV5(0.001, 1.1, 1, mul:0.6, out: ~strTek.choose); // tek	
~ats02.brt_(1.5).playPV4(0.01, 0.4, 0.9, mul:0.4, start:[0.73].choose, out:  ~strCok.choose); 

//vis
~destMini01.stop;
		
				}, 
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////------------------------------------------- Cember --------4 Levels-- 13 parts -- 2.4s -------------------------------------------------////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//-------------------------------------------lev1-4/4--24s-----------------------------------------------
			\layer_A_22 -> {//	+dum2
"LayerA CEMBER".postln;				


fork{

	~kik02.brt_(0.5).playPV1(0.001, 1.1, 1, mul:0.2, out: ~strTek.choose); // tek
	2.5.wait;
	~kik02.brt_(0.5).playPV2(0.001, 1.1, 1, mul:0.1, out: ~strCok.choose); // tek
	
	~ats02.brt_(1.2).playPV4(0.01, 0.4, 0.9, mul:0.3, start:[0.6].choose, out:  ~strCok.choose); // dum
	

};

				}, 
			\layer_A_23 -> {//	|te
			
~kik03.brt_(0.5).playPV2(0.001, 1.1, 1, mul:0.5, out: ~strTek); // tek
~ats02.brt_(1.0).playPV1(0.01, 1.4, 1.3, mul:0.4, start:0.33, out: ~strHep); // dum

				}, 
			\layer_A_24 -> {//	ke

~kik02.brt_(0.2).playPV5(0.001, 1.1, 1, mul:0.4, out: ~strCok); // tek
~ats02.brt_(4.0).playPV1(0.01, 1.4, 1.9, mul:0.4, start:0.33, out: ~strHep); // dum
				
				},
			
		//-------------------------------------------lev2-4/4--24s-----------------------------------------------	
			\layer_A_25 -> {//	+dum2
				
~kik01.brt_(0.3).playPV1(0.001, 1.1, 1, mul:0.1, out: ~strHep); // tek
~ats02.brt_(2.0).playPV1(0.01, 1.4, 2.9, mul:0.4, start:0.13, out: ~strHep); // dum
				
				}, 
			\layer_A_26 -> {//	|dum

~kik02.brt_(0.5).playPV2(0.001, 1.1, 1, mul:0.2, out: ~strHep); // tek
~ats01.brt_(0.4).playPV5(2.01, 1.4, 0.9, mul:0.4, start:0.33, out: ~strHep); // dum
	
				}, //0.73, 0.2, 0.28, 0.57
			\layer_A_27 -> {//	_dum
~kik02.brt_(0.28).playPV2(0.001, 1.1, 1, mul:0.1, out: ~strHep); // tek
~ats02.brt_(1.5).playPV1(0.01, 1.4, 0.9, mul:0.4, start:0.73, out: ~strHep); // dum

				
				},
			
		//-------------------------------------------lev3-6/4--36s-----------------------------------------------
			\layer_A_28 -> {//	+tek2

fork{
	
	1.5.wait;
	OF.feedback("activate", 0);
	OF.int("mirrorMode", 0);
	OF.mask(~imageLib.at('mask', 0),255,255);
	
	~kik02.brt_(1.5).playPV2(0.001, 1.1, 1, mul:0.1, out: ~strCok.choose); // dum
	KafSinVib.ar(0.1, 0.1, 18.0, mul:0.3, freq1: ~kA1, freq2: ~kA1+3, vib1: 2.1, vib2: 4, out: ~strCok.choose).play;
	
	fork{
		18.do {
			
			~kik01.brt_(71.5).playPV4(0.001, 1.1, 1, mul:0.1, out: ~strCok.choose); // dum
			2.0.wait;
		};
	};
//:-el1
~visRout.stop;
~visRout = {
	~seq = Pseq((0..8).mirror,inf).asStream;
	~op = Pseq((255..0),inf).asStream;
	120.do{
		
		OF.img(~imageLib.at('el1', ~seq.next), ~op.next, ~op.next, 0, 0);
		0.1.wait;
		//OF.black(255); 0.1.wait;
		
	}
}.fork;	


}
				
				}, 
			\layer_A_29 -> {//	|tek2

fork{

	~kik02.brt_(1.5).playPV5(0.001, 1.1, 1, mul:0.1, out: ~strTek.choose); // dum
	0.005.wait;
	KafSinVib.ar(0.1, 0.1, 14.0, mul:0.3, freq1: ~kA3, freq2: ~kA3+2, vib1: 2.1, vib2: 4).play;
	fork{
		
		~ats03.brt_(~kRC1 *1.82101).playGverb(0.01, 0.3, 0.1, mul:0.5, out: ~strCok);
		0.2.wait;
		
		~tol01.brt_(~kRB2 *1.23700).playGverb(0.001, 1.1, 16.1, mul:0.3, room:55, rev:23.5, damp:0.71, out: ~strHep);
	
	};
	fork{
		9.do {
			
			~kik01.brt_(71.5).playPV4(0.001, 1.1, 1, mul:0.1, pv4a: 30.3, out: ~strTek.choose); // dum
			0.8.wait;
			~kik01.brt_(61.5).playPV3(0.001, 1.1, 1, mul:0.1, pv3a: 0.3, out: ~strCok); // dum
			1.8.wait;
		};
	};

//:-el1
~visRout.stop;
~visRout = {
	~seq = Pseq((0..8).mirror,inf).asStream;
	~op = Pseq((255..0),inf).asStream;
	120.do{
		
		OF.img(~imageLib.at('agaz', ~seq.next), ~op.next, ~op.next, 0, 0);
		0.1.wait;
		//OF.black(255); 0.1.wait;
		
	}
}.fork;

};				
				}, 
			\layer_A_30 -> {//	tek2

~kik02.brt_(1.5).playPV2(0.001, 1.1, 1, mul:0.1, out: ~strTek.choose); // dum
KafSinVib.ar(0.1, 0.1, 8.0, mul:0.2, freq1: ~kA1, freq2: ~kA1+1.2, vib1: 2.1, vib2: 4, out: ~strTek).play;

fork{
	9.do {
		
		~kik01.brt_(11.5).playPV4(0.001, 1.1, 1, mul:0.2, out: ~strTek.choose); // dum
		0.8.wait;
		~kik01.brt_(21.5).playPV1(0.001, 0.1, 1, mul:0.6, start: 0.4, out: ~strHep); // dum
		0.6.wait;
	};
	2.3.wait;
		//~tol01.brt_(~kRD7 *1.23700).playGverbR(0.001, 1.1, 6.1, mul:0.3, room:55, rev:23.5, damp:0.71, out: ~strCok);
};
				
//:-bash1
~visRout.stop;
~visRout = {
	~seq = Pseq((0..10).mirror,inf).asStream;
	~op = Pseq((255..0),inf).asStream;
	120.do{
		
		OF.img(~imageLib.at('bash', ~seq.next), ~op.next, ~op.next, 0, 0);
		0.1.wait;
		//OF.black(255); 0.1.wait;
		
	}
}.fork;

				}, 


			
		//-------------------------------------------lev4-6/4--36s-----------------------------------------------
			\layer_A_31 -> {//	+dum2
fork{

	~ats03.brt_(~kRD1 *1.82101).playPV3(0.01, 6.0, 4.1, mul:0.5, pv3a:6.0,  out:[0,1]);
	
	fork{	
		
		~rit02
			.brt1_(~kRB4 *1.02006).brt1Dur_(0.01)
			.btrDur_(0.5)
			.brt2_(~kRC7 *1.02006).brt2Dur_(3)
		.transBuf(0.02, 2.78, 8.0, mul:0.1, loop:1, out: ~strTek.choose);
		10.0.wait;
		
		~ats03.brt_(~kRA1 *1.82101).playPV3(0.01, 6.0, 1.0, mul:0.5, pv3a:6.0,  out:[0,1]);
		
		4.5.wait;
		
		~rit03
			.brt1_(~kRB4 *1.02006).brt1Dur_(0.01)
			.btrDur_(0.5)
			.brt2_(~kRC7 *1.02006).brt2Dur_(3)
		.transBuf(0.02, 0.78, 5.0, mul:0.1, loop:1, out: ~strCok.choose);
		
		~rit02
			.brt1_(~kRB4 *1.02006).brt1Dur_(0.01)
			.btrDur_(0.5)
			.brt2_(~kRC7 *1.02006).brt2Dur_(3)
		.transBuf(0.02, 0.78, 8.0, mul:0.1, loop:1, out: ~strHep);
		
	};
	

	2.5.wait;

	fork{
	
		~ats03.brt_(~kRD1 *1.82101).playPV3(0.01, 0.5, 0.1, mul:0.5, pv3a:6.0, start:0.2, out: ~strCok.choose);
		0.5.wait;
		~ats03.brt_(~kRD1 *1.82101).playPV3(0.01, 0.6, 1.1, mul:0.5, pv3a:8.0, start:0.4, out: ~strCok.choose);
		0.8.wait;
		~ats03.brt_(~kRB1 *1.82101).playPV3(0.01, 2.5, 0.1, mul:0.5, pv3a:8.0, start:0.1, out: ~strCok.choose);
		0.8.wait;
		~ats03.brt_(~kRB1 *1.82101).playPV3(0.01, 2.5, 0.1, mul:0.5, pv3a:2.0, start:0.1, out: ~strCok.choose);
	
	};

};



				
				}, 
			\layer_A_32 -> {//	|ta2
fork{

	~kik02.brt_(1.5).playPV2(0.001, 1.1, 1, mul:0.5, out: ~strTek.choose); // dum
	
	0.005.wait;
	~tol01.brt_(~kRD7 *1.23700).playGverb(0.001, 1.1, 16.1, mul:0.4, room:55, rev:23.5, damp:0.71, out: ~strCok);
	
	0.006.wait;
	//KafSinVib.ar(0.1, 0.1, 8.0, mul:0.3, freq1: ~kA4, freq2: ~kA4+1.1, vib1: 2.1, vib2: 4).play;

	fork{
		~mul01 = Pseq([0.5, 0.4, 0.3, 0.2, 0.1, 0.09, 0.07, 0.04].mirror*0.2, inf).asStream;
		~dur01 = Pseq([0.25, 0.36, 0.47, 0.58, 0.69, 0.80, 0.91, 0.94].mirror/2, inf).asStream;
		14.do {|i|
			
			//~gou02.brt_(~kRC4 *1.23700).playGverb(0.001, 1.1, 1, mul: ~mul01.next, room:8.4, rev:1, damp:0.91, out: ~str);
			~gou02.brt_(~kRC4 *0.89000).playFverb(0.001, 1.1, 5.1, mul: ~mul01.next, froom:0.5, fmix:0.7, fdamp:0.71, out: ~strTek.choose);
			~dur01.next.wait;
		
		};
	};
	
	0.005.wait;
	fork{
		~volUp = Pseq([0.9, 0.65, 0.4, 0.3, 0.2, 0.1, 0.07, 0.04].reverse*0.9, inf).asStream;
		6.do{
			~ats03.brt_(~kRC1 *1.82101).playPV3(0.01, 2.0, 0.1, mul:~volUp.next, pv3a:6.0, start:[0.73, 0.1, 0.28, 0.57, 0.9].choose, out: ~strCok.choose);
			1.0.wait;
		};
		0.5.wait;
		~ats06.brt_(~kRC1 *1.82101).playGverb(0.01, 2.0, 4.1, mul:0.7, start:[0.73, 0.1, 0.28, 0.57, 0.9].choose, out: ~strCok.choose);
		2.5.wait;
		~ats01.brt_(~kRA1/2 *1.82101).playPV3(0.01, 2.5, 5.1, mul:0.5, pv3a:8.0, start:0.5, out: ~strCok.choose);
	};


	2.5.wait;

	fork{
	
		~ats03.brt_(~kRD1 *1.82101).playPV3(1.01, 0.5, 0.1, mul:0.5, pv3a:9.0, start:0.2, out: ~strCok.choose);
		0.5.wait;
		~ats03.brt_(~kRD1 *1.82101).playPV3(0.01, 0.6, 1.1, mul:0.5, pv3a:8.0, start:0.4, out: ~strCok.choose);
		0.8.wait;
		~ats03.brt_(~kRB1 *1.82101).playPV3(0.01, 2.5, 0.1, mul:0.5, pv3a:7.0, start:0.1, out: ~strCok.choose);
		0.8.wait;
		~ats04.brt_(~kRB1 *1.82101).playPV3(0.01, 2.5, 5.1, mul:0.5, pv3a:4.0, start:0.1, out: ~strCok.choose);
	
	};


};

		
				}, 
			\layer_A_33 -> {//	hek2
				
fork{

	
	~kik02.brt_(1.0).playBuf(0.001, 2.1, 1, mul:0.8, out: ~strTek.choose); // dum
	KafSinVib.ar(0.1, 0.1, 8.0, mul:0.3, freq1: ~kB3, freq2: ~kC1+3, vib1: 20.1, vib2: 40 ).play;
	0.002.wait;
	~ats02.brt_(~kRA4 *1.82101).playPV1R(0.01, 4.0, 6.1, mul:0.9, start:0.2, out: ~strCok.choose);
	0.001.wait;
	~ats02.brt_(~kRA1 *1.01000).playGverbR(0.001, 3.1, 8.1, mul:0.5, room:55, rev:3.5, damp:0.71, out:~strCok.choose);
	~ats01.brt_(~kRA1 *1.82101).playPV3(0.01, 2.5, 5.1, mul:0.8, pv3a:10.0, start:0.4, out: ~strCok.choose);
	
	3.5.wait;	
	fork{
		~volUp = Pseq([0.9, 0.65, 0.4, 0.3, 0.2, 0.1, 0.07, 0.04].reverse*0.9, inf).asStream;
		~ats01.brt_(~kRA1 *1.82101).playPV3(0.01, 2.5, 5.1, mul:0.8, pv3a:10.0, start:0.4, out: ~strCok.choose);
		6.do{
			~ats03.brt_(~kRC1 *1.82101).playPV3(0.01, 2.0, 0.1, mul:~volUp.next, pv3a:6.0, start:[0.73, 0.1, 0.28, 0.57, 0.9].choose, out: ~strCok.choose);
			0.5.wait;
			~gou02.brt_(~kRC1 *0.89000).playFverb(0.001, 1.1, 5.1, mul: ~mul01.next, froom:0.5, fmix:0.7, fdamp:0.71, out: ~strTek.choose);
			0.5.wait;
		};
		0.5.wait;
		~ats06.brt_(~kRA1 *1.82101).playGverb(0.01, 2.0, 4.1, mul:0.7, start:[0.73, 0.1, 0.28, 0.57, 0.9].choose, out: ~strCok.choose);
		~big02.brt_(~kRB7 *1.01000).playGverb(1.1, 1.1, 9.1, mul:0.8, room:55, rev:3.5, damp:0.71, start:0.1, out:~strTek.choose);
	};


};		
		
		

				}, 
			
		//-------------------------------------------lev5-4/4--24s-----------------------------------------------
			\layer_A_34 -> {//	|te

~kik02.brt_(2.5).playPV4(0.001, 1.1, 1, mul:0.9, out: ~strCok.choose); // tek
~ats06.brt_(~kRA1 *1.82101).playGverb(0.01, 2.0, 4.1, mul:0.7, start:[0.73, 0.1, 0.28, 0.57, 0.9].choose, out: ~strCok.choose);

fork{
	~kPseq01 = Pseq([~kRC4, ~kRE1, ~kRD1, ~kRC1, ~kRC2, ~kRC4, ~kRC3, ~kRC1], inf).asStream;
	~dur = Pseq([0.25, 0.36, 0.47, 0.58, 0.69, 0.80, 0.91, 0.94]/3, inf).asStream;
	3.do{
		
		//var dur = Pseq([0.25, 0.36, 0.47, 0.58, 0.69, 0.80, 0.91, 0.94]/5, inf).asStream;
		//var frqqq = Pseq([~kRC1, ~kRC3, ~kRC5, ~kRD1, ~kRC4, ~kRD1, ~kRC1, ~kRD1].rotate(0), inf).asStream;
		
		~gou02.brt_(~kPseq01 *0.89000).playPV5(0.001, 1.1, 6.1, mul:0.09, out: ~strTek.choose);
		~dur.next.wait;
		
		~tol07.brt_(~kPseq01.next *1.07500).playPV5(0.001, 0.9, 1.4, mul:~amp.next, out: 0);
		0.15.wait;
		~tol06.brt_(~kPseq01.next *1.07500).playPV2(0.001, 1.1, 1.1, mul:0.1, out: ~strHep);
		~ats03.brt_(~kPseq01.next *1.82101).playPV1(0.01, 1.0, 1.1, mul:0.9, start:0.5, out: ~strCok.choose);
		~dur.next.wait;

	};
	
	0.001.wait;
	
	~tol07.brt_(~kRD4*1.07500).playPV5(0.001, 0.9, 1.4, mul:~amp.next, out: 0);
	~ats02.brt_(~kRB4 *1.82101).playPV1(0.01, 1.0, 1.1, mul:0.9, start:0.5, out: ~strCok.choose);
	
	0.2.wait;
//:--rectFade
~blackFade={
	~fade = Pseq((0..255), inf).asStream;
	48.do{
		OF.rectOp(-100, -100, 1380, 1124, ~fade.next); 
		0.04.wait;
	};
}.fork;
	
};

//---vis---vis---vis---vis---vis---vis---vis---vis---vis---vis---//	
OF.feedback("speedXY", 0, 0);


				
				}, 
			\layer_A_35 -> {//	ke
~ats06.brt_(~kRA1 *1.82101).playGverbR(0.01, 4.0, 9.1, mul:0.7, start:[0.0].choose, out: ~strCok.choose);

~gou05
	.brt1_(~kRA1 *1.02006).brt1Dur_(15)
	.btrDur_(0.25)
	.brt2_(~kRA2 *1.02006).brt2Dur_(16)
.transGverb(4.0, 5.9, 28.0, mul:0.2, start:0.0, out:~strCok.choose);

OF.int("mirrorMode", 7);  //OK
//---vis---vis---vis---vis---vis---vis---vis---vis---vis---vis---//
~visRout.stop;
~visRout = {
	~seq = Pseq((0..28).mirror,inf).asStream;
	~op = Pseq((0..150).mirror, inf).asStream;
	inf.do{
		
		OF.img(
			~imageLib.at('sleep', ~seq.next), 
			255, ~op.next, [0,0,0,0].choose, 0
		);
		0.09.wait;
		
	}
}.fork;

			
				}, 
			\layer_A_36 -> {//	|te

OF.int("mirrorMode", 8);  //OK
~ats06.brt_(~kRA2 *1.82101).playGverbR(0.01, 4.0, 9.1, mul:1.7, start:[0.0].choose, out: ~strCok.choose);

~gou05
	.brt1_(~kRA2 *1.02006).brt1Dur_(15)
	.btrDur_(0.25)
	.brt2_(~kRA4 *1.02006).brt2Dur_(16)
.transGverb(4.0, 5.9, 28.0, mul:0.05, start:0.0, out:~strCok.choose);



				}, 
			\layer_A_37 -> {//	ke

~ats06.brt_(~kRA1 *1.82101).playGverbR(0.01, 4.0, 9.1, mul:1.7, start:[0.0].choose, out: ~strCok.choose);
~gou02.brt_(~kRD5 *0.89000).playBuf(0.001, 1.1, 10.1, mul:0.009, out: ~strTek.choose);
//---vis---vis---vis---vis---vis---vis---vis---vis---vis---vis---//
OF.int("mirrorMode", 7);  //OK
~visRout.stop;
~visRout = {
	~seq = Pseq((0..28).mirror,inf).asStream;
	~op = Pseq((80..100), inf).asStream;
	~bright = Pxrand((220..255), inf).asStream;
	inf.do{
		
		OF.img(
			~imageLib.at('sleep', ~seq.next), 
			~bright.next, ~op.next, [0,0,0,0].choose, 0
		);
		0.06.wait;
		
		
	}
}.fork;
			

				},

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////-------------------------------------------DEVR-i KEBIR --------5 Levels--19 parts--2.8s-----------------------------------------------/////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//-------------------------------------------lev1-6/4--36s-----------------------------------------------
			\layer_A_38 -> {//	+dum2
"LayerA DEVR-i KEBIR level 1  6/4".postln;

~ats06.brt_(~kRA1 *1.82101).playGverbR(0.01, 4.0, 9.1, mul:1.7, start:[0.0].choose, out: ~strCok.choose);

~gou05
	.brt1_(~kRA3 *1.02006).brt1Dur_(15)
	.btrDur_(0.25)
	.brt2_(~kRA4 *1.02006).brt2Dur_(16)
.transGverb(4.0, 5.9, 28.0, mul:0.05, start:0.0, out:~strCok.choose);

~gou02.brt_(~kRE1 *0.89000).playBuf(0.001, 1.1, 10.1, mul:0.009, out: ~strTek.choose);
OF.destruct;	

//---vis---vis---vis---vis---vis---vis---vis---vis---vis---vis---//
				
				}, 
			\layer_A_39 -> {//	|dum2
				
~ats06.brt_(~kRA1 *1.82101).playGverbR(0.01, 4.0, 9.1, mul:1.7, start:[0.0].choose, out: ~strCok.choose);

~gou02.brt_(~kRD5 *0.89000).playBuf(0.001, 1.1, 10.1, mul:0.009, out: ~strTek.choose);
OF.destruct;	

				
				}, 
			\layer_A_40 -> {//	|tek2

~ats06.brt_(~kRA1 *1.82101).playGverbR(0.01, 4.0, 9.1, mul:1.7, start:[0.0].choose, out: ~strCok.choose);
			
~gou05
	.brt1_(~kRA4 *1.02006).brt1Dur_(15)
	.btrDur_(0.25)
	.brt2_(~kRA1 *1.02006).brt2Dur_(16)
.transGverb(4.0, 5.9, 28.0, mul:0.09, start:0.0, out:~strCok.choose);

~gou02.brt_(~kRC4 *0.89000).playBuf(0.001, 1.1, 10.1, mul:0.09, out: ~strTek.choose);
OF.destruct;
	
~gou02.brt_(~kRC1 *0.89000).playBufR(0.001, 1.1, 2.1, mul:0.9, out: ~strTek.choose);

				},
			
		//-------------------------------------------lev2-4/4--24s-----------------------------------------------
			\layer_A_41 -> {//	+dum
"LayerA DEVR-i KEBIR level 2  4/4".postln;


~ats06.brt_(~kRA1 *1.82101).playGverbR(0.01, 4.0, 9.1, mul:1.7, start:[0.0].choose, out: ~strCok.choose);
		
~gou05
	.brt1_(~kRA1 *1.02006).brt1Dur_(15)
	.btrDur_(0.25)
	.brt2_(~kRA2 *1.02006).brt2Dur_(16)
.transGverb(4.0, 5.9, 28.0, mul:0.6, start:0.0, out:~strCok.choose);

fork{
	~gou02.brt_(~kRF1 *0.89000).playGverbR(0.001, 1.1, 1.1, mul:0.09, room:55, rev:13.5, damp:0.71, out: ~strTek.choose);	
	0.5.wait;
	~gou02.brt_(~kRC1 *0.89000).playBuf(0.001, 1.1, 10.1, mul:0.09, out: ~strTek.choose);	OF.destruct;	
	~gou02.brt_(~kRC3 *0.89000).playBufR(0.001, 6.1, 2.1, mul:0.9, out: ~strTek.choose);
	2.5.wait;
	
	fork{
		71.do{|i|
			var dur = Pseq([0.25, 0.25, 0.25, 0.25, 0.25, 0.25, 0.25, 0.25]/4, inf).asStream;
			~gou02.brt_([~kRE1, ~kRC3].choose *0.89000).playBuf(0.001, 1.1, 5.1, mul:0.000001+0.0002*(i%71), out: ~strTek.choose);
			OF.imgP(~imageLib.at('sleepSag', rrand(0, 12)), 255, 255, 0, 0);
			dur.next.wait;
			
			
		};
		0.5.wait;
		~gou02.brt_(~kRC4 *0.89000).playBuf(0.001, 1.1, 10.1, mul:0.09, out: ~strTek.choose);
		OF.destruct;
		
		71.do{|i|
			var dur = Pseq([0.25, 0.25, 0.25, 0.25, 0.25, 0.25, 0.25, 0.25]/4, inf).asStream;
			~gou02.brt_([~kRC4, ~kRC1].choose *0.89000).playBuf(0.001, 1.1, 5.1, mul:0.000001+0.0002*(i%71), out: ~strTek.choose);
			OF.imgX(~imageLib.at('sleepSol', rrand(0, 12)), 255, 255, 0, 0);
			
			dur.next.wait;
			
			
		};
		2.8.wait;
		~gou02.brt_(~kRC2 *0.89000).playBuf(0.001, 1.1, 10.1, mul:0.09, out: ~strTek.choose);
		OF.destruct;
	};
	
}



				}, 
			\layer_A_42 -> {//	|tek


~ats06.brt_(~kRA1 *1.82101).playGverbR(0.01, 4.0, 9.1, mul:0.7, start:[0.0].choose, out: ~strCok.choose);
~gou05
	.brt1_(~kRA4 *1.02006).brt1Dur_(10)
	.btrDur_(0.25)
	.brt2_(~kRA1 *1.02006).brt2Dur_(16)
.transGverb(1.0, 1.9, 28.0, mul:0.3, start:0.0, out:~strCok.choose);

	

~gouBass1.stop;
~gouBass1 = {
	 ~kP01 = Pxrand([
				~kRA4,~kRB1, ~kRB4 
			
	], inf).asStream;
	30.do{|i|
		var dur = Pwhite(0.2, 0.5, inf).asStream;
		

		~gou02.brt_(~kP01.next *0.89000).playBuf(0.001, 1.1, 5.1, mul:0.0001+0.01*(i%13), out: ~strTek.choose);
		OF.imgP(~imageLib.at('exit', rrand(0, 12)), 255, 255, 0, 0);
		
		dur.next.wait;
		
		
	};
	
}.fork;


				
				}, 
			\layer_A_43 -> {//	te'

fork{

	~ats06.brt_(~kRA1 *1.82101).playGverbR(0.01, 4.0, 9.1, mul:3.7, start:[0.0].choose, out: ~strCok.choose);
	~gou05
		.brt1_(~kRA5 *1.02006).brt1Dur_(10)
		.btrDur_(0.25)
		.brt2_(~kRA4 *1.02006).brt2Dur_(16)
	.transGverb(1.0, 6.9, 28.0, mul:0.3, start:0.0, out:~strCok.choose);
	
	
	fork{
		
		fork{
			44.do{|i|
				var dur = Pseq([0.25, 0.25, 0.25, 0.25, 0.25, 0.25, 0.25, 0.25]/4, inf).asStream;
				~gou02.brt_([~kRE2, ~kRC6].choose *0.89000).playBuf(0.001, 1.1, 5.1, mul:0.00001+0.0001*(i%70), out: ~strTek.choose);
				OF.imgP(~imageLib.at('exit', rrand(0, 12)), 255, 255, 0, 0);
				dur.next.wait;
				
				
			};
		};
		
		2.0.wait;
		
		
		~gouA1 = {
			 ~kP01 = Pxrand([
						~kRA1, ~kRA2, ~kRA3, ~kRA4, ~kRA5, ~kRA6, ~kRA7, 
						~kRB1, ~kRB2, ~kRB3, ~kRB4, ~kRB5, ~kRB6, ~kRB7,
						~kRC1, ~kRC2, ~kRC3, ~kRC4, ~kRC5, ~kRC6, ~kRC7,
						~kRD1, ~kRD2, ~kRD3, ~kRD4, ~kRD5, ~kRD6, ~kRD7,
						~kRE1, ~kRE2, ~kRE3, ~kRE4, ~kRE5, ~kRE6, ~kRE7,
						~kRF1, ~kRF2, ~kRF3, ~kRF4, ~kRF5, ~kRF6, ~kRF7
			], inf).asStream;
			~amp = Pseq((0.1..0.05), 128).asStream;
			inf.do{
				var dur = Pwhite(0.9, 0.1, inf).asStream;
		
				~gou02.brt_(~kP01.next *0.89000).playBuf(0.001, 1.1, 5.1, mul:~amp.next, out: ~strTek.choose);
				OF.destruct;
				OF.imgP(~imageLib.at('exit', rrand(0, 12)), 255, 255, 0, 0);
				dur.next.wait;
				
				
			};
			
		}.fork;
		
	}

}
				
				}, 
			\layer_A_44 -> {//	ke'

~ats06.brt_(~kRA4/2 *1.82101).playGverbR(0.01, 4.0, 9.1, mul:3.7, start:[0.0].choose, out: ~strCok.choose);
				
				},
			\layer_A_45 -> {//	|dum



				}, 
			
		//-------------------------------------------lev3-4/4--24s-----------------------------------------------
			\layer_A_46 -> {//	+tek2
"LayerA DEVR-i KEBIR level 3  4/4".postln;
~ats06.brt_(~kRA4/2 *1.82101).playGverbR(0.01, 4.0, 9.1, mul:3.7, start:[0.0].choose, out: ~strCok.choose);


~gouA2 = {
	 ~kP01 = Pxrand([
				~kRA1, ~kRA2, ~kRA3, ~kRA4, ~kRA5, ~kRA6, ~kRA7, 
				~kRB1, ~kRB2, ~kRB3, ~kRB4, ~kRB5, ~kRB6, ~kRB7,
				~kRC1, ~kRC2, ~kRC3, ~kRC4, ~kRC5, ~kRC6, ~kRC7,
				~kRD1, ~kRD2, ~kRD3, ~kRD4, ~kRD5, ~kRD6, ~kRD7,
				~kRE1, ~kRE2, ~kRE3, ~kRE4, ~kRE5, ~kRE6, ~kRE7,
				~kRF1, ~kRF2, ~kRF3, ~kRF4, ~kRF5, ~kRF6, ~kRF7
	], inf).asStream;
	~amp = Pseq((0.1..0.05), 128).asStream;
	inf.do{
		var dur = Pwhite(1.2, 0.5, inf).asStream;

		~gou02.brt_(~kP01.next *0.89000).playPV2(0.001, 1.1, 5.1, mul:~amp.next, out: ~strTek.choose);
		OF.destruct;
		OF.imgP(~imageLib.at('exit', rrand(0, 12)), 255, 255, 0, 0);
		dur.next.wait;
		
		
	};
	
}.fork;


				
				}, 
			\layer_A_47 -> {//	|tek2
			
	
			
				
				
				
				},
			
			
		//-------------------------------------------lev4-6/4--36s-----------------------------------------------
			\layer_A_48 -> {//	+tek2
"LayerA DEVR-i KEBIR level 4  6/4".postln;

		


				}, 
			\layer_A_49 -> {//	+dum2
				
				}, 
			\layer_A_50 -> {//	|dum
				
				}, 
			
			\layer_A_51 -> {//	+ta2

fork{
	~gir04.brt_(~kRC2).playBufR(0.001, 1.1, 10.1, mul:0.9, out: ~strTek.choose);
	2.5.wait;
	~gir04.brt_(~kRB4).playBufR(0.001, 1.1, 10.1, mul:0.9, out: ~strTek.choose);


};

				}, 
			\layer_A_52 -> {//	|hek



~kik02.brt_(2.5).playPV5(0.001, 1.1, 1, mul:0.9, out: ~strCok.choose); // tek

fork{
	~kPseq01 = Pseq([~kRC2, ~kRC1, ~kRC5, ~kRC1, ~kRC2, ~kRC4, ~kRB3, ~kRB1].mirror, inf).asStream;
	~dur = Pseq([0.25, 0.36, 0.47, 0.58, 0.69, 0.80, 0.91, 0.94]/3, inf).asStream;
	8.do{
		
		//~gou02.brt_(~kPseq01 *0.89000).playPV5(0.001, 1.1, 10.1, mul:0.09, out: ~strTek.choose);
		~dur.next.wait;
		
		//~gou02.brt_(~kPseq01 *1.23700).playPV5(0.001, 1.1, 16.1, mul:0.01, out: ~strHep);
		~ats06.brt_(~kPseq01 *1.82101).playPV1(0.01, 1.0, 1.1, mul:0.9, start:0.5, out: ~strCok.choose);
		~dur.next.wait;

	};
	
	0.001.wait;
	
	~met02.brt_(~kRD4 *1.01000).playGverb(0.001, 3.1, 16.1, mul:0.5, room:55, rev:13.5, damp:0.71, out:~strCok.choose);
	~visRout.stop;
	OF.img(~imageLib.at('sleep', rrand(0,28)), 255, 187, [0].choose, 0);
	~ats02.brt_(~kRB4 *1.82101).playPV1(0.01, 1.0, 1.1, mul:0.9, start:0.5, out: ~strCok.choose);
	1.0.wait;
//:--rectFade
~blackFade={
	~fade = Pseq((0..255), inf).asStream;
	148.do{
		OF.rectOp(-100, -100, 1380, 1124, ~fade.next); 
		0.09.wait;
	};
}.fork;
	
	
};

	
			
				}, 
			
		//-------------------------------------------lev5-4/4--24s-----------------------------------------------
			\layer_A_53 -> {//	|te
"LayerA DEVR-i KEBIR level 5  4/4".postln;

~tol01.brt_(~kRD4 *1.23700).playGverb(0.001, 1.1, 16.1, mul:0.6, room:55, rev:23.5, damp:0.71, out: ~strCok.choose);


fork{		
	
	~kik01.brt_(1.5).playPV2(0.001, 1.1, 1, mul:0.1, out: ~strTek.choose); // dum				
	KafSinVib.ar(0.1, 0.1, 8.0, mul:0.3, freq1: ~kA1, freq2: ~kA1+3, vib1: 2.1, vib2: 4, out: ~strCok.choose).play;
	0.8.wait;
	fork{
		~mul01 = Pseq([0.5, 0.4, 0.3, 0.2, 0.1, 0.09, 0.07, 0.04]*0.9, inf).asStream;
		~dur01 = Pseq([0.25, 0.36, 0.47, 0.58, 0.69, 0.80, 0.91, 0.94, 0.99, 1.1].reverse/2, inf).asStream;
		10.do {|i|
			
			~kik02.brt_([9.5, 7.3, 4.5, 8.9].choose).playGverb(0.001, 1.1, 1, mul: ~mul01.next, room:18.4, rev:15, damp:0.91, out: ~strCok.choose);
			~dur01.next.wait;
		
		};
	};
	2.9.wait;
	~kik01.brt_(5.5).playGverb(0.001, 1.1, 1, mul: ~mul01.next, room:8.4, rev:1, damp:0.91, out: ~strTek.choose);

	~gir04.brt_(~kRC1).playGverbR(0.001, 1.1, 10.1, mul:0.9, room:55, rev:13.5, damp:0.71, out: ~strTek.choose);

};


				
				}, 
			\layer_A_54 -> {//	ke
fork{
	~gir04.brt_(~kRC2).playBufR(0.001, 1.1, 10.1, mul:0.9, out: ~strTek.choose);
	2.5.wait;
	~gir04.brt_(~kRB4).playBufR(0.001, 1.1, 10.1, mul:0.9, out: ~strTek.choose);


};
				
				}, 
			\layer_A_55 -> {//	|te

fork{
	~gir04.brt_(~kRC3).playBufR(0.001, 1.1, 10.1, mul:0.9, out: ~strTek.choose);
	2.5.wait;
	~gir04.brt_(~kRB5).playBufR(0.001, 1.1, 10.1, mul:0.9, out: ~strTek.choose);


};
				
				}, 
			\layer_A_56 -> {//	ke
				

fork{
	~gir04.brt_(~kRB7).playBufR(0.001, 1.1, 8.1, mul:0.9, out: ~strTek.choose);
	2.5.wait;
	~gir04.brt_(~kRC1).playBufR(0.001, 1.1, 10.1, mul:0.9, out: ~strTek.choose);


};

				
				
				},
			
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////-------------------------------------- BEREFSAN --------7 Levels-- 15 parts -- 3.2s -------------------------------------------------/////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//-------------------------------------------lev1-6/4--36s-----------------------------------------------
			\layer_A_57 -> {//	+dum2-3-4
"LayerA BEREFSAN".postln;				
~gir02.brt_(~kRD4 *1.07500).playGverb(1.1, 2.1, 16.1, mul:0.2, room:55, rev:13.5, damp:0.71, out: ~strCok.choose);

~kik01.brt_(1.5).playPV5(0.1, 1.1, 1, mul:0.9, out: ~strTek.choose); // dum

~ks38 = KafSinVib.ar(0.1, 0.1, 8.0, mul:0.3, freq1: ~kA4, freq2: ~kA4+3, vib1: 2.1, vib2: 4).play;

//vis
~visRout.stop;
~visRout = {
	
	
		
	~exit01 = Pseq((0..48), inf).asStream;
	~dur = Pseq([0.25/2], inf).asStream;
	inf.do{|i|
		
		
		OF.feedback("activate", 1);
		OF.feedback("speedXY", [0, 1, -1, 2, -2].choose, [0, -1, 1, 2, -2].choose);
		
		~dur.next.wait;
		
		//OF.destruct(225);
		
		~dur.next.wait;
		
		
		
		~dur.next.wait;
		
		OF.destruct; 
		OF.feedback("speedXY", [0, 2, -1, 1, 2].choose, [0, -1, 1, -2, 2].choose);
		
		~dur.next.wait;
		
		//OF.black(255); 
		
		
		~dur.next.wait;
		
		//OF.feedback("speedXY", -1, 0);
		OF.feedback("activate", 0);
				
		~dur.next.wait;
		
		
	};
	
	
}.fork;
		
				
				}, 
			\layer_A_58 -> {//	|tek2

~met02.brt_(~kRA5 *1.01000).playGverb(0.001, 1.1, 16.1, mul:0.6, room:55, rev:13.5, damp:0.71, out:~strTek.choose);

~kik01.brt_(1.3).playPV2(0.001, 1.1, 1, mul:0.5, out: ~strTek.choose); // dum

~ks39 = KafSinVib.ar(0.1, 0.1, 8.0, mul:0.4, freq1: ~kA3, freq2: ~kA3+3, vib1: 2.1, vib2: 4).play;

OF.img(~imageLib.at('exit', rrand(0,48)), 255, 255, [0, 90, 180, 270].choose, 0 );
				
				}, 
			
		//-------------------------------------------lev2-6/4--36s-----------------------------------------------
			\layer_A_59 -> {//	+dum2-3-4
				
~met02.brt_(~kRA6 *1.01000).playGverb(0.001, 0.1, 8.1, mul:0.7, room:55, rev:13.5, damp:0.71, out:~strTek.choose);

~kik01.brt_(1.5).playPV2(0.001, 1.1, 1, mul:0.1, out: ~strTek.choose); // dum

~ks40 = KafSinVib.ar(0.1, 0.1, 8.0, mul:0.3, freq1: ~kA2, freq2: ~kA2+3, vib1: 2.1, vib2: 4, out: ~strCok.choose).play;

~ats01.brt_(~kRA1/2 *1.82101).playPV3(0.01, 2.5, 5.1, mul:0.5, pv3a:8.0, start:0.5, out: ~strCok.choose);

OF.img(~imageLib.at('exit', rrand(0,48)), 255, 255, [0, 90, 180, 270].choose, 0 );

/*//:--rectFade
~rectFade={
	~fade = Pseq((255..255), 24).asStream;
	254.do{
		OF.black( 255); 
		0.04.wait;
	};
}.fork;*/	
			
				}, 
			\layer_A_60 -> {//	|tek2

fork{
	~kik02.brt_(1.5).playPV2(0.001, 1.1, 1, mul:0.1, out: ~strTek.choose); // dum
	0.04.wait;
	~met02.brt_(~kRA7 *1.01000).playGverb(0.001, 0.1, 8.1, mul:0.7, room:55, rev:3.5, damp:0.71, out:~strTek.choose);
	OF.img(~imageLib.at('exit', rrand(0,48)), 255, 255, [0, 90, 180, 270].choose, 0 );
	0.4.wait;
	~met02.brt_(~kRA5 *1.01000).playGverb(0.001, 0.1, 8.1, mul:0.7, room:55, rev:3.5, damp:0.71, out:~strTek.choose);
	~kik02.brt_(8.5).playPV2(0.001, 1.1, 1, mul:0.1, out: ~strTek.choose); // dum
	OF.img(~imageLib.at('exit', rrand(0,48)), 255, 255, [0, 90, 180, 270].choose, 0 );

};

~kik03.brt_(1.5).playPV2(0.001, 1.1, 1, mul:0.1, out: ~strTek.choose); // dum
OF.img(~imageLib.at('exit', rrand(0,48)), 255, 255, [0, 90, 180, 270].choose, 0 );

~ks41 = KafSinVib.ar(0.1, 0.1, 8.0, mul:0.8, freq1: ~kA6, freq2: ~kA5+3, vib1: 2.1, vib2: 4).play;

~ats01.brt_(~kRA1/2 *1.82101).playPV3(0.01, 2.5, 5.1, mul:0.5, pv3a:9.0, start:0.5, out: ~strCok.choose);
				
				}, 
			
		//-------------------------------------------lev3-4/4--24s-----------------------------------------------
			\layer_A_61 -> {//	+dum2-3-4

~met02.brt_(~kRA1 *1.01000).playGverb(0.001, 0.1, 8.1, mul:0.9, room:55, rev:13.5, damp:0.71, out:~strTek.choose);
~ks42 = KafSinVib.ar(0.1, 0.1, 8.0, mul:0.8, freq1: ~kA4, freq2: ~kA4+3, vib1: 2.1, vib2: 4).play;
OF.img(~imageLib.at('exit', rrand(0,48)), 255, 255, [0, 90, 180, 270].choose, 0 );
~ats01.brt_(~kRA1/2 *1.82101).playPV3(0.01, 2.5, 5.1, mul:0.5, pv3a:4.0, start:0.2, out: ~strCok.choose);
				
				}, 
			
		//-------------------------------------------lev4-4/4--24s-----------------------------------------------
			\layer_A_62 -> {//	|dum2

~met02.brt_(~kRA6 *1.01000).playGverb(0.001, 0.1, 9.1, mul:0.8, room:55, rev:13.5, damp:0.71, out:~strTek.choose);

~kik03.brt_(1.5).playPV2(0.001, 1.1, 1, mul:0.1, out: ~strTek.choose); // dum
OF.img(~imageLib.at('exit', rrand(0,48)), 255, 255, [0, 90, 180, 270].choose, 0 );

~ks43 = KafSinVib.ar(0.1, 0.1, 8.0, mul:0.3, freq1: ~kA6, freq2: ~kA2+3, vib1: 2.1, vib2: 4).play;

~ats01.brt_(~kRA1/2 *1.82101).playPV3(0.01, 2.5, 5.1, mul:0.5, pv3a:8.0, start:0.5, out: ~strCok.choose);

				
				}, 
			\layer_A_63 -> {//	tek2

~met02.brt_(~kRA3 *1.01000).playGverb(0.001, 0.1, 10.1, mul:0.9, room:55, rev:13.5, damp:0.71, out:~strTek.choose);

~kik02.brt_(1.5).playPV2(0.001, 1.1, 1, mul:0.1, out: ~strTek.choose); // dum
OF.img(~imageLib.at('exit', rrand(0,48)), 255, 255, [0, 90, 180, 270].choose, 0 );

~ks44 = KafSinVib.ar(0.1, 0.1, 8.0, mul:0.3, freq1: ~kA3, freq2: ~kA2+3, vib1: 2.1, vib2: 4).play;

~ats01.brt_(~kRA1/2 *1.82101).playPV3(0.01, 2.5, 5.1, mul:0.5, pv3a:8.0, start:0.5, out: ~strCok.choose);
				
				}, 
		//-------------------------------------------lev5-4/4--24s-----------------------------------------------
			\layer_A_64 -> {//	+dum2

~met02.brt_(~kRA4 *1.01000).playGverb(0.001, 0.1, 12.1, mul:0.9, room:55, rev:19.5, damp:0.71, out:~strTek.choose);

~kik02.brt_(1.5).playPV2(0.001, 1.1, 1, mul:0.1, out: ~strTek.choose); // dum
OF.img(~imageLib.at('exit', rrand(0,48)), 255, 255, [0, 90, 180, 270].choose, 0 );

~ks45 = KafSinVib.ar(0.1, 0.1, 8.0, mul:0.3, freq1: ~kA4, freq2: ~kA4+1, vib1: 2.1, vib2: 4).play;

~ats01.brt_(~kRA1/2 *1.82101).playPV3(0.01, 2.5, 5.1, mul:0.9, pv3a:8.0, start:0.5, out: ~strCok.choose);
				
				}, 
			\layer_A_65 -> {//	|dum2
OF.int("mirrorMode", 7);  //OK
~kik02.brt_(1.5).playPV2(0.001, 1.1, 1, mul:0.1, out: ~strTek.choose); // dum
fork{
	
	0.5.wait;
	
	~gir04
		.brt1_(~kRA1 *1.02006).brt1Dur_(0.1)
		.btrDur_(170.5)
		.brt2_(~kRC3 *1.02006).brt2Dur_(80)
	.transGverb(0.001, 1.09, 4.0, mul:0.3, start:0.0, out: ~strCok.choose);

	fork{
		3.do{
			var dur = Pseq([0.25, 0.25, 0.25, 0.25, 0.25, 0.25, 0.25, 0.25]/4, inf).asStream;
			var amp = Pseq((0.4..0.75), 8).asStream;
			~kik03.brt_(7.5).playPV5(0.001, 1.1, 1, mul:amp, out: ~strCok.choose); // tek
			OF.img(~imageLib.at('exit', rrand(0,48)), 255, 255, [0, 90, 180, 270].choose, 0 );	
			dur.next.wait;
			
			
		};
		~kik03.brt_(2.5).playPV5(0.001, 1.1, 1, mul:0.9, out: ~strCok.choose); // tek
		OF.img(~imageLib.at('exit', rrand(0,48)), 255, 255, [0, 90, 180, 270].choose, 0 );
		~met02.brt_(~kRA1 *1.01000).playGverb(0.001, 0.1, 8.1, mul:0.8, room:55, rev:3.5, damp:0.71, out:~strTek.choose);		
		1.5.wait;
		fork{
			~amp = Pseq((0.2..0.75), inf).asStream;
			3.do{
				
				var dur = Pseq([0.25, 0.25, 0.25, 0.25, 0.25, 0.25, 0.25, 0.25]/4, inf).asStream;
				//var amp = Pseq((0.4..0.75), 8).asStream;
				~kik02.brt_([12 ].choose).playPV4(0.001, 1.1, 1, mul:~amp, out: ~strCok.choose); // tek
				OF.img(~imageLib.at('exit', rrand(0,48)), 255, 255, [0, 90, 180, 270].choose, 0 );	
				dur.next.wait;
				
				
			};
			~kik03.brt_(1.3).playPV2(0.001, 1.1, 1, mul:0.4, out: ~strCok.choose); // tek
			~met02.brt_(~kRA7 *1.01000).playGverb(0.001, 2.1, 8.1, mul:0.9, room:15, rev:5.5, damp:0.71, out:~strTek.choose);	
		};
		
		
	};
	

};

//vis
~visRout.stop;
~visRout = {
	
	
		
	~exit01 = Pseq((0..48), inf).asStream;
	~dur = Pseq([0.25/2], inf).asStream;
	inf.do{|i|
		
		
		OF.feedback("activate", 1);
		OF.feedback("speedXY", [0, 1, -1, 2, -2].choose, [0, -1, 1, 2, -2].choose);
		
		~dur.next.wait;
		
		//OF.destruct(225);
		//OF.int("mirrorMode", 8);  //OK
		
		~dur.next.wait;
		
		OF.img(~imageLib.at('exit', ~exit01.next), 255, 255, [0, 90, 180, 270, 0, 0, 0].choose, [0, 1, 2, 3].choose );
		
		~dur.next.wait;
		
		//OF.destruct; 
		OF.feedback("speedXY", [0, 2, -1, 1, 2].choose, [0, -1, 1, -2, 2].choose);
		
		~dur.next.wait;
		
		//OF.black(255); 
		OF.img(~imageLib.at('exit', ~exit01.next), 255, 255, [0, 90, 180, 270, 0, 0, 0].choose, [0, 1, 2, 3].choose );
		
		~dur.next.wait;
		
		//OF.feedback("speedXY", -1, 0);
		OF.feedback("activate", 0);
				
		~dur.next.wait;
		OF.int("mirrorMode", 7);  //OK
		
	};
	
	
}.fork;


				
				}, 
		//-------------------------------------------lev6-4/4--24s-----------------------------------------------
			\layer_A_66 -> {//	+ta2

~visRout.stop;

fork{
	

	~kik03.brt_(1.5).playPV2(0.001, 1.1, 1, mul:0.1, out: ~strTek.choose); // dum
	~met02.brt_(~kRA4 *1.01000).playGverb(0.001, 0.1, 8.1, mul:0.6, room:55, rev:3.5, damp:0.71, out:~strTek.choose);
	OF.img(~imageLib.at('exit', ~exit01.next), 255, 255, [0, 90, 180, 270, 0, 0, 0].choose, [0, 1, 2, 3].choose );
	0.2.wait;
	~met03.brt_(~kRB1 *1.01000).playGverb(0.001, 0.1, 8.1, mul:0.8, room:55, rev:3.5, damp:0.71, out:~strTek.choose);
	~kik03.brt_(8.5).playPV2(0.001, 1.1, 1, mul:0.1, out: ~strTek.choose); // dum
	OF.img(~imageLib.at('exit', ~exit01.next), 255, 255, [0, 90, 180, 270, 0, 0, 0].choose, [0, 1, 2, 3].choose );

};

				}, 
			\layer_A_67 -> {//	|hek

	//:--rectFade
	~blackFade={
		~fade = Pseq((0..255), inf).asStream;
		48.do{
			OF.rectOp(-100, -100, 1380, 1124, ~fade.next); 
			0.04.wait;
		};
	}.fork;

	fork{
		3.do{
			var dur = Pseq([0.25, 0.25, 0.25, 0.25, 0.25, 0.25, 0.25, 0.25]/4, inf).asStream;
			var amp = Pseq((0.4..0.75), 8).asStream;
			~kik03.brt_(7.5).playPV2(0.001, 1.1, 1, mul:amp, out: ~strCok.choose); // tek	
			dur.next.wait;
			
			
		};
		~kik03.brt_(2.5).playPV5(0.001, 1.1, 1, mul:0.9, out: ~strCok.choose); // tek
		~met02.brt_(~kRA4 *1.01000).playGverb(0.001, 0.1, 8.1, mul:0.8, room:55, rev:3.5, damp:0.71, out:~strTek.choose);		
		1.5.wait;
		fork{
			~amp = Pseq((0.2..0.75), inf).asStream;
			3.do{
				
				var dur = Pseq([0.25, 0.25, 0.25, 0.25, 0.25, 0.25, 0.25, 0.25]/4, inf).asStream;
				//var amp = Pseq((0.4..0.75), 8).asStream;
				~kik02.brt_([12,2,8 ].choose).playPV4(0.001, 1.1, 1, mul:~amp, out: ~strCok.choose); // tek	
				dur.next.wait;
				
				
			};
			~kik03.brt_(9.3).playPV2(0.001, 1.1, 1, mul:0.4, out: ~strCok.choose); // tek	
		};
		
		
	};
				
				}, 
			
		//-------------------------------------------lev7-4/4--24s-----------------------------------------------
			\layer_A_68 -> {
OF.feedback("activate", 0);
OF.int("mirrorMode", 0);
OF.bMask(255);
OF.black(255);
OF.rectOp(-100, -100, 1380, 1124, 255);
OF.black(255);
				
				/*

fork {
	
	~ff = ~kA1;
	KafGendy.ar(8.1, 4.1, 2.3, 6.8,
		freq: [~ff*2, ~ff*3, ~ff*4, ~ff*5], 
		freqrlp1: ~kA1/2, 
		freqrlp2: ~ff*2,
		mul: 0.4,
		out: 0
	).play;


	
	9.5.wait;
	
	~ff = ~kA4;
	KafGendy.ar(1.1, 0.1, 4.3, 4.8,
		freq: [~ff*2, ~ff*3, ~ff*4, ~ff*5], 
		freqrlp1: ~kA1/2, 
		freqrlp2: ~ff*2,
		mul: 0.4,
		out: 0
	).play;
	~tht08.brt_(~kRB4 *1.10000).playPV4(1, 4.1, 5.1, pv4a:1.2, loop:0, out: ~strTek.choose); //ok


	//------vis-------//
	~visRout.stop;
	~visRout = {
		~seq = Pseq((0..5).mirror,inf).asStream;
		~op = Pseq((80..100), inf).asStream;
		~bright = Pseq((0..255), inf).asStream;
		250.do{
			
			OF.img(
				~imageLib.at('deli', ~seq.next), 
				~bright.next, ~op.next, [0,0,0,0].choose, 0
			);
			0.09.wait;
			
			
		}
	}.fork;



	5.5.wait;
	
	~ff = ~kA3;
	KafGendy.ar(1.1, 0.1, 4.3, 4.8,
		freq: [~ff*2, ~ff*3, ~ff*4, ~ff*5], 
		freqrlp1: ~kA1/2, 
		freqrlp2: ~ff*2,
		mul: 0.4,
		out: 0
	).play;
	
	
	
	
};				
	

	
				
				*/}, 
			\layer_A_69 -> {/*//	ke

fork {
	~ff = ~kA1;
	KafGendy.ar(1.1, 0.1, 4.3, 16.8,
		freq: [~ff*2, ~ff*3, ~ff*4, ~ff*5], 
		freqrlp1: ~kA1/2, 
		freqrlp2: ~ff*2,
		mul: 0.4,
		out: 0
	).play;
	
	~tht08.brt_(~kRB1 *1.10000).playPV4(1, 4.1, 5.1, pv4a:1.2, loop:0, out: ~strTek.choose); //ok
	
	//------vis-------//
	~visRout.stop;
	~visRout = {
		~seq = Pseq((0..5).mirror,inf).asStream;
		~op = Pseq((80..100), inf).asStream;
		~bright = Pseq((255..255), inf).asStream;
		250.do{
			
			OF.img(
				~imageLib.at('deli', ~seq.next), 
				~bright.next, ~op.next, [0,0,0,0].choose, 0
			);
			0.06.wait;
			
			
		}
	}.fork;
	
	9.5.wait;
	
	~ff = ~kA4;
	KafGendy.ar(1.1, 0.1, 4.3, 4.8,
		freq: [~ff*2, ~ff*3, ~ff*4, ~ff*5], 
		freqrlp1: ~kA1/2, 
		freqrlp2: ~ff*2,
		mul: 0.4,
		out: 0
	).play;
	~tht08.brt_(~kRB4 *1.10000).playPV4(1, 4.1, 5.1, pv4a:1.2, loop:0, out: ~strTek.choose); //ok
	
	//------vis-------//
	~visRout.stop;
	~visRout = {
		~seq = Pseq((0..5).mirror,inf).asStream;
		~op = Pseq((80..100), inf).asStream;
		~bright = Pseq((255..255), inf).asStream;
		250.do{
			
			OF.img(
				~imageLib.at('deli', ~seq.next), 
				~bright.next, ~op.next, [0,0,0,0].choose, 0
			);
			0.06.wait;
			
			
		}
	}.fork;

	5.5.wait;
	
	~ff = ~kA3;
	KafGendy.ar(1.1, 0.1, 4.3, 4.8,
		freq: [~ff*2, ~ff*3, ~ff*4, ~ff*5], 
		freqrlp1: ~kA1/2, 
		freqrlp2: ~ff*2,
		mul: 0.4,
		out: 0
	).play;
	~tht08.brt_(~kRB3 *1.10000).playPV4(1, 4.1, 5.1, pv4a:1.2, loop:0, out: ~strTek.choose); //ok
	
	//------vis-------//
	~visRout.stop;
	~visRout = {
		~seq = Pseq((0..5).mirror,inf).asStream;
		~op = Pseq((80..100), inf).asStream;
		~bright = Pseq((255..255), inf).asStream;
		250.do{
			
			OF.img(
				~imageLib.at('deli', ~seq.next), 
				~bright.next, ~op.next, [0,0,0,0].choose, 0
			);
			0.06.wait;
			
			
		}
	}.fork;
	
};

				
				*/}, 
			\layer_A_70 -> {/*//	|te

fork {
	~ff = ~kA1;
	KafGendy.ar(1.1, 0.1, 4.3, 16.8,
		freq: [~ff*2, ~ff*3, ~ff*4, ~ff*5], 
		freqrlp1: ~kA1/2, 
		freqrlp2: ~ff*2,
		mul: 0.4,
		out: 0
	).play;
	~tht08.brt_(~kRB1 *1.10000).playPV4(1, 4.1, 5.1, pv4a:1.2, loop:0, out: ~strTek.choose); //ok
	
	//------vis-------//
	~visRout.stop;
	~visRout = {
		~seq = Pseq((0..5).mirror,inf).asStream;
		~op = Pseq((80..100), inf).asStream;
		~bright = Pseq((255..255), inf).asStream;
		250.do{
			
			OF.img(
				~imageLib.at('deli', ~seq.next), 
				~bright.next, ~op.next, [0,0,0,0].choose, 0
			);
			0.06.wait;
			
			
		}
	}.fork;
	
	~ff = ~kA4;
	KafGendy.ar(1.1, 0.1, 4.3, 4.8,
		freq: [~ff*2, ~ff*3, ~ff*4, ~ff*5], 
		freqrlp1: ~kA1/2, 
		freqrlp2: ~ff*2,
		mul: 0.4,
		out: 0
	).play;
	~tht08.brt_(~kRB4 *1.10000).playPV4(1, 4.1, 5.1, pv4a:1.2, loop:0, out: ~strTek.choose); //ok
	
	//------vis-------//
	~visRout.stop;
	~visRout = {
		~seq = Pseq((0..5).mirror,inf).asStream;
		~op = Pseq((80..100), inf).asStream;
		~bright = Pseq((255..255), inf).asStream;
		250.do{
			
			OF.img(
				~imageLib.at('deli', ~seq.next), 
				~bright.next, ~op.next, [0,0,0,0].choose, 0
			);
			0.06.wait;
			
			
		}
	}.fork;

	5.5.wait;
	
	~ff = ~kA3;
	KafGendy.ar(1.1, 0.1, 4.3, 4.8,
		freq: [~ff*2, ~ff*3, ~ff*4, ~ff*5], 
		freqrlp1: ~kA1/2, 
		freqrlp2: ~ff*2,
		mul: 0.4,
		out: 0
	).play;
	~tht08.brt_(~kRB3 *1.10000).playPV4(1, 4.1, 5.1, pv4a:1.2, loop:0, out: ~strTek.choose); //ok
	
	//------vis-------//
	~visRout.stop;
	~visRout = {
		~seq = Pseq((0..5).mirror,inf).asStream;
		~op = Pseq((80..100), inf).asStream;
		~bright = Pseq((255..255), inf).asStream;
		250.do{
			
			OF.img(
				~imageLib.at('deli', ~seq.next), 
				~bright.next, ~op.next, [0,0,0,0].choose, 0
			);
			0.06.wait;
			
			
		}
	}.fork;
	
};
				
				*/}, 
			\layer_A_71 -> {/*//	ke

fork {
	~ff = ~kA1;
	KafGendy.ar(1.1, 0.1, 4.3, 16.8,
		freq: [~ff*2, ~ff*3, ~ff*4, ~ff*5], 
		freqrlp1: ~kA1/2, 
		freqrlp2: ~ff*2,
		mul: 0.4,
		out: 0
	).play;
	~tht08.brt_(~kRB1 *1.10000).playPV4(1, 4.1, 5.1, pv4a:1.2, loop:0, out: ~strTek.choose); //ok
	
	//------vis-------//
	~visRout.stop;
	~visRout = {
		~seq = Pseq((0..5).mirror,inf).asStream;
		~op = Pseq((80..100), inf).asStream;
		~bright = Pseq((255..255), inf).asStream;
		250.do{
			
			OF.img(
				~imageLib.at('deli', ~seq.next), 
				~bright.next, ~op.next, [0,0,0,0].choose, 0
			);
			0.06.wait;
			
			
		}
	}.fork;
	9.5.wait;
	
	~ff = ~kA4;
	KafGendy.ar(1.1, 0.1, 4.3, 4.8,
		freq: [~ff*2, ~ff*3, ~ff*4, ~ff*5], 
		freqrlp1: ~kA1/2, 
		freqrlp2: ~ff*2,
		mul: 0.4,
		out: 0
	).play;
	~tht08.brt_(~kRB4 *1.10000).playPV4(1, 4.1, 5.1, pv4a:1.2, loop:0, out: ~strTek.choose); //ok
	
	//------vis-------//
	~visRout.stop;
	~visRout = {
		~seq = Pseq((0..5).mirror,inf).asStream;
		~op = Pseq((80..100), inf).asStream;
		~bright = Pseq((255..255), inf).asStream;
		250.do{
			
			OF.img(
				~imageLib.at('deli', ~seq.next), 
				~bright.next, ~op.next, [0,0,0,0].choose, 0
			);
			0.06.wait;
			
			
		}
	}.fork;

	5.5.wait;
	
	~ff = ~kA3;
	KafGendy.ar(1.1, 0.1, 4.3, 4.8,
		freq: [~ff*2, ~ff*3, ~ff*4, ~ff*5], 
		freqrlp1: ~kA1/2, 
		freqrlp2: ~ff*2,
		mul: 0.4,
		out: 0
	).play;
	~tht08.brt_(~kRB3 *1.10000).playPV4(1, 4.1, 5.1, pv4a:1.2, loop:0, out: ~strTek.choose); //ok
	//------vis-------//
	~visRout.stop;
	~visRout = {
		~seq = Pseq((0..5).mirror,inf).asStream;
		~op = Pseq((80..100), inf).asStream;
		~bright = Pseq((255..0), inf).asStream;
		250.do{
			
			OF.img(
				~imageLib.at('deli', ~seq.next), 
				~bright.next, ~op.next, [0,0,0,0].choose, 0
			);
			0.06.wait;
			
			
		}
	}.fork;

OF.int("mirrorMode", 0);	
};
				
				*/}
		).play;
		
//------Zencir-------//
Pdef(\zencirLayerA, Posc(
	\msg, Pseq(
		[
		//cifteDuyek
		\layer_A_1, \layer_A_2, \layer_A_3, 
		\layer_A_4, \layer_A_5, \layer_A_6, \layer_A_7, \layer_A_8,
		//fahte
		\layer_A_9, \layer_A_10,\layer_A_11, 
		\layer_A_12, \layer_A_13, \layer_A_14, 
		\layer_A_15, \layer_A_16, \layer_A_17, 
		\layer_A_18, \layer_A_19, \layer_A_20, \layer_A_21, 
		//cember
		\layer_A_22, \layer_A_23, \layer_A_24, 
		\layer_A_25, \layer_A_26, \layer_A_27, 
		\layer_A_28, \layer_A_29, \layer_A_30,
		\layer_A_31, \layer_A_32, \layer_A_33, 
		\layer_A_34, \layer_A_35, \layer_A_36, \layer_A_37, 
		//devriKebir
		\layer_A_38, \layer_A_39, \layer_A_40, 
		\layer_A_41, \layer_A_42, \layer_A_43, \layer_A_44, \layer_A_45, 
		\layer_A_46, \layer_A_47, 
		\layer_A_48, \layer_A_49, \layer_A_50, \layer_A_51, \layer_A_52, 
		\layer_A_53, \layer_A_54, \layer_A_55, \layer_A_56, 
		//berefsan
		\layer_A_57, \layer_A_58, 
		\layer_A_59, \layer_A_60, 
		\layer_A_61, 
		\layer_A_62, \layer_A_63, \layer_A_64, \layer_A_65, \layer_A_66, \layer_A_67, 
		\layer_A_68, \layer_A_69, \layer_A_70, \layer_A_71
		
		], inf
	),
	\dur, Pseq(
		[
		//cifteDuyek
		Pseq([2, 4, 2], 1),
		Pseq([2, 2, 2, 1, 1], 1),
		//fahte
		Pseq([2, 1, 1], 1),
		Pseq([2, 2, 2], 1),
		Pseq([2, 2, 2], 1),
		Pseq([1, 1, 1,1], 1),
		//cember
		Pseq([2, 1, 1], 1),
		Pseq([2, 1, 1], 1),
		Pseq([2, 2, 2], 1),
		Pseq([2, 2, 2], 1),
		Pseq([1, 1, 1, 1], 1),
		//devriKebir
		Pseq([2, 2, 2], 1),
		Pseq([1, 1, 1/2, 1/2, 1], 1),
		Pseq([2, 2], 1),
		Pseq([2, 2, 2], 1),
		Pseq([2, 2], 1),
		Pseq([1, 1, 1, 1], 1),
		//berefsan
		Pseq([4, 2], 1),
		Pseq([4, 2], 1),
		Pseq([4], 1),
		Pseq([2, 2], 1),
		Pseq([2, 2], 1),
		Pseq([2, 2], 1),
		Pseq([1, 1, 1,1], 1)
		
		]*6, 1
	)
	)
);






//------CifteDuyek-------//
Pdef(\cifteDuyekLayerA, Posc(
	\msg, Pseq(
		[
		//cifteDuyek
		\layer_A_1, \layer_A_2, \layer_A_3, 
		\layer_A_4, \layer_A_5, \layer_A_6, \layer_A_7, \layer_A_8		
		], inf
	),
	\dur, Pseq(
		[
		//cifteDuyek
		Pseq([2, 4, 2], 1),
		Pseq([2, 2, 2, 1, 1], 1)
		
		]*6, 1
	)
	)
);

//------toFahte-------//
Pdef(\toFahteLayerA, Posc(
	\msg, Pseq(
		[
		\layer_A_7, \layer_A_8,
		//fahte
		\layer_A_9, \layer_A_10,\layer_A_11, 
		\layer_A_12, \layer_A_13, \layer_A_14, 
		\layer_A_15, \layer_A_16, \layer_A_17, 
		\layer_A_18, \layer_A_19, \layer_A_20, \layer_A_21, 
		//cember
		\layer_A_22, \layer_A_23, \layer_A_24, 
		\layer_A_25, \layer_A_26, \layer_A_27, 
		\layer_A_28, \layer_A_29, \layer_A_30,
		\layer_A_31, \layer_A_32, \layer_A_33, 
		\layer_A_34, \layer_A_35, \layer_A_36, \layer_A_37, 
		//devriKebir
		\layer_A_38, \layer_A_39, \layer_A_40, 
		\layer_A_41, \layer_A_42, \layer_A_43, \layer_A_44, \layer_A_45, 
		\layer_A_46, \layer_A_47, 
		\layer_A_48, \layer_A_49, \layer_A_50, \layer_A_51, \layer_A_52, 
		\layer_A_53, \layer_A_54, \layer_A_55, \layer_A_56, 
		//berefsan
		\layer_A_57, \layer_A_58, 
		\layer_A_59, \layer_A_60, 
		\layer_A_61, 
		\layer_A_62, \layer_A_63, \layer_A_64, \layer_A_65, \layer_A_66, \layer_A_67, 
		\layer_A_68, \layer_A_69, \layer_A_70, \layer_A_71
		], inf
	),
	\dur, Pseq(
		[
		Pseq([ 1, 1], 1),
		//fahte
		Pseq([2, 1, 1], 1),
		Pseq([2, 2, 2], 1),
		Pseq([2, 2, 2], 1),
		Pseq([1, 1, 1,1], 1),
		//cember
		Pseq([2, 1, 1], 1),
		Pseq([2, 1, 1], 1),
		Pseq([2, 2, 2], 1),
		Pseq([2, 2, 2], 1),
		Pseq([1, 1, 1, 1], 1),
		//devriKebir
		Pseq([2, 2, 2], 1),
		Pseq([1, 1, 1/2, 1/2, 1], 1),
		Pseq([2, 2], 1),
		Pseq([2, 2, 2], 1),
		Pseq([2, 2], 1),
		Pseq([1, 1, 1, 1], 1),
		//berefsan
		Pseq([4, 2], 1),
		Pseq([4, 2], 1),
		Pseq([4], 1),
		Pseq([2, 2], 1),
		Pseq([2, 2], 1),
		Pseq([2, 2], 1),
		Pseq([1, 1, 1,1], 1)
		]*6, 1
	)
	)
);


//---------Fahte-------//
Pdef(\fahteLayerA, Posc(
	\msg, Pseq(
		[

		//fahte
		\layer_A_9, \layer_A_10,\layer_A_11, 
		\layer_A_12, \layer_A_13, \layer_A_14, 
		\layer_A_15, \layer_A_16, \layer_A_17, 
		\layer_A_18, \layer_A_19, \layer_A_20, \layer_A_21
		
		
		], inf
	),
	\dur, Pseq(
		[

		//fahte
		Pseq([2, 1, 1], 1),
		Pseq([2, 2, 2], 1),
		Pseq([2, 2, 2], 1),
		Pseq([1, 1, 1,1], 1)
		
		]*6, 1
	)
	)
);


//------toCember-------//
Pdef(\toCemberLayerA, Posc(
	\msg, Pseq(
		[
		\layer_A_20, \layer_A_21,
		//cember
		\layer_A_22, \layer_A_23, \layer_A_24, 
		\layer_A_25, \layer_A_26, \layer_A_27, 
		\layer_A_28, \layer_A_29, \layer_A_30,
		\layer_A_31, \layer_A_32, \layer_A_33, 
		\layer_A_34, \layer_A_35, \layer_A_36, \layer_A_37, 
		//devriKebir
		\layer_A_38, \layer_A_39, \layer_A_40, 
		\layer_A_41, \layer_A_42, \layer_A_43, \layer_A_44, \layer_A_45, 
		\layer_A_46, \layer_A_47, 
		\layer_A_48, \layer_A_49, \layer_A_50, \layer_A_51, \layer_A_52, 
		\layer_A_53, \layer_A_54, \layer_A_55, \layer_A_56, 
		//berefsan
		\layer_A_57, \layer_A_58, 
		\layer_A_59, \layer_A_60, 
		\layer_A_61, 
		\layer_A_62, \layer_A_63, \layer_A_64, \layer_A_65, \layer_A_66, \layer_A_67, 
		\layer_A_68, \layer_A_69, \layer_A_70, \layer_A_71
		], inf
	),
	\dur, Pseq(
		[
		Pseq([ 1, 1], 1),
		//cember
		Pseq([2, 1, 1], 1),
		Pseq([2, 1, 1], 1),
		Pseq([2, 2, 2], 1),
		Pseq([2, 2, 2], 1),
		Pseq([1, 1, 1, 1], 1),
		//devriKebir
		Pseq([2, 2, 2], 1),
		Pseq([1, 1, 1/2, 1/2, 1], 1),
		Pseq([2, 2], 1),
		Pseq([2, 2, 2], 1),
		Pseq([2, 2], 1),
		Pseq([1, 1, 1, 1], 1),
		//berefsan
		Pseq([4, 2], 1),
		Pseq([4, 2], 1),
		Pseq([4], 1),
		Pseq([2, 2], 1),
		Pseq([2, 2], 1),
		Pseq([2, 2], 1),
		Pseq([1, 1, 1,1], 1)
		]*6, 1
	)
	)
);


//------Cember-------//
Pdef(\cemberLayerA, Posc(
	\msg, Pseq(
		[

		//cember
		\layer_A_22, \layer_A_23, \layer_A_24, 
		\layer_A_25, \layer_A_26, \layer_A_27, 
		\layer_A_28, \layer_A_29, \layer_A_30,
		\layer_A_31, \layer_A_32, \layer_A_33, 
		\layer_A_34, \layer_A_35, \layer_A_36, \layer_A_37
		
		], inf
	),
	\dur, Pseq(
		[

		//cember
		Pseq([2, 1, 1], 1),
		Pseq([2, 1, 1], 1),
		Pseq([2, 2, 2], 1),
		Pseq([2, 2, 2], 1),
		Pseq([1, 1, 1, 1], 1)
		
		]*6, 1
	)
	)
);

//------toDKebir-------//
Pdef(\toDevriKebirLayerA, Posc(
	\msg, Pseq(
		[
		\layer_A_31, \layer_A_32, \layer_A_33,
		\layer_A_34, \layer_A_35, \layer_A_36, \layer_A_37,
		//devriKebir
		\layer_A_38, \layer_A_39, \layer_A_40, 
		\layer_A_41, \layer_A_42, \layer_A_43, \layer_A_44, \layer_A_45, 
		\layer_A_46, \layer_A_47, 
		\layer_A_48, \layer_A_49, \layer_A_50, \layer_A_51, \layer_A_52, 
		\layer_A_53, \layer_A_54, \layer_A_55, \layer_A_56, 
		//berefsan
		\layer_A_57, \layer_A_58, 
		\layer_A_59, \layer_A_60, 
		\layer_A_61, 
		\layer_A_62, \layer_A_63, \layer_A_64, \layer_A_65, \layer_A_66, \layer_A_67, 
		\layer_A_68, \layer_A_69, \layer_A_70, \layer_A_71
		], inf
	),
	\dur, Pseq(
		[
		Pseq([2, 2, 2], 1),
		Pseq([1, 1, 1, 1], 1),
		//devriKebir
		Pseq([2, 2, 2], 1),
		Pseq([1, 1, 1/2, 1/2, 1], 1),
		Pseq([2, 2], 1),
		Pseq([2, 2, 2], 1),
		Pseq([2, 2], 1),
		Pseq([1, 1, 1, 1], 1),
		//berefsan
		Pseq([4, 2], 1),
		Pseq([4, 2], 1),
		Pseq([4], 1),
		Pseq([2, 2], 1),
		Pseq([2, 2], 1),
		Pseq([2, 2], 1),
		Pseq([1, 1, 1,1], 1)
		]*6, 1
	)
	)
);

//------devriKebirLayerA-------//
Pdef(\devriKebirLayerA, Posc(
	\msg, Pseq(
		[

		//devriKebir
		\layer_A_38, \layer_A_39, \layer_A_40, 
		\layer_A_41, \layer_A_42, \layer_A_43, \layer_A_44, \layer_A_45, 
		\layer_A_46, \layer_A_47, 
		\layer_A_48, \layer_A_49, \layer_A_50, \layer_A_51, \layer_A_52, 
		\layer_A_53, \layer_A_54, \layer_A_55, \layer_A_56
		
		], inf
	),
	\dur, Pseq(
		[

		//devriKebir
		Pseq([2, 2, 2], 1),
		Pseq([1, 1, 1/2, 1/2, 1], 1),
		Pseq([2, 2], 1),
		Pseq([2, 2, 2], 1),
		Pseq([2, 2], 1),
		Pseq([1, 1, 1, 1], 1)
		
		]*6, 1
	)
	)
);

//------toBerefsan-------//
Pdef(\toBerefsanLayerA, Posc(
	\msg, Pseq(
		[
		\layer_A_55, \layer_A_56, 
		//berefsan
		\layer_A_57, \layer_A_58, 
		\layer_A_59, \layer_A_60, 
		\layer_A_61, 
		\layer_A_62, \layer_A_63, \layer_A_64, \layer_A_65, \layer_A_66, \layer_A_67, 
		\layer_A_68, \layer_A_69, \layer_A_70, \layer_A_71
		], inf
	),
	\dur, Pseq(
		[
		Pseq([ 1, 1], 1),
		//berefsan
		Pseq([4, 2], 1),
		Pseq([4, 2], 1),
		Pseq([4], 1),
		Pseq([2, 2], 1),
		Pseq([2, 2], 1),
		Pseq([2, 2], 1),
		Pseq([1, 1, 1,1], 1)
		]*6, 1
	)
	)
);

//------Berefsan-------//
Pdef(\berefsanLayerA, Posc(
	\msg, Pseq(
		[

		//berefsan
		\layer_A_57, \layer_A_58, 
		\layer_A_59, \layer_A_60, 
		\layer_A_61, 
		\layer_A_62, \layer_A_63, \layer_A_64, \layer_A_65, \layer_A_66, \layer_A_67, 
		\layer_A_68, \layer_A_69, \layer_A_70, \layer_A_71
		
		], inf
	),
	\dur, Pseq(
		[

		//berefsan
		Pseq([4, 2], 1),
		Pseq([4, 2], 1),
		Pseq([4], 1),
		Pseq([2, 2], 1),
		Pseq([2, 2], 1),
		Pseq([2, 2], 1),
		Pseq([1, 1, 1,1], 1)
		
		]*6, 1
	)
	)
);




	
	
		
	
	}	
	


}