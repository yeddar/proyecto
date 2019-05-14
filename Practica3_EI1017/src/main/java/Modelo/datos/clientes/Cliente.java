package Modelo.datos.clientes;

import Modelo.datos.*;
import Modelo.datos.tarifas.Tarifa;
import Application.main.MainMenu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO abstract añadido.

public abstract class Cliente implements Fechas, Serializable {

	private Address address;
    private Map<String, Factura> facturas;
    private List<Llamada> llamadas;
    private Tarifa tarifaBase;
    private Fecha dichargeDate;
    private String nif;
    private String name;
    private String email;

    public Cliente(Fecha dischargeDate, String postalCode, String province, String city, String nif, String name, String email){
        super();
        this.address = new Address(postalCode,province,city);
        this.facturas = new HashMap<String, Factura>();
        this.llamadas = new ArrayList<Llamada>();
        this.tarifaBase = MainMenu.factoryTarifas.crearTarifaBasica(0.15);
        this.email = email;
        this.name = name;
        this.nif = nif;
        this.dichargeDate = dischargeDate;
    }

    public String getNombre() {
    	return name;
    }

    public String getNif(){ 
    	return nif;
    }

    public String getEmail(){
    	return email;
    }

    public Address getAddress(){
    	return address;
    }
    
    public Factura getFactura(String code){
    	return facturas.get(code);
    }
    
    public Map<String, Factura> getListaFacturas(){
    	return facturas;
    }

    public Tarifa getTarifa() {
    	return tarifaBase;
    } //TODO No sacar tarifa directamente

    public void setTarifa(Tarifa tarifa){
    	tarifaBase = tarifa;
    }

    public List<Llamada> getLlamadas(){
        return llamadas;
    }

    public void altaLlamada(Llamada llamada) {
        llamadas.add(llamada);
    }
    
    public void altaFactura(String code, Factura factura) {
    	facturas.put(code, factura);
    }

    @Override
    public Fecha getFecha(){
        return dichargeDate;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[ ");
        builder.append("Nif: "+nif);
        builder.append(", ");
        builder.append("Name: "+name);
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
        builder.append(" ]");
        return builder.toString();
    }
}
