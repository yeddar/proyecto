package Application.main;

import Modelo.ImplementaModelo;
import Modelo.datos.Cartera;
import Modelo.datos.factory.clientes.FactoryClientes;
import Modelo.datos.factory.tarifas.FactoryTarifas;
import View.ImplementaVista;
import controlador.*;


public class MainMenu {
    private Cartera cartera = new Cartera();
    public static FactoryClientes factoryClientes =  new FactoryClientes();
    public static FactoryTarifas factoryTarifas = new FactoryTarifas();


    // TODO Las excepciones estan implementadas, lo unico que lo hemos dejado "sucio", es decir, que muestra el mensaje de la excepcion en vez de un mensaje personaliado.
    public static void main(String[] args) {
        new MainMenu().ejecuta();
    }


    private void ejecuta(){

        // Cargar GUI
        ImplementaControlador controlador = new ImplementaControlador();
        ImplementaModelo modelo = new ImplementaModelo(cartera);
        ImplementaVista vista = new ImplementaVista();
        controlador.setVista(vista);
        controlador.setModelo(modelo);
        controlador.setCartera(modelo);
        vista.setControlador(controlador);
        vista.setModelo(modelo);
        modelo.setVista(vista);
        vista.creaGUI();

    }
}