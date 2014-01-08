package juego;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	
	private static final int DIAMETER = 30;  // Constante
	int x = 0;	// Variables para la posicion x e y
	int y = 0;	// velocidad en el eje x e y
	int xa = 1;
	int ya = 1;
	private Game game;

	public Ball(Game game) {
		this.game = game;
	}

	// metodo para hacer la animacion de la bola, ampliando de uno en uno
	void move() {
		if (x + xa < 0) // si se cumple 
			xa = game.speed;		// cambiamos la direccion hacia la derecha
		if (x + xa > game.getWidth() - DIAMETER) // si se cumple
			xa = -game.speed;	// cambiamos la direccion hacia la izquierda
		if (y + ya < 0)
			ya = game.speed;
		if (y + ya > game.getHeight() - DIAMETER) // Si llega a la parte de abajo: GAME OVER
			game.gameOver();
		if (collision()){  // Valor booleano definido en el metodo collision: true o false
			ya = -game.speed;  // La bola irá hacia arriba
			y = game.racquet.getTopY() - DIAMETER; // Esta linea evita un posible error en la colision; mueve la bola a la parte superior de la raqueta
												   // en el caso de que la colision se produzca en el extremo de la raqueta (se producirian varias colisiones simultaneas en esa misma colision)
			game.speed++;
		}						
		x = x + xa;				
		y = y + ya;
	}
	
	// Cuando haya interseccion entre los dos sprites sera true
	private boolean collision() {
		return game.racquet.getBounds().intersects(getBounds());
	}

	public void paint(Graphics2D g) {
		g.fillOval(x, y, DIAMETER, DIAMETER);
		
	}
	
	// java.awt.Rectangle; tiene este metodo para devolver un rectangulo de la bola para 
	// saber la posicion y despues comprobar si hay interseccion con la raqueta
	public Rectangle getBounds() { // getBounds retorna un rectangulo indicando la posicion de la pelota
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}