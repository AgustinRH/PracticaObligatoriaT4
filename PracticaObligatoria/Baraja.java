package PracticaObligatoria;

public class Baraja {

    // Variables para la clase baraja
    private int tipo;
    private String palo;
    Carta mazo[][];
    Carta mazoBarajado[];
    Carta next;

    // Creamos el objeto Baraja
    public Baraja(int tipo) {
        this.tipo = tipo;
        generarMazo(); // Generamos el mazo cuando se crea la baraja
    }

    // Método para generar el mazo según el tipo (1.Póker 2.Española)
    private void generarMazo() {
        if (tipo == 1) { // Póker
            mazo = new Carta[4][13];
            for (int i = 0; i < mazo.length; i++) {
                switch (i) {
                    case 0:
                        palo = "CORAZONES";
                        break;
                    case 1:
                        palo = "DIAMANTES";
                        break;
                    case 2:
                        palo = "PICAS";
                        break;
                    case 3:
                        palo = "TREBOLES";
                        break;
                    default:
                        break;
                }
                for (int j = 0; j < mazo[0].length; j++) {
                    mazo[i][j] = new Carta(j + 1, palo, tipo);
                }
            }
        }

        if (tipo == 2) { // Española
            mazo = new Carta[4][10];
            for (int i = 0; i < mazo.length; i++) {
                switch (i) {
                    case 0:
                        palo = "BASTOS";
                        break;
                    case 1:
                        palo = "OROS";
                        break;
                    case 2:
                        palo = "ESPADAS";
                        break;
                    case 3:
                        palo = "COPAS";
                        break;
                    default:
                        break;
                }
                for (int j = 0; j < mazo[0].length; j++) {
                    mazo[i][j] = new Carta(j + 1, palo, tipo);
                }
            }
        }
        // Guardamos la cara que va a salir
        next = obtenerSiguienteCarta();
    }

    // Método para barajar el mazo
    public void barajar() {
        // Variables del metodo barajar
        int fil, col, fil2, col2;

        // Bucle que mezcla las cartas
        for (int i = 0; i < 60; i++) {
            fil = (int) ((Math.random() * 4));
            fil2 = (int) ((Math.random() * 4));

            // Si es de póker, el mazo tiene 12 cartas
            if (tipo == 1) {
                col = (int) ((Math.random() * 13));
                col2 = (int) ((Math.random() * 13));
                mazoBarajado = new Carta[13];
            }
            // Si es española, el mazo tiene 10 cartas
            else {
                col = (int) ((Math.random() * 10));
                col2 = (int) ((Math.random() * 10));
                mazoBarajado = new Carta[10];
            }

            // Cambiamos posiciones entre cartas de forma aleatoria
            Carta aux = mazo[fil][col];

            mazo[fil][col] = mazo[fil2][col2];

            mazo[fil2][col2] = aux;

        }

        // Inicializamos la siguiente carta a sacar
        next = obtenerSiguienteCarta();
    }

    // Método para obtener la siguiente carta a sacar
    private Carta obtenerSiguienteCarta() {
        // Buscamos la siguiente carta
        for (int i = 0; i < mazo.length; i++) {
            for (int j = 0; j < mazo[i].length; j++) {
                if (mazo[i][j] != null) {
                    // Guardamos la siguiente carta
                    Carta carta = mazo[i][j];
                    mazo[i][j] = null; // Quitamos la carta del mazo
                    return carta;
                }
            }
        }

        // Si no quedan cartas devolvemos null
        return null;
    }

    // Sacamos la siguiente carta
    public Carta siguiente() {
        // Si no quedan cartas devolvemos null
        if (next == null) {
            return null;
        }

        // Guardamos la siguiente carta para sacarla
        Carta cartaASacar = next;

        // Guardamos la próxima carta
        next = obtenerSiguienteCarta();

        // Devolvemos la carta sacada
        return cartaASacar;
    }

    // Método para mostrar la baraja completa
    public void mostrarBaraja() {
        for (int i = 0; i < mazo.length; i++) {
            for (int j = 0; j < mazo[0].length; j++) {
                System.out.println(mazo[i][j]);
            }
        }
    }

    public int numCartas() {
        int restantes = 0;
        for (int i = 0; i < mazo.length; i++) {
            for (int j = 0; j < mazo[i].length; j++) {
                if (!(mazo[i][j] == null)) {
                    restantes++;
                }
            }
        }
        return restantes;
    }

    public Carta[] getBaraja() {
        Carta[] restantes = new Carta[numCartas()];

        int contador = 0;

        for (int i = 0; i < mazo.length; i++) {
            for (int j = 0; j < mazo[0].length; j++) {
                if (!(mazo[i][j] == null)) {
                    restantes[contador] = mazo[i][j];
                    contador++;
                }
            }
        }
        return restantes;
    }

    public Carta[] getBaraja(int n) {

        // Contamos cuantas cartas quedan en el mazo
        int numCartasRestantes = numCartas();

        // Si no hay cartas, devolvemos null
        if (numCartasRestantes == 0) {
            return null;
        }

        // Si hay menos cartas restantes de n devolvemos n cartas
        if (numCartasRestantes < n) {
            numCartasRestantes = n;
        }

        // Creamos un array para las cartas restantes
        Carta[] cartasRestantes = new Carta[numCartasRestantes];

        int contador = 0;
        // Recorremos el mazo y añadimos las cartas al nuevo array
        for (int i = 0; i < mazo.length; i++) {
            for (int j = 0; j < mazo[i].length; j++) {
                if (mazo[i][j] != null && contador < numCartasRestantes) {
                    cartasRestantes[contador] = mazo[i][j];
                    contador++;
                }
            }
        }

        return cartasRestantes; // Devolvemos el array con las cartas solicitadas
    }

    // Método para volver a generar el mazo y barajar de nuevo
    public void reiniciar() {

        generarMazo();
        barajar();
    }

    public String toString() {
        String resultado = "";

        // Recorremos el mazo y añadimos las cartas al resultado
        for (int i = 0; i < mazo.length; i++) {
            for (int j = 0; j < mazo[i].length; j++) {
                if (mazo[i][j] != null) {
                    // Si ya hay cartas en el resultado, añadimos una coma y un espacio
                    if (!resultado.equals("")) {
                        resultado += ", ";
                    }

                    resultado += mazo[i][j].toString();
                }
            }
        }

        return resultado; // Devolver la cadena resultante
    }
}
