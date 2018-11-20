package vinchucas_app_web;

public class VotosDeVerificacion {
	
	private String	nombre;
	private int		puntos;

	public VotosDeVerificacion(String nombre) {
		this.nombre = nombre;
		this.puntos = 0;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
}
