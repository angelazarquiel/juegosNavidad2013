package main;

import graphics2.Canvas;
import graphics2.Picture;

public class Ship {
	
	protected int life;
	protected int x;
	protected int y;
	public static int width = 0;
	public static int height = 0;
	public static int START_Y = 100;
	public static Picture nave;
	
	
	public Ship(){
		nave = new Picture("src/images/miNave/nave2.png");
		nave.translate(0,0);
		nave.draw();
		width = nave.getWidth();
		height = nave.getHeight();
	}
	
	public Ship(int x, int y){
		nave = new Picture("src/images/miNave/nave2.png");
		START_Y = (Canvas.height - nave.getHeight())-10;
		nave.translate(x,START_Y);
		nave.draw();
		width = nave.getWidth();
		height = nave.getHeight();
		
		
	}
	public Ship(int x, int y, int type){
		switch(type){
		case 1:
			nave = new Picture("src/images/miNave/nave1.png");
			break;
		case 2:
			nave = new Picture("src/images/miNave/nave2.png");
			break;
		case 3:
			nave = new Picture("src/images/miNave/nave3.png");
			break;
		case 4:
			nave = new Picture("src/images/miNave/nave4.png");
			break;
		default:
			nave = new Picture("src/images/miNave/nave2.png");
			break;
		}
		START_Y = (Canvas.height - nave.getHeight())-10;
	/*	System.out.println("START_Y:"+ START_Y);
		System.out.println(Canvas.height);
		System.out.println(nave.getHeight());
		*/
		nave.translate(x,START_Y);
		nave.draw();
		width = nave.getWidth();
		height = nave.getHeight();
	}
	
	
	
	public static void translate(int x, int y){
		
		nave.translate(
				(x - nave.getX()) - (nave.getWidth()/2),
				(y - nave.getY()) - (nave.getHeight()/2));
	}
	
	public int getX(){
		return nave.getX();
	}
	public int getY(){
		return nave.getY();
	}
	public int getHeith(){
		return nave.getHeight();
	}
	public int getWidth(){
		return nave.getWidth();
	}
	public void delete(){
		nave.undraw();
	}

}
