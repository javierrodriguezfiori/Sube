package test;
import java.util.GregorianCalendar;

import dao.ViajeColectivoDao;
import dao.ViajeDao;
import funciones.Funciones;
public class TestTraerSubtesPorTramo {

	public static void main(String[] args) {
		
		GregorianCalendar ini = Funciones.traerFecha("05/05/2018", "00:00:00");
		GregorianCalendar fin = Funciones.traerFecha("05/06/2018", "00:00:00");
		
		//System.out.println(Funciones.imprimirLista(ViajeColectivoDao.getInstance().traerViajesSubte(ini, fin, (long)4)));

	}

}
