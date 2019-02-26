package main;

import datos.Cartera;
import menu.clientes.*;
import menu.llamadas.AltaLlamada;
import menu.llamadas.ListarLlamadas;

import java.util.Scanner;

public class Principal {
    private Cartera cartera = new Cartera();
    private boolean salir = false;

    private void showMenu() {
        System.out.println("0.-Salir.");
        System.out.println("1.-Alta empresa.");
        System.out.println("2.-Alta particular.");
        System.out.println("3.-Buscar por nif.");
        System.out.println("4.-Listar clientes.");
        System.out.println("5.-Cambiar tarifa.");
        System.out.println("6.-Dar de baja un cliente.");
        System.out.println("7.-Listar llamadas.");
        System.out.println("8.-Alta llamada.");
    }


    private void filtrarOpcion(int option, Cartera cartera){
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
            case 0:
                salir = true;
                break;
        }
    }

    private void ejecuta(){
        Scanner entrada = new Scanner(System.in);
        int option;
        do {
            showMenu();
            System.out.print("Introduce una opción: ");
            option = entrada.nextInt();
            filtrarOpcion(option, cartera);

        } while(salir != true);
        entrada.close();

    }

    public static void main(String[] args) {
        new Principal().ejecuta();
    }



}
