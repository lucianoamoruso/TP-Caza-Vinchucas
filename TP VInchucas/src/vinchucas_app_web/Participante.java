package vinchucas_app_web;

import java.util.ArrayList;
import java.util.List;

public class Participante{

	private String alias;
	private List<Muestra> envios;
	private List<Muestra> revisiones;
	private AppWeb aplicacionWeb;
	protected INivelDeConocimiento nivelDeConocimiento;
	
	public Participante(String alias, AppWeb aplicacionWeb, INivelDeConocimiento nivelDeConocimiento) {
		this.alias = alias;
		this.aplicacionWeb = aplicacionWeb;
		this.envios = new ArrayList<Muestra>();
		this.revisiones = new ArrayList<Muestra>();
		this.nivelDeConocimiento = nivelDeConocimiento;
	}

	/* Envia una nueva muestra a la aplicacion web.
	 * Luego añade la muestra que envió a la lista de envios. 
	 */
	public void enviarMuestra(Ubicacion ubicacion, TipoVinchuca tipo) {
		
		Muestra muestra = new Muestra(this.aplicacionWeb, this, ubicacion, tipo);
		
		this.aplicacionWeb.nuevaMuestra(muestra);
		
		this.envios.add(muestra);
		
		this.nivelDeConocimiento.update(this);
	}
	
	/*
	 * Verifica una muestra.
	 * Luego añade la muestra que verifico a la lista de revisiones.
	 */
	public void verificarMuestra(Muestra muestra, TipoVinchuca tipo) {
		
		muestra.addVerificacion(new Verificacion(this, tipo));
		
		this.revisiones.add(muestra);
		
		this.nivelDeConocimiento.update(this);
	}
	
	/*
	 * Retorna el valor numerico que se le asigna por su nivel de conocimiento.
	 */
	public Integer getValorDeConocimiento() {
		return this.nivelDeConocimiento.getValorDeConocimiento();
	}
	
	/*
	 * Setea un nuevo nivel de conocimiento (Puede ser Basico o Experto que puede cambiar en el tiempo)
	 */
	public void setNivelDeConocimiento(INivelDeConocimiento nivelDeConocimiento) {
		this.nivelDeConocimiento = nivelDeConocimiento;
	}
	
	/*
	 * Retorna la cantidad de revisiones
	 */
	public Integer getCantidadDeRevisiones() {
		return this.revisiones.size();
	}
	
	/*
	 * Retorna la cantidad de envios
	 */
	public Integer getCantidadDeEnvios() {
		return this.envios.size();
	}
	

	/*
	 * Retorna el alias del participante
	 */
	public String getAlias() {
		return this.alias;
	}

}
