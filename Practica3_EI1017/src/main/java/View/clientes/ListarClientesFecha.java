package View.clientes;

import Modelo.datos.Cartera;
import Modelo.datos.Fecha;
import Modelo.datos.Funcional;
import Modelo.datos.clientes.Cliente;
import Modelo.exceptions.FechaInvalida;
import View.menu.EjecutaOpcion;
import controlador.Utilidades;

import java.util.ArrayList;
import java.util.List;

public class ListarClientesFecha {

    /* Al hacer los metodos de mostrar por fechas, no encontramos la forma de que pueda simplificar los tres metodos
     * (cliente, factura y llamada) en uno, por lo que de momento todavia tienen un print los tres metodos */

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
            ShowTable table = new ShowTable(newList);
            for(Cliente client : newList) {
                System.out.println(client);
            }
        } catch (FechaInvalida e){
            e.printStackTrace();
        }
    }
}
