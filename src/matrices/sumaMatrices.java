package ejercicios;

public class sumaMatrices {
    public static void main(String[] args) {
        int[][] numeros = {
                {2, 4, 6},
                {5, 7, 9},
                {88, 4, 2}
        };
        int[][] numeros2 = {
                {5, 7, 6},
                {2, 7, 1},
                {78, 4, 2}
        };

        int[][] sumas = new int[3][3];

        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros.length; j++) {
                sumas[i][j] = numeros[i][j]  + numeros2[i][j];
            }
        }

        //Mostrar las matrices
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros.length; j++) {
                System.out.print(sumas[i][j] + " ");

            }
            System.out.println();

        }
    }



}
