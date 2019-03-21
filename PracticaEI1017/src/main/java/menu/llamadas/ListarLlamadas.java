package menu.llamadas;

import datos.*;
import datos.clientes.Cliente;
import menu.EjecutaOpcion;
import menu.Utilidades;

import java.util.List;
import java.util.Scanner;

public class ListarLlamadas implements EjecutaOpcion{
	
	public void ejecuta(Cartera cartera){
        Scanner teclado = new Scanner(System.in);
        System.out.print("Nif del cual se desea obtener las llamadas: ");
        String nif = teclado.next();
        Cliente cliente = cartera.buscarPorNif(nif);
        if(cliente == null){
            System.out.println("El cliente no existe.");
            return;
        }
        List<Llamada> llamadas = cliente.getLlamadas();
        for(Llamada llamada : llamadas){
            System.out.println(llamada);
        }
    }

    public void porFecha(Cartera cartera) {
	    Scanner teclado = new Scanner(System.in);
        System.out.print("Nif del cual se desea obtener las llamadas: ");
        String nif = teclado.next();
        Cliente cliente = cartera.buscarPorNif(nif);
        if(cliente == null){
            System.out.println("El cliente no existe.");
            return;
        }
        System.out.print("Fecha inicio (DD/MM/YYYY): ");
        String date = teclado.next();
        Fecha diaInicio = Utilidades.pideFecha(date);
        System.out.print("Fecha fin (DD/MM/YYYY): ");
        date = teclado.next();
        Fecha diaParada = Utilidades.pideFecha(date);
        List<Llamada> newList = cliente.getLlamadas();
        newList = new Funcional().filtrar(newList,diaInicio,diaParada);
        if(newList.isEmpty()) {
            System.out.println("No se ha encontrado ningún cliente dentro de ese periodo.");
            return;
        }
        // Hay clientes en la lista.
        for(Llamada call : newList) {
            System.out.println(call);
        }
    }

}
