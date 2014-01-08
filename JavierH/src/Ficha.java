import graphics2.Color;
import graphics2.Ellipse;
import graphics2.Line;
import graphics2.Rectangle;
import graphics2.Text;


public class Ficha {

	
		// TODO Auto-generated constructor stub
		//atributos de la "ficha"
		private int casillaactual=0;
	    private int x;
		private int y;
		private int soy; //guardara 0 1 2 3 ... dependiendo de la ficha que sea
		
		private Ellipse contorno;
		private Ellipse relleno;
		private Color color;
		
		//vamos por el constructor
		public int quefichaes (){return this.soy;};
		
		public Ficha(int x, int y, Color color,int seras){
			this.x=x;
			this.y=y;
			this.soy=seras;
			;
			this.color=color;
			// variables de control...
			int posx=this.x;
			int posy=this.y;
			
			
			final int diam=25; //diametro de la ficha
		
			
			contorno=new Ellipse(posx,posy,diam,diam);
			relleno=new Ellipse(posx,posy,diam,diam);
			relleno.setColor(color);
			contorno.setColor(Color.BLACK);
			relleno.draw();
			relleno.fill();
		
			contorno.draw();
			
			
		}
	
		public void fichahappy(int color,int posx,int posy) throws InterruptedException{
			
			
			
			Text cartel;
			Ellipse arito;
			double x,y;
			int r=0,g=0,b=0;
			String texto="GANA EL: ";
			if (color==0) {r=1;b=0;g=0;texto="GANA EL: ROJO ";};
			if (color==1) {r=0;b=0;g=1;texto="GANA EL: VERDE ";};
			if (color==2) {r=1;b=0;g=1;texto="GANA EL: AMARILLO";};
			if (color==3) {r=0;b=1;g=0;texto="GANA EL: AZUL ";};
			
			for (int aro=120;aro<510;aro++){
				Thread.sleep(10);
				x=Math.cos(Math.toRadians(aro))*(aro/(20+aro/3));
			    y=Math.sin(Math.toRadians(aro))*(aro/(20+aro/3));
			    arito=new Ellipse(y*aro/5+posx,x*aro/5+posy,(10+aro)/3,(10+aro)/3);
			    arito.setColor(new Color(aro/2*r,aro/2*g,aro/2*b));
			    arito.draw();
			    arito.fill();
				
			};
			cartel=new Text(450, 175, texto);
			cartel.grow(2, 2);
			for (int cc=1;cc<255;cc++){
			cartel.setColor(new Color(cc*b,cc*r,cc*g));
			Thread.sleep(10);
			if (cc%10==0){cartel.grow(1, 1);}
			cartel.draw();}
			cartel.undraw();
			for (int aro=120;aro<250;aro++){ //intento sonrisa
				Thread.sleep(5);
				x=(-Math.cos(Math.toRadians(aro))*(aro/(20+aro/4)));
			    y=-Math.sin(Math.toRadians(aro))*(aro/(20+aro/4));
			    arito=new Ellipse(180+(y*aro/5+posx),-100+(x*aro/5+posy),(5),(5));
			    arito.setColor(new Color(aro/2*r,aro/2*g,aro/2*b));
			    arito.draw();
			    arito.fill();
			}
			arito=new Ellipse(440,150,40,60);arito.setColor(Color.WHITE);
			arito.draw();arito.fill();
			arito=new Ellipse(500,150,40,60);arito.setColor(Color.WHITE);
			arito.draw();arito.fill();
			arito=new Ellipse(440,170,20,25);
			
			arito.draw();arito.fill();
			
			arito=new Ellipse(500,170,20,25);
			
			arito.draw();arito.fill();
		
		
			
		}
		public void pintarficha(){ // para pintar la ficha (plasmar)
			relleno.draw();
			relleno.fill();
		
			contorno.draw();
		}
		public double dondeX() {  // obtener la posicion actual X
			return relleno.getX();
		}
		public double dondeY() {  // obtener la posicion actual X
			return relleno.getY();
		}
		public void cambiacasilla(int casilladestino){// cambia la ficha dada a la casilla dada
		casillaactual=casilladestino;
		
		};
		public int quecasilla(){
			return casillaactual;
		};
		
			
		
		public void moverdesdehasta(double xO,double yO,double xF,double yF) throws InterruptedException{
			
			
			 double radio=0d;
			 int angulofinal=0;
			 int anguloinicial=0;
	         int origenx,origeny,destinox,destinoy;
	         double desx,desy,senoprop;
	         int opcion3c=0; //movimiento en el 4º cuadrante inverso al 1º
	         
       origenx=(int)xO;
       origeny=(int)yO;
       destinox=(int)xF;
       destinoy=(int)yF;
		 //transformacion a y negat.
        destinoy=destinoy*-1;
        origeny=origeny*-1;
		radio=(Math.sqrt(Math.pow((origenx-destinox),2)+Math.pow((origeny-destinoy),2))/2);
	
		senoprop=(((double)destinoy-(double)origeny)/(radio*2));
		

		//pendiente=((double)(destinox-origenx)/(double)(destinoy-origeny));
		
		//
		//anguloinicial=(int)(Math.toDegrees(Math.asin(senoprop)));
		if (origenx<=destinox && origeny<destinoy){ // primer cuadrante
		anguloinicial=(int)(Math.toDegrees(Math.asin(senoprop)));if (radio>220){opcion3c=-1;};
		} //cuadrante=1
		if (origenx>=destinox && origeny<destinoy){ // segundo cuadrante
			anguloinicial=90+(int)(Math.toDegrees(Math.acos(senoprop)));
			}//cuadrante=2;
		if (origenx>=destinox && origeny>=destinoy){ // tercer cuadrante
			anguloinicial=90+(int)(Math.toDegrees(Math.acos(senoprop)));
			
			}//cuadrante=3;
		if (origenx<destinox && origeny>destinoy){ // cuarto cuadrante
			anguloinicial=360+(int)(Math.toDegrees(Math.asin(senoprop)));
			
			}//cuadrante=4;
		
		angulofinal=anguloinicial+180;
		
		// calcular los recoridos del for dependiendo del sentido
		for (int i=anguloinicial ;i<angulofinal;i++){
			desy=((Math.sin(Math.toRadians(i)))-(Math.sin(Math.toRadians(i+1))))*radio*-1;
			desx=((Math.cos(Math.toRadians(i)))-(Math.cos(Math.toRadians(i+1))))*radio;
			if (opcion3c==-1){desy=desy*opcion3c;}; // para que no se salga del canvas en los saltos grandes
			Thread.sleep(4);
		        relleno.translate(desx,desy);
	    		contorno.translate(desx,desy);
		    }
		  
		double ajustex,ajustey;
		ajustex=dondeX();
		ajustey=dondeY();
		relleno.translate(((double)destinox)-ajustex,(((double)(destinoy))*(-1))-(ajustey));
		contorno.translate(((double)destinox)-ajustex,(((double)((destinoy))*(-1)))-(ajustey));
	
		
		}
		
		
		
		
	

}
