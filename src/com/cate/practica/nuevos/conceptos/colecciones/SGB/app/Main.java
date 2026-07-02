package com.cate.practica.nuevos.conceptos.colecciones.SGB.app;

import com.cate.practica.nuevos.conceptos.colecciones.SGB.enums.*;
import com.cate.practica.nuevos.conceptos.colecciones.SGB.model.*;

public class Main {
    public static void main(String[] args) {
        Libro libro = new Libro( "Libro", Idioma.ESPAÑOL, Disponinilidad.DISPONIBLE, Categoria.ROMANCE, "Io", 400, 123456789);
        libro.setDisponible(Disponinilidad.NO_DISPONIBLE);
        System.out.println(libro);

        Biblioteca biblioteca;
        Biblioteca biblioteca1;
        try {
            biblioteca = new Biblioteca("Cate", "Bogota", "3993243456", "ctae@gmail.com");
            biblioteca1 = new Biblioteca("Cate", "Bogota", "3993243456", "ctae@gmail.com");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        biblioteca.MostrarHorarioBiblioteca();
        System.out.println(biblioteca);
        System.out.println(biblioteca1);




    }
}
