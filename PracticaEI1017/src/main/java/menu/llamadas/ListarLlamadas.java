package menu.llamadas;

import datos.*;
import menu.EjecutaOpcion;
import menu.PedirFecha;

import java.util.ArrayList;
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

    public void porFecha(Cartera cartera) {
        CONSOLA.print("Nif del cual se desea obtener las llamadas: ");
        String nif = TECLADO.next();
        Cliente cliente = cartera.buscarPorNif(nif);
        if(cliente == null){
            CONSOLA.println("El cliente no existe.");
            return;
        }
        CONSOLA.print("Fecha inicio (DD/MM/YYYY): ");
        Fecha diaInicio = new PedirFecha().pideFecha();
        CONSOLA.print("Fecha fin (DD/MM/YYYY): ");
        Fecha diaParada = new PedirFecha().pideFecha();
        List<Llamada> newList = cliente.getLlamadas();
        newList = new Funcional().filtrar(newList,diaInicio,diaParada);
        if(newList.isEmpty()) {
            CONSOLA.println("No se ha encontrado ningún cliente dentro de ese periodo.");
            return;
        }
        // Hay clientes en la lista.
        for(Llamada call : newList) {
            CONSOLA.println(call);
        }
    }

}
