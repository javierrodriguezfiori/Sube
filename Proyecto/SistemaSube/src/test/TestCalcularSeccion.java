package test;
import datos.Parada;
import datos.Tren;
import datos.ViajeTren;
import funciones.Funciones;
import negocio.ParadaABM;
import negocio.TransportePublicoABM;
public class TestCalcularSeccion {

	public static void main(String[] args) throws Exception {
		Tren tren = TransportePublicoABM.getInstance().traerTrenYParadas((long)1);
		System.out.println(Funciones.imprimirLista(tren.getParadas()));
		Parada origen = ParadaABM.getInstance().traer((long)1);
		Parada destino = ParadaABM.getInstance().traer((long)1);
		System.out.println(origen);
		System.out.println(destino);
		System.out.println();
		System.out.println(tren.calcularDistanciaViaje(destino, origen));
		
		System.out.println(tren.calcularSeccionViaje(destino, origen));
		
		
		

	}

}
