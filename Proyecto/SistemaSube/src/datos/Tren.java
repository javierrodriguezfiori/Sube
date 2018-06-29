package datos;

import java.util.Set;
import negocio.SeccionRecorridoABM;
import negocio.SeccionABM;
import datos.ViajeTren;
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
	
	public int calulcarSeccionViaje(Parada origen,Parada destino) {
		int seccion = 1;
		for(Parada parada : paradas) {
			
		}
		return seccion;
	}
	
	public float calcularDistancia(Parada origen,Parada destino) {
		float distancia=0;
		boolean encontrado = false;
		for(Parada p : paradas) {
			if(p.equals(destino) || p.equals(origen)) {
				encontrado = !encontrado;
				
			}
			if(encontrado) {
				distancia += p.getDistanciaKM();
			}
		}
		return distancia;
	}

	@Override
	public String toString() {
		return "Tren [paradas=" + paradas + "]";
	}
	
	
	
	

}
