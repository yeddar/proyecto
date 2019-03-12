package menu.clientes;

import datos.Fecha;
import datos.Cartera;
import datos.clientes.Cliente;
import datos.clientes.Particular;
import menu.EjecutaOpcion;
import menu.Utilidades;

public class AltaParticular implements EjecutaOpcion{

	public void ejecuta(Cartera cartera) {
		CONSOLA.print("Nif: ");
        String nif = TECLADO.next();
        if (cartera.buscarPorNif(nif) != null) {
        	CONSOLA.println("Ya existe un cliente con este nif.\n");
        	return;
        }
		CONSOLA.print("Name: ");
        String name = TECLADO.next();
        CONSOLA.print("Surnames: ");
        String surnames = TECLADO.next();
        CONSOLA.print("Email: ");
        String email = TECLADO.next();
        CONSOLA.print("Postal Code: ");
        String postalCode = TECLADO.next();
        CONSOLA.print("Province: ");
        String province = TECLADO.next();
        CONSOLA.print("City: ");
        String city = TECLADO.next();
        System.out.print("Fecha de alta (DD/MM/YYYY): ");
        Fecha date = Utilidades.pideFecha();

        Cliente cliente = new Particular(date,postalCode,province,city,nif,name,surnames,email);
        cartera.nuevoCliente(cliente);
    }
	
}
