package org.oscasistemas.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Proxy;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by José Ángel Caudevílla Casaús on 31/07/2017.
 */
@Entity
@Table(name="administradores", catalog = "osca_localizacion")
@Embeddable
@JsonInclude(JsonInclude.Include.ALWAYS)
@Proxy(lazy = false)
public class Administrador implements Serializable{


    @Id
    @JsonView(View.Summary.class)
    private int idAdmin;

    @JsonView(View.Summary.class)
    private String Nombre;

    @JsonView(View.Summary.class)
    private String direccionIp;


    public int getIdAdmmin() {
        return idAdmin;
    }

    public void setIdAdmmin(int idAdmmin) {
        this.idAdmin = idAdmmin;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDireccionIp() {
        return direccionIp;
    }

    public void setDireccionIp(String direccionIp) {
        this.direccionIp = direccionIp;
    }


    @Override
    public String toString() {
        return "Administrador{" +
                "idAdmmin=" + idAdmin +
                ", Nombre='" + Nombre + '\'' +
                ", direccionIp='" + direccionIp + '\'' +
                '}';
    }
}
