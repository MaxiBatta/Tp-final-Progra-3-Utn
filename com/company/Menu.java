package com.company;
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
        System.out.println("1. Reserva de vuelo");
        System.out.println("2. Cancelación de vuelo");
        System.out.println("3. Lista de vuelos");
        System.out.println("4. Lista de clientes");
        System.out.println("5. Salir");
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
                    System.out.println("Seleccionaste opcion 3");
                    pausa.nextLine();
                case 5:
                    salir = true;
                    System.out.println("Gracias por utilizar nuestro servicio");
                    break;
                default:
                    System.out.println("Solo opciones entre 1 y 4");
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
                        menuCliente();
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

    public  void menuCliente () {
        Scanner scan = new Scanner(System.in);
        Scanner pausa = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        do {
            System.out.println("1. Reserva de vuelo");
            System.out.println("2. Menu anterior");
            try {
                System.out.println("Escribe una de las opciones");
                opcion = scan.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado la opcion 1");
                        pausa.nextLine();
                        break;

                    case 2:
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
        int posArray;
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


        } catch (InputMismatchException e) {
            System.out.println("Debe ingresar valores enteros para DNI");
            pausa.nextLine();

        }
    }

}
