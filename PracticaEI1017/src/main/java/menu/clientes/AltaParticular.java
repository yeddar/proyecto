package menu.clientes;

import datos.Cartera;
import datos.Cliente;
import datos.Fecha;
import datos.Particular;
import menu.EjecutaOpcion;

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
        CONSOLA.print("Dia de alta (DIA): ");
        int cal_day = TECLADO.nextInt();
        CONSOLA.print("(MES): ");
        int cal_month = TECLADO.nextInt();
        CONSOLA.print("(AÑO): ");
        int cal_year = TECLADO.nextInt();
        Fecha cal = new Fecha(cal_year, cal_month, cal_day);
        Cliente cliente = new Particular(cal,postalCode,province,city,nif,name,surnames,email);
        cartera.nuevoCliente(cliente);
    }
	
}
