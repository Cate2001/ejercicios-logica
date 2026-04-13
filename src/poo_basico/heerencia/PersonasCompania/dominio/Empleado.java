package POO.heerencia.PersonasCompania.dominio;

public class Empleado extends Persona {
    private Double renumeracion;
    private int empleadoId;
    private static int autoincrementable = 0;

    public Empleado(String nombre, String apellido, String numeroFiscal, String direccion, Double renumeracion) {
        super(nombre, apellido, numeroFiscal, direccion);
        this.renumeracion = renumeracion;
        this.empleadoId = ++autoincrementable;
    }

    public Double getRenumeracion() {
        return renumeracion;
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    public void aumentarRemuneracion(int porcentaje) {
        if (porcentaje < 0) throw new IllegalArgumentException("El valor no puede ser negativo");
        this.renumeracion += porcentaje;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.deleteCharAt(sb.length() - 1);
        sb.append(", Empleado: ");
        sb.append(" Renumeracion= ").append(renumeracion);
        sb.append(", Empleado ID= ").append(empleadoId);
        sb.append('}');

        return sb.toString();
    }
}
