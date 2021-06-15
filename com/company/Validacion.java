package com.company;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Validacion {
    Scanner scan = new Scanner(System.in);
    public Validacion() {
    }

    public  int validaLetrasYnumeros(String string) {
        int flag=0;
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i)) && !Character.isLetter(string.charAt(i)))
                flag=1;
        }

        return flag;
    }

    public  boolean validaUnNumero(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (Character.isDigit(string.charAt(i)))
                return true;
        }
        return false;
    }

    public  boolean unaLetra(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (Character.isLetter(string.charAt(i)))
                return true;
        }
        return false;
    }

        public  boolean soloLetra(String string) {
            for (int i = 0; i < string.length(); i++) {
                if (!Character.isLetter(string.charAt(i)))
                    return false;
            }
            return true;
        }

    // nombres y apellidos
    public  int validaNombreApellido (String string)  {
            int flag=0;

        if (!soloLetra(string) || string.length() < 3) {
            System.out.println("Debe ingresar solo caracteres alfabeticos y como minimo 4 caracteres");
            flag = 1;
        }
        return flag;
    }
    public  int validaUsuarioPassword (String string) {
        int flag=0;

        if (string.length() < 3) {
            System.out.println("Debe ingresar como minimo 4 caracteres");
            flag=1;
        }
        return flag;
    }




    // Para Edad
    public  int validaEdad(int edad)  {
        int flag=0;
        if (edad < 18 || edad > 99) {
            System.out.println("Edad no permitida");
            flag = 1;
        }
        return flag;
    }

    public  boolean validaFechaFormato(String fecha) throws Exception {

        if (fecha.length() != 10)
            throw new Exception("Fecha/Formato incorrecto/ Ingrese dd/mm/yyyy");

        return true;

    }
    public  boolean validaFecha( LocalDate fechaLd) throws Exception {
        LocalDate fechaActual = LocalDate.now();
        if (fechaActual.isAfter(fechaLd))
            throw new Exception("Fecha no puede ser anterior a la actual");

        if (fechaLd.isAfter(fechaActual.plusMonths(6)))
            throw new Exception("Todavia no hay vuelos programados para esa fecha");


        return true;

    }


    // Para Dni
    public  int validaDni(int dni)  {
        int flag=0;
        if (String.valueOf(dni).length() != 8) {
            System.out.println("Dni Formato incorrecto");
            flag = 1;
        }
        return flag;

    }

    //para verificar origen y destino
    public  boolean validaOrigenDestino(String string1, String string2) throws Exception {
        if (string1.equals(string2)) {
            throw new Exception("Origen y  Destino no pueden ser iguales");
        }

        return true;
    }

    public  boolean validaCantAcompañantes(int cantMax , int cant) throws Exception {

        if (cant > cantMax) {
            throw new Exception("No tenemos aviones disponibles con esa capacidad/Capacidad maxima: 30 pasajeros según disponibilidad por fecha ");
        }

        return true;
    }

    public  boolean validaIdReserva1(ArrayList<Reserva> reservas , int id) throws Exception {
            for (Reserva reserva : reservas)
            if (reservas.contains(id)) {
                throw new Exception("El nro de reserva no es valida");
            }

        return true;
    }

    public  void validaIdReserva(ArrayList<Reserva> reservas , int id)  {

            if (reservas.get(id)== null) {
                System.out.println("El nro de reserva no es valida");
            }

    }





}
