package org.oscasistemas.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by José Ángel Caudevílla Casaús on 01/08/2017.
 */
@Entity
@Table(name = "tareaspendientes" , catalog = "osca_localizacion")
@Embeddable
@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_DEFAULT)
@Proxy(lazy = false)
public class TareasPendientes implements Serializable{


    @Id
    @JsonView(View.Summary.class)
    private int idTareaPendiente;

    @JsonView(View.Summary.class)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Id_lanzadera")
    private Lanzadera lanzadera;

    @JsonView(View.Summary.class)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Id_accion")
    private Acciones Accion;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name =  "articulo" )
    @JsonView(View.Summary.class)
    private Articulo Articulo;


    @JsonView(View.Summary.class)
    public String descripcion;

    @JsonView(View.Summary.class)
    public double Cantidad;

    @JsonView(View.Summary.class)
    private Timestamp fecha_creacion;

    @JsonView(View.Summary.class)
    private String URL;


    public int getIdTareaPendiente() {
        return idTareaPendiente;
    }

    public void setIdTareaPendiente(int idTareaPendiente) {
        this.idTareaPendiente = idTareaPendiente;
    }

    public Lanzadera getLanzadera() {
        return lanzadera;
    }

    public void setLanzadera(Lanzadera lanzadera) {
        this.lanzadera = lanzadera;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Acciones getAccion() {
        return Accion;
    }

    public org.oscasistemas.model.Articulo getArticulo() {
        return Articulo;
    }

    public void setArticulo(org.oscasistemas.model.Articulo articulo) {
        Articulo = articulo;
    }

    public double getCantidad() {
        return Cantidad;
    }

    public void setCantidad(double cantidad) {
        Cantidad = cantidad;
    }

    public void setAccion(Acciones accion) {
        Accion = accion;
    }

    public Timestamp getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Timestamp fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public String toString() {
        return "TareasPendientes{" +
                "idTareaPendiente=" + idTareaPendiente +
                ", lanzadera=" + lanzadera +
                ", Accion=" + Accion +
                ", Articulo=" + Articulo +
                ", descripcion='" + descripcion + '\'' +
                ", Cantidad=" + Cantidad +
                ", fecha_creacion=" + fecha_creacion +
                ", URL='" + URL + '\'' +
                '}';
    }
}
