package proyectos_poo.poo_basico.herencia_abstraccion_interfaces.SGVE.app;

import proyectos_poo.poo_basico.herencia_abstraccion_interfaces.SGVE.enums.EstadoVehiculo;
import proyectos_poo.poo_basico.herencia_abstraccion_interfaces.SGVE.model.Camion;
import proyectos_poo.poo_basico.herencia_abstraccion_interfaces.SGVE.model.Dron;
import proyectos_poo.poo_basico.herencia_abstraccion_interfaces.SGVE.model.Moto;
import proyectos_poo.poo_basico.herencia_abstraccion_interfaces.SGVE.model.Vehiculo;
import proyectos_poo.poo_basico.herencia_abstraccion_interfaces.SGVE.services.VehiculoService;

public class Main {
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
