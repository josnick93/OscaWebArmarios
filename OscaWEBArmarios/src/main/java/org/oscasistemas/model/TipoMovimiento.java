package org.oscasistemas.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.Proxy;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by José Ángel Caudevílla Casaús on 11/07/2017.
 */
@Entity
@Table(name = "tipo_movimiento" , catalog = "osca_localizacion")
@Embeddable
@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_DEFAULT)
@Proxy(lazy = false)
public class TipoMovimiento {

    @Id
    private int Id_tipoMovimiento;


    private String descripcion;


    public int getId_tipoMovimiento() {
        return Id_tipoMovimiento;
    }

    public void setId_tipoMovimiento(int id_tipoMovimiento) {
        Id_tipoMovimiento = id_tipoMovimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    @Override
    public String toString() {
        return "TipoMovimiento{" +
                "Id_tipoMovimiento=" + Id_tipoMovimiento +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
