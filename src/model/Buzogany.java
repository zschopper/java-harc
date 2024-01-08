package model;

public class Buzogany extends Fegyver{

    public Buzogany(String nev, FegyverTipus tipus, String sebzes) {
        super(nev, tipus, sebzes);
    }

    public Buzogany(String nev, String sebzes) {
        super(nev, FegyverTipus.ZUZO, sebzes);
    }
}
