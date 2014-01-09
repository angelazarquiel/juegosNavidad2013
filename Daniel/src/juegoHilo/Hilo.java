package juegoHilo;

import java.util.Scanner;

import javax.swing.JOptionPane;

import graphics2.Text;
import graphics2.Color;
import graphics2.Rectangle;

public class Hilo {

	public static void main(String[] args) {
		//mensaje bienvenida
		System.out.println("------------------------------------------------");
		System.out.println("--------------BIENVENIDO A >>>HILO<<<-----------");
		System.out.println("-----------SALDRÁN CARTAS DEL 1 AL 10-----------");
		System.out.println("-INDIQUE SI LA SIGUIENTE CARTA ES MAYOR O MENOR-");
		System.out.println("------------------------------------------------");
		
		
		//dibujar la zona de juego
		Rectangle cuadrado;
		cuadrado=new Rectangle(0,0,1000,400);
		cuadrado.setColor(Color.GREEN);
		cuadrado.fill();
		
		//dibujar marcador
		Text texto;
		String textoo="Aciertos: ";
		texto=new Text(450,410,textoo);
		texto.draw();
		texto.setColor(Color.BLACK);
		
		Scanner teclado=new Scanner(System.in);
		int acumulador=(int)(Math.random() * (11 - 1) + 1);
		String aciertos="";
		int acierto=0;
		while (true){
			//dibujar marcador
			Text Aciertos;
			aciertos = String.valueOf(acierto);
			aciertos = Integer.toString(acierto);
			Aciertos=new Text(520,410,aciertos);
			Aciertos.draw();
			Aciertos.setColor(Color.RED);
			
			
			//dibujar las cartas
			Rectangle carta1;
			carta1=new Rectangle(150,100,150,200);
			carta1.setColor(Color.WHITE);
			carta1.fill();
			
			Rectangle carta2;
			carta2=new Rectangle(700,100,150,200);
			carta2.setColor(Color.WHITE);
			carta2.fill();
			
			
			//botones
			/*JButton aceptar = new JButton("Aceptar");
			JButton cancelar = new JButton("Cancelar");*/
			
			
			//colocamos una carta al azar
			int azar= acumulador;		 
			String Azar = "";
			Azar = String.valueOf(azar);
			Azar = Integer.toString(azar);
			
			Text carta1texto;
			carta1texto=new Text(220,190,Azar);
			carta1texto.draw();
			carta1texto.setColor(Color.BLACK);
			
			//preguntamos si la siguiente carta es mayor o menor
			System.out.println("Indique si la siguiente carta es mayor o menor: ");
			String respuesta=teclado.next();
			respuesta = respuesta.toUpperCase();
			
			
			//colocamos una segunda carta al azar
			int azar2=0;
			do{
				azar2= (int)(Math.random() * (11 - 1) + 1);		 
			}while(azar2==azar);
			acumulador=azar2;
			String Azar2 = "";
			Azar2 = String.valueOf(azar2);
			Azar2 = Integer.toString(azar2);
					
			Text carta2texto;
			carta2texto=new Text(770,190,Azar2);
			carta2texto.draw();
			carta2texto.setColor(Color.BLACK);
			
			//comprobamos si es mayor menor o igual
			
			String solucion="";
			
			if(azar2>azar){
				solucion="MAYOR";
			}else{
				solucion="MENOR";
			}
			
			//comprobamos si la respuesta del usuario es correcta
			if(solucion.equals(respuesta)){
				acierto++;
				Aciertos.undraw();
				System.out.println("RESPUESTA CORRECTA");
				JOptionPane.showMessageDialog(null, "RESPUESTA CORRECTA");
			}else {
				JOptionPane.showMessageDialog(null, "RESPUESTA INCORRECTA");
				Text fin;
				String finaal="------GAME OVER------";
				fin=new Text(450,200,finaal);
				fin.draw();
				fin.setColor(Color.RED);
				System.out.println(" RESPUESTA INCORRECTA");
				System.out.println("------GAME OVER------");
				break;
			}

		}
		teclado.close();
		
	}

}
