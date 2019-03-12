package menu;

import datos.Cartera;
import datos.Fecha;

import java.util.Scanner;

public class Utilidades {

    public static void clienteExiste(Cartera cartera, String nif) {
        if(cartera.buscarPorNif(nif) == null)
            throw new IllegalArgumentException();
    }

    public static String pedirNif() {
        Scanner teclado = new Scanner(System.in);
        System.out.print("NIF: ");
        String nif = teclado.next();
        //teclado.close();
        return nif;
    }

    public static Fecha pideFecha() {
        Scanner teclado = new Scanner(System.in);
        String date = teclado.next();
        //teclado.close();
        String[] parts = date.split("/");
        return new Fecha(parts[0],parts[1],parts[2]);

    }
}
