package org.osasistemas.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class UtilTexto {
	public static String calendarToString(Calendar calendarRecibo) {
		SimpleDateFormat formatter = null;
		formatter = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");

		try {
			formatter.setLenient(false);
			return formatter.format(calendarRecibo.getTime());
		} catch (Exception arg2) {
			System.out.println("La Fecha es Incorrecta");
			return null;
		}
	}

}
