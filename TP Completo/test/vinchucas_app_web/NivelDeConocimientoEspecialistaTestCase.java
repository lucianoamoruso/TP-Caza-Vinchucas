package vinchucas_app_web;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NivelDeConocimientoEspecialistaTestCase {

	private NivelDeConocimientoEspecialista instancia;
	
	
	@BeforeEach
	public void setUp() {
		
		instancia = NivelDeConocimientoEspecialista.getInstance();
		
	}
	
	@Test
	void testObtenerValorDeConocimiento() {
		
		//Exercise
		Integer valorDeConocimientoActual = instancia.getValorDeConocimiento();
		
		//Verify
		Integer expected = new Integer(10);
		assertEquals(expected, valorDeConocimientoActual);
	}

}
