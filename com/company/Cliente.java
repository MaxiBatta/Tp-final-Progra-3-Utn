package com.company;

public class Cliente  {
private static int cont = 0;
private int idCliente;
private String nombre;
private String apellido;
private String usuario;
private String password;
private String edad;
private String dni;





    public Cliente() {
    }

    public Cliente( String nombre, String apellido, String usuario, String password, String edad, String dni) {
        this.idCliente = ++cont;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.password = password;
        this.edad = edad;
        this.dni = dni;
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
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
                "\nUsuario: " + this.usuario +
                "\nPassword: " + this.password +
                "\n-------------------- ";
    }


}
