package proyectos_poo.poo_basico.orden_compra;

/**
 * Representa a un cliente en el sistema de órdenes de compra.
 * <p>
 * Esta clase modela la información básica de un cliente,
 * incluyendo su nombre y apellido.
 * </p>
 * <p>
 * Responsabilidades:
 * <ul>
 * <li>Almacenar nombre y apellido del cliente</li>
 * <li>Validar que nombre y apellido no sean nulos o vacíos</li>
 * </ul>
 * </p>
 *
 * @author Caterine Salinas Bolaños
 * @version 1.0
 */
public class Cliente {
    /**
     * Nombre del cliente.
     */
    private String nombre;

    /**
     * Apellido del cliente.
     */
    private String apellido;

    /**
     * Constructor que inicializa un cliente con nombre y apellido.
     *
     * @param nombre el nombre del cliente (no puede ser nulo o vacío)
     * @param apellido el apellido del cliente (no puede ser nulo o vacío)
     * @throws IllegalArgumentException si nombre o apellido son nulos o vacíos
     */
    public Cliente(String nombre, String apellido){
        if (nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException("Nombre es obligatorio");
        }
        if (apellido == null || apellido.isBlank()){
            throw new IllegalArgumentException("Apellido es obligatorio");
        }

        this.nombre = nombre;
        this.apellido = apellido;
    }

    /**
     * Retorna el nombre del cliente.
     *
     * @return el nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Retorna el apellido del cliente.
     *
     * @return el apellido del cliente
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Retorna una representación en cadena del cliente.
     *
     * @return una cadena con el nombre y apellido del cliente
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cliente{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", apellido='").append(apellido).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
