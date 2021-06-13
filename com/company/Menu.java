package com.company;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {
    Scanner scan = new Scanner(System.in);
    Scanner pausa = new Scanner(System.in);
    Aerotaxi sistema = new Aerotaxi();
    Validacion valida = new Validacion();

    public Menu() {
    }

    public void menuInicio() {
        boolean salir = false;
        int opcion;


        do {
            System.out.println("1. Ingreso Cliente");
            System.out.println("2. Ingreso Administrador");
            System.out.println("3. Salir");
            try {
                System.out.println("Escribe una de las opciones");
                opcion = scan.nextInt();
                switch (opcion) {
                    case 1:
                        menuReserva();
                        pausa.nextLine();
                        break;
                    case 2:
                        menuAdministrador();
                        pausa.nextLine();
                        break;

                    case 3:
                        salir = true;

                        sistema.guardarClientes();
                        sistema.guardarRutas();



                        System.out.println("Gracias por utilizar nuestro servicio");
                        break;
                    default:
                        System.out.println("Solo opciones entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes ingresar valores enteros");
                scan.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                pausa.nextLine();
            }
        } while (!salir);
        pausa.nextLine();
    }


    public void menuReserva() {
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


                        break;
                    case 2:
                        menuRegistraCliente();



                        break;

                    case 3:
                        System.out.println("enter para volver a menu anterior");
                        pausa.nextLine();
                        salir = true;

                        break;
                    default:
                        System.out.println("Solo opciones entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes ingresar valores enteros");
                scan.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                pausa.nextLine();
            }
        } while (!salir);
        pausa.nextLine();
    }


    private void menuRegistraCliente() {
        String usuario;
        String password;
        String nombre;
        String apellido;
        String opcion;
        int edad;
        int dni;

        do{

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
                    sistema.altaCliente(nombre, apellido, usuario, password, edad, dni);
                    System.out.println("Registracion exitosa");
                    sistema.muestraClientes();
                } else {
                    System.out.println("Este DNI ya se encuentra registrado en el sistema");
                }
                pausa.reset();
                pausa.nextLine();

            } catch(InputMismatchException e){
                System.out.println("Debes ingresar valores enteros");
            }
        catch(Exception e){
                System.out.println(e.getMessage());

            }

        System.out.println("Desea salir del menu de registracion? s/n");
        opcion = pausa.nextLine();
    } while(!(opcion.equals("s")));

    }
    private void menuClienteRegistrado()  {
        int dnii;
        String usuario;
        String password;
        try {
            pausa.reset();
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



        } catch (InputMismatchException e) {
            System.out.println("Debes ingresar valores enteros");
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
                System.out.println("1-Realizar reserva");
                System.out.println("2-Cancelar reserva");
                System.out.println("3-Mis reservas por fecha");
                System.out.println("4-Mis reservas");
                System.out.println("5-Volver al menu anterior");
                opcion = pausa.nextInt();


                switch (opcion) {
                    case 1:
                        pausa.reset();
                        menuAltaReserva(dni);

                        break;
                    case 2:

                        break;
                    case 3:

                        break;

                    case 4:

                        break;
                    case 5:
                        System.out.println("enter para volver a menu anterior");
                        pausa.nextLine();
                        continuar = false;
                        break;
                    default:
                        System.out.println("Solo opciones entre 1 y 5");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes ingresar numeros enteros");
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
        int idRuta;
        String opcion;
        Cliente cliente = sistema.buscarCliente1(dni);

        sistema.cargarReservas();
        sistema.guardarVuelos();
        try {
            System.out.println("Ingrese fecha de vuelo para reserva (dd/mm/yyyy)");
            fecha  = pausa.next();
            valida.validaFechaFormato(fecha);
            LocalDate fechaLd= LocalDate.parse(fecha,DateTimeFormatter.ofPattern("d/MM/y"));
            valida.validaFecha(fechaLd);
            System.out.println("Ingrese cantidad de acompañantes");
            pasajeros= pausa.nextInt();
            valida.validaCantAcompañantes(sistema.getAviones(),pasajeros);
            System.out.println("Rutas disponibles");
            sistema.muestraRutas();
            pausa.nextLine();
            pausa.reset();
            System.out.println("Ingrese Id ruta elegida");
            idRuta= pausa.nextInt();

            /*System.out.println("Ingrese Ciudad de origen");
            origen = pausa.nextLine();
            pausa.reset();
            System.out.println("Ingrese Ciudad de destino");
            destino = pausa.nextLine();
            pausa.reset();
            valida.validaOrigenDestino(origen, destino);
            */
            Ruta ruta = sistema.buscaRutaId(idRuta);
            System.out.println(ruta);
            System.out.println("\n-----------------------------\n");
            System.out.println("Aviones disponibles");
            System.out.println("\n-----------------------------");

            sistema.muestraAvionesDisponiblesPorFecha(fecha);
            pausa.reset();
            //System.out.println("destino " + destino);
            //System.out.println("origen " + origen);
            System.out.println("Elija un avion disponible por nro de ID");
            idAvion = pausa.nextInt();
            Avion avion= sistema.buscaAvion1(idAvion);
            System.out.println(avion.getFechasDisponibles());
            Vuelo vuelo= new Vuelo(fecha,ruta,pasajeros,avion);


                if (pasajeros < avion.getCapacidadPasajeros()){
                    sistema.altaVuelo(vuelo);
                    System.out.println(vuelo);
                } else{
                System.out.println("NO tenemos aviones con esa capacidad de pasajeros");
            }

            pausa.nextLine();
            System.out.println("Desea confirmar la reserva para este vuelo S/N? ");
            opcion = pausa.nextLine();
            if (opcion.equals("s")) {
                System.out.println("Reserva exitosa");
                Reserva reservaActual = new Reserva(cliente, vuelo);
                System.out.println  (reservaActual);
                System.out.println("---------------");

                avion.removeFechasDisponibles(fecha);
                System.out.println(avion.getFechasDisponibles());
                sistema.altaReserva(cliente, vuelo);
                sistema.guardarVuelos();
                sistema.guardarReservas();


            }else{
                System.out.println("Gracias por tu consulta");
            }


            pausa.nextLine();


        } catch (Exception e) {
            System.out.println(e.getMessage());
            pausa.nextLine();
        }
        pausa.reset();

    }

    public void menuAdministrador() {
        boolean salir = false;
        int opcion;
        int dni;
        String usuario;
        String password;
        System.out.println("Ingrese Usuario:");
        usuario = pausa.next();
        System.out.println("Ingrese Password");
        password = pausa.next();
        if (usuario.equals("admin") && password.equals("admin")) {
            do {
                pausa.nextLine();
                System.out.println("1. Listado de Clientes ");
                System.out.println("2. Listado de reservas por fecha");
                System.out.println("3. Listado de reservas por cliente");
                System.out.println("4. Listado completo de reservas");

                System.out.println("5. Menu anterior");

                try {
                    System.out.println("Escribe una de las opciones");
                    opcion = scan.nextInt();
                    switch (opcion) {
                        case 1:
                            sistema.muestraClientes();


                            break;
                        case 2:
                            System.out.println("mostrar reservas por fecha");

                            break;
                        case 3:
                            System.out.println("Ingresa dni/cliente");
                            dni= pausa.nextInt();
                            sistema.muestraReservas(dni);
                            pausa.nextLine();


                            break;
                        case 4:

                            sistema.muestraReservas();


                            break;
                        case 5:
                            salir = true;
                            System.out.println("Enter para volver a menu anterior");

                            break;
                        default:
                            System.out.println("Solo opciones entre 1 y 5");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Debes ingresar valores enteros");

                } catch (Exception e) {
                    System.out.println(e.getMessage());

                }
            } while (!salir);
        }else
        {
            System.out.println("Usuario y/o password no validos");
        }
        pausa.nextLine();
    }


    public void espaciador(){
    for(int i=0; i<5;i++){
        System.out.println("\n");
    }
}

}
