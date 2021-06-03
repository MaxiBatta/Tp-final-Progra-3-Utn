package com.company;

public class Silver extends Avion {

    private String catering ="Estandar";

    public Silver() {
    }

    public Silver(String catering) {
        this.catering = catering;
    }

    public Silver(int combustible, float costoKm, int capacidadPasajeros, int velocidadMax, String catering) {
        super(combustible, costoKm, capacidadPasajeros, velocidadMax);
        this.catering = catering;
    }

    public String getCatering() {
        return catering;
    }

    public void setCatering(String catering) {
        this.catering = catering;
    }


    @Override
    public String toString() {
        return super.toString() +
                "catering= " + this.catering;
    }
}
