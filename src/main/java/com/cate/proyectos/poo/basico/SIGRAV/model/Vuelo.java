package com.cate.proyectos.poo.basico.SIGRAV.model;

/**
 * Representa un vuelo en el sistema de gestión de rutas aéreas.
 * <p>
 * Esta clase es la transacción que une el origen y destino con un avión
 * asignado, y calcula el costo final de la operación. Combina la información
 * de la ruta (costo del trayecto) con el costo de operación del avión.
 * </p>
 * <p>
 * Responsabilidades:
 * <ul>
 * <li>Mantener información de origen y destino del vuelo</li>
 * <li>Asignar un avión al vuelo</li>
 * <li>Calcular el costo final sumando ruta + operación del avión</li>
 * <li>Validar que exista ruta y avión asignado antes de calcular</li>
 * </ul>
 * </p>
 *
 * @author Caterine Salinas Bolaños
 * @version 1.0
 */
public class Vuelo {

    /**
     * Ciudad de origen del vuelo.
     * Es inmutable ya que un vuelo no puede cambiar su origen una vez creado.
     */
    private final String ORIGEN;

    /**
     * Ciudad de destino del vuelo.
     * Es inmutable ya que un vuelo no puede cambiar su destino una vez creado.
     */
    private final String DESTINO;

    /**
     * Avión asignado para realizar este vuelo.
     * Puede ser null si aún no se ha asignado un avión.
     */
    private Avion avionAsignado;

    /**
     * Costo final calculado del vuelo.
     * Incluye el costo de la ruta más el costo de operación del avión.
     * Un valor de -1.0 indica que el cálculo falló.
     */
    private double costoFinal;

    /**
     * Constructor que inicializa un vuelo con origen y destino.
     * <p>
     * El costo final se inicializa en 0.0 y el avión asignado en null.
     * El cálculo del costo debe realizarse posteriormente llamando a
     * {@link #calcularCostoFinal(RutaAerea)}.
     * </p>
     *
     * @param ORIGEN la ciudad de origen (ej: "A")
     * @param DESTINO la ciudad de destino (ej: "B")
     * @throws IllegalArgumentException si origen o destino son nulos o vacíos
     */
    public Vuelo(String ORIGEN, String DESTINO) {
        if (ORIGEN == null || ORIGEN.trim().isEmpty()) {
            throw new IllegalArgumentException("El origen no puede ser nulo o vacío");
        }
        if (DESTINO == null || DESTINO.trim().isEmpty()) {
            throw new IllegalArgumentException("El destino no puede ser nulo o vacío");
        }
        this.ORIGEN = ORIGEN;
        this.DESTINO = DESTINO;
        this.costoFinal = 0.0;
        this.avionAsignado = null;
    }

    /**
     * Asigna un avión a este vuelo.
     * <p>
     * Un vuelo debe tener un avión asignado antes de poder calcular
     * su costo final.
     * </p>
     *
     * @param avion el avión a asignar (no puede ser null)
     * @throws IllegalArgumentException si el avión es null
     */
    public void asignarAvion(Avion avion) {
        if (avion == null) {
            throw new IllegalArgumentException("El avión no puede ser null");
        }
        this.avionAsignado = avion;
    }

    /**
     * Calcula el costo final del vuelo.
     * <p>
     * Este método combina el costo de la ruta (directa o con escala)
     * con el costo de operación base del avión asignado.
     * </p>
     * <p>
     * Fórmula de cálculo:
     * <code>costoFinal = costoRuta + costoOperacionAvion</code>
     * </p>
     * <p>
     * Condiciones de error:
     * <ul>
     * <li>Si no existe ruta (directa o con escala): costoFinal = -1.0</li>
     * <li>Si no hay avión asignado: costoFinal = -1.0</li>
     * </ul>
     * </p>
     *
     * @param mapaRutas el mapa de rutas aéreas para calcular el costo del trayecto
     * @throws IllegalArgumentException si mapaRutas es null
     */
    public void calcularCostoFinal(RutaAerea mapaRutas) {
        if (mapaRutas == null) {
            throw new IllegalArgumentException("El mapa de rutas no puede ser null");
        }

        // 1. Obtener el costo base de la ruta (usa la lógica de escala)
        int costoRuta = mapaRutas.encontrarPrimeraRuta(this.ORIGEN, this.DESTINO);

        if (costoRuta == -1) {
            // La ruta no existe (ciudad inválida o no se encontró escala)
            this.costoFinal = -1.0;
            System.out.println("⛔ ERROR (" + this.ORIGEN + " -> " + this.DESTINO + "): No se encontró una ruta válida (directa o con una escala).");

        } else if (this.avionAsignado == null) {
            // El avión no ha sido asignado.
            this.costoFinal = -1.0;
            System.out.println("⚠️ ERROR (" + this.ORIGEN + " -> " + this.DESTINO + "): No se puede calcular el costo. No hay avión asignado.");

        } else {
            // Cálculo Final: Costo de la Ruta + Costo Fijo de Operación del Avión
            double costoOperacionAvion = this.avionAsignado.getCOSTO_OPERACION_BASE();

            // Convertimos el costoRuta a double para la suma
            this.costoFinal = (double) costoRuta + costoOperacionAvion;
            System.out.println("✅ Cálculo Exitoso para Vuelo " + this.ORIGEN + " -> " + this.DESTINO);
        }
    }

    /**
     * Retorna el costo final calculado del vuelo.
     * <p>
     * Este valor incluye el costo de la ruta más el costo de operación
     * del avión. Un valor de -1.0 indica que el cálculo falló.
     * </p>
     *
     * @return el costo final del vuelo, o -1.0 si no se pudo calcular
     */
    public double getCostoFinal() {
        return costoFinal;
    }

    /**
     * Retorna el avión asignado a este vuelo.
     * <p>
     * Puede retornar null si aún no se ha asignado un avión.
     * </p>
     *
     * @return el avión asignado, o null si no hay avión asignado
     */
    public Avion getAvionAsignado() {
        return avionAsignado;
    }



}
