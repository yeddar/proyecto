package Modelo.datos;

import java.util.ArrayList;
import java.util.List;

public class Funcional {

    public <T extends Fechas>List<T> filtrar(List<T> list, Fecha ini, Fecha fin) {
        List<T> newList = new ArrayList<T>();

        for (T elem : list) {
            if(elem.getFecha().insideOfDate(ini,fin))
                newList.add(elem);
        }
        return newList;
    }
}
