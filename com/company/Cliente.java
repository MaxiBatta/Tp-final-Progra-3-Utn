package com.company;

public class Cliente extends Persona  {
private static int cont = 0;
private int idCliente;
private String usuario;
private String password;




//region Const

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String usuario, String password,Integer edad, Integer dni) {
        super(nombre, apellido, edad, dni);
        this.idCliente = ++cont;
        this.usuario = usuario;
        this.password = password;
    }

    public static int getCont() {
        return cont;
    }

    public static void setCont(int cont) {
        Cliente.cont = cont;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


//endregion
//region Getters & Setters

//endregion
//region Metodos
@Override
    public String toString() {
        return "Nombre: " + this.getNombre() +
                "\nApellido: " + this.getApellido() +
                "\nDni: " + this.getDni() +
                "\nEdad: " + this.getEdad() +
                "\n-------------------- ";
    }
//endregion

}
