package PracticaObligatoria;

public class Carta {

    // Variables privadas de la clase.
    private String palo;
    private int tipo, valor;

    // Constructor de la clase para dar valor a las variables.
    public Carta(int valor, String palo, int tipo) {
        this.valor = valor;
        this.palo = palo;
        this.tipo = tipo;
    }

    // Getter de Tipo
    public int getTipo() {
        return tipo;
    }

    // Setter de Tipo
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    // Getter de Valor
    public int getValor() {
        return valor;
    }

    // Setter de Valor
    public void setValor(int valor) {
        this.valor = valor;
    }

    // Getter de Palo
    public String getPalo() {
        return palo;
    }

    // Setter de Palo
    public void setPalo(String palo) {
        // Baraja de póker
        if (palo.equals("CORAZONES") || palo.equals("DIAMANTES") || palo.equals("PICAS") || palo.equals("TREBOLES")) {
            this.palo = palo;
        }

        // Baraja española
        if (palo.equals("BASTOS") || palo.equals("OROS") || palo.equals("ESPADAS") || palo.equals("COPAS")) {
            this.palo = palo;
        }
    }

    // Devuelve un String del valor y el palo de la carta.
    public String toString() {
        return valor + " de " + palo;
    }

    // Método para comparar cartas
    public boolean equals(Carta c) {
        boolean iguales = false;
        if (c.getValor() == this.valor && c.getPalo().equals(this.palo)) {
            iguales = true;
        }
        return iguales;
    }

    // Método para clonar cartas
    public Carta clone() {
        Carta c = new Carta(this.valor, this.palo, this.tipo);
        return c;
    }

    // Método para comparar números de cartas
    public boolean compararNumeros(Carta c) {
        return this.valor == c.valor;
    }

    // Método para comparar palos de cartas
    public boolean compararPalos(Carta c) {
        return this.palo.equals(c.palo);
    }

    // Método para saber si una carta es mayor que otra
    public boolean mayorQue(Carta c) {
        boolean mayor = false;
    
        // Comparar primero los valores
        if (this.valor > c.getValor()) {
            mayor = true;
        } else if (this.valor < c.getValor()) {
            mayor = false;
        } else {
            // Si los valores son iguales, comparar los palos
            if (this.palo.equals("OROS")) {
                mayor = true;
            } else if (this.palo.equals("COPAS") && !c.palo.equals("OROS")) {
                mayor = true;
            } else if (this.palo.equals("ESPADAS") && !c.palo.equals("OROS") && !c.palo.equals("COPAS")) {
                mayor = true;
            }
        }
    
        return mayor;
    }
}
