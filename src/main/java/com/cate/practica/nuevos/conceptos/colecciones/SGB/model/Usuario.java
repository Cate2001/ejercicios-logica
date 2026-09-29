package com.cate.practica.nuevos.conceptos.colecciones.SGB.model;

import com.cate.practica.nuevos.conceptos.colecciones.SGB.util.GeneradorId;
import com.cate.practica.nuevos.conceptos.colecciones.SGB.util.Validaciones;

/**
 * Clase: Solicitar prestamo de un material.
 *
 * @author Cate
 */
public class Usuario {
    private final int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;

    public Usuario(String nombre, String apellido, String telefono, String correo) {
        this.id = GeneradorId.generarIdUsuario();
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        Validaciones.validarNullVacio(nombre, "Nombre");
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        Validaciones.validarNullVacio(apellido, "Apellido");
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        Validaciones.validarTelefono(telefono);
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        Validaciones.validarEmail(correo);
        this.correo = correo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Usuario{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", apellido='").append(apellido).append('\'');
        sb.append(", telefono='").append(telefono).append('\'');
        sb.append(", correo='").append(correo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
