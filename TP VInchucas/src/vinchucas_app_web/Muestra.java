package vinchucas_app_web;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa una muestra tomada en el sistema web de Caza de Vinchucas.
 */
public class Muestra {
	
	private Participante recolector;
	private TipoVinchuca tipoVinchuca;
	private	List<Verificacion> verificaciones;
	private Ubicacion ubicacion;
	
	public Muestra(Participante recolector, Ubicacion ubicacion, TipoVinchuca tipoVinchuca) {
		
		this.recolector = recolector;
		this.ubicacion = ubicacion;
		this.tipoVinchuca = tipoVinchuca;
		this.verificaciones = new ArrayList<Verificacion>();
	}
	
	
	/* Agrega una verificacion a la lista de Verificaciones, si la 
	 * muestra ya tiene el maximo de verificaciones avisa que ya tiene 
	 * el numero maximo de verificaciones.
	 */
	public void addVerificacion(Verificacion verificacion) {
		if(this.getVerificadores().contains(verificacion.getVerificador())) {
			throw new RuntimeException("El participante ya verificó esta muestra");
		}else {
			if(this.verificaciones.size() == 2) {
				throw new RuntimeException("La muestra ya tiene el numero máximo de verificaciones posibles");
			} else {
				this.verificaciones.add(verificacion);
			}
		}
	}
	
	/*
	 * Retorna la ubicacion donde fue tomada la muestra.
	 */
	public Ubicacion getUbicacion() {
		return this.ubicacion;
	}

	/*
	 * Retorna el tipo de vinchuca que el recolector propuso.
	 */
	public TipoVinchuca getTipoVinchuca() {
		return this.tipoVinchuca;
	}
	
	/*
	 * Retorna el alias del recolector.
	 */
	public String aliasDelRecolector() {
		return this.recolector.getAlias();
	}
	
	
	/*
	 * Devuelve una lista con los participantes que 
	 * hasta el momento verificaron la muestra.
	 */
	public List<Participante> getVerificadores(){
		List<Participante> retorno = new ArrayList<Participante>();
		for (Verificacion verificacion : this.verificaciones) {
			retorno.add(verificacion.getVerificador());
		}
		
		retorno.add(this.recolector);
		
		return retorno;
	}
	
	/*
	 * Es el valor de Verificacion inicial de la muestra.
	 */
	public Integer veracidadDeLaMuestra(){
		return this.recolector.getValorDeConocimiento();
	}
	
	
	/* Si los tipos de vinchuca de las demas verificaciones coinciden
	 * con el tipo de vinchuca de la muestra, se suman con el valor de
	 * veracidad de la muestra, sino se restan, y deuelven el resultado.
	 */
	public Integer valorDeVerificacionDeLaMuestra() {
		Integer valorDeVerificacion = this.veracidadDeLaMuestra();
		
		for(Verificacion verificacion : this.verificaciones) {
			if(verificacion.getTipoVinchuca().equals(this.getTipoVinchuca())) {
				valorDeVerificacion += verificacion.valorDeVerificacion();
			} else {
				valorDeVerificacion -= verificacion.valorDeVerificacion();
			}
		}
		
		if(valorDeVerificacion < 0) {
			valorDeVerificacion *= -1;
		}
		
		return valorDeVerificacion;
	}
	
	
	/*
	 * Segun el valor de verificacion que tenga la muestra
	 * se calcula si es baja, media o alta.
	 */
	public String nivelDeVerficacion() {
		
		Integer valor = this.valorDeVerificacionDeLaMuestra();
		
		if(valor == 1) {
			return "Baja";
		} else if(valor == 2) {
			return "Media";
		} else {
			return"Alta";
		}
	}
}
