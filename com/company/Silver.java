package com.company;

public class Silver extends Avion {

    private String catering ="Estandar";

    public Silver() {
    }




    public Silver(String catering) {
        this.catering = catering;
    }

    public Silver(int combustible, float costoKm, int capacidadPasajeros, int velocidadMax, Propulsion propulsion) {
        super(combustible, costoKm, capacidadPasajeros, velocidadMax, propulsion);
        this.catering = catering;
        this.setTarifaFija(4000);

    }


    public String getCatering() {
        return catering;
    }

    public void setCatering(String catering) {
        this.catering = catering;
    }


    @Override
    public String toString() {
        return "Avion Silver" +
                super.toString() +
                "\nCatering: " + this.catering +
                "\n-----------------------------" +
                 "\n-----------------------------" +
                "\n";
    }
}
