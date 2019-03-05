package menu.facturas;

import java.util.Calendar;
import java.util.List;
import datos.Cartera;
import datos.Cliente;
import datos.Factura;
import menu.EjecutaOpcion;
import datos.Llamada;
import datos.Fecha;

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
        		break;
        	CONSOLA.println("Ese codigo ya existe para este cliente.");
        }
        double amount = 0;
        Fecha hoy = new Fecha(Calendar.getInstance());
        CONSOLA.print("Fecha de inicio: ");
        Fecha dia_inicio = createFecha();
        CONSOLA.print("Fecha de parada: ");
        Fecha dia_parada = createFecha();
        List<Llamada> lista = cliente.getLlamadas();
        for (Llamada llamada : lista) {
        	Fecha actual = llamada.getFecha();
        	if (actual.getDia().compareTo(dia_parada.getDia())<=0 && actual.getDia().compareTo(dia_inicio.getDia())>=0){  // Es correcta
        		amount = amount + llamada.getTiempo() * cliente.getTarifa().getPriseSec();
        	}
        } double tarifaUsada = cliente.getTarifa().getPriseSec();
        Factura nuevaFactura = new Factura(code, tarifaUsada, hoy, dia_inicio, dia_parada, amount);
        cliente.altaFactura(code, nuevaFactura);
	}
	
	private Fecha createFecha() {
		 CONSOLA.print("(DIA): ");
	     int dia = TECLADO.nextInt();
	     CONSOLA.print("(MES): ");
	     int mes = TECLADO.nextInt();
		 CONSOLA.print("(ANO): ");
	     int ano = TECLADO.nextInt();
	     return new Fecha(ano,mes,dia);
	}
}
