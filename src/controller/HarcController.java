package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import model.Buzogany;
import model.Ember;
import model.Harcos;
import model.Kard;
import model.Kocka;
import model.Lancing;
import model.LovagiPancel;
import model.Resztvevo;

public class HarcController {
    static int MAX_KOR = 30;

    public HarcController() {

        Harcos hos = new Harcos("Sir Lancelot", 20, 20, 20);
        hos.addVedelem(new LovagiPancel("LovagiPancel", 7));
        hos.setFegyver(new Kard("Hosszukard", "1d10+1"));
        Harcos ellenfel = new Harcos("Fekete Lovag", 12, 24, 24);
        ellenfel.addVedelem(new Lancing("Lancing", 5));
        ellenfel.setFegyver(new Buzogany("Csatacsillag", "2d6+1"));
        this.harcol(hos, ellenfel);
    }

    public void harcol(Ember ki, Ember kivel) {
        ArrayList<Resztvevo> rvSorrendben = new ArrayList<>();
        boolean vege = false;
        int kor = 0;

        rvSorrendben.add(new Resztvevo(ki));
        rvSorrendben.add(new Resztvevo(kivel));

        rvSorrendben.get(0).setEllenfel(rvSorrendben.get(1));
        rvSorrendben.get(1).setEllenfel(rvSorrendben.get(0));

        do {
            kor++;
            System.out.println("\nUj kor kezdodott!\n");
            for (Resztvevo resztvevo : rvSorrendben) {
                resztvevo.setKezdoDobas(Kocka.dobas(20));
            }

            // sorrend meghatározása
            Collections.sort(rvSorrendben, new Comparator<Resztvevo>() {
                public int compare(Resztvevo r1, Resztvevo r2) {
                    return Integer.compare(r1.getKezdoDobas(), r2.getKezdoDobas());
                }
            });

            // támadások sorrendben
            for (Resztvevo tamado : rvSorrendben) {
                // ha a támadó él, ha a védő él, és a támadásban nem halt meg az ellenfél
                if (!tamado.getHarcol() || !tamado.getEmber().tamad(tamado.getEllenfel())) {
                    vege = true;
                }
            }

            vege |= (rvSorrendben.size() == 0) || kor >= MAX_KOR;
        } while (!vege);
    }

    public boolean ___tamad(Resztvevo tamado) {
        Resztvevo vedo = tamado.getEllenfel();

        int tamadas = tamado.getEmber().getTamadas();
        int vedekezes = vedo.getEmber().getVedekezes();

        System.out.printf("%s tamad!\n", tamado.getEmber().getNev());
        if (tamadas + Kocka.dobas(10) > vedekezes) {
            int sebzes = tamado.getEmber().getSebzes();
            int valosSebzodes = vedo.getEmber().sebzodes(sebzes);  // FEGYVER!

            System.out.printf("%s tamadasa eltalalta %s-t %d eleterot sebezve rajta!\n", tamado.getEmber().getNev(),
                    vedo.getEmber().getNev(), valosSebzodes);
        } else {
            System.out.printf("%s tamadasa nem talalta el %s-t!\n", tamado.getEmber().getNev(),
                    vedo.getEmber().getNev());
        }
        if (!vedo.getEmber().getEl()) {
            System.out.printf("%s meghalt.\n", vedo.getEmber().getNev());
        } else {
            System.out.printf("%snak %d eletereje maradt.\n", vedo.getEmber().getNev(),
                    vedo.getEmber().getEletero());
        }

        return tamado.getEllenfel().getEmber().getEl() && tamado.getEmber().getEl();
    }
}
