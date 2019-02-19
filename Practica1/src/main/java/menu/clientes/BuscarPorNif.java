package menu.clientes;

import datos.Cartera;
import datos.Cliente;
import menu.EjecutaOpcion;

public class BuscarPorNif implements EjecutaOpcion {

    public void ejecuta(Cartera cartera) {
        CONSOLA.print("Nif a buscar: ");
        String nif = TECLADO.nextLine();
        Cliente cliente = cartera.buscarPorNif(nif);

        if(cliente == null)
            CONSOLA.println("El cliente no existe.");
        else {
            CONSOLA.println(cliente);
        }
    }
}
