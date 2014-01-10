package TresEnRaya;

import java.awt.Point;

import graphics2.Canvas;
import graphics2.Color;
import graphics2.Ellipse;
import graphics2.Line;
import graphics2.Rectangle;
import graphics2.Text;

import javax.swing.JOptionPane;


public class main {	
	

	public static void main(String[] args) {
		int x;
		int y;
		int z;
		int s;
		int empate = 0;
		boolean bot = false;
		boolean play = false;
		boolean uno = true,dos = true,tres = true,cuatro = true,cinco = true,seis = true,siete = true,ocho = true,nueve = true;
		boolean botuno = false,botdos = false,bottres = false,botcuatro = false,botcinco = false,botseis = false,botsiete = false,botocho = false,botnueve = false;
		boolean playuno = false,playdos = false,playtres = false,playcuatro = false,playcinco = false,playseis = false,playsiete = false,playocho = false,playnueve = false;
		boolean difuno = true, difdos = true, diftres = true, difcuatro = true, difcinco = true, difseis = true, difsiete = true, difocho = true, difnueve = true;
		opcion();
		posicion();
		x = posicionx();
		y = posiciony();
		
		if (x >= 200 && y >= 330 && x <= 300 && y <= 380) {
			play = true;
		}
		
		if (x >= 410 && y >= 330 && x <= 510 && y <= 380) {
			bot = true;
		}
		
		dibujarTablero();
		
		while(true){
			
			
			
			while(play){
				bot = true;
				posicion();
				x = posicionx();
				y = posiciony();
				System.out.println(x + "+" + y);
				//Primer cuadro
				if (x >= 50 && y >= 50 && x <=245 && y <= 245 && uno == true) {
					x = 75;
					y = 75;
					circulo(x, y);
					playuno = true;
					uno = false;
					empate = empate +1;
					break;
				}
				//Segundo cuadro
				if (x >= 255 && y >= 50 && x <=455 && y <= 245 && dos == true) {
					x = 75;
					y = 280;
					circulo(x, y);
					playdos = true;
					dos = false;
					empate = empate +1;
					break;
				}
				//Tercer cuadro
				if (x >= 465 && y >= 50 && x <=670 && y <= 245 && tres == true) {
					x = 75;
					y = 490;
					circulo(x, y);
					playtres = true;
					tres = false;
					empate = empate +1;
					break;
				}
				//Cuarto cuadro
				if (x >= 50 && y >= 255 && x <=245 && y <= 455 && cuatro == true) {
					x = 280;
					y = 75;
					circulo(x, y);
					playcuatro = true;
					cuatro = false;
					empate = empate +1;
					break;
				}
				//Quinto cuadro
				if (x >= 255 && y >= 255 && x <=455 && y <= 455 && cinco == true) {
					x = 280;
					y = 280;
					circulo(x, y);
					playcinco = true;
					cinco = false;
					empate = empate +1;
					break;
				}
				//Sexto cuadro
				if (x >= 465 && y >= 255 && x <=670 && y <= 455 && seis == true) {
					x = 280;
					y = 490;
					circulo(x, y);
					playseis = true;
					seis = false;
					empate = empate +1;
					break;
				}
				//Septimo cuadro
				if (x >= 50 && y >= 465 && x <=245 && y <= 670 && siete == true) {
					x = 490;
					y = 75;
					circulo(x, y);
					playsiete = true;
					siete = false;
					empate = empate +1;
					break;
				}
				//Octavo cuadro
				if (x >= 255 && y >= 465 && x <=455 && y <= 670 && ocho == true) {
					x = 490;
					y = 280;
					circulo(x, y);
					playocho = true;
					ocho = false;
					empate = empate +1;
					break;
				}
				//Noveno cuadro
				if (x >= 465 && y >= 465 && x <=670 && y <= 670 && nueve == true) {
					x = 490;
					y = 490;
					circulo(x, y);
					playnueve = true;
					nueve = false;
					empate = empate +1;
					break;
				}
				break;
			}
			
			if (playuno && playcinco && playnueve == true || playuno && playcuatro && playsiete == true || playuno && playdos && playtres == true || playcuatro && playcinco && playseis == true || playsiete && playocho && playnueve == true || playtres && playcinco && playsiete == true || playuno && playcuatro && playsiete == true || playdos && playcinco && playocho == true || playtres && playseis && playnueve == true) {
				JOptionPane.showMessageDialog(null, "Felicidades usted es el ganador");
				break;
			}
			
			
			while(true){
				//Empieza el hacer a la maquina mas inteligente
				//Marca la casilla 7
				if (playtres && playcinco && difuno == true) {
					x = 490;
					y = 75;
					z = 220;
					s = 635;
					equis1(x, y , z , s);
					x = 490;
					y = 220;
					z = 75;
					s = 635;
					equis2(x, y , z , s);
					difuno = false;
					botsiete = true;
					siete = false;
					bot = false;
					empate = empate +1;
					break;
				}
				//Marca la casilla 9
				if (playuno && playcinco && difdos == true) {
					x = 490;
					y = 490;
					z = 635;
					s = 635;
					equis1(x, y , z , s);
					x = 490;
					y = 635;
					z = 490;
					s = 635;
					equis2(x, y , z , s);
					botnueve = true;
					nueve = false;
					difdos = false;
					bot = false;
					empate = empate +1;
					break;
				}
				//Marca la casilla 3
				if (playsiete && playcinco && diftres == true) {
					x = 75;
					y = 490;
					z = 635;
					s = 220;
					equis1(x, y , z , s);
					x = 75;
					y = 635;
					z = 490;
					s = 220;
					equis2(x, y , z , s);
					bottres = true;
					tres = false;
					diftres = false;
					bot = false;
					empate = empate +1;
					break;
				}
				//Marca la casilla 8
				if (playdos && playcinco && difcuatro == true) {
					x = 490;
					y = 275;
					z = 420;
					s = 635;
					equis1(x, y , z , s);
					x = 490;
					y = 420;
					z = 275;
					s = 635;
					equis2(x, y , z , s);
					botocho = true;
					ocho = false;
					difcuatro = false;
					bot = false;
					empate = empate +1;
					break;
				}
				//Marca la casilla 6
				if (playcuatro && playcinco && difcinco == true) {
					x = 275;
					y = 490;
					z = 635;
					s = 420;
					equis1(x, y , z , s);
					x = 275;
					y = 635;
					z = 490;
					s = 420;
					equis2(x, y , z , s);
					botseis = true;
					seis = false;
					difcinco = false;
					bot = false;
					empate = empate +1;
					break;
				}
				//Marca la casilla 4
				if (playseis && playcinco && difseis == true) {
					x = 280;
					y = 75;
					z = 220;
					s = 425;
					equis1(x, y , z , s);
					x = 425;
					y = 75;
					z = 220;
					s = 280;
					equis2(x, y , z , s);
					botcuatro = true;
					cuatro = false;
					difseis = false;
					bot = false;
					empate = empate +1;
					break;
				}
				//Marca la casilla 7
				if (playuno && playcuatro && difsiete == true) {
					x = 490;
					y = 75;
					z = 220;
					s = 635;
					equis1(x, y , z , s);
					x = 490;
					y = 220;
					z = 75;
					s = 635;
					equis2(x, y , z , s);
					botsiete = true;
					siete = false;
					difsiete = false;
					bot = false;
					empate = empate +1;
					break;
				}
				//Marca la casilla 8
				if (playtres && playseis && difocho == true) {
					x = 490;
					y = 490;
					z = 635;
					s = 635;
					equis1(x, y , z , s);
					x = 490;
					y = 635;
					z = 490;
					s = 635;
					equis2(x, y , z , s);
					botnueve = true;
					nueve = false;
					difocho = false;
					bot = false;
					empate = empate +1;
					break;
				}
				//Marca la casilla 3
				if (playseis && playnueve && difnueve == true) {
					x = 75;
					y = 490;
					z = 635;
					s = 220;
					equis1(x, y , z , s);
					x = 75;
					y = 635;
					z = 490;
					s = 220;
					equis2(x, y , z , s);
					bottres = true;
					tres = false;
					difnueve = false;
					bot = false;
					empate = empate +1;
					break;
				}
				break;
			}
			
			
			while(bot){
				play = true;
				//Empieza el codigo de la maquina
				
				//Primer cuadro
				if (uno == true) {
					x = 75;
					y = 75;
					z = 220;
					s = 220;
					equis1(x, y , z , s);
					x = 75;
					y = 220;
					z = 75;
					s = 220;
					equis2(x, y , z , s);
					botuno = true;
					uno = false;
					empate = empate +1;
					break;
				}
				//Segundo cuadro
				if (dos == true) {
					x = 75;
					y = 280;
					z = 425;
					s = 220;
					equis1(x, y , z , s);
					x = 75;
					y = 425;
					z = 280;
					s = 220;
					equis2(x, y , z , s);
					botdos = true;
					dos = false;
					empate = empate +1;
					break;
				}
				//Tercer cuadro
				if (tres == true) {
					x = 75;
					y = 490;
					z = 635;
					s = 220;
					equis1(x, y , z , s);
					x = 75;
					y = 635;
					z = 490;
					s = 220;
					equis2(x, y , z , s);
					bottres = true;
					tres = false;
					empate = empate +1;
					break;
				}
				//Cuarto cuadro
				if (cuatro == true) {
					x = 280;
					y = 75;
					z = 220;
					s = 425;
					equis1(x, y , z , s);
					x = 425;
					y = 75;
					z = 220;
					s = 280;
					equis2(x, y , z , s);
					botcuatro = true;
					cuatro = false;
					empate = empate +1;
					break;
				}
				//Quinto cuadro
				if (cinco == true) {
					x = 275;
					y = 275;
					z = 425;
					s = 425;
					equis1(x, y , z , s);
					x = 425;
					y = 275;
					z = 425;
					s = 275;
					equis2(x, y , z , s);
					botcinco = true;
					cinco = false;
					empate = empate +1;
					break;
				}
				//Sexto cuadro
				if (seis == true) {
					x = 275;
					y = 490;
					z = 635;
					s = 420;
					equis1(x, y , z , s);
					x = 275;
					y = 635;
					z = 490;
					s = 420;
					equis2(x, y , z , s);
					botseis = true;
					seis = false;
					empate = empate +1;
					break;
				}
				//Septimo cuadro
				if (siete == true) {
					x = 490;
					y = 75;
					z = 220;
					s = 635;
					equis1(x, y , z , s);
					x = 490;
					y = 220;
					z = 75;
					s = 635;
					equis2(x, y , z , s);
					botsiete = true;
					siete = false;
					empate = empate +1;
					break;
				}
				//Octavo cuadro
				if (ocho == true) {
					x = 490;
					y = 275;
					z = 420;
					s = 635;
					equis1(x, y , z , s);
					x = 490;
					y = 420;
					z = 275;
					s = 635;
					equis2(x, y , z , s);
					botocho = true;
					ocho = false;
					empate = empate +1;
					break;
				}
				//Noveno cuadro
				if (nueve == true) {
					x = 490;
					y = 490;
					z = 635;
					s = 635;
					equis1(x, y , z , s);
					x = 490;
					y = 635;
					z = 490;
					s = 635;
					equis2(x, y , z , s);
					botnueve = true;
					nueve = false;
					empate = empate +1;
					break;
				}
				break;
	
			}
			
			if(empate >= 9){
				JOptionPane.showMessageDialog(null, "Empate!");
				break;
			}
			
			if (botuno && botcinco && botnueve == true || botuno && botcuatro && botsiete == true || botuno && botdos && bottres == true || botcuatro && botcinco && botseis == true || botsiete && botocho && botnueve == true || bottres && botcinco && botsiete == true || botuno && botcuatro && botsiete == true || botdos && botcinco && botocho == true || bottres && botseis && botnueve == true) {
				JOptionPane.showMessageDialog(null, "La maquina es la ganadora");
				break;
			}
			
			
				
		}

	}
	
	
	public static void opcion(){
		//Boton Jugador
		Rectangle player = new Rectangle (200,330,100,50);
		Color player1 = new Color(217,217,217);
		player.setColor(player1);
		
		Rectangle playerborde = new Rectangle (199,329,102,52);
		Color player1borde = new Color(66,66,66);
		playerborde.setColor(player1borde);
		
		Text playertexto = new Text(234,346,"Player");
		
		//Boton maquina
		Rectangle bot = new Rectangle (410,330,100,50);
		Color bot1 = new Color(217,217,217);
		bot.setColor(bot1);
		
		Rectangle botborde = new Rectangle (409,329,102,52);
		Color bot1borde = new Color(66,66,66);
		botborde.setColor(bot1borde);
		
		Text bottexto = new Text(439,346,"Maquina");
		
		//Boton pregunta
		Rectangle empieza = new Rectangle (250,250,200,50);
		Color empieza1 = new Color(217,217,217);
		empieza.setColor(empieza1);
		
		Rectangle empiezaborde = new Rectangle (249,249,202,52);
		Color empieza1borde = new Color(66,66,66);
		empiezaborde.setColor(empieza1borde);
		
		Text empiezatexto = new Text(280,265,"Quien empieza jugando?");
		
		playerborde.fill();
		player.fill();
		playertexto.draw();
		
		botborde.fill();
		bot.fill();
		bottexto.draw();
		
		empiezaborde.fill();
		empieza.fill();
		empiezatexto.draw();
		
	}
	
