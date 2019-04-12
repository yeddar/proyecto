package menu.facturas;

import datos.Cartera;
import datos.Factura;
import exceptions.ClienteNoExiste;
import exceptions.FacturaNoExiste;
import menu.EjecutaOpcion;
import menu.Utilidades;

import java.util.Scanner;

public class DatoFactura implements EjecutaOpcion{
	
	public void ejecuta (Cartera cartera) {
        String nif = Utilidades.pedirNif();
        try {
            Utilidades.clienteExiste(cartera, nif);
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
