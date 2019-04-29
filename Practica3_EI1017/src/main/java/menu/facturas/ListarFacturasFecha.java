package menu.facturas;

import datos.Cartera;
import datos.Factura;
import datos.Fecha;
import datos.Funcional;
import datos.clientes.Cliente;
import exceptions.ClienteNoExiste;
import exceptions.FechaInvalida;
import menu.EjecutaOpcion;
import menu.Utilidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListarFacturasFecha implements EjecutaOpcion {
    @Override
    public void ejecuta(Cartera cartera) {
        String nif = Utilidades.pedirNif();
        try{
            Utilidades.clienteExiste(cartera, nif);
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
