package datos;

public class Tarifa {
    private double priceSec;

    public Tarifa(){
        this.priceSec = 0.0;
    }

    public Tarifa(double priceSec) {
        this.priceSec = priceSec;
    }

    public double getTarifa(){ return priceSec;}

    public void setTarifa(double priceSec) {
        this.priceSec = priceSec;
    }
}
