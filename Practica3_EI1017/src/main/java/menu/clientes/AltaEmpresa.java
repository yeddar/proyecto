package menu.clientes;

import datos.*;
import datos.clientes.Cliente;
import exceptions.ClientAlreadyExists;
import exceptions.ClienteNoExiste;
import menu.EjecutaOpcion;
import menu.Utilidades;

public class AltaEmpresa implements EjecutaOpcion{

    // TODO Respecto al comentario de la practica anterior de mover la funcion de añadir cliente, no se si esto estaria bien
	public void ejecuta(Cartera cartera) {
            try{
                    Cliente cliente = Utilidades.pideDatos(cartera, false);
                    Utilidades.anadirCliente(cartera, cliente);
            } catch  (ClientAlreadyExists e) {
                    e.printStackTrace();
            }
    }
	
}
