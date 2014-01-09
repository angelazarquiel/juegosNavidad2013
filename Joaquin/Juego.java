package tresenraya;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import graphics2.Canvas;
import graphics2.Color;
import graphics2.Ellipse;
import graphics2.Line;
import graphics2.Text;

public class Juego {

	
	public static void main(String[] args) throws InterruptedException{
		
		dibujarTablero();
		int numero=sorteo();
		System.out.println(numero);
		Text texto=new Text(40,40,mensajeSorteo(numero));
		texto.draw();
		Thread.sleep(3000);
		texto.undraw();
		juego(numero);
		}
	
//metodo del funcionamiento del juego
	
	public static void juego(int numero)throws InterruptedException{
		List MovHumano=new ArrayList();
		List MovOrdenador=new ArrayList();
		List PosJugadas=new ArrayList();
		int jugada;
		int jugadas=0;
		//juego empezando el ordenador si el sorteo es 0
		if (numero==0){
			do{
				//juega el ordenador
				int posicion=(int)(Math.random()*9+1);
				//comprueba que no se haya usado ese movimiento
				while(PosJugadas.contains(posicion)){
					posicion=(int)(Math.random()*9+1);
					}
				posicionOrdenador(posicion);
				PosJugadas.add(posicion);
				MovOrdenador.add(posicion);
				jugadas++;
				//comprobar si se da alguna combinacion ganadora
				if(MovOrdenador.contains(1)&&MovOrdenador.contains(2)&&MovOrdenador.contains(3)
				||MovOrdenador.contains(4)&&MovOrdenador.contains(5)&&MovOrdenador.contains(6)
				||MovOrdenador.contains(7)&&MovOrdenador.contains(8)&&MovOrdenador.contains(9)		
				||MovOrdenador.contains(1)&&MovOrdenador.contains(4)&&MovOrdenador.contains(7)		
				||MovOrdenador.contains(2)&&MovOrdenador.contains(5)&&MovOrdenador.contains(8)		
				||MovOrdenador.contains(3)&&MovOrdenador.contains(6)&&MovOrdenador.contains(9)
				||MovOrdenador.contains(1)&&MovOrdenador.contains(5)&&MovOrdenador.contains(9)	
				||MovOrdenador.contains(3)&&MovOrdenador.contains(5)&&MovOrdenador.contains(7)	
				){	System.out.println("GANA EL ORDENADOR");
				Text texto=new Text(100,100,"GANA EL ORDENADOR");
				texto.draw();
				Thread.sleep(10000);
				System.exit(0);
				}
		//juega humano
					if(jugadas<9){
					/*Scanner teclado = new Scanner(System.in);
					System.out.println("Elige jugada: ");
					int jugada=teclado.nextInt();*/
					jugada=coord();
		
					while(PosJugadas.contains(jugada)){
							System.out.println("Jugada repetida. Elige otra jugada: ");
							//jugada=teclado.nextInt();
							jugada=coord();
							}
							
					posicionHumano(jugada);
					Thread.sleep(1000);
					PosJugadas.add(jugada);
					MovHumano.add(jugada);
					jugadas++;
					
					if(MovHumano.contains(1)&&MovHumano.contains(2)&&MovHumano.contains(3)
					||MovHumano.contains(4)&&MovHumano.contains(5)&&MovHumano.contains(6)
					||MovHumano.contains(7)&&MovHumano.contains(8)&&MovHumano.contains(9)		
					||MovHumano.contains(1)&&MovHumano.contains(4)&&MovHumano.contains(7)		
					||MovHumano.contains(2)&&MovHumano.contains(5)&&MovHumano.contains(8)		
					||MovHumano.contains(3)&&MovHumano.contains(6)&&MovHumano.contains(9)
					||MovHumano.contains(1)&&MovHumano.contains(5)&&MovHumano.contains(9)	
					||MovHumano.contains(3)&&MovHumano.contains(5)&&MovHumano.contains(7)	
					){
					System.out.println("GANAS TÚ");
					Text texto=new Text(100,100,"GANAS TÚ");
					texto.draw();
					Thread.sleep(10000);
					System.exit(0);
							}
					}
			}while (jugadas<9);
			
			//System.out.println("jugadas ya "+jugadas);
			System.out.println("TABLAS");
			Text texto=new Text(100,100,"TABLAS");
			texto.draw();
			Thread.sleep(10000);
			System.exit(0);
		}
		//juego empezando el humano si el sorteo es 1
		else if (numero==1){
			do{
				//juega humano
				/*Scanner teclado = new Scanner(System.in);
				System.out.println("Elige jugada: ");
				int jugada=teclado.nextInt();*/
				jugada=coord();
				while(PosJugadas.contains(jugada)){
					System.out.println("Jugada repetida. Elige otra jugada: ");
					jugada=coord();
					//jugada=teclado.nextInt();
					}
							
					posicionHumano(jugada);
					Thread.sleep(1000);
					PosJugadas.add(jugada);
					MovHumano.add(jugada);
					jugadas++;
					if(MovHumano.contains(1)&&MovHumano.contains(2)&&MovHumano.contains(3)
							||MovHumano.contains(4)&&MovHumano.contains(5)&&MovHumano.contains(6)
							||MovHumano.contains(7)&&MovHumano.contains(8)&&MovHumano.contains(9)		
							||MovHumano.contains(1)&&MovHumano.contains(4)&&MovHumano.contains(7)		
							||MovHumano.contains(2)&&MovHumano.contains(5)&&MovHumano.contains(8)		
							||MovHumano.contains(3)&&MovHumano.contains(6)&&MovHumano.contains(9)
							||MovHumano.contains(1)&&MovHumano.contains(5)&&MovHumano.contains(9)	
							||MovHumano.contains(3)&&MovHumano.contains(5)&&MovHumano.contains(7)	
							){
								System.out.println("GANAS TÚ");
								Text texto=new Text(100,100,"GANAS TÚ");
								texto.draw();
								Thread.sleep(10000);
								System.exit(0);
								}
					//juega ordenador
					if(jugadas<9){
						int posicion=(int)(Math.random()*9+1);
						while(PosJugadas.contains(posicion)){
						//System.out.println("Repetida. ordenador elige otra ");
						posicion=(int)(Math.random()*9+1);
						}
					posicionOrdenador(posicion);
					PosJugadas.add(posicion);
					MovOrdenador.add(posicion);
					jugadas++;
					if(MovOrdenador.contains(1)&&MovOrdenador.contains(2)&&MovOrdenador.contains(3)
							||MovOrdenador.contains(4)&&MovOrdenador.contains(5)&&MovOrdenador.contains(6)
							||MovOrdenador.contains(7)&&MovOrdenador.contains(8)&&MovOrdenador.contains(9)		
							||MovOrdenador.contains(1)&&MovOrdenador.contains(4)&&MovOrdenador.contains(7)		
							||MovOrdenador.contains(2)&&MovOrdenador.contains(5)&&MovOrdenador.contains(8)		
							||MovOrdenador.contains(3)&&MovOrdenador.contains(6)&&MovOrdenador.contains(9)
							||MovOrdenador.contains(1)&&MovOrdenador.contains(5)&&MovOrdenador.contains(9)	
							||MovOrdenador.contains(3)&&MovOrdenador.contains(5)&&MovOrdenador.contains(7)	
							){
								System.out.println("GANA EL ORDENADOR");
								Text texto=new Text(100,100,"GANA EL ORDENADOR");
								texto.draw();
								Thread.sleep(10000);
								System.exit(0);
							}
					}
		}while(jugadas<9);
			
			//System.out.println("jugadas ya "+jugadas);
			System.out.println("TABLAS");
			Text texto=new Text(100,100,"TABLAS");
			texto.draw();
			Thread.sleep(10000);
			System.exit(0);
			}
	}
	
	
	//metodo para dibujar un tablero con 9 casillas
	public static void dibujarTablero(){
		int w = 150,x = 150,y = 150,z = 600;
		
		Line linea=new Line(w,x,y,z);
		Color color=new Color(0,0,0);
		linea.setColor(color);
		linea.draw();
		
		for (int i=0;i<3;i++){
			w=w+150;
			y=y+150;
			linea=new Line(w,x,y,z);
			linea.setColor(color);
			linea.draw();
		}
	
		int a = 150,b = 150,c = 600,d = 150;
		Line linea2=new Line(a,b,c,d);
		linea2.setColor(color);
		linea2.draw();
		
		for (int i=0;i<3;i++){
			b=b+150;
			d=d+150;
			linea2=new Line(a,b,c,d);
			linea2.setColor(color);
			linea2.draw();
		}
	}
	//metodo para ver si empieza el humano o el ordenador
	
