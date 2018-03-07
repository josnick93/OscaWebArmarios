package org.oscasistemas.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Proxy;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by josnick on 12/06/2017.
 */
@Entity
@Table(name="articulo", catalog = "osca_localizacion")
@Embeddable
@JsonInclude(JsonInclude.Include.ALWAYS)
@Proxy(lazy = false)
public class Articulo implements Serializable{

    @Id
    @JsonView(View.Summary.class)
    private String No;
    @JsonView(View.Summary.class)
    private String searchDescription;
    @JsonView(View.Summary.class)
    private String Descripcion;
    @JsonView(View.Summary.class)
    private String Descripcion2;
    @JsonView(View.Summary.class)
    private int safetyStockQuantity;
    @JsonView(View.Summary.class)
    private int netWeight;
    @JsonView(View.Summary.class)
    private double Quantity;

    public String getNo() {
        return No;
    }

    public void setNo(String no) {
        No = no;
    }

    public String getSearchDescription() {
        return searchDescription;
    }

    public void setSearchDescription(String searchDescription) {
        this.searchDescription = searchDescription;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getDescripcion2() {
        return Descripcion2;
    }

    public void setDescripcion2(String descripcion2) {
        Descripcion2 = descripcion2;
    }

    public int getSafetyStockQuantity() {
        return safetyStockQuantity;
    }

    public void setSafetyStockQuantity(int safetyStockQuantity) {
        this.safetyStockQuantity = safetyStockQuantity;
    }

    public double getQuantity() {
        return Quantity;
    }

    public void setQuantity(double quantity) {
        Quantity = quantity;
    }

    public int getNetWeight() {
        return netWeight;
    }

    public void setNetWeght(int netWeight) {
        this.netWeight = netWeight;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "No='" + No + '\'' +
                ", searchDescription='" + searchDescription + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                ", Descripcion2='" + Descripcion2 + '\'' +
                ", safetyStockQuantity=" + safetyStockQuantity +
                ", netWeight=" + netWeight +
                ", Quantity=" + Quantity +
                '}';
    }
}
