package POO.heerencia.fruver.dominio;

public class Lacteo extends Producto{
    private int cantidad;
    private int proteinas;

    public Lacteo(String nombre, Double precio, int cantidad, int proteinas) {
        super(nombre, precio);

        if (cantidad < 0 || proteinas < 0) {
            throw new IllegalArgumentException("la cantidad no puede ser negativa");
        }
        this.cantidad = cantidad;
        this.proteinas = proteinas;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getProteinas() {
        return proteinas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.deleteCharAt(sb.length() -1);
        sb.append(", Cantidad: ").append(cantidad);
        sb.append(", proteinas: ").append(proteinas);
        sb.append('}');
        return sb.toString();
    }
}
