package com.company;

public class Bronze extends Avion{

    public Bronze() {
    }

    public Bronze(int combustible, float costoKm, int capacidadPasajeros, int velocidadMax, Propulsion propulsion) {
        super(combustible, costoKm, capacidadPasajeros, velocidadMax, propulsion);
        this.setTarifaFija(3000);
    }


    @Override
    public String toString() {

        return "Avion Bronze " +
                super.toString() +
               "\n-----------------------------" +
               "\n-----------------------------" +
                "\n";
    }
}
