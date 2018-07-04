package dao;

import datos.RedSube;
import datos.Rol;

public class RolDao extends DAO {
	public Rol traerRol() {
		Rol objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (Rol)session.get(Rol.class , 1);
		} finally {
			session.close();
		}
		
		return objeto;
	}
}
