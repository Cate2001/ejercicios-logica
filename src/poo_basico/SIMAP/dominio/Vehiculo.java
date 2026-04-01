package POO.SIMAP.dominio;

import java.time.LocalTime;

public class Vehiculo {
    private String placa;
    private int horaEntrada;
    private String tipo;

    //Contructores
    public Vehiculo(String placa, int horaEntrada, String tipo) {
        setPlaca(placa);
        this.horaEntrada = horaEntrada;
        this.tipo = tipo;
    }
    public Vehiculo(String placa, String tipo){
        setPlaca(placa);
        this.tipo = tipo;
        this.horaEntrada = LocalTime.now().getHour();
    }

    //Getters and setters
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String nuevaPlaca) {
        if (nuevaPlaca != null && !nuevaPlaca.trim().isEmpty()) {
            this.placa = nuevaPlaca;
        } else {
            System.err.println("Error: La placa no puede ser nula o vacía.");
        }
    }

    public int getHoraEntrada() {
        return horaEntrada;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
