package vinchucas_app_web;

public class Organizacion {

	private Ubicacion ubicacion;
	private Integer cantidadDePersonas;
	//private TipoDeOrganizacion tipoDeOrganizacion; //TODAVIA NO SE SABE QUE HACEN
	
	public Organizacion(Ubicacion ubicacion, Integer cantidadDePersonas/*, TipoDeOrganizacion tipoDeOrganizacion*/) {
		this.ubicacion = ubicacion;
		this.cantidadDePersonas = cantidadDePersonas;
		//this.tipoDeOrganizacion = tipoDeOrganizacion;
	}
	
	public Ubicacion ubicacion() {
		return this.ubicacion;
	}
	
	public Integer cantidadDePersonasQuTrabajan() {
		return this.cantidadDePersonas;
	}
	
	/*public tipoDeOrganizacion() {
		return this.tipoDeOrganizacion;
	}
	*/
}
