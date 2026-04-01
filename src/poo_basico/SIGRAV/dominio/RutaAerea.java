package POO.SIGRAV.dominio;

public class RutaAerea {
    //Comprendido. Vamos a enfocarnos exclusivamente en el Motor de Costos,
    // la clase RutaAerea, con una especificación completa y profesional. Una vez que esta
    // clase esté implementada, la complejidad del proyecto se reduce drásticamente.
    // Especificación Profesional: Clase RutaAerea (Motor de Costos)
    //La clase RutaAerea es el corazón lógico del proyecto SIGRAV. Su única responsabilidad
    // es conocer el mapa y calcular las rutas.

    // Atributos y Matriz de Costos (Regla de Negocio)
    private static final int DIMENSION = 5;
    private final String[] NOMBRES_CIUDADES; // Arreglo de Etiquetas
    private final int[][] MAPA_RUTAS;

    //Constructor
    public RutaAerea() {

        this.NOMBRES_CIUDADES = new String[]{"A", "B", "C", "D", "E"};
        this.MAPA_RUTAS = new int[][]{
                //   A   B   C   D   E
                {0, 100, 0, 200, 50}, // Origen A
                {100, 0, 150, 0, 0},  // Origen B
                {0, 150, 0, 300, 0},  // Origen C
                {200, 0, 300, 0, 250},// Origen D
                {50, 0, 0, 250, 0}    // Origen E
        };
    }

    //Metodos
    public int getIndiceCiudad(String nombre) {
        for (int i = 0; i < DIMENSION; i++) {
            if (this.NOMBRES_CIUDADES[i].equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1;
    }

    public int buscarCostoDirecto(String origen, String destino) {
        int indiceOrigen = getIndiceCiudad(origen);
        int indiceDestino = getIndiceCiudad(destino);
        if (indiceOrigen == -1 || indiceDestino == -1) {
            return -1;
        }
        int costo = this.MAPA_RUTAS[indiceOrigen][indiceDestino];
        if (costo > 0) {
            return costo;
        } else {
            return -1;
        }
    }

    public int encontrarPrimeraRuta(String origen, String destino) {
        int validarCiuOrigen = getIndiceCiudad(origen);
        int validarCiuDesti = getIndiceCiudad(destino);

        int costoDirecto = buscarCostoDirecto(origen, destino);

        if (validarCiuOrigen == -1 || validarCiuDesti == -1) {
            return -1;
        } else if (costoDirecto > 0) {
            return costoDirecto;
        } else {
            // Dentro del bloque 'else'
            // Sabemos que las ciudades son válidas, pero la ruta directa no existe.

            int costoTotal = -1; // 1. Inicializa el costo a -1 (no encontrado)

            // 2. Etiqueta para el 'break'
            BUSQUEDA_ESCALA:
            for (int i = 0; i < DIMENSION; i++) { // 'i' es el índice de la ESCALA (0, 1, 2, 3, 4)

                // 3. Obtiene el costo del TRAMO 1 (Origen -> Escala 'i')
                int costoTramo1 = this.MAPA_RUTAS[validarCiuOrigen][i];

                // 4. Obtiene el costo del TRAMO 2 (Escala 'i' -> Destino)
                int costoTramo2 = this.MAPA_RUTAS[i][validarCiuDesti];

                // 5. La Validación Crítica
                // ¿Existen AMBOS tramos? (¿Son mayores que 0?)
                if (costoTramo1 > 0 && costoTramo2 > 0) {

                    // 6. ¡Ruta encontrada! Calcula el costo total
                    costoTotal = costoTramo1 + costoTramo2;

                    // 7. Sal del bucle 'for' inmediatamente
                    break BUSQUEDA_ESCALA;
                }
            }

                  // 8. Retorna el resultado
            return costoTotal; // Devuelve el costo (ej: 250) o -1 si nunca se encontró escala


        }


    }

}
