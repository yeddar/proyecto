package menu.facturas;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import datos.*;
import menu.EjecutaOpcion;
import menu.PedirFecha;

public class EmiteFactura implements EjecutaOpcion{

	public void ejecuta(Cartera cartera) {
		CONSOLA.print("Nif del cliente a realizar la factura: ");
        String nif = TECLADO.next();
        Cliente cliente = cartera.buscarPorNif(nif);
        if(cliente == null){
            CONSOLA.println("El cliente no existe.");
            return;
        } String code;
        while (true){
        	CONSOLA.print("Introduce el codigo para la factura: ");
            code = TECLADO.next();
        	Factura factura = cliente.getFactura(code);
        	if (factura == null)
        		// No hay factura registrada con ese código.
        		break;

        	CONSOLA.println("Ese codigo ya existe para este cliente.");
        }

        double amount = 0;
        Fecha hoy = new Fecha(LocalDate.now());

        // Pide al usuario el intervalo de la factura.
        CONSOLA.print("Fecha de inicio (DD/MM/YYYY): ");
		Fecha diaInicio = new PedirFecha().pideFecha();
        CONSOLA.print("Fecha de parada (DD/MM/YYYY): ");
        Fecha diaParada = new PedirFecha().pideFecha();


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
