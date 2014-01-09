package juego;

/* =========================================
 * =========================================
 * 
 *   C  A  S  I  N  O     M  E  M  O  R  Y
 * 
 * =========================================
 * =========================================
 * 
 * TITULO DEL JUEGO: "CASINO MEMORY"
 * VERSION: 1.0
 * AUTOR: MIGUEL ANGEL GARCIA GODOY
 * ASIGNATURA: PROGRAMACION
 * CURSO: 1º DAW - IES AZARQUIEL (TOLEDO)
 * FECHA: 6/01/2014  
 * 
 * OBJETIVO PRINCIPAL: DESARROLLAR LA MEMORIA
 * OBJETIVO DEL JUEGO: ENCONTRAR PAREJAS
 * 
 * =========================================
 * D E S C R I P C I O N   D E L  J U E G O
 * =========================================
 * 
 * El juego consta de 4 NIVELES de dificultad.
 * 	
 * ----> NIVEL 1 : 6 PAREJAS
 * ----> NIVEL 2 : 8 PAREJAS.
 * ----> NIVEL 3 : 15 PAREJAS.
 * ----> NIVEL 4 : 18 PAREJAS.
 * 
 * La PUNTUACION es proporcional al tiempo empleado
 * en encontrar todas las parejas y al nivel de dificultad.
 * 
 * En primer lugar, el jugador escoge el nivel de dificultad
 * de la partida en la pantalla de presentación del juego.
 * 
 * Acto seguido aparece el panel de la partida con las
 * figuras a la izquierda y los marcadores a la derecha.
 * 
 * Las figuras se encuentran ocultas bajo el icono de "ruleta".
 * 
 * Una vez comienza el juego, se pueden descubrir 2 figuras
 * a la vez (una a continuación de la otra). Transcurridos 
 * 1,5 segundos desde que dichas figuras son destapadas, estas 
 * vuelven a quedar ocultas, a no ser que formen una PAREJA, en
 * cuyo caso quedan descubiertas hasta el final de la partida.
 * 
 * Cada vez que se encuentra una PAREJA, el marcador de "PAREJAS"
 * se actualiza.
 * 
 * Al finalizar la partida, en el marcador de "TIEMPO" aparece
 * el tiempo en segundos empleado en encontrar todas las parejas.
 * Del mismo modo, en el marcador de "PUNTUACION" aparece la 
 * puntuación final obtenida.
 * 
 * Se da la opción al jugador de jugar otra partida. Si acepta,
 * se vuelve a mostrar la pantalla de presentación con el menú
 * de los niveles de dificultad.
 * 
 *
 * ==============================================================
 * N O T A:  UBICACION DE LA VENTANA DEL JUEGO
 * ==============================================================
 * 
 * La situación de la ventana emergente del juego se ha 
 * dispuesto modificando valores en la clase "Canvas" del paquete
 * "graphics2".
 * 
 * ==============================================================
 */

import java.awt.Point;
import graphics2.Canvas;
import graphics2.Color;
import graphics2.Picture;
import graphics2.Rectangle;
import graphics2.Text;

public class CasinoMemory {
	
	
	//VARIABLES GENERALES	

	private static int numFiguras = 0;
	private static int numFigurasPorFila = 0;
	private static Text marcadorParejas = new Text(840,50,"0" );
	private static Text segundos = new Text(840,200,"");
	private static Text puntos = new Text(840,350,"0");
	private static int nivelElegido = -1;
	private static Picture mono = new Picture("/simbolos/mono.png");
	private static Picture bocadillo = new Picture("/simbolos/bocadillo.png");
	
	
	
	//METODO "CARGAR-MENU": CARGA LA PANTALLA DE
	//PRESENTACION DEL JUEGO CON EL MENU PARA 
	//ELEGIR EL NIVEL DE DIFICULTAD
	
