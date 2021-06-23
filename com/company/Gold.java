package com.company;


public class Gold extends Avion implements ServiceAvion {
    //Codigos de escape ANSI (color)
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";

   //Constructores
    public Gold() {
    }

    public Gold(String catering, boolean wifi) {
        this.catering = catering;
        this.wifi = wifi;
    }

    public Gold(int combustible, float costoKm, int capacidadPasajeros, int velocidadMax, Propulsion propulsion, boolean disponibilidad, int tarifaFija, String catering, boolean wifi, String catAvion) {
        super(combustible, costoKm, capacidadPasajeros, velocidadMax, propulsion, disponibilidad, tarifaFija, catering, wifi, catAvion);
    }

//Setters and Getters
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

    //Metodos

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
//Se implementa metodo de Interface Service Avion
    @Override
    public void serviceAvion() {
        System.out.println(ANSI_GREEN+ "\n\nTabla de Service Aviones Gold:");
        System.out.println("Origen: Alemania");
        System.out.println("Fecha de fabricacion: 2018");
        System.out.println("Service cada 50 horas/vuelo");
        System.out.println("---------------------------" + ANSI_RESET);


    }
}
