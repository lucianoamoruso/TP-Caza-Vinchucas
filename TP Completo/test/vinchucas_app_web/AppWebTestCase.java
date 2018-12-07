package vinchucas_app_web;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppWebTestCase {

	private AppWeb aplicacion;
	private ZonaDeCobertura zona;
	private Muestra muestra;
	private Ubicacion ubicacionZona;
	private Ubicacion ubicacionMuestra;
	
	@BeforeEach
	public void setUp() {
		aplicacion = new AppWeb();
		zona = mock(ZonaDeCobertura.class);
		muestra = mock(Muestra.class);
		ubicacionZona = mock(Ubicacion.class);
		ubicacionMuestra = mock(Ubicacion.class);
	}
	
	@Test
	public void testConstructor() {
		
		//Verify

		int cantidadDeMuestrasActual = aplicacion.getMuestras().size();
		int cantidadDeValidacionesActual = aplicacion.getValidaciones().size();
		int cantidadDeTiposActual = aplicacion.getTiposVinchuca().size();
		int cantidadDeZonasActual = aplicacion.getZonasDeCobertura().size();
		
		assertEquals(0, cantidadDeMuestrasActual);
		assertEquals(0, cantidadDeValidacionesActual);
		assertEquals(5, cantidadDeTiposActual);
		assertEquals(0, cantidadDeZonasActual);
	}
	
	@Test
	public void testSeAgregaUnaZonaDeCobertura() {
		
		//Exercise
		aplicacion.addZonaDeCobertura(zona);
		
		//Verify
		int tamaño = aplicacion.getZonasDeCobertura().size();
		assertEquals(1, tamaño);
	}
	
	@Test
	public void testSeAñadeUnNuevoTipoDeVinchuca() {
		
		//Exercise
		aplicacion.nuevoTipoVinchuca("NuevaVinchuca");
		
		//Verify
		int cantidadDeTipos = aplicacion.getTiposVinchuca().size();
		assertEquals(6, cantidadDeTipos);
	}
	
	@Test
	public void testSeAgregaUnaNuevaMuestraQuePerteneceAUnaZonaDeCobertura() {
		
		//SetUp
		aplicacion.addZonaDeCobertura(zona);
		
		//Fixture
		when(muestra.getUbicacion()).thenReturn(ubicacionMuestra);
		when(zona.getEpicentro()).thenReturn(ubicacionZona);
		when(zona.getRadio()).thenReturn(100);
		when(zona.getEpicentro().distanciaEntreDosUbicaciones(zona.getEpicentro(), muestra.getUbicacion())).thenReturn(0d);
		
		//Exercise
		aplicacion.nuevaMuestra(muestra);
		
		//Verify
		int muestrasActual = aplicacion.getMuestras().size();
		assertEquals(1, muestrasActual);
		verify(zona, times(1)).reportarMuestra(muestra);
	}
	
	@Test
	public void testSeAgregaUnaNuevaMuestraQueNoPerteneceAUnaZonaDeCobertura() {
		
		//SetUp
		aplicacion.addZonaDeCobertura(zona);
		
		//Fixture
		when(muestra.getUbicacion()).thenReturn(ubicacionMuestra);
		when(zona.getEpicentro()).thenReturn(ubicacionZona);
		when(zona.getRadio()).thenReturn(100);
		when(zona.getEpicentro().distanciaEntreDosUbicaciones(zona.getEpicentro(), muestra.getUbicacion())).thenReturn(200d);
		
		//Exercise
		aplicacion.nuevaMuestra(muestra);
		
		//Verify
		int muestrasActual = aplicacion.getMuestras().size();
		assertEquals(1, muestrasActual);
		verify(zona, times(0)).reportarMuestra(muestra);
	}

	
	@Test
	public void testSeAgregaUnaNuevaValidacionQuePerteneceAUnaZonaDeCobertura() {
		
		//SetUp
		aplicacion.addZonaDeCobertura(zona);
		
		//Fixture
		when(muestra.getUbicacion()).thenReturn(ubicacionMuestra);
		when(zona.getEpicentro()).thenReturn(ubicacionZona);
		when(zona.getRadio()).thenReturn(100);
		when(zona.getEpicentro().distanciaEntreDosUbicaciones(zona.getEpicentro(), muestra.getUbicacion())).thenReturn(0d);
		
		//Exercise
		aplicacion.nuevaValidacion(muestra);
		
		//Verify
		int validacionesActual = aplicacion.getValidaciones().size();
		assertEquals(1, validacionesActual);
		verify(zona, times(1)).reportarValidacion(muestra);
	}
	
	@Test
	public void testSeAgregaUnaNuevaValidacionQueNoPerteneceAUnaZonaDeCobertura() {
		
		//SetUp
		aplicacion.addZonaDeCobertura(zona);
		
		//Fixture
		when(muestra.getUbicacion()).thenReturn(ubicacionMuestra);
		when(zona.getEpicentro()).thenReturn(ubicacionZona);
		when(zona.getRadio()).thenReturn(100);
		when(zona.getEpicentro().distanciaEntreDosUbicaciones(zona.getEpicentro(), muestra.getUbicacion())).thenReturn(200d);
		
		//Exercise
		aplicacion.nuevaValidacion(muestra);
		
		//Verify
		int validacionesActual = aplicacion.getValidaciones().size();
		assertEquals(1, validacionesActual);
		verify(zona, times(0)).reportarValidacion(muestra);
	}
	
}
