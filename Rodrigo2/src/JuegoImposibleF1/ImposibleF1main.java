package JuegoImposibleF1;

import java.awt.Point;

import javax.swing.JOptionPane;

import graphics2.Canvas;
import graphics2.Color;
import graphics2.Picture;
import graphics2.Rectangle;


public class ImposibleF1main {

	

	public static void main(String[] args) throws InterruptedException {

		Rectangle pantalla;
		pantalla = new Rectangle(50, 50, 750, 750);
		pantalla.setThickness(75);
		pantalla.setColor(Color.BLACK);
		pantalla.draw();

		Picture fondo;
		fondo = new Picture();
		fondo.load("FondoImposibleF1.jpg");
		fondo.draw();	
		
		Rectangle enemigo1;
		Rectangle enemigo2;
		Rectangle enemigo3;
		Rectangle enemigo4;
		
		enemigo1 = new Rectangle(125, 125, 95, 95);
		enemigo1.setColor(Color.BLACK);
		enemigo1.fill();

		enemigo2 = new Rectangle(615, 125, 110, 60);
		enemigo2.setColor(Color.BLACK);
		enemigo2.fill();

		enemigo3 = new Rectangle(125, 620, 60, 110);
		enemigo3.setColor(Color.BLACK);
		enemigo3.fill();

		enemigo4 = new Rectangle(555, 685, 170, 40);
		enemigo4.setColor(Color.BLACK);
		enemigo4.fill();

		Rectangle jugador = new Rectangle(375, 375, 70, 70);
		jugador.setColor(Color.RED);
		jugador.fill();

		Canvas c;
		c = Canvas.getInstance();
		Point pulsacion = c.getMousePosition();
		jugador.undraw();

		Canvas.pause();
		
		int movimiento_x1 = 5;
		int movimiento_y1 = 7;
		
		int movimiento_x2 = -7;
		int movimiento_y2 = 5;
		
		int movimiento_x3 = -5;
		int movimiento_y3 = -7;
		
		int movimiento_x4 = 5;
		int movimiento_y4 = 6;

		
		long start = System.currentTimeMillis();
		
		int n = 20;
		int aumentarVelocidad = 0;
		int velocidad = 10;
		boolean finJuego = false;
		
		
		do {
			if (!(pulsacion.x<730 && pulsacion.y<730 && pulsacion.x>120 && pulsacion.y>120)){
				finJuego=true;
			}
			
			
			jugador.undraw();
			jugador = new Rectangle(pulsacion.x - 35, pulsacion.y - 35, 70, 70);
			jugador.setColor(Color.RED);
			jugador.fill();
			
			if (aumentarVelocidad==velocidad){
				n-=3;
				aumentarVelocidad=0;
				velocidad += 10;
			}
			
		    Thread.sleep(5);

			enemigo1.translate(movimiento_x1, movimiento_y1);
			if (((enemigo1.getX() + 50) >= 725 || enemigo1.getX() <= 75)) {
				movimiento_x1 = -movimiento_x1;
				if (n > 5)
					aumentarVelocidad++;
					
			}
			if ((enemigo1.getY() + 50) >= 725 || enemigo1.getY() <= 75) {
				movimiento_y1 = -movimiento_y1;
				if (n > 5)
					aumentarVelocidad++;
			}
		
			enemigo2.translate(movimiento_x2, movimiento_y2);
			if (((enemigo2.getX() + 70) >= 725 || enemigo2.getX() <= 80)) {
				movimiento_x2 = -movimiento_x2;
				if (n > 5)
					aumentarVelocidad++;
			}
			if ((enemigo2.getY() + 20) >= 725 || enemigo2.getY() <= 80) {
				movimiento_y2 = -movimiento_y2;
				if (n > 5)
					aumentarVelocidad++;
			}
		
			enemigo3.translate(movimiento_x3, movimiento_y3);
			if (((enemigo3.getX() + 20) >= 725 || enemigo3.getX() <= 70)) {
				movimiento_x3 = -movimiento_x3;
				if (n > 5)
					aumentarVelocidad++;
			}
			if ((enemigo3.getY() + 70) >= 725 || enemigo3.getY() <= 85) {
				movimiento_y3 = -movimiento_y3;
				if (n > 5)
					aumentarVelocidad++;
			}
	
			enemigo4.translate(movimiento_x4, movimiento_y4);
			if (((enemigo4.getX() + 130) >= 725 || enemigo4.getX() <= 85)) {
				movimiento_x4 = -movimiento_x4;
				if (n > 5)
					aumentarVelocidad++;
			}
			if ((enemigo4.getY() + 0) >= 725 || enemigo4.getY() <= 85) {
				movimiento_y4 = -movimiento_y4;
				if (n > 5)
					aumentarVelocidad++;
			}
			Thread.sleep((long) n);
			
			
			if((enemigo1.getX() + 95) >= (jugador.getX()+70) || (enemigo1.getY() + 95) == (jugador.getY()+70)){
				finJuego=true;
			}
			
			}while ((pulsacion.x<730 && pulsacion.y<730 && pulsacion.x>120 && pulsacion.y>120));
		
		if(finJuego==true){
			long tiempoJugado = (System.currentTimeMillis() - start)/1000;
/*
			Text tiempo = new Text(125,125,"ENHORABUENA, has conseguido aguantar " + tiempoJugado + " segundos.");
			tiempo.draw();
			System.out.println("ENHORABUENA, has conseguido aguantar " + tiempoJugado + " segundos.");
*/
			JOptionPane.showMessageDialog(null, "ENHORABUENA, has conseguido aguantar " + tiempoJugado + " segundos.");
			
		}
		
		
		 
	}
}