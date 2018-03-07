package org.osasistemas.utils;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.TooManyListenersException;

public class Serial {
	
	private SerialPort serialPort;
	private OutputStream outStream;
	private InputStream inStream;

	public void connect(String portName) throws IOException {
		try {
			CommPortIdentifier e = CommPortIdentifier
					.getPortIdentifier(portName);
			this.serialPort = (SerialPort) e.open("Rotomat", 5000);
			this.setSerialPortParameters();
			this.outStream = this.serialPort.getOutputStream();
			this.inStream = this.serialPort.getInputStream();
		} catch (NoSuchPortException arg2) {
			throw new IOException(arg2.getMessage());
		} catch (PortInUseException arg3) {
			throw new IOException(arg3.getMessage());
		} catch (IOException arg4) {
			this.serialPort.close();
			throw arg4;
		}
	}

	public InputStream getSerialInputStream() {
		return this.inStream;
	}

	public OutputStream getSerialOutputStream() {
		return this.outStream;
	}

	public void addDataAvailableEventHandler(
			SerialPortEventListener eventHandler) {
		try {
			this.serialPort.addEventListener(eventHandler);
			this.serialPort.notifyOnDataAvailable(true);
		} catch (TooManyListenersException arg2) {
			System.err.println(arg2.getMessage());
		}

	}

	public void disconnect() {
		if (this.serialPort != null) {
			try {
				this.outStream.close();
				this.inStream.close();
			} catch (IOException arg1) {
				;
			}

			this.serialPort.close();
		}

	}

	private void setSerialPortParameters() throws IOException {
		short baudRate = 9600;

		try {
			this.serialPort.setSerialPortParams(baudRate, 8, 1, 0);
			this.serialPort.setFlowControlMode(0);
		} catch (UnsupportedCommOperationException arg2) {
			throw new IOException("Unsupported serial port parameter");
		}
	}

	public static class SerialEventHandler implements SerialPortEventListener {
		private InputStream inStream;
		private int readBufferLen;
		private int readBufferOffset;
		private byte[] readBuffer;

		public SerialEventHandler(InputStream inStream, int readBufferLen) {
			this.inStream = inStream;
			this.readBufferLen = readBufferLen;
			this.readBuffer = new byte[readBufferLen];
		}

		public boolean isBufferFull() {
			return this.readBufferOffset == this.readBufferLen;
		}

		public String getReadBuffer() {
			return new String(this.readBuffer);
		}

		public String getContenidoBuffer() {
			String contenido = (new String(this.readBuffer)).substring(0,
					this.readBufferOffset);
			this.cleanBuffer();
			return contenido;
		}

		private void cleanBuffer() {
			this.readBufferOffset = 0;
			this.readBuffer = new byte[this.readBufferLen];
		}

		public void serialEvent(SerialPortEvent event) {
			switch (event.getEventType()) {
			case 1:
				this.readSerial();
				break;
			case 2:
				System.out.println("EMPTY");
				break;
			case 3:
				System.out.println("CTS");
				break;
			case 4:
				System.out.println("DSR");
				break;
			case 5:
				System.out.println("RI");
				break;
			case 6:
				System.out.println("CD");
				break;
			case 7:
				System.out.println("OE");
				break;
			case 8:
				System.out.println("PE");
				break;
			case 9:
				System.out.println("FE");
				break;
			case 10:
				System.out.println("BI");
			}

		}

		private void readSerial() {
			try {
				int e = this.inStream.available();
				if (e > 0 && !this.isBufferFull()) {
					this.readBufferOffset += this.inStream.read(
							this.readBuffer, this.readBufferOffset, 1);
				}
			} catch (IOException arg1) {
				arg1.printStackTrace();
			}

		}
	}

}
