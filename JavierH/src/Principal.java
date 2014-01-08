
// JUEGO DE LA OCA , POR JAVIER HERNANDEZ RODRIGUEZ, 1º DAW VESPERTINO AZARQUIEL 2013-14
//
//FALTA POR IMPLEMENTAR LA OPCION SALIR Y REINICIAR (RESET)
//(imagino que se hará cuando lleguemos al control de excepciones/hilos, que posibilite interrumpir/bifurcar la ejecucion
//en los momentos que tambien "juege la máquina", de momento lo he eliminado del código

// En lo básico existen 3 clases para los objetos principales del juego Tablero, Dado y Ficha
// la clase Principal contiene las llamadas a los mimos y los bucles principales anidados para la ejecucion. Asi como ciertos métodos que actuan como funciones
// sobre los objetos principales instanciados.

// se necesita la imagen del tablero "tablero750C.png" en el directorio de ejecución/proyecto.
//
/* FUNCIONAMIENTO DEL JUEGO:
 *  HAY QUE ESCOJER AL MENOS 2  JUGADORES (HUMANOS O MÁQUINAS) PARA PODER COMENZAR EL JUEGO
 *  DESPUES HAY QUE "COMENZAR"
 *  EMPIEZA MOVIENDO EL PRIMER DE LOS JUGADORES SELECCIONADOS QUE OBTIENE UN 6 AL LANZAR LOS DADOS
 *  
 *  GANA EL JUGADOR/FICHA QUE LLEGA A LA CASILLA Nº 63 CON UNA SACADA DIRECTA DE DADOS
 *  (NO VALE LLEGAR DE REBOTE Y CAYENDO EN LA UTIMA CASILLA DE "OCA")
 *  
 *  
 *  PUEDEN VARIARSE EN EL CODIGO ALGUNOS EFECTOS COMO LA VELOCIDAD DEL DADO Y CIERTAS PAUSAS (MENSAJES) QUE ESTAN
 *  AJUSTADAS A UN MODO "RÁPIDO" PARA MEJORAR LA "JUGABILIDAD"
 *  
 */

import graphics2.Canvas;
import graphics2.Color;
import graphics2.Ellipse;
import graphics2.Picture;
import graphics2.Rectangle;
import graphics2.Text;

import java.awt.Point;



