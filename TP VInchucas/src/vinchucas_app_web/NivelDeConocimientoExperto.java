package vinchucas_app_web;

public class NivelDeConocimientoExperto implements INivelDeConocimiento {
	
	private static NivelDeConocimientoExperto instance;
	
	private NivelDeConocimientoExperto() {
		
	}
	
	/*
	 * Retorna la instancia de NivelDeConocimientoExperto.
	 */
	public static NivelDeConocimientoExperto getInstance() {
		
		if(instance == null) {
			instance = new NivelDeConocimientoExperto();
		}
		
		return instance;
	}
	
	/*
	 * Actualiza el nivel de conocimiento del participante recibido si se dan las condiciones.
	 */
	
	@Override
	public void update(Participante participante) {
		
		if (participante.getCantidadDeEnvios() <= 10 && participante.getCantidadDeRevisiones() <= 20) {
			participante.setNivelDeConocimiento(NivelDeConocimientoBasico.getInstance());
		}
	}
	
	
	
	@Override
	public Integer getValorDeConocimiento() {
		return 10;
	}

	

}
