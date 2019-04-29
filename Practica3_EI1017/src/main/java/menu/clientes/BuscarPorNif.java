package menu.clientes;

import datos.Cartera;
import datos.clientes.Cliente;
import exceptions.ClienteNoExiste;
import menu.EjecutaOpcion;
import menu.Utilidades;

public class BuscarPorNif implements EjecutaOpcion{
	public void ejecuta(Cartera cartera) {

        String nif = Utilidades.pedirNif();
        try {
            Utilidades.clienteExiste(cartera, nif);
            System.out.println(cartera.buscarPorNif(nif));

        } catch(ClienteNoExiste e) {
            e.printStackTrace();
        }

    }
}
