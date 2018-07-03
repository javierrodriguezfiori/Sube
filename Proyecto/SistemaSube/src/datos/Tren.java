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
	
	
	
	public float calcularDistanciaViaje(Parada origen,Parada destino)throws Exception {
		float distancia = 0;
		boolean encontrado1=false;
		boolean encontrado2=false;
		List<Parada> listaParadas = new ArrayList<Parada>();
		for(Parada parada : this.paradas) {
			listaParadas.add(parada);
			
		}
		
		for(Parada parada : listaParadas) {
			if(parada.equals(origen))encontrado1=true;
			if(parada.equals(destino))encontrado2=true;
		}
		if(!encontrado1 || !encontrado2)throw new Exception("origen o destino no encontrado");
		
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
	
	public int calcularSeccionViaje(Parada origen,Parada destino) throws Exception {
		
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
