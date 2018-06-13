package test;
import dao.ViajeDao;
import funciones.Funciones;
import java.util.GregorianCalendar;
public class TestTraerViajesPorFecha {

	public static void main(String[] args) {
		ViajeDao viajeDao = new ViajeDao();
		GregorianCalendar ini = Funciones.traerFecha("05/05/2018", "00:00:00");
		GregorianCalendar fin = Funciones.traerFecha("05/06/2018", "00:00:00");
		//System.out.println(Funciones.imprimirLista(viajeDao.traerViajesTren(ini, fin)));
		
		System.out.println(Funciones.imprimirLista(viajeDao.traerViajesSubte(ini, fin)));
		
		//System.out.println(Funciones.imprimirLista(viajeDao.traerViajesColectivo(ini, fin)));

	}

}
