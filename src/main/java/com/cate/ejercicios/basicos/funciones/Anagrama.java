package com.cate.ejercicios.basicos.funciones;

import java.util.HashSet;
import java.util.Set;

public class Anagrama {
    public static void main(String[] args) {
        String palabra1 = "Roma";
        String palabra2 = "Amor";
        boolean esAnagrama = validarAnagrama(palabra1, palabra2);
        if (esAnagrama) {
            System.out.println("Es anagrama");
        } else {
            System.out.println("Las palabras no son anagrama");
        }
    }

    private static boolean validarAnagrama(String palabra1, String palabra2) {
        if (palabra1 == null || palabra2 == null)
            throw new IllegalArgumentException("Las palabras deben ser diferentes a nulo");

        int tamanioPalabra1 = palabra1.length();
        int tamanioPalabra2 = palabra2.length();
        String minusculaPalabra1 = palabra1.toLowerCase();
        String minusculaPalabra2 = palabra2.toLowerCase();
        Set<Integer> hashSet = new HashSet<>();

        if (tamanioPalabra1 != tamanioPalabra2) return false;

        principal:
        for (int i = 0; i < tamanioPalabra1; i++) {
            for (int j = 0; j < tamanioPalabra2; j++) {
                if (hashSet.contains(j)) continue;
                if (minusculaPalabra1.charAt(i) == minusculaPalabra2.charAt(j)) {
                    hashSet.add(j);
                    continue principal;
                }
            }
            return false;
        }
        return true;
    }
}
