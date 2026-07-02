package com.cate.practica.nuevos.conceptos.colecciones.SGB.model;

import com.cate.practica.nuevos.conceptos.colecciones.SGB.enums.Disponinilidad;
import com.cate.practica.nuevos.conceptos.colecciones.SGB.util.GeneradorId;
import com.cate.practica.nuevos.conceptos.colecciones.SGB.util.Validaciones;

import java.util.Date;

/**
 * Clase: Relacionar un usuario con un material.
 *
 * @author Cate
 */
public class Prestamo {
    private int id;
    private Usuario usuario;
    private Material material;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private Disponinilidad disponible;

    public Prestamo(Usuario usuario, Material material, Date fechaPrestamo, Date fechaDevolucion, Disponinilidad disponible) {
        this.id = GeneradorId.generarIdPrestamo();
        Validaciones.validarFechaObjeto(fechaPrestamo);
        setUsuario(usuario);
        setMaterial(material);
        setFechaDevolucion(fechaDevolucion);
        this.fechaPrestamo = fechaPrestamo;
        this.disponible = disponible;
    }

    public int getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        Validaciones.validarObjetosnNulo(usuario, "Usuario");
        this.usuario = usuario;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        Validaciones.validarObjetosnNulo(material, "Material");
        this.material = material;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        Validaciones.validarFechaObjeto(fechaDevolucion);
        this.fechaDevolucion = fechaDevolucion;
    }

    public Disponinilidad getDisponible() {
        return disponible;
    }

    public void setDisponible(Disponinilidad disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Prestamo{");
        sb.append("id=").append(id);
        sb.append(", usuario=").append(usuario);
        sb.append(", material=").append(material);
        sb.append(", fechaPrestamo=").append(fechaPrestamo);
        sb.append(", fechaDevolucion=").append(fechaDevolucion);
        sb.append(", disponible=").append(disponible);
        sb.append('}');
        return sb.toString();
    }
}
