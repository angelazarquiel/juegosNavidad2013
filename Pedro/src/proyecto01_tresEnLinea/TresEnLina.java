package proyecto01_tresEnLinea;

import java.awt.Point;
import java.util.Vector;

import graphics2.*;

public class TresEnLina {
	private static int[] tablero = new int[9];
	private static Vector<Ellipse> circulos = new Vector<Ellipse>();
	private static Vector<Line> cruces = new Vector<Line>();
	private static boolean maquina = true;
	private final static int inicioTablero = 10;
	private final static int anchoTablero = 600;
	private final static int altoTablero = 600;
	private final static int anchoLinasTablero = 20;
	private final static int anchoLinasFichas = 20;
	private final static int porporcionFicha = 80; // Proporción relativa al hueco disponible (porcentaje)
	private final static Color colorFondoTablero = new Color(240, 220, 200);
	private final static Color colorLineaTablero = new Color(200, 180, 160);
	private final static Color colorLineaFicha = new Color(160, 140, 120);
	private final static Color[] colorCuadros = {new Color(240, 220, 200), new Color(200, 180, 160), new Color(160, 140, 120)};
	private final static int[][] lineasGanadoras = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
	private final static int[][][] imposiblePerder = {
		{{8},{},{0,4}},{{6},{},{2,4}},{{2},{},{6,4}},{{0},{},{8,4}},
		{{4},{},{2,6}},{{4},{},{0,8}},{{6},{},{0,3}},{{7},{},{1,4}},
		{{8},{},{2,5}},{{0},{},{3,6}},{{1},{},{4,7}},{{2},{},{5,8}},
		{{3},{},{0,6}},{{4},{},{1,7}},{{5},{},{2,8}},{{2},{},{0,1}},
		{{5},{},{3,4}},{{8},{},{6,7}},{{0},{},{1,2}},{{3},{},{4,5}},
		{{6},{},{7,8}},{{1},{},{0,2}},{{4},{},{3,5}},{{7},{},{6,8}},
		{{8},{0,4},{}},{{6},{2,4},{}},{{2},{6,4},{}},{{0},{8,4},{}},
		{{4},{2,6},{}},{{4},{0,8},{}},{{6},{0,3},{}},{{7},{1,4},{}},
		{{8},{2,5},{}},{{0},{3,6},{}},{{1},{4,7},{}},{{2},{5,8},{}},
		{{3},{0,6},{}},{{4},{1,7},{}},{{5},{2,8},{}},{{2},{0,1},{}},
		{{5},{3,4},{}},{{8},{6,7},{}},{{0},{1,2},{}},{{3},{4,5},{}},
		{{6},{7,8},{}},{{1},{0,2},{}},{{4},{3,5},{}},{{7},{6,8},{}},
		{{4},{8},{}},{{4},{6},{}},{{4},{2},{}},{{4},{0},{}},{{4},{7}
		,{}},{{4},{5},{}},{{4},{3},{}},{{4},{1},{}},{{1},{8,0},{4}},
		{{3},{6,2},{4}},{{5},{2,6},{4}},{{7},{0,8},{4}},{{8},{5,7},{
		4}},{{6},{3,7},{4}},{{2},{5,1},{4}},{{0},{3,1},{4}},{{0},{8}
		,{4}},{{2},{6},{4}},{{6},{2},{4}},{{8},{0},{4}},{{0},{4},{8}
		},{{2},{4},{6}},{{6},{4},{2}},{{8},{4},{0}},{{0,2,6,8},{},{}
		},{{1,3,5,7},{},{}}};	

	public static void main(String[] args) {
		
		generarTablero();

		maquina = elegirOponente();
		
		while(true){
			mostrarGanador(partidaNueva());
			limpiarFichas();
		}
	}

	private static int partidaNueva() {
		int turnos = 0;
		int ganador = 0;
		boolean jugador = Math.random() > 0.5;
		
		while(turnos<9 && ganador==0){
			if(jugador && maquina){
				turnoMaquina(jugador);
			}else{
				if(!turnoHumano(jugador))
					continue;
			}					
			
			ganador = hayGanador();

			jugador=!jugador;
			turnos++;
		}
		return ganador;
	}
	private static boolean turnoHumano(boolean jugador) {
		int celda = pulsarCelda();

		if(tablero[celda]==0){
			nuevaFicha(celda, jugador);

			return true;
		}

		return false;
	}

