package test;

import negocio.TransportePublicoABM;
import datos.Tren;
import negocio.ParadaABM;
import negocio.TramoABM;
import datos.Subte;
public class TestAgregarTransportePublico {

	public static void main(String[] args) throws Exception {

       // Agrego Tren Consittucion-A.Korn y sus paradas//
		//TransportePublicoABM.getInstance().agregarTren(1, "Constitucion-A.Korn");
        //Tren t = (Tren)TransportePublicoABM.getInstance().traerTrenYParadas((long)1);
        //for(int i=1;i<=15;i++) {
        	//t.agregar(ParadaABM.getInstance().traer((long)i));
        //}
        //	TransportePublicoABM.getInstance().modificar(t);
        
        //TransportePublicoABM.getInstance().modificar(t);
		//TransportePublicoABM.getInstance().agregarSubte(2, "C");
		//Subte s=(Subte) TransportePublicoABM.getInstance().tra((long)2);
		//s.agregar(ParadaABM.getInstance().traer((long)1));
		///System.out.println(s.getParadas());
		
		//Test agregar colectivo
//		try {
//			TransportePublicoABM.getInstance().agregarColectivo(4, "160");
//		} catch (Exception e) {
//			System.out.println(e);
//		}
		
		//Test agregar subte
//		try {
//			TransportePublicoABM.getInstance().agregarSubte(5, "D");
//		} catch (Exception e) {
//			System.out.println(e);
//		}
		
		//Test agregar tren
		try {
			TransportePublicoABM.getInstance().agregarTren(6, "Constitucion-Ezeiza");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
