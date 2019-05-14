package Modelo.datos.factory.clientes;

import Modelo.datos.Fecha;
import Modelo.datos.clientes.Cliente;
import Modelo.datos.clientes.Empresa;
import Modelo.datos.clientes.Particular;

public class FactoryClientes implements FactoryClientesInt{

    @Override
    public Cliente crearParticular(Fecha dischargeDate, String postalCode, String province, String city, String nif, String name, String surnames, String email) {
        return new Particular(dischargeDate,postalCode,province,city,nif,name,surnames,email);
    }

    @Override
    public Cliente crearEmpresa(Fecha dischargeDate, String postalCode, String province, String city, String nif, String name, String email) {
        return new Empresa(dischargeDate,postalCode,province,city,nif,name,email);
    }
}
