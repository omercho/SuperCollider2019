/*
IFTxt.make(\00,\00, \ifKick,1);
IFTxt.make(\00,\ifSnr,11);
IFTxt.make(\00,\ifHat,11);
IFTxt.make(\00,\ifBass,6);
IFTxt.make(\00,\ifKeys,6);
IFTxt.make(\00,\ifSamp,6);
IFTxt.make(\00,\ifMopho,6);

IFTxt.trckDflt;

IFTxt.readIfTrack(\00,\ifKick);
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

IFTxt.readIfTrack(\00,\ifSnr);
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

IFTxt.readIfTrack(\00,\ifHat);
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

IFTxt.readIfTrack(\00,\ifBass);
~tBsAmp=IFTxt.line(1);
~tBsNt=IFTxt.line(2);
~tBsVel=IFTxt.line(3);
~tBsSus=IFTxt.line(4);
~tBsTm=IFTxt.line(5);
~tBsDur=IFTxt.line(6);

IFTxt.readIfTrack(\00,\ifKeys);
~tKyAmp=IFTxt.line(1);
~tKyNt=IFTxt.line(2);
~tKyVel=IFTxt.line(3);
~tKySus=IFTxt.line(4);
~tKyTm=IFTxt.line(5);
~tKyDur=IFTxt.line(6);

IFTxt.readIfTrack(\00,\ifSamp);
~tSmAmp=IFTxt.line(1);
~tSmNt=IFTxt.line(2);
~tSmVel=IFTxt.line(3);
~tSmSus=IFTxt.line(4);
~tSmTm=IFTxt.line(5);
~tSmDur=IFTxt.line(6);

IFTxt.readIfTrack(\00,\ifMopho);
~tMpAmp=IFTxt.line(1);
~tMpNt=IFTxt.line(2);
~tMpVel=IFTxt.line(3);
~tMpSus=IFTxt.line(4);
~tMpTm=IFTxt.line(5);
~tMpDur=IFTxt.line(6);

IFTxt.ifPath(\00,\00,\ifKick);

*/

