package Modelo;

import Modelo.datos.Cartera;
import Modelo.datos.Factura;
import Modelo.datos.Fecha;
import Modelo.datos.Llamada;
import Modelo.datos.clientes.Cliente;
import Modelo.exceptions.ClienteNoExiste;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface InterrogaModelo {
    Map<String, Cliente> getClientes();
    List<Cliente> clientesFecha(Fecha ini, Fecha fin);
    List<Llamada> llamadasFecha(String nif, Fecha ini, Fecha fin);
    List<Factura> facturasFecha(String nif, Fecha ini, Fecha fin);

    Cliente buscarPorNif(String nif);
    Map<String, Factura> getFacturas(String nif);
    List<Llamada> getLlamadas(String nif);
    Cliente clienteExiste(String nif) throws ClienteNoExiste;


}
