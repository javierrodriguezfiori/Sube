package test;

import java.util.GregorianCalendar;

import datos.Contacto;
import datos.DatosUsuario;
import datos.Sesion;
import datos.Usuario;
import negocio.UsuarioABM;

public class TestUsuario {

	public static void main(String[] args) {
		Contacto contacto= new Contacto("rjavier@pepito.com", "1162574132", "42486183");
		DatosUsuario datos= new DatosUsuario("Javier", "Rodriguez", 'M', contacto);
		
//		// Test Agregar
//		try {
//			UsuarioABM.getInstance().agregar("DNI", "3180781", "4132", new GregorianCalendar(), datos);
//		} catch (Exception e){
//			System.out.println(e);
//		}
		
		
//		// Test traer por idUsuario
//		try {
//			System.out.println(UsuarioABM.getInstance().traerUsuario(6));
//		} catch (Exception e){
//			System.out.println(e);
//		}
		
//		// Test traer por documento
				try {
					Usuario usuario = UsuarioABM.getInstance().traerUsuario("34180781");
					Sesion.obtenerSesionActual().setUsuarioLogeado(usuario);
					System.out.println(Sesion.obtenerSesionActual().tienePrivilegios());
				} catch (Exception e){
					System.out.println(e);
				}
		
//		// Test eliminar
//		try {
//			UsuarioABM.getInstance().eliminar(7);
//		} catch (Exception e){
//			System.out.println(e);
//		}
	}

}
