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
	private String				ubicacion;
	private String				cazador;
	
	public Muestra(AppWeb sistema, Usuario cazador, TipoVinchuca tipo) {
		this.sistema = sistema;
		this.tipos = sistema.getTiposVinchuca();
		this.tipoVinchuca = tipo;
		this.verificaciones = sistema.getVerificaciones();
	}
	
}
