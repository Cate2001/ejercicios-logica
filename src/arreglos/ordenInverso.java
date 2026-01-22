package ejercicios;

public class ordenInverso {
    public static void main(String[] args) {
        int[] numeros = {2, 4, 6, 7, 9, 1};
        int[] inverso = new int[numeros.length];
        int pos = 0;

        for (int i = numeros.length - 1; i >= 0 ; i--) {
            inverso[pos++] = numeros[i];
        }

        System.out.println("Array original");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }

        System.out.println();
        System.out.println("Array invertido");
        //MOSTRAR ARRAY INVERTIDO
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(inverso[i] + " ");
        }
    }
}
