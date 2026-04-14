package POO.heerencia.fruver.dominio;

public class Fruta extends Producto{
    private double peso;
    private String color;

    public Fruta(String nombre, Double precio, String color, double peso) {
        super(nombre, precio);
        if (color == null || color.isBlank()) {
            throw new IllegalArgumentException("Valor ingresado no es valido");
        }
        if (peso < 0) throw new IllegalArgumentException("Valor ingresado no es valido");

        this.color = color;
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder(super.toString());
        sb.deleteCharAt(sb.length() -1);
        sb.append(" Peso: ").append(peso);
        sb.append(", Color: ").append(color);
        sb.append('}');
        return sb.toString();
    }
}
