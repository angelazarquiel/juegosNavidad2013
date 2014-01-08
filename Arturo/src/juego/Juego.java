package juego;

import java.awt.Point;

import graphics2.Canvas;
import graphics2.Color;
import graphics2.Rectangle;
import graphics2.Text;

public class Juego {

	public static void main(String[] args) {

		Rectangle cuadrado, teclas;
		Ahorcado ahorcado = new Ahorcado();
		Oculta oculta = null;
		
		Tecla[] keys = new Tecla [32];
		
		cuadrado = new Rectangle (10, 10, 1310, 830);
		cuadrado.setColor(Color.LIGHT_GRAY);
		cuadrado.fill();
		
		ahorcado = new Ahorcado();
		
		teclas = new Rectangle (135,485, 1060, 310);
		teclas.draw();
		
		Text opciones= new Text(320,435,"Pulse una de las opciones superiores. "
				+ "Cada vez que pulse generará una nueva palabra a adivinar. Tiene permitidos 6 fallos.");
		opciones.draw();
		
		Text creditos= new Text(470,810,"Arturo Díaz Calvo. 1º Desarrollo de aplicaciones web. Programación.");
		creditos.draw();
		
		int iKey = 0;
		keys[iKey]=new Tecla(515,50,Utilidades.RADIO_BOTON_ANCHO,Utilidades.RADIO_ALTO,"FUTBOLISTAS");
		
		iKey++;
		keys[iKey]=new Tecla(690,50,Utilidades.RADIO_BOTON_ANCHO,Utilidades.RADIO_ALTO,"CAP. DE PROVINCIA");
		
		iKey++;
		keys[iKey]=new Tecla(865,50,Utilidades.RADIO_BOTON_ANCHO,Utilidades.RADIO_ALTO,"PELICULAS");
		
		iKey++;
		keys[iKey]=new Tecla(1040,50,Utilidades.RADIO_BOTON_ANCHO,Utilidades.RADIO_ALTO,"ALEATORIO");
		
		iKey++;
		keys[iKey]=new Tecla(145,495,Utilidades.RADIO_TECLA_ANCHO,Utilidades.RADIO_ALTO,"Q");
		
		iKey++;
		keys[iKey]=new Tecla(245,495,Utilidades.RADIO_TECLA_ANCHO,Utilidades.RADIO_ALTO,"W");
		
		iKey++;
		keys[iKey]=new Tecla(345,495,Utilidades.RADIO_TECLA_ANCHO,Utilidades.RADIO_ALTO,"E");
		
		iKey++;
		keys[iKey]=new Tecla(445,495,Utilidades.RADIO_TECLA_ANCHO,Utilidades.RADIO_ALTO,"R");
		
		iKey++;
		keys[iKey]=new Tecla(545,495,Utilidades.RADIO_TECLA_ANCHO,Utilidades.RADIO_ALTO,"T");
		
		iKey++;
		keys[iKey]=new Tecla(645,495,Utilidades.RADIO_TECLA_ANCHO,Utilidades.RADIO_ALTO,"Y");
		
		iKey++;
		keys[iKey]=new Tecla(745,495,Utilidades.RADIO_TECLA_ANCHO,Utilidades.RADIO_ALTO,"U");
		
		iKey++;
		keys[iKey]=new Tecla(845,495,Utilidades.RADIO_TECLA_ANCHO,Utilidades.RADIO_ALTO,"I");
		
		iKey++;
		keys[iKey]=new Tecla(945,495,Utilidades.RADIO_TECLA_ANCHO,Utilidades.RADIO_ALTO,"O");
		
		iKey++;
		keys[iKey]=new Tecla(1045,495,Utilidades.RADIO_TECLA_ANCHO,Utilidades.RADIO_ALTO,"P");
		
		iKey++;
		keys[iKey]=new Tecla(195,595,Utilidades.RADIO_TECLA_ANCHO,Utilidades.RADIO_ALTO,"A");
		
		iKey++;
		keys[iKey]=new Tecla(295,595,Utilidades.RADIO_TECLA_ANCHO,Utilidades.RADIO_ALTO,"S");
		
		iKey++;
		keys[iKey]=new Tecla(395,595,Utilidades.RADIO_TECLA_ANCHO,Utilidades.RADIO_ALTO,"D");
		
		iKey++;
		keys[iKey]=new Tecla(495,595,Utilidades.RADIO_TECLA_ANCHO,Utilidades.RADIO_ALTO,"F");
		
		iKey++;
		keys[iKey]=new Tecla(595,595,Utilidades.RADIO_TECLA_ANCHO,Utilidades.RADIO_ALTO,"G");
		
		iKey++;
		keys[iKey]=new Tecla(695,595,Utilidades.RADIO_TECLA_ANCHO,Utilidades.RADIO_ALTO,"H");
		
		iKey++;
		keys[iKey]=new Tecla(795,595,Utilidades.RADIO_TECLA_ANCHO,Utilidades.RADIO_ALTO,"J");
		
		iKey++;
		keys[iKey]=new Tecla(895,595,Utilidades.RADIO_TECLA_ANCHO,Utilidades.RADIO_ALTO,"K");
		
		iKey++;
		keys[iKey]=new Tecla(995,595,Utilidades.RADIO_TECLA_ANCHO,Utilidades.RADIO_ALTO,"L");
		
		iKey++;
		keys[iKey]=new Tecla(1095,595,Utilidades.RADIO_TECLA_ANCHO,Utilidades.RADIO_ALTO,"Ñ");
		
		iKey++;
		keys[iKey]=new Tecla(245,695,Utilidades.RADIO_TECLA_ANCHO,Utilidades.RADIO_ALTO,"Z");
		
		iKey++;
		keys[iKey]=new Tecla(345,695,Utilidades.RADIO_TECLA_ANCHO,Utilidades.RADIO_ALTO,"X");
		
		iKey++;
		keys[iKey]=new Tecla(445,695,Utilidades.RADIO_TECLA_ANCHO,Utilidades.RADIO_ALTO,"C");
		
		iKey++;
		keys[iKey]=new Tecla(545,695,Utilidades.RADIO_TECLA_ANCHO,Utilidades.RADIO_ALTO,"V");
		
		iKey++;
		keys[iKey]=new Tecla(645,695,Utilidades.RADIO_TECLA_ANCHO,Utilidades.RADIO_ALTO,"B");
		
		iKey++;
		keys[iKey]=new Tecla(745,695,Utilidades.RADIO_TECLA_ANCHO,Utilidades.RADIO_ALTO,"N");
		
		iKey++;
		keys[iKey]=new Tecla(845,695,Utilidades.RADIO_TECLA_ANCHO,Utilidades.RADIO_ALTO,"M");
		
		iKey++;
		keys[iKey]=new Tecla(945,695,Utilidades.RADIO_BOTON_ANCHO,Utilidades.RADIO_ALTO,"SALIR");
		
		for (iKey=0;iKey<32;iKey++){
			keys[iKey].dibuja(null);
		}
		
		
		Tecla ganastePerdiste = new Tecla(740,320,Utilidades.RADIO_BOTON_ANCHO,Utilidades.RADIO_ALTO,"GANASTE");
		/*ganastePerdiste.setLetra("PERDISTE");*/
		
		String letrasPulsadas = "";
		boolean fin = false;
				
		Canvas c;
		c=Canvas.getInstance();
		c.waitMouseClick(); // es una línea: Canvas.getInstance().waitMouseClick();
		

		while(true){
			Point pulsacion = c.waitMouseClick(); //requiere import java.awt.Point;
			//System.out.println("Has pulsado en: (" + pulsacion.x + "," + pulsacion.y + ")");
			boolean teclaEncontrada = false;
			iKey=0;
			while(iKey<32 &&!teclaEncontrada){
				teclaEncontrada = keys[iKey].esPulsada(pulsacion.x,pulsacion.y);
				if (teclaEncontrada){
					String palabra;
					switch (keys[iKey].getLetra()) {
					/*
					 * 	intervalo = (System.currentTimeMillis() - start)/1000;
						System.out.println("LLevas " + intervalo + " segundos jugados.");
					 */
					case "FUTBOLISTAS":
						ahorcado = new Ahorcado();
						for (iKey=0;iKey<32;iKey++){
							keys[iKey].dibuja(null);
						}
						keys[0].cambiaColor(Color.GREEN);
						keys[1].cambiaColor(Color.RED);
						keys[2].cambiaColor(Color.RED);
						keys[3].cambiaColor(Color.RED);
						palabra = Utilidades.nuevaPalabra(Palabras.futbol);
						//System.out.println(palabra + " " + palabra.length());
						oculta = new Oculta(palabra);
						fin = false;
						letrasPulsadas = "";
						break;
						
					case "CAP. DE PROVINCIA":
						ahorcado = new Ahorcado();
						for (iKey=0;iKey<32;iKey++){
							keys[iKey].dibuja(null);
						}
						keys[0].cambiaColor(Color.RED);
						keys[1].cambiaColor(Color.GREEN);
						keys[2].cambiaColor(Color.RED);
						keys[3].cambiaColor(Color.RED);
						palabra = Utilidades.nuevaPalabra(Palabras.ciudad);
						//System.out.println(palabra + " " + palabra.length());
						oculta = new Oculta(palabra);
						fin = false;
						letrasPulsadas = "";
						
						break;
						
					case "PELICULAS":
						ahorcado = new Ahorcado();
						for (iKey=0;iKey<32;iKey++){
							keys[iKey].dibuja(null);
						}
						keys[0].cambiaColor(Color.RED);
						keys[1].cambiaColor(Color.RED);
						keys[2].cambiaColor(Color.GREEN);
						keys[3].cambiaColor(Color.RED);
						palabra = Utilidades.nuevaPalabra(Palabras.pelis);
						//System.out.println(palabra + " " + palabra.length());
						oculta = new Oculta(palabra);
						fin = false;
						letrasPulsadas = "";
						
						break;
						
					case "ALEATORIO":
						ahorcado = new Ahorcado();
						for (iKey=0;iKey<32;iKey++){
							keys[iKey].dibuja(null);
						}
						keys[0].cambiaColor(Color.RED);
						keys[1].cambiaColor(Color.RED);
						keys[2].cambiaColor(Color.RED);
						keys[3].cambiaColor(Color.GREEN);
						palabra = Utilidades.nuevaPalabra(Palabras.aleato);
						//System.out.println(palabra + " " + palabra.length());
						oculta = new Oculta(palabra);
						fin = false;
						letrasPulsadas = "";
						
						break;
						
					case "SALIR":
						System.exit(0);

						break;

					default:
						if(oculta!=null && !fin){
							if (!letrasPulsadas.contains(keys[iKey].getLetra())){
								letrasPulsadas += keys[iKey].getLetra();
								if(oculta.contieneLetra(keys[iKey].getLetra())){
									keys[iKey].cambiaColor(Color.GREEN);
									fin = oculta.muestraLetra(keys[iKey].getLetra());
									if (fin){
										ganastePerdiste.setLetra("GANASTE");
										ganastePerdiste.dibuja(Color.GREEN);
									}
								}else{
									keys[iKey].cambiaColor(Color.RED);
									fin = ahorcado.dibujaSiguiente();
									if (fin){
										ganastePerdiste.setLetra("PERDISTE");
										ganastePerdiste.dibuja(Color.RED);
										oculta.muestraPalabra();
									}
								}							
							}
							
						}
						break;
					}
				}
				iKey++;
			}
		}
	}

}
