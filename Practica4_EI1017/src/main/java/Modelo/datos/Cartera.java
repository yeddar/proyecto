package Modelo.datos;

import Modelo.CambioModelo;
import Modelo.InterrogaModelo;
import Modelo.datos.clientes.Cliente;
import Modelo.exceptions.ClienteNoExiste;
import View.Emergente;
import View.InformaVista;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Cartera implements Serializable{
	private InformaVista vista;
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
		// todo Falta notificar a la vista por si necesita actualizarse.
		// TODO Se hace en ImplementaModelo
	}



	public void añadirCliente(Cliente cliente) {
	    	clientes.put(cliente.getNif(),cliente);
			// todo Falta notificar a la vista por si necesita actualizarse.
			// TODO Se hace en ImplementaModelo
	}

}
