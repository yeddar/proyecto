package menu.clientes;

import datos.Cartera;
import datos.Cliente;
import datos.Empresa;
import menu.EjecutaOpcion;

public class AltaEmpresa implements EjecutaOpcion {


    public void ejecuta(Cartera cartera) {
        CONSOLA.print("Nif: ");
        String nif = TECLADO.next();
        if(cartera.buscarPorNif(nif) == null){
            CONSOLA.println("El cliente ya existe.");
            return;
        }
        CONSOLA.print("Name: ");
        String name = TECLADO.next();
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
        Cliente cliente = new Empresa(dischargeDate,postalCode,province,city,nif,name,email);
        cartera.nuevoCliente(cliente);
    }
}
