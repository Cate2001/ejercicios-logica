package com.cate.practica.nuevos.conceptos.colecciones.SGCM.model;

import com.cate.practica.nuevos.conceptos.colecciones.SGCM.enums.GeneroMusical;
import com.cate.practica.nuevos.conceptos.colecciones.SGCM.util.GeneradorId;
import com.cate.practica.nuevos.conceptos.colecciones.SGCM.util.ValidacionesAtributos;

public class Banda {
    private final int id;
    private String nombre;
    private GeneroMusical generoMusical;
    private int anioFundacion;
    private String nombreBajista;

    public Banda(String nombre, GeneroMusical generoMusical, int anioFundacion, String nombreBajista) {
        this.id = GeneradorId.generarIdBanda();
        setNombre(nombre);
        setGeneroMusical(generoMusical);
        setAnioFundacion(anioFundacion);
        setNombreBajista(nombreBajista);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        ValidacionesAtributos.validarNullVacio(nombre, "Nombre");
        this.nombre = nombre;
    }

    public GeneroMusical getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(GeneroMusical generoMusical) {
        ValidacionesAtributos.validarObjetosnNulo(generoMusical, "GeneroMusical");
        this.generoMusical = generoMusical;
    }

    public int getAnioFundacion() {
        return anioFundacion;
    }

    public void setAnioFundacion(int anioFundacion) {
        ValidacionesAtributos.validarNumeroNagativo(anioFundacion, "AnioFundacion");
        this.anioFundacion = anioFundacion;
    }

    public String getNombreBajista() {
        return nombreBajista;
    }

    public void setNombreBajista(String nombreBajista) {
        ValidacionesAtributos.validarNullVacio(nombreBajista, "NombreBajista");
        this.nombreBajista = nombreBajista;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Banda{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", generoMusical=").append(generoMusical);
        sb.append(", anioFundacion=").append(anioFundacion);
        sb.append(", nombreBajista='").append(nombreBajista).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
