package menu.facturas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import datos.*;
import datos.clientes.Cliente;
import exceptions.ClienteNoExiste;
import menu.EjecutaOpcion;
import menu.Utilidades;

public class ListarFacturas implements EjecutaOpcion{

	public void ejecuta (Cartera cartera) {
        String nif = Utilidades.pedirNif();
        try {
            Utilidades.clienteExiste(cartera, nif);
        } catch (ClienteNoExiste e) {
            e.printStackTrace();
            return;
        }
        Set<String> lista = cartera.buscarPorNif(nif).getListaFacturas().keySet();
        Utilidades.mostrarFacturas(cartera, nif, lista);
	}
}
