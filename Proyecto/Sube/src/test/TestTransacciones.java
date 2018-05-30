package test;

import negocio.*;
import datos.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestTransacciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//System.out.println(TarjetaSubeABM.getInstance().traerTarjetaSube(123));
			//TransaccionABM.getInstance().agregarRecarga(50, Funciones.traerFecha(2018, 5, 9),TarjetaSubeABM.getInstance().traerTarjetaSube(123));
			//System.out.println(ParadaABM.getInstance().traer((long)1));
			//TransaccionABM.getInstance().agregarViajeTren(3,Funciones.traerFecha(2018,5,10,9,0,0),TarjetaSubeABM.getInstance().traerTarjetaSube(123),TransportePublicoABM.getInstance().traerTrenYParadas((long)1),ParadaABM.getInstance().traer((long)1),ParadaABM.getInstance().traer((long)2));
			//TransaccionABM.getInstance().agregarViajeSubte(3,Funciones.traerFecha(2018,5,10,9,0,0),TarjetaSubeABM.getInstance().traerTarjetaSube(123),TransportePublicoABM.getInstance().traerSubteYParadas((long)2),ParadaABM.getInstance().traer((long)1));
			//TransaccionABM.getInstance().agregarViajeColectivo(3,Funciones.traerFecha(2018,5,10,9,0,0),TarjetaSubeABM.getInstance().traerTarjetaSube(123),TransportePublicoABM.getInstance().traerColectivoYTramos((long)3),TramoABM.getInstance().traer((long)1));
			//System.out.println(TransaccionABM.getInstance().traerTransaccion(1));
			TerminalViaje tv=new TerminalViaje();
			TerminalRecarga tr=new TerminalRecarga();
			//ViajeColectivo v=new ViajeColectivo(0,(GregorianCalendar)Calendar.getInstance(),null,TransportePublicoABM.getInstance().traer(3),TramoABM.getInstance().traer(1));
			ViajeTren v=new ViajeTren(0,(GregorianCalendar)Calendar.getInstance(),null,TransportePublicoABM.getInstance().traer(1),ParadaABM.getInstance().traer(1),null);
			tv.cobrarViaje(TarjetaSubeABM.getInstance().traerTarjetaSube(8),v);
			/*Recarga r=new Recarga(50,(GregorianCalendar)Calendar.getInstance(),TarjetaSubeABM.getInstance().traerTarjetaSube(9));
			tr.registrarRecarga(TarjetaSubeABM.getInstance().traerTarjetaSube(9),r);*/
		}
		catch(Exception e){
			System.out.print(e.getMessage());
		}
		

	}

}
