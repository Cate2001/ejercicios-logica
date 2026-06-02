package com.cate.proyectos.poo.basico.orden.compra;

import java.util.Arrays;
import java.util.Date;

/**
 * Representa una orden de compra en el sistema.
 * <p>
 * Esta clase modela una transacción de compra que incluye información
 * de la orden, cliente asociado, fecha y lista de productos.
 * Administra un identificador único autoincremental.
 * </p>
 * <p>
 * Responsabilidades:
 * <ul>
 * <li>Administrar identificador único autoincremental</li>
 * <li>Almacenar descripción, fecha y cliente de la orden</li>
 * <li>Administrar lista de productos (capacidad máxima: 4)</li>
 * <li>Calcular el gran total de la orden</li>
 * <li>Validar límites de capacidad de productos</li>
 * </ul>
 * </p>
 *
 * @author Caterine Salinas Bolaños
 * @version 1.0
 */
public class OrdenCompra {
    /**
     * Contador estático para generar identificadores únicos.
     */
    private static int ultimoId = 0;

    /**
     * Identificador único de la orden.
     */
    private int identificador;

    /**
     * Descripción de la orden de compra.
     */
    private String descripcion;

    /**
     * Fecha de creación de la orden.
     */
    private Date fecha;

    /**
     * Cliente asociado a la orden.
     */
    private Cliente cliente;

    /**
     * Arreglo de productos en la orden.
     */
    private Producto[] productos;

    /**
     * Índice actual para agregar nuevos productos.
     */
    private int indice;


    /**
     * Constructor que inicializa una orden de compra.
     * <p>
     * Genera automáticamente un identificador único e inicializa
     * el arreglo de productos con capacidad máxima de 4.
     * </p>
     *
     * @param descripcion la descripción de la orden (no puede ser nula o vacía)
     * @throws IllegalArgumentException si la descripción es nula o vacía
     */
    public OrdenCompra( String descripcion){
        if (descripcion == null || descripcion.isBlank()){
            throw new IllegalArgumentException("La descripción es obligatoria");
        }
        this.descripcion = descripcion;
        this.productos = new Producto[4];
        this.identificador = ++ultimoId;
    }

    /**
     * Retorna el identificador único de la orden.
     *
     * @return el identificador de la orden
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * Retorna la descripción de la orden.
     *
     * @return la descripción de la orden
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Retorna la fecha de la orden.
     *
     * @return la fecha de la orden
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la orden.
     *
     * @param fecha la nueva fecha (no puede ser null)
     * @throws IllegalArgumentException si la fecha es null
     */
    public void setFecha(Date fecha) {
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha no puede ser null");
        }
        this.fecha = fecha;
    }

    /**
     * Retorna el cliente asociado a la orden.
     *
     * @return el cliente de la orden
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Establece el cliente de la orden.
     *
     * @param cliente el nuevo cliente (no puede ser null)
     * @throws IllegalArgumentException si el cliente es null
     */
    public void setCliente(Cliente cliente) {
        if (cliente == null){
            throw new IllegalArgumentException("El cliente no puede ser null");
        }
        this.cliente = cliente;
    }

    /**
     * Retorna el arreglo de productos de la orden.
     *
     * @return el arreglo de productos
     */
    public Producto[] getProductos() {
        return productos;
    }

    /**
     * Agrega un producto a la orden de compra.
     * <p>
     * Valida que el producto no sea null y que no se haya excedido
     * la capacidad máxima de productos (4).
     * </p>
     *
     * @param producto el producto a agregar
     * @throws IllegalArgumentException si el producto es null
     * @throws IllegalStateException si la capacidad máxima ha sido alcanzada
     */
    public void addProducto(Producto producto){
        if (producto == null){
            throw new IllegalArgumentException("El producto no puede ser null");
        }

        if (indice >= productos.length) {
            throw new IllegalStateException("Capacidad máxima de productos alcanzada (" + productos.length + ")");
        }

        productos[indice] = producto;
        indice++;
    }

    /**
     * Calcula el gran total de la orden de compra.
     * <p>
     * Suma los precios de todos los productos agregados a la orden.
     * Los productos null son ignorados en el cálculo.
     * </p>
     *
     * @return el gran total de la orden
     */
    public int calcularGranTotal() {
        int suma = 0;
        for (Producto p : productos) {
            if (p != null) suma += p.getPrecio();
        }
        return suma;
    }

    /**
     * Retorna una representación en cadena de la orden de compra.
     *
     * @return una cadena con la información completa de la orden
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrdenCompra{");
        sb.append("identificador=").append(identificador);
        sb.append(", descripcion='").append(descripcion).append('\'');
        sb.append(", fecha=").append(fecha);
        sb.append(", cliente=").append(cliente);
        sb.append(", productos=").append(Arrays.toString(productos));
        sb.append(", indice=").append(indice);
        sb.append('}');
        return sb.toString();
    }
}
