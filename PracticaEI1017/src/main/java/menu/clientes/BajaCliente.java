package menu.clientes;

import datos.Cartera;
import menu.EjecutaOpcion;

public class BajaCliente implements EjecutaOpcion{
	
	public void ejecuta(Cartera cartera){
        CONSOLA.print("Introduce el nif a borrar: ");
        String nif = TECLADO.next();

        if(cartera.buscarPorNif(nif) == null){
            CONSOLA.println("El cliente no existe.");
            return;
        }
        cartera.eliminaCliente(nif);
    }
	
}
