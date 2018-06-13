package datos;

import java.util.GregorianCalendar;

import funciones.Funciones;

public class ViajeTren extends Viaje{
	
	private Parada origen;
	private Parada destino;
	
	public ViajeTren() {}
	
	public ViajeTren(float monto, GregorianCalendar fechaHora, TarjetaSube tarjetaSube, TransportePublico tren, Parada origen, Parada destino) {
		super(monto,fechaHora,tarjetaSube,tren);
		this.origen = origen;
		this.destino = destino;
	}

	public Parada getOrigen() {
		return origen;
	}

	public void setOrigen(Parada origen) {
		this.origen = origen;
	}

	public Parada getDestino() {
		return destino;
	}

	public void setDestino(Parada destino) {
		this.destino = destino;
	}

	@Override
	public String toString() {
		return "ViajeTren [origen=" + origen + ", destino=" + destino + Funciones.traerFechaCortaHora(fechaHora)  + "]";
	}
	
	
	
	
	

}
