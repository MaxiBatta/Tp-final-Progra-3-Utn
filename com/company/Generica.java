package com.company;

import java.util.ArrayList;
import java.util.List;

public class Generica <T>{

    private List<T> listaGen = new ArrayList<>();


    public Generica() {
    }


    public void agregarElemento (T t){
        listaGen.add(t);
    }

    public void muestraLista (){
        for (T t : listaGen){
            System.out.println(t);
            System.out.println("------------------");
        }
    }

}
