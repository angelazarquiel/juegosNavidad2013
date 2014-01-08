package Ahorcado;

import java.util.Scanner;

public class JuegoAhorcado {
	// Atributos de clase
	private static final int max_letras = 25;
	private static final int max_intentos = 7;
	private static int intentos = 0;
	private static boolean restar_intento = false;
	private static boolean encontrada = false;
	private static char letra = 0;
	private static String[] diccionario = { "GOTA", "ALQUILAR", "TIMIDO",
			"BASCULA", "RELLENAR", "EXTERIOR", "LOCUTOR", "CARTOGRAFIA",
			"PESADILLA", "COMEDIA", "GRADUAR", "DOCUMENTOS", "EVITAR",
			"ANTARTIDA", "TELEGRAMA", "AVISPA", "AMULETO", "NAVIDAD",
			"COCOLATE", "POLIGONO", "ARDILLA", "PETROLEO", "PROGRAMACION" };
	public static char[] palabra_introducida = new char[max_letras];
	public static char[] palabra_guardada = new char[max_letras];
	public static char[] palabra_diccionario = new char[max_letras];
	public static Scanner teclado = new Scanner(System.in);
	public static String palabra;

	public static void main(String[] args) {
		menu();
	}

	// METODO PARA MOSTRAR EL MENU
	public static void menu() {
		int opcion = 0;
		do {
			System.out.println("\n*  Menu  *");
			for (int k = 0; k < 10; k++)
				System.out.print("*");
			System.out.println();
			do {
				System.out
						.println(" 1. Iniciar juego introduciendo la palabra a adiviniar.");
				System.out
						.println(" 2. Iniciar juego utilizando una palabra aleatoria de nuestro diccionario");
				System.out.println(" 3. Salir. ");
				System.out.print(" \n Opcion --> ");
				opcion = teclado.nextInt();
			} while (opcion != 1 && opcion != 2 && opcion != 3);

			switch (opcion) {
			case 1:
				iniciarJuegoPalabra();
				break;
			case 2:
				iniciarJuegoAleatorio();
				break;
			case 3:
				System.out
						.println("Gracias por jugar al <<JUEGO DEL AHORCADO>>");
				break;
			}
		} while (opcion != 3);
	}

	// METODO Definicion de la palabra en el juego y posterior guardado en caracteres
	public static void definirPalabra() {

		System.out.print(" Ingrese una palabra para comenzar el juego: ");
		palabra = teclado.next().toLowerCase();
		for (int i = 0; i < palabra.length(); i++) {
			palabra_introducida[i] = palabra.charAt(i);
			palabra_guardada[i] = '_';
		}
		System.out.println(" La palabra se ha guardado correctamente");
	}

	// METODO Limpiar Palabra Guardada por si existiese una palabra_guardada anterior
	public static void limpiarPalabra() {
		for (int i = 0; i < palabra_guardada.length; i++)
			palabra_guardada[i] = ' ';
		for (int i = 0; i < palabra.length(); i++)
			palabra_guardada[i] = '_';
	}

	// METODO Iniciar juego con la opción: 1 palabra introducida
	public static void iniciarJuegoPalabra() {
		definirPalabra();
		limpiarPalabra();
		do {
			mostarPalabraEspacios();
			ingresarLetra();
			buscaLetraEnPalabra(letra);
			compararPalabra();
			intentosUsados();
		} while (intentos < max_intentos && !encontrada);
		finJuego();
	}

	// METODO Busca letra en la palabra_introducida y la guarda en su posicion correspondiente en palabra_guardada
	public static void buscaLetraEnPalabra(char letra) {
		System.out.println(" Letra ingresada " + letra);
		letra = Character.toLowerCase(letra);
		restar_intento = false;
		for (int i = 0; i < palabra_introducida.length; i++) {
			if (letra == palabra_introducida[i]) {
				palabra_guardada[i] = letra;
				restar_intento = true;
			}
		}
		if (restar_intento == true) {
			intentos--;
		}
	}

