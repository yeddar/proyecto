package menu.llamadas;

import datos.*;
import datos.clientes.Cliente;
import exceptions.ClienteNoExiste;
import menu.EjecutaOpcion;
import menu.Utilidades;

import java.util.Scanner;

public class AltaLlamada implements EjecutaOpcion{
	// TODO ¿En llamada, tambien se deberia mover el metodo de anadir llamada?
	public void ejecuta(Cartera cartera) {
	        String nif = Utilidades.pedirNif();
            try{
                    Utilidades.clienteExiste(cartera, nif);
                    Cliente cliente = cartera.buscarPorNif(nif);
                    Llamada llamada = Utilidades.pedirLlamada();
                    cliente.altaLlamada(llamada);
            } catch (ClienteNoExiste e){
                    e.printStackTrace();
            }

    }
}
