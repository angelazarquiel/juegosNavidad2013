import java.awt.Point;

import graphics2.Canvas;
import graphics2.Color;
import graphics2.Line;
import graphics2.Rectangle;
import graphics2.Text;



public class Tablero {
	public int[][] defcasillas={
			
			{15,644},{150,644},{150,739},{15,739},//0 inicio
			{166,644},{240,641},{231,739},{159,739},//1
			{254,638},{307,639},{309,742},{254,742},//2
			{318,639},{371,641},{372,742},{319,742},//3
			{380,638},{433,638},{434,741},{383,739},//4
			{444,636},{495,638},{498,741},{443,740},//5
			{504,636},{552,640},{560,740},{507,738},//6
			{560,636},{605,636},{622,739},{570,740},//7
			{611,634},{631,639},{716,720},{625,741},//8
			{632,623},{641,609},{742,629},{723,717},//9
			{639,601},{640,555},{740,568},{742,625},//10
					
			{639,545},{640,498},{741,502},{742,556},//11
			{639,490},{639,438},{740,438},{742,493},//12
			{639,429},{639,377},{740,377},{741,431},//13
			{636,365},{638,311},{740,313},{740,364},//14
			{637,304},{638,258},{739,249},{740,303},//15
			{637,247},{638,203},{737,189},{738,239},//16
			{633,193},{637,146},{732,125},{738,177},//17
			{635,136},{632,121},{718,32},{735,114},//18
			{623,113},{607,104},{626,7},{706,22},//19
			{595,107},{551,107},{562,6},{614,7},//20
			{541,105},{500,104},{500,8},{552,7},//21
			{486,107},{441,107},{440,6},{490,7},//22
			
			{429,107},{377,106},{377,6},{428,7},//23
			{367,108},{314,105},{314,8},{367,7},//24
			{303,108},{260,106},{254,6},{302,4},//25
			{248,106},{203,106},{191,8},{242,7},//26
			{193,107},{149,108},{128,9},{180,7},//27
			{138,105},{124,115},{40,27},{116,9},//28
			{117,121},{109,135},{11,117},{29,33},//29
			{109,148},{107,191},{9,182},{9,129},//30
			{108,205},{110,249},{10,243},{11,191},//31
			
			{110,263},{108,304},{9,306},{10,253},//32
			{111,315},{110,361},{9,367},{9,316},//33
			{111,370},{110,415},	{9,430},{8,378},//34.
			{111,427},{111,471},{11,498},{9,441},//35
			{111,485},{118,503},{27,593},{10,506},//36
			{124,508},{145,517},{119,619},{35,602},//37
			{153,516},{199,517},{184,619},{129,621},//38
			{209,516},{257,517},{248,618},{194,619},//39
			{269,515},{316,519},{309,622},{254,621},//40
			{325,517},{369,516},{371,620},{317,619},//41
			{379,517},{426,517},{435,618},{381,619},//42
			{435,515},{481,515},{502,618},{444,619},//43
			{492,516},{506,508},{600,605},{510,621},//44.
			{511,503},{520,490},{622,506},{607,594},//45.
			{517,479},{518,432},{622,442},{623,497},//46
			{516,425},{520,379},{622,377},{622,432},//47
			{515,368},{517,319},{621,313},{622,368},//48
			{514,311},{516,264},{619,247},{621,301},//49
			{515,256},{510,244},{600,150},{620,235},//50.
			{506,232},{492,226},{508,125},{592,143},//51
			{482,233},{436,228},{440,126},{498,126},//52
			{425,233},{380,228},{377,125},{430,126},//53
			{369,233},{323,231},{313,127},{368,125},//54
			{314,233},{269,233},{249,127},{303,127},//55
			{260,228},{245,235},{153,143},{241,127},//56
			{241,242},{231,254},{128,238},{144,152},//57
			{233,262},{233,306},{126,306},{127,244},//58
			{234,314},{232,356},{128,378},{128,315},//59
			{232,366},{238,383},{145,474},{128,387},//60
			{247,387},{260,397},{241,499},{153,482},//61
			{268,393},{308,395},{309,499},{251,498},//62
			{319,389},{504,381},{503,498},{320,499},//63**** casilla meta
			{268,393},{308,395},{309,499},{251,498},//62 -1  para "contar hacia atras"
			{247,387},{260,397},{241,499},{153,482},//61 -2
			{232,366},{238,383},{145,474},{128,387},//60 -3
			{234,314},{232,356},{128,378},{128,315},//59 -4
			{233,262},{233,306},{126,306},{127,244},//58 -5
	};
	public int posfichacasillax(int numcas,int ficha){ //retornara una posicionx dentro de una casilla
int medx;
medx=0;
if ((Math.abs(defcasillas[numcas][0]-defcasillas[numcas][2])>
		(Math.abs(defcasillas[numcas][4]-defcasillas[numcas][7])))){
			
		}
		if (defcasillas[numcas][0]> defcasillas[numcas][2]){;}else{;} //lleanar direccion izq
if (defcasillas[numcas][1]> defcasillas[numcas][3]){;}else{;} //lleanar direccion arrib

		
		if ((Math.abs(defcasillas[numcas][0]-defcasillas[numcas][2])<
Math.abs(defcasillas[numcas][1]-defcasillas[numcas][3]))){
	
}else{};
//defcasillas[numcas][0]-defcasillas[numcas][2])/2
		return medx;
	};
	public int posfichacasillay(int numcas){
		int y =0;
		return y;
	};
	
