package juego;

import graphics2.Color;
import graphics2.Ellipse;
import graphics2.Line;
import graphics2.Rectangle;

public class Ahorcado {
	
	private Line ahor4,ahor5;
	
	private Rectangle ahor1, ahor2, ahor3;
	
	private Ellipse cabeza;
	
	private Line [] mu�eco;
	
	private int iMu�eco;
	
	public Ahorcado(){
		ahor1 = new Rectangle (145,380, 280, 20);
		ahor1.setColor(Color.BLACK);
		ahor1.fill();
		
		ahor2 = new Rectangle (185,50, 20, 330);
		ahor2.setColor(Color.BLACK);
		ahor2.fill();	
		
		ahor3 = new Rectangle (205,50,180,20);
		ahor3.setColor(Color.BLACK);
		ahor3.fill();
		
		ahor4 = new Line (205,110,245,70);
		ahor4.draw();
		
		ahor5 = new Line (350,50,350,120);
		ahor5.draw();
		
		Rectangle borrar = new Rectangle(310,120,80,200);
		borrar.setColor(Color.LIGHT_GRAY);
		borrar.fill();
		
		//Borra el ganaste perdiste
		Rectangle borrar2 = new Rectangle(720,320,200,100);
		borrar2.setColor(Color.LIGHT_GRAY);
		borrar2.fill();
		
		cabeza = new Ellipse(320,120,60,60);
		
		mu�eco = new Line [6];
		
		iMu�eco=0;
		mu�eco[iMu�eco] = new Line(350,180,350,190);
		iMu�eco++;
		mu�eco[iMu�eco] = new Line(350,190,385,215);
		iMu�eco++;
		mu�eco[iMu�eco] = new Line(350,190,315,215);
		iMu�eco++;
		mu�eco[iMu�eco] = new Line(350,190,350,260);
		iMu�eco++;
		mu�eco[iMu�eco] = new Line(350,260,370,290);
		iMu�eco++;
		mu�eco[iMu�eco] = new Line(350,260,330,290);
		
		iMu�eco = 0;

	}
	/**
	 * 
	 * @return devuelve true si no hay m�s que pintar
	 */
	public boolean dibujaSiguiente(){
		if(iMu�eco==0){
			cabeza.draw();
		}else{
			mu�eco[iMu�eco-1].draw();
		}
		iMu�eco++;
		return (iMu�eco==7);
	}
	
}
