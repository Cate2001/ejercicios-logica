package com.cate.practica.nuevos.conceptos.colecciones.SGB.model;

import com.cate.practica.nuevos.conceptos.colecciones.SGB.enums.DiaSemana;
import com.cate.practica.nuevos.conceptos.colecciones.SGB.util.Constantes;
import com.cate.practica.nuevos.conceptos.colecciones.SGB.util.GeneradorId;
import com.cate.practica.nuevos.conceptos.colecciones.SGB.util.Validaciones;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Clase abastracta: Representa la biblioteca.
 *
 * @author Cate
 */
public class Biblioteca {
    private final int id; // Identificador único de la biblioteca
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private static final Map<DiaSemana, String> horarios = new LinkedHashMap<>();

    // Agregamos en un arreglo los días de la semana del Enum DiaSemana
    private static final DiaSemana[] DiaSemanaArr = DiaSemana.values();

    public Biblioteca(String nombre, String direccion, String telefono, String email) {
        this.id = GeneradorId.generarIdBiblioteca();
        setNombre(nombre);
        setDireccion(direccion);
        setTelefono(telefono);
        setEmail(email);
        cargarHorarioBiblioteca();
    }

    //Getters y Setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        Validaciones.validarNullVacio(nombre, "Nombre");
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        Validaciones.validarNullVacio(direccion, "Dirección");
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        Validaciones.validarTelefono(telefono);
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Validaciones.validarEmail(email);
        this.email = email;
    }

    private static void cargarHorarioBiblioteca() {
        for (DiaSemana dia : DiaSemanaArr) {
            if (dia.equals(DiaSemana.DOMINGO)) {
                horarios.put(dia, Constantes.HORARIO_DOMINGO);
            } else if (dia.equals(DiaSemana.SABADO)) {
                horarios.put(dia, Constantes.HORARIO_SABADO);
            } else {
                horarios.put(dia, Constantes.HORARIO_DIAS_ENTRE_SEMANA);
            }
        }
    }

    public void MostrarHorarioBiblioteca() {
        for (Map.Entry<DiaSemana, String> horario : horarios.entrySet()) {
            System.out.println(horario.getKey() + " -> " + horario.getValue());
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Biblioteca{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", direccion='").append(direccion).append('\'');
        sb.append(", telefono='").append(telefono).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}


