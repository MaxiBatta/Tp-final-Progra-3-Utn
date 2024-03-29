package com.company;

import java.util.ArrayList;

public class Silver extends Avion implements ServiceAvion {
    //Codigos de escape ANSI (color)
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";

    private String catering ="";

    //Constructores
    public Silver() {
    }

    public Silver(int combustible, float costoKm, int capacidadPasajeros, int velocidadMax, Propulsion propulsion, boolean disponibilidad, int tarifaFija, String catering,String catAvion) {
        super(combustible, costoKm, capacidadPasajeros, velocidadMax, propulsion, disponibilidad, tarifaFija, catAvion);
        this.catering = catering;
    }

    //Setter and Getters
    public String getCatering() {
        return catering;
    }

    public void setCatering(String catering) {
        this.catering = catering;
    }

    //Metodos
    @Override
    public String toString() {
        return "Avion Silver" +
                super.toString() +
                "\nCatering: " + this.catering +
                "\n-----------------------------" +
                 "\n-----------------------------" +
                "\n";
    }
    //Se implementa metodo de Interface Service Avion
    @Override
    public void serviceAvion() {
        System.out.println(ANSI_BLUE +"\n\nTabla de Service Aviones Silver:");
        System.out.println("Origen: Noruega");
        System.out.println("Fecha de fabricacion: 2015");
        System.out.println("Service cada 35 horas/vuelo");
        System.out.println("---------------------------"+ ANSI_RESET);

    }
}
