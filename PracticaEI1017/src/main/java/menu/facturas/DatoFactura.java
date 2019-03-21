package menu.facturas;

import datos.Cartera;
import datos.Factura;
import menu.EjecutaOpcion;

import java.util.Scanner;

public class DatoFactura implements EjecutaOpcion{
	
	public void ejecuta (Cartera cartera) {
	    Scanner teclado = new Scanner(System.in);
		System.out.print("Nif del cliente: ");
        String nif = teclado.next();
        if (cartera.buscarPorNif(nif) == null) {
            System.out.println("No existe ningun cliente con este NIF.\n");
        	return;
        }
        System.out.print("Codigo de la factura: ");
        String code = teclado.next();
        Factura factura = cartera.buscarPorNif(nif).getFactura(code);
        if (factura == null) {
            System.out.println("No existe ninguna factura con ese codigo para este cliente.\n");
        	return;
        }
        System.out.println(factura);
	}
}
