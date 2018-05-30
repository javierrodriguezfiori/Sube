package datos;
import java.util.Set;
import negocio.CostoSubte;
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
	
	public double calcularCostoDeViaje(Viaje viaje)throws Exception {
		double costoViaje=0;
		if(viaje instanceof ViajeSubte) {
			 costoViaje = CostoSubte.getInstance().traerCostoSubte();
		}else throw new Exception("El viaje no es viaje subte");
		return costoViaje;
	}

	@Override
	public String toString() {
		return "Subte [idTransporte=" + idTransporte + ", linea=" + linea + "]";
	}

	
	
	
	

}
