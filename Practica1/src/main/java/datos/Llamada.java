package datos;

public class Llamada implements Fecha{
    private String numbrer;
    private String date;
    private long duration;

    public Llamada(String number, String date, long duration) {
        this.numbrer = number;
        this.date = date;
        this.duration = duration;
    }

    public String getFecha() {
        return date;
    }
}
