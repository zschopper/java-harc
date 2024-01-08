package model;

public abstract class Fegyver {
    private String nev;
    private String sebzes;
    private FegyverTipus tipus;

    public Fegyver(String nev, FegyverTipus tipus, String sebzes) {
        this.nev = nev;
        this.tipus = tipus;
        this.sebzes = sebzes;
    }

    public String getNev() {
        return this.nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getSebzes() {
        return this.sebzes;
    }

    public void setSebzes(String sebzes) {
        this.sebzes = sebzes;
    }

    public FegyverTipus getTipus() {
        return this.tipus;
    }

    public int sebez() {
        return Kocka.dobas(sebzes);
    }
}
