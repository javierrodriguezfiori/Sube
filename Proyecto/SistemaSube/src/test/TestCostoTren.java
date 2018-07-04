package test;

import java.util.GregorianCalendar;

import datos.TarjetaSube;
import datos.ViajeTren;
import negocio.ParadaABM;
import negocio.TransportePublicoABM;

public class TestCostoTren {

	public static void main(String[] args) throws Exception {
		
		
		
		ViajeTren viaje = new ViajeTren((float)0,new GregorianCalendar(),new TarjetaSube(),TransportePublicoABM.getInstance().traerTrenYParadas((long)6),ParadaABM.getInstance().traer((long)15),ParadaABM.getInstance().traer((long)1));
		System.out.println(TransportePublicoABM.getInstance().calcularCostoDeViaje(viaje));
		System.out.println(viaje);

	}

}
