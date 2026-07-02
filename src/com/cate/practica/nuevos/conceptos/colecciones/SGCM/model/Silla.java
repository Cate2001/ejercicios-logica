package com.cate.practica.nuevos.conceptos.colecciones.SGCM.model;

import com.cate.practica.nuevos.conceptos.colecciones.SGCM.enums.Categoria;
import com.cate.practica.nuevos.conceptos.colecciones.SGCM.util.GeneradorId;
import com.cate.practica.nuevos.conceptos.colecciones.SGCM.util.ValidacionesAtributos;

class Silla {
    private final int id;
    private String fila;
    private int columna;
    private Categoria categoria;
    private boolean disponible;

    public Silla(String fila, int columna, Categoria categoria) {
        this.id = GeneradorId.generarIdSilla();
        ValidacionesAtributos.validarNullVacio(fila, "Fila");
        ValidacionesAtributos.validarNumeroNagativo(columna, "Columna");
        ValidacionesAtributos.validarObjetosnNulo(categoria, "Categoria");
        this.fila = fila;
        this.columna = columna;
        this.categoria = categoria;
        this.disponible = true;
    }

    public int getId() {
        return id;
    }

    public String getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public boolean isDisponible() {
        return disponible;
    }

    void desocuparSilla() {
        if (disponible) throw new IllegalArgumentException("La silla ya esta desocupada");
        this.disponible = true;
    }

    void ocuparSilla() {
        if (!disponible) throw new IllegalArgumentException("La silla ya esta ocupada");
        this.disponible = false;
    }
}
