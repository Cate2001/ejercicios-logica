package ejercicios;

public class calculoEstadisticoHisto {
    public static void main(String[] args) {
        int[] numeros = {3, 1,7,9,23,6,7,2,7,7};
        int numeroMenor = numeros[0];
        int numeroMayor = numeros[0];
        int suma = 0;

        for (int numero: numeros){
            suma += numero;
            //numero mayor
            if (numero > numeroMayor){
                numeroMayor = numero;
            }
            //numero menor
            if (numero < numeroMenor){
                numeroMenor = numero;
            }
        }


        System.out.println("Minimo = " + numeroMenor);
        System.out.println("Maximo = " + numeroMayor);
        System.out.println("Promedio: = " + suma / numeros.length);

    }
}
