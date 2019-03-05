package menu.clientes;

import datos.Cartera;
import datos.Cliente;
import menu.EjecutaOpcion;

public class CambiaTarifa implements EjecutaOpcion{
	
	public void ejecuta(Cartera cartera) {
        CONSOLA.print("Nif a cambiar tarifa: ");
        String nif = TECLADO.next();
        Cliente cliente = cartera.buscarPorNif(nif);
        if (cliente == null) {
            CONSOLA.println("Cliente no encontrado.");
            return;
        }
        CONSOLA.print("Indica la tarifa (€/min): ");
        double priceSec = TECLADO.nextDouble();
        cartera.setTarifa(nif, priceSec);
    }
}
