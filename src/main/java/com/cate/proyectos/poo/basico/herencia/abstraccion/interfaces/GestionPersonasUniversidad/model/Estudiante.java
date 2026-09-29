package com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.GestionPersonasUniversidad.model;

import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.GestionPersonasUniversidad.enums.TipoPersona;

/**
 * Representa a un estudiante en el sistema de gestión universitaria.
 * <p>
 * Esta clase extiende de {@link Persona} y agrega la información específica
 * de un estudiante, incluyendo su carrera académica.
 * </p>
 * <p>
 * Responsabilidades:
 * <ul>
 * <li>Almacenar la carrera del estudiante</li>
 * <li>Validar que la carrera no sea nula o vacía</li>
 * <li>Implementar la actividad específica de estudiar</li>
 * </ul>
 * </p>
 *
 * @author Caterine Salinas Bolaños
 * @version 1.0
 */
public class Estudiante  extends Persona {
    /**
     * Carrera académica del estudiante.
     * Debe ser validada para no ser nula o vacía.
     */
    private String carrera;

    /**
     * Constructor que inicializa un estudiante con nombre, edad, tipo y carrera.
     *
     * @param nombre el nombre del estudiante
     * @param edad la edad del estudiante (debe ser >= 15)
     * @param tipoPersona el tipo de persona (debe ser ESTUDIANTE)
     * @param carrera la carrera académica del estudiante
     * @throws IllegalArgumentException si la carrera es nula o vacía
     */
    public Estudiante(String nombre, int edad, TipoPersona tipoPersona, String carrera){
        super(nombre, edad, tipoPersona);
        setCarrera(carrera);
    }

    /**
     * Retorna la carrera académica del estudiante.
     *
     * @return la carrera del estudiante
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * Establece la carrera académica del estudiante.
     * <p>
     * Valida que la carrera no sea nula o vacía antes de asignarla.
     * </p>
     *
     * @param carrera la nueva carrera del estudiante
     * @throws IllegalArgumentException si la carrera es nula o vacía
     */
    public void setCarrera(String carrera) {
        if (carrera == null || carrera.isBlank()){
            throw new IllegalArgumentException("El campo carrera no puede estar vacio");
        }
        this.carrera = carrera;
    }

    /**
     * Implementación de la actividad específica de un estudiante.
     * <p>
     * La actividad principal de un estudiante es estudiar.
     * </p>
     */
    @Override
    public void actividad() {
        System.out.println("Estudiar");
    }

    /**
     * Retorna una representación en cadena del estudiante.
     * <p>
     * Reutiliza el toString de la clase padre y agrega la información
     * de la carrera.
     * </p>
     *
     * @return una cadena con la información completa del estudiante
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString()); //Reutiliza el toString del padre
        sb.deleteCharAt(sb.length() -1); // Quita el último '}' del padre para "abrir" la cadena
        sb.append(", Carrera = ").append(carrera);
        sb.append('}');
        return sb.toString();
    }
}
