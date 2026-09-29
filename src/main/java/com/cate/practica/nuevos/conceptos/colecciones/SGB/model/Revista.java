package com.cate.practica.nuevos.conceptos.colecciones.SGB.model;

import com.cate.practica.nuevos.conceptos.colecciones.SGB.enums.Categoria;
import com.cate.practica.nuevos.conceptos.colecciones.SGB.enums.Disponinilidad;
import com.cate.practica.nuevos.conceptos.colecciones.SGB.enums.Idioma;
import com.cate.practica.nuevos.conceptos.colecciones.SGB.util.Validaciones;

import java.util.Date;

/**
 * Clase: Representar Revistas.
 *
 * @author Cate
 */

public class Revista extends Material {
    private String editorial;
    private int numeroDeEdicion;
    private Date fechaDePublicacion;

    public Revista(String titulo, Idioma idioma, Disponinilidad disponible, Categoria categoria, String editorial, int numeroDeEdicion, Date fechaDePublicacion) {
        super(titulo, idioma, disponible, categoria);
        this.editorial = editorial;
        this.numeroDeEdicion = numeroDeEdicion;
        this.fechaDePublicacion = fechaDePublicacion;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        Validaciones.validarNullVacio(editorial, "Editorial");
        this.editorial = editorial;
    }

    public Date getFechaDePublicacion() {
        return fechaDePublicacion;
    }

    public void setFechaDePublicacion(Date fechaDePublicacion) {
        Validaciones.validarFechaObjeto(fechaDePublicacion);
        this.fechaDePublicacion = fechaDePublicacion;
    }

    public int getNumeroDeEdicion() {
        return numeroDeEdicion;
    }

    public void setNumeroDeEdicion(int numeroDeEdicion) {
        Validaciones.validarNumeroNagativo(numeroDeEdicion, "Numero de edición");
        this.numeroDeEdicion = numeroDeEdicion;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(super.toString()).append("Revista { ")
                .append("editorial='").append(editorial).append('\'')
                .append(", numeroDeEdicion=").append(numeroDeEdicion)
                .append(", fechaDePublicacion=").append(fechaDePublicacion)
                .append('}').toString();
    }
}
