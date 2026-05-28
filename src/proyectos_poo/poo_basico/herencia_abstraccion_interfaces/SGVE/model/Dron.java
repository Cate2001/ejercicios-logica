package proyectos_poo.poo_basico.herencia_abstraccion_interfaces.SGVE.model;

import proyectos_poo.poo_basico.herencia_abstraccion_interfaces.SGVE.enums.EstadoVehiculo;
import proyectos_poo.poo_basico.herencia_abstraccion_interfaces.SGVE.interfaces.GPS;
import proyectos_poo.poo_basico.herencia_abstraccion_interfaces.SGVE.interfaces.Recargable;

public class Dron extends Vehiculo implements GPS, Recargable {
    private int nivelBateria;
    private double alturaMaxima;
    private double consumoBateria;

    public Dron(String placa, String marca, double capacidadCarga, EstadoVehiculo estado, double distanciaRecorrida, int nivelBateria, double alturaMaxima, double consumoBateria) {
        super(placa, marca, capacidadCarga, estado, distanciaRecorrida);
        setNivelBateria(nivelBateria);
        setAlturaMaxima(alturaMaxima);
        setConsumoBateria(consumoBateria);
        this.nivelBateria = nivelBateria;
        this.alturaMaxima = alturaMaxima;
        this.consumoBateria = consumoBateria;
    }

    public int getNivelBateria() {
        return nivelBateria;
    }

    public void setNivelBateria(int nivelBateria) {
        validarCampoDouble(nivelBateria);
        this.nivelBateria = nivelBateria;
    }

    public double getAlturaMaxima() {
        return alturaMaxima;
    }

    public void setAlturaMaxima(double alturaMaxima) {
        validarCampoDouble(alturaMaxima);
        this.alturaMaxima = alturaMaxima;
    }

    public double getConsumoBateria() {
        return consumoBateria;
    }

    public void setConsumoBateria(double consumoBateria) {
        validarCampoDouble(consumoBateria);
        this.consumoBateria = consumoBateria;
    }

    @Override
    public double calcularCostoEnvio() {
        if (nivelBateria < 20) throw new IllegalArgumentException("El dron no tiene bateria suficiente");

        final double COSTO_BASE = 500000;
        double costo = getDistanciaRecorrida() * this.consumoBateria + COSTO_BASE;

        return costo;
    }

    @Override
    public String obtenerUbicacion() {
        return "El Dron esta en china";
    }

    @Override
    public void recargarBateria() {
        this.nivelBateria = 100;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dron{");
        sb.append("nivelBateria=").append(nivelBateria);
        sb.append(", alturaMaxima=").append(alturaMaxima);
        sb.append(", consumoBateria=").append(consumoBateria);
        sb.append('}');
        return sb.toString();
    }
}
