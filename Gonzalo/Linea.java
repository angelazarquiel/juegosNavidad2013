package Linea1;

import java.io.*;

public class Linea {

        // Enumeramos los jugadores
        enum Turno {
                P1, P2
        }

        // Constantes
        private static final int MAX_POS = 9;
       
        private static final int COL_ROW = 3;

        private static final char JUGADOR_UNO = 'X';

        private static final char JUGADOR_DOS = 'O';
       
        private static final char NO_GANADOR = 'N';
       
        private static final String FILA = " %s | %s | %s ";
       
        private static final String LINEA = "\n-----------\n";
       
        private static final String ERROR = "ERROR!:Caracter No Valido, Por Favor, Intente Nuevamente JUGADOR ";
       
        private static final String GANADOR = "FIN DEL JUEGO: FELICIDADES %s!, HA GANADO!.";
       
        private static final String TURNO = ": Elija Una Casilla Ingresando El Numero Correspondiente.\n";
       
        // Variables.
        public char[] tablero;
        Turno turno;

        /*
         * Lleva Cuenta De Las Veces Que Han Participado Los Jugadores 1 y 2.
         */
        int contador;

        /* Constructor(Inicializa Variables). */
        public Linea() {

                tablero = new char[MAX_POS];
                turno = Turno.P1;
                contador = 0;
                inicializarTablero();
        }
       
        private int getIndice(int i, int j) {
                return (COL_ROW * i) + j;
        }

        /*
         * Inicia El Arreglo, Especifica El Numero Que Le Corresponde A Cada
         * Casilla.
         */
        public void inicializarTablero() {
                for (int i = 0; i < MAX_POS; i++) {
                        tablero[i] = Integer.toString(i + 1).charAt(0);
                }
        }

        /*
         *  Imprime El Formato Del Tablero.
         *
         */
        public void imprimirTablero() {

                StringBuffer buffer = new StringBuffer();
               
                for (int i = 0; i < COL_ROW; i++) {

                        Object[] valoresDeFila = new Object[] {
                                        tablero[getIndice(i, 0)],
                                        tablero[getIndice(i, 1)],
                                        tablero[getIndice(i, 2)] };

                        buffer.append(String.format(FILA, valoresDeFila));

                        if (i < 2) { buffer.append(LINEA); }

                }
                buffer.append("\n\n\n");
               
                System.out.print(buffer.toString());
        }

        /*
         * Indica La Posicion Donde Se Ingresara El Dato Dentro Del Arreglo Por
         * Medio De Parametros
         */
        public void indicarPosicionArreglo(int indice, char c) {
                tablero[indice] = c;
        }

        /*
         * Manipula el valor De La Variable "contador".
         */
        public void setContador(int e) {
                contador = e;
        }

        /*
         * Regresa Valor De La Posicion Del Arreglo Indicada Por Medio De
         * Parametros
         */
        public char getPosicionArreglo(int indice) {
                return tablero[indice];
        }

        /* Regresa Valor De La Variable "contador". */
        public int getContador() {
                return contador;
        }

        /*
         * Imprime e Indica El El Turno Del Jugador Que Le Toca Elejir Una Casilla
         * Con Ayuda del Metodo "getTurno()".
         */
        public void indicarTurno() {
                System.out.println(turno.toString().concat(TURNO));
        }

        /*
         * Regresa El Caracter De Tipo Char Para Posteriormente Ingresarlo A Alguna
         * Posicion Del Arreglo, Usandolo En Otro Metodo.
         */
        public char obtenerFigura() {
                return (turno.equals(Turno.P1)) ? JUGADOR_UNO : JUGADOR_DOS;
        }

        /*
         *  Cambia El Valor De La Variable "turno" Para Llevar El Orden Correcto De
         *  Los Turnos Entre Los 2 Jugadores.
         */
        public void cambiarTurno() {
                if (obtenerFigura() == JUGADOR_UNO)
                        setTurno(Turno.P2);
                else
                        setTurno(Turno.P1);
        }

        private void setTurno(Turno jugador) {
                turno = jugador;
        }

