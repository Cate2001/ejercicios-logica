package proyectos_poo.poo_basico.herencia_abstraccion.SportifyTech.model;

/**
 * Representa a entrenador en el sistema deportivo SportifyTech.
 * <p>
 * Esta clase extiende de {@link Persona} y agrega información específica
 * de un entrenador, incluyendo su especialidad deportiva, años de experiencia
 * y la lista de competidores que entrena.
 * </p>
 * <p>
 * Responsabilidades:
 * <ul>
 * <li>Almacenar la especialidad deportiva del entrenador</li>
 * <li>Administrar la lista de competidores asignados (máximo 10)</li>
 * <li>Validar experiencia mínima (2 años)</li>
 * <li>Calcular credibilidad física basada en métricas de salud</li>
 * <li>Asignar y eliminar competidores de su lista</li>
 * </ul>
 * </p>
 *
 * @author Caterine Salinas Bolaños
 * @version 1.0
 */
public class Entrenador extends Persona {
    /**
     * Especialidad deportiva del entrenador.
     */
    private String especialidadDeportiva;

    /**
     * Años de experiencia del entrenador.
     */
    private int aniosExperiencia;

    /**
     * Arreglo de competidores asignados al entrenador.
     */
    private Competidor[] listaDeCompetidores;

    /**
     * Capacidad máxima de competidores que puede entrenar.
     */
    private static final int MAX_COMPETIDORES = 10;

    /**
     * Cantidad actual de competidores asignados.
     */
    private int cantidadCompetidores = 0;

    /**
     * Constructor que inicializa un entrenador con todos sus atributos.
     *
     * @param nombre el nombre del entrenador
     * @param apellidos los apellidos del entrenador
     * @param edad la edad en años
     * @param vasosDeAgua la cantidad de vasos de agua consumidos
     * @param peso el peso en kilogramos
     * @param estatura la estatura en metros
     * @param especialidadDeportiva la especialidad deportiva
     * @param aniosExperiencia los años de experiencia (debe ser >= 2)
     * @throws IllegalArgumentException si la especialidad es null o experiencia < 2
     */
    public Entrenador(String nombre, String apellidos, int edad, int vasosDeAgua, double peso, double estatura, String especialidadDeportiva,
                      int aniosExperiencia) {
        super(nombre, apellidos, edad, vasosDeAgua, peso, estatura);
        setEspecialidadDeportiva(especialidadDeportiva);
        setAniosExperiencia(aniosExperiencia);
        this.listaDeCompetidores = new Competidor[MAX_COMPETIDORES];
        this.cantidadCompetidores = 0;
    }

    /**
     * Retorna la especialidad deportiva del entrenador.
     *
     * @return la especialidad deportiva
     */
    public String getEspecialidadDeportiva() {
        return especialidadDeportiva;
    }

    /**
     * Establece la especialidad deportiva del entrenador.
     *
     * @param especialidadDeportiva la nueva especialidad
     * @throws IllegalArgumentException si la especialidad es null
     */
    public void setEspecialidadDeportiva(String especialidadDeportiva) {
        if (especialidadDeportiva == null){
            throw new IllegalArgumentException("La especialidad no puede ir nula");
        }
        this.especialidadDeportiva = especialidadDeportiva;
    }

    /**
     * Retorna los años de experiencia del entrenador.
     *
     * @return los años de experiencia
     */
    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    /**
     * Establece los años de experiencia del entrenador.
     *
     * @param aniosExperiencia los nuevos años de experiencia (debe ser >= 2)
     * @throws IllegalArgumentException si la experiencia es menor a 2 años
     */
    public void setAniosExperiencia(int aniosExperiencia) {
        if (aniosExperiencia < 2){
            throw new IllegalArgumentException("El entrenador no cumple con el minimo valor de años de experiencia");
        }
        this.aniosExperiencia = aniosExperiencia;
    }

