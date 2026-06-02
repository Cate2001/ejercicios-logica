package com.cate.proyectos.poo.basico.SIGRAV.model;

/**
 * Representa un avión en el sistema de gestión de rutas aéreas.
 * <p>
 * Esta clase modela las características operativas y los costos fijos
 * de un avión. Las características de un avión son inmutables una vez
 * establecidas, ya que representan especificaciones técnicas del equipo.
 * </p>
 * <p>
 * Responsabilidades:
 * <ul>
 * <li>Almacenar el modelo del avión</li>
 * <li>Definir la capacidad de pasajeros</li>
 * <li>Establecer el costo base de operación</li>
 * </ul>
 * </p>
 *
 * @author Caterine Salinas Bolaños
 * @version 1.0
 */
public class Avion {

    /**
     * Modelo del avión (ej: Boeing 737, Airbus A320).
     * Es inmutable ya que representa una especificación técnica.
     */
    private final String MODELO;

    /**
     * Capacidad máxima de pasajeros que puede transportar el avión.
     * Es inmutable ya que es una limitación física del equipo.
     */
    private final int CAPACIDAD_PASAJEROS;

    /**
     * Costo base de operación del avión por vuelo.
     * Este valor es fijo y representa los costos operativos mínimos.
     */
    private final double COSTO_OPERACION_BASE;

    /**
     * Constructor que inicializa un avión con sus características técnicas.
     * <p>
     * El costo de operación base se establece automáticamente en $500.00
     * como valor estándar para todos los aviones.
     * </p>
     *
     * @param MODELO el modelo del avión (ej: "Boeing 737", "Airbus A320")
     * @param capacidadPasajeros la capacidad máxima de pasajeros
     * @throws IllegalArgumentException si el modelo es nulo o vacío,
     *                                  o si la capacidad es menor o igual a cero
     */
    public Avion(String MODELO, int capacidadPasajeros){
        if (MODELO == null || MODELO.trim().isEmpty()) {
            throw new IllegalArgumentException("El modelo del avión no puede ser nulo o vacío");
        }
        if (capacidadPasajeros <= 0) {
            throw new IllegalArgumentException("La capacidad de pasajeros debe ser mayor a cero");
        }
        this.MODELO = MODELO;
        this.CAPACIDAD_PASAJEROS = capacidadPasajeros;
        this.COSTO_OPERACION_BASE = 500.00;

    }

    /**
     * Retorna el modelo del avión.
     *
     * @return el modelo del avión (ej: "Boeing 737", "Airbus A320")
     */
    public String getMODELO() {
        return MODELO;
    }

    /**
     * Retorna la capacidad máxima de pasajeros del avión.
     *
     * @return la capacidad de pasajeros
     */
    public int getCAPACIDAD_PASAJEROS() {
        return CAPACIDAD_PASAJEROS;
    }

    /**
     * Retorna el costo base de operación del avión por vuelo.
     * <p>
     * Este valor representa los costos operativos mínimos fijos
     * que se incurren por cada vuelo, independientemente de la ruta.
     * </p>
     *
     * @return el costo base de operación ($500.00)
     */
    public double getCOSTO_OPERACION_BASE() {
        return COSTO_OPERACION_BASE;
    }

    // Nota: No se implementan setters, pues las características de un avión son inmutables.
}
