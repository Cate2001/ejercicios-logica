package proyectos_poo.poo_basico.herencia_abstraccion.GestionPersonasUniversidad.model;
import proyectos_poo.poo_basico.herencia_abstraccion.GestionPersonasUniversidad.enums.TipoPersona;

/**
 * Clase base que representa a una persona en el sistema de gestión universitaria.
 * <p>
 * Esta clase abstracta define los atributos y comportamientos comunes
 * a todas las personas en el sistema (estudiantes y profesores).
 * Implementa validaciones de dominio para nombre y edad.
 * </p>
 * <p>
 * Responsabilidades:
 * <ul>
 * <li>Almacenar información básica de la persona (nombre, edad, tipo)</li>
 * <li>Validar que el nombre no sea nulo o vacío</li>
 * <li>Validar que la edad sea mayor o igual a 15 años</li>
 * <li>Definir el método abstracto {@link #actividad()}</li>
 * </ul>
 * </p>
 *
 * @author Caterine Salinas Bolaños
 * @version 1.0
 */
public class Persona {
    /**
     * Nombre de la persona.
     * Debe ser validado para no ser nulo o vacío.
     */
    private String nombre;

    /**
     * Edad de la persona.
     * Debe ser mayor o igual a 15 años según las políticas de la universidad.
     */
    private int edad;

    /**
     * Tipo de persona (ESTUDIANTE o PROFESOR).
     * Es inmutable ya que el tipo de una persona no cambia.
     */
    private final TipoPersona tipoPersona;

    /**
     * Constructor que inicializa una persona con nombre, edad y tipo.
     *
     * @param nombre el nombre de la persona (no puede ser nulo o vacío)
     * @param edad la edad de la persona (debe ser >= 15)
     * @param tipoPersona el tipo de persona (ESTUDIANTE o PROFESOR)
     * @throws IllegalArgumentException si el nombre es nulo o vacío,
     *                                  o si la edad es menor a 15
     */
    public Persona(String nombre, int edad, TipoPersona tipoPersona){
        setNombre(nombre);
        setEdad(edad);
        this.tipoPersona = tipoPersona;
    }

    /**
     * Retorna el nombre de la persona.
     *
     * @return el nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     * <p>
     * Valida que el nombre no sea nulo o vacío antes de asignarlo.
     * </p>
     *
     * @param nombre el nuevo nombre de la persona
     * @throws IllegalArgumentException si el nombre es nulo o vacío
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException("Debe ingresar un nombre");
        }
        this.nombre = nombre;
    }

    /**
     * Retorna la edad de la persona.
     *
     * @return la edad de la persona
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad de la persona.
     * <p>
     * Valida que la edad sea mayor o igual a 15 años según las
     * políticas de la universidad.
     * </p>
     *
     * @param edad la nueva edad de la persona
     * @throws IllegalArgumentException si la edad es menor a 15
     */
    public void setEdad(int edad) {
        if (edad < 15){
            throw new IllegalArgumentException("La edad debe ser mayor o igual a 15 años");
        }
        this.edad = edad;
    }

    /**
     * Retorna el tipo de persona.
     *
     * @return el tipo de persona (ESTUDIANTE o PROFESOR)
     */
    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    /**
     * Método abstracto que define la actividad específica de la persona.
     * <p>
     * Cada subclase (Estudiante, Profesor) debe implementar su propia
     * actividad específica.
     * </p>
     */
    public void actividad(){
        System.out.println("Actividad");
    }

    /**
     * Retorna una representación en cadena de la persona.
     *
     * @return una cadena con el nombre, edad y tipo de persona
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Persona {");
        sb.append("Nombre= '").append(nombre).append('\'');
        sb.append(", Edad= ").append(edad);
        sb.append(", Tipo persona= ").append(tipoPersona);
        sb.append('}');
        return sb.toString();
    }
}
