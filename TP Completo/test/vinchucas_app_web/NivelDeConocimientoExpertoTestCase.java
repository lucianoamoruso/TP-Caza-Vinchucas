package vinchucas_app_web;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NivelDeConocimientoExpertoTestCase {

	NivelDeConocimientoExperto instancia;
	Participante participante;
	
	
	@BeforeEach
	public void setUp() {
		
		instancia = NivelDeConocimientoExperto.getInstance();
		participante = mock(Participante.class);
	}
	
	
	@Test
	void testObtenerValorDeConocimiento() {
		
		//Exercise
		Integer valorDeConocimientoActual = instancia.getValorDeConocimiento();
		
		//Verify
		Integer expected = new Integer(10);
		assertEquals(expected, valorDeConocimientoActual);
		
	}
	
	@Test
	public void testNoUpdateaParticipante() {
		
		//Fixture
		when(participante.getCantidadDeEnvios()).thenReturn(11);
		when(participante.getCantidadDeRevisiones()).thenReturn(21);
		
		//Exercise
		instancia.update(participante);
		
		//Verify
		verify(participante, times(0)).setNivelDeConocimiento(NivelDeConocimientoBasico.getInstance());
	}

	
	@Test
	public void testUpdateParticipante() {
		
		//Fixture
		when(participante.getCantidadDeEnvios()).thenReturn(1);
		when(participante.getCantidadDeRevisiones()).thenReturn(3);
	
		//Exercise
		instancia.update(participante);
		
		//Verify
		verify(participante, times(1)).setNivelDeConocimiento(NivelDeConocimientoBasico.getInstance());
		
	}
}
