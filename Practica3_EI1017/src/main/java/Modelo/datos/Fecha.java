package Modelo.datos;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;


public class Fecha implements Serializable {
    private LocalDate date;
    private LocalTime time;

    public Fecha(){
        super();
    }

    public Fecha(LocalDate date, LocalTime time){
        this.date = date;
        this.time = time;
    }
    public Fecha(String hour, String minute){
        this.time = LocalTime.parse(hour+":"+minute);
    }


    public Fecha(String day, String month, String year){
        this.date = LocalDate.parse(year+"-"+month+"-"+day);

    }

    public LocalDate getFecha(){
        return date;
    }

    public LocalTime getTime() { return time;}

    public boolean insideOfDate(Fecha inicio, Fecha fin){
        if((this.date.compareTo(inicio.date) >= 0) && this.date.compareTo(fin.date) <= 0)
            return true;
        else
            return false;
    }

    public boolean inisdeOfTime(Fecha inicio, Fecha fin) {
        if((this.time.compareTo(inicio.time) >= 0) && this.time.compareTo(fin.time) <= 0)
            return true;
        else
            return false;
    }

    public String getDayOfWeek(){
        return this.date.getDayOfWeek().toString();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(date.getDayOfMonth());
        builder.append(" of ");
        builder.append(date.getMonth());
        builder.append(" ");
        builder.append(date.getYear());
        return builder.toString();
    }

}