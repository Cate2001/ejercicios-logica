package POO.heerencia.SportifyTech.service;

import POO.heerencia.SportifyTech.model.Competidor;
import POO.heerencia.SportifyTech.model.Entrenador;

//Servicio que asigna un entrenador a mi competidor
public class ServicioCompetidor {

    //Validar parametros de metodos
    private void validarParametrosMetodos(Competidor competidor, Entrenador[] entrenadores) {
        if (competidor == null || entrenadores == null) {
            throw new IllegalArgumentException("Los datos no pueden ser nulos");
        }

        if (entrenadores.length == 0) {
            throw new IllegalArgumentException("Debe agregar entrenadores al arreglo");
        }
    }

    //Validar los entrenadores que tengan el mismo deporte que el competidor
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
