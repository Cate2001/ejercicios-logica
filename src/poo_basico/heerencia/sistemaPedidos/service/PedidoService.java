package POO.heerencia.sistemaPedidos.service;

import POO.heerencia.sistemaPedidos.model.Cliente;
import POO.heerencia.sistemaPedidos.model.Pago;
import POO.heerencia.sistemaPedidos.model.Pedido;

public class PedidoService {

    private void crearPedido(Cliente cliente, Pago pago, double total){
        if (cliente == null || pago == null) throw new IllegalArgumentException("No se admiten valores nulos");
        if (total <= 0) throw new IllegalArgumentException("Ingrese un valor mayor a 0");




    }
}
