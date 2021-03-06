package datos;
import java.util.Set;

import negocio.TramoABM;
import datos.ViajeColectivo;
import datos.Tramo;

public class Colectivo extends TransportePublico {
	private Set<Tramo> tramos;
	
	public Colectivo() {}
	
	public Colectivo(long idColectivo,String linea) {
		super(idColectivo,linea);
	}

	public Set<Tramo> getTramos() {
		return tramos;
	}

	public void setTramos(Set<Tramo> tramos) {
		this.tramos = tramos;
	}
	
	public boolean agregar(Tramo tramo) {
		return tramos.add(tramo);
	}
	
	

	@Override
	public String toString() {
		return "Colectivo [idTransporte=" + idTransporte + ", linea=" + linea + "]";
	}
	
	
	
	
	
    
    
    
}
