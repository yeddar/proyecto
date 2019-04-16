package datos.Tarifas;

import datos.Fecha;
import datos.Llamada;

import java.io.Serializable;

public abstract class Tarifa implements Serializable {
	private double priceMin;

    public Tarifa(){
        super();
    }

    public Tarifa(double priceMin) {
        this.priceMin = priceMin;
    }

    public double getPrice(Llamada llamada) {
        return this.priceMin;
    }


    public void setTarifa(double priceMin) {
        this.priceMin = priceMin;
    }

}
