package exceptions;

public class FacturaNoExiste extends Exception {
    public FacturaNoExiste(){
        super("No existe una factura con ese código");
    }
}
