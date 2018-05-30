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
	
	public double calcularCostoDeViaje(Viaje viaje)throws Exception  {
		double costoViaje=0;
		if(viaje instanceof ViajeColectivo){
			costoViaje = ((ViajeColectivo) viaje).getTramo().getCosto();
		}else throw new Exception("El viaje no es viaje colectivo");
		return costoViaje;
	}

	@Override
	public String toString() {
		return "Colectivo [idTransporte=" + idTransporte + ", linea=" + linea + "]";
	}
	
	
	
	
	
    
    
    
}
