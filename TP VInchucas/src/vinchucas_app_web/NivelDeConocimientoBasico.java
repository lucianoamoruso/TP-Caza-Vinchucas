package vinchucas_app_web;

public class NivelDeConocimientoBasico implements INivelDeConocimiento{
	
	
	private static NivelDeConocimientoBasico instance;
	
	private NivelDeConocimientoBasico() {
		
	}
	
	public static NivelDeConocimientoBasico getInstance() { 
		
		if(instance == null) {
			instance = new NivelDeConocimientoBasico();
		}
		
		return instance;
	}
	
	/*
	 * Actualiza el nivel de conocimiento del participante, si se dan las condiciones.
	 */
	@Override
	public void update(Participante participante) {
		
		
		if (participante.getCantidadDeEnvios() > 10 && participante.getCantidadDeRevisiones() > 20) {
			participante.setNivelDeConocimiento(NivelDeConocimientoExperto.getInstance());
		}
	}

	
	
	@Override
	public Integer getValorDeConocimiento() {
		
		// a convenir
		
		return null;
	}

	
}
