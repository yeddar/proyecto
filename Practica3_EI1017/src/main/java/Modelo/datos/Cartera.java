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

public class Cartera implements Serializable, CambioModelo, InterrogaModelo {
	private InformaVista vista;
	private Cartera cartera;

	private Map<String, Cliente> clientes;

	public Cartera(){
		super();
		clientes = new HashMap<String,Cliente>();
	}
	public void setVista(InformaVista vista) {
	this.vista = vista;
}

	@Override
	public void setClientes(Object obj){
		clientes = (Map<String, Cliente>) obj;
	}

	public void nuevoCliente(Cliente cliente){
		clientes.put(cliente.getNif(),cliente);
	}

	@Override
	public Map<String, Cliente> getClientes(){
		Map<String, Cliente> aux = clientes;
		return aux;
	}

	@Override
	public Cliente buscarPorNif(String nif){
		Cliente cliente = clientes.get(nif);
		return cliente;
	}

	@Override
	public void eliminaCliente(String nif) {
		clientes.remove(nif);
	}


	@Override
	public void añadirCliente(Cliente cliente) {
	    	clientes.put(cliente.getNif(),cliente);

	}


	@Override
	public void getFacturas(String nif) {

	}

	@Override
	public void getLlamadas(List<Llamada> llamadas) {

	}

	@Override
	public Cliente clienteExiste(String nif) throws ClienteNoExiste{
		Cliente cliente = clientes.get(nif);
		if(cliente == null) {
			throw new ClienteNoExiste();
		} else {
			return cliente;
		}

	}
}
