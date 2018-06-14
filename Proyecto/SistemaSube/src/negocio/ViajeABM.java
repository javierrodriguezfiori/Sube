package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.ViajeDao;
import datos.Viaje;
import funciones.Funciones;

public class ViajeABM {
	private static ViajeABM instance = null;
	
	protected ViajeABM() {}
	
	public static ViajeABM getInstance() {
		if(instance==null) {
			instance = new ViajeABM();
		}
		return instance;
	}
	
	public Viaje traerUltimoViaje(long nroTarjeta) {
		
		return ViajeDao.getInstance().traerUltimoViaje(nroTarjeta);
	}
	
	
	
	public List<Viaje> traerViajesTren(GregorianCalendar ini,GregorianCalendar fin){
		return ViajeDao.getInstance().traerViajesTren(ini, fin);
	}
	
	
	public List<Viaje> traerViajesColectivo(GregorianCalendar ini,GregorianCalendar fin){
		
		return ViajeDao.getInstance().traerViajesColectivo(ini, fin);
	}
	
	
	public List<Viaje> traerViajesSubte(GregorianCalendar ini,GregorianCalendar fin){
		return ViajeDao.getInstance().traerViajesSubte(ini, fin);
	}

}
