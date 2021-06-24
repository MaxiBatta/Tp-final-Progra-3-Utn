package com.company;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;



public class Generica<T> {

    private List<T> listaGen = new ArrayList<>();
    private File archivoListaGen = new File("listaGen.json");

    private static GsonBuilder gb = new GsonBuilder();
    Gson gson = gb.setPrettyPrinting().create();

    public void guardarListaGen() {
        try {
            String json = gson.toJson(listaGen);

            FileWriter file = new FileWriter(archivoListaGen);
            file.write(json);

            file.flush();
            file.close();

        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    public ArrayList<T> cargarListaGen() {
        ArrayList<T> listaGen = new ArrayList<>();


        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(archivoListaGen));

            listaGen = gson.fromJson(reader,(new TypeToken< ArrayList <T>>(){}.getType()));

            reader.close();
        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
        return listaGen;
    }

    public Generica() {
    }


    public void agregarElemento(T t) {
        listaGen.add(t);
    }

    public void muestraListaC() {
        for (T t : listaGen) {
            if(t instanceof Cliente){
            System.out.println(t);
            System.out.println("------------------");
        }
    }}
    public void muestraListaA() {
        for (T t : listaGen) {
            if(t instanceof Avion){
                System.out.println(t);
                System.out.println("------------------");
            }
        }}
    public void muestraListaV() {
        for (T t : listaGen) {
            if(t instanceof Vuelo){
                System.out.println(t);
                System.out.println("------------------");
            }
        }}

    public void muestraListaR() {
        for (T t : listaGen) {
            if(t instanceof Ruta){
                System.out.println(t);
                System.out.println("------------------");
            }
        }}

    public void muestraListaRe() {
        for (T t : listaGen) {
            if(t instanceof Reserva){
                System.out.println(t);
                System.out.println("------------------");
            }
        }}
    public void muestraLista() {
        for (T t : listaGen) {
            if(t instanceof Gold || t instanceof Silver || t instanceof Bronze) {
                System.out.println(t);
                System.out.println("------------------");
            }
        }}

    public void recorreArrayyPasaaListaGenerica( ArrayList <T>array){
        for (T t : array){
            agregarElemento(t);
        }
    }
   }

