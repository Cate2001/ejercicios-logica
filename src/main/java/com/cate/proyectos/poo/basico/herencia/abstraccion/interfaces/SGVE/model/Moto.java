package com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SGVE.model;

import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SGVE.enums.EstadoVehiculo;
import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SGVE.interfaces.GPS;
import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SGVE.util.Constantes;

/**
 * Clase que representa una motocicleta en el Sistema de Gestión de Vehículos de Envío (SGVE).
 * Extiende de Vehiculo e implementa la interfaz GPS.
 *
 * <p>La motocicleta es un vehículo terrestre utilizado para envíos rápidos
 * en zonas urbanas. Es ideal para entregas de último kilómetro debido a su
 * maniobrabilidad y capacidad de acceso a áreas restringidas para vehículos grandes.</p>
 *
 * @author SGVE Development Team
 * @version 1.0
 */
public class Moto extends Vehiculo implements GPS {
    private int cilindraje;
    private double consumoGasolina;

    /**
     * Constructor de la clase Moto.
     *
     * @param placa Identificador único de la moto (no puede ser nulo o vacío)
     * @param marca Fabricante de la moto (no puede ser nulo o vacío)
     * @param capacidadCarga Capacidad máxima de carga en kg (debe ser mayor a 0)
     * @param estado Estado actual de la moto (DISPONIBLE, EN_RUTA, MANTENIMIENTO)
     * @param distanciaRecorrida Distancia total recorrida en km (debe ser mayor a 0)
     * @param cilindraje Cilindraje del motor en cc (debe ser mayor a 0)
     * @param consumoGasolina Consumo de gasolina por km (debe ser mayor a 0)
     */
    public Moto(String placa, String marca, double capacidadCarga, EstadoVehiculo estado, double distanciaRecorrida, int cilindraje, double consumoGasolina) {
        super(placa, marca, capacidadCarga, estado, distanciaRecorrida);
        setCilindraje(cilindraje);
        setConsumoGasolina(consumoGasolina);
    }

    /**
     * Obtiene el consumo de gasolina por kilómetro de la moto.
     *
     * @return Consumo de gasolina por km
     */
    public double getConsumoGasolina() {
        return consumoGasolina;
    }

    /**
     * Establece el consumo de gasolina por kilómetro de la moto.
     *
     * @param consumoGasolina Nuevo consumo de gasolina por km (debe ser mayor a 0)
     * @throws IllegalArgumentException si el parámetro es 0 o negativo
     */
    public void setConsumoGasolina(double consumoGasolina) {
        validarCampoDouble(consumoGasolina);
        this.consumoGasolina = consumoGasolina;
    }

    /**
     * Obtiene el cilindraje del motor de la moto.
     *
     * @return Cilindraje en centímetros cúbicos (cc)
     */
    public int getCilindraje() {
        return cilindraje;
    }

    /**
     * Establece el cilindraje del motor de la moto.
     *
     * @param cilindraje Nuevo cilindraje en cc (debe ser mayor a 0)
     * @throws IllegalArgumentException si el parámetro es 0 o negativo
     */
    public void setCilindraje(int cilindraje) {
        validarCampoDouble(cilindraje);
        this.cilindraje = cilindraje;
    }

    /**
     * Retorna una representación en String de la moto.
     *
     * @return String con la información completa de la moto
     */
    @Override
    public String toString() {
        return super.toString().replace("Vehiculo{", "Moto{")
               .replace("}", ", cilindraje=" + cilindraje + ", consumoGasolina=" + consumoGasolina + "}");
    }

    /**
     * Calcula el costo de envío para la moto.
     * El costo se basa en la distancia recorrida, el consumo de gasolina y un costo base.
     *
     * @return Costo total del envío
     */
    @Override
    public double calcularCostoEnvio() {
        double costo = getDistanciaRecorrida() * this.consumoGasolina + Constantes.COSTO_BASE;

        return costo;
    }

    /**
     * Obtiene la ubicación actual de la moto mediante GPS.
     *
     * @return Ubicación actual de la moto
     */
    @Override
    public String obtenerUbicacion() {
        return "La moto esta en Bogotá";
    }
}
