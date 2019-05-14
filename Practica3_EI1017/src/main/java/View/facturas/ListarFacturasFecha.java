package View.facturas;

import Modelo.datos.Cartera;
import Modelo.datos.Factura;
import Modelo.datos.Fecha;
import Modelo.datos.Funcional;
import Modelo.datos.clientes.Cliente;
import Modelo.exceptions.ClienteNoExiste;
import Modelo.exceptions.FechaInvalida;
import View.menu.EjecutaOpcion;
import controlador.Utilidades;

import java.util.ArrayList;
import java.util.List;

public class ListarFacturasFecha implements EjecutaOpcion {
    @Override
    public void ejecuta(Cartera cartera) {
        String nif = Utilidades.pedirNif();
        try{
            cartera.clienteExiste(nif);
        } catch (ClienteNoExiste e){
            e.printStackTrace();
            return;
        }
        try {
            Fecha[] fechas = Utilidades.pedirFechas();
            Fecha diaInicio = fechas[0];
            Fecha diaParada = fechas[1];
            Cliente cliente = cartera.buscarPorNif(nif);
            List<Factura> newList = new ArrayList<>(cliente.getListaFacturas().values());

            newList = new Funcional().filtrar(newList,diaInicio,diaParada);
            if(newList.isEmpty()) {
                return;
            }
            // Hay clientes en la lista.
            for(Factura bill : newList) {
                System.out.println(bill);
            }
        } catch (FechaInvalida e){
            e.printStackTrace();
            return;
        }

    }
}
