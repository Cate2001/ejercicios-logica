package POO.heerencia.GestionPersonasUniversidad.Service;

import POO.heerencia.GestionPersonasUniversidad.model.Estudiante;
import POO.heerencia.GestionPersonasUniversidad.model.Persona;
import POO.heerencia.GestionPersonasUniversidad.model.Profesor;

public class ServicioPersona {
    private final int TAMANIO_ARR = 4;
    private Persona[] personasArreglo = new Persona[TAMANIO_ARR];
    private int indice = 0;
    private int tamanioArr = personasArreglo.length;

    //Ingresar datos a mi arreglo
    public void add(Persona personasEn) {
        if (personasEn == null) {
            throw new IllegalArgumentException("⚠️ No se permiten datos nulos, por favor ingrese datos validos.");
        }
        //Verificar los espacios que quedan en el arreglo Personas (estudiantes, profesores)
        if (indice < tamanioArr) {
            personasArreglo[indice] = personasEn;
            indice++;

        } else {
            System.out.println("⚠️ No se puede agregar el " + personasEn.getTipoPersona() + " = " + personasEn.getNombre() + " Capacidad: "
                    + personasArreglo.length);
        }
    }

    //Mostrar la inforamción del arreglo personas
    public void mostrarArregloPersonas() {
        if (indice == 0) {
            throw new IllegalArgumentException("⚠️ No existe información para mostrar. Por favor agregue información.");
        }
        for (Persona persona : personasArreglo) {
            if (persona != null) {
                System.out.println(persona.toString());
            }

        }
    }

    //Contar total estudiantes
    private int contarEstudiantes() {
        int contadorEstudiantes = 0;
        for (Persona estudiantes : personasArreglo) {
            if (estudiantes == null) continue;
            if (estudiantes instanceof Estudiante) contadorEstudiantes++;
        }
        return contadorEstudiantes;

    }

    //Contar total profesores
    private int contarProfesores() {
        int contadorProfesores = 0;
        for (Persona estudiantes : personasArreglo) {
            if (estudiantes == null) continue;
            if (estudiantes instanceof Profesor) contadorProfesores++;
        }
        return contadorProfesores;

    }

    //Mostrar cantidad total estudiantes y profesores
    public void mostrarCantidadTipoPersona() {
        int totalEstudiantes = contarEstudiantes();
        int totalProfesores = contarProfesores();

        if (totalEstudiantes > 0) {
            System.out.println("Total estudiantes agregados: " + totalEstudiantes);
        } else {
            System.out.println("No hay estudiantes agregados");
        }

        if (totalProfesores > 0) {
            System.out.println("Total profesores agregados: " + totalProfesores);

        } else {
            System.out.println("No hay profesores agregados");
        }
    }

    //Agregar estudiantes y profesores en la matriz
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

    public void mostrarMatrizPersonas(){
        Persona[][] matriz = agregarPersonasMatriz();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == null) continue;
                System.out.println(matriz[i][j].getTipoPersona() + ": " +  matriz[i][j].toString());
            }
            System.out.println();

        }
    }
}
