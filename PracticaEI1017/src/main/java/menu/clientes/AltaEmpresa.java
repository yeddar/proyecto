package menu.clientes;

import datos.Cartera;
import datos.Cliente;
import datos.Empresa;
import datos.Fecha;
import menu.EjecutaOpcion;

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
        CONSOLA.print("Dia de alta (DIA): ");
        int cal_day = TECLADO.nextInt();
        CONSOLA.print("(MES): ");
        int cal_month = TECLADO.nextInt();
        CONSOLA.print("(AÑO): ");
        int cal_year = TECLADO.nextInt();
        Fecha cal = new Fecha(cal_year, cal_month, cal_day);
        Cliente cliente = new Empresa(cal,postalCode,province,city,nif,name,email);
        cartera.nuevoCliente(cliente);
    }
	
}
