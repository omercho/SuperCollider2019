/*
IFTxt.make(\00,\ifKick,11);
IFTxt.make(\00,\ifSnr,11);
IFTxt.make(\00,\ifHat,11);
IFTxt.make(\00,\ifBass,6);
IFTxt.make(\00,\ifKeys,6);
IFTxt.make(\00,\ifSamp,6);
IFTxt.make(\00,\ifMopho,6);

IFTxt.trckDflt;

IFTxt.readFile(\00,\ifKick);
~tKcAmp=IFTxt.line(1);
~tKcNt=IFTxt.line(2);
~tKcVel=IFTxt.line(3);
~tKcSus=IFTxt.line(4);
~tKcTm=IFTxt.line(5);
~tKcDur=IFTxt.line(6);
~tKc2Amp=IFTxt.line(7);
~tKc2Nt=IFTxt.line(8);
~tKc2Vel=IFTxt.line(9);
~tKc2Sus=IFTxt.line(10);
~tKcOct=IFTxt.line(11);

IFTxt.readFile(\00,\ifSnr);
~tSrAmp=IFTxt.line(1);
~tSrNt=IFTxt.line(2);
~tSrVel=IFTxt.line(3);
~tSrSus=IFTxt.line(4);
~tSrTm=IFTxt.line(5);
~tSrDur=IFTxt.line(6);
~tSr2Amp=IFTxt.line(7);
~tSr2Nt=IFTxt.line(8);
~tSr2Vel=IFTxt.line(9);
~tSr2Sus=IFTxt.line(10);
~tSrOct=IFTxt.line(11);

IFTxt.readFile(\00,\ifHat);
~tHtAmp=IFTxt.line(1);
~tHtNt=IFTxt.line(2);
~tHtVel=IFTxt.line(3);
~tHtSus=IFTxt.line(4);
~tHtTm=IFTxt.line(5);
~tHtDur=IFTxt.line(6);
~tHt2Amp=IFTxt.line(7);
~tHt2Nt=IFTxt.line(8);
~tHt2Vel=IFTxt.line(9);
~tHt2Sus=IFTxt.line(10);
~tHtOct=IFTxt.line(11);

IFTxt.readFile(\00,\ifBass);
~tBsAmp=IFTxt.line(1);
~tBsNt=IFTxt.line(2);
~tBsVel=IFTxt.line(3);
~tBsSus=IFTxt.line(4);
~tBsTm=IFTxt.line(5);
~tBsDur=IFTxt.line(6);

IFTxt.readFile(\00,\ifKeys);
~tKyAmp=IFTxt.line(1);
~tKyNt=IFTxt.line(2);
~tKyVel=IFTxt.line(3);
~tKySus=IFTxt.line(4);
~tKyTm=IFTxt.line(5);
~tKyDur=IFTxt.line(6);

IFTxt.readFile(\00,\ifSamp);
~tSmAmp=IFTxt.line(1);
~tSmNt=IFTxt.line(2);
~tSmVel=IFTxt.line(3);
~tSmSus=IFTxt.line(4);
~tSmTm=IFTxt.line(5);
~tSmDur=IFTxt.line(6);

IFTxt.readFile(\00,\ifMopho);
~tMpAmp=IFTxt.line(1);
~tMpNt=IFTxt.line(2);
~tMpVel=IFTxt.line(3);
~tMpSus=IFTxt.line(4);
~tMpTm=IFTxt.line(5);
~tMpDur=IFTxt.line(6);

*/

