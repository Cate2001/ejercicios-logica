package proyectos_poo.poo_basico.herencia_abstraccion_interfaces.fitlife.model;

import proyectos_poo.poo_basico.herencia_abstraccion_interfaces.fitlife.enums.TipoMembresia;

/**
 * Representa un miembro estudiantil en el sistema de gimnasio FitLife.
 * <p>
 * Esta clase extiende de {@link Miembro} y agrega información específica
 * de un miembro estudiantil, incluyendo su universidad y semestre actual.
 * Aplica un descuento adicional del 10% sobre el precio de la membresía.
 * </p>
 * <p>
 * Responsabilidades:
 * <ul>
 * <li>Almacenar información universitaria (universidad, semestre)</li>
 * <li>Validar que la universidad tenga al menos 3 caracteres</li>
 * <li>Validar que el semestre esté entre 1 y 10</li>
 * <li>Calcular pago mensual con descuento estudiantil adicional</li>
 * <li>Definir beneficios específicos de membresía estudiantil</li>
 * </ul>
 * </p>
 *
 * @author Caterine Salinas Bolaños
 * @version 1.0
 */
public class MiembroEstudiantil extends Miembro {
    /**
     * Universidad donde estudia el miembro.
     */
    private String universidad;

    /**
     * Semestre actual del estudiante (1-10).
     */
    private int semestre;

    /**
     * Constructor que inicializa un miembro estudiantil.
     *
     * @param nombre el nombre del miembro
     * @param cedula la cédula del miembro
     * @param edad la edad del miembro
     * @param membresia el tipo de membresía
     * @param universidad la universidad (mínimo 3 caracteres)
     * @param semestre el semestre actual (1-10)
     * @throws IllegalArgumentException si la universidad es inválida o el semestre fuera de rango
     */
    public MiembroEstudiantil(String nombre, String cedula, int edad, TipoMembresia membresia, String universidad, int semestre) {
        super(nombre, cedula, edad, membresia);
        validarCampoUniversidad(universidad);
        validarCampoSemetre(semestre);
        this.universidad = universidad;
        this.semestre = semestre;

    }

    /**
     * Valida que el campo de universidad no sea nulo, vacío o tenga menos de 3 caracteres.
     *
     * @param campo el campo universidad a validar
     * @throws IllegalArgumentException si el campo es inválido
     */
    private void validarCampoUniversidad(String campo) {
        if (campo == null || campo.isBlank()) {
            throw new IllegalArgumentException("El campo no puede estar vacio o nulo");
        }
        if (campo.length() < 3) {
            throw new IllegalArgumentException("El campo debe tener minimo 3 caracteres");
        }
    }

    /**
     * Valida que el semestre esté en el rango permitido (1-10).
     *
     * @param campo el semestre a validar
     * @throws IllegalArgumentException si el semestre está fuera de rango
     */
    private void validarCampoSemetre(int campo) {
        if (campo < 1 || campo > 10) {
            throw new IllegalArgumentException("El rango del semestre debe ser entre 1 y 10");
        }
    }

    /**
     * Calcula el pago mensual del miembro estudiantil.
     * <p>
     * Aplica un descuento adicional del 10% sobre el precio con descuento
     * de la membresía base.
     * </p>
     *
     * @return el pago mensual con descuento estudiantil aplicado
     */
    @Override
    double calcularPagoMensual() {
        double precio = getMembresia().getPrecioConDescuento();
        double descuento = precio * (10/100);
        double precioFinal = precio - descuento;
        return precioFinal;
    }

    /**
     * Retorna el tipo de miembro.
     *
     * @return "Estudiantil"
     */
    @Override
    String getTipo() {
        return "Estudiantil";
    }

    /**
     * Retorna los beneficios específicos de la membresía estudiantil.
     *
     * @return arreglo con los beneficios disponibles
     */
    @Override
    String[] getBeneficios() {
        String[] beneficio = new String[] {"Acceso Lunes-Viernes", "Descuento estudiantil 10% extra"};
        return beneficio;
    }

    /**
     * Retorna una representación en cadena del miembro estudiantil.
     *
     * @return una cadena con la información completa del miembro estudiantil
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.deleteCharAt(sb.length() - 1);
        sb.append(", MiembroEstudiantil ");
        sb.append(", universidad='").append(universidad).append('\'');
        sb.append(", Semestre=").append(semestre);
        sb.append('}');
        return sb.toString();
    }
}
