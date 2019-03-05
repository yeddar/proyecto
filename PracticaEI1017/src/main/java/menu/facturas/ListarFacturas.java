package menu.facturas;

import java.util.Set;
import datos.Cartera;
import menu.EjecutaOpcion;

public class ListarFacturas implements EjecutaOpcion{

	public void ejecuta (Cartera cartera) {
		CONSOLA.print("Nif del cliente: ");
        String nif = TECLADO.next();
        if (cartera.buscarPorNif(nif) == null) {
        	CONSOLA.println("No existe ningún cliente con este NIF.\n");
        	return;
        }
        Set<String> lista = cartera.buscarPorNif(nif).getListaFacturas().keySet();
        for (String code : lista) {
        	CONSOLA.println(cartera.buscarPorNif(nif).getFactura(code));
        }
	}
}
