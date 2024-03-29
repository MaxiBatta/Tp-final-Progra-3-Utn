package com.company;

import java.util.ArrayList;

public class Ruta {

    private static int cont = 0;
    private String origen;
    private String destino;
    private int distanciaKm;
    private int idRuta;

//Constructores
    public Ruta() {
    }



    public Ruta(String origen, String destino, int distanciaKm) {
        this.origen = origen;
        this.destino = destino;
        this.distanciaKm = distanciaKm;
        this.idRuta = ++cont;
    }
//getters and setters

    public static int getCont() {
        return cont;
    }

    public static void setCont(int cont) {
        Ruta.cont = cont;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(int distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }


//Metodos

    @Override
    public String toString() {
        return "Ruta ID: " + this.idRuta +
                "\nOrigen: " + this.origen +
                "\nDestino: " + this.destino +
                "\nDistancia en Km: " + this.distanciaKm +
                "\n------------------------------" ;
    }
}
