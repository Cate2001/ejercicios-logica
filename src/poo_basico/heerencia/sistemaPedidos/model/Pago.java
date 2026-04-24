package POO.heerencia.sistemaPedidos.model;

public abstract class Pago {
    private double monto;

    public Pago(double monto) {
        if (monto <= 0) throw new IllegalArgumentException("El monto no puede ser negativo o igual a cero. Por favor ingrese un valor mayor a 0");
        this.monto = monto;
    }

    public double getMonto() {
        return monto;
    }

    public abstract boolean procesarPago();
}
