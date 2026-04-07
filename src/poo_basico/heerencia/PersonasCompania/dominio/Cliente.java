package POO.heerencia.PersonasCompania.dominio;

public class Cliente extends Persona {
    private int clienteId;
    private int autoincrementable = 0;

    public Cliente(String nombre, String apellido, String numeroFiscal, String direccion) {
        super(nombre, apellido, numeroFiscal, direccion);
        this.clienteId = ++autoincrementable;
    }

    public int getAutoincrementable() {
        return autoincrementable;
    }

    public int getClienteId() {
        return clienteId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.deleteCharAt(sb.length() - 1);
        sb.append(", Cliente Id= ").append(clienteId);
        sb.append('}');

        return sb.toString();
    }
}
