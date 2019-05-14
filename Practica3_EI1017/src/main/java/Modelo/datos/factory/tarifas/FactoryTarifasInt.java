package Modelo.datos.factory.tarifas;

import Modelo.datos.Fecha;
import Modelo.datos.tarifas.Tarifa;

public interface FactoryTarifasInt {
    public Tarifa crearTarifaBasica(double priceMin);

    public Tarifa crearTarifaFranjaHoraria(Tarifa tarifa, double priceMin, Fecha hIni, Fecha hFin);

    public Tarifa crearTrarifaDia(Tarifa tarifa, double priceMin, String day);
}
