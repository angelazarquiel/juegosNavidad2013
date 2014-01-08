package main;

import graphics2.Canvas;
import graphics2.Color;
import graphics2.Picture;
import graphics2.Text;

import java.awt.Point;
import java.lang.management.GarbageCollectorMXBean;
import java.util.ArrayList;

import javax.swing.JFrame;

public class MainView{

	public static BackGround backGround; 
	public static Canvas c;
	private static Point pulsacionRaton;
	public static NumAleatorio rndNum = new NumAleatorio();
	private static Ship miNave; 
	private static String str = "";
	public static int numVidas = 5;
	public static boolean CONTINUAR = false;
	
	// DONDE CREO TODOS LOS TEXTOS
	public static Text txtVidas = new Text(40, 10, "0");
	public static Text txtRocket = new Text(27, 60, "0");
	public static Text txtEnemigos = new Text(27, 120, "0");
	public static Text txtRocketCount = new Text(5, 480,"[Rckt] x:   y:  ");
	//texto principal
	public static Text txtPrincipal;

	// ARRAY DONDE GUARDO LOS MISILES
	private static int MISILES_MAX = 15;
	private static int misilesDisponibles = MISILES_MAX;
	public static boolean nuevoMisil = false;
	//public static ArrayList<Rocket> misiles = new ArrayList<Rocket>(MISILES_MAX);
	public static ArrayList<Rocket> misiles = new ArrayList<Rocket>(MISILES_MAX);
		
	// ARRAY DONDE GUARDO LOS ENEMIGOS
	private static int ENEMIGOS_MAX = 60;
	private static int enemigosMatados = 0;
	private static int enemigosLlegaronDestino = 0;
	public static boolean nuevoEnemigo = false;
	public static ArrayList<Enemy> enemigos = new ArrayList<Enemy>();


