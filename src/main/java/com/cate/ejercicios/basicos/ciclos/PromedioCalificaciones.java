package com.cate.ejercicios.basicos.ciclos;

import java.util.Scanner;

public class PromedioCalificaciones {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        double[] calificaciones = new double[5];
        double suma = 0;
        double promedio = 0;

        for (int i = 0; i < calificaciones.length; i++) {
            System.out.println("Ingrese la calificación " + (i + 1));
            calificaciones[i] = leer.nextDouble();

            suma += calificaciones[i];
        }
        promedio =  Math.round(suma / calificaciones.length);

        System.out.println("Promedio de las calificaciones ingresadas: " + promedio);
    }
}
