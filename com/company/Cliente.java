package com.company;

public class Cliente  {
private static int cont = 0;
private int idCliente;
private String nombre;
private String apellido;
private String dni;
private String edad;
private String password = " ";



    public Cliente() {
    }


    public Cliente( String nombre, String apellido, String dni, String edad) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "Nombre: " + this.nombre +
                "\nApellido: " + this.apellido +
                "\nDni: " + this.dni +
                "\nEdad: " + this.edad +
                "\n-------------------- ";
    }
}
