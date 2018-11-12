package vinchucas_app_web;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class ParticipanteTestCase {

	private Participante participante;
	private AppWeb aplicacion;
	private Ubicacion ubicacion;
	private TipoVinchuca tipo;
	private Muestra muestra;
	
	@Test
	void testConstructor() {
		
		//SetUP
		aplicacion = mock(AppWeb.class);
		participante = new Participante("Juan", aplicacion);
		
		//Exercise
		int envios = participante.getCantidadDeEnvios();
		int revisiones = participante.getCantidadDeRevisiones();
		int valorDeConocimiento = participante.getValorDeConocimiento();
		String alias = participante.getAlias();
		
		//Verify
		assertEquals(0, envios);
		assertEquals(0, revisiones);
		assertEquals(1, valorDeConocimiento);
		assertEquals("Juan", alias);
	}
	
	@Test
	public void testParticipanteNuevoEnviaUnaMuestra() {
		
		//SetUp
		aplicacion = mock(AppWeb.class);
		participante = new Participante("Hector", aplicacion);
		ubicacion = mock(Ubicacion.class); //Dummy
		tipo = mock(TipoVinchuca.class); //Dummy
		
		//Exercise
		participante.enviarMuestra(ubicacion, tipo);
		int envios = participante.getCantidadDeEnvios();
		
		//Verify
		verify(aplicacion).nuevaMuestra(any(Muestra.class));
		assertEquals(1, envios);
		
	}
	
	@Test
	public void testPArticipanteNuevoHaceUnaRevision() {
		
		//SetUp
		aplicacion = mock(AppWeb.class);
		participante = new Participante("Laura", aplicacion);
		tipo = mock(TipoVinchuca.class);
		muestra = mock(Muestra.class);
		
		//Exercise
		participante.verificarMuestra(muestra, tipo);
		int revisiones = participante.getCantidadDeRevisiones();
		
		//Verify
		verify(muestra).addVerificacion(any(Verificacion.class));
		assertEquals(1, revisiones);
		
	}

}
