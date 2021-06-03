package com.company;

public class Bronze extends Avion{

    public Bronze() {
    }

    public Bronze(int combustible, float costoKm, int capacidadPasajeros, int velocidadMax, Propulsion propulsion) {
        super(combustible, costoKm, capacidadPasajeros, velocidadMax, propulsion);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
