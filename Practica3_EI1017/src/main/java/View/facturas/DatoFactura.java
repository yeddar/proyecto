package View.facturas;

import Modelo.datos.Cartera;
import Modelo.exceptions.ClienteNoExiste;
import Modelo.exceptions.FacturaNoExiste;
import View.menu.EjecutaOpcion;
import controlador.Utilidades;

public class DatoFactura implements EjecutaOpcion{
	
	public void ejecuta (Cartera cartera) {
        String nif = Utilidades.pedirNif();
        try {
            cartera.clienteExiste(nif);
        } catch (ClienteNoExiste e) {
            e.printStackTrace();
            return;
        }
        String code = Utilidades.pedirCodigo();
        try {
            Utilidades.facturaExiste(cartera, nif, code);
            System.out.println(cartera.buscarPorNif(nif).getFactura(code));
        } catch (FacturaNoExiste e) {
            e.printStackTrace();
        }
    }
}
