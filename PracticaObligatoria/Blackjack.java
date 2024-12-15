package PracticaObligatoria;

import java.util.Scanner;

public class Blackjack {
    // Variables de la clase
    private Baraja b;
    private String jugador;
    private double puntosJugador;
    private double puntosCroupier;

    // Constructor de Blackjack
    public Blackjack(int tipo){
            b = new Baraja(tipo);
            b.barajar();
    }

    // Método para jugar
    public void jugar() {
        Scanner sc = new Scanner(System.in);


        System.out.println("Bienvenido al juego de Blackjack. \n Introducción al juego: Para ganar debes obtener 21 puntos, si te pasas pierdes, si el croupier obtiene más puntos que tú, pierdes.");
        
        System.out.println("Introduce tu nombre: ");
        jugador = sc.next();

        jugarTurnoJugador();  // Método para jugar el turno del jugador
        jugarTurnoCroupier(); // Método para jugar el turno del croupier

        determinarGanador(); // Método para determinar el ganador
    }

        // Método para jugar turno del jugador
    private void jugarTurnoJugador() {
        Scanner sc = new Scanner(System.in);
        boolean stop = false;

        // El jugador saca dos cartas al inicio
        puntosJugador = 0;
        for (int i = 0; i < 2; i++) {
            Carta c = b.siguiente();
            puntosJugador += c.getValor();
            System.out.println("Has sacado un " + c);
            if (c.getValor() == 13) {
                
            }
        }

        // Si el jugador se pasa de 21, pierde
        if (puntosJugador > 21) {
            System.out.println("Te has pasado de 21 puntos, has perdido.");
            return;
        }

        // Si no se pasa de 21 puede elegir entre plantarse o sacar otra carta 
        while (!stop && puntosJugador < 21) {
            System.out.println("PUNTUACIÓN: " + puntosJugador);
            System.out.println("¿Quieres sacar otra carta? (s/n)");
            String respuesta = sc.next();

            if (respuesta.equals("s")) {
                Carta c = b.siguiente();
                puntosJugador += c.getValor();
                System.out.println("Has sacado un " + c);

                if (puntosJugador > 21) {
                    System.out.println("Te has pasado de 21 puntos, has perdido.");
                    return;
                }
            } else {
                stop = true;
                System.out.println("Te has plantado con " + puntosJugador + " puntos.");
            }
        }
    }

    // Método para jugar turno del Croupier
    private void jugarTurnoCroupier() {
        
        // Inicializamos los puntos del croupier a 0
        puntosCroupier = 0;

        // El croupier saca cartas hasta alcanzar al menos 17 puntos    
        while (puntosCroupier < 17) {
            Carta c = b.siguiente();
            puntosCroupier += c.getValor();
            System.out.println("El croupier ha sacado un " + c);
        }

        // Comprobamos si el croupier se ha pasado de puntos o no.
        if (puntosCroupier > 21) {
            System.out.println("El croupier se ha pasado de 21 puntos.");
        } else {
            System.out.println("El croupier se planta con " + puntosCroupier + " puntos.");
        }
    }

    // Método para determinar el ganador
    private void determinarGanador() {
        System.out.println("\nResultados finales:");
        System.out.println(jugador + " tiene " + puntosJugador + " puntos.");
        System.out.println("El croupier tiene " + puntosCroupier + " puntos.");

        if (puntosJugador > 21) {
            System.out.println("Has perdido.");
        } else if (puntosCroupier > 21 || puntosJugador > puntosCroupier) {
            System.out.println("¡Has ganado!");
        } else if (puntosJugador < puntosCroupier) {
            System.out.println("Has perdido.");
        } else {
            System.out.println("Es un empate.");
        }
    }
}