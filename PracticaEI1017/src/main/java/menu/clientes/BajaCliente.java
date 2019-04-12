package menu.clientes;

import datos.Cartera;
import exceptions.ClienteNoExiste;
import menu.EjecutaOpcion;
import menu.Utilidades;

import java.util.Scanner;

public class BajaCliente implements EjecutaOpcion{
	
	public void ejecuta(Cartera cartera){
        String nif = Utilidades.pedirNif();
        try {
            Utilidades.clienteExiste(cartera, nif);
            cartera.eliminaCliente(nif);
        } catch (ClienteNoExiste e){
            e.printStackTrace();
        }
    }
	
}
