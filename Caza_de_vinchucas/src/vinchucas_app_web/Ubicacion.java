package vinchucas_app_web;

public class Ubicacion {

	
	
	/**
	 * Prop: calcula la distancia entre dos coordenadas.
	 * @author donnierock.com
	 * @param lat1	latitud de la primer coordenada.
	 * @param lng1	longitud de la primer coordenada.
	 * @param lat2	latitud de la primer coordenada.
	 * @param lng2	longitud de la primer coordenada.
	 * @return	devuelve la distancia como decimal.
	 */
	public static double distanciaCoord(double lat1, double lng1, double lat2, double lng2) {  
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
