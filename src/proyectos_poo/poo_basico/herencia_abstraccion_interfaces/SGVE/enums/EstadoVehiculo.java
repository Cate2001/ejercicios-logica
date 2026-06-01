package proyectos_poo.poo_basico.herencia_abstraccion_interfaces.SGVE.enums;

/**
 * Enum que representa los posibles estados de un vehículo en el sistema.
 *
 * <p>Los estados permiten controlar la disponibilidad y el flujo de trabajo
 * de los vehículos en el Sistema de Gestión de Vehículos de Envío (SGVE).</p>
 *
 * @author SGVE Development Team
 * @version 1.0
 */
public enum EstadoVehiculo {
    /**
     * El vehículo está disponible para realizar envíos.
     */
    DISPONIBLE,
    
    /**
     * El vehículo se encuentra actualmente en ruta realizando un envío.
     */
    EN_RUTA,
    
    /**
     * El vehículo está en mantenimiento y no está disponible para envíos.
     */
    MANTENIMIENTO;
}
