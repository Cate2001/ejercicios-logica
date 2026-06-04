package com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.GestionPersonasUniversidad.services;

import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.GestionPersonasUniversidad.model.Estudiante;
import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.GestionPersonasUniversidad.model.Persona;
import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.GestionPersonasUniversidad.model.Profesor;


/**
 * Servicio de gestión de personas en el sistema universitario.
 * <p>
 * Esta clase administra el almacenamiento y recuperación de personas
 * (estudiantes y profesores) en un arreglo de capacidad fija.
 * Proporciona métodos para agregar, contar y organizar personas por tipo.
 * </p>
 * <p>
 * Responsabilidades:
 * <ul>
 * <li>Administrar el almacenamiento de personas (capacidad máxima: 4)</li>
 * <li>Agregar personas al sistema con validación de capacidad</li>
 * <li>Contar estudiantes y profesores por separado</li>
 * <li>Organizar personas en matriz por tipo</li>
 * <li>Proporcionar información agregada del sistema</li>
 * </ul>
 * </p>
 *
 * @author Caterine Salinas Bolaños
 * @version 1.0
 */
public class ServicioPersona {
    /**
     * Capacidad máxima del arreglo de personas.
     */
    private final int TAMANIO_ARR = 4;

    /**
     * Arreglo que almacena las personas del sistema.
     */
    private Persona[] personasArreglo = new Persona[TAMANIO_ARR];

    /**
     * Índice actual para agregar nuevas personas.
     */
    private int indice = 0;

    /**
     * Tamaño total del arreglo de personas.
     */
    private int tamanioArr = personasArreglo.length;

    /**
     * Agrega una persona al sistema de gestión.
     * <p>
     * Valida que la persona no sea nula y que haya capacidad disponible
     * en el arreglo antes de agregarla.
     * </p>
     *
     * @param persona la persona a agregar (no puede ser null)
     * @throws IllegalArgumentException si la persona es nula
     * @throws IllegalStateException si la capacidad máxima ha sido alcanzada
     */
    public void agregarPersona(Persona persona) {
        if (persona == null) {
            throw new IllegalArgumentException("⚠️ No se permiten datos nulos, por favor ingrese datos validos.");
        }
        //Verificar los espacios que quedan en el arreglo Personas (estudiantes, profesores)
        if (indice >= tamanioArr) {
            throw new IllegalStateException("⚠️ No se puede agregar el " + persona.getTipoPersona() + " = " + persona.getNombre() + " Capacidad: "
                    + personasArreglo.length);
        }
        personasArreglo[indice] = persona;
        indice++;
    }

    /**
     * Retorna el arreglo de personas almacenadas en el sistema.
     * <p>
     * Valida que exista al menos una persona antes de retornar el arreglo.
     * </p>
     *
     * @return el arreglo de personas
     * @throws IllegalStateException si no hay personas en el sistema
     */
    public Persona[] obtenerArregloPersonas() {
        if (indice == 0) {
            throw new IllegalStateException("⚠️ No existe información para mostrar. Por favor agregue información.");
        }
        return personasArreglo;
    }

    /**
     * Cuenta el total de estudiantes en el sistema.
     * <p>
     * Recorre el arreglo de personas y cuenta aquellas que son instancias
     * de {@link Estudiante}.
     * </p>
     *
     * @return el número de estudiantes en el sistema
     */
    private int contarEstudiantes() {
        int contadorEstudiantes = 0;
        for (Persona persona : personasArreglo) {
            if (persona == null) continue;
            if (persona instanceof Estudiante) contadorEstudiantes++;
        }
        return contadorEstudiantes;

    }

    /**
     * Cuenta el total de profesores en el sistema.
     * <p>
     * Recorre el arreglo de personas y cuenta aquellas que son instancias
     * de {@link Profesor}.
     * </p>
     *
     * @return el número de profesores en el sistema
     */
    private int contarProfesores() {
        int contadorProfesores = 0;
        for (Persona persona : personasArreglo) {
            if (persona == null) continue;
            if (persona instanceof Profesor) contadorProfesores++;
        }
        return contadorProfesores;

    }

    /**
     * Retorna una cadena con la cantidad de estudiantes y profesores.
     * <p>
     * Formatea la información de conteo en una cadena legible.
     * </p>
     *
     * @return una cadena con el conteo de estudiantes y profesores
     */
    public String obtenerCantidadTipoPersona() {
        int totalEstudiantes = contarEstudiantes();
        int totalProfesores = contarProfesores();

        StringBuilder sb = new StringBuilder();
        if (totalEstudiantes > 0) {
            sb.append("Total estudiantes agregados: ").append(totalEstudiantes).append("\n");
        } else {
            sb.append("No hay estudiantes agregados\n");
        }

        if (totalProfesores > 0) {
            sb.append("Total profesores agregados: ").append(totalProfesores);
        } else {
            sb.append("No hay profesores agregados");
        }
        return sb.toString();
    }

    /**
     * Organiza las personas en una matriz separada por tipo.
     * <p>
     * Crea una matriz de 2 filas: fila 0 para estudiantes, fila 1 para profesores.
     * Distribuye las personas según su tipo en la matriz correspondiente.
     * </p>
     *
     * @return una matriz de 2x4 con personas organizadas por tipo
     */
    private Persona[][] agregarPersonasMatriz() {
        Persona[][] matrizPersonas = new Persona[2][TAMANIO_ARR];
        final int FILA_ESTUDIANTE = 0;
        final int FILA_PROFESOR = 1;
        int columnaEstudiante = 0;
        int columnaProfesor = 0;

        for (Persona arrPersona : personasArreglo) {
            if (arrPersona == null) continue;
            if (arrPersona instanceof Estudiante) {
                matrizPersonas[FILA_ESTUDIANTE][columnaEstudiante++] = arrPersona;
            } else if (arrPersona instanceof Profesor) {
                matrizPersonas[FILA_PROFESOR][columnaProfesor++] = arrPersona;
            }
        }
        return matrizPersonas;
    }

    /**
     * Retorna una cadena con la matriz de personas organizada por tipo.
     * <p>
     * Formatea la información de la matriz en una cadena legible,
     * separando estudiantes y profesores.
     * </p>
     *
     * @return una cadena con la matriz de personas formateada
     */
    public String obtenerMatrizPersonas(){
        Persona[][] matriz = agregarPersonasMatriz();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == null) continue;
                sb.append(matriz[i][j].getTipoPersona()).append(": ").append(matriz[i][j].toString()).append("\n");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
