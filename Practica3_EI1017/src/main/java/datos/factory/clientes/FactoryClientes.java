package datos.factory.clientes;

import datos.Fecha;
import datos.clientes.Cliente;
import datos.clientes.Empresa;
import datos.clientes.Particular;

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
