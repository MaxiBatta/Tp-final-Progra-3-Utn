package com.company;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class AeroTaxi {
    //Codigos de escape ANSI (color)
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";

//region Archivos/ json Persistencia datos
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
    private HashMap <String, Integer> listaHash = new HashMap<>();

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
//endregion

    public AeroTaxi() {
        clientes = cargarClientes();
        aviones = cargarAviones();
        rutas = cargarRutas();
        vuelos = cargarVuelos();
        reservas = cargarReservas();

    }
//region Const
    public AeroTaxi(ArrayList<Cliente> clientes, ArrayList<Avion> aviones, ArrayList<Vuelo> vuelos) {
        this.clientes = clientes;
        this.aviones = aviones;
        this.vuelos = vuelos;
    }
//endregion
//getters and Setters
    public ArrayList<Avion> getAviones() {
        return aviones;
    }

    public void setAviones(ArrayList<Avion> aviones) {
        this.aviones = aviones;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }


//region Metodos

    //Fx agrega clientes a ArrayList clientes
    public void altaCliente(String nombre, String apellido, String usuario, String password, int edad, int dni) {
        Cliente nuevo = new Cliente(nombre, apellido, usuario, password, edad, dni);
        clientes.add(nuevo);

    }


    public Cliente buscarCliente1(int dni) {

        int pos = -1;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getDni().equals(dni))
                pos = i;

        }
        return clientes.get(pos);
    }

    public Cliente buscarCliente(String usuario, String password, int dni){

        int pos = -1;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getUsuario().equals(usuario) && clientes.get(i).getPassword().equals(password)&&clientes.get(i).getDni().equals(dni)) {
                pos = i;
            }
        }
        if (pos==-1)
            System.out.println("Cliente no validado");

        return clientes.get(pos);
    }


    public Cliente buscaCliente (String user, String pass, int dni) throws Exception {

        Cliente clienteAux = new Cliente();
        clienteAux = null;

        for (Cliente c : clientes) {
            if (c.getUsuario().equals(user) && c.getPassword().equals(pass) && c.getDni().equals(dni)) {
                clienteAux = c;
            }
        }
        if (clienteAux == null) {
            throw new Exception("Error en la identificacion del cliente");
        }
        return clienteAux;
    }

    public int validaDniExiste (int dni){
        int flag=0;
        for (Cliente c : clientes){
            if (c.getDni()== dni){
                System.out.println(ANSI_RED+"El DNI ingresado ya se encuentra registrado como cliente");
                flag=1;
            }
        }
        return flag;
    }
    public int validaDniExiste1 (int dni){
        int flag=0;
        for (Cliente c : clientes){
            if (c.getDni()== dni){

                flag=1;
            }
        }
        return flag;
    }



    public void muestraClientes() {
        for (Cliente c : clientes) {
            System.out.println(c);
            System.out.println(ANSI_CYAN +"Total Facturado a la fecha: "+ calculaTotalFacturadoVuelosDni(c.getDni()) + ANSI_RESET);
            categoriaMasUtilizada(c.getDni());
        }
    }
