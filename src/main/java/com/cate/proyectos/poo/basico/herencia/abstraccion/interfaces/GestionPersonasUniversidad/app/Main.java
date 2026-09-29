package com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.GestionPersonasUniversidad.app;

import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.GestionPersonasUniversidad.enums.TipoPersona;
import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.GestionPersonasUniversidad.model.Estudiante;
import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.GestionPersonasUniversidad.model.Persona;
import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.GestionPersonasUniversidad.model.Profesor;
import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.GestionPersonasUniversidad.services.ServicioPersona;

/**
 * Clase principal de demostración del Sistema de Gestión de Personas de Universidad.
 * <p>
 * Esta clase contiene pruebas que demuestran el funcionamiento del sistema,
 * incluyendo gestión de estudiantes y profesores con herencia y polimorfismo.
 * </p>
 * <p>
 * Las pruebas validan:
 * </p>
 * <ul>
 * <li>Creación de estudiantes y profesores con atributos específicos</li>
 * <li>Registro de personas en el servicio con validación de capacidad</li>
 * <li>Visualización de personas agregadas</li>
 * <li>Conteo de personas por tipo (estudiantes y profesores)</li>
 * <li>Organización de personas en matriz por tipo</li>
 * <li>Ejecución de actividades específicas (estudiar, dar clases)</li>
 * </ul>
 *
 * @author Caterine Salinas Bolaños
 * @version 1.0
 */
public class Main {
    /**
     * Método principal que ejecuta las pruebas del sistema de gestión universitaria.
     * <p>
     * Realiza pruebas que cubren:
     * </p>
     * <ol>
     * <li>Creación de 2 estudiantes (Carlos, Camilo) con carrera Tecnología</li>
     * <li>Creación de 2 profesores (Daniel, Carolina) con materias específicas</li>
     * <li>Registro de personas en el servicio (capacidad máxima: 4)</li>
     * <li>Visualización de todas las personas agregadas</li>
     * <li>Conteo de estudiantes y profesores por separado</li>
     * <li>Organización de personas en matriz (fila 0: estudiantes, fila 1: profesores)</li>
     * <li>Ejecución de actividades polimórficas (estudiar, dar clases)</li>
     * </ol>
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        ServicioPersona servicioPersona  = new ServicioPersona();

        //Estudiantes
        Persona estudiante1 = new Estudiante("Carlos", 24, TipoPersona.ESTUDIANTE, "Tecnologia");
        Persona estudiante2 = new Estudiante("Camilo", 27, TipoPersona.ESTUDIANTE, "Tecnologia");

        //Profesores
        Persona profesor1 = new Profesor("Daniel", 35, TipoPersona.PROFESOR, "Programación");
        Persona profesor2 = new Profesor("Carolina", 34, TipoPersona.PROFESOR, "Bases de datos");

        //servicioPersona.add();
        try {

            servicioPersona.agregarPersona(estudiante1);

            servicioPersona.agregarPersona(profesor2);
            servicioPersona.agregarPersona(profesor1);

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("-------------------------------------------------------------------------------------");

        //Mostrar info de las personas agregadas
        System.out.println("PERSONAS AGREGADAS ✅");
        try {
            Persona[] personas = servicioPersona.obtenerArregloPersonas();
            for (Persona persona : personas) {
                if (persona != null) {
                    System.out.println(persona.toString());
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("-------------------------------------------------------------------------------------");
        //Contar profesores y estudiantes agregados al arreglo
        System.out.println("Total de personas por tipo:");
        System.out.println(servicioPersona.obtenerCantidadTipoPersona());

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("MATRIZ PERSONAS");
        System.out.println(servicioPersona.obtenerMatrizPersonas());

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Actividad personas");
        System.out.print(estudiante1.getTipoPersona() + ": ");
        estudiante1.actividad();
        System.out.print(profesor1.getTipoPersona() + ": ");
        profesor1.actividad();

    }

}
