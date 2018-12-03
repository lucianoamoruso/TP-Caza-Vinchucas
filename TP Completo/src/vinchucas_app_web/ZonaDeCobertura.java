package vinchucas_app_web;

import java.util.ArrayList;
import java.util.List;

public class ZonaDeCobertura {

	private Ubicacion epicentro;
	private int radio;
	private String nombre;
	private AppWeb aplicacion;
	private List<Organizacion> organizacionesRegistradas;
	
	public ZonaDeCobertura(Ubicacion epicentro, int radio, String nombre, AppWeb aplicacion) {
		this.epicentro = epicentro;
		this.radio = radio;
		this.nombre = nombre;
		this.aplicacion = aplicacion;
		this.organizacionesRegistradas = new ArrayList<Organizacion>();
	}

	/*
	 * Retorna el radio de la zona.
	 */
	public int getRadio() {
		return this.radio;
	}

	
	/*
	 * Retorna la ubicacion del epicentro de la zona.
	 */
	public Ubicacion getEpicentro() {
		return this.epicentro;
	}

	/*
	 * Retorna el nombre de la zona.
	 */
	public String getNombre() {
		return this.nombre;
	}
	
	/*
	 * Reporta una muestra nueva.
	 */
	public void reportarMuestra(Muestra muestra) {
		for(Organizacion organizacion : organizacionesRegistradas) {
			organizacion.nuevoEventoMuestra(organizacion, this, muestra);
		}
	}
	
	/*
	 * Reporta una nueva validación.
	 */
	public void reportarValidacion(Muestra muestra) {
		for(Organizacion organizacion : organizacionesRegistradas) {
			organizacion.nuevoEventoValidacion(organizacion, this, muestra);
		}
	}
	
	/*
	 * Retorna una lista con las muestras que se han reportado en la zona.
	 */
	public List<Muestra> muestrasQueSeHanReportadoEnLaZona(){
		List<Muestra> muestrasQueSeHanReportado = new ArrayList<Muestra>();
		
		for(Muestra muestra : aplicacion.getMuestras()) {
			if(this.getEpicentro().distanciaEntreDosUbicaciones(epicentro, muestra.getUbicacion()) < this.getRadio()) {
				muestrasQueSeHanReportado.add(muestra);
			}
		}
		return muestrasQueSeHanReportado;
	}
	

	/*
	 * Retorna una lista con las zonas de cobertura que la solapan.
	 */
	public List<ZonaDeCobertura> zonasQueLaSolapan(){
		
		List<ZonaDeCobertura> zonasQueLaSolapan = new ArrayList<ZonaDeCobertura>();
		
		for(ZonaDeCobertura zona : aplicacion.getZonasDeCobertura()) {
			if (this.getRadio()+zona.getRadio() > this.getEpicentro().distanciaEntreDosUbicaciones(this.epicentro, zona.getEpicentro())) {
				zonasQueLaSolapan.add(zona);
			}
		}
		return zonasQueLaSolapan;
	}

	
	/*
	 * Registra una organizacion.
	 */
	public void registrarOrganizacion(Organizacion organizacion) {
		organizacionesRegistradas.add(organizacion);
	}
	
	/*
	 * Desregistra una organizacion.
	 */
	public void desregistrarOrganizacion(Organizacion organizacion) {
		organizacionesRegistradas.remove(organizacion);
	}
	
	/*
	 * Retorna una lista con las organizacines registradas en la zona.
	 */
	public List<Organizacion> organizacionesRegistradas(){
		return this.organizacionesRegistradas;
	}
	
}
