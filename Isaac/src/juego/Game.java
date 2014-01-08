package juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel {

	Ball ball = new Ball(this);
	Racquet racquet = new Racquet(this);
	int speed = 1;

	private int getScore() {
		return speed - 1;
	}
	
	private URL url = getClass().getResource("/imagenes/fondo.jpg"); // Con estas dos lineas añado la imagen de fondo
	Image image = new ImageIcon(url).getImage();
	
	//Clase Anonima
	public Game() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);			// Informamos que se ha soltado una tecla
			}

			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);			// Informamos que se ha pulsado una tecla
			}
		});
		setFocusable(true);
	}
	
	private void move() {
		ball.move();
		racquet.move();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g); // el super hace que la bola sea borrada cada vez que se mueve de uno en uno
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); // estas dos lineas borran las asperezas
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		ball.paint(g2d);
		racquet.paint(g2d);
		g2d.setColor(Color.GRAY);
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		g2d.drawString(String.valueOf(getScore()), 10, 30);
	}
	
	// Metodo Game Over. Nos saltará un pop up de Game Over y un boton ACEPTAR y finalizará
	public void gameOver() {
		JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
		JOptionPane.showMessageDialog(this, "your score is: " + getScore(),
				"Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Mini Tennis"); // te crea la ventana de juego y su titulo
		Game game = new Game(); 
		frame.add(game);
		frame.setSize(500, 700); //tamaño de la ventana
		frame.setVisible(true);	//Es indispensable para que se vea
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Hace que maximice o cierre la ventana. Responde al raton
		
		while (true) {
			game.move();	// actualiza la posicion de la bola
			game.repaint();	// vuelve a pintar la bola
			Thread.sleep(10); // para evitar conflictos con otrod threads (hilos de ejecucion) como el
		}					  // del metodo paint que es automatico se le hace parar con este sleep
	}
}