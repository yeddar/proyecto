package Modelo.datos.clientes;

import Modelo.datos.Fecha;

public class Empresa extends Cliente {

    public Empresa(Fecha dischargeDate, String postalCode, String province, String city, String nif, String name, String email){
        super(dischargeDate, postalCode, province, city, nif,name,email);
    }
}