    public int modojuego=1;
    //modos: 1 configuracion 2 jugando ,3 sacando seis, 
	public int[] ocas={
			5,9,14,18,23,27,32,36,41,45,50,54,59,63,63 //la última es de oca a oca y gané
			};
	public int [] dedado={
			26,53
	};
	public int[] puentes={ 6,12
			
	};
	public int[] trampas={19,31,42,52
		
	};
	public int muerte=58;
	public int llegada=63;
	
	private int [][] jugadoresorig={
		//jugador(0,3)...R,G,B,Y |0=no juega,1= Humano,2 =Auto|turnosEspera=0 ...|orden jugador
		{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}
	};
	
	public int [][] jugadores={
			//jugador(0,3)...R,G,B,Y |0=no juega,1= Humano,2 =Auto|turnosEspera=0 ...|orden jugador
			{0,1,0,0,0},{0,1,0,0,0},{0,1,0,0,0},{0,1,0,0,0}
	};
	public int [][] mopciones={ //[j][op1x,op1y,op1x',op1y',op2x,op2y,...,
			{806,593,821,608},{839,593,854,608},{873,593,887,608},//f roja  0 1 2
			{806,634,821,649},{839,634,854,649},{873,634,887,649},//f verde 3 4 5
			{806,671,821,685},{839,671,854,685},{873,671,887,685},//op f amarilla 6 7 8 
			{806,710,821,725},{839,710,854,725},{873,710,887,725},//op f azul 9 10 11
			{760,262,890,298},{760,331,890,369},{760,396,889,431},//op dados 12  comenzar 13 reinic 14
			{760,466,890,502},{760,466,890,502},{760,466,890,502} //opcion salir 15
	};
	public int[][] casillas4={ // para que quepan en la misma celda 4 fichas
			//se multiplicaran por "n" para la posicion de la ficha en cada casilla:
			//ficha0(0,1)*n		//ficha1(2,3)*n      //ficha2(4,5)*n    	//ficha3(6,7)*n
			{770,587},			{770,628},			{770,667},			{770,704}, //0
			//{58,640},			{108,642},			{063,703},			{106,704}, //0 //cambiada
			{158,649},			{208,652},			{163,713},			{206,714}, //1
			{259,658},			{290,664},			{261,698},			{285,717}, 
			{322,646},			{345,664},			{325,707},			{345,717},
			{384,646},			{410,663},			{385,697},			{409,716},
			{445,644},			{475,660},			{445,694},			{474,715}, //5
			{504,648},			{536,656},			{506,697},			{536,709},
			{560,645},			{589,664},			{566,692},			{596,710},
			{617,650},			{647,677},			{633,717},			{669,704},
			{654,613},			{695,621},			{679,647},			{713,670},
			{659,556},			{703,566},			{664,583},			{697,587},//10
			{661,502},			{708,504},			{685,533},			{718,535},
			{643,468},			{681,442},			{705,474},			{710,439},
			{642,406},			{685,378},			{706,407},			{719,378},
			{642,340},			{671,311},			{696,346},			{713,315},
			{714,280},			{662,284},			{661,253},			{713,251},//15
			{710,223},			{654,227},			{660,196},			{704,192},
			{704,131},			{637,172},			{665,139},			{701,158},
			{700,51},			{707,87},			{668,84},			{641,114},
			{628,9},			{668,14},			{615,61},			{646,58},
			{575,78},			{561,39},			{590,23},			{565,8}, //20
			{518,78},			{499,36},			{526,30},			{503,6},
			{464,84},			{437,42},			{462,24},			{440,7},
			{403,78},			{378,44},			{405,27},			{377,5},
			{344,85},			{313,46},			{342,37},			{313,7},
			{278,83},			{254,46},			{282,23},			{253,6},//25
			{224,82},			{194,44},			{215,22},			{190,6},
			{168,81},			{137,48},			{154,21},			{128,8},
			{104,76},			{100,33},			{62,43},			{47,13},
			{76,108},			{32,94},			{42,58},			{7,63},
			{81,144},			{49,160},			{12,151},			{10,127},//30
			{75,224},			{74,197},			{10,216},			{11,190},
			{77,257},			{58,281},			{11,278},			{10,252},
			{76,313},			{57,339},			{8,315},			{9,344},
			{78,374},			{62,400},			{12,405},			{10,376},
			{63,455},			{70,430},			{11,440},			{10,470},//35
			{81,493},			{51,529},			{14,554},			{10,513},
			{110,523},		{99,552},			{53,583},			{89,591},
			{152,520},			{171,541},			{142,570},			{160,592},
			{226,594},			{231,555},			{210,514},			{193,590},
			{269,515},			{259,587},			{290,539},			{285,575},//40
			{324,518},			{350,594},			{321,558},			{346,541},
			{381,522},			{404,552},			{379,565},			{408,587},
			{442,584},			{436,515},			{462,537},			{472,579},
			{504,581},			{552,584},			{516,545},			{494,522},
			{532,489},			{580,498},			{595,535},			{554,524},//45
			{515,452},			{562,435},			{588,468},			{596,439},
			{592,408},			{574,375},			{515,403},			{542,376},
			{596,313},			{514,343},			{535,315},			{590,340},
			{514,283},			{538,257},			{585,250},			{580,278},
			{523,225},			{574,223},			{577,168},			{598,191},//50
			{562,123},			{539,158},			{505,124},			{497,177},
			{462,197},			{436,162},			{438,122},			{472,139},
			{403,207},			{378,175},			{377,124},			{400,141},
			{344,203},			{314,163},			{342,137},			{312,124},
			{276,124},			{290,199},			{252,146},			{285,155},//55
			{211,185},			{225,149},			{178,156},			{175,126},
			{136,161},			{132,206},			{169,217},			{203,216},
			{133,253},			{159,259},			{196,267},			{212,270},
			{127,347},			{129,310},			{186,312},			{194,340},
			{127,383},			{127,425},			{175,416},			{192,372},//60
			{165,464},			{214,471},			{210,420},			{228,400},
			{267,395},			{257,451},			{287,457},			{287,416},
			{357,385},			{383,465},			{427,377},			{476,454},//63
			{267,395},			{257,451},			{287,457},			{287,416},// 64 -62 +2
			{165,464},			{214,471},			{210,420},			{228,400},// 65 -61 +3
			{127,383},			{127,425},			{175,416},			{192,372},// 66 -60 +4
			{127,347},			{129,310},			{186,312},			{194,340},// 67 -59 +5
			{133,253},			{159,259},			{196,267},			{212,270},// 68 -58 +6
			};
	