public class Principal {


	
	public static void main(String[] args) throws InterruptedException {
	

		
		Ficha FichaRoja;
		Ficha FichaAmarilla;
		Ficha FichaAzul;
		Ficha FichaVerde;
		Dado Dadonormal;
		//Rectangle cartelera;
		Tablero tapete;
		int modojuego=0; //0 config, 1 juego  2 quiensale 3 salir
		int casillaestaba, casillatrasoca, casillatrampas;
		
		tapete = new Tablero(); //iniciando el tablero->en tapete
		
		
		//cargar tablero
		Picture pic = new Picture("tablero750C.png");
		pic.translate(0, 0);
		pic.draw();
		Dadonormal= new Dado(775,145,20);
		
		FichaRoja=new Ficha(tapete.casillas4[0][0],tapete.casillas4[0][1],Color.RED,0);
		
		FichaVerde=new Ficha(tapete.casillas4[1][0],tapete.casillas4[1][1],new Color(0,200,10),1);
		FichaAmarilla=new Ficha(tapete.casillas4[2][0],tapete.casillas4[2][1],Color.YELLOW,2);
			
		FichaAzul=new Ficha(tapete.casillas4[3][0],tapete.casillas4[3][1],Color.BLUE,3);
		//circu1.setColor(new Color(0,200,200))
		
		Ficha[] lasfichas; //para mas comodidad meto los objetos fichas instanciados en un array
		lasfichas=new Ficha[4];
		lasfichas[0] =FichaRoja;
		lasfichas[1]= FichaVerde;
		lasfichas [2]=FichaAmarilla;
		lasfichas [3]=FichaAzul;
		
		tapete.mensajes(1);  //MENSAJE BIENVENIDOS
		tapete.mensajes(2); 
		
		
		Canvas c;
		c=Canvas.getInstance();
		
		
		Text posiciones;
	    		

		int sequiensaca=5; // para el control del turno incial
		int turnode=0;
		int sacado=0;
		int pulsado=0;
		
		int respuesta=0;
		
        Dadonormal.lanzar();
	
		do{      tapete.repintaropciones();
			//Point pulsacion=c.waitMouseClick(); // capturando la posicion del click del raton
				/********** modo configuracion 0 **********/	
				do{// modojuego==0      estamos en modo configuracion 	
					tapete.repintaropciones();
					respuesta=tapete.ratonen2(0);//(pulsacion.x,pulsacion.y);
					 tapete.repintaropciones();
					 colocarFichasConfig(tapete, FichaRoja, FichaVerde, FichaAmarilla, FichaAzul);
					
						switch (respuesta) {			
		            case 12:  
		            	 //pinchado en dados
		            	tapete.mensajes(2);
		            		 
		                     break;
		            case 13:  //pinchado en comenzar
		            	if (tapete.preparados()>1){modojuego=2; // que haya mas de 1 jugador
		          
		            	} else{
		            	            	
		            		tapete.mensajes(2); //avisamos de nuevo
		            		};
		                     break;
		            case 14: // reiniciar (FUTURA IMPLEMENTACION: buscar solucion al probrema de turno de ficha automatico)
		                     break;
		            case 15:  // salir  (FUTURA IMPLEMENTACION)
		                     break;		            
		            default:; //nada de nada
		                     break;
		        }
				
					Thread.sleep(10);
					
				}while (modojuego==0);// fin estamos en modo config
				
				
				
				
				
								/***************/
				do{// estamos en modo ¿quiensaca?	
					
					tapete.mensajes(16); //sacar mensaje info de tirar
					
					do {// el primero que saca 6 empieza
						tapete.mensajes(16);
						if (tapete.jugadores[turnode][0]!=0) //verificar que la ficha juega 
							{//pintamos el color indicador en el tablero
							tapete.coloractivo(turnode);
							if (tapete.jugadores[turnode][0]==1)//vemos si es humano tira dado humano//
								{
									tapete.mensajes(12+turnode);// mensaje de tirar jugador
									pulsado =tapete.ratonen2(2);// esperear pulsacion raton
									if (pulsado==12){sacado=Dadonormal.lanzar();
													}//opcion tirar dados
									
									if (pulsado==13){//mensaje confirmar reset , verificacion reset -> reset y variable escape}
													}
								}
							
							else{ // esto es que tira la máquina
						    Thread.sleep(1000); // espera para ver el resultado
							tapete.mensajes(12+turnode);
							sacado=Dadonormal.lanzar();
							Thread.sleep(1000); // espera para ver el resultado
							} //tira dados maquina
							}
					// comprobamos si sale el 6
					if (sacado==6){
						tapete.jugadores[turnode][1]=0;//asigno el turno al que saca 6
					    sequiensaca=turnode;  //se establece el 1erturno
					    tapete.mensajes(15); // mensaje de "ha salido 6 empieza.."
					    Thread.sleep(1000);
					    tapete.mensajes((12+turnode));
					    modojuego=1; //ya se puede empezar
					
					}else{turnode++;
					if (turnode >3){turnode=0;}; }//mensaje de no haber 6 , siguente intento
					
					
					
					}while (sequiensaca==5);
					
					
				}while (modojuego==2);
				
				/***************/
				//Modo jugando =1
					
					do{turnode=quienmueve(tapete); 
							
					
						tapete.coloractivo(turnode);
					
						if (tapete.jugadores[(lasfichas[turnode]).quefichaes()][0]==2){ //es el ordenador
							lasfichas[turnode].cambiacasilla( // cambiara la casilla con salto paso a paso a lo que saque el dado
									moverfichadesdeapasoapaso(lasfichas[turnode], tapete, Dadonormal.lanzar())
									// para forzar el dado al numero---> moverfichadesdeapasoapaso(lasfichas[turnode], tapete, 3)
									);
									//System.out.println("esta en la casilla"+(lasfichas[turnode].quecasilla()));
									;
						
						}
						if (tapete.jugadores[(lasfichas[turnode]).quefichaes()][0]==1) { // es humano
							// tira el humano
							do {
							respuesta=tapete.ratonen2(0);
							// 12 tirar los dados //mandar el mensaje num/ 12 rojo /13 verde /14 amarillo/ 15 azul;
							tapete.mensajes(lasfichas[turnode].quefichaes()+12);
							if (respuesta==12){lasfichas[turnode].cambiacasilla( // cambiara la casilla con salto paso a paso a lo que saque el dado
									moverfichadesdeapasoapaso(lasfichas[turnode], tapete, Dadonormal.lanzar())
									);};
									
							}while (respuesta!=12); //ESPERAR AL HUMANO QUE TIRE EL DADO 
							
							
						}
						//parte comun independiente de humano o máquina:
						//ahora miraremos si hay que rebotar o saltar o lo que sea... y reasignamos casilla
							if(lasfichas[turnode].quecasilla()>63){lasfichas[turnode].cambiacasilla
								(63-((lasfichas[turnode].quecasilla())-63));} //para el rebote del final
							
						  casillaestaba = lasfichas[turnode].quecasilla();
						     if (casillaestaba==63){modojuego=4;} //GANADOR
						     else{//ahora llamamos a las ocas puentes y dados...
						    	 //ocas puentes dadoa dado...
	        		      casillatrasoca = casillacaidaficha(lasfichas[turnode],tapete, lasfichas[turnode].quecasilla());
	        		    
	        		      if (casillaestaba==lasfichas[turnode].quecasilla()||lasfichas[turnode].quecasilla()==1) //si no hay oca o a caido en "muerte" condiciones de paso de turno...etc
	        		      {
	        		    	  // se ve si hay penalizacion de turno por caer en "trampas" caso Muerte
	        		    	  casillatrampas = casillatrampaficha(lasfichas[turnode], tapete,lasfichas[turnode].quecasilla());
	        		    // se pasa turno...
	        		    	  pasaturno(tapete,lasfichas[turnode]);
	        		      }
	        		      {for (int fi=0 ;fi<4;fi++){ //ajustará las fichas para que no se "pisen" si estan en la misma casilla
	        		    	  	if (turnode!=fi && lasfichas[turnode].quecasilla()==lasfichas[fi].quecasilla())
	        		    	  			{nopisarotras(lasfichas[fi],tapete);nopisarotras(lasfichas[turnode],tapete);
	        		    	  			};
	        		      				}
	        		    	  
	        		      };
	        		      
	        		    	};
	        		     
	        		 
					
				}while (modojuego==1);// hasta aqui estamos en modo 1(JUGANDO)
				
				/*****************parte modo juego 4*******************************/
				do{// estamos en modo alguien llegó a meta
					//System.out.println("ha ganado la ficha");Thread.sleep(6000);
					lasfichas[turnode].fichahappy(turnode, 300, 300);
				}while (modojuego==4);
		
				
				
				} while (modojuego!=3);
	
	
	}

