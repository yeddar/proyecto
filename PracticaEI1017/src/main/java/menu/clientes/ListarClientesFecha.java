package menu.clientes;

import datos.Cartera;
import datos.Fecha;
import datos.Funcional;
import datos.clientes.Cliente;
import exceptions.FechaInvalida;
import menu.EjecutaOpcion;
import menu.Utilidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListarClientesFecha implements EjecutaOpcion {

    /* Al hacer los metodos de mostrar por fechas, no encontramos la forma de que pueda simplificar los tres metodos
     * (cliente, factura y llamada) en uno, por lo que de momento todavia tienen un print los tres metodos */

    @Override
    public void ejecuta(Cartera cartera) {
        try {
            Fecha[] fechas = Utilidades.pedirFechas();
            Fecha diaInicio = fechas[0];
            Fecha diaParada = fechas[1];
            List<Cliente> newList = new ArrayList<>(cartera.getClientes().values());
            newList = new Funcional().filtrar(newList,diaInicio,diaParada);
            if(newList.isEmpty()) {
                return;
            }
            // Hay clientes en la lista.
            for(Cliente client : newList) {
                System.out.println(client);
            }
        } catch (FechaInvalida e){
            e.printStackTrace();
        }
    }
}
