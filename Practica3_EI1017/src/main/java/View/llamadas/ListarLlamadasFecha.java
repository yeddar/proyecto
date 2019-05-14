package View.llamadas;

import Modelo.datos.Cartera;
import Modelo.datos.Fecha;
import Modelo.datos.Funcional;
import Modelo.datos.Llamada;
import Modelo.datos.clientes.Cliente;
import Modelo.exceptions.ClienteNoExiste;
import Modelo.exceptions.FechaInvalida;
import View.menu.EjecutaOpcion;
import controlador.Utilidades;

import java.util.List;

public class ListarLlamadasFecha implements EjecutaOpcion {
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
            List<Llamada> newList = cliente.getLlamadas();
            newList = new Funcional().filtrar(newList,diaInicio,diaParada);
            if(newList.isEmpty()) {
                return;
            }
            // Hay clientes en la lista.
            for(Llamada call : newList) {
                System.out.println(call);
            }
        } catch (FechaInvalida e){
            e.printStackTrace();
        }
    }
}
