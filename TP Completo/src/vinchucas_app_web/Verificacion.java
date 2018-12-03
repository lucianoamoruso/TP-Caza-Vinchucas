package vinchucas_app_web;

public class Verificacion {

	private Participante verificador;
	private TipoVinchuca tipoVinchuca;
	
	public Verificacion(Participante verificador, TipoVinchuca tipoVinchuca) {
		this.verificador = verificador;
		this.tipoVinchuca = tipoVinchuca;

	}
	
	/*
	 * Retorna al participante que hizo la verificacion.
	 */
	public Participante getVerificador() {
		return this.verificador;
	}
	
	
	/*
	 * Retorna el tipo de vinchuca que cree que es el verificador.
	 */
	public TipoVinchuca getTipoVinchuca() {
		return this.tipoVinchuca;
	}
	
	
	/*
	 * Retorna el valor numerico del valor de conocimiento del verificador.
	 */
	public Integer valorDeVerificacion() {
		return this.getVerificador().getValorDeConocimiento();
	}

}
