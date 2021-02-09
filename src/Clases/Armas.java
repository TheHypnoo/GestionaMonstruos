package Clases;

public class Armas {
    String nombreArma;
    int poderAtaque;

    public Armas(String nombreArma, int poderAtaque) {
        this.nombreArma = nombreArma;
        this.poderAtaque = poderAtaque;
    }

    public String getNombreArma() {
        return nombreArma;
    }

    public void setNombreArma(String nombreArma) {
        this.nombreArma = nombreArma;
    }

    public int getPoderAtaque() {
        return poderAtaque;
    }

    public void setPoderAtaque(int poderAtaque) {
        this.poderAtaque = poderAtaque;
    }
}
