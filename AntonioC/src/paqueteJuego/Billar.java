package paqueteJuego;

import graphics2.*;

public class Billar {

	public static void main(String[] args) throws InterruptedException {
		

		int tamañopelota = 20, movx = (int) (Math.random() * 4 + 1), movy = (int) (Math.random() * 3 + 2);

		int minx = 300, miny = 50, max = 400, maxy = 550;
		

		double movx2 = (Math.random() * 5), movy2 = (Math.random() * 3 + 2);
		double movx3 = (Math.random() * 4 + 1), movy3 = (Math.random() * 3 + 2);
		double movx4 = (Math.random() * 4 + 1), movy4 = (Math.random() * 3 + 2);
		double movx5 = (Math.random() * 4 + 1), movy5 = (Math.random() * 3 + 2);
		double movx6 = (Math.random() * 4 + 1), movy6 = (Math.random() * 3 + 2);
		double movx7 = (Math.random() * 4 + 1), movy7 = (Math.random() * 3 + 2);
		double movx8 = (Math.random() * 4 + 1), movy8 = (Math.random() * 3 + 2);
		//double movx9 = (Math.random() * 4 + 1), movy9 = (Math.random() * 3 + 2);

		//Color color = new Color(51, 152, 96);
		//Color color2 = new Color(53, 94, 59);
		Color color3 = new Color(150, 75, 0);

		
		
		
		Picture pic = new Picture("src/images/suelo5.png");
		pic.translate(0, 0);
		pic.draw();

		Picture billar = new Picture("src/images/tablero7.png");
		billar.translate(minx - 30, miny - 30);
		billar.draw();

		Picture win = new Picture("src/images/win.jpg");
		win.translate(0, 0);

		Picture botellas = new Picture("src/images/botellas3.png");
		botellas.translate(50, 25);
		botellas.draw();

		Picture botellas2 = new Picture("src/images/botellas3.png");
		botellas2.translate(max + minx + 50, 25);
		botellas2.draw();

		Picture botellas3 = new Picture("src/images/botellas3.png");
		botellas3.translate(50, maxy / 2 + 30);
		botellas3.draw();

		Picture botellas4 = new Picture("src/images/botellas3.png");
		botellas4.translate(max + minx + 50, maxy / 2 + 30);
		botellas4.draw();

		
		
		/*
		 * Rectangle fondo = new Rectangle(minx,miny,max,maxy); fondo.draw();
		 * fondo.setColor(color); fondo.fill();
		 */

		Ellipse pelota1 = new Ellipse((max / 2) + minx - 20, miny + 50,
				tamañopelota, tamañopelota);
		pelota1.draw();
		pelota1.setColor(Color.ORANGE);
		pelota1.fill();

		Ellipse pelota2 = new Ellipse((max / 2) + minx + 10, miny + 70,
				tamañopelota, tamañopelota);
		pelota2.draw();
		pelota2.setColor(Color.RED);
		pelota2.fill();

		Ellipse pelota3 = new Ellipse((max / 2) + minx - 10, miny + 70,
				tamañopelota, tamañopelota);
		pelota3.draw();
		pelota3.setColor(Color.RED);
		pelota3.fill();

		Ellipse pelota4 = new Ellipse((max / 2) + minx, miny + 90,
				tamañopelota, tamañopelota);
		pelota4.draw();
		pelota4.setColor(Color.RED);
		pelota4.fill();

		Ellipse pelota5 = new Ellipse((max / 2) + minx, miny + 50,
				tamañopelota, tamañopelota);
		pelota5.draw();
		pelota5.setColor(Color.ORANGE);
		pelota5.fill();

		Ellipse pelota6 = new Ellipse(((max / 2) + minx) + 20, miny + 50,
				tamañopelota, tamañopelota);
		pelota6.draw();
		pelota6.setColor(Color.ORANGE);
		pelota6.fill();

		Ellipse pelota7 = new Ellipse((max / 2) + minx, miny + 70,
				tamañopelota, tamañopelota);
		pelota7.draw();
		pelota7.setColor(Color.BLACK);
		pelota7.fill();

		Ellipse pelota71 = new Ellipse(((max / 2) + minx) + 5, miny + 75,
				tamañopelota - 10, tamañopelota - 10);
		pelota71.draw();
		pelota71.setColor(Color.WHITE);
		pelota71.fill();

		Text ocho = new Text(((max / 2) + minx) + 7, miny + 72, "8");
		ocho.draw();

		Ellipse pelota8 = new Ellipse((max / 2) + minx, miny + 400,
				tamañopelota - 5, tamañopelota - 5);
		pelota8.draw();
		pelota8.setColor(Color.WHITE);
		pelota8.fill();

		Rectangle palo = new Rectangle(((max / 2) + minx) + 5, 475, 5, 150);
		palo.draw();
		palo.setColor(color3);
		palo.fill();
		Rectangle ppalo = new Rectangle(((max / 2) + minx) + 5, 465, 5, 15);
		ppalo.draw();
		ppalo.setColor(Color.BLACK);
		ppalo.fill();

		
		Text instrucciones = new Text(max / 2 + minx-40, miny*4,"Instrucciones:");
		instrucciones.draw();
		instrucciones.setColor(Color.ORANGE);
		
		Text instrucciones2 = new Text(max / 2 + minx-50, miny*4+20,"1-Pulsar el mouse");
		instrucciones2.draw();
		instrucciones2.setColor(Color.ORANGE);
		
		Text instrucciones3 = new Text(max / 2 + minx-60, miny*4+40,"2-Esperar a que las bolas entren");
		instrucciones3.draw();
		instrucciones3.setColor(Color.ORANGE);

		

			//Canvas c;
			Canvas.getInstance().waitMouseClick();
			instrucciones.undraw();
			instrucciones2.undraw();
			instrucciones3.undraw();

			for (int i = 0; i < 10; i++) {

				Thread.sleep(10);
				palo.translate(0, -5);
				ppalo.translate(0, -5);
			}

			for (int i = 0; i < 25; i++) {

				Thread.sleep(5);
				palo.translate(0, 5);
				ppalo.translate(0, 5);
			}

			for (int i = 0; i < 60; i++) {

				Thread.sleep(10);
				pelota8.translate(0, -5);
			}

			movx = -movx;
			movy = -movy;
			movx2 = -movx2;
			movy2 = -movy2;
			movx3 = -movy3;
			movy3 = -movy3;
			movx4 = -movx4;
			movy4 = -movy4;
			movx5 = -movx5;
			movy5 = -movy5;
			movx6 = -movx6;
			movy6 = -movy6;
			movx7 = -movx7;
			movy7 = -movy7;
			movx8 = -movx8;
			movy8 = -movy8;


			boolean p1 = true, p2 = true, p3 = true, p4 = true, p5 = true, p6 = true, p7 = true, p8 = true;
			/*p1 = false; 
			p2 = false; 
			p3 = false; 
			p4 = false; 
			p5 = false;
			p6 = false; 
			p7 = false;
			p8 = false;*/
			
			

			Text ant = new Text(max / 2 + minx-40, miny,"Creado por: Antonio Cañete");

			Text ant2 = new Text(max / 2+minx-40 , miny + 60,"Todos los derechos reservados");
			ant.grow(40, 10);
			ant2.grow(40, 10);
			ant.setColor(Color.RED);
			ant2.setColor(Color.RED);

			while (true) {

				Thread.sleep(10);
				pelota1.translate(movx, movy);
				pelota2.translate(movx2, movy2);
				pelota3.translate(movx3, movy3);
				pelota4.translate(movx4, movy4);
				pelota5.translate(movx5, movy5);
				pelota6.translate(movx6, movy6);
				pelota7.translate(movx7, movy7);
				pelota71.translate(movx7, movy7);
				ocho.translate(movx7, movy7);
				pelota8.translate(movx8, movy8);

				if ((pelota1.getX() + tamañopelota + 1 > max + minx)
						|| pelota1.getX() < minx) {// +tamañopelota con eso
													// cuadra
					movx = -movx;
					// pelota1.setColor(Color.BLACK);
					// pelota1.fill();
					// movx=0;
					// movy=0;
				}

				/*
				 * if ((pelota1.getX()+tamañopelota+1 == max) && pelota1.getY()
				 * == maxy){ pelota1.setColor(Color.BLACK); pelota1.fill();
				 * movx=0; movy=0;
				 * 
				 * }
				 */

				if ((pelota1.getY() + tamañopelota + 1 > maxy + miny)
						|| pelota1.getY() < miny)
					movy = -movy;

				// Empiezan los 6 if de la desaparicion

				if ((pelota1.getX() + tamañopelota <= minx + 30)
						&& pelota1.getY() <= miny + 15) {
					movy = 0;
					movx = 0;
					pelota1.undraw();

					p1 = false;
				}// if1

				if ((pelota1.getX() + tamañopelota >= max + minx - 30)
						&& (pelota1.getY() <= miny + 15)) {
					movy = 0;
					movx = 0;
					pelota1.undraw();

					p1 = false;

				}// if2

				if ((pelota1.getX() + tamañopelota <= minx + 30)
						&& pelota1.getY() >= maxy + miny - 20) {

					movy = 0;
					movx = 0;
					pelota1.undraw();
					p1 = false;
				}// if3

				if ((pelota1.getX() + tamañopelota >= max + minx - 30)
						&& pelota1.getY() >= maxy + miny - 20) {
					movy = 0;
					movx = 0;
					pelota1.undraw();
					p1 = false;
				}// if4

				if ((pelota2.getX() + tamañopelota + 1 > max + minx)
						|| pelota2.getX() < minx)// +tamañopelota con eso cuadra
					movx2 = -movx2;
				if ((pelota2.getY() + tamañopelota + 1 > maxy + miny)
						|| pelota2.getY() < miny)
					movy2 = -movy2;

				// Empiezan los 6 if de la desaparicion

				if ((pelota2.getX() + tamañopelota <= minx + 30)
						&& pelota2.getY() <= miny + 15) {
					movy2 = 0;
					movx2 = 0;
					pelota2.undraw();
					p2 = false;
				}// if1

				if ((pelota2.getX() + tamañopelota >= max + minx - 30)
						&& (pelota2.getY() <= miny + 15)) {
					movy2 = 0;
					movx2 = 0;
					pelota2.undraw();
					p2 = false;
				}// if2

				if ((pelota2.getX() + tamañopelota <= minx + 30)
						&& pelota2.getY() >= maxy + miny - 20) {

					movy2 = 0;
					movx2 = 0;
					pelota2.undraw();
					p2 = false;
				}// if3

				if ((pelota2.getX() + tamañopelota >= max + minx - 30)
						&& pelota2.getY() >= maxy + miny - 20) {
					movy2 = 0;
					movx2 = 0;
					pelota2.undraw();
					p2 = false;
				}// if4

				if ((pelota3.getX() + tamañopelota + 1 > max + minx)
						|| pelota3.getX() < minx)// +tamañopelota con eso cuadra
					movx3 = -movx3;
				if ((pelota3.getY() + tamañopelota + 1 > maxy + miny)
						|| pelota3.getY() < miny)
					movy3 = -movy3;

				// Empiezan los 6 if de la desaparicion

				if ((pelota3.getX() + tamañopelota <= minx + 30)
						&& pelota3.getY() <= miny + 15) {
					movy3 = 0;
					movx3 = 0;
					pelota3.undraw();
					p3 = false;
				}// if1

				if ((pelota3.getX() + tamañopelota >= max + minx - 30)
						&& (pelota3.getY() <= miny + 15)) {
					movy3 = 0;
					movx3 = 0;
					pelota3.undraw();
					p3 = false;
				}// if2

				if ((pelota3.getX() + tamañopelota <= minx + 30)
						&& pelota3.getY() >= maxy + miny - 20) {

					movy3 = 0;
					movx3 = 0;
					pelota3.undraw();
					p3 = false;
				}// if3

				if ((pelota3.getX() + tamañopelota >= max + minx - 30)
						&& pelota3.getY() >= maxy + miny - 20) {
					movy3 = 0;
					movx3 = 0;
					pelota3.undraw();
					p3 = false;
				}// if4

				if ((pelota4.getX() + tamañopelota + 1 > max + minx)
						|| pelota4.getX() < minx)// +tamañopelota con eso cuadra
					movx4 = -movx4;
				if ((pelota4.getY() + tamañopelota + 1 > maxy + miny)
						|| pelota4.getY() < miny)
					movy4 = -movy4;

				// Empiezan los 6 if de la desaparicion

				if ((pelota4.getX() + tamañopelota <= minx + 30)
						&& pelota4.getY() <= miny + 15) {
					movy4 = 0;
					movx4 = 0;
					pelota4.undraw();
					p4 = false;
				}// if1

				if ((pelota4.getX() + tamañopelota >= max + minx - 30)
						&& (pelota4.getY() <= miny + 15)) {
					movy4 = 0;
					movx4 = 0;
					pelota4.undraw();
					p4 = false;
				}// if2

				if ((pelota3.getX() + tamañopelota <= minx + 30)
						&& pelota3.getY() >= maxy + miny - 20) {

					movy4 = 0;
					movx4 = 0;
					pelota4.undraw();
					p4 = false;
				}// if3

				if ((pelota4.getX() + tamañopelota >= max + minx - 30)
						&& pelota4.getY() >= maxy + miny - 20) {
					movy4 = 0;
					movx4 = 0;
					pelota4.undraw();
					p4 = false;
				}// if4

				if ((pelota5.getX() + tamañopelota + 1 > max + minx)
						|| pelota5.getX() < minx)// +tamañopelota con eso cuadra
					movx5 = -movx5;
				if ((pelota5.getY() + tamañopelota + 1 > maxy + miny)
						|| pelota5.getY() < miny)
					movy5 = -movy5;

				// Empiezan los 6 if de la desaparicion

				if ((pelota5.getX() + tamañopelota <= minx + 30)
						&& pelota5.getY() <= miny + 15) {
					movy5 = 0;
					movx5 = 0;
					pelota5.undraw();
					p5 = false;
				}// if1

				if ((pelota5.getX() + tamañopelota >= max + minx - 30)
						&& (pelota5.getY() <= miny + 15)) {
					movy5 = 0;
					movx5 = 0;
					pelota5.undraw();
					p5 = false;
				}// if2

				if ((pelota5.getX() + tamañopelota <= minx + 30)
						&& pelota5.getY() >= maxy + miny - 20) {

					movy5 = 0;
					movx5 = 0;
					pelota5.undraw();
					p5 = false;
				}// if3

				if ((pelota5.getX() + tamañopelota >= max + minx - 30)
						&& pelota5.getY() >= maxy + miny - 20) {
					movy5 = 0;
					movx5 = 0;
					pelota5.undraw();
					p5 = false;
				}// if4

				if ((pelota6.getX() + tamañopelota + 1 > max + minx)
						|| pelota6.getX() < minx)// +tamañopelota con eso cuadra
					movx6 = -movx6;
				if ((pelota6.getY() + tamañopelota + 1 > maxy + miny)
						|| pelota6.getY() < miny)
					movy6 = -movy6;

				// Empiezan los 6 if de la desaparicion

				if ((pelota6.getX() + tamañopelota <= minx + 30)
						&& pelota6.getY() <= miny + 15) {
					movy6 = 0;
					movx6 = 0;
					pelota6.undraw();
					p6 = false;
				}// if1

				if ((pelota6.getX() + tamañopelota >= max + minx - 30)
						&& (pelota6.getY() <= miny + 15)) {
					movy6 = 0;
					movx6 = 0;
					pelota6.undraw();
					p6 = false;
				}// if2

				if ((pelota6.getX() + tamañopelota <= minx + 30)
						&& pelota6.getY() >= maxy + miny - 20) {

					movy6 = 0;
					movx6 = 0;
					pelota6.undraw();
					p6 = false;
				}// if3

				if ((pelota6.getX() + tamañopelota >= max + minx - 30)
						&& pelota6.getY() >= maxy + miny - 20) {
					movy6 = 0;
					movx6 = 0;
					pelota6.undraw();
					p6 = false;
				}// if4

				if ((pelota7.getX() + tamañopelota + 1 > max + minx)
						|| pelota7.getX() < minx)// +tamañopelota con eso cuadra
					movx7 = -movx7;
				if ((pelota7.getY() + tamañopelota + 1 > maxy + miny)
						|| pelota7.getY() < miny)
					movy7 = -movy7;
				// Empiezan los 6 if de la desaparicion

				if ((pelota7.getX() + tamañopelota <= minx + 30)
						&& pelota7.getY() <= miny + 15) {
					movy7 = 0;
					movx7 = 0;
					pelota7.undraw();
					pelota71.undraw();
					ocho.undraw();
					p7 = false;

				}// if1

				if ((pelota7.getX() + tamañopelota >= max + minx - 30)
						&& (pelota7.getY() <= miny + 15)) {
					movy7 = 0;
					movx7 = 0;
					pelota7.undraw();
					pelota71.undraw();
					ocho.undraw();
					p7 = false;
				}// if2

				if ((pelota7.getX() + tamañopelota <= minx + 30)
						&& pelota7.getY() >= maxy + miny - 20) {

					movy7 = 0;
					movx7 = 0;
					pelota7.undraw();
					pelota71.undraw();
					ocho.undraw();
					p7 = false;
				}// if3

				if ((pelota7.getX() + tamañopelota >= max + minx - 30)
						&& pelota7.getY() >= maxy + miny - 20) {
					movy7 = 0;
					movx7 = 0;
					pelota7.undraw();
					pelota71.undraw();
					ocho.undraw();
					p7 = false;
				}// if4

				if ((pelota8.getX() + tamañopelota + 1 > max + minx)
						|| pelota8.getX() < minx)// +tamañopelota con eso cuadra
					movx8 = -movx8;
				if ((pelota8.getY() + tamañopelota + 1 > maxy + miny)
						|| pelota8.getY() < miny)
					movy8 = -movy8;

				// Empiezan los 6 if de la desaparicion

				if ((pelota8.getX() + tamañopelota <= minx + 30)
						&& pelota8.getY() <= miny + 15) {
					movy8 = 0;
					movx8 = 0;
					pelota8.undraw();
					p8 = false;
				}// if1

				if ((pelota8.getX() + tamañopelota >= max + minx - 30)
						&& (pelota8.getY() <= miny + 15)) {
					movy8 = 0;
					movx8 = 0;
					pelota8.undraw();
					p8 = false;
				}// if2

				if ((pelota8.getX() + tamañopelota <= minx + 30)
						&& pelota8.getY() >= maxy + miny - 20) {

					movy8 = 0;
					movx8 = 0;
					pelota8.undraw();
					p8 = false;
				}// if3

				if ((pelota8.getX() + tamañopelota >= max + minx - 30)
						&& pelota8.getY() >= maxy + miny - 20) {
					movy8 = 0;
					movx8 = 0;
					pelota8.undraw();
					p8 = false;
				}// if4

				if (p1 == false && p2 == false && p3 == false && p4 == false
						&& p5 == false && p6 == false && p7 == false
						&& p8 == false) {

					win.draw();
					ant.draw();
					ant2.draw();

					for (int i = 0; i < 20; i++) {
						Thread.sleep(10);
						ant.translate(0, 1);
						ant2.translate(0, 1);
					}

				}
				

			}
			
		
		}

	}
