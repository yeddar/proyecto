package menu.clientes;

import datos.Cartera;
import datos.Cliente;
import datos.Fecha;
import datos.Funcional;
import menu.EjecutaOpcion;
import menu.PedirFecha;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListarClientes implements EjecutaOpcion{

	public void ejecuta(Cartera cartera) {
        Map<String,Cliente> clientes = cartera.getClientes();
        for(String nif : clientes.keySet()){
            CONSOLA.println(clientes.get(nif));
        }
    }

    public void porFecha(Cartera cartera) {
	    CONSOLA.print("Fecha inicio (DD/MM/YYYY): ");
	    Fecha diaInicio = new PedirFecha().pideFecha();
        CONSOLA.print("Fecha fin (DD/MM/YYYY): ");
        Fecha diaParada = new PedirFecha().pideFecha();
        List<Cliente> newList = new ArrayList<>(cartera.getClientes().values());
        newList = new Funcional().filtrar(newList,diaInicio,diaParada);
        if(newList.isEmpty()) {
            CONSOLA.println("No se ha encontrado ningún cliente dentro de ese periodo.");
            return;
        }
        // Hay clientes en la lista.
        for(Cliente client : newList) {
            CONSOLA.println(client);
        }
    }
	
}
