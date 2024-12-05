package PracticaObligatoria;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // boolean salir = false;
        // int opc = -1;
        SieteYMedia s1 = new SieteYMedia(1);
        Blackjack b1 = new Blackjack(1);
        Baraja b = new Baraja(1);

        b.barajar();
        b.mostrarBaraja();

        System.out.println("-----------------");

        b.reiniciar();

        b.mostrarBaraja();
        System.out.println(b.siguiente());
        System.out.println("-----------------");
        System.out.println(b.toString());

        b1.jugar();

        /*
         * while (!salir) {
         * System.out.println("MENÚ PRINCIPAL");
         * System.out.print("---------------");
         * System.out.print(
         * "\n 1. Crear baraja \n 2. Mostrar baraja. \n 3. Sacar una carta \n 4. Barajar \n 5. Jugar \n 0. Salir del juego..."
         * );
         * System.out.println("\n Selecciona una opción: ");
         * try {
         * opc = sc.nextInt();
         * } catch (Exception e) {
         * System.out.println("Error al elegir la opción disponible.");
         * }
         * 
         * switch (opc) {
         * case 1:
         * 
         * break;
         * case 2:
         * 
         * break;
         * case 3:
         * 
         * break;
         * case 4:
         * 
         * break;
         * case 5:
         * 
         * break;
         * case 0:
         * System.out.println("Saliendo...");
         * salir = true;
         * break;
         * default:
         * System.out.println("Error al elegir la opción correcta...");
         * break;
         * }
         * }
         */

        sc.close();
    }
}
