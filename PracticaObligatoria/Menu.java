package PracticaObligatoria;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Variables de la clase Main
        int opc = -1;
        Baraja b = null;
        int opcionbaraja = -1;
        int tipoBaraja = -1;
        
        // Mientras no quiera salirse se le mostrará el menú
        while (opc != 0) {
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("----------------------");
            System.out.println("1. Crear una baraja.");
            System.out.println("2. Mostrar baraja.");
            System.out.println("3. Sacar cartas.");
            System.out.println("4. Barajar.");
            System.out.println("5. Jugar");
            System.out.println("0. Salir del programa.");
            try {
                opc = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Error al escoger una opción.");
                sc.nextLine(); // Limpia el buffer
            }

            switch (opc) {
                case 1: // Abre un menú de barajas
                    while (opcionbaraja != 0) {
                        System.out.println("MENÚ DE BARAJAS");
                        System.out.println("1. Crear una baraja de poker.");
                        System.out.println("2. Crear una baraja española.");
                        System.out.println("0. Volver al menú principal.");
                        try {
                            opcionbaraja = sc.nextInt();
                        } catch (Exception e) {
                            System.out.println("Error al elegir una opción del menú de baraja");
                            sc.nextLine();
                        }

                        switch (opcionbaraja) {
                            case 1: // Crea baraja de pókerclear
                                b = new Baraja(1);
                                tipoBaraja = 1;
                                opcionbaraja = 0;
                                break;
                            case 2: // Crea baraja española
                                b = new Baraja(2);
                                tipoBaraja = 2; 
                                opcionbaraja = 0;
                                break;
                            case 0: // Sale del menú de baraja
                                System.out.println("Saliendo...");
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case 2: // Muestra la baraja
                    if (b != null) {
                        System.out.println(b.toString());
                    } else {
                        System.out.println("No hay baraja creada.");
                    }
                    break; // Saca una carta del montón
                case 3:
                    if (b != null) {
                        System.out.println(b.siguiente());
                    } else {
                        System.out.println("No hay baraja creada.");
                    }
                    break;
                case 4: // Baraja las cartas
                    if (b != null) {
                        b.barajar();
                        System.out.println("Barajado");
                    } else {
                        System.out.println("No se ha podido barajar ya que no hay cartas...");
                    }
                    break;
                case 5: // Juega al juego Siete y Media
                    if (b != null) {
                        if (tipoBaraja == 2 ) {
                        SieteYMedia s = new SieteYMedia(tipoBaraja); 
                        s.jugar();
                        }
                        else {
                            System.out.println("No puedes jugar con cartas de póker, debes crear una baraja Española...");
                        }
                    } else {
                        System.out.println("No hay baraja creada. Crea una baraja primero.");
                    }
                    break;
                default:
                System.out.println("Opción no válida.");
                    break;
            }
        }
        sc.close();
    }
}
