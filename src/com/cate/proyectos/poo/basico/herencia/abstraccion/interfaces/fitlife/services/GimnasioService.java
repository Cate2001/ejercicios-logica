package com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.fitlife.services;

import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.fitlife.model.Miembro;
import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.fitlife.enums.DiaSemana;
import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.fitlife.util.Calculadora;

import java.util.Arrays;

/**
 * Servicio de gestión del gimnasio FitLife.
 * <p>
 * Esta clase administra las operaciones principales del gimnasio,
 * incluyendo el registro de miembros, cálculo de ingresos y
 * gestión de asistencias.
 * </p>
 * <p>
 * Responsabilidades:
 * <ul>
 * <li>Administrar el registro de miembros</li>
 * <li>Calcular ingresos mensuales del gimnasio</li>
 * <li>Mostrar estadísticas de miembros</li>
 * <li>Validar duplicados por cédula</li>
 * </ul>
 * </p>
 *
 * @author Caterine Salinas Bolaños
 * @version 1.0
 */
public class GimnasioService {

    /**
     * Arreglo que contiene los miembros registrados en el gimnasio.
     */
    private Miembro[] miembros;

    /**
     * Índice actual para agregar nuevos miembros.
     */
    private int indice;

    /**
     * Capacidad máxima de miembros del gimnasio.
     */
    private static final int CAPACIDAD_MAXIMA = 10;

    /**
     * Constructor que inicializa el servicio del gimnasio.
     */
    public GimnasioService() {
        this.miembros = new Miembro[CAPACIDAD_MAXIMA];
        this.indice = 0;
    }

    /**
     * Registra un nuevo miembro en el gimnasio.
     * <p>
     * Valida que el miembro no sea null, que no exista otro miembro
     * con la misma cédula, y que no se haya excedido la capacidad máxima.
     * </p>
     *
     * @param miembro el miembro a registrar
     * @throws IllegalArgumentException si el miembro es null o ya existe
     * @throws IllegalStateException si la capacidad máxima ha sido alcanzada
     */
    public void registrarMiembro(Miembro miembro) {
        if (miembro == null) {
            throw new IllegalArgumentException("El miembro no puede ser null");
        }

        if (existeMiembro(miembro.getCedula())) {
            throw new IllegalArgumentException("Ya existe un miembro con la cédula: " + miembro.getCedula());
        }

        if (indice >= miembros.length) {
            throw new IllegalStateException("Capacidad máxima de miembros alcanzada (" + CAPACIDAD_MAXIMA + ")");
        }

        miembros[indice] = miembro;
        indice++;
        System.out.println("✅ Miembro registrado exitosamente: " + miembro.getNombre());
    }

    /**
     * Verifica si existe un miembro con la cédula especificada.
     *
     * @param cedula la cédula a buscar
     * @return true si existe un miembro con esa cédula, false en caso contrario
     */
    private boolean existeMiembro(String cedula) {
        for (int i = 0; i < indice; i++) {
            if (miembros[i] != null && miembros[i].getCedula().equals(cedula)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Busca un miembro por su cédula.
     *
     * @param cedula la cédula del miembro a buscar
     * @return el miembro encontrado, o null si no existe
     */
    public Miembro buscarMiembro(String cedula) {
        for (int i = 0; i < indice; i++) {
            if (miembros[i] != null && miembros[i].getCedula().equals(cedula)) {
                return miembros[i];
            }
        }
        return null;
    }

    /**
     * Calcula el total de ingresos mensuales del gimnasio.
     * <p>
     * Suma los pagos mensuales de todos los miembros registrados.
     * </p>
     *
     * @return el total de ingresos mensuales
     */
    public double calcularIngresosMensuales() {
        double total = 0.0;
        for (int i = 0; i < indice; i++) {
            if (miembros[i] != null) {
                total += miembros[i].calcularPagoMensual();
            }
        }
        return total;
    }

    /**
     * Calcula el total de ingresos mensuales con IVA incluido.
     *
     * @return el total de ingresos mensuales con IVA
     */
    public double calcularIngresosMensualesConIVA() {
        double ingresosSinIVA = calcularIngresosMensuales();
        return Calculadora.calcularPrecioConIVA(ingresosSinIVA);
    }

    /**
     * Muestra la información de todos los miembros registrados.
     */
    public void mostrarMiembros() {
        if (indice == 0) {
            System.out.println("No hay miembros registrados en el gimnasio.");
            return;
        }

        System.out.println("\n=== MIEMBROS REGISTRADOS EN EL GIMNASIO ===");
        for (int i = 0; i < indice; i++) {
            if (miembros[i] != null) {
                System.out.println("\n" + (i + 1) + ". " + miembros[i].getTipo());
                System.out.println("   Nombre: " + miembros[i].getNombre());
                System.out.println("   Cédula: " + miembros[i].getCedula());
                System.out.println("   Edad: " + miembros[i].getEdad());
                System.out.println("   Membresía: " + miembros[i].getMembresia());
                System.out.println("   Pago Mensual: $" + miembros[i].calcularPagoMensual());
                System.out.println("   Beneficios: " + Arrays.toString(miembros[i].getBeneficios()));
                System.out.println("   Total Asistencias: " + miembros[i].getTotalAsistencias());
            }
        }
    }

    /**
     * Muestra estadísticas del gimnasio.
     */
    public void mostrarEstadisticas() {
        System.out.println("\n=== ESTADÍSTICAS DEL GIMNASIO ===");
        System.out.println("Total de miembros: " + indice);
        System.out.println("Total de miembros (estático): " + Miembro.getTotalMiembros());
        System.out.println("Ingresos mensuales (sin IVA): $" + calcularIngresosMensuales());
        System.out.println("Ingresos mensuales (con IVA): $" + calcularIngresosMensualesConIVA());
        System.out.println("IVA (19%): $" + Calculadora.calcularIVA(calcularIngresosMensuales()));
    }

    /**
     * Registra la asistencia de un miembro en un día específico.
     *
     * @param cedula la cédula del miembro
     * @param dia el día de la semana
     * @return true si se registró la asistencia, false en caso contrario
     */
    public boolean registrarAsistencia(String cedula, DiaSemana dia) {
        Miembro miembro = buscarMiembro(cedula);
        if (miembro == null) {
            System.out.println("❌ No se encontró miembro con cédula: " + cedula);
            return false;
        }

        boolean registrado = miembro.registrarAsistencia(dia);
        if (registrado) {
            System.out.println("✅ Asistencia registrada para " + miembro.getNombre() + " el día " + dia);
        } else {
            System.out.println("❌ No se pudo registrar la asistencia");
        }
        return registrado;
    }

    /**
     * Retorna el arreglo de miembros registrados.
     *
     * @return el arreglo de miembros
     */
    public Miembro[] getMiembros() {
        return miembros;
    }

    /**
     * Retorna la cantidad de miembros registrados.
     *
     * @return la cantidad de miembros
     */
    public int getCantidadMiembros() {
        return indice;
    }
}