		public static int sorteo(){
			int numero=(int)(Math.random()*2);
			return numero;	
		}
		
	//mensaje de inicio de partida
		public static String mensajeSorteo(int numero){
			String mensaje="";
			if (numero==1){
				mensaje="Empiezas tú";
			}
			else{
				mensaje="Empieza el ordenador";
			}
			return mensaje;
		}
	
	//pintar jugada ordenador verde
		public static void posicionOrdenador(int posicion){
			if (posicion==1){
				Ellipse circulo=new Ellipse(200,200,50,50);
				circulo.setColor(Color.GREEN);
				circulo.draw();
				circulo.fill();
			}
			if (posicion==2){
				Ellipse circulo=new Ellipse(350,200,50,50);
				circulo.setColor(Color.GREEN);
				circulo.draw();
				circulo.fill();
			}
			if (posicion==3){
				Ellipse circulo=new Ellipse(500,200,50,50);
				circulo.setColor(Color.GREEN);
				circulo.draw();
				circulo.fill();
			}
			if (posicion==4){
				Ellipse circulo=new Ellipse(200,350,50,50);
				circulo.setColor(Color.GREEN);
				circulo.draw();
				circulo.fill();
			}
			if (posicion==5){
				Ellipse circulo=new Ellipse(350,350,50,50);
				circulo.setColor(Color.GREEN);
				circulo.draw();
				circulo.fill();
			}
			if (posicion==6){
				Ellipse circulo=new Ellipse(500,350,50,50);
				circulo.setColor(Color.GREEN);
				circulo.draw();
				circulo.fill();
			}
			if (posicion==7){
				Ellipse circulo=new Ellipse(200,500,50,50);
				circulo.setColor(Color.GREEN);
				circulo.draw();
				circulo.fill();
			}
			if (posicion==8){
				Ellipse circulo=new Ellipse(350,500,50,50);
				circulo.setColor(Color.GREEN);
				circulo.draw();
				circulo.fill();
			}
			if (posicion==9){
				Ellipse circulo=new Ellipse(500,500,50,50);
				circulo.setColor(Color.GREEN);
				circulo.draw();
				circulo.fill();
			}
		}
		
