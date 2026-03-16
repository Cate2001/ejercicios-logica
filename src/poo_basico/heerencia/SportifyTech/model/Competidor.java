package POO.heerencia.SportifyTech.model;

import POO.heerencia.SportifyTech.Enums.Nivel;

public class Competidor extends Persona {
    private String deporteQuePractica;
    private final Nivel nivelCompetidor;
    private Entrenador entrenador;

    public Competidor(String nombre, String apellidos, int edad, int vasosDeAgua, double peso, double estatura,
                      String deporteQuePractica, Nivel nivelCompetidor) {
        super(nombre, apellidos, edad, vasosDeAgua, peso, estatura);
        if (nivelCompetidor == null){
            throw new IllegalArgumentException("El competidor no puede ser nulo");
        }
        if (nivelCompetidor == null){
            throw new IllegalArgumentException("El nivel no puede ser nulo");
        }

        this.nivelCompetidor = nivelCompetidor;
        setDeporteQuePractica(deporteQuePractica);

    }

    public String getDeporteQuePractica() {
        return deporteQuePractica;
    }

    public void setDeporteQuePractica(String deporteQuePractica) {
        if (deporteQuePractica == null || deporteQuePractica.isBlank()){
            throw new IllegalArgumentException("El campo no puede estar vacio");
        }
        this.deporteQuePractica = deporteQuePractica;
    }

    public Nivel getNivelCompetidor() {
        return nivelCompetidor;
    }


    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    //Validar si es apto para competir
    public boolean aptoCompetir(){
        boolean validarCantidadAgua = validarCantidadAguaConsumida();
        double calculoIMC = validarIMC();

        return validarCantidadAgua && calculoIMC >= 18.5 && calculoIMC <= 24.9;
    }
}
