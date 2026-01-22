package POO.orden_compra;

public class Producto {
    private String fabricante;
    private String nombre;
    private int precio;

    public Producto(String fabricante, String nombre, int precio){
        if (fabricante == null || fabricante.isBlank()){
            throw new IllegalArgumentException("El fabricante es obligatorio");
        }

        if (nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException("El nombre es obligatorio");
        }

        if (precio < 0){
            throw new IllegalArgumentException("El precio no puede ser un valor negativo");
        }

        this.fabricante = fabricante;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Producto{");
        sb.append("fabricante='").append(fabricante).append('\'');
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", precio=").append(precio);
        sb.append('}');
        return sb.toString();
    }
}
