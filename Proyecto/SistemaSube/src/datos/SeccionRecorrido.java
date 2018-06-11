package datos;

public class SeccionRecorrido {
	
	private long idSeccionRecorrido;
	private Seccion seccion;
	private Parada origen;
	private Parada destino;
	
	public SeccionRecorrido() {
		
	}
	
	

	public SeccionRecorrido(long idSeccionRecorrido, Seccion seccion, Parada origen, Parada destino) {
		super();
		this.idSeccionRecorrido = idSeccionRecorrido;
		this.seccion = seccion;
		this.origen = origen;
		this.destino = destino;
	}



	public long getIdSeccionRecorrido() {
		return idSeccionRecorrido;
	}

	public void setIdSeccionRecorrido(long idSeccionRecorrido) {
		this.idSeccionRecorrido = idSeccionRecorrido;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
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
		return "SeccionRecorrido [idSeccionRecorrido=" + idSeccionRecorrido + ", seccion=" + seccion + ", origen="
				+ origen + ", destino=" + destino + "]";
	}
	
	
	
	
	

}
