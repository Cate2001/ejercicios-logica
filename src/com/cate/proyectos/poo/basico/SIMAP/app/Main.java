package com.cate.proyectos.poo.basico.SIMAP.app;

import com.cate.proyectos.poo.basico.SIMAP.model.Parqueadero;
import com.cate.proyectos.poo.basico.SIMAP.model.Vehiculo;

/**
 * Clase principal de demostración del Sistema de Gestión de Parqueaderos (SIMAP).
 * <p>
 * Esta clase contiene pruebas que demuestran el funcionamiento del sistema,
 * incluyendo registro de entradas/salidas de vehículos y cálculo de tarifas.
 * </p>
 * <p>
 * Las pruebas validan:
 * </p>
 * <ul>
 * <li>Creación de vehículos con placa, hora de entrada y tipo</li>
 * <li>Registro de entrada de vehículos en el parqueadero</li>
 * <li>Prevención de entrada cuando el parqueadero está lleno</li>
 * <li>Registro de salida y cálculo de costos basado en tiempo de estadía</li>
 * <li>Manejo de errores cuando la placa no existe</li>
 * <li>Cálculo de espacios libres disponibles</li>
 * </ul>
 *
 * @author Caterine Salinas Bolaños
 * @version 1.0
 */
public class Main {
    /**
     * Método principal que ejecuta las pruebas del sistema SIMAP.
     * <p>
     * Realiza pruebas que cubren:
     * </p>
     * <ol>
     * <li>Creación de vehículos (moto y carro)</li>
     * <li>Creación de parqueadero con capacidad 2 y tarifa $10,000/hora</li>
     * <li>Registro de entradas exitosas</li>
     * <li>Intento de entrada con parqueadero lleno (error esperado)</li>
     * <li>Verificación de espacios libres</li>
     * <li>Registro de salida con cálculo de costo</li>
     * <li>Intento de salida con placa incorrecta (error esperado)</li>
     * <li>Verificación de espacios libres después de salida</li>
     * </ol>
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
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
