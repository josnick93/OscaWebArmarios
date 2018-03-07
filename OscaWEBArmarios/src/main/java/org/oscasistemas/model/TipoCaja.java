package org.oscasistemas.model;

import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by José Ángel Caudevílla Casaús on 12/06/2017.
 */
@Entity
@Table(name = "tipo_caja" , catalog = "osca_localizacion")
@Proxy(lazy = false)
public class TipoCaja implements Serializable{

    @Id
    private int Id_caja;
    private String tipo_caja;
    private String descripcion;
    private int num_huecos;
    private String ruta_img;
    private Timestamp ts;


    public int getId_caja() {
        return Id_caja;
    }

    public void setId_caja(int id_caja) {
        Id_caja = id_caja;
    }

    public String getTipo_caja() {
        return tipo_caja;
    }

    public void setTipo_caja(String tipo_caja) {
        this.tipo_caja = tipo_caja;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNum_huecos() {
        return num_huecos;
    }

    public void setNum_huecos(int num_huecos) {
        this.num_huecos = num_huecos;
    }

    public String getRuta_img() {
        return ruta_img;
    }

    public void setRuta_img(String ruta_img) {
        this.ruta_img = ruta_img;
    }

    public Timestamp getTs() {
        return ts;
    }

    public void setTs(Timestamp ts) {
        this.ts = ts;
    }

    @Override
    public String toString() {
        return "TipoCaja{" +
                "Id_caja=" + Id_caja +
                ", tipo_caja='" + tipo_caja + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", num_huecos=" + num_huecos +
                ", ruta_img='" + ruta_img + '\'' +
                ", ts=" + ts +
                '}';
    }
}
