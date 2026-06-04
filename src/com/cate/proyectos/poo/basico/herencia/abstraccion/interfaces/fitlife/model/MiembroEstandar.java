package com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.fitlife.model;

import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.fitlife.enums.TipoMembresia;

/**
 * Representa un miembro estándar del gimnasio FitLife.
 * <p>
 * Esta clase extiende de {@link Miembro} e implementa el comportamiento
 * específico para miembros con membresía estándar, que incluye acceso
 * a todas las instalaciones del gimnasio con beneficios básicos.
 * </p>
 * <p>
 * Características:
 * <ul>
 * <li>Acceso a máquinas y equipos del gimnasio</li>
 * <li>Casillero incluido para almacenamiento personal</li>
 * <li>Pago mensual basado en el precio con descuento de la membresía</li>
 * <li>Sin beneficios adicionales especiales</li>
 * </ul>
 * </p>
 *
 * @author Caterine Salinas Bolaños
 * @version 1.0
 * @see Miembro
 * @see TipoMembresia
 */
public class MiembroEstandar extends Miembro {

    /**
     * Constructor que inicializa un miembro estándar.
     * <p>
     * Hereda la validación de campos de la clase padre {@link Miembro},
     * asegurando que nombre, cédula y edad cumplan con los requisitos.
     * </p>
     *
     * @param nombre el nombre completo del miembro
     * @param cedula el número de identificación del miembro
     * @param edad la edad del miembro (14-90 años)
     * @param membresia el tipo de membresía asignada
     * @throws IllegalArgumentException si los parámetros no cumplen las validaciones de la clase padre
     */
    public MiembroEstandar(String nombre, String cedula, int edad, TipoMembresia membresia) {
        super(nombre, cedula, edad, membresia);
    }

    /**
     * Calcula el pago mensual del miembro estándar.
     * <p>
     * Retorna el precio de la membresía con el descuento base aplicado,
     * sin modificaciones adicionales.
     * </p>
     *
     * @return el pago mensual correspondiente a la membresía estándar
     */
    @Override
    public double calcularPagoMensual() {
        return getMembresia().getPrecioConDescuento();
    }

    /**
     * Retorna el tipo de miembro.
     *
     * @return "ESTANDAR" como identificador del tipo de membresía
     */
    @Override
    public String getTipo() {
        return "ESTANDAR";
    }

    /**
     * Retorna los beneficios disponibles para membresía estándar.
     * <p>
     * Los beneficios incluyen acceso a equipos del gimnasio y
     * uso de casillero para almacenamiento personal.
     * </p>
     *
     * @return arreglo con los beneficios de membresía estándar
     */
    @Override
    public String[] getBeneficios() {
        String[] beneficios = new String[] {"Acceso a máquinas", "Casillero incluido"};
        return beneficios;
    }
}
