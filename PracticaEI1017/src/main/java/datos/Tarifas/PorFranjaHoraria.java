package datos.Tarifas;

import datos.Fecha;
import datos.Llamada;

public class PorFranjaHoraria extends Extra {
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
            return super.getPrice(llamada);
        else
            return tarifa.getPrice(llamada);
    }
}
