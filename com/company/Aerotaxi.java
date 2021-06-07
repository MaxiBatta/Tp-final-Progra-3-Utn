package com.company;

import java.util.ArrayList;

public class Aerotaxi {


    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Avion> aviones = new ArrayList<>();
    private ArrayList<Vuelo> vuelos = new ArrayList<>();


    public Aerotaxi() {
    }

    public Aerotaxi(ArrayList<Cliente> clientes, ArrayList<Avion> aviones, ArrayList<Vuelo> vuelos) {
        this.clientes = clientes;
        this.aviones = aviones;
        this.vuelos = vuelos;
    }

    public void altaCliente(String nombre, String apellido, String usuario, String password,String edad, String dni) {
        Cliente nuevo = new Cliente(nombre,apellido,usuario,password,edad,dni);
        clientes.add(nuevo);

    }
    public int buscarCliente(String dni) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getDni() == dni)
                return i;
        }
        return -1;
    }
    public Cliente buscarCliente1(String dni) {
        Cliente cliente= new Cliente();
        int cont = 0;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getDni() == dni) {
                cont = i;
            }
        }
        return clientes.get(cont);
    }
    public int buscarCliente(String usuario, String password) {

        int pos = -1;
        for ( int i=0 ; i < clientes.size(); i++) {
            if (clientes.get(i).getUsuario().equals(usuario) && clientes.get(i).getPassword().equals(password)){
                pos = i;
            }
        }
        return pos;
    }
    public String buscarClientePassword(String dni) {
        Cliente cliente= new Cliente();
        int cont = 0;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getDni() == dni) {
                cont = i;
            }
        }
        return clientes.get(cont).getPassword();
    }
    public String buscarClienteUsuario(String dni) {
        Cliente cliente= new Cliente();
        int cont = 0;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getDni() == dni) {
                cont = i;
            }
        }
        return clientes.get(cont).getUsuario();
    }

    public void muestraClientes () {
        for (var cliente : clientes) {
            System.out.println(cliente);
        }
    }

}
