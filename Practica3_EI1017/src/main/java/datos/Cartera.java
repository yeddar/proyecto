package datos;

import datos.clientes.Cliente;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Cartera implements Serializable {

	    private Map<String, Cliente> clientes;

	    public Cartera(){
	        super();
	        clientes = new HashMap<String,Cliente>();
	    }

	    public void setClientes(Object obj){
	    	clientes = (Map<String, Cliente>) obj;
		}

	    public void nuevoCliente(Cliente cliente){
	        clientes.put(cliente.getNif(),cliente);
	    }

	    public Map<String, Cliente> getClientes(){
			Map<String, Cliente> aux = clientes;
	    	return aux;
	    }
	    
	    public Cliente buscarPorNif(String nif){
	        Cliente cliente = clientes.get(nif);
	        return cliente;
	    }

	    public void eliminaCliente(String nif) {
	        clientes.remove(nif);
	    }


}
