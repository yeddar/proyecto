package datos.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datos.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.*;
import static org.junit.Assert.assertEquals;

import java.util.List;

public class DatosTest {
	private static Cartera cartera = new Cartera();
	
	@Test
	public void TestNullClientes(){
		Cliente cliente1 = new Particular(new Fecha(2019,2,20), "12170", "cas", "san", "20612594V", "Jose", "Gil", "cocsi" );
		Cliente cliente2 = new Empresa(new Fecha(2019,2,10), "12170", "cas", "san", "B2345678", "Diego", "diego");
		cartera.nuevoCliente(cliente1);
		cartera.nuevoCliente(cliente2);
		assertEquals(cartera.buscarPorNif("20612594V"), cliente1);
		assertEquals(cartera.buscarPorNif("B2345678"), cliente2);
	}
	
	@Test
	public void TestBorrarClientes() {
		cartera.eliminaCliente("B2345678");
		assertThat(cartera.buscarPorNif("B2345678"), nullValue());
	}
	
	@Test
	public void TestAnadirLlamada() {
		cartera.buscarPorNif("20612594V").altaLlamada(new Llamada("987654321", new Fecha(2019,2,24), 4));
		List<Llamada> listaLlamadas = cartera.buscarPorNif("20612594V").getLlamadas();
		for (Llamada llamada : listaLlamadas) {
			assertEquals(llamada.getTelefono(), "987654321");
		}
	}
	
	// No hemos podido crear un test para comprobar el correcto funcionamiento de la creacion de una factura debido a que hay un problema que no entendemos con el buscarPorNif, ya que devuelve null cuando no deberia.
	// Esto es lo que teniamos
	@Test
	public void TestHacerFactura() {
		Cliente cliente = cartera.buscarPorNif("20612594V");
		cliente.altaLlamada(new Llamada("987654321", new Fecha(2019,2,25), 3));
		cliente.altaLlamada(new Llamada("987654321", new Fecha(2019,2,26), 5));
		cliente.setTarifa(2.5);
		Fecha diaInicio = new Fecha(2019,2,23);
		Fecha diaParada = new Fecha(2019,2,28);
		double amount = 0;
		List<Llamada> listaLlamadas = cliente.getLlamadas();
		for (Llamada llamada : listaLlamadas) {
			Fecha actual = llamada.getFecha();
        	if (actual.getDia().compareTo(diaParada.getDia())<=0 && actual.getDia().compareTo(diaInicio.getDia())>=0){  // Es correcta
        		amount = amount + llamada.getTiempo() * cliente.getTarifa().getPriseSec();
        	}
		} double tarifaUsada = cliente.getTarifa().getPriseSec();
		Factura nuevaFactura = new Factura("10", tarifaUsada, new Fecha(2019,3,3), diaInicio, diaParada, amount);
		cliente.altaFactura("10", nuevaFactura);
		assertThat(cliente.getFactura("10").getAmount(), is (30.0));
	}
}
