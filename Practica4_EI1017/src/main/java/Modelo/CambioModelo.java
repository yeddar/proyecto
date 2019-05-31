package Modelo;

import Modelo.datos.Cartera;
import Modelo.datos.Fecha;
import Modelo.datos.Llamada;
import Modelo.datos.clientes.Cliente;
import Modelo.datos.tarifas.Tarifa;
import Modelo.exceptions.ClientAlreadyExists;

import java.util.Map;

public interface CambioModelo {
    void anyadirCliente(Cliente cliente);
    void eliminaCliente(String nif);
    void setClientes(Object obj);
    Map<String, Cliente> getClientes();
    void cambiarTarifaDia(String nif, Tarifa tarifa);
    void cambiarTarifaHora(String nif, Tarifa tarifa);
    void anadirLlamada(String nif, Llamada llamada);
    void emitirFactura(String nif, String code, Fecha fIni, Fecha fFin);
    Cliente buscarPorNif(String nif);

}
