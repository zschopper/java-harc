package model;

public class Kard extends Fegyver{

    public Kard(String nev, FegyverTipus tipus, String sebzes) {
        super(nev, tipus, sebzes);
    }

    public Kard(String nev, String sebzes) {
        super(nev, FegyverTipus.VAGO, sebzes);
    }

}
