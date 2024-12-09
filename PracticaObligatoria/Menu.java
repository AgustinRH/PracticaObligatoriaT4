package PracticaObligatoria;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido, vamos a escoger una baraja...");
        System.out.println("¿Qué quieres usar? \n 1. Baraja de Póker. \n 2. Baraja Española.");
        int tipo = sc.nextInt();

        Baraja b = new Baraja(tipo);
        
        sc.close();
    }
}