	// METODO Compara los caracteres de palabra_introducida con los de palabra_guardada en todas sus posiciones
	public static void compararPalabra() {
		for (int i = 0; i < palabra_introducida.length; i++) {
			if ((int) palabra_introducida[i] != 0) {
				if (palabra_introducida[i] == palabra_guardada[i]) {
					encontrada = true;
				} else {
					encontrada = false;
					break;
				}
			}
		}
	}

	// METODO Iniciar juego en la opción 2: palabra aleatoria
	public static void iniciarJuegoAleatorio() {
		definirPalabraDiccionario();
		limpiarPalabra();
		do {
			mostarPalabraEspacios();
			ingresarLetra();
			buscaLetraEnPalabraDiccionario(letra);
			compararPalabraDiccionario();
			intentosUsados();
		} while (intentos < max_intentos && !encontrada);
		finJuego();
	}

	// METODO Guardar palabra diccionario en caracteres
	public static void definirPalabraDiccionario() {

		palabra = randomDiccionario().toLowerCase();
		for (int i = 0; i < palabra.length(); i++) {
			palabra_diccionario[i] = palabra.charAt(i);
			palabra_guardada[i] = '_';
		}
		System.out.println(" La palabra se ha guardado correctamente");
	}

	// METODO Elegir una palabra de forma aleatoria del vector "diccionario"
	private static String randomDiccionario() {
		int num = (int) (Math.random() * (diccionario.length));
		return diccionario[num];
	}

	// METODO Busca letra en la palabra_diccionario y la guarda en su posicion correspondiente en palabra_guardada
	public static void buscaLetraEnPalabraDiccionario(char letra) {
		System.out.println(" Letra ingresada " + letra);
		letra = Character.toLowerCase(letra);
		restar_intento = false;
		for (int i = 0; i < palabra_diccionario.length; i++) {
			if (letra == palabra_diccionario[i]) {
				palabra_guardada[i] = letra;
				restar_intento = true;
			}
			
			}if (restar_intento == true) {
				intentos--;
		}
	}

	// METODO Compara la palabra introducida con palabra diccionario
	public static void compararPalabraDiccionario() {
		for (int i = 0; i < palabra_diccionario.length; i++) {
			if ((int) palabra_diccionario[i] != 0) {
				if (palabra_diccionario[i] == palabra_guardada[i]) {
					encontrada = true;
				} else {
					encontrada = false;
					break;
				}
			}
		}
	}

	// METODO juego finalizado y muestra los mensajes
	public static void finJuego() {
		if (intentos < max_intentos && encontrada) {

			System.out.println("\n \t \t \t " + ">> PALABRA ENCONTRADA <<");
			for (int i = 0; i < 25; i++) {
				System.out.print(" * ");
			}
			System.out.println("\n \t \t " + " - ENHORABUENA, te has librado por los pelos - ");
			for (int i = 0; i < 25; i++) {
				System.out.print(" * ");
			}
			System.out.print("\n" + " Número de intentos empleados : " + intentos + "\n");
		} else {
			for (int i = 0; i < 25; i++) {
				System.out.print(" *");
			}
			System.out
					.println("\n" + " \t \t  NO LO HAS CONSEGUIDO \n \t MORIRAS ENTRE TERRIBLE SUFRIMIENTO ");
			for (int i = 0; i < 25; i++) {
				System.out.print(" *");
			}
		}
	}

	// METODO Muestra el número de intentos usados y el máximo
	public static void intentosUsados() {
		System.out.println(" Intentos " + intentos + ". Nº máximo de intentos "
				+ max_intentos);
	}

	// METODO Mostrar palabra: espacios o caracteres acertados
	public static void mostarPalabraEspacios() {
		System.out.println("\n");

		for (char l : palabra_guardada) {
			if ((int) l != 0) {
				System.out.print(" " + l);
			}
		}
	}

	// METODO ingresar letra por teclado
	public static char ingresarLetra() {
		System.out.print(" \n\n Ingrese una letra : ");
		letra = new String(teclado.next()).charAt(0);
		intentos++;
		return letra;
	}
}