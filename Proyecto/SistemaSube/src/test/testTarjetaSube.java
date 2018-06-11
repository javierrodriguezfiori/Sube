package test;

import negocio.TarjetaSubeABM;
import datos.TarjetaSube;;

public class testTarjetaSube {

	public static void main(String[] args) {
		
		
		// Test agregar 
			try {
				TarjetaSubeABM.getInstance().agregar(500, 0);
			} catch (Exception e) {
				System.out.println(e);
			}
		
		// Test eliminar 
//			try {
//				TarjetaSubeABM.getInstance().eliminar(14);
//			} catch (Exception e) {
//				System.out.println(e);
//			}
		
//		// Test modificar
//			try {
//				Usuario user=UsuarioDAO.getInstance().traerUsuario(6);
//				TarjetaSube tarjeta=TarjetaSubeABM.getInstance().traerTarjetaSube(16);
//				tarjeta.setEstado(1);
//				TarjetaSubeABM.getInstance().modificar(tarjeta);
//				
//			} catch (Exception e) {
//				System.out.println(e);
//			}
			
//		// Test traer por nroTarjeta
//			try {
//				System.out.println(TarjetaSubeABM.getInstance().traerTarjetaSube(14));
//			} catch (Exception e) {
//				System.out.println(e);
//			}
	}
}
