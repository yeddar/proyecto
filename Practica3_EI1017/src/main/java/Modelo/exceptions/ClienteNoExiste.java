package Modelo.exceptions;

public class ClienteNoExiste extends Exception {
    public ClienteNoExiste(){
        super("No existe ningún cliente con ese nif");
    }
}