   public int[][] casillas={
			{0,70,630,655,680,710,0,0,0},
			{0,137,650,0,0,0,0,0,0}, //1
			{0,275,660,0,0,0,0,0,0},
			{0,340,666,0,0,0,0,0,0},
			{0,405,665,0,0,0,0,0,0},
			{0,465,660,0,0,0,0,0,0},//5
			{0,520,661,0,0,0,0,0,0},
			{0,585,663,0,0,0,0,0,0},
			{0,622,662,0,0,0,0,0,0},
			{0,660,629,0,0,0,0,0,0},
			{0,663,568,0,0,0,0,0,0},//10
			{0,662,515,0,0,0,0,0,0},
			{0,663,462,0,0,0,0,0,0},
			{0,663,403,0,0,0,0,0,0},
			{0,663,340,0,0,0,0,0,0},
			{0,663,280,0,0,0,0,0,0},//15
			{0,663,220,0,0,0,0,0,0},
			{0,663,160,0,0,0,0,0,0},
			{0,665,90,0,0,0,0,0,0},
			{0,640,55,0,0,0,0,0,0},
			{0,577,70,0,0,0,0,0,0},//20
			{0,520,75,0,0,0,0,0,0},
			{0,459,75,0,0,0,0,0,0},
			{0,398,75,0,0,0,0,0,0},
			{0,337,75,0,0,0,0,0,0},
			{0,276,75,0,0,0,0,0,0},//25
			{0,215,54,0,0,0,0,0,0},
			{0,164,55,0,0,0,0,0,0},
			{0,93,50,0,0,0,0,0,0},
			{0,71,100,0,0,0,0,0,0},
			{0,70,160,0,0,0,0,0,0},//30
			{0,69,220,0,0,0,0,0,0},
			{0,69,275,0,0,0,0,0,0},
			{0,65,340,0,0,0,0,0,0},
			{0,65,400,0,0,0,0,0,0},
			{0,65,450,0,0,0,0,0,0},//35
			{0,62,520,0,0,0,0,0,0},
			{0,106,563,0,0,0,0,0,0},
			{0,160,563,0,0,0,0,0,0},
			{0,223,563,0,0,0,0,0,0},
			{0,290,543,0,0,0,0,0,0},//40
			{0,345,543,0,0,0,0,0,0},
			{0,396,543,0,0,0,0,0,0},
			{0,467,543,0,0,0,0,0,0},
			{0,498,543,0,0,0,0,0,0},
			{0,550,515,0,0,0,0,0,0},//45
			{0,550,459,0,0,0,0,0,0},
			{0,550,403,0,0,0,0,0,0},
			{0,550,347,0,0,0,0,0,0},
			{0,565,285,0,0,0,0,0,0},
			{0,550,225,0,0,0,0,0,0},//50
			{0,516,186,0,0,0,0,0,0},
			{0,461,186,0,0,0,0,0,0},
			{0,408,170,0,0,0,0,0,0},
			{0,337,186,0,0,0,0,0,0},
			{0,287,166,0,0,0,0,0,0},//55
			{0,201,175,0,0,0,0,0,0},
			{0,181,226,0,0,0,0,0,0},
			{0,159,288,0,0,0,0,0,0},
			{0,188,331,0,0,0,0,0,0},
			{0,185,385,0,0,0,0,0,0},//60
			{0,230,430,0,0,0,0,0,0},
			{0,285,435,0,0,0,0,0,0},
			{0,377,414,0,0,0,0,0,0}, //63
			{0,285,435,0,0,0,0,0,0}, // rebotes
			{0,230,430,0,0,0,0,0,0},
			{0,185,385,0,0,0,0,0,0},
			{0,188,331,0,0,0,0,0,0},
			{0,188,284,0,0,0,0,0,0}, 
			{0,185,220,0,0,0,0,0,0},
	};
   
