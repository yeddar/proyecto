package Modelo.datos.factory.tarifas;

import Modelo.datos.Fecha;
import Modelo.datos.tarifas.PorDia;
import Modelo.datos.tarifas.PorFranjaHoraria;
import Modelo.datos.tarifas.Tarifa;
import Modelo.datos.tarifas.TarifaBasica;

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
