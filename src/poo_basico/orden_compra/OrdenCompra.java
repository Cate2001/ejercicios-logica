package POO.orden_compra;

import java.util.Arrays;
import java.util.Date;

public class OrdenCompra {
    private static int ultimoId = 0;
    private int identificador;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private Producto[] productos;
    private int indice;


    public OrdenCompra( String descripcion){
        if (descripcion == null || descripcion.isBlank()){
            throw new IllegalArgumentException("La descripción es obligatoria");
        }
        this.descripcion = descripcion;
        this.productos = new Producto[4];
        this.identificador = ++ultimoId;
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha no puede ser null");
        }
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        if (cliente == null){
            throw new IllegalArgumentException("El cliente no puede ser null");
        }
        this.cliente = cliente;
    }

    public Producto[] getProductos() {
        return productos;
    }

    //Metodos
    public void addProducto(Producto producto){
        if (producto == null){
            throw new IllegalArgumentException("El producto no puede ser null");
        }

        productos[indice] = producto;
        indice++;
    }

    public int calcularGranTotal() {
        int suma = 0;
        for (Producto p : productos) {
            if (p != null) suma += p.getPrecio();
        }
        return suma;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrdenCompra{");
        sb.append("identificador=").append(identificador);
        sb.append(", descripcion='").append(descripcion).append('\'');
        sb.append(", fecha=").append(fecha);
        sb.append(", cliente=").append(cliente);
        sb.append(", productos=").append(Arrays.toString(productos));
        sb.append(", indice=").append(indice);
        sb.append('}');
        return sb.toString();
    }
}
