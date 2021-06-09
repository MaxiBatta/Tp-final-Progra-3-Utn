package com.company;

public class Validacion {

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

    // Para Dni
    public  boolean validaDni(int dni) throws Exception {
        if (String.valueOf(dni).length() != 8)
            throw new Exception("Dni incorrecto");

        return true;

    }

    //para verificar origen y destino
    public  boolean validaOrigenDestino(String origen, String destino) throws Exception {
        if (origen.equals(destino)) {
            throw new Exception("Origen y  Destino no pueden ser iguales");
        }

        return true;
    }

}
