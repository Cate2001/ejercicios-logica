package com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.fitlife.app;

import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.fitlife.model.Miembro;
import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.fitlife.model.MiembroEstandar;
import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.fitlife.model.MiembroEstudiantil;
import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.fitlife.model.MiembroVip;
import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.fitlife.enums.TipoMembresia;
import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.fitlife.enums.DiaSemana;
import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.fitlife.services.GimnasioService;

/**
 * Clase principal de demostración del sistema de gimnasio FitLife.
 * <p>
 * Esta clase contiene un conjunto de pruebas exhaustivas que demuestran
 * el funcionamiento del sistema, incluyendo:
 * </p>
 * <ul>
 * <li>Creación y registro de diferentes tipos de miembros (Estándar, Estudiantil, VIP)</li>
 * <li>Validación de campos y manejo de excepciones</li>
 * <li>Registro y control de asistencias</li>
 * <li>Cálculo de pagos mensuales y estadísticas del gimnasio</li>
 * <li>Búsqueda y comparación de miembros</li>
 * <li>Verificación de funcionalidades de enumeraciones</li>
 * </ul>
 * <p>
 * Las pruebas están diseñadas para validar todos los aspectos funcionales
 * del sistema, incluyendo casos de éxito y casos de error esperados.
 * </p>
 *
 * @author Caterine Salinas Bolaños
 * @version 1.0
 */
