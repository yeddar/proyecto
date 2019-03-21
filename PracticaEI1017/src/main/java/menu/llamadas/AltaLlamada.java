package menu.llamadas;

import datos.*;
import datos.clientes.Cliente;
import menu.EjecutaOpcion;
import menu.Utilidades;

import java.util.Scanner;

public class AltaLlamada implements EjecutaOpcion{
	
	public void ejecuta(Cartera cartera) {
	    Scanner teclado = new Scanner(System.in);
        System.out.print("Nif del cliente que realiza la llamada: ");
        String nif = teclado.next();
        Cliente cliente = cartera.buscarPorNif(nif);
        if(cliente == null) {
            System.out.println("El cliente no existe.");
            return;
        }
        System.out.print("Telefono: ");
        String phone = teclado.next();
        System.out.print("Duracion de la llamada (min): ");
        double duration = teclado.nextDouble();

        System.out.print("Fecha de realización de la llamada (DD/MM/YYYY): ");
        String date = teclado.next();
        Fecha dateConversed = Utilidades.pideFecha(date);
        cliente.altaLlamada(new Llamada(phone, dateConversed, duration));
    }
}
