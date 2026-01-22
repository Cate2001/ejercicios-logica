package POO.SIMAP;

public class Parqueadero {
    //maneja la lógica de ocupación y cálculo.

    private int espaciosDisponibles;
    private double tarifaPorHora;
    private Vehiculo[] vehiculosOcupando;

    //Constructor
    public Parqueadero(int espaciosDisponibles, double tarifaPorHora){
        this.espaciosDisponibles = espaciosDisponibles;
        this.tarifaPorHora = tarifaPorHora;
        this.vehiculosOcupando = new Vehiculo[espaciosDisponibles];
    }

    //Metodos
    public void registrarEntrada(Vehiculo v){
        for (int i = 0; i < this.vehiculosOcupando.length; i++) {
            if (this.vehiculosOcupando[i] == null){
                this.vehiculosOcupando[i] = v;
                System.out.println("✅ Entrada exitosa. Espacio: " + i);
                return;

            }
        }

        System.out.println("❌ Error: Parqueadero lleno. Capacidad máxima alcanzada.");

    }

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
