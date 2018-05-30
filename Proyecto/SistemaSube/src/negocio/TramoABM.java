package negocio;
import dao.TramoDao;
import datos.Tramo;
public class TramoABM {
	
	public static TramoABM instance = null;
	
	protected TramoABM() {}
	
	public static TramoABM getInstance() {
		if(instance==null) {
			instance = new TramoABM();
		}
		return instance;
	}
	
	public long agregar(String distancia,float costo) {
		Tramo tramo = new Tramo(distancia,costo);
		return TramoDao.getInstance().agregar(tramo);
	}
	
	public Tramo traer(long idTramo) {
		return TramoDao.getInstance().traer(idTramo);
	}

}
