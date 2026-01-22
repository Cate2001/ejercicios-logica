package ejercicios;

public class funcionElementosMayoresPromedio {
    public static void main(String[] args) {
        int[][] matrizPromedio = {
                {10, 2, 6},
                {4, 8, 12},
                {1, 9, 7}
        };

        int sumaPromedio = calcularSumaPromedio(matrizPromedio);
        double promedio = calcularPromedio(sumaPromedio, matrizPromedio);
        int cantidadElementosMayoresPromedio = contadorElementosMayoresPromedio(promedio, matrizPromedio);

        System.out.println("La cantidad de elementos mayores al priomedio es: " + cantidadElementosMayoresPromedio);

    }

    public static int calcularSumaPromedio(int[][] matriz){
        int sumaPromedio = 0;

        for (int[] fila : matriz){
            for (int elemento : fila){
                sumaPromedio += elemento;
            }
        }
        return sumaPromedio;
    }

    public static double calcularPromedio(int suma, int[][] matriz){
        double promedio = 0;
        int filas = matriz.length;
        int columnas = matriz[0].length;
         int totalElementos = filas * columnas;


        promedio = (double) suma / totalElementos;

        return promedio;

    }

    public static int contadorElementosMayoresPromedio(double promedio, int[][] matriz){
        int contador = 0;

        for (int[] filas : matriz){
            for (int elemento : filas){
                if (elemento > promedio){
                    ++contador;
                }
            }
        }
        return contador;
    }
}
