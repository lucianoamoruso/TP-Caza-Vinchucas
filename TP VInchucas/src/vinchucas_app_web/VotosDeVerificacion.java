package vinchucas_app_web;

public class VotosDeVerificacion {
	
	private String	nombre;
	private int		puntos;

	public VotosDeVerificacion(String nombre) {
		this.nombre = nombre;
		this.puntos = 0;
	}
	
	public void votar(Participante verificador) {
		this.puntos += verificador.getValorDeConocimiento();
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public int getPuntos() {
		return this.puntos;
	}

}
