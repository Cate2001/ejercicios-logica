package POO.heerencia.fruver.dominio;

public class Producto {
    private String nombre;
    private Double precio;

    public Producto(String nombre, Double precio) {
        if (nombre == null || nombre.isBlank())throw  new IllegalArgumentException("Nombre no puede ser nulo o vacio");
        if (precio <= 0) throw  new IllegalArgumentException("Precio no puede ser negativo o igual a cero");
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
            StringBuilder sb = new StringBuilder("Producto: {");
            sb.append("Nombre: ").append(nombre);
            sb.append(", Precio: ").append(precio);
            sb.append('}');

        return sb.toString();
    }
}
