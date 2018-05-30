package test;

import negocio.TarjetaSubeABM;
import datos.TarjetaSube;

public class testTarjetaSube {

	public static void main(String[] args) {
		testTarjetaSube test= new testTarjetaSube();
		
		test.agregarTarjeta();
				
//		test.eliminarTarjeta(8);
		
		
//		double precio= 9.25;
//		TarjetaSubeABM abmTarjeta= new TarjetaSubeABM();
//		
//		try {
//			TarjetaSube tarjeta= abmTarjeta.traerTarjetaSube(7);
//			tarjeta.setEstado(2);
//			abmTarjeta.modificar(tarjeta);
//			precio=precio*abmTarjeta.calcularDescuento(tarjeta);
//			System.out.println((float)precio);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
		
	}
	
	public void agregarTarjeta() {
		float saldo = 50;
		TarjetaSubeABM abm = TarjetaSubeABM.getInstance();
		int idUsuario=1;
		int estado=0;
		try{
			abm.agregar(idUsuario, saldo, estado);
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void eliminarTarjeta(long nroTarjeta) {
		TarjetaSubeABM abm = TarjetaSubeABM.getInstance();
		try {
			abm.eliminar(nroTarjeta);
		} catch(Exception e) { 
			System.out.println(e);
		}
	}
}
