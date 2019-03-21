package menu.clientes;

import datos.Cartera;
import datos.Fecha;
import datos.Funcional;
import datos.clientes.Cliente;
import menu.EjecutaOpcion;
import menu.Utilidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListarClientesFecha implements EjecutaOpcion {
    @Override
    public void ejecuta(Cartera cartera) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Fecha inicio (DD/MM/YYYY): ");
        String date = teclado.next();
        Fecha diaInicio = Utilidades.pideFecha(date);
        System.out.print("Fecha fin (DD/MM/YYYY): ");
        date = teclado.next();
        Fecha diaParada = Utilidades.pideFecha(date);

        List<Cliente> newList = new ArrayList<>(cartera.getClientes().values());
        newList = new Funcional().filtrar(newList,diaInicio,diaParada);
        if(newList.isEmpty()) {
            System.out.println("No se ha encontrado ningún cliente dentro de ese periodo.");
            return;
        }
        // Hay clientes en la lista.
        for(Cliente client : newList) {
            System.out.println(client);
        }

    }
}
