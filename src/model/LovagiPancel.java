package model;

public class LovagiPancel extends Vedelem {

    public LovagiPancel(String nev, int elnyeles) {
        super(nev, elnyeles);
    }

    @Override
    public int getElnyeles(Fegyver fegyver) {
        return 6;
    }

}
