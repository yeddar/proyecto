package Modelo.datos.factory.clientes;

import Modelo.datos.Fecha;
import Modelo.datos.clientes.Cliente;

public interface FactoryClientesInt {

    public Cliente crearParticular(Fecha dischargeDate, String postalCode, String province, String city, String nif, String name, String surnames, String email);

    public Cliente crearEmpresa(Fecha dischargeDate, String postalCode, String province, String city, String nif, String name, String email);
}
