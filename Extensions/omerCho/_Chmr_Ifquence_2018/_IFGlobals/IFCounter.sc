/*
IFCounter.count;
IFCounter.get;
IFCounter.step(5);
IFCounter.reset;


~ifTime= Clock.seconds-Clock.seconds;

*/
IFCounter{
	classvar <>cnt=0, <>counter=0, <>mainCount=0, <>clock, <>clockNow;



	*loadProxy {
		~stepNumCnt = PatternProxy( Pseq([0], inf));
		~stepNumCntP= Pseq([~stepNumCnt], inf).asStream;
	}

	*get{
		^mainCount.postln;
	}
	*getClockNow{
		clockNow=Clock.seconds;
		^clockNow;
	}
	*reset{
		mainCount=0;
		~tOSCAdrr.sendMsg('mainCountLabel', mainCount);
	}

	*count {
		mainCount = mainCount + 1;

		clock = (clockNow-Clock.seconds)*(-1);
		[["IF Time:",clock.asInt]++["IF Steps:",mainCount]].postln;
		//if (mainCount % 16 != 0, mainCount.postln, clockNow-Clock.seconds.postln);
		~tOSCAdrr.sendMsg('mainCountLabel', mainCount);
		~tOSCAdrr.sendMsg('ifTimeBar1H', clock);
		mainCount.switch(
			1, {

			},
			2, {

			},
		)
	}

	*step{|i|
		this.st(i);
	}

	*st01 {
		"-1".postln;
		fork{~tOSCAdrr.sendMsg('seqLed01', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed01', 0);};
	}
	*st02 {
		"--2".postln;
		fork{~tOSCAdrr.sendMsg('seqLed02', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed02', 0);};
	}
	*st03 {
		"---3".postln;
		fork{~tOSCAdrr.sendMsg('seqLed03', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed03', 0);};
	}
	*st04 {
		"----4".postln;
		fork{~tOSCAdrr.sendMsg('seqLed04', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed04', 0);};
	}
	*st05 {
		"-5".postln;
		fork{~tOSCAdrr.sendMsg('seqLed05', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed05', 0);};
	}
	*st06 {
		"--6".postln;
		fork{~tOSCAdrr.sendMsg('seqLed06', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed06', 0);};
	}
	*st07 {
		"---7".postln;
		fork{~tOSCAdrr.sendMsg('seqLed07', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed07', 0);};
	}
	*st08 {
		"----8".postln;
		fork{~tOSCAdrr.sendMsg('seqLed08', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed08', 0);};
	}
	*st09 {
		"-9".postln;
		fork{~tOSCAdrr.sendMsg('seqLed09', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed09', 0);};
	}
	*st10 {
		"--10".postln;
		fork{~tOSCAdrr.sendMsg('seqLed10', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed10', 0);};
	}
	*st11 {
		"---11".postln;
		fork{~tOSCAdrr.sendMsg('seqLed11', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed11', 0);};
	}
	*st12 {
		"----12".postln;
		fork{~tOSCAdrr.sendMsg('seqLed12', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed12', 0);};
	}
	*st13 {
		"-13".postln;
		fork{~tOSCAdrr.sendMsg('seqLed13', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed13', 0);};
	}
	*st14 {
		"--14".postln;
		fork{~tOSCAdrr.sendMsg('seqLed14', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed14', 0);};
	}
	*st15 {
		"---15".postln;
		fork{~tOSCAdrr.sendMsg('seqLed15', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed15', 0);};
	}
	*st16 {
		"----16".postln;
		fork{~tOSCAdrr.sendMsg('seqLed16', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed16', 0);};
	}

	*countOld {
		counter = counter + 1;
		//~tOSCAdrr.sendMsg('mainCountLabel', counter);
		counter.switch(
			1, {
				"-1".postln;
				fork{~tOSCAdrr.sendMsg('seqLed01', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed01', 0);};
			},
			2, {
				"--2".postln;
				fork{~tOSCAdrr.sendMsg('seqLed02', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed02', 0);};
			},
			3, {
				"---3".postln;
				fork{~tOSCAdrr.sendMsg('seqLed03', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed03', 0);};
			},
			4, {
				"----4".postln;
				fork{~tOSCAdrr.sendMsg('seqLed04', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed04', 0);};
			},
			5, {
				"-5".postln;
				fork{~tOSCAdrr.sendMsg('seqLed05', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed05', 0);};
			},
			6, {
				"--6".postln;
				fork{~tOSCAdrr.sendMsg('seqLed06', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed06', 0);};
			},
			7, {
				"---7".postln;
				fork{~tOSCAdrr.sendMsg('seqLed07', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed07', 0);};
			},
			8, {
				"----8".postln;
				fork{~tOSCAdrr.sendMsg('seqLed08', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed08', 0);};
			},
			9, {
				"-9".postln;
				fork{~tOSCAdrr.sendMsg('seqLed09', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed09', 0);};
			},
			10, {
				"--10".postln;
				fork{~tOSCAdrr.sendMsg('seqLed10', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed10', 0);};
			},
			11, {
				"---11".postln;
				fork{~tOSCAdrr.sendMsg('seqLed11', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed11', 0);};
			},
			12, {
				"----12".postln;
				fork{~tOSCAdrr.sendMsg('seqLed12', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed12', 0);};
			},
			13, {
				"-13".postln;
				fork{~tOSCAdrr.sendMsg('seqLed13', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed13', 0);};
			},
			14, {
				"--14".postln;
				fork{~tOSCAdrr.sendMsg('seqLed14', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed14', 0);};
			},
			15, {
				"---15".postln;
				fork{~tOSCAdrr.sendMsg('seqLed15', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed15', 0);};
			},

			16,{
				"----16".postln;
				fork{~tOSCAdrr.sendMsg('seqLed16', 1); 0.3.wait; ~tOSCAdrr.sendMsg('seqLed16', 0);};
				this.ctrl_8;
				this.reset;
				//~countSeqRec=1;
			}

		)
	}

	*zero{

		counter = 0;
		//~tOSCAdrr.sendMsg('mainCountLabel', counter);


	}


	*ctrl_8 {



		/*~res1Mcr2.stop;
		~res1Mcr2={
		var val;
		val = Pslide((30..100).mirror, inf,3,1,0).asStream;
		240.do{
		~mdOut.control(~res1Ch, ~res1Mac2, val.next);
		(~dur.next*(1/8)).wait;
		}
		}.fork;*/

	}

	/*	*count {

	counter = counter + 1;
	//~tOSCAdrr.sendMsg('mainCountLabel', counter);
	counter.switch(
	1, {
	"1".postln;
	~tOSCAdrr.sendMsg('seqLed08', 0);
	~tOSCAdrr.sendMsg('seqLed01', 1);
	//~countSeqRec = ~countSeqRec + 1;
	},
	2, {
	"2".postln;
	~tOSCAdrr.sendMsg('seqLed01', 0);
	~tOSCAdrr.sendMsg('seqLed02', 1);
	//~countSeqRec = ~countSeqRec + 1;
	},
	3, {
	"3".postln;
	~tOSCAdrr.sendMsg('seqLed02', 0);
	~tOSCAdrr.sendMsg('seqLed03', 1);
	//~countSeqRec = ~countSeqRec + 1;
	},
	4, {
	"4".postln;
	~tOSCAdrr.sendMsg('seqLed03', 0);
	~tOSCAdrr.sendMsg('seqLed04', 1);
	//~countSeqRec = ~countSeqRec + 1;
	},
	5, {
	"5".postln;
	~tOSCAdrr.sendMsg('seqLed04', 0);
	~tOSCAdrr.sendMsg('seqLed05', 1);
	//~countSeqRec = ~countSeqRec + 1;
	},
	6, {
	"6".postln;
	~tOSCAdrr.sendMsg('seqLed05', 0);
	~tOSCAdrr.sendMsg('seqLed06', 1);
	//~countSeqRec = ~countSeqRec + 1;
	},
	7, {
	"7".postln;
	~tOSCAdrr.sendMsg('seqLed06', 0);
	~tOSCAdrr.sendMsg('seqLed07', 1);
	//~countSeqRec = ~countSeqRec + 1;
	},
	8,{
	"8".postln;
	~tOSCAdrr.sendMsg('seqLed07', 0);
	~tOSCAdrr.sendMsg('seqLed08', 1);
	this.ctrl_8;
	this.reset;
	//~countSeqRec=1;
	},
	9, {
	//("Main Count: "+counter).postln;
	//"1".postln;
	//~tOSCAdrr.sendMsg('seqLed08', 0);
	//~tOSCAdrr.sendMsg('seqLed01', 1);


	}

	)
	}*/





}