package datos;

import java.util.Calendar;

public class Llamada implements Fecha{
    private String numbrer;
    private Calendar date;
    private long duration;

    public Llamada(String number, Calendar date, long duration) {
        this.numbrer = number;
        this.date = date;
        this.duration = duration;
    }

    public String getFecha() {
        return date.toString();
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        builder.append("Phone number: "+this.numbrer);
        builder.append(", ");
        builder.append("Date: "+date.DAY_OF_MONTH+"/"+date.MONTH+"/"+date.YEAR);
        builder.append(", ");
        builder.append("Duration: "+this.duration);
        builder.append("]");
        return builder.toString();
    }
}
