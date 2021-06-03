package com.company;

import java.util.UUID;

public class Vuelo {

    private UUID idVuelo;
    private String fecha;
    private Ruta ruta;
    private int numeroPasajeros;
    private Avion avion;

    public Vuelo() {
    }

    public Vuelo(UUID idVuelo, String fecha, Ruta ruta, int numeroPasajeros, Avion avion) {
        this.idVuelo = idVuelo;
        this.fecha = fecha;
        this.ruta = ruta;
        this.numeroPasajeros = numeroPasajeros;
        this.avion = avion;
    }

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

    @Override
    public String toString() {
        return "Vuelo: " + this.idVuelo +
                "\nFecha: " + this.fecha +
                "\nRuta: " + this.ruta +
                "\nAvion: " + this.avion;

    }
}
