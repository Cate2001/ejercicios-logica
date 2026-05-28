package proyectos_poo.poo_basico.herencia_abstraccion_interfaces.fitlife.model;

import proyectos_poo.poo_basico.herencia_abstraccion_interfaces.fitlife.enums.DiaSemana;
import proyectos_poo.poo_basico.herencia_abstraccion_interfaces.fitlife.enums.TipoMembresia;

import java.util.Arrays;
import java.util.Objects;

public abstract class Miembro {
    private String nombre;
    private String cedula;
    private int edad;
    private TipoMembresia tipoMembresia;
    private int[] diasAsistencia;
    private boolean activo;
    private static int totalMiembros;
    private final static double DESCUENTO_CUMPLEAÑOS = 0.10;
    DiaSemana[] diasSemana = DiaSemana.values();
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

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public int getEdad() {
        return edad;
    }

    public TipoMembresia getMembresia() {
        return tipoMembresia;
    }

    public static int getTotalMiembros() {
        return totalMiembros;
    }

    private void validarCamposString(String campo){
        if (campo == null || campo.isBlank())throw new IllegalArgumentException("Debe agregar un valor diferente a vacío");
    }
    private void validarEdad(int valor){
        if (valor < 14 || valor > 90) {
            throw new IllegalArgumentException("La edad debe estar en el rango 14 y 90 años");
        }
    }
    public boolean registrarAsistencia(DiaSemana dia){
        int cont = 0;
        for (int i = 0; i < diasSemana.length; i++) {
            if (!dia.equals(diasSemana[i])) continue;
            diasAsistencia[i] = ++cont;
            return true;
        }
        return false;
    }

    public int getTotalAsistencias(){
        int contadorAsistencias = 0;
        for (int asistencia : diasAsistencia){
            contadorAsistencias += asistencia;
        }
        return contadorAsistencias;
    }

    public void setActivo(boolean activo){
        this.activo = activo;
    }

    public boolean isActivo(){
        return this.activo;
    }

    //Metodos abstractos
    abstract double  calcularPagoMensual();
    abstract String getTipo();
    abstract String[] getBeneficios();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Miembro miembro = (Miembro) o;
        return Objects.equals(cedula, miembro.cedula);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cedula);
    }

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
