package ejercicios;

public class funcionMatrizTranspuesta {
    public static void main(String[] args) {
        int[][] matriz = {
                {1, 2, 3},
                {4, 5, 6}
        };

        System.out.println("Matriz original");
        mostrarMatriz(matriz);

        System.out.println("Matriz transpuesta");
        int[][] matrizTranspuesta = obtenerMatrizTranspuesta(matriz);
        mostrarMatriz(matrizTranspuesta);


    }

    public static void mostrarMatriz(int[][] numerosMatriz){

        for (int[] fila : numerosMatriz){
            for (int elemento : fila){
                System.out.print(elemento + " ");
            }
            System.out.println();

        }
    }
    public static int[][] obtenerMatrizTranspuesta(int[][] matrizOriginal){
        int filasOriginal = matrizOriginal.length;
        int columnasOriginal = matrizOriginal[0].length;
        
        int[][] matrizTranspuesta = new int[columnasOriginal][filasOriginal];

        for (int i = 0; i < filasOriginal; i++) {
            for (int j = 0; j < columnasOriginal; j++) {
                matrizTranspuesta[j][i] = matrizOriginal[i][j];
            }
        }
        return matrizTranspuesta;
    }
}
