package main;

import java.util.Scanner;
import datos.Cartera;
import datos.factory.clientes.FactoryClientes;
import datos.factory.tarifas.FactoryTarifas;
import menu.*;


public class MainMenu {
    private Cartera cartera = new Cartera();
    public static FactoryClientes factoryClientes =  new FactoryClientes();
    public static FactoryTarifas factoryTarifas = new FactoryTarifas();
    private boolean salir = false;

    // TODO Las excepciones estan implementadas, lo unico que lo hemos dejado "sucio", es decir, que muestra el mensaje de la excepcion en vez de un mensaje personaliado.
    public static void main(String[] args) {
        new MainMenu().ejecuta();
    }

    private void showMenu() {
        System.out.println();
        System.out.println("0) SALIR.");
        System.out.println("1) GESTIÓN CLIENTES.");
        System.out.println("2) GESTIÓN FACTURAS.");
        System.out.println("3) GESTIÓN LLAMADAS");
    }

    private void filtrarOpcion(int option) {
        switch (option) {
            case 1:
                clienteMenu(cartera);
                break;
            case 2:
                facturaMenu(cartera);
                break;
            case 3:
                llamadaMenu(cartera);
                break;
            case 0:
                salir = true;
                break;
            default:
                System.out.println("La opción no es correcta\n");
                break;
        }
    }
    //TODO Habría que reducir código común en los métodos menú.

    public static void facturaMenu(Cartera cartera){
        Scanner entrada = new Scanner(System.in);
        byte option;
        do {
            System.out.println("GESTIÓN FACTURAS");
            System.out.println(OptionsFactura.getMenu());
            System.out.print("Introduce una opción: ");
            option = entrada.nextByte();
            OptionsFactura optionFactura = OptionsFactura.getOption(option);
            optionFactura.ejecuta(cartera);
        } while(option != 0);
    }

    public static void clienteMenu(Cartera cartera){
        Scanner entrada = new Scanner(System.in);
        byte option;
        do {
            System.out.println("GESTIÓN CLIENTES");
            System.out.println(OptionsClients.getMenu());
            System.out.print("Introduce una opción: ");
            option = entrada.nextByte();
            OptionsClients optionClients = OptionsClients.getOption(option);
            optionClients.ejecuta(cartera);
        } while(option != 0);
    }

    public static void llamadaMenu(Cartera cartera){
        Scanner entrada = new Scanner(System.in);
        byte option;
        do {
            System.out.println("GESTIÓN LLAMADAS");
            System.out.println(OptionsLlamada.getMenu());
            System.out.print("Introduce una opción: ");
            option = entrada.nextByte();
            OptionsLlamada optionLlamada = OptionsLlamada.getOption(option);
            optionLlamada.ejecuta(cartera);
        } while(option != 0);
    }

    private void ejecuta(){
        Scanner entrada = new Scanner(System.in);
        byte option;
        new CargarCartera().ejecuta(cartera);
        do {
            System.out.println("MENÚ PRINCIPAL");
            showMenu();
            System.out.print("Introduce una opcion: ");
            option = entrada.nextByte();
            filtrarOpcion(option);

        } while(salir != true);
        System.out.println("\nHasta luego.");
        new GuardarCartera().ejecuta(cartera);
        entrada.close();
    }
}