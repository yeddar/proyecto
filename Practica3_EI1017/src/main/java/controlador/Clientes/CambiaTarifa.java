package controlador.Clientes;

import Modelo.datos.Cartera;
import Modelo.datos.tarifas.Tarifa;
import Modelo.datos.clientes.Cliente;
import Modelo.exceptions.ClienteNoExiste;
import View.menu.EjecutaOpcion;
import controlador.Utilidades;

public class CambiaTarifa implements EjecutaOpcion{
	
	public void ejecuta(Cartera cartera) {
        String nif = Utilidades.pedirNif();
        try {
            cartera.clienteExiste(nif);
            Tarifa tarifaOferta = Utilidades.pedirTarifa(cartera.buscarPorNif(nif));
            Cliente client = cartera.buscarPorNif(nif);
            client.setTarifa(tarifaOferta);
        } catch (ClienteNoExiste e){
            e.printStackTrace();
        }

    }
}
