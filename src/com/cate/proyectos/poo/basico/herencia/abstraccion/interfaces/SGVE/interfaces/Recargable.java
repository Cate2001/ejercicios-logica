package com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SGVE.interfaces;

/**
 * Interfaz que define la capacidad de recarga para vehículos eléctricos.
 * Los vehículos que implementan esta interfaz pueden recargar su batería.
 *
 * <p>Esta interfaz sigue el principio de segregación de interfaces (ISP),
 * permitiendo que solo los vehículos eléctricos (como drones) implementen esta funcionalidad.</p>
 *
 * @author SGVE Development Team
 * @version 1.0
 */
public interface Recargable {
    /**
     * Recarga la batería del vehículo al nivel máximo.
     */
    public void recargarBateria();
}
