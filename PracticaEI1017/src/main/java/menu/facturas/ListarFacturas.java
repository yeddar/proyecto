package menu.facturas;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import datos.*;
import menu.EjecutaOpcion;
import menu.PedirFecha;

public class ListarFacturas implements EjecutaOpcion{

	public void ejecuta (Cartera cartera) {
		CONSOLA.print("Nif del cliente: ");
        String nif = TECLADO.next();
        if (cartera.buscarPorNif(nif) == null) {
        	CONSOLA.println("No existe ningun cliente con este NIF.\n");
        	return;
        }
        Set<String> lista = cartera.buscarPorNif(nif).getListaFacturas().keySet();
        for (String code : lista) {
        	CONSOLA.println(cartera.buscarPorNif(nif).getFactura(code));
        }
	}

    public void porFecha(Cartera cartera) {
        CONSOLA.print("Nif del cual se desea obtener las facturas: ");
        String nif = TECLADO.next();
        Cliente cliente = cartera.buscarPorNif(nif);
        if(cliente == null){
            CONSOLA.println("El cliente no existe.");
            return;
        }
        CONSOLA.print("Fecha inicio (DD/MM/YYYY): ");
        Fecha diaInicio = new PedirFecha().pideFecha();
        CONSOLA.print("Fecha fin (DD/MM/YYYY): ");
        Fecha diaParada = new PedirFecha().pideFecha();

        List<Factura> newList = new ArrayList<>(cliente.getListaFacturas().values());

        newList = new Funcional().filtrar(newList,diaInicio,diaParada);
        if(newList.isEmpty()) {
            CONSOLA.println("No se ha encontrado ningúna factura dentro de ese periodo.");
            return;
        }
        // Hay clientes en la lista.
        for(Factura bill : newList) {
            CONSOLA.println(bill);
        }
    }
}
