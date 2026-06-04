package com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SGVE.app;

import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SGVE.enums.EstadoVehiculo;
import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SGVE.model.Camion;
import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SGVE.model.Dron;
import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SGVE.model.Moto;
import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SGVE.model.Vehiculo;
import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SGVE.services.VehiculoService;

/**
 * Clase principal de demostración del Sistema de Gestión de Vehículos de Envío (SGVE).
 * <p>
 * Esta clase contiene un conjunto exhaustivo de pruebas que demuestran el funcionamiento
 * del sistema, incluyendo:
 * </p>
 * <ul>
 * <li>Creación y operación de diferentes tipos de vehículos (Dron, Moto, Camión)</li>
 * <li>Implementación de interfaces (GPS, Recargable)</li>
 * <li>Gestión de vehículos mediante VehiculoService</li>
 * <li>Cálculo de costos de envío personalizados por tipo de vehículo</li>
 * <li>Búsqueda y filtrado de vehículos por estado y placa</li>
 * <li>Validación de dominio y manejo de excepciones</li>
 * </ul>
 * <p>
 * Las pruebas están diseñadas para validar todos los aspectos funcionales del sistema,
 * incluyendo casos de éxito y casos de error esperados para validar las validaciones
 * de dominio implementadas.
 * </p>
 *
 * @author Caterine Salinas Bolaños
 * @version 1.0
 */
