package test;

import dao.SeccionRecorridoDao;
import negocio.ParadaABM;
import datos.Parada;

public class TestTraerSeccionesPorRecorrido {

	public static void main(String[] args) {
		SeccionRecorridoDao sr = new SeccionRecorridoDao();
		//System.out.println(Funciones.imprimirLista(sr.traer()));
		Parada origen = ParadaABM.getInstance().traer((long)1);
		Parada destino = ParadaABM.getInstance().traer((long)9);
		//System.out.println(origen);
		//System.out.println(destino);
		System.out.println(sr.traer(origen, destino));

	}

}
