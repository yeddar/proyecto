package Modelo.datos.tarifas;

import Modelo.datos.Llamada;

import java.io.Serializable;

public abstract class Tarifa implements Serializable {
	protected double priceMin;

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

    public double getPriceMin(){return priceMin;}

}
