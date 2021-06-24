package com.company;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.time.LocalDate;


public final class Menu {
//Codigos de escape ANSI (color)
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";

    Scanner scan = new Scanner(System.in);
    Scanner pausa = new Scanner(System.in);
    AeroTaxi sistema = new AeroTaxi();
    Validacion valida = new Validacion();
    Generica g= new Generica();


    public Menu() {
    }

    public void menuInicio() {
        boolean salir = false;
        int opcion;


        do {
            System.out.println(ANSI_GREEN + "\n\tBIENVENIDOS  A SISTEMA DE AEROTAXI / PANTALLA DE INICIO\n\n"+ ANSI_RESET);
            System.out.println("\n1. Ingreso Cliente");
            System.out.println("\n2. Ingreso Administrador");
            System.out.println("\n3. Salir");
            try {
                System.out.println(ANSI_BLUE + "\nEscribe una de las opciones\n\n" + ANSI_RESET);
                opcion = scan.nextInt();
                switch (opcion) {
                    case 1:
                        menuInicioCliente();
                        pausa.nextLine();
                        break;
                    case 2:
                        menuAdministrador();
                        pausa.nextLine();
                        break;

                    case 3:
                        salir = true;
                        // persistencia de datos
                        sistema.guardarClientes();
                        sistema.guardarRutas();
                        sistema.guardarAviones();

                        System.out.println(ANSI_BLUE + "Gracias por utilizar nuestro servicio" +ANSI_RESET);
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


    public void menuInicioCliente() {
        Scanner scan = new Scanner(System.in);
        Scanner pausa = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        do {
            System.out.println("\n1. Cliente ya registrado\n");
            System.out.println("\n2. Nuevo cliente\n");
            System.out.println("\n3. Menu anterior");

            try {
                System.out.println(ANSI_BLUE + "\nEscribe una de las opciones\n\n" + ANSI_RESET);
                opcion = scan.nextInt();
                switch (opcion) {
                    case 1:
                        //Ingresa al menu del cliente ya registrado
                        menuClienteRegistrado();
                        pausa.nextLine();

                        break;
                    case 2:
                        //Ingresa al menu para registrar un nuevo cliente
                        menuRegistraCliente();
                        pausa.nextLine();

                        break;

                    case 3:
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

//Menu para registrar a un nuevo cliente
    private void menuRegistraCliente() {
        String usuario;
        String password;
        String nombre;
        String apellido;
        String opcion;
        int edad;
        int dni;
        int control;
        int controlDni;



        try {

                pausa.reset();
                do {
                    System.out.println("Ingrese su dni: ");
                    dni = pausa.nextInt();
                    control = valida.validaDni(dni);
                    controlDni = sistema.validaDniExiste(dni);
                    pausa.nextLine();
                }while (control!=0);

                if (controlDni==0) {

                    do {
                        System.out.println("Ingrese su nombre: ");
                        nombre = pausa.nextLine();
                        control = valida.validaNombreApellido(nombre);
                    } while (control != 0);

                    do {
                        System.out.println("Ingrese su apellido: ");
                        apellido = pausa.nextLine();
                        control = valida.validaNombreApellido(apellido);
                    } while (control != 0);

                    do {
                        System.out.println("Ingrese su edad: ");
                        edad = pausa.nextInt();
                        control = valida.validaEdad(edad);
                        pausa.nextLine();
                    } while (control != 0);


                    do {
                        System.out.println("Ingrese un Usuario: ");
                        usuario = pausa.nextLine();
                        control = valida.validaUsuarioPassword(usuario);
                    } while (control != 0);

                    do {
                        System.out.println("Ingrese su password: ");
                        password = pausa.nextLine();
                        control = valida.validaUsuarioPassword(password);
                    } while (control != 0);
                    pausa.nextLine();
                    //menu para confirmar el registro
                    menuConfirmaDatospersonales(nombre, apellido, usuario, password, edad, dni);
                    } else {
                        System.out.println(ANSI_BLUE + "Ingrese como cliente Registrado" + ANSI_RESET);
                    }
                    pausa.reset();
                    pausa.nextLine();

                }
             catch(InputMismatchException e){
                System.out.println("Debes ingresar valores enteros");
            }
            catch(NoSuchElementException e){
                System.out.println("Comando invalido");
            }
        catch(Exception e){
                System.out.println(e.getMessage());

            }
    }
    //Menu para confirmar el registro de un nuevo cliente
    public void menuConfirmaDatospersonales(String nombre,String apellido,String usuario,String password,int edad, int dni) {
        boolean salir = false;
        int opcion;
        do {
            System.out.println("\nDesea confirmar los datos registrados?\n");
            System.out.println(ANSI_GREEN + "\n1. Confirmar" + ANSI_RESET);
            System.out.println(ANSI_RED + "\n2. Salir"+ ANSI_RESET);
            try {

                opcion = scan.nextInt();
                switch (opcion) {
                    case 1:
                        sistema.altaCliente(nombre, apellido, usuario, password, edad, dni);
                        System.out.println(ANSI_GREEN+"Registracion exitosa" +ANSI_RESET);
                        sistema.guardarClientes();
                        sistema.cargarClientes();
                        System.out.println(sistema.buscarCliente1(dni));

                        salir = true;
                        break;
                    case 2:
                        System.out.println(ANSI_RED + "Registracion Cancelada" + ANSI_RESET);
                        salir = true;

                        break;
                    default:
                        System.out.println("Solo opciones entre 1 y 2");
                }

            } catch (InputMismatchException e) {
                System.out.println("Debes ingresar valores enteros");
                scan.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                pausa.nextLine();
            }
        } while (!salir);

    }
// Menu para el cliente que ya se encuentra registrado
    private void menuClienteRegistrado()  {
        int dnii;
        String usuario;
        String password;
        int control;
        int controlDni;

        try{
            pausa.reset();

            do {
                System.out.println("Ingrese su dni");
                dnii = pausa.nextInt();
                control = valida.validaDni(dnii);
                controlDni = sistema.validaDniExiste1(dnii);
             } while(control!=0);
            pausa.nextLine();
            if(controlDni==1) {
                do {
                    System.out.println("Ingrese Usuario:");
                    usuario = pausa.nextLine();
                    control = valida.validaUsuarioPassword(usuario);
                } while (control != 0);

                do {
                    System.out.println("Ingrese Password");
                    password = pausa.nextLine();
                    control = valida.validaUsuarioPassword(password);
                } while (control != 0 );

                Cliente cliente = sistema.buscaCliente(usuario, password, dnii);

                if(cliente!=null) {
                    System.out.println(ANSI_GREEN + "\n\nAcceso exitoso!\n" + ANSI_RESET);
                    //Una vez que corroboro dni, pass y user se ingresa al Menu de Cliente personalizado
                    menuCliente(dnii);
                }else{
                    System.out.println(ANSI_RED + "Usuario o contraseña no valida" + ANSI_RESET);
                }
            }else{
                System.out.println(ANSI_RED + "Usuario no registrado" + ANSI_RESET);
            }

        } catch (InputMismatchException e) {
            System.out.println("Debes ingresar valores enteros");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            pausa.nextLine();
        }
        pausa.reset();
        pausa.nextLine();
    }
// Menu Cliente
    private void menuCliente (int dni) {
        Cliente cliente = sistema.buscarCliente1(dni);
        int opcion;
        boolean continuar = true;
        String rta;
        String fecha;
        int id;

        do {
            try {

                System.out.println(ANSI_BLUE + "\nMenu Opciones de Cliente " + cliente.getNombre() + ANSI_RESET);
                System.out.println("\n1-Realizar reserva");
                System.out.println("\n2-Cancelar reserva");
                System.out.println("\n3-Mis reservas");
                System.out.println("\n4-Volver al menu anterior");
                System.out.println(ANSI_BLUE + "\nEscribe una de las opciones\n" + ANSI_RESET);

                opcion = pausa.nextInt();


                switch (opcion) {
                    case 1:
                        pausa.reset();
                        //Menu para gestionar una reserva
                        menuAltaReserva(dni);

                        break;
                    case 2:

                        if (sistema.validaReservas()) {
                            System.out.println(ANSI_BLUE + "\n\tRESERVAS ACTUALES" + ANSI_RESET);
                            sistema.muestraReservas(dni);
                            System.out.println(ANSI_BLUE + "Ingrese nro de Id de reserva a cancelar / 0 Cero para salir" + ANSI_RESET);
                            id = pausa.nextInt();

                            if (sistema.buscaReserva(id) != null) {
                                Reserva reservaCancela = sistema.buscaReserva(id);
                                System.out.println(reservaCancela);
                                String fechaReserva = reservaCancela.getVuelo().getFecha();
                                LocalDate fechaLd = LocalDate.parse(fechaReserva, DateTimeFormatter.ofPattern("d/MM/y"));
                                LocalDate fechaActual = LocalDate.now();
                                if (fechaLd.minusDays(1).equals(fechaActual)) {
                                    System.out.println(ANSI_RED + "\n\nNo se puede cancelar un vuelo con menos de 24hs de anticipacion\n" + ANSI_RESET);
                                    pausa.nextLine();
                                } else {
                                    menuCancelaReserva(id);
                                    reservaCancela.getVuelo().getAvion().cargaFechaDisponible(reservaCancela.getVuelo().getAvion(), fechaReserva);
                                    sistema.guardarAviones();
                                }
                            } else {
                                System.out.println(ANSI_RED + "El id de reserva ingresado no existe" + ANSI_RESET);
                                pausa.nextLine();
                            }
                            pausa.nextLine();
                        }else{
                            System.out.println(ANSI_BLUE + "No hay reservas para cancelar"+ ANSI_RESET);
                            pausa.nextLine();
                            pausa.nextLine();
                        }
                        break;
                    case 3:
                        if(sistema.validaReservas()) {
                            sistema.muestraReservas(dni);
                            pausa.nextLine();
                        }else {
                            System.out.println(ANSI_BLUE + "No hay reservas"+ ANSI_RESET);
                            pausa.nextLine();
                        }
                        pausa.nextLine();
                        break;
                    case 4:
                        continuar = false;
                        break;
                    default:
                        System.out.println("Solo opciones entre 1 y 4");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes ingresar numeros enteros");
                continuar = false;
            }catch (Exception e) {
                System.out.println(e.getMessage());
                continuar = false;
                pausa.nextLine();
            }

        } while (continuar);
        pausa.nextLine();
    }
// Menu Para gestionar alta de una reserva
    private void menuAltaReserva (int dni) {
        String fecha;
        int pasajeros;
        int idAvion;
        int idRuta;
        String opcion;
        Cliente cliente = sistema.buscarCliente1(dni);

        try {
            pausa.reset();
            System.out.println(ANSI_BLUE + "Ingrese fecha de vuelo para reserva (dd/mm/yyyy)" + ANSI_RESET);
            fecha = pausa.next();
            valida.validaFechaFormato(fecha);
            LocalDate fechaLd = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("d/MM/y"));
            valida.validaFecha(fechaLd);


            System.out.println(ANSI_BLUE + "Ingrese cantidad de acompañantes" +ANSI_RESET);
            pasajeros= pausa.nextInt();
            valida.validaCantAcompañantes(30,pasajeros);
            System.out.println(ANSI_BLUE + "Rutas disponibles" + ANSI_RESET);
            sistema.muestraRutas();
            pausa.nextLine();
            pausa.reset();
            System.out.println(ANSI_BLUE + "Ingrese Id ruta elegida" +ANSI_RESET);
            idRuta= pausa.nextInt();

            //busco la ruta por ID elegido
            Ruta ruta = sistema.buscaRutaId(idRuta);

            System.out.println("\n-----------------------------\n");
            System.out.println(ANSI_BLUE+"Aviones disponibles" +ANSI_RESET);
            System.out.println("\n-----------------------------\n");

            //Muestro los aviones disponibles por fecha y disponibilidad de asientos
            sistema.muestraAvionesDisponiblesPorFecha(fecha, pasajeros);


            System.out.println(ANSI_BLUE+"Elija un avion disponible por nro de ID"+ ANSI_RESET);
            idAvion = pausa.nextInt();
            //busco el avion por ID elegido
            Avion avion= sistema.buscaAvion1(idAvion);

            //Creo el Vuelo para guardar en la reserva
            Vuelo vuelo= new Vuelo(fecha,ruta,pasajeros,avion);

            //Chequeo que el avion tenga disponibilidad de asientos
                if (pasajeros <= avion.getCapacidadPasajeros()){
                    sistema.altaVuelo(vuelo);
                    sistema.guardarVuelos();
                    System.out.println(vuelo);
                } else{
                System.out.println(ANSI_RED+"NO tenemos aviones con esa capacidad de pasajeros" +ANSI_RESET);
            }
            pausa.nextLine();
                //Confirmacion de reserva
            System.out.println(ANSI_BLUE+"Desea confirmar la reserva para este vuelo S/N? " +ANSI_RESET);
            opcion = pausa.nextLine();
            if (opcion.equals("s")) {
                System.out.println(ANSI_GREEN+"Reserva exitosa" +ANSI_RESET);
                Reserva reservaActual = new Reserva(cliente, vuelo, sistema.ultimoIdReservas()+1);
                System.out.println  (reservaActual);
                System.out.println("---------------");
                // se borra la fecha de dsiponibilidad del avion
                avion.removeFechasDisponibles(fecha);

                // Se guardan los datos para persistencia
                sistema.guardarAviones();
                sistema.altaReserva(reservaActual);

                sistema.guardarReservas();
                sistema.cargarReservas();
                sistema.cargarVuelos();
                sistema.cargarAviones();


            }else{
                System.out.println(ANSI_BLUE+ "Gracias por tu consulta" +ANSI_RESET);
            }


            pausa.nextLine();


        } catch (Exception e) {
            System.out.println(e.getMessage());
            pausa.nextLine();
        }
        pausa.reset();
        pausa.nextLine();

    }
// Menu de administrador
    public void menuAdministrador() {
        boolean salir = false;
        int opcion;
        int dni;
        String usuario;
        String password;
        String fecha;
        System.out.println(ANSI_BLUE+ "Ingrese Usuario:" + ANSI_RESET);
        usuario = pausa.next();
        System.out.println(ANSI_BLUE+"Ingrese Password"+ ANSI_RESET);
        password = pausa.next();
        if (usuario.equals("admin") && password.equals("admin")) {
            do {
                pausa.nextLine();
                System.out.println("\n\n1. Listado de Clientes ");
                System.out.println("\n2. Listado de reservas por fecha");
                System.out.println("\n3. Listado de reservas por cliente");
                System.out.println("\n4. Listado completo de reservas");
                System.out.println("\n5. Lista Hash Clientes que tienen Reservas");
                System.out.println("\n6. Lista Generica");
                System.out.println("\n7. Ficha tecnica aviones");
                System.out.println("\n8. Menu anterior");

                try {
                    System.out.println(ANSI_BLUE+ "\nEscribe una de las opciones" + ANSI_RESET);
                    opcion = scan.nextInt();
                    switch (opcion) {
                        case 1:
                            // Se muestra el Array de Clientes
                            sistema.muestraClientes();
                            break;
                        case 2:
                            //Se muestran las reservas filtradas por fecha
                            System.out.println("\nIngrese fecha para buscar reservas programadas/Formato xx/mm/YYYY\n");
                            fecha= pausa.nextLine();

                            valida.validaFechaFormato(fecha);
                            sistema.muestraReservasFecha(fecha);
                            pausa.nextLine();
                            break;
                        case 3:
                            //Se muestran las reservas filtradas por cliente
                            System.out.println(ANSI_BLUE+ "Ingresa dni/cliente"+ANSI_RESET);
                            dni= pausa.nextInt();
                            if(sistema.validaReservaDni(dni)==1) {
                                sistema.muestraReservas(dni);
                                pausa.nextLine();
                            }else {
                                System.out.println(ANSI_BLUE + "No hay reservas"+ ANSI_RESET);
                                pausa.nextLine();
                            }
                            pausa.nextLine();


                            break;
                        case 4:
                            //Se muestran todas las reservas
                            if(sistema.validaReservas()) {
                                sistema.muestraReservas();
                            }else {
                                System.out.println(ANSI_BLUE + "No hay reservas"+ ANSI_RESET);
                                pausa.nextLine();
                            }
                            pausa.nextLine();
                            break;
                        case 5:
                            sistema.recorreArrayyPasaaListhash();
                            sistema.muestraListaHash();
                            pausa.nextLine();
                            break;

                        case 6:
                            Gold avg2= new Gold(15000, 280, 20, 500, Propulsion.Reaccion,true,6000,"Premium", false, "GOLD");
                            Silver avs1= new Silver(9000, 250,20,500,Propulsion.Pistones,true,4000,"Basico", "SILVER");
                            Bronze avb1= new Bronze(9000, 180, 30, 400, Propulsion.Helice,true,3000, "BRONZE");
                            g.agregarElemento(avg2);
                            g.agregarElemento(avs1);
                            g.agregarElemento(avb1);

                            g.recorreArrayyPasaaListaGenerica(sistema.getClientes());
                            g.recorreArrayyPasaaListaGenerica(sistema.getRutas());
                            g.recorreArrayyPasaaListaGenerica( sistema.getVuelos());
                            g.recorreArrayyPasaaListaGenerica(sistema.getReservas());

                            g.cargarListaGen();
                            menuClaseGenerica();
                           pausa.nextLine();
                            break;
                        case 7:
                            // Interfaz forzada para mostrar como se implementa
                            Gold avionGold = new Gold();
                            Silver avionSilver = new Silver();
                            Bronze avionBronze = new Bronze();
                            avionGold.serviceAvion();
                            avionSilver.serviceAvion();
                            avionBronze.serviceAvion();
                            pausa.nextLine();

                            break;
                        case 8:
                            salir = true;
                            System.out.println("Enter para volver a menu anterior");

                            break;
                        default:
                            System.out.println("Solo opciones entre 1 y 8");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Debes ingresar valores enteros");

                } catch (Exception e) {
                    System.out.println(e.getMessage());

                }
            } while (!salir);
        }else
        {
            System.out.println(ANSI_RED + "Usuario y/o password no validos"+ANSI_RESET);
        }
        pausa.nextLine();
    }
// Menu para Confirmar la baja de una Reserva
    public void menuCancelaReserva(int id) {
        boolean salir = false;
        int opcion;
        do {
            System.out.println("\nDesea confirmar la baja de la reserva?\n");
            System.out.println(ANSI_GREEN+ "1. Confirmar"+ANSI_RESET);
            System.out.println(ANSI_RED+ "2. Volver a menu anterior"+ANSI_RESET);
            try {

                opcion = scan.nextInt();
                switch (opcion) {
                    case 1:
                        sistema.bajaReserva(id);
                        System.out.println(ANSI_BLUE+"La reserva se ha cancelado con exito"+ANSI_RESET);
                        sistema.guardarReservas();
                        sistema.cargarReservas();
                        pausa.nextLine();
                        salir = true;
                        break;
                        case 2:
                        salir = true;

                        break;
                    default:
                        System.out.println("Solo opciones entre 1 y 2");
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

    public void menuClaseGenerica() {
        Scanner scan = new Scanner(System.in);
        Scanner pausa = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        do {
            System.out.println("\n1. Filtrar por Clientes\n");
            System.out.println("\n2. Filtrar por Aviones\n");
            System.out.println("\n3. Filtrar por Rutas\n");
            System.out.println("\n4. Filtrar por Vuelos\n");
            System.out.println("\n5. Filtrar por Reservas\n");
            System.out.println("\n6. Menu anterior");

            try {
                System.out.println(ANSI_BLUE + "\nEscribe una de las opciones\n\n" + ANSI_RESET);
                opcion = scan.nextInt();
                switch (opcion) {
                    case 1:
                        g.muestraListaC();
                        pausa.nextLine();

                        break;
                    case 2:
                        g.muestraLista();
                        pausa.nextLine();

                        break;

                    case 3:
                        g.muestraListaR();
                        pausa.nextLine();

                        break;
                    case 4:
                        g.muestraListaV();
                        pausa.nextLine();

                        break;
                    case 5:
                        g.muestraListaRe();
                        pausa.nextLine();

                        break;

                    case 6:
                        g.cargarListaGen();
                        salir = true;

                        break;
                    default:
                        System.out.println("Solo opciones entre 1 y 6");
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


}
