package vinchucas_app_web;

public class TipoVinchuca {

	private String nombre;

	
	public TipoVinchuca(String nombre) {
		this.nombre = nombre;
	}

	/* 
	 * retorna el tipo de vinchuca o si es imagen poco clara o ninguna.
	 */
	
	public String getNombre() {
		return this.nombre;
	}
	
}
