package org.osasistemas.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;

public class SerialConector {
	///dev/ttyUSB0 COM4
	public static final String PORT = "/dev/ttyUSB0";
	//public static final String PORT = "COM4";
	private static final int TIMEOUT_VALUE = 5000;
	private static final int MAX_ITERACIONES = 50;

	public boolean moverA(int estanteriaRecibo) {
		this.limpiarCompleto();
		Serial loopbackTest = new Serial();

		try {
			loopbackTest.connect(PORT);
			InputStream ex = loopbackTest.getSerialInputStream();
			Serial.SerialEventHandler serialEventHandler = new Serial.SerialEventHandler(
					ex, 300);
			loopbackTest.addDataAvailableEventHandler(serialEventHandler);
			OutputStream outStream = loopbackTest.getSerialOutputStream();
			byte[] orden = Comandos.crearOrden(Comandos
					.moverA(estanteriaRecibo));
			outStream.write(orden);
			System.out.println("[ "
					+ UtilTexto.calendarToString(Calendar.getInstance())
					+ " ] Host: " + new String(orden));
			this.esperarComandoAceptado(serialEventHandler);
			String respuestaAceptacion = serialEventHandler
					.getContenidoBuffer();
			System.out.println("[ "
					+ UtilTexto.calendarToString(Calendar.getInstance())
					+ " ] MP: = " + respuestaAceptacion);
			System.out.println("-" + respuestaAceptacion + "Ç");
			System.out.println("Esperando respuesta aceptacion --->> "
					+ Respuestas.ACEPTADO);
			if (Respuestas.ACEPTADO.equals(respuestaAceptacion)) {
				System.out.println("[ "
						+ UtilTexto.calendarToString(Calendar.getInstance())
						+ " ] Comando MOVER aceptado");
				boolean ejecutado = false;
				boolean carriedOut = false;
				boolean realizarPollingHost = true;

				do {
					String respuestaEstado = this.pollingHost(
							serialEventHandler, outStream);
					System.out
							.println("[ "
									+ UtilTexto.calendarToString(Calendar
											.getInstance()) + " ] MP: "
									+ respuestaEstado);
					if (Respuestas.MOVER_EJECUTADO.equals(respuestaEstado)) {
						ejecutado = true;
						realizarPollingHost = false;
						if (carriedOut) {
							System.out.println("[ "
									+ UtilTexto.calendarToString(Calendar
											.getInstance())
									+ " ] Comando MOVER ejecutado");
						} else {
							System.out
									.println("[ "
											+ UtilTexto
													.calendarToString(Calendar
															.getInstance())
											+ " ] Comando MOVER ejecutado, ya estaba en la estanteria");
						}
					} else if (Respuestas.MOVER_CARRIED_OUT
							.equals(respuestaEstado)) {
						carriedOut = true;
					} else if (respuestaEstado.contains("BARRERAS DE LUZ")) {
						System.out.println("[ "
								+ UtilTexto.calendarToString(Calendar
										.getInstance())
								+ " ] ERROR BARRERA DE LUZ");
					} else {
						ejecutado = false;
						realizarPollingHost = false;
						System.out
								.println("[ "
										+ UtilTexto.calendarToString(Calendar
												.getInstance())
										+ " ] Comando MOVER no ejecutado, esperaba CARRIED_OUT or EJECUTADO");
					}
				} while (realizarPollingHost);

				loopbackTest.disconnect();
				return ejecutado;
			} else {
				System.out.println("Respuesta no aceptada");
				return false;
			}
		} catch (Exception arg11) {
			arg11.printStackTrace();
			return false;
		}
	}

