package proyectos_poo.poo_basico.herencia_abstraccion_interfaces.SGVE.model;

import proyectos_poo.poo_basico.herencia_abstraccion_interfaces.SGVE.enums.EstadoVehiculo;
import proyectos_poo.poo_basico.herencia_abstraccion_interfaces.SGVE.interfaces.GPS;
import proyectos_poo.poo_basico.herencia_abstraccion_interfaces.SGVE.interfaces.Recargable;
import proyectos_poo.poo_basico.herencia_abstraccion_interfaces.SGVE.util.Constantes;

/**
 * Clase que representa un dron en el Sistema de Gestión de Vehículos de Envío (SGVE).
 * Extiende de Vehiculo e implementa las interfaces GPS y Recargable.
 *
 * <p>El dron es un vehículo aéreo no tripulado utilizado para envíos rápidos
 * en zonas de difícil acceso terrestre. Requiere batería para operar y tiene
 * capacidades de geolocalización.</p>
 *
 * @author SGVE Development Team
 * @version 1.0
 */
public class Dron extends Vehiculo implements GPS, Recargable {
    private int nivelBateria;
    private double alturaMaxima;
    private double consumoBateria;

    /**
     * Constructor de la clase Dron.
     *
     * @param placa Identificador único del dron (no puede ser nulo o vacío)
     * @param marca Fabricante del dron (no puede ser nulo o vacío)
     * @param capacidadCarga Capacidad máxima de carga en kg (debe ser mayor a 0)
     * @param estado Estado actual del dron (DISPONIBLE, EN_RUTA, MANTENIMIENTO)
     * @param distanciaRecorrida Distancia total recorrida en km (debe ser mayor a 0)
     * @param nivelBateria Nivel actual de batería en porcentaje (debe ser mayor a 0)
     * @param alturaMaxima Altura máxima de vuelo en metros (debe ser mayor a 0)
     * @param consumoBateria Consumo de batería por km (debe ser mayor a 0)
     */
    public Dron(String placa, String marca, double capacidadCarga, EstadoVehiculo estado, double distanciaRecorrida, int nivelBateria, double alturaMaxima, double consumoBateria) {
        super(placa, marca, capacidadCarga, estado, distanciaRecorrida);
        setNivelBateria(nivelBateria);
        setAlturaMaxima(alturaMaxima);
        setConsumoBateria(consumoBateria);
    }

    /**
     * Obtiene el nivel actual de batería del dron.
     *
     * @return Nivel de batería en porcentaje (0-100)
     */
    public int getNivelBateria() {
        return nivelBateria;
    }

    /**
     * Establece el nivel de batería del dron.
     *
     * @param nivelBateria Nuevo nivel de batería en porcentaje (debe ser mayor a 0)
     * @throws IllegalArgumentException si el parámetro es 0 o negativo
     */
    public void setNivelBateria(int nivelBateria) {
        validarCampoDouble(nivelBateria);
        this.nivelBateria = nivelBateria;
    }

    /**
     * Obtiene la altura máxima de vuelo del dron.
     *
     * @return Altura máxima en metros
     */
    public double getAlturaMaxima() {
        return alturaMaxima;
    }

    /**
     * Establece la altura máxima de vuelo del dron.
     *
     * @param alturaMaxima Nueva altura máxima en metros (debe ser mayor a 0)
     * @throws IllegalArgumentException si el parámetro es 0 o negativo
     */
    public void setAlturaMaxima(double alturaMaxima) {
        validarCampoDouble(alturaMaxima);
        this.alturaMaxima = alturaMaxima;
    }

    /**
     * Obtiene el consumo de batería por kilómetro del dron.
     *
     * @return Consumo de batería por km
     */
    public double getConsumoBateria() {
        return consumoBateria;
    }

    /**
     * Establece el consumo de batería por kilómetro del dron.
     *
     * @param consumoBateria Nuevo consumo de batería por km (debe ser mayor a 0)
     * @throws IllegalArgumentException si el parámetro es 0 o negativo
     */
    public void setConsumoBateria(double consumoBateria) {
        validarCampoDouble(consumoBateria);
        this.consumoBateria = consumoBateria;
    }

    /**
     * Calcula el costo de envío para el dron.
     * El costo se basa en la distancia recorrida, el consumo de batería y un costo base.
     *
     * @return Costo total del envío
     * @throws IllegalArgumentException si el nivel de batería es menor al 20%
     */
    @Override
    public double calcularCostoEnvio() {
        if (nivelBateria < 20) throw new IllegalArgumentException("El dron no tiene bateria suficiente");

        double costo = getDistanciaRecorrida() * this.consumoBateria + Constantes.COSTO_BASE;

        return costo;
    }

    /**
     * Obtiene la ubicación actual del dron mediante GPS.
     *
     * @return Ubicación actual del dron
     */
    @Override
    public String obtenerUbicacion() {
        return "El Dron esta en china";
    }

    /**
     * Recarga la batería del dron al nivel máximo.
     */
    @Override
    public void recargarBateria() {
        this.nivelBateria = Constantes.BATERIA_MAXIMA;
    }

    /**
     * Retorna una representación en String del dron.
     *
     * @return String con la información completa del dron
     */
    @Override
    public String toString() {
        return super.toString().replace("Vehiculo{", "Dron{")
               .replace("}", ", nivelBateria=" + nivelBateria + ", alturaMaxima=" + alturaMaxima + ", consumoBateria=" + consumoBateria + "}");
    }
}
