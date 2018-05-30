package datos;

import java.util.GregorianCalendar;

public class Recarga extends Transaccion {
	
	public Recarga(){}
	
	public Recarga(float monto, GregorianCalendar fechaHora, TarjetaSube tarjetaSube){
		super(monto,fechaHora,tarjetaSube);
	}

	@Override
	public String toString() {
		return "Recarga [idTransaccion=" + idTransaccion + ", monto=" + monto + ", fechaHora=" + fechaHora
				+ ", tarjetaSube=" + tarjetaSube + "]";
	}
	
	

}
