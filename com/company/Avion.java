package com.company;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public  class Avion  {
public static final String ANSI_BLUE = "\u001B[34m";
public static final String ANSI_RESET = "\u001B[0m";

    private int combustible;
    private float costoKm;
    private int capacidadPasajeros;
    private int velocidadMax;
    private Propulsion propulsion;
    private int idAvion;
    private static int cont = 0;
    private boolean disponibilidad;
    private int tarifaFija =0;
    private ArrayList<String> fechasDisponibles = new ArrayList<>();
    protected String catering ="";
    protected boolean wifi= false;
    private String catAvion= "";




    public Avion() {
    }

    public Avion(int combustible, float costoKm, int capacidadPasajeros, int velocidadMax, Propulsion propulsion, boolean disponibilidad, int tarifaFija, String catering, boolean wifi, String catAvion) {
        this.combustible = combustible;
        this.costoKm = costoKm;
        this.capacidadPasajeros = capacidadPasajeros;
        this.velocidadMax = velocidadMax;
        this.propulsion = propulsion;
        this.disponibilidad = disponibilidad;
        this.tarifaFija = tarifaFija;
        this.catering = catering;
        this.wifi = wifi;
        this.idAvion= ++cont;
        this.catAvion= catAvion;
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

    public int getTarifaFija() {
        return tarifaFija;
    }

    public void setTarifaFija(int tarifaFija) {
        this.tarifaFija = tarifaFija;
    }

    public Propulsion getPropulsion() {
        return propulsion;
    }

    public void setPropulsion(Propulsion propulsion) {
        this.propulsion = propulsion;
    }

    public int getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(int idAvion) {
        this.idAvion = idAvion;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    //Fx que carga fechas en un arreglo String
    public void cargaFechasDisponibles (String fecha){
        LocalDate fechaLD= LocalDate.parse(fecha, DateTimeFormatter.ofPattern("d/MM/y"));
        for (int i= 0; i<200; i++) {
           fechaLD= fechaLD.plusDays(1);
           fecha = fechaLD.format(DateTimeFormatter.ISO_DATE);
           fechasDisponibles.add(fecha);
       }
    }



    public void removeFechasDisponibles (String fecha){
        LocalDate fechaLD= LocalDate.parse(fecha, DateTimeFormatter.ofPattern("d/MM/y"));
        fecha = fechaLD.format(DateTimeFormatter.ISO_DATE);
        for (int i =0; i<fechasDisponibles.size(); i++) {
            if(fechasDisponibles.get(i).equals(fecha)){
                fechasDisponibles.remove(i);
            }
        }
    }

    public void cargaFechaDisponible (Avion avion ,String fecha ){
        LocalDate fechaLD= LocalDate.parse(fecha, DateTimeFormatter.ofPattern("d/MM/y"));
        fecha = fechaLD.format(DateTimeFormatter.ISO_DATE);
        avion.getFechasDisponibles().add(fecha);
    }


    public ArrayList<String> getFechasDisponibles() {
        return fechasDisponibles;
    }

    public void setFechasDisponibles(ArrayList<String> fechasDisponibles) {
        this.fechasDisponibles = fechasDisponibles;
    }
    public void muestraFechasDisponibles(){
        for (String fecha: fechasDisponibles){
            System.out.println(fecha);
        }
    }

    @Override
    public String toString() {
        if (disponibilidad) {
            if (wifi) {
                return  (ANSI_BLUE + "\n\tAvion " + this.catAvion +ANSI_RESET) +
                        "\nCatering: " + this.catering +
                        "\nWifi: SI" +
                        "\nCombustible: " + this.combustible +
                        "\nCosto Km: " + this.costoKm +
                        "\nCapacidad de Pasajeros: " + this.capacidadPasajeros +
                        "\nVelocidad Maxima: " + this.velocidadMax +
                        "\nID de Avion: " + this.idAvion +
                        "\nUNIDAD DISPONIBLE ";

                    }else{
                return (ANSI_BLUE + "\n\tAvion " + this.catAvion +ANSI_RESET) +
                        "\nCatering: " + this.catering +
                        "\nWifi: NO" +
                        "\nCombustible: " + this.combustible +
                        "\nCosto Km: " + this.costoKm +
                        "\nCapacidad de Pasajeros: " + this.capacidadPasajeros +
                        "\nVelocidad Maxima: " + this.velocidadMax +
                        "\nID de Avion: " + this.idAvion +
                        "\nUNIDAD DISPONIBLE ";
            }

        }else{
            return (ANSI_BLUE + "\n\tAvion " + this.catAvion +ANSI_RESET) +
                    "\nCatering: " + this.catering +
                    "\nWifi: NO" +
                    "\nCombustible: " + this.combustible +
                    "\nCosto Km: " + this.costoKm +
                    "\nCapacidad de Pasajeros: " + this.capacidadPasajeros +
                    "\nVelocidad Maxima: " + this.velocidadMax +
                    "\nID de Avion: " + this.idAvion +
                    "\nUNIDAD NO DISPONIBLE " ;


        }
    }



}
