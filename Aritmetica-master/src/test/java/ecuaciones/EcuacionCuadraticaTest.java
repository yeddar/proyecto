package ecuaciones;

import static org.junit.Assert.*;

import ecuacion.EcuacionCuadratica;
import org.junit.Test;

public class EcuacionCuadraticaTest {
    private static EcuacionCuadratica ecuacionCuadratica;

    @Test
    public void términoACeroTest() {
        ecuacionCuadratica = new EcuacionCuadratica(0.0, 1.0, 2.0);
        ecuacionCuadratica.calcularSolucion();
        assertEquals(0.0,ecuacionCuadratica.x1,0.0);
        assertEquals(-2.0,ecuacionCuadratica.x2,0.0);
    }

    @Test
    public void terminoIndependienteCeroTest() throws Exception {
        ecuacionCuadratica = new EcuacionCuadratica(2.0, 1.0, 0.0);
        ecuacionCuadratica.calcularSolucion();
        assertEquals(0.0,ecuacionCuadratica.x1,0.0);
        assertEquals(-0.5,ecuacionCuadratica.x2,0.0);

    }

    @Test
    public void raizNegativa() throws ArithmeticException {
        ecuacionCuadratica = new EcuacionCuadratica(1, 1, 1);
        try {
            ecuacionCuadratica.calcularSolucion();
            fail("No se contempla el caso de raíz negativa.");
        } catch (ArithmeticException e){

        }
    }


}
