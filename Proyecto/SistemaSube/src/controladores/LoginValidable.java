package controladores;

import datos.Sesion;
import datos.Usuario;
import negocio.TarjetaSubeABM;

public interface LoginValidable {
	
	default boolean existeUsuarioLogeado() {
		return (Sesion.obtenerSesionActual().getUsuarioLogeado() != null);
	}
	
	default boolean usuarioTieneTarjetaSube() throws Exception {
		Usuario usuario = Sesion.obtenerSesionActual().getUsuarioLogeado();
		return TarjetaSubeABM.getInstance().traerTarjetaSube(usuario) != null;
	}
}
