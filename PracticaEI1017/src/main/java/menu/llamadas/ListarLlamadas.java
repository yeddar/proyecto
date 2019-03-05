package menu.llamadas;

import datos.Cartera;
import datos.Cliente;
import datos.Llamada;
import menu.EjecutaOpcion;
import java.util.List;

public class ListarLlamadas implements EjecutaOpcion{
	
	public void ejecuta(Cartera cartera){
        CONSOLA.print("Nif del cual se desea obtener las llamadas: ");
        String nif = TECLADO.next();
        Cliente cliente = cartera.buscarPorNif(nif);
        if(cliente == null){
            CONSOLA.println("El cliente no existe.");
            return;
        }
        List<Llamada> llamadas = cliente.getLlamadas();
        for(Llamada llamada : llamadas){
            System.out.println(llamada);
        }
    }
}