	public int consultarPosicionArmario() {
		this.limpiarCompleto();
		Serial loopbackTest = new Serial();

		try {
			loopbackTest.connect(PORT);
			InputStream ex = loopbackTest.getSerialInputStream();
			Serial.SerialEventHandler serialEventHandler = new Serial.SerialEventHandler(
					ex, 300);
			loopbackTest.addDataAvailableEventHandler(serialEventHandler);
			OutputStream outStream = loopbackTest.getSerialOutputStream();
			byte[] orden = Comandos.crearOrden(Comandos
					.consultarPosicionArmario());
			outStream.write(orden);
			System.out.println("[ "
					+ UtilTexto.calendarToString(Calendar.getInstance())
					+ " ] Host: " + new String(orden));
			String respuestaAceptado="";
//			for (int i = 0; i < 10 && respuestaAceptado.length()==0; i++) {
				this.esperarComandoAceptado(serialEventHandler);
				respuestaAceptado = serialEventHandler
						.getContenidoBuffer();
//				Thread.sleep(50);
//			}
			
			System.out.println("[ "
					+ UtilTexto.calendarToString(Calendar.getInstance())
					+ " ] MP: = " + respuestaAceptado);
			if (Respuestas.ACEPTADO.equals(respuestaAceptado)) {
				System.out.println("[ "
						+ UtilTexto.calendarToString(Calendar.getInstance())
						+ " ] Comando CONSULTAR aceptado");
				String respuestaEjecucion = this.pollingHost(
						serialEventHandler, outStream);
				System.out.println("[ "
						+ UtilTexto.calendarToString(Calendar.getInstance())
						+ " ] MP: " + respuestaEjecucion);
				boolean ejecutado = false;
				int ejecutado1;
				if (respuestaEjecucion
						.startsWith(Respuestas.CONSULTAR_EJECUTADO)) {
					String[] array = respuestaEjecucion.split("\\$");
					ejecutado1 = Integer.valueOf(array[4].replace("T", ""))
							.intValue();
					System.out
							.println("[ "
									+ UtilTexto.calendarToString(Calendar
											.getInstance())
									+ " ] Comando CONSULTAR ejecutado");
				} else {
					ejecutado1 = 0;
					System.out
							.println("[ "
									+ UtilTexto.calendarToString(Calendar
											.getInstance())
									+ " ] Comando CONSULTAR no ejecutado");
				}

				loopbackTest.disconnect();
				return ejecutado1;
			} else {
				System.out.println("[ "
						+ UtilTexto.calendarToString(Calendar.getInstance())
						+ " ] Comando CONSULTAR no aceptado: "
						+ respuestaAceptado);
				loopbackTest.disconnect();
				return 0;
			}
		} catch (Exception arg9) {
			loopbackTest.disconnect();
			arg9.printStackTrace();
			return -1;
		}
	}

	public boolean limpiar(int iteracionesRecibo) {
		Serial loopbackTest = new Serial();

		try {
			loopbackTest.connect(PORT);
			InputStream ex = loopbackTest.getSerialInputStream();
			Serial.SerialEventHandler serialEventHandler = new Serial.SerialEventHandler(
					ex, 300);
			loopbackTest.addDataAvailableEventHandler(serialEventHandler);
			OutputStream outStream = loopbackTest.getSerialOutputStream();
			System.out.println("[ "
					+ UtilTexto.calendarToString(Calendar.getInstance())
					+ " ] Comando LIMPIAR aceptado");
			long startTime = System.currentTimeMillis();
			int i = 0;

			do {
				outStream.write(Comandos.pollingHost());
				startTime = System.currentTimeMillis();

				long elapsedTime;
				do {
					try {
						Thread.sleep(100L);
					} catch (InterruptedException arg11) {
						;
					}

					elapsedTime = System.currentTimeMillis() - startTime;
				} while (elapsedTime < 5000L
						&& !serialEventHandler.isBufferFull()
						&& !this.respuestaCompleta(serialEventHandler));

				System.out.println("[ "
						+ UtilTexto.calendarToString(Calendar.getInstance())
						+ " ] BUFFER Armario: "
						+ serialEventHandler.getContenidoBuffer());
				++i;
			} while (i < iteracionesRecibo);

			boolean ejecutado = true;
			System.out.println("[ "
					+ UtilTexto.calendarToString(Calendar.getInstance())
					+ " ] Comando LIMPIAR ejecutado");
			loopbackTest.disconnect();
			return ejecutado;
		} catch (Exception arg12) {
			arg12.printStackTrace();
			return false;
		}
	}

