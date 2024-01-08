package model;

import java.util.ArrayList;

public class Harcos extends Ember {
    private ArrayList<Vedelem> vedelem;
    private Fegyver fegyver = null;

    public Harcos(String nev, int eletero, int tamadas, int vedekezes) {
        super(nev, eletero, tamadas, vedekezes);
        this.vedelem = new ArrayList<Vedelem>();
    }

    public Fegyver getFegyver() {
        return fegyver;
    }

    public void setFegyver(Fegyver fegyver) {
        this.fegyver = fegyver;
    }

    public ArrayList<Vedelem> getVedelem() {
        return this.vedelem;
    }

    public void addVedelem(Vedelem vedelem) {
        this.vedelem.add(vedelem);
    }

    public int sebzodes(int sebzes, Fegyver fegyver) {
        int elnyeles = 0;
        for (Vedelem pancel : vedelem) {
            elnyeles += pancel.getElnyeles(fegyver);
        }

        if (elnyeles > sebzes - 1) {
            elnyeles = sebzes -1; // minimum sebzes
        }
        if (vedelem.size() > 0)
            System.out.printf("%d pontot felfogott a %s pancelja.\n", elnyeles, getNev());
        else
            System.out.printf("%snak nincs pancelja.\n", getNev());
        return sebzodes(sebzes - elnyeles);
    }

    @Override
    public int getSebzes() {
        if (fegyver != null) {
            return fegyver.sebez();
        } else {
            return super.getSebzes();
        }
    }

    @Override
    public boolean tamad(Resztvevo ellenfel) {
        return tamad(fegyver, ellenfel);
    }

    public boolean tamad(Fegyver fegyver, Resztvevo ellenfel) {

        int tamadas = getTamadas();
        int vedekezes = ellenfel.getEmber().getVedekezes();
        Harcos ellenHarcos = ellenfel.getEmber() instanceof Harcos ? (Harcos) ellenfel.getEmber() : null;

        System.out.printf("%s tamad!\n", getNev());
        if (tamadas + Kocka.dobas(10) > vedekezes) {
            int sebzes = getSebzes();
            int valosSebzodes = 0;
            if (ellenHarcos != null) {
                valosSebzodes = ellenfel.getEmber().sebzodes(sebzes, fegyver);
            } else {
                valosSebzodes = ellenfel.getEmber().sebzodes(sebzes);
            }

            System.out.printf("%s tamadasa eltalalta %s-t %d eleterot sebezve rajta!\n", getNev(),
                    ellenfel.getEmber().getNev(), valosSebzodes);
        } else {
            System.out.printf("%s tamadasa nem talalta el %s-t!\n", getNev(),
                    ellenfel.getEmber().getNev());
        }
        if (!ellenfel.getEmber().getEl()) {
            System.out.printf("%s meghalt.\n", ellenfel.getEmber().getNev());
        } else {
            System.out.printf("%snak %d eletereje maradt.\n", ellenfel.getEmber().getNev(),
                    ellenfel.getEmber().getEletero());
        }

        return ellenfel.getEmber().getEl() && getEl();
    }

}
