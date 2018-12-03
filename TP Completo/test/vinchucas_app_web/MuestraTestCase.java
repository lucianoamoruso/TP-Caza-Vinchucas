package vinchucas_app_web;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class MuestraTestCase {

	private AppWeb			sistema;
	private Participante	recolector;
	private Ubicacion		ubicacion;
	private TipoVinchuca	tipo;
	private Muestra			muestra;
	
	@BeforeEach
	public void setUp() throws Exception {
		sistema = mock(AppWeb.class);
		recolector = mock(Participante.class);
		ubicacion = mock(Ubicacion.class);
		tipo = mock(TipoVinchuca.class);
	}

	@Test
	public void testConstructorDeUnaNuevaMuestra() {
		List<VotosDeVerificacion> votosFalsos = new ArrayList<>();
		votosFalsos.add(new VotosDeVerificacion("Vinchuca"));
		
		//Fixture
		when(sistema.votacionesDisponibles()).thenReturn(votosFalsos);
		when(recolector.getAlias()).thenReturn("Pedro");
		when(recolector.getValorDeConocimiento()).thenReturn(1);
		when(tipo.getNombre()).thenReturn("Vinchuca");
		
		//Setup
		muestra = new Muestra(sistema, recolector, ubicacion, tipo);
		
		//Exercise
		String alias = muestra.aliasDelRecolector();
		String nivelDeVerificacion = muestra.nivelDeVerficacion();
		Ubicacion ubicacionActual = muestra.getUbicacion();
		
		//Verify
		assertEquals("Pedro", alias);
		assertEquals("Baja", nivelDeVerificacion);
		assertTrue(muestra.getVerificadores().contains(recolector));
		assertEquals(ubicacion, ubicacionActual);
	}
	
	@Test
	public void testVerificacionConNivelDeVerificacionMedia() {
		List<VotosDeVerificacion> votosFalsos = new ArrayList<>();
		votosFalsos.add(new VotosDeVerificacion("Vinchuca"));
		
		//Fixture 1
		when(sistema.votacionesDisponibles()).thenReturn(votosFalsos);
		when(recolector.getValorDeConocimiento()).thenReturn(1);
		when(recolector.getAlias()).thenReturn("Pedro");
		when(tipo.getNombre()).thenReturn("Vinchuca");

		//SetUp
		muestra = new Muestra(sistema, recolector, ubicacion, tipo);
		Participante basico = mock(Participante.class);
		Verificacion verificacion = mock(Verificacion.class);
		
		//Fixture 2
		when(basico.getValorDeConocimiento()).thenReturn(1);
		when(basico.getAlias()).thenReturn("Carlos");
		when(verificacion.getTipoVinchuca()).thenReturn(tipo);
		when(verificacion.getVerificador()).thenReturn(basico);
		
		//Exercise
		muestra.addVerificacion(verificacion);
		
		int valorDeVerificacionDeLaMuestra = muestra.valorDeVerificacion();
		String nivelDeVerificacion = muestra.nivelDeVerficacion();
		
		//Verify
		assertEquals(2, valorDeVerificacionDeLaMuestra);
		assertEquals("Media", nivelDeVerificacion);
	}
	
	@Test
	public void testMuestraCreadaPorUnRecolectorConNivelDeConocimienoAltoYUnParticipanteBasicoDiscrepa() {
		List<VotosDeVerificacion> votosFalsos = new ArrayList<>();
		votosFalsos.add(new VotosDeVerificacion("Vinchuca"));
		votosFalsos.add(new VotosDeVerificacion("Chince Foliada"));
		
		//Fixture 1
		when(sistema.votacionesDisponibles()).thenReturn(votosFalsos);
		when(recolector.getValorDeConocimiento()).thenReturn(10);
		when(recolector.getAlias()).thenReturn("Pedro");
		when(tipo.getNombre()).thenReturn("Vinchuca");
		
		//SetUp
		muestra = new Muestra(sistema, recolector, ubicacion, tipo);
		Participante basico = mock(Participante.class);
		TipoVinchuca tipoDelBasico = mock(TipoVinchuca.class);
		Verificacion verificacionBasico = mock(Verificacion.class); 
		
		//Fixture
		when(basico.getValorDeConocimiento()).thenReturn(1);
		when(tipoDelBasico.getNombre()).thenReturn("Chince Foliada");
		when(verificacionBasico.getTipoVinchuca()).thenReturn(tipoDelBasico);
		when(verificacionBasico.getVerificador()).thenReturn(basico);
		
		//Exercise
		muestra.addVerificacion(verificacionBasico);
		
		int valorDeVerificacion = muestra.valorDeVerificacion();
		String nivelDeVerificacion = muestra.nivelDeVerficacion();
		
		//Verify
		assertEquals(11, valorDeVerificacion);
		assertEquals("Alta", nivelDeVerificacion);
	}
	
}
