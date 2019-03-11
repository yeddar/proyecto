package datos;



public class Llamada implements Fechas{

	private String phone;
	private Fecha day;
	private double duration;
	
	public Llamada() {
		super();
	}
	
	public Llamada(String phone, Fecha day, double duration) {
		super();
		this.phone = phone;
		this.day = day;
		this.duration = duration;
	}
	
	public String getTelefono() {
		return this.phone;
	}
	
	public double getTiempo() {
		return this.duration;
	}

	@Override
	public Fecha getFecha() {
		return this.day;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[ Tel: ");
		builder.append(this.phone);
		builder.append(", Dia llamada: ");
		builder.append(this.day.toString());
		builder.append(", Tiempo: ");
		builder.append(this.duration);
		builder.append(" ]");
		return builder.toString();
	}
}
