package vinchucas_app_web;

import java.util.List;

/**
 * Representa una muestra tomada en el sistema web de Caza de Vinchucas.
 */
public class Muestra {

	private AppWeb				sistema;
	private	List<TipoVinchuca>	tipos;
	private TipoVinchuca		tipoVinchuca;
	private	List<Verificacion>	verificaciones;
	private	Verificacion		verificacion;
	private String				fotografia;
	private Ubicacion			ubicacion;
	private Usuario				cazador;
	
	public Muestra(AppWeb sistema, Usuario cazador, TipoVinchuca tipo) {
		this.sistema = sistema;
		this.tipoVinchuca = tipo;
		verificacionInicial(cazador.getRango());
	}

	private void verificacionInicial(Experiencia rango) {
		//Aca se calcula el nivel de verificacion inicial a partir del rango del cazador.
	}
	
}
