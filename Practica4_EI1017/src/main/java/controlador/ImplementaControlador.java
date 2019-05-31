package controlador;

import Modelo.CambioModelo;
import Modelo.CargarGuardar;
import Modelo.ImplementaModelo;
import Modelo.datos.*;
import Modelo.datos.tarifas.Tarifa;
import Modelo.datos.clientes.Cliente;
import Application.main.MainMenu;


import java.io.*;
import java.util.*;

import Modelo.exceptions.ClientAlreadyExists;
import Modelo.exceptions.ClienteNoExiste;
import Modelo.exceptions.FacturaNoExiste;
import Modelo.exceptions.FechaInvalida;
import View.ImplementaVista;
import View.InterrogaVista;

// todo Elegid un mejor nombre para esta clase.
// TODO Hecho!
public class ImplementaControlador implements Controlador, Serializable {
    private InterrogaVista vista;
    private CambioModelo modelo;
    private CargarGuardar cartera;

    public ImplementaControlador() {}

    public void setModelo(CambioModelo modelo) { this.modelo = modelo; }

    public void setVista(InterrogaVista vista) {
        this.vista = vista;
    }

    public void setCartera(CargarGuardar cartera){ this.cartera = cartera;}


    // TODO Sería conveniente cambiar la forma en la que se comprueba si un cliente existe ya que lo hacemos con null


    @Override
    public void fechasCorrectas(Fecha ini, Fecha fin) throws FechaInvalida{
        if (fin.getFecha().isBefore(ini.getFecha()))
            throw new FechaInvalida();
    }
    // TODO Falta utilizar este método
    @Override
    public void facturaExiste(Cartera cartera, String nif, String code) throws FacturaNoExiste{
        if (cartera.buscarPorNif(nif).getFactura(code) == null)
            throw new FacturaNoExiste();
    }
    // TODO Falta utilizar este método
    @Override
    public void facturaExisteEmitir(Cartera cartera, String nif, String code) throws FacturaNoExiste{
        if (cartera.buscarPorNif(nif).getFactura(code) != null)
            throw new FacturaNoExiste();
    }


    // todo Aquí el separador es una /, y en el constructor de Fecha un guión.
    // TODO Hecho!
    public static Fecha setFecha(String date) {
        String[] parts = date.split("/");
        return new Fecha(parts[0],parts[1],parts[2]);
    }

    public static Fecha setTime(String time) {
        String[] parts = time.split(":");
        return new Fecha(parts[0],parts[1]);
    }

    @Override
    public void guardarCartera() {
        cartera.guardarCartera();
    }

    @Override
    public void cargarCartera() {
        cartera.cargarCartera();
    }

    @Override
    public void pedirCliente() throws ClientAlreadyExists{
        Cliente cliente;
        String nif = vista.getNif();
        String name = vista.getName();
        String surnames = vista.getSurnames();
        String email = vista.getEmail();
        String zip = vista.getZip();
        String province = vista.getProvince();
        String city = vista.getCity();
        String date = vista.getDate();
        Fecha dateConversed = ImplementaControlador.setFecha(date);

        //TODO Comprobar si cliente ya existe!
        // TODO Hecho!
        if(modelo.buscarPorNif(nif) != null)
            throw new ClientAlreadyExists();

        if(surnames.isEmpty())
            cliente = MainMenu.factoryClientes.crearEmpresa(dateConversed,zip,province,city,nif,name,email);
        else
            cliente = MainMenu.factoryClientes.crearParticular(dateConversed,zip,province,city,nif,name,surnames,email);

        modelo.anyadirCliente(cliente);
    }

    @Override
    public void emitirFactura() throws ClienteNoExiste{
        String nif = vista.getNifFac();
        String code = vista.getCode();
        Fecha fIni = setFecha(vista.getFIniFac());
        Fecha fFin = setFecha(vista.getFFinFac());
        // TODO Comprobar si el cliente existe!
        // TODO Hecho!
        if(modelo.buscarPorNif(nif) == null)
            throw new ClienteNoExiste();

        modelo.emitirFactura(nif, code, fIni, fFin);
    }

    @Override
    public void anadirLlamada() throws ClienteNoExiste{
        String nif = vista.getNifLlamada();
        String tel = vista.getTel();
        Double dur = Double.valueOf(vista.getDur());
        Fecha FIni = setFecha(vista.getFIni());
        Fecha FHora = setTime(vista.getFHora());
        if(modelo.buscarPorNif(nif) == null)
            throw new ClienteNoExiste();
        Llamada llamada = new Llamada(tel,FIni,FHora,dur);
        modelo.anadirLlamada(nif, llamada);
    }

    @Override
    public void borrarCliente(String nif) {
        modelo.eliminaCliente(nif);
    }

    @Override
    public void cambiarTarifaDia() throws ClienteNoExiste{
        Tarifa tarifa;
        String nif = vista.getNifDia();
        double precioMin = vista.getPercioMinDia();
        String day = vista.getDiaSemana();
        // TODO Comprobar si el cliente existe!
        //TODO Hecho!

        if(modelo.buscarPorNif(nif) == null)
            throw new ClienteNoExiste();
        tarifa = modelo.buscarPorNif(nif).getTarifa();
        tarifa = MainMenu.factoryTarifas.crearTrarifaDia(tarifa, precioMin, day);
        modelo.cambiarTarifaDia(nif, tarifa);
    }

    @Override
    public void cambiarTarifaHora() throws ClienteNoExiste{
        Tarifa tarifa;
        String nif = vista.getNifHora();
        double precioMin = vista.getPrecioMinHora();
        Fecha horaIni = setTime(vista.getHoraIni());
        Fecha horaFin = setTime(vista.getHoraFin());
        // TODO Comprobar aquí si el cliente existe!
        // TODO Hecho!
        if(modelo.buscarPorNif(nif) == null)
            throw new ClienteNoExiste();
        tarifa = modelo.buscarPorNif(nif).getTarifa();
        tarifa = MainMenu.factoryTarifas.crearTarifaFranjaHoraria(tarifa, precioMin, horaIni, horaFin);
        modelo.cambiarTarifaHora(nif, tarifa);
    }
}
