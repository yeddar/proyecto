package menu.facturas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import datos.*;
import datos.clientes.Cliente;
import menu.EjecutaOpcion;
import menu.Utilidades;

public class ListarFacturas implements EjecutaOpcion{

	public void ejecuta (Cartera cartera) {
        Scanner teclado = new Scanner(System.in);
		String nif = Utilidades.pedirNif();
        if (cartera.buscarPorNif(nif) == null) {
            System.out.println("No existe ningun cliente con este NIF.\n");
        	return;
        }
        Set<String> lista = cartera.buscarPorNif(nif).getListaFacturas().keySet();
        for (String code : lista) {
            System.out.println(cartera.buscarPorNif(nif).getFactura(code));
        }
	}

    public void porFecha(Cartera cartera) {
	    Scanner teclado = new Scanner(System.in);
        System.out.print("Nif del cual se desea obtener las facturas: ");
        String nif = teclado.next();
        Cliente cliente = cartera.buscarPorNif(nif);
        if(cliente == null){
            System.out.println("El cliente no existe.");
            return;
        }
        System.out.print("Fecha inicio (DD/MM/YYYY): ");
        String date = teclado.next();
        Fecha diaInicio = Utilidades.pideFecha(date);
        System.out.print("Fecha fin (DD/MM/YYYY): ");
        date = teclado.next();
        Fecha diaParada = Utilidades.pideFecha(date);

        List<Factura> newList = new ArrayList<>(cliente.getListaFacturas().values());

        newList = new Funcional().filtrar(newList,diaInicio,diaParada);
        if(newList.isEmpty()) {
            System.out.println("No se ha encontrado ningúna factura dentro de ese periodo.");
            return;
        }
        // Hay clientes en la lista.
        for(Factura bill : newList) {
            System.out.println(bill);
        }
    }
}
