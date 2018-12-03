package vinchucas_app_web;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

class ZonaDeCoberturaTestCase {

	private Ubicacion ubicacion1;
	private Ubicacion ubicacion2;
	private Ubicacion ubicacion3;
	private Ubicacion ubicacion4;
	private ZonaDeCobertura zona1;
	private ZonaDeCobertura zona2;
	private ZonaDeCobertura zona3;
	private ZonaDeCobertura zona4;
	private AppWeb aplicacion;
	private Muestra muestra1;
	private Muestra muestra2;
	private Muestra muestra3;
	
	
	@Test
	public void testConstructor() {
		//SetUp
		ubicacion1 = mock(Ubicacion.class);
		aplicacion = mock(AppWeb.class);
		zona1 = new ZonaDeCobertura(ubicacion1, 500, "Zona 1", aplicacion);
		
		//Fixture
		when(ubicacion1.getLatitud()).thenReturn(0d);
		when(ubicacion1.getLongitud()).thenReturn(0d);
		
		//Exercise
		double radio = zona1.getRadio();
		double longitud = zona1.getEpicentro().getLongitud();
		double latitud = zona1.getEpicentro().getLatitud();
		String nombre = zona1.getNombre();
		
		//Verify
		assertEquals(0, longitud);
		assertEquals(0, latitud);
		assertEquals(500, radio);
		assertEquals("Zona 1", nombre);
		verify(ubicacion1, times(1)).getLatitud();
		verify(ubicacion1, times(1)).getLongitud();
	}

	
	@Test
	public void testMuestrasQueSeHanReportadoEnLasZona() {
		
		//SetUp
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);
		
		ubicacion1 = mock(Ubicacion.class);
		ubicacion2 = mock(Ubicacion.class);
		ubicacion3 = mock(Ubicacion.class);
		ubicacion4 = mock(Ubicacion.class);
		
		aplicacion = mock(AppWeb.class);
		
		List<Muestra> appMuestras = new ArrayList<Muestra>();
		appMuestras.add(muestra1);
		appMuestras.add(muestra2);
		appMuestras.add(muestra3);
	
		zona1 = new ZonaDeCobertura(ubicacion1, 300, "Zona", aplicacion);
		
		when(ubicacion1.distanciaEntreDosUbicaciones(ubicacion1, ubicacion2)).thenReturn(200d);
		when(muestra1.getUbicacion()).thenReturn(ubicacion2);
		when(ubicacion1.distanciaEntreDosUbicaciones(ubicacion1, ubicacion3)).thenReturn(100.1);
		when(muestra2.getUbicacion()).thenReturn(ubicacion3);
		when(ubicacion1.distanciaEntreDosUbicaciones(ubicacion1, ubicacion4)).thenReturn(300.1);
		when(muestra3.getUbicacion()).thenReturn(ubicacion4);
		
		when(aplicacion.getMuestras()).thenReturn(appMuestras);
		
		
		//Exercise
		
		List<Muestra> actual = zona1.muestrasQueSeHanReportadoEnLaZona();
		
		//Verify
		
		List<Muestra> expected = new ArrayList<Muestra>();
		expected.add(muestra1);
		expected.add(muestra2);
		
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void testListaDeZonasDeCoberturaQueSeSolapan() {
	
		//SetUp
		ubicacion1 = mock(Ubicacion.class);
		ubicacion2 = mock(Ubicacion.class);
		ubicacion3 = mock(Ubicacion.class);
		ubicacion4 = mock(Ubicacion.class);
		aplicacion = mock(AppWeb.class);
		
		zona1 = new ZonaDeCobertura(ubicacion1, 500, "Zona 1", aplicacion);
		zona2 = mock(ZonaDeCobertura.class);
		zona3 = mock(ZonaDeCobertura.class);
		zona4 = mock(ZonaDeCobertura.class);
		
		
		List<ZonaDeCobertura> list = new ArrayList<ZonaDeCobertura>();
		list.add(zona2);
		list.add(zona3);
		list.add(zona4);
		
		
		//Fixture
		when(zona2.getEpicentro()).thenReturn(ubicacion2);
		when(zona2.getRadio()).thenReturn(100);
		when(zona3.getEpicentro()).thenReturn(ubicacion3);
		when(zona3.getRadio()).thenReturn(700);
		when(zona4.getEpicentro()).thenReturn(ubicacion4);
		when(zona4.getRadio()).thenReturn(250);
		when(aplicacion.getZonasDeCobertura()).thenReturn(list);
		
		when(ubicacion1.distanciaEntreDosUbicaciones(ubicacion1, ubicacion2)).thenReturn(850.1); //no la solapa
		when(ubicacion1.distanciaEntreDosUbicaciones(ubicacion1, ubicacion3)).thenReturn(350.5); //solapa
		when(ubicacion1.distanciaEntreDosUbicaciones(ubicacion1, ubicacion4)).thenReturn(450d);//solapa
		
		
		//Exercise
		List<ZonaDeCobertura> actual = zona1.zonasQueLaSolapan();
		
		
		//Verify
		List<ZonaDeCobertura> expected = new ArrayList<ZonaDeCobertura>();
		expected.add(zona3);
		expected.add(zona4);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSeRegistraUnaOrganizacion() {
		
		//SetUp
		Organizacion organizacion = mock(Organizacion.class);
		zona1 = new ZonaDeCobertura(ubicacion1, 300, "Zona", aplicacion);
		
		//Exercise
		zona1.registrarOrganizacion(organizacion);
		
		//Verify
		assertTrue(zona1.organizacionesRegistradas().contains(organizacion));
		
	}
	
	@Test
	public void testSeDesregistraUnaOrganizacion() {
		
		//SetUp
		Organizacion organizacion = mock(Organizacion.class);
		zona1 = new ZonaDeCobertura(ubicacion2, 100, "Zona1", aplicacion);
		zona1.registrarOrganizacion(organizacion);
		
		//Exercise
		zona1.desregistrarOrganizacion(organizacion);
		
		//Verify
		assertFalse(zona1.organizacionesRegistradas().contains(organizacion));
		
	}
	
	@Test
	public void testTresOrganizacionesRegistradas() {
		
		//SetUp
		zona1 = new ZonaDeCobertura(ubicacion3, 1, "Zona1", aplicacion);
		
		Organizacion organizacion1 = mock(Organizacion.class);
		Organizacion organizacion2 = mock(Organizacion.class);
		Organizacion organizacion3 = mock(Organizacion.class);
		
		zona1.registrarOrganizacion(organizacion1);
		zona1.registrarOrganizacion(organizacion2);
		zona1.registrarOrganizacion(organizacion3);
		
		//Exercise
		List<Organizacion> actual = zona1.organizacionesRegistradas();
		
		//Verify
		List<Organizacion> expected = new ArrayList<Organizacion>();
		expected.add(organizacion1);
		expected.add(organizacion2);
		expected.add(organizacion3);
		
		assertEquals(expected, actual);
	}
	
}
