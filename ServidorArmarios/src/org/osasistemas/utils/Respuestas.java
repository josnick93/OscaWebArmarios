package org.osasistemas.utils;

public class Respuestas {
	public static final String ACEPTADO;
	public static final String NO_ACEPTADO;
	public static final String BUFFER_EMPTY = "*BE$\r\n";
	public static final String MOVER_CARRIED_OUT;
	public static final String MOVER_EJECUTADO;
	public static final String ERROR_BARRERA_LUZ = "BARRERAS DE LUZ";
	public static final String CONSULTAR_EJECUTADO;
	public static final String CONSULTAR_CAMPO_ESTANTERIA = "T";

	static {
		ACEPTADO = "*" + Comandos.PUNTO_ACCESO + "$P XS$E00$" + "\r\n";
		NO_ACEPTADO = "*" + Comandos.PUNTO_ACCESO + "$P XS$E02$" + "\r\n";
		MOVER_CARRIED_OUT = "*" + Comandos.PUNTO_ACCESO
				+ "$P XA$A20$E96$S01000$" + "\r\n";
		MOVER_EJECUTADO = "*" + Comandos.PUNTO_ACCESO + "$P XA$A20$E00$"
				+ "\r\n";
		CONSULTAR_EJECUTADO = "*" + Comandos.PUNTO_ACCESO + "$P XA$A12$E00$";
	}

}
