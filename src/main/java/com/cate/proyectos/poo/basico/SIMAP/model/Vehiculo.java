package com.cate.proyectos.poo.basico.SIMAP.model;

import java.time.LocalTime;

/**
 * Representa un vehículo en el sistema de gestión de parqueaderos.
 * <p>
 * Esta clase modela la información de un vehículo que ingresa al
 * parqueadero, incluyendo su placa, hora de entrada y tipo de vehículo.
 * </p>
 * <p>
 * Responsabilidades:
 * <ul>
 * <li>Almacenar la placa del vehículo</li>
 * <li>Registrar la hora de entrada al parqueadero</li>
 * <li>Clasificar el tipo de vehículo</li>
 * <li>Validar que la placa no sea nula o vacía</li>
 * </ul>
 * </p>
 *
 * @author Caterine Salinas Bolaños
 * @version 1.0
 */
public class Vehiculo {
    /**
     * Placa del vehículo.
     * Es un identificador único y debe ser validado para no ser nulo o vacío.
     */
    private String placa;

    /**
     * Hora de entrada del vehículo al parqueadero.
     * Se registra en formato de hora (0-23).
     */
    private int horaEntrada;

    /**
     * Tipo de vehículo (ej: "Carro", "Moto", "Camión").
     * Se utiliza para calcular tarifas diferenciadas según el tipo.
     */
    private String tipo;

    /**
     * Constructor que inicializa un vehículo con placa, hora de entrada y tipo.
     * <p>
     * La hora de entrada se proporciona explícitamente. Si se desea usar
     * la hora actual del sistema, usar el constructor alternativo.
     * </p>
     *
     * @param placa la placa del vehículo (no puede ser nula o vacía)
     * @param horaEntrada la hora de entrada (0-23)
     * @param tipo el tipo de vehículo (ej: "Carro", "Moto")
     * @throws IllegalArgumentException si la placa es nula o vacía
     */
    public Vehiculo(String placa, int horaEntrada, String tipo) {
        setPlaca(placa);
        this.horaEntrada = horaEntrada;
        this.tipo = tipo;
    }

    /**
     * Constructor que inicializa un vehículo con placa y tipo,
     * usando la hora actual del sistema como hora de entrada.
     *
     * @param placa la placa del vehículo (no puede ser nula o vacía)
     * @param tipo el tipo de vehículo (ej: "Carro", "Moto")
     * @throws IllegalArgumentException si la placa es nula o vacía
     */
    public Vehiculo(String placa, String tipo){
        setPlaca(placa);
        this.tipo = tipo;
        this.horaEntrada = LocalTime.now().getHour();
    }

    /**
     * Retorna la placa del vehículo.
     *
     * @return la placa del vehículo
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Establece la placa del vehículo.
     * <p>
     * Valida que la placa no sea nula o vacía antes de asignarla.
     * </p>
     *
     * @param nuevaPlaca la nueva placa del vehículo
     * @throws IllegalArgumentException si la placa es nula o vacía
     */
    public void setPlaca(String nuevaPlaca) {
        if (nuevaPlaca == null || nuevaPlaca.trim().isEmpty()) {
            throw new IllegalArgumentException("La placa no puede ser nula o vacía.");
        }
        this.placa = nuevaPlaca;
    }

    /**
     * Retorna la hora de entrada del vehículo al parqueadero.
     *
     * @return la hora de entrada (0-23)
     */
    public int getHoraEntrada() {
        return horaEntrada;
    }

    /**
     * Retorna el tipo de vehículo.
     *
     * @return el tipo de vehículo (ej: "Carro", "Moto")
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de vehículo.
     *
     * @param tipo el nuevo tipo de vehículo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
