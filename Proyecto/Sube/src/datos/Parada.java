package datos;

public class Parada {
	
	private long idParada;
	private String nombre;
	
	public Parada() {};
	
	public Parada(long parada,String nombre) {
		this.idParada = parada;
		this.nombre = nombre;
	}
	
	public void setIdParada(long idParada) {
		this.idParada = idParada;
	}
	
	public long getIdParada() {
		return idParada;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public boolean equals(Parada parada) {
		boolean resultado=false;
		if(parada.getIdParada()==this.idParada) {
			resultado=true;
		}
		return resultado;
	}

	@Override
	public String toString() {
		return "Parada [idParada=" + idParada + ", nombre=" + nombre + "]";
	}
	
	

}
