package com.cate.ejercicios.basicos.funciones;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*
 * Crea un programa que cuente cuantas veces se repite cada palabra
 * y que muestre el recuento final de todas ellas.
 * - Los signos de puntuación no forman parte de la palabra.
 * - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
 * - No se pueden utilizar funciones propias del lenguaje que
 *   lo resuelvan automáticamente.
 */
public class ContadorPalabras {
    public static void main(String[] args) {

        try {

            String poema = Files.readString(Path.of("src/main/java/resources/manifiesto.txt"));
            System.out.println(poema);

            obtenerFrecuenciaPalabras(poema);

        } catch (IOException e) {
            System.err.println("No se pudo cargar el archivo del poema: " + e.getMessage());
        }
    }

    private static void obtenerFrecuenciaPalabras(String poema) {
        if (poema == null || poema.isBlank())
            throw new NullPointerException("Ingrese un valor diferente a vacio o nulo");

        Map<String, Integer> resultadoPalabras = contadorPalabrasRepetidasPoema(poema);
        mostrarResultado(resultadoPalabras);
    }

    private static Map<String, Integer> contadorPalabrasRepetidasPoema(String poema) {
        List<String> palabrasDivididasPoema = extraerPalabras(poema);
        Map<String, Integer> palabrasEncontradas = new HashMap<>();
        int contadorPalabraRepetida = 0;

        for (String palabraActual : palabrasDivididasPoema) {
            if (!palabrasEncontradas.isEmpty()) {
                if (palabrasEncontradas.containsKey(palabraActual)) continue;
            }
            for (String palabraEncontrada : palabrasDivididasPoema) {
                if (palabraActual.equals(palabraEncontrada)) contadorPalabraRepetida++;
            }
            palabrasEncontradas.put(palabraActual, contadorPalabraRepetida);
            contadorPalabraRepetida = 0;
        }
        return palabrasEncontradas;
    }

    private static List<String> extraerPalabras(String poema) {
        List<String> palabrasPoema = new ArrayList<>();
        List<Character> caracteresOmitir = List.of(' ', ',', '.', ';', '*', ':', '\n', '\r');
        StringBuilder sb = new StringBuilder();
        Character letraActual;
        for (int i = 0; i < poema.length(); i++) {
            letraActual = poema.charAt(i);
            if (caracteresOmitir.contains(letraActual)) {
                if (!sb.isEmpty()) {
                    palabrasPoema.add(sb.toString());
                    sb.setLength(0);
                }
                continue;
            }
            sb.append(aMinuscula(letraActual));
        }
        return palabrasPoema;
    }

    private static char aMinuscula(char letra) {
        if (letra >= 'A' && letra <= 'Z') return (char) (letra + 32);
        return letra;
    }

    private static void mostrarResultado(Map<String, Integer> palabras) {
        palabras.forEach((clave, valor) -> {
            System.out.println("Palabra: " + clave + " | cantidad: " + valor);
        });
    }
}

