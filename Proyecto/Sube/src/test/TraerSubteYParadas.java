package test;

import negocio.TransportePublicoABM;
import negocio.ParadaABM;
import negocio.TramoABM;
import datos.Subte;
import datos.Parada;

public class TraerSubteYParadas {

	public static void main(String[] args) {
		Subte s = (Subte)TransportePublicoABM.getInstance().traerSubteYParadas(4);
		
        System.out.println(s);
//        System.out.println(Funciones.imprimirLista(s.getParadas()));
		
  }
}
