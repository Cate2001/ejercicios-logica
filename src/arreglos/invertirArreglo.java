package ejercicios;

public class invertirArreglo {
    public static void main(String[] args) {
        int[] numeros = {2,3,5,6,7,88,9};
        int tamanio = numeros.length;
        int temp = 0;
        int posInter = 0;

        System.out.println("Arreglo original");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }

        for (int i = tamanio - 1; i > posInter; i--) { // 'i' empieza al final y va hacia 0
            temp = numeros[i];
            numeros[i] = numeros[posInter];
            numeros[posInter] = temp;
            posInter++;  // 'posInter' empieza en 0 y va hacia adelante 

        }
        System.out.println();

        //Resultado array invertido
        System.out.println("Arreglo invertido");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }
    }
}
