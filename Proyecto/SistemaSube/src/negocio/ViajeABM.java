package negocio;

import dao.ViajeDao;
import datos.Viaje;

public class ViajeABM {
	public static ViajeABM instance = null;
	
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

}
