package com.company;

public class Silver extends Avion implements ServiceAvion {

    private String catering ="Estandar";

    public Silver() {
    }




    public Silver(String catering) {
        this.catering = catering;
    }

    public Silver(int combustible, float costoKm, int capacidadPasajeros, int velocidadMax, Propulsion propulsion) {
        super(combustible, costoKm, capacidadPasajeros, velocidadMax, propulsion);
        this.catering = catering;
        this.setTarifaFija(4000);

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
        System.out.println("\n\nTabla de Service Aviones Silver:");
        System.out.println("Origen: Noruega");
        System.out.println("Fecha de fabricacion: 2015");
        System.out.println("Service cada 35 horas/vuelo");
        System.out.println("---------------------------");

    }
}
