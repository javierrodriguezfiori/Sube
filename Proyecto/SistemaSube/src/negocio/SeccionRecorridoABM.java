package negocio;
import org.hibernate.HibernateException;

import dao.SeccionRecorridoDao;
import datos.Parada;
import datos.SeccionRecorrido;
public class SeccionRecorridoABM {
	
	SeccionRecorridoDao dao = new SeccionRecorridoDao();
	 public static SeccionRecorridoABM instance = null;
	 protected SeccionRecorridoABM() {}
	 public static SeccionRecorridoABM getInstance() {
		 if(instance==null) {
			 instance = new SeccionRecorridoABM();
		 }
		 return instance;
	 }
	public SeccionRecorrido traer(Parada origen,Parada destino)throws HibernateException {
		
		return dao.traer(origen, destino);
	}

}
