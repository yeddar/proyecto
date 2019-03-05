package menu.clientes;

import datos.Cartera;
import datos.Cliente;
import menu.EjecutaOpcion;
import java.util.Map;

public class ListarClientes implements EjecutaOpcion{

	public void ejecuta(Cartera cartera) {
        Map<String,Cliente> clientes = cartera.getClientes();
        for(String nif : clientes.keySet()){
            CONSOLA.println(clientes.get(nif));
        }
    }
	
}
