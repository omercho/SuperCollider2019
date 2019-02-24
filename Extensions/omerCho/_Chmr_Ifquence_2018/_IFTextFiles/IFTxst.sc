/*
~txtPathLst[1]

IFTxst.makePath(\test2)
IFTxst.makeFile(\test2)

IFTxst.readFile
IFTxst.readFile(1)
IFTxst.get

~ln1=IFTxst()
~ln1.value

~ln1=IFTxst(\test2,1)
~ln2=IFTxst(\test2,1)
~ln3=IFTxst(\test2,1)
~ln4=IFTxst(\test2,1)
IFTxst(4)

IFTxst.set(\test2,1);

*/

IFTxst{
	classvar <>path, <>name, >lineOut,<>rdFile;
	*initClass {
		StartUp add: {
			//Server.default.doWhenBooted({this.paths; });
		}
	}
	*makePath{|fileName|
		^path="~/Library/Application Support/SuperCollider/Extensions/omerCho/CHMR_IFTxt_Patterns/IFTracks/"++fileName++".txt"
	}

	*makeFile{|fileName,file|
		var cnt=1, min=0,max=1;
		fork{
			this.makePath(fileName);
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
				//0.01.wait;
			};
			0.02.wait;
			file.close;
		}
	}

	//READ
	*readFile{|line|
		//var rdFile;
		fork{
			rdFile = CSVFileReader.readInterpret(path.standardizePath, true, true);
			0.02.wait;
			line.switch(line,{lineOut=rdFile[line-1];})
		};

	}
	*new{|i|
		i.switch(i,{lineOut=rdFile[i-1];});
		^lineOut;
	}
	*set{|nm,ln|
		fork{
			this.makeFile(nm);
			0.1.wait;
			this.readFile(ln);
			0.1.wait;

		}
		//^lineOut;
	}
}

/*
IFTxst.makeFile;
IFTxst.wrt(0,1);
IFTxst.wrtC(0,1);
IFTxst.write(0,1);
IFTxst.writeDo(0,1);
IFTxst.writeArrDo(16,2);
IFTxst.readFile;

//OKKKKK
IFTxst.makeFile;
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