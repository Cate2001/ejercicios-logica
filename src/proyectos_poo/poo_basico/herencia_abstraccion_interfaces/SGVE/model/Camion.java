package proyectos_poo.poo_basico.herencia_abstraccion_interfaces.SGVE.model;

import proyectos_poo.poo_basico.herencia_abstraccion_interfaces.SGVE.enums.EstadoVehiculo;
import proyectos_poo.poo_basico.herencia_abstraccion_interfaces.SGVE.interfaces.GPS;

public class Camion extends Vehiculo implements GPS {
    private int numeroEjes;
    private double pesoActualCarga;
    private double costoPeajes;

    public Camion(String placa, String marca, double capacidadCarga, EstadoVehiculo estado, double distanciaRecorrida, int numeroEjes, double pesoActualCarga, double costoPeajes) {
        super(placa, marca, capacidadCarga, estado, distanciaRecorrida);
        setNumeroEjes(numeroEjes);
        setPesoActualCarga(pesoActualCarga);
        setCostoPeajes(costoPeajes);

        this.numeroEjes = numeroEjes;
        this.pesoActualCarga = pesoActualCarga;
        this.costoPeajes = costoPeajes;
    }

    public int getNumeroEjes() {
        return numeroEjes;
    }

    public void setNumeroEjes(int numeroEjes) {
        validarCampoDouble(numeroEjes);
        this.numeroEjes = numeroEjes;
    }

    public double getPesoActualCarga() {
        return pesoActualCarga;
    }

    public void setPesoActualCarga(double pesoActualCarga) {
        validarCampoDouble(pesoActualCarga);
        this.pesoActualCarga = pesoActualCarga;
    }

    public double getCostoPeajes() {
        return costoPeajes;
    }

    public void setCostoPeajes(double costoPeajes) {
        validarCampoDouble(costoPeajes);
        this.costoPeajes = costoPeajes;
    }

    @Override
    public double calcularCostoEnvio() {
        return 0;
    }

    @Override
    public String obtenerUbicacion() {
        return "";
    }
}
