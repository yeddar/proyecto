package menu.clientes;

import datos.Cartera;
import datos.clientes.Cliente;
import exceptions.ClienteNoExiste;
import menu.EjecutaOpcion;
import menu.Utilidades;

import java.util.Scanner;

public class CambiaTarifa implements EjecutaOpcion{
	
	public void ejecuta(Cartera cartera) {
        String nif = Utilidades.pedirNif();
        try {
            Utilidades.clienteExiste(cartera, nif);
            double priceSec = Utilidades.pedirTarifa();
            cartera.setTarifa(nif, priceSec);
        } catch (ClienteNoExiste e){
            e.printStackTrace();
        }

    }
}
