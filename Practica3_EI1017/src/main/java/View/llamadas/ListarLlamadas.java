package View.llamadas;

import Modelo.datos.*;
import Modelo.datos.clientes.Cliente;
import Modelo.exceptions.ClienteNoExiste;
import View.menu.EjecutaOpcion;
import controlador.Utilidades;

import java.util.List;

public class ListarLlamadas implements EjecutaOpcion{
	
	public void ejecuta(Cartera cartera){
        String nif = Utilidades.pedirNif();
        try {
            cartera.clienteExiste(nif);
            Cliente cliente = cartera.buscarPorNif(nif);
            List<Llamada> llamadas = cliente.getLlamadas();
            Utilidades.mostrarLlamadas(llamadas);
        } catch (ClienteNoExiste e) {
            e.printStackTrace();
            return;
        }
    }

}
