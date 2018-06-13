package datos;

import java.util.GregorianCalendar;

import funciones.Funciones;

public class Recarga extends Transaccion {
	
	public Recarga(){}
	
	public Recarga(float monto, GregorianCalendar fechaHora, TarjetaSube tarjetaSube){
		super(monto,fechaHora,tarjetaSube);
	}

	@Override
	public String toString() {
		return "Recarga [idTransaccion=" + idTransaccion + ", monto=" + monto + ", fechaHora=" + Funciones.traerFechaCortaHora(fechaHora)
				+ ", tarjetaSube=" + tarjetaSube + "]";
	}
	
	

}
