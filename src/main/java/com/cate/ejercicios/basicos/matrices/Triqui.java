package com.cate.ejercicios.basicos.matrices;
/*
 * Crea una función que analice una matriz 3x3 compuesta por "X" y "O"
 * y retorne lo siguiente:
 * - "X" si han ganado las "X"
 * - "O" si han ganado los "O"
 * - "Empate" si ha habido un empate
 * - "Nulo" si la proporción de "X", de "O", o de la matriz no es correcta.
 *   O si han ganado los 2.
 * Nota: La matriz puede no estar totalmente cubierta.
 * Se podría representar con un vacío "", por ejemplo.
 */

public class triqui {
    static void main(String[] args) {

    }

    public String analizarMatriz(String[][] matriz) {
        if (matriz == null) throw new IllegalArgumentException("La matriz no puede ser null");
        if (matriz.length != 3 && matriz[0].length != 3) throw new IllegalArgumentException("Nulo");

        String x = "X";
        String o = "O";
        String empate = "Empate";

        int xCount = 0;
        int oCount = 0;
        for (String[] fila : matriz) {
            for (String valor : fila){
                if (valor != null){
                    if (valor.equalsIgnoreCase(x)) xCount++;
                    if (valor.equalsIgnoreCase(o)) oCount++;
                }
            }

        }
        int diferenciaProporcion = xCount - oCount;

        if (diferenciaProporcion > 1 || diferenciaProporcion < 0) return "Nulo";

        return "Exitoso";

    }
}
