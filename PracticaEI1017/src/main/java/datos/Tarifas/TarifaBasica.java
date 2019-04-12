package datos.Tarifas;

public class TarifaBasica extends Tarifa {

    public TarifaBasica(){
        super(0.15);
    }

    public TarifaBasica(Tarifa tarifa){
        super(tarifa.getPriceMin());
    }
}
