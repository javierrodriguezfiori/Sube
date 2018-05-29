package datos;

import java.util.GregorianCalendar;

public abstract class Viaje extends Transaccion{
	
	protected TransportePublico transporte;
	
	public Viaje() {}
	
	public Viaje(float monto, GregorianCalendar fechaHora, TarjetaSube tarjetaSube, TransportePublico transporte) {
		super(monto,fechaHora,tarjetaSube);
		this.transporte = transporte;
	}

	public TransportePublico getTransporte() {
		return transporte;
	}

	public void setTransporte(TransportePublico transporte) {
		this.transporte = transporte;
	}

	@Override
	public String toString() {
		return "Viaje [transporte=" + transporte + ", idTransaccion=" + idTransaccion + ", monto=" + monto
				+ ", fechaHora=" + fechaHora + ", tarjetaSube=" + tarjetaSube + "]";
	}

	
	

}
