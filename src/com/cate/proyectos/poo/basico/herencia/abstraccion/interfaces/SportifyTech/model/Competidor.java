package com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SportifyTech.model;

import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SportifyTech.enums.Nivel;
import proyectos_poo.poo_basico.herencia_abstraccion_interfaces.SportifyTech.enums.*;

/**
 * Representa a competidor en el sistema deportivo SportifyTech.
 * <p>
 * Esta clase extiende de {@link Persona} y agrega información específica
 * de un competidor, incluyendo el deporte que practica, su nivel de habilidad
 * y el entrenador asignado.
 * </p>
 * <p>
 * Responsabilidades:
 * <ul>
 * <li>Almacenar el deporte que practica el competidor</li>
 * <li>Definir el nivel de habilidad (inmutable)</li>
 * <li>Asignar un entrenador al competidor</li>
 * <li>Validar aptitud para competir según métricas de salud</li>
 * </ul>
 * </p>
 *
 * @author Caterine Salinas Bolaños
 * @version 1.0
 */
public class Competidor extends Persona {
    /**
     * Deporte que practica el competidor.
     */
    private String deporteQuePractica;

    /**
     * Nivel de habilidad del competidor.
     * Es inmutable ya que el nivel se asigna al crear el competidor.
     */
    private final Nivel nivelCompetidor;

    /**
     * Entrenador asignado al competidor.
     * Puede ser null si aún no tiene entrenador asignado.
     */
    private Entrenador entrenador;

    /**
     * Constructor que inicializa un competidor con todos sus atributos.
     *
     * @param nombre el nombre del competidor
     * @param apellidos los apellidos del competidor
     * @param edad la edad en años
     * @param vasosDeAgua la cantidad de vasos de agua consumidos
     * @param peso el peso en kilogramos
     * @param estatura la estatura en metros
     * @param deporteQuePractica el deporte que practica
     * @param nivelCompetidor el nivel de habilidad (no puede ser null)
     * @throws IllegalArgumentException si el nivel es null o el deporte es vacío
     */
    public Competidor(String nombre, String apellidos, int edad, int vasosDeAgua, double peso, double estatura,
                      String deporteQuePractica, Nivel nivelCompetidor) {
        super(nombre, apellidos, edad, vasosDeAgua, peso, estatura);
        if (nivelCompetidor == null){
            throw new IllegalArgumentException("El nivel no puede ser nulo");
        }
        this.nivelCompetidor = nivelCompetidor;
        setDeporteQuePractica(deporteQuePractica);

    }

    /**
     * Retorna el deporte que practica el competidor.
     *
     * @return el deporte que practica
     */
    public String getDeporteQuePractica() {
        return deporteQuePractica;
    }

    /**
     * Establece el deporte que practica el competidor.
     *
     * @param deporteQuePractica el nuevo deporte
     * @throws IllegalArgumentException si el deporte es null o vacío
     */
    public void setDeporteQuePractica(String deporteQuePractica) {
        if (deporteQuePractica == null || deporteQuePractica.isBlank()){
            throw new IllegalArgumentException("El campo no puede estar vacio");
        }
        this.deporteQuePractica = deporteQuePractica;
    }

    /**
     * Retorna el nivel de habilidad del competidor.
     *
     * @return el nivel de habilidad
     */
    public Nivel getNivelCompetidor() {
        return nivelCompetidor;
    }

    /**
     * Retorna el entrenador asignado al competidor.
     *
     * @return el entrenador asignado, o null si no tiene
     */
    public Entrenador getEntrenador() {
        return entrenador;
    }

    /**
     * Establece el entrenador asignado al competidor.
     *
     * @param entrenador el nuevo entrenador
     */
    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    /**
     * Valida si el competidor es apto para competir.
     * <p>
     * Un competidor es apto si:
     * <ul>
     * <li>Consume al menos 6 vasos de agua por día</li>
     * <li>Tiene un IMC entre 18.5 y 24.9 (rango saludable)</li>
     * </ul>
     * </p>
     *
     * @return true si es apto para competir, false en caso contrario
     */
    public boolean aptoCompetir(){
        boolean validarCantidadAgua = validarCantidadAguaConsumida();
        double calculoIMC = validarIMC();

        return validarCantidadAgua && calculoIMC >= 18.5 && calculoIMC <= 24.9;
    }
}
