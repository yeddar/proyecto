package menu.facturas;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import datos.*;
import datos.clientes.Cliente;
import menu.EjecutaOpcion;
import menu.Utilidades;

public class EmiteFactura implements EjecutaOpcion{

	public void ejecuta(Cartera cartera) {
	    Scanner teclado = new Scanner(System.in);
		System.out.print("Nif del cliente a realizar la factura: ");
        String nif = teclado.next();
        Cliente cliente = cartera.buscarPorNif(nif);
        if(cliente == null){
            System.out.println("El cliente no existe.");
            return;
        } String code;
        while (true){
            System.out.print("Introduce el codigo para la factura: ");
            code = teclado.next();
        	Factura factura = cliente.getFactura(code);
        	if (factura == null)
        		// No hay factura registrada con ese código.
        		break;

            System.out.println("Ese codigo ya existe para este cliente.");
        }

        double amount = 0;
        Fecha hoy = new Fecha(LocalDate.now());

        // Pide al usuario el intervalo de la factura.
        System.out.print("Fecha de inicio (DD/MM/YYYY): ");
        String date = teclado.next();
		Fecha diaInicio = Utilidades.pideFecha(date);
        System.out.print("Fecha de parada (DD/MM/YYYY): ");
        date = teclado.next();
        Fecha diaParada = Utilidades.pideFecha(date);


        List<Llamada> lista = cliente.getLlamadas();
        for (Llamada llamada : lista) {
        	Fecha actual = llamada.getFecha();
        	if (actual.insideOf(diaInicio,diaParada)){  // Es correcta
        		amount = amount + llamada.getTiempo() * cliente.getTarifa().getPriseSec();
        	}
        } double tarifaUsada = cliente.getTarifa().getPriseSec();
        Factura nuevaFactura = new Factura(code, tarifaUsada, hoy, diaInicio, diaParada, amount);
        cliente.altaFactura(code, nuevaFactura);
	}
}