	private static void colocarFichasConfig 
	(Tablero tblins, Ficha fichains0,Ficha fichains1,Ficha fichains2,Ficha fichains3) throws InterruptedException{
		// pasamos el tablero y las fichas instanciados para mover las fichas en modo configuracion
		//ficha0
		//System.out.println("roja estado="+tblins.jugadores[0][0]+" casilla roja:"+fichains0.quecasilla());
		if (tblins.jugadores[0][0]>0 && fichains0.quecasilla()==0){
			fichains0.cambiacasilla(1);
		fichains0.moverdesdehasta(fichains0.dondeX(),fichains0.dondeY(),
				tblins.casillas4[4][0] , tblins.casillas4[4][1]);}
		
		if (tblins.jugadores[0][0]==0 && fichains0.quecasilla()==1){
			//System.out.println("Se cumple regresar roja");
			fichains0.cambiacasilla(0);
		fichains0.moverdesdehasta(fichains0.dondeX(),fichains0.dondeY() ,
				tblins.casillas4[0][0] , tblins.casillas4[0][1]);}
		//ficha 1
		if (tblins.jugadores[1][0]>0 && fichains1.quecasilla()==0){
		fichains1.moverdesdehasta(tblins.casillas4[1][0],tblins.casillas4[1][1] ,
				tblins.casillas4[5][0] , tblins.casillas4[5][1]);
		fichains1.cambiacasilla(1);}
		if (tblins.jugadores[1][0]==0 && fichains1.quecasilla()==1){
		fichains1.moverdesdehasta(tblins.casillas4[5][0],tblins.casillas4[5][1] ,
				tblins.casillas4[1][0] , tblins.casillas4[1][1]);
		fichains1.cambiacasilla(0);}
		//ficha 2
		 if (tblins.jugadores[2][0]>0 && fichains2.quecasilla()==0){
		
			fichains2.moverdesdehasta(tblins.casillas4[2][0],tblins.casillas4[2][1] ,
				tblins.casillas4[6][0] , tblins.casillas4[6][1]);
			fichains2.cambiacasilla(1);}
		 if (tblins.jugadores[2][0]==0 && fichains2.quecasilla()==1){
		
		fichains2.moverdesdehasta(tblins.casillas4[6][0],tblins.casillas4[6][1] ,
				tblins.casillas4[2][0] , tblins.casillas4[2][1]);
		fichains2.cambiacasilla(0);}
		//ficha 3
		 if (tblins.jugadores[3][0]>0 && fichains3.quecasilla()==0){
				
		fichains3.moverdesdehasta(tblins.casillas4[3][0],tblins.casillas4[3][1] ,
				tblins.casillas4[7][0] , tblins.casillas4[7][1]);
		fichains3.cambiacasilla(1);}
		 if (tblins.jugadores[3][0]==0 && fichains3.quecasilla()==1){
				
		fichains3.moverdesdehasta(tblins.casillas4[7][0],tblins.casillas4[7][1] ,
				tblins.casillas4[3][0] , tblins.casillas4[3][1]);
		fichains3.cambiacasilla(0);}
			
	
	}
	private static int quienmueve(Tablero tabla){ //dará el numero de jugador/ficha que actualmente tiene el turno=0
		int mueve=7; //PARA FORZAR ERRORES SI NO VA BIEN
		for (int t=0;t<4;t++){
			if (tabla.jugadores[t][1]==0 && tabla.jugadores[t][0]>0){
				mueve= t;} //que sea su turno y que sea humano o máquina
		};
			return mueve; //valor irreal
		};
		private  static void pasaturno (Tablero tabla,Ficha pastilla) throws InterruptedException{// cambiará la matriz para pasar el turno al siguiente
			int cambiado=0;
					int conta=pastilla.quefichaes();
			// añadimos el turno al jugador actual
			tabla.jugadores[pastilla.quefichaes()][1]++;
			do {
				//tabla.jugadores[conta][1]++;//retrasamos el turno natural a la ficha actual
				conta++; //pasamos de ficha
				if (conta>3){conta=0;};
				if (tabla.jugadores[conta][0]>0){//solo se pasa el turno si juega ... humano o maquina
				tabla.jugadores[conta][1]--; 
				if (tabla.jugadores[conta][1]==3){ //es que la ficha esta en alguna trampa y tiene que esperar mostramos los mensajes...
					tabla.mensajes(7);
					
				} 
				if (tabla.jugadores[conta][1]==2){ //es que la ficha esta en alguna trampa y tiene que esperar mostramos los mensajes...
					tabla.mensajes(8);
					
				}
				//System.out.println("quitado 1 a ficha:"+conta);
					if (tabla.jugadores[conta][1]==0) {cambiado=1;} // se ha producido cambio de turno
				}
				
			}while(cambiado==0);
						
		};
		
