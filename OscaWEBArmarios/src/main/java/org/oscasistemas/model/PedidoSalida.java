package org.oscasistemas.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by José Ángel Caudevílla Casaús on 03/11/2017.
 */
@Entity
@Table(name = "pedidossalida" , catalog = "osca_localizacion")
@Embeddable
@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_DEFAULT)
@Proxy(lazy = false)
public class PedidoSalida implements Serializable {

    @Id
    @JsonView(View.Summary.class)
    private String Npedido;
    @Id
    @JsonView(View.Summary.class)
    private int Nlinea;
    @JsonView(View.Summary.class)
    @ManyToOne
    @JoinColumn(name =  "Id_Lanzadera")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Lanzadera lanzadera;
    @JsonView(View.Summary.class)
    @ManyToOne
    @JoinColumn(name =  "Entablado")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Entablado entablado;
    @JsonView(View.Summary.class)
    private boolean Marcado;
    @UpdateTimestamp
    @JsonView(View.Summary.class)
    private Timestamp ts;


    public String getNpedido() {
        return Npedido;
    }

    public void setNpedido(String npedido) {
        Npedido = npedido;
    }

    public int getNlinea() {
        return Nlinea;
    }

    public void setNlinea(int nlinea) {
        Nlinea = nlinea;
    }

    public boolean isMarcado() {
        return Marcado;
    }

    public void setMarcado(boolean marcado) {
        Marcado = marcado;
    }

    public Timestamp getTs() {
        return ts;
    }

    public void setTs(Timestamp ts) {
        this.ts = ts;
    }

    public Lanzadera getLanzadera() {
        return lanzadera;
    }

    public void setLanzadera(Lanzadera lanzadera) {
        this.lanzadera = lanzadera;
    }

    public Entablado getEntablado() {
        return entablado;
    }

    public void setEntablado(Entablado entablado) {
        this.entablado = entablado;
    }

    @Override
    public String toString() {
        return "PedidoEntrada{" +
                "Npedido='" + Npedido + '\'' +
                ", Nlinea='" + Nlinea + '\'' +
                ", lanzadera=" + lanzadera +
                ", entablado=" + entablado +
                ", Marcado=" + Marcado +
                ", ts=" + ts +
                '}';
    }
}
