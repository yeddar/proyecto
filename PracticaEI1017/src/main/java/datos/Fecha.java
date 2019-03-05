package datos;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {
	private Calendar dia;
	
	public Fecha() {
		super();
	}
	
	public Fecha(Calendar calendar) {
		super();
		this.dia = calendar;
	}
	
	public Fecha(int year, int month, int day) {
		super();
		dia = new GregorianCalendar();
		dia.set(year, month-1, day);;
	}
	
	public int getYear() {
		return dia.get(Calendar.YEAR);
	}
	
	public int getMonth() {
		return dia.get(Calendar.MONTH);
	}
	
	public int getDay() {
		return dia.get(Calendar.DAY_OF_MONTH);
	}
	
	public Calendar getDia() {
		return dia;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(dia.get(Calendar.DAY_OF_MONTH));
		builder.append(" / ");
		builder.append(dia.get(Calendar.MONTH) + 1);
		builder.append(" / ");
		builder.append(dia.get(Calendar.YEAR));
		return builder.toString();
	}
}
