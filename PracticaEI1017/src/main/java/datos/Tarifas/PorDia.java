package datos.Tarifas;

import datos.Llamada;

public class PorDia extends Extra{
    private String day;

    public PorDia(Tarifa tarifa, double priceMin, String day){
        super(tarifa, priceMin);
        this.day = day;
    }

    @Override
    public double getPrice(Llamada llamada){
        if(llamada.getFecha().getDayOfWeek().equals(day))
            return super.getPrice(llamada);
        else
            return tarifa.getPrice(llamada);
    }
}
