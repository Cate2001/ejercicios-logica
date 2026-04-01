package POO.SIGRAV.dominio;

public class Avion {

    //Responsabilidad: Modelar las características operativas y los costos fijos de un avión.

    private final String MODELO;
    private final int CAPACIDAD_PASAJEROS;
    private final double COSTO_OPERACION_BASE;

    //Constructor
    public Avion(String MODELO, int capacidadPasajeros){
        this.MODELO = MODELO;
        this.CAPACIDAD_PASAJEROS = capacidadPasajeros;
        this.COSTO_OPERACION_BASE = 500.00;

    }

    // Getters (Solo Lectura)

    public String getMODELO() {
        return MODELO;
    }

    public int getCAPACIDAD_PASAJEROS() {
        return CAPACIDAD_PASAJEROS;
    }

    public double getCOSTO_OPERACION_BASE() {
        return COSTO_OPERACION_BASE;
    }

    // Nota: No se implementan setters, pues las características de un avión son inmutables.
}
