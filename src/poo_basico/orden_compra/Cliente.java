package POO.orden_compra;

public class Cliente {
    private String nombre;
    private String apellido;

    public Cliente(String nombre, String apellido){
        if (nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException("Nombre es obligatorio");
        }
        if (apellido == null || apellido.isBlank()){
            throw new IllegalArgumentException("Apellido es obligatorio");
        }

        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cliente{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", apellido='").append(apellido).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
