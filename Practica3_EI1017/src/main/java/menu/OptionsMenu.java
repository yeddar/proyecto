package menu;

import datos.Cartera;
import menu.clientes.*;
import menu.facturas.DatoFactura;
import menu.facturas.EmiteFactura;
import menu.facturas.ListarFacturas;
import menu.facturas.ListarFacturasFecha;
import menu.llamadas.AltaLlamada;
import menu.llamadas.ListarLlamadas;
import menu.llamadas.ListarLlamadasFecha;

// todo Bien por el patrón de diseño Estrategia
public enum OptionsMenu {
    SALIR("Salir.", new Salir()),
    ALTA_EMPRESA("Alta empresa.", new AltaEmpresa()),
    ALTA_PARTICULAR("Alta Particular.", new AltaParticular()),
    BUSCA_CLIENTE("Buscar cliente.", new BuscarPorNif()),
    MODIFICA_TARIFA("Modificar la tarifa", new CambiaTarifa()),
    //CAMBIA_TARIFA("Cambiar la tarifa", new CambiaTarifa()),
    LISTA_CLIENTES("Listar todos los clientes", new ListarClientes()),
    BAJA_CLIENTE("Baja cliente", new BajaCliente()),
    ALTA_LLAMADA("Dar de alta una llamada", new AltaLlamada()),
    LISTA_LLAMADAS("Listado de llamadas sobre cliente", new ListarLlamadas()),
    EMITE_FACTURA("Emitir factura", new EmiteFactura()),
    MUESTRA_FACTURA("Mostrar factura cliente", new DatoFactura()),
    LISTA_FACTURAS("Listar todas las facturas", new ListarFacturas()),
    CLIENTES_POR_FECHA("Listar clientes por fecha", new ListarClientesFecha()),
    LLAMADAS_POR_FECHA("Listar llamadas por fecha", new ListarLlamadasFecha()),
    FACTURAS_POR_FECHA("Listar facturas por fecha", new ListarFacturasFecha());


    private String description;
    private EjecutaOpcion ejecutaOpcion;

    private OptionsMenu(String description, EjecutaOpcion ejecutaOpcion){
        this.description = description;
        this.ejecutaOpcion = ejecutaOpcion;
    }

    public String getDescription(){
        return description;
    }

    public static OptionsMenu getOption(int position){
        return values()[position];
    }


    public static String getMenu(){
        StringBuilder sb = new StringBuilder();

        for(OptionsMenu option : OptionsMenu.values()){
            sb.append(option.ordinal());
            sb.append(".- ");
            sb.append(option.getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void ejecuta(Cartera cartera){ ejecutaOpcion.ejecuta(cartera);}
}

