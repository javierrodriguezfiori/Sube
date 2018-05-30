package datos;

public class Seccion {
	
	private long idSeccion;
	private float costo;
	
	public Seccion() {}
	
	
	public Seccion(long idSeccion, float costo) {
		super();
		this.idSeccion = idSeccion;
		this.costo = costo;
	}


	public long getIdSeccion() {
		return idSeccion;
	}
	public void setIdSeccion(long idSeccion) {
		this.idSeccion = idSeccion;
	}
	public float getCosto() {
		return costo;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	
	public boolean equals(Seccion seccion) {
		boolean resultado=false;
		if(seccion.getIdSeccion()==this.idSeccion) {
			resultado=true;
		}
		return resultado;
	}
	
	@Override
	public String toString() {
		return "Seccion [idSeccion=" + idSeccion + ", costo=" + costo + "]";
	}
	
	
	
	

}
