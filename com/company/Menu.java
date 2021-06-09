package com.company;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {
    Scanner scan = new Scanner(System.in);
    Scanner pausa = new Scanner (System.in);
    Aerotaxi sistema = new Aerotaxi();
    Validacion valida = new Validacion();

    public Menu() {
    }

    public  void menuInicio (){
    Scanner scan = new Scanner(System.in);
    Scanner pausa = new Scanner (System.in);
    boolean salir = false;
    int opcion;

   do {
        System.out.println("1. Ingreso sistema de reservas");
        System.out.println("2. Lista de vuelos reservados");
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
                    System.out.println("Listado de reservas registradas");
                    System.out.println("-------------------------------");
                    sistema.muestraReservas();
                    pausa.nextLine();
                    break;
                case 3:
                    System.out.println("Listado de Clientes registrados");
                    System.out.println("-------------------------------");
                    sistema.muestraClientes();
                    pausa.nextLine();
                    break;
                case 4:
                    salir = true;
                    sistema.guardarClientes();

                    System.out.println("Gracias por utilizar nuestro servicio");
                    break;
                default:
                    System.out.println("Solo opciones entre 1 y 4");
            }
        } catch (InputMismatchException e) {
            System.out.println("Debes insertar un número");
            scan.next();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            pausa.nextLine();
        }
   }while (!salir);
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


                        break;

                    case 3:
                        salir = true;
                        System.out.println("Enter para volver a menu anterior");
                        pausa.nextLine();
                        break;
                    default:
                        System.out.println("Solo opciones entre 1 y 2");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                scan.next();
            }catch (Exception e) {
                    System.out.println(e.getMessage());
                    pausa.nextLine();
                }
        } while (!salir);
    }


    private void menuRegistraCliente() {
        String usuario;
        String password;
        String nombre;
        String apellido;
        int edad;
        int dni;

        try {

            pausa.reset();

            System.out.println("Ingrese su nombre: ");
            nombre = pausa.nextLine();
            valida.validaNombreApellido(nombre);
            System.out.println("Ingrese su apellido: ");
            apellido = pausa.nextLine();
            valida.validaNombreApellido(apellido);
            System.out.println("Ingrese su edad: ");
            edad = pausa.nextInt();
            valida.validaEdad(edad);
            System.out.println("Ingrese su dni: ");
            dni = pausa.nextInt();
            valida.validaDni(dni);
            System.out.println("Ingrese un Usuario: ");
            usuario = pausa.next();
            valida.validaLetrasYnumeros(usuario);
            System.out.println("Ingrese su password: ");
            password = pausa.next();
            valida.validaLetrasYnumeros(password);

            if (sistema.buscarCliente(dni) == -1) {
                sistema.altaCliente(nombre,apellido,usuario,password,edad,dni);
                System.out.println("Registracion exitosa");
                sistema.muestraClientes();
            } else {
                System.out.println("Este DNI ya se encuentra registrado en el sistema");
            }
            pausa.reset();
            pausa.nextLine();

        } catch (InputMismatchException e) {
            System.out.println("Debe ingresar numeros...");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            pausa.nextLine();
        }

    }
    private void menuClienteRegistrado()  {
        int dnii;
        String usuario;
        String password;
        try {
            sistema.muestraClientes();
            System.out.println("Ingrese Usuario:");
            usuario = pausa.next();
            System.out.println("Ingrese Password");
            password = pausa.next();
            System.out.println("Ingrese su dni");
            pausa.reset();
            dnii= pausa.nextInt();

            Cliente cliente = sistema.buscarCliente(usuario,password, dnii);
            System.out.println(sistema.buscarCliente(usuario, password, dnii));

            if(cliente!=null)
                System.out.println("Acceso exitoso!");
            if(cliente==null)
                System.out.println("Usuario o contraseña no valida");
            menuCliente(dnii);
            pausa.nextLine();


        } catch (InputMismatchException e) {
            System.out.println("Debe ingresar valores enteros para DNI");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            pausa.nextLine();
        }
        pausa.reset();
    }

    private void menuCliente (int dni) {
        Cliente cliente = sistema.buscarCliente1(dni);
        int opcion;
        boolean continuar = true;


        do {
            try {
                System.out.println("Menu Opciones de Cliente " + cliente.getNombre());
                System.out.println("1-Realizar reserva/muestra aviones");
                System.out.println("2-Cancelar Vuelo");
                System.out.println("3-Mostrar Historial de Vuelos");
                System.out.println("4-Mostrar Vuelos de Fecha elegida");
                System.out.println("5-Volver al menu anterior");
                opcion = pausa.nextInt();


                switch (opcion) {
                    case 1:
                        menuAltaReserva(dni);
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
                        System.out.println("Solo opciones entre 1 y 5");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("ingrese un numero entero, por favor");
            }catch (Exception e) {
                System.out.println(e.getMessage());
                pausa.nextLine();
            }

        } while (continuar);

    }

    private void menuAltaReserva (int dni) {
        String fecha;
        String origen;
        String destino;
        int pasajeros;
        int idAvion;
        String opcion;
        Cliente cliente = sistema.buscarCliente1(dni);


        try {
            System.out.println("Ingrese fecha de vuelo para reserva");
            fecha  = pausa.next();
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
            sistema.muestraAvionesDisponiblesPorFecha(fecha);
            System.out.println("destino " + destino);
            System.out.println("origen " + origen);
            System.out.println("Elija un avion disponible por nro de ID");
            pausa.reset();
            idAvion = pausa.nextInt();
            Ruta ruta = sistema.buscaRuta(origen, destino);
            Avion avion= sistema.buscaAvion(idAvion);
            System.out.println(avion.getFechasDisponibles());

            Vuelo vuelo= new Vuelo(fecha,ruta,pasajeros,avion);

            if(ruta!= null) {
                if (pasajeros < avion.getCapacidadPasajeros()){
                    sistema.altaVuelo(vuelo);
                    sistema.muestraVuelos();
                } else{
                System.out.println("NO tenemos aviones con esa capacidad de pasajeros");
            }}else{
                System.out.println("La ruta elegida no es correcta");
            }


            System.out.println("Desea confirmar la reserva para este vuelo Si/No? ");
            opcion = scan.nextLine();
            if (opcion.equals("si")) {
                System.out.println("Reserva exitosa");
                sistema.altaReserva(cliente, vuelo);
                System.out.println("---------------");
                sistema.muestraReservas();
                avion.removeFechasDisponibles(fecha);
                avion.setDisponibilidad(false);
                System.out.println(avion.getFechasDisponibles());

            }else{
                System.out.println("Gracias por tu consulta");
            }


            pausa.nextLine();


        } catch (Exception e) {
            System.out.println(e.getMessage());
            pausa.nextLine();
        }
    }

}
