

import graphics2.*;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class JuegoAhorcado {

		public static void main(String[] args) throws InterruptedException {
			base ();
			cabeza ();
			cuerpo ();
			brazos ();
			piernas1 ();
			piernas2 ();
			
			//Mensaje de bienvenida creado por mi en la librería Canvas
			Canvas.bienvenida();
			
			//Para borrar el dibujo anterior pintamos rectángulo en blanco encima
			Rectangle borrar;
			borrar = new Rectangle (0, 0, 500, 600);
			borrar.setColor(Color.WHITE);
			borrar.fill();
			
			int tx = 40;
			
			//Que no se vean los caracteres al introducir la palabra clave
			JPasswordField jpf=new JPasswordField();
			
			//Introducir la palabra clave en ventana
			JOptionPane.showConfirmDialog(null, jpf,"Dime la  Palabra Secreta",JOptionPane.OK_OPTION);
			String palabra=String.valueOf(jpf.getPassword());
			StringBuffer adivinada=new StringBuffer();
			
			//Poner tantos asteriscos como letras tenga la palabra secreta
			for(int i=0;i<palabra.length();i++) 
			{
				adivinada.append("*");
			}
			Text longitud;
			longitud = new Text (30, 10, "LA PALABRA TIENE " + palabra.length()+ " LETRAS. SUERTE !!");
			longitud.grow(20, 20);
			longitud.setColor(Color.BLACK);
			longitud.draw();
			//Dibujamos tantas líneas como letras tenga la palabara secreta
			//Esto es solo a modo decorativo, lo que se sustituye por las letras son los asteriscos
			for(int i=0;i<palabra.length();i++) 
			{
				Text lineas;
				lineas = new Text (tx, 30, "-");
				lineas.grow(20, 20);
				lineas.setColor(Color.RED);
				lineas.draw();
				tx = tx + 40;
			}
			int fallos=0;
			while(fallos<8 && !palabra.equals(adivinada.toString()))
			{
				Text numfallos;
				//mostrar los guiones en consola
				System.out.println(adivinada);
				
				//pido una letra
				char letra = JOptionPane.showInputDialog(null,"Teclea una letra").charAt(0);
				//Busco la letra y hago los cambios
				boolean cambios=false;
				for(int i=0;i<palabra.length();i++)
				{
					if(palabra.charAt(i)==letra)
					{
						//Dibujar las letras adivinadas
						adivinada.setCharAt(i, letra);
						Text adivin;
						adivin = new Text (60, 55,  ""+ adivinada + "" );
						adivin.grow(30, 30);
						adivin.draw();
						//Mensaje de acierto creado por mi en la libreria Canvas
						Canvas.acierto();
						adivin.undraw();
						cambios=true;
					}
				}
				if(cambios==false)
				{
					//Contando el número de fallos e imprimiendolo en ventana
					fallos++;
					numfallos = new Text (350, 550, "Tienes " + fallos + " fallos");		
					numfallos.grow(50, 50);
					numfallos.setColor(Color.BLUE);
					numfallos.draw();
					Rectangle recuadro;
					recuadro = new Rectangle(290, 515, 190, 90);
					recuadro.setThickness(5);
					recuadro.setColor(Color.BLUE);
					recuadro.draw();
					
					//Mensaje de fallo creado por mi en la librería Canvas
					Canvas.fallo();
					numfallos.undraw();
					recuadro.undraw();
					//Mostrar número de fallos por consola
					System.out.println("Tienes "+ fallos +" fallos");
					
					//Según número de fallos llamar a un método
					//para ir creando el dibujo
					switch (fallos) {
					case 0:
						break;
					case 1:
						base ();
						break;
					case 2:
						cabeza ();
						break;
					case 3:
						cuerpo ();
						break;
					case 4:
						brazos ();
						break;
					case 5:
						piernas1 ();
						break;
					case 6:
						piernas2 ();
						break;
					case 7:
						faltauno ();
						break;
					}	
				}	
			}//fin while
			if(fallos==8)
			{
				//Mensaje en ventana si ganas
				Text perdedor;
				perdedor = new Text (300, 300, "ERES EL PEOR");
				perdedor.grow(120, 140);
				perdedor.setColor(Color.RED);
				perdedor.draw();
				//Mensaje por consola en caso de perder la partida
				System.out.println("Eres el peor");
			}
			else
			{
				Rectangle borrar2;
				borrar2 = new Rectangle (0, 0, 500, 600);
				borrar2.setColor(Color.WHITE);
				borrar2.fill();
				
				//Llamamos al método que se encargará de hacer saltar al muñeco
				movimiento ();
				
				//Mensaje por consola si ganas la partida
				System.out.println("Eres el mejor");
			}
		}
		public static void base() {
			Rectangle rectangulo;
			rectangulo = new Rectangle(100, 75, 250, 25);
			rectangulo.fill();
			Rectangle rectangulo2;
			rectangulo2 = new Rectangle(100, 75, 25, 500);
			rectangulo2.fill();
			Rectangle rectangulo3;
			rectangulo3 = new Rectangle(50, 575, 150, 25);
			rectangulo3.fill();
		}
		public static void cabeza() {
			Ellipse cabeza;
			cabeza = new Ellipse(300, 100, 70, 70);
			cabeza.setThickness(10f); 
			cabeza.setColor(Color.YELLOW);
			cabeza.draw();
			Ellipse ojo1;
			ojo1 = new Ellipse(320, 120, 5, 5);
			ojo1.setColor(Color.BLACK);
			ojo1.fill();
			Ellipse ojo2;
			ojo2 = new Ellipse(340, 120, 5, 5);
			ojo2.setColor(Color.BLACK);
			ojo2.fill();
			Rectangle boca;
			boca = new Rectangle (320, 140, 25, 5);
			boca.setColor(Color.RED);
			boca.fill();
		}
		public static void cuerpo() {
			Rectangle cuello;
			cuello = new Rectangle(330, 170, 15, 25);
			cuello.fill();
			Rectangle cuerpo;
			cuerpo = new Rectangle(300, 195, 70, 110);
			cuerpo.setColor(Color.GREEN);
			cuerpo.fill();
		}
		public static void brazos() {
			Rectangle uno;
			uno = new Rectangle(240, 195, 60, 15);
			uno.fill();
			Rectangle dos;
			dos = new Rectangle(370, 195, 60, 15);
			dos.fill();
		}
		public static void piernas1() {
			Rectangle pierna1;
			pierna1 = new Rectangle(300, 300, 25, 100);
			pierna1.setColor(Color.BLUE);
			pierna1.fill();
		}
		public static void piernas2() {
			Rectangle pierna2;
			pierna2 = new Rectangle(345, 300, 25, 100);
			pierna2.setColor(Color.BLUE);
			pierna2.fill();
		}
		public static void faltauno() {
			Text faltauno;
			faltauno = new Text (400, 40, "UN FALLO MÁS Y ADIOS...");
			faltauno.grow(90, 70);
			faltauno.setColor(Color.RED);
			faltauno.draw();
		}
		public static void movimiento() throws InterruptedException {
			
			Ellipse cabeza;
			cabeza = new Ellipse(100, 100, 70, 70);
			cabeza.setThickness(10f); 
			cabeza.setColor(Color.YELLOW);
			cabeza.draw();
			Ellipse ojo1;
			ojo1 = new Ellipse(120, 120, 5, 5);
			ojo1.setColor(Color.BLACK);
			ojo1.fill();
			Ellipse ojo2;
			ojo2 = new Ellipse(140, 120, 5, 5);
			ojo2.setColor(Color.BLACK);
			ojo2.fill();
			Rectangle boca;
			boca = new Rectangle (120, 140, 25, 5);
			boca.setColor(Color.RED);
			boca.fill();
			
			Rectangle cuello;
			cuello = new Rectangle(130, 170, 15, 25);
			cuello.fill();
			Rectangle cuerpo;
			cuerpo = new Rectangle(100, 195, 70, 110);
			cuerpo.setColor(Color.GREEN);
			cuerpo.fill();
			
			Rectangle uno;
			uno = new Rectangle(40, 195, 60, 15);
			uno.fill();
			Rectangle dos;
			dos = new Rectangle(170, 195, 60, 15);
			dos.fill();
			
			Rectangle pierna1;
			pierna1 = new Rectangle(100, 300, 25, 100);
			pierna1.setColor(Color.BLUE);
			pierna1.fill();
			
			Rectangle pierna2;
			pierna2 = new Rectangle(145, 300, 25, 100);
			pierna2.setColor(Color.BLUE);
			pierna2.fill();
			
			//Saltar hacia arriba
			int saltararriba = 0;
			while (saltararriba < 40){
			Thread.sleep(20);
			cabeza.translate(0, -10);
			ojo1.translate(0, -10);
			ojo2.translate(0, -10);
			boca.translate(0, -10);
			cuello.translate(0, -10);
			cuerpo.translate(0, -10);
			uno.translate(0, -10);
			dos.translate(0, -10);
			pierna1.translate(0, -10);
			pierna2.translate(0, -10);
			saltararriba++;
			}
			//Saltar hacia abajo
			int saltarabajo = 0;
			while (saltarabajo < 40){
			Thread.sleep(20);
			cabeza.translate(0, 10);
			ojo1.translate(0, 10);
			ojo2.translate(0, 10);
			boca.translate(0, 10);
			cuello.translate(0, 10);
			cuerpo.translate(0, 10);
			uno.translate(0, 10);
			dos.translate(0, 10);
			pierna1.translate(0, 10);
			pierna2.translate(0, 10);
			saltarabajo++;
			}
			
			//Si ganas la partida dibuja el texto
			Text ganador;
			ganador = new Text (300, 300, "ERES EL MEJOR");
			ganador.grow(120, 140);
			ganador.setColor(Color.RED);
			ganador.draw();
		}
}


