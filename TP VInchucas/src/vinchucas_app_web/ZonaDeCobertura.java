package vinchucas_app_web;

import java.util.ArrayList;
import java.util.List;

public class ZonaDeCobertura {

	private Ubicacion epicentro;
	private int radio;
	private String nombre;
	private AppWeb aplicacion;
	private List<Muestra> muestrasQueSeReportaron;
	
	public ZonaDeCobertura(Ubicacion epicentro, int radio, String nombre, AppWeb aplicacion) {
		this.epicentro = epicentro;
		this.radio = radio;
		this.nombre = nombre;
		this.aplicacion = aplicacion;
		this.muestrasQueSeReportaron = new ArrayList<Muestra>();
	}

	public int getRadio() {
		return this.radio;
	}

	public Ubicacion getEpicentro() {
		return this.epicentro;
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public void reportarMuestra(Muestra muestra) {
		this.muestrasQueSeReportaron.add(muestra);
	}
	
	public List<Muestra> muestrasQueSeHanReportadoEnLaZona(){
		return muestrasQueSeReportaron;
	}
	

	public List<ZonaDeCobertura> zonasQueLaSolapan(){
		
		List<ZonaDeCobertura> zonasQueLaSolapan = new ArrayList<ZonaDeCobertura>();
		
		for(ZonaDeCobertura zona : aplicacion.getZonasDeCobertura()) {
			if (this.getRadio()+zona.getRadio() > this.getEpicentro().distanciaEntreDosUbicaciones(this.epicentro, zona.getEpicentro())) {
				zonasQueLaSolapan.add(zona);
			}
		}
		
		return zonasQueLaSolapan;
		
	}

	
	
}
