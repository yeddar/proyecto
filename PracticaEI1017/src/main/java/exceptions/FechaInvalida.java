package exceptions;

public class FechaInvalida extends Exception {
    public FechaInvalida(){
        super("La fecha final es anterior a la fecha de inicio");
    }
}
