package menu.clientes;

import datos.Cartera;
import datos.Cliente;
import datos.Empresa;
import menu.EjecutaOpcion;

public class AltaEmpresa implements EjecutaOpcion {


    public void ejecuta(Cartera cartera) {
        CONSOLA.print("Name: ");
        String name = TECLADO.nextLine();
        CONSOLA.print("Nif: ");
        String nif = TECLADO.nextLine();
        CONSOLA.print("Email: ");
        String email = TECLADO.nextLine();
        CONSOLA.print("Postal Code: ");
        String postalCode = TECLADO.nextLine();
        CONSOLA.print("Province: ");
        String province = TECLADO.nextLine();
        CONSOLA.print("City: ");
        String city = TECLADO.nextLine();
        CONSOLA.print("Dicharge date: ");
        String dischargeDate = TECLADO.nextLine();
        Cliente cliente = new Empresa(dischargeDate,postalCode,province,city,nif,name,email);
        cartera.nuevoCliente(cliente);
    }
}
