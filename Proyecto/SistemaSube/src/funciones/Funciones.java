package funciones;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

/**
 * Esta Clase define varios metodos útiles para
 * el tratamiento de fechas,caracteres,string,numeros y listas.
 * @author Mauro Lucas Pereyra
 * @version 15/04/2018
 *
 */
public class Funciones {
	/**
	 * Metodo que permite sumar dos numeros pasados
	 * por parametro.
	 * @param num1 - Valor ingresado por parametro.
	 * @param num2 - Valor ingresado por parametro.
	 * @return - Retorna la suma de num1 y num2
	 */
	public static int sumar(int num1,int num2) {
		return num1+num2;
	}
	

	/**
	 * Metodo que permite saber si un año es bisiesto o no es bisiesto.
	 * @note Un año es bisiesto cuando el mes de febrero tiene 29 dias,
	 * esto ocurre cada 4 años.
	 * @param anio - Valor ingreado por parametro de tipo entero.
	 * @return <ul>
	 *          <li>true: el año es bisiesto</li>
	 *          <li>false: el año no es bisiesto</li>
	 *         </ul>
	 * 
	 */

	public static boolean esBisiesto(int anio) {
		boolean bisiesto;
		if(anio%4==0  && (anio%100!=0 || anio%400==0)) {
			
			bisiesto = true;
		}
		else {
			bisiesto=false;
		}
		
		return bisiesto;
	}
	
	/** 
	 * Metodo para saber el año de una fecha pasada por parametro.
	 * @param fecha : Valor de tipo GregorianCalendar
	 * @return año de la fecha.
	 */
	

	public static int traerAnio(GregorianCalendar fecha) {
		
		return fecha.get(Calendar.YEAR);
	}

	/**
	 * Metodo para saber el mes de una fecha pasada por parametro.
	 * @param fecha : Valor de tipo GregorianCalendar
	 * @return mes de la fecha.
	 */

	public static int traerMes(GregorianCalendar fecha) {
		
		return fecha.get(Calendar.MONTH)+1;
	}
	

	/**
	 * Metodo para saber el día de una fecha pasada por parametro.
	 * @param fecha : Valor de tipo GregorianCalendar
	 * @return día de la fecha.
	 */

	public static int traerDia(GregorianCalendar fecha) {
		
		return fecha.get(Calendar.DAY_OF_MONTH);
	}
	
	
	
	/**
	 * Metodo que genera un objeto GregorianCalendar con el dia, mes y anio ingresados por parametro.
	 * @param anio : valor de tipo int
	 * @param mes : valor de tipo int
	 * @param dia : valor de tipo int
	 * @return objeto GregorianCalendar con la fecha introducida.
	 */
	
	public static GregorianCalendar traerFecha(int anio,int mes,int dia) {
		
		GregorianCalendar resultado = new GregorianCalendar();
		if(esFechaValida(anio,mes,dia)) {
		resultado.set(anio, mes-1, dia);
		resultado.setTime(resultado.getTime());
		}
		else {
			resultado=null;
		}
		
		return(resultado);
		
	}


