package com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SportifyTech.services;

import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SportifyTech.model.Competidor;
import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SportifyTech.model.Entrenador;

/**
 * Servicio de asignación de entrenadores a competidores.
 * <p>
 * Esta clase implementa la lógica de negocio para asignar el entrenador
 * más adecuado a un competidor basándose en su especialidad deportiva,
 * credibilidad física y años de experiencia.
 * </p>
 * <p>
 * Responsabilidades:
 * <ul>
 * <li>Validar parámetros de entrada</li>
 * <li>Validar aptitud del competidor para competir</li>
 * <li>Buscar entrenadores compatibles por especialidad deportiva</li>
 * <li>Seleccionar el mejor entrenador basándose en credibilidad y experiencia</li>
 * <li>Asignar el entrenador al competidor</li>
 * </ul>
 * </p>
 *
 * @author Caterine Salinas Bolaños
 * @version 1.0
 */
//Servicio que asigna un entrenador a mi competidor
public class ServicioCompetidor {

    /**
     * Valida los parámetros de entrada de los métodos del servicio.
     *
     * @param competidor el competidor a validar
     * @param entrenadores el arreglo de entrenadores a validar
     * @throws IllegalArgumentException si el competidor o entrenadores son null,
     *                                  o si el arreglo de entrenadores está vacío
     */
    private void validarParametrosMetodos(Competidor competidor, Entrenador[] entrenadores) {
        if (competidor == null || entrenadores == null) {
            throw new IllegalArgumentException("Los datos no pueden ser nulos");
        }

        if (entrenadores.length == 0) {
            throw new IllegalArgumentException("Debe agregar entrenadores al arreglo");
        }
    }

    /**
     * Selecciona y asigna el mejor entrenador a un competidor.
     * <p>
     * El algoritmo de selección sigue estos criterios:
     * <ol>
     * <li>Valida que el competidor sea apto para competir</li>
     * <li>Valida que el competidor no tenga ya un entrenador asignado</li>
     * <li>Busca entrenadores con la misma especialidad deportiva</li>
     * <li>Selecciona el entrenador con mayor credibilidad física</li>
     * <li>En caso de empate, selecciona el con más años de experiencia</li>
     * </ol>
     * </p>
     *
     * @param competidor el competidor al que se le asignará el entrenador
     * @param entrenadores el arreglo de entrenadores disponibles
     * @throws IllegalArgumentException si los parámetros son inválidos
     * @throws IllegalStateException si el competidor no es apto,
     *                              ya tiene entrenador,
     *                              o no hay entrenador compatible disponible
     */
        public void seleccionarEntrenador(Competidor competidor, Entrenador[] entrenadores) {
        validarParametrosMetodos(competidor, entrenadores);
        String deporteCompetidor = competidor.getDeporteQuePractica();
        int mayorCredibilidad = 0;
        int mayorAniosExperiencia = 0;
        Entrenador mejorEntrenador = null;

        if (!competidor.aptoCompetir()) {
            throw new IllegalStateException("El competidor no es apto para competir");
        }
        if (competidor.getEntrenador() != null){
            throw new IllegalArgumentException("El competidor ya tiene un entrenador asignado");
        }
        for (Entrenador entrenador : entrenadores) {
            if (entrenador == null) continue;
            if (!deporteCompetidor.equals(entrenador.getEspecialidadDeportiva())) continue;
            int credibilidad = entrenador.calcularCredibilidadFisica();
            int aniosExperienciaActual = entrenador.getAniosExperiencia();
            if (mejorEntrenador == null) {
                mejorEntrenador = entrenador;
                mayorCredibilidad = credibilidad;
                mayorAniosExperiencia = aniosExperienciaActual;
                //aniosExperienciaEntrenador = entrenador.getAniosExperiencia();
            } else if (credibilidad >= mayorCredibilidad &&  aniosExperienciaActual > mayorAniosExperiencia) {
                mayorCredibilidad = credibilidad;
                mejorEntrenador = entrenador;
                mayorAniosExperiencia = aniosExperienciaActual;
            }
        }
        if (mejorEntrenador == null){
            throw new IllegalArgumentException("No existe entrenador compatible disponible");
        }
        mejorEntrenador.agregarCompetidor(competidor);
    }
}
