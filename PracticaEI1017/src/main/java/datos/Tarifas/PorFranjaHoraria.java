package datos.Tarifas;

import datos.Fecha;
import datos.Llamada;

public class PorFranjaHoraria extends Tarifa {
    private Tarifa tarifa;

    public PorFranjaHoraria(Tarifa tarifa){
        super(0.05);
        this.tarifa = tarifa;
    }

    @Override
    public double getPrice(Llamada llamada){
        Fecha ini = new Fecha("16","00");
        Fecha fin = new Fecha("20","00");

        if(llamada.getTime().inisdeOfTime(ini,fin))
            return super.getPrice(llamada);
        else
            return tarifa.getPrice(llamada);
    }
}
