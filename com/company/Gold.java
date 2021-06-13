package com.company;

public class Gold extends Avion implements ServiceAvion{

    private String catering ="Premiun";
    private boolean wifi;

    public Gold() {
    }

    public Gold(int combustible, float costoKm, int capacidadPasajeros, int velocidadMax, Propulsion propulsion, boolean wifi) {
        super(combustible, costoKm, capacidadPasajeros, velocidadMax, propulsion);
        this.catering = catering;
        this.wifi = wifi;
        this.setTarifaFija(6000);
    }

    public Gold(String catering, boolean wifi) {
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
        if (wifi) {
            return "Avion Gold "  +
                    super.toString() +
                    "\nCatering: " + this.catering +
                    "\nWifi: SI" +
                    "\n-----------------------------" +
                    "\n-----------------------------" +
                    "\n";

        }else{
            return "Avion Gold " +
                    super.toString() +
                    "\nCatering: " + this.catering +
                    "\nWifi: NO" +
                    "\n-----------------------------" +
                    "\n-----------------------------"+
                    "\n";
        }
    }

    @Override
    public void serviceAvion() {
        System.out.println("\n\nTabla de Service Aviones Gold:");
        System.out.println("Origen: Alemania");
        System.out.println("Fecha de fabricacion: 2018");
        System.out.println("Service cada 50 horas/vuelo");
        System.out.println("---------------------------");


    }
}
