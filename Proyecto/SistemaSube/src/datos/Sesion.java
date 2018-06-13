package datos;

public class Sesion {
	private static Sesion sesionUnica;
	private Usuario usuarioLogeado;
	
	private Sesion() { }
	
	public static Sesion obtenerSesionActual() {
		if (sesionUnica == null)
			sesionUnica = new Sesion();
		
		return sesionUnica;
	}
	
	public void setUsuarioLogeado(Usuario usuarioLogeado) {
		this.usuarioLogeado = usuarioLogeado;
	}
	
	public Usuario getUsuarioLogeado() {
		return this.usuarioLogeado;
	}
	
	public void deslogear() {
		setUsuarioLogeado(null);
	}
}