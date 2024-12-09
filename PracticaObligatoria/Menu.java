package PracticaObligatoria;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean bienvenida = true;
        int tipo = 0, opc = 0;

        System.out.println("BIENVENIDO!! \n Elige un menú...");
        System.out.println("1. Menú de Baraja.");
        System.out.println("2. Menú de Juegos.");
        System.out.println("3. Salir...");


        switch (opc) {
            case 1:
                System.out.println("1. CREAR MAZO (1. Póker | 2. Española)");
                System.out.println("2. BARAJAR MAZO");
                System.out.println("3. MOSTRAR MAZO");
                System.out.println("4. SACAR CARTA");
                System.out.println("5. SACAR NÜMERO DE CARTAS");
                System.out.println("6. NÚMERO DE CARTAS RESTANTES");
                System.out.println("7. REINICIAR");
                int opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                    System.out.println("Dime el tipo (1. )");
                        Baraja b = new Baraja(tipo);
                        break;
                
                    default:
                        break;
                }
                break;
        
            default:
                break;
        }

        while (bienvenida) {
            System.out.println("Bienvenido, vamos a escoger una baraja...");
            System.out.println("¿Qué quieres usar? \n 1. Baraja de Póker. \n 2. Baraja Española.");

            try {
                tipo = sc.nextInt();
            } catch (Exception e) {
                bienvenida = false;
            }
        }

        Baraja b = new Baraja(tipo);

        System.out.println("¿Quieres barajar? \n 1. Sí. \n 2. No");
        try {
            opc = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Error al elegir opción");
        }

        if (opc == 1) {
            b.barajar();
        }

        sc.close();
    }
}
