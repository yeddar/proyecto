package menu.clientes;

import datos.Cartera;
import datos.Cliente;
import datos.Particular;
import menu.EjecutaOpcion;

public class AltaParticular implements EjecutaOpcion {
    public void ejecuta(Cartera cartera) {
        CONSOLA.print("Nif: ");
        String nif = TECLADO.next();
        if(cartera.buscarPorNif(nif) == null){
            CONSOLA.println("El cliente ya existe.");
            return;
        }
        CONSOLA.print("Name: ");
        String name = TECLADO.next();
        CONSOLA.print("Surnames: ");
        String surnames = TECLADO.next();
        CONSOLA.print("Email: ");
        String email = TECLADO.next();
        CONSOLA.print("Postal Code: ");
        String postalCode = TECLADO.next();
        CONSOLA.print("Province: ");
        String province = TECLADO.next();
        CONSOLA.print("City: ");
        String city = TECLADO.next();
        CONSOLA.print("Dicharge date: ");
        String dischargeDate = TECLADO.next();
        Cliente cliente = new Particular(dischargeDate,postalCode,province,city,nif,name,surnames,email);
        cartera.nuevoCliente(cliente);
    }
}
