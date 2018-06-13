package datos;

import java.util.GregorianCalendar;

import funciones.Funciones;

public class Devolucion extends Transaccion{
	
	public Devolucion() {}

	public Devolucion(float monto, GregorianCalendar fechaHora, TarjetaSube tarjetaSube){
		super(monto,fechaHora,tarjetaSube);
	}

	@Override
	public String toString() {
		return "Devolucion [idTransaccion=" + idTransaccion + ", monto=" + monto + ", fechaHora=" + Funciones.traerFechaCortaHora(fechaHora)
				+ ", tarjetaSube=" + tarjetaSube + "]";
	}
	
	
}
