package View.clientes;

import Modelo.datos.Cartera;
import Modelo.exceptions.ClienteNoExiste;
import View.menu.EjecutaOpcion;
import controlador.Utilidades;

public class BuscarPorNif implements EjecutaOpcion{
	public void ejecuta(Cartera cartera) {

        String nif = Utilidades.pedirNif();
        try {
            cartera.clienteExiste(nif);
            System.out.println(cartera.buscarPorNif(nif));

        } catch(ClienteNoExiste e) {
            e.printStackTrace();
        }

    }
}
