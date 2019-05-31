package controlador;

import Modelo.datos.Cartera;
import Modelo.datos.Factura;
import Modelo.datos.Fecha;
import Modelo.datos.Llamada;
import Modelo.datos.clientes.Cliente;
import Modelo.exceptions.ClientAlreadyExists;
import Modelo.exceptions.ClienteNoExiste;
import Modelo.exceptions.FacturaNoExiste;
import Modelo.exceptions.FechaInvalida;

import java.util.List;


public interface Controlador {
    void guardarCartera();
    void cargarCartera();
    void pedirCliente() throws ClientAlreadyExists;
    void borrarCliente(String nif) throws ClienteNoExiste;
    void cambiarTarifaDia() throws ClienteNoExiste;
    void cambiarTarifaHora() throws ClienteNoExiste;
    void anadirLlamada() throws ClienteNoExiste;
    void emitirFactura() throws ClienteNoExiste;
    void fechasCorrectas(Fecha ini, Fecha fin) throws FechaInvalida;
    void facturaExiste(Cartera cartera, String nif, String code) throws FacturaNoExiste;
    void facturaExisteEmitir(Cartera cartera, String nif, String code) throws FacturaNoExiste;

}
