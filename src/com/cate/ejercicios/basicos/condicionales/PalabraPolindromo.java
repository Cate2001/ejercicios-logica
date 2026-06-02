package com.cate.ejercicios.basicos.condicionales;

import java.util.Scanner;

public class PalabraPolindromo {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese la palabra a validar");
        String palabra = leer.next();

        char[] letras = palabra.toCharArray();
        char[] invertida = new char[palabra.length()];
        int pos = 0;
        boolean esPalindromo = true;

        for (int i = letras.length - 1; i >= 0; i--) {
            invertida[pos++] = letras[i];
        }

        //Recorremos la palabra invertida para validar si es palindromo
        for (int i = 0; i < letras.length; i++) {
            if (invertida[i] != letras[i]){
                esPalindromo = false;
                break;
            }
        }

        if (esPalindromo){
            System.out.println("La palabra " + palabra + " es palindromo");
        }else {
            System.out.println("La palabra " + palabra + " no es palindromo");
        }


    }
}
