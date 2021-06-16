package com.company;

import java.util.ArrayList;

public class Bronze extends Avion implements ServiceAvion{
    //Codigos de escape ANSI (color)
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";

    //Constructores

    public Bronze() {
    }

    public Bronze(int combustible, float costoKm, int capacidadPasajeros, int velocidadMax, Propulsion propulsion, boolean disponibilidad, int tarifaFija, String catering, boolean wifi, String catAvion) {
        super(combustible, costoKm, capacidadPasajeros, velocidadMax, propulsion, disponibilidad, tarifaFija, catering, wifi, catAvion);
    }

//Metodos

    @Override
    public String toString() {

        return "Avion Bronze " +
                super.toString() +
               "\n-----------------------------" +
               "\n-----------------------------" +
                "\n";
    }
    //Se sobreescribe metodo de Interface Service Avion
    @Override
    public void serviceAvion() {
        System.out.println(ANSI_CYAN+"\n\nTabla de Service Aviones Bronze");
        System.out.println("Origen: China");
        System.out.println("Fecha de fabricacion: 2012");
        System.out.println("Service cada 20 horas/vuelo");
        System.out.println("---------------------------" + ANSI_RESET);
    }
}
