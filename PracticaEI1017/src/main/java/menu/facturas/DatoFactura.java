package menu.facturas;

import datos.Cartera;
import datos.Factura;
import menu.EjecutaOpcion;

public class DatoFactura implements EjecutaOpcion{
	
	public void ejecuta (Cartera cartera) {
		CONSOLA.print("Nif del cliente: ");
        String nif = TECLADO.next();
        if (cartera.buscarPorNif(nif) == null) {
        	CONSOLA.println("No existe ningún cliente con este NIF.\n");
        	return;
        }
        CONSOLA.print("Código de la factura: ");
        String code = TECLADO.next();
        Factura factura = cartera.buscarPorNif(nif).getFactura(code);
        if (factura == null) {
        	CONSOLA.println("No existe ninguna factura con ese código para este cliente.\n");
        	return;
        }
        CONSOLA.println(factura);
	}
}
