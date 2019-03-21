package menu;

import datos.Cartera;

import static javafx.application.Platform.exit;

public class Salir implements EjecutaOpcion {
    @Override
    public void ejecuta(Cartera cartera) {
        exit();

    }
}
