package vinchucas_app_web;

import java.util.List;

public class Usuario {

	private AppWeb				sistema;
	private List<Experiencia>	rangos;
	private Experiencia			experiencia;
	
	public Usuario() {
		this.rangos = sistema.getRangos();
		this.experiencia = ;
	}

	public void enviarMuestra() {
		this.sistema.nuevaMuestra();
	}
	
	public void verificarMuestra() {
		this.sistema.verificarMuestra();
	}
	
}
