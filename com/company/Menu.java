package com.company;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {

    public Menu() {
    }

    public  void muestraMenu (){
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
                    System.out.println("Has seleccionado la opcion 1");
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
                    System.out.println("Solo números entre 1 y 4");
            }
        } catch (InputMismatchException e) {
            System.out.println("Debes insertar un número");
            scan.next();
        }
    } while (!salir);



}



}
