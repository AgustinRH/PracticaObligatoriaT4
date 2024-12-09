package PracticaObligatoria;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean bienvenida = true;
        int tipo = 0, opc = 0;
        Baraja b = null;
        while (opc != 3) {
            System.out.println("BIENVENIDO!! \n Elige un menú...");
            System.out.println("1. Menú de Baraja.");
            System.out.println("2. Menú de Juegos.");
            System.out.println("3. Salir...");
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("1. CREAR MAZO");
                    System.out.println("2. BARAJAR MAZO");
                    System.out.println("3. MOSTRAR MAZO");
                    System.out.println("4. SACAR CARTA");
                    System.out.println("5. SACAR NÜMERO DE CARTAS");
                    System.out.println("6. NÚMERO DE CARTAS RESTANTES");
                    System.out.println("7. REINICIAR");
                    int opcion = sc.nextInt();
                    switch (opcion) {
                        case 1:
                            System.out.println("Dime el tipo (1. Póker | 2. Española)");
                            tipo = sc.nextInt();

                            b = new Baraja(tipo);
                            break;
                        case 2:
                            if (b != null) {
                                b.barajar();
                            } else {
                                System.out.println("No es posible barajar algo que no existe...");
                            }
                            break;
                        case 3:
                            if (b != null) {
                                b.toString();
                            }
                            break;
                        case 4:
                            if (b != null) {
                                b.siguiente();
                                System.out.println();
                            }
                            break;
                        case 5:
                            if (b != null) {
                                System.out.println("Dime cuantas cartas quieres sacar: ");
                                int cartas = sc.nextInt();
                                b.getBaraja(cartas);
                            }
                            break;
                        case 6:
                            if (b != null) {
                                b.getBaraja();
                            }
                            break;
                        case 7:
                            b.reiniciar();
                            break;
                        default:
                            System.out.println("Error al elegir una opción correcta...");
                            break;
                    }
                    break;
                case 2:
                SieteYMedia s;
                    System.out.println("Elige que mazo quieres usar:");
                    int opcTipo = sc.nextInt();
                    switch (tipo) {
                        case 1:
                            s = new SieteYMedia(opcTipo);
                            break;
                        case 2:
                            s = new SieteYMedia(opcTipo);
                            break;
                        default:
                            break;
                    }
                    break;

                default:
                    break;
            }
        }

    }
}
