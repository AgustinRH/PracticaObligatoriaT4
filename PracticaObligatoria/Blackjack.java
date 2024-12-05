package PracticaObligatoria;

import java.util.Scanner;

public class Blackjack {
   
    private Baraja b;
    private String jugador;
    private double puntos;

    public Blackjack(int tipo){
        if (tipo == 1 ) {
            b = new Baraja(tipo);
            b.barajar();
        } else {
            System.out.println("¡El blackjac es un juego de póker!");
        }
    }

    public void jugar() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido al juego de Blackjack. \n Introducción al juego: Para ganar debes obtener 21 puntos, si te pasas pierdes, si el coupier obtiene más puntos que tú, pierdes.");
        
        System.out.println("introduce tu nombre: ");
        jugador = sc.next();

        jugador(jugador);

        sc.close();
    }

    private void jugador(String jugador) {
        Scanner sc = new Scanner(System.in);

        boolean stop = false;

        Carta c = b.siguiente(); // Llamamos a la clase Carta

        System.out.println("Bienvenido " + jugador + ", aquí empieza tu desafio.");
        puntos = c.getValor();
        System.out.println(c.getValor());  // Obtenemos el valor de la carta que ha tocado y la sumamos a los puntos

        System.out.println("Has sacado un " + c);

        if (c.getValor() > 21) {
            System.out.println("Has perdido, te has pasado de 21.");
        }

        if (c.getValor() == 21) {
            System.out.println("¡¡Has ganado!!");
        }

        if (c.getValor() < 21) {
            System.out.println("¿Deseas sacar otra carta?");
        }



        sc.close();
    }

}
