package dao;

import datos.ViajeColectivo;

public class ViajeColectivoDao extends DAO{
	
	private static ViajeColectivoDao instancia = null; // Patrón Singleton

	protected ViajeColectivoDao() {}

	public static ViajeColectivoDao getInstance() {
		if (instancia == null)
			instancia = new ViajeColectivoDao();
		return instancia;
	}
	
	

}
