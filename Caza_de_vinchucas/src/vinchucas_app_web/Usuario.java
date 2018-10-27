package vinchucas_app_web;

import java.util.List;

public class Usuario {

	private AppWeb				sistema;
	private List<Experiencia>	rangos;
	private Experiencia			experiencia;
	
	public Usuario() {
		this.rangos = sistema.getRangos();
		this.experiencia = sistema.rangoInicial();
	}

	public void enviarMuestra(TipoVinchuca tipo) {
		Muestra muestra = new Muestra(sistema, this, tipo);
		this.sistema.nuevaMuestra(muestra);
	}
	
	public void verificarMuestra() {
		this.sistema.verificarMuestra(this.experiencia);
	}
	
	public Experiencia getRango() {
		return this.experiencia;
	}
	
}
