package datos;

import java.time.LocalDate;


public class Fecha {
    private LocalDate date;

    public Fecha(){
        super();
    }

    public Fecha(LocalDate date){
        this.date = date;
    }

    public Fecha(String day, String month, String year){
        this.date = LocalDate.parse(year+"-"+month+"-"+day);
    }

    public LocalDate getFecha(){
        return date;
    }

    public boolean insideOf(Fecha inicio, Fecha fin){
        if((this.date.compareTo(inicio.date) >= 0) && this.date.compareTo(fin.date) <= 0)
            return true;
        else
            return false;
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
