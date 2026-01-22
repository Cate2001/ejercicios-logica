package ejercicios;

import java.util.Scanner;

public class matrizIdentidad {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese el tamaño de la matriz");
        int tamanio = leer.nextInt();

        int [][] matriz = new int[tamanio][tamanio];
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                if(matriz[i] == matriz[j]){
                    matriz[i][j] = 1;
                }else {
                    matriz[i][j] = 0;
                }
            }
        }

        //Mostrar la matriz
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
