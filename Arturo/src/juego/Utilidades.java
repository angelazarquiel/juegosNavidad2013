package juego;

public class Utilidades {
	

	public static final int RADIO_TECLA_ANCHO = 90;
	public static final int RADIO_BOTON_ANCHO = 140;
	public static final int RADIO_ALTO = 90;
	
	public static void main(String[] args) {

		
		
	}

	public static int aleatorio(int min, int max){
		int sol = 0;
		sol = (int)(Math.random()* ((max - min) + 1)) + min;
		return sol;
	}
	
	public static String nuevaPalabra(String[] palabras){
		int max=palabras.length;
		return palabras[aleatorio(0, max-1)];
	}
	
	
	
}
