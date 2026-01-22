package POO.orden_compra;

import java.util.Date;

public class EjemploOrdenes {
    public static void main(String[] args) {
        // =====================================================
        // 1. CREAR ORDEN
        // =====================================================
        OrdenCompra orden1 = new OrdenCompra("Primera compra prueba");
        orden1.setFecha(new Date());

        // =====================================================
        // 2. CREAR CLIENTE Y ASIGNARLO
        // =====================================================
        Cliente cliente1 = new Cliente("Cate", "Salinas");
        orden1.setCliente(cliente1);

        // =====================================================
        // 3. CREAR PRODUCTOS
        // =====================================================
        Producto producto1 = new Producto("LG", "T.V", 2_000_000);
        Producto producto2 = new Producto("Samsung", "Celular", 100_000);
        Producto producto3 = new Producto("Pulsar", "Moto", 20_000_000);
        Producto producto4 = new Producto("Yamaha", "Moto", 10_000_000);

        // =====================================================
        // 4. AGREGAR PRODUCTOS A LA ORDEN
        // =====================================================
        orden1.addProducto(producto1);
        orden1.addProducto(producto2);
        orden1.addProducto(producto3);
        orden1.addProducto(producto4);

        // =====================================================
        // 5. CALCULAR TOTAL
        // =====================================================
        int total = orden1.calcularGranTotal();
        System.out.println("TOTAL ORDEN 1: $" + total);

        // =====================================================
        // 6. IMPRIMIR DETALLES DE LA ORDEN
        // =====================================================
        System.out.println(orden1);

    }
}