public class Main {
    /**
     * Método principal que ejecuta todas las pruebas del sistema SGVE.
     * <p>
     * Realiza 19 pruebas diferentes que cubren:
     * </p>
     * <ol>
     * <li>Creación y operación de Dron (ubicación GPS, recarga de batería, cálculo de costo)</li>
     * <li>Creación y operación de Moto (ubicación GPS, cálculo de costo)</li>
     * <li>Creación y operación de Camión (ubicación GPS, cálculo de costo con peajes)</li>
     * <li>Registro de vehículos en VehiculoService</li>
     * <li>Cálculo de costos de envío mediante el servicio</li>
     * <li>Búsqueda de vehículos por placa</li>
     * <li>Filtrado de vehículos por estado (DISPONIBLE)</li>
     * <li>Validación: Dron con batería insuficiente (< 20%)</li>
     * <li>Validación: Vehículo con placa nula</li>
     * <li>Validación: Vehículo con capacidad negativa</li>
     * <li>Validación: Registro de vehículo null en servicio</li>
     * <li>Validación: Cálculo de costos con vehículo null</li>
     * <li>Validación: Mostrar vehículos sin registros previos</li>
     * <li>Validación: Búsqueda por placa vacía</li>
     * <li>Validación: Búsqueda por placa null</li>
     * <li>Validación: Dron con valores negativos (batería, altura, consumo)</li>
     * <li>Validación: Moto con valores negativos (cilindraje, consumo)</li>
     * <li>Validación: Camión con valores negativos (ejes, carga, peajes)</li>
     * <li>Búsqueda de vehículo no existente</li>
     * </ol>
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    static void main(String[] args) {
        // Crear instancia del servicio
        VehiculoService servicio = new VehiculoService();

        // Prueba 1: Crear y probar Dron
        System.out.println("=== PRUEBA 1: DRON ===");
        Dron dron = new Dron("DRN-001", "DJI", 5.0, EstadoVehiculo.DISPONIBLE, 50.0, 80, 120.0, 2.5);
        System.out.println("Dron creado: " + dron.toString());
        System.out.println("Ubicación: " + dron.obtenerUbicacion());
        System.out.println("Costo envío: " + dron.calcularCostoEnvio());
        System.out.println("Nivel batería antes de recarga: " + dron.getNivelBateria());
        dron.recargarBateria();
        System.out.println("Nivel batería después de recarga: " + dron.getNivelBateria());
        System.out.println();

        // Prueba 2: Crear y probar Moto
        System.out.println("=== PRUEBA 2: MOTO ===");
        Moto moto = new Moto("MOT-001", "Honda", 20.0, EstadoVehiculo.DISPONIBLE, 100.0, 150, 0.05);
        System.out.println("Moto creada: " + moto.toString());
        System.out.println("Ubicación: " + moto.obtenerUbicacion());
        System.out.println("Costo envío: " + moto.calcularCostoEnvio());
        System.out.println();

        // Prueba 3: Crear y probar Camion
        System.out.println("=== PRUEBA 3: CAMIÓN ===");
        Camion camion = new Camion("CAM-001", "Volvo", 10000.0, EstadoVehiculo.DISPONIBLE, 500.0, 6, 5000.0, 15000.0);
        System.out.println("Camión creado: " + camion.toString());
        System.out.println("Ubicación: " + camion.obtenerUbicacion());
        System.out.println("Costo envío: " + camion.calcularCostoEnvio());
        System.out.println();

        // Prueba 4: Probar VehiculoService
        System.out.println("=== PRUEBA 4: VEHICULO SERVICE ===");
        servicio.registrarVehiculo(dron);
        servicio.registrarVehiculo(moto);
        System.out.println("Vehículos registrados exitosamente");
        System.out.println();

        // Prueba 5: Calcular costos
        System.out.println("=== PRUEBA 5: CALCULAR COSTOS ===");
        System.out.println("Costo envío dron: " + servicio.calcularCostos(dron));
        System.out.println("Costo envío moto: " + servicio.calcularCostos(moto));
        System.out.println();

        // Prueba 6: Buscar por placa
        System.out.println("=== PRUEBA 6: BUSCAR POR PLACA ===");
        Vehiculo encontrado = servicio.buscarPorPlaca("DRN-001");
        if (encontrado != null) {
            System.out.println("Vehículo encontrado: " + encontrado.toString());
        } else {
            System.out.println("Vehículo no encontrado");
        }
        System.out.println();

        // Prueba 7: Cambiar estado y mostrar disponibles
        System.out.println("=== PRUEBA 7: MOSTRAR DISPONIBLES ===");
        moto.setEstado(EstadoVehiculo.EN_RUTA);
        servicio.mostrarDisponibles();
        System.out.println();

        // Prueba 8: Excepción - Dron con batería insuficiente
        System.out.println("=== PRUEBA 8: EXCEPCIÓN - DRON BATERÍA INSUFICIENTE ===");
        try {
            Dron dronSinBateria = new Dron("DRN-002", "DJI", 5.0, EstadoVehiculo.DISPONIBLE, 50.0, 10, 120.0, 2.5);
            dronSinBateria.calcularCostoEnvio();
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
        }
        System.out.println();

        // Prueba 9: Excepción - Vehículo con placa nula
        System.out.println("=== PRUEBA 9: EXCEPCIÓN - PLACA NULA ===");
        try {
            Moto motoInvalida = new Moto(null, "Honda", 20.0, EstadoVehiculo.DISPONIBLE, 100.0, 150, 0.05);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
        }
        System.out.println();

        // Prueba 10: Excepción - Vehículo con capacidad negativa
        System.out.println("=== PRUEBA 10: EXCEPCIÓN - CAPACIDAD NEGATIVA ===");
        try {
            Camion camionInvalido = new Camion("CAM-002", "Volvo", -100.0, EstadoVehiculo.DISPONIBLE, 500.0, 6, 5000.0, 15000.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
        }
        System.out.println();

        // Prueba 11: Excepción - VehiculoService registrar null
        System.out.println("=== PRUEBA 11: EXCEPCIÓN - REGISTRAR VEHÍCULO NULL ===");
        try {
            servicio.registrarVehiculo(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
        }
        System.out.println();

        // Prueba 12: Excepción - VehiculoService calcular costos con null
        System.out.println("=== PRUEBA 12: EXCEPCIÓN - CALCULAR COSTOS CON NULL ===");
        try {
            servicio.calcularCostos(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
        }
        System.out.println();

        // Prueba 13: Excepción - VehiculoService mostrar vehículos sin registrar
        System.out.println("=== PRUEBA 13: EXCEPCIÓN - MOSTRAR SIN REGISTRAR ===");
        VehiculoService servicioVacio = new VehiculoService();
        try {
            servicioVacio.mostrarVehiculos();
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
        }
        System.out.println();

        // Prueba 14: Excepción - VehiculoService buscar por placa vacía
        System.out.println("=== PRUEBA 14: EXCEPCIÓN - BUSCAR POR PLACA VACÍA ===");
        try {
            servicio.buscarPorPlaca("");
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
        }
        System.out.println();

        // Prueba 15: Excepción - VehiculoService buscar por placa null
        System.out.println("=== PRUEBA 15: EXCEPCIÓN - BUSCAR POR PLACA NULL ===");
        try {
            servicio.buscarPorPlaca(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
        }
        System.out.println();

        // Prueba 16: Excepción - Dron con valores negativos
        System.out.println("=== PRUEBA 16: EXCEPCIÓN - DRON VALORES NEGATIVOS ===");
        try {
            Dron dronInvalido = new Dron("DRN-003", "DJI", 5.0, EstadoVehiculo.DISPONIBLE, 50.0, -10, -120.0, -2.5);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
        }
        System.out.println();

        // Prueba 17: Excepción - Moto con valores negativos
        System.out.println("=== PRUEBA 17: EXCEPCIÓN - MOTO VALORES NEGATIVOS ===");
        try {
            Moto motoInvalida = new Moto("MOT-002", "Honda", 20.0, EstadoVehiculo.DISPONIBLE, 100.0, -150, -0.05);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
        }
        System.out.println();

        // Prueba 18: Excepción - Camion con valores negativos
        System.out.println("=== PRUEBA 18: EXCEPCIÓN - CAMIÓN VALORES NEGATIVOS ===");
        try {
            Camion camionInvalido = new Camion("CAM-003", "Volvo", 10000.0, EstadoVehiculo.DISPONIBLE, 500.0, -6, -5000.0, -15000.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
        }
        System.out.println();

        // Prueba 19: Búsqueda de vehículo no existente
        System.out.println("=== PRUEBA 19: BÚSQUEDA VEHÍCULO NO EXISTENTE ===");
        Vehiculo noEncontrado = servicio.buscarPorPlaca("XXX-999");
        if (noEncontrado == null) {
            System.out.println("Búsqueda correcta: vehículo no encontrado (null)");
        }
        System.out.println();

        System.out.println("=== TODAS LAS PRUEBAS COMPLETADAS ===");
    }
}
