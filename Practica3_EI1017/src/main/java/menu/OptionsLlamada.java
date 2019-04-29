package menu;

import datos.Cartera;
import menu.llamadas.AltaLlamada;
import menu.llamadas.ListarLlamadas;
import menu.llamadas.ListarLlamadasFecha;

public enum OptionsLlamada {
    SALIR("Salir.", new Salir()),
    ALTA_LLAMADA("Dar de alta una llamada", new AltaLlamada()),
    LISTA_LLAMADAS("Listado de llamadas sobre cliente", new ListarLlamadas()),
    LLAMADAS_POR_FECHA("Listar llamadas por fecha", new ListarLlamadasFecha());

    private String description;
    private EjecutaOpcion ejecutaOpcion;

    private OptionsLlamada(String description, EjecutaOpcion ejecutaOpcion){
        this.description = description;
        this.ejecutaOpcion = ejecutaOpcion;
    }

    public String getDescription(){
        return description;
    }

    public static OptionsLlamada getOption(int position){
        return values()[position];
    }


    public static String getMenu(){
        StringBuilder sb = new StringBuilder();

        for(OptionsLlamada option : OptionsLlamada.values()){
            sb.append(option.ordinal());
            sb.append(".- ");
            sb.append(option.getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void ejecuta(Cartera cartera){ ejecutaOpcion.ejecuta(cartera);}

}
