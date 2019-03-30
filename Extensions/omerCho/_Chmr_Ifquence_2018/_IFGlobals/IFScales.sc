/*

*/


IFScales{
	*initClass {
		StartUp add: {
			Server.default.doWhenBooted({
			this.load;
			});
		}

	}

	*load{
		this.osc;
		this.midi;
		this.loadList;
	}
	*loadList{
		~ifSclList = [
			//5Nt
			Scale.minorPentatonic, Scale.majorPentatonic,
			Scale.ritusen,Scale.egyptian,Scale.kumoi,Scale.hirajoshi,Scale.chinese,Scale.indian,
			Scale.pelog,Scale.prometheus,Scale.scriabin,Scale.gong,Scale.shang,
			Scale.jiao,Scale.zhi,Scale.yu,
			//7Nt
			Scale.minor,Scale.major,
			Scale.harmonicMinor,Scale.harmonicMajor,Scale.melodicMinor,Scale.melodicMajor,
			Scale.ionian,Scale.dorian,Scale.phrygian,Scale.lydian,Scale.mixolydian,
			Scale.aeolian,Scale.locrian
		];
	}
	*rand{
		~scl2=~ifSclList[(0..28).choose];
	}
	*osc{

	}
	*midi{

	}

}