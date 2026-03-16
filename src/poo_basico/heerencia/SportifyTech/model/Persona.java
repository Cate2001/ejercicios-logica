package POO.heerencia.SportifyTech.model;

public class Persona {
    private String nombre;
    private String apellidos;
    private int edad;
    private int vasosDeAgua;
    private double peso;
    private double estatura;
    private static final int CANTIDAD_MINIMA = 6;

    public Persona(String nombre, String apellidos, int edad, int vasosDeAgua, double peso, double estatura) {
        setNombre(nombre);
        setApellidos(apellidos);
        setEdad(edad);
        setVasosDeAgua(vasosDeAgua);
        setPeso(peso);
        setEstatura(estatura);
    }

    //Metodos auxiliares para validar atributos de mi clase
    private void validarAtributosStringNulos(String valor) {
        if (valor == null) {
            throw new IllegalArgumentException("El valor ingresado no puede ser nulo");
        }
    }

    private void validarAtributosDoubleNulos(double valor){
        if (valor <= 0){
            throw new IllegalArgumentException("¡Valor ingresado incorrecto! El valor debe ser mayor a 0");
        }
    }

    //Metodos getters and setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        validarAtributosStringNulos(nombre);
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        validarAtributosStringNulos(apellidos);
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad < 12) {
            throw new IllegalArgumentException("El rango de edad permitida debe ser mayor o igual a 12 años");
        }
        this.edad = edad;
    }

    public int getVasosDeAgua() {
        return vasosDeAgua;
    }

    public void setVasosDeAgua(int vasosDeAgua) {
        if (vasosDeAgua < 0){
            throw new IllegalArgumentException("El valor no puede ser negativo");
        }
        this.vasosDeAgua = vasosDeAgua;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        validarAtributosDoubleNulos(peso);
        this.peso = peso;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        validarAtributosDoubleNulos(estatura);
        this.estatura = estatura;
    }

    // validar cantidad Minima de agua consumida por día
    public boolean validarCantidadAguaConsumida() {
        return this.vasosDeAgua >= CANTIDAD_MINIMA;
    }

    public double validarIMC() {
        double calculoEstatura = this.estatura * this.estatura;
        double calculoIMC = this.peso / calculoEstatura;

        return calculoIMC;
    }


}


