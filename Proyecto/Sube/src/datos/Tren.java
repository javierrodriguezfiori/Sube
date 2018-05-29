package datos;

import java.util.Set;
import negocio.SeccionRecorridoABM;
import negocio.SeccionABM;
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
				costoViaje = SeccionRecorridoABM.getInstance().traer(viaje.getOrigen(), viaje.getDestino()).getSeccion().getCosto();
			}
		}else throw new Exception("El viaje no es viaje tren");
		return costoViaje;
	}

	@Override
	public String toString() {
		return "Tren [paradas=" + paradas + "]";
	}
	
	
	
	

}
