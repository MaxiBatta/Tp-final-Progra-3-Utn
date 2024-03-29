package com.company;

public class Reserva {

    private static int cont;
    private Cliente cliente;
    private int idReserva;
    private Vuelo vuelo;

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

//region const
    public Reserva() {
    }



    public Reserva(Cliente cliente, Vuelo vuelo, int idReserva) {
        this.cliente = cliente;
        this.vuelo = vuelo;
        this.idReserva = idReserva;
    }
//endregion

//region Getters and Getters

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
    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }


//endregion

//region metodos
    @Override
    public String toString() {
        return "-----------------------------------" +
                "\n\n " +
                (ANSI_GREEN + "\nReserva Id: " + this.idReserva + ANSI_RESET) +
                "\nCliente: " + this.cliente.toString() +
                "\nVuelo: " + this.vuelo.toString();

    }

//endregion

}
