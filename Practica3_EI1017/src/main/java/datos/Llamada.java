package datos;


import java.io.Serializable;

public class Llamada implements Fechas, Serializable {

	private String phone;
	private Fecha date;
	private Fecha time;
	private double duration;
	
	public Llamada() {
		super();
	}
	
	public Llamada(String phone, Fecha date, Fecha time, double duration) {
		super();
		this.phone = phone;
		this.date = date;
		this.duration = duration;
		this.time = time;
	}
	
	public String getTelefono() {
		return this.phone;
	}
	
	public double getDuracion() {
		return this.duration;
	}

	@Override
	public Fecha getFecha() {
		return this.date;
	}

	public Fecha getTime() {return this.time;}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[ Tel: ");
		builder.append(this.phone);
		builder.append(", Fecha llamada: ");
		builder.append(this.date.toString());
		builder.append(", Tiempo: ");
		builder.append(this.duration);
		builder.append(" ]");
		return builder.toString();
	}
}