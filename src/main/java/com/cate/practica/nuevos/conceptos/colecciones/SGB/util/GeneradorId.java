package com.cate.practica.nuevos.conceptos.colecciones.SGB.util;

public final class GeneradorId {
    private static int contadorIdBiblioteca = 0;
    private static int contadorIdMaterial = 0;
    private static int contadorIdUsuario = 0;
    private static int contadorIdBibliotecario = 0;
    private static int contadorIdCodigoEmpleado = 0;
    private static int contadorIdPrestamo = 0;

    public static int generarIdBiblioteca() {
        return ++contadorIdBiblioteca;
    }

    public static int generarIdMaterial() {
        return ++contadorIdMaterial;
    }

    public static int generarIdUsuario() {
        return ++contadorIdUsuario;
    }

    public static int generarIdBibliotecario() {
        return ++contadorIdBibliotecario;
    }

    public static int generarIdCodigoEmpleado() {
        return ++contadorIdCodigoEmpleado;
    }

    public static int generarIdPrestamo() {
        return ++contadorIdPrestamo;
    }
}
