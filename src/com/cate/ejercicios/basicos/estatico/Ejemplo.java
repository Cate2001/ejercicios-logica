package com.cate.ejercicios.basicos.estatico;

public class Ejemplo {
    private int numero;
    private static int contador = 0;

    public Ejemplo(int numero) {
        this.numero = numero;

    }
    public static void autoincrementar() {
        contador++;
    }
}