        /* Verifica Si La Posicion Del Arreglo Al Que El Jugador Desea Ingresar El
         * Caracter No Fue Utilizada Antes.
         */
        public void comprobarEspacio(char espacio, int indice) {

                // Si Se Cumple La Condicion Se Ingresa El Valor En La Posicion Del
                // Arreglo Especificada.
                if (espacio != JUGADOR_UNO && espacio != JUGADOR_DOS) {

                        // Ingresa EL Caracter Si  Se Cumple  La Condicion.
                        indicarPosicionArreglo(indice, obtenerFigura());
                        cambiarTurno(); // Cambia El Turno Si Se Cumple La Condicion.
                        contador++; // Solo Incremente Cuando Se Cumple La Anterior
                                                // Condicion.
                } else {
                        // Imprime El Siguiente Mensaje En Caso De Que No Se Cumpla La
                        // Anterior Condicion.
                        System.out.println("La Casilla Esta Ocupada, Elija Otra Por Favor");
                }
        }

        // Metodo Que Hace Uso De Un "switch" Para Indicar La Posicion Del Arreglo
        // Que El Jugador Elijio En El Juego.
        public void elegirPosicion(int posicion) {
                if (0 <= posicion && posicion <= 8) {
                         comprobarEspacio(getPosicionArreglo(posicion), posicion);
                } else {
                        System.out.println("Por Favor, Ingrese Solo Un Digito Del 1 al 9.");
                }
        }

        /* Solo Imprime Un Mensaje Distinto Dependiendo Del Jugador Que Haya
         *  Resultado Ganador.
         */
        public void decirGanador(char a) {
                System.out.println(String.format(GANADOR, (a == JUGADOR_UNO) ? Turno.P1 : Turno.P2).toString());
        }

        // Verifica Las Unicas 8 Combinaciones Que Pueden Dar La Victoria A Uno De
        // Los Jugadores.
        public char buscarGanador() {

                // Ciclo Con Instrucciones Para Comprobar Las 3 Posibilidades De Ganar
                // De Forma Horizontal.
                for (int i = 0; i < 3; i++) {
                        if (tablero[getIndice(i, 0)] == tablero[getIndice(i, 1)]
                                        && tablero[getIndice(i, 1)] == tablero[getIndice(i, 2)]) {
                                return tablero[getIndice(i, 1)];
                        }
                }

                // Ciclo Con Instrucciones Para Comprobar Las 3 Posibilidades De Ganar
                // De Forma Vertical.
                for (int j = 0; j < 3; j++) {
                        if (tablero[getIndice(0, j)] == tablero[getIndice(1, j)]
                                        && tablero[getIndice(1, j)] == tablero[getIndice(2, j)]) {
                                return tablero[getIndice(1, j)];
                        }
                }

                // Instrucciones Para Comprobar La Unica Posibilidad De Ganar De Forma
                // Diagonal.
                if (tablero[getIndice(0, 0)] == tablero[getIndice(1, 1)]
                                && tablero[getIndice(1, 1)] == tablero[getIndice(2, 2)]) {
                        return tablero[getIndice(1, 1)];
                }

                // Ciclo Con Instrucciones Para Comprobar La Unica Posibilidade De Ganar
                // De Forma Diagonal Inversa.
                if (tablero[getIndice(0, 2)] == tablero[getIndice(1, 1)]
                                && tablero[getIndice(1, 1)] == tablero[getIndice(2, 0)]) {
                        return tablero[getIndice(1, 1)];
                }
               
                return NO_GANADOR;
               
        }

        // Metodo Que Contiene El Flujo Y El Orden Del Juego.
        public void jugarGato() {

                BufferedReader entrada = new BufferedReader(new InputStreamReader(
                                System.in));

                System.out.println("BIENVENIDO A LAS 3 EN LINEA");

                do {

                        indicarTurno();
                        imprimirTablero();
                       
                        try {
                                elegirPosicion(Integer.parseInt(entrada.readLine()) - 1);
                        } catch (IOException | NumberFormatException e) {
                                System.out.println(ERROR.concat(turno.toString()));
                        }

                        char ganador = buscarGanador();
                       
                        if (ganador != NO_GANADOR) {
                                decirGanador(ganador);
                                imprimirTablero();
                                setContador(10);
                        }

                } while (getContador() < 9);

                if (getContador() == 9) {
                        System.out.println("¡JUEGO EMPATADO!");
                        imprimirTablero();
                }

                System.out.println("¡GRACIAS POR JUGAR!");
        }

        public static void main(String[] args) {
                new Linea().jugarGato();
        }
}



