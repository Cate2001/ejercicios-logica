package com.cate.proyectos.poo.basico.SIGRAV.app;

import com.cate.proyectos.poo.basico.SIGRAV.model.Avion;
import com.cate.proyectos.poo.basico.SIGRAV.model.RutaAerea;
import com.cate.proyectos.poo.basico.SIGRAV.model.Vuelo;

/**
 * Clase principal de demostración del Sistema de Gestión de Rutas Aéreas (SIGRAV).
 * <p>
 * Esta clase contiene pruebas que demuestran el funcionamiento del sistema,
 * incluyendo cálculo de costos de vuelos con rutas directas y con escalas.
 * </p>
 * <p>
 * Las pruebas validan:
 * </p>
 * <ul>
 * <li>Cálculo de costos para rutas directas (A -> B)</li>
 * <li>Cálculo de costos para rutas con escalas (A -> C)</li>
 * <li>Detección de rutas imposibles (A -> Z)</li>
 * <li>Asignación de aviones a vuelos</li>
 * <li>Validación de costos finales (ruta + operación del avión)</li>
 * </ul>
 *
 * @author Caterine Salinas Bolaños
 * @version 1.0
 */
public class Main {
    /**
     * Método principal que ejecuta las pruebas del sistema SIGRAV.
     * <p>
     * Realiza 3 pruebas que cubren:
     * </p>
     * <ol>
     * <li>RUTA DIRECTA: Vuelo de A a B con costo de ruta $100 + costo operación avión $500 = $600</li>
     * <li>RUTA CON ESCALA: Vuelo de A a C con escala en B (A->B $100 + B->C $150 = $250) + costo operación avión $500 = $750</li>
     * <li>RUTA IMPOSIBLE: Vuelo de A a Z (no existe ruta) retorna costo -1.0</li>
     * </ol>
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {

        // 1. INICIALIZAR EL MOTOR DE COSTOS
        RutaAerea mapa = new RutaAerea();

        // 2. CREAR INSTANCIAS DE AVIONES (con tu costo base de 500.00)
        Avion airbus320 = new Avion("Airbus A320", 120);

        // --- PRUEBA 1: RUTA DIRECTA (A -> B) ---
        Vuelo vueloDirecto = new Vuelo("A", "B"); // Costo Base Ruta: 100
        vueloDirecto.asignarAvion(airbus320);
        vueloDirecto.calcularCostoFinal(mapa);

        System.out.println("\n--- PRUEBA 1: RUTA DIRECTA (A -> B) ---");
        System.out.println("Costo Ruta (A->B): " + mapa.encontrarPrimeraRuta("A", "B"));
        System.out.println("Costo Operación Avión: " + airbus320.getCOSTO_OPERACION_BASE());
        System.out.printf("COSTO FINAL: $%.2f%n", vueloDirecto.getCostoFinal()); // Esperado: 100 + 500 = 600.00

        System.out.println("----------------------------------------");


        // --- PRUEBA 2: RUTA CON ESCALA (A -> C) ---
        Vuelo vueloEscala = new Vuelo("A", "C"); // Escala A->B(100) -> C(150). Costo Base Ruta: 250
        vueloEscala.asignarAvion(airbus320);
        vueloEscala.calcularCostoFinal(mapa);

        System.out.println("\n--- PRUEBA 2: RUTA CON ESCALA (A -> C) ---");
        System.out.println("Costo Ruta (A->C): " + mapa.encontrarPrimeraRuta("A", "C")); // Debería ser 250
        System.out.println("Costo Operación Avión: " + airbus320.getCOSTO_OPERACION_BASE());
        System.out.printf("COSTO FINAL: $%.2f%n", vueloEscala.getCostoFinal()); // Esperado: 250 + 500 = 750.00

        System.out.println("----------------------------------------");


        // --- PRUEBA 3: RUTA IMPOSIBLE (A -> Z) ---
        Vuelo vueloInvalido = new Vuelo("A", "Z");
        vueloInvalido.asignarAvion(airbus320);
        vueloInvalido.calcularCostoFinal(mapa);

        System.out.println("\n--- PRUEBA 3: RUTA IMPOSIBLE (A -> Z) ---");
        System.out.println("Costo Ruta (A->Z): " + mapa.encontrarPrimeraRuta("A", "Z")); // Debería ser -1
        System.out.println("COSTO FINAL: " + vueloInvalido.getCostoFinal()); // Esperado: -1.0

    }
}