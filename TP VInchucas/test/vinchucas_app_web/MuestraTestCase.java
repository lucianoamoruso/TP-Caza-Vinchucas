package vinchucas_app_web;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class MuestraTestCase {

	private IParticipante recolector;
	private Ubicacion ubicacion;
	private TipoVinchuca tipo;
	private Muestra muestra;
	
	@Test
	void testConstructorDeUnaNuevaMuestraDeTipoVinchicaDeUnParticipanteQueRecienEmpiezaLlamadoPedro() {
		
		//SetUp
		recolector = mock(IParticipante.class);
		ubicacion = mock(Ubicacion.class);
		tipo = mock(TipoVinchuca.class);
		muestra = new Muestra(recolector, ubicacion, tipo);
		
		//Fixture
		when(recolector.getAlias()).thenReturn("Pedro");
		when(recolector.getValorDeConocimiento()).thenReturn(1);
		
		//Exercise
		int veracidadDeLaMuestra = muestra.veracidadDeLaMuestra();
		String alias = muestra.aliasDelRecolector();
		String nivelDeVerificacion = muestra.nivelDeVerficacion();
		
		//Verify
		assertEquals(1, veracidadDeLaMuestra);
		assertEquals("Pedro", alias);
		assertEquals("Baja", nivelDeVerificacion);
		assertTrue(muestra.getVerificadores().contains(recolector));
			
	}
	
	@Test
	public void testVerificacionConNivelDeVerificacionMedia() {
		
		//SetUp
		ubicacion = mock(Ubicacion.class);
		recolector = mock(IParticipante.class);
		IParticipante basico = mock(IParticipante.class);
		tipo = mock(TipoVinchuca.class);
		muestra = new Muestra(recolector, ubicacion, tipo);
		Verificacion verificacion = mock(Verificacion.class);
		
		
		//Fixture
		when(recolector.getValorDeConocimiento()).thenReturn(1);
		when(verificacion.valorDeVerificacion()).thenReturn(1);
		when(verificacion.getTipoVinchuca()).thenReturn(tipo);
		when(basico.getValorDeConocimiento()).thenReturn(1);
		
		
		//Exercise
		muestra.addVerificacion(verificacion);
		int valorDeVerificacionDeLaMuestra = muestra.valorDeVerificacionDeLaMuestra();
		String nivelDeVerificacion = muestra.nivelDeVerficacion();
		
		assertEquals(2, valorDeVerificacionDeLaMuestra);
		assertEquals("Media", nivelDeVerificacion);
	}

	
	@Test
	public void testMuestraCreadaPorUnRecolectorConNivelDeConocimienoAltoYUnParticipanteBasicoDiscrepa() {
		
		//SetUp
		recolector = mock(IParticipante.class);
		IParticipante basico = mock(IParticipante.class);
		TipoVinchuca tipoDelBasico = mock(TipoVinchuca.class);
		ubicacion = mock(Ubicacion.class);
		tipo = mock(TipoVinchuca.class);
		muestra = new Muestra(recolector, ubicacion, tipo);
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
		int valorDeVerificacion = muestra.valorDeVerificacionDeLaMuestra();
		String nivelDeVerificacion = muestra.nivelDeVerficacion();
		
		//Verify
		assertEquals(9, valorDeVerificacion);
		assertEquals("Alta", nivelDeVerificacion);
		
	}
}
