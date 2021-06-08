package com.company;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {
    Scanner scan = new Scanner(System.in);
    Scanner pausa = new Scanner (System.in);
    Aerotaxi sistema = new Aerotaxi();

    public Menu() {
    }

    public  void menuInicio (){
    Scanner scan = new Scanner(System.in);
    Scanner pausa = new Scanner (System.in);
    boolean salir = false;
    int opcion;

   do {
        System.out.println("1. Ingreso sistema de reservas");
        System.out.println("2. Lista de vuelos");
        System.out.println("3. Lista de clientes");
        System.out.println("4. Salir");
        try {
            System.out.println("Escribe una de las opciones");
            opcion = scan.nextInt();
            switch (opcion) {
                case 1:
                    menuReserva();
                    pausa.nextLine();
                    break;
                case 2:
                    System.out.println("Has seleccionado la opcion 2");
                    pausa.nextLine();
                    break;
                case 3:
                    System.out.println("Has seleccionado la opcion 3");
                    pausa.nextLine();
                    break;
                case 4:
                    salir = true;
                    System.out.println("Gracias por utilizar nuestro servicio");
                    break;
                default:
                    System.out.println("Solo opciones entre 1 y 3");
            }
        } catch (InputMismatchException e) {
            System.out.println("Debes insertar un número");
            scan.next();
        }
    } while (!salir);
}


    public  void menuReserva () {
        Scanner scan = new Scanner(System.in);
        Scanner pausa = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        do {
            System.out.println("1. Cliente ya registrado");
            System.out.println("2. Nuevo cliente");

            System.out.println("3. Menu anterior");
            try {
                System.out.println("Escribe una de las opciones");
                opcion = scan.nextInt();
                switch (opcion) {
                    case 1:
                        menuClienteRegistrado();
                        pausa.nextLine();

                        break;
                    case 2:
                        menuRegistraCliente();
                        pausa.nextLine();

                        pausa.nextLine();
                        break;

                    case 3:
                        salir = true;
                        System.out.println("Enter para volver a menu anterior");
                        break;
                    default:
                        System.out.println("Solo opciones entre 1 y 2");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                scan.next();
            }
        } while (!salir);
    }


    private void menuRegistraCliente() {
        String usuario;
        String password;
        String nombre;
        String apellido;
        String edad;
        String dni;

        try {

            System.out.println("Ingrese su nombre: ");
            nombre = pausa.nextLine();
            System.out.println("Ingrese su apellido: ");
            apellido = pausa.nextLine();
            System.out.println("Ingrese su edad: ");
            edad = pausa.next();
            System.out.println("Ingrese su dni: ");
            dni = pausa.next();
            System.out.println("Ingrese un Usuario: ");
            usuario = pausa.next();
            System.out.println("Ingrese su password: ");
            password = pausa.next();

            if (sistema.buscarCliente(dni) == -1) {
                sistema.altaCliente(nombre,apellido,usuario,password,edad,dni);
                System.out.println("Registracion exitosa");
                sistema.muestraClientes();
            } else {
                System.out.println("Este cliente ya existe en el sistema");
            }


        } catch (InputMismatchException e) {
            System.out.println("Debe ingresar numeros para Dni o edad...");
            pausa.nextLine();
        }

    }
    private void menuClienteRegistrado() {
        String dni;
        String usuario;
        String password;
        try {
            sistema.muestraClientes();
            System.out.println("Ingrese Usuario:");
            usuario = pausa.next();
            System.out.println("Ingrese Password");
            pausa.nextLine();
            password = pausa.next();
            System.out.println("Ingrese dni");
            pausa.nextLine();
            dni = pausa.next();
            Cliente cliente = sistema.buscarCliente1(dni);
            System.out.println(sistema.buscarCliente1(dni));

            if(sistema.buscarCliente(usuario,password)>-1) {
                System.out.println("Acceso exitoso!");
            }else{
                System.out.println("Usuario o contraseña no valida");
            }
            menuCliente(dni);

        } catch (InputMismatchException e) {
            System.out.println("Debe ingresar valores enteros para DNI");
            pausa.nextLine();

        }
    }

    private void menuCliente (String dni) {
        int opcion;
        boolean continuar = true;


        do {
            try {
                System.out.println("Menu Opciones de Cliente " + sistema.buscarCliente1(dni).getNombre());
                System.out.println("1-Realizar reserva/muestra aviones");
                System.out.println("2-Cancelar Vuelo");
                System.out.println("3-Mostrar Historial de Vuelos");
                System.out.println("4-Mostrar Vuelos de Fecha elegida");
                System.out.println("5-Volver al menu anterior");
                opcion = pausa.nextInt();


                switch (opcion) {
                    case 1:
                        menuAltaReserva();
                        pausa.nextLine();
                        break;
                    case 2:

                        break;
                    case 3:

                        break;

                    case 4:

                        break;
                    case 5:
                        System.out.println("saliendo del menu");
                        continuar = false;
                        break;
                    default:
                        System.out.println("opcion incorrecta");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("ingrese un numero entero, por favor");
                pausa.nextLine();
            }

        } while (continuar);

    }

    private void menuAltaReserva () {
        String fecha;
        String origen;
        String destino;
        int pasajeros;
        int idAvion;
        String opcion;



        try {
            System.out.println("Ingrese fecha de vuelo para reserva");
            fecha  = pausa.next();
            LocalDate fechaReserva= LocalDate.parse(fecha, DateTimeFormatter.ofPattern("d/MM/y"));
            System.out.println("Ingrese cantidad de acompañantes");
            pasajeros= pausa.nextInt();
            System.out.println("Rutas disponibles");
            sistema.altaRuta();
            sistema.muestraRutas();
            pausa.nextLine();
            System.out.println("Ingrese Ciudad de origen");
            origen = pausa.nextLine();
            System.out.println("Ingrese Ciudad de destino");
            destino = pausa.nextLine();
            System.out.println("\n-----------------------------\n");
            System.out.println("Aviones disponibles");
            System.out.println("\n-----------------------------");
            sistema.altaAvion();
            sistema.muestraAvionesDisponiblesxFecha(fecha);
            System.out.println("destino " + destino);
            System.out.println("origen " + origen);

            System.out.println("Elija un avion disponible por nro de ID");
            idAvion = pausa.nextInt();
            Ruta ruta = sistema.buscaRuta(origen, destino);
            Avion avion= sistema.buscaAvion(idAvion);
            avion.removeFechasDisponibles(fecha);
            avion.setDisponibilidad(false);
            sistema.muestraAviones();
            System.out.println(ruta);


            if(ruta!= null) {
                if (pasajeros < avion.getCapacidadPasajeros()){
                sistema.altaVuelo(fecha,ruta, pasajeros, avion);
                sistema.muestraVuelos();
                } else{
                System.out.println("NO tenemos aviones con esa capacidad de pasajeros");
            }}else{
                System.out.println("La ruta elegida no es correcta");
            }


            System.out.println("Desea confirmar la reserva para este vuelo S/N? ");
            opcion = pausa.next();


            pausa.nextLine();


        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error en la eleccion " + e.getMessage());
        } catch (InputMismatchException exc) {
            System.out.println("Debe ingresar un numero entero");
            pausa.nextLine();
        }
    }

}