	private static int moverfichadesdeapasoapaso (Ficha pastilla,Tablero tabla,int casillasrecorrer) throws InterruptedException{
		int casillainicial=pastilla.quecasilla();
		int quedaen;
		for (int ca=casillainicial;ca<(casillainicial+casillasrecorrer);ca++) //modificacion:quitamos 1 para el ajuste de no pisarse
				{
			pastilla.moverdesdehasta(
					pastilla.dondeX(), pastilla.dondeY(), tabla.casillas[ca+1][1],tabla.casillas[ca+1][2]);
			//[(ca+1)*(nficha)][0],tabla.casillas4[(ca+1)*(nficha)][1]
			
		}
		
		// AJUSTE PARA QUE NO SE PISEN LAS FICHAS (ultimo paso)
		 quedaen = casillasrecorrer+pastilla.quecasilla();
		
		return quedaen;
	};
	public static void nopisarotras(Ficha pastilla,Tablero tabla) throws InterruptedException{
		int quedaen=pastilla.quecasilla(); //para ajustar la posicion de la ficha y que no se pisen
		
		pastilla.moverdesdehasta(pastilla.dondeX(), pastilla.dondeY(),
				tabla.casillas4[(quedaen*4)+pastilla.quefichaes()][0], //posicion x de la casilla para la ficha actual en tabla4 
				tabla.casillas4[(quedaen*4)+pastilla.quefichaes()][1]); //posicion y de ...
						
	}
	private static void moverfichasalto(Ficha pastilla, Tablero tabla,int casilladestino) throws InterruptedException{
		pastilla.moverdesdehasta(pastilla.dondeX(), pastilla.dondeY(),
				tabla.casillas4[(casilladestino*4)+pastilla.quefichaes()][0],tabla.casillas4[(casilladestino*4)+pastilla.quefichaes()][1]);
		
	};
	private static int casillacaidaficha(Ficha pastilla, Tablero tabla, int casilladestino) throws InterruptedException{
		/* retorna la casilla real donde cae una ficha 
		 * evaluando las posibilidades siguientes ocas, puentes, dados , rebote final*/
		int posact=pastilla.quecasilla();
		//System.out.println("estoy en la oca de la casilla: "+posact);
		
		//do {} while (encontrado==0||tabla.ocas.length==)
		for (int recorre=0;recorre<(tabla.ocas.length);recorre++){
			if (posact==tabla.ocas[recorre]){
				tabla.mensajes(3);
				//System.out.println("estoy en la oca de la casilla: "+posact+"debo saltar a"+tabla.ocas[(recorre+1)]);
				Thread.sleep(1000);
				//llama al mensaje y ruido de oca oca...
				 casilladestino=tabla.ocas[(recorre+1)];
				
			}
		}
		// vamos a ver si hemos caido en puente...
		if (tabla.puentes[0]==posact) {// llama mensaje de dado
		casilladestino=tabla.puentes[1];
		tabla.mensajes(4);
		}
		if (tabla.puentes[1]==posact) {// llama mensaje de dado
			casilladestino=tabla.puentes[0];
			tabla.mensajes(4);
			}
		// vamos a ver si hemos caido en dados...
				if (tabla.dedado[0]==posact) {// llama mensaje de dado
				casilladestino=tabla.dedado[1];
				tabla.mensajes(5);
				
				}
				if (tabla.dedado[1]==posact) {// llama mensaje de dado
					casilladestino=tabla.dedado[0];
					tabla.mensajes(5);
					}
				// vamos a ver si hemos caido en "muerte"
				if (tabla.muerte==posact) {// llama mensaje de la muerte
					tabla.mensajes(18);
					// pasaturno(tabla,pastilla);//forzamos a perder  turnos
					//tabla.jugadores[pastilla.quefichaes()][1]=1; 
							casilladestino=1;
							
				
				}
				
	//evaluar si ha habido salto:
				if (posact!=casilladestino){
				moverfichasalto(pastilla,tabla,casilladestino);}
				pastilla.cambiacasilla(casilladestino);
			return casilladestino;
		}
		

	private static int casillatrampaficha(Ficha pastilla, Tablero tabla, int casilladestino)
			throws InterruptedException{
		/* retorna la casilla real donde cae una ficha 
		 * evaluando las posibilidades siguientes ocas, puentes, dados , rebote final*/
		int posact=pastilla.quecasilla();
		// vamos a ver si hemos caido en pozo,posada,laberinto...
		for (int recorre=0;recorre<(tabla.trampas.length);recorre++){
			if (posact==tabla.trampas[recorre]){
				//llamara al mensaje lamentando el evento y si tiene que esperar turnos 
				//añadimos los turnos sin tirar 3
				tabla.jugadores[pastilla.quefichaes()][1]=3; //forzamos a perder 3 turnos
				tabla.mensajes(6);
				
				//System.out.println("he caido en la trampa de la csilla "+posact);
				
				
			}
		}
		
	
				if (posact!=casilladestino){
				moverfichasalto(pastilla,tabla,casilladestino);}
				pastilla.cambiacasilla(casilladestino);
			return casilladestino;
		}
	}

		//fin de la aplicacion
		
	
		
		
		
		
		
	

		
		


