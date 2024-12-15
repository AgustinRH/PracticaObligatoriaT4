package PracticaObligatoria;

import java.util.Scanner;

public class Blackjack {
   
    private Baraja b;
    private String jugador;
    private double puntosJugador;
    private double puntosCroupier;

    public Blackjack(int tipo){
            b = new Baraja(tipo);
            b.barajar();
    }

    public void jugar() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido al juego de Blackjack. \n Introducción al juego: Para ganar debes obtener 21 puntos, si te pasas pierdes, si el croupier obtiene más puntos que tú, pierdes.");
        
        System.out.println("Introduce tu nombre: ");
        jugador = sc.next();

        jugarTurnoJugador();
        jugarTurnoCroupier();

        determinarGanador();
    }

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

        // Si el jugador saca un As, le pregunta si quiere que valga 1 o 11
        if (puntosJugador > 21) {
            System.out.println("Te has pasado de 21 puntos, has perdido.");
            return;
        }

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

    private void jugarTurnoCroupier() {
        // El croupier saca cartas hasta alcanzar al menos 17 puntos
        puntosCroupier = 0;

        while (puntosCroupier < 17) {
            Carta c = b.siguiente();
            puntosCroupier += c.getValor();
            System.out.println("El croupier ha sacado un " + c);
        }

        if (puntosCroupier > 21) {
            System.out.println("El croupier se ha pasado de 21 puntos.");
        } else {
            System.out.println("El croupier se planta con " + puntosCroupier + " puntos.");
        }
    }

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