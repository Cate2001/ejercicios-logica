package proyectos_poo.poo_basico.herencia_abstraccion.fitlife.model;

import proyectos_poo.poo_basico.herencia_abstraccion.fitlife.enums.TipoMembresia;

/**
 * Representa un miembro VIP en el sistema de gimnasio FitLife.
 * <p>
 * Esta clase extiende de {@link Miembro} y agrega información específica
 * de un miembro VIP, incluyendo el nombre de su entrenador personal.
 * Aplica un cargo adicional de $50,000 por el servicio de entrenador personal.
 * </p>
 * <p>
 * Responsabilidades:
 * <ul>
 * <li>Almacenar el nombre del entrenador personal</li>
 * <li>Validar que el nombre del entrenador tenga al menos 3 caracteres</li>
 * <li>Calcular pago mensual con cargo adicional de entrenador personal</li>
 * <li>Definir beneficios exclusivos de membresía VIP</li>
 * </ul>
 * </p>
 *
 * @author Caterine Salinas Bolaños
 * @version 1.0
 */
public class MiembroVip extends Miembro{
    /**
     * Nombre del entrenador personal asignado.
     */
    private String nombreEntrenadorPersonal;

    /**
     * Constructor que inicializa un miembro VIP.
     *
     * @param nombre el nombre del miembro
     * @param cedula la cédula del miembro
     * @param edad la edad del miembro
     * @param membresia el tipo de membresía
     * @param nombreEntrenadorPersonal el nombre del entrenador personal (mínimo 3 caracteres)
     * @throws IllegalArgumentException si el nombre del entrenador es inválido
     */
    public MiembroVip(String nombre, String cedula, int edad, TipoMembresia membresia, String nombreEntrenadorPersonal) {
        super(nombre, cedula, edad, membresia);
        setNombreEntrenadorPersonal(nombreEntrenadorPersonal);
        this.nombreEntrenadorPersonal = nombreEntrenadorPersonal;
    }

    /**
     * Retorna el nombre del entrenador personal.
     *
     * @return el nombre del entrenador personal
     */
    public String getNombreEntrenadorPersonal() {
        return nombreEntrenadorPersonal;
    }

    /**
     * Establece el nombre del entrenador personal.
     *
     * @param nombreEntrenadorPersonal el nuevo nombre (mínimo 3 caracteres)
     * @throws IllegalArgumentException si el nombre es nulo, vacío o tiene menos de 3 caracteres
     */
    public void setNombreEntrenadorPersonal(String nombreEntrenadorPersonal) {
        if (nombreEntrenadorPersonal == null || nombreEntrenadorPersonal.isBlank()) {
            throw new IllegalArgumentException("El campo no puede estar vacio");
        }
        if (nombreEntrenadorPersonal.length() < 3){
            throw new IllegalArgumentException("El nombre debe tener minimo 3 caracteres");
        }
        this.nombreEntrenadorPersonal = nombreEntrenadorPersonal;
    }

    /**
     * Calcula el pago mensual del miembro VIP.
     * <p>
     * Agrega un cargo adicional de $50,000 por el servicio de
     * entrenador personal al precio de la membresía.
     * </p>
     *
     * @return el pago mensual con cargo de entrenador personal
     */
    @Override
    double calcularPagoMensual() {
        double precio = getMembresia().getPrecioConDescuento() + 50000;
        return precio;
    }

    /**
     * Retorna el tipo de miembro.
     *
     * @return "VIP"
     */
    @Override
    String getTipo() {
        return "VIP";
    }

    /**
     * Retorna los beneficios exclusivos de la membresía VIP.
     *
     * @return arreglo con los beneficios VIP disponibles
     */
    @Override
    String[] getBeneficios() {
        String[] beneficios = new  String[] {"Acceso 24/7", "Clases grupales", "Entrenador personal", "Toalla incluida", "Bebida proteica"};
        return beneficios;
    }

    /**
     * Retorna una representación en cadena del miembro VIP.
     *
     * @return una cadena con la información completa del miembro VIP
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.deleteCharAt(sb.length() - 1);
        sb.append(", MiembroVip ");
        sb.append(" nombreEntrenadorPersonal = '").append(nombreEntrenadorPersonal).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
