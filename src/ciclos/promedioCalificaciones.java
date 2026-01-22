package ejercicios;

import java.util.Scanner;

public class promedioCalificaciones {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        double[] calificaiones = new double[5];
        double suma = 0;
        double promedio = 0;

        for (int i = 0; i < calificaiones.length; i++) {
            System.out.println("Ingrese la calificación " + (i + 1));
            calificaiones[i] = leer.nextDouble();

            suma += calificaiones[i];
        }
        promedio =  Math.round(suma / calificaiones.length);

        System.out.println("Promedio de las calificaciones ingresadas: " + promedio);
    }
}
