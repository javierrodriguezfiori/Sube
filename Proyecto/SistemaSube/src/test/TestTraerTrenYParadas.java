package test;
import negocio.TransportePublicoABM;
public class TestTraerTrenYParadas {

	public static void main(String[] args) {
		System.out.println(TransportePublicoABM.getInstance().traerTrenYParadas((long)1));

	}

}