	public boolean limpiarCompleto() {
		Serial loopbackTest = new Serial();

		try {
			loopbackTest.connect(PORT);
			InputStream ex = loopbackTest.getSerialInputStream();
			Serial.SerialEventHandler serialEventHandler = new Serial.SerialEventHandler(
					ex, 300);
			loopbackTest.addDataAvailableEventHandler(serialEventHandler);
			OutputStream outStream = loopbackTest.getSerialOutputStream();
			System.out.println("[ "
					+ UtilTexto.calendarToString(Calendar.getInstance())
					+ " ] Comando FULL_CLEAN aceptado");
			long startTime = System.currentTimeMillis();
			String buffer = null;
			int iteraciones = 0;

			do {
				outStream.write(Comandos.pollingHost());
				startTime = System.currentTimeMillis();

				long elapsedTime;
				do {
					try {
						Thread.sleep(100L);
					} catch (InterruptedException arg11) {
						;
					}

					elapsedTime = System.currentTimeMillis() - startTime;
				} while (elapsedTime < 5000L
						&& !serialEventHandler.isBufferFull()
						&& !this.respuestaCompleta(serialEventHandler));

				buffer = serialEventHandler.getContenidoBuffer();
				System.out.println("[ "
						+ UtilTexto.calendarToString(Calendar.getInstance())
						+ " ] BUFFER: " + buffer);
				++iteraciones;
			} while (iteraciones < 50 && !"*BE$\r\n".equals(buffer));

			boolean ejecutado = true;
			System.out.println("[ "
					+ UtilTexto.calendarToString(Calendar.getInstance())
					+ " ] Comando FULL_CLEAN ejecutado (" + iteraciones
					+ " it)");
			loopbackTest.disconnect();
			return ejecutado;
		} catch (Exception arg12) {
			arg12.printStackTrace();
			return false;
		}
	}

	private void esperarComandoAceptado(
			Serial.SerialEventHandler serialEventHandlerRecibo) {
		long startTime = System.currentTimeMillis();

		long elapsedTime;
		do {
			try {
				Thread.sleep(100L);
			} catch (InterruptedException arg6) {
				;
			}

			elapsedTime = System.currentTimeMillis() - startTime;
		} while (elapsedTime < 5000L
				&& !serialEventHandlerRecibo.isBufferFull()
				&& !this.respuestaCompleta(serialEventHandlerRecibo));

	}

	private boolean respuestaCompleta(
			Serial.SerialEventHandler serialEventHandlerRecibo) {
		
		return serialEventHandlerRecibo.getReadBuffer() != null ? serialEventHandlerRecibo
				.getReadBuffer().contains("\r\n") : false;
	}

	private String pollingHost(
			Serial.SerialEventHandler serialEventHandlerRecibo,
			OutputStream outStreamRecibo) throws IOException {
		long startTime = System.currentTimeMillis();
		String buffer = null;
		System.out.println("[ "
				+ UtilTexto.calendarToString(Calendar.getInstance())
				+ " ] Host: pollingHost()");

		do {
			outStreamRecibo.write(Comandos.pollingHost());
			startTime = System.currentTimeMillis();

			long elapsedTime;
			do {
				try {
					Thread.sleep(100L);
				} catch (InterruptedException arg8) {
					;
				}

				elapsedTime = System.currentTimeMillis() - startTime;
			} while (elapsedTime < 5000L
					&& !serialEventHandlerRecibo.isBufferFull()
					&& !this.respuestaCompleta(serialEventHandlerRecibo));

			buffer = serialEventHandlerRecibo.getContenidoBuffer();
		} while ("*BE$\r\n".equals(buffer));

		return buffer;
	}
}
