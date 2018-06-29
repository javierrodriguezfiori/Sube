package test;

import java.util.GregorianCalendar;

import datos.TarjetaSube;
import datos.ViajeTren;
import negocio.ParadaABM;
import negocio.TransportePublicoABM;

public class TestCostoTren {

	public static void main(String[] args) {
		
		
		
		ViajeTren viaje = new ViajeTren((float)0,new GregorianCalendar(),new TarjetaSube(),TransportePublicoABM.getInstance().traerTrenYParadas((long)1),ParadaABM.getInstance().traer((long)5),ParadaABM.getInstance().traer((long)14));
		System.out.println(TransportePublicoABM.getInstance().calcularCostoDeViaje(viaje));
		System.out.println(viaje);

	}

}
