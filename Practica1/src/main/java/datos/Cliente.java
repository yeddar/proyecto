package datos;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private class Address{
        private String postalCode;
        private String province;
        private String city;

    }
    private Address address;
    private List<Factura> facturas;
    private Tarifa tarifa;
    private String startDate;
    private String nif;
    private String name;
    private String email;


    public Cliente(){
        super();
        this.address = new Address();
        this.facturas = new ArrayList<Factura>();
        this.tarifa = new Tarifa();
        this.startDate = "";
        this.nif = "";
        this.name = "";
        this.email = "";

    }

    public Cliente(String startDate, String nif, String name, String email){
        super();
        this.address = new Address();
        this.facturas = new ArrayList<Factura>();
        this.tarifa = new Tarifa();
        this.email = email;
        this.name = name;
        this.nif = nif;
        this.startDate = startDate;
    }
}
