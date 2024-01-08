package model;

public class Lancing extends Vedelem {

    public Lancing(String nev, int elnyeles) {
        super(nev, elnyeles);
    }

    @Override
    public int getElnyeles(Fegyver fegyver) {
        if (fegyver.getTipus() == FegyverTipus.SZURO) {
            return super.getElnyeles(fegyver) / 2;
        } else {
            return super.getElnyeles(fegyver);
        }
    }

}
