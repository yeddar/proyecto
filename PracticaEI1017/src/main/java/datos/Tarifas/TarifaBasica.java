package datos.Tarifas;

import datos.Llamada;

public class TarifaBasica extends Tarifa {

    public TarifaBasica(double priceMin){
        super(priceMin);
    }

    @Override
    public double getPrice(Llamada llamada) {
        return super.getPrice(llamada);
    }
}
