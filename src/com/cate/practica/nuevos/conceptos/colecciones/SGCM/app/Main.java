package com.cate.practica.nuevos.conceptos.colecciones.SGCM.app;

import com.cate.practica.nuevos.conceptos.colecciones.SGCM.model.*;

public class Main {
    static void main(String[] args) {
        try {
            Estadio estadio = new Estadio("Estadio 1", 30, "Calle 1");
            estadio.organizarSillas();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }


    }
}
