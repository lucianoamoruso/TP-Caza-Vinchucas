package vinchucas_app_web;

public class Organizacion {

	private Ubicacion ubicacion;
	private Integer cantidadDePersonas;
	private FuncionalidadExterna funcionalidadNuevaMuestra;
	private FuncionalidadExterna funcionalidadNuevaValidacion;
	
	public Organizacion(Ubicacion ubicacion, Integer cantidadDePersonas) {
		this.ubicacion = ubicacion;
		this.cantidadDePersonas = cantidadDePersonas;
	}
	
	/*
	 * retorna la ubicacion de la organizacion.
	 */
	public Ubicacion ubicacion() {
		return this.ubicacion;
	}
	
	/*
	 * retorna la cantidad de personas que trabajan.
	 */
	public Integer cantidadDePersonasQueTrabajan() {
		return this.cantidadDePersonas;
	}
	
	/*
	 * Se registra en una zona de cobertura.
	 */
	public void registrarseEnZona(ZonaDeCobertura zona) {
		zona.registrarOrganizacion(this);
	}
	
	/*
	 * Se desregistra de una zona de cobertura.
	 */
	public void desregistrarseDeZona(ZonaDeCobertura zona) {
		zona.desregistrarOrganizacion(this);
	}
	
	/*
	 * Setea una funcionalidad para la nueva muestra muestra reportada.
	 */
	public void setFuncionalidadNuevaMuestra(FuncionalidadExterna funcionalidad) {
		this.funcionalidadNuevaMuestra = funcionalidad;
	}
	
	/*
	 * Setea una funcionalidad para una nueva validacion de muestra reportada.
	 */
	public void setFuncionalidadNuevaValidacion(FuncionalidadExterna funcionalidad) {
		this.funcionalidadNuevaValidacion = funcionalidad;
	}
	
	/*
	 * Ejecuta la funcionalidad externa para la nueva muestra reportada.
	 */
	public void nuevoEventoMuestra(Organizacion organizacion, ZonaDeCobertura zona, Muestra muestra) {
		this.funcionalidadNuevaMuestra.nuevoEvento(this, zona, muestra);
	}
	
	/*
	 * Ejecuta la funcionalidad externa para la nueva validacion de muestra reportada.
	 */
	public void nuevoEventoValidacion(Organizacion organizacion, ZonaDeCobertura zona, Muestra muestra) {
		this.funcionalidadNuevaValidacion.nuevoEvento(this, zona, muestra);
	}
	
	
	
}