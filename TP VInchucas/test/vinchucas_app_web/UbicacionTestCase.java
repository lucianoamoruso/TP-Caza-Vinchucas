package vinchucas_app_web;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class UbicacionTestCase {
	
	private Ubicacion ubicacion1;
	private Ubicacion ubicacion2;
	private Ubicacion ubicacion3;
	private List<Ubicacion> ubicaciones;
	private Muestra muestra1;
	private Muestra muestra2;
	private Muestra muestra3;
		
	@BeforeEach
	public void setUp() {
		//SetUp
		ubicacion1 = new Ubicacion(2, 3);
		ubicacion2 = new Ubicacion(5, 6);
		ubicacion3 = new Ubicacion(0, 0);
		
	}
		
	// distancia entre 3 y 1 = 400.86262447368625
	// distancia entre 3 y 2 = 867.8085613727542
	// distancia entre 1 y 2 = 471.29308683522254

	
	@Test 
	public void testDistanciaEntreUnaUbicacionCOnsigoMisma() {
		
		//Exercise
		double distancia = ubicacion1.distanciaEntreDosUbicaciones(ubicacion1, ubicacion1);
		
		//Verify
		assertEquals(0.0, distancia);
	}

	@Test
	public void testDistanciaEntreDosCoordenadas() {

		//Exercise
		double distancia = ubicacion3.distanciaEntreDosUbicaciones(ubicacion3, ubicacion2); 
		
		//Verify
		assertEquals(867.8085613727542, distancia);
	}
	
	@Test
	public void testUbicacioesAMenosDeXKilometrosDadaUnalistaDeUbicaciones() {
		
		//SetUp
		ubicaciones = new ArrayList<Ubicacion>(); //lista con ubicaciones 1 y 2
		ubicaciones.add(ubicacion1);
		ubicaciones.add(ubicacion2);
		
		//Exercise
		List <Ubicacion> actual = ubicacion3.ubicacionesCercanas(ubicaciones, 450); // lista que me va a retornar
		
		//Verify
		List<Ubicacion> expected = new ArrayList<Ubicacion>(); //Lista con la que quiero comparar
		expected.add(ubicacion1);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testMuestrasAMenosDeXKilometros() {
		
		//SetUp
		List<Muestra> listaDeMuestras = new ArrayList<Muestra>(); //Lista que se envia como parametro
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class); //Muestra de referencia
		listaDeMuestras.add(muestra1);
		listaDeMuestras.add(muestra2);
		
		//Fixture
		when(muestra1.getUbicacion()).thenReturn(ubicacion1);
		when(muestra2.getUbicacion()).thenReturn(ubicacion2);
		when(muestra3.getUbicacion()).thenReturn(ubicacion3);
		
		//Exercise
		List<Muestra> actual= ubicacion3.muestrasCercanas(muestra3, listaDeMuestras, 450);
		
		List<Muestra> expected = new ArrayList<Muestra>();
		expected.add(muestra1);
		
		//Verify
		assertEquals(expected, actual);
	}
}
