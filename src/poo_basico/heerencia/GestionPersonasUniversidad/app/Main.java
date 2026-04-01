package POO.heerencia.GestionPersonasUniversidad.app;

import POO.heerencia.GestionPersonasUniversidad.Eums.TipoPersona;
import POO.heerencia.GestionPersonasUniversidad.Service.ServicioPersona;
import POO.heerencia.GestionPersonasUniversidad.model.Estudiante;
import POO.heerencia.GestionPersonasUniversidad.model.Persona;
import POO.heerencia.GestionPersonasUniversidad.model.Profesor;

public class Main {
    public static void main(String[] args) {
        ServicioPersona servicioPersona = new ServicioPersona();

        //Estudiantes
        Persona estudiante1 = new Estudiante("Carlos", 24, TipoPersona.ESTUDIANTE, "Tecnologia");
        Persona estudiante2 = new Estudiante("Camilo", 27, TipoPersona.ESTUDIANTE, "Tecnologia");

        //Profesores
        Persona profesor1 = new Profesor("Daniel", 35, TipoPersona.PROFESOR, "Programación");
        Persona profesor2 = new Profesor("Carolina", 34, TipoPersona.PROFESOR, "Bases de datos");

        //servicioPersona.add();
        try {
            servicioPersona.add(estudiante2);
            servicioPersona.add(estudiante1);

            servicioPersona.add(profesor2);
            servicioPersona.add(profesor1);

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("-------------------------------------------------------------------------------------");

        //Mostrar info de las personas agregadas
        System.out.println("PERSONAS AGREGADAS ✅");
        try {
            servicioPersona.mostrarArregloPersonas();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("-------------------------------------------------------------------------------------");
        //Contar profesores y estudiantes agregados al arreglo
        System.out.println("Total de personas por tipo:");
        servicioPersona.mostrarCantidadTipoPersona();

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("MATRIZ PERSONAS");
        servicioPersona.mostrarMatrizPersonas();

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Actividad personas");
        System.out.print(estudiante1.getTipoPersona() + ": ");
        estudiante1.actividad();
        System.out.print(profesor1.getTipoPersona() + ": ");
        profesor1.actividad();

    }

}