    /**
     * Busca si un competidor ya está asignado al entrenador.
     *
     * @param competidor el competidor a buscar
     * @return true si el competidor ya está asignado, false en caso contrario
     * @throws IllegalArgumentException si el competidor es null
     */
    private boolean buscarCompetidor(Competidor competidor){
        if (competidor == null){
            throw new IllegalArgumentException("El competidor no puede ser nulo");
        }

        for (int i = 0; i < listaDeCompetidores.length; i++) {
            if (listaDeCompetidores[i] == null) continue;
            if (competidor.equals(listaDeCompetidores[i])) return true;

        }
        return false;
    }

    /**
     * Agrega un competidor a la lista del entrenador.
     * <p>
     * Valida que el entrenador tenga capacidad disponible y que el competidor
     * no ya esté asignado. Asigna bidireccionalmente el entrenador al competidor.
     * </p>
     *
     * @param competidor el competidor a agregar
     * @throws IllegalArgumentException si el competidor es null
     * @throws IllegalStateException si la capacidad máxima ha sido alcanzada
     *                              o si el competidor ya está asignado
     */
    public void agregarCompetidor(Competidor competidor) {
        if (competidor == null) {
            throw new IllegalArgumentException("El campo no puede estar nulo");
        }

        if (cantidadCompetidores >= listaDeCompetidores.length) {
            throw new IllegalArgumentException("El entrenador ya tiene asignado la cantidad de competidores máxima que puede entrenar");
        }

        if (cantidadCompetidores > 0) {
            if (buscarCompetidor(competidor)) {
                throw new IllegalStateException("El competidor ya tiene asignado el entrenador");
            }
        }

        for (int i = 0; i < listaDeCompetidores.length; i++) {
            if (listaDeCompetidores[i] != null) continue;
            listaDeCompetidores[i] = competidor;
            cantidadCompetidores++;
            competidor.setEntrenador(this);
            break;
        }
    }


    /**
     * Elimina un competidor de la lista del entrenador.
     *
     * @param competidor el competidor a eliminar
     * @return true si se eliminó exitosamente, false si no se encontró
     * @throws IllegalArgumentException si el competidor es null
     */
    public boolean eliminarCompetidor(Competidor competidor){
        if (competidor == null){
            throw new IllegalArgumentException("El campo no puede estar nulo");
        }
        for (int i = 0; i < listaDeCompetidores.length; i++) {
            if (listaDeCompetidores[i] == null) continue;
            if (listaDeCompetidores[i].equals(competidor)) {
                listaDeCompetidores[i] = null;
                cantidadCompetidores--;
                return true;
            }
        }
        return false;
    }

    /**
     * Calcula la credibilidad física del entrenador.
     * <p>
     * La credibilidad se calcula basándose en:
     * <ul>
     * <li>IMC: Se penaliza si está fuera de rango (18.5-30)</li>
     * <li>Consumo de agua: Se penaliza si no cumple el mínimo (6 vasos)</li>
     * </ul>
     * Puntuación base: 100 puntos.
     * </p>
     *
     * @return la credibilidad física calculada (0-100)
     */
    public int calcularCredibilidadFisica(){
        double imc = validarIMC();
        int credibilidad = 100;

        if (imc < 18.5 || imc > 30) {
            credibilidad -= 30;
        }

        if (!validarCantidadAguaConsumida()) {
            credibilidad -= 20;
        }

        return credibilidad;
    }

    /**
     * Retorna una representación en cadena del entrenador.
     * <p>
     * Incluye información personal y la lista de competidores asignados.
     * </p>
     *
     * @return una cadena con la información completa del entrenador
     */
    @Override
    public String toString() {
        String info = "Entrenador:\n";
        info += "Nombre: " + getNombre() + "\n";
        info += "Apellidos: " + getApellidos() + "\n";
        info += "Edad: " + getEdad() + "\n";
        info += "Vasos de agua: " + getVasosDeAgua() + "\n";
        info += "Peso: " + getPeso() + "\n";
        info += "Estatura: " + getEstatura() + "\n";
        info += "Especialidad deportiva: " + this.especialidadDeportiva + "\n";
        info += "Años de experiencia: " + this.aniosExperiencia + "\n";
        info += "Competidores asignados:\n";

        for(Competidor competidor: listaDeCompetidores){
            if (competidor != null) {
                info +=  "- " + competidor.getNombre() + "\n";
            }
        }

        return info;
    }
}

