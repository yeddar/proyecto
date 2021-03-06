package Modelo.datos.tarifas;

import Modelo.datos.Llamada;

import java.io.Serializable;

public class TarifaBasica extends Tarifa implements Serializable {

    public TarifaBasica(double priceMin){
        super(priceMin);
    }

    @Override
    public double getPrice(Llamada llamada) {
        return priceMin;
    }
}
