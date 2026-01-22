package ejercicios;

public class transpuestaMatriz {
    public static void main(String[] args) {
        int[][] numeros = {
                {2, 4, 6},
                {5, 7, 9},
                {8, 4, 2}
        };

        int[][] transpuesta = new int[3][3];
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                transpuesta[i][j] = numeros[j][i];
            }
        }

        //Mostrar la matriz transpuesta
        for (int i = 0; i < transpuesta.length ; i++) {
            for (int j = 0; j < transpuesta[i].length; j++) {
                System.out.print(transpuesta[i][j] + " ");
            }
            System.out.println();
        }
    }
}
