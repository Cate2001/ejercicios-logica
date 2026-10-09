package com.cate.ejercicios.basicos.ciclos;
/*
 * Escribe un programa que imprima los 50 primeros números de la sucesión
 * de Fibonacci empezando en 0.
 * - La serie Fibonacci se compone por una sucesión de números en
 *   la que el siguiente siempre es la suma de los dos anteriores.
 *   0, 1, 1, 2, 3, 5, 8, 13...
 */
public class Fibonacci {
    public static void main(String[] args) {

        int numeroAnterior = 0;
        int numeroActual = 1;
        System.out.print(numeroAnterior + ", " + numeroActual);
        for (int i = 0; i < 49; i++) {
            int resultadoSuma = numeroAnterior + numeroActual;
            numeroAnterior = numeroActual;
            numeroActual = resultadoSuma;
            System.out.print(", ");
            System.out.print(numeroActual);

        }

    }
}
