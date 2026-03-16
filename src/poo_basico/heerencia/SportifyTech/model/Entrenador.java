package POO.heerencia.SportifyTech.model;

public class Entrenador extends Persona {
    private String especialidadDeportiva;
    private int aniosExperiencia;
    private Competidor[] listaDeCompetidores;
    private static final int MAX_COMPETIDORES = 10;
    private int cantidadCompetidores = 0;

    public Entrenador(String nombre, String apellidos, int edad, int vasosDeAgua, double peso, double estatura, String especialidadDeportiva,
                      int aniosExperiencia) {
        super(nombre, apellidos, edad, vasosDeAgua, peso, estatura);
        setEspecialidadDeportiva(especialidadDeportiva);
        setAniosExperiencia(aniosExperiencia);
        this.listaDeCompetidores = new Competidor[MAX_COMPETIDORES];
        this.cantidadCompetidores = 0;
    }

    public String getEspecialidadDeportiva() {
        return especialidadDeportiva;
    }

    public void setEspecialidadDeportiva(String especialidadDeportiva) {
        if (especialidadDeportiva == null){
            throw new IllegalArgumentException("La especialidad no puede ir nula");
        }
        this.especialidadDeportiva = especialidadDeportiva;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        if (aniosExperiencia < 2){
            throw new IllegalArgumentException("El entrenador no cumple con el minimo valor de años de experiencia");
        }
        this.aniosExperiencia = aniosExperiencia;
    }

    //Metodos
    private boolean buscarCompetidor(Competidor competidor){
        if (competidor == null){
            throw new IllegalArgumentException("El competidor no puede ser nulo");
        }

        for (int i = 0; i < listaDeCompetidores.length; i++) {
            if (listaDeCompetidores[i] == null) continue;
            if (competidor.equals(listaDeCompetidores[i])) return true;

        }
        return false;
    }

    public void agregarCompetidor(Competidor competidor) {
        if (competidor == null) {
            throw new IllegalArgumentException("El campo no puede estar nulo");
        }

        if (cantidadCompetidores >= listaDeCompetidores.length) {
            throw new IllegalArgumentException("El entrenador ya tiene asignado la cantidad de competidores máxima que puede entrenar");
        }

        if (cantidadCompetidores > 0) {
            if (buscarCompetidor(competidor)) {
                throw new IllegalStateException("El competidor ya tiene asignado el entrenador");
            }
        }

        for (int i = 0; i < listaDeCompetidores.length; i++) {
            if (listaDeCompetidores[i] != null) continue;
            listaDeCompetidores[i] = competidor;
            cantidadCompetidores++;
            competidor.setEntrenador(this);
            break;
        }
    }


    public boolean eliminarCompetidor(Competidor competidor){
        if (competidor == null){
            throw new IllegalArgumentException("El campo no puede estar nulo");
        }
        for (int i = 0; i < listaDeCompetidores.length; i++) {
            if (listaDeCompetidores[i] == null) continue;
            if (listaDeCompetidores[i].equals(competidor)) {
                listaDeCompetidores[i] = null;
                cantidadCompetidores--;
                return true;
            }
        }
        return false;
    }

    public int calcularCredibilidadFisica(){
        double imc = validarIMC();
        int credibilidad = 100;

        if (imc < 18.5 || imc > 30) {
            credibilidad -= 30;
        }

        if (!validarCantidadAguaConsumida()) {
            credibilidad -= 20;
        }

        return credibilidad;
    }

    @Override
    public String toString() {
        String info = "Entrenador:\n";
        info += "Nombre: " + getNombre() + "\n";
        info += "Apellidos: " + getApellidos() + "\n";
        info += "Edad: " + getEdad() + "\n";
        info += "Vasos de agua: " + getVasosDeAgua() + "\n";
        info += "Peso: " + getPeso() + "\n";
        info += "Estatura: " + getEstatura() + "\n";
        info += "Especialidad deportiva: " + this.especialidadDeportiva + "\n";
        info += "Años de experiencia: " + this.aniosExperiencia + "\n";
        info += "Competidores asignados:\n";

        for(Competidor competidor: listaDeCompetidores){
            if (competidor != null) {
                info +=  "- " + competidor.getNombre() + "\n";
            }
        }

        return info;
    }
}

