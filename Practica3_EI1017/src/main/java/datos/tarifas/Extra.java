package datos.tarifas;

import datos.Llamada;

import java.io.Serializable;

public abstract class Extra extends Tarifa implements Serializable {
    protected Tarifa tarifa;

    public Extra(Tarifa tarifa, double priceMin) {
        super(priceMin);
        this.tarifa = tarifa;
    }

    public double getPrice(Llamada llamada) {
        return tarifa.getPrice(llamada);
    }


}
