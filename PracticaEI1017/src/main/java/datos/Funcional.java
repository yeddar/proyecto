package datos;

import java.util.ArrayList;
import java.util.List;

public class Funcional {

    public <T extends Fechas>List<T> filtrar(List<T> list, Fecha ini, Fecha fin) {
        List<T> newList = new ArrayList<T>();

        for (T elem : list) {
            // Si la fecha no se encuentra entre el inicio y final se borra el objeto del conjunto.
            if(elem.getFecha().insideOf(ini,fin))
                newList.add(elem);
        }
        return newList;
    }
}
