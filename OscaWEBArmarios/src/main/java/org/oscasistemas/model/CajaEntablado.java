package org.oscasistemas.model;

import com.dynamics.webServices.Item_Card_WS.ItemCardWS;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by José Ángel Caudevílla Casaús on 12/06/2017.
 */
@Entity
@Table(name = "cajas_entablado", catalog = "osca_localizacion")
@Embeddable
@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_DEFAULT)
@Proxy(lazy = false)
public class CajaEntablado implements Serializable{
    @Transient
    @JsonView(View.Summary.class)
    private ItemCardWS infoArticulo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="Id_caja")
    @JsonView(View.Summary.class)
    private TipoCaja tipoCaja;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    @JoinColumn(name="Codigo",referencedColumnName="Codigo" ,nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(View.Summary.class)
    private Entablado entablado;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="Id_lanzadera",referencedColumnName="Id_lanzadera")
    @JsonView(View.Summary.class)
    private Lanzadera Lanzadera;

    @Id
    @JsonView(View.Summary.class)
    private int fila;
    @Id
    @JsonView(View.Summary.class)
    private int columna;

    @JsonView(View.Summary.class)
    private double xPos;
    @JsonView(View.Summary.class)
    private double yPos;

    @JsonView(View.Summary.class)
    private String Articulo;



    @JsonView(View.Summary.class)
    private int Cantidad;



    @JsonView(View.Summary.class)
    private double Peso;

    @JsonView(View.Summary.class)
    private  byte esVacia;


    @JsonView(View.Summary.class)
    @Column(name = "fechaCreacion", columnDefinition="DATETIME")
    private Date fechaCreacion;
    @Column(name = "fechaActualizacion", columnDefinition="DATETIME")
    @JsonView(View.Summary.class)
    private Date fechaActualizacion;

    @Column(name = "ts", columnDefinition="TIMESTAMP")
    @JsonView(View.Summary.class)
    private Timestamp ts;

    public TipoCaja getTipoCaja() {
        return tipoCaja;
    }

    public void setTipoCaja(TipoCaja tipoCaja) {
        this.tipoCaja = tipoCaja;
    }

    public Entablado getEntablado() {
        return entablado;
    }

    public void setEntablado(Entablado entablado) {
        this.entablado = entablado;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public double getxPos() {
        return xPos;
    }

    public void setxPos(double xPos) {
        this.xPos = xPos;
    }

    public double getyPos() {
        return yPos;
    }

    public void setyPos(double yPos) {
        this.yPos = yPos;
    }

    public String getArticulo() {
        return Articulo;
    }

    public void setArticulo(String articulo) {
        Articulo = articulo;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public double getPeso() {
        return Peso;
    }

    public void setPeso(double peso) {
        Peso = peso;
    }

    public byte getEsVacia() {
        return esVacia;
    }

    public void setEsVacia(byte esVacia) {
        this.esVacia = esVacia;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Timestamp getTs() {
        return ts;
    }

    public void setTs(Timestamp ts) {
        this.ts = ts;
    }

    public ItemCardWS getInfoArticulo() {
        return infoArticulo;
    }

    public void setInfoArticulo(ItemCardWS infoArticulo) {
        this.infoArticulo = infoArticulo;
    }

    public org.oscasistemas.model.Lanzadera getLanzadera() {
        return Lanzadera;
    }

    public void setLanzadera(org.oscasistemas.model.Lanzadera lanzadera) {
        Lanzadera = lanzadera;
    }

    @Override
    public String toString() {
        return "CajaEntablado{" +
                "tipoCaja=" + tipoCaja +
                ", entablado=" + entablado +
                ", fila=" + fila +
                ", columna=" + columna +
                ", xPos=" + xPos +
                ", yPos=" + yPos +
                ", Articulo='" + Articulo + '\'' +
                ", Cantidad=" + Cantidad +
                ", Peso=" + Peso +
                ", esVacia=" + esVacia +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaActualizacion=" + fechaActualizacion +
                ", ts=" + ts +
                '}';
    }
}
