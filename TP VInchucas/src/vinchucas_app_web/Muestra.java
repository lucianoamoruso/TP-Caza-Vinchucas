package vinchucas_app_web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Representa una muestra tomada en el sistema web de Caza de Vinchucas.
 */
public class Muestra {
	
	private AppWeb						sistema;
	private Participante				recolector;
	private TipoVinchuca				tipoVinchuca;
	private	List<Verificacion>			verificaciones;
	private Ubicacion					ubicacion;
	private List<VotosDeVerificacion>	valoraciones;
	
	public Muestra(AppWeb sistema, Participante recolector, Ubicacion ubicacion, TipoVinchuca tipoVinchuca) {
		this.sistema = sistema;
		this.recolector = recolector;
		this.ubicacion = ubicacion;
		this.tipoVinchuca = tipoVinchuca;
		this.verificaciones = new ArrayList<Verificacion>();
		this.valoraciones = sistema.votacionesDisponibles();
	}
	
	/**
	 * Prop: agrega una verificacion a la lista de Verificaciones, si la 
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
				votarPorVerificacion(verificacion);
			}
		}
	}
	
	/**
	 * Prop: agrega puntos a la valoracion de su lista que corresponda con el tipo de vinchuca recibido.
	 */
	private void votarPorVerificacion(Verificacion verificacion) {
		String nombre = verificacion.getTipoVinchuca().getNombre();
		VotosDeVerificacion valoracion = this.valoraciones.stream()
				.filter(val -> nombre == val.getNombre())
				.findAny()
				.orElse(null);
		valoracion.votar(verificacion.getVerificador());
	}
	
	/**
	 * Prop: retorna el alias del recolector.
	 */
	public String aliasDelRecolector() {
		return this.recolector.getAlias();
	}
	
	/**
	 * Prop: devuelve una lista con los participantes que 
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
		
	public int valorDeVerificacion() {
		VotosDeVerificacion predominante = this.valoraciones.stream().reduce((a,b) ->
				a.getPuntos() > b.getPuntos() ? a : b)
				.get();
		return predominante.getPuntos();
	}
	
	/**
	 * Prop: segun el valor de verificacion que tenga la muestra
	 * se calcula si es baja, media o alta.
	 */
	public String nivelDeVerficacion() {
		
		Integer valor = valorDeVerificacion();
		
		if(valor == 1) {
			return "Baja";
		} else if(valor == 2) {
			return "Media";
		} else {
			return"Alta";
		}
	}
	
//---------------------- GETTERS Y SETTERS ----------------------

	public Ubicacion getUbicacion() {
		return this.ubicacion;
	}

	public TipoVinchuca getTipoVinchuca() {
		return this.tipoVinchuca;
	}

}
