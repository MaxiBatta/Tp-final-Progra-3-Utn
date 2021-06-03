package com.company;

public abstract class Avion {

    private int combustible;
    private float costoKm;
    private int capacidadPasajeros;
    private int velocidadMax;
    private enum tipoPropulsion{};
    private int idAvion;
    private static int cont = 0;

    public Avion() {
    }

    public Avion(int combustible, float costoKm, int capacidadPasajeros, int velocidadMax) {
        this.combustible = combustible;
        this.costoKm = costoKm;
        this.capacidadPasajeros = capacidadPasajeros;
        this.velocidadMax = velocidadMax;
        this.idAvion = ++cont;
    }

    public int getCombustible() {
        return combustible;
    }

    public void setCombustible(int combustible) {
        this.combustible = combustible;
    }

    public float getCostoKm() {
        return costoKm;
    }

    public void setCostoKm(float costoKm) {
        this.costoKm = costoKm;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public int getVelocidadMax() {
        return velocidadMax;
    }

    public void setVelocidadMax(int velocidadMax) {
        this.velocidadMax = velocidadMax;
    }



    @Override
    public String toString() {
        return "Avion{" +
                "combustible=" + this.combustible +
                ", costoKm=" + this.costoKm +
                ", capacidadPasajeros=" + this.capacidadPasajeros +
                ", velocidadMax=" + this.velocidadMax +
                ", idAvion=" + this.idAvion +
                '}';
    }
}
