package com.cate.practica.nuevos.conceptos.colecciones.SGCM.util;

public final class GeneradorId {

    private static int contadorIdEstadio = 0;
    private static int contadorIdBanda = 0;
    private static int contadorIdSilla = 0;

    public static int generarIdEstadio() {
        return ++contadorIdEstadio;
    }

    public static int generarIdBanda() {
        return ++contadorIdBanda;
    }

    public static int generarIdSilla() {
        return ++contadorIdSilla;
    }
}
