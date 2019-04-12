package menu.clientes;

import datos.Cartera;
import datos.clientes.Cliente;
import exceptions.ClientAlreadyExists;
import exceptions.ClienteNoExiste;
import menu.EjecutaOpcion;
import menu.Utilidades;

import java.util.Scanner;

public class AltaParticular implements EjecutaOpcion{

	public void ejecuta(Cartera cartera) {
	        try{
	                Cliente cliente = Utilidades.pideDatos(cartera, true);
	                Utilidades.anadirCliente(cartera, cliente);
            } catch  (ClientAlreadyExists e) {
	                e.printStackTrace();
            }

    }
	
}
