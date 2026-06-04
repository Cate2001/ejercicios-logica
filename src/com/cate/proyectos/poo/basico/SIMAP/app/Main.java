package com.cate.proyectos.poo.basico.SIMAP.app;

import com.cate.proyectos.poo.basico.SIMAP.model.Parqueadero;
import com.cate.proyectos.poo.basico.SIMAP.model.Vehiculo;



public class Main {
    public static void main(String[] args) {

        System.out.println("=== SISTEMA DE GESTIÓN DE PARQUEADEROS (SIMAP) ===\n");

        //Creamos objeto vehiculo
        Vehiculo vehiculo1 = new Vehiculo("XL567", 1024, "Moto");
        Vehiculo vehiculo2 = new Vehiculo("DCF46", "Carro");

        System.out.println("--- VEHÍCULOS CREADOS ---");
        System.out.println("Vehículo 1: Placa=" + vehiculo1.getPlaca() + ", Hora Entrada=" + vehiculo1.getHoraEntrada() + ", Tipo=" + vehiculo1.getTipo());
        System.out.println("Vehículo 2: Placa=" + vehiculo2.getPlaca() + ", Hora Entrada=" + vehiculo2.getHoraEntrada() + ", Tipo=" + vehiculo2.getTipo());
        System.out.println();

        //Creamos objeto parqueadero
        Parqueadero parqueadero1 = new Parqueadero(2, 10000);
        System.out.println("--- PARQUEADERO CREADO ---");
        System.out.println("Capacidad: 2 espacios");
        System.out.println("Tarifa: $10,000 por hora");
        System.out.println();

        System.out.println("--- REGISTRO DE ENTRADAS ---");
        parqueadero1.registrarEntrada(vehiculo1);
        parqueadero1.registrarEntrada(vehiculo2);
        System.out.println();

        System.out.println("--- INTENTO DE ENTRADA CON PARQUEADERO LLENO ---");
        parqueadero1.registrarEntrada(vehiculo1);
        System.out.println();

        System.out.println("--- ESPACIOS LIBRES DESPUÉS DE ENTRADAS ---");
        parqueadero1.getEspaciosLibres();
        System.out.println();

        System.out.println("--- REGISTRO DE SALIDAS ---");
        double costo1 = parqueadero1.registrarSalida("XL567", 1200);
        System.out.println("Costo pagado por vehículo XL567: $" + costo1);
        System.out.println();

        System.out.println("--- INTENTO DE SALIDA CON PLACA INCORRECTA ---");
        double costo2 = parqueadero1.registrarSalida("cdfd", 1245);
        System.out.println("Costo pagado por vehículo cdfd: $" + costo2);
        System.out.println();

        System.out.println("--- ESPACIOS LIBRES DESPUÉS DE SALIDA ---");
        parqueadero1.getEspaciosLibres();
        System.out.println();

        System.out.println("=== FIN DEL PROGRAMA ===");

    }
}
