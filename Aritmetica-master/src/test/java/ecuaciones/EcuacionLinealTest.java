package ecuaciones;

import static org.junit.Assert.*;

import org.junit.Test;

import ecuacion.EcuacionLineal;

public class EcuacionLinealTest {

	@Test
	public void terminoIndependienteCeroTest(){
		EcuacionLineal ecuacionLineal = new EcuacionLineal(1, 0); // x + 0 = 0
		// A partir de aquí, el código que comprueba que la solución es correcta
		double resultado = ecuacionLineal.devuelveSolución();
		assertEquals(0.0,resultado,0.0);
	}

	@Test
	public void terminoXCeroTest() throws Exception {
		EcuacionLineal ecuacionLineal = new EcuacionLineal(0, 1); // x + 0 = 0
		if(ecuacionLineal.términoX == 0)
			throw new java.lang.ArithmeticException("División por 0");
	}

	@Test
	public void distintosDeCeroTest() {
		EcuacionLineal ecuacionLineal = new EcuacionLineal(1, 1); // x + 1 = 0
		// A partir de aquí, el código que comprueba que la solución es correcta
		double resultado = ecuacionLineal.devuelveSolución();
		double esperado = (-ecuacionLineal.términoIndependiente)/(ecuacionLineal.términoX);
		assertEquals(esperado,resultado,0.0);

		ecuacionLineal = new EcuacionLineal(2, 1); // 2x + 1 = 0
		// A partir de aquí, el código que comprueba que la solución es correcta
		resultado = ecuacionLineal.devuelveSolución();
		esperado = (-ecuacionLineal.términoIndependiente)/(ecuacionLineal.términoX);
		assertEquals(esperado,resultado,0.0);

	}

}
