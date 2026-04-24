package POO.heerencia.sistemaPedidos.service;

import POO.heerencia.sistemaPedidos.model.Pago;

public class PagoService {

    void procesarPago(Pago pago) {
        if (pago == null) throw new IllegalArgumentException("Debe ingrsar un pago");

        if (pago.procesarPago()){
            System.out.println("Pago exitoso");
        }else {
            System.out.println("Pago rechazado");
        }
    }

}
