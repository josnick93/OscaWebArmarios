package org.oscasistemas;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.osasistemas.utils.Comandos;
import org.osasistemas.utils.SerialConector;
import org.oscasistemas.monitor.ControlEstado;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

/**
 * Servlet implementation class JSONServlet
 */
@WebServlet("/JSONServlet")
public class JSONServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final ControlEstado monitor = new ControlEstado();
	private static boolean init=false;
	


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.err.println("inicccio");
		doPost(request, response);
	}

	/***************************************************
	 * URL: /jsonservlet doPost(): receives JSON data, parse it, map it and send
	 * back as JSON
	 ****************************************************/
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		if(!init){
			monitor.init(getServletContext());
			init=true;
		}
		
		String orden = request.getParameter("orden");
		//String lanzadera = request.getParameter("lanzadera");
		String entablado = request.getParameter("entablado");
		String codigoAcesso = request.getParameter("codigoAcesso");
		
		//String orden = "MOVER";
		//String lanzadera = request.getParameter("lanzadera");
		//String entablado = "3";
		//String codigoAcesso = "071";
		// realizar accion
		SerialConector serialConector = null;
		JSONObject json = null;
		String val = "";
		System.out.println(orden.toUpperCase());
		switch (orden.toUpperCase()) {
		case "MOVER":
			
			// realizar accion
			serialConector = new SerialConector();
			json = new JSONObject();
			val = "";
			//obtener ip de la peticion
			String remoteAddr = "";
		    remoteAddr = request.getHeader("X-FORWARDED-FOR");
		    if (remoteAddr == null || "".equals(remoteAddr)) {
		       remoteAddr = request.getRemoteAddr();
		    }
		    System.out.println("	Ip recibida :"+remoteAddr);
			//comprobar si la lanzadera esta libre
			if(monitor.tengoAcceso(remoteAddr) || Integer.valueOf(entablado)==0 ){
				//marco lanzadera como ocupada
				monitor.ocuparLanzadera();
				if (monitor.traerEntablado(Integer.valueOf(entablado),
						codigoAcesso)) {
					Comandos.PUNTO_ACCESO = "GXXY".replace("XXY", codigoAcesso);
					serialConector.moverA(Integer.valueOf(entablado));
					val = "OK";
					break;
					
				} else {
					val = "TRAIDO";
				}
			//lanzadera ocupada y no acesible
			}else{
				val="DENEGADO";
			}
			break;
		case "CONSULTAR":
			serialConector = new SerialConector();
			json = new JSONObject();
			val = "";
			Comandos.PUNTO_ACCESO = "GXXY".replace("XXY", codigoAcesso);
			int resultado = serialConector.consultarPosicionArmario();
			monitor.actualizarEntablado(resultado);
			val = String.valueOf(resultado);
			break;

		case "LIMPIAR":
			serialConector = new SerialConector();
			json = new JSONObject();
			val = "";
			int iteraciones = Integer.valueOf(entablado).intValue();
			Comandos.PUNTO_ACCESO = "GXXY".replace("XXY", codigoAcesso);
			serialConector.limpiar(iteraciones);
			break;

		case "FULL_CLEAN":
			serialConector = new SerialConector();
			json = new JSONObject();
			val = "";
			Comandos.PUNTO_ACCESO = "GXXY".replace("XXY", codigoAcesso);
			serialConector.limpiarCompleto();
			break;
		case "APAGAR":
			json = new JSONObject();
			val = "";
			System.out.println("Comando apagar recibido");
			apagar();
			json.put("RESULT ", val);
			break;
		// solicitar acesso lanzadera
		case "ACCEDER":
			json = new JSONObject();
			val = "";
			//obtener ip de la peticion
			remoteAddr = "";
		    remoteAddr = request.getHeader("X-FORWARDED-FOR");
		    if (remoteAddr == null || "".equals(remoteAddr)) {
		       remoteAddr = request.getRemoteAddr();
		    }
			if(monitor.tengoAcceso(remoteAddr))	val = "OK";
			else 	val = "OCUPADO";
			json.put("RESULT ", val);
			break;
		case "LIBERAR":
			json = new JSONObject();
			System.out.println("Comando liberar lanzadera");
			// libera la lanzadera
			remoteAddr = "";
		    remoteAddr = request.getHeader("X-FORWARDED-FOR");
		    if (remoteAddr == null || "".equals(remoteAddr)) {
		       remoteAddr = request.getRemoteAddr();
		    }
			monitor.liberarLanzadera(remoteAddr);
			val = "OK";
			json.put("RESULT ", val);
			break;
		}
		// put some value pairs into the JSON object .
		json.put("RESULT ", val);
		// response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		response.getWriter().write(json.toString());
	}

	public void apagar() throws RuntimeException, IOException {
		String shutdownCommand;
		String operatingSystem = System.getProperty("os.name");
		System.out.println(operatingSystem);
		if ("Linux".contains(operatingSystem)
				|| "Mac OS X".equals(operatingSystem)) {
			shutdownCommand = "shutdown -h now";
		} else if ("Windows 10".equals(operatingSystem)) {
			shutdownCommand = "shutdown.exe -s -t 0";
		} else {
			throw new RuntimeException("Unsupported operating system.");
		}

		Runtime.getRuntime().exec(shutdownCommand);
		System.out.println("---------------");
		System.exit(0);
	}
	
	
	
	public static void abrirVentanaRemota(String host,String command1){
	    String user="oscasistemas";
	    String password="osca";
	    try{
	    	
	    	java.util.Properties config = new java.util.Properties(); 
	    	config.put("StrictHostKeyChecking", "no");
	    	JSch jsch = new JSch();
	    	Session session=jsch.getSession(user, host, 22);
	    	session.setPassword(password);
	    	session.setConfig(config);
	    	session.connect();
	    	System.out.println("Connected");
	    	
	    	Channel channel=session.openChannel("exec");
	        ((ChannelExec)channel).setCommand(command1);
	        channel.setInputStream(null);
	        ((ChannelExec)channel).setErrStream(System.err);
	        
	        InputStream in=channel.getInputStream();
	        channel.connect();
	        byte[] tmp=new byte[1024];
	        while(true){
	          while(in.available()>0){
	            int i=in.read(tmp, 0, 1024);
	            if(i<0)break;
	            System.out.print(new String(tmp, 0, i));
	          }
	          if(channel.isClosed()){
	            System.out.println("exit-status: "+channel.getExitStatus());
	            break;
	          }
	          try{Thread.sleep(1000);}catch(Exception ee){}
	        }
	        channel.disconnect();
	        session.disconnect();
	        System.out.println("DONE");
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
}

}
