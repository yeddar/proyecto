package controlador;

import Modelo.datos.Cartera;
import Modelo.datos.Fecha;
import Modelo.datos.clientes.Cliente;
import Modelo.exceptions.ClienteNoExiste;

import java.util.List;


public interface Controlador {
    void pedirCliente();
    void pedirLlamada();
    void pedirTarifa();
    void guardarCartera();
    void cargarCartera();
    void borrarCliente(String nif) throws ClienteNoExiste;
    List<Cliente> clientesFecha(Fecha ini, Fecha fin);

}
