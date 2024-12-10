package PracticaObligatoria;

import java.util.Scanner;

public class SieteYMedia {

    // Variables de la clase
    private Baraja b;
    private String[] jugadores;
    private double[] puntos;
    private int numJugadores;

    // Objeto que genera una baraja según el tipo
    public SieteYMedia(int tipo) {
        b = new Baraja(tipo);
        b.barajar();
    }

    // Método que inicializa el juego
    public void jugar() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido al juego de Siete y Media");

        // Inicializa numJugadores a 0
        numJugadores = 0;

        System.out.println("Introduce el número de jugadores (mínimo 2): ");
        while (numJugadores < 2) {
            try {
                numJugadores = sc.nextInt();
                if (numJugadores < 2) {
                    System.out.println("Recuarda... Mínimo 2 personas para jugar");
                }
            } catch (Exception e) {
                System.out.println("Error al introducir el valor de jugadores. Intenta de nuevo.");
                sc.next(); // Limpiar el buffer
            }
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

    // Método paraa jugar cada turno de cada jugador
    private void jugarTurno(int turno){
        Scanner sc2 = new Scanner(System.in);
        // Variables del método
        boolean stop = false;

        Carta c = b.siguiente(); // Llamamos a la clase Carta

        puntos[turno] = c.getValor();
        System.out.println(c.getValor());  // Obtenemos el valor de la carta que ha tocado y la sumamos a los puntos

        System.out.println("Has sacado un " + c);

        // Bucle para saber si pierde durante su turno un jugador
            if (puntos[turno] > 7.5) { // Si saca mayor de 7.5, pierde
                System.out.println("Te has pasado de 7.5 puntos, has perdido.");
            }
            
            // Mientras que no se planta el jugador o no supera 7.5 puntos puede seguir sacando cartas
            while (!stop && puntos[turno] <= 7.5) {
                System.out.println("PUNTUACIÓN: " + puntos[turno]);
                System.out.println("¿Quieres sacar otra carta? (s/n)");
                String respuesta = sc2.next();
    
                // Si decide "s", se planta y sale del bucle
                if (respuesta.equals("s")) {
                    c = b.siguiente();
                    puntos[turno] += c.getValor();
    
                    System.out.println("Has sacado un " + c);
    
                    if (puntos[turno] > 7.5) {
                        System.out.println("Te has pasado de 7.5 puntos, has perdido.");
                    }
                } else {
                    stop = true;
                    System.out.println("Te has plantado con " + puntos[turno]);
                }
            }

    }

    // Método para saber el ganador
    private void ganador() {
        double maxPuntos = 0;
        int ganador = -1;

        // Bucle para saber que jugador tiene la mayor puntuación
        for (int i = 0; i < jugadores.length; i++) {
            if (puntos[i] <= 7.5 && puntos[i] > maxPuntos) {
                maxPuntos = puntos[i];
                ganador = i;
            }
        }

        // Comprobamos que algún jugador no ha perdido y tiene un mínimo de puntuación
        // para poder ganar
        if (ganador != -1) {
            System.out.println("\n El ganador es " + jugadores[ganador] + " con " + puntos[ganador]);
        } else {
            System.out.println("Todos los jugadores han perdido");
        }
    }
}
