package Modelo;

import Modelo.*;
import Modelo.datos.*;
import Modelo.datos.clientes.Cliente;
import Modelo.datos.tarifas.Tarifa;
import Modelo.exceptions.ClienteNoExiste;
import View.ImplementaVista;
import View.InformaVista;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


// todo El nombre de esta clase no es significativo.
// TODO Hecho!
public class ImplementaModelo implements CambioModelo, InterrogaModelo, CargarGuardar{
    private Cartera cartera;
    private InformaVista vista;

    public ImplementaModelo(Cartera cartera){ this.cartera = cartera;}

    public void setVista(InformaVista vista){ this.vista = vista;}

    // todo Ay! esas eñes me siguen doliendo.
    // TODO Hecho!

    //TODO Aquí es donde se notifica a la vista
    @Override
    public void anyadirCliente(Cliente cliente) {
        cartera.añadirCliente(cliente);
        vista.clienteAnyadido();
    }

    @Override
    public void eliminaCliente(String nif) {
        cartera.eliminaCliente(nif);
        vista.clienteBorrado();
    }

    @Override
    public void setClientes(Object obj) {
        cartera.setClientes(obj);
    }

    @Override
    public Map<String, Cliente> getClientes() {
        return cartera.getClientes();
    }

    @Override
    public void cambiarTarifaDia(String nif, Tarifa tarifa) {
        cartera.buscarPorNif(nif).setTarifa(tarifa);
    }

    @Override
    public void cambiarTarifaHora(String nif, Tarifa tarifa) {
        cartera.buscarPorNif(nif).setTarifa(tarifa);
    }

    @Override
    public Cliente buscarPorNif(String nif) {
        return cartera.buscarPorNif(nif);
    }

    @Override
    public void anadirLlamada(String nif, Llamada llamada){
      cartera.buscarPorNif(nif).altaLlamada(llamada);
    }

    @Override
    public void emitirFactura(String nif, String code, Fecha fIni, Fecha fFin){
        double amount = 0.0;
        Fecha hoy = new Fecha(LocalDate.now(), LocalTime.now());
        Cliente cliente = cartera.buscarPorNif(nif);
        List<Llamada> llamadas = cliente.getLlamadas();
        for (Llamada llamada : llamadas) {
            Fecha fecha = llamada.getFecha();
            if (fecha.insideOfDate(fIni,fFin)){  // Es correcta
                amount = amount + llamada.getDuracion() * cliente.getTarifa().getPrice(llamada);
            }
        }
        Factura nuevaFactura = new Factura(code, hoy, fIni, fFin, amount);
        cliente.altaFactura(code, nuevaFactura);
    }

    @Override
    public Map<String, Factura> getFacturas(String nif) {
        return cartera.buscarPorNif(nif).getListaFacturas();
    }

    @Override
    public List<Llamada> getLlamadas(String nif) {
        return cartera.buscarPorNif(nif).getLlamadas();
    }

    @Override
    public Cliente clienteExiste(String nif) throws ClienteNoExiste {
        if (cartera.buscarPorNif(nif) == null){
            throw new ClienteNoExiste();
        } else {
            return cartera.buscarPorNif(nif);
        }
    }
    @Override
    public List<Cliente> clientesFecha(Fecha ini, Fecha fin){
        List<Cliente> list = new ArrayList<>(getClientes().values());
        return new Funcional().filtrar(list, ini, fin);
    }
    @Override
    public List<Llamada> llamadasFecha(String nif, Fecha ini, Fecha fin){
        List<Llamada> list = new ArrayList<>(getLlamadas(nif));
        return new Funcional().filtrar(list, ini, fin);
    }
    @Override
    public List<Factura> facturasFecha(String nif, Fecha ini, Fecha fin){
        Map<String, Factura> listaEntera = getFacturas(nif);
        List<Factura> list = new ArrayList<>(listaEntera.values());
        return new Funcional().filtrar(list, ini, fin);
    }

    @Override
    public void cargarCartera() {
        try{
            FileInputStream fis = new FileInputStream("cartera.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            ois.close();

            cartera.setClientes(obj);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void guardarCartera() {
        try{
            FileOutputStream fos = new FileOutputStream("cartera.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(cartera.getClientes());
            oos.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