IFTxt{
	classvar <>file, <>path, <>trckPath,<>ifTrckPath, <>lineOut,<>rdFile;
	*initClass {
		StartUp add: {
			//Server.default.doWhenBooted({this.paths; });
		}
	}

	*ifPath{|trck,prt,inst|
		^ifTrckPath="~/Library/Application Support/SuperCollider/Extensions/omerCho/_Chmr_Ifquence_2018/_IFTrackPatterns/"++trck++"/"++prt++"/"++inst++".txt"
	}
	*readIfTrack{|trck,prt,inst|
		this.ifPath(trck,prt,inst);
		rdFile = CSVFileReader.readInterpret(ifTrckPath.standardizePath, true, true);
	}
	*line{|i|
		i.switch(i,{lineOut=rdFile[i-1];});
		^lineOut;
	}
	*readInst{|trck,prt|
		IFTxt.readIfTrack(trck,prt,\ifStat);
		~tStKc=IFTxt.line(1);
		~tStKcN=IFTxt.line(2);
		~tStSn=IFTxt.line(3);
		~tStSnN=IFTxt.line(4);
		~tStHt=IFTxt.line(5);
		~tStHtN=IFTxt.line(6);
		~tStClp=IFTxt.line(7);
		~tStClpN=IFTxt.line(8);
		~tStTom1=IFTxt.line(9);
		~tStTom1N=IFTxt.line(10);
		~tStTom2=IFTxt.line(11);
		~tStTom2N=IFTxt.line(12);

		IFTxt.readIfTrack(trck,prt,\ifKick);
		~tKcAmp=IFTxt.line(1);
		~tKcOct=IFTxt.line(2);
		~tKcNt=IFTxt.line(3);
		~tKcVel=IFTxt.line(4);
		~tKcSus=IFTxt.line(5);
		~tKcTm=IFTxt.line(6);
		~tKcDur=IFTxt.line(7);
		~tKcShuf=IFTxt.line(8);
		~tKcGlob=IFTxt.line(9);

		IFTxt.readIfTrack(trck,prt,\ifSnr);
		~tSnAmp=IFTxt.line(1);
		~tSnOct=IFTxt.line(2);
		~tSnNt=IFTxt.line(3);
		~tSnVel=IFTxt.line(4);
		~tSnSus=IFTxt.line(5);
		~tSnTm=IFTxt.line(6);
		~tSnDur=IFTxt.line(7);
		~tSnShuf=IFTxt.line(8);
		~tSnGlob=IFTxt.line(9);

		IFTxt.readIfTrack(trck,prt,\ifHat);
		~tHtAmp=IFTxt.line(1);
		~tHtOct=IFTxt.line(2);
		~tHtNt=IFTxt.line(3);
		~tHtVel=IFTxt.line(4);
		~tHtSus=IFTxt.line(5);
		~tHtTm=IFTxt.line(6);
		~tHtDur=IFTxt.line(7);
		~tHtShuf=IFTxt.line(8);
		~tHtGlob=IFTxt.line(9);

		IFTxt.readIfTrack(trck,prt,\ifBass);
		~tBsAmp=IFTxt.line(1);
		~tBsOct=IFTxt.line(2);
		~tBsNt=IFTxt.line(3);
		~tBsVel=IFTxt.line(4);
		~tBsSus=IFTxt.line(5);
		~tBsTm=IFTxt.line(6);
		~tBsDur=IFTxt.line(7);
		~tBsShuf=IFTxt.line(8);
		~tBsLfo=IFTxt.line(9);
		~tBsEnv=IFTxt.line(10);

		IFTxt.readIfTrack(trck,prt,\ifKeys);
		~tKyAmp=IFTxt.line(1);
		~tKyOct=IFTxt.line(2);
		~tKyNt=IFTxt.line(3);
		~tKyVel=IFTxt.line(4);
		~tKySus=IFTxt.line(5);
		~tKyTm=IFTxt.line(6);
		~tKyDur=IFTxt.line(7);
		~tKyShuf=IFTxt.line(8);
		~tKyLfo=IFTxt.line(9);
		~tKyEnv=IFTxt.line(10);

		IFTxt.readIfTrack(trck,prt,\ifMopho);
		~tMpAmp=IFTxt.line(1);
		~tMpOct=IFTxt.line(2);
		~tMpNt=IFTxt.line(3);
		~tMpVel=IFTxt.line(4);
		~tMpSus=IFTxt.line(5);
		~tMpTm=IFTxt.line(6);
		~tMpDur=IFTxt.line(7);
		~tMpShuf=IFTxt.line(8);
		~tMpLfo=IFTxt.line(9);
		~tMpEnv=IFTxt.line(10);

		IFTxt.readIfTrack(trck,prt,\ifSamp);
		~tSmAmp=IFTxt.line(1);
		~tSmOct=IFTxt.line(2);
		~tSmNt=IFTxt.line(3);
		~tSmVel=IFTxt.line(4);
		~tSmSus=IFTxt.line(5);
		~tSmTm=IFTxt.line(6);
		~tSmDur=IFTxt.line(7);
		~tSmShuf=IFTxt.line(8);
		~tSmLfo=IFTxt.line(9);
		~tSmEnv=IFTxt.line(10);
	}

	*writeRndSttDrmLines{|trck,prt,inst|
		var cnt=1, min=0,max=1, seq;
		var amp1,nt1,amp2,nt2,amp3,nt3,amp4,nt4,amp5,nt5,amp6,nt6;
		amp1=Pseq([1,0],inf).asStream;
		nt1=Pseq([0],inf).asStream;
		amp2=Pseq([0,0,1,0],inf).asStream;
		nt2=Prand((20..20),inf).asStream;
		amp3=Pseq([0,1,0,1],inf).asStream;
		nt3=Prand((125..125),inf).asStream;
		amp4=Pseq([0,0,0,1],inf).asStream;
		nt4=Prand((30..39),inf).asStream;
		amp5=Prand([0,0,0,1],inf).asStream;
		nt5=Prand((0..19),inf).asStream;
		amp6=Prand([0,0,0,1],inf).asStream;
		nt6=Prand((20..39),inf).asStream;
		fork{
			this.ifPath(trck,prt,inst);
			file=File.new(ifTrckPath.standardizePath,"w");
			0.02.wait;
			(1..192).do{|n|
				case
				{cnt>0&&cnt<=16}{seq=amp1.next}//ampVkick
				{cnt>16&&cnt<=32}{seq=nt1.next}//ntVkick

				{cnt>32&&cnt<=48}{seq=amp2.next}//ampVSnr
				{cnt>48&&cnt<=64}{seq=nt2.next}//ntVSnr

				{cnt>64&&cnt<=80}{seq=amp3.next}//ampVHat
				{cnt>80&&cnt<=96}{seq=nt3.next}//ntVHat

				{cnt>96&&cnt<=112}{seq=amp4.next}//ampVClap
				{cnt>112&&cnt<=128}{seq=nt4.next}//ntVClap

				{cnt>128&&cnt<=144}{seq=amp5.next}//ampVTomL
				{cnt>144&&cnt<=160}{seq=nt5.next}//ntVTomL

				{cnt>160&&cnt<=176}{seq=amp6.next}//ampVTomH
				{cnt>176&&cnt<=192}{seq=nt6.next};//ntVTomH
				file.write(
					seq.asString ++ if (n % 16 != 0, ",", Char.nl)
				);
				cnt=cnt+1;
			};
			0.02.wait;
			file.close;
		}
	}
	/**writeRndDrmLines{|trck,prt,inst|
		var cnt=1, min=0,max=1;
		fork{
			this.ifPath(trck,prt,inst);
			file=File.new(ifTrckPath.standardizePath,"w");
			0.02.wait;
			(1..144).do{|n|
				case
				{cnt>0&&cnt<=16}{min=(0);max=(1);}//amp
				{cnt>16&&cnt<=32}{min=(0);max=(4);}//oct
				{cnt>32&&cnt<=48}{min=(0);max=(7);}//nt
				{cnt>48&&cnt<=64}{min=(1);max=(3);}//vel
				{cnt>64&&cnt<=80}{min=(1);max=(5);}//sus
				{cnt>80&&cnt<=96}{min=(1);max=(1);}//tm
				{cnt>96&&cnt<=112}{min=(4);max=(4);}//dur
				{cnt>112&&cnt<=128}{min=(-2);max=(4);}//Shuf
				{cnt==129}{min=(0.8);max=(0.99);}//Vol
				{cnt==130}{min=(0);max=(2);}//OctMul
				{cnt>130&&cnt<=144}{min=(0);max=(127);};//globMul -- susMul-lfo2
				file.write(
					(min..max).choose.asString ++ if (n % 16 != 0, ",", Char.nl)
				);
				cnt=cnt+1;
			};
			0.02.wait;
			file.close;
		}
	}*/
	*writeRndDrmLines{|trck,prt,inst|
		var cnt=1, min=0,max=1,seq;
		var amp,oct,nt,vel,susT,tm,dur,shuf;
		var vol,octM,susM,dec,dly,pan,sndA,sndB;
		amp=  Pwhite(0,   1,   inf).asStream;
		oct=  Pwhite(0,   3,   inf).asStream;
		nt=   Pwhite(0,   7,   inf).asStream;
		vel=  Pwhite(1,   3,   inf).asStream;
		susT= Pwhite(1,   5,   inf).asStream;
		tm=   Pwhite(1,   2,   inf).asStream;
		dur=  Pwhite(2,   4,   inf).asStream;
		shuf= Pwhite(0,   14,   inf).asStream;
		vol=  Pwhite(0.8, 0.99,inf).asStream;
		octM= Pwhite(0,   5, inf).asStream;
		susM= Pwhite(0.1, 0.9, inf).asStream;
		dec=  Pwhite(0.2, 1.0, inf).asStream;
		dly=  Pwhite(0.1, 0.9, inf).asStream;
		pan=  Pwhite(0.1, 0.9, inf).asStream;
		sndA= Pwhite(0.1, 0.9, inf).asStream;
		sndB= Pwhite(0.1, 0.9, inf).asStream;
		fork{
			this.ifPath(trck,prt,inst);
			file=File.new(ifTrckPath.standardizePath,"w");
			0.02.wait;
			(1..136).do{|n|
				case
				{cnt>0&&cnt<=16}   {seq=amp.next}//amp
				{cnt>16&&cnt<=32}  {seq=oct.next}//oct
				{cnt>32&&cnt<=48}  {seq=nt.next}//nt
				{cnt>48&&cnt<=64}  {seq=vel.next}//vel
				{cnt>64&&cnt<=80}  {seq=susT.next}//susT
				{cnt>80&&cnt<=96}  {seq=tm.next}//tm
				{cnt>96&&cnt<=112} {seq=dur.next}//dur
				{cnt>112&&cnt<=128}{seq=shuf.next}//Shuf
				{cnt==129}     {seq=vol.next}//Vol
				{cnt==130}     {seq=octM.next}//OctMul
				{cnt==131}     {seq=susM.next}//SusMul
				{cnt==132}     {seq=dec.next}//dec
				{cnt==133}     {seq=dly.next}//rls
				{cnt==134}     {seq=pan.next}//pan
				{cnt==135}     {seq=sndA.next}//sndX
				{cnt==136}     {seq=sndB.next};//sndY
				file.write(
					seq.asString ++ if (n % 16 != 0, ",", Char.nl)
				);
				cnt=cnt+1;
			};
			0.02.wait;
			file.close;
		}
	}
	*writeRndBassLines{|trck,prt,inst|
		var cnt=1, min=0,max=1,seq;
		var amp,oct,nt,vel,susT,tm,dur,shuf,lfoP;
		var vol,att,dec,susV,rls,pan,sndA,sndB;
		var octM,susM,xy1X,xy1Y,xy2X,xy2Y,lfoM1,lfoM2;
		amp=  Pwhite(0,   1,   inf).asStream;
		oct=  Pwhite(2,   3,   inf).asStream;
		nt=   Pwhite(0,   7,   inf).asStream;
		vel=  Pwhite(1,   3,   inf).asStream;
		susT= Pwhite(1,   5,   inf).asStream;
		tm=   Pwhite(1,   1,   inf).asStream;
		dur=  Pwhite(4,   4,   inf).asStream;
		shuf= Pwhite(-2,  4,   inf).asStream;
		lfoP= Pwhite(0,   127, inf).asStream;
		vol=  Pwhite(0.8, 0.99,inf).asStream;
		att=  Pwhite(0.0, 0.5, inf).asStream;
		dec=  Pwhite(0.2, 1.0, inf).asStream;
		susV= Pwhite(0.1, 0.8, inf).asStream;
		rls=  Pwhite(0.1, 0.9, inf).asStream;
		pan=  Pwhite(0.1, 0.9, inf).asStream;
		sndA= Pwhite(0.1, 0.9, inf).asStream;
		sndB= Pwhite(0.1, 0.9, inf).asStream;
		octM= Pwhite(-1,   1, inf).asStream;
		susM= Pwhite(0.1, 0.9, inf).asStream;
		xy1X= Pwhite(0.0, 0.9, inf).asStream;
		xy1Y= Pwhite(0.0, 0.9, inf).asStream;
		xy2X= Pwhite(0.0, 0.9, inf).asStream;
		xy2Y= Pwhite(0.0, 0.9, inf).asStream;
		lfoM1=Pwhite(0.0, 1.0, inf).asStream;
		lfoM2=Pwhite(0.0, 1.0, inf).asStream;
		fork{
			this.ifPath(trck,prt,inst);
			file=File.new(ifTrckPath.standardizePath,"w");
			0.02.wait;
			(1..160).do{|n|
				case
				{cnt>0&&cnt<=16}   {seq=amp.next}//amp
				{cnt>16&&cnt<=32}  {seq=oct.next}//oct
				{cnt>32&&cnt<=48}  {seq=nt.next}//nt
				{cnt>48&&cnt<=64}  {seq=vel.next}//vel
				{cnt>64&&cnt<=80}  {seq=susT.next}//susT
				{cnt>80&&cnt<=96}  {seq=tm.next}//tm
				{cnt>96&&cnt<=112} {seq=dur.next}//dur
				{cnt>112&&cnt<=128}{seq=shuf.next}//Shuf
				{cnt>128&&cnt<=144}{seq=lfoP.next}//lfo
				{cnt==145}     {seq=vol.next}//Vol
				{cnt==146}     {seq=att.next}//Att
				{cnt==147}     {seq=dec.next}//dec
				{cnt==148}     {seq=susV.next}//sus
				{cnt==149}     {seq=rls.next}//rls
				{cnt==150}     {seq=pan.next}//pan
				{cnt==151}     {seq=sndA.next}//sndX
				{cnt==152}     {seq=sndB.next}//sndY
				{cnt==153}   {seq=octM.next}//OctMul
				{cnt==154}   {seq=susM.next}//SusMul
				{cnt==155}   {seq=xy1X.next}//xy1X
				{cnt==156}   {seq=xy1Y.next}//xy1Y
				{cnt==157}   {seq=xy2X.next}//xy2X
				{cnt==158}   {seq=xy1Y.next}//xy2Y
				{cnt==159}   {seq=lfoM1.next}//lfoMul1
				{cnt==160}   {seq=lfoM2.next};//lfoMul2
				file.write(
					seq.asString ++ if (n % 16 != 0, ",", Char.nl)
				);
				cnt=cnt+1;
			};
			0.02.wait;
			file.close;
		}
	}
	/*
	(0.1..0.9).asFloat.choose
	~aatt=Pwhite(0.0, 1.0, inf).asStream;
	127*~aatt.next
	~sshuf= Pwhite(-2,  4,   inf).asStream;
	~sshuf.next
	*/
	*writeRndMelLines{|trck,prt,inst|
		var cnt=1, min=0,max=1,seq;
		var amp,oct,nt,vel,susT,tm,dur,shuf,lfoP;
		var vol,att,dec,susV,rls,pan,sndA,sndB;
		var octM,susM,xy1X,xy1Y,xy2X,xy2Y,lfoM1,lfoM2;
		amp=  Pwhite(0,   1,   inf).asStream;
		oct=  Pwhite(2,   4,   inf).asStream;
		nt=   Pwhite(-4,   7,   inf).asStream;
		vel=  Pwhite(1,   3,   inf).asStream;
		susT= Pwhite(1,   5,   inf).asStream;
		tm=   Pwhite(1,   1,   inf).asStream;
		dur=  Pwhite(4,   4,   inf).asStream;
		shuf= Pwhite(-2,  4,   inf).asStream;
		lfoP= Pwhite(0,   127, inf).asStream;
		vol=  Pwhite(0.8, 0.99,inf).asStream;
		att=  Pwhite(0.0, 0.5, inf).asStream;
		dec=  Pwhite(0.2, 1.0, inf).asStream;
		susV= Pwhite(0.1, 0.8, inf).asStream;
		rls=  Pwhite(0.1, 0.9, inf).asStream;
		pan=  Pwhite(0.1, 0.9, inf).asStream;
		sndA= Pwhite(0.1, 0.9, inf).asStream;
		sndB= Pwhite(0.1, 0.9, inf).asStream;
		octM= Pwhite(-1,   2, inf).asStream;
		susM= Pwhite(0.1, 0.9, inf).asStream;
		xy1X= Pwhite(0.0, 0.9, inf).asStream;
		xy1Y= Pwhite(0.0, 0.9, inf).asStream;
		xy2X= Pwhite(0.0, 0.9, inf).asStream;
		xy2Y= Pwhite(0.0, 0.9, inf).asStream;
		lfoM1=Pwhite(0.0, 1.0, inf).asStream;
		lfoM2=Pwhite(0.0, 1.0, inf).asStream;
		fork{
			this.ifPath(trck,prt,inst);
			file=File.new(ifTrckPath.standardizePath,"w");
			0.02.wait;
			(1..160).do{|n|
				case
				{cnt>0&&cnt<=16}   {seq=amp.next}//amp
				{cnt>16&&cnt<=32}  {seq=oct.next}//oct
				{cnt>32&&cnt<=48}  {seq=nt.next}//nt
				{cnt>48&&cnt<=64}  {seq=vel.next}//vel
				{cnt>64&&cnt<=80}  {seq=susT.next}//susT
				{cnt>80&&cnt<=96}  {seq=tm.next}//tm
				{cnt>96&&cnt<=112} {seq=dur.next}//dur
				{cnt>112&&cnt<=128}{seq=shuf.next}//Shuf
				{cnt>128&&cnt<=144}{seq=lfoP.next}//lfo
				{cnt==145}     {seq=vol.next}//Vol
				{cnt==146}     {seq=att.next}//Att
				{cnt==147}     {seq=dec.next}//dec
				{cnt==148}     {seq=susV.next}//sus
				{cnt==149}     {seq=rls.next}//rls
				{cnt==150}     {seq=pan.next}//pan
				{cnt==151}     {seq=sndA.next}//sndX
				{cnt==152}     {seq=sndB.next}//sndY
				{cnt==153}   {seq=octM.next}//OctMul
				{cnt==154}   {seq=susM.next}//SusMul
				{cnt==155}   {seq=xy1X.next}//xy1X
				{cnt==156}   {seq=xy1Y.next}//xy1Y
				{cnt==157}   {seq=xy2X.next}//xy2X
				{cnt==158}   {seq=xy1Y.next}//xy2Y
				{cnt==159}   {seq=lfoM1.next}//lfoMul1
				{cnt==160}   {seq=lfoM2.next};//lfoMul2
				file.write(
					seq.asString ++ if (n % 16 != 0, ",", Char.nl)
				);
				cnt=cnt+1;
			};
			0.02.wait;
			file.close;
		}
	}
	/**writeRndMelLines{|trck,prt,inst|
		var cnt=1, min=0,max=1;
		fork{
			this.ifPath(trck,prt,inst);
			file=File.new(ifTrckPath.standardizePath,"w");
			0.02.wait;
			(1..176).do{|n|
				case
				{cnt>0&&cnt<=16}{min=(0);max=(1);}//amp
				{cnt>16&&cnt<=32}{min=(3);max=(4);}//oct
				{cnt>32&&cnt<=48}{min=(-4);max=(7);}//nt
				{cnt>48&&cnt<=64}{min=(1);max=(3);}//vel
				{cnt>64&&cnt<=80}{min=(1);max=(5);}//sus
				{cnt>80&&cnt<=96}{min=(1);max=(1);}//tm
				{cnt>96&&cnt<=112}{min=(4);max=(4);}//dur
				{cnt>112&&cnt<=128}{min=(-2);max=(4);}//Shuf
				{cnt>128&&cnt<=144}{min=(0);max=(127);}//lfo
				{cnt==145}{min=(0.8);max=(0.99);}//Vol
				{cnt==146}{min=(0.01);max=(0.5);}//Att
				{cnt>146&&cnt<=160}{min=(0.02);max=(0.7);}//globEnv -- dec-sus-rls-pan-sndY
				{cnt==161}{min=(0);max=(2);}//OctMul
				{cnt==162}{min=(0.1);max=(1.0);}//SusMul
				{cnt>162&&cnt<=176}{min=(0.0);max=(0.9);};//globMul -- xy1-xy2-lfo2
				file.write(
					(min..max).choose.asString ++ if (n % 16 != 0, ",", Char.nl)
				);
				cnt=cnt+1;
			};
			0.02.wait;
			file.close;
		}
	}*/
	*make{|trck,prt,inst,lines|
		lines.switch(
			'rndSttDrmTag',{
				fork{
					this.writeRndSttDrmLines(trck,prt,inst);
					0.1.wait;
					this.readIfTrack(trck,prt,inst);
					0.1.wait;
				};
			},
			'rndDrmTag',{
				fork{
					this.writeRndDrmLines(trck,prt,inst);
					0.1.wait;
					this.readIfTrack(trck,prt,inst);
					0.1.wait;
				};
			},
			'rndBassTag', {
				fork{
					this.writeRndBassLines(trck,prt,inst);
					0.1.wait;
					this.readIfTrack(trck,prt,inst);
					0.1.wait;
				};
			},
			'rndMelTag', {
				fork{
					this.writeRndMelLines(trck,prt,inst);
					0.1.wait;
					this.readIfTrack(trck,prt,inst);
					0.1.wait;
				};
			};
		)
	}
	*trckDflt{
		fork{
			IFTxt.make(\00,\00,\ifStat,'rndSttDrmTag');
			0.1.wait;
			IFTxt.make(\00,\00,\ifKick,'rndDrmTag');
			0.1.wait;
			IFTxt.make(\00,\00,\ifSnr,'rndDrmTag');
			0.1.wait;
			IFTxt.make(\00,\00,\ifHat,'rndDrmTag');
			0.1.wait;
			IFTxt.make(\00,\00,\ifBass,'rndBassTag');
			0.1.wait;
			IFTxt.make(\00,\00,\ifKeys,'rndMelTag');
			0.1.wait;
			IFTxt.make(\00,\00,\ifSamp,'rndMelTag');
			0.1.wait;
			IFTxt.make(\00,\00,\ifMopho,'rndMelTag');


		}
	}

}

/*

IFTxt.trckDflt;


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
IFTxst.readIfTrack;

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

IFTxst.readIfTrack;

IFTxst.writeSer(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);
IFTxst.writeFile(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);

IFTxst.writeSer();


File.getcwd;

~seq=Pseq([~vl01,2,\vl03],inf).asStream;
format("here I will send message % with args %", message, args).postln;

~readIfTrack= FileReader.readInterpret("~/IFTxst01.txt").postcs;
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