	/**
	 * Metodo para saber si una fecha es valida o no es valida.
	 * @note Una fecha es válida dependiendo de la cantidad de días del mes
	 * y si es bisiesto o no(en el caso del mes de febrero). 
	 * @param anio - Valor ingresado por parametro.
	 * @param mes - Valor ingresado por parametro.
	 * @param dia - Valor ingresado por parametro.
	 * @return <ul>
	 *          <li>true: si la fecha es válida</li>
	 *          <li>false: si la fecha no es válida</li>
	 *         </ul>
	 */
	public static boolean esFechaValida(int anio,int mes,int dia) {
		
		boolean fechaValida=true;
	    
		switch (mes) {
		
		case 1:if(dia>31) fechaValida=false;break;
		case 2:if(dia>28 && !esBisiesto(anio))fechaValida=false;break;
		case 3:if(dia>31)fechaValida=false; break;
		case 4:if(dia>30)fechaValida=false; break;
		case 5:if(dia>31)fechaValida=false; break;
		case 6:if(dia>30)fechaValida=false; break;
		case 7:if(dia>31)fechaValida=false; break;
		case 8:if(dia>31)fechaValida=false; break;
		case 9:if(dia>30)fechaValida=false; break;
		case 10:if(dia>31)fechaValida=false; break;
		case 11:if(dia>30)fechaValida=false; break;
		case 12:if(dia>31)fechaValida=false; break;
		default :fechaValida=false;
		}
		return fechaValida;
	}
	
	
	/**
	 * Metodo para crear una fecha de tipo GregorianCalendar a partir
	 * de un anio, mes, dia, horas, minutos, segundos de tipo entero 
	 * pasados por parametro. 
	 * @param anio - Valor ingresado por parametro.
	 * @param mes - Valor ingresado por parametro.
	 * @param dia - Valor ingresado por parametro.
	 * @param horas - Valor ingresado por parametro.
	 * @param minutos - Valor ingresado por parametro.
	 * @param segundos - Valor ingresado por parametro.
	 * @return fecha de tipo GregorianCalendar
	 */
	public static GregorianCalendar traerFecha(int anio,int mes,int dia,int horas,int minutos,int segundos) {

		
		GregorianCalendar resultado = new GregorianCalendar();
		if(esFechaValida(anio,mes,dia)) {
		resultado.set(anio, mes-1, dia,horas,minutos,segundos);
		resultado.setTime(resultado.getTime());
		}
		else {
			resultado=null;
		}
		
		return(resultado);
		
	}

	

	/**
	 * Metodo para crear una fecha de tipo GregorianCalendar a partir
	 * de String pasado por parametro.
	 * @note DD/MM/AA
     * @param anio - Valor ingresado por parametro.
	 * @param mes - Valor ingresado por parametro.
	 * @param dia - Valor ingresado por parametro.
	 * @param horas - Valor ingresado por parametro.
	 * @param minutos - Valor ingresado por parametro.
	 * @param segundos - Valor ingresado por parametro.
	 * @return fecha de tipo GregorianCalendar

	 */

	public static GregorianCalendar traerFecha(String fecha) {
		
		GregorianCalendar resultado = new GregorianCalendar();
		if(fecha.length()==10) {
		String dia= fecha.substring(0,2);
		String mes = fecha.substring(3,5);
		String anio=fecha.substring(6,10);
			
		
		resultado.set(Integer.parseInt(anio),Integer.parseInt(mes)-1,Integer.parseInt(dia));  // paso de string a int
		resultado.setTime(resultado.getTime());
		}
		else {
			resultado=null;
		}
		return resultado;
	}
	
	public static GregorianCalendar traerFecha(String fecha,String hora) {
		
		GregorianCalendar resultado = new GregorianCalendar();
		if(fecha.length()==10) {
		String dia= fecha.substring(0,2);
		String mes = fecha.substring(3,5);
		String anio=fecha.substring(6,10);
		
		String h=hora.substring(0,2);
	    String m=hora.substring(3,5);
	    String s=hora.substring(6,8);
		
		
		resultado.set(Integer.parseInt(anio),Integer.parseInt(mes)-1,Integer.parseInt(dia),
				Integer.parseInt(h),Integer.parseInt(m),Integer.parseInt(s));  // paso de string a int
		resultado.setTime(resultado.getTime());
		}
		else {
			resultado=null;
		}
		return resultado;
	}
	

	/**
	 * Metodo que recibe un dato de tipo GregorianCalendar y retorna en un String 
	 * la fecha.
	 * @param fecha - Valor ingresado por parametro.
	 * @return dia, mes y año de la fecha.  
	 */

