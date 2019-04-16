package datos.Tarifas;

import datos.Llamada;

public abstract class Extra extends Tarifa{
    protected Tarifa tarifa;

    public Extra(Tarifa tarifa, double priceMin) {
        super(priceMin);
        this.tarifa = tarifa;
    }

    public double getPrice(Llamada llamada) {
        return super.getPrice(llamada);
    }


}
