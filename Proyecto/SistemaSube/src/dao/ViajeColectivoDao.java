package dao;

import datos.ViajeColectivo;

public class ViajeColectivoDao extends DAO{
	
	private static ViajeColectivoDao instancia = null; // Patr�n Singleton

	protected ViajeColectivoDao() {}

	public static ViajeColectivoDao getInstance() {
		if (instancia == null)
			instancia = new ViajeColectivoDao();
		return instancia;
	}
	
	

}
