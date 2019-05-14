package View.facturas;

import java.util.Set;

import Modelo.datos.*;
import Modelo.exceptions.ClienteNoExiste;
import View.menu.EjecutaOpcion;
import controlador.Utilidades;

public class ListarFacturas implements EjecutaOpcion{

	public void ejecuta (Cartera cartera) {
        String nif = Utilidades.pedirNif();
        try {
            cartera.clienteExiste(nif);
        } catch (ClienteNoExiste e) {
            e.printStackTrace();
            return;
        }
        Set<String> lista = cartera.buscarPorNif(nif).getListaFacturas().keySet();
        Utilidades.mostrarFacturas(cartera, nif, lista);
	}
}
