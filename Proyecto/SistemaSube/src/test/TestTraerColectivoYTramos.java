package test;

import negocio.TramoABM;
import negocio.TransportePublicoABM;
import datos.Colectivo;

public class TestTraerColectivoYTramos {

	public static void main(String[] args) {
		Colectivo c = TransportePublicoABM.getInstance().traerColectivoYTramos((long)5);
		System.out.println(c);
	//	System.out.println(Funciones.imprimirLista(c.getTramos()));
	}

}
