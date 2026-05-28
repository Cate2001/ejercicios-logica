package proyectos_poo.poo_basico.herencia_abstraccion_interfaces.SGVE.model;

import proyectos_poo.poo_basico.herencia_abstraccion_interfaces.SGVE.enums.EstadoVehiculo;

public abstract class Vehiculo {
    private String placa;
    private String marca;
    private double capacidadCarga;
    private EstadoVehiculo estado;
    private double distanciaRecorrida;

    public Vehiculo(String placa, String marca, double capacidadCarga, EstadoVehiculo estado, double distanciaRecorrida) {
        setPlaca(placa);
        setMarca(marca);
        setCapacidadCarga(capacidadCarga);
        setEstado(estado);
        setDistanciaRecorrida(distanciaRecorrida);
        this.placa = placa;
        this.marca = marca;
        this.capacidadCarga = capacidadCarga;
        this.estado = estado;
        this.distanciaRecorrida = distanciaRecorrida;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        validarCampoString(placa);
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        validarCampoString(marca);
        this.marca = marca;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        validarCampoDouble(capacidadCarga);
        this.capacidadCarga = capacidadCarga;
    }

    public EstadoVehiculo getEstado() {
        return estado;
    }

    public void setEstado(EstadoVehiculo estado) {
        this.estado = estado;
    }

    public double getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public void setDistanciaRecorrida(double distanciaRecorrida) {
        validarCampoDouble(distanciaRecorrida);
        this.distanciaRecorrida = distanciaRecorrida;
    }

    //Metodo validar informacion de entrada
    public void validarCampoString(String campo) {
        if (campo == null || campo.isBlank()) throw new IllegalArgumentException("El campo no puede ser nulo o vacio");
    }

    //Metodo validar informacion de entrada
    public void validarCampoDouble(double campo) {
        if (campo <= 0) throw new IllegalArgumentException("El campo no puede ser 0 o negativo");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vehiculo{");
        sb.append("placa='").append(placa).append('\'');
        sb.append(", marca='").append(marca).append('\'');
        sb.append(", capacidadCarga=").append(capacidadCarga);
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }

    public abstract double calcularCostoEnvio();
}
