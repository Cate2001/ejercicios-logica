package com.cate.ejercicios.basicos.coleccion;
/*
 * Crea una función que reciba dos cadenas como parámetro (str1, str2)
 * e imprima otras dos cadenas como salida (out1, out2).
 * - out1 contendrá todos los caracteres presentes en la str1 pero NO
 *   estén presentes en str2.
 * - out2 contendrá todos los caracteres presentes en la str2 pero NO
 *   estén presentes en str1.
 */

import java.util.HashSet;
import java.util.Set;

public class eliminarCaracteresRepetidos {
    public static void main(String[] args) {
        String palabra1 = "Mantequilla";
        String palabra2 = "Caramelo";
        eliminarCaracteres(palabra1, palabra2);
    }

    private static void eliminarCaracteres(String str1, String str2) {
        if (str1 == null || str2 == null) throw new IllegalArgumentException("Los strings no pueden ser null");
        Set<Character> palabrasRetidas = new HashSet<>();

        String palabra1 = str1.toLowerCase();
        String palabra2 = str2.toLowerCase();

        buclePrincipal:
        for (int i = 0; i < palabra1.length(); i++) {
            for (int j = 0; j < palabra2.length(); j++) {
                if (palabra1.charAt(i) == palabra2.charAt(j)) {
                    palabrasRetidas.add(str1.charAt(i));
                    continue buclePrincipal;
                }
            }
        }
        validarRetorno(str1, palabrasRetidas);
        System.out.println();
        validarRetorno(str2, palabrasRetidas);
    }

    private static void validarRetorno(String palabra, Set<Character> palabrasRetidas) {
        inicio:
        for (int i = 0; i < palabra.length(); i++) {
            for (char letra : palabrasRetidas) {
                if (palabra.charAt(i) == letra) {
                    continue inicio;
                }
            }
            System.out.print(palabra.charAt(i));
        }
    }
}
