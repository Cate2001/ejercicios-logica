package POO.heerencia.sistemaPedidos.model;

public class PagoTarjeta extends Pago{
    private String numeroTarjeta;

    public PagoTarjeta(double monto, String numeroTarjeta) {
        super(monto);
        if (numeroTarjeta == null || numeroTarjeta.isBlank()) throw  new IllegalArgumentException("El valor no puede ser nulo o en blanco");
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    @Override
    public boolean procesarPago() {
        return true;
    }
}
