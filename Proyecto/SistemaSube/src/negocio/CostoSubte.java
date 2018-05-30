package negocio;
import dao.CostoSubteDao;

public class CostoSubte {
	
	private static CostoSubte instance=null;
	protected CostoSubte() {}
	public static CostoSubte getInstance() {
		if(instance==null) {
			instance = new CostoSubte();
		}
		return instance;
	}
	
	public float traerCostoSubte() {
		CostoSubteDao cs = new CostoSubteDao();
		return cs.traer().getCosto();
	}

}
