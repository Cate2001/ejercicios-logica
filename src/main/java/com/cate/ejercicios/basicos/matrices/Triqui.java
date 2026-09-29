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

public class Triqui {
    public static void main(String[] args) {

        Character[][] triqui = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'O', 'X'}
        };

     

        analizarMatriz(triqui);
    }

    public static String analizarMatriz(Character[][] matriz) {
        if (matriz == null) throw new IllegalArgumentException("La matriz no puede ser null");
        if (matriz.length != 3 && matriz[0].length != 3) throw new IllegalArgumentException("Nulo");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {


            }

        }



        
        return null;


    }
}
