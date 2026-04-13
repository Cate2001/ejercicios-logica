package POO.heerencia.PersonasCompania.dominio;

public class Gerente extends Empleado {

    private Double presupuesto;

    public Gerente(String nombre, String apellido, String numeroFiscal, String direccion, Double renumeracion, Double presupuesto) {
        super(nombre, apellido, numeroFiscal, direccion, renumeracion);
        this.presupuesto = presupuesto;
    }

    public Double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.deleteCharAt(sb.length() - 1);
        sb.append(", Presupuesto: ").append(presupuesto);
        sb.append('}');

        return sb.toString();

    }
}

