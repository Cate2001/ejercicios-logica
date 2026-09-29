package com.cate.ejercicios.basicos.funciones;
public class Multiplo {
    public static void main(String[] args) {

        final int multiplo1 = 3;
        final int multiplo2 = 5;

        final String palabraTres = "fizz";
        final String palabraCinco = "buzz";

        for (int i = 1; i < 101; i++) {
            boolean esMultiploTres = esMultiploDe(i, multiplo1);
            boolean esMultiploDeCinco = esMultiploDe(i, multiplo2);

            if (esMultiploTres && esMultiploDeCinco) {
                System.out.println(palabraTres + palabraCinco);
            } else if (esMultiploTres) {
                System.out.println(palabraTres);

            } else if (esMultiploDeCinco) {
                System.out.println(palabraCinco);

            } else {
                System.out.println(i);
            }
        }
    }

    private static boolean esMultiploDe(int numeroValidar, int multiplo) {
        return numeroValidar % multiplo == 0;
    }
}
