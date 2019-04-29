package menu.facturas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import datos.*;
import datos.clientes.Cliente;
import exceptions.ClienteNoExiste;
import exceptions.FacturaNoExiste;
import exceptions.FechaInvalida;
import menu.EjecutaOpcion;
import menu.Utilidades;

public class EmiteFactura implements EjecutaOpcion{

	public void ejecuta(Cartera cartera) {
        String nif = Utilidades.pedirNif();
        try {
            Utilidades.clienteExiste(cartera, nif);
        } catch (ClienteNoExiste e) {
            e.printStackTrace();
            return;
        }
        String code = Utilidades.pedirCodigo();
        try {
            Utilidades.facturaExisteEmitir(cartera, nif, code);
        } catch (FacturaNoExiste e) {
            e.printStackTrace();
            return;
        }
        double amount = 0;
        Fecha hoy = new Fecha(LocalDate.now(),LocalTime.now());
        Fecha diaInicio;
        Fecha diaParada;
        try {
            Fecha[] fechas = Utilidades.pedirFechas();
            diaInicio = fechas[0];
            diaParada = fechas[1];
        } catch (FechaInvalida e){
            e.printStackTrace();
            return;
        }
        Cliente cliente = cartera.buscarPorNif(nif);
        List<Llamada> list = cliente.getLlamadas();

        for (Llamada llamada : list) {
        	Fecha fecha = llamada.getFecha();
        	if (fecha.insideOfDate(diaInicio,diaParada)){  // Es correcta
        		amount = amount + llamada.getDuracion() * cliente.getTarifa().getPrice(llamada);
        	}
        }
        Factura nuevaFactura = new Factura(code, hoy, diaInicio, diaParada, amount);
        // TODO ¿En factura, tambien se debería mover el metodo de anadir la factura?
        cliente.altaFactura(code, nuevaFactura);
	}
}
