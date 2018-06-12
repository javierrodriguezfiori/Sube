package datos;

public class Sesion {
	private static Sesion sesionUnica;
	private TarjetaSube tarjetaSubeLogeada;
	
	private Sesion() { }
	
	public Sesion obtenerSesionActual() {
		if (sesionUnica == null)
			sesionUnica = new Sesion();
		
		return sesionUnica;
	}
	
	public void setTarjetaSubeLogeada(TarjetaSube tarjetaSubeNueva) {
		this.tarjetaSubeLogeada = tarjetaSubeNueva;
	}
	
	public TarjetaSube getTarjetaSubeLogeada() {
		return this.tarjetaSubeLogeada;
	}
}