package org.oscasistemas.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by José Ángel Caudevílla Casaús on 12/06/2017.
 */
@Entity
@Table(name = "entablado" , catalog = "osca_localizacion")
@Embeddable
@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_DEFAULT)
@Proxy(lazy = false)
public class Entablado implements Serializable{


    @Id
    @JsonView(View.Summary.class)
    @Column(name = "Codigo")
    private String codigo;

    @JsonView(View.Summary.class)
    @ManyToOne
    @JoinColumn(name =  "Id_lanzadera")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Lanzadera Lanzadera;


    @JsonView(View.Summary.class)
    private double PesoMaximo;


    @JsonView(View.Summary.class)
    private double PesoActual;


    @JsonView(View.Summary.class)
    private int HuecosLibres;


    @JsonView(View.Summary.class)
    private Timestamp ts;


    @JsonView(View.Summary.class)
    @Formula("PesoMaximo - PesoActual")
    private double PesoRestante;

    @JsonBackReference
    public Lanzadera getLanzadera() {
        return Lanzadera;
    }

    public void setLanzadera(Lanzadera lanzadera) {
        this.Lanzadera = lanzadera;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPesoMaximo() {
        return PesoMaximo;
    }

    public void setPesoMaximo(double pesoMaximo) {
        PesoMaximo = pesoMaximo;
    }

    public double getPesoActual() {
        return PesoActual;
    }

    public void setPesoActual(double pesoActual) {
        PesoActual = pesoActual;
    }

    public int getHuecosLibres() {
        return HuecosLibres;
    }

    public void setHuecosLibres(int huecosLibres) {
        HuecosLibres = huecosLibres;
    }

    public Timestamp getTs() {
        return ts;
    }

    public void setTs(Timestamp ts) {
        this.ts = ts;
    }

    public double getPesoRestante() {
        return PesoRestante;
    }

    public void setPesoRestante(double pesoRestante) {
        this.PesoRestante = pesoRestante;
    }

    @Override
    public String toString() {
        return "Entablado{" +
                "codigo='" + codigo + '\'' +
                ", Lanzadera=" + Lanzadera +
                ", PesoMaximo=" + PesoMaximo +
                ", PesoActual=" + PesoActual +
                ", HuecosLibres=" + HuecosLibres +
                ", ts=" + ts +
                ", PesoRestante=" + PesoRestante +
                '}';
    }
}
