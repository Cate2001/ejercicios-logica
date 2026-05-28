package proyectos_poo.poo_basico.herencia_abstraccion_interfaces.fitlife.model;

import proyectos_poo.poo_basico.herencia_abstraccion_interfaces.fitlife.enums.TipoMembresia;

public class MiembroEstandar extends Miembro {

    public MiembroEstandar(String nombre, String cedula, int edad, TipoMembresia membresia) {
        super(nombre, cedula, edad, membresia);
    }

    @Override
    double calcularPagoMensual() {
        return getMembresia().getPrecioConDescuento();
    }

    @Override
    String getTipo() {
        return "ESTANDAR";

    }

    @Override
    String[] getBeneficios() {
        String[] beneficios = new String[] {"Acceso a máquinas", "Casillero incluido"};
        return beneficios;
    }
}
