package main;

import graphics2.Canvas;
import graphics2.Picture;

public class BackGround {
	
	protected static int width;
	protected static int height;
	private Picture pic;
	
	public BackGround(){
		pic = new Picture("src/images/logo.jpg");
		//pic = new Picture("src/images/bck1copy.jpg");
		//pic.translate(0, 0);	
		pic.draw();
		width = pic.getWidth();
		height = pic.getHeight();
		//setMiddle();
	}
	public BackGround(String str){
		pic = new Picture(str);
		//pic = new Picture("src/images/bck1copy.jpg");
		//pic.translate(0, 0);	
		pic.draw();
		width = pic.getWidth();
		height = pic.getHeight();
		//setMiddle();
	}
	
	public int getHeight(){
		return height;
	}
	public int getWidth(){
		return width;
	}
	
	public void Load(String str){
		pic.load(str);
		//pic.draw();
		setMiddle();
		pic.draw();
	}
	
	public void setMiddle(){
		if (Canvas.height != 0 && Canvas.width != 0){
			int margenHorizontal = (Canvas.width - pic.getWidth()) / 2;
			int margenVertical = (Canvas.height - pic.getHeight()) /2;
			if(margenHorizontal > 0 && margenVertical>0){
			System.out.println("margenH: "+margenHorizontal  + " margenV:" + margenVertical );
			pic.translate(margenHorizontal, margenVertical);
			}else{
				System.out.println("setMiddle(). No a sido posible ponerlo en el medio.");
				pic.translate(0, 0);
			}		//pic.translate(10, 10);
		}
	}
	
	public void setZero(){
		int xx = (pic.getX())* -1;
		int yy = pic.getY() * -1;
		pic.translate(xx, yy);
	}
	
	public void unLoad(){
		pic.undraw();
	}
	
	public void translate(int x, int y){
		pic.translate(x,y);
	}
	
	public int getX(){
		return pic.getX();
	}
	public int getY(){
		return pic.getY();
	}
	
	
}
