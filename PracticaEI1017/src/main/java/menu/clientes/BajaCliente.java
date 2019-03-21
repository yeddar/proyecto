package menu.clientes;

import datos.Cartera;
import menu.EjecutaOpcion;
import menu.Utilidades;

import java.util.Scanner;

public class BajaCliente implements EjecutaOpcion{
	
	public void ejecuta(Cartera cartera){

        String nif = Utilidades.pedirNif();
        if(cartera.buscarPorNif(nif) == null){
            System.out.println("El cliente no existe.");
            return;
        }
        cartera.eliminaCliente(nif);
    }
	
}
