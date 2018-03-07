package org.oscasistemas.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.Proxy;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by José Ángel Caudevílla Casaús on 12/06/2017.
 */
@Entity
@Table(name = "lanzadera" , catalog = "osca_localizacion")
@Embeddable
@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_DEFAULT)
@Proxy(lazy = false)
public class Lanzadera implements Serializable{

    @Id
    @JsonView(View.Summary.class)
    private int Id_lanzadera;
    @JsonView(View.Summary.class)
    private String descripcion;
    @JsonView(View.Summary.class)
    private String direccion_ip;
    @JsonView(View.Summary.class)
    private String punto_acesso;
    @JsonView(View.Summary.class)
    private Timestamp ts;

    public int getId_lanzadera() {
        return Id_lanzadera;
    }

    public void setId_lanzadera(int id_lanzadera) {
        Id_lanzadera = id_lanzadera;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion_ip() {
        return direccion_ip;
    }

    public void setDireccion_ip(String direccion_ip) {
        this.direccion_ip = direccion_ip;
    }

    public String getPunto_acesso() {
        return punto_acesso;
    }

    public void setPunto_acesso(String punto_acesso) {
        this.punto_acesso = punto_acesso;
    }

    public Timestamp getTs() {
        return ts;
    }

    public void setTs(Timestamp ts) {
        this.ts = ts;
    }
}
