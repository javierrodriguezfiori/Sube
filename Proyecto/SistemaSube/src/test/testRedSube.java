package test;

import java.util.GregorianCalendar;

import datos.RedSube;
import datos.TarjetaSube;
import negocio.RedSubeABM;
import negocio.TarjetaSubeABM;

public class testRedSube {

	public static void main(String[] args) {	

		agregarRedSube(16);
			
//		System.out.println(test.modificarRedSube(9));
//
//		System.out.println(test.traerRedSube(9).toString());
		
//		GregorianCalendar fechaHora = new GregorianCalendar();
//		double precio = 9.25;
//		try {
//			precio=precio*RedSubeABM.getInstance().calcularDescuento(9,"168",fechaHora);
//			System.out.println(precio);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
		
	}
	
	public static void agregarRedSube(int nroTarjeta) {
		try{
			TarjetaSube tarjetasube= TarjetaSubeABM.getInstance().traerTarjetaSube(nroTarjeta);
			RedSubeABM.getInstance().agregar(new GregorianCalendar(), 0, "", tarjetasube);	
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static RedSube traerRedSube(long idRedSube) {
		RedSubeABM abm = RedSubeABM.getInstance();
		RedSube rs = null;
		try {
			rs=abm.traerRedSube(idRedSube);
		} catch(Exception e) { 
			System.out.println(e);
		}
		return rs;
	}
	
	public static RedSube modificarRedSube(long idRedSube) {
		RedSubeABM abm = RedSubeABM.getInstance();
		RedSube rs = null;
		GregorianCalendar fechaHora= null;
		try {
			rs=abm.traerRedSube(idRedSube);
			rs.setFechaHora(fechaHora);
			rs.setLinea("160");
			abm.modificar(rs);
		} catch(Exception e) { 
			System.out.println(e);
		}
		return rs;
	}
}
