package vinchucas_app_web;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class MuestraTestCase {

	private AppWeb sistema;
	private Participante recolector;
	private Ubicacion ubicacion;
	private TipoVinchuca tipo;
	private Muestra muestra;
	
	@Before
	public void setUp() {
		sistema = mock(AppWeb.class);
		recolector = mock(Participante.class);
		ubicacion = mock(Ubicacion.class);
		tipo = mock(TipoVinchuca.class);
		muestra = new Muestra(sistema, recolector, ubicacion, tipo);
	}
	
	@Test
	public void testConstructorDeUnaNuevaMuestra() {
		//Fixture
		when(recolector.getAlias()).thenReturn("Pedro");
		when(recolector.getValorDeConocimiento()).thenReturn(1);
		
		//Exercise
		String alias = muestra.aliasDelRecolector();
		String nivelDeVerificacion = muestra.nivelDeVerficacion();
		
		//Verify
		assertEquals("Pedro", alias);
		assertEquals("Baja", nivelDeVerificacion);
		assertTrue(muestra.getVerificadores().contains(recolector));
			
	}
	
	@Test
	public void testVerificacionConNivelDeVerificacionMedia() {
		//SetUp
		Participante basico = mock(Participante.class);
		Verificacion verificacion = mock(Verificacion.class);
		
		//Fixture
		when(recolector.getValorDeConocimiento()).thenReturn(1);
		when(verificacion.valorDeVerificacion()).thenReturn(1);
		when(verificacion.getTipoVinchuca()).thenReturn(tipo);
		when(basico.getValorDeConocimiento()).thenReturn(1);
		
		//Exercise
		muestra.addVerificacion(verificacion);
		int valorDeVerificacionDeLaMuestra = muestra.valorDeVerificacion();
		String nivelDeVerificacion = muestra.nivelDeVerficacion();
		
		assertEquals(2, valorDeVerificacionDeLaMuestra);
		assertEquals("Media", nivelDeVerificacion);
	}
	
	@Test
	public void testMuestraCreadaPorUnRecolectorConNivelDeConocimienoAltoYUnParticipanteBasicoDiscrepa() {
		//SetUp
		Participante basico = mock(Participante.class);
		TipoVinchuca tipoDelBasico = mock(TipoVinchuca.class);
		Verificacion verificacion = mock(Verificacion.class);
		Verificacion verificacionBasico = mock(Verificacion.class); 
		
		//Fixture
		when(recolector.getValorDeConocimiento()).thenReturn(10);
		when(basico.getValorDeConocimiento()).thenReturn(1);
		
		when(verificacion.valorDeVerificacion()).thenReturn(10);
		when(verificacion.getTipoVinchuca()).thenReturn(tipo);
		when(verificacionBasico.valorDeVerificacion()).thenReturn(1);
		when(verificacionBasico.getTipoVinchuca()).thenReturn(tipoDelBasico);
		
		//Exercise
		muestra.addVerificacion(verificacionBasico);
		int valorDeVerificacion = muestra.valorDeVerificacion();
		String nivelDeVerificacion = muestra.nivelDeVerficacion();
		
		//Verify
		assertEquals(9, valorDeVerificacion);
		assertEquals("Alta", nivelDeVerificacion);
	}
}
