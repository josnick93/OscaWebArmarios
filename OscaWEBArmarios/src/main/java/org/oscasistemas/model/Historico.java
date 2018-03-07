package org.oscasistemas.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by José Ángel Caudevílla Casaús on 11/07/2017.
 */
@Entity
@Table(name = "historico" , catalog = "osca_localizacion")
@Embeddable
@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_DEFAULT)
@Proxy(lazy = false)
public class Historico implements Serializable{

    @Id
    @SequenceGenerator(sequenceName="SQ_historico",name="seqHistorico")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqHistorico")
    private int Id_historico;

    @JsonView(View.Summary.class)
    @ManyToOne
    @JoinColumn(name =  "Id_lanzadera")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Lanzadera Lanzadera;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,optional=false)
    @JoinColumns({@JoinColumn(name="Id_lanzadera",referencedColumnName="Id_lanzadera", updatable=false),
            @JoinColumn(name = "codigo",referencedColumnName = "codigo", updatable=false)})
    @JsonView(View.Summary.class)
    private Entablado entablado;


    @JsonView(View.Summary.class)
    @ManyToOne
    @JoinColumn(name =  "Id_tipoMovimiento")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private TipoMovimiento tipoMovimiento;


    @JsonView(View.Summary.class)
    private String usuario;


    @JsonView(View.Summary.class)
    private int fila;

    @JsonView(View.Summary.class)
    private int columna;

    @JsonView(View.Summary.class)
    private String Articulo;

    @JsonView(View.Summary.class)
    private double Cantidad;

    @JsonView(View.Summary.class)
    private Timestamp fecha;


    public int getId_historico() {
        return Id_historico;
    }

    public void setId_historico(int id_historico) {
        Id_historico = id_historico;
    }

    public Lanzadera getLanzadera() {
        return Lanzadera;
    }

    public void setLanzadera(Lanzadera lanzadera) {
        this.Lanzadera = lanzadera;
    }

    public Entablado getEntablado() {
        return entablado;
    }

    public void setEntablado(Entablado entablado) {
        this.entablado = entablado;
    }

    public TipoMovimiento getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public String getArticulo() {
        return Articulo;
    }

    public void setArticulo(String articulo) {
        Articulo = articulo;
    }

    public double getCantidad() {
        return Cantidad;
    }

    public void setCantidad(double cantidad) {
        Cantidad = cantidad;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }


    @Override
    public String toString() {
        return "Historico{" +
                "Id_historico=" + Id_historico +
                ", lanzadera=" + Lanzadera +
                ", entablado=" + entablado +
                ", tipoMovimiento=" + tipoMovimiento +
                ", usuario='" + usuario + '\'' +
                ", fila=" + fila +
                ", columna=" + columna +
                ", articulo=" + Articulo +
                ", Cantidad=" + Cantidad +
                ", fecha=" + fecha +
                '}';
    }
}
