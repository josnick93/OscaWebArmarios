package org.oscasistemas.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by José Ángel Caudevilla Casaus on 13/02/2018.
 */
@Entity
@Table(name = "grupos_lanzaderas" , catalog = "osca_localizacion")
@Embeddable
@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_DEFAULT)
@Proxy(lazy = false)
public class GruposLanzaderas implements Serializable{

    @Id
    @JsonView(View.Summary.class)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name =  "id_lanzadera1")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Lanzadera Lanzadera1;

    @Id
    @JsonView(View.Summary.class)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name =  "id_lanzadera2")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Lanzadera Lanzadera2;

    @JsonView(View.Summary.class)
    private Timestamp ts;

    public Lanzadera getLanzadera1() {
        return Lanzadera1;
    }

    public void setLanzadera1(Lanzadera lanzadera1) {
        this.Lanzadera1 = lanzadera1;
    }

    public Lanzadera getLanzadera2() {
        return Lanzadera2;
    }

    public void setLanzadera2(Lanzadera lanzadera2) {
        this.Lanzadera2 = lanzadera2;
    }

    public Timestamp getTs() {
        return ts;
    }

    public void setTs(Timestamp ts) {
        this.ts = ts;
    }
}
