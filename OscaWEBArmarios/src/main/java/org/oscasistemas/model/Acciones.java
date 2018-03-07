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

/**
 * Created by José Ángel Caudevílla Casaús on 01/08/2017.
 */
@Entity
@Table(name = "acciones" , catalog = "osca_localizacion")
@Embeddable
@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_DEFAULT)
@Proxy(lazy = false)
public class Acciones implements Serializable{

    @Id
    @JsonView(View.Summary.class)
    private int Id_accion;

    @JsonView(View.Summary.class)
    private String descripcion;


    public int getId_accion() {
        return Id_accion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setId_accion(int id_accion) {
        Id_accion = id_accion;
    }

    @Override
    public String toString() {
        return "Acciones{" +
                "Id_accion=" + Id_accion +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
