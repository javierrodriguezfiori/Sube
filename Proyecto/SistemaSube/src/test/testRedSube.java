package test;

import java.util.GregorianCalendar;

import datos.RedSube;
import datos.TarjetaSube;
import funciones.Funciones;
import negocio.RedSubeABM;
import negocio.TarjetaSubeABM;

public class testRedSube {

	public static void main(String[] args) {	

//		//Test calcular descuento
//		try {
//			System.out.println(RedSubeABM.getInstance().calcularDescuento(25,"318",new GregorianCalendar()));
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	
	}
	
//	public static void agregarRedSube(int nroTarjeta) {
//		try{
//			TarjetaSube tarjetasube= TarjetaSubeABM.getInstance().traerTarjetaSube(nroTarjeta);
//			RedSubeABM.getInstance().agregar(new GregorianCalendar(), 0, "", tarjetasube);	
//		} catch(Exception e) {
//			System.out.println(e);
//		}
//	}
//	
//	public static RedSube traerRedSube(long idRedSube) {
//		RedSubeABM abm = RedSubeABM.getInstance();
//		RedSube rs = null;
//		try {
//			rs=abm.traerRedSube(idRedSube);
//		} catch(Exception e) { 
//			System.out.println(e);
//		}
//		return rs;
//	}
//	
//	public static RedSube modificarRedSube(long idRedSube) {
//		RedSubeABM abm = RedSubeABM.getInstance();
//		RedSube rs = null;
//		GregorianCalendar fechaHora= null;
//		try {
//			rs=abm.traerRedSube(idRedSube);
//			rs.setFechaHora(fechaHora);
//			rs.setLinea("160");
//			abm.modificar(rs);
//		} catch(Exception e) { 
//			System.out.println(e);
//		}
//		return rs;
//	}
}
