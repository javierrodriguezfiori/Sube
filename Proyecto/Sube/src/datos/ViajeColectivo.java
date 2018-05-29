package datos;

import java.util.GregorianCalendar;

public class ViajeColectivo extends Viaje {
	
	private Tramo tramo;
	
	public ViajeColectivo() {}

	public ViajeColectivo(float monto, GregorianCalendar fechaHora, TarjetaSube tarjetaSube, TransportePublico colectivo, Tramo tramo) {
		super(monto, fechaHora, tarjetaSube, colectivo);
		this.tramo = tramo;
	}

	public Tramo getTramo() {
		return tramo;
	}

	public void setTramo(Tramo tramo) {
		this.tramo = tramo;
	}

	@Override
	public String toString() {
		return "ViajeColectivo [tramo=" + tramo + ", transporte=" + transporte + ", idTransaccion=" + idTransaccion
				+ ", monto=" + monto + ", fechaHora=" + fechaHora + ", tarjetaSube=" + tarjetaSube + "]";
	}
	
	
	

}
