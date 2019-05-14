package controlador;

import Modelo.CambioModelo;
import Modelo.datos.Cartera;
import Modelo.datos.Fecha;
import Modelo.datos.Funcional;
import Modelo.datos.Llamada;
import Modelo.datos.tarifas.Tarifa;
import Modelo.datos.clientes.Cliente;
import Application.main.MainMenu;


import java.io.*;
import java.util.*;

import Modelo.exceptions.ClientAlreadyExists;
import Modelo.exceptions.FacturaNoExiste;
import Modelo.exceptions.FechaInvalida;
import View.InterrogaVista;
import View.clientes.ShowTable;

public class Utilidades implements Controlador, Serializable {
    private InterrogaVista vista;
    private CambioModelo modelo;
    private Cartera cartera;

    public Utilidades(Cartera cartera) {
        this.cartera = cartera;
    }

    public void setModelo(CambioModelo modelo) { this.modelo = modelo; }

    public void setVista(InterrogaVista vista) {
        this.vista = vista;
    }


    public static void clienteExisteAlta(Cartera cartera, String nif) throws ClientAlreadyExists {
        if(cartera.buscarPorNif(nif) != null)
            throw new ClientAlreadyExists();
    }

    public static void fechasCorrectas(Fecha ini, Fecha fin) throws FechaInvalida{
        if (fin.getFecha().isBefore(ini.getFecha()))
            throw new FechaInvalida();
    }

    public static void facturaExiste(Cartera cartera, String nif, String code) throws FacturaNoExiste{
        if (cartera.buscarPorNif(nif).getFactura(code) == null)
            throw new FacturaNoExiste();
    }

    public static void facturaExisteEmitir(Cartera cartera, String nif, String code) throws FacturaNoExiste{
        if (cartera.buscarPorNif(nif).getFactura(code) != null)
            throw new FacturaNoExiste();
    }

    public static String pedirNif() {
        Scanner teclado = new Scanner(System.in);
        System.out.print("NIF: ");
        String nif = teclado.next();
        return nif;
    }

    public static String pedirCodigo(){
        Scanner teclado = new Scanner(System.in);
        System.out.print("Codigo de la factura: ");
        String code = teclado.next();
        return code;
    }

    public static Fecha setFecha(String date) {
        String[] parts = date.split("/");
        return new Fecha(parts[0],parts[1],parts[2]);
    }

    public static Fecha setTime(String time) {
        String[] parts = time.split(":");
        return new Fecha(parts[0],parts[1]);

    }


    public static Cliente pideDatos (Cartera cartera, boolean tipo) throws ClientAlreadyExists {
        Scanner teclado = new Scanner(System.in);
        String nif = Utilidades.pedirNif();
        Utilidades.clienteExisteAlta(cartera, nif);
        Cliente cliente;
        System.out.print("Name: ");
        String name = teclado.next();
        System.out.print("Email: ");
        String email = teclado.next();
        System.out.print("Postal Code: ");
        String postalCode = teclado.next();
        System.out.print("Province: ");
        String province = teclado.next();
        System.out.print("City: ");
        String city = teclado.next();
        System.out.print("Fecha de alta (DD/MM/YYYY): ");
        String date = teclado.next();
        Fecha dateConversed = Utilidades.setFecha(date);
        if (tipo){
            System.out.print("Surnames: ");
            String surnames = teclado.next();
            cliente = MainMenu.factoryClientes.crearParticular(dateConversed,postalCode,province,city,nif,name,surnames,email);
        } else {
            cliente = MainMenu.factoryClientes.crearEmpresa(dateConversed,postalCode,province,city,nif,name,email);
        }
        return cliente;
    }

