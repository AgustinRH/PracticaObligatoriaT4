package PracticaObligatoria;

public class Baraja {

    // Variables de la clase baraja
    private int tipo;
    private String palo;
    private Carta mazo[][];

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
    }

    // Método para barajar el mazo
    public void barajar() {
        // Variables del metodo barajar
        int fil, col, fil2, col2;
    
        // Bucle que mezcla las cartas
        for (int i = 0; i < 60; i++) {
            fil = (int) (Math.random() * 4);
            fil2 = (int) (Math.random() * 4);
    
            // Si es de póker, el mazo tiene 13 cartas
            if (tipo == 1) {
                col = (int) (Math.random() * 13); // Cambiado a 13
                col2 = (int) (Math.random() * 13); // Cambiado a 13
            }
            // Si es española, el mazo tiene 10 cartas
            else {
                col = (int) (Math.random() * 10);
                col2 = (int) (Math.random() * 10);
            }
    
            // Cambiamos posiciones entre cartas de forma aleatoria
            Carta aux = mazo[fil][col];
            mazo[fil][col] = mazo[fil2][col2];
            mazo[fil2][col2] = aux;
        }
    }

    // Método para obtener la siguiente carta a sacar
    public Carta siguiente() {
        // Buscamos la siguiente carta
        for (int i = 0; i < mazo.length; i++) {
            for (int j = 0; j < mazo[i].length; j++) {
                if (mazo[i][j] != null) {
                    // Guardamos la carta a sacar
                    Carta carta = mazo[i][j];
                    mazo[i][j] = null; // Quitamos la carta del mazo
                    return carta; // Devolvemos la carta sacada
                }
            }
        }
    
        // Si no quedan cartas, devolvemos null
        return null;
    }

    // Método para mostrar la baraja completa
    public void mostrarBaraja() {
        for (int i = 0; i < mazo.length; i++) {
            for (int j = 0; j < mazo[0].length; j++) {
                System.out.println(mazo[i][j]);
            }
        }
    }

    // Método que devuelve la cantidad de cartas restante del mazo
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

    // Método que devuelve las cartas restantes de la baraja
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

    // Método que devuelve n cartas de las cartas restastes o su total si es menor a n
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

    // Método toString que devuelve las cartas divididas por un espacio y una coma
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

        return resultado; // Devolvemos el resultado
    }
}
