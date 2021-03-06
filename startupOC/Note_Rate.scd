/*
This table created using A4 = 440 Hz 
Speed of sound = 345 m/s = 1130 ft/s = 770 miles/hr

("Middle C" is C4 )

i = 2 ** ([1,2,3,4,5,6,7,8,9,10,11,12]/12); 


1/4*i[0]
1/4*i[1]
1/4*i[2]
1/4*i[3]
1/4*i[4]
1/4*i[5]
1/4*i[6]
1/4*i[7]
1/4*i[8]
1/4*i[9]
1/4*i[10]
1/4*i[11]

0.26486577358982

0.28061551207734

0.29730177875068

0.31498026247372

0.33370996354251

0.35355339059327

0.37457676921917

0.39685026299205

0.42044820762686

0.44544935907017

0.47193715634085

0.5
~c0
~c1
~c2
~c3
~c4
~c5
~c6
~c7
~c8
*/

currentEnvironment use: {
//Octave0
~cR0		= 1/4;
~cRS0 	= 0.26486577358982;
~dR0 	= 0.28061551207734;
~dRS0 	= 0.29730177875068;
~eR0 	= 0.31498026247372;
~fR0 	= 0.33370996354251;
~fRS0	= 0.35355339059327;
~gR0 	= 0.37457676921917;
~gRS0 	= 0.39685026299205;
~aR0 	= 0.42044820762686;
~aRS0	= 0.44544935907017;
~bR0 	= 0.47193715634085;


//Octave1
~cR1 	= ~cR0*2;
~cRS1 	= ~cRS0*2;
~dR1 	= ~dR0*2;
~dRS1 	= ~dRS0*2;
~eR1 	= ~eR0*2;
~fR1		= ~fR0*2;
~fRS1 	= ~fRS0*2;
~gR1 	= ~gR0*2;
~gRS1 	= ~gRS0*2;
~aR1 	= ~aR0*2;
~aRS1 	= ~aRS0*2;
~bR1 	= ~bR0*2;

//Octave2
~cR2 	= ~cR1*2;
~cRS2 	= ~cRS1*2;
~dR2 	= ~dR1*2;
~dRS2 	= ~dRS1*2;
~eR2 	= ~eR1*2;
~fR2		= ~fR1*2;
~fRS2 	= ~fRS1*2;
~gR2 	= ~gR1*2;
~gRS2 	= ~gRS1*2;
~aR2 	= ~aR1*2;
~aRS2 	= ~aRS1*2;
~bR2 	= ~bR1*2;

//Octave3
~cR3 	= ~cR2*2;
~cRS3 	= ~cRS2*2;
~dR3 	= ~dR2*2;
~dRS3 	= ~dRS2*2;
~eR3 	= ~eR2*2;
~fR3		= ~fR2*2;
~fRS3 	= ~fRS2*2;
~gR3 	= ~gR2*2;
~gRS3 	= ~gRS2*2;
~aR3 	= ~aR2*2;
~aRS3 	= ~aRS2*2;
~bR3 	= ~bR2*2;

//Octave4
~cR4 	= ~cR3	*2;
~cRS4 	= ~cRS3	*2;
~dR4 	= ~dR3	*2;
~dRS4 	= ~dRS3	*2;
~eR4 	= ~eR3	*2;
~fR4		= ~fR3	*2;
~fRS4 	= ~fRS3	*2;
~gR4 	= ~gR3	*2;
~gRS4 	= ~gRS3	*2;
~aR4 	= ~aR3	*2;
~aRS4 	= ~aRS3	*2;
~bR4 	= ~bR3	*2;

//Octave5
~cR5 	= ~cR4	*2;
~cRS5 	= ~cRS4	*2;
~dR5 	= ~dR4	*2;
~dRS5 	= ~dRS4	*2;
~eR5 	= ~eR4	*2;
~fR5		= ~fR4	*2;
~fRS5 	= ~fRS4	*2;
~gR5 	= ~gR4	*2;
~gRS5 	= ~gRS4	*2;
~aR5 	= ~aR4	*2;
~aRS5 	= ~aRS4	*2;
~bR5 	= ~bR4	*2;

//Octave6
~cR6 	= ~cR5	*2;
~cRS6 	= ~cRS5	*2;
~dR6 	= ~dR5	*2;
~dRS6 	= ~dRS5	*2;
~eR6 	= ~eR5	*2;
~fR6		= ~fR5	*2;
~fRS6 	= ~fRS5	*2;
~gR6 	= ~gR5	*2;
~gRS6 	= ~gRS5	*2;
~aR6 	= ~aR5	*2;
~aRS6 	= ~aRS5	*2;
~bR6 	= ~bR5	*2;

//Octave7
~cR7 	= ~cR6	*2;
~cRS7 	= ~cRS6	*2;
~dR7 	= ~dR6	*2;
~dRS7 	= ~dRS6	*2;
~eR7 	= ~eR6	*2;
~fR7		= ~fR6	*2;
~fRS7 	= ~fRS6	*2;
~gR7 	= ~gR6	*2;
~gRS7 	= ~gRS6	*2;
~aR7 	= ~aR6	*2;
~aRS7 	= ~aRS6	*2;
~bR7 	= ~bR6	*2;

//Octave8
~cR8 	= ~cR7	*2;
~cRS8 	= ~cRS7	*2;
~dR8 	= ~dR7	*2;
~dRS8 	= ~dRS7	*2;
~eR8 	= ~eR7	*2;
~fR8		= ~fR7	*2;
~fRS8 	= ~fRS7	*2;
~gR8 	= ~gR7	*2;
~gRS8 	= ~gRS7	*2;
~aR8 	= ~aR7	*2;
~aRS8 	= ~aRS7	*2;
~bR8 	= ~bR7	*2;


};



