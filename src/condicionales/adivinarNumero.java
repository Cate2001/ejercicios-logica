package ejercicios;

import java.util.Scanner;

public class adivinarNumero {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int numero = 24;
        int adivino = 0;

        do {
            System.out.println("Adivina el numero");
            System.out.println("El numero esta en el rango 1 a 50");
            adivino = leer.nextInt();

            if (adivino == numero){
                System.out.println("¡Ganaste!");
            }

        }while (adivino != numero);
    }
}
