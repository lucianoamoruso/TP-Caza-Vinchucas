package vinchucas_app_web;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class ParticipanteTestCase {

	private Participante participante; //SUT
	private AppWeb aplicacion;
	private TipoVinchuca tipo;
	private Muestra muestra;
	private NivelDeConocimientoBasico nivel;
	
	@BeforeEach
	public void setUp() { //SetUp
		nivel = mock(NivelDeConocimientoBasico.class);
		aplicacion = mock(AppWeb.class);
		tipo = mock(TipoVinchuca.class); //Dummy
		participante = new Participante("Juan", aplicacion, nivel);
		muestra = mock(Muestra.class);
	}
	
	@Test
	void testConstructor() {
		
		when(nivel.getValorDeConocimiento()).thenReturn(1);
		
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
	public void testParticipanteNuevoHaceUnaRevision() {
		
		//Exercise
		participante.verificarMuestra(muestra, tipo);
		int revisiones = participante.getCantidadDeRevisiones();
		
		//Verify
		verify(muestra).addVerificacion(any(Verificacion.class));
		assertEquals(1, revisiones);
		
	}
	
	@Test
	public void testParticipanteNuevoEspecialista() {
			
		//SetUp
		
		NivelDeConocimientoEspecialista nivelDeEsteban = mock(NivelDeConocimientoEspecialista.class);
		Participante participanteEspecialista = new Participante("Esteban", aplicacion, nivelDeEsteban);
		
		//Fixture
		when(nivelDeEsteban.getValorDeConocimiento()).thenReturn(10);
		
		//Exercise
		int valorConocimiento = participanteEspecialista.getValorDeConocimiento();
		int envios = participanteEspecialista.getCantidadDeEnvios();
		int revisiones = participanteEspecialista.getCantidadDeRevisiones();
		
		//Verify
		assertEquals(10, valorConocimiento);
		assertEquals(0, envios);
		assertEquals(0, revisiones);
	}

}