	public static void cargarMenu() {
		
		int i;
		int x = 40;
		int y = 560;		
		
		Picture fondo = new Picture("/simbolos/fondo.png");
		fondo.translate(0, 0);
		fondo.draw();
		
		Picture[] niveles = new Picture[4];
		String[] rutaNiveles = new String[4];
				
		for ( i = 0; i < niveles.length; ++i ) {			
			
			rutaNiveles[i] = ("/simbolos/nivel" + (i + 1) + ".png");
			niveles[i] = new Picture(rutaNiveles[i]);
			niveles[i].translate(x, y);
			niveles[i].draw();
			
			x += 240;			
		}	
		
		Canvas c = Canvas.getInstance();
		
		boolean posicionNoValida = true;		
		
		do {			
			
			c.waitMouseClick();
			Point click = c.getMousePosition();
			
			for ( i = 0; i < niveles.length; ++i ) {
			
				if (click.x > niveles[i].getX() && click.y > niveles[i].getY() && 
					click.x < niveles[i].getWidth() + niveles[i].getX() && click.y < niveles[i].getHeight() + 
					niveles[i].getY()) {
					
					posicionNoValida = false;
					nivelElegido = i;
					i = niveles.length;					
				}			
			}
		
		} while (posicionNoValida);
		
		switch ( nivelElegido ) {
		
		case 0:
			numFiguras = 12;
			numFigurasPorFila = 4;
			break;
		case 1:
			numFiguras = 16;
			numFigurasPorFila = 4;
			break;
		case 2:
			numFiguras = 30;
			numFigurasPorFila = 5;
			break;
		case 3:
			numFiguras = 36;
			numFigurasPorFila = 6;
			break;
		}
		
		fondo.undraw();
		for ( i = 0; i < niveles.length; ++i ) {
			
			niveles[i].undraw();		
		}
		
	}//FIN METODO "CARGAR-MENU"
	
	
	//METODO "CARGAR-PANELES": CARGA EN PANTALLA LOS
	//PANELES DONDE SE REPRESENTAN LAS FIGURAS DE CADA
	//PARTIDA Y LOS MARCADORES
	
	public static void cargarPaneles() {
		
		final int ANCHOPANEL = 1000;
		final int ALTOPANEL = 646;		
		
		Rectangle panel = new Rectangle(0,0,ANCHOPANEL,ALTOPANEL);
		Color color = new Color(28,119,92);
		panel.setColor(color);
		panel.fill();
		
		Text parejas = new Text(700,50,"PAREJAS:");
		parejas.grow(40, 40);
		parejas.draw();
		
		Text tiempo = new Text(700,200,"TIEMPO:");
		tiempo.grow(40, 40);
		tiempo.draw();
		
		Text puntuacion = new Text(700,350,"PUNTOS:");
		puntuacion.grow(40, 40);
		puntuacion.draw();
		
		Color color2 = new Color(157,9,21);
		
		marcadorParejas.setColor(color2);
		marcadorParejas.grow(40, 40);
		marcadorParejas.draw();
		
		segundos.setColor(color2);
		segundos.grow(40, 40);
		segundos.draw();
		
		puntos.setColor(color2);
		puntos.grow(40, 40);
		puntos.draw();	
		
	}//FIN METODO "CARGAR-PANELES"
	
	
	
	//METODO "CARGAR-JUEGO": REPRESENTA LAS FIGURAS EN PANTALLA
	//Y SIGUE LA LOGICA GENERAL DEL JUEGO
	
