package com.company;

import java.util.ArrayList;

public class Silver extends Avion implements ServiceAvion {

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";

    public Silver() {
    }

    public Silver(int combustible, float costoKm, int capacidadPasajeros, int velocidadMax, Propulsion propulsion, boolean disponibilidad, int tarifaFija, String catering, boolean wifi,String catAvion) {
        super(combustible, costoKm, capacidadPasajeros, velocidadMax, propulsion, disponibilidad, tarifaFija, catering, wifi, catAvion);
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

    @Override
    public void serviceAvion() {
        System.out.println(ANSI_BLUE +"\n\nTabla de Service Aviones Silver:");
        System.out.println("Origen: Noruega");
        System.out.println("Fecha de fabricacion: 2015");
        System.out.println("Service cada 35 horas/vuelo");
        System.out.println("---------------------------"+ ANSI_RESET);

    }
}
