package POO.heerencia.sistemaPedidos.model;

import javax.swing.plaf.PanelUI;

public class Pedido {
    private Cliente cliente;
    private Pago pago;
    private double total;

    public Pedido(Cliente cliente, Pago pago, double total) {
        this.cliente = cliente;
        this.pago = pago;
        if (total <= 0) throw new IllegalArgumentException("El valor ingresado no puede ser negativo o igual a 0. ingrese un valor mayor a 0");
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Pago getPago() {
        return pago;
    }

    public double getTotal() {
        return total;
    }

    public void mostrarDetalle(){
        System.out.println("=== Detalle del Pedido ===");
        System.out.println("Cliente: " + cliente);
        System.out.println("Tipo pago: " + pago);
        System.out.println("Total: " + total);
    }
}
