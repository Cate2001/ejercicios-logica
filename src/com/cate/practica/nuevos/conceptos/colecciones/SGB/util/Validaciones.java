package com.cate.practica.nuevos.conceptos.colecciones.SGB.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class Validaciones {

    public static void validarNumeroNagativo(int numero, String campo) {
        if (numero <= 0) {
            throw new IllegalArgumentException(campo + " no puede ser negativo o igual a 0");
        }
    }

    public static void validarNullVacio(String texto, String campo) {
        if (texto == null || texto.trim().isEmpty()) {
            throw new IllegalArgumentException(campo + " no puede ser nulo o vacio");
        }
        if (texto.length() < 3) {
            throw new IllegalArgumentException(campo + " debe contener minimo 3 caracteres");
        }
    }

    public static void validarTelefono(String telefono) {
        validarNullVacio(telefono, "Telefono");
        if (telefono.length() != 10) {
            throw new IllegalArgumentException("El telefono debe tener 10 digitos");
        }
    }

    public static void validarEmail(String email) {
        validarNullVacio(email, "Email");
        if (!email.contains("@")) {
            throw new IllegalArgumentException("El email no es valido");
        }
    }

    public static void validarFechaObjeto(Date fecha) {
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha no puede ser nula");
        }

        try {
            // Convierte Date a String para re-evaluar contra el calendario
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            formato.setLenient(false); // Estricto: no permite 30 de feb, etc.
            formato.format(fecha);

        } catch (Exception e) {
            throw new IllegalArgumentException("La fecha no es valida");
        }
    }

    public static <T> void validarObjetosnNulo(T objeto, String campo) {
        if (objeto == null) {
            throw new IllegalArgumentException(
                    campo + " no puede ser nulo");
        }
    }

}
