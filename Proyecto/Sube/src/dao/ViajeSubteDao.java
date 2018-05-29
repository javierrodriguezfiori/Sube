package dao;

import datos.ViajeSubte;

public class ViajeSubteDao extends DAO{
	
	private static ViajeSubteDao instancia = null; // Patr�n Singleton

	protected ViajeSubteDao() {}

	public static ViajeSubteDao getInstance() {
		if (instancia == null)
			instancia = new ViajeSubteDao();
		return instancia;
	}
	
	

}
