package POO.SIGRAV.app;

import POO.SIGRAV.dominio.RutaAerea;
import POO.SIGRAV.dominio.Vuelo;
import POO.SIGRAV.dominio.Avion;

public class Main {
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