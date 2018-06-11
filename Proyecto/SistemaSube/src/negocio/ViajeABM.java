package negocio;
import org.hibernate.Query;

import dao.ViajeDao;
import datos.Viaje;
public class ViajeABM {
	
	
	ViajeDao dao = new ViajeDao();
	public Viaje traerUltimoViaje(long nroTarjeta) {
		
		return dao.traerUltimoViaje(nroTarjeta);
	}

}
