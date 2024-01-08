package model;

public class Resztvevo {
    private Ember ember;
    private Resztvevo ellenfel;
    private int kezdoDobas;

    public Resztvevo(Ember ember) {
        this.ember = ember;
        this.kezdoDobas = 0;
    }

    public Ember getEmber() {
        return ember;
    }

    public void setEmber(Ember ember) {
        this.ember = ember;
    }

    public int getKezdoDobas() {
        return kezdoDobas;
    }

    public void setKezdoDobas(int kezdoDobas) {
        this.kezdoDobas = kezdoDobas;
    }

    public Resztvevo getEllenfel() {
        return this.ellenfel;
    }

    public void setEllenfel(Resztvevo ellenfel) {
        this.ellenfel = ellenfel;
    }

    public boolean getHarcol() {
        return ember.getEl() && ellenfel != null && ellenfel.ember.getEl();
    }
}
