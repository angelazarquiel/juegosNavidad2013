package Juego;

import java.awt.Point;

import Graphics2.Canvas;
import Graphics2.Color;
import Graphics2.Ellipse;
import Graphics2.Line;
import Graphics2.Rectangle;
import Graphics2.Text;

public class TresEnRaya {

public static int [][] cuadricula;

private static final int CIRCULO = 1;
private static final int ASPA = 2;
private static final int TABLAS = 3;

private static final int NADIE = 0;
private static final int JUGADOR = 1;
private static final int MAQUINA = 2;

public static boolean juegoTerminado;

public static int jugadasRestantes;

	//Seleccionar casilla mediante el ratón en la cuadrícula
	public static int [] seleccionarCasilla (Point posicion){
		
		int [] casilla;
		casilla = new int [2];
		
		//Se selecciona la columna
		if (posicion.x<200){
			casilla [1]=1;					//Primera columna
		}else if (posicion.x<400){
			casilla [1]=2;					//Segunda columna
		}else{
			casilla [1]=3;					//Tercera columna
		}
		
		//Se selecciona la fila
		if (posicion.y<200){
			casilla [0]=1;					//Primera fila
		}else if (posicion.y<400){
			casilla [0]=2;					//Segunda fila
		}else{
			casilla [0]=3;					//Tercera fila
		}
		
		return casilla;
		
	}
	
	//Pinta un círculo en una casilla
	public static void pintarCirculoCasilla (int [] casilla){
		int x, y;
		
		//Para centrar el círculo en la casilla (coordenada y)
		if (casilla[0]==1){
			y=5;
		}else if (casilla[0]==2){
			y=205;
		}else 
			y=405;

		//Para centrar el círculo en la casilla (coordenada x)
		if (casilla[1]==1){
			x=5;
		}else if (casilla[1]==2){
			x=205;
		}else 
			x=405;
		
		//Se pinta el círculo
		Ellipse circulo;
		circulo = new Ellipse (x,y,190,190);
		circulo.setColor (Color.BLUE);
		circulo.setThickness(2.3f);
		circulo.draw();
		
	}
	
	//Pinta un aspa en una casilla
	public static void pintarAspaCasilla (int [] casilla){
		int x, y;
		
		//Para centrar el aspa en la casilla (coordenada y)
		if (casilla[0]==1){
			y=5;
		}else if (casilla[0]==2){
			y=205;
		}else 
			y=405;
		
		//Para centrar el círculo en la casilla (coordenada x)
		if (casilla[1]==1){
			x=5;
		}else if (casilla[1]==2){
			x=205;
		}else 
			x=405;

		//Se pinta la diagonal directa del aspa
		Line linea1;
		linea1 = new Line (x,y,x+190,y+190);
		linea1.setColor (Color.MAGENTA);
		linea1.setThickness(2.3f);
		linea1.draw();
		
		//Se pinta la diagonal inversa del aspa
		Line linea2;
		linea2 = new Line (x+190,y,x,y+190);
		linea2.setColor (Color.MAGENTA);
		linea2.setThickness(2.3f);
		linea2.draw();
		
	}
	 
	//Se marca la casilla como ocupada
	public static void ocuparCasilla (int [] casilla,int tipoFigura){
		cuadricula[casilla[0]-1][casilla[1]-1]=tipoFigura;	
	}
	
	//La máquina elige una casilla
	public static void turnoMaquina (){

		//Buscamos una casilla vacía para pintar
		int i=0;
		int j=0; 
		int[] casillaSeleccionada = new int[2];
		
		if(jugadasRestantes!=8){
			//Seleccionamos la primera casilla vacía para la máquina
			while (cuadricula [i][j]==CIRCULO || cuadricula [i][j]==ASPA){
				if(j==2){
					i++;
					j=0;
				}else
					j++;
			}
				
		}else{
			
			//Seleccionamos la primera casilla de la máquina al azar
			do{
				i=(int)(Math.random()*3);
				j=(int)(Math.random()*3);
			}while (cuadricula [i][j]==CIRCULO || cuadricula [i][j]==ASPA);
			
		}

		//Pintamos la primera casilla vacía encontrada
		casillaSeleccionada[0]=i+1;
		casillaSeleccionada[1]=j+1;
		
		//Pintamos la casilla
		pintarAspaCasilla (casillaSeleccionada);
		ocuparCasilla (casillaSeleccionada,ASPA);
		jugadasRestantes--;
		
		if(comprobarGanador(ASPA)){
			mensajeGanador(ASPA);
			juegoTerminado=true;
		}else if(jugadasRestantes==0){
			mensajeGanador(TABLAS);
			juegoTerminado=true;
		}
		
	}

	//Se comprueba si el jugador ha ganado ya
	public static boolean comprobarGanador(int tipoJugador){
		
		//Comprobamos tres en raya horizontal
		if(cuadricula[0][0]==tipoJugador && cuadricula[0][1]==tipoJugador && cuadricula[0][2]==tipoJugador)
			return true;
		else if(cuadricula[1][0]==tipoJugador && cuadricula[1][1]==tipoJugador && cuadricula[1][2]==tipoJugador)
			return true;
		else if(cuadricula[2][0]==tipoJugador && cuadricula[2][1]==tipoJugador && cuadricula[2][2]==tipoJugador)
			return true;
				
		//Comprobamos tres en raya vertical
		if(cuadricula[0][0]==tipoJugador && cuadricula[1][0]==tipoJugador && cuadricula[2][0]==tipoJugador)
			return true;
		else if(cuadricula[0][1]==tipoJugador && cuadricula[1][1]==tipoJugador && cuadricula[2][1]==tipoJugador)
			return true;
		else if(cuadricula[0][2]==tipoJugador && cuadricula[1][2]==tipoJugador && cuadricula[2][2]==tipoJugador)
			return true;
		
		//Comprobamos tres en raya diagonal
		if(cuadricula[0][0]==tipoJugador && cuadricula[1][1]==tipoJugador && cuadricula[2][2]==tipoJugador)
			return true;
		else if(cuadricula[0][2]==tipoJugador && cuadricula[1][1]==tipoJugador && cuadricula[2][0]==tipoJugador)
			return true;
		
		return false;
	}
	
