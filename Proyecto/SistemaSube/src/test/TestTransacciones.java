package test;

import negocio.*;
import datos.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestTransacciones {

	public static void main(String[] args) {
		try {
			TerminalViaje tv=new TerminalViaje();
			TerminalRecarga tr=new TerminalRecarga();
			
			ViajeTren vTren=new ViajeTren(0,(GregorianCalendar)Calendar.getInstance(),TarjetaSubeABM.getInstance().traerTarjetaSube(8),TransportePublicoABM.getInstance().traer(1),ParadaABM.getInstance().traer(5),null);
			ViajeSubte vSubte=new ViajeSubte(0,(GregorianCalendar)Calendar.getInstance(),TarjetaSubeABM.getInstance().traerTarjetaSube(8),TransportePublicoABM.getInstance().traer(2),ParadaABM.getInstance().traer(16));
			
			tv.cobrarViaje(vTren);
		}
		catch(Exception e){
			System.out.print(e.getMessage());
		}
		

	}

}
