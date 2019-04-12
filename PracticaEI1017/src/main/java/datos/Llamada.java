package datos;


import datos.Tarifas.PorDia;
import datos.Tarifas.PorFranjaHoraria;
import datos.Tarifas.Tarifa;
import datos.Tarifas.TarifaBasica;
import datos.clientes.Cliente;

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

	public double getPrice(Cliente cliente) { //TODO Ahora llamada devuelve el precio de la llamada aplicando TODAS las tarifas
		Tarifa tarifa = cliente.getTarifa();
		tarifa = new TarifaBasica(tarifa);
		tarifa = new PorFranjaHoraria(tarifa);
		tarifa = new PorDia(tarifa);
		return tarifa.getPrice(this);
	}
	
	public String getTelefono() {
		return this.phone;
	}
	
	public double getTiempo() {
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