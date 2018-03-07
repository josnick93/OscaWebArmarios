package org.osasistemas.utils;

public class Comandos {
	public static final String INI = "*";
	public static final String CRLF = "\r\n";
	public static final String SEPARADOR_CAMPOS = "\\$";
	public static final String CADENA_PA = "XXY";
	public static final String PUNTO_ACCESO_BASE = "GXXY";
	public static String PUNTO_ACCESO = "GXXY";
	private static final String META_SHELF = "@@shelf@@";
	public static final String MOVER = "$M XR$E20$T@@shelf@@$F001$O01$H01$C04000$P1$Z0$M0$";
	public static final String CONSULTAR = "$M XR$E12$";

	
	//crea una ristra de bytes para cada comando a enviar
	public static byte[] crearOrden(String orden) {
		return ("*" + PUNTO_ACCESO + orden + "\r\n").getBytes();
	}

	//limpia el host
	public static byte[] pollingHost() {
		return "*\r\n".getBytes();
	}

	public static String moverA(int estanteriaRecibo) {
		StringBuilder estanteria = new StringBuilder();
		int length = String.valueOf(estanteriaRecibo).length();

		for (int i = length; i < 3; ++i) {
			estanteria.append("0");
		}

		estanteria.append(estanteriaRecibo);
		return "$M XR$E20$T@@shelf@@$F001$O01$H01$C04000$P1$Z0$M0$".replaceAll(
				"@@shelf@@", estanteria.toString());
	}

	public static String consultarPosicionArmario() {
		return "$M XR$E12$";
	}
}
