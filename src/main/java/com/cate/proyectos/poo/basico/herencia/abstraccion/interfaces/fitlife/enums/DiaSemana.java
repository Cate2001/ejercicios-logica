package com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.fitlife.enums;

/**
 * Enumeración que define los días de la semana.
 * <p>
 * Esta enumeración representa los días de la semana con un indicador
 * de si es día laboral o fin de semana.
 * </p>
 *
 * @author Caterine Salinas Bolaños
 * @version 1.0
 */
public enum DiaSemana {
    /**
     * Día lunes (laboral).
     */
    LUNES(true),
    
    /**
     * Día martes (laboral).
     */
    MARTES(true),
    
    /**
     * Día miércoles (laboral).
     */
    MIERCOLES(true),
    
    /**
     * Día jueves (laboral).
     */
    JUEVES(true),
    
    /**
     * Día viernes (laboral).
     */
    VIERNES(true),
    
    /**
     * Día sábado (fin de semana).
     */
    SABADO(false),
    
    /**
     * Día domingo (fin de semana).
     */
    DOMINGO(false);
    
    /**
     * Indica si el día es laboral.
     */
    private boolean laboral;

    /**
     * Constructor que inicializa un día de la semana.
     *
     * @param b true si es día laboral, false si es fin de semana
     */
    DiaSemana(boolean b) {
        this.laboral = b;
    }

    /**
     * Determina si el día es fin de semana.
     *
     * @return true si es fin de semana, false si es día laboral
     */
    public boolean esFinDeSemana() {return !laboral;}
}
