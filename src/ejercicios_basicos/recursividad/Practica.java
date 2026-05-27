package ejercicios_basicos.recursividad;

public class Practica {

    public static double sumar(double[] numeros, int indice) {

        if (indice >= numeros.length) {
            return 0;
        }

        return numeros[indice] + sumar(numeros, indice + 1);
    }

    public static void contarAtras(int numeros) { //6 , 0
        if (numeros == 0) return;
        System.out.println(numeros);
        contarAtras(numeros - 1);
    }

    public static void contarAdelante(int desde, int hasta) { // 1 - 9
        if (desde > hasta) return;
        System.out.println(desde);
        contarAdelante(desde + 1, hasta);
    }

    public static int sumarNumeros(int numeroHasta, int contador) { // contador debe iniciar desde el 1 = 1 + 2 + 3 + 4 + 5 = 15
        if (contador > numeroHasta) return 0;

        return contador + sumarNumeros(numeroHasta, contador + 1);
    }

    public static int calcularPotencia(int base, int exponente, int cont) {
        if (cont > exponente) return 1;
        return base * calcularPotencia(base, exponente, cont + 1);

    }

    public static boolean buscarNumero(int[] numeros, int numeroBuscar, int contador) {
        if (numeros[contador] == numeroBuscar) return true;
        if (contador == numeros.length - 1) return false;
        return buscarNumero(numeros, numeroBuscar, contador + 1);
    }

    public static int buscarNumeroMayor(int[] numeros, int contador){
        if (contador == numeros.length - 1) return 0;

        return  numeros[contador] > buscarNumeroMayor(numeros, contador + 1);
        /// 7 > 0 = 7
        //7 > 15 =
    }
}
