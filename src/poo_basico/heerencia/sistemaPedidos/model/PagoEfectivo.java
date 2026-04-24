package POO.heerencia.sistemaPedidos.model;

public class PagoEfectivo extends Pago{
    private double dineroRecibido;

    public PagoEfectivo(double monto, double dineroRecibido) {
        super(monto);
        if (dineroRecibido <= 0) throw new IllegalArgumentException("El valor ingresado no puede ser negativo o igual a 0. ingrese un valor mayor a 0");
        this.dineroRecibido = dineroRecibido;
    }

    public double getDineroRecibido() {
        return dineroRecibido;
    }

    @Override
    public boolean procesarPago() {
        return dineroRecibido >= getMonto();
    }
}
