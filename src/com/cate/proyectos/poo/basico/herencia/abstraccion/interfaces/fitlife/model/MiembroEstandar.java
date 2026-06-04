package com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.fitlife.model;

import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.fitlife.enums.TipoMembresia;

public class MiembroEstandar extends Miembro {

    public MiembroEstandar(String nombre, String cedula, int edad, TipoMembresia membresia) {
        super(nombre, cedula, edad, membresia);
    }

    @Override
    public double calcularPagoMensual() {
        return getMembresia().getPrecioConDescuento();
    }

    @Override
    public String getTipo() {
        return "ESTANDAR";

    }

    @Override
    public String[] getBeneficios() {
        String[] beneficios = new String[] {"Acceso a máquinas", "Casillero incluido"};
        return beneficios;
    }
}
