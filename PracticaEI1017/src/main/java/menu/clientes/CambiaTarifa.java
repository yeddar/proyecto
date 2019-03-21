package menu.clientes;

import datos.Cartera;
import datos.clientes.Cliente;
import menu.EjecutaOpcion;
import menu.Utilidades;

import java.util.Scanner;

public class CambiaTarifa implements EjecutaOpcion{
	
	public void ejecuta(Cartera cartera) {
	    Scanner teclado = new Scanner(System.in);
        String nif = Utilidades.pedirNif();
        Cliente cliente = cartera.buscarPorNif(nif);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        System.out.print("Indica la tarifa (eur/min): ");
        double priceSec = teclado.nextDouble();
        cartera.setTarifa(nif, priceSec);
    }
}
