package com.cate.ejercicios.basicos.colecciones.cajeroAutomatico;


import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args) {
        double saldo = 1000000;
        double retiro = 50000;
        List billetes = new ArrayList(List.of(10000, 100000, 20000, 200000, 50000, 5000));

        if (saldo <= 0) System.out.println("Sin saldo");
        else if (retiro > saldo) System.out.println("Saldo insuficiente");






    }
}
