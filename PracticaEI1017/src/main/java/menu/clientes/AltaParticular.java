package menu.clientes;

import datos.Fecha;
import datos.Cartera;
import datos.clientes.Cliente;
import datos.clientes.Particular;
import menu.EjecutaOpcion;
import menu.Utilidades;

import java.util.Scanner;

public class AltaParticular implements EjecutaOpcion{

	public void ejecuta(Cartera cartera) {
	    Scanner teclado = new Scanner(System.in);
        String nif = Utilidades.pedirNif();
        if (cartera.buscarPorNif(nif) != null) {
            System.out.println("Ya existe un cliente con este nif.\n");
        	return;
        }
        System.out.print("Name: ");
        String name = teclado.next();
        System.out.print("Surnames: ");
        String surnames = teclado.next();
        System.out.print("Email: ");
        String email = teclado.next();
        System.out.print("Postal Code: ");
        String postalCode = teclado.next();
        System.out.print("Province: ");
        String province = teclado.next();
        System.out.print("City: ");
        String city = teclado.next();
        System.out.print("Fecha de alta (DD/MM/YYYY): ");
        String fecha = teclado.next();
        Fecha dateConversed = Utilidades.pideFecha(fecha);

        Cliente cliente = new Particular(dateConversed,postalCode,province,city,nif,name,surnames,email);
        cartera.nuevoCliente(cliente);
    }
	
}
