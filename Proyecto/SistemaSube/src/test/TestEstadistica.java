package test;
import java.util.GregorianCalendar;

import funciones.Funciones;
import negocio.ViajeABM;
public class TestEstadistica {

	public static void main(String[] args) {
		
		
		GregorianCalendar ini = Funciones.traerFecha(2018, 02, 22);
	    GregorianCalendar fin = Funciones.traerFecha(2019, 02, 22);
		//System.out.println(Funciones.imprimirLista(ViajeABM.getInstance().estadisticaViajeColectivo(ini, fin, (long)3).getMuestras()));
       // System.out.println(funciones.Funciones.imprimirLista(ViajeABM.getInstance().traerViajesColectivo(ini, fin,(long)3 )));
	    //System.out.println(funciones.Funciones.imprimirLista(ViajeABM.getInstance().estadisticaViajeSubte(ini, fin, (long)2).getMuestras()));
	   // System.out.println(funciones.Funciones.imprimirLista(ViajeABM.getInstance().estadisticaViajeTren(ini, fin, (long)1).getMuestras()));
	    
	    
	    //System.out.println(funciones.Funciones.imprimirLista(ViajeABM.getInstance().estadisticaSumMontosViajesTren(ini, fin, (long)1).getMuestras()));
	   // System.out.println(funciones.Funciones.imprimirLista(ViajeABM.getInstance().estadisticaCantViajesTren(ini, fin, (long)1).getMuestras()));
	    System.out.println(funciones.Funciones.imprimirLista(ViajeABM.getInstance().estadisticaSumMontosViajesColectivo(ini, fin, (long)3).getMuestras()));
	}

}
