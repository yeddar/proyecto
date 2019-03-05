package datos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cliente implements Fecha {

    private Address address;
    private Map<String,Factura> facturas;
    private List<Llamada> llamadas;
    private Tarifa tarifa;
    private String dichargeDate;
    private String nif;
    private String name;
    private String email;

    public Cliente(){
        super();
        this.address = new Address();
        this.facturas = new HashMap<String, Factura>();
        this.llamadas = new ArrayList<Llamada>();
        this.tarifa = new Tarifa();
        this.dichargeDate = "";
        this.nif = "";
        this.name = "";
        this.email = "";
    }

    public Cliente(String dischargeDate, String postalCode, String province, String city, String nif, String name, String email){
        super();
        this.address = new Address(postalCode,province,city);
        this.facturas = new HashMap<String, Factura>();
        this.llamadas = new ArrayList<Llamada>();
        this.tarifa = new Tarifa();
        this.email = email;
        this.name = name;
        this.nif = nif;
        this.dichargeDate = dischargeDate;
    }

    public String getFecha() {
        return dichargeDate;
    }

    public String getNombre() { return name;}

    public String getNif(){ return nif;}

    public String getEmail(){return email;}

    public Address getAddress(){ return address;}

    public String getDischargeDate(){ return dichargeDate;}

    public void setTarifa(double priceSec){this.tarifa.setTarifa(priceSec);}

    public List<Llamada> getLlamadas(){
        return llamadas;
    }

    public void altaLlamada(Llamada llamada) {
        llamadas.add(llamada);
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        builder.append("Name: "+name);
        builder.append(", ");
        builder.append("Nif: "+nif);
        builder.append(", ");
        builder.append("Email: "+email);
        builder.append(", ");
        builder.append("Postal code: "+address.getPostalCode());
        builder.append(", ");
        builder.append("Province: "+address.getProvince());
        builder.append(", ");
        builder.append("City: "+address.getCity());
        builder.append(", ");
        builder.append("Discharge date: "+dichargeDate);
        builder.append(", ");
        builder.append("Tarifa: "+tarifa.getTarifa());
        builder.append("]");
        return builder.toString();
    }
}
