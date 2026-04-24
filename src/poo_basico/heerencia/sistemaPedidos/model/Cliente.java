package POO.heerencia.sistemaPedidos.model;

public class Cliente {
    private String nombre;
    private String identificacion;

    public Cliente(String nombre, String identificacion) {
        validarCampos(nombre);
        validarCampos(identificacion);
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    private void validarCampos(String campo){
        if (campo == null || campo.isBlank()){
            throw new IllegalArgumentException("Agregue un valor valido");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Cliente: {");
        sb.append("Nombre: '").append(nombre).append("'");
        sb.append(", Identificación: '").append(identificacion).append("'");
        sb.append('}');

        return sb.toString();
    }
}
