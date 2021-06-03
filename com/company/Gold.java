package com.company;

public class Gold extends Avion{

    private String catering ="Premiun";
    private boolean wifi;

    public Gold() {
    }

    public Gold(String catering, boolean wifi) {
        this.catering = catering;
        this.wifi = wifi;
    }

    public Gold(int combustible, float costoKm, int capacidadPasajeros, int velocidadMax, Propulsion propulsion, String catering, boolean wifi) {
        super(combustible, costoKm, capacidadPasajeros, velocidadMax, propulsion);
        this.catering = catering;
        this.wifi = wifi;
    }

    public String getCatering() {
        return catering;
    }

    public void setCatering(String catering) {
        this.catering = catering;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Catering: " + this.catering +
                "Wifi: " + this.wifi;
    }
}
