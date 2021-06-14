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

    public  boolean validaLetrasYnumeros(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i)) && !Character.isLetter(string.charAt(i)))
                return false;
        }

        return true;
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
    public  boolean validaNombreApellido (String string) throws Exception {

            if (!soloLetra(string))
                throw new Exception("Debe ingresar solo caracteres alfabeticos");

            if (string.length() < 3)
                throw new Exception("Debe ingresar al menos 4 caracteres");


        return true;
    }




    // Para Edad
    public  boolean validaEdad(int edad) throws Exception {

        if (edad < 18 || edad > 99)
            throw new Exception("Edad no permitida");

        return true;

    }
    public  boolean validaFechaFormato(String fecha) throws Exception {

        if (fecha.length() != 10)
            throw new Exception("Fecha/Formato incorrecto/ Ingrese dd/mm/yyyy");

        return true;

    }
    public  boolean validaFecha( LocalDate fechaLd) throws Exception {
        LocalDate fechaActual = LocalDate.now();
        if (fechaActual.isAfter(fechaLd)) {
            throw new Exception("Fecha no puede ser anterior a la actual");
        }
        if (fechaLd.isAfter(fechaActual.plusMonths(6))) {
            throw new Exception("Todavia no hay vuelos programados para esa fecha");
        }

        return true;

    }


    // Para Dni
    public  boolean validaDni(int dni) throws Exception {
        if (String.valueOf(dni).length() != 8)
            throw new Exception("Dni incorrecto");

        return true;

    }

    //para verificar origen y destino
    public  boolean validaOrigenDestino(String string1, String string2) throws Exception {
        if (string1.equals(string2)) {
            throw new Exception("Origen y  Destino no pueden ser iguales");
        }

        return true;
    }

    public  boolean validaCantAcompañantes(ArrayList<Avion> aviones , int cant) throws Exception {
        for (Avion avion : aviones)
        if (cant > avion.getCapacidadPasajeros()) {
            throw new Exception("No tenemos aviones disponibles con esa capacidad de pasajeros");
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
