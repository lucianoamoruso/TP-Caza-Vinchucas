package vinchucas_app_web;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class VotosDeVerificacionTestCase {

	private VotosDeVerificacion votosDeVerificacion;
	private Participante participante;
	
	
	@BeforeEach
	public void setUp() {
		votosDeVerificacion = new VotosDeVerificacion("X");
		participante = mock(Participante.class);
	}
	
	
	@Test
	public void testConstructor() {
		
		//Exercise
		String nombreActual = votosDeVerificacion.getNombre();
		int puntosActual = votosDeVerificacion.getPuntos();
		
		//Verify
		assertEquals("X", nombreActual);
		assertEquals(0, puntosActual);
		
		
	}
	
	@Test
	public void testVotar() {
		
		//Fixture
		when(participante.getValorDeConocimiento()).thenReturn(10);
		
		//Exercise
		votosDeVerificacion.votar(participante);
		int puntosActual = votosDeVerificacion.getPuntos();
		
		//Verify
		assertEquals(10, puntosActual);
		verify(participante, times(1)).getValorDeConocimiento();
		
	}
	
}
