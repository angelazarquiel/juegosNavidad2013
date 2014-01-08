package juego;

import graphics2.Color;
import graphics2.Line;
import graphics2.Rectangle;
import graphics2.Text;

public class Oculta {

	private String palabra;
	private boolean mostrada[];
	private Line[] lineas;
	
	public Oculta(String adivinar){
		lineas = new Line [adivinar.length()];
		mostrada = new boolean[adivinar.length()];
		palabra = adivinar;
		
		Rectangle borrar = new Rectangle(450,240,850,50);
		borrar.setColor(Color.LIGHT_GRAY);
		borrar.fill();
		
		int posX1 = 460,posX2 = 495;
		for(int iLine=0; iLine<adivinar.length(); iLine++){
			if(adivinar.charAt(iLine)!=' '){
				lineas[iLine] = new Line (posX1,280, posX2,280);
				lineas[iLine].draw();
				mostrada[iLine] = false;
			}else{
				mostrada[iLine] = true;
			}
			posX1+=45;
			posX2+=45;
		}
	}
	
	public boolean contieneLetra(String letra) {
		return palabra.contains(letra);
		
	}

	/**
	 * 
	 * @param letra
	 * @return Devuelve true si ya se han acertado todas las letras
	 */
	public boolean muestraLetra(String letra) {
		String aux = palabra;
		int incremento = 0;
		while(aux.indexOf(letra)!=-1){
			int i = aux.indexOf(letra);
			Text carac = new Text(lineas[i+incremento].getX()+15,lineas[i+incremento].getY()-20,letra);
			mostrada[i+incremento] = true;
			carac.draw();
			aux = aux.substring(i+1);
			incremento += i+1;
		}
		boolean resuelto = true;
		int i=0;
		while (i<palabra.length() && resuelto){
			resuelto = resuelto && mostrada[i];
			i++;
		}
		return resuelto;
	}

	public void muestraPalabra() {
		for(int i = 0; i<palabra.length();i++){
			if (!mostrada[i]){
				Text carac = new Text(lineas[i].getX()+15,lineas[i].getY()-20,palabra.charAt(i)+"");
				carac.setColor(Color.RED);
				carac.draw();
			}
		}
		
	}

	
	
}
