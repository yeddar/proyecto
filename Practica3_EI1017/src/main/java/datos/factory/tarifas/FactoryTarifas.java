package datos.factory.tarifas;

import datos.Fecha;
import datos.tarifas.PorDia;
import datos.tarifas.PorFranjaHoraria;
import datos.tarifas.Tarifa;
import datos.tarifas.TarifaBasica;

public class FactoryTarifas implements FactoryTarifasInt {
    @Override
    public Tarifa crearTarifaBasica(double priceMin) {
        return new TarifaBasica(priceMin);
    }

    @Override
    public Tarifa crearTarifaFranjaHoraria(Tarifa tarifa, double priceMin, Fecha hIni, Fecha hFin) {
        return new PorFranjaHoraria(tarifa,priceMin,hIni,hFin);
    }

    @Override
    public Tarifa crearTrarifaDia(Tarifa tarifa, double priceMin, String day) {
        return new PorDia(tarifa, priceMin, day);
    }
}
