package JuegoProgramacion;

import java.awt.Point;

import graphics2.*;

public class Juego {

	public static void main(String[] args) throws InterruptedException {

//DECLARO VARIABLES ENTERAS Y STRING
		
		int turno=1,jugador1=0,jugador2=0,jugador3=0,jugador4=0,uno=0,dos=0,tres=0,cuatro=0,tirada=0,aleatorio=0;
		
		
//Especifico el fondo y toda la pagina de presentacion.
	
			
		Canvas lienzo;
		lienzo = Canvas.getInstance();
		
		Picture fondo = new Picture("src/JuegoProgramacion/fondo.jpg");
			fondo.draw();
		Picture inicio1 = new Picture("src/JuegoProgramacion/numeros/iniciouno.png");
			inicio1.translate(170, 70);
			inicio1.draw();
		Picture inicio2 = new Picture("src/JuegoProgramacion/numeros/iniciodos.png");
			inicio2.translate(270, 230);
			inicio2.draw();
		
		Picture inicio3 = new Picture("src/JuegoProgramacion/numeros/jugador2.png");	
			inicio3.translate(500, 450);
			inicio3.draw();
			
		Picture inicio4 = new Picture("src/JuegoProgramacion/numeros/jugador3.png");	
			inicio4.translate(500, 500);
			inicio4.draw();
			
		Picture inicio5 = new Picture("src/JuegoProgramacion/numeros/jugador4.png");	
			inicio5.translate(500, 550);
			inicio5.draw();	
			
		Text carlos=new Text(518,700,"Creado por Carlos Domínguez Ferrer.");
		carlos.setColor(Color.WHITE);
		carlos.grow(10, 10);
		carlos.draw();
		
		Text version=new Text(1230,720,"v 1.0");
		version.setColor(Color.WHITE);
		version.draw();
		

//figuritas del inicio
			
		Picture iniciocoche=new Picture("src/JuegoProgramacion/fichas/cocheG.png");
		Picture iniciobota=new Picture("src/JuegoProgramacion/fichas/botaG.png");
		Picture inicioperro=new Picture("src/JuegoProgramacion/fichas/perroG.png");
		Picture iniciosombrero=new Picture("src/JuegoProgramacion/fichas/sombreroG.png");	
		Picture iniciocarretilla=new Picture("src/JuegoProgramacion/fichas/carretillaG.png");
		Picture iniciodedal=new Picture("src/JuegoProgramacion/fichas/dedalG.png");
				
		iniciocoche.translate(30, 300); iniciocoche.draw();
		iniciobota.translate(80, 500); iniciobota.draw();
		iniciodedal.translate(350, 400); iniciodedal.draw();		
		inicioperro.translate(800, 380); inicioperro.draw();	
		iniciocarretilla.translate(1000, 550); iniciocarretilla.draw();	
		iniciosombrero.translate(1050, 300); iniciosombrero.draw();	
		
	
	
//ESTE ES EL MENU DEL INICIO, PARA SABER DONDE PINCHA EL USUARIO.
				
		while (true){
			Point pulsacion12 = lienzo.waitMouseClick();	
			
			//Dos jugadores
			if (pulsacion12.x>500&&pulsacion12.x<730&&pulsacion12.y>450&&pulsacion12.y<491){
				tres=-1;
				cuatro=-1;
				
				iniciocoche.undraw();
				iniciodedal.undraw();
				iniciocarretilla.undraw();
				inicioperro.undraw();
				iniciosombrero.undraw();
				iniciobota.undraw();
				inicio1.undraw();
				inicio2.undraw();
				inicio3.undraw();
				inicio4.undraw();
				inicio5.undraw();
				carlos.undraw();
				version.undraw();
				
				break;
				
			//tres jugadores
			}else if (pulsacion12.x>500&&pulsacion12.x<730&&pulsacion12.y>500&&pulsacion12.y<543){
				cuatro=-1;
				
				iniciocoche.undraw();
				iniciodedal.undraw();
				iniciocarretilla.undraw();
				inicioperro.undraw();
				iniciosombrero.undraw();
				iniciobota.undraw();
				inicio1.undraw();
				inicio2.undraw();
				inicio3.undraw();
				inicio4.undraw();
				inicio5.undraw();
				carlos.undraw();	
				version.undraw();
				
				break;
				
			//cuatro jugadores	
			}else if (pulsacion12.x>500&&pulsacion12.x<730&&pulsacion12.y>550&&pulsacion12.y<592){
				
				iniciocoche.undraw();
				iniciodedal.undraw();
				iniciocarretilla.undraw();
				inicioperro.undraw();
				iniciosombrero.undraw();
				iniciobota.undraw();
				inicio1.undraw();
				inicio2.undraw();
				inicio3.undraw();
				inicio4.undraw();
				inicio5.undraw();
				carlos.undraw();
				version.undraw();
				
				break;
			}
			
		}
		lienzo.repaint();
		
//Especifico tablero y lista de calles:			
		Picture tablero = new Picture("src/JuegoProgramacion/tablero.jpg");
			tablero.draw();
			tablero.translate(40, 40);
		Picture lista=new Picture("src/JuegoProgramacion/listacalles.png");
			lista.draw();
			lista.translate(780, 160);
			
		Rectangle borde=new Rectangle (37,37,681,681);
		borde.setThickness(4);
		borde.draw();
  					
//declaro todos los arrays que voy a utilizar, algunos con valores para identificar algunas casillas.
		

		int[] chupitos={0,1,0,1,4,4,2,0,2,2,0,3,3,3,3,4,3,0,3,4,0,4,0,4,4,4,4,4,3,4,0,6,6,0,6,4,0,6,2,7};
		int[] sicaes={0,1,0,1,0,1,1,0,1,1,0,2,3,2,2,1,1,0,1,1,0,1,0,1,1,1,2,2,3,2,0,2,2,0,2,1,0,6,0,6};
		int[] cordenadas={0,695,0,670,0,0,645,0,620,595,0,570,0,545,520,0,495,0,470,445,0,420,0,395,370,0,345,320,0,295,0,270,245,0,220,0,0,195,0,170};
		int [] sorpresachupitos={4,3,4,3,2,1,3,0,1,1,4,2,4,3,2};
		int [] tesoreriachupitos={4,3,2,4,3,2,3,3,4,7,2,2,3,2,4};
		
		String [] jugadores={"0","Jugador 1","Jugador 2","Jugador 3","Jugador 4"};
		String[] adquiridas=new String [40];
		

		
//Declaro las formas e imagenes que voy a utilizar
		
	  
		Rectangle rectangulo;

		Text nombre,tabla1;
		nombre=new Text(0,0,"");
		
		
//Calles
		Picture [] cartas;
		cartas=new Picture[40];
		cartas[1]=new Picture("src/JuegoProgramacion/cartas/c1.jpg");
		cartas[3]=new Picture("src/JuegoProgramacion/cartas/c3.jpg");
		cartas[5]=new Picture("src/JuegoProgramacion/cartas/c5.jpg");
		cartas[6]=new Picture("src/JuegoProgramacion/cartas/c6.jpg");
		cartas[8]=new Picture("src/JuegoProgramacion/cartas/c8.jpg");
		cartas[9]=new Picture("src/JuegoProgramacion/cartas/c9.jpg");
		cartas[11]=new Picture("src/JuegoProgramacion/cartas/c11.jpg");
		cartas[12]=new Picture("src/JuegoProgramacion/cartas/c12.jpg");
		cartas[13]=new Picture("src/JuegoProgramacion/cartas/c13.jpg");
		cartas[14]=new Picture("src/JuegoProgramacion/cartas/c14.jpg");
		cartas[15]=new Picture("src/JuegoProgramacion/cartas/c15.jpg");
		cartas[16]=new Picture("src/JuegoProgramacion/cartas/c16.jpg");
		cartas[18]=new Picture("src/JuegoProgramacion/cartas/c18.jpg");
		cartas[19]=new Picture("src/JuegoProgramacion/cartas/c19.jpg");
		cartas[21]=new Picture("src/JuegoProgramacion/cartas/c21.jpg");
		cartas[23]=new Picture("src/JuegoProgramacion/cartas/c23.jpg");
		cartas[24]=new Picture("src/JuegoProgramacion/cartas/c24.jpg");
		cartas[25]=new Picture("src/JuegoProgramacion/cartas/c25.jpg");
		cartas[26]=new Picture("src/JuegoProgramacion/cartas/c26.jpg");
		cartas[27]=new Picture("src/JuegoProgramacion/cartas/c27.jpg");
		cartas[28]=new Picture("src/JuegoProgramacion/cartas/c28.jpg");
		cartas[29]=new Picture("src/JuegoProgramacion/cartas/c29.jpg");
		cartas[31]=new Picture("src/JuegoProgramacion/cartas/c31.jpg");
		cartas[32]=new Picture("src/JuegoProgramacion/cartas/c32.jpg");
		cartas[34]=new Picture("src/JuegoProgramacion/cartas/c34.jpg");
		cartas[35]=new Picture("src/JuegoProgramacion/cartas/c35.jpg");
		cartas[37]=new Picture("src/JuegoProgramacion/cartas/c37.jpg");
		cartas[39]=new Picture("src/JuegoProgramacion/cartas/c39.jpg");
		
		cartas[1].translate(50, 230);
		cartas[3].translate(50, 230);
		cartas[5].translate(50, 230);
		cartas[6].translate(50, 230);
		cartas[8].translate(50, 230);
		cartas[9].translate(50, 230);
		cartas[11].translate(50, 230);
		cartas[12].translate(50, 230);
		cartas[13].translate(50, 230);
		cartas[14].translate(50, 230);
		cartas[15].translate(50, 230);
		cartas[16].translate(50, 230);
		cartas[18].translate(50, 230);
		cartas[19].translate(50, 230);
		cartas[21].translate(50, 230);
		cartas[23].translate(50, 230);
		cartas[24].translate(50, 230);
		cartas[25].translate(50, 230);
		cartas[26].translate(50, 230);
		cartas[27].translate(50, 230);
		cartas[28].translate(50, 230);
		cartas[29].translate(50, 230);
		cartas[31].translate(50, 230);
		cartas[32].translate(50, 230);
		cartas[34].translate(50, 230);
		cartas[35].translate(50, 230);
		cartas[37].translate(50, 230);
		cartas[39].translate(50, 230);
		
		
//cartas de sorpresa y tesoreria
		
		Picture [] sorpresa=new Picture[15];
		
	    sorpresa[0]=new Picture("src/JuegoProgramacion/sorpresa/sorpresa1.jpg");
	    sorpresa[1]=new Picture("src/JuegoProgramacion/sorpresa/sorpresa2.jpg");
	    sorpresa[2]=new Picture("src/JuegoProgramacion/sorpresa/sorpresa3.jpg");
	    sorpresa[3]=new Picture("src/JuegoProgramacion/sorpresa/sorpresa4.jpg");
	    sorpresa[4]=new Picture("src/JuegoProgramacion/sorpresa/sorpresa5.jpg");
	    sorpresa[5]=new Picture("src/JuegoProgramacion/sorpresa/sorpresa6.jpg");
	    sorpresa[6]=new Picture("src/JuegoProgramacion/sorpresa/sorpresa7.jpg");
	    sorpresa[7]=new Picture("src/JuegoProgramacion/sorpresa/sorpresa8.jpg");
	    sorpresa[8]=new Picture("src/JuegoProgramacion/sorpresa/sorpresa9.jpg");
	    sorpresa[9]=new Picture("src/JuegoProgramacion/sorpresa/sorpresa10.jpg");
	    sorpresa[10]=new Picture("src/JuegoProgramacion/sorpresa/sorpresa11.jpg");
	    sorpresa[11]=new Picture("src/JuegoProgramacion/sorpresa/sorpresa12.jpg");
	    sorpresa[12]=new Picture("src/JuegoProgramacion/sorpresa/sorpresa13.jpg");
	    sorpresa[13]=new Picture("src/JuegoProgramacion/sorpresa/sorpresa14.jpg");
	    sorpresa[14]=new Picture("src/JuegoProgramacion/sorpresa/sorpresa15.jpg");
	   
//Aki le marco las posicion donde se imprimira.
		for (int i=0;i<sorpresa.length;i++){ sorpresa[i].translate(50, 230);}
		
		
		Picture [] tesoreria=new Picture[15];
		
	    tesoreria[0]=new Picture("src/JuegoProgramacion/tesoreria/tesoreria1.jpg");
	    tesoreria[1]=new Picture("src/JuegoProgramacion/tesoreria/tesoreria2.jpg");
	    tesoreria[2]=new Picture("src/JuegoProgramacion/tesoreria/tesoreria3.jpg");
	    tesoreria[3]=new Picture("src/JuegoProgramacion/tesoreria/tesoreria4.jpg");
	    tesoreria[4]=new Picture("src/JuegoProgramacion/tesoreria/tesoreria5.jpg");
	    tesoreria[5]=new Picture("src/JuegoProgramacion/tesoreria/tesoreria6.jpg");
	    tesoreria[6]=new Picture("src/JuegoProgramacion/tesoreria/tesoreria7.jpg");
	    tesoreria[7]=new Picture("src/JuegoProgramacion/tesoreria/tesoreria8.jpg");
	    tesoreria[8]=new Picture("src/JuegoProgramacion/tesoreria/tesoreria9.jpg");
	    tesoreria[9]=new Picture("src/JuegoProgramacion/tesoreria/tesoreria10.jpg");
	    tesoreria[10]=new Picture("src/JuegoProgramacion/tesoreria/tesoreria11.jpg");
	    tesoreria[11]=new Picture("src/JuegoProgramacion/tesoreria/tesoreria12.jpg");
	    tesoreria[12]=new Picture("src/JuegoProgramacion/tesoreria/tesoreria13.jpg");
	    tesoreria[13]=new Picture("src/JuegoProgramacion/tesoreria/tesoreria14.jpg");
	    tesoreria[14]=new Picture("src/JuegoProgramacion/tesoreria/tesoreria15.jpg");
		
//Aki le marco las posicion donde se imprimira.
	   for (int i=0;i<tesoreria.length;i++){ tesoreria[i].translate(50, 230);}
		
	    
//Numeros de xupitos que te toca beber.
		Picture [] numeros;
		numeros=new Picture[8];
		numeros[0]=new Picture("src/JuegoProgramacion/numeros/cero.png");		
		numeros[1]=new Picture("src/JuegoProgramacion/numeros/uno.png");
		numeros[2]=new Picture("src/JuegoProgramacion/numeros/dos.png");
		numeros[3]=new Picture("src/JuegoProgramacion/numeros/tres.png");
		numeros[4]=new Picture("src/JuegoProgramacion/numeros/cuatro.png");
		numeros[5]=new Picture("src/JuegoProgramacion/numeros/cinco.png");
		numeros[6]=new Picture("src/JuegoProgramacion/numeros/seis.png");
		numeros[7]=new Picture("src/JuegoProgramacion/numeros/siete.png");
		
//Aki le marco la posicion donde se tienen que imprimir.
		
		for (int i=0;i<numeros.length;i++){ numeros[i].translate(640, 355);}	
		
		
		Picture vasoG=new Picture("src/JuegoProgramacion/menus/vasoG.png");
		Picture pulgar0=new Picture("src/JuegoProgramacion/menus/pulgar0.png");
		Picture pulgar1=new Picture("src/JuegoProgramacion/menus/pulgar1.png");
		Picture equis=new Picture ("src/JuegoProgramacion/numeros/equis.png");				
		Picture comprar=new Picture ("src/JuegoProgramacion/numeros/comprar.png");
	
		pulgar0.translate(1100, 390);
	    pulgar1.translate(900, 390);
		vasoG.translate(350, 290);
		equis.translate(560, 390);
		comprar.translate(850, 290);
		
		
		Picture dueño1=new Picture("src/JuegoProgramacion/numeros/dueño1.png");
		Picture dueño2=new Picture("src/JuegoProgramacion/numeros/dueño2.png");
		Picture dueño3=new Picture("src/JuegoProgramacion/numeros/dueño3.png");
		Picture dueño4=new Picture("src/JuegoProgramacion/numeros/dueño4.png");
		Picture eresdueño=new Picture("src/JuegoProgramacion/numeros/eresdueño.png");
		Picture continuar=new Picture("src/JuegoProgramacion/numeros/continuar.png");
		dueño1.translate(500, 150);
		dueño2.translate(500, 150);
		dueño3.translate(500, 150);
		dueño4.translate(500, 150);
		eresdueño.translate(250, 150);
		continuar.translate(800, 330);

		
		Picture guardia=new Picture("src/JuegoProgramacion/numeros/carcel.jpg");
		Picture sintirar=new Picture("src/JuegoProgramacion/numeros/sintirar.png");
		guardia.translate(400, 170);
		sintirar.translate(10, 170);

		Picture alcohol=new Picture("src/JuegoProgramacion/cartas/alcohol.jpg");
		Picture lujo=new Picture("src/JuegoProgramacion/cartas/lujo.jpg");
		alcohol.translate(50, 230);
		lujo.translate(50, 230);
		
		
//Fichas grandes
				Picture cocheG=new Picture("src/JuegoProgramacion/fichas/cocheG.png");
				Picture botaG=new Picture("src/JuegoProgramacion/fichas/botaG.png");
				Picture perroG=new Picture("src/JuegoProgramacion/fichas/perroG.png");
				Picture sombreroG=new Picture("src/JuegoProgramacion/fichas/sombreroG.png");
				cocheG.translate(1080, 5);
				botaG.translate(1080, 5);
				perroG.translate(1080, 5);
				sombreroG.translate(1090, 30);
				
//Fichas pequeñas
				Picture coche=new Picture("src/JuegoProgramacion/fichas/coche.png");
				Picture bota=new Picture("src/JuegoProgramacion/fichas/bota.png");
				Picture perro=new Picture("src/JuegoProgramacion/fichas/perro.png");
				Picture sombrero=new Picture("src/JuegoProgramacion/fichas/sombrero.png");
		
				
//PRIMERO SE IMPRIMEN LAS FICHAS QUE VAN A RECORRER EL TABLERO
				
				coche.draw(); coche.translate(630, 620);
				bota.draw();  bota.translate(670, 630);
				
				if (tres==0){ perro.draw();  perro.translate(625, 655); }
				if (cuatro==0){ sombrero.draw(); sombrero.translate(668, 678); }				
		
//-----------------------------------------------------------AKI EMPIEZA EL JUEGO-------------------------------------------------------------------------		
								
		while (true){
			
			Picture dado0=new Picture("src/JuegoProgramacion/dado/dado0.png");
			dado0.translate(780, 30);
			dado0.draw();
			
//----------------------------------------------------------------JUGADOR1--------------------------------------------------------------------------------	
						
		if (uno!=0){ uno--; }	
		if ((uno==0)&&(turno==1)){
			
//Imprimo el nombre del jugador
			nombre.undraw();
			nombre=new Text(1000,60,jugadores[turno]);
			nombre.grow(50, 50);
			nombre.setColor(Color.WHITE);
			nombre.draw();
		
//Imprimo la ficha del jugador en grande.
			sombreroG.undraw();
			cocheG.undraw();
			botaG.undraw();
			perroG.undraw();

			cocheG.draw();
				
//AKI SE MARCAN LAS CORDENADAS DEL DADO
			while (true){
				Point pulsacion = lienzo.waitMouseClick();	
				if (pulsacion.x>780&&pulsacion.x<880&&pulsacion.y>30&&pulsacion.y<129){
					break;
				}
			}
			
//AKI SE COLOCAN LAS FICHAS SEGUN LA TIRADA
		
			tirada=Juego.Dado();
					
			for (int x=1;x<=tirada;x++){
					
				if ((jugador1+x)<10){ 						coche.translate(-55,0); 	Thread.sleep(500);}		
				else if (jugador1+x==10){					coche.translate(-55,60); 	Thread.sleep(500);}
				else if (jugador1+x==11){ 					coche.translate(6,-100); 	Thread.sleep(500);}
				else if (jugador1+x>11&&jugador1+x<20){ 	coche.translate(0,-55); 	Thread.sleep(500);}					
				else if (jugador1+x==20){ 					coche.translate(-6,-100); 	Thread.sleep(500);}
				else if (jugador1+x>=21&&jugador1+x<30){ 	coche.translate(55,0); 		Thread.sleep(500);}
				else if (jugador1+x==30){ 					coche.translate(55,0); 		Thread.sleep(500);}
				else if (jugador1+x==31){ 					coche.translate(0,100); 	Thread.sleep(500);}
				else if (jugador1+x>31&&jugador1+x<40){ 	coche.translate(0,55); 		Thread.sleep(500);}
				else if (jugador1+x==40){ 					coche.translate(0,40); 		jugador1=jugador1-40; Thread.sleep(500);}								
			}//for
			jugador1=jugador1+tirada;
			Thread.sleep(500);
			
					
//AKI SE COMPRUEBA QUE LA CASILLA DONDE HA CAIDO SE PUEDE COMPRAR O NO
			
			rectangulo=new Rectangle (0,150,1280,400);
			rectangulo.setColor(Color.BLACK);
			rectangulo.fill();
			rectangulo.undraw();
			
			
			
//AKI COMPRUEBO SI EL JUGADOR HA CAIDO EN LA CASILLA DE IR A LA CARCEL.			
		
			if (jugador1==30){
			
				rectangulo.fill();
				pulgar1.draw();
				continuar.draw();
				guardia.draw();
				sintirar.draw();		
			
			while (true){
				Point pulsacion9 = lienzo.waitMouseClick();	
				
				if (pulsacion9.x>904&&pulsacion9.x<994&&pulsacion9.y>395&&pulsacion9.y<481){

					continuar.undraw();
					pulgar1.undraw();
					rectangulo.undraw();
					guardia.undraw();
					sintirar.undraw();
					break;
				}//if
			}//while	
					
//Muevo la ficha a la carcel.
			
					tirada=20;
					for (int x=1;x<=tirada;x++){
						
						if ((jugador1+x)<10){ 						coche.translate(-55,0); 	Thread.sleep(500);}		
						else if (jugador1+x==10){					coche.translate(-55,60); 	Thread.sleep(500);}
						else if (jugador1+x==11){ 					coche.translate(6,-100); 	Thread.sleep(500);}
						else if (jugador1+x>11&&jugador1+x<20){ 	coche.translate(0,-55); 	Thread.sleep(500);}					
						else if (jugador1+x==20){ 					coche.translate(-6,-100); 	Thread.sleep(500);}
						else if (jugador1+x>=21&&jugador1+x<30){ 	coche.translate(55,0); 		Thread.sleep(500);}
						else if (jugador1+x==30){ 					coche.translate(55,0); 		Thread.sleep(500);}
						else if (jugador1+x==31){ 					coche.translate(0,100); 	Thread.sleep(500);}
						else if (jugador1+x>31&&jugador1+x<40){ 	coche.translate(0,55); 		Thread.sleep(500);}
						else if (jugador1+x==40){ 					coche.translate(0,40); 		jugador1=jugador1-40; Thread.sleep(500);}								
					}//for
					jugador1=jugador1+tirada;
					uno=3;
		
		}//IF de la casilla 30.
			
		
			
//Aki controlo las calles de los impuestos
			
			if (jugador1==4){
					
			rectangulo.fill();
			alcohol.draw();
			equis.draw();
			numeros[4].draw();
			vasoG.draw();
			pulgar1.draw();
			continuar.draw();
		
			
				while (true){
					Point pulsacion10 = lienzo.waitMouseClick();	
				
					if (pulsacion10.x>904&&pulsacion10.x<994&&pulsacion10.y>395&&pulsacion10.y<481){
					
						rectangulo.undraw();
						alcohol.undraw();
						equis.undraw();
						numeros[4].undraw();
						vasoG.undraw();
						pulgar1.undraw();
						continuar.undraw();
								
						break;
					}
				}					
			
			}
			
			
			if (jugador1==38){
				
				rectangulo.fill();
				lujo.draw();
				equis.draw();
				numeros[2].draw();
				vasoG.draw();
				pulgar1.draw();
				continuar.draw();
				
					while (true){
						Point pulsacion11 = lienzo.waitMouseClick();	
					
						if (pulsacion11.x>904&&pulsacion11.x<994&&pulsacion11.y>395&&pulsacion11.y<481){
						
							rectangulo.undraw();
							lujo.undraw();
							equis.undraw();
							numeros[2].undraw();
							vasoG.undraw();
							pulgar1.undraw();
							continuar.undraw();
									
							break;
						}
					}					
				
				}
				
			
//CUANDO ES TESORERIA O SORPRESA				
			
			//TESORERIA
			if (jugador1==2||jugador1==17||jugador1==33){
				
				aleatorio=(int)(Math.random()*15);
				rectangulo.fill();
				tesoreria[aleatorio].draw();
				pulgar1.draw();
				continuar.draw();
				equis.draw();
				vasoG.draw();
				numeros[tesoreriachupitos[aleatorio]].draw();
				
				
				while (true){
					Point pulsacion7 = lienzo.waitMouseClick();	
					
					if (pulsacion7.x>904&&pulsacion7.x<994&&pulsacion7.y>395&&pulsacion7.y<481){
						
						continuar.undraw();
						pulgar1.undraw();
						rectangulo.undraw();
						tesoreria[aleatorio].undraw();
						numeros[tesoreriachupitos[aleatorio]].undraw();
						vasoG.undraw();
						equis.undraw();
						
					break;
					}
				}					
				
			
			}
//Sorpresa				
			if (jugador1==7||jugador1==22||jugador1==36){
				
				aleatorio=(int)(Math.random()*15);
				
				rectangulo.fill();
				sorpresa[aleatorio].draw();
				pulgar1.draw();
				continuar.draw();
				equis.draw();
				vasoG.draw();
				numeros[sorpresachupitos[aleatorio]].draw();
				
				
				
				while (true){
					Point pulsacion8 = lienzo.waitMouseClick();	
					
					if (pulsacion8.x>904&&pulsacion8.x<994&&pulsacion8.y>395&&pulsacion8.y<481){

						continuar.undraw();
						pulgar1.undraw();
						rectangulo.undraw();
						sorpresa[aleatorio].undraw();
						numeros[sorpresachupitos[aleatorio]].undraw();
						vasoG.undraw();
						equis.undraw();
						
					break;
					}//if
				}//while					
				
			}//if
						
	
			if (jugador1==1||jugador1==3||jugador1==5||jugador1==6||jugador1==8||jugador1==9||jugador1==11||jugador1==12||jugador1==13||jugador1==14||jugador1==15||jugador1==16||jugador1==18||jugador1==19||jugador1==21||jugador1==23||jugador1==24||jugador1==25||jugador1==26||jugador1==27||jugador1==28||jugador1==29||jugador1==31||jugador1==32||jugador1==34||jugador1==35||jugador1==37||jugador1==39){
				
				rectangulo.fill();
								
//AKI IMPRIMO LA CARTA DE LA CASILLA DONDE HA CAIDO EL JUGADOR
									
				cartas[jugador1].draw();
				
//
//AKI COMPRUEBO EL PROPIETARIO DE LA CARTA.
//

				
//CUANDO LA CALLE ES TUYA
				if (adquiridas[jugador1]=="jugador1"){
					eresdueño.draw();
					continuar.draw();
					pulgar1.draw();
									
					while (true){
						Point pulsacion2 = lienzo.waitMouseClick();	
						
						if (pulsacion2.x>904&&pulsacion2.x<994&&pulsacion2.y>395&&pulsacion2.y<481){
							eresdueño.undraw();
							continuar.undraw();
							pulgar1.undraw();
							rectangulo.undraw();
							cartas[jugador1].undraw();
						break;
						}
					}
						
//CUANDO EL PROPIETARIO ES EL JUGADOR 2
				}else if (adquiridas[jugador1]=="jugador2"){
											
					dueño2.draw();
					continuar.draw();
					pulgar1.draw();
					equis.draw();
					vasoG.draw();
					numeros[sicaes[jugador1]].draw();
										
					while (true){
						Point pulsacion3 = lienzo.waitMouseClick();	
						
						if (pulsacion3.x>904&&pulsacion3.x<994&&pulsacion3.y>395&&pulsacion3.y<481){
							dueño2.undraw();
							continuar.undraw();
							pulgar1.undraw();
							rectangulo.undraw();
							cartas[jugador1].undraw();
							equis.undraw();
							vasoG.undraw();
							numeros[sicaes[jugador1]].undraw();
							
						break;
						}
					}					
					
					
//CUANDO EL PROPIETARIO ES EL JUGADOR 3
				}else if (adquiridas[jugador1]=="jugador3"){
					
					dueño3.draw();
					continuar.draw();
					pulgar1.draw();
					equis.draw();
					vasoG.draw();
					numeros[sicaes[jugador1]].draw();
					
					
					while (true){
						Point pulsacion4 = lienzo.waitMouseClick();	
						
						if (pulsacion4.x>904&&pulsacion4.x<994&&pulsacion4.y>395&&pulsacion4.y<481){
							dueño3.undraw();
							continuar.undraw();
							pulgar1.undraw();
							rectangulo.undraw();
							cartas[jugador1].undraw();
							equis.undraw();
							vasoG.undraw();
							numeros[sicaes[jugador1]].undraw();
							
						break;
						}
					}					
						
//CUANDO EL PROPIETARIO ES EL JUGADOR 4	
				
					
				}else if (adquiridas[jugador1]=="jugador4"){
					
					dueño4.draw();
					continuar.draw();
					pulgar1.draw();
					equis.draw();
					vasoG.draw();
					numeros[sicaes[jugador1]].draw();
						
					
					while (true){
						Point pulsacion5 = lienzo.waitMouseClick();	
						
						if (pulsacion5.x>904&&pulsacion5.x<994&&pulsacion5.y>395&&pulsacion5.y<481){
							dueño4.undraw();
							continuar.undraw();
							pulgar1.undraw();
							rectangulo.undraw();
							cartas[jugador1].undraw();
							equis.undraw();
							vasoG.undraw();
							numeros[sicaes[jugador1]].undraw();
							
						break;
						}
					}					
								
//Y CUANDO NO ES DE NADIE QUE SE PUEDA COMPRAR	
				}else{
								
				vasoG.draw();
				equis.draw();		
				pulgar0.draw();
				pulgar1.draw();
				comprar.draw();
				numeros[chupitos[jugador1]].draw();
				
				
						
				while (true){
					Point pulsacion6 = lienzo.waitMouseClick();	
					
					
//CUANDO EL JUGADOR QUIERE COMPRARLA
					if (pulsacion6.x>904&&pulsacion6.x<994&&pulsacion6.y>395&&pulsacion6.y<481){
												
						pulgar0.undraw();
						pulgar1.undraw();
						cartas[jugador1].undraw();
						comprar.undraw();
						equis.undraw();
						vasoG.undraw();
						rectangulo.undraw();
						numeros[chupitos[jugador1]].undraw();
						adquiridas[jugador1]="jugador1";	
					
						
						
						if (jugador1==1||jugador1==3||jugador1==6||jugador1==8||jugador1==9||jugador1==11||jugador1==13||jugador1==14||jugador1==16||jugador1==18||jugador1==19||jugador1==21||jugador1==23||jugador1==24||jugador1==26||jugador1==27||jugador1==29||jugador1==31||jugador1==32||jugador1==34||jugador1==37||jugador1==39){
							
						tabla1=new Text(1115,cordenadas[jugador1],jugadores[turno]);
						tabla1.setColor(Color.BLACK);
						tabla1.draw();
						}
						
						
						
						break;
					}
					
//CUANDO EL JUGADOR NO QUIERE COMPRARLA
					if (pulsacion6.x>1100&&pulsacion6.x<1200&&pulsacion6.y>395&&pulsacion6.y<485){
					
						pulgar0.undraw();
						pulgar1.undraw();
						cartas[jugador1].undraw();
						comprar.undraw();
						equis.undraw();
						vasoG.undraw();
						rectangulo.undraw();
						numeros[chupitos[jugador1]].undraw();
								
						break;
					}//IF
				}//WHILE
	
					
			}//ELSE
			
			}
			
		
		}//if jugador1
		turno++;
	
//-----------------------------------------------------JUGADOR2------------------------------------------------------------------------------		
		
		
		
		
		//Jugador 2
			Picture dado00=new Picture("src/JuegoProgramacion/dado/dado0.png");
			dado00.translate(780, 30);
			dado00.draw();
			
				if (dos!=0){ dos--; }	
				if ((dos==0)&&(turno==2)){
					
		//Imprimo el nombre del jugador
					nombre.undraw();
					nombre=new Text(1000,60,jugadores[turno]);
					nombre.grow(50, 50);
					nombre.setColor(Color.WHITE);
					nombre.draw();
				
		//Imprimo la ficha del jugador en grande.
					sombreroG.undraw();
					cocheG.undraw();
					botaG.undraw();
					perroG.undraw();

					botaG.draw();
						
		//AKI SE MARCAN LAS CORDENADAS DEL DADO
					while (true){
						Point pulsacion = lienzo.waitMouseClick();	
						if (pulsacion.x>780&&pulsacion.x<880&&pulsacion.y>30&&pulsacion.y<129){
							break;
						}
					}
					
		//AKI SE COLOCAN LAS FICHAS SEGUN LA TIRADA
				
					tirada=Juego.Dado();			
				
					for (int x=1;x<=tirada;x++){
							
						if ((jugador2+x)==1){ 						bota.translate(-95,0); 		Thread.sleep(500);}	
						else if ((jugador2+x)<10){ 					bota.translate(-55,0); 		Thread.sleep(500);}	
						else if (jugador2+x==10){					bota.translate(-99,35); 	Thread.sleep(500);}	
						else if (jugador2+x==11){ 					bota.translate(18,-90); 	Thread.sleep(500);}	
						else if (jugador2+x>11&&jugador2+x<20){ 	bota.translate(0,-55); 		Thread.sleep(500);}						
						else if (jugador2+x==20){ 					bota.translate(-5,-95); 	Thread.sleep(500);}	 
						else if (jugador2+x==21){ 					bota.translate(85,10);	 	Thread.sleep(500);}	 
						else if (jugador2+x<30){ 					bota.translate(55,0); 		Thread.sleep(500);}	
						else if (jugador2+x==30){ 					bota.translate(55,0); 		Thread.sleep(500);}	
						else if (jugador2+x==31){ 					bota.translate(15,85); 		Thread.sleep(500);}	
						else if (jugador2+x>31&&jugador2+x<40){ 	bota.translate(0,55); 		Thread.sleep(500);}		
						else if (jugador2+x==40){ 					bota.translate(26,55); 		jugador2=jugador2-40;  Thread.sleep(500);}									
					}//for
					jugador2=jugador2+tirada;
					Thread.sleep(500);
					
							
		//AKI SE COMPRUEBA QUE LA CASILLA DONDE HA CAIDO SE PUEDE COMPRAR O NO
					
					rectangulo=new Rectangle (0,150,1280,400);
					rectangulo.setColor(Color.BLACK);
					rectangulo.fill();
					rectangulo.undraw();
					
					
					
		//AKI COMPRUEBO SI EL JUGADOR HA CAIDO EN LA CASILLA DE IR A LA CARCEL.			
				
					if (jugador2==30){
					
						rectangulo.fill();
						pulgar1.draw();
						continuar.draw();
						guardia.draw();
						sintirar.draw();		
					
					while (true){
						Point pulsacion9 = lienzo.waitMouseClick();	
						
						if (pulsacion9.x>904&&pulsacion9.x<994&&pulsacion9.y>395&&pulsacion9.y<481){

							continuar.undraw();
							pulgar1.undraw();
							rectangulo.undraw();
							guardia.undraw();
							sintirar.undraw();
							break;
						}//if
					}//while	
							
		//Muevo la ficha a la carcel.
					
							tirada=20;
							for (int x=1;x<=tirada;x++){
								
								if ((jugador2+x)==1){ 						bota.translate(-95,0); 		Thread.sleep(500);}	
								else if ((jugador2+x)<10){ 					bota.translate(-55,0); 		Thread.sleep(500);}	
								else if (jugador2+x==10){					bota.translate(-99,35); 	Thread.sleep(500);}	
								else if (jugador2+x==11){ 					bota.translate(18,-90); 	Thread.sleep(500);}	
								else if (jugador2+x>11&&jugador2+x<20){ 	bota.translate(0,-55); 		Thread.sleep(500);}						
								else if (jugador2+x==20){ 					bota.translate(-5,-95); 	Thread.sleep(500);}	 
								else if (jugador2+x==21){ 					bota.translate(85,10);	 	Thread.sleep(500);}	 
								else if (jugador2+x<30){ 					bota.translate(55,0); 		Thread.sleep(500);}	
								else if (jugador2+x==30){ 					bota.translate(55,0); 		Thread.sleep(500);}	
								else if (jugador2+x==31){ 					bota.translate(15,85); 		Thread.sleep(500);}	
								else if (jugador2+x>31&&jugador2+x<40){ 	bota.translate(0,55); 		Thread.sleep(500);}		
								else if (jugador2+x==40){ 					bota.translate(26,55); 		jugador2=jugador2-40;  Thread.sleep(500);}									
							}//for
							jugador2=jugador2+tirada;
							dos=3;
				
				}//IF de la casilla 30.
					
					
		//Aki controlo las calles de los impuestos
					
					if (jugador2==4){
					
					rectangulo.fill();
					alcohol.draw();
					equis.draw();
					numeros[4].draw();
					vasoG.draw();
					pulgar1.draw();
					continuar.draw();
					
						while (true){
							Point pulsacion10 = lienzo.waitMouseClick();	
						
							if (pulsacion10.x>904&&pulsacion10.x<994&&pulsacion10.y>395&&pulsacion10.y<481){
							
								rectangulo.undraw();
								alcohol.undraw();
								equis.undraw();
								numeros[4].undraw();
								vasoG.undraw();
								pulgar1.undraw();
								continuar.undraw();
										
								break;
							}
						}					
					
					}
					
					
					if (jugador2==38){
						
						rectangulo.fill();
						lujo.draw();
						equis.draw();
						numeros[2].draw();
						vasoG.draw();
						pulgar1.draw();
						continuar.draw();
						
							while (true){
								Point pulsacion11 = lienzo.waitMouseClick();	
							
								if (pulsacion11.x>904&&pulsacion11.x<994&&pulsacion11.y>395&&pulsacion11.y<481){
								
									rectangulo.undraw();
									lujo.undraw();
									equis.undraw();
									numeros[2].undraw();
									vasoG.undraw();
									pulgar1.undraw();
									continuar.undraw();
											
									break;
								}
							}					
						
						}
					
		//CUANDO ES TESORERIA O SORPRESA				
					
					//TESORERIA
					if (jugador2==2||jugador2==17||jugador2==33){
						
						aleatorio=(int)(Math.random()*15);
						
						rectangulo.fill();
						tesoreria[aleatorio].draw();
						pulgar1.draw();
						continuar.draw();
						equis.draw();
						vasoG.draw();
						numeros[tesoreriachupitos[aleatorio]].draw();
						
						while (true){
							Point pulsacion7 = lienzo.waitMouseClick();	
							
							if (pulsacion7.x>904&&pulsacion7.x<994&&pulsacion7.y>395&&pulsacion7.y<481){
								
								continuar.undraw();
								pulgar1.undraw();
								rectangulo.undraw();
								tesoreria[aleatorio].undraw();
								numeros[tesoreriachupitos[aleatorio]].undraw();
								vasoG.undraw();
								equis.undraw();
												
							break;
							}
						}					
						
					
					}
		//Sorpresa				
					if (jugador2==7||jugador2==22||jugador2==36){
						
						aleatorio=(int)(Math.random()*15);
						
						rectangulo.fill();
						sorpresa[aleatorio].draw();
						pulgar1.draw();
						continuar.draw();
						equis.draw();
						vasoG.draw();
						numeros[sorpresachupitos[aleatorio]].draw();
						
						
						while (true){
							Point pulsacion8 = lienzo.waitMouseClick();	
							
							if (pulsacion8.x>904&&pulsacion8.x<994&&pulsacion8.y>395&&pulsacion8.y<481){

								continuar.undraw();
								pulgar1.undraw();
								rectangulo.undraw();
								sorpresa[aleatorio].undraw();
								numeros[sorpresachupitos[aleatorio]].undraw();
								vasoG.undraw();
								equis.undraw();
													
							break;
							}//if
						}//while					
						
					}//if
								
					
					if (jugador2==1||jugador2==3||jugador2==5||jugador2==6||jugador2==8||jugador2==9||jugador2==11||jugador2==12||jugador2==13||jugador2==14||jugador2==15||jugador2==16||jugador2==18||jugador2==19||jugador2==21||jugador2==23||jugador2==24||jugador2==25||jugador2==26||jugador2==27||jugador2==28||jugador2==29||jugador2==31||jugador2==32||jugador2==34||jugador2==35||jugador2==37||jugador2==39){
						
						rectangulo.fill();
										
		//AKI IMPRIMO LA CARTA DE LA CASILLA DONDE HA CAIDO EL JUGADOR
											
						cartas[jugador2].draw();
						
		//
		//AKI COMPRUEBO EL PROPIETARIO DE LA CARTA.
		//

				
						
		//CUANDO LA CALLE ES TUYA
						if (adquiridas[jugador2]=="jugador2"){
							eresdueño.draw();
							continuar.draw();
							pulgar1.draw();
											
							while (true){
								Point pulsacion2 = lienzo.waitMouseClick();	
								
								if (pulsacion2.x>904&&pulsacion2.x<994&&pulsacion2.y>395&&pulsacion2.y<481){
									eresdueño.undraw();
									continuar.undraw();
									pulgar1.undraw();
									rectangulo.undraw();
									cartas[jugador2].undraw();
								break;
								}
							}
								
		//CUANDO EL PROPIETARIO ES EL JUGADOR 1
						}else if (adquiridas[jugador2]=="jugador1"){
							dueño1.draw();
							continuar.draw();
							pulgar1.draw();
							equis.draw();
							vasoG.draw();
							numeros[sicaes[jugador2]].draw();
							
							while (true){
								Point pulsacion3 = lienzo.waitMouseClick();	
								
								if (pulsacion3.x>904&&pulsacion3.x<994&&pulsacion3.y>395&&pulsacion3.y<481){
									dueño1.undraw();
									continuar.undraw();
									pulgar1.undraw();
									rectangulo.undraw();
									cartas[jugador2].undraw();
									equis.undraw();
									vasoG.undraw();
									numeros[sicaes[jugador2]].undraw();
									
								break;
								}
							}					
							
							
		//CUANDO EL PROPIETARIO ES EL JUGADOR 3
						}else if (adquiridas[jugador2]=="jugador3"){
							
							dueño3.draw();
							continuar.draw();
							pulgar1.draw();
							equis.draw();
							vasoG.draw();
							numeros[sicaes[jugador2]].draw();
							
							while (true){
								Point pulsacion4 = lienzo.waitMouseClick();	
								
								if (pulsacion4.x>904&&pulsacion4.x<994&&pulsacion4.y>395&&pulsacion4.y<481){
									dueño3.undraw();
									continuar.undraw();
									pulgar1.undraw();
									rectangulo.undraw();
									cartas[jugador2].undraw();
									equis.undraw();
									vasoG.undraw();
									numeros[sicaes[jugador2]].undraw();
									
								break;
								}
							}					
								
		//CUANDO EL PROPIETARIO ES EL JUGADOR 4	
						
							
						}else if (adquiridas[jugador2]=="jugador4"){
							
							dueño4.draw();
							continuar.draw();
							pulgar1.draw();
							equis.draw();
							vasoG.draw();
							numeros[sicaes[jugador2]].draw();
							
							while (true){
								Point pulsacion5 = lienzo.waitMouseClick();	
								
								if (pulsacion5.x>904&&pulsacion5.x<994&&pulsacion5.y>395&&pulsacion5.y<481){
									dueño4.undraw();
									continuar.undraw();
									pulgar1.undraw();
									rectangulo.undraw();
									cartas[jugador2].undraw();
									equis.undraw();
									vasoG.undraw();
									numeros[sicaes[jugador2]].undraw();
									
								break;
								}
							}					
										
		//Y CUANDO NO ES DE NADIE QUE SE PUEDA COMPRAR	
						}else{
										
						vasoG.draw();
						equis.draw();		
						pulgar0.draw();
						pulgar1.draw();
						comprar.draw();
						numeros[chupitos[jugador2]].draw();
								
						while (true){
							Point pulsacion6 = lienzo.waitMouseClick();	
							
							
		//CUANDO EL JUGADOR QUIERE COMPRARLA
							if (pulsacion6.x>904&&pulsacion6.x<994&&pulsacion6.y>395&&pulsacion6.y<481){
								
								pulgar0.undraw();
								pulgar1.undraw();
								cartas[jugador2].undraw();
								comprar.undraw();
								equis.undraw();
								vasoG.undraw();
								rectangulo.undraw();
								numeros[chupitos[jugador2]].undraw();
								adquiridas[jugador2]="jugador2";				
								
								
								if (jugador2==1||jugador2==3||jugador2==6||jugador2==8||jugador2==9||jugador2==11||jugador2==13||jugador2==14||jugador2==16||jugador2==18||jugador2==19||jugador2==21||jugador2==23||jugador2==24||jugador2==26||jugador2==27||jugador2==29||jugador2==31||jugador2==32||jugador2==34||jugador2==37||jugador2==39){
									
								tabla1=new Text(1115,cordenadas[jugador2],jugadores[turno]);
								tabla1.setColor(Color.BLACK);
								tabla1.draw();
								}
								
								
								
								break;
							}
							
		//CUANDO EL JUGADOR NO QUIERE COMPRARLA
							if (pulsacion6.x>1100&&pulsacion6.x<1200&&pulsacion6.y>395&&pulsacion6.y<485){
							
								pulgar0.undraw();
								pulgar1.undraw();
								cartas[jugador2].undraw();
								comprar.undraw();
								equis.undraw();
								vasoG.undraw();
								rectangulo.undraw();
								numeros[chupitos[jugador2]].undraw();
										
								break;
							}//IF
						}//WHILE
			
							
					}//ELSE
					
					}
					
				
				}//if jugador2
		turno++;
		
		
		
		
		
		//-----------------------------------------------------JUGADOR3------------------------------------------------------------------------------		
				
		
				//Jugador 3
		
					Picture dado000=new Picture("src/JuegoProgramacion/dado/dado0.png");
					dado000.translate(780, 30);
					dado000.draw();
			
						if (tres<0){ turno=1; }
						if (tres!=0){ tres--; }	
						if ((tres==0)&&(turno==3)){
							
				//Imprimo el nombre del jugador
							nombre.undraw();
							nombre=new Text(1000,60,jugadores[turno]);
							nombre.grow(50, 50);
							nombre.setColor(Color.WHITE);
							nombre.draw();
						
				//Imprimo la ficha del jugador en grande.
							sombreroG.undraw();
							cocheG.undraw();
							botaG.undraw();
							perroG.undraw();

							perroG.draw();
								
				//AKI SE MARCAN LAS CORDENADAS DEL DADO
							while (true){
								Point pulsacion = lienzo.waitMouseClick();	
								if (pulsacion.x>780&&pulsacion.x<880&&pulsacion.y>30&&pulsacion.y<129){
									break;
								}
							}
							
				//AKI SE COLOCAN LAS FICHAS SEGUN LA TIRADA
						
							tirada=Juego.Dado();			
						
							for (int x=1;x<=tirada;x++){
									
								if ((jugador3+x)==1){ 						perro.translate(-53,0); 	Thread.sleep(500);}	
								else if ((jugador3+x)<10){ 					perro.translate(-55,0); 	Thread.sleep(500);}
								else if (jugador3+x==10){					perro.translate(-95,-35); 	Thread.sleep(500);}
								else if (jugador3+x==11){ 					perro.translate(18,-50); 	Thread.sleep(500);}
								else if (jugador3+x>11&&jugador3+x<20){ 	perro.translate(0,-55); 	Thread.sleep(500);} 					
								else if (jugador3+x==20){ 					perro.translate(-10,-45); 	Thread.sleep(500);}
								else if (jugador3+x==21){ 					perro.translate(90,-10);	Thread.sleep(500);}
								else if (jugador3+x<30){ 					perro.translate(55,0); 		Thread.sleep(500);}
								else if (jugador3+x==30){ 					perro.translate(55,0); 		Thread.sleep(500);}
								else if (jugador3+x==31){ 					perro.translate(20,60); 	Thread.sleep(500);}
								else if (jugador3+x>31&&jugador3+x<40){ 	perro.translate(0,55); 		Thread.sleep(500);}	
								else if (jugador3+x==40){ 					perro.translate(-25,80); 	jugador3=jugador3-40; Thread.sleep(500);}								
							}//for
							jugador3=jugador3+tirada;
							Thread.sleep(500);
							
									
				//AKI SE COMPRUEBA QUE LA CASILLA DONDE HA CAIDO SE PUEDE COMPRAR O NO
							
							rectangulo=new Rectangle (0,150,1280,400);
							rectangulo.setColor(Color.BLACK);
							rectangulo.fill();
							rectangulo.undraw();
							
							
							
				//AKI COMPRUEBO SI EL JUGADOR HA CAIDO EN LA CASILLA DE IR A LA CARCEL.			
						
							if (jugador3==30){
							
								rectangulo.fill();
								pulgar1.draw();
								continuar.draw();
								guardia.draw();
								sintirar.draw();		
							
							while (true){
								Point pulsacion9 = lienzo.waitMouseClick();	
								
								if (pulsacion9.x>904&&pulsacion9.x<994&&pulsacion9.y>395&&pulsacion9.y<481){

									continuar.undraw();
									pulgar1.undraw();
									rectangulo.undraw();
									guardia.undraw();
									sintirar.undraw();
									break;
								}//if
							}//while	
									
				//Muevo la ficha a la carcel.
							
									tirada=20;
									for (int x=1;x<=tirada;x++){
										
										if ((jugador3+x)==1){ 						perro.translate(-53,0); 	Thread.sleep(500);}	
										else if ((jugador3+x)<10){ 					perro.translate(-55,0); 	Thread.sleep(500);}
										else if (jugador3+x==10){					perro.translate(-95,-35); 	Thread.sleep(500);}
										else if (jugador3+x==11){ 					perro.translate(18,-50); 	Thread.sleep(500);}
										else if (jugador3+x>11&&jugador3+x<20){ 	perro.translate(0,-55); 	Thread.sleep(500);} 					
										else if (jugador3+x==20){ 					perro.translate(-10,-45); 	Thread.sleep(500);}
										else if (jugador3+x==21){ 					perro.translate(90,-10);	Thread.sleep(500);}
										else if (jugador3+x<30){ 					perro.translate(55,0); 		Thread.sleep(500);}
										else if (jugador3+x==30){ 					perro.translate(55,0); 		Thread.sleep(500);}
										else if (jugador3+x==31){ 					perro.translate(20,60); 	Thread.sleep(500);}
										else if (jugador3+x>31&&jugador3+x<40){ 	perro.translate(0,55); 		Thread.sleep(500);}	
										else if (jugador3+x==40){ 					perro.translate(-25,80); 	jugador3=jugador3-40; Thread.sleep(500);}								
									}//for
									jugador3=jugador3+tirada;
									tres=3;
						
						}//IF de la casilla 30.
							
							
				//Aki controlo las calles de los impuestos
							
							if (jugador3==4){
							
							rectangulo.fill();
							alcohol.draw();
							equis.draw();
							numeros[4].draw();
							vasoG.draw();
							pulgar1.draw();
							continuar.draw();
							
								while (true){
									Point pulsacion10 = lienzo.waitMouseClick();	
								
									if (pulsacion10.x>904&&pulsacion10.x<994&&pulsacion10.y>395&&pulsacion10.y<481){
									
										rectangulo.undraw();
										alcohol.undraw();
										equis.undraw();
										numeros[4].undraw();
										vasoG.undraw();
										pulgar1.undraw();
										continuar.undraw();
												
										break;
									}
								}					
							
							}
							
							
							if (jugador3==38){
								
								rectangulo.fill();
								lujo.draw();
								equis.draw();
								numeros[2].draw();
								vasoG.draw();
								pulgar1.draw();
								continuar.draw();
								
									while (true){
										Point pulsacion11 = lienzo.waitMouseClick();	
									
										if (pulsacion11.x>904&&pulsacion11.x<994&&pulsacion11.y>395&&pulsacion11.y<481){
										
											rectangulo.undraw();
											lujo.undraw();
											equis.undraw();
											numeros[2].undraw();
											vasoG.undraw();
											pulgar1.undraw();
											continuar.undraw();
													
											break;
										}
									}					
								
								}
							
				//CUANDO ES TESORERIA O SORPRESA				
							
							//TESORERIA
							if (jugador3==2||jugador3==17||jugador3==33){
								
								aleatorio=(int)(Math.random()*15);
								
								rectangulo.fill();
								tesoreria[aleatorio].draw();
								pulgar1.draw();
								continuar.draw();
								equis.draw();
								vasoG.draw();
								numeros[tesoreriachupitos[aleatorio]].draw();
								
								while (true){
									Point pulsacion7 = lienzo.waitMouseClick();	
									
									if (pulsacion7.x>904&&pulsacion7.x<994&&pulsacion7.y>395&&pulsacion7.y<481){
										
										continuar.undraw();
										pulgar1.undraw();
										rectangulo.undraw();
										tesoreria[aleatorio].undraw();
										numeros[tesoreriachupitos[aleatorio]].undraw();
										vasoG.undraw();
										equis.undraw();
														
									break;
									}
								}					
								
							
							}
				//Sorpresa				
							if (jugador3==7||jugador3==22||jugador3==36){
								
								aleatorio=(int)(Math.random()*15);
								
								rectangulo.fill();
								sorpresa[aleatorio].draw();
								pulgar1.draw();
								continuar.draw();
								equis.draw();
								vasoG.draw();
								numeros[sorpresachupitos[aleatorio]].draw();
								
								
								while (true){
									Point pulsacion8 = lienzo.waitMouseClick();	
									
									if (pulsacion8.x>904&&pulsacion8.x<994&&pulsacion8.y>395&&pulsacion8.y<481){

										continuar.undraw();
										pulgar1.undraw();
										rectangulo.undraw();
										sorpresa[aleatorio].undraw();
										numeros[sorpresachupitos[aleatorio]].undraw();
										vasoG.undraw();
										equis.undraw();
															
									break;
									}//if
								}//while					
								
							}//if
										
							
							if (jugador3==1||jugador3==3||jugador3==5||jugador3==6||jugador3==8||jugador3==9||jugador3==11||jugador3==12||jugador3==13||jugador3==14||jugador3==15||jugador3==16||jugador3==18||jugador3==19||jugador3==21||jugador3==23||jugador3==24||jugador3==25||jugador3==26||jugador3==27||jugador3==28||jugador3==29||jugador3==31||jugador3==32||jugador3==34||jugador3==35||jugador3==37||jugador3==39){
								
								rectangulo.fill();
												
				//AKI IMPRIMO LA CARTA DE LA CASILLA DONDE HA CAIDO EL JUGADOR
													
								cartas[jugador3].draw();
								
				//
				//AKI COMPRUEBO EL PROPIETARIO DE LA CARTA.
				//

						
								
				//CUANDO LA CALLE ES TUYA
								if (adquiridas[jugador3]=="jugador3"){
									eresdueño.draw();
									continuar.draw();
									pulgar1.draw();
													
									while (true){
										Point pulsacion2 = lienzo.waitMouseClick();	
										
										if (pulsacion2.x>904&&pulsacion2.x<994&&pulsacion2.y>395&&pulsacion2.y<481){
											eresdueño.undraw();
											continuar.undraw();
											pulgar1.undraw();
											rectangulo.undraw();
											cartas[jugador3].undraw();
										break;
										}
									}
										
				//CUANDO EL PROPIETARIO ES EL JUGADOR 1
								}else if (adquiridas[jugador3]=="jugador1"){
									dueño1.draw();
									continuar.draw();
									pulgar1.draw();
									equis.draw();
									vasoG.draw();
									numeros[sicaes[jugador3]].draw();
									
									while (true){
										Point pulsacion3 = lienzo.waitMouseClick();	
										
										if (pulsacion3.x>904&&pulsacion3.x<994&&pulsacion3.y>395&&pulsacion3.y<481){
											dueño1.undraw();
											continuar.undraw();
											pulgar1.undraw();
											rectangulo.undraw();
											cartas[jugador3].undraw();
											equis.undraw();
											vasoG.undraw();
											numeros[sicaes[jugador3]].undraw();
											
										break;
										}
									}					
									
									
				//CUANDO EL PROPIETARIO ES EL JUGADOR 2
								}else if (adquiridas[jugador3]=="jugador2"){
									
									dueño2.draw();
									continuar.draw();
									pulgar1.draw();
									equis.draw();
									vasoG.draw();
									numeros[sicaes[jugador3]].draw();
									
									while (true){
										Point pulsacion4 = lienzo.waitMouseClick();	
										
										if (pulsacion4.x>904&&pulsacion4.x<994&&pulsacion4.y>395&&pulsacion4.y<481){
											dueño2.undraw();
											continuar.undraw();
											pulgar1.undraw();
											rectangulo.undraw();
											cartas[jugador3].undraw();
											equis.undraw();
											vasoG.undraw();
											numeros[sicaes[jugador3]].undraw();
											
										break;
										}
									}					
										
				//CUANDO EL PROPIETARIO ES EL JUGADOR 4	
								
									
								}else if (adquiridas[jugador3]=="jugador4"){
									
									dueño4.draw();
									continuar.draw();
									pulgar1.draw();
									equis.draw();
									vasoG.draw();
									numeros[sicaes[jugador3]].draw();
									
									while (true){
										Point pulsacion5 = lienzo.waitMouseClick();	
										
										if (pulsacion5.x>904&&pulsacion5.x<994&&pulsacion5.y>395&&pulsacion5.y<481){
											dueño4.undraw();
											continuar.undraw();
											pulgar1.undraw();
											rectangulo.undraw();
											cartas[jugador3].undraw();
											equis.undraw();
											vasoG.undraw();
											numeros[sicaes[jugador3]].undraw();
											
										break;
										}
									}					
												
				//Y CUANDO NO ES DE NADIE QUE SE PUEDA COMPRAR	
								}else{
												
								vasoG.draw();
								equis.draw();		
								pulgar0.draw();
								pulgar1.draw();
								comprar.draw();
								numeros[chupitos[jugador3]].draw();
										
								while (true){
									Point pulsacion6 = lienzo.waitMouseClick();	
									
									
				//CUANDO EL JUGADOR QUIERE COMPRARLA
									if (pulsacion6.x>904&&pulsacion6.x<994&&pulsacion6.y>395&&pulsacion6.y<481){
										
										pulgar0.undraw();
										pulgar1.undraw();
										cartas[jugador3].undraw();
										comprar.undraw();
										equis.undraw();
										vasoG.undraw();
										rectangulo.undraw();
										numeros[chupitos[jugador3]].undraw();
										adquiridas[jugador3]="jugador3";				
										
										
										if (jugador3==1||jugador3==3||jugador3==6||jugador3==8||jugador3==9||jugador3==11||jugador3==13||jugador3==14||jugador3==16||jugador3==18||jugador3==19||jugador3==21||jugador3==23||jugador3==24||jugador3==26||jugador3==27||jugador3==29||jugador3==31||jugador3==32||jugador3==34||jugador3==37||jugador3==39){
											
										tabla1=new Text(1115,cordenadas[jugador3],jugadores[turno]);
										tabla1.setColor(Color.BLACK);
										tabla1.draw();
										}
										
										
										
										break;
									}
									
				//CUANDO EL JUGADOR NO QUIERE COMPRARLA
									if (pulsacion6.x>1100&&pulsacion6.x<1200&&pulsacion6.y>395&&pulsacion6.y<485){
									
										pulgar0.undraw();
										pulgar1.undraw();
										cartas[jugador3].undraw();
										comprar.undraw();
										equis.undraw();
										vasoG.undraw();
										rectangulo.undraw();
										numeros[chupitos[jugador3]].undraw();
												
										break;
									}//IF
								}//WHILE
					
									
							}//ELSE
							
							}
							
						
						}//if jugador3
				turno++;
				

				//-----------------------------------------------------JUGADOR4------------------------------------------------------------------------------		
						
				
						//Jugador 4
								
								Picture dado0000=new Picture("src/JuegoProgramacion/dado/dado0.png");
								dado0000.translate(780, 30);
								dado0000.draw();

				
				
				
								if (cuatro<0){ turno=1; }
								if (cuatro!=0){ cuatro--; }	
								if ((cuatro==0)&&(turno==4)){
									
						//Imprimo el nombre del jugador
									nombre.undraw();
									nombre=new Text(1000,60,jugadores[turno]);
									nombre.grow(50, 50);
									nombre.setColor(Color.WHITE);
									nombre.draw();
								
						//Imprimo la ficha del jugador en grande.
									sombreroG.undraw();
									cocheG.undraw();
									botaG.undraw();
									perroG.undraw();

									sombreroG.draw();
										
						//AKI SE MARCAN LAS CORDENADAS DEL DADO
									while (true){
										Point pulsacion = lienzo.waitMouseClick();	
										if (pulsacion.x>780&&pulsacion.x<880&&pulsacion.y>30&&pulsacion.y<129){
											break;
										}
									}
									
						//AKI SE COLOCAN LAS FICHAS SEGUN LA TIRADA
								
									tirada=Juego.Dado();			
									for (int x=1;x<=tirada;x++){
											
										if ((jugador4+x)==1){ 						sombrero.translate(-93,0); 		Thread.sleep(500);}		
										else if ((jugador4+x)<10){ 					sombrero.translate(-55,0); 		Thread.sleep(500);}	
										else if (jugador4+x==10){					sombrero.translate(-50,-55); 	Thread.sleep(500);}	
										else if (jugador4+x==11){ 					sombrero.translate(-45,-48); 	Thread.sleep(500);}	
										else if (jugador4+x>11&&jugador4+x<20){ 	sombrero.translate(0,-55); 		Thread.sleep(500);} 					
										else if (jugador4+x==20){ 					sombrero.translate(46,-45); 	Thread.sleep(500);} 
										else if (jugador4+x==21){ 					sombrero.translate(50,0);		Thread.sleep(500);} 
										else if (jugador4+x<30){ 					sombrero.translate(55,0); 		Thread.sleep(500);}
										else if (jugador4+x==30){ 					sombrero.translate(55,0); 		Thread.sleep(500);}
										else if (jugador4+x==31){ 					sombrero.translate(35,50); 		Thread.sleep(500);}
										else if (jugador4+x>31&&jugador4+x<40){ 	sombrero.translate(0,55); 		Thread.sleep(500);}	
										else if (jugador4+x==40){ 					sombrero.translate(2,98); 		jugador4=jugador4-40; Thread.sleep(500); }								
									}//for
									jugador4=jugador4+tirada;
									Thread.sleep(500);
									
											
						//AKI SE COMPRUEBA QUE LA CASILLA DONDE HA CAIDO SE PUEDE COMPRAR O NO
									
									rectangulo=new Rectangle (0,150,1280,400);
									rectangulo.setColor(Color.BLACK);
									rectangulo.fill();
									rectangulo.undraw();
									
									
									
						//AKI COMPRUEBO SI EL JUGADOR HA CAIDO EN LA CASILLA DE IR A LA CARCEL.			
								
									if (jugador4==30){
									
										rectangulo.fill();
										pulgar1.draw();
										continuar.draw();
										guardia.draw();
										sintirar.draw();		
									
									while (true){
										Point pulsacion9 = lienzo.waitMouseClick();	
										
										if (pulsacion9.x>904&&pulsacion9.x<994&&pulsacion9.y>395&&pulsacion9.y<481){

											continuar.undraw();
											pulgar1.undraw();
											rectangulo.undraw();
											guardia.undraw();
											sintirar.undraw();
											break;
										}//if
									}//while	
											
						//Muevo la ficha a la carcel.
									
											tirada=20;
											for (int x=1;x<=tirada;x++){
												
												if ((jugador4+x)==1){ 						sombrero.translate(-93,0); 		Thread.sleep(500);}		
												else if ((jugador4+x)<10){ 					sombrero.translate(-55,0); 		Thread.sleep(500);}	
												else if (jugador4+x==10){					sombrero.translate(-50,-55); 	Thread.sleep(500);}	
												else if (jugador4+x==11){ 					sombrero.translate(-45,-48); 	Thread.sleep(500);}	
												else if (jugador4+x>11&&jugador4+x<20){ 	sombrero.translate(0,-55); 		Thread.sleep(500);} 					
												else if (jugador4+x==20){ 					sombrero.translate(46,-45); 	Thread.sleep(500);} 
												else if (jugador4+x==21){ 					sombrero.translate(50,0);		Thread.sleep(500);} 
												else if (jugador4+x<30){ 					sombrero.translate(55,0); 		Thread.sleep(500);}
												else if (jugador4+x==30){ 					sombrero.translate(55,0); 		Thread.sleep(500);}
												else if (jugador4+x==31){ 					sombrero.translate(35,50); 		Thread.sleep(500);}
												else if (jugador4+x>31&&jugador4+x<40){ 	sombrero.translate(0,55); 		Thread.sleep(500);}	
												else if (jugador4+x==40){ 					sombrero.translate(2,98); 		jugador4=jugador4-40; Thread.sleep(500); }								
											}//for
											jugador4=jugador4+tirada;
											cuatro=3;
								
								}//IF de la casilla 30.
									
									
						//Aki controlo las calles de los impuestos
									
									if (jugador4==4){
									
									rectangulo.fill();
									alcohol.draw();
									equis.draw();
									numeros[4].draw();
									vasoG.draw();
									pulgar1.draw();
									continuar.draw();
									
										while (true){
											Point pulsacion10 = lienzo.waitMouseClick();	
										
											if (pulsacion10.x>904&&pulsacion10.x<994&&pulsacion10.y>395&&pulsacion10.y<481){
											
												rectangulo.undraw();
												alcohol.undraw();
												equis.undraw();
												numeros[4].undraw();
												vasoG.undraw();
												pulgar1.undraw();
												continuar.undraw();
														
												break;
											}
										}					
									
									}
									
									
									if (jugador4==38){
										
										rectangulo.fill();
										lujo.draw();
										equis.draw();
										numeros[2].draw();
										vasoG.draw();
										pulgar1.draw();
										continuar.draw();
										
											while (true){
												Point pulsacion11 = lienzo.waitMouseClick();	
											
												if (pulsacion11.x>904&&pulsacion11.x<994&&pulsacion11.y>395&&pulsacion11.y<481){
												
													rectangulo.undraw();
													lujo.undraw();
													equis.undraw();
													numeros[2].undraw();
													vasoG.undraw();
													pulgar1.undraw();
													continuar.undraw();
															
													break;
												}
											}					
										
										}
									
						//CUANDO ES TESORERIA O SORPRESA				
									
									//TESORERIA
									if (jugador4==2||jugador4==17||jugador4==33){
										
										aleatorio=(int)(Math.random()*15);
										
										rectangulo.fill();
										tesoreria[aleatorio].draw();
										pulgar1.draw();
										continuar.draw();
										equis.draw();
										vasoG.draw();
										numeros[tesoreriachupitos[aleatorio]].draw();
										
										while (true){
											Point pulsacion7 = lienzo.waitMouseClick();	
											
											if (pulsacion7.x>904&&pulsacion7.x<994&&pulsacion7.y>395&&pulsacion7.y<481){
												
												continuar.undraw();
												pulgar1.undraw();
												rectangulo.undraw();
												tesoreria[aleatorio].undraw();
												numeros[tesoreriachupitos[aleatorio]].undraw();
												vasoG.undraw();
												equis.undraw();
																
											break;
											}
										}					
										
									
									}
						//Sorpresa				
									if (jugador4==7||jugador4==22||jugador4==36){
										
										aleatorio=(int)(Math.random()*15);
										
										rectangulo.fill();
										sorpresa[aleatorio].draw();
										pulgar1.draw();
										continuar.draw();
										equis.draw();
										vasoG.draw();
										numeros[sorpresachupitos[aleatorio]].draw();
										
										
										while (true){
											Point pulsacion8 = lienzo.waitMouseClick();	
											
											if (pulsacion8.x>904&&pulsacion8.x<994&&pulsacion8.y>395&&pulsacion8.y<481){

												continuar.undraw();
												pulgar1.undraw();
												rectangulo.undraw();
												sorpresa[aleatorio].undraw();
												numeros[sorpresachupitos[aleatorio]].undraw();
												vasoG.undraw();
												equis.undraw();
																	
											break;
											}//if
										}//while					
										
									}//if
												
									
									if (jugador4==1||jugador4==3||jugador4==5||jugador4==6||jugador4==8||jugador4==9||jugador4==11||jugador4==12||jugador4==13||jugador4==14||jugador4==15||jugador4==16||jugador4==18||jugador4==19||jugador4==21||jugador4==23||jugador4==24||jugador4==25||jugador4==26||jugador4==27||jugador4==28||jugador4==29||jugador4==31||jugador4==32||jugador4==34||jugador4==35||jugador4==37||jugador4==39){
										
										rectangulo.fill();
														
						//AKI IMPRIMO LA CARTA DE LA CASILLA DONDE HA CAIDO EL JUGADOR
															
										cartas[jugador4].draw();
										
						//
						//AKI COMPRUEBO EL PROPIETARIO DE LA CARTA.
						//

								
										
						//CUANDO LA CALLE ES TUYA
										if (adquiridas[jugador4]=="jugador4"){
											eresdueño.draw();
											continuar.draw();
											pulgar1.draw();
															
											while (true){
												Point pulsacion2 = lienzo.waitMouseClick();	
												
												if (pulsacion2.x>904&&pulsacion2.x<994&&pulsacion2.y>395&&pulsacion2.y<481){
													eresdueño.undraw();
													continuar.undraw();
													pulgar1.undraw();
													rectangulo.undraw();
													cartas[jugador4].undraw();
												break;
												}
											}
												
						//CUANDO EL PROPIETARIO ES EL JUGADOR 1
										}else if (adquiridas[jugador4]=="jugador1"){
											dueño1.draw();
											continuar.draw();
											pulgar1.draw();
											equis.draw();
											vasoG.draw();
											numeros[sicaes[jugador4]].draw();
											
											while (true){
												Point pulsacion3 = lienzo.waitMouseClick();	
												
												if (pulsacion3.x>904&&pulsacion3.x<994&&pulsacion3.y>395&&pulsacion3.y<481){
													dueño1.undraw();
													continuar.undraw();
													pulgar1.undraw();
													rectangulo.undraw();
													cartas[jugador4].undraw();
													equis.undraw();
													vasoG.undraw();
													numeros[sicaes[jugador4]].undraw();
													
												break;
												}
											}					
											
											
						//CUANDO EL PROPIETARIO ES EL JUGADOR 2
										}else if (adquiridas[jugador4]=="jugador2"){
											
											dueño2.draw();
											continuar.draw();
											pulgar1.draw();
											equis.draw();
											vasoG.draw();
											numeros[sicaes[jugador4]].draw();
											
											while (true){
												Point pulsacion4 = lienzo.waitMouseClick();	
												
												if (pulsacion4.x>904&&pulsacion4.x<994&&pulsacion4.y>395&&pulsacion4.y<481){
													dueño2.undraw();
													continuar.undraw();
													pulgar1.undraw();
													rectangulo.undraw();
													cartas[jugador4].undraw();
													equis.undraw();
													vasoG.undraw();
													numeros[sicaes[jugador4]].undraw();
													
												break;
												}
											}					
												
						//CUANDO EL PROPIETARIO ES EL JUGADOR 3	
										
											
										}else if (adquiridas[jugador4]=="jugador3"){
											
											dueño3.draw();
											continuar.draw();
											pulgar1.draw();
											equis.draw();
											vasoG.draw();
											numeros[sicaes[jugador4]].draw();
											
											while (true){
												Point pulsacion5 = lienzo.waitMouseClick();	
												
												if (pulsacion5.x>904&&pulsacion5.x<994&&pulsacion5.y>395&&pulsacion5.y<481){
													dueño3.undraw();
													continuar.undraw();
													pulgar1.undraw();
													rectangulo.undraw();
													cartas[jugador4].undraw();
													equis.undraw();
													vasoG.undraw();
													numeros[sicaes[jugador4]].undraw();
													
												break;
												}
											}					
														
						//Y CUANDO NO ES DE NADIE QUE SE PUEDA COMPRAR	
										}else{
														
										vasoG.draw();
										equis.draw();		
										pulgar0.draw();
										pulgar1.draw();
										comprar.draw();
										numeros[chupitos[jugador4]].draw();
												
										while (true){
											Point pulsacion6 = lienzo.waitMouseClick();	
											
											
						//CUANDO EL JUGADOR QUIERE COMPRARLA
											if (pulsacion6.x>904&&pulsacion6.x<994&&pulsacion6.y>395&&pulsacion6.y<481){
												
												pulgar0.undraw();
												pulgar1.undraw();
												cartas[jugador4].undraw();
												comprar.undraw();
												equis.undraw();
												vasoG.undraw();
												rectangulo.undraw();
												numeros[chupitos[jugador4]].undraw();
												adquiridas[jugador4]="jugador4";				
												
												
												if (jugador4==1||jugador4==3||jugador4==6||jugador4==8||jugador4==9||jugador4==11||jugador4==13||jugador4==14||jugador4==16||jugador4==18||jugador4==19||jugador4==21||jugador4==23||jugador4==24||jugador4==26||jugador4==27||jugador4==29||jugador4==31||jugador4==32||jugador4==34||jugador4==37||jugador4==39){
													
												tabla1=new Text(1115,cordenadas[jugador4],jugadores[turno]);
												tabla1.setColor(Color.BLACK);
												tabla1.draw();
												}
												
												
												
												break;
											}
											
						//CUANDO EL JUGADOR NO QUIERE COMPRARLA
											if (pulsacion6.x>1100&&pulsacion6.x<1200&&pulsacion6.y>395&&pulsacion6.y<485){
											
												pulgar0.undraw();
												pulgar1.undraw();
												cartas[jugador4].undraw();
												comprar.undraw();
												equis.undraw();
												vasoG.undraw();
												rectangulo.undraw();
												numeros[chupitos[jugador4]].undraw();
														
												break;
											}//IF
										}//WHILE
							
											
									}//ELSE
									
									}
									
								
								}//if jugador4
						turno=1;
							
	}	//while JUEGO COMPLETO

		
}//MAIN
		
	
	public static int Dado(){
	
		Picture dado1=new Picture("src/JuegoProgramacion/dado/dado1.png");
		Picture dado2=new Picture("src/JuegoProgramacion/dado/dado2.png");
		Picture dado3=new Picture("src/JuegoProgramacion/dado/dado3.png");
		Picture dado4=new Picture("src/JuegoProgramacion/dado/dado4.png");
		Picture dado5=new Picture("src/JuegoProgramacion/dado/dado5.png");
		Picture dado6=new Picture("src/JuegoProgramacion/dado/dado6.png");
		
		int numero=(int)(Math.random()*6+1);
		dado1.undraw();
		dado2.undraw();
		dado3.undraw();
		dado4.undraw();
		dado5.undraw();
		dado6.undraw();
		
			
		switch(numero){
		
		case 1:
			dado1.draw();
			dado1.translate(780, 30);
			
			break;
		case 2:
			dado2.draw();
			dado2.translate(780, 30);
			break;
		case 3:
			dado3.draw();
			dado3.translate(780, 30);
			break;
		case 4:
			dado4.draw();
			dado4.translate(780, 30);
			break;
		case 5:
			dado5.draw();
			dado5.translate(780, 30);
			break;
		case 6:
			dado6.draw();
			dado6.translate(780, 30);
			break;
		}
	return numero;
	}	

	
}