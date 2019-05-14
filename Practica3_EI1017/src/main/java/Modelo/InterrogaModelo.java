package Modelo;

import Modelo.datos.Cartera;
import Modelo.datos.Llamada;
import Modelo.datos.clientes.Cliente;
import Modelo.exceptions.ClienteNoExiste;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface InterrogaModelo {
    Map<String, Cliente> getClientes();
    Cliente buscarPorNif(String nif);
    void getFacturas(String nif);
    void getLlamadas(List<Llamada> llamadas);
    Cliente clienteExiste(String nif) throws ClienteNoExiste;


}
