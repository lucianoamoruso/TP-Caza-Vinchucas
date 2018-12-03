package vinchucas_app_web;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class VerificacionTestCase {

	private Verificacion verificacion;
	private Participante participante;
	private TipoVinchuca tipo;
	
	
	@Test
	public void testDeUnaVerificacionDeUnParticipanteQueTieneelMayorNivelDeConocimiento() {
		
		//SetUp
		participante = mock(Participante.class); //Stub
		tipo = mock(TipoVinchuca.class); //Dummy
		
		verificacion = new Verificacion(participante, tipo); 
		
		//Fixture
		when(participante.getValorDeConocimiento()).thenReturn(10);
		
		//Exercise
		int actual = verificacion.valorDeVerificacion();

		
		//Verify
		assertEquals(10, actual);

	}
	
	@Test
	public void testDeUnaVerificacionDeUnParticipanteConNivelDeConocimientoBasico() {
		
		//SetUp

		participante = mock(Participante.class); //Stub
		tipo = mock(TipoVinchuca.class);//Dummy
		verificacion = new Verificacion(participante, tipo);
		
		//fixture
		when(participante.getValorDeConocimiento()).thenReturn(1);
		
		//Exercise
		int actual = verificacion.valorDeVerificacion();
		
		//Verify
		assertEquals(1, actual);
		
		
	}

}
