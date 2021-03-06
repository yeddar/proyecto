package Modelo.datos.test;

import Modelo.datos.factory.clientes.FactoryClientes;
import Modelo.datos.factory.tarifas.FactoryTarifas;
import Modelo.datos.tarifas.PorDia;
import Modelo.datos.tarifas.PorFranjaHoraria;
import Modelo.datos.tarifas.Tarifa;
import Modelo.datos.tarifas.TarifaBasica;
import Modelo.datos.clientes.Cliente;
import Modelo.datos.clientes.Empresa;
import Modelo.datos.clientes.Particular;
import org.junit.Test;

import Modelo.datos.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.*;
import static org.junit.Assert.assertEquals;

import java.util.List;

public class DatosTest {
	private static Cartera cartera = new Cartera();

	// TODO Todavía falta pulir los test por falta de tiempo.


	@Test
	public void testFactoria(){
		FactoryClientes factoriaClientes = new FactoryClientes();
		FactoryTarifas factoriaTarifas = new FactoryTarifas();

		Fecha fechaAlta = new Fecha();
		Cliente cliente1 = new Particular(fechaAlta,"12170","cas","cas","1234", "Jose","Gil", "josegil");
		Cliente cliente2 = factoriaClientes.crearParticular(fechaAlta,"12170","cas","cas","1234", "Jose","Gil", "josegil");
		assertEquals(cliente1.getNif(), cliente2.getNif());

		Cliente cliente3 = new Empresa(fechaAlta,"12170","cas","cas","1234", "Jose", "josegil");
		Cliente cliente4 = factoriaClientes.crearEmpresa(fechaAlta,"12170","cas","cas","1234", "Jose", "josegil");
		assertEquals(cliente3.getNif(), cliente4.getNif());

		Tarifa tarifaBase = new TarifaBasica(0.20);
		Tarifa tarifa1 = new PorDia(tarifaBase, 0.10, "SUNDAY");
		Tarifa tarifa2 = factoriaTarifas.crearTrarifaDia(tarifaBase, 0.10, "SUNDAY");
		assertEquals(tarifa1.getPriceMin(), 0.10, 0);
		assertEquals(tarifa1.getPriceMin(), tarifa2.getPriceMin(),0);
	}

	@Test
	public void testTarifas(){
		Tarifa tarifa = new TarifaBasica(0.15);
		tarifa = new PorFranjaHoraria(tarifa, 0.01, new Fecha("16","00"), new Fecha("20","00"));
		tarifa = new PorDia(tarifa, 0.02, "SATURDAY");
		tarifa = new PorFranjaHoraria(tarifa, 0.05, new Fecha("12","00"), new Fecha("15","00"));

		Llamada llamada = new Llamada("987654321",new Fecha("13","04","2019"), new Fecha("16","00"), 1);
		assertThat(tarifa.getPrice(llamada), is(0.01));
	}

	@Test
	public void TestNullClientes(){
		Cliente cliente1 = new Particular(new Fecha("20","02","2019"), "12170", "cas", "san", "20612594V", "Jose", "Gil", "cocsi" );
		Cliente cliente2 = new Empresa(new Fecha("10","02","2019"), "12170", "cas", "san", "B2345678", "Diego", "diego");
		cartera.nuevoCliente(cliente1);
		cartera.nuevoCliente(cliente2);
		assertEquals(cartera.buscarPorNif("20612594V"), cliente1);
		assertEquals(cartera.buscarPorNif("B2345678"), cliente2);
	}
	
	@Test
	public void TestBorrarClientes() {
		// TODO ¿Como sabeis que este?
		cartera.eliminaCliente("B2345678");
		assertThat(cartera.buscarPorNif("B2345678"), nullValue());
	}
	
	@Test
	public void TestAnadirLlamada() {
		cartera.buscarPorNif("20612594V").altaLlamada(new Llamada("987654321", new Fecha("24","02","2019"),new Fecha("00","00"), 4));
		List<Llamada> listaLlamadas = cartera.buscarPorNif("20612594V").getLlamadas();
		for (Llamada llamada : listaLlamadas) {
			assertEquals(llamada.getTelefono(), "987654321");
		}
	}
	
	// No hemos podido crear un test para comprobar el correcto funcionamiento de la creacion de una factura debido a que hay un problema que no entendemos con el buscarPorNif, ya que devuelve null cuando no deberia.
	// Esto es lo que teniamos
	// TODO Contestando vuestra duda: Recordad que las pruebas son independientes, es decir, no podeis suponer que vuestra cartera contenga Modelo.datos a menos que la inicieis en un metodo anotado con @Before, que no es vuestro caso.
	/*
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
	*/
}
