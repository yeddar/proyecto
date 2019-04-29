package datos;


import java.io.Serializable;

public class Factura implements Fechas, Serializable {
	private String code;
	// private double tarifa;
    private Fecha dateOfIssue;
    private Fecha dateOfStart;
    private Fecha dateOfEnd;
    private double amount;

    public Factura(){
    	super();
    }

    public Factura(String code, Fecha dateOfIssue, Fecha dateOfStart, Fecha dateOfEnd, double amount) {
    	this.code = code;
    	// this.tarifa = tarifa; // TODO Quitar tarifa (Clases factura y emiteFactura)
    	this.dateOfIssue = dateOfIssue;
    	this.dateOfStart =dateOfStart;
    	this.dateOfEnd = dateOfEnd;
    	this.amount = amount;
    }
    
    public String getCode() {
    	return this.code;
    }
    
    public Fecha getDateOfStart() {
    	return this.dateOfStart;
    }
    
    public Fecha getDateOfEnd() {
    	return this.dateOfEnd;
    }
    
    public double getAmount() {
    	return this.amount;
    }

    @Override
    public Fecha getFecha() {
        return this.dateOfIssue;
    }


    @Override
    public String toString() {
    	StringBuilder builder = new StringBuilder();
		builder.append("[ ");
        builder.append("Code: "+code);
        //builder.append(", "); //TODO Pendiente de eliminar
        //builder.append("Bill: "+tarifa);
        builder.append(", ");
        builder.append("Date of Issue: "+dateOfIssue);
        builder.append(", ");
        builder.append("Date of start: "+dateOfStart);
        builder.append(", ");
        builder.append("Date of end: "+dateOfEnd);
        builder.append(", ");
        builder.append("Amount: "+amount+"€");
		builder.append(" ]");
		return builder.toString();
    }
}
