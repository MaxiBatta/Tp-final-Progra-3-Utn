package com.company;

public class Reserva {
    private Cliente cliente;
    private static int cont = 0;
    private int idReserva;
    private Vuelo vuelo;
    private Ruta ruta;



    public Reserva() {
    }



    public Reserva(Cliente cliente, Cliente cliente1, Vuelo vuelo, Ruta ruta) {
        this.cliente = cliente;
        this.cliente = cliente1;
        this.vuelo = vuelo;
        this.ruta = ruta;
        this.idReserva = ++cont;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public static int getCont() {
        return cont;
    }

    public static void setCont(int cont) {
        Reserva.cont = cont;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "cliente=" + cliente +
                ", cliente=" + cliente +
                ", vuelo=" + vuelo +
                ", ruta=" + ruta +
                '}';
    }
}
