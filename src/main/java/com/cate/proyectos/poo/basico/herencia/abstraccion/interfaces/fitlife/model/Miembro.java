package com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.fitlife.model;

import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.fitlife.enums.DiaSemana;
import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.fitlife.enums.TipoMembresia;

import java.util.Arrays;
import java.util.Objects;

/**
 * Clase abstracta que representa un miembro del gimnasio FitLife.
 * <p>
 * Esta clase define la estructura base para todos los tipos de miembros del gimnasio,
 * estableciendo los atributos comunes y comportamientos fundamentales que deben
 * implementar las clases concretas ({@link MiembroEstandar}, {@link MiembroEstudiantil}, {@link MiembroVip}).
 * </p>
 * <p>
 * Responsabilidades:
 * <ul>
 * <li>Almacenar información personal del miembro (nombre, cédula, edad)</li>
 * <li>Gestionar el tipo de membresía y estado de activación</li>
 * <li>Registrar y controlar asistencias por día de la semana</li>
 * <li>Validar campos obligatorios (nombre, cédula, edad)</li>
 * <li>Mantener contador estático de total de miembros registrados</li>
 * <li>Definir métodos abstractos para cálculo de pagos y beneficios</li>
 * </ul>
 * </p>
 * <p>
 * Validaciones aplicadas:
 * <ul>
 * <li>Nombre y cédula: no pueden ser nulos o vacíos</li>
 * <li>Edad: debe estar entre 14 y 90 años</li>
 * </ul>
 * </p>
 *
 * @author Caterine Salinas Bolaños
 * @version 1.0
 * @see MiembroEstandar
 * @see MiembroEstudiantil
 * @see MiembroVip
 * @see TipoMembresia
 * @see DiaSemana
 */
public abstract class Miembro {
    /**
     * Nombre completo del miembro.
     */
    private String nombre;

    /**
     * Número de identificación (cédula) del miembro.
     * Este campo se utiliza como identificador único para comparaciones.
     */
    private String cedula;

    /**
     * Edad del miembro en años.
     * Debe estar entre 14 y 90 años.
     */
    private int edad;

    /**
     * Tipo de membresía asignada al miembro.
     */
    private TipoMembresia tipoMembresia;

    /**
     * Arreglo que registra la cantidad de asistencias por cada día de la semana.
     * Índices: 0=Lunes, 1=Martes, 2=Miércoles, 3=Jueves, 4=Viernes, 5=Sábado, 6=Domingo
     */
    private int[] diasAsistencia;

    /**
     * Estado de activación del miembro en el gimnasio.
     */
    private boolean activo;

    /**
     * Contador estático que mantiene el total de miembros registrados en el sistema.
     */
    private static int totalMiembros;

    /**
     * Descuento por cumpleaños aplicable (10%).
     * Constante definida para futura implementación de cálculos especiales.
     */
    private final static double DESCUENTO_CUMPLEAÑOS = 0.10;

    /**
     * Arreglo con todos los días de la semana disponibles para registro de asistencia.
     */
    DiaSemana[] diasSemana = DiaSemana.values();
    /**
     * Constructor que inicializa un miembro del gimnasio.
     * <p>
     * Valida los campos obligatorios antes de la asignación e inicializa
     * el arreglo de asistencias con ceros para todos los días de la semana.
     * Incrementa automáticamente el contador estático de miembros.
     * </p>
     *
     * @param nombre el nombre completo del miembro (no puede ser nulo o vacío)
     * @param cedula el número de identificación (no puede ser nulo o vacío)
     * @param edad la edad del miembro (debe estar entre 14 y 90 años)
     * @param membresia el tipo de membresía asignada
     * @throws IllegalArgumentException si nombre o cédula son nulos/vacíos, o si edad está fuera de rango
     */
    public Miembro(String nombre, String cedula, int edad, TipoMembresia membresia) {
        validarCamposString(nombre);
        validarCamposString(cedula);
        validarEdad(edad);
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.tipoMembresia = membresia;
        this.diasAsistencia = new int[] {0, 0, 0, 0, 0, 0, 0};
        this.totalMiembros++;
    }

    /**
     * Retorna el nombre completo del miembro.
     *
     * @return el nombre del miembro
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Retorna el número de cédula del miembro.
     *
     * @return la cédula del miembro
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Retorna la edad del miembro.
     *
     * @return la edad en años
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Retorna el tipo de membresía asignada al miembro.
     *
     * @return el tipo de membresía
     */
    public TipoMembresia getMembresia() {
        return tipoMembresia;
    }

    /**
     * Retorna el total de miembros registrados en el sistema.
     * <p>
     * Este valor es estático y se incrementa cada vez que se crea
     * una nueva instancia de cualquier subclase de {@link Miembro}.
     * </p>
     *
     * @return el total de miembros registrados
     */
    public static int getTotalMiembros() {
        return totalMiembros;
    }

