package com.company;

public class Cliente  {
private static int cont = 0;
private int idCliente;
private String nombre;
private String apellido;
private String usuario;
private String password;
private Integer edad;
private Integer dni;



//region Const

    public Cliente() {
    }

    public Cliente( String nombre, String apellido, String usuario, String password, int edad, int dni) {
        this.idCliente = ++cont;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.password = password;
        this.edad = edad;
        this.dni = dni;
    }

//endregion
//region Getters & Setters
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

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
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
//endregion
//region Metodos
@Override
    public String toString() {
        return "Nombre: " + this.nombre +
                "\nApellido: " + this.apellido +
                "\nDni: " + this.dni +
                "\nEdad: " + this.edad +
                "\n-------------------- ";
    }
//endregion

}
