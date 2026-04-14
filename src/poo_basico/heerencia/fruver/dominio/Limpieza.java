package POO.heerencia.fruver.dominio;

public class Limpieza extends Producto{
    private String componentes;
    private double litros;

    public Limpieza(String nombre, Double precio, String componentes, double litros) {
        super(nombre, precio);
        if (componentes == null || componentes.isBlank()) throw new IllegalArgumentException("Valor ingresado no valido");
        if (litros <= 0) throw new IllegalArgumentException("El valor no puede ser negativo o igual a 0");
        this.componentes = componentes;
        this.litros = litros;
    }

    public String getComponentes() {
        return componentes;
    }

    public double getLitros() {
        return litros;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder(super.toString());
        sb.deleteCharAt(sb.length() -1);
        sb.append(" Componentes: ").append(componentes);
        sb.append(", Litros: ").append(litros);
        sb.append('}');
        return sb.toString();
    }
}