IFTxt{
	classvar <>file, <>path, <>trckPath, <>lineOut,<>rdFile;
	*initClass {
		StartUp add: {
			//Server.default.doWhenBooted({this.paths; });
		}
	}
	*makePath{|dirIndex=00,fileName|
		^path="~/Library/Application Support/SuperCollider/Extensions/omerCho/CHMR_IFTxt_Patterns/IFTracks/"++dirIndex++"/"++fileName++".txt"
	}
	*trackPath{|trck=01,prt=01,inst|
		^trckPath="~/Library/Application Support/SuperCollider/Extensions/omerCho/CHMR_IFTxt_Patterns/IFTracks/"++trck++"/"++prt++"/"++inst++".txt"
	}
	*readFile{|dir,fileName|
		this.makePath(dir,fileName);
		rdFile = CSVFileReader.readInterpret(path.standardizePath, true, true);
	}
	*readTrack{|trck,prt,inst|
		this.trackPath(trck,prt,inst);
		rdFile = CSVFileReader.readInterpret(trckPath.standardizePath, true, true);
	}
	*line{|i|
		i.switch(i,{lineOut=rdFile[i-1];});
		^lineOut;
	}
	*storeInst{|track|
		IFTxt.readFile(track,\ifKick);
		~tKcAmp=IFTxt.line(1);
		~tKcNt=IFTxt.line(2);
		~tKcVel=IFTxt.line(3);
		~tKcSus=IFTxt.line(4);
		~tKcTm=IFTxt.line(5);
		~tKcDur=IFTxt.line(6);
		~tKc2Amp=IFTxt.line(7);
		~tKc2Nt=IFTxt.line(8);
		~tKc2Vel=IFTxt.line(9);
		~tKc2Sus=IFTxt.line(10);
		~tKcOct=IFTxt.line(11);

		IFTxt.readFile(track,\ifSnr);
		~tSrAmp=IFTxt.line(1);
		~tSrNt=IFTxt.line(2);
		~tSrVel=IFTxt.line(3);
		~tSrSus=IFTxt.line(4);
		~tSrTm=IFTxt.line(5);
		~tSrDur=IFTxt.line(6);
		~tSr2Amp=IFTxt.line(7);
		~tSr2Nt=IFTxt.line(8);
		~tSr2Vel=IFTxt.line(9);
		~tSr2Sus=IFTxt.line(10);
		~tSrOct=IFTxt.line(11);

		IFTxt.readFile(track,\ifHat);
		~tHtAmp=IFTxt.line(1);
		~tHtNt=IFTxt.line(2);
		~tHtVel=IFTxt.line(3);
		~tHtSus=IFTxt.line(4);
		~tHtTm=IFTxt.line(5);
		~tHtDur=IFTxt.line(6);
		~tHt2Amp=IFTxt.line(7);
		~tHt2Nt=IFTxt.line(8);
		~tHt2Vel=IFTxt.line(9);
		~tHt2Sus=IFTxt.line(10);
		~tHtOct=IFTxt.line(11);

		IFTxt.readFile(track,\ifBass);
		~tBsAmp=IFTxt.line(1);
		~tBsNt=IFTxt.line(2);
		~tBsVel=IFTxt.line(3);
		~tBsSus=IFTxt.line(4);
		~tBsTm=IFTxt.line(5);
		~tBsDur=IFTxt.line(6);

		IFTxt.readFile(track,\ifKeys);
		~tKyAmp=IFTxt.line(1);
		~tKyNt=IFTxt.line(2);
		~tKyVel=IFTxt.line(3);
		~tKySus=IFTxt.line(4);
		~tKyTm=IFTxt.line(5);
		~tKyDur=IFTxt.line(6);

		IFTxt.readFile(track,\ifSamp);
		~tSmAmp=IFTxt.line(1);
		~tSmNt=IFTxt.line(2);
		~tSmVel=IFTxt.line(3);
		~tSmSus=IFTxt.line(4);
		~tSmTm=IFTxt.line(5);
		~tSmDur=IFTxt.line(6);

		IFTxt.readFile(track,\ifMopho);
		~tMpAmp=IFTxt.line(1);
		~tMpNt=IFTxt.line(2);
		~tMpVel=IFTxt.line(3);
		~tMpSus=IFTxt.line(4);
		~tMpTm=IFTxt.line(5);
		~tMpDur=IFTxt.line(6);
	}
	*readInst{|trck,prt|
		IFTxt.readTrack(trck,prt,\ifKick);
		~tKcAmp=IFTxt.line(1);
		~tKcNt=IFTxt.line(2);
		~tKcVel=IFTxt.line(3);
		~tKcSus=IFTxt.line(4);
		~tKcTm=IFTxt.line(5);
		~tKcDur=IFTxt.line(6);
		~tKc2Amp=IFTxt.line(7);
		~tKc2Nt=IFTxt.line(8);
		~tKc2Vel=IFTxt.line(9);
		~tKc2Sus=IFTxt.line(10);
		~tKcOct=IFTxt.line(11);

		IFTxt.readTrack(trck,prt,\ifSnr);
		~tSrAmp=IFTxt.line(1);
		~tSrNt=IFTxt.line(2);
		~tSrVel=IFTxt.line(3);
		~tSrSus=IFTxt.line(4);
		~tSrTm=IFTxt.line(5);
		~tSrDur=IFTxt.line(6);
		~tSr2Amp=IFTxt.line(7);
		~tSr2Nt=IFTxt.line(8);
		~tSr2Vel=IFTxt.line(9);
		~tSr2Sus=IFTxt.line(10);
		~tSrOct=IFTxt.line(11);

		IFTxt.readTrack(trck,prt,\ifHat);
		~tHtAmp=IFTxt.line(1);
		~tHtNt=IFTxt.line(2);
		~tHtVel=IFTxt.line(3);
		~tHtSus=IFTxt.line(4);
		~tHtTm=IFTxt.line(5);
		~tHtDur=IFTxt.line(6);
		~tHt2Amp=IFTxt.line(7);
		~tHt2Nt=IFTxt.line(8);
		~tHt2Vel=IFTxt.line(9);
		~tHt2Sus=IFTxt.line(10);
		~tHtOct=IFTxt.line(11);

		IFTxt.readTrack(trck,prt,\ifBass);
		~tBsAmp=IFTxt.line(1);
		~tBsNt=IFTxt.line(2);
		~tBsVel=IFTxt.line(3);
		~tBsSus=IFTxt.line(4);
		~tBsTm=IFTxt.line(5);
		~tBsDur=IFTxt.line(6);

		IFTxt.readTrack(trck,prt,\ifKeys);
		~tKyAmp=IFTxt.line(1);
		~tKyNt=IFTxt.line(2);
		~tKyVel=IFTxt.line(3);
		~tKySus=IFTxt.line(4);
		~tKyTm=IFTxt.line(5);
		~tKyDur=IFTxt.line(6);

		IFTxt.readTrack(trck,prt,\ifSamp);
		~tSmAmp=IFTxt.line(1);
		~tSmNt=IFTxt.line(2);
		~tSmVel=IFTxt.line(3);
		~tSmSus=IFTxt.line(4);
		~tSmTm=IFTxt.line(5);
		~tSmDur=IFTxt.line(6);

		IFTxt.readTrack(trck,prt,\ifMopho);
		~tMpAmp=IFTxt.line(1);
		~tMpNt=IFTxt.line(2);
		~tMpVel=IFTxt.line(3);
		~tMpSus=IFTxt.line(4);
		~tMpTm=IFTxt.line(5);
		~tMpDur=IFTxt.line(6);
	}

	/**makePath{|dirIndex=00,fileName|
		^path="~/Library/Application Support/SuperCollider/Extensions/omerCho/CHMR_IFTxt_Patterns/Track_00/"++dirIndex++"/"++fileName++".txt"
	}
	*trackPath{|trck=01,prt=01,inst|
		^trckPath="~/Library/Application Support/SuperCollider/Extensions/omerCho/CHMR_IFTxt_Patterns/"++trck++"/"++prt++"/"++inst++".txt"
	}*/
	*rnd4Line{|dir,fileName|
		var cnt=1, min=0,max=1;
		fork{
			this.makePath(dir,fileName);
			file=File.new(path.standardizePath,"w");
			0.02.wait;
			(1..64).do{|n|
				case
				{cnt>0&&cnt<=16}{min=(0);max=(1);}
				{cnt>16&&cnt<=32}{min=(-7);max=(7);}
				{cnt>32&&cnt<=48}{min=(1);max=(3);}
				{cnt>48}{min=(1);max=(5);};
				file.write(
					(min..max).choose.asString ++ if (n % 16 != 0, ",", Char.nl)
				);
				cnt=cnt+1;
			};
			0.02.wait;
			file.close;
		}
	}
	*rnd6Line{|dir,fileName|
		var cnt=1, min=0,max=1;
		fork{
			this.makePath(dir,fileName);
			file=File.new(path.standardizePath,"w");
			0.02.wait;
			(1..96).do{|n|
				case
				{cnt>0&&cnt<=16}{min=(0);max=(1);}//amp
				{cnt>16&&cnt<=32}{min=(-4);max=(7);}//nt
				{cnt>32&&cnt<=48}{min=(1);max=(3);}//vel
				{cnt>48&&cnt<=64}{min=(1);max=(5);}//sus
				{cnt>64&&cnt<=80}{min=(1);max=(1);}//tm
				{cnt>80&&cnt<=96}{min=(4);max=(4);};//dur
				file.write(
					(min..max).choose.asString ++ if (n % 16 != 0, ",", Char.nl)
				);
				cnt=cnt+1;
			};
			0.02.wait;
			file.close;
		}
	}
	*rndMel{|dir,fileName|
		var cnt=1, min=0,max=1;
		fork{
			this.makePath(dir,fileName);
			file=File.new(path.standardizePath,"w");
			0.02.wait;
			(1..96).do{|n|
				case
				{cnt>0&&cnt<=16}{min=(0);max=(1);}//amp
				{cnt>16&&cnt<=32}{min=(-4);max=(7);}//nt
				{cnt>32&&cnt<=48}{min=(1);max=(3);}//vel
				{cnt>48&&cnt<=64}{min=(1);max=(5);}//sus
				{cnt>64&&cnt<=80}{min=(1);max=(1);}//tm
				{cnt>80&&cnt<=96}{min=(4);max=(4);};//dur
				file.write(
					(min..max).choose.asString ++ if (n % 16 != 0, ",", Char.nl)
				);
				cnt=cnt+1;
			};
			0.02.wait;
			file.close;
		}
	}
	*rnd11Line{|dir,fileName|
		var cnt=1, min=0,max=1;
		fork{
			this.makePath(dir,fileName);
			file=File.new(path.standardizePath,"w");
			0.02.wait;
			(1..176).do{|n|
				case
				{cnt>0&&cnt<=16}{min=(0);max=(1);}//amp
				{cnt>16&&cnt<=32}{min=(0);max=(7);}//nt
				{cnt>32&&cnt<=48}{min=(1);max=(3);}//vel
				{cnt>48&&cnt<=64}{min=(1);max=(5);}//sus
				{cnt>64&&cnt<=80}{min=(1);max=(1);}//tm
				{cnt>80&&cnt<=96}{min=(4);max=(4);}//dur
				{cnt>96&&cnt<=112}{min=(0);max=(1);}//amp2
				{cnt>112&&cnt<=128}{min=(-7);max=(14);}//nt2
				{cnt>128&&cnt<=144}{min=(1);max=(3);}//vel2
				{cnt>144&&cnt<=160}{min=(1);max=(5);}//sus2
				{cnt>160&&cnt<=176}{min=(1);max=(4);};//oct
				file.write(
					(min..max).choose.asString ++ if (n % 16 != 0, ",", Char.nl)
				);
				cnt=cnt+1;
			};
			0.02.wait;
			file.close;
		}
	}
	*make{|dir,nm,lines|
		lines.switch(
			4,{
				fork{
					this.rnd4Line(dir,nm);
					0.1.wait;
					this.readFile(dir,nm);
					0.1.wait;

				};
			},
			6, {
				fork{
					this.rnd6Line(dir,nm);
					0.1.wait;
					this.readFile(dir,nm);
					0.1.wait;

				};
			},
			11, {
				fork{
					this.rnd11Line(dir,nm);
					0.1.wait;
					this.readFile(dir,nm);
					0.1.wait;

				};
			};
		)
	}
	*trckDflt{
		fork{
			IFTxt.make(\00,\ifKick,11);
			0.1.wait;
			IFTxt.make(\00,\ifSnr,11);
			0.1.wait;
			IFTxt.make(\00,\ifHat,11);
			0.1.wait;
			IFTxt.make(\00,\ifBass,6);
			0.1.wait;
			IFTxt.make(\00,\ifKeys,6);
			0.1.wait;
			IFTxt.make(\00,\ifSamp,6);
			0.1.wait;
			IFTxt.make(\00,\ifMopho,6);
			0.1.wait;
			//IFTxt.storeInst(\00);

		}
	}

}

