package ejercicios;

import java.util.Scanner;

public class palabraPolindromo {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese la palabra a validar");
        String palabra = leer.next();

        char[] letras = palabra.toCharArray();
        char[] invertida = new char[palabra.length()];
        int pos = 0;
        boolean esPolindroma = true;

        for (int i = letras.length - 1; i >= 0; i--) {
            invertida[pos++] = letras[i];
        }

        //Recorremos la palabra invertida para validar si es polindromo
        for (int i = 0; i < letras.length; i++) {
            if (invertida[i] != letras[i]){
                esPolindroma = false;
                break;
            }
        }

        if (esPolindroma){
            System.out.println("La palabra " + palabra + " es polindromo");
        }else {
            System.out.println("La palabra " + palabra + " no es polindromo");
        }


    }
}
