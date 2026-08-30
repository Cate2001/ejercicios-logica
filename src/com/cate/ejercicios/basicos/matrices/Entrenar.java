package com.cate.ejercicios.basicos.matrices;

import java.util.ArrayList;
import java.util.List;

public class Entrenar {
    static void main(String[] args) {
        String  palabra = "Mantequilla";
        System.out.println(palabra.length());


    }

    public void eliminarCaracteres(String str1, String str2){
        if (str1 == null || str2 == null) throw new IllegalArgumentException("Los strings no pueden ser null");
        List<Character> palabrasRetidas = new ArrayList<>();

        buclePrincipal:
        for (int i = 0; i < str1.length(); i++){
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    palabrasRetidas.add(str1.charAt(i));
                    continue buclePrincipal;
                }
            }
        }






    }
}