public class Main {
    /**
     * Método principal que ejecuta todas las pruebas del sistema.
     * <p>
     * Realiza 17 pruebas diferentes que cubren:
     * </p>
     * <ol>
     * <li>Registro de miembro estándar</li>
     * <li>Registro de miembro estudiantil</li>
     * <li>Registro de miembro VIP</li>
     * <li>Prevención de duplicados por cédula</li>
     * <li>Registro de asistencias</li>
     * <li>Manejo de cédulas inexistentes</li>
     * <li>Visualización de miembros registrados</li>
     * <li>Cálculo de estadísticas del gimnasio</li>
     * <li>Búsqueda de miembros por cédula</li>
     * <li>Validación de edad fuera de rango</li>
     * <li>Validación de nombre vacío</li>
     * <li>Validación de universidad inválida (estudiantil)</li>
     * <li>Validación de semestre fuera de rango (estudiantil)</li>
     * <li>Validación de entrenador personal inválido (VIP)</li>
     * <li>Comparación de miembros con equals</li>
     * <li>Verificación de días de fin de semana</li>
     * <li>Información de tipos de membresía</li>
     * </ol>
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {

        System.out.println("=== SISTEMA DE GIMNASIO FITLIFE ===\n");

        GimnasioService gimnasio = new GimnasioService();

        // =====================================================
        // PRUEBA 1: Crear y registrar Miembro Estándar
        // =====================================================
        System.out.println("--- PRUEBA 1: MIEMBRO ESTÁNDAR ---");
        try {
            MiembroEstandar miembroEstandar = new MiembroEstandar(
                    "Carlos",
                    "123456789",
                    25,
                    TipoMembresia.ESTANDAR
            );
            gimnasio.registrarMiembro(miembroEstandar);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        System.out.println();

        // =====================================================
        // PRUEBA 2: Crear y registrar Miembro Estudiantil
        // =====================================================
        System.out.println("--- PRUEBA 2: MIEMBRO ESTUDIANTIL ---");
        try {
            MiembroEstudiantil miembroEstudiantil = new MiembroEstudiantil(
                    "Ana",
                    "987654321",
                    20,
                    TipoMembresia.ESTUDIANTIL,
                    "Universidad Nacional",
                    5
            );
            gimnasio.registrarMiembro(miembroEstudiantil);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        System.out.println();

        // =====================================================
        // PRUEBA 3: Crear y registrar Miembro VIP
        // =====================================================
        System.out.println("--- PRUEBA 3: MIEMBRO VIP ---");
        try {
            MiembroVip miembroVip = new MiembroVip(
                    "Pedro",
                    "456789123",
                    30,
                    TipoMembresia.VIP,
                    "Juan Pérez"
            );
            gimnasio.registrarMiembro(miembroVip);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        System.out.println();

        // =====================================================
        // PRUEBA 4: Intentar registrar miembro duplicado (misma cédula)
        // =====================================================
        System.out.println("--- PRUEBA 4: MIEMBRO DUPLICADO ---");
        try {
            MiembroEstandar duplicado = new MiembroEstandar(
                    "Carlos Duplicate",
                    "123456789",
                    28,
                    TipoMembresia.BASICO
            );
            gimnasio.registrarMiembro(duplicado);
        } catch (Exception e) {
            System.out.println("ERROR ESPERADO: " + e.getMessage());
        }
        System.out.println();

        // =====================================================
        // PRUEBA 5: Registrar asistencias
        // =====================================================
        System.out.println("--- PRUEBA 5: REGISTRO DE ASISTENCIAS ---");
        gimnasio.registrarAsistencia("123456789", DiaSemana.LUNES);
        gimnasio.registrarAsistencia("123456789", DiaSemana.MIERCOLES);
        gimnasio.registrarAsistencia("987654321", DiaSemana.MARTES);
        gimnasio.registrarAsistencia("456789123", DiaSemana.LUNES);
        gimnasio.registrarAsistencia("456789123", DiaSemana.VIERNES);
        System.out.println();

        // =====================================================
        // PRUEBA 6: Intentar registrar asistencia con cédula inexistente
        // =====================================================
        System.out.println("--- PRUEBA 6: ASISTENCIA CON CÉDULA INEXISTENTE ---");
        gimnasio.registrarAsistencia("999999999", DiaSemana.LUNES);
        System.out.println();

        // =====================================================
        // PRUEBA 7: Mostrar todos los miembros
        // =====================================================
        System.out.println("--- PRUEBA 7: MOSTRAR MIEMBROS ---");
        gimnasio.mostrarMiembros();
        System.out.println();

        // =====================================================
        // PRUEBA 8: Mostrar estadísticas del gimnasio
        // =====================================================
        System.out.println("--- PRUEBA 8: ESTADÍSTICAS ---");
        gimnasio.mostrarEstadisticas();
        System.out.println();

        // =====================================================
        // PRUEBA 9: Buscar miembro por cédula
        // =====================================================
        System.out.println("--- PRUEBA 9: BUSCAR MIEMBRO ---");
        Miembro encontrado = gimnasio.buscarMiembro("987654321");
        if (encontrado != null) {
            System.out.println("Miembro encontrado: " + encontrado.getNombre() + " - " + encontrado.getTipo());
        } else {
            System.out.println("Miembro no encontrado");
        }
        System.out.println();

        // =====================================================
        // PRUEBA 10: Validación - Edad fuera de rango
        // =====================================================
        System.out.println("--- PRUEBA 10: VALIDACIÓN EDAD FUERA DE RANGO ---");
        try {
            MiembroEstandar edadInvalida = new MiembroEstandar(
                    "Juan",
                    "111111111",
                    10,
                    TipoMembresia.BASICO
            );
        } catch (Exception e) {
            System.out.println("ERROR ESPERADO: " + e.getMessage());
        }
        System.out.println();

        // =====================================================
        // PRUEBA 11: Validación - Nombre vacío
        // =====================================================
        System.out.println("--- PRUEBA 11: VALIDACIÓN NOMBRE VACÍO ---");
        try {
            MiembroEstandar nombreVacio = new MiembroEstandar(
                    "",
                    "222222222",
                    25,
                    TipoMembresia.BASICO
            );
        } catch (Exception e) {
            System.out.println("ERROR ESPERADO: " + e.getMessage());
        }
        System.out.println();

        // =====================================================
        // PRUEBA 12: Validación - Universidad inválida (estudiantil)
        // =====================================================
        System.out.println("--- PRUEBA 12: VALIDACIÓN UNIVERSIDAD INVÁLIDA ---");
        try {
            MiembroEstudiantil universidadInvalida = new MiembroEstudiantil(
                    "Maria",
                    "333333333",
                    22,
                    TipoMembresia.ESTUDIANTIL,
                    "AB",
                    3
            );
        } catch (Exception e) {
            System.out.println("ERROR ESPERADO: " + e.getMessage());
        }
        System.out.println();

        // =====================================================
        // PRUEBA 13: Validación - Semestre fuera de rango (estudiantil)
        // =====================================================
        System.out.println("--- PRUEBA 13: VALIDACIÓN SEMESTRE FUERA DE RANGO ---");
        try {
            MiembroEstudiantil semestreInvalido = new MiembroEstudiantil(
                    "Luis",
                    "444444444",
                    21,
                    TipoMembresia.ESTUDIANTIL,
                    "Universidad",
                    15
            );
        } catch (Exception e) {
            System.out.println("ERROR ESPERADO: " + e.getMessage());
        }
        System.out.println();

        // =====================================================
        // PRUEBA 14: Validación - Entrenador personal inválido (VIP)
        // =====================================================
        System.out.println("--- PRUEBA 14: VALIDACIÓN ENTRENADOR PERSONAL INVÁLIDO ---");
        try {
            MiembroVip entrenadorInvalido = new MiembroVip(
                    "Sofia",
                    "555555555",
                    28,
                    TipoMembresia.VIP,
                    "AB"
            );
        } catch (Exception e) {
            System.out.println("ERROR ESPERADO: " + e.getMessage());
        }
        System.out.println();

        // =====================================================
        // PRUEBA 15: Comparación de miembros con equals
        // =====================================================
        System.out.println("--- PRUEBA 15: COMPARACIÓN DE MIEMBROS (equals) ---");
        MiembroEstandar miembro1 = new MiembroEstandar("Test1", "666666666", 25, TipoMembresia.BASICO);
        MiembroEstandar miembro2 = new MiembroEstandar("Test2", "666666666", 30, TipoMembresia.ESTANDAR);
        MiembroEstandar miembro3 = new MiembroEstandar("Test3", "777777777", 25, TipoMembresia.BASICO);

        System.out.println("miembro1.equals(miembro2) [misma cédula]: " + miembro1.equals(miembro2));
        System.out.println("miembro1.equals(miembro3) [diferente cédula]: " + miembro1.equals(miembro3));
        System.out.println();

        // =====================================================
        // PRUEBA 16: Verificar días de fin de semana
        // =====================================================
        System.out.println("--- PRUEBA 16: DÍAS DE FIN DE SEMANA ---");
        System.out.println("Sábado es fin de semana: " + DiaSemana.SABADO.esFinDeSemana());
        System.out.println("Domingo es fin de semana: " + DiaSemana.DOMINGO.esFinDeSemana());
        System.out.println("Lunes es fin de semana: " + DiaSemana.LUNES.esFinDeSemana());
        System.out.println();

        // =====================================================
        // PRUEBA 17: Información de tipos de membresía
        // =====================================================
        System.out.println("--- PRUEBA 17: INFORMACIÓN DE TIPOS DE MEMBRESÍA ---");
        System.out.println("BÁSICO - Precio: $" + TipoMembresia.BASICO.getPrecioBase() + 
                          ", Descuento: " + TipoMembresia.BASICO.getDescuento() + "%" +
                          ", Acceso: " + TipoMembresia.BASICO.getDescripcionAcceso());
        System.out.println("ESTÁNDAR - Precio: $" + TipoMembresia.ESTANDAR.getPrecioBase() + 
                          ", Descuento: " + TipoMembresia.ESTANDAR.getDescuento() + "%" +
                          ", Acceso: " + TipoMembresia.ESTANDAR.getDescripcionAcceso());
        System.out.println("VIP - Precio: $" + TipoMembresia.VIP.getPrecioBase() + 
                          ", Descuento: " + TipoMembresia.VIP.getDescuento() + "%" +
                          ", Acceso: " + TipoMembresia.VIP.getDescripcionAcceso());
        System.out.println("ESTUDIANTIL - Precio: $" + TipoMembresia.ESTUDIANTIL.getPrecioBase() + 
                          ", Descuento: " + TipoMembresia.ESTUDIANTIL.getDescuento() + "%" +
                          ", Acceso: " + TipoMembresia.ESTUDIANTIL.getDescripcionAcceso());
        System.out.println();

        System.out.println("=== TODAS LAS PRUEBAS COMPLETADAS ===");

    }
}
