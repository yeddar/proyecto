package menu.llamadas;

import datos.*;
import menu.EjecutaOpcion;
import menu.PedirFecha;

public class AltaLlamada implements EjecutaOpcion{
	
	public void ejecuta(Cartera cartera) {
        CONSOLA.print("Nif del cliente que realiza la llamada: ");
        String nif = TECLADO.next();
        Cliente cliente = cartera.buscarPorNif(nif);
        if(cliente == null) {
            CONSOLA.println("El cliente no existe.");
            return;
        }
        CONSOLA.print("Telefono: ");
        String phone = TECLADO.next();
        CONSOLA.print("Duracion de la llamada (min): ");
        double duration = TECLADO.nextDouble();

        System.out.print("Fecha de realización de la llamada (DD/MM/YYYY): ");
        Fecha date = new PedirFecha().pideFecha();
        cliente.altaLlamada(new Llamada(phone, date, duration));
    }
}
