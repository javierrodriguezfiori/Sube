package datos;

import java.util.GregorianCalendar;

public class ViajeSubte extends Viaje{
	
	private Parada origen;
	
	public ViajeSubte() {}

	public ViajeSubte(float monto, GregorianCalendar fechaHora, TarjetaSube tarjetaSube, TransportePublico subte, Parada origen) {
		super(monto,fechaHora,tarjetaSube,subte);
		this.origen = origen;
	}

	public Parada getOrigen() {
		return origen;
	}

	public void setOrigen(Parada origen) {
		this.origen = origen;
	}

	@Override
	public String toString() {
		return "ViajeSubte [origen=" + origen + ", transporte=" + transporte + ", idTransaccion=" + idTransaccion
				+ ", monto=" + monto + ", fechaHora=" + fechaHora + ", tarjetaSube=" + tarjetaSube + "]";
	}
	
	
	

}