	public static String traerFechaCorta(GregorianCalendar fecha) {
		String resultado = new String();
		if(fecha!=null) {
			
			String dia=String.valueOf(fecha.get(Calendar.DAY_OF_MONTH));
			String mes=String.valueOf(fecha.get(Calendar.MONTH)+1);
			String anio = String.valueOf(fecha.get(Calendar.YEAR));
					
					
			
			resultado = (dia+ "/" +mes + "/" + anio);
		}
		else {
			resultado=null;
		}
		return resultado;
		
	}
	
	/**
	 * Metodo que recibe un dato de tipo GregorianCalendar y retorna en un String 
	 * la fecha.
	 * @param fecha - Valor ingresado por parametro.
	 * @return segundos, minutos, horas, dia, mes y año  de la fecha.  
	 */

	public static String traerFechaCortaHora(GregorianCalendar fecha) {
		
		String resultado = new String();
		if(fecha!=null) {
			
			String dia=String.valueOf(fecha.get(Calendar.DAY_OF_MONTH));
			String mes=String.valueOf(fecha.get(Calendar.MONTH)+1);
			String anio = String.valueOf(fecha.get(Calendar.YEAR));
			String hora = String.valueOf(fecha.get(Calendar.HOUR_OF_DAY));
			String minutos=String.valueOf(fecha.get(Calendar.MINUTE));
			String segundos=String.valueOf(fecha.get(Calendar.SECOND));
					
					
			
			resultado = (anio+ "/" +mes + "/" + dia + " " + hora+":"+minutos+":"+segundos);
		}
		else {
			resultado=null;
		}
		return resultado;
	}
	
	/**
	 * Metodo que trae un objeto GregorianCalendar con la cantidad de dias ingresada por parametro,
	 * sumada a la fecha GregorianCalendar que ingresa junto con esta.
	 * @param fecha : valor tipo GregorianCalendar
	 * @param cantdias : valor tipo int
	 * @return objeto GregorianCalendar con los dias agregados a la fecha inicial.
	 */
	
	public static GregorianCalendar traerFechaProximo(GregorianCalendar fecha,int cantdias) {
		
		
		GregorianCalendar resultado = (GregorianCalendar) fecha.clone();
		resultado.add(GregorianCalendar.DAY_OF_YEAR, cantdias);
		resultado.setTime(resultado.getTime());
		return resultado;
		
		
		
	}
	
	/**
	 * Metodo que determina si una fecha es un dia habil o no (Dias habiles: Lunes, Martes, Miercoles, Jueves, Viernes)
	 * @param fecha : valor de tipo GregorianCalendar
	 * @return <ul>
	 *          <li>true: el dia es habil</li>
	 *          <li>false: el dia no es habil</li>
	 *         </ul>
	 */
	public static boolean esDiaHabil(GregorianCalendar fecha) {
	boolean resultado=true;	
	switch(fecha.get(Calendar.DAY_OF_MONTH)){
	case 1:resultado=false;
	case 7:resultado=false;
	}
	return resultado;
	}
	
	/**
	 * Metodo que trae el nombre del dia de la semana de la fecha ingresada como parametro.
	 * @param fecha : valor de tipo GregorianCalendar
	 * @return String con el nombre del dia. </br>
	 * <ol>
	 * <li>Lunes</li>
	 * <li>Martes</li>
	 * <li>Miercoles</li>
	 * <li>Jueves</li>
	 * <li>Viernes</li>
	 * <li>Sabado</li>
	 * <li>Domingo</li>
	 * </ol>
	 *                                     
	 */
	
	public static String traerDiaDeLaSemana(GregorianCalendar fecha) {
		
		String resultado = new String();
		int dia= fecha.get(Calendar.DAY_OF_WEEK);
		switch(dia) {
		
		case 1:resultado="Domingo"; break;
		case 2:resultado="Lunes";break;
		case 3:resultado="Martes";break;
		case 4:resultado="Miercoles";break;
		case 5:resultado="Jueves";break;
		case 6:resultado="Viernes";break;
		case 7:resultado="Sabado";break;
		
		}
		
		return resultado;
	}
	
