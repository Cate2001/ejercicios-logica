package com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.fitlife.util;

/**
 * Clase de utilidades para cálculos financieros del gimnasio FitLife.
 * <p>
 * Proporciona métodos estáticos para el cálculo de IVA (Impuesto al Valor Agregado)
 * y precios finales con impuestos incluidos, siguiendo la tasa impositiva vigente
 * en Colombia (19%).
 * </p>
 * <p>
 * Esta clase sigue el patrón Utility Class con constructor privado para evitar
 * instanciación, ya que todos sus métodos son estáticos.
 * </p>
 * <p>
 * Tasa impositiva: 19% (IVA estándar en Colombia)
 * </p>
 *
 * @author Caterine Salinas Bolaños
 * @version 1.0
 */
public class Calculadora {

    /**
     * Tasa del IVA (Impuesto al Valor Agregado) en Colombia: 19%.
     */
    private static final double TASA_IVA = 0.19;

    /**
     * Constructor privado para evitar instanciación de la clase de utilidades.
     * <p>
     * Esta clase solo contiene métodos estáticos, por lo que no debe ser instanciada.
     * </p>
     */
    private Calculadora(){}

    /**
     * Calcula el valor del IVA para un precio dado.
     * <p>
     * Aplica la tasa impositiva del 19% sobre el precio base proporcionado.
     * </p>
     *
     * @param precio el precio base sobre el cual calcular el IVA
     * @return el valor del IVA correspondiente al 19% del precio
     */
    public static double calcularIVA(double precio){
        double iva = precio * TASA_IVA;
        return iva;
    }

    /**
     * Calcula el precio final incluyendo IVA.
     * <p>
     * Suma al precio base el valor del IVA calculado al 19%.
     * </p>
     *
     * @param precio el precio base sin IVA
     * @return el precio final con IVA incluido
     */
    public static double calcularPrecioConIVA(double precio){
        double iva = calcularIVA(precio);
        double precioIVA = precio + iva;
        return precioIVA;
    }

}
