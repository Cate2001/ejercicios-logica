package com.cate.practica.nuevos.conceptos.colecciones.SGCM.enums;

public enum TipoBoleta {

    VIP("Zona VIP", 150.00),
    GENERAL("Zona General", 50.00);

    private final String nombreZona;
    private final double precio;

    TipoBoleta(String nombreZona, double precio) {
        this.nombreZona = nombreZona;
        this.precio = precio;
    }

    public String getNombreZona() {
        return nombreZona;
    }

    public double getPrecio() {
        return precio;
    }
}
