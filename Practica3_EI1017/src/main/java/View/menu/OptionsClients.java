package View.menu;

import controlador.Clientes.CambiaTarifa;
import Modelo.datos.Cartera;
import View.clientes.*;

public enum OptionsClients {

    SALIR("Salir.", new Salir()),
    //ALTA_EMPRESA("Alta empresa.", new AltaEmpresa()),
    //ALTA_PARTICULAR("Alta Particular.", new AltaParticular()),
    BUSCA_CLIENTE("Buscar cliente.", new BuscarPorNif()),
    LISTA_CLIENTES("Listar todos los clientes", new ListarClientes()),
    //BAJA_CLIENTE("Baja cliente", new BajaCliente()),
    ANADIR_OFERTA("Modificar la tarifa", new CambiaTarifa());
    //CLIENTES_POR_FECHA("Listar clientes por fecha", new ListarClientesFecha());

    private String description;
    private EjecutaOpcion ejecutaOpcion;

    private OptionsClients(String description, EjecutaOpcion ejecutaOpcion){
        this.description = description;
        this.ejecutaOpcion = ejecutaOpcion;
    }

    public String getDescription(){
        return description;
    }

    public static View.menu.OptionsClients getOption(int position){
        return values()[position];
    }


    public static String getMenu(){
        StringBuilder sb = new StringBuilder();

        for(View.menu.OptionsClients option : View.menu.OptionsClients.values()){
            sb.append(option.ordinal());
            sb.append(".- ");
            sb.append(option.getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void ejecuta(Cartera cartera){ ejecutaOpcion.ejecuta(cartera);}
}


