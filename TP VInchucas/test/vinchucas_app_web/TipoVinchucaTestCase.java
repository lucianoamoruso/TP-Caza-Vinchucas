package vinchucas_app_web;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TipoVinchucaTestCase {
	
	private TipoVinchuca vinchuca;
	
	@Test
	void testConstructor() {
		
		vinchuca = new TipoVinchuca("Chince Foliada"); //SetUp
		
		String nombre = vinchuca.getNombre(); //Exercise
		
		assertEquals("Chince Foliada", nombre); //Verify
	
	}
	
}
