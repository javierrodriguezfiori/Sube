package test;

import datos.*;
import negocio.*;
import java.util.GregorianCalendar;

public class testTerminal {

	public static void main(String[] args) {
		ViajeTren viaje = new ViajeTren();
		GregorianCalendar fechaHora = new GregorianCalendar();
		
		viaje.setFechaHora(fechaHora);
	}

}