	public static void main(String[] args) throws InterruptedException {
		
		//c.updateWidthHeight();
		c = Canvas.getInstance();
		System.out.println("CanvasHeight:"+ Canvas.height );
		System.out.println("CanvasWidth:" + Canvas.width);
		
		
		// ****************  pantalla inicio *******************************************
		backGround = new BackGround("src/images/logo.jpg");
		System.out.println("[background] width:" + backGround.width + "\theight:" + (backGround.height));
		c.pack();
		do{
			Thread.sleep(100);
		}while(CONTINUAR == false);
		CONTINUAR = false;
		
		//*************** PANTALLA MISION ********************************************
		backGround.Load("src/images/mision.jpg");
		do{
			Thread.sleep(100);
		}while(CONTINUAR == false);
		CONTINUAR = false;
		
		
		//*************** INICIO DE JUEGO **********************************************
		c.setMaximizado();
		c.updateWidthHeight();
		backGround.Load("src/images/bck1copy.jpg");
		backGround.setZero();
		
		Picture lifeImg = new Picture("src/images/life2.png");
		lifeImg.draw();
		Picture rktImg = new Picture("src/images/rocket/rk1.png");
		rktImg.translate(0, 30);
		rktImg.draw();
		Picture enemyImg = new Picture("src/images/enemyImg.png");
		enemyImg.translate(-3, 98);
		enemyImg.draw();
		
		miNave = new Ship(0, 0, rndNum.numEntre(1, 4));
		textosCreate();
		textosUpdate();
		
		Thread.sleep(2000);
		
		do
		{	
		
			//MUEVE LA NAVE DE LADO A LADO
			pulsacionRaton = c.getMousePosition();
			//if ((pulsacionRaton.x > 0) && (pulsacionRaton.x < backGround.height))
				if ((pulsacionRaton.x < (c.width + (miNave.width/2)))  && (pulsacionRaton.x > 0 ))
					miNave.translate(pulsacionRaton.x, miNave.START_Y);
		
				
			// CREACION DE UN NUEVO MISIL
			if((nuevoMisil == true) && (misilesDisponibles > 0)){ //&& (misilesDisponibles <= MISILES_MAX)){
				misiles.add(new Rocket(pulsacionRaton.x, miNave.START_Y));
				misiles.get(misiles.size()-1).translate(pulsacionRaton.x, miNave.START_Y);
				Rocket.rocketCount++; //misiles totales creados
				misilesDisponibles--;
				nuevoMisil = false;
				txtRocket.setText(String.format("%2d/%2d",misilesDisponibles,MISILES_MAX));
			}

			if (enemigos.isEmpty() == true) {
				int aleatorio = rndNum.numEntre(1, 6);
				// CREACION DE ENEMIGOS ALEATORIA
				for (int i = 0; i < aleatorio; i++) {
					enemigos.add(new Enemy(
							((int) ((Enemy.width / 2)
									+ (Math.random() * c.width) - Enemy.width)),
							30, rndNum.numEntre(1, 5)));
				}
				System.out.printf("\n[CREATE]: %d enemies", aleatorio);
				// System.out.println("Enemy:  x:"+enemigos.get(0).getX()+"  y: "+enemigos.get(0).getY()
				// +"   width:" + enemigos.get(0).width + "  height: "
				// +enemigos.get(0).height);
			}	

			
		//COMPROBAR SI LOS MISILES PASARON LA PANTALLA
		if(misiles.isEmpty()==false)
		{	//Si hay misiles creados entonces muevelos
			for(int i=0; i<Rocket.rocketCount;i++)
			{
				misiles.get(i).move();
				//SI existen enemigos entonces comprueba si el misil ha impactado con ellos
				if(misiles.isEmpty()==false && enemigos.isEmpty()==false)
				{		
					for(int j=0; j<Enemy.enemiesCount;j++) //FOR EACH MISIL comprueba si ha dado cn el enemigo
					{
						if((misiles.get(i).getX() > enemigos.get(j).getX()) && ((misiles.get(i).getX()) < (enemigos.get(j).getX()+enemigos.get(j).width)) && (misiles.get(i).getY() < (enemigos.get(j).getY()+enemigos.get(j).height)))
						{										
									//System.out.printf("\n[COLLISION]: misil[%d] enemigo[%d]",i,j); //detectada colision
									misiles.get(i).delete();
									misiles.remove(i);
									Rocket.rocketCount--;
									misilesDisponibles++;
									enemigos.get(j).delete();
									enemigos.remove(j);
									Enemy.enemiesCount--;
									enemigosMatados++;
									txtEnemigos.setText(String.format("%2d/%2d", enemigosMatados, ENEMIGOS_MAX));
									txtRocket.setText(String.format("%2d/%2d",misilesDisponibles,MISILES_MAX));
									break;
						}else if(misiles.get(i).getY() < 0){
							//System.out.printf("\n[DELETE] misil[%d]",i);
							misiles.get(i).delete();
							misiles.remove(i);
							Rocket.rocketCount--;
							misilesDisponibles++;
							txtRocket.setText(String.format("%2d/%2d",misilesDisponibles,MISILES_MAX));
							break;
						}
					}//if
				}//for
			}//if
		}//END IF
		
		
		//MUEVE LOS ENEMIGOS
		if(enemigos.isEmpty()==false)
		{
			for(int i=0; i<enemigos.size();i++){
				enemigos.get(i).move();
			}
			boolean HaLlegado = false;//SI en el for elimine un enemigo vuelve a recorrer el array
			do
			{
				HaLlegado = false;
				for(int i=0; i<enemigos.size();i++)
				{
					//COMPRUEBO SI LLEGARON ABAJO
					if(enemigos.get(i).getY() > (backGround.height + (enemigos.get(i).height/2))){
						enemigos.get(i).delete();
						enemigos.remove(i);
						Enemy.enemiesCount--;
						numVidas--;
						HaLlegado = true;
						enemigosLlegaronDestino++;
						System.gc(); //llamo a GARBAGE COLLECTOR
					}
				}
				txtVidas.setText(String.format("%d", numVidas));
			}while(HaLlegado==true);
		}//FIN IF	
		
		
	
	}while ((numVidas > 0) && (ENEMIGOS_MAX !=(enemigosMatados+enemigosLlegaronDestino))  );//FIN WHILE
	// ******* FIN PARTIDA *******************	
		miNave.delete();
		lifeImg.undraw();
		rktImg.undraw();
		enemyImg.undraw();
		txtVidas.setText("");
		txtEnemigos.setText("");
		txtRocket.setText("");
		do{
			for(int i=0; i<enemigos.size();i++){
				enemigos.get(i).delete();
				enemigos.remove(i);
				Enemy.enemiesCount--;
			}
			for(int i=0; i<misiles.size();i++){
				misiles.get(i).delete();
				misiles.remove(i);
				Rocket.rocketCount--;
			}
		}while(Rocket.rocketCount > 0 || Enemy.enemiesCount > 0);
		System.out.println("\nmisilcount:" + Rocket.rocketCount);
		System.out.println("enemigoscount:" + Enemy.enemiesCount);
	
	// *************** PARTIDA GANADA **************************************	
	if((numVidas > 0) && (enemigosMatados+enemigosLlegaronDestino == ENEMIGOS_MAX)){
		System.out.println("HAS GANADO !!!");
		backGround.Load("src/images/win2.jpg");
	
	}else{ // ********************  PARTIDA PERDIDA ****************************************		
		System.out.println("HAS PERDIDO");
		backGround.Load("src/images/loose2.jpg");
		
	}
	
	c.repaint();
		
}
	
	
/**********************
 * FIN DEL METODO MAIN
 **********************/
	private static void textosCreate() {

		txtVidas.grow(8, 8);
		txtVidas.setColor(Color.RED);
		txtVidas.draw();
		txtRocket.grow(8, 8);
		txtRocket.setColor(Color.WHITE);
		txtRocket.draw();
		txtEnemigos.grow(8, 8);
		txtEnemigos.setColor(Color.WHITE);
		txtEnemigos.draw();
		//txtRocketCount.grow(4, 4);
		//txtRocketCount.setColor(Color.WHITE);
		//txtRocketCount.draw();

	}

	public static void textosUpdate() {
		
		txtVidas.setText(String.format("%d", numVidas));
		txtRocket.setText(String.format("%2d/%2d",misilesDisponibles,MISILES_MAX));
		txtEnemigos.setText(String.format("%2d/%2d", enemigosMatados, ENEMIGOS_MAX));
	}
}
