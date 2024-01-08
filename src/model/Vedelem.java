package model;

public class Vedelem {
    private String nev;
    private int elnyeles;

    public Vedelem(String nev, int elnyeles) {
        this.nev = nev;
        this.elnyeles = elnyeles;
    }

    public String getNev() {
        return this.nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getElnyeles(Fegyver fegyver) {
        return this.elnyeles;
    }

    public void setElnyeles(int elnyeles) {
        this.elnyeles = elnyeles;
    }

}
