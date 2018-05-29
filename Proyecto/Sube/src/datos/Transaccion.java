package datos;

import java.util.GregorianCalendar;

public abstract class Transaccion {
	
	protected int idTransaccion;
	protected float monto;
	protected GregorianCalendar fechaHora;
	protected TarjetaSube tarjetaSube;
	
	public Transaccion(){}
	
	public Transaccion(float monto, GregorianCalendar fechaHora, TarjetaSube tarjetaSube) {
		super();
		this.monto = monto;
		this.fechaHora = fechaHora;
		this.tarjetaSube = tarjetaSube;
	}

	public int getIdTransaccion() {
		return idTransaccion;
	}

	protected void setIdTransaccion(int idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public GregorianCalendar getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(GregorianCalendar fechaHora) {
		this.fechaHora = fechaHora;
	}

	public TarjetaSube getTarjetaSube() {
		return tarjetaSube;
	}

	public void setTarjetaSube(TarjetaSube tarjetaSube) {
		this.tarjetaSube = tarjetaSube;
	}

	@Override
	public String toString() {
		return "Transaccion [idTransaccion=" + idTransaccion + ", monto=" + monto + ", fechaHora=" + fechaHora
				+ ", tarjetaSube=" + tarjetaSube + "]";
	}
	
	
	
	

}
