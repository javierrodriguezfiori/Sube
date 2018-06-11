package test;

import java.util.GregorianCalendar;

import datos.RedSube;
import datos.TarjetaSube;
import negocio.RedSubeABM;
import negocio.TarjetaSubeABM;

public class testRedSube {

	public static void main(String[] args) {
		testRedSube test= new testRedSube();
		RedSubeABM abm = RedSubeABM.getInstance();
		
//		test.agregarRedSube();
			
//		System.out.println(test.modificarRedSube(9));
//
//		System.out.println(test.traerRedSube(9).toString());
		
		GregorianCalendar fechaHora = new GregorianCalendar();
		double precio = 9.25;
		try {
			precio=precio*abm.calcularDescuento(9,"168",fechaHora);
			System.out.println(precio);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void agregarRedSube() {
		RedSubeABM abmRedSube = RedSubeABM.getInstance();
		GregorianCalendar fechaHora = null;
		int contador=0; 
		int nroTarjeta=9;
		String linea="";
		TarjetaSubeABM abmTarjeta = TarjetaSubeABM.getInstance();
		
		try{
			TarjetaSube tarjetasube= abmTarjeta.traerTarjetaSube(nroTarjeta);
			abmRedSube.agregar(fechaHora, contador, linea, tarjetasube);	
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public RedSube traerRedSube(long idRedSube) {
		RedSubeABM abm = RedSubeABM.getInstance();
		RedSube rs = null;
		try {
			rs=abm.traerRedSube(idRedSube);
		} catch(Exception e) { 
			System.out.println(e);
		}
		return rs;
	}
	
	public RedSube modificarRedSube(long idRedSube) {
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
