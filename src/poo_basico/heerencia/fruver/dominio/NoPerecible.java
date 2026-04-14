package POO.heerencia.fruver.dominio;

public class NoPerecible extends Producto{
    private int contenido;
    private int calorias;

    public NoPerecible(String nombre, Double precio, int contenido, int calorias) {
        super(nombre, precio);
        this.contenido = contenido;
        this.calorias = calorias;
    }

    public int getContenido() {
        return contenido;
    }

    public int getCalorias() {
        return calorias;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder(super.toString());
        sb.deleteCharAt(sb.length() -1);
        sb.append(" Contenido: ").append(contenido);
        sb.append(", Calorias: ").append(calorias);
        sb.append('}');
        return sb.toString();
    }


}
