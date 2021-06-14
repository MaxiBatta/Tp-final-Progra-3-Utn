package com.company;

public class Bronze extends Avion implements ServiceAvion{

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

    @Override
    public void serviceAvion() {
        System.out.println("\n\nTabla de Service Aviones Bronze");
        System.out.println("Origen: China");
        System.out.println("Fecha de fabricacion: 2012");
        System.out.println("Service cada 20 horas/vuelo");
        System.out.println("---------------------------");
    }
}
