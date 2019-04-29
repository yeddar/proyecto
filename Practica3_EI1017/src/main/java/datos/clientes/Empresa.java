package datos.clientes;

import datos.Fecha;
import datos.clientes.Cliente;

public class Empresa extends Cliente {

    public Empresa(Fecha dischargeDate, String postalCode, String province, String city, String nif, String name, String email){
        super(dischargeDate, postalCode, province, city, nif,name,email);
    }
}
