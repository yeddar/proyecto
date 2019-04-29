package menu.clientes;

import datos.Cartera;
import datos.tarifas.Tarifa;
import datos.clientes.Cliente;
import exceptions.ClienteNoExiste;
import menu.EjecutaOpcion;
import menu.Utilidades;

public class CambiaTarifa implements EjecutaOpcion{
	
	public void ejecuta(Cartera cartera) {
        String nif = Utilidades.pedirNif();
        try {
            Utilidades.clienteExiste(cartera, nif);
            Tarifa tarifaOferta = Utilidades.pedirTarifa(cartera.buscarPorNif(nif));
            Cliente client = cartera.buscarPorNif(nif);
            client.setTarifa(tarifaOferta);
        } catch (ClienteNoExiste e){
            e.printStackTrace();
        }

    }
}