	public static void posicion(){
		posiciony();
		posicionx();
		Canvas c;
		c = Canvas.getInstance();
		c.waitMouseClick();
	}
	
	public static int posicionx(){
		Canvas c;
		c = Canvas.getInstance();
		c.getMousePosition();
		Point pulsacion = c.getMousePosition();
		return pulsacion.x;
	}
	
	public static int posiciony(){
		Canvas c;
		c = Canvas.getInstance();
		c.getMousePosition();
		Point pulsacion = c.getMousePosition();
		return pulsacion.y;
	}
	
	public static void equis1(int x, int y, int z, int s){
		Line equis1 = new Line(y,x,z,s);
		equis1.setThickness(10);
		equis1.setColor(Color.RED);
		
		equis1.draw();
	}
	public static void equis2(int x, int y, int z, int s){
		Line equis2 = new Line(y,x,z,s);
		equis2.setThickness(10);
		equis2.setColor(Color.RED);
		equis2.draw();
	}
	
	public static void circulo(int x, int y){
		Ellipse circulo = new Ellipse(y,x,150,150);
		circulo.setThickness(20);
		circulo.setColor(Color.RED);
		
		circulo.draw();
	}
	
	public static void dibujarTablero(){
		Rectangle tablero = new Rectangle(50,50,620,620);
		tablero.setColor(Color.GRAY);
		
		Rectangle barra1 = new Rectangle(245,50,10,620);
		barra1.setColor(Color.RED);
		
		Rectangle barra2 = new Rectangle(455,50,10,620);
		barra2.setColor(Color.RED);
		
		Rectangle barra3 = new Rectangle(50,245,620,10);
		barra3.setColor(Color.RED);
		
		Rectangle barra4 = new Rectangle(50,455,620,10);
		barra4.setColor(Color.RED);
		
		tablero.fill();
		barra1.fill();
		barra2.fill();
		barra3.fill();
		barra4.fill();
	}

}
