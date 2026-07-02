package com.cate.practica.nuevos.conceptos.colecciones.SGB.model;

import com.cate.practica.nuevos.conceptos.colecciones.SGB.util.GeneradorId;
import com.cate.practica.nuevos.conceptos.colecciones.SGB.util.Validaciones;

/**
 * Clase: Administrar la biblioteca.
 *
 * @author Cate
 */
public class Bibliotecario {
    private int id;
    private String nombre;
    private int codigoEmpleado;

    public Bibliotecario(String nombre) {
        this.id = GeneradorId.generarIdBibliotecario();
        setNombre(nombre);
        this.codigoEmpleado = GeneradorId.generarIdCodigoEmpleado();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        Validaciones.validarNullVacio(nombre, "Nombre");
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bibliotecario{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", codigoEmpleado=").append(codigoEmpleado);
        sb.append('}');
        return sb.toString();
    }
}
