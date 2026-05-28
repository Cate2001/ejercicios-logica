package proyectos_poo.poo_basico.herencia_abstraccion.GestionPersonasUniversidad.model;

import proyectos_poo.poo_basico.herencia_abstraccion.GestionPersonasUniversidad.enums.TipoPersona;

/**
 * Representa a un profesor en el sistema de gestión universitaria.
 * <p>
 * Esta clase extiende de {@link Persona} y agrega la información específica
 * de un profesor, incluyendo la materia que imparte.
 * </p>
 * <p>
 * Responsabilidades:
 * <ul>
 * <li>Almacenar la materia que imparte el profesor</li>
 * <li>Validar que la materia no sea nula o vacía</li>
 * <li>Implementar la actividad específica de dar clases</li>
 * </ul>
 * </p>
 *
 * @author Caterine Salinas Bolaños
 * @version 1.0
 */
public class Profesor extends Persona{
    /**
     * Materia que imparte el profesor.
     * Debe ser validada para no ser nula o vacía.
     */
    private String materia;

    /**
     * Constructor que inicializa un profesor con nombre, edad, tipo y materia.
     *
     * @param nombre el nombre del profesor
     * @param edad la edad del profesor (debe ser >= 15)
     * @param tipoPersona el tipo de persona (debe ser PROFESOR)
     * @param materia la materia que imparte el profesor
     * @throws IllegalArgumentException si la materia es nula o vacía
     */
    public Profesor(String nombre, int edad, TipoPersona tipoPersona, String materia){
        super(nombre, edad, tipoPersona);
        setMateria(materia);
    }

    /**
     * Retorna la materia que imparte el profesor.
     *
     * @return la materia del profesor
     */
    public String getMateria() {
        return materia;
    }

    /**
     * Establece la materia que imparte el profesor.
     * <p>
     * Valida que la materia no sea nula o vacía antes de asignarla.
     * </p>
     *
     * @param materia la nueva materia del profesor
     * @throws IllegalArgumentException si la materia es nula o vacía
     */
    public void setMateria(String materia) {
        if (materia == null || materia.isBlank()){
            throw new IllegalArgumentException("El campo materia no puede estar vacio");
        }
        this.materia = materia;
    }

    /**
     * Implementación de la actividad específica de un profesor.
     * <p>
     * La actividad principal de un profesor es dar clases.
     * </p>
     */
    @Override
    public void actividad() {
        System.out.println("Dar clases");
    }

    /**
     * Retorna una representación en cadena del profesor.
     * <p>
     * Reutiliza el toString de la clase padre y agrega la información
     * de la materia.
     * </p>
     *
     * @return una cadena con la información completa del profesor
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(super.toString()); //Reutiliza el toString del padre
        sb.deleteCharAt(sb.length() -1); // Quita el último '}' del padre para "abrir" la cadena
        sb.append(", Materia = ").append(materia);
        sb.append('}');
        return sb.toString();
    }
}
