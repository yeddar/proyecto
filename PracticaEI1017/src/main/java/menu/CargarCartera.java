package menu;

import datos.Cartera;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class CargarCartera implements EjecutaOpcion, Serializable {

    @Override
    public void ejecuta(Cartera cartera) {
        try{
            FileInputStream fis = new FileInputStream("cartera.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            ois.close();

            cartera.setClientes(obj);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
