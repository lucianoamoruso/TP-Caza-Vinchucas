package vinchucas_app_web;

import java.util.ArrayList;
import java.util.List;

public class AppWeb {
	
	private	List<TipoVinchuca>	tipos;
	private List<Muestra>		muestras;

	public AppWeb() {
		this.tipos = new ArrayList<>();
		definirTipos();
		this.muestras = new ArrayList<Muestra>();
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
	 * Prop: agrega un nuevo tipo de verificacion de vinchuca al sistema.
	 * @param nombre	nombre del nuevo tipo de verificacion.
	 */
	public void nuevoTipoVinchuca(String nombre) {
		this.tipos.add( new TipoVinchuca(nombre) );
	}

	
	/*
	 * Retorna una lista con los tipos de vinchuca existentes en la appWeb.
	 */
	public List<TipoVinchuca> getTiposVinchuca() {
		return this.tipos;
	}
	
	/**
	 * Prop: agrega una nueva muestra al sistema.
	 * @param muestra	la muestra a ser agregada.
	 */
	public void nuevaMuestra(Muestra muestra) {
		this.muestras.add(muestra);
	}
	
	public List<Muestra> getMuestras(){
		return this.muestras;
	}
	
	public List<VotosDeVerificacion> votacionesDisponibles() {
		List<VotosDeVerificacion> disponibles = new ArrayList<>();
		
		for (TipoVinchuca tipo : this.tipos) {
			disponibles.add(new VotosDeVerificacion(tipo.getNombre()));
		}
		return disponibles;
	}

}