	/**
	 * Metodo que trae el nombre del mes de la fecha ingresada como parametro.
	 * @param fecha : valor de tipo GregorianCalendar
	 * @return String con el nombre del mes </br>
	 * <ol>
	 * <li>Enero</li>
	 * <li>Febrero</li>
	 * <li>Marzo</li>
	 * <li>Abril</li>
	 * <li>Mayo</li>
	 * <li>Junio</li>
	 * <li>Julio</li>
	 * <li>Agosto</li>
	 * <li>Septiembre</li>
	 * <li>Octubre</li>
	 * <li>Noviembre</li>
	 * <li>Diciembre</li>
	 */
	
	public static String traerMesEnLetras(GregorianCalendar fecha) {
		String resultado=new String();
		int mes=fecha.get(Calendar.MONTH);
		switch(mes) {
		
		case 0:resultado="Enero";break;
		case 1:resultado="Febrero";break;
		case 2:resultado="Marzo";break;
		case 3:resultado="Abril";break;
		case 4:resultado="Mayo";break;
		case 5:resultado="Junio";break;
		case 6:resultado="Julio";break;
		case 7:resultado="Agosto";break;
		case 8:resultado="Septiempre";break;
		case 9:resultado="Octubre";break;
		case 10:resultado="Noviembre";break;
		case 11:resultado="Diciembre";break;
		}
		
		return resultado;
	}
	
	/**
	 * Metodo que trae como String la fecha ingresada como parametro (Formato: dia numero de mes del anio)
	 * @param fecha : valor de tipo GregorianCalendar
	 * @return String con el formato de la fecha
	 */
	
	public static String traerFechaLarga(GregorianCalendar fecha) {
		
		String resultado = new String();
		resultado=traerDiaDeLaSemana(fecha)+" " + String.valueOf(fecha.get(Calendar.DAY_OF_MONTH)+" de "+ traerMesEnLetras(fecha)+" del "+String.valueOf(fecha.get(Calendar.YEAR)));
		return resultado;
	}

	  /**
     * Metodo para saber si dos fechas son iguales.
     * @note las fechas van a ser iguales cuando compartan el mismo dia mes y año.
     * @param fecha - Valor ingresado como parametro
     * @param fecha1 - Valor ingresado como parametro
     * @return <ul>
     *          <li>true : si las fechas son iguales</li>
     *          <li>false : si las fechas no son iguales</li>
     */

	
	public static boolean sonFechasIguales(GregorianCalendar fecha,GregorianCalendar fecha1) {
		
		boolean resultado=false;
		
		if (fecha.get(Calendar.DAY_OF_MONTH)== fecha1.get(Calendar.DAY_OF_MONTH)) {
			if(fecha.get(Calendar.MONTH)==fecha1.get(Calendar.MONTH)) {
				if(fecha.get(Calendar.YEAR)==fecha1.get(Calendar.YEAR)) {
					resultado=true;
				}
			}
			
		}
		return resultado;
	}
	
	 /**
     * Metodo para saber si dos fechas y hora son iguales.
     * @note las fechas van a ser iguales cuando compartan el mismo dia,mes,año y los
     * mismos segundos minutos y horas.
     * @param fecha - Valor ingresado como parametro
     * @param fecha1 - Valor ingresado como parametro
     * @return <ul>
     *          <li>true : si las fechas son iguales</li>
     *          <li>false : si las fechas no son iguales</li>
     */
	public static boolean sonFechasHorasIguales(GregorianCalendar fecha,GregorianCalendar fecha1) {

		
		boolean resultado=false;
		
		if (fecha.get(Calendar.DAY_OF_MONTH)== fecha1.get(Calendar.DAY_OF_MONTH)) {
			if(fecha.get(Calendar.MONTH)==fecha1.get(Calendar.MONTH)) {
				if(fecha.get(Calendar.YEAR)==fecha1.get(Calendar.YEAR)) {
					if(fecha.get(Calendar.HOUR)==fecha1.get(Calendar.HOUR)) {
						if(fecha.get(Calendar.MINUTE)==fecha1.get(Calendar.MINUTE)) {
							if(fecha.get(Calendar.SECOND)==fecha1.get(Calendar.SECOND)) {
								resultado=true;
							}
						}
					}
				}
			}
			
		}
		return resultado;
	}
	
