package menu;

import datos.Cartera;

import java.io.*;

public class GuardarCartera implements Serializable, EjecutaOpcion {
    @Override
    public void ejecuta(Cartera cartera){
        try{
            FileOutputStream fos = new FileOutputStream("cartera.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(cartera.getClientes());
            oos.close();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
