package datos;

public abstract class TransportePublico {
	protected long idTransporte;
	protected String linea;
	
	public TransportePublico() {}
	
	public TransportePublico(long idTransporte,String linea) {
		super();
		this.idTransporte = idTransporte;
		this.linea = linea;
	}
	
	public void setIdTransporte(long idTransporte) {
		this.idTransporte = idTransporte;
	}
	
	public long getIdTransporte() {
		return idTransporte;
	}

	public String getLinea() {
		return linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}
	
	public abstract double calcularCostoDeViaje(Viaje viaje)throws Exception;
	
	
	
	
	

}
