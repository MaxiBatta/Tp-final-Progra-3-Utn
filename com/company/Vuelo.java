package com.company;

import java.util.Locale;
import java.util.UUID;

public class Vuelo {

    private UUID idVuelo;
    private String fecha;
    private Ruta ruta;
    private int numeroPasajeros;
    private Avion avion;

//Constructores

    public Vuelo() {
    }

    public Vuelo(String fecha, Ruta ruta, int numeroPasajeros, Avion avion) {
        this.idVuelo = UUID.randomUUID();
        this.fecha = fecha;
        this.ruta = ruta;
        this.numeroPasajeros = numeroPasajeros;
        this.avion = avion;
    }

//Getters an Setters

    public UUID getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(UUID idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public int getNumeroPasajeros() {
        return numeroPasajeros;
    }

    public void setNumeroPasajeros(int numeroPasajeros) {
        this.numeroPasajeros = numeroPasajeros;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    //Metodos

    //Fx para calcular el costo del vuelo
    public float calculaCostoVuelo (){

        return (ruta.getDistanciaKm()*avion.getCostoKm()) + numeroPasajeros * 3500 + avion.getTarifaFija();
    }

    @Override
    public String toString() {
        return "Vuelo: " + this.idVuelo.toString().substring(0,4).toUpperCase(Locale.ROOT) +
                "\nFecha: " + this.fecha +
                "\nRuta: " + this.ruta.toString() +
                "\nCosto del Vuelo: " + this.calculaCostoVuelo() +
                "\nAvion: " + this.avion.toString() ;


    }
}