	//Escribe el mensaje ganador o tablas
	public static void mensajeGanador(int tipoJugador){
		Text texto;
		
		if(tipoJugador==CIRCULO){
			texto = new Text(233,295,"¡HAS GANADO JUGADOR!");
			texto.setColor(Color.GREEN);
		}else if(tipoJugador==ASPA){
			texto = new Text(220,295,"¡LO SIENTO!, te he ganado...");
			texto.setColor(Color.RED);
		}else{
			texto = new Text(235,295,"¡TABLAS!, nadie gana");
			texto.setColor(Color.DARK_GRAY);
		}
		
		texto.draw();
	}
	
	//Inicializacion del tablero
	public static void inicializarTablero(){

		//Inicializacion del tablero a todas las casillas vacias
		cuadricula = new int [3][3];
		for (int i=0; i<3; i++)
			for (int j=0; j<3; j++)
				cuadricula [i][j]=0;
		
		//Crear el tablero blanco
		Rectangle cuadrado;
		cuadrado = new Rectangle (0,0,600,600);
		cuadrado.setColor(Color.WHITE);
		cuadrado.fill();
		
		//Crear el tablero
		cuadrado = new Rectangle (0,0,600,600);
		cuadrado.setThickness(6.5f); //para el grosor de las lineas
		cuadrado.setColor(Color.BLACK);
		cuadrado.draw();
		
		//Crear las lineas del tablero
		Line linea;
		linea = new Line (200,0,200,600);
		linea.setThickness(6.5f);
		linea.setColor(Color.BLACK);
		linea.draw();
		
		linea = new Line (400,0,400,600);
		linea.setThickness(6.5f);
		linea.setColor(Color.BLACK);
		linea.draw();
		
		linea = new Line (0,200,600,200);
		linea.setThickness(6.5f);
		linea.setColor(Color.BLACK);
		linea.draw();
		
		linea = new Line (0,400,600,400);
		linea.setThickness(6.5f);
		linea.setColor(Color.BLACK);
		linea.draw();
	
	}
	
	//Se crea la pantalla de inicio del juego
	public static void pantallaInicio(){
		Text texto;
		texto = new Text (270,100,"EL JUEGO DE LAS TRES EN RAYA");
		texto.grow(170,100);
		texto.setColor(Color.BLUE);
		texto.draw();
		
		texto = new Text (270,300,"Elige quien empieza a jugar");
		texto.grow(50,20);
		texto.setColor (Color.GREEN);
		texto.draw();
		
		Rectangle rectangulo;
		rectangulo = new Rectangle (100,350,150,50);
		rectangulo.setColor (Color.GRAY);
		rectangulo.fill();
		
		texto = new Text (150,370,"MAQUINA");
		texto.setColor (Color.RED);
		texto.draw();
		
		rectangulo = new Rectangle (350,350,150,50);
		rectangulo.setColor (Color.GRAY);
		rectangulo.fill();
		
		texto = new Text (400,370,"JUGADOR");
		texto.setColor (Color.RED);
		texto.draw();
		
		
	}
	
	public static int elegirPrimerJugador(Point pulsacion){
	
		if ((pulsacion.x>100 && pulsacion.x<250) && (pulsacion.y>350 && pulsacion.y<400)){
			return MAQUINA;
		}else if ((pulsacion.x>350 && pulsacion.x<500) && (pulsacion.y>350 && pulsacion.y<400)){
			return JUGADOR;
		}else{
			return NADIE;
		}
	}
	
	public static void main(String[] args) {
	
		Canvas c;
		c= Canvas.getInstance();
		Point pulsacion;
		
		pantallaInicio();
		
		//Elegir quien empieza jugando
		int primerJugador=0;
		while (primerJugador==0){
			pulsacion = c.waitMouseClick();
			primerJugador=elegirPrimerJugador(pulsacion);
		}
		
		//El juego empieza
		juegoTerminado=false;
		jugadasRestantes=9;
		
		//Inicialización del tablero de juego
		inicializarTablero();
		
		int[] casillaSeleccionada = new int[2];
		if(primerJugador==MAQUINA){
			//Comienza la máquina eligiendo la casilla
			casillaSeleccionada[0]=(int)(Math.random()*3)+1;
			casillaSeleccionada[1]=(int)(Math.random()*3)+1;
			pintarAspaCasilla (casillaSeleccionada);
			ocuparCasilla(casillaSeleccionada,ASPA);
			jugadasRestantes--;
		}
		
		while (!juegoTerminado){
			
			//Juega el jugador
			pulsacion = c.waitMouseClick();
			casillaSeleccionada=seleccionarCasilla(pulsacion);
			pintarCirculoCasilla (casillaSeleccionada);
			ocuparCasilla(casillaSeleccionada,CIRCULO);
			jugadasRestantes--;
			
			//Si el jugador no gana, le toca a la máquina
			if(comprobarGanador(CIRCULO)){
				mensajeGanador(CIRCULO);
				juegoTerminado=true;
			}else if(jugadasRestantes==0){
				mensajeGanador(TABLAS);
				juegoTerminado=true;
			}else
				turnoMaquina();
		
		}
	}

}
