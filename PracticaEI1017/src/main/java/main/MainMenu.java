package main;

import java.util.Scanner;
import datos.Cartera;
import menu.clientes.*;
import menu.facturas.*;
import menu.llamadas.*;

public class MainMenu {
    private Cartera cartera = new Cartera();
    private boolean salir = false;

    public static void main(String[] args) {
        new MainMenu().ejecuta();
    }

    private void showMenu() {
        System.out.println();
        System.out.println("0.-Salir.");
        System.out.println("1.-Alta empresa.");
        System.out.println("2.-Alta particular.");
        System.out.println("3.-Buscar por nif.");
        System.out.println("4.-Listar clientes.");
        System.out.println("5.-Cambiar tarifa.");
        System.out.println("6.-Dar de baja un cliente.");
        System.out.println("7.-Listar llamadas.");
        System.out.println("8.-Alta llamada.");
        System.out.println("9.-Emitir factura.");
        System.out.println("10.-Listar factura en concreto.");
        System.out.println("11.-Listar todas las facturas.");
        System.out.println("12.-Listar clientes por fecha.");
        System.out.println("13.-Listar llamadas por fecha.");
    }

    private void filtrarOpcion(int option){
        switch(option) {
            case 1:
                new AltaEmpresa().ejecuta(cartera);
                break;
            case 2:
                new AltaParticular().ejecuta(cartera);
                break;
            case 3:
                new BuscarPorNif().ejecuta(cartera);
                break;
            case 4:
                new ListarClientes().ejecuta(cartera);
                break;
            case 5:
                new CambiaTarifa().ejecuta(cartera);
                break;
            case 6:
                new BajaCliente().ejecuta(cartera);
                break;
            case 7:
                new ListarLlamadas().ejecuta(cartera);
                break;
            case 8:
                new AltaLlamada().ejecuta(cartera);
                break;
            case 9:
                new EmiteFactura().ejecuta(cartera);
                break;
            case 10:
                new DatoFactura().ejecuta(cartera);
                break;
            case 11:
                new ListarFacturas().ejecuta(cartera);
                break;
            case 12:
                new ListarClientes().porFecha(cartera);
                break;
            case 13:
                new ListarLlamadas().porFecha(cartera);
                break;
            case 0:
                salir = true;
                break;
            default:
                System.out.println("Esta opcion no es correcta\n");
                break;
        }
    }

    private void ejecuta(){
        Scanner entrada = new Scanner(System.in);
        int option;
        do {
            showMenu();
            System.out.print("Introduce una opcion: ");
            option = entrada.nextInt();
            filtrarOpcion(option);

        } while(salir != true);
        System.out.println("\nHasta luego.");
        entrada.close();
    }
}