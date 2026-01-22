package POO.SIGRAV;

public class Vuelo {
    //La clase Vuelo (la Transacción) tiene la responsabilidad de
    // unir el ORIGEN y DESTINO con un Avion y
    // calcular el costo final de la operación.

    //Atributos
    private final String ORIGEN;
    private final String DESTINO;
    private Avion avionAsignado;
    private double costoFinal;

    //Constructor
    public Vuelo(String ORIGEN, String DESTINO) {
        this.ORIGEN = ORIGEN;
        this.DESTINO = DESTINO;
        this.costoFinal = 0.0;
        this.avionAsignado = null;
    }

    //Metodos
    public void asignarAvion(Avion avion) {
        this.avionAsignado = avion;
    }

    // --- Lógica Principal con Validaciones ---
    // Dentro de la clase Vuelo, debajo de asignarAvion()

    public void calcularCostoFinal(RutaAerea mapaRutas) {

        // 1. Obtener el costo base de la ruta (usa la lógica de escala)
        int costoRuta = mapaRutas.encontrarPrimeraRuta(this.ORIGEN, this.DESTINO);

        if (costoRuta == -1) {
            // La ruta no existe (ciudad inválida o no se encontró escala)
            this.costoFinal = -1.0;
            System.out.println("⛔ ERROR (" + this.ORIGEN + " -> " + this.DESTINO + "): No se encontró una ruta válida (directa o con una escala).");

        } else if (this.avionAsignado == null) {
            // El avión no ha sido asignado.
            this.costoFinal = -1.0;
            System.out.println("⚠️ ERROR (" + this.ORIGEN + " -> " + this.DESTINO + "): No se puede calcular el costo. No hay avión asignado.");

        } else {
            // Cálculo Final: Costo de la Ruta + Costo Fijo de Operación del Avión
            double costoOperacionAvion = this.avionAsignado.getCOSTO_OPERACION_BASE();

            // Convertimos el costoRuta a double para la suma
            this.costoFinal = (double) costoRuta + costoOperacionAvion;
            System.out.println("✅ Cálculo Exitoso para Vuelo " + this.ORIGEN + " -> " + this.DESTINO);
        }
    }

    // ** MÉTODOS GETTERS PARA MOSTRAR EN MAIN **
    public double getCostoFinal() {
        return costoFinal;
    }

    public Avion getAvionAsignado() {
        return avionAsignado;
    }



}
