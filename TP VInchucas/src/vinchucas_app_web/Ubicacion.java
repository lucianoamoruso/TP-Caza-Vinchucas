package vinchucas_app_web;

import java.util.ArrayList;
import java.util.List;

public class Ubicacion {

	private double latitud;
	private double longitud;
	
	/**
	 * Prop: retorna aquellas ubicaciones que se encuentran a menos de cierta cantidad de kilometros.
	 * @param ubicaciones	ubicaciones a ser analizadas y filtradas.
	 * @param radio	cantidad de kilometros que define el radio en el cual buscar.
	 */
	
	public Ubicacion(double latitud, double longitud) {
		this.latitud = latitud;
		this.longitud = longitud;
	}
	
	public double getLatitud() {
		return this.latitud;
	}
	
	public double getLongitud() {
		return this.longitud;
	}
	
	public List<Ubicacion> ubicacionesCercanas(List<Ubicacion> ubicaciones, int radio) {
		
		/*
		 * Recorre la lista de ubicaciones recibida como parametro
		 * y guarda en la variable temporal aquellas que esten a menor
		 * distancia del radio recibido como parametro y luego las retorna.
		 */
		
		List<Ubicacion> retorno =  new ArrayList<Ubicacion>();
		
		for(Ubicacion ubicacion : ubicaciones) {
			if (distanciaEntreDosUbicaciones(this, ubicacion) < radio) {
				retorno.add(ubicacion);
			}
		}
		return retorno;
	}
	
	/**
	 * Prop: retorna aquellas muestras que han sido obtenidas a menos de cierta cantidad de kilometros alrededor
	 * de donde fue tomada cierta muestra.
	 * @param muestraDeReferencia : muestra a cuya ubicacion se le aplicara el radio de busqueda.
	 * @param radio :	cantidad de kilometros que define el radio en el cual buscar.
	 * @param muestras : lista de muestras recibida para poder comprobar la distancia entre muestras.
	 */
	public List<Muestra> muestrasCercanas(Muestra muestraDeReferencia, List<Muestra> muestras, int radio) {
		
		// la unica forma que pude pensarlo es usar una lista de muestras.
		// como este metodo seguro lo va a usar la aplicacion web, va a poder
		// usar su lista de muestras y mandarla como parametro
		
		List<Muestra> retorno = new ArrayList<Muestra>();
		
		for (Muestra muestra : muestras) {
			if(this.distanciaEntreDosUbicaciones(muestraDeReferencia.getUbicacion(), muestra.getUbicacion()) < radio) {
				retorno.add(muestra);
			}
		}
		
		return retorno;
	}
	
	/**
	 * Prop: calcula la distancia entre dos ubicaciones.
	 * @author donnierock.com
	 * @param ubi1	primera ubicacion.
	 * @param ubi2	segunda ubicacion.
	 * @return	devuelve la distancia como decimal.
	 */
	public double distanciaEntreDosUbicaciones(Ubicacion ubi1, Ubicacion ubi2) {
		double lat1 = ubi1.getLatitud();
		double lng1 = ubi1.getLongitud();
		double lat2 = ubi2.getLatitud();
		double lng2 = ubi2.getLongitud();
		
		double radioTierra = 6371;	//En kilómetros  
		double dLat = Math.toRadians(lat2 - lat1);
		double dLng = Math.toRadians(lng2 - lng1);
		double sindLat = Math.sin(dLat / 2);
		double sindLng = Math.sin(dLng / 2);
		double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2) * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
		double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
		double distancia = radioTierra * va2;

		return distancia;
	}
	
}
