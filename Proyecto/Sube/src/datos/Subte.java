package datos;
import java.util.Set;
public class Subte extends TransportePublico {
	
	private Set<Parada> paradas;
	
	public Subte() {}
	
	public Subte(long idSubte,String linea) {
		super(idSubte,linea);
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
	
	public double calcularCostoDeViaje(Viaje viaje) {
		double costoViaje=0;
		if(viaje instanceof ViajeSubte) {
			 
		}
		return costoViaje;
	}

	@Override
	public String toString() {
		return "Subte [idTransporte=" + idTransporte + ", linea=" + linea + "]";
	}

	
	
	
	

}
