package datos;

public class Tramo {
	
	public long idTramo;
	public String distancia;
	public float costo;
	
	public Tramo() {}
	
	public Tramo(String distancia, float costo) {
		this.distancia = distancia;
		this.costo = costo;
	}
	
	protected void setIdTramo(long idTramo) {
		this.idTramo = idTramo;
	}
	
	public long getIdTramo() {
		return this.idTramo;
	}

	public String getDistancia() {
		return distancia;
	}

	public void setDistancia(String distancia) {
		this.distancia = distancia;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	@Override
	public String toString() {
		return "Tramo [idTramo=" + idTramo + ", distancia=" + distancia + ", costo=" + costo + "]";
	}
	
	
	

}
