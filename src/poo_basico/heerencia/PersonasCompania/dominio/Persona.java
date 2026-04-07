package POO.heerencia.PersonasCompania.dominio;

public class Persona {
    private String nombre;
    private String apellido;
    private String numeroFiscal;
    private String direccion;

    public Persona(String nombre, String apellido, String numeroFiscal, String direccion) {
        if (nombre == null || apellido == null || numeroFiscal == null || direccion == null)
            throw new IllegalArgumentException("los campos no pueden ser nulos");
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroFiscal = numeroFiscal;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNumeroFiscal() {
        return numeroFiscal;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Persona {");
        sb.append("Nombre= '").append(nombre).append('\'');
        sb.append(", Apellido= '").append(apellido).append('\'');
        sb.append(", Numero fiscal '").append(numeroFiscal).append('\'');
        sb.append(", Dirección= '").append(direccion).append('\'');
        sb.append('}');

        return sb.toString();
    }
}
