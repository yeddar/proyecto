package Modelo.datos.clientes;

import Modelo.datos.Fecha;

public class Particular extends Cliente {
	private String surnames;

    public Particular(Fecha dischargeDate, String postalCode, String province, String city, String nif, String name, String surnames, String email){
        super(dischargeDate, postalCode, province, city, nif,name,email);
        this.surnames = surnames;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.deleteCharAt(builder.length()-1);
        builder.append(", Surnames: "+surnames);
        builder.append(" ]");
        return builder.toString();

    }
}
