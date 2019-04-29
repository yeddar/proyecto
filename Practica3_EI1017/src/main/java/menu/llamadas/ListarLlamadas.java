package menu.llamadas;

import datos.*;
import datos.clientes.Cliente;
import exceptions.ClienteNoExiste;
import menu.EjecutaOpcion;
import menu.Utilidades;

import java.util.List;
import java.util.Scanner;

public class ListarLlamadas implements EjecutaOpcion{
	
	public void ejecuta(Cartera cartera){
        String nif = Utilidades.pedirNif();
        try {
            Utilidades.clienteExiste(cartera, nif);
            Cliente cliente = cartera.buscarPorNif(nif);
            List<Llamada> llamadas = cliente.getLlamadas();
            Utilidades.mostrarLlamadas(llamadas);
        } catch (ClienteNoExiste e) {
            e.printStackTrace();
            return;
        }
    }

}
