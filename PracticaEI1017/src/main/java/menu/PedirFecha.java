package menu;

import datos.Fecha;

import java.util.Scanner;

public class PedirFecha{

    public Fecha pideFecha() {
        Scanner teclado = new Scanner(System.in);
        String date = teclado.next();
        String[] parts = date.split("/");
        return new Fecha(parts[0],parts[1],parts[2]);

    }
}
