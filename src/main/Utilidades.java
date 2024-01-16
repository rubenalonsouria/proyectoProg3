package main;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import domain.MetodoDePago;

public class Utilidades {
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static String dateToString(Date d) {
		return sdf.format(d);
	}
	
	public static Date stringToDate(String s) {
		try {
			return sdf.parse(s);
		} catch (ParseException e) {
			return new Date(0); //1970-01-01
		}
	}
	
	public static void actualizarMetodosDePago(MetodoDePago m, ArrayList<String> datos) {
		/*
		 * Desarrollar para que se guarde en la base de datos
		 * @TODO
		 * */
	}
	
	public static void privilegiosAdministrador(Boolean b) {
		if (b) {
			/*AQUI IRAN LOS PRIVILEGIOS DE LOS ADMINISTRADORES*/
		}else {
			/*AQUI IRAN LOS PRIVILEGIOS DE LOS ADMINISTRADORES PERO DESACTIVADOS*/

		}
	}

}
