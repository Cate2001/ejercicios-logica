package com.cate.practica.nuevos.conceptos.colecciones.SGB.model;

import com.cate.practica.nuevos.conceptos.colecciones.SGB.enums.*;
import com.cate.practica.nuevos.conceptos.colecciones.SGB.util.GeneradorId;
import com.cate.practica.nuevos.conceptos.colecciones.SGB.util.Validaciones;

/**
 * Clase abastracta: Representar cualquier elemento que pueda existir dentro de la biblioteca para prestar al usaurio.
 * @author Cate
 */
public abstract class Material {
    private final int id;
    private String titulo;
    private Idioma idioma;
    private Disponinilidad disponible;
    private Categoria categoria;

    public Material(String titulo, Idioma idioma, Disponinilidad disponible, Categoria categoria) {
        this.id = GeneradorId.generarIdMaterial();
        setTitulo(titulo);
        this.idioma = idioma;
        this.disponible = disponible;
        this.categoria = categoria;
    }


    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        Validaciones.validarNullVacio(titulo, "Material");
        this.titulo = titulo;
    }

    public Disponinilidad getDisponible() {
        return disponible;
    }

    public void setDisponible(Disponinilidad disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Material{");
        sb.append("id=").append(id);
        sb.append(", titulo='").append(titulo).append('\'');
        sb.append(", disponible=").append(disponible);
        sb.append(", categoria=").append(categoria);
        sb.append('}');
        return sb.toString();
    }
}
