package vinchucas_app_web;

public class NivelDeConocimientoEspecialista implements INivelDeConocimiento {

	private static NivelDeConocimientoEspecialista instance;
	
	private NivelDeConocimientoEspecialista() {
		
	}
	
	public static NivelDeConocimientoEspecialista getInstance() {
		if(instance == null) {
			instance = new NivelDeConocimientoEspecialista();
		}
		return instance;
	}
	
	@Override
	public void update(Participante participante) {
		//el participante especialista siempre queda especialista
	}

	@Override
	public Integer getValorDeConocimiento() {
		// a convenir
		return null;
	}

	
	
}
