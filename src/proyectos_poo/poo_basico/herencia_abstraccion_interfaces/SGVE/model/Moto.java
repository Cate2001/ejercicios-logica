package proyectos_poo.poo_basico.herencia_abstraccion_interfaces.SGVE.model;

import proyectos_poo.poo_basico.herencia_abstraccion_interfaces.SGVE.enums.EstadoVehiculo;
import proyectos_poo.poo_basico.herencia_abstraccion_interfaces.SGVE.interfaces.GPS;

public class Moto extends Vehiculo implements GPS {
    private int cilindraje;
    private double consumoGasolina;

    public Moto(String placa, String marca, double capacidadCarga, EstadoVehiculo estado, double distanciaRecorrida, int cilindraje, double consumoGasolina) {
        super(placa, marca, capacidadCarga, estado, distanciaRecorrida);
        setCilindraje(cilindraje);
        setConsumoGasolina(consumoGasolina);
        this.cilindraje = cilindraje;
        this.consumoGasolina = consumoGasolina;
    }

    public double getConsumoGasolina() {
        return consumoGasolina;
    }

    public void setConsumoGasolina(double consumoGasolina) {
        validarCampoDouble(consumoGasolina);
        this.consumoGasolina = consumoGasolina;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        validarCampoDouble(cilindraje);
        this.cilindraje = cilindraje;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Moto{");
        sb.append("cilindraje=").append(cilindraje);
        sb.append(", consumoGasolina=").append(consumoGasolina);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public double calcularCostoEnvio() {
        final double COSTO_BASE = 500000;
        double costo = getDistanciaRecorrida() * this.consumoGasolina + COSTO_BASE;

        return costo;
    }

    @Override
    public String obtenerUbicacion() {
        return "La moto esta en Bogotá";
    }
}
