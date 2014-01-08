import graphics2.Color;
import graphics2.Ellipse;
import graphics2.Line;
import graphics2.Rectangle;
import graphics2.Text;


public class Dado {
	//matriz de puntos 0 vacio 1 negro
	public int[][] caras={
		{0,0,0,
		 0,0,0,
		 0,0,0},
		 //0
		{0,0,0,
		 0,1,0,
		 0,0,0},
		 //1
		 {1,0,0,
	      0,0,0,
		  0,0,1},
		  //2
		 {1,0,0,
		  0,1,0,
		  0,0,1},
		  //3
		  {1,0,1,
		   0,0,0,
		   1,0,1},
		   //4
		  {1,0,1,
		   0,1,0,
	       1,0,1},
	       //5
		  {1,0,1,
		   1,0,1,
	       1,0,1} //6  	
	};
	 
			public int[][] puntosdado2={ //matriz de posiciones de los puntos del dado
			 {1,1,37,1,73,1,
			  1,37,37,37,73,37,
			  1,73,37,73,73,73},// 0 - 7 
			  
			 {0,0,0,0,0,0,
			 0,0,37,37,0,0,
			 0,0,0,0,0,0},//1
			 
			 {1,1,0,0,0,0,
			 0,0,0,0,0,0,
			 0,0,0,0,73,73},//2
			 
			 {1,1,0,0,0,0,
			 0,0,37,37,0,0,
			 0,0,0,0,73,73},//3

			 {1,1,0,0,73,1,
			 0,0,0,0,0,0,
			 1,73,0,0,73,73},//4
			
			 {1,1,0,0,73,1,
			 0,0,37,37,0,0,
			 1,73,0,0,73,73},//5
			 
			 {1,1,0,0,73,1,
			 1,37,0,0,73,37,
			 1,73,0,0,73,73}//6

		 

};
			
	 public int valor=1;
	
		// TODO Auto-generated constructor stub
		//atributos de la "ficha"
		private int x;
		private int y;
		
		private Rectangle vertices;
		private Ellipse puntoscara[];

		//vamos por el constructor
	
		
		public Dado(int x, int y, int dpunto) throws InterruptedException{ // pinta la flecha inicial
			this.x=x;
			this.y=y;

			// variables de control...
			puntoscara = new Ellipse[9];
			int posx=this.x;
			int posy=this.y;
			int separador=(dpunto/2);
		
			vertices=new Rectangle(posx,posy,(4*separador)+(3*dpunto),(4*separador)+(3*dpunto));
			//vertices.draw();
			//vertices.setThickness(3);
			int cuenta=0;
			for (int n=0;n<3;n++){ //cargamos los 9 puntos en su posicion
				for (int p=0;p<3;p++)
				{
					puntoscara[cuenta]=new Ellipse
									(posx+separador+(p*(separador+dpunto)),
										posy+separador+(n*(separador+dpunto)),
										dpunto,dpunto);
					puntoscara[cuenta].draw(); // linea de test comentar despues del test
					//System.out.println("cuenta"+cuenta); //idem
					cuenta++;
					 
				}
			}
		
			
		}
		public int valoractual(){ // para pintar la ficha (plasmar)
			return valor;
		}
		public int Dadox(){
			return vertices.getX();
			
		};
		public int Dadoy(){
			return vertices.getY();
		};
	public int lanzar() throws InterruptedException{
		int meneos=18; //numero múltiplo de 6 a sumar al aleatorio,
		int posdado=1;
		int deceleracion=1; //valor normal 6 7
		
		valor=(int)((Math.random()*6)+1); //sacando del 1-6
		
		meneos=meneos+valor;
		
		for (int i =0;i<meneos;i++){ //bucle de repeticiones totales
			
			for (int b=0;b<9;b++){// borramos las caras esperamos pintamos la siguiente
				
				puntoscara[b].setColor(Color.WHITE);
				//puntoscara[b].fill(); 
			}
			
			Thread.sleep(i*deceleracion); // efecto deceleracion
			for (int b=0;b<9;b++){// pintamos segun patrones de caras[]
				if (caras[posdado][b]==1) {
					puntoscara[b].setColor(Color.BLACK);
					puntoscara[b].fill();};
				
				//puntoscara[b].fill(); 
				//puntoscara[b].setColor(Color.BLACK); //ME SALTO EL ELSE
				//Thread.sleep(300);
			}Thread.sleep(i*deceleracion); // efecto deceleracion
			posdado++;
			if (posdado>6) {posdado=1;};
			Thread.sleep(40);
			
			
			};
			//System.out.println("sacaste="+valor);
			return valor;
			
		
	
		
			
		};
	



		
		
		
	

}
