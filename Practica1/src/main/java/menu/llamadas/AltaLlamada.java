package menu.llamadas;

import datos.Cartera;
import datos.Cliente;
import datos.Llamada;
import menu.EjecutaOpcion;
import java.util.GregorianCalendar;

import java.util.Calendar;

public class AltaLlamada implements EjecutaOpcion {

    public void ejecuta(Cartera cartera) {
        CONSOLA.print("Nif del cliente que realiza la llamada: ");
        String nif = TECLADO.next();
        Cliente cliente = cartera.buscarPorNif(nif);
        if(cliente == null) {
            CONSOLA.println("El cliente no existe.");
            return;
        }
        CONSOLA.print("Teléfono: ");
        String phone = TECLADO.next();
        CONSOLA.print("Duración de la llamada: ");
        long duration = TECLADO.nextLong();
        Calendar today = GregorianCalendar.getInstance();

        cliente.altaLlamada(new Llamada(phone,today,duration));



    }
}
