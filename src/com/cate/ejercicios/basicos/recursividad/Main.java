package com.cate.ejercicios.basicos.recursividad;

public class Main {
    static void main() {
        //double[] notas = new double[] {2.4, 5.0, 3.7, 2.1};

        //Practica.sumar(notas, 0);
        // System.out.println(Calculadora.sumar(notas, 0));

        //Practica.contarAtras(4);
        // Practica.contarAdelante(1, 6);
        //int resultadoSuma = Practica.sumarNumeros(5, 1);
        //System.out.println(resultadoSuma);

        // int potencia = Practica.calcularPotencia(2,3,1);
        //System.out.println(potencia);
       /*
        int[] numeros = {5, 8, 2, 10};
        int numeroBuscar = 8;
        int contador = 0;
        boolean encontrado = Practica.buscarNumero(numeros, numeroBuscar, contador);

        if (encontrado) {
            System.out.println("Numero encontrado");
        } else {
            System.out.println("Numero no encontrado");
        }

        */

        int[] numeros1 = {4, 9, 2, 15, 7, 7};
        int contador = 0;
        int numero = Practica.buscarNumeroMayor(numeros1,contador);
        System.out.println(numero);

    }
}
