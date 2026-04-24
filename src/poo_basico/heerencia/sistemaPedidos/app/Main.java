package POO.heerencia.sistemaPedidos.app;

import POO.heerencia.sistemaPedidos.model.Cliente;
import POO.heerencia.sistemaPedidos.model.Pago;
import POO.heerencia.sistemaPedidos.model.PagoEfectivo;
import POO.heerencia.sistemaPedidos.model.Pedido;

public class Main {
    static void main() {
        Cliente cliente = new Cliente("Caterine", "138990138130");
        Pago pago1 = new PagoEfectivo(800.000, 1200.000);

        if (pago1.procesarPago()){
            System.out.println("Pago exitoso");
        }else {
            System.out.println("¡Saldo insuficiente! " + " valor a pagar: " + pago1.getMonto() + " saldo disponible: ");
        }

        Pedido pedido = new Pedido(cliente, pago1, 800.000);

        pedido.mostrarDetalle();





    }
}
