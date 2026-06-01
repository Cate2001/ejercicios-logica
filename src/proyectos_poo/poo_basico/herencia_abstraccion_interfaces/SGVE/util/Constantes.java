package proyectos_poo.poo_basico.herencia_abstraccion_interfaces.SGVE.util;

/**
 * Clase que contiene las constantes utilizadas en el Sistema de Gestión de Vehículos de Envío (SGVE).
 *
 * <p>Esta clase centraliza todos los valores constantes del sistema, facilitando su mantenimiento
 * y evitando la duplicación de valores mágicos en el código.</p>
 *
 * @author SGVE Development Team
 * @version 1.0
 */
public class Constantes {
    /**
     * Costo base aplicado a todos los envíos independientemente del tipo de vehículo.
     */
    public static final double COSTO_BASE = 5000;
    
    /**
     * Nivel máximo de batería que puede tener un vehículo eléctrico (100%).
     */
    public static final int  BATERIA_MAXIMA = 100;
    
    /**
     * Costo por kilómetro aplicado específicamente a los camiones.
     */
    public static final double COSTO_KM_CAMION = 3000;
}