	/**
	 * Metodo que trae la cantidad de dias que tiene un mes en determinado año.
	 * @param anio : valor de tipo int
	 * @param mes : valor de tipo int
	 * @return numero de dias que tiene el mes
	 */
	
	public static int traerCantDiasDeUnMes(int anio,int mes) {
		int resultado=0;
		switch(mes) {
		
		case 1:resultado=31;
		case 2:if(esBisiesto(anio))resultado=29;else resultado=28;break;
		case 3:resultado=31;
		case 4:resultado=30;
		case 5:resultado=31;
		case 6:resultado=30;
		case 7:resultado=31;
		case 8:resultado=31;
		case 9:resultado=30;
		case 10:resultado=31;
		case 11:resultado=30;
		case 12:resultado=31;
		}
		
		return resultado;
	}
	
	/**
	 * Metodo que formatea numero decimal a un maximo de 2 decimales
	 * @param valor : double a formatear
	 * @return numero con 2 decimales
	 */
	
	public static double aproximar2Decimal(double valor) {
		
		 return Math.rint(valor*100)/100;
	}

	/**
	 * Metodo para saber si un caracter es una numero.
	 * @param c - Valor ingresado por parametro
	 * @return <ul>
	 *          <li>true: si es un numero</li>
	 *          <li>false: no es un numero</li>
	 */

	public static boolean esNumero(char c) {
		
		return (Character.isDigit(c));
	}


	
	/**
	 * Metodo para saber si un caracter es una letra.
	 * @param c - Valor ingresado por parametro
	 * @return <ul>
	 *          <li>true: si es una letra</li>
	 *          <li>false: no es una letra</li>
	 */

	public static boolean esLetra(char c) {
		return (Character.isLetter(c));
	}
	
	/**
	 * Metodo para saber si un String es una cadena
	 * de numeros.
	 * @param cadena - Valor ingresado como parametro
	 * @return <ul>
	 *          <li>true: es una cadena de numeros</li>
	 *          <li>false: no es una cadena de numeros</li>
	 *         </ul>
	 */

	public static boolean esCadenaNros(String cadena) {
		boolean resultado=true;
		for(int i=0;i<cadena.length();i++) {
			char c=cadena.charAt(i);
			if(!Character.isDigit(c)) {
				resultado=false;
			}
		}
		return resultado;
	}
	

	/**
	 * Metodo para saber si un String es una cadena
	 * de letras.
	 * @param cadena - Valor ingresado como parametro
	 * @return <ul>
	 *          <li>true: es una cadena de letras</li>
	 *          <li>false: no es una cadena de letras</li>
	 *         </ul>
	 */

	public static boolean esCadenaLetras(String cadena) {
		boolean resultado=true;
		for(int i=0;i<cadena.length();i++) {
			char c=cadena.charAt(i);
			if(!Character.isLetter(c)) {
				resultado=false;
			}
		}
		return resultado;
	}


	/**
	 * Metodo para castear un valor de tipo entero.
	 * @param n - Valor de tipo int
	 * @return parametro n casteado a double.
	 */

	public static double convertirADouble(int n) {
		
		return ((double) n);
	}
	

	/**
	 * Metodo que recibe una lista de tipo generico y retorna un String
	 * con las posiciones de la lista y un salto de linea
	 * @param lista - Parametro generico.
	 * @return resultado : lista con los saltos de linea.
	 */

	public static<E> String imprimirLista  (List<E> lista) {
		String resultado = new String();
		for(E objeto : lista) {
			resultado += objeto.toString() + "\n";
		}
		return resultado;

  }
	
	public static<E> String imprimirLista  (Set<E> lista) {
		String resultado = new String();
		for(E objeto : lista) {
			resultado += objeto.toString() + "\n";
		}
		return resultado;
	}
}