    /**
     * Valida que un campo de tipo String no sea nulo o vacío.
     *
     * @param campo el campo a validar
     * @throws IllegalArgumentException si el campo es nulo o está en blanco
     */
    private void validarCamposString(String campo){
        if (campo == null || campo.isBlank())throw new IllegalArgumentException("Debe agregar un valor diferente a vacío");
    }

    /**
     * Valida que la edad esté dentro del rango permitido.
     *
     * @param valor la edad a validar
     * @throws IllegalArgumentException si la edad es menor a 14 o mayor a 90
     */
    private void validarEdad(int valor){
        if (valor < 14 || valor > 90) {
            throw new IllegalArgumentException("La edad debe estar en el rango 14 y 90 años");
        }
    }
    /**
     * Registra la asistencia del miembro para un día específico de la semana.
     * <p>
     * Incrementa el contador de asistencias para el día correspondiente.
     * Cada invocación incrementa el contador en 1 para ese día específico.
     * </p>
     *
     * @param dia el día de la semana a registrar
     * @return true si se registró la asistencia correctamente, false si el día no es válido
     */
    public boolean registrarAsistencia(DiaSemana dia){
        int cont = 0;
        for (int i = 0; i < diasSemana.length; i++) {
            if (!dia.equals(diasSemana[i])) continue;
            diasAsistencia[i] = ++cont;
            return true;
        }
        return false;
    }

    /**
     * Calcula el total de asistencias acumuladas del miembro.
     * <p>
     * Suma todas las asistencias registradas en los diferentes días de la semana.
     * </p>
     *
     * @return el total de asistencias del miembro
     */
    public int getTotalAsistencias(){
        int contadorAsistencias = 0;
        for (int asistencia : diasAsistencia){
            contadorAsistencias += asistencia;
        }
        return contadorAsistencias;
    }

    /**
     * Establece el estado de activación del miembro.
     *
     * @param activo true para activar el miembro, false para desactivarlo
     */
    public void setActivo(boolean activo){
        this.activo = activo;
    }

    /**
     * Verifica si el miembro está activo en el gimnasio.
     *
     * @return true si el miembro está activo, false en caso contrario
     */
    public boolean isActivo(){
        return this.activo;
    }

    /**
     * Calcula el pago mensual correspondiente al tipo de membresía.
     * <p>
     * Cada subclase debe implementar su propia lógica de cálculo
     * según los beneficios y descuentos aplicables.
     * </p>
     *
     * @return el pago mensual a cobrar
     */
    public abstract double calcularPagoMensual();

    /**
     * Retorna el tipo específico de miembro.
     * <p>
     * Cada subclase debe retornar su identificador de tipo
     * (ej: "ESTANDAR", "ESTUDIANTIL", "VIP").
     * </p>
     *
     * @return el tipo de miembro como cadena de texto
     */
    public abstract String getTipo();

    /**
     * Retorna el arreglo de beneficios disponibles para el tipo de membresía.
     * <p>
     * Cada subclase debe definir sus propios beneficios específicos
     * según el tipo de membresía.
     * </p>
     *
     * @return arreglo con los beneficios disponibles
     */
    public abstract String[] getBeneficios();

    /**
     * Compara este miembro con otro objeto para determinar igualdad.
     * <p>
     * Dos miembros se consideran iguales si tienen la misma cédula,
     * independientemente de otros atributos.
     * </p>
     *
     * @param o el objeto a comparar
     * @return true si los objetos son iguales, false en caso contrario
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Miembro miembro = (Miembro) o;
        return Objects.equals(cedula, miembro.cedula);
    }

    /**
     * Genera el código hash basado en la cédula del miembro.
     * <p>
     * Consistente con {@link #equals(Object)} para garantizar
     * el correcto funcionamiento en colecciones hash-based.
     * </p>
     *
     * @return el código hash del miembro
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(cedula);
    }

    /**
     * Retorna una representación en cadena del miembro.
     * <p>
     * Incluye todos los atributos principales del miembro en formato legible.
     * </p>
     *
     * @return representación en cadena del miembro
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Miembro{");
        sb.append(" nombre = '").append(nombre).append('\'');
        sb.append(", cedula = '").append(cedula).append('\'');
        sb.append(", edad = ").append(edad);
        sb.append(", membresia = ").append(tipoMembresia);
        sb.append(", diasAsistencia = ").append(Arrays.toString(diasAsistencia));
        sb.append(", activo = ").append(activo);
        sb.append(", diasSemana = ").append(Arrays.toString(diasSemana));
        sb.append('}');
        return sb.toString();
    }
}
