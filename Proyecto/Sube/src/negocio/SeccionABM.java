package negocio;
import dao.SeccionDao;
import datos.Seccion;
public class SeccionABM {
	
	SeccionDao dao = new SeccionDao();
	private static SeccionABM instance = null;
	protected SeccionABM() {}
	
	public static SeccionABM getInstance() {
		if(instance==null) {
			instance = new SeccionABM();
		}
		return instance;
	}
	
	public Seccion traer(long idSeccion) {
		return dao.traer(idSeccion);
	}

}
