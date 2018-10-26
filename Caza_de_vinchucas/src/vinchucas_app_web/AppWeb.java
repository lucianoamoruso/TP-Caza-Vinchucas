package vinchucas_app_web;

import java.util.ArrayList;
import java.util.List;

public class AppWeb {
	
	private	List<TipoVinchuca>	tipos;
	private	List<Verificacion>	verificaciones;

	public AppWeb() {
		this.tipos = new ArrayList<>();
		definirTipos();
		this.verificaciones = new ArrayList<>();
		definirNiveles();
	}
	
	/**
	 * Prop: define los tipos iniciales de verificacion de vinchuca.
	 */
	private void definirTipos() {
		List<TipoVinchuca> iniciales = new ArrayList<>();
		iniciales.add( new TipoVinchuca("Vinchuca") );
		iniciales.add( new TipoVinchuca("Chince Foliada") );
		iniciales.add( new TipoVinchuca("Phtia-Chinche") );
		iniciales.add( new TipoVinchuca("Ninguna") );
		iniciales.add( new TipoVinchuca("Imagen poco clara") );
		this.tipos = iniciales;
	}
	
	/**
	 * Prop: define los niveles iniciales de validacion de una muestra.
	 */
	private void definirNiveles() {
		List<Verificacion> iniciales = new ArrayList<>();
		iniciales.add( new Verificacion("Baja") );
		iniciales.add( new Verificacion("Media") );
		iniciales.add( new Verificacion("Alta") );
		this.verificaciones = iniciales;
	}
	
	/**
	 * Prop: agrega un nuevo tipo de verificacion de vinchuca al sistema.
	 * @param nombre	nombre del nuevo tipo de verificacion.
	 */
	public void nuevoTipoVinchuca(String nombre) {
		this.tipos.add( new TipoVinchuca(nombre) );
	}
	
	/**
	 * Prop: agrega un nuevo tipo de verificacion de vinchuca al sistema.
	 * @param nivel	nombre del nuevo nivel de verificacion.
	 */
	public void nuevoNivelVerificacion(String nivel) {
		this.verificaciones.add( new Verificacion(nivel) );
	}

//	--------------	GETTERS Y SETTERS	--------------
	
	public List<TipoVinchuca> getTiposVinchuca() {
		return this.tipos;
	}
	
	public List<Verificacion> getVerificaciones() {
		return this.verificaciones;
	}
	
}
