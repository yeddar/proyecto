package menu.facturas;

import datos.Cartera;
import datos.Factura;
import datos.Fecha;
import datos.Funcional;
import datos.clientes.Cliente;
import menu.EjecutaOpcion;
import menu.Utilidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListarFacturasFecha implements EjecutaOpcion {
    @Override
    public void ejecuta(Cartera cartera) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Nif del cual se desea obtener las facturas: ");
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

        List<Factura> newList = new ArrayList<>(cliente.getListaFacturas().values());

        newList = new Funcional().filtrar(newList,diaInicio,diaParada);
        if(newList.isEmpty()) {
            System.out.println("No se ha encontrado ningúna factura dentro de ese periodo.");
            return;
        }
        // Hay clientes en la lista.
        for(Factura bill : newList) {
            System.out.println(bill);
        }
    }
}
