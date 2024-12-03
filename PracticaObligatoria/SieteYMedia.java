package PracticaObligatoria;

import java.util.Scanner;

public class SieteYMedia {

    private Baraja b;
    private String[] jugadores;
    private double[] puntos;
    private int numJugadores;

    public SieteYMedia(int tipo) {
        b = new Baraja(tipo);
        b.barajar();
    }

    public void jugar() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido al juego de Siete y Media");

        System.out.println("Introduce el número de jugadores: ");
        while (numJugadores < 2) {
            try {
                numJugadores = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Error al introducir el valor de jugadores");
            }

            System.out.println("Recuarda... Mínimo 2 personas para jugar");
        }

        jugadores = new String[numJugadores];
        puntos = new double[numJugadores];

        for (int i = 0; i < jugadores.length; i++) {
            System.out.println("Introduce el nombre del jugador: ");
            jugadores[i] = sc.next();
        }

        for (int i = 0; i < numJugadores; i++) {
            System.out.println("\nTurno de " + jugadores[i] + ":");
            jugarTurno(i);
        }

        ganador();




        sc.close();
    }   

    private void jugarTurno(int turno){
        Scanner sc = new Scanner(System.in);

        boolean stop = false;
        boolean perdido = false;

        Carta carta = b.siguiente();

        puntos[turno] = carta.getValor();

        System.out.println("Has sacado un " + carta);

        do {
            if (puntos[turno] > 7.5) {
                System.out.println("Te has pasado de 7.5 puntos, has perdido.");
                perdido = true;
            }
    
            while (!stop && puntos[turno] <= 7.5) {
                System.out.println("PUNTUACIÓN: " + puntos[turno]);
                System.out.println("¿Quieres sacar otra carta? (s/n)");
                String respuesta = sc.next();
    
                if (respuesta.equals("s")) {
                    carta = b.siguiente();
                    puntos[turno] += carta.getValor();
    
                    System.out.println("Has sacado un " + carta);
    
                    if (puntos[turno] > 7.5) {
                        System.out.println("Te has pasado de 7.5 puntos, has perdido.");
                    perdido = true;
                    }
                } else {
                    stop = true;
                    System.out.println("Te has plantado con " + puntos[turno]);
                }
            }
        } while (!perdido);

    sc.close();
    }

    

    private void ganador(){
        double maxPuntos = 0;
        int ganador = -1;

        for (int i = 0; i < jugadores.length; i++) {
            if (puntos[i]<= 7.5 && puntos[i] > maxPuntos) {
                maxPuntos = puntos[i];
                ganador = i; 
            }
        }
        if (ganador != -1) {
            System.out.println("\n El ganador es " + jugadores[ganador] + " con " + puntos[ganador]);
        }
        else {
            System.out.println("Todos los jugadores han perdido");
        }
    }
}
