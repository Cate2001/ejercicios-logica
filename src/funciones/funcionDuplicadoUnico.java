package ejercicios;

public class funcionDuplicadoUnico {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5, 1, 6};

            int duplicado = encontrarDuplicado(numeros);

        System.out.println("El numero duplicado dentro del arreglo es: " + duplicado);
    }

    public static int encontrarDuplicado(int[] arr){
        int y = 0;
        int k = arr.length - 1;
        int x = (k * (k + 1)) / 2;

        for (int numero : arr){
            y += numero;
        }

        return y - x;
    }
}


