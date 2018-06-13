package test;
import funciones.Funciones;
import negocio.TransaccionABM;
import negocio.TransportePublicoABM;
public class TestTraerTranssaccionesPorUsuario {

	public static void main(String[] args) {
		//System.out.println(Funciones.imprimirLista(TransaccionABM.getInstance().traer((long)25)));
      System.out.println(TransportePublicoABM.getInstance().traerTransportePublico("318"));
	}

}
