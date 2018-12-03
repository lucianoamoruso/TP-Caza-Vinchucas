package vinchucas_app_web;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrganizacionTestCase {

	
	private Organizacion organizacion;
	private Ubicacion ubicacionOrganizacion;
	private FuncionalidadExterna funcionalidadNuevaMuestra;
	private FuncionalidadExterna funcionalidadNuevaValidacion;
	private ZonaDeCobertura zona;
	private Muestra muestra;
	
	@BeforeEach
	public void setUp() {
		ubicacionOrganizacion = mock(Ubicacion.class);
		organizacion = new Organizacion (ubicacionOrganizacion, 15);
		funcionalidadNuevaMuestra = mock(FuncionalidadExterna.class);
		funcionalidadNuevaValidacion = mock(FuncionalidadExterna.class);
		zona = mock(ZonaDeCobertura.class);
		muestra = mock(Muestra.class);
	}
	
	
	@Test
	public void testConstructor() {
		
		//Exercise
		
		Ubicacion ubicacionActual = organizacion.ubicacion();
		Integer cantidadDePersonasActual = organizacion.cantidadDePersonasQueTrabajan();
		
		//Verify
		
		assertEquals(ubicacionOrganizacion, ubicacionActual);
		assertEquals(new Integer(15), cantidadDePersonasActual);
	}

	
	@Test
	public void testOrganizacionSeRegistraEnZona() {
		
		//Exercise
		organizacion.registrarseEnZona(zona);
		
		
		//Verify
		verify(zona, times(1)).registrarOrganizacion(organizacion);
	}
	
	@Test
	public void testOrganizacionSeDesregistraDeZona() {
		
		//Exercise
		organizacion.desregistrarseDeZona(zona);
		
		
		//Verify
		verify(zona, times(1)).desregistrarOrganizacion(organizacion);
		
	}
	
	
	@Test
	public void testOrganizacionSeteaUnaNuevaFuncionalidadDeMuestraYLaEjecuta() {
		
		//SetUp
		organizacion.setFuncionalidadNuevaMuestra(funcionalidadNuevaMuestra);
		
		//Exercise
		organizacion.nuevoEventoMuestra(organizacion, zona, muestra);
		
		//Verify
		verify(funcionalidadNuevaMuestra, times(1)).nuevoEvento(organizacion, zona, muestra);
		
	}
	
	
	public void testOrganizacionSeteaUnaNuevaFuncionalidadDeValidacionYLaEjecuta() {
		
		//SetUp
		organizacion.setFuncionalidadNuevaValidacion(funcionalidadNuevaValidacion);
		
		//Exercise
		
		organizacion.nuevoEventoValidacion(organizacion, zona, muestra);
		
		//Verify
		verify(funcionalidadNuevaValidacion, times(1)).nuevoEvento(organizacion, zona, muestra);
	}
	
}
