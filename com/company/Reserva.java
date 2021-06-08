package com.company;

public class Reserva {
    private Cliente cliente;
    private static int cont = 0;
    private int idReserva;
    private Vuelo vuelo;




    public Reserva() {
    }



    public Reserva(Cliente cliente, Vuelo vuelo) {
        this.cliente = cliente;
        this.vuelo = vuelo;
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


    public static int getCont() {
        return cont;
    }

    public static void setCont(int cont) {
        Reserva.cont = cont;
    }

    @Override
    public String toString() {
        return "Reserva " +
                "\nReserva Id: " + this.idReserva +
                "\nCliente: " + this.cliente.toString() +
                "\nVuelo: " + this.vuelo.toString();

    }
}
