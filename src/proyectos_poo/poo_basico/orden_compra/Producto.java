package proyectos_poo.poo_basico.orden_compra;

/**
 * Representa un producto en el sistema de órdenes de compra.
 * <p>
 * Esta clase modela la información de un producto, incluyendo
 * su fabricante, nombre y precio.
 * </p>
 * <p>
 * Responsabilidades:
 * <ul>
 * <li>Almacenar fabricante, nombre y precio del producto</li>
 * <li>Validar que fabricante y nombre no sean nulos o vacíos</li>
 * <li>Validar que el precio no sea negativo</li>
 * </ul>
 * </p>
 *
 * @author Caterine Salinas Bolaños
 * @version 1.0
 */
public class Producto {
    /**
     * Fabricante del producto.
     */
    private String fabricante;

    /**
     * Nombre del producto.
     */
    private String nombre;

    /**
     * Precio del producto.
     */
    private int precio;

    /**
     * Constructor que inicializa un producto con fabricante, nombre y precio.
     *
     * @param fabricante el fabricante del producto (no puede ser nulo o vacío)
     * @param nombre el nombre del producto (no puede ser nulo o vacío)
     * @param precio el precio del producto (no puede ser negativo)
     * @throws IllegalArgumentException si fabricante o nombre son nulos/vacíos,
     *                                  o si el precio es negativo
     */
    public Producto(String fabricante, String nombre, int precio){
        if (fabricante == null || fabricante.isBlank()){
            throw new IllegalArgumentException("El fabricante es obligatorio");
        }

        if (nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException("El nombre es obligatorio");
        }

        if (precio < 0){
            throw new IllegalArgumentException("El precio no puede ser un valor negativo");
        }

        this.fabricante = fabricante;
        this.nombre = nombre;
        this.precio = precio;
    }

    /**
     * Retorna el fabricante del producto.
     *
     * @return el fabricante del producto
     */
    public String getFabricante() {
        return fabricante;
    }

    /**
     * Retorna el nombre del producto.
     *
     * @return el nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Retorna el precio del producto.
     *
     * @return el precio del producto
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Retorna una representación en cadena del producto.
     *
     * @return una cadena con la información completa del producto
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Producto{");
        sb.append("fabricante='").append(fabricante).append('\'');
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", precio=").append(precio);
        sb.append('}');
        return sb.toString();
    }
}
