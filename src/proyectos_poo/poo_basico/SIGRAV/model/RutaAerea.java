package proyectos_poo.poo_basico.SIGRAV.model;

/**
 * Motor de costos y rutas aéreas del sistema SIGRAV.
 * <p>
 * Esta clase es el corazón lógico del proyecto SIGRAV. Su única responsabilidad
 * es conocer el mapa de rutas y calcular los costos entre ciudades.
 * Implementa una matriz de adyacencia para representar las conexiones aéreas
 * y sus costos asociados.
 * </p>
 * <p>
 * Responsabilidades:
 * <ul>
 * <li>Mantener el mapa de rutas aéreas con sus costos</li>
 * <li>Calcular costos directos entre ciudades</li>
 * <li>Encontrar rutas con escalas cuando no hay conexión directa</li>
 * <li>Validar existencia de ciudades en el sistema</li>
 * </ul>
 * </p>
 * <p>
 * El sistema maneja 5 ciudades identificadas como A, B, C, D y E.
 * Los costos están predefinidos en una matriz de adyacencia.
 * </p>
 *
 * @author Caterine Salinas Bolaños
 * @version 1.0
 */
public class RutaAerea {

    /**
     * Dimensión fija del sistema de ciudades (5 ciudades).
     */
    private static final int DIMENSION = 5;

    /**
     * Arreglo de etiquetas con los nombres de las ciudades del sistema.
     * Las ciudades son identificadas como A, B, C, D y E.
     */
    private final String[] NOMBRES_CIUDADES;

    /**
     * Matriz de adyacencia que representa el mapa de rutas aéreas.
     * <p>
     * MAPA_RUTAS[i][j] representa el costo de volar desde la ciudad i
     * hasta la ciudad j. Un valor de 0 indica que no hay conexión directa.
     * </p>
     */
    private final int[][] MAPA_RUTAS;

    /**
     * Constructor que inicializa el mapa de rutas aéreas.
     * <p>
     * Establece las 5 ciudades del sistema (A, B, C, D, E) y configura
     * la matriz de costos con las conexiones disponibles y sus tarifas.
     * </p>
     * <p>
     * Configuración de rutas:
     * <ul>
     * <li>A ↔ B: $100</li>
     * <li>A ↔ D: $200</li>
     * <li>A ↔ E: $50</li>
     * <li>B ↔ C: $150</li>
     * <li>C ↔ D: $300</li>
     * <li>D ↔ E: $250</li>
     * </ul>
     * </p>
     */
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

    /**
     * Busca el índice de una ciudad en el sistema.
     * <p>
     * La búsqueda es case-insensitive, por lo que "a" y "A" retornan
     * el mismo resultado.
     * </p>
     *
     * @param nombre el nombre de la ciudad a buscar (ej: "A", "B", "C")
     * @return el índice de la ciudad en el arreglo (0-4), o -1 si no existe
     */
    public int getIndiceCiudad(String nombre) {
        for (int i = 0; i < DIMENSION; i++) {
            if (this.NOMBRES_CIUDADES[i].equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Calcula el costo directo de vuelo entre dos ciudades.
     * <p>
     * Este método busca una conexión directa en la matriz de rutas.
     * Si no existe conexión directa, retorna -1.
     * </p>
     *
     * @param origen la ciudad de origen (ej: "A")
     * @param destino la ciudad de destino (ej: "B")
     * @return el costo directo del vuelo, o -1 si no existe conexión directa
     *         o si alguna ciudad no existe en el sistema
     */
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

    /**
     * Encuentra la primera ruta disponible entre dos ciudades.
     * <p>
     * Este método implementa un algoritmo de búsqueda de rutas con escala:
     * <ol>
     * <li>Primero verifica si existe conexión directa</li>
     * <li>Si no hay conexión directa, busca una ciudad de escala intermedia</li>
     * <li>Retorna el costo total de la ruta con escala</li>
     * </ol>
     * </p>
     * <p>
     * Si no existe ninguna ruta (ni directa ni con escala), retorna -1.
     * </p>
     *
     * @param origen la ciudad de origen (ej: "A")
     * @param destino la ciudad de destino (ej: "C")
     * @return el costo total de la ruta (directa o con escala),
     *         o -1 si no existe ruta posible
     */
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
