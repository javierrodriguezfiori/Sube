package datos;

import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import negocio.SeccionRecorridoABM;
import negocio.SeccionABM;
import datos.ViajeTren;
import funciones.Funciones;
public class Tren extends TransportePublico {
	
   private Set<Parada> paradas;
	
	public Tren() {}
	
	public Tren(long idTren,String linea) {
		super(idTren,linea);
	}

	public Set<Parada> getParadas() {
		return paradas;
	}

	public void setParadas(Set<Parada> paradas) {
		this.paradas = paradas;
	}
	
	public boolean agregar(Parada parada) {
		return paradas.add(parada);
	}
	
	public double calcularCostoDeViaje(Viaje viaje)throws Exception {
		double costoViaje=0;
		if(viaje instanceof ViajeTren) {
			if(((ViajeTren) viaje).getDestino()==null) {
				costoViaje = SeccionABM.getInstance().traer((long)3).getCosto();
			}else {
				
				costoViaje = SeccionRecorridoABM.getInstance().traer(((ViajeTren) viaje).getOrigen(), ((ViajeTren) viaje).getDestino()).getSeccion().getCosto();
			}
		}else throw new Exception("El viaje no es ViajeTren");
		return costoViaje;
	}
	
	public float calcularDistanciaViaje(Parada origen,Parada destino) {
		float distancia = 0;
		List<Parada> listaParadas = new ArrayList<Parada>();
		for(Parada parada : this.paradas) {
			listaParadas.add(parada);
		}
		
		
		
		int i=0;
		boolean encontrado = false;
		while(i<listaParadas.size()) {
			
			if(listaParadas.get(i).equals(origen) || listaParadas.get(i).equals(destino)) {
				encontrado = !encontrado;
			}
			
			if(encontrado) {
				
				distancia += listaParadas.get(i+1).getDistanciaKM();
			}
			
			i++;
			
		}
		
		return distancia;
	}
	
	public int calcularSeccionViaje(Parada origen,Parada destino) {
		
		int seccion=1;
		float distancia = calcularDistanciaViaje(origen,destino);
		if(distancia>13) seccion = 2;
		if(distancia>27) seccion = 3;
		
		return seccion;
	}

	@Override
	public String toString() {
		return "Tren [paradas=" + paradas + "]";
	}
	
	
	
	

}
