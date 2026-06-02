package com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SGVE.interfaces;

/**
 * Interfaz que define la capacidad de geolocalización para vehículos.
 * Los vehículos que implementan esta interfaz pueden proporcionar su ubicación actual.
 *
 * <p>Esta interfaz sigue el principio de segregación de interfaces (ISP),
 * permitiendo que solo los vehículos que requieren geolocalización implementen esta funcionalidad.</p>
 *
 * @author SGVE Development Team
 * @version 1.0
 */
public interface GPS {

    /**
     * Obtiene la ubicación actual del vehículo.
     *
     * @return String con la ubicación actual del vehículo
     */
    public String obtenerUbicacion();

}
