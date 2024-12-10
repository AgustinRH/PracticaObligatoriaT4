package PracticaObligatoria;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opc = -1;
        Baraja b = null;
        int opcionbaraja = -1;
        int tipoBaraja = -1;

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
                System.out.println("Error al elegir una opción...");
                sc.next();
            }

            switch (opc) {
                case 1:
                    while (opcionbaraja != 0) {
                        System.out.println("MENÚ DE BARAJAS");
                        System.out.println("1. Crear una baraja de poker.");
                        System.out.println("2. Crear una baraja española.");
                        System.out.println("0. Volver al menú principal.");
                        try {
                            opcionbaraja = sc.nextInt();
                        } catch (Exception e) {
                            System.out.println("Error al elegir una opción del menú de baraja");
                            sc.next(); // Limpiar el buffer
                        }

                        switch (opcionbaraja) {
                            case 1:
                                b = new Baraja(1);
                                tipoBaraja = 1;
                                opcionbaraja = 0;
                                break;
                            case 2:
                                b = new Baraja(2);
                                tipoBaraja = 2; 
                                opcionbaraja = 0;
                                break;
                            case 0:
                                System.out.println("Saliendo...");
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case 2:
                    if (b != null) {
                        System.out.println(b.toString());
                    } else {
                        System.out.println("No hay baraja creada.");
                    }
                    break;
                case 3:
                    if (b != null) {
                        System.out.println(b.siguiente());
                    } else {
                        System.out.println("No hay baraja creada.");
                    }
                    break;
                case 4:
                    if (b != null) {
                        b.barajar();
                        System.out.println("Barajado");
                    } else {
                        System.out.println("No se ha podido barajar ya que no hay cartas...");
                    }
                    break;
                case 5:
                    if (b != null) {
                        SieteYMedia s = new SieteYMedia(tipoBaraja); 
                        s.jugar();
                    } else {
                        System.out.println("No hay baraja creada. Crea una baraja primero.");
                    }
                    break;
                default:
                    break;
            }
        }
        sc.close();
    }
}