	public Tablero() {
		// TODO Auto-generated constructor stub
		 int[][] casillas={
				{0,0,0,0,0,0,0,0,0},
				{0,37,664,0,0,0,0,0,0},
				{0,275,660,0,0,0,0,0,0},
				{0,340,666,0,0,0,0,0,0},
				{0,405,665,0,0,0,0,0,0},
				{0,470,660,0,0,0,0,0,0},
				{0,535,661,0,0,0,0,0,0},
				{0,600,663,0,0,0,0,0,0},
				{0,632,662,0,0,0,0,0,0},
				{0,660,629,0,0,0,0,0,0},
				{0,663,578,0,0,0,0,0,0},
				{0,662,525,0,0,0,0,0,0},
				{0,663,472,0,0,0,0,0,0},
				{0,663,403,0,0,0,0,0,0},
				{0,663,340,0,0,0,0,0,0},
				{0,663,280,0,0,0,0,0,0},
				{0,663,220,0,0,0,0,0,0},
				{0,663,160,0,0,0,0,0,0},
				{0,663,100,0,0,0,0,0,0},
				{0,663,569,0,0,0,0,0,0},
				{0,581,518,0,0,0,0,0,0},
				{0,520,465,0,0,0,0,0,0},
				{0,459,412,0,0,0,0,0,0},
				{0,398,343,0,0,0,0,0,0},
				{0,337,280,0,0,0,0,0,0},
				{0,276,220,0,0,0,0,0,0},
				{0,215,160,0,0,0,0,0,0},
				{0,154,100,0,0,0,0,0,0},
				{0,113,40,0,0,0,0,0,0},
				{0,85,119,0,0,0,0,0,0},
				{0,85,175,0,0,0,0,0,0},
				{0,85,235,0,0,0,0,0,0},
				{0,85,295,0,0,0,0,0,0},
				{0,85,355,0,0,0,0,0,0},
				{0,85,415,0,0,0,0,0,0},
				{0,85,475,0,0,0,0,0,0},
				{0,68,512,0,0,0,0,0,0},
				{0,106,543,0,0,0,0,0,0},
				{0,162,543,0,0,0,0,0,0},
				{0,213,543,0,0,0,0,0,0},
				{0,264,543,0,0,0,0,0,0},
				{0,315,543,0,0,0,0,0,0},
				{0,366,543,0,0,0,0,0,0},
				{0,417,543,0,0,0,0,0,0},
				{0,468,543,0,0,0,0,0,0},
				{0,550,515,0,0,0,0,0,0},
				{0,550,459,0,0,0,0,0,0},
				{0,550,403,0,0,0,0,0,0},
				{0,550,347,0,0,0,0,0,0},
				{0,550,291,0,0,0,0,0,0},
				{0,550,235,0,0,0,0,0,0},
				{0,516,196,0,0,0,0,0,0},
				{0,461,196,0,0,0,0,0,0},
				{0,408,196,0,0,0,0,0,0},
				{0,337,196,0,0,0,0,0,0},
				{0,287,196,0,0,0,0,0,0},
				{0,233,196,0,0,0,0,0,0},
				{0,208,235,0,0,0,0,0,0},
				{0,208,284,0,0,0,0,0,0},
				{0,208,331,0,0,0,0,0,0},
				{0,208,380,0,0,0,0,0,0},
				{0,237,420,0,0,0,0,0,0},
				{0,285,420,0,0,0,0,0,0},
				{0,377,414,0,0,0,0,0,0}
		};
		 casillas[0][0]=0;
		 casillas[0][1]=0;
		 casillas[0][2]=0;
		 casillas[0][3]=0;
		 casillas[0][4]=0;
		 casillas[0][5]=0;
		 casillas[0][6]=0;
		 casillas[0][7]=0;
		 casillas[0][8]=0;
	}
	public void ocupacasilla(int nficha,int numcelda){
		//int nficha=this.nficha;
		for (int i=0;i >= (casillas[0].length);i++)
			{
			if(casillas[0][i]==nficha){casillas[0][i]=0;}
			casillas[0][numcelda]=nficha;
			}
	}
	
