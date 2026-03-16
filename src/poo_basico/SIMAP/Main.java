package POO.SIMAP;

public class Main {
    public static void main(String[] args) {

        //Creamos objeto vehiculo
        Vehiculo vehiculo1 = new Vehiculo("XL567", 1024, "Moto");
        Vehiculo vehiculo2 = new Vehiculo("DCF46", "Carro");

        //Creamos objeto parqueadero
        Parqueadero parqueadero1 = new Parqueadero(2, 10000);
        parqueadero1.registrarEntrada(vehiculo1);
        parqueadero1.registrarEntrada(vehiculo2);
        parqueadero1.registrarEntrada(vehiculo1);

        parqueadero1.registrarSalida("XL567", 1200);
        parqueadero1.registrarSalida("cdfd", 1245);

        parqueadero1.getEspaciosLibres();





    }
}