/*
(
AppClock.sched(0.0,{ arg time;
    ["AppClock has been playing for ",time].postln;
    rrand(0.1,0.9);
});
)

(
AppClock.sched(2.0,{
    "2.0 seconds later".postln;
    nil;
});
)
5*60

AppClock.clear;

IFTxst.rnd6Line;
IFTxst.wrt(0,1);
IFTxst.wrtC(0,1);
IFTxst.write(0,1);
IFTxst.writeDo(0,1);
IFTxst.writeArrDo(16,2);
IFTxst.readFile;

//OKKKKK
IFTxst.rnd6Line;
IFTxst.wrtC(0,1);
~flCsv=CSVFileReader.read("~/CHMR_SCTxt/IFTxt/IFTxtStKick.csv".standardizePath,false,false);
~flCsv.postcs;
~dfg=~flCsv.collect(_.collect(_.interpret));
~nm= ~dfg[0];
(~dfg[3])+(~dfg[4])

IFSeqVKick.st01([0,1].choose);
IFSeqVKick.st02([0,1].choose);
IFSeqVKick.st03([0,1].choose);
IFSeqVKick.st04([0,1].choose);
IFSeqVKick.st05([0,1].choose);
IFSeqVKick.st06([0,1].choose);
IFSeqVKick.st07([0,1].choose);
IFSeqVKick.st08([0,1].choose);

IFSeqVKick.st09([0,1].choose);
IFSeqVKick.st10([0,1].choose);
IFSeqVKick.st11([0,1].choose);
IFSeqVKick.st12([0,1].choose);
IFSeqVKick.st13([0,1].choose);
IFSeqVKick.st14([0,1].choose);
IFSeqVKick.st15([0,1].choose);
IFSeqVKick.st16([0,1].choose);


IFTxst.makeFile;
IFTxst.wrtLns(0,1);
~flCsv=CSVFileReader.read("~/CHMR_SCTxt/IFTxt/IFTxtStKick.csv".standardizePath,false,false);
~flCsv.postcs;
~dfg=~flCsv.collect(_.collect(_.interpret));
~nm= ~dfg[0];





~fl=File.readAllString("~/IFTxst01.csv".standardizePath,"rb");
~fl=File.read("~/IFTxst01.csv".standardizePath);
~flCsv=CSVFileReader.read("~/IFTxst01.csv".standardizePath,false,false);
~flCsv;
~flCsv.postcs;
~dfg=~flCsv.collect(_.collect(_.interpret));
~nm= ~dfg[0]
~nm[2]
~nm[2]+~nm[3]
~nm.collect(_.collect(_.interpret));
~nm1=~flCsv.at(0);
~nm2=5;
~sum = "~nm1+~nm2".compile.postln;
~sum.value
~fl=File.readAllSignal("~/IFTxst01.txt".standardizePath);
~num = "~fl[0]".interpret;
~num=~fl.asArray[2]
~fl[1].asInteger
~fl.at(2);
~fl.split($ );
~fl.asArray.split($ ).interpret
~num01=(~fl[3]);
"~num+0".asInteger;
~fl[2].asString;
~seq=Pseq(~fl.split($ ),inf).asStream;
~seq.next
~fl.value
~fl.collect(_.collect(_.interpret))
~fl.ascii

~nm= ~fl[2];
~nm.value.postln

IFSeqVKick.stGrpSet  (1,0,1,0, 1,0,1,0,  1,0,1,0, 1,0,1,0);
~seqVKick01.source = ~nm[0]

IFSeqVKick.st01(~num.value);
IFSeqVKick.st01("~fl[2]+0".asInteger;);
IFSeqVKick.st01(~fl[0].asString);

"~fl.at(2)".asInteger;
~num = "~fl.at(2)+1".compile;
~num.value
IFSeqVKick.st01(~fl[0]);
IFSeqVKick.st02(~fl[1]);
IFSeqVKick.st03(~fl[2]);
IFSeqVKick.st04(~fl[3]);
IFSeqVKick.st05(~fl[4]);
IFSeqVKick.st06(~fl[5]);
IFSeqVKick.st07(~fl[6]);
IFSeqVKick.st08(~fl[7]);

IFSeqVKick.stGrpSet(
~fl[0].asInteger,
~fl[1].asStream,
~fl[2].asStream,
~fl[3].asStream,
~fl[4].asStream,
~fl[5].asStream,
~fl[6].asStream,
~fl[7].asStream,
~fl[8].asStream,
~fl[9].asStream,
~fl[10].asStream,
~fl[11].asStream,
~fl[12].asStream,
~fl[13].asStream,
~fl[14].asStream,
~fl[15].asStream
);
IFSeqVKick.stGrpSet  (1,0,1,0, 1,0,1,0,  1,0,1,0, 1,0,1,0);

IFSeqVKick.st01(~fl[0].asString);
IFSeqVKick.st02(~fl[1]);
IFSeqVKick.st03(~fl[2]);
IFSeqVKick.st04(~fl[3]);
IFSeqVKick.st05(~fl[4]);
IFSeqVKick.st06(~fl[5]);
IFSeqVKick.st07(~fl[6]);
IFSeqVKick.st08(~fl[7]);

postf("this % a %. pi = %, list = %\n", "is", "test", pi.round(1e-4), (1..4))

this is a test. pi = 3.1416, list = [ 1, 2, 3, 4 ]


List[~fl].do({ arg item, i; item.postln });
List[2, 1, 4, 3].asSortedList;

String.readNew(~fl)

f.collect(_.collect(_.interpret))
Post<<"~/IFTxst01.txt".pathMatch

IFTxst.loadPath;
IFTxst.writeArr(1,16);

IFTxst.readFile;

IFTxst.writeSer(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);
IFTxst.writeFile(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);

IFTxst.writeSer();


File.getcwd;

~seq=Pseq([~vl01,2,\vl03],inf).asStream;
format("here I will send message % with args %", message, args).postln;

~readFile= FileReader.readInterpret("~/IFTxst01.txt").postcs;
File.readAllString("~/IFTxst01.txt".standardizedPath);

f.postcs
File.getcwd;


~br="1";
~zr="3+~br".compile.asInteger
~zr.value

*/

