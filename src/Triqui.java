import java.util.Scanner;


public class Triqui {


    private char[][] tablero;
    private char jugadorActual;

    public Triqui() {
        tablero = new char[3][3];
        jugadorActual = 'X';
        inicializarTablero();
    }

    public void jugar() {
        Scanner scanner = new Scanner(System.in);

        do {
            dibujarTablero();
            int fila, columna;
            do {
                //indicaciones al usuario
                System.out.println("Jugador " + jugadorActual + ", ingresa fila (0, 1, 2) y columna (0, 1, 2) separadas por espacio: ");
                fila = scanner.nextInt();
                columna = scanner.nextInt();
            } while (!movimientoValido(fila, columna));

            tablero[fila][columna] = jugadorActual;
            //establero funciona basado en imprimir en diferentes renglones los datos como si fuera una matriz y despues de cada jugada vuelve a imprimir como quedo nuevamente
            if (hayGanador()) {
                dibujarTablero();
                System.out.println("¡Jugador " + jugadorActual + " gana!");
                break;
            } else if (tableroLleno()) {
                dibujarTablero();
                System.out.println("Empate.");
                break;
            }

            cambiarJugador();
        } while (true);

        scanner.close();
    }


    private void inicializarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = ' ';
            }
        }
    }
    private void dibujarTablero() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean movimientoValido(int fila, int columna) {
        if (fila < 0 || fila >= 3 || columna < 0 || columna >= 3 || tablero[fila][columna] != ' ') {
            System.out.println("Movimiento no válido. Inténtalo de nuevo.");
            return false;
        }
        return true;
    }

    private void cambiarJugador() {
        if (jugadorActual == 'X') {
            jugadorActual = 'O';
        } else {
            jugadorActual = 'X';
        }
    }

    private boolean hayGanador() {
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugadorActual && tablero[i][1] == jugadorActual && tablero[i][2] == jugadorActual) {
                return true; // Verificar filas
            }
            if (tablero[0][i] == jugadorActual && tablero[1][i] == jugadorActual && tablero[2][i] == jugadorActual) {
                return true; // Verificar columnas
            }
        }
        if (tablero[0][0] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][2] == jugadorActual) {
            return true; // Verificar diagonal principal
        }
        if (tablero[0][2] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][0] == jugadorActual) {
            return true; // Verificar diagonal secundaria
        }
        return false;
    }

    private boolean tableroLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Triqui juego = new Triqui();
        juego.jugar();
    }
}



