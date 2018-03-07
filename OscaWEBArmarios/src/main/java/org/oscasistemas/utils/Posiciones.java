package org.oscasistemas.utils;

import java.io.Serializable;

/**
 * Created by José Ángel Caudevílla Casaús on 05/07/2017.
 * Vector class, represent a position into shelf
 */
public class Posiciones implements Serializable {

    private int fila,columna;

    public Posiciones(int fila,int columna){
        this.fila=fila;
        this.columna=columna;
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

    @Override
    public String toString() {
        return "Posiciones{" +
                "fila=" + fila +
                ", columna=" + columna +
                '}';
    }
}
