package menu.clientes;

import datos.*;
import datos.clientes.Cliente;
import datos.clientes.Empresa;
import menu.EjecutaOpcion;
import menu.Utilidades;

public class AltaEmpresa implements EjecutaOpcion{

	public void ejecuta(Cartera cartera) {
		CONSOLA.print("Nif: ");
        String nif = TECLADO.next();
        if (cartera.buscarPorNif(nif) != null) {
        	CONSOLA.println("Ya existe un cliente con este nif.\n");
        	return;
        }
		CONSOLA.print("Name: ");
        String name = TECLADO.next();
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
        Cliente cliente = new Empresa(date,postalCode,province,city,nif,name,email);
        cartera.nuevoCliente(cliente);
    }
	
}
