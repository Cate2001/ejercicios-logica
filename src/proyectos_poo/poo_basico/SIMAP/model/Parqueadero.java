package proyectos_poo.poo_basico.SIMAP.model;

/**
 * Representa un parqueadero en el sistema de gestión de parqueaderos.
 * <p>
 * Esta clase maneja la lógica de ocupación de espacios y cálculo de tarifas.
 * Administra un arreglo de vehículos y calcula los costos basándose en el tiempo
 * de estadía y la tarifa por hora configurada.
 * </p>
 * <p>
 * Responsabilidades:
 * <ul>
 * <li>Administrar la capacidad de espacios disponibles</li>
 * <li>Registrar la entrada de vehículos</li>
 * <li>Registrar la salida de vehículos y calcular costos</li>
 * <li>Calcular espacios libres disponibles</li>
 * </ul>
 * </p>
 *
 * @author Caterine Salinas Bolaños
 * @version 1.0
 */
public class Parqueadero {

    /**
     * Cantidad total de espacios disponibles en el parqueadero.
     */
    private int espaciosDisponibles;

    /**
     * Tarifa por hora que se cobra por el uso del parqueadero.
     */
    private double tarifaPorHora;

    /**
     * Arreglo que contiene los vehículos actualmente ocupando espacios.
     * Las posiciones null indican espacios libres.
     */
    private Vehiculo[] vehiculosOcupando;

    /**
     * Constructor que inicializa un parqueadero con capacidad y tarifa.
     *
     * @param espaciosDisponibles la cantidad total de espacios del parqueadero
     * @param tarifaPorHora la tarifa a cobrar por cada hora de estadía
     * @throws IllegalArgumentException si espaciosDisponibles es menor o igual a cero,
     *                                  o si tarifaPorHora es negativa
     */
    public Parqueadero(int espaciosDisponibles, double tarifaPorHora){
        if (espaciosDisponibles <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor a cero");
        }
        if (tarifaPorHora < 0) {
            throw new IllegalArgumentException("La tarifa no puede ser negativa");
        }
        this.espaciosDisponibles = espaciosDisponibles;
        this.tarifaPorHora = tarifaPorHora;
        this.vehiculosOcupando = new Vehiculo[espaciosDisponibles];
    }

    /**
     * Registra la entrada de un vehículo al parqueadero.
     * <p>
     * Busca el primer espacio disponible y asigna el vehículo.
     * Si el parqueadero está lleno, imprime un mensaje de error.
     * </p>
     *
     * @param v el vehículo a registrar (no puede ser null)
     * @throws IllegalArgumentException si el vehículo es null
     */
    public void registrarEntrada(Vehiculo v){
        if (v == null) {
            throw new IllegalArgumentException("El vehículo no puede ser null");
        }
        for (int i = 0; i < this.vehiculosOcupando.length; i++) {
            if (this.vehiculosOcupando[i] == null){
                this.vehiculosOcupando[i] = v;
                System.out.println("✅ Entrada exitosa. Espacio: " + i);
                return;

            }
        }

        System.out.println("❌ Error: Parqueadero lleno. Capacidad máxima alcanzada.");

    }

    /**
     * Registra la salida de un vehículo y calcula el costo a pagar.
     * <p>
     * Busca el vehículo por su placa, calcula el tiempo de estadía,
     * y aplica la tarifa por hora. El tiempo mínimo cobrado es 1 hora.
     * </p>
     * <p>
     * Fórmula de cálculo:
     * <code>costo = max(1, horaSalida - horaEntrada) * tarifaPorHora</code>
     * </p>
     *
     * @param placa la placa del vehículo a buscar
     * @param horaSalida la hora de salida del vehículo (0-23)
     * @return el costo total a pagar, o 0.0 si no se encuentra el vehículo
     */
    public double registrarSalida(String placa, int horaSalida){

        //Buscar dentro del arreglo si existe una placa que conincida
        for (int i = 0; i < this.vehiculosOcupando.length; i++) {
            if (this.vehiculosOcupando[i] != null && this.vehiculosOcupando[i].getPlaca().equals(placa)){
                int horas = horaSalida - this.vehiculosOcupando[i].getHoraEntrada();
                // Si el tiempo es cero o negativo, cobrar al menos una hora
                if (horas <= 0) {
                    horas = 1;
                }

                double costo = horas * this.tarifaPorHora;

                //Liberamos el espacio en el parqueadero
                this.vehiculosOcupando[i] = null;

                System.out.println("✅ Salida registrada. Costo total: " + costo);
                return costo;
            }
        }
        System.out.println("❌ Error: Placa no encontrada en el parqueadero.");
        return 0.0; // <-- Tu retorno de error.
    }

    /**
     * Calcula y retorna la cantidad de espacios libres en el parqueadero.
     * <p>
     * Cuenta las posiciones null en el arreglo de vehículos ocupando.
     * </p>
     *
     * @return la cantidad de espacios libres disponibles
     */
    public int getEspaciosLibres(){
        int contadorEspacioLibres = 0;
        for (Vehiculo vehiculo : this.vehiculosOcupando) {
            if (vehiculo == null) {
                contadorEspacioLibres++;
            }
        }
        System.out.println("La cantidad de espacios libres en el parqueadero es: " + contadorEspacioLibres);
        return contadorEspacioLibres;
    }
}
