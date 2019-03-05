package datos;

public class Tarifa {
	private double priceMin;

    public Tarifa(){
        this.priceMin = 0.0;
    }

    public Tarifa(double priceSec) {
        this.priceMin = priceSec;
    }

    public double getPriseSec(){
    	return priceMin;
    }

    public void setTarifa(double priceMin) {
        this.priceMin = priceMin;
    }

}
