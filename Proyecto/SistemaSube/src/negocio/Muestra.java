package negocio;




/**
 * Esta Clase define una Muestra, según el tipo de Transporte la muestra
 * define la informacion de la siguiente manera:
 * Colectivo:
 *  idMuestra= id origen tramo
 *  idMuestra2= null
 *  nombre = distancia del tramo
 *  nombre2 = null
 *  muestra =  (depende de la estadistica solicitada)
 * Tren:
 *  idMuestra= id parada origen
 *  idMuestra2= id parada destino
 *  nombre = nombre del origen
 *  nombre2 = nombre del destino
 *  muestra =  (depende de la estadistica solicitada)
 * Subte:
 *  idMuestra= id parada origen
 *  idMuestra2= null
 *  nombre = nombre del origen
 *  nombre2 = null
 *  muestra =  (depende de la estadistica solicitada) 
 * 
 * Las atributos idMuestra y idMuestra2 no son datos importantes solo se utilazan en el 
 * algoritmo de estadistica. Los datos importantes son nombre y muestra(en el caso
 * de los trenes nombre2 tambien).
 * 
 * 
 * 
 * @author Mauro Lucas Pereyra
 * @version 17/06/2018
 *
 */

public class Muestra {
	
	private int idMuestra;
	private int idMuestra2;
	private String nombre;
	private String nombre2;
	private float muestra;
	
	
	
	public Muestra(int idMuestra, String nombre, float muestra) {
		super();
		this.idMuestra = idMuestra;
		this.nombre = nombre;
		this.muestra = muestra;
	
		
	}
	
	public Muestra(int idMuestra,int idMuestra2, String nombre,String nombre2, float muestra) {
		super();
		this.idMuestra = idMuestra;
		this.nombre = nombre;
		this.nombre2=nombre2;
		this.muestra = muestra;
		this.idMuestra2=idMuestra2;
	
		
	}

	public Muestra() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public float getMuestra() {
		return muestra;
	}

	public void setMuestra(float muestra) {
		this.muestra = muestra;
	}

	public int getIdMuestra() {
		return idMuestra;
	}

	public void setIdMuestra(int idMuestra) {
		this.idMuestra = idMuestra;
	}
	
	

	public int getIdMuestra2() {
		return idMuestra2;
	}

	public void setIdMuestra2(int idMuestra2) {
		this.idMuestra2 = idMuestra2;
	}
	
	

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	@Override
	public String toString() {
		return "Muestra [idMuestra=" + idMuestra + ", idMuestra2=" + idMuestra2 + ", nombre=" + nombre + ", nombre2="
				+ nombre2 + ", muestra=" + muestra + "]";
	}

     

	

	
	
	
	
	
	
	

}
