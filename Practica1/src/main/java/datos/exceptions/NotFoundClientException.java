package datos.exceptions;

public class NotFoundClientException extends Exception{
    public NotFoundClientException(){
        super("No existe ningún cliente con este nif.\n");
    }

}