		//pintar jugada humano rojo
				public static void posicionHumano(int posicion){
					if (posicion==1){
						Ellipse circulo=new Ellipse(200,200,50,50);
						circulo.setColor(Color.RED);
						circulo.draw();
						circulo.fill();
					}
					if (posicion==2){
						Ellipse circulo=new Ellipse(350,200,50,50);
						circulo.setColor(Color.RED);
						circulo.draw();
						circulo.fill();
					}
					if (posicion==3){
						Ellipse circulo=new Ellipse(500,200,50,50);
						circulo.setColor(Color.RED);
						circulo.draw();
						circulo.fill();
					}
					if (posicion==4){
						Ellipse circulo=new Ellipse(200,350,50,50);
						circulo.setColor(Color.RED);
						circulo.draw();
						circulo.fill();
					}
					if (posicion==5){
						Ellipse circulo=new Ellipse(350,350,50,50);
						circulo.setColor(Color.RED);
						circulo.draw();
						circulo.fill();
					}
					if (posicion==6){
						Ellipse circulo=new Ellipse(500,350,50,50);
						circulo.setColor(Color.RED);
						circulo.draw();
						circulo.fill();
					}
					if (posicion==7){
						Ellipse circulo=new Ellipse(200,500,50,50);
						circulo.setColor(Color.RED);
						circulo.draw();
						circulo.fill();
					}
					if (posicion==8){
						Ellipse circulo=new Ellipse(350,500,50,50);
						circulo.setColor(Color.RED);
						circulo.draw();
						circulo.fill();
					}
					if (posicion==9){
						Ellipse circulo=new Ellipse(500,500,50,50);
						circulo.setColor(Color.RED);
						circulo.draw();
						circulo.fill();
					}
				}
				
	//metodo para pinchar con el ratón en casilla y de acuerdo a las coordenas devuelva la casilla de la jugada del humano
	public static  int coord(){
		int jugada = 0;
		Canvas c;
		c=Canvas.getInstance();
		Point pulsation=c.waitMouseClick();
		if((pulsation.x>=150&&pulsation.x<=299) && (pulsation.y>=150&&pulsation.y<=299)){
			System.out.println("Has pulsado en: "+pulsation.x+"-"+pulsation.y);
			jugada=1;
			}
		else if((pulsation.x>=300&&pulsation.x<=449) && (pulsation.y>=150&&pulsation.y<=299)){
			System.out.println("Has pulsado en: "+pulsation.x+"-"+pulsation.y);
			jugada=2;
				}
		else if((pulsation.x>=450&&pulsation.x<=600) && (pulsation.y>=150&&pulsation.y<=299)){
			System.out.println("Has pulsado en: "+pulsation.x+"-"+pulsation.y);
			jugada=3;
				}
		else if((pulsation.x>=150&&pulsation.x<=299) && (pulsation.y>=300&&pulsation.y<=449)){
			System.out.println("Has pulsado en: "+pulsation.x+"-"+pulsation.y);
			jugada=4;
				}
		else if((pulsation.x>=300&&pulsation.x<=449) && (pulsation.y>=300&&pulsation.y<=449)){
			System.out.println("Has pulsado en: "+pulsation.x+"-"+pulsation.y);
			jugada=5;
				}
		else if((pulsation.x>=450&&pulsation.x<=600) && (pulsation.y>=300&&pulsation.y<=449)){
			System.out.println("Has pulsado en: "+pulsation.x+"-"+pulsation.y);
			jugada=6;
				}
		else if((pulsation.x>=150&&pulsation.x<=299) && (pulsation.y>=450&&pulsation.y<=600)){
			System.out.println("Has pulsado en: "+pulsation.x+"-"+pulsation.y);
			jugada=7;
				}
		else if((pulsation.x>=300&&pulsation.x<=449) && (pulsation.y>=450&&pulsation.y<=600)){
			System.out.println("Has pulsado en: "+pulsation.x+"-"+pulsation.y);
			jugada=8;
				}
		else if((pulsation.x>=450&&pulsation.x<=600) && (pulsation.y>=450&&pulsation.y<=600)){
			System.out.println("Has pulsado en: "+pulsation.x+"-"+pulsation.y);
			jugada=9;
				}
		return jugada;
	
	}
}