/*
*writeArr{|minVal,maxVal|
File.use(
pathStKick.standardizePath,"w",
{ |txt2|
(minVal..maxVal).do { |n| txt2.write(n.asString ++ ","); };
});

}
*writeArrDo{|tms,val|
File.use(
pathStKick.standardizePath,"w",
{ |txt2|
tms.do {
txt2.write(val.asString ++ ",");
val=val+1;
};
});
}
*writeSer{|vl01,vl02,vl03,vl04,vl05,vl06,vl07,vl08,vl09,vl10,vl11,vl12,vl13,vl14,vl15,vl16|
File.use(
pathStKick.standardizePath,
"w",
{ |txt3|
txt3.write(
vl01,vl02,vl03,vl04,vl05,vl06,vl07,vl08,vl09,vl10,vl11,vl12,vl13,vl14,vl15,vl16
);
}
);
}
*writeDo{|min,max|
File.use(
pathStKick.standardizePath,"w+",
{ |txt4|
16.do{txt4.write([min,max].choose.asString ++ " ")};
}
);
}
*write{|min,max|
File.use(
pathStKick.standardizePath,"w+",
{ |txt4|
15.do{txt4.write([min,max].choose.asString ++ ", ")};
//2.0.wait;
1.do{txt4.write([min,max].choose.asString)};
}
);
}
*wrt{|min,max|
File.use(
pathStKick.standardizePath,"wb+",
{ |txt4|
16.do{txt4.write([min,max].choose.asString)};
}
);
}
*wrtC{|min,max|
File.use(
pathStKick.standardizePath,"wb",
{ |txt4|
16.do{txt4.write([min,max].choose.asString++ ",")};
}
);
}
*wrtLns{|min,max|
File.use(
pathStKick.standardizePath,"wb",
{ |txt4,cnt=0|
32.do{
txt4.write([min,max].choose.asString ++ if (cnt=16,{Char.nl},{","}););
cnt+1;

}
};
);

*paths{
~txtPathLst=[
"~/Library/Application Support/SuperCollider/Extensions/omerCho/CHMR_IFTxt_Patterns/IFTracks/IFTxtStbl.txt",
"~/Library/Application Support/SuperCollider/Extensions/omerCho/CHMR_IFTxt_Patterns/IFTracks/IFTxtKick.txt",
"~/Library/Application Support/SuperCollider/Extensions/omerCho/CHMR_IFTxt_Patterns/IFTracks/IFTxtSnr.txt",
"~/Library/Application Support/SuperCollider/Extensions/omerCho/CHMR_IFTxt_Patterns/IFTracks/IFTxtHat.txt",
"~/Library/Application Support/SuperCollider/Extensions/omerCho/CHMR_IFTxt_Patterns/IFTracks/IFTxtBass.txt",
"~/Library/Application Support/SuperCollider/Extensions/omerCho/CHMR_IFTxt_Patterns/IFTracks/IFTxtKeys.txt",
"~/Library/Application Support/SuperCollider/Extensions/omerCho/CHMR_IFTxt_Patterns/IFTracks/IFTxtSamp.txt",
"~/Library/Application Support/SuperCollider/Extensions/omerCho/CHMR_IFTxt_Patterns/IFTracks/IFTxtMopho.txt"
];
}
*/