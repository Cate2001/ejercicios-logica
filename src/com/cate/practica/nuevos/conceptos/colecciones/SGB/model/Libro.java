package com.cate.practica.nuevos.conceptos.colecciones.SGB.model;

import com.cate.practica.nuevos.conceptos.colecciones.SGB.enums.Categoria;
import com.cate.practica.nuevos.conceptos.colecciones.SGB.enums.Disponinilidad;
import com.cate.practica.nuevos.conceptos.colecciones.SGB.enums.Idioma;
import com.cate.practica.nuevos.conceptos.colecciones.SGB.util.Validaciones;

/**
 * Clase: Representar libros.
 *
 * @author Cate
 */
public class Libro extends Material{
    private String autor;
    private int numeroDePaginas;
    private int isbn;

    public Libro(String titulo, Idioma idioma, Disponinilidad disponible, Categoria categoria, String autor, int numeroDePaginas, int isbn) {
        super(titulo, idioma, disponible, categoria);
        setAutor(autor);
        setNumeroDePaginas(numeroDePaginas);
        setIsbn(isbn);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        Validaciones.validarNullVacio(autor, "Autor");
        this.autor = autor;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        Validaciones.validarNumeroNagativo(numeroDePaginas, "Numero dee páginas");
        this.numeroDePaginas = numeroDePaginas;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        Validaciones.validarNumeroNagativo(isbn, "isbn");
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(super.toString()).append("Libro { ").append("autor='").append(autor).append('\'').append(", numeroDePaginas=").append(numeroDePaginas).append(", isbn=").append(isbn).append('}').toString();
    }
}

