package org.oscasistemas.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by José Ángel Caudevílla Casaús on 12/06/2017.
 */
@Entity
@Table(name = "acceso_lanzaderas" , catalog = "osca_localizacion")
@Embeddable
@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_DEFAULT)
@Proxy(lazy = false)
public class AcessoLanzadera implements Serializable{

    @Id
    @JsonView(View.Summary.class)
    private String ipOrdenador;

    @JsonView(View.Summary.class)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Id_lanzadera")
    private Lanzadera Lanzadera;

    @JsonView(View.Summary.class)
    private String descripcionOrdenador;

    @JsonView(View.Summary.class)
    private Timestamp ts;

    public String getIpOrdenador() {
        return ipOrdenador;
    }

    public void setIpOrdenador(String ipOrdenador) {
        this.ipOrdenador = ipOrdenador;
    }


    public org.oscasistemas.model.Lanzadera getLanzadera() {
        return Lanzadera;
    }

    public void setLanzadera(org.oscasistemas.model.Lanzadera lanzadera) {
        Lanzadera = lanzadera;
    }

    public String getDescripcionOrdenador() {
        return descripcionOrdenador;
    }

    public void setDescripcionOrdenador(String descripcionOrdenador) {
        this.descripcionOrdenador = descripcionOrdenador;
    }

    public Timestamp getTs() {
        return ts;
    }

    public void setTs(Timestamp ts) {
        this.ts = ts;
    }

    @Override
    public String toString() {
        return "AcessoLanzadera{" +
                "ipOrdenador='" + ipOrdenador + '\'' +
                ", Lanzadera=" + Lanzadera +
                ", descripcionOrdenador='" + descripcionOrdenador + '\'' +
                ", ts=" + ts +
                '}';
    }
}
