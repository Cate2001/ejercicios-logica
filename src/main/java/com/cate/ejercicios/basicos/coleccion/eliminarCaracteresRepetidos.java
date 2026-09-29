package com.cate.ejercicios.basicos.matrices;
/*
 * Crea una función que reciba dos cadenas como parámetro (str1, str2)
 * e imprima otras dos cadenas como salida (out1, out2).
 * - out1 contendrá todos los caracteres presentes en la str1 pero NO
 *   estén presentes en str2.
 * - out2 contendrá todos los caracteres presentes en la str2 pero NO
 *   estén presentes en str1. PENDIENTE: REVISAR LOGICCA OPROGRAMA
 */

import java.util.HashSet;
import java.util.Set;

public class Entrenar {
    public static void main(String[] args) {
        String palabra1 = "mantequilla";
        String palabra2 = "Caramelo";
        eliminarCaracteres(palabra1, palabra2);
    }

    private static void eliminarCaracteres(String str1, String str2) {
        if (str1 == null || str2 == null) throw new IllegalArgumentException("Los strings no pueden ser null");
        Set<Character> palabrasRetidas = new HashSet<>();

        buclePrincipal:
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
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
