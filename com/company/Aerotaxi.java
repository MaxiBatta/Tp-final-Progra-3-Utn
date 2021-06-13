package com.company;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Aerotaxi {

    private File archivoClientes = new File("Clientes.json");
    private File archivoAviones = new File("Aviones.json");
    private File archivoVuelos = new File("Vuelos.json");
    private File archivoReservas = new File("Reservas.json");
    private File archivoRutas = new File("Rutas.json");
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Avion> aviones = new ArrayList<>();
    private ArrayList<Vuelo> vuelos = new ArrayList<>();
    private ArrayList<Reserva> reservas = new ArrayList<>();
    private ArrayList<Ruta> rutas = new ArrayList<>();

    private static GsonBuilder gb = new GsonBuilder();
    Gson gson = gb.setPrettyPrinting().create();

    public void guardarClientes() {
        try {
            String json = gson.toJson(clientes);

            FileWriter file = new FileWriter(archivoClientes);
            file.write(json);

            file.flush();
            file.close();

        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    public ArrayList<Cliente> cargarClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(archivoClientes));

            clientes = gson.fromJson(reader,(new TypeToken<ArrayList<Cliente>>(){}.getType()));

            reader.close();
        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
        return clientes;
    }
    public void guardarAviones() {
        try {
            String json = gson.toJson(aviones);

            FileWriter file = new FileWriter(archivoAviones);
            file.write(json);

            file.flush();
            file.close();

        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    public ArrayList<Avion> cargarAviones() {
        ArrayList<Avion> aviones = new ArrayList<>();


        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(archivoAviones));

            aviones = gson.fromJson(reader,(new TypeToken<ArrayList<Avion>>(){}.getType()));

            reader.close();
        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
        return aviones;
    }
    public void guardarRutas() {
        try {
            String json = gson.toJson(rutas);

            FileWriter file = new FileWriter(archivoRutas);
            file.write(json);

            file.flush();
            file.close();

        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    public ArrayList<Ruta> cargarRutas() {
        ArrayList<Ruta> rutas = new ArrayList<>();

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(archivoRutas));

            rutas = gson.fromJson(reader,(new TypeToken<ArrayList<Ruta>>(){}.getType()));

            reader.close();
        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
        return rutas;
    }
    public void guardarVuelos() {
        try {
            String json = gson.toJson(vuelos);

            FileWriter file = new FileWriter(archivoVuelos);
            file.write(json);

            file.flush();
            file.close();

        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    public ArrayList<Vuelo> cargarVuelos() {
        ArrayList<Vuelo> vuelos = new ArrayList<>();

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(archivoVuelos));

            vuelos = gson.fromJson(reader,(new TypeToken<ArrayList<Vuelo>>(){}.getType()));

            reader.close();
        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
        return vuelos;
    }
    public void guardarReservas() {
        try {
            String json = gson.toJson(reservas);

            FileWriter file = new FileWriter(archivoReservas);
            file.write(json);

            file.flush();
            file.close();

        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    public ArrayList<Reserva> cargarReservas() {
        ArrayList<Reserva> reservas = new ArrayList<>();

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(archivoReservas));

            reservas = gson.fromJson(reader,(new TypeToken<ArrayList<Reserva>>(){}.getType()));

            reader.close();
        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
        return reservas;
    }

    public Aerotaxi() {
        clientes = cargarClientes();
        aviones = cargarAviones();
        rutas = cargarRutas();
        vuelos = cargarVuelos();
        reservas = cargarReservas();

    }

    public Aerotaxi(ArrayList<Cliente> clientes, ArrayList<Avion> aviones, ArrayList<Vuelo> vuelos) {
        this.clientes = clientes;
        this.aviones = aviones;
        this.vuelos = vuelos;
    }

    public void altaCliente(String nombre, String apellido, String usuario, String password, int edad, int dni) {
        Cliente nuevo = new Cliente(nombre, apellido, usuario, password, edad, dni);
        clientes.add(nuevo);

    }

    public int buscarCliente(int dni) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getDni() == dni)
                return i;
        }
        return -1;
    }

    public Cliente buscarCliente1(int dni) {

        int pos = -1;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getDni().equals(dni))
                pos = i;

        }
        return clientes.get(pos);
    }

    public Cliente buscarCliente(String usuario, String password, int dni)throws Exception{

        int pos = -1;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getUsuario().equals(usuario) && clientes.get(i).getPassword().equals(password)&&clientes.get(i).getDni().equals(dni)) {
                pos = i;
            }
        }
        if (pos==-1)
            throw new Exception("Cliente no registrado, debe registrarse en opcion Nuevo Cliente");

        return clientes.get(pos);
    }



    public void muestraClientes() {
        for (var cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public void altaAvion() {
        aviones.add(new Gold(10000, 300, 25, 600, Propulsion.Reaccion, true));
        aviones.add(new Gold(15000, 280, 20, 500, Propulsion.Reaccion, false));
        aviones.add(new Silver(9000, 250,20,500,Propulsion.Pistones));
        aviones.add(new Silver(8000, 280, 20, 500, Propulsion.Reaccion));
        aviones.add(new Bronze(9000, 180, 30, 400, Propulsion.Helice));
        aviones.add(new Bronze(5000, 150, 10, 450, Propulsion.Helice));
       aviones.get(0).cargaFechasDisponibles("07/06/2021");
       aviones.get(1).cargaFechasDisponibles("07/06/2021");
       aviones.get(2).cargaFechasDisponibles("07/06/2021");
       aviones.get(3).cargaFechasDisponibles("07/06/2021");
       aviones.get(4).cargaFechasDisponibles("07/06/2021");
       aviones.get(5).cargaFechasDisponibles("07/06/2021");



    }

    public void muestraAviones() {
        for (var avion : aviones) {
            System.out.println(avion);
        }
    }
    public void muestraAvionesDisponiblesPorFecha(String fecha) {
        LocalDate fechaLD= LocalDate.parse(fecha, DateTimeFormatter.ofPattern("d/MM/y"));
        fecha = fechaLD.format(DateTimeFormatter.ISO_DATE);
        for (Avion avion : aviones) {
            if (avion.getFechasDisponibles().contains(fecha) && avion.isDisponibilidad()) {
                System.out.println(avion );
            }
        }
    }


    public Avion buscaAvion (int idAvion) throws Exception{
        int pos=-1;
        Avion avionAux= new Avion();

        for (int i = 0; i < aviones.size(); i++) {
            if (aviones.get(i).getIdAvion()== idAvion) {
                pos= i ;
            }
        }
        if (pos==-1)
            throw new Exception("Nro de avion elegido no valido");

        return aviones.get(pos);
    }
    public Avion buscaAvion1 (int idAvion) throws Exception {

        Avion avionAux = new Avion();
        avionAux = null;

        for (Avion avion : aviones) {
            if (avion.getIdAvion() == idAvion) {
                avionAux = avion;
            }
        }
        if (avionAux == null) {
            throw new Exception("Nro de avion elegido no valido");
        }
    return avionAux;
    }


    public void altaRuta (){
        rutas.add(new Ruta("Buenos Aires","Cordoba", 695 ));
        rutas.add(new Ruta("Buenos Aires","Santiago", 1400 ));
        rutas.add(new Ruta("Buenos Aires","Montevideo", 950 ));
        rutas.add(new Ruta("Cordoba","Montevideo", 1190 ));
        rutas.add(new Ruta("Cordoba ","Santiago", 1050 ));
        rutas.add(new Ruta("Montevideo","Santiago", 2100 ));

    }

    public void muestraRutas() {
        for (var ruta : rutas) {
            System.out.println(ruta);
        }
    }
    public Ruta buscaRutaId (int id) throws Exception {

        Ruta rutaAux = new Ruta();
        rutaAux = null;

        for (Ruta ruta : rutas) {
            if (ruta.getIdRuta() == id) {
                rutaAux = ruta;
            }
        }
        if (rutaAux == null) {
            throw new Exception("Nro de Id de ruta elegido no valido");
        }
        return rutaAux;
    }

    public Ruta buscaRuta (String origen, String destino){
        int pos = -1;
        Ruta rutaAux = new Ruta();
        for (int i = 0; i < rutas.size(); i++) {
            if (rutas.get(i).getOrigen().equals(origen) && rutas.get(i).getDestino().equals(destino)) {
                pos= i ;
            }
        }
        return rutas.get(pos);
    }
    public Ruta buscaRuta1 (String origen, String destino) throws Exception {

        Ruta rutaAux = new Ruta();
        rutaAux = null;

        for (Ruta ruta : rutas) {
            if (ruta.getOrigen().equals(origen)&& ruta.getDestino().equals(destino)) {
                rutaAux = ruta;
            }
        }

        return rutaAux;
    }
    public void altaVuelo(String fecha, Ruta ruta, int pasajeros,Avion avion){
        vuelos.add(new Vuelo(fecha, ruta, pasajeros,avion));
    }
    public void altaVuelo(Vuelo vuelo){
        vuelos.add(vuelo);
    }
    public void muestraVuelos() {
        for (var vuelo: vuelos) {
            System.out.println(vuelo);
        }
    }

    public void altaReserva (Cliente cliente, Vuelo vuelo){
        reservas.add(new Reserva(cliente, vuelo));
    }
    public void muestraReservas() {
        for (var reserva: reservas) {
            System.out.println(reserva);
        }
    }
    public void muestraReservas(int dni) {
        for (var reserva: reservas) {
            if(reserva.getCliente().getDni()==dni)
            System.out.println(reserva);
        }
    }

    public ArrayList<Avion> getAviones() {
        return aviones;
    }

    public void setAviones(ArrayList<Avion> aviones) {
        this.aviones = aviones;
    }
}

