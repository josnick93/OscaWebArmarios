package org.oscasistemas.webServices.productos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Spring cliente WS del servicio de consulta de productos
 * @author José Ángel Caudevilla Casaus
 */
public class ProductosCliente {
    private final String	   URI = "http://192.168.2.6:7047/DynamicsNAV100CU08_OSCASIST/WS/Oscapruebas/Page/Item_Card";
    @Autowired
    private WebServiceTemplate webServiceTemplate;

    /**
     * Será inyectada por Spring
     */
    public void setWebServiceTemplate(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    /**
     * @return Devuelve la lista de libros que cumplen los criterios especificados
     */
    public java.util.List<Producto> getProductos() {
    String		 xmlRequest = this.getPeticion();
    StreamSource peticion   = new StreamSource(new StringReader(xmlRequest));
    DOMResult respuesta	= new DOMResult();
    List<Producto> libros = null;

    boolean hayRespuesta = webServiceTemplate.sendSourceAndReceiveToResult(URI, peticion, respuesta);
    if (hayRespuesta){
    libros = this.resultadoProductos((Document) respuesta.getNode());
    }
    return libros;
    }


    /**
     * @return Genera la petición (payload) que se enviará al servicio Web
     */
    private String getPeticion(String categoria, String nivel){
        StringBuffer buffer = new StringBuffer(1024);
        buffer.append("<Item_Card xmlns='http://www.w3.org/2001/XMLSchema'>");
        buffer.append("</Item_Card>");
        return buffer.toString();
    }

    /**
     * @return Genera la petición (payload) que se enviará al servicio Web
     */
    private String getPeticion(){
        StringBuffer buffer = new StringBuffer(1024);
        buffer.append("<Item_Card xmlns='http://www.w3.org/2001/XMLSchema'>");
        buffer.append("</Item_Card>");
        return buffer.toString();
    }


    /**
     * @return Devuelve una lista de Productos a partir del DOM
     */
    private List<Producto> resultadoProductos(Document doc){
        NodeList nodos 	 = doc.getFirstChild().getChildNodes();
        Node current = null;
        Producto	 producto	 = null;
        ArrayList<Producto> productos = new ArrayList<Producto>();
        for (int i = 0, num = nodos.getLength(); i < num; i++){
            current = nodos.item(i);
            producto	= new Producto();

            producto.setKey(this.getProperty(current, "key"));
            producto.setNo(this.getProperty(current, "No"));
            producto.setDescription(this.getProperty(current, "Description"));
            producto.setNo(this.getProperty(current, "Inventory"));
            producto.setSearch_Description(this.getProperty(current, "Search_Description"));
            productos.add(producto);
        }
        return productos;
    }


    /**
     *
     * @param nodo Nodo padre en el cual se busca la propiedad
     * @param tag Nombre del elemento buscado
     * @return Devuelve el valor de un elemento <padre><tag1>xxx<tag1><tagN>xxx<tagN></padre>
     */
    private String getProperty(Node nodo, String tag){
        NodeList props  = nodo.getChildNodes();
        Node	 prop   = null;
        String	 value	= null;

        for (int j = 0, num = props.getLength(); j < num; j++){
            prop = props.item(j);
            if (tag.equals(prop.getNodeName())){
                value = prop.getFirstChild().getNodeValue();
                break;
            }
        }
        return value;
    }

}
