package main;

import datos.Cartera;
import datos.Empresa;
import menu.clientes.AltaEmpresa;
import menu.clientes.AltaParticular;
import menu.clientes.BuscarPorNif;

import java.util.Scanner;

public class Principal {


    private static void filtrarOpcion(int option, Cartera cartera) {
        switch(option) {
            case 0:
                break;
            case 1:
                new AltaEmpresa().ejecuta(cartera);
                break;
            case 2:
                new AltaParticular().ejecuta(cartera);
                break;
            case 3:
                new BuscarPorNif().ejecuta(cartera);
            case 4:
                cartera.listarClientes();
        }
    }

    public static void main(String[] args){
        Cartera cartera = new Cartera();
        Scanner entrada = new Scanner(System.in);
        int option;
        do {
            System.out.println("0-Salir");
            System.out.println("1-Alta empresa");
            System.out.println("2-Alta particular");
            System.out.println("3-Buscar por nif");
            System.out.println("4- Listar clientes");
            System.out.print("Introduce una opción: ");
            option = entrada.nextInt();
            filtrarOpcion(option, cartera);

        } while(option != 0);


    }

}
