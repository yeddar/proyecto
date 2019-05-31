package Modelo.datos;

import java.io.Serializable;

public class Address implements Serializable {

	protected String postalCode;
    protected String province;
    protected String city;

    public Address(){
        super();
    }

    public Address(String postalCode, String province, String city){
        super();
        this.postalCode = postalCode;
        this.province = province;
        this.city = city;
    }

    public String getPostalCode(){
        return postalCode;
    }

    public String getProvince(){
        return province;
    }

    public String getCity(){
        return city;
    }
}
