package ejercicios;

import java.util.Arrays;

public class eliminarValoresDupli {
    public static void main(String[] args) {
        int[] valores = {2, 4, 1, 6, 7, 9, 2, 1, 3, 6, 7, 5};
        int[] sinDuplicados = new  int[valores.length];
        sinDuplicados[0] = valores[0];
        int indice = 1;
        boolean validar = false;
        int numero = 0;



        for (int valore : valores) {
            validar = false;
            for (int j = 0; j < indice; j++) {
                if (valore == sinDuplicados[j]) {
                    validar = true;
                    break;
                }
            }
            if (!validar) {
                sinDuplicados[indice++] = valore;
            }
        }
        // aquí recortamos el array al tamaño real
        sinDuplicados = Arrays.copyOf(sinDuplicados, indice);

        //mostrar los arreglos
        System.out.println("Arreglo original");
        for (int valor : valores){
            System.out.print(valor + " ");
        }
        System.out.println();
        System.out.println("Arreglo elimimando los duplicados");
        for (int sinDuplicado: sinDuplicados){
            System.out.print(sinDuplicado + " ");
        }

        validar = false;
        indice = 0;

        //ORGANIZAR ARREGLO DE MENOR A MAYOR
        for (int i = 0; i < sinDuplicados.length; i++) { //2
             numero = sinDuplicados[i];
            int j;
            validar = false;
            for (j = i; j < sinDuplicados.length; j++) {
                if (numero > sinDuplicados[j]){
                    numero = sinDuplicados[j];
                    validar = true;
                    indice = j;
                }
            }
            if (validar){
                sinDuplicados[indice] = sinDuplicados[i];
                sinDuplicados[i] = numero;
            }
        }

        System.out.println();
        System.out.println("Arreglo organizado");
        for (int sinDuplicado: sinDuplicados){
            System.out.print(sinDuplicado + " ");
        }
    }
}