//Funcion que utilizo para generar los aviones de la flota y sus fechas disponibles de vuelo en un Array de fechas String
    public void altaAvion() {
        Gold avg1= new Gold(10000, 300, 25, 600, Propulsion.Reaccion, true,6000,"Premium",true, "GOLD");
        Gold avg2= new Gold(15000, 280, 20, 500, Propulsion.Reaccion,true,6000,"Premium", false, "GOLD");
        Silver avs1= new Silver(9000, 250,20,500,Propulsion.Pistones,true,4000,"Basico",false, "SILVER");
        Silver avs2= new Silver(8000, 280, 20, 500, Propulsion.Reaccion, true,4000,"Basico",false, "SILVER");
        Bronze avb1= new Bronze(9000, 180, 30, 400, Propulsion.Helice,true,3000,"NO",false,"BRONZE");
        Bronze avb2= new Bronze(5000, 150, 10, 450, Propulsion.Helice,true,3000,"NO",false, "BRONZE");

        aviones.add(avg1);
        aviones.add(avg2);
        aviones.add(avs1);
        aviones.add(avs2);
        aviones.add(avb1);
        aviones.add(avb2);


       aviones.get(0).cargaFechasDisponibles("14/06/2021");
       aviones.get(1).cargaFechasDisponibles("14/06/2021");
       aviones.get(2).cargaFechasDisponibles("14/06/2021");
       aviones.get(3).cargaFechasDisponibles("14/06/2021");
       aviones.get(4).cargaFechasDisponibles("14/06/2021");
       aviones.get(5).cargaFechasDisponibles("14/06/2021");


    }


    public void muestraAviones() {
        for (Avion e : aviones) {
            if (e instanceof Gold)
            System.out.println((Gold)e);
            if (e instanceof Silver)
                System.out.println((Silver)e);
            if (e instanceof Bronze)
                System.out.println((Bronze)e);

            }
    }

    public void muestraAvionesx() {
        for (Avion a : aviones) {
            System.out.println(a);
        }
    }

    public void muestraAvionesDisponiblesPorFecha(String fecha, int pasajeros) {
        Boolean dispo=false;
        LocalDate fechaLD= LocalDate.parse(fecha, DateTimeFormatter.ofPattern("d/MM/y"));
        fecha = fechaLD.format(DateTimeFormatter.ISO_DATE);
        for (var avion : aviones) {
            if (avion.getFechasDisponibles().contains(fecha) && avion.isDisponibilidad()&& avion.getCapacidadPasajeros()>= pasajeros) {
                System.out.println( avion );
                dispo=true;
            }
        }
        if (!dispo){
            System.out.println("No tenemos aviones disponibles para esa fecha");
        }
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

        //Fx da de alta rutas en ArrayList
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
    //La uso para agregar u vuelo al ArrayList
    public void altaVuelo(Vuelo vuelo){
        vuelos.add(vuelo);
    }

    public void muestraVuelos() {
        for (var vuelo: vuelos) {
            System.out.println(vuelo);
        }
    }

    public void altaReserva (Cliente cliente, Vuelo vuelo, int idReserva){
        reservas.add(new Reserva(cliente, vuelo, idReserva));
    }

    //La uso para agregar una reserva al ArrayList
    public void altaReserva (Reserva r){
        reservas.add(r);
    }

    public void bajaReserva (int idReserva){
        reservas.remove(buscaReserva(idReserva));
    }


    public Reserva buscaReserva(int id) {
        Reserva r = new Reserva();
        r= null;
        try {

            for (var reserva : reservas) {
                if (reserva.getIdReserva() == id) {
                    r = reserva;
                }
            }

        }catch (IndexOutOfBoundsException e){
            System.out.println("Nro elegido invalido");
        }catch (Exception e){
            System.out.println("error" + e.getMessage() );
        }
        return r;
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
    public void muestraReservasFecha(String fecha) {

        int flag=0;
        for (Reserva r: reservas) {
            if(r.getVuelo().getFecha().equals(fecha)) {
                System.out.println(r);
                flag=1 ;
            }
        }
        if (flag==0) {
            System.out.println(ANSI_RED + "No hay reservas programadas para esa fecha" + ANSI_RESET);
        }

    }


//fx que utilizo para el total facturado por cliente
    public float calculaTotalFacturadoVuelosDni (int dni) {

        float total=0;
        for (Reserva r: reservas) {
            if(r.getCliente().getDni()==dni) {
                total =  total + r.getVuelo().calculaCostoVuelo();
            }
        }
        return total;
        }
//Fx que indica la mayor categoria usada hasta el momento
    public void categoriaMasUtilizada (int dni) {

        int Gold=0;
        int Silver=0;
        int Bronze=0;
        for (Reserva r: reservas) {
            if(r.getCliente().getDni()== dni && r.getVuelo().getAvion().getCatAvion().equals("GOLD")) {
                Gold=1;
            }
            if(r.getCliente().getDni()== dni && r.getVuelo().getAvion().getCatAvion().equals("SILVER")) {
               Silver=1;

            }if(r.getCliente().getDni()== dni && r.getVuelo().getAvion().getCatAvion().equals("BRONZE")) {
                Bronze=1;
            }
        }
        if (Gold != 0) {
            System.out.println(ANSI_CYAN + "CT ++ GOLD\n" + ANSI_RESET);
        }else{
            if(Silver!=0){
                System.out.println(ANSI_GREEN + "CT ++ SILVER\n" + ANSI_RESET);
            }else{
                if(Bronze!=0) {
                    System.out.println(ANSI_BLUE + "CT ++ BRONZE\n" + ANSI_RESET);
                }else{
                    System.out.println(ANSI_RED + "CT ++ --\n" + ANSI_RESET);
                }
            }
        }

    }


    public boolean validaReservas (){
        Boolean rta=true;
        if( reservas.isEmpty()){
            rta= false;
            }

            return rta;
        }

    public  int validaReservaDni(int dni)  {
        int flag=0;
        for (Reserva r: reservas)
            if (r.getCliente().getDni()==dni){
                flag=1;
            }
        return flag;
    }
    //fx para buscar el ultimo id de las reservas
    public int ultimoIdReservas (){
        return reservas.size();
    }
//endregion

    public void recorreArrayyPasaaListhash(){
        for (Reserva r : reservas){
            listaHash.put(r.getCliente().getApellido(), r.getCliente().getDni());
        }
    }
    public void muestraListaHash(){
        listaHash.forEach(
                (k,v) ->{
                    System.out.println("Apellido Cliente : " + k);
                    System.out.println("Dni nro : " + v);
                    System.out.println("-------------------------");
                }
                );
    }

}

