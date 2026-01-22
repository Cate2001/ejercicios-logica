package ejercicios;

public class moverCerosFinal {
    public static void main(String[] args) {
        int[] numeros = {3,5,0,7,0,1,6,4,3,0,1};
        // 3,5,7,1,6,4,3,1
        int tamanio = numeros.length;
        int writeIndex = 0;

        for (int i = 0; i < tamanio; i++) {
            if (numeros[i] != 0){
                numeros[writeIndex++] = numeros[i];
            }
        }
        for (int i = writeIndex; i < tamanio; i++) {
            numeros[i] = 0;
        }

        System.out.println("Arreglo modificado");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }
    }
}

