package org.oscasistemas.monitor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletContext;

public class ControlEstado {
	
	//-1 entablado libre
	private int entabladoTraido;
	private String ipLanzadera;
	private boolean lanzaderaLibre; //consulta desde peticiones exteriores
	
	
	public synchronized void init(ServletContext app){
	
		//try {
		
			//leer el archivo con la ip
			byte[] encoded =null;
			try {
				encoded = Files.readAllBytes(Paths.get
						(app.getRealPath("/resources/ip.txt")));
				ipLanzadera=new String(encoded, Charset.defaultCharset());
				System.out.println("*****"+ipLanzadera);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("***************************");
				e.printStackTrace();
			}
			entabladoTraido=-1;
			lanzaderaLibre=true;
	}
	
	/**
	 * Devuelve true si la lanzadera esta libre o si
	 * soy el poseedor de la lanzadera
	 * @param ip
	 * @return
	 */
	public synchronized boolean tengoAcceso(String ip){
		//if(lanzaderaLibre)  ipLanzadera=ip;
		System.out.println("--->Estado de la lanzadera: "+lanzaderaLibre);
		return lanzaderaLibre || ip.equals(ipLanzadera);
	}
	
	public synchronized void ocuparLanzadera(){
		System.out.println("--->Ocupar Lanzadera");
		lanzaderaLibre=false;
	}
	
	public synchronized void liberarLanzadera(String ip){
		lanzaderaLibre=true;
		System.out.println("--->Estado de la lanzadera: "+lanzaderaLibre);
	}
	
	public synchronized boolean traerEntablado(int entablado,String codigoAcesso){
		if(entabladoTraido==-1){
			//traerlo
			System.out.println("Traer entablado");
			entabladoTraido=entablado;
			return true;
		}
		else if(entabladoTraido==entablado){
			//mensaje ya esta traido
			System.out.println("Ya estas en el entablado.");
			return false;
		}
		else{
			//mover entablado
			System.out.println("Moviendo a otro entablado.");
			entabladoTraido=entablado;
			return true;
		}
	}
	
	public int getEntablado(){
		return entabladoTraido;
	}
	
	public synchronized void actualizarEntablado(int i){
		if(i!=-1)
			entabladoTraido=i;
	}
	
	public synchronized boolean subirEntablado(String ip){
		//comprobar si la ip corresponde al de la lanzanzadera
		if(ipLanzadera.equals(ip)){
			System.out.println("La ip corresponde con la lanzadera");
			return true;
		}else{
			System.out.println("La ip no corresponde con la lanzadera");
			return false;
		}
	}
	
	
	

}
