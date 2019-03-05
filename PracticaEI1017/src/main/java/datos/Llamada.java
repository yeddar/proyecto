package datos;

public class Llamada {

	private String telefono;
	private Fecha dia_llamada;
	private double tiempo;
	
	public Llamada() {
		super();
	}
	
	public Llamada(String telefono, Fecha dia_llamada, double tiempo) {
		super();
		this.telefono = telefono;
		this.dia_llamada = dia_llamada;
		this.tiempo = tiempo;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public Fecha getFecha() {
		return dia_llamada;
	}
	
	public double getTiempo() {
		return tiempo;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[ Tel: ");
		builder.append(telefono);
		builder.append(", Día llamada: ");
		builder.append(dia_llamada.toString());
		builder.append(", Tiempo: ");
		builder.append(tiempo);
		builder.append(" ]");
		return builder.toString();
	}
}
