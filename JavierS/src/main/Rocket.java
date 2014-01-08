package main;

import graphics2.Picture;

public class Rocket {

	private int x=0;
	private int y=0;
	public static int width = 0;
	public static int height = 0;
	private static final double UP_SPEED = 0.004; //5pixeles
	public static int rocketCount = 0;
	private Picture rocket = new Picture("src/images/rocket/rk2.png");

	public Rocket(){
		rocket.draw();
		rocket.translate(0,0);
		width = rocket.getWidth();
		height = rocket.getHeight();
	}
	
	public Rocket(int x, int y){
		rocket.draw();
		rocket.translate(x,x);
		width = rocket.getWidth();
		height = rocket.getHeight();
	}
	
	public int getX(){
		return rocket.getX();
	}
	public int getY(){
		return rocket.getY();
	}
	//DEVUELVE LA POSICION X DEL CENTRO DEL OBJETO
	public int getXcentro(){
		int tmp = rocket.getX() + (width/2);
		return tmp;
	}
	//DEVUELVE LA POSICION Y DEL CENTRO DEL OBJETO
	public int getYcentro(){
		int tmp = rocket.getX() + (width/2);
		return tmp;
	}
	public void translate(int x, int y){
		rocket.translate(
				(x - rocket.getX()) - (rocket.getWidth()/2),
				(y - rocket.getY()) - (rocket.getHeight()/2));
	}
	
	public void move(){
		rocket.moveY(UP_SPEED);
	}
	
	public void delete(){
		rocket.undraw();
	}
}
