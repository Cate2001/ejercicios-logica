package proyectos_poo.poo_basico.herencia_abstraccion_interfaces.SGVE.model;

import proyectos_poo.poo_basico.herencia_abstraccion_interfaces.SGVE.enums.EstadoVehiculo;

/**
 * Clase abstracta que representa un vehículo en el Sistema de Gestión de Vehículos de Envío (SGVE).
 * Define los atributos y comportamientos comunes para todos los tipos de vehículos del sistema.
 *
 * <p>Esta clase implementa los principios de abstracción y encapsulamiento de la POO,
 * sirviendo como base para las clases concretas: Dron, Moto y Camion.</p>
 *
 * @author SGVE Development Team
 * @version 1.0
 */
public abstract class Vehiculo {
    private String placa;
    private String marca;
    private double capacidadCarga;
    private EstadoVehiculo estado;
    private double distanciaRecorrida;

    /**
     * Constructor de la clase Vehiculo.
     *
     * @param placa Identificador único del vehículo (no puede ser nulo o vacío)
     * @param marca Fabricante del vehículo (no puede ser nulo o vacío)
     * @param capacidadCarga Capacidad máxima de carga en kg (debe ser mayor a 0)
     * @param estado Estado actual del vehículo (DISPONIBLE, EN_RUTA, MANTENIMIENTO)
     * @param distanciaRecorrida Distancia total recorrida en km (debe ser mayor a 0)
     */
    public Vehiculo(String placa, String marca, double capacidadCarga, EstadoVehiculo estado, double distanciaRecorrida) {
        setPlaca(placa);
        setMarca(marca);
        setCapacidadCarga(capacidadCarga);
        setEstado(estado);
        setDistanciaRecorrida(distanciaRecorrida);
    }

    /**
     * Obtiene la placa del vehículo.
     *
     * @return Placa del vehículo
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Establece la placa del vehículo.
     *
     * @param placa Nueva placa del vehículo (no puede ser nulo o vacío)
     * @throws IllegalArgumentException si el parámetro es nulo o vacío
     */
    public void setPlaca(String placa) {
        validarCampoString(placa);
        this.placa = placa;
    }

    /**
     * Obtiene la marca del vehículo.
     *
     * @return Marca del vehículo
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del vehículo.
     *
     * @param marca Nueva marca del vehículo (no puede ser nulo o vacío)
     * @throws IllegalArgumentException si el parámetro es nulo o vacío
     */
    public void setMarca(String marca) {
        validarCampoString(marca);
        this.marca = marca;
    }

    /**
     * Obtiene la capacidad de carga del vehículo.
     *
     * @return Capacidad de carga en kg
     */
    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    /**
     * Establece la capacidad de carga del vehículo.
     *
     * @param capacidadCarga Nueva capacidad de carga en kg (debe ser mayor a 0)
     * @throws IllegalArgumentException si el parámetro es 0 o negativo
     */
    public void setCapacidadCarga(double capacidadCarga) {
        validarCampoDouble(capacidadCarga);
        this.capacidadCarga = capacidadCarga;
    }

    /**
     * Obtiene el estado actual del vehículo.
     *
     * @return Estado del vehículo (DISPONIBLE, EN_RUTA, MANTENIMIENTO)
     */
    public EstadoVehiculo getEstado() {
        return estado;
    }

    /**
     * Establece el estado del vehículo.
     *
     * @param estado Nuevo estado del vehículo
     */
    public void setEstado(EstadoVehiculo estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la distancia total recorrida por el vehículo.
     *
     * @return Distancia recorrida en km
     */
    public double getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    /**
     * Establece la distancia total recorrida por el vehículo.
     *
     * @param distanciaRecorrida Nueva distancia recorrida en km (debe ser mayor a 0)
     * @throws IllegalArgumentException si el parámetro es 0 o negativo
     */
    public void setDistanciaRecorrida(double distanciaRecorrida) {
        validarCampoDouble(distanciaRecorrida);
        this.distanciaRecorrida = distanciaRecorrida;
    }

    /**
     * Valida que un campo de tipo String no sea nulo o vacío.
     *
     * @param campo Campo a validar
     * @throws IllegalArgumentException si el campo es nulo o vacío
     */
    public void validarCampoString(String campo) {
        if (campo == null || campo.isBlank()) throw new IllegalArgumentException("El campo no puede ser nulo o vacio");
    }

    /**
     * Valida que un campo de tipo double sea mayor a 0.
     *
     * @param campo Campo a validar
     * @throws IllegalArgumentException si el campo es 0 o negativo
     */
    public void validarCampoDouble(double campo) {
        if (campo <= 0) throw new IllegalArgumentException("El campo no puede ser 0 o negativo");
    }

    /**
     * Retorna una representación en String del vehículo.
     *
     * @return String con la información del vehículo
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vehiculo{");
        sb.append("placa='").append(placa).append('\'');
        sb.append(", marca='").append(marca).append('\'');
        sb.append(", capacidadCarga=").append(capacidadCarga);
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Calcula el costo de envío para el vehículo.
     * Cada tipo de vehículo implementa su propia lógica de cálculo.
     *
     * @return Costo total del envío
     */
    public abstract double calcularCostoEnvio();
}
