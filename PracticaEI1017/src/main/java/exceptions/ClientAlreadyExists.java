package exceptions;

import datos.clientes.Cliente;

public class ClientAlreadyExists extends Exception{
    public ClientAlreadyExists() {
        super("Ya existe un cliente registrado con ese nif.");
    }
}
