package proyectos_poo.poo_basico.herencia_abstraccion_interfaces.fitlife.enums;

/**
 * Enumeración que define los tipos de membresía disponibles en el gimnasio.
 * <p>
 * Esta enumeración representa las diferentes categorías de membresía
 * con sus precios base, descripciones de acceso y porcentajes de descuento.
 * </p>
 *
 * @author Caterine Salinas Bolaños
 * @version 1.0
 */
public enum TipoMembresia {
    /**
     * Membresía básica con acceso de lunes a viernes.
     */
    BASICO(80.000, "Lunes a Viernes", 0),
    
    /**
     * Membresía estándar con acceso todos los días.
     */
    ESTANDAR(120.000, "Todos los días", 5),
    
    /**
     * Membresía VIP con acceso 24/7 y clases incluidas.
     */
    VIP(200.000, "24/7 + Clases", 15),
    
    /**
     * Membresía estudiantil con acceso de lunes a viernes y descuento especial.
     */
    ESTUDIANTIL(60.000, "Lunes a Viernes", 20);

    /**
     * Precio base de la membresía.
     */
    private final double precioBase;

    /**
     * Descripción de los días de acceso disponibles.
     */
    private final String descripcionAcceso ;

    /**
     * Porcentaje de descuento aplicable a la membresía.
     */
    private final double descuento;

    /**
     * Constructor que inicializa un tipo de membresía.
     *
     * @param precio el precio base de la membresía
     * @param descripcionAcceso la descripción de los días de acceso
     * @param descuento el porcentaje de descuento aplicable
     */
    TipoMembresia(double precio, String descripcionAcceso, double descuento) {
        this.precioBase = precio;
        this.descripcionAcceso = descripcionAcceso;
        this.descuento = descuento;
    }

    /**
     * Retorna el precio base de la membresía.
     *
     * @return el precio base
     */
    public double getPrecioBase() {
        return precioBase;
    }

    /**
     * Retorna el porcentaje de descuento de la membresía.
     *
     * @return el porcentaje de descuento
     */
    public double getDescuento() {
        return descuento;
    }

    /**
     * Retorna la descripción de los días de acceso.
     *
     * @return la descripción de acceso
     */
    public String getDescripcionAcceso() {
        return descripcionAcceso;
    }

    /**
     * Calcula el precio con descuento aplicado.
     * <p>
     * Aplica un descuento fijo del 5% sobre el precio base.
     * </p>
     *
     * @return el precio final con descuento aplicado
     */
    public double getPrecioConDescuento() {
        double descuento = this.precioBase * (5/100);
        double precioFinal = this.precioBase - descuento;
        return precioFinal;
    }

}
