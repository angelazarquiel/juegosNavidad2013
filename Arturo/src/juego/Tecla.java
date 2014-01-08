package juego;

import graphics2.Color;
import graphics2.Ellipse;
import graphics2.Text;

public class Tecla {
	
	private int posX;
	private int posY;
	private int radioAncho;
	private int radioAlto;
	private String letra;
	private Ellipse circulo;
	private Text texto;
	private boolean pulsada;
	
	public Tecla(int posX, int posY, int radioAncho, int radioAlto, String letra) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.radioAncho = radioAncho;
		this.radioAlto = radioAlto;
		this.letra = letra;
		this.pulsada = false;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	
	public void dibuja(Color color){
		/*posX = 145;
		posY = 495;*/
		circulo = new Ellipse(posX,posY,radioAncho,radioAlto);
		if(color!= null){
			circulo.setColor(color);
		}else{
			circulo.setColor(Color.YELLOW);
		}
		circulo.fill();
		texto = new Text(0,0,letra);
		int ancho = texto.getWidth();
		int alto = texto.getHeight();
		texto = new Text ((posX+(radioAncho/2)-(ancho/2)),(posY+(radioAlto/2)-(alto/2)),letra);
		texto.draw();
		pulsada=false;
		
	}
	public boolean esPulsada(int x, int y) {
		boolean teclaPulsada = posX<x && x<posX+radioAncho;
		teclaPulsada = teclaPulsada && posY<y && y<posY+radioAlto;
		return teclaPulsada;
	}
	public void cambiaColor(Color color) {
		circulo.setColor(color);
		circulo.fill();
		texto.draw();
		pulsada=true;
		
	}

}
