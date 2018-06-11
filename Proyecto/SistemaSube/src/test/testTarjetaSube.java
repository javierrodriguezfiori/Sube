package test;

import negocio.TarjetaSubeABM;
import negocio.UsuarioABM;
import dao.UsuarioDAO;
import datos.*;

public class testTarjetaSube {

	public static void main(String[] args) {
		
		
//		// Test agregar 
//			try {
//				TarjetaSubeABM.getInstance().agregar(500, 0, null, null);
//			} catch (Exception e) {
//				System.out.println(e);
//			}
		
		// Test eliminar 
			
//		// Test modificar
//			try {
//				Usuario user=UsuarioDAO.getInstance().traerUsuario(6);
//				TarjetaSube tarjeta=TarjetaSubeABM.getInstance().traerTarjetaSube(13);
//				tarjeta.setUsuario(user);
//				System.out.println(user+""+tarjeta);
//				TarjetaSubeABM.getInstance().modificar(tarjeta);
//				
//			} catch (Exception e) {
//				System.out.println(e);
//			}
			
		// Test traer por nroTarjeta
			try {
				System.out.println(TarjetaSubeABM.getInstance().traerTarjetaSube(13));
			} catch (Exception e) {
				System.out.println(e);
			}
	}
}
