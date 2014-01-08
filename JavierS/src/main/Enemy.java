package main;

import graphics2.Picture;

public class Enemy {

	private int life = 10;
	private int x=0;
	private int y=0;
	public static int width = 0;
	public static int height = 0;
	public final static int START_Y = 5;
	private static final double DOWN_SPEED = -0.0005; //5pixeles
	public static int enemiesCount = 0;
	
	private Picture enemy;//= new Picture("src/images/enemies/enemy1.png");

	public Enemy(){
		enemy = new Picture("src/images/enemies/enemy1.png");
		enemy.draw();
		enemy.translate(10,START_Y);
		width = enemy.getWidth();
		height = enemy.getHeight();	
		enemiesCount++;
		
	}
	
	public Enemy(int x, int y){
		enemy = new Picture("src/images/enemies/enemy1.png");
		enemy.draw();
		enemy.translate(x,START_Y);
		width = enemy.getWidth();
		height = enemy.getHeight();
		enemiesCount++;
		
	}
	public Enemy(int x, int y, int type){	
		switch(type){
		case 1:
			enemy = new Picture("src/images/enemies/enemy1.png");
			break;
		case 2:
			enemy = new Picture("src/images/enemies/enemy2.png");
			break;
		case 3:
			enemy = new Picture("src/images/enemies/enemy3.png");
			break;
		case 4:
			enemy = new Picture("src/images/enemies/enemy4.png");
			break;
		default:
			enemy = new Picture("src/images/enemies/enemy2.png");
			break;
	}
		enemy.draw();
		enemy.translate(x,START_Y);
		width = enemy.getWidth();
		height = enemy.getHeight();
		enemiesCount++;
	}
	public int getX(){
		return enemy.getX();
	}
	public int getY(){
		return enemy.getY();
	}
	
	//DEVUELVE LA POSICION X DEL CENTRO DEL OBJETO
	public int getXcentro(){
		int tmp = enemy.getX() + (width/2);
		return tmp;
	}
	//DEVUELVE LA POSICION Y DEL CENTRO DEL OBJETO
	public int getYcentro(){
		int tmp = enemy.getY() + (height/2);
		return tmp;
	}
	public void translate(int x, int y){
		enemy.translate(
				(x - enemy.getX()) - (enemy.getWidth()/2),
				(y - enemy.getY()) - (enemy.getHeight()/2));
	}
	
	public void move(){
		enemy.moveY(DOWN_SPEED);
	}
	
	public int getLife(){
		return life;
	}
	public void setLife(int dlife){
		life -= dlife;
	}
	
	public void delete(){
		enemy.undraw();
	}
}
