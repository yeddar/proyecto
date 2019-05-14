package View.menu;

import Modelo.datos.Cartera;
import View.facturas.DatoFactura;
import controlador.Facturas.EmiteFactura;
import View.facturas.ListarFacturas;
import View.facturas.ListarFacturasFecha;


public enum OptionsFactura {
    SALIR("Salir.", new Salir()),
    EMITE_FACTURA("Emitir factura", new EmiteFactura()),
    MUESTRA_FACTURA("Mostrar factura cliente", new DatoFactura()),
    LISTA_FACTURAS("Listar todas las facturas", new ListarFacturas()),
    FACTURAS_POR_FECHA("Listar facturas por fecha", new ListarFacturasFecha());


    private String description;
    private EjecutaOpcion ejecutaOpcion;

    private OptionsFactura(String description, EjecutaOpcion ejecutaOpcion){
        this.description = description;
        this.ejecutaOpcion = ejecutaOpcion;
    }

    public String getDescription(){
        return description;
    }

    public static OptionsFactura getOption(int position){
        return values()[position];
    }


    public static String getMenu(){
        StringBuilder sb = new StringBuilder();

        for(OptionsFactura option : OptionsFactura.values()){
            sb.append(option.ordinal());
            sb.append(".- ");
            sb.append(option.getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void ejecuta(Cartera cartera){ ejecutaOpcion.ejecuta(cartera);}
}
