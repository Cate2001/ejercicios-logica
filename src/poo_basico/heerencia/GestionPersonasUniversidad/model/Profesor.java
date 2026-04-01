package POO.heerencia.GestionPersonasUniversidad.model;

import POO.heerencia.GestionPersonasUniversidad.Eums.TipoPersona;

public class Profesor extends Persona{
    private String materia;

    public Profesor(String nombre, int edad, TipoPersona tipoPersona, String materia){
        super(nombre, edad, tipoPersona);
        setMateria(materia);
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        if (materia == null || materia.isBlank()){
            throw new IllegalArgumentException("El campo materia no puede estar vacio");
        }
        this.materia = materia;
    }

    @Override
    public void actividad() {
        System.out.println("Dar clases");
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(super.toString()); //Reutiliza el toString del padre
        sb.deleteCharAt(sb.length() -1); // Quita el último '}' del padre para "abrir" la cadena
        sb.append(", Materia = ").append(materia);
        sb.append('}');
        return sb.toString();
    }
}
