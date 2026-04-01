package POO.heerencia.GestionPersonasUniversidad.model;

import POO.heerencia.GestionPersonasUniversidad.Eums.TipoPersona;

public class Estudiante  extends Persona{
    private String carrera;

    public Estudiante(String nombre, int edad, TipoPersona tipoPersona, String carrera){
        super(nombre, edad, tipoPersona);
        setCarrera(carrera);
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        if (carrera == null || carrera.isBlank()){
            throw new IllegalArgumentException("El campo carrera no puede estar vacio");
        }
        this.carrera = carrera;
    }

    @Override
    public void actividad() {
        System.out.println("Estudiar");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString()); //Reutiliza el toString del padre
        sb.deleteCharAt(sb.length() -1); // Quita el último '}' del padre para "abrir" la cadena
        sb.append(", Carrera = ").append(carrera);
        sb.append('}');
        return sb.toString();
    }
}
