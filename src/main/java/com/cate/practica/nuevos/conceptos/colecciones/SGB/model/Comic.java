package com.cate.practica.nuevos.conceptos.colecciones.SGB.model;

import com.cate.practica.nuevos.conceptos.colecciones.SGB.enums.Categoria;
import com.cate.practica.nuevos.conceptos.colecciones.SGB.enums.Disponinilidad;
import com.cate.practica.nuevos.conceptos.colecciones.SGB.enums.Idioma;
import com.cate.practica.nuevos.conceptos.colecciones.SGB.util.Validaciones;

/**
 * Clase: Representar cómics.
 *
 * @author Cate
 */
public class Comic extends Material {
    private String dibujante;
    private String saga;

    public Comic(String titulo, Idioma idioma, Disponinilidad disponible, Categoria categoria, String dibujante, String saga) {
        super(titulo, idioma, disponible, categoria);
        setDibujante(dibujante);
        setSaga(saga);
    }

    public String getDibujante() {
        return dibujante;
    }

    public void setDibujante(String dibujante) {
        Validaciones.validarNullVacio(dibujante, "Dibujante");
        this.dibujante = dibujante;
    }

    public String getSaga() {
        return saga;
    }

    public void setSaga(String saga) {
        Validaciones.validarNullVacio(saga, "Saga");
        this.saga = saga;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(super.toString()).append("Comic{")
                .append("dibujante='").append(dibujante).append('\'')
                .append(", saga='").append(saga).append('\'')
                .append('}').toString();
    }
}
