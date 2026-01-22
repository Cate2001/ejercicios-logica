package ejercicios;

public class metodoInvertirArray {
    public static void main(String[] args) {
        int[] numerosArray = {2,3,5,6,7,88,9};

        System.out.println("Arreglo original");
        mostrarArreglo(numerosArray);

        invertirArreglo(numerosArray);
        System.out.println();

        System.out.println("Arreglo invertido");
        mostrarArreglo(numerosArray);

    }

    public static void invertirArreglo(int[] arr){
        int tamanio = arr.length;
        int temp = 0;
        int posInter = 0;

        for (int i = tamanio - 1; i > posInter; i--) { // 'i' empieza al final y va hacia 0
            temp = arr[i];
            arr[i] = arr[posInter];
            arr[posInter] = temp;
            posInter++;  // 'posInter' empieza en 0 y va hacia adelante

        }
    }

    //Metodo mostrar arreglo
    public static void mostrarArreglo(int[] arr){
        for (int numero : arr) {
            System.out.print(numero + " ");
        }
    }
}
