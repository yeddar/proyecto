package menu.llamadas;

import datos.Cartera;
import datos.Cliente;
import datos.Fecha;
import datos.Llamada;
import menu.EjecutaOpcion;

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
        CONSOLA.print("Fecha de realizacion (DIA): ");
        int cal_day = TECLADO.nextInt();
        CONSOLA.print("(MES): ");
        int cal_month = TECLADO.nextInt();
        CONSOLA.print("(ANO): ");
        int cal_year = TECLADO.nextInt();
        Fecha cal = new Fecha(cal_year, cal_month, cal_day);
        cliente.altaLlamada(new Llamada(phone,cal,duration));
    }
}
