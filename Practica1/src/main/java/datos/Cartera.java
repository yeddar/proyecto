package datos;


import java.util.HashMap;

import java.util.Map;

public class Cartera {
    private Map<String, Cliente> clientes;

    public Cartera(){
        super();
        clientes = new HashMap<String,Cliente>();
    }

    public void nuevoCliente(Cliente cliente){
        clientes.put(cliente.getNif(),cliente);
    }


    public void listarClientes(){
        for(String nif : clientes.keySet()){
            System.out.println(clientes.get(nif));
        }
    }

    public Cliente buscarPorNif(String nif){
        return clientes.get(nif);
    }


}
