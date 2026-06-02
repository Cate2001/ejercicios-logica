package com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.fitlife.util;

public class Calculadora {

    private Calculadora(){}

    public static double calcularIVA(double precio){
        double iva = (double) 19 / 100;
        double precioIVA = precio * iva;
        return precioIVA;
    }

    public static double calcularPrecioConIVA(double precio){
        double iva = calcularIVA(precio);
        double precioIVA = precio + iva;

        return precioIVA;
    }





}
