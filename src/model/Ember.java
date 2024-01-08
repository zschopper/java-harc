package model;

public abstract class Ember {

    private String nev;
    private int maxEletero;
    private int eletero;
    private int tamadas;
    private int vedekezes;

    public Ember(String nev, int eletero, int tamadas, int vedekezes) {
        this.nev = nev;
        this.eletero = eletero;
        this.tamadas = tamadas;
        this.vedekezes = vedekezes;
        this.maxEletero = eletero;
    }

    public int getMaxEletero() {
        return this.maxEletero;
    }

    public void setMaxEletero(int maxEletero) {
        this.maxEletero = maxEletero;
    }

    public String getNev() {
        return this.nev;
    }

    public int getEletero() {
        return this.eletero > 0 ? this.eletero : 0;
    }

    public void setEletero(int eletero) {
        if (this.eletero > 0) {
            this.eletero = eletero;
            if (this.eletero < 0) {
                this.eletero = 0;
            }
        }
    }

    public int getSebzes() {
        return Kocka.dobas("1d3");
    }

    public int sebzodes(int eletero) {
        this.setEletero(this.getEletero() - eletero);
        return eletero;
    }

    public int sebzodes(int eletero, Fegyver fegyver) {
        return sebzodes(eletero);
    }

    public int getTamadas() {
        return this.tamadas;
    }

    public void setTamadas(int tamadas) {
        this.tamadas = tamadas;
    }

    public int getVedekezes() {
        return this.vedekezes;
    }

    public void setVedekezes(int vedekezes) {
        this.vedekezes = vedekezes;
    }

    public boolean getEl() {
        return eletero > 0;
    }

    public abstract boolean tamad(Resztvevo ellenfel);
}
