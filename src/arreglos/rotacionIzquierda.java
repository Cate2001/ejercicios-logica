package ejercicios;

import java.util.Scanner;

public class rotacionIzquierda {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        int[] numeros = {1,2,3,4, 5, 6};
        int tamanioArr = numeros.length;

        // leer posiciones (cantidad a rotar) y validar que 0 <= posiciones < tamano
        int posiciones;

        do {
            System.out.println("Por favor ingrese un numero entero menor a " + tamanioArr + " para posiciones el arreglo");
            posiciones = leer.nextInt();

            if (posiciones< 0 || posiciones >= tamanioArr) {
                System.out.println("Valor inválido. Ingrese 0 <= posiciones < " + tamanioArr);
            }
        }while (posiciones< 0 || posiciones >= tamanioArr);

        //mostrar original
        System.out.print("Arreglo original: ");
        for (int x : numeros) System.out.print(x + " ");
        System.out.println();

        // cálculo de índices y tamaños
        int cantidadMover = posiciones;    // cuántos guardaremos en temporal
        int cantidadRestante = tamanioArr - cantidadMover; // cuántos quedan "desplazables"
        int leidosTemp = 0;    // índice de lectura hacia temp
        int escritosTemp = 0; // índice de escritura desde temp

        // arreglo temporal que guarda los primeros 'posiciones' elementos
        int[] temporal = new int[cantidadMover];

        int leerDesde = posiciones; // posición desde donde tomamos los elementos que "sobran"

        for (int i = 0; i < tamanioArr; i++) {
            // guardar en temporal los primeros 'posiciones' elementos
            if (leidosTemp < posiciones) {
                temporal[i] = numeros[i];
                leidosTemp++;
            }

            // mover los elementos restantes hacia la izquierda
                if (i < cantidadRestante){
                    //Mover a la derecha los valores sobrantes
                    numeros[i] = numeros[leerDesde++];
                } else {
                    // agregar al final lo que estaba guardado en temporal
                    numeros[i] = temporal[escritosTemp++];
                }
        }

        // mostrar resultado
        System.out.print("Arreglo rotado: ");
        for (int x : numeros) System.out.print(x + " ");
        System.out.println();


        leer.close();
    }
}
