package Modelo;

import Modelo.datos.Cartera;
import Modelo.datos.clientes.Cliente;
import Modelo.exceptions.ClientAlreadyExists;

import java.util.Map;

public interface CambioModelo {
    void añadirCliente(Cliente cliente);
    void eliminaCliente(String nif);
    void setClientes(Object obj);
    Map<String, Cliente> getClientes();

}
