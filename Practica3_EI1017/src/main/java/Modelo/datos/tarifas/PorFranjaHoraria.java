package Modelo.datos.tarifas;

import Modelo.datos.Fecha;
import Modelo.datos.Llamada;

import java.io.Serializable;

public class PorFranjaHoraria extends Extra implements Serializable {
    private Fecha hIni;
    private Fecha hFin;

    public PorFranjaHoraria(Tarifa tarifa, double priceMin, Fecha hIni, Fecha hFin){
        super(tarifa, priceMin);
        this.hFin = hFin;
        this.hIni = hIni;
    }

    @Override
    public double getPrice(Llamada llamada){
        if(llamada.getTime().inisdeOfTime(hIni,hFin))
            return Math.min(priceMin, tarifa.getPrice(llamada));
        else
            return tarifa.getPrice(llamada);
    }

}
