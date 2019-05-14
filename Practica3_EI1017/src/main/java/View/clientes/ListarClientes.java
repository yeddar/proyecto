package View.clientes;

import Modelo.datos.Cartera;
import Modelo.datos.clientes.Cliente;
import View.menu.EjecutaOpcion;
import controlador.Utilidades;

import java.util.Map;


public class ListarClientes implements EjecutaOpcion{

	public void ejecuta(Cartera cartera) {
        Map<String,Cliente> clientes = cartera.getClientes();
        Utilidades.mostrarClientes(clientes);
    }
	
}