/*


C1 32.70 1050. 
C#1/Db1 34.65 996. 
D1 36.71 940. 
D#1/Eb1 38.89 887. 
E1 41.20 837. 
F1 43.65 790. 
F#1/Gb1 46.25 746. 
G1 49.00 704. 
G#1/Ab1 51.91 665. 
A1 55.00 627. 
A#1/Bb1 58.27 592. 
B1 61.74 559. 
C2 65.41 527. 
C#2/Db2 69.30 498. 
D2 73.42 470. 
D#2/Eb2 77.78 444. 
E2 82.41 419. 
F2 87.31 395. 
F#2/Gb2 92.50 373. 
G2 98.00 352. 
G#2/Ab2 103.83 332. 
A2 110.00 314. 
A#2/Bb2 116.54 296. 
B2 123.47 279. 
C3 130.81 264. 
C#3/Db3 138.59 249. 
D3 146.83 235. 
D#3/Eb3 155.56 222. 
E3 164.81 209. 
F3 174.61 198. 
F#3/Gb3 185.00 186. 
G3 196.00 176. 
G#3/Ab3 207.65 166. 
A3 220.00 157. 
A#3/Bb3 233.08 148. 
B3 246.94 140. 
C4 261.63 132. 
C#4/Db4 277.18 124. 
D4 293.66 117. 
D#4/Eb4 311.13 111. 
E4 329.63 105. 
F4 349.23 98.8 
F#4/Gb4 369.99 93.2 
G4 392.00 88.0 
G#4/Ab4 415.30 83.1 
A4 440.00 78.4 
A#4/Bb4 466.16 74.0 
B4 493.88 69.9 
C5 523.25 65.9 
C#5/Db5 554.37 62.2 
D5 587.33 58.7 
D#5/Eb5 622.25 55.4 
E5 659.26 52.3 
F5 698.46 49.4 
F#5/Gb5 739.99 46.6 
G5 783.99 44.0 
G#5/Ab5 830.61 41.5 
A5 880.00 39.2 
A#5/Bb5 932.33 37.0 
B5 987.77 34.9 
C6 1046.50 33.0 
C#6/Db6 1108.73 31.1 
D6 1174.66 29.4 
D#6/Eb6 1244.51 27.7 
E6 1318.51 26.2 
F6 1396.91 24.7 
F#6/Gb6 1479.98 23.3 
G6 1567.98 22.0 
G#6/Ab6 1661.22 20.8 
A6 1760.00 19.6 
A#6/Bb6 1864.66 18.5 
B6 1975.53 17.5 
C7 2093.00 16.5 
C#7/Db7 2217.46 15.6 
D7 2349.32 14.7 
D#7/Eb7 2489.02 13.9 
E7 2637.02 13.1 
F7 2793.83 12.3 
F#7/Gb7 2959.96 11.7 
G7 3135.96 11.0 
G#7/Ab7 3322.44 10.4 
A7 3520.00 9.8 
A#7/Bb7 3729.31 9.3 
B7 3951.07 8.7 
C8 4186.01 8.2 
C#8/Db8 4434.92 7.8 
D8 4698.64 7.3 
D#8/Eb8 4978.03 6.9

*/