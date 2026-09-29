package com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SGVE.services;

import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SGVE.enums.EstadoVehiculo;
import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SGVE.model.Vehiculo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase de servicio para la gestión de vehículos en el Sistema de Gestión de Vehículos de Envío (SGVE).
 * Proporciona funcionalidades para registrar, consultar y calcular costos de envío de vehículos.
 *
 * <p>Esta clase implementa el patrón Service Layer, centralizando la lógica de negocio
 * relacionada con la gestión de vehículos.</p>
 *
 * @author SGVE Development Team
 * @version 1.0
 */
public class VehiculoService {
    private final List<Vehiculo> vehiculos = new ArrayList<>();

    /**
     * Registra un nuevo vehículo en el sistema.
     *
     * @param vehiculo Vehículo a registrar (no puede ser nulo)
     * @return true si el vehículo fue registrado exitosamente
     * @throws IllegalArgumentException si el vehículo es nulo o si se excede la capacidad máxima
     */
    public boolean registrarVehiculo(Vehiculo vehiculo) {
        if (vehiculo == null) throw new IllegalArgumentException("El vehiculo no puede ser null");
        vehiculos.add(vehiculo);
        return true;
    }

    /**
     * Muestra todos los vehículos registrados en el sistema.
     *
     * @throws IllegalArgumentException si no hay vehículos registrados
     */
    public void mostrarVehiculos() {
        if (vehiculos.isEmpty()) throw new IllegalArgumentException("No hay vehiculos registrados");
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo != null) {
                System.out.println(vehiculo);
            }
        }
    }


    /**
     * Calcula el costo de envío para un vehículo específico.
     *
     * @param vehiculo Vehículo para calcular el costo (no puede ser nulo)
     * @return Costo total del envío
     * @throws IllegalArgumentException si el vehículo es nulo
     */
    public double calcularCostos(Vehiculo vehiculo) {
        if (vehiculo == null) throw new IllegalArgumentException("El vehiculo no puede ser null");
        return vehiculo.calcularCostoEnvio();
    }

    /**
     * Muestra solo los vehículos que se encuentran en estado DISPONIBLE.
     *
     * @throws IllegalArgumentException si no hay vehículos registrados
     */
    public void mostrarDisponibles() {
        if (vehiculos.isEmpty()) throw new IllegalArgumentException("No hay vehiculos registrados");
        for (Vehiculo vehiculo : vehiculos){
            if (vehiculo != null) {
                if (vehiculo.getEstado() == EstadoVehiculo.DISPONIBLE){
                    System.out.println(vehiculo);
                }
            }
        }
    }

    /**
     * Busca un vehículo por su número de placa.
     *
     * @param placa Placa del vehículo a buscar (no puede ser nulo o vacío)
     * @return Vehículo encontrado o null si no existe
     * @throws IllegalArgumentException si la placa es nula o vacía
     */
    public Vehiculo buscarPorPlaca(String placa) {
        if (placa == null || placa.isBlank()) throw new IllegalArgumentException("El campo no puede ser nulo o estar vacio");
        for (Vehiculo vehiculo : vehiculos){
            if (vehiculo != null) {
                if (vehiculo.getPlaca().equals(placa)) {
                    return vehiculo;
                }
            }
        }
        return null;
    }
}
