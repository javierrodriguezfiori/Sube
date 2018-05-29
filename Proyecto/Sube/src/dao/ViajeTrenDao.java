package dao;

import datos.ViajeTren;

public class ViajeTrenDao extends DAO{
	
	private static ViajeTrenDao instancia = null; // Patrón Singleton

	protected ViajeTrenDao() {}

	public static ViajeTrenDao getInstance() {
		if (instancia == null)
			instancia = new ViajeTrenDao();
		return instancia;
	}
	

}