	public static void cargarJuego() throws InterruptedException {
		
		//CONSTANTES EMPLEADAS
		
		final int ALTO = 96;
		final int ANCHO = 96;
		final int HUECO = 10;
		final int NUMFIGURASDISPONIBLES = 38;
		
		//FIGURAS ORIGINALES ELEGIDAS ALEATORIAMENTE 
		//DE ENTRE LAS DISPONIBLES (SIN REPETIR)
		
		int i, j;
		
		int[] figurasOriginales = new int[numFiguras/2];
		
		aleatoriosSinRepeticion(figurasOriginales, NUMFIGURASDISPONIBLES);
		
		//TOTAL FIGURAS A REPRESENTAR 
		//(LAS ORIGINALES REPETIDAS 2 VECES CADA UNA)
		//PARA FORMAR PAREJAS
		
		int[] figurasPlasmar = new int[numFiguras];
		
		for ( i = 0; i < figurasPlasmar.length / 2; ++i ) {
			
			figurasPlasmar[i] = figurasOriginales[i];
			figurasPlasmar[i + figurasPlasmar.length / 2] = figurasOriginales[i];
		}
		
		//ALTERAR EL ORDEN DE FIGURAS A REPRESENTAR ALEATORIAMENTE
		//PARA QUE LAS PAREJAS SE SITUEN EN POSICIONES
		//DISTINTAS EN CADA PARTIDA
		
		int[] ordenFiguras = new int[numFiguras];
		
		aleatoriosSinRepeticion(ordenFiguras, numFiguras);
		
		//FIGURAS ORDENADAS ALEATORIAMENTE APLICANDO EL ORDEN
		//ANTERIOR
		
		int[] figuras = new int[numFiguras];
		
		for ( i = 0; i < figuras.length; ++i ) {
			
			figuras[i] = figurasPlasmar[ordenFiguras[i]];			
		}
		
		//RUTA DE LOS ARCHIVOS DE LAS FIGURAS
		
		String[] rutaFiguras = new String[numFiguras];		
				
		for ( i = 0; i < rutaFiguras.length; ++i ) {			
			
			rutaFiguras[i] = ("/simbolos/" + Integer.toString(figuras[i]) + ".png");			
		}
		
		//DIBUJAR FIGURAS A PLASMAR
		
		int x = HUECO;
		int y = HUECO;
		
		Picture[] figurasJuego = new Picture[numFiguras];
		
		for ( i = 0; i < figurasJuego.length; ++i ) {
			
			figurasJuego[i] = new Picture(rutaFiguras[i]);
			
			if ( i != 0 && i % numFigurasPorFila == 0 ) {
				
				y += HUECO + ALTO;
				x = HUECO;
			}
			
			figurasJuego[i].translate(x, y);
			figurasJuego[i].draw();
			
			x += HUECO + ANCHO;
			
		}
		
		//DIBUJAR LAS TAPAS DE LAS FIGURAS ("RULETA")
		
		x = HUECO;
		y = HUECO;
		
		Picture[] tapasFiguras = new Picture[numFiguras];
		
		for ( i = 0; i < tapasFiguras.length; ++i ) {
			
			tapasFiguras[i] = new Picture("/simbolos/ruleta.png");
			
			if ( i != 0 && i % numFigurasPorFila == 0 ) {
				
				y += HUECO + ALTO;
				x = HUECO;
			}
			
			tapasFiguras[i].translate(x, y);
			tapasFiguras[i].draw();
			
			x += HUECO + ANCHO;
			
		}
		
		//DESARROLLO DEL JUEGO
		
		boolean[] destapada = new boolean[numFiguras];
		boolean pulsacionNoValida;
		int numDestapadas = 0;
		int numParejas = 0;
		int[] pulsacion = new int[2];
		int resultado;
	    long start = System.currentTimeMillis(); 
	    long intervalo;
	    
		Canvas c = Canvas.getInstance();
		
				
		do {						
				
			for ( j = 0; j < pulsacion.length; ++j ) {
				
				do {
					
					pulsacionNoValida = true;
					c.waitMouseClick();
					Point click = c.getMousePosition();					
			
						for ( i = 0; i < figurasJuego.length; ++i ) {
			
							if(click.x > figurasJuego[i].getX() && click.x < figurasJuego[i].getWidth() + figurasJuego[i].getX()
								&& click.y > figurasJuego[i].getY() && click.y < figurasJuego[i].getHeight() + figurasJuego[i].getY() 
								&& destapada[i] == false) {			
				
								pulsacionNoValida = false;								
								tapasFiguras[i].undraw();				
								destapada[i] = true;
								++numDestapadas;
								pulsacion[j] = i;						
								i = figurasJuego.length;	
							}				
						}
				
				} while (pulsacionNoValida);								
			}						
			
			if ( numDestapadas == 2 ) {
				
				if ( figuras[pulsacion[0]] == figuras[pulsacion[1]]  ) { //pareja encontrada	
					
					++numParejas;					
					cambiarMarcadorParejas(Integer.toString(numParejas) + " de " + Integer.toString(numFiguras/2));
					numDestapadas -= 2;	//las parejas descubiertas las considero tapadas				
				} 
				
				else {	//pareja no encontrada	
					
					Thread.sleep(1500);	//1,5 segundos y se vuelven a tapar las figuras					
					for ( i = 0; i < pulsacion.length; ++i ) {						
						tapasFiguras[pulsacion[i]].draw();
						destapada[pulsacion[i]] = false;
						--numDestapadas;					
					}					
				}
			}
			
		} while( numParejas < numFiguras / 2 );
		
		intervalo = (System.currentTimeMillis() - start)/1000;
		cambiarTiempo(Long.toString(intervalo) + " seg.");
		resultado = puntuacion(intervalo);
		cambiarPuntos(Long.toString(resultado));
		
		//FIGURAS PARA DAR LA OPCION DE JUGAR
		//OTRA PARTIDA
		
		mono.translate(800, 499);
		mono.draw();
		Thread.sleep(1000);
		bocadillo.translate(650, 420);
		bocadillo.draw();		
		
		pulsacionNoValida = true;		
		
		do {			
			
			c.waitMouseClick();
			Point click = c.getMousePosition();			
			
			if (click.x > bocadillo.getX() && click.y > bocadillo.getY() && 
				click.x < bocadillo.getWidth() + bocadillo.getX() && click.y < bocadillo.getHeight() + 
				bocadillo.getY()) {
					
				pulsacionNoValida = false;
					
			}		
		
		} while (pulsacionNoValida);
		
		resetear();
				
	} //FIN METODO "CARGAR-JUEGO"
	
	
	//METODO "ALEATORIOS-SIN-REPETICION": PARA NO REPETIR 
	//ELEMENTOS ALEATORIOS DE UNA MATRIZ DADA
		
