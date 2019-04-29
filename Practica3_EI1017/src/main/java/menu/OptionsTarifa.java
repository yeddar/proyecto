package menu;

import datos.Cartera;
import menu.clientes.CambiaTarifa;


public enum OptionsTarifa {
    SALIR("Salir.", new Salir()),
    MODIFICA_TARIFA("Modificar la tarifa", new CambiaTarifa());


    private String description;
    private EjecutaOpcion ejecutaOpcion;

    private OptionsTarifa(String description, EjecutaOpcion ejecutaOpcion){
        this.description = description;
        this.ejecutaOpcion = ejecutaOpcion;
    }

    public String getDescription(){
        return description;
    }

    public static OptionsTarifa getOption(int position){
        return values()[position];
    }


    public static String getMenu(){
        StringBuilder sb = new StringBuilder();

        for(OptionsTarifa option : OptionsTarifa.values()){
            sb.append(option.ordinal());
            sb.append(".- ");
            sb.append(option.getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void ejecuta(Cartera cartera){ ejecutaOpcion.ejecuta(cartera);}
}

