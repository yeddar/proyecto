package menu.clientes;

import datos.*;
import datos.clientes.Cliente;
import datos.clientes.Empresa;
import menu.EjecutaOpcion;
import menu.Utilidades;

import java.util.Scanner;

public class AltaEmpresa implements EjecutaOpcion{

	public void ejecuta(Cartera cartera) {
	    Scanner teclado = new Scanner(System.in);
		System.out.print("Nif: ");
        String nif = teclado.next();
        if (cartera.buscarPorNif(nif) != null) {
            System.out.println("Ya existe un cliente con este nif.\n");
        	return;
        }
        System.out.print("Name: ");
        String name = teclado.next();
        System.out.print("Email: ");
        String email = teclado.next();
        System.out.print("Postal Code: ");
        String postalCode = teclado.next();
        System.out.print("Province: ");
        String province = teclado.next();
        System.out.print("City: ");
        String city = teclado.next();
        System.out.print("Fecha de alta (DD/MM/YYYY): ");
        String date = teclado.next();
        Fecha dateConversed = Utilidades.pideFecha(date);
        Cliente cliente = new Empresa(dateConversed,postalCode,province,city,nif,name,email);
        cartera.nuevoCliente(cliente);
    }
	
}
