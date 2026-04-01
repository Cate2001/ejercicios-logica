package POO.heerencia.GestionPersonasUniversidad.model;
import POO.heerencia.GestionPersonasUniversidad.Eums.TipoPersona;

public class Persona {
    private String nombre;
    private int edad;
    private final TipoPersona tipoPersona;

    public Persona(String nombre, int edad, TipoPersona tipoPersona){
        setNombre(nombre);
        setEdad(edad);
        this.tipoPersona = tipoPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException("Debe ingresar un nombre");
        }
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad < 15){
            throw new IllegalArgumentException("La edad debe ser mayor o igual a 15 años");
        }
        this.edad = edad;
    }

    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    public void actividad(){
        System.out.println("Actividad");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Persona {");
        sb.append("Nombre= '").append(nombre).append('\'');
        sb.append(", Edad= ").append(edad);
        sb.append(", Tipo persona= ").append(tipoPersona);
        sb.append('}');
        return sb.toString();
    }
}
