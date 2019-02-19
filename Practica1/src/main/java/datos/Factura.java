package datos;

public class Factura implements Fecha{
    private Tarifa tarifa;
    private String code;
    private String dateOfIssue;
    private String billingPeriod;
    private double amount;

    public Factura(){}

    public String getFecha() {
        return dateOfIssue;
    }

    public float calcularFactura(){
        return 0;
    }
}
