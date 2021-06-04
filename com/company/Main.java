package com.company;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
    ArrayList <Ruta> rutas = new ArrayList<>(20);
     creaRutas(rutas);

    }


    static void creaRutas (ArrayList rutas){

        Ruta ruta1 = new Ruta("Buenos Aires", "Cordoba", 695);
        Ruta ruta2 = new Ruta("Buenos Aires", "Santiago", 1400);
        Ruta ruta3 = new Ruta("Buenos Aires", "Montevideo", 950);
        Ruta ruta4 = new Ruta("Cordoba", "Montevideo", 1190);
        Ruta ruta5 = new Ruta("Cordoba", "Santiago", 1050);
        Ruta ruta6 = new Ruta("Montevideo", "Santiago", 2100);
        Ruta ruta7 = new Ruta("Cordoba","Buenos Aires", 695);
        Ruta ruta8 = new Ruta("Santiago", "Buenos Aires", 1400);
        Ruta ruta9 = new Ruta("Montevideo", "Buenos Aires", 950);
        Ruta ruta10 = new Ruta("Montevideo", "Cordoba", 1190);
        Ruta ruta11= new Ruta("Santiago", "Cordoba", 1050);
        Ruta ruta12= new Ruta("Santiago", "Montevideo", 2100);

        rutas.add(ruta1);
        rutas.add(ruta2);
        rutas.add(ruta3);


        for (var ruta: rutas){
            System.out.println(ruta);
        }


    }


}