	private static void turnoMaquina(boolean jugador) {
		final int jIA = jugador ? 1 : 2;
		final int jHumano = !jugador ? 1 : 2;
		
		for(int regla=0; regla<imposiblePerder.length; regla++){
			boolean correcto = true;
			
			for(int j1=0; j1<imposiblePerder[regla][1].length; j1++)
				if(tablero[imposiblePerder[regla][1][j1]]!=jHumano)
					correcto = false;
			
			for(int j2=0; j2<imposiblePerder[regla][2].length; j2++)
				if(tablero[imposiblePerder[regla][2][j2]]!=jIA)
					correcto = false;

			int celda = imposiblePerder[regla][0][(int)(imposiblePerder[regla][0].length * Math.random())];
			if(correcto && tablero[celda]==0){
				nuevaFicha(celda, jugador);
				break;
			}
		}
	}

	private static void nuevaFicha(int celda, boolean jugador) {
		tablero[celda] = jugador ? 1 : 2;
		generarFicha(celda, jugador);		
	}

	
	private static int hayGanador() {
		int jugador, ganador;
		
		for(int i=0; i<lineasGanadoras.length; i++){
			jugador = 0;
			ganador = 0;
			
			for(int j=0; j<lineasGanadoras[i].length; j++){
				if(tablero[lineasGanadoras[i][j]] == 0){
					jugador = 0;
					break;
				}
				jugador = tablero[lineasGanadoras[i][j]];
				ganador += tablero[lineasGanadoras[i][j]];
			}
			
			if(ganador%3==0 && jugador!=0) return jugador;
		}
		
		return 0;
	}

	private static void generarTablero() {
		Rectangle fondo = new Rectangle(
			inicioTablero, inicioTablero,
			anchoTablero, altoTablero
		);
		fondo.setColor(colorFondoTablero);
		fondo.fill();

		generarLinea( (0/3.0), 0, (0/3.0), 1);
		generarLinea( (1/3.0), 0, (1/3.0), 1);
		generarLinea( (2/3.0), 0, (2/3.0), 1);
		generarLinea( (3/3.0), 0, (3/3.0), 1);
		generarLinea( 0, (0/3.0), 1, (0/3.0));
		generarLinea( 0, (1/3.0), 1, (1/3.0));
		generarLinea( 0, (2/3.0), 1, (2/3.0));
		generarLinea( 0, (3/3.0), 1, (3/3.0));
	}

	private static void generarLinea(double x1, double y1, double x2, double y2) {
		Line linea = new Line(
				anchoTablero * x1 + inicioTablero,
				altoTablero * y1 + inicioTablero,
				anchoTablero * x2 + inicioTablero,
				altoTablero * y2 + inicioTablero
		);
		linea.setThickness(anchoLinasTablero);
		linea.setColor(colorLineaTablero);
		linea.draw();
	}

	private static void generarFicha(int i, boolean cruz) {
		int x = i%3;
		int y = i/3;
		int w = (((anchoTablero / 3) - anchoLinasTablero) - anchoLinasFichas) * porporcionFicha / 100;
		int h = (((altoTablero / 3) - anchoLinasTablero) - anchoLinasFichas) * porporcionFicha / 100;
		int inicioX = inicioTablero + (anchoTablero * (x + 1) / 3) - (anchoTablero * 1 / 6);
		int inicioY = inicioTablero + (altoTablero * (y + 1) / 3) - (altoTablero * 1 / 6);
		
		if(cruz){
			Line raya1 = new Line(
				inicioX - (w / 2),
				inicioY - (h / 2),
				inicioX + (w / 2),
				inicioY + (h / 2)
			);
			raya1.setThickness(anchoLinasFichas);
			raya1.setColor(colorLineaFicha);
			raya1.draw();
			
			Line raya2 = new Line(
				inicioX + (w / 2),
				inicioY - (h / 2),
				inicioX - (w / 2),
				inicioY + (h / 2)
			);
			raya2.setThickness(anchoLinasFichas);
			raya2.setColor(colorLineaFicha);
			raya2.draw();

			cruces.add(raya1);
			cruces.add(raya2);
		}else{
			Ellipse circulo = new Ellipse(
				inicioX - (w / 2),
				inicioY - (h / 2),
				w, h
			);
			circulo.setThickness(anchoLinasFichas);
			circulo.setColor(colorLineaFicha);
			circulo.draw();
			
			circulos.add(circulo);
		}
	}

