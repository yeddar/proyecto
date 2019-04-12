package menu.clientes;

import datos.Cartera;
import datos.clientes.Cliente;
import menu.EjecutaOpcion;
import menu.Utilidades;

import java.util.Map;


public class ListarClientes implements EjecutaOpcion{

	public void ejecuta(Cartera cartera) {
        Map<String,Cliente> clientes = cartera.getClientes();
        Utilidades.mostrarClientes(clientes);
    }
	
}
