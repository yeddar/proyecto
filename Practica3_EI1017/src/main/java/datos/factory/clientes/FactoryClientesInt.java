package datos.factory.clientes;

import datos.Fecha;
import datos.clientes.Cliente;

public interface FactoryClientesInt {

    public Cliente crearParticular(Fecha dischargeDate, String postalCode, String province, String city, String nif, String name, String surnames, String email);

    public Cliente crearEmpresa(Fecha dischargeDate, String postalCode, String province, String city, String nif, String name, String email);
}
