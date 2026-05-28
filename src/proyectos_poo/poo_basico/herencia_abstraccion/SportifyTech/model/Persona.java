package proyectos_poo.poo_basico.herencia_abstraccion.SportifyTech.model;

/**
 * Clase base que representa a una persona en el sistema deportivo SportifyTech.
 * <p>
 * Esta clase define los atributos físicos y de salud comunes a todas
 * las personas en el sistema (competidores y entrenadores).
 * Implementa validaciones de dominio para asegurar datos coherentes.
 * </p>
 * <p>
 * Responsabilidades:
 * <ul>
 * <li>Almacenar información personal (nombre, apellidos, edad)</li>
 * <li>Almacenar métricas de salud (peso, estatura, consumo de agua)</li>
 * <li>Validar atributos según políticas de salud</li>
 * <li>Calcular IMC y validar consumo de agua</li>
 * </ul>
 * </p>
 *
 * @author Caterine Salinas Bolaños
 * @version 1.0
 */
public class Persona {
    /**
     * Nombre de la persona.
     */
    private String nombre;

    /**
     * Apellidos de la persona.
     */
    private String apellidos;

    /**
     * Edad de la persona en años.
     */
    private int edad;

    /**
     * Cantidad de vasos de agua consumidos por día.
     */
    private int vasosDeAgua;

    /**
     * Peso de la persona en kilogramos.
     */
    private double peso;

    /**
     * Estatura de la persona en metros.
     */
    private double estatura;

    /**
     * Cantidad mínima de vasos de agua recomendados por día.
     */
    private static final int CANTIDAD_MINIMA = 6;

    /**
     * Constructor que inicializa una persona con todos sus atributos.
     *
     * @param nombre el nombre de la persona
     * @param apellidos los apellidos de la persona
     * @param edad la edad en años (debe ser >= 12)
     * @param vasosDeAgua la cantidad de vasos de agua consumidos
     * @param peso el peso en kilogramos (debe ser > 0)
     * @param estatura la estatura en metros (debe ser > 0)
     * @throws IllegalArgumentException si algún parámetro es inválido
     */
    public Persona(String nombre, String apellidos, int edad, int vasosDeAgua, double peso, double estatura) {
        setNombre(nombre);
        setApellidos(apellidos);
        setEdad(edad);
        setVasosDeAgua(vasosDeAgua);
        setPeso(peso);
        setEstatura(estatura);
    }

    /**
     * Valida que un atributo String no sea nulo.
     *
     * @param valor el valor a validar
     * @throws IllegalArgumentException si el valor es nulo
     */
    private void validarAtributosStringNulos(String valor) {
        if (valor == null) {
            throw new IllegalArgumentException("El valor ingresado no puede ser nulo");
        }
    }

    /**
     * Valida que un atributo double sea mayor a cero.
     *
     * @param valor el valor a validar
     * @throws IllegalArgumentException si el valor es menor o igual a cero
     */
    private void validarAtributosDoubleNulos(double valor){
        if (valor <= 0){
            throw new IllegalArgumentException("¡Valor ingresado incorrecto! El valor debe ser mayor a 0");
        }
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
     *
     * @param nombre el nuevo nombre
     * @throws IllegalArgumentException si el nombre es nulo
     */
    public void setNombre(String nombre) {
        validarAtributosStringNulos(nombre);
        this.nombre = nombre;
    }

    /**
     * Retorna los apellidos de la persona.
     *
     * @return los apellidos de la persona
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos de la persona.
     *
     * @param apellidos los nuevos apellidos
     * @throws IllegalArgumentException si los apellidos son nulos
     */
    public void setApellidos(String apellidos) {
        validarAtributosStringNulos(apellidos);
        this.apellidos = apellidos;
    }

    /**
     * Retorna la edad de la persona.
     *
     * @return la edad en años
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad de la persona.
     *
     * @param edad la nueva edad en años (debe ser >= 12)
     * @throws IllegalArgumentException si la edad es menor a 12
     */
    public void setEdad(int edad) {
        if (edad < 12) {
            throw new IllegalArgumentException("El rango de edad permitida debe ser mayor o igual a 12 años");
        }
        this.edad = edad;
    }

    /**
     * Retorna la cantidad de vasos de agua consumidos.
     *
     * @return la cantidad de vasos de agua
     */
    public int getVasosDeAgua() {
        return vasosDeAgua;
    }

    /**
     * Establece la cantidad de vasos de agua consumidos.
     *
     * @param vasosDeAgua la nueva cantidad (no puede ser negativa)
     * @throws IllegalArgumentException si el valor es negativo
     */
    public void setVasosDeAgua(int vasosDeAgua) {
        if (vasosDeAgua < 0){
            throw new IllegalArgumentException("El valor no puede ser negativo");
        }
        this.vasosDeAgua = vasosDeAgua;
    }

    /**
     * Retorna el peso de la persona.
     *
     * @return el peso en kilogramos
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Establece el peso de la persona.
     *
     * @param peso el nuevo peso en kilogramos (debe ser > 0)
     * @throws IllegalArgumentException si el peso es menor o igual a cero
     */
    public void setPeso(double peso) {
        validarAtributosDoubleNulos(peso);
        this.peso = peso;
    }

    /**
     * Retorna la estatura de la persona.
     *
     * @return la estatura en metros
     */
    public double getEstatura() {
        return estatura;
    }

    /**
     * Establece la estatura de la persona.
     *
     * @param estatura la nueva estatura en metros (debe ser > 0)
     * @throws IllegalArgumentException si la estatura es menor o igual a cero
     */
    public void setEstatura(double estatura) {
        validarAtributosDoubleNulos(estatura);
        this.estatura = estatura;
    }

    /**
     * Valida si la persona consume la cantidad mínima de agua recomendada.
     * <p>
     * La cantidad mínima recomendada es de 6 vasos por día.
     * </p>
     *
     * @return true si consume al menos 6 vasos, false en caso contrario
     */
    public boolean validarCantidadAguaConsumida() {
        return this.vasosDeAgua >= CANTIDAD_MINIMA;
    }

    /**
     * Calcula el Índice de Masa Corporal (IMC) de la persona.
     * <p>
     * Fórmula: IMC = peso (kg) / estatura² (m)
     * </p>
     *
     * @return el valor del IMC calculado
     */
    public double validarIMC() {
        double calculoEstatura = this.estatura * this.estatura;
        double calculoIMC = this.peso / calculoEstatura;

        return calculoIMC;
    }


}