	public void coloractivo(int ficha) {
		//cambiara el color segun el turno...
		Rectangle luzactivo = new Rectangle(765,440,125,22);
        
		
	
		switch (ficha) {
		case 0:  luzactivo.setColor(Color.RED);
        break;
		case 1:  luzactivo.setColor(new Color(0,200,10));//verde
        break; 
		case 2:  luzactivo.setColor(Color.YELLOW);
        break;
		case 3:  luzactivo.setColor(Color.BLUE);
        break;
        default:  luzactivo.setColor(Color.ORANGE);}
		luzactivo.draw();
		luzactivo.fill();
		
	}
	public int xcasilla(int ncasilla) {
		return casillas[ncasilla][1];
	}
	public int ycasilla(int ncasilla) {
		return casillas[ncasilla][2];
	}
	public int preparados(){
		int numjugactivados=0;
		for (int i =0; i<4;i++){
			if (jugadores[i][0] >0){  // que esten en modo humano o auto
			numjugactivados++;}
			}
		return numjugactivados;
	};
	public void cambiaopcionjugadores(int opcion){
		switch (opcion) {
		case 0:  jugadores[0][0] =0;
        break;
		case 1:  jugadores[0][0] =1;
        break; 
		case 2:  jugadores[0][0] =2;
        break;
		case 3:  jugadores[1][0] =0;
        break;
		case 4:  jugadores[1][0] =1;
        break;
		case 5:  jugadores[1][0] =2;
        break;
		case 6:  jugadores[2][0] =0;
        break;
		case 7:  jugadores[2][0] =1;
        break;
		case 8:  jugadores[2][0] =2;
        break;
		case 9:  jugadores[3][0] =0;
        break;
		case 10:  jugadores[3][0] =1;
        break;
		case 11:  jugadores[3][0] =2;
        break;
		}
	};
	public int ratonen2(int modojuego) throws InterruptedException{
		// espera un click del raton y retorna la opcion del boton
		//
		Canvas c;
		
		int x,y; 
		int encontradox=100;
		Rectangle seleccionado;
		c=Canvas.getInstance();
		Point pulsacion=c.waitMouseClick();//getMousePosition();
		
		x=pulsacion.x;
		y=pulsacion.y;
		for ( int i =0; i< mopciones.length;i++)
		 {
			if ((mopciones[i] [0]<=x) && (mopciones[i] [1]<=y) && (mopciones[i] [2]>=x) && (mopciones[i] [3]>=y))
			{	encontradox=i;}
			 
			
		
		}
		if (encontradox < 12 && modojuego==0) {cambiaopcionjugadores(encontradox);}; //cambia opciones de jugador en modo config.
		if (encontradox >11 && encontradox <16)// pintamos un rectangulo sobre la opcion "pinchada"
		{ //System.out.println("encontradox="+encontradox);
			seleccionado = new Rectangle(mopciones[encontradox][0],mopciones[encontradox][1],
					Math.abs(mopciones[encontradox][0]-mopciones[encontradox][2]),
					Math.abs(mopciones[encontradox][1]-mopciones[encontradox][3]));
			seleccionado.setColor(Color.GRAY);
			seleccionado.setThickness(5);
			seleccionado.draw();
			seleccionado.fill();
		/*
			Thread.sleep(20);
			for (int anch=1;anch<5;anch++)//(anch<=(int)(Math.abs((mopciones[encontradox][2]-mopciones[encontradox][0])/4)));anch++)
					{
			seleccionado.grow(-1*anch,0);
			
			
			}
			*/
			Thread.sleep(25);
			seleccionado.undraw();
			
		}
		return encontradox;
	};
	