	public static void aleatoriosSinRepeticion( int[] matriz, int constante ) {
			
		int i = 0;
		int j = 0;
			
		matriz[i] = (int)(Math.random()*(constante));
			
		for ( i = 1; i < matriz.length; ++i ) {
				
			matriz[i] = (int)(Math.random()*(constante));
				
			for ( j = 0; j < i; ++j ) {
					
				if ( matriz[j] == matriz[i] ) {
						
					--i;				
				}
			}
		}		
			
	}//FIN METODO "ALEATORIOS-SIN-REPETICION"
	
	
	//METODO "PUNTUACION": DEVUELVE LA PUNTUACION
	//OBTENIDA EN FUNCION DEL TIEMPO EMPLEADO Y DEL
	//NIVEL DE DIFICULTAD DE LA PARTIDA
		
	public static int puntuacion( long tiempo ) {
			
		int puntuacion = 0;
			
		switch ( nivelElegido ) {
			
		case 0:
				
			if ( tiempo > 90 ) puntuacion = 50;
			else if ( tiempo >= 70 && tiempo <= 90 ) puntuacion = 100;
			else if ( tiempo >= 30 && tiempo < 70 ) puntuacion = 500;
			else if ( tiempo >= 15 && tiempo < 30 ) puntuacion = 1000;
			else puntuacion = 5000;
			break;
				
		case 1:
				
			if ( tiempo > 120 ) puntuacion = 50;
			else if ( tiempo >= 80 && tiempo <= 120 ) puntuacion = 100;
			else if ( tiempo >= 60 && tiempo < 80 ) puntuacion = 500;
			else if ( tiempo >= 30 && tiempo < 60 ) puntuacion = 1000;
			else puntuacion = 5000;
			break;
				
		case 2:
				
			if ( tiempo > 195 ) puntuacion = 50;
			else if ( tiempo >= 155 && tiempo <= 195 ) puntuacion = 100;
			else if ( tiempo >= 135 && tiempo < 155 ) puntuacion = 500;
			else if ( tiempo >= 105 && tiempo < 135 ) puntuacion = 1000;
			else puntuacion = 5000;
			break;
				
		case 3:
				
			if ( tiempo > 240 ) puntuacion = 50;
			else if ( tiempo >= 200 && tiempo <= 240 ) puntuacion = 100;
			else if ( tiempo >= 180 && tiempo < 200 ) puntuacion = 500;
			else if ( tiempo >= 140 && tiempo < 180 ) puntuacion = 1000;
			else puntuacion = 5000;
			break;
		}		
			
		return puntuacion;
			
	}//FIN METODO "PUNTUACION"
	
	
	
	//METODO "CAMBIAR-MARCADOR-PAREJAS": ACTUALIZA EL
	//MARCADOR DE "PAREJAS"
	
	public static void cambiarMarcadorParejas( String marcador ) {
		
		marcadorParejas.setText(marcador);
		
	}//FIN METODO "CAMBIAR-MARCADOR-PAREJAS"
	
	
	//METODO "CAMBIAR-TIEMPO": ACTUALIZA EL TIEMPO EMPLEADO
	//EN ENCONTRAR TODAS LAS PAREJAS AL FINAL DE LA PARTIDA
	
	public static void cambiarTiempo( String tiempo ) {
		
		segundos.setText(tiempo);
		
	}//FIN METODO "CAMBIAR-TIEMPO"
	
	
	//METODO "CAMBIAR-PUNTOS": ACTUALIZA LA PUNTUACION
	//OBTENIDA AL FINAL DE LA PARTIDA
	
	public static void cambiarPuntos( String resultado ) {
		
		puntos.setText(resultado);	
		
	}//FIN METODO "CAMBIAR-PUNTOS"
	
	
	//METODO "RESETEAR": PARA RESTAURAR LO NECESARIO
	//A SUS VALORES INICIALES Y PODER ASI COMENZAR
	//UNA NUEVA PARTIDA
	
	public static void resetear() {
		
		segundos.undraw();
		segundos.grow(-40,-40);
		segundos.setText("");
		puntos.undraw();
		puntos.grow(-40,-40);
		puntos.setText("0");
		mono.undraw();
		mono.translate(-800, -499);
		bocadillo.undraw();
		bocadillo.translate(-650, -420);
		marcadorParejas.undraw();
		marcadorParejas.grow(-40,-40);
		marcadorParejas.setText("0");
		
	}	
	
	
	//METODO "MAIN": SE HACEN LAS LLAMADAS A LOS
	//DISTINTOS METODOS PRINCIPALES DEL PROGRAMA
	
	public static void main(String[] args) throws InterruptedException {
		
		while( true ) {
			
			cargarMenu();		
			cargarPaneles();
			cargarJuego();
		}

	}//FIN METODO "MAIN"

}//FIN CLASE "CASINO-MEMORY"
