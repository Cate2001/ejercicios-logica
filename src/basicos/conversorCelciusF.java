package ejercicios;

import java.util.Scanner;

public class conversorCelciusF {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int opcion = 0;
        double numero = 0;
        double fahrenheit;
        double celsius;

        do {
            System.out.println("Seleccione la opción a convertir: \n 1. Celsius \n 2. Fahrenheit");
            opcion = leer.nextInt();

            if (opcion < 1 || opcion > 2) {
                System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (opcion < 1 || opcion > 2);

        System.out.println("Ingrese el valor a convertir:");
        numero = leer.nextInt();

        switch (opcion) {
            case 1:
                fahrenheit = (numero * 9.0 / 5.0) + 32;
                System.out.println(numero + " °C equivalen a " + fahrenheit + " °F");
                break;
            case 2:
                celsius = (numero - 32) * 5.0 / 9.0;
                System.out.println(numero + " °F equivalen a " + celsius + " °C");
                break;
            default:
                System.out.println("Error inesperado.");
                break;
        }
    }
}
