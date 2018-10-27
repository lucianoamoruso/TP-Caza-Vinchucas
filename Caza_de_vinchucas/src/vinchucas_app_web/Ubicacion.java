package vinchucas_app_web;

import java.util.List;

public class Ubicacion {

	private double	latitud;
	private double	longitud;
	
	/**
	 * Prop: retorna aquellas ubicaciones que se encuentran a menos de cierta cantidad de kilometros.
	 * @param ubicaciones	ubicaciones a ser analizadas y filtradas.
	 * @param radio	cantidad de kilometros que define el radio en el cual buscar.
	 */
	public List<Ubicacion> ubicacionesCercanas(List<Ubicacion> ubicaciones, int radio) {
		//TODO
	}
	
	/**
	 * Prop: retorna aquellas muestras que han sido obtenidas a menos de cierta cantidad de kilometros alrededor
	 * de donde fue tomada cierta muestra.
	 * @param muestra	muestra a cuya ubicacion se le aplicara el radio de busqueda.
	 * @param radio	cantidad de kilometros que define el radio en el cual buscar.
	 */
	public List<Muestra> muestrasCercanas(Muestra muestra, int radio) {
		//TODO
	}
	
	/**
	 * Prop: calcula la distancia entre dos ubicaciones.
	 * @author donnierock.com
	 * @param ubi1	primera ubicacion.
	 * @param ubi2	segunda ubicacion.
	 * @return	devuelve la distancia como decimal.
	 */
	public static double distanciaCoord(Ubicacion ubi1, Ubicacion ubi2) {
		double lat1 = ubi1.latitud;
		double lng1 = ubi1.longitud;
		double lat2 = ubi2.latitud;
		double lng2 = ubi2.longitud;
		
		double radioTierra = 6371;	//en kilómetros  
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