    @Override
    public void pedirCliente() {
        Cliente cliente;
        String nif = vista.getNif();
        String name = vista.getName();
        String surnames = vista.getSurnames();
        String email = vista.getEmail();
        String zip = vista.getZip();
        String province = vista.getProvince();
        String city = vista.getCity();
        String date = vista.getDate();
        System.out.println("Fecha: "+date);
        Fecha dateConversed = Utilidades.setFecha(date);
        if(surnames.isEmpty())
            cliente = MainMenu.factoryClientes.crearEmpresa(dateConversed,zip,province,city,nif,name,email);
        else
            cliente = MainMenu.factoryClientes.crearParticular(dateConversed,zip,province,city,nif,name,surnames,email);

        modelo.añadirCliente(cliente);
    }

    @Override
    public void pedirTarifa() {
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
    public void borrarCliente(String nif) {
        cartera.eliminaCliente(nif);

    }

    @Override
    public void pedirLlamada() {
    }
/*
    public static Llamada pedirLlamada(){
        Scanner teclado = new Scanner(System.in);
        System.out.print("Telefono: ");
        String phone = teclado.next();
        System.out.print("Duracion de la llamada (min): ");
        double duration = teclado.nextDouble();
        System.out.print("Fecha de realización de la llamada (DD/MM/YYYY): ");
        String date = teclado.next();
        System.out.print("Hora de realización de la llamada (HH:MM): ");
        String time = teclado.next();
        Fecha timeConversed = setTime(time);
        Fecha dateConversed = setFecha(date);
        return new Llamada(phone, dateConversed,timeConversed, duration);
    }
*/


    public static Tarifa pedirTarifa(Cliente cliente){
        Scanner teclado = new Scanner(System.in);
        System.out.print("Tipo de oferta (1:Tarifa por hora, 2:Tarifa por día): ");
        int tipo = teclado.nextInt();
        System.out.print("Precio de esta oferta: ");
        double price = teclado.nextDouble();
        Tarifa tarifa = cliente.getTarifa();
        if (tipo == 1){
            System.out.print("Hora de inicio de la oferta (HH:MM): ");
            String time = teclado.next();
            Fecha horaInicio = setTime(time);
            System.out.print("Hora de parada de la oferta (HH:MM): ");
            time = teclado.next();
            Fecha horaParada = setTime(time);
            tarifa = MainMenu.factoryTarifas.crearTarifaFranjaHoraria(tarifa,price,horaInicio, horaParada);
        } else if (tipo == 2){
            System.out.print("Dia de la semana (MONDAY, TUESDAY, WEDNESDAY, ...): ");
            String day = teclado.next();
            tarifa = MainMenu.factoryTarifas.crearTrarifaDia(tarifa, price, day);
        }
        return tarifa;
    }

    @Override
    public List<Cliente> clientesFecha(Fecha ini, Fecha fin){
        List<Cliente> list = new ArrayList<>(cartera.getClientes().values());
        list = new Funcional().filtrar(list,ini,fin);
        return list;
    }

    public static void mostrarClientes(Map<String,Cliente> clientes){
        for(String nif : clientes.keySet()){
            System.out.println(clientes.get(nif));
        }
    }

    public static void mostrarFacturas(Cartera cartera, String nif, Set<String> lista){
        for (String code : lista) {
            System.out.println(cartera.buscarPorNif(nif).getFactura(code));
        }
    }


    public static void mostrarLlamadas(List<Llamada> llamadas){
        for(Llamada llamada : llamadas){
            System.out.println(llamada);
        }
    }

    public static Fecha[] pedirFechas() throws FechaInvalida{
        Scanner teclado = new Scanner(System.in);
        System.out.print("Fecha inicio (DD/MM/YYYY): ");
        String date = teclado.next();
        Fecha diaInicio = Utilidades.setFecha(date);
        System.out.print("Fecha fin (DD/MM/YYYY): ");
        date = teclado.next();
        Fecha diaParada = Utilidades.setFecha(date);
        fechasCorrectas(diaInicio, diaParada);
        Fecha[] fechas = {diaInicio, diaParada};
        return fechas;
    }

    public static void anadirCliente(Cartera cartera, Cliente cliente) throws ClientAlreadyExists{
        cartera.nuevoCliente(cliente);
    }
}
