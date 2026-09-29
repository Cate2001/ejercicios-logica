package com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SGVE.model;

import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SGVE.enums.EstadoVehiculo;
import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SGVE.interfaces.GPS;
import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SGVE.util.Constantes;

/**
 * Clase que representa un camión en el Sistema de Gestión de Vehículos de Envío (SGVE).
 * Extiende de Vehiculo e implementa la interfaz GPS.
 *
 * <p>El camión es un vehículo terrestre de gran capacidad utilizado para envíos
 * de carga pesada y larga distancia. Es ideal para transporte interurbano y
 * logística de grandes volúmenes.</p>
 *
 * @author SGVE Development Team
 * @version 1.0
 */
public class Camion extends Vehiculo implements GPS {
    private int numeroEjes;
    private double pesoActualCarga;
    private double costoPeajes;

    /**
     * Constructor de la clase Camion.
     *
     * @param placa Identificador único del camión (no puede ser nulo o vacío)
     * @param marca Fabricante del camión (no puede ser nulo o vacío)
     * @param capacidadCarga Capacidad máxima de carga en kg (debe ser mayor a 0)
     * @param estado Estado actual del camión (DISPONIBLE, EN_RUTA, MANTENIMIENTO)
     * @param distanciaRecorrida Distancia total recorrida en km (debe ser mayor a 0)
     * @param numeroEjes Número de ejes del camión (debe ser mayor a 0)
     * @param pesoActualCarga Peso actual de la carga en kg (debe ser mayor a 0)
     * @param costoPeajes Costo total de peajes (debe ser mayor a 0)
     */
    public Camion(String placa, String marca, double capacidadCarga, EstadoVehiculo estado, double distanciaRecorrida, int numeroEjes, double pesoActualCarga, double costoPeajes) {
        super(placa, marca, capacidadCarga, estado, distanciaRecorrida);
        setNumeroEjes(numeroEjes);
        setPesoActualCarga(pesoActualCarga);
        setCostoPeajes(costoPeajes);
    }

    /**
     * Obtiene el número de ejes del camión.
     *
     * @return Número de ejes
     */
    public int getNumeroEjes() {
        return numeroEjes;
    }

    /**
     * Establece el número de ejes del camión.
     *
     * @param numeroEjes Nuevo número de ejes (debe ser mayor a 0)
     * @throws IllegalArgumentException si el parámetro es 0 o negativo
     */
    public void setNumeroEjes(int numeroEjes) {
        validarCampoDouble(numeroEjes);
        this.numeroEjes = numeroEjes;
    }

    /**
     * Obtiene el peso actual de la carga del camión.
     *
     * @return Peso actual de la carga en kg
     */
    public double getPesoActualCarga() {
        return pesoActualCarga;
    }

    /**
     * Establece el peso actual de la carga del camión.
     *
     * @param pesoActualCarga Nuevo peso de carga en kg (debe ser mayor a 0)
     * @throws IllegalArgumentException si el parámetro es 0 o negativo
     */
    public void setPesoActualCarga(double pesoActualCarga) {
        validarCampoDouble(pesoActualCarga);
        this.pesoActualCarga = pesoActualCarga;
    }

    /**
     * Obtiene el costo total de peajes del camión.
     *
     * @return Costo total de peajes
     */
    public double getCostoPeajes() {
        return costoPeajes;
    }

    /**
     * Establece el costo total de peajes del camión.
     *
     * @param costoPeajes Nuevo costo de peajes (debe ser mayor a 0)
     * @throws IllegalArgumentException si el parámetro es 0 o negativo
     */
    public void setCostoPeajes(double costoPeajes) {
        validarCampoDouble(costoPeajes);
        this.costoPeajes = costoPeajes;
    }

    /**
     * Calcula el costo de envío para el camión.
     * El costo se basa en la distancia recorrida, el costo por kilómetro,
     * los peajes y un costo base.
     *
     * @return Costo total del envío
     */
    @Override
    public double calcularCostoEnvio() {
        double costo = (getDistanciaRecorrida() * Constantes.COSTO_KM_CAMION) + this.costoPeajes + Constantes.COSTO_BASE;
        return costo;
    }

    /**
     * Obtiene la ubicación actual del camión mediante GPS.
     *
     * @return Ubicación actual del camión
     */
    @Override
    public String obtenerUbicacion() {
        return "La ubicación del camión es Barranquilla.";
    }

    /**
     * Retorna una representación en String del camión.
     *
     * @return String con la información completa del camión
     */
    @Override
    public String toString() {
        return super.toString().replace("Vehiculo{", "Camion{")
               .replace("}", ", numeroEjes=" + numeroEjes + ", pesoActualCarga=" + pesoActualCarga + ", costoPeajes=" + costoPeajes + "}");
    }
}