	private static int pulsarCelda() {
		Canvas lienzo = Canvas.getInstance();
		int resultado = 0;
		boolean X = false, Y = false; // Almacena que sea correcto el rango
		 
		while(!X || !Y){
			X = false;
			Y = false;
			resultado = 0;
			Point pulsacion = lienzo.waitMouseClick();
			
			for(int x=0; x<3 && !X; x++)
				if(comprobarRango(x, pulsacion.x)){
					X = true;
					resultado += x;
				}
			
			for(int y=0; y<3 && X && !Y; y++)
				if(comprobarRango(y, pulsacion.y)){
					Y = true;
					resultado += (y * 3);
				}
		}
		
		return resultado;
	}

	private static boolean comprobarRango(int n, int posicion) {
		int inicioColumna = inicioTablero + (anchoTablero * (n) / 3) + (anchoLinasTablero / 2);
		int finColumna = inicioTablero + (anchoTablero * (n + 1) / 3) - (anchoLinasTablero / 2);
		
		return inicioColumna < posicion && posicion < finColumna;
	}

	private static boolean elegirOponente() {
		int bordeTexto = 6;
		Rectangle[] cuadros = new Rectangle[2];
		Text[] textoHumano = new Text[1 + bordeTexto];
		Text[] textoIA = new Text[1 + bordeTexto];
		
		cuadros = generarCuadros(cuadros, new Color[]{colorCuadros[0], colorCuadros[2]}, true);
		textoHumano = generarTexto("Humano", textoHumano, 100, (inicioTablero + anchoTablero / 2), (inicioTablero + altoTablero * 1 / 4), new Color[]{colorCuadros[2], colorCuadros[1]});
		textoIA = generarTexto("Máquina", textoIA, 100, (inicioTablero + anchoTablero / 2), (inicioTablero + altoTablero * 3 / 4), new Color[]{colorCuadros[0], colorCuadros[1]});
		
		Canvas lienzo = Canvas.getInstance();
				 
		Point pulsacion = lienzo.waitMouseClick();

		ocultarElementos(cuadros);
		ocultarElementos(textoHumano);
		ocultarElementos(textoIA);
			
		return pulsacion.y > (inicioTablero + altoTablero / 2);
	}

	private static void mostrarGanador(int ganador) {
		Rectangle[] fondo = new Rectangle[1];
		Text[] titulo = new Text[8];
		String texto = ganador == 0 ? "Empate" :
			maquina ? "Has perdido" : "Jugador " + ganador;
		
		fondo = generarCuadros(fondo, new Color[]{colorCuadros[0]}, false);
		titulo = generarTexto(texto, titulo, 100, (inicioTablero + anchoTablero / 2), (inicioTablero + altoTablero / 2), new Color[]{colorCuadros[2], colorCuadros[1]});
		
		Canvas lienzo = Canvas.getInstance();
		lienzo.waitMouseClick();
		
		ocultarElementos(fondo);
		ocultarElementos(titulo);
	
	}

	private static void limpiarFichas() {

		for(int i=0; i<circulos.size(); i++)
			circulos.elementAt(i).undraw();
		
		for(int i=0; i<cruces.size(); i++)
			cruces.elementAt(i).undraw();
		
		tablero = new int[9];
		circulos = new Vector<Ellipse>();
		cruces = new Vector<Line>();
	}
	
	private static Rectangle[] generarCuadros(Rectangle[] cuadros, Color[] c, boolean partido) {
		for(int i=0; i<cuadros.length; i++){
			cuadros[i] = new Rectangle(
				inicioTablero, inicioTablero + i * altoTablero / 2,
				anchoTablero,
				partido ? altoTablero / 2 : altoTablero
			);
			cuadros[i].setColor(c[i]);
			cuadros[i].fill();
		}
		return cuadros;
	}

	private static Text[] generarTexto(String titulo, Text[] texto, int tamanio, int x, int y, Color[] c) {
		for(int i=texto.length-1; i>=0; i--){
			texto[i] = new Text(x, y, titulo);
			texto[i].grow(tamanio * 1.8, tamanio);
			texto[i].setColor(i==0 ? c[0] : c[1]);
			texto[i].draw();
			texto[i].translate(0, (texto[i].getHeight() / -10) + i);
		}
		
		return texto;
	}

	private static void ocultarElementos(Rectangle[] elementos) {
		for(int i=0; i<elementos.length; i++)
			elementos[i].undraw();		
	}

	private static void ocultarElementos(Text[] elementos) {
		for(int i=0; i<elementos.length; i++)
			elementos[i].undraw();		
	}
}
