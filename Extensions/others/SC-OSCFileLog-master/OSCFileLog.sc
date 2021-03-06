/*
OSC message recorder and player
(c) 2013 - Marije Baalman
GPL3 license

// this class needs the FileLog quark to function


// ------ recording

// to record, create a OSCFileLog
~timelog = OSCFileLog.new( "test" ); // "test" is the base for the filename, a datetime stamp will be automatically added to the name

// send some osc data to test:
n = NetAddr.new( "localhost", NetAddr.langPort );
(
Task({ 10.do{
	n.sendMsg( "/hello", 0, 20.rand, 19.rand, "hello", 3, 4, 2.003);
	1.0.rand.max(0.01).wait;
}}).play;
);

// close the file again:
~timelog.close;


//------- playback:

// set up our target net address (here we just send to SC again
n = NetAddr.new( "localhost", NetAddr.langPort );

// we trace it to see if we get it, just to show that it works:
OSCFunc.trace( true );

// create a player
~oscplayer = OSCFileLogPlayer.new( "/home/nescivi/SuperCollider/test_130812_121049", n ); // arguments are the file/folder we previously recorded, and the target netaddress

// and play it
~oscplayer.play;

~oscplayer.pause;

~oscplayer.resume;

~oscplayer.stop;

~oscplayer.reset;

// play back faster:
~myClock = TempoClock.new( 10 );
~oscplayer.play( ~myClock );


// close the file again:
~oscplayer.close;



*/


OSCFileLog{

	var <recording;
	var <timelogfile;
	var <offset;
	var <oscRecFunc;

	*new{ |fn|
		^super.new.init( fn );
	}

	init{ |fn|
		fn = fn ? "TimeFileLog";
		this.open(fn);
	}

	open{ |fn|
        var filename = fn ++ "_"++Date.localtime.stamp++".txt";
		timelogfile = MultiFileWriter.new( filename ).zipSingle_( false ).tarBundle_( false );
		timelogfile.open;
		recording = true;
		oscRecFunc = { |msg, time| this.writeLine( time, msg[0], msg.copyToEnd( 1 ) ) };
		this.resetTime;
		thisProcess.addOSCRecvFunc( oscRecFunc );
        "recording OSC data to %\n".postf( timelogfile.pathDir );
	}

	resetTime{
		offset = Process.elapsedTime;
	}

	writeLine{ |time,tag,data|
        timelogfile.writeLine( [time - offset, tag.asCompileString ] ++ data.collect{ |it| it.asCompileString } );
	}

	close{
		recording = false;
		timelogfile.close;
		thisProcess.removeOSCRecvFunc( oscRecFunc );
	}
}

// reads an oscfilelog and plays it

OSCFileLogPlayer{
	var <reader;
	var playTask;

//	var <timeMap;
	var <curTime=0;
//	var <deltaT=0;

	var <fileClass;
	// var <hasStamp = false;
	// var <hasExtraTab = false;

	var <targetaddr;

	*new{ |fn,addr|
		^super.new.init( fn, addr );
	}

	init{ |fn,addr|
		targetaddr = addr;
		this.checkFileClass( fn );
		this.open( fn );
	}

	checkFileClass{ |fn|
		var tar,txt;
		var path = PathName(fn);
		tar = (path.extension == "tar");
		txt = (path.extension == "txt");
		if ( tar ){
			fileClass = MultiFilePlayer;
		}{
			if ( txt ){
				fileClass = TabFilePlayer;
			}{
				fileClass = MultiFilePlayer;
			}
		};
		//		[tar, txt, fileClass].postln;
	}

	open{ |fn|
		if ( playTask.notNil ){ playTask.stop; };
		if ( reader.notNil ){ reader.close; };

		reader = fileClass.new( fn );

	//	this.readHeader;

		playTask = Task{
			var dt = 0;
			while( { dt.notNil }, {
				dt = this.readLine;
				if ( dt.notNil ){
					dt.wait;
				}
			});
		};
	}

	readLine{ |update=true|
		var dt,line,data;
		var oldid;
		var oldTime = curTime;
		oldid = reader.curid;
		line = reader.nextInterpret;
		//	line.postcs;
		// header may have changed:
	//	if ( oldid != reader.curid ){
	//		this.readHeader;
	//	};
		if ( line.isNil ){
			"At end of data".postln;
			^nil;
		};
		curTime = line.first;
		if ( update ){
			targetaddr.sendMsg( *line.copyToEnd( 1 ) );
		};
		dt = curTime - oldTime;
		^dt;
	}


	play{ |clock|
		playTask.start( clock );
	}

	pause{
		playTask.pause;
	}

	resume{
		playTask.resume;
	}

	stop{
		playTask.stop;
		this.reset;
	}

	reset{
		curTime = 0;
		reader.reset;
//		this.readHeader;
		playTask.reset;
	}

	close{
		playTask.stop;
		reader.close;
	}

		/*
	goToTime{ |newtime|
		var line,oldid;
		if ( deltaT == 0 ){
			deltaT = this.readLine;
		};
		line = floor( newtime / deltaT );
		curTime = line * deltaT;
		// assuming dt is constant.

		if ( fileClass == MultiFilePlayer ){
			oldid = reader.curid;
			reader.goToLine( line.asInteger );
			// header may have changed:
			if ( oldid != reader.curid ){
				this.readHeader;
			};
		}{
			reader.goToLine( line.asInteger );
		};
	}
*/

/*
	readHeader{
		var spec,playset,playids;
		var playslots;
		var header;

		playnodes = Dictionary.new;

		header = reader.readHeader(hs:2);
		spec = header[0].last;
		if ( spec.notNil, {
			network.setSpec( spec );
			// if spec was not local, it may be included in the tar-ball
			if ( network.spec.isNil ){
				reader.extractFromTar( spec ++ ".spec" );
				network.spec.fromFileName( reader.pathDir +/+ spec );
			};
		});

		playslots = header[1].drop(1).collect{ |it| it.interpret };

		if ( fileClass == TabFilePlayer ){
			// backwards compatibility (there was an extra tab written at the end)
			playslots = playslots.drop(-1);
			hasExtraTab = true;
		};

		if ( playslots.first == "time" ){
			// date stamps in the first column:
			playslots.drop(1);
			hasStamp = true;
		};

		playset = Set.new;
		playids = playslots.collect{ |it| it.first }.do{
			|it,i| playset.add( it );
		};
		playset.do{ |it|
			network.addExpected( it );
			playnodes.put( it, Array.new )
		};
		playids.do{ |it,i|
			playnodes.put( it, playnodes[it].add( i ) )
		};
	}
*/
}