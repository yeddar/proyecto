package menu;

import datos.Cartera;
import datos.Fecha;

import java.util.Scanner;

public class Utilidades {


    // TODO hay métodos cómo AltaEmpresa que deben devolver una excepción cuando el cliente SÍ exista y este método hace lo contrario.
    public static void clienteExiste(Cartera cartera, String nif) {
        if(cartera.buscarPorNif(nif) == null)
            throw new IllegalArgumentException();
    }

    public static String pedirNif() {
        Scanner teclado = new Scanner(System.in);
        System.out.print("NIF: ");
        String nif = teclado.next();
        return nif;
    }

    public static Fecha pideFecha(String date) {
        String[] parts = date.split("/");
        return new Fecha(parts[0],parts[1],parts[2]);

    }
}
