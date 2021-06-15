package com.company;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;


public class Menu {
    Scanner scan = new Scanner(System.in);
    Scanner pausa = new Scanner(System.in);
    AeroTaxi sistema = new AeroTaxi();
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
                        sistema.guardarAviones();








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
                        pausa.nextLine();

                        break;
                    case 2:
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
                pausa.nextLine();
                System.out.println("Ingrese un Usuario: ");
                usuario = pausa.nextLine();
                valida.validaLetrasYnumeros(usuario);
                System.out.println("Ingrese su password: ");
                password = pausa.nextLine();
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

        System.out.println("Sus datos son correctos? s/n");
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
            usuario = pausa.nextLine();
            System.out.println("Ingrese Password");
            password = pausa.nextLine();
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
        pausa.nextLine();
    }

    private void menuCliente (int dni) {
        Cliente cliente = sistema.buscarCliente1(dni);
        int opcion;
        boolean continuar = true;
        String rta;
        int id;



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
                        System.out.println("Ingrese nro de Id de reserva a cancelar");
                        id= pausa.nextInt();

                        if (sistema.buscaReserva(id) != null) {
                            Reserva reservaCancela = sistema.buscaReserva(id);
                            System.out.println(reservaCancela);
                            String fechaReserva= reservaCancela.getVuelo().getFecha();
                            LocalDate fechaLd= LocalDate.parse(fechaReserva,DateTimeFormatter.ofPattern("d/MM/y"));
                            LocalDate fechaActual= LocalDate.now();
                            if (fechaLd.minusDays(1).equals(fechaActual)){
                                System.out.println("\n\nNo se puede cancelar un vuelo con menos de 24hs de anticipacion\n");
                                pausa.nextLine();
                                }else{
                                menuCancelaReserva(id);
                                reservaCancela.getVuelo().getAvion().cargaFechaDisponible(reservaCancela.getVuelo().getAvion(),fechaReserva);
                                sistema.guardarAviones();
                                }
                        }else {
                            System.out.println("El id de reserva ingresado no existe");
                            pausa.nextLine();
                        }
                        pausa.nextLine();
                        break;
                    case 3:
                        System.out.println("p");
                        break;

                    case 4:
                        if(sistema.validaReservas()) {
                            sistema.muestraReservas(dni);
                            pausa.nextLine();
                        }else {
                            System.out.println("No hay reservas");
                            pausa.nextLine();
                        }
                        pausa.nextLine();
                        break;
                    case 5:
                        System.out.println("enter para volver a menu anterior");

                        continuar = false;
                        break;
                    default:
                        System.out.println("Solo opciones entre 1 y 5");
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

    private void menuAltaReserva (int dni) {
        String fecha;
        String origen;
        String destino;
        int pasajeros;
        int idAvion;
        int idRuta;
        String opcion;
        Cliente cliente = sistema.buscarCliente1(dni);


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

            Ruta ruta = sistema.buscaRutaId(idRuta);
            System.out.println(ruta);
            System.out.println("\n-----------------------------\n");
            System.out.println("Aviones disponibles");

            System.out.println("\n-----------------------------\n");

            sistema.muestraAvionesDisponiblesPorFecha(fecha);


            System.out.println("Elija un avion disponible por nro de ID");
            idAvion = pausa.nextInt();
            Avion avion= sistema.buscaAvion1(idAvion);
            avion.muestraFechasDisponibles();

            Vuelo vuelo= new Vuelo(fecha,ruta,pasajeros,avion);


                if (pasajeros < avion.getCapacidadPasajeros()){
                    sistema.altaVuelo(vuelo);
                    sistema.guardarVuelos();
                    System.out.println(vuelo);
                } else{
                System.out.println("NO tenemos aviones con esa capacidad de pasajeros");
            }

            pausa.nextLine();
            System.out.println("Desea confirmar la reserva para este vuelo S/N? ");
            opcion = pausa.nextLine();
            if (opcion.equals("s")) {
                System.out.println("Reserva exitosa");
                Reserva reservaActual = new Reserva(cliente, vuelo, sistema.ultimoIdReservas()+1);
                System.out.println  (reservaActual);
                System.out.println("---------------");

                avion.removeFechasDisponibles(fecha);
                System.out.println(avion.getFechasDisponibles());
                sistema.guardarAviones();
                sistema.altaReserva(reservaActual);

                sistema.guardarReservas();
                sistema.cargarReservas();
                sistema.cargarVuelos();
                sistema.cargarAviones();


            }else{
                System.out.println("Gracias por tu consulta");
            }


            pausa.nextLine();


        } catch (Exception e) {
            System.out.println(e.getMessage());
            pausa.nextLine();
        }
        pausa.reset();
        pausa.nextLine();

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

                System.out.println("5. Ficha tecnica aviones");



                System.out.println("6. Menu anterior");

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

                            Gold avionGold = new Gold();
                            Silver avionSilver = new Silver();
                            Bronze avionBronze = new Bronze();
                            avionGold.serviceAvion();
                            avionSilver.serviceAvion();
                            avionBronze.serviceAvion();
                            pausa.nextLine();




                            break;
                        case 6:
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

    public void menuCancelaReserva(int id) {
        boolean salir = false;
        int opcion;
        do {
            System.out.println("\nDesea confirmar la baja de la reserva?\n");
            System.out.println("1. Confirmar");
            System.out.println("2. Volver a menu anterior");
            try {

                opcion = scan.nextInt();
                switch (opcion) {
                    case 1:
                        sistema.bajaReserva(id);
                        System.out.println("La reserva se ha cancelado con exito");
                        sistema.guardarReservas();
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


    public void espaciador(){
    for(int i=0; i<5;i++){
        System.out.println("\n");
    }
}

}