	public int ratonen(int x,int y){
		int encontradox = 100; //valor malo
	
		for ( int i =0; i< mopciones.length;i++)
		 {
			
			if ((mopciones[i] [0]<=x) && (mopciones[i] [1]<=y) && (mopciones[i] [2]>=x) && (mopciones[i] [3]>=y))
			{
				encontradox=i;
				
			   }
			 
			  // System.out.println(i+" esp "+" encon:"+encontradox);
				
	}
		
		return encontradox;
	};
	public void pintacontornocasilla(int num) throws InterruptedException{
		Line linea1;
		Line linea2;
		Line linea3;
		Line linea4;
		int casrel=(num-1) *(4);
		linea1= new Line(defcasillas[casrel][0],defcasillas[casrel][1],defcasillas[casrel+1][0],defcasillas[casrel+1][1]);
		linea2= new Line(defcasillas[casrel+1][0],defcasillas[casrel+1][1],defcasillas[casrel+2][0],defcasillas[casrel+2][1]);
		linea3= new Line(defcasillas[casrel+2][0],defcasillas[casrel+2][1],defcasillas[casrel+3][0],defcasillas[casrel+3][1]);
		linea4= new Line(defcasillas[casrel+3][0],defcasillas[casrel+3][1],defcasillas[casrel][0],defcasillas[casrel][1]);
		linea1.setColor(Color.PINK);linea1.setThickness(3);
		linea2.setColor(Color.PINK);linea2.setThickness(3);
		linea3.setColor(Color.PINK);linea3.setThickness(3);
		linea4.setColor(Color.PINK);linea4.setThickness(3);
		linea1.draw();linea2.draw();linea3.draw();linea4.draw();
		Thread.sleep(400);
		linea1.undraw();linea2.undraw();linea3.undraw();linea4.undraw();
	}
	public void repintaropciones(){
		//System.out.println("han llamado a repintar!!!");
	
		int ancho,alto;
		Rectangle cuadradito;
		for (int n=0;n<3;n++){
			ancho=Math.abs(mopciones[n][0]-mopciones[n][2]);
			alto=Math.abs(mopciones[n][1]-mopciones[n][3]);
		
			cuadradito= new Rectangle(mopciones[n][0],mopciones[n][1],ancho,alto);	// rojos
			cuadradito.setColor(Color.GRAY);
			if (jugadores[0][0]==n) {cuadradito.setColor(Color.RED);};
			cuadradito.fill();
		}
		for (int n=3;n<6;n++){
			ancho=Math.abs(mopciones[n][0]-mopciones[n][2]);
			alto=Math.abs(mopciones[n][1]-mopciones[n][3]);
			cuadradito= new Rectangle(mopciones[n][0],mopciones[n][1],ancho,alto);	// verdes
			cuadradito.setColor(Color.GRAY);
			if (jugadores[1][0]==n-3) {cuadradito.setColor(new Color(0,200,10));};
			cuadradito.fill();
		}
		for (int n=6;n<9;n++){
			ancho=Math.abs(mopciones[n][0]-mopciones[n][2]);
			alto=Math.abs(mopciones[n][1]-mopciones[n][3]);
			cuadradito= new Rectangle(mopciones[n][0],mopciones[n][1],ancho,alto);	// amarillos
			cuadradito.setColor(Color.GRAY);
			if (jugadores[2][0]==n-6) {cuadradito.setColor(Color.YELLOW);};
			cuadradito.fill();
		}
		
		for (int n=9;n<12;n++){
			ancho=Math.abs(mopciones[n][0]-mopciones[n][2]);
			alto=Math.abs(mopciones[n][1]-mopciones[n][3]);
			cuadradito= new Rectangle(mopciones[n][0],mopciones[n][1],ancho,alto);	// azules
			cuadradito.setColor(Color.GRAY);
			if (jugadores[3][0]==n-9) {cuadradito.setColor(Color.BLUE);};
			cuadradito.fill();
		}
	
		

	};
	public void mensajes(int nummensaje) throws InterruptedException{
		
		String[] mensajes={ // DE CUATRO EN CUATRO LINEAS
				"                    ","                    ","                     ","                ",//0
				"BIENVENIDOS AL      "," JUEGO DE LA OCA    ","                     ","               ",
				"ESCOGE AL MENOS     ","DOS JUGADORES Y     "," HAZ CLICK EN:       "," COMENZAR      ",
				"DE OCA A OCA Y      ","TIRO POR QUE ME TOCA","                     ","               ",
				"DE PUENTE A PUENTE  "," Y TIRO POR QUE ME  "," LLEVA LA CORRIENTE  ","               ",
				"DE DADO A DADO      "," Y TIRO POR QUE     "," ME HA TOCADO        ","               ",//5
				"TIENES QUE ESPERAR  ","3 TURNOS SIN        "," LANZAR LOS DADOS    ","               ",
				"AUN TIENE QUE PASAR ","2 TURNOS SIN        ","LANZAR LOS DADOS     ","               ",
				"AUN TIENE QUE PASAR ","1 TURNO SIN         ","LANZAR LOS DADOS     ","               ",
				"ESCOJE LAS OPCIONES "," SOBRE LOS JUGADORES"," Y PULSA EMPEZAR     ","				  ",
				"¿ABANDONAR PARTIDA? ","CONFIRM.EN REINICIAR","PARA SEGUIR:LANZAR   ","               ",//10
				"¿SALIR DEL  JUEGO?  ","CONFIRMA CON CLIC EN","SALIR, PARA SEGUIR:  ","CLIC EN LANZAR ",
				"TURNO:				 ","FICHA ROJA   	    "," TIRA EL DADO        ","               ",										//10
				"TURNO:              ","FICHA VERDE         "," TIRA EL DADO        ","               ",
				"TURNO:              ","FICHA AMARILLA      "," TIRA EL DADO        ","               ",
				"TURNO: 			 ","FICHA AZUL          "," TIRA EL DADO        ","               ",//15
				"SALE PRIMERO        ","QUIEN SAQUE UN 6    ","EMPIEZA EL...        ","               ",
				"SALIÓ EL 6          ","                    ","EMPIEZA EL...        ","               ",
				"MALA SUERTE         ","HAS CAIDO           ","EN LA MUERTE. DIRECTO","A LA CASILLA 1 ",
				};
		
		
		Text mensajito1,mensajito2,mensajito3,mensajito4;
		Rectangle cartelera;
		cartelera = new Rectangle(755,10,140,100);
        cartelera.setColor(Color.ORANGE);
        cartelera.draw();
        cartelera.fill();
			
		mensajito1= new Text(755,20,mensajes[(nummensaje*4)]);
		mensajito1.draw();
		mensajito2= new Text(755,40,mensajes[(nummensaje*4)+1]);
		mensajito2.draw();
		mensajito3= new Text(755,60,mensajes[(nummensaje*4)+2]);
		mensajito3.draw();
		mensajito4= new Text(755,80,mensajes[(nummensaje*4)+3]);
		mensajito4.draw();
		Thread.sleep(1200);
		mensajito1.undraw();
		mensajito2.undraw();mensajito3.undraw();mensajito4.undraw();
		//mensajito.undraw();
		
		
	}
	
		
		
	

}
