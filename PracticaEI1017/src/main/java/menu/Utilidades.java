package menu;

import datos.Cartera;
import datos.Fecha;
import datos.Llamada;
import datos.clientes.Cliente;
import datos.clientes.Empresa;
import datos.clientes.Particular;

import java.util.List;
import java.util.Map;

import exceptions.ClientAlreadyExists;
import exceptions.ClienteNoExiste;
import exceptions.FacturaNoExiste;
import exceptions.FechaInvalida;

import java.util.Scanner;
import java.util.Set;

public class Utilidades {

    // todo Este método debe ir dentro de Cartera
    public static void clienteExiste(Cartera cartera, String nif) throws ClienteNoExiste {
        if(cartera.buscarPorNif(nif) == null)
            throw new ClienteNoExiste();
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
            cliente = new Particular(dateConversed,postalCode,province,city,nif,name,surnames,email);
        } else {
            cliente = new Empresa(dateConversed,postalCode,province,city,nif,name,email);
        }
        return cliente;
    }

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

    public static double pedirTarifa(){
        Scanner teclado = new Scanner(System.in);
        System.out.print("Indica la tarifa (eur/min): ");
        double priceSec = teclado.nextDouble();
        return priceSec;
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

    public static void anadirCliente(Cartera cartera, Cliente cliente){
        cartera.nuevoCliente(cliente);
    }
}
