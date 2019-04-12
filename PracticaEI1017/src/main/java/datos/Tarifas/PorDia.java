package datos.Tarifas;

import datos.Llamada;

public class PorDia extends Tarifa{
    private Tarifa tarifa;

    public PorDia(Tarifa tarifa){
        super(0.00);
        this.tarifa = tarifa;

    }

    @Override
    public double getPrice(Llamada llamada){
        if(llamada.getFecha().getDayOfWeek().equals("SUNDAY"))
            return super.getPrice(llamada);
        else
            return tarifa.getPrice(llamada);
    }
}
