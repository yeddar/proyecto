package Modelo.datos.tarifas;

import Modelo.datos.Llamada;

import java.io.Serializable;

public class PorDia extends Extra implements Serializable {
    private String day;

    public PorDia(Tarifa tarifa, double priceMin, String day){
        super(tarifa, priceMin);
        this.day = day;
    }

    @Override
    public double getPrice(Llamada llamada){
        if(llamada.getFecha().getDayOfWeek().equals(day))
            return Math.min(priceMin, tarifa.getPrice(llamada));
        else
            return tarifa.getPrice(llamada);
    }
